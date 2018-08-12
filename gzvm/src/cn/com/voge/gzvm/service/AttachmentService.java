package cn.com.voge.gzvm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.awt.Image; 
import java.awt.image.BufferedImage; 
import java.io.BufferedInputStream;
import java.io.File; 
import java.io.FileInputStream;
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

import javax.imageio.ImageIO; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec; 
import com.sun.image.codec.jpeg.JPEGImageEncoder; 

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import cn.com.voge.system.beans.Version;
import cn.com.voge.actor.service.PermissionService;
import cn.com.voge.actor.dao.InstanceDao;
import cn.com.voge.gzvm.Constant;
import cn.com.voge.gzvm.beans.Attachment;
import cn.com.voge.gzvm.dao.AttachmentDao;
import cn.com.voge.system.dao.VersionDao;

import com.voyageci.core.service.BaseService;
import com.voyageci.tools.utils.ListUtils;
import com.voyageci.tools.utils.NumberUtils;
import com.voyageci.tools.utils.ServletUtils;

@SuppressWarnings({ "unchecked", "rawtypes"/*,"restriction"*/ })
public class AttachmentService  extends BaseService {
	private static final Logger log = Logger.getLogger(AttachmentService.class);
	private AttachmentDao attachmentDao;
	private InstanceDao instanceDao;
	private VersionDao versionDao; 
	//private FileSearchService fileSearchService;
	private String vogeHome;
	private String attachDir = "c:/upload";
	private String courseHttpServerAddr ="";
	private String courseWebServerAddr ="";
	private Integer imageSmallSize = 0x812C;
	private Integer imageWidth = 70;
	private Integer imageHeight = 96;
	private final String vogeExt = "voge.txt";
	
	private PermissionService permissionService ;
	
	public void appDownloadNum(){
		List<Version> versions = versionDao.getAll();
		if(ListUtils.isEmpty(versions)){
			return ;
		}
		Version version = versions.get(0);
		Integer num = version.getCreateUser();
		num ++ ;
		version.setCreateUser(num);
		versionDao.update(version);
		
		return;
	}
	
	public List<Attachment> getOwnerAttaches(int userId,int instanceId,Integer ownerType,Integer ownerId,Integer extType){
		Map criteria = new HashMap();
		criteria.put("ownerType", ownerType);
		if(ownerId != null){
			criteria.put("ownerId", ownerId);
		}
		if((extType != null)&&(extType >0)){
			criteria.put("extType", extType);
		}else{
			criteria.put("nullExtType", true);
		}
		/*if(!permissionService.isSysAdmin(userId)){
			//criteria.put("authoritySQL", permissionService.getAttachDomainStr(userId,instanceId));
		}*/
		return attachmentDao.findBy(criteria);
	}
	
	public Attachment getOwnerAttach(Integer ownerType,Integer ownerId,Integer extType){
		Map criteria = new HashMap();
		criteria.put("ownerType", ownerType);
		criteria.put("ownerId", ownerId);
		if((extType != null)&&(extType >0)){
			criteria.put("extType", extType);
		}else{
			criteria.put("nullExtType", true);
		}
		/*if(!permissionService.isSysAdmin(userId)){
			//criteria.put("authoritySQL", permissionService.getAttachDomainStr(userId,instanceId));
		}*/
		return attachmentDao.firstFindBy(criteria);
	}
	
	public boolean deleteOwnerAttaches(Integer instanceId,Integer ownerType,Integer ownerId){
		String path = getSavePath(instanceId,ownerType,ownerId);
		boolean hasDel = false;
		try {
			File file = new File(path);
			if(file.exists()){
				file.delete();
			}
			hasDel = true;
		} catch (Exception e) {
			hasDel = false;
		}
		return hasDel;
	}
	
	public boolean udpateAttachIndex(int attachId,int dispIndex){
		Attachment attach = attachmentDao.get(attachId);
		if(attach == null){
			return false;
		}
		attach.setDispIndex(dispIndex);
		attachmentDao.update(attach);
		return true;
	}
	
	public Map deleteAttachment (int attachmentId){
		boolean hasDel = true;
		String msg = "删除成功！";
		Attachment attach = attachmentDao.get(attachmentId);
		Map result = new HashMap();
		
		if(attach != null){
			try {
				attachmentDao.remove(attach);
				String path = getSavePath(attach);
				File file = new File(path+"/"+attach.getAttachName());
				if(file.exists()){
					file.delete();
				}
			} catch (Exception e) {
				msg = e.getMessage();
				hasDel = false;
			}
		}else{
			hasDel = false;
			msg = "当前附件已经被删除！";
		}
		result.put("msg", msg);
		result.put("hasDel", hasDel);
		return result;
	}
	
	public boolean saveAttachment(Map attachMap ,File file){
		//检查文件名是否重复,如果重复则覆盖原附件
		int oper = 1;
		Attachment attach = attachmentDao.firstFindBy(attachMap);
		if(attach == null){
			attach = new Attachment();
			oper = 0;
			try {
				BeanUtils.copyProperties(attach, attachMap);
			} catch (Exception e) {
				return false;
			}
		}
		String attachExt = FilenameUtils.getExtension(attach.getAttachName());
		attach.setAttachExt(attachExt);
		attach.setAttachTime(new Date());
		attach.setState(Constant.BASE_STATE);
		String path = getSavePath(attach);
		preparePath(path);
		Integer fileSize = 0;
		try{
			FileOutputStream fos = new FileOutputStream(path + "/"+ attach.getAttachName());
			FileInputStream fis = new FileInputStream(file);
			fileSize = fis.available();
		 	byte[] buffer = new byte[1024];
		 	int len = 0;
		 	while ((len = fis.read(buffer)) > 0) {
		 		fos.write(buffer, 0, len);
		 	}
		 	fos.close();
		 	fis.close();
		 	
		 	//压缩图片
		 	if(attachExt != null){
				String lower = attachExt.toLowerCase();
				if(lower.equals(Constant.IMAGE_EXT_JPG)||lower.equals(Constant.IMAGE_EXT_PNG)||lower.equals(Constant.IMAGE_EXT_GIF)
						||lower.equals(Constant.IMAGE_EXT_JPG_ALL)){
					String fileName = attach.getAttachName();
					fileName = fileName.substring(0, fileName.lastIndexOf("."));
					this.compressImage(file, fileSize, path, fileName, "s", attachExt);
				}
		 	}
		}catch (Exception e){
			String msg = e.getMessage();
			log.debug(msg);
		}
		attach.setAttachPath(path);
		attach.setFileSize(fileSize);
		attach.setAttachTime(new Date());
		if(oper == 0){
			attachmentDao.insert(attach);
		}else{
			attachmentDao.update(attach);
		}
		
		return true;
	}
	
	public Attachment saveAttachment(Map attachMap ,byte[] bytes){
		//检查文件名是否重复,如果重复则覆盖原附件
		int oper = 1;
		Attachment attach = attachmentDao.firstFindBy(attachMap);
		if(attach == null){
			attach = new Attachment();
			oper = 0;
			try {
				BeanUtils.copyProperties(attach, attachMap);
			} catch (Exception e) {
				return null;
			}
		}
		String attachName = attach.getAttachName() ;
		String attachExt = FilenameUtils.getExtension(attach.getAttachName());
		attach.setAttachExt(attachExt);
		String path = getSavePath(attach);
		preparePath(path);
		Integer fileSize = bytes.length;
		
		try{
			//保存原图为大图，名称后面+l
			String fileName = attachName.substring(0, attachName.lastIndexOf("."))+"l."+attachExt;
			FileOutputStream fos = new FileOutputStream(path + "\\"+ fileName);
			fos.write(bytes, 0, fileSize);
		 	fos.close();
		 	
		 	//压缩图片
		 	if(attachExt != null){
				String lower = attachExt.toLowerCase();
				if(lower.equals(Constant.IMAGE_EXT_JPG)||lower.equals(Constant.IMAGE_EXT_PNG)||lower.equals(Constant.IMAGE_EXT_GIF)
						||lower.equals(Constant.IMAGE_EXT_JPG_ALL)){
					//fileName = attach.getAttachName();
					fileName = fileName.substring(0, fileName.lastIndexOf(".")-1);
					this.compressImage(bytes, fileSize, path, fileName, "s", attachExt);
				}
		 	}
		}catch (Exception e){
			String msg = e.getMessage();
			log.debug(msg);
		}
		attach.setAttachPath(path);
		attach.setFileSize(fileSize);
		if(oper == 0){
			attachmentDao.insert(attach);
		}else{
			attachmentDao.update(attach);
		}
		
		return attachmentDao.get(attach.getAttachId());
	}
	
	public Integer saveFile(File file,String savePath,String fileName){
		
		Integer fileSize = 0;
		preparePath(savePath);
		try{
			FileOutputStream fos = new FileOutputStream(savePath + "/"+ fileName);
			FileInputStream fis = new FileInputStream(file);
		 	byte[] buffer = new byte[1024];
		 	fileSize = fis.available();
		 	int len = 0;
		 	while ((len = fis.read(buffer)) > 0) {
		 		fos.write(buffer, 0, len);
		 	}
		 	fos.close();
		 	fis.close();
		}catch (Exception e){
			String msg = e.getMessage();
			log.info(msg);
			return 0;
		}
		return fileSize;
	}
	
	public Integer saveFile(byte[] bytes,String savePath,String fileName,String type,String extName){
		if(type == null){
			type = "l";//
		}
		type = type.toLowerCase();
		/*Integer fileSize = bytes.length;
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(savePath + "/"+ fileName+type+"."+extName);
			fos.write(bytes, 0, bytes.length);
		 	fos.close();
		}catch (Exception e){
			String msg = e.getMessage();
			log.info(msg);
			if(fos != null){
				try{
					fos.close();
				}catch(Exception ex){
					
				}
			}
			return 0;
		}*/
		
		return compressImageEx(bytes,bytes.length,savePath,fileName,type,extName);
	}
	
	public Integer saveFile(byte[] bytes,String savePath,String fileName,String extName){
		return compressImageEx(bytes,bytes.length,savePath,fileName,"",extName);
	}
	
	public Integer compressImage (byte[] bytes,Integer fileSize,String savePath,String fileName,String type,String extName){
		/*Double rate = getCompressRate(fileSize);
		rate = Math.sqrt(rate);
		if(rate <= 1){
			return saveFile(bytes,savePath,fileName,"s",extName);
		}*/
		try{
			
			Image img = ImageIO.read( new ByteArrayInputStream(bytes)  ); 
			if (img.getWidth(null) == -1) { 
				return 0; 
			}
			int newWidth; int newHeight; 
			// 为等比缩放计算输出的图片宽度及高度 
			double oldWidth = img.getWidth(null);
			double oldHeight = img.getHeight(null);
			
			newWidth = (oldWidth>oldHeight)?imageHeight:imageWidth;//NumberUtils.toIntValue(((double) img.getWidth(null)) / rate); 
			newHeight = (oldHeight>oldWidth)?imageHeight:imageWidth;//NumberUtils.toIntValue(((double) img.getHeight(null)) / rate); 
			BufferedImage tag = new BufferedImage(newWidth,newHeight, BufferedImage.TYPE_INT_RGB);
			String fileAllName = fileName+type+"."+extName;
			/* 
			* Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 
			* 优先级比速度高 生成的图片质量比较好 但速度慢 
			*/ 
			tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
			
			FileOutputStream out = new FileOutputStream(savePath +"/"+ fileAllName); 
			try{
				// JPEGImageEncoder可适用于其他图片类型的转换 
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
				encoder.encode(tag); 
				out.close(); 
			}catch (Exception e){
				out.close(); 
			}
			
			
		} catch (IOException ex){
			return 0;
		}
		
		return fileSize;
	}
	
	public Integer compressImageEx (byte[] bytes,Integer fileSize,String savePath,String fileName,String type,String extName){
		/*Double rate = getCompressRate(fileSize);
		rate = Math.sqrt(rate);
		if(rate <= 1){
			return saveFile(bytes,savePath,fileName,"s",extName);
		}*/
		try{
			
			Image img = ImageIO.read( new ByteArrayInputStream(bytes)  ); 
			if (img.getWidth(null) == -1) { 
				return 0; 
			}
			// 为等比缩放计算输出的图片宽度及高度 
			int oldWidth = NumberUtils.toIntValue(img.getWidth(null));
			int oldHeight = NumberUtils.toIntValue(img.getHeight(null));
			
			BufferedImage tag = new BufferedImage(oldWidth,oldHeight, BufferedImage.TYPE_INT_RGB);
			String fileAllName = fileName+type+"."+extName;
			/* 
			* Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 
			* 优先级比速度高 生成的图片质量比较好 但速度慢 
			*/ 
			tag.getGraphics().drawImage(img.getScaledInstance(oldWidth, oldHeight, Image.SCALE_SMOOTH), 0, 0, null); 
			FileOutputStream out = new FileOutputStream(savePath +"/"+ fileAllName); 
			try{
			// JPEGImageEncoder可适用于其他图片类型的转换 
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
			encoder.encode(tag); 
			out.close(); 
			}catch(Exception e){
				out.close();
			}
		} catch (IOException ex){
			return 0;
		}
		
		return fileSize;
	}
	
	public Integer compressImage (File file,Integer fileSize,String savePath,String fileName,String type,String extName){
		//Double rate = getCompressRate(fileSize);
		/*if(rate < 1){
			return saveFile(file,savePath,fileName,"s",extName);
		}*/
		try{
			Image img = ImageIO.read(file); 
			if (img.getWidth(null) == -1) { 
				return 0; 
			}
			int newWidth; int newHeight; 
			// 为等比缩放计算输出的图片宽度及高度 
			// 为等比缩放计算输出的图片宽度及高度 
			double oldWidth = img.getWidth(null);
			double oldHeight = img.getHeight(null);
			
			newWidth = (oldWidth>oldHeight)?imageHeight:imageWidth;//NumberUtils.toIntValue(((double) img.getWidth(null)) / rate); 
			newHeight = (oldHeight>oldWidth)?imageHeight:imageWidth;//NumberUtils.toIntValue(((double) img.getHeight(null)) / rate); 
						
			BufferedImage tag = new BufferedImage(newWidth,newHeight, BufferedImage.TYPE_INT_RGB);
			String fileAllName = fileName+type+"."+extName;
			/* 
			* Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 
			* 优先级比速度高 生成的图片质量比较好 但速度慢 
			*/ 
			tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null); 
			FileOutputStream out = new FileOutputStream(savePath +"/"+ fileAllName); 
			try{
				// JPEGImageEncoder可适用于其他图片类型的转换 
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
				encoder.encode(tag); 
				out.close(); 
			}catch (Exception e){
				out.close();
			}
			
		} catch (IOException ex){
			return 0;
		}
		
		return NumberUtils.toIntValue(file.length());
	}
	
	public Double getCompressRate(Integer fileSize){
		return (NumberUtils.toDoubleValue(fileSize)/imageSmallSize);
	}
	
	public boolean showPic(String fileName,HttpServletResponse response,HttpServletRequest request){
		try{
			File file= new File(fileName);
			if(!file.exists()){
				return false;
			}
			OutputStream out = response.getOutputStream();
			int index = fileName.lastIndexOf("/");
			String name = fileName.substring(index+1);
			String fn = ServletUtils.encodeFileName(request, name);
			response.setHeader("Content-Disposition", "inline;filename=\"" + fn + "\"");
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			byte[] data = new byte[4096];  
	        int count = -1;  
	        try{
		        while((count = bis.read(data)) != -1)  
		        	out.write(data, 0, count);
		        out.flush();
		        out.close();
			 	bis.close();
	        }catch(Exception e){
	        	out.flush();
		        out.close();
			 	bis.close();
			 	return false;
	        }
			
		}catch (Exception e){
			String msg = e.getMessage();
			log.debug(msg);
			return false;
		}
		return true;
	}
	
	public boolean showPic(String[]fileNames,HttpServletResponse response,HttpServletRequest request){
		
		return true;
	}
	

	public String getSavePath(Attachment attach){
		Integer ownerType = attach.getOwnerType();
		Integer ownerId = attach.getOwnerId();
		Integer instanceId = attach.getInstanceId();
		return getSavePath(instanceId,ownerType,ownerId);
	}
	
	public String getSavePath(Integer ownerType,Integer ownerId){
		String path = attachDir+"/"; 
		if(ownerType == Constant.TYPE_MODULE_ITEM_CONTENT){
			path += ("itemcontent/" + ownerId.toString());
			return path;
		}
		return (path += ownerId.toString());
	}
	
	public String getSavePath(Integer instanceId,Integer ownerType,Integer ownerId){
		
		String path = attachDir+"/"; 
		
		if(ownerType == Constant.TYPE_MODULE_ITEM_CONTENT){
			path += ("itemcontent/" + ownerId.toString());
			return path;
		}/*else if(ownerType == Constant.TYPE_SCENE){
			path += ("scheme/" + ownerId.toString()+"/"+(Constant.SCHEME_THEME_SCENE+""));
			return path;
		}else if(ownerType == Constant.TYPE_GUIDE){
			path += ("scheme/" + ownerId.toString()+"/"+(Constant.SCHEME_THEME_GUIDE+""));
			return path;
		}else if(ownerType == Constant.TYPE_CHANNEL){
			path += "channel/";
		}else if(ownerType == Constant.TYPE_STAFF){
			path += "staff/";
		}else if(ownerType == Constant.TYPE_GUIDE){
			path += "guide/";
		}else if(ownerType == Constant.TYPE_SCHEME){
			path += "scheme/";
		}else if(ownerType == Constant.TYPE_ATTACH){
			path += "attach/";
		}else if(ownerType == Constant.TYPE_RM_FILE){
			path += "rmfile/";
		}else if(ownerType == Constant.TYPE_TASK){
			path += "task/";
		}else if(ownerType == Constant.TYPE_RM_SCENE){
			path += "rmscene/";
		}else if(ownerType == Constant.TYPE_RM_SCENE_CAT){
			path += "rmsceneCat/";
		}else if(ownerType == Constant.TYPE_NOTICE){
			path += "notice/";
		}else if(ownerType == Constant.TYPE_TRAINPLAN){
			path += "halltrain/";
		}else if(ownerType == Constant.TYPE_TRAINPLAN_ORG){
			path += "orgtrain/";
		}else if(ownerType == Constant.TYPE_COURSE){
			path += "course/";
		}else if(ownerType == Constant.TYPE_COURSE_CLASSIFY){
			path += "courseclassify/";
		}else if(ownerType == Constant.TYPE_INSPECTION){
			path += "inspection/";
		}else if(ownerType == Constant.TYPE_SALE_SKILL){
			path += "saleskill/";
		}else if(ownerType == Constant.TYPE_EXAM_CLASSIFY){
			path += "examclassify/";
		}else if(ownerType == Constant.TYPE_RM_DIALOG){
			path += "dialog/";
		}*/
		
		return (path += ownerId.toString());
	}
	
	public String getSavePath(Integer instanceId,Integer ownerType,Integer ownerId,String extFolder){
		String path = getSavePath(instanceId,ownerType,ownerId);
		if((extFolder !=null)&&(extFolder.trim().length()>0)){
				return path+"/"+extFolder;
		}
		return path;
	}
	
	public void deleteLSImages(Integer ownerType,Integer ownerId,List<Integer> imageIds){
		deleteLSImages(ownerType, ownerId, imageIds, null);
	}
	
	public void deleteLSImages(Integer ownerType,Integer ownerId,List<Integer> imageIds,String extFolder){
		if (ListUtils.isNotEmpty(imageIds)) {
			String path = getSavePath(ownerType, ownerId);
			for (Integer imageId : imageIds) {
				deleteLSImage(path, imageId,extFolder);
			}
		}
	}
	
	public void deleteLSImage(String path,Integer imageId){
		deleteLSImage(path, imageId,null);
	}
	
	public void deleteLSImage(String path,Integer imageId,String extFolder){
		if (path == null || imageId == null) {
			return;
		}
		if (extFolder == null) {
			extFolder = Constant.IMAGE_EXT_JPG;
		}
		try{
			File file = new File(path+"/"+imageId.toString() + "l."+extFolder);
			if(file.exists()){
				file.delete();
			}
			File fileS = new File(path+"/"+imageId.toString() + "s."+extFolder);
			if(fileS.exists()){
				fileS.delete();
			}
		} catch (Exception e) {
			
		}
	}
	
	public String getIndexPath(int objectType){
		String path = vogeHome+"\\"+attachDir+"\\"; 
		//return path+"index";
		/*if(objectType == Constant.TYPE_CHANNEL){
			path += "channel";
		}else if(objectType == Constant.TYPE_STAFF){
			path += "staff";
		}*/
		return path;
	}
	
	/**
	 * 准备文件存储路径，如果目录不存在则创建
	 * @param path
	 */
	public boolean preparePath(String path){
		if(!path.endsWith(File.separator))
		     path = path + File.separator;
		
		File dir = new File(path);
	    if(dir.exists()) {
	     System.out.println("创建目录" + path + "失败，目标目录已存在！");
	     return false;
	    }
	   
	    // 创建单个目录
	    if(dir.mkdirs()) {
	     System.out.println("创建目录" + path + "成功！");
	     return true;
	    } else {
	     System.out.println("创建目录" + path + "失败！");
	     return false;
	    }
	}
	
	public void createTextFile(int objectType,int objectId,String title,String content){
		/*String path = getSavePath(objectType,objectId);
		preparePath(path);
		String fileName = title+ "."+vogeExt;
		String filePath = path + "/"+ fileName;
		
		try{
			FileWriter writer = new FileWriter(filePath, true); 
			writer.write(content); 
			writer.close(); 
			//将文件添加到索引中
			//String indexPath = getIndexPath(objectType);
			//fileSearchService.createFileIndex(indexPath, filePath, title,objectId);
		}catch (Exception e){
			String msg = e.getMessage();
			log.debug(msg);
		}*/
	}
	
	public String fileToTxt(File f) {  
		return null;//fileSearchService.fileToTxt(f);
	}
	
	public void fileChannelCopy(File s, File t) {

        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        
        try {

            fi = new FileInputStream(s);
            fo = new FileOutputStream(t);
            in = fi.getChannel();//得到对应的文件通道
            out = fo.getChannel();//得到对应的文件通道
            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
		        try {
		        	if(fi != null){
		        		fi.close();
		        	}
		            if(in != null){
		            	in.close();
		            }
		            if(fo != null){
		            	fo.close();
		            }
		            if(out != null){
		            	out.close();
		            }
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

        }

    }
	
	public AttachmentDao getAttachmentDao() {
		return attachmentDao;
	}

	public void setAttachmentDao(AttachmentDao attachmentDao) {
		this.attachmentDao = attachmentDao;
	}

	public String getVogeHome() {
		return vogeHome;
	}

	public void setVogeHome(String vogeHome) {
		this.vogeHome = vogeHome;
	}

	public String getAttachDir() {
		return attachDir;
	}

	public void setAttachDir(String attachDir) {
		this.attachDir = attachDir;
	}

	public PermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public Integer getImageSmallSize() {
		return imageSmallSize;
	}

	public void setImageSmallSize(Integer imageSmallSize) {
		if((imageSmallSize == null)||(imageSmallSize<1024)){
			imageSmallSize = Constant.SMALL_IMAGE_SIZE;
		}
		this.imageSmallSize = imageSmallSize;
	}

	public String getVogeExt() {
		return vogeExt;
	}

	public Integer getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(Integer imageWidth) {
		this.imageWidth = imageWidth;
	}

	public Integer getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(Integer imageHeight) {
		this.imageHeight = imageHeight;
	}

	public InstanceDao getInstanceDao() {
		return instanceDao;
	}

	public void setInstanceDao(InstanceDao instanceDao) {
		this.instanceDao = instanceDao;
	}

	public VersionDao getVersionDao() {
		return versionDao;
	}

	public void setVersionDao(VersionDao versionDao) {
		this.versionDao = versionDao;
	}

	public String getCourseHttpServerAddr() {
		return courseHttpServerAddr;
	}

	public void setCourseHttpServerAddr(String courseHttpServerAddr) {
		this.courseHttpServerAddr = courseHttpServerAddr;
	}

	public String getCourseWebServerAddr() {
		return courseWebServerAddr;
	}

	public void setCourseWebServerAddr(String courseWebServerAddr) {
		this.courseWebServerAddr = courseWebServerAddr;
	}
	
}