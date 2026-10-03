package net.ibizsys.pswx.api;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

/**
 * 微信API基类
 * <p>
 * 本API中的get、post、upload、download 默认采用java.net.URLConnection实现，如遇到性能等问题请重写
 * 
 * @author Enmaai
 */
public abstract class WXBaseApi {

	public static final String GET = "GET";

	public static final String POST = "POST";

	/**
	 * POST请求
	 * 
	 * @param url 地址
	 * @param params 参数
	 * @return
	 */
	public static JSONObject http_post(String url, JSONObject params) throws Exception {
		if (params != null) {
			return http_post(url, params.toString());
		}
		return http_post(url, "");
	}

	/**
	 * POST请求
	 * 
	 * @param url 地址
	 * @param bodyParams 参数
	 * @return
	 */
	public static JSONObject http_post(String url, String bodyParams) throws Exception {
		PrintWriter out = null;
		InputStream in = null;
		String result = "";

		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),StandardCharsets.UTF_8));  
			out.print(bodyParams);
			out.flush();

			in = conn.getInputStream();
			result = parseStream(in);
		} catch (Exception e) {
			throw new Exception("网络请求异常");
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return JSONObject.fromString(result);
	}

	/**
	 * GET请求
	 * 
	 * @param url 地址
	 * @param params 参数
	 * @return
	 */
	public static JSONObject http_get(String url, Map<String, String> params) throws Exception {
		String result = "";
		InputStream in = null;
		try {
			String strUrl = parseUrl(url, params);

			URL realUrl = new URL(strUrl);
			URLConnection conn = realUrl.openConnection();

			conn.setUseCaches(false);
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			conn.connect();
			in = conn.getInputStream();
			result = parseStream(in);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("网络请求异常");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return JSONObject.fromString(result);
	}

	/**
	 * 上传文件
	 * 
	 * @param url 地址
	 * @param file 文件
	 * @return
	 */
	public static JSONObject upload(String url, File file) throws Exception {
		String end = "\r\n";
		String twoHyphens = "--";
		String boundary = "*****";
		FileInputStream fileInputStream = null;
		DataOutputStream outputStream = null;
		String result = null;

		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			HttpURLConnection httpURLConnection = (HttpURLConnection) conn;
			httpURLConnection.setDoInput(true);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
			httpURLConnection.setRequestProperty("Charset", "UTF-8");
			httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			outputStream = new DataOutputStream(httpURLConnection.getOutputStream());

			String filename = file.getName();
			outputStream.writeBytes(twoHyphens + boundary + end);
			outputStream.writeBytes("Content-Disposition: form-data;filename=\"" + filename + "\"" + end);
			outputStream.writeBytes(end);

			fileInputStream = new FileInputStream(file);
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			int length = -1;
			while ((length = fileInputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, length);
			}
			outputStream.writeBytes(end);
			outputStream.writeBytes(twoHyphens + boundary + twoHyphens + end);
			outputStream.flush();

			result = parseStream(conn.getInputStream());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				fileInputStream.close();
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return JSONObject.fromString(result);
	}

	/**
	 * 下载文件
	 * 
	 * @param url 地址
	 * @param params 参数
	 * @param saveFile 保存文件
	 * @return
	 */
	public static boolean download(String url, Map<String, String> params, File saveFile) throws Exception {
		InputStream in = null;
		FileOutputStream fos = null;
		try {
			String strUrl = parseUrl(url, params);
			URL realUrl = new URL(strUrl);
			URLConnection conn = realUrl.openConnection();

			conn.connect();
			in = conn.getInputStream();

			fos = new FileOutputStream(saveFile);

			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = in.read(buf)) > 0) {
				fos.write(buf, 0, bytesRead);
			}
			fos.flush();
			return true;
		} catch (Exception e) {
			throw new Exception("网络请求异常");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
	}

	public static String parseUrl(String url, Map<String, String> params) throws UnsupportedEncodingException {
		String param = parseParam(params);

		if (StringHelper.isNullOrEmpty(param)) {
			return url;
		}
		if (url.indexOf("?") != -1) {
			return url + "&" + param;
		} else {
			return url + "?" + param;
		}
	}

	public static String parseParam(Map<String, String> params) throws UnsupportedEncodingException {
		String param = "";
		if (params == null || params.size() == 0) {
			return param;
		}
		for (String key : params.keySet()) {
			String value = params.get(key);
			if (!StringHelper.isNullOrEmpty(value)) {
				param += "&" + key + "=" + params.get(key);
			}
		}
		if (param.length() > 0) {
			return param.substring(1);
		}
		return param;
	}

	public static String parseStream(InputStream input) throws IOException {
		final InputStreamReader in = new InputStreamReader(input, StandardCharsets.UTF_8);
		StringBuilder builder = new StringBuilder();
		char[] buffer = new char[4096];
		int n;
		while (-1 != (n = in.read(buffer))) {
			if (buffer != null) {
				builder.append(buffer, 0, n);
			}
		}
		return builder.toString();
	}

	public static CallResult get(String url, Map<String, String> params) {
		CallResult callResult = null;
		try {
			JSONObject json = http_get(url, params);
			callResult = createResult(json);
		} catch (Exception ex) {
			ex.printStackTrace();
			callResult = new CallResult();
			callResult.setRetCode(-1);
			callResult.setErrorInfo(ex.getMessage());
		}

		return callResult;
	}

	public static CallResult post(String url, JSONObject params) {
		if (params != null) {
			return post(url, params.toString());
		}
		return post(url, "");
	}

	public static CallResult post(String url, Map<String, String> params) {
		try {
			return post(url, parseParam(params));
		} catch (Exception ex) {
			CallResult callResult = new CallResult();
			callResult.setRetCode(Errors.INPUTERROR);
			callResult.setErrorInfo("准备参数异常");
			return callResult;
		}

	}

	public static CallResult post(String url, String params) {
		CallResult callResult = null;
		try {
			JSONObject json = http_post(url, params);
			callResult = createResult(json);
		} catch (Exception ex) {
			ex.printStackTrace();
			callResult = new CallResult();
			callResult.setRetCode(-1);
			callResult.setErrorInfo(ex.getMessage());
		}

		return callResult;
	}

	protected static CallResult createResult(JSONObject json) {
		CallResult callResult = new CallResult();

		if (json.has("errcode")) {
			callResult.setRetCode(json.getInt("errcode"));
		}
		if (json.has("errmsg")) {
			callResult.setErrorInfo(json.getString("errmsg"));
		}

		callResult.setUserObject(json);

		return callResult;
	}
}
