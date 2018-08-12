package cn.com.voge.gzvm;

/**
 * @author lianzw
 *
 */
/**
 * @author lianzw
 *
 */
public final class Constant {

	public static Integer BASE_STATE = 1;
	public static Integer BASE_STATE_PUBLISH = 2;
//	public static Integer BASE_STATE_EFF = 1;
	public static Integer OPER_INSTER = 0;
	public static Integer OPER_UPDATE = 1;
	public static Integer RESULT_CODE_ERROR = 0;
	public static Integer RESULT_CODE_SUCCESS = 1;
	
	public static Integer ROWS_START = 0;
	public static Integer ROWS_PAGE = 15;
	public static Integer ROWS_MAX = 30;
	
	public static Integer PHOTO_TYPE_COVER = 10;
	public static Integer PHOTO_TYPE_CONTENT = 20;
	
	public static int TYPE_MODULE_ITEM_CONTENT = 0x100;// 模块项内容
	
	public static String ADMIN_TYPE_HIGHES = "highes_admin";
	public static String ADMIN_TYPE_COMMON = "common_admin";
	
	public static String USER_PHOTO = "user_photo";
	
	public static Integer USER_ID_TYPE_IDCARD= 1;
	public static Integer USER_ID_TYPE_HONGKONG = 2;
	
	public static int SMALL_IMAGE_SIZE = 0x812C;
	
	
	public static String IMAGE_EXT_JPG = "jpg";
	public static String IMAGE_EXT_JPG_ALL = "jpeg";
	public static String IMAGE_EXT_PNG = "png";
	public static String IMAGE_EXT_GIF = "gif";
	public static String VIDEO_EXT_MP4 = "mp4";
	
	/**-----------**/
	public static String COMPETITION_LEVEL_SERIES = "系列赛";
	public static String COMPETITION_LEVEL_OPEN = "公开赛";
	public static String COMPETITION_LEVEL_CHALLENGE = "挑战赛";
	public static String COMPETITION_LEVEL_ELITE = "精英赛";
	public static String COMPETITION_LEVEL_GRAND_SLAM  = "大满贯";
	
	public static Integer JOIN_TYPE_DIRECTLY = 10; //直接报名
	public static Integer JOIN_TYPE_NO_DIRECTLY = 20;  // 预报名
	
	public static Integer GROUP_TYPE_PERSONAL = 1;  // 个人赛
	public static Integer GROUP_TYPE_GROUP  = 2;  // 团体赛
	public static Integer GROUP_TYPE_ALL  = 3;  // 个人+团体赛
	
//	/**  ΢��֧��     **/
//	public static String WX_APP_ID = "wx2cee035d0fd25149"; //΢��appId
//	public static String WX_APP_SECRET = "e27f24da653070a85d5bdbc3a9a92ecb"; //΢��app�ܳ�
//	public static String WX_APP_KEY = "NbXLeMrAiKRxItrMOL1wCi8czobsfKTV"; // ΢��api�ܳ�
//	public static String WX_MCH_ID = "1362881902"; // �̻�id
	
	/**  ΢��֧��     **/
	public static String WX_APP_ID = "wxe1f1a5472102dd15"; //开发者ID
	public static String WX_APP_SECRET = "770d06efba3a2e1c863abd0764dd82d0"; //钥匙
	public static String WX_APP_KEY = "2016wuhuantiyuverticalmarathon11"; // 商户钥匙
	public static String WX_MCH_ID = "1233897302"; // 商户号
	
	public static String WX_UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder"; //΢��ͳһ�µ�url
	
	public static String WX_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&";
	public static String WX_JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi&access_token=";
	public static String WX_CODE_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code&";
	public static String WX_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?lang=zh_CN&access_token=";
	public static String WX_QR_CODE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=";
	
	public static String WX_QR_CALLBACK_URL = "http://dzs.gzmtr.cn/wxapp/modules/transfer.php?";
	
	public static String WX_SUCCESS_CODE = "SUCCESS"; // �ɹ�����
	public static String WX_FAIL_CODE = "FAIL"; // ʧ�ܴ���
	
	public static String WX_TOKEN_TYPE_API_TOKEN = "WEIXIN_API_ACCESS_TOKEN";
	public static String WX_TOKEN_TYPE_JSAPI_TICKET = "WEIXIN_JSAPI_TICKET";
	
	public static String TRADE_SUCCESS = "SUCCESS";
	public static String TRADE_REFUND = "REFUND";
	public static String TRADE_NOTPAY = "NOTPAY";
	public static String TRADE_CLOSED = "CLOSED";
	public static String TRADE_REVOKED = "REVOKED";
	public static String TRADE_USERPAYING = "USERPAYING";
	public static String TRADE_PAYERROR = "PAYERROR";
	
	/**
	 * ��ȨUrl AccessToken
	 * @return
	 */
	public static String getCodeAccessTokenUrl(){
		return WX_CODE_ACCESS_TOKEN_URL + getAppIdAndSecret() + "&code=";
	}
	
	public static String getAppIdAndSecret(){
		return "appid=" + WX_APP_ID + "&secret=" + WX_APP_SECRET;
	}
}
