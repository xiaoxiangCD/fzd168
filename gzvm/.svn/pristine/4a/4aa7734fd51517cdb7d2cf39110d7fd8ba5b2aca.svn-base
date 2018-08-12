package cn.com.voge.gzvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.security.DigestException;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;   
import org.w3c.dom.Element;   
import org.w3c.dom.Node;   
import org.w3c.dom.NodeList;   
import org.xml.sax.InputSource; 
import org.dom4j.DocumentException;

@SuppressWarnings({"rawtypes","unchecked"})
public final class CommonUtil {
	
	private static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;
	/**
	 * 随机字符串?
	 * 
	 * @return
	 */
	public static String create_uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 生成随机字符串?
	 * 
	 * @param length
	 * @return
	 */
	public static String create_nonce_str(int length) {
		String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	// ascll 排序
	public static String ascllSort(Map param) {
		List<String> keys = new ArrayList<String>();
		for (Object string : param.keySet().toArray()) {
			keys.add((String) string);
		}
		Collections.sort(keys);
		String stringA = "";
		for (String i : keys) {
			stringA += '&' + i + '=' + param.get(i);
		}
		return stringA.substring(1);
	}

	/**
	 * 微信支付签名算法sign
	 * 
	 * @param characterEncoding
	 * @param parameters
	 * @return
	 */
	public static String createSign(String characterEncoding,
			SortedMap parameters,String key) {
		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();// �?��参与传参的参数按照accsii排序（升序）
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k)
					&& !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		String sign = null;
		if(characterEncoding.equals("SHA-1")){
			try {
				String sbStr = sb.toString().substring(0, sb.toString().length()-1);
				sign = SHA1(sbStr);
			} catch (DigestException e) {
				System.out.println("sha1 签名失败:"+e.getMessage());
			}
		}else{
			sb.append("key=" + key);
			sign = MD5Encode(sb.toString(), characterEncoding).toUpperCase();
		}
		
		return sign;
	}
	/** 
     * SHA1 安全加密算法 
     * @param maps 参数key-value map集合 
     * @return 
     * @throws DigestException  
     */  
    public static String SHA1(String decrypt) throws DigestException {  
        //获取信息摘要 - 参数字典排序后字符串  
        try {  
            //指定sha1算法  
            MessageDigest digest = MessageDigest.getInstance("SHA-1");  
            digest.update(decrypt.getBytes());  
            //获取字节数组  
            byte messageDigest[] = digest.digest();  
            // Create Hex String  
            StringBuffer hexString = new StringBuffer();  
            // 字节数组转换�?十六进制 �? 
            for (int i = 0; i < messageDigest.length; i++) {  
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);  
                if (shaHex.length() < 2) {  
                    hexString.append(0);  
                }  
                hexString.append(shaHex);  
            }  
            return hexString.toString().toUpperCase();  
  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
            throw new DigestException("签名错误");  
        }  
    } 
    
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
	/**
	 * 将map转换为xml字符�?
	 * @param map
	 * @return
	 */
	public static String getXmlWithMap(Map map) {
		String xmlStr = "";
		Set es = map.entrySet();// �?��参与传参的参数按照accsii排序（升序）
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v)) {
				xmlStr += "<" + k + "><![CDATA[";
				xmlStr += v;
				xmlStr += "]]></" + k + ">";
			}
		}
		return "<xml>" + xmlStr + "</xml>";
	}
	
	/** 
	* 解析XML字符�?
	*  
	* @param xml 
	* @return 
	* @throws DocumentException 
	*/  
	public static Map parseXML(String protocolXML) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(
					protocolXML)));

			Element root = doc.getDocumentElement();
			NodeList books = root.getChildNodes();
			if (books != null) {
				Map map = new HashMap();
				for (int i = 0; i < books.getLength(); i++) {
					Node book = books.item(i);
					map.put(book.getNodeName(), book.getFirstChild().getNodeValue());
				}
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 中国正常坐标系GCJ02协议的坐标，转到 百度地图对应�?BD09 协议坐标
	 * @param lat
	 * @param lng
	 * @return
	 */
	public static Map Convert_GCJ02_To_BD09(double lat,double lng) {
		double x = lng, y = lat;
		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
		lng = z * Math.cos(theta) + 0.0065;
		lat = z * Math.sin(theta) + 0.006;
		Map map = new HashMap();
		map.put("lng", lng);
		map.put("lat", lat);
		return map;
	}
	
	/**
	 * 百度地图对应�?BD09 协议坐标，转�?中国正常坐标系GCJ02协议的坐�?
	 * @param lat
	 * @param lng
	 * @return
	 */
	public static Map Convert_BD09_To_GCJ02(double lat, double lng) {
		double x = lng - 0.0065, y = lat - 0.006;
		double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
		lng = z * Math.cos(theta);
		lat = z * Math.sin(theta);
		Map map = new HashMap();
		map.put("lng", lng);
		map.put("lat", lat);
		return map;
	}
	
	/**
	 * 两点的距�?
	 * @param long1	 经度1
	 * @param lat1	 维度1
	 * @param long2	经度2
	 * @param lat2	维度2
	 * @return
	 */
	public static double distance(double long1, double lat1, double long2, double lat2) {  
	    double a, b, R;  
	    R = 6378137; // �����? 
	    lat1 = lat1 * Math.PI / 180.0;  
	    lat2 = lat2 * Math.PI / 180.0;  
	    a = lat1 - lat2;  
	    b = (long1 - long2) * Math.PI / 180.0;  
	    double d;  
	    double sa2, sb2;  
	    sa2 = Math.sin(a / 2.0);  
	    sb2 = Math.sin(b / 2.0);  
	    d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)  
	                    * Math.cos(lat2) * sb2 * sb2));  
	    return d;  
	}
	
	public static String parseInputStream(InputStream inputStream)
			throws NoSuchAlgorithmException, NoSuchProviderException,
			KeyManagementException, MalformedURLException, IOException,
			ProtocolException, UnsupportedEncodingException {
		InputStreamReader inputStreamReader = new InputStreamReader(
				inputStream, "utf-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String str = null;
		StringBuffer buffer = new StringBuffer();
		while ((str = bufferedReader.readLine()) != null) {
			buffer.append(str);
		}
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
		inputStream = null;
		return buffer.toString();
	}
}
