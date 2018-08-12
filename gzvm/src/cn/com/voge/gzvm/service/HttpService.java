package cn.com.voge.gzvm.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import cn.com.voge.gzvm.CommonUtil;

import com.voyageci.core.service.BaseService;
import com.voyageci.tools.json.JSON;

@SuppressWarnings("rawtypes")
public class HttpService extends BaseService {

	public static Map httpsRequestToXML(String requestUrl, String requestMethod, String outputStr) {
		Map result = null;
		try {
			String str = httpsRequest(requestUrl, requestMethod, outputStr);
			result = CommonUtil.parseXML(str);
		} catch (ConnectException ce) {
			System.out.println("���ӳ�ʱ��" + ce.getMessage());
		} catch (Exception e) {
			System.out.println("https�����쳣��" + e.getMessage());
		}
		return result;
	}

	public static Map httpsRequestToJSON(String requestUrl, String requestMethod, String outputStr) {
		Map result = null;
		try {
			String str = httpsRequest(requestUrl, requestMethod, outputStr);
			result = JSON.parseToMap(str);
		} catch (ConnectException ce) {
			System.out.println("���ӳ�ʱ��" + ce.getMessage());
		} catch (Exception e) {
			System.out.println("https�����쳣��" + e.getMessage());
		}
		return result;
	}

	public static String httpsRequest(String requestUrl, String requestMethod, String output)
			throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException, MalformedURLException,
			IOException, ProtocolException, UnsupportedEncodingException {
		URL url = new URL(requestUrl);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setUseCaches(false);
		connection.setRequestMethod(requestMethod);
		if (null != output) {
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(output.getBytes("UTF-8"));
			outputStream.close();
		}
		// ����������ȡ��������
		InputStream inputStream = connection.getInputStream();
		String map = parseInputStream(inputStream);
		connection.disconnect();
		return map;
	}

	public static String parseInputStream(InputStream inputStream)
			throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException, MalformedURLException,
			IOException, ProtocolException, UnsupportedEncodingException {
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
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
