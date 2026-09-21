/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.api;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
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
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

public abstract class WXBaseApi {
    public static final String GET = "GET";
    public static final String POST = "POST";

    public static JSONObject http_post(String url, JSONObject params) throws Exception {
        if (params != null) {
            return WXBaseApi.http_post(url, params.toString());
        }
        return WXBaseApi.http_post(url, "");
    }

    public static JSONObject http_post(String url, String bodyParams) throws Exception {
        PrintWriter out = null;
        InputStream in = null;
        String result = "";
        try {
            try {
                URL realUrl = new URL(url);
                URLConnection conn = realUrl.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setUseCaches(false);
                conn.setRequestProperty("Accept-Charset", "utf-8");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8));
                out.print(bodyParams);
                out.flush();
                in = conn.getInputStream();
                result = WXBaseApi.parseStream(in);
            }
            catch (Exception e) {
                throw new Exception("\u7f51\u7edc\u8bf7\u6c42\u5f02\u5e38");
            }
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return JSONObject.fromString((String)result);
    }

    public static JSONObject http_get(String url, Map<String, String> params) throws Exception {
        String result = "";
        InputStream in = null;
        try {
            try {
                String strUrl = WXBaseApi.parseUrl(url, params);
                URL realUrl = new URL(strUrl);
                URLConnection conn = realUrl.openConnection();
                conn.setUseCaches(false);
                conn.setRequestProperty("Accept-Charset", "utf-8");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                conn.connect();
                in = conn.getInputStream();
                result = WXBaseApi.parseStream(in);
            }
            catch (Exception e) {
                e.printStackTrace();
                throw new Exception("\u7f51\u7edc\u8bf7\u6c42\u5f02\u5e38");
            }
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return JSONObject.fromString((String)result);
    }

    public static JSONObject upload(String url, File file) throws Exception {
        String result;
        block18: {
            String end = "\r\n";
            String twoHyphens = "--";
            String boundary = "*****";
            FileInputStream fileInputStream = null;
            FilterOutputStream outputStream = null;
            result = null;
            try {
                try {
                    URL realUrl = new URL(url);
                    URLConnection conn = realUrl.openConnection();
                    HttpURLConnection httpURLConnection = (HttpURLConnection)conn;
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod(POST);
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Charset", "UTF-8");
                    httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
                    outputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    String filename = file.getName();
                    ((DataOutputStream)outputStream).writeBytes(String.valueOf(twoHyphens) + boundary + end);
                    ((DataOutputStream)outputStream).writeBytes("Content-Disposition: form-data;filename=\"" + filename + "\"" + end);
                    ((DataOutputStream)outputStream).writeBytes(end);
                    fileInputStream = new FileInputStream(file);
                    int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    int length = -1;
                    while ((length = fileInputStream.read(buffer)) != -1) {
                        ((DataOutputStream)outputStream).write(buffer, 0, length);
                    }
                    ((DataOutputStream)outputStream).writeBytes(end);
                    ((DataOutputStream)outputStream).writeBytes(String.valueOf(twoHyphens) + boundary + twoHyphens + end);
                    ((DataOutputStream)outputStream).flush();
                    result = WXBaseApi.parseStream(conn.getInputStream());
                }
                catch (Exception e) {
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        }
                        catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    break block18;
                }
            }
            catch (Throwable throwable) {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                throw throwable;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return JSONObject.fromString(result);
    }

    public static boolean download(String url, Map<String, String> params, File saveFile) throws Exception {
        InputStream in = null;
        FileOutputStream fos = null;
        try {
            int bytesRead;
            String strUrl = WXBaseApi.parseUrl(url, params);
            URL realUrl = new URL(strUrl);
            URLConnection conn = realUrl.openConnection();
            conn.connect();
            in = conn.getInputStream();
            fos = new FileOutputStream(saveFile);
            byte[] buf = new byte[1024];
            while ((bytesRead = in.read(buf)) > 0) {
                fos.write(buf, 0, bytesRead);
            }
            fos.flush();
            return true;
        }
        catch (Exception e) {
            throw new Exception("\u7f51\u7edc\u8bf7\u6c42\u5f02\u5e38");
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String parseUrl(String url, Map<String, String> params) throws UnsupportedEncodingException {
        String param = WXBaseApi.parseParam(params);
        if (StringHelper.isNullOrEmpty((String)param)) {
            return url;
        }
        if (url.indexOf("?") != -1) {
            return String.valueOf(url) + "&" + param;
        }
        return String.valueOf(url) + "?" + param;
    }

    public static String parseParam(Map<String, String> params) throws UnsupportedEncodingException {
        String param = "";
        if (params == null || params.size() == 0) {
            return param;
        }
        for (String key : params.keySet()) {
            String value = params.get(key);
            if (StringHelper.isNullOrEmpty((String)value)) continue;
            param = String.valueOf(param) + "&" + key + "=" + params.get(key);
        }
        if (param.length() > 0) {
            return param.substring(1);
        }
        return param;
    }

    public static String parseStream(InputStream input) throws IOException {
        int n;
        InputStreamReader in = new InputStreamReader(input, StandardCharsets.UTF_8);
        StringBuilder builder = new StringBuilder();
        char[] buffer = new char[4096];
        while (-1 != (n = in.read(buffer))) {
            if (buffer == null) continue;
            builder.append(buffer, 0, n);
        }
        return builder.toString();
    }

    public static CallResult get(String url, Map<String, String> params) {
        CallResult callResult = null;
        try {
            JSONObject json = WXBaseApi.http_get(url, params);
            callResult = WXBaseApi.createResult(json);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            callResult = new CallResult();
            callResult.setRetCode(-1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    public static CallResult post(String url, JSONObject params) {
        if (params != null) {
            return WXBaseApi.post(url, params.toString());
        }
        return WXBaseApi.post(url, "");
    }

    public static CallResult post(String url, Map<String, String> params) {
        try {
            return WXBaseApi.post(url, WXBaseApi.parseParam(params));
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(5);
            callResult.setErrorInfo("\u51c6\u5907\u53c2\u6570\u5f02\u5e38");
            return callResult;
        }
    }

    public static CallResult post(String url, String params) {
        CallResult callResult = null;
        try {
            JSONObject json = WXBaseApi.http_post(url, params);
            callResult = WXBaseApi.createResult(json);
        }
        catch (Exception ex) {
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
        callResult.setUserObject((Object)json);
        return callResult;
    }
}

