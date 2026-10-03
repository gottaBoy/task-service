package net.ibizsys.paas.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.common.entity.File;
import net.ibizsys.psrt.srv.common.service.FileService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 文件辅助对象
 * 
 * @author Administrator
 *
 */
public class FileHelper {
	/**
	 * 获取临时文件
	 * 
	 * @param iWebContext
	 * @param strFileName
	 * @param strFileExt
	 * @return
	 * @throws Exception
	 */
	static public String getTmpFileName(IWebContext iWebContext, String strFileName, String strFileExt) throws Exception {
		if (StringHelper.isNullOrEmpty(strFileName)) {
			strFileName = KeyValueHelper.genGuidEx();
		}
		
		if (iWebContext == null) {
			return StringHelper.format("%1$s%2$s%3$s", WebConfig.getCurrent().getTempPath(), strFileName, strFileExt);
		} else {
			String strFolder = StringHelper.format("%1$s%2$s%3$s", WebConfig.getCurrent().getTempPath(), iWebContext.getSessionId(), java.io.File.separator);
			java.io.File file = new java.io.File(strFolder);
			file.mkdirs();
			return StringHelper.format("%1$s%2$s%3$s%4$s%5$s", WebConfig.getCurrent().getTempPath(), iWebContext.getSessionId(), java.io.File.separator, strFileName, strFileExt);
		}
	}
	
	
	
	/**
	 * 获取平台上传文件存储格式转为为文件列表
	 * @param strFileList
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	static public File[] getFileList(String strFileList,SessionFactory sessionFactory)throws Exception{
		
		if(StringHelper.isNullOrEmpty(strFileList))
			return null;
		
		ArrayList<File> fileList = new ArrayList<File>();
		
		FileService fileService = (FileService)ServiceGlobal.getService(FileService.class,sessionFactory);
		JSONArray ja = JSONArray.fromString(strFileList);
		for(int i =0;i<ja.length();i++){
			JSONObject jo = ja.getJSONObject(i);  
			String strId = jo.optString("id");
			if(StringHelper.isNullOrEmpty(strId))
				continue;
			
			File file = new File();
			file.setFileId(strId);
			fileService.get(file);
			fileList.add(file);
		}
		
		return fileList.toArray(new File[fileList.size()]);
	}
	
	/**
	 * 从文件中构建
	 * @param input
	 * @return
	 */
	public static String readFile(InputStream input) throws Exception {
		return readFile(input,null);
	}
	
	/**
	 * 从文件中构建
	 * @param input
	 * @param strEncoding 
	 * @return
	 */
	public static String readFile(InputStream input,String strEncoding) throws Exception {
		if (input == null) {  
	        throw new Exception("无效输入");  
	    }  
		if(StringHelper.isNullOrEmpty(strEncoding))
			strEncoding = "UTF-8";
	    //字节数组  
	    byte[] bcache = new byte[4096];  
	    int readSize = 0;//每次读取的字节长度  
	    ByteArrayOutputStream infoStream = new ByteArrayOutputStream();  
	    try {  
	        //一次性读取4096字节  
	        while ((readSize = input.read(bcache)) > 0) {  
	            infoStream.write(bcache,0,readSize);  
	        }  
	    } catch (IOException e1) {  
	        throw new Exception(e1);  
	    } finally {  
	        try {  
	            //输入流关闭  
	            input.close();  
	        } catch (IOException e) {  
	            throw new Exception(e);  
	        }  
	    }  
	  
	    try {  
	        return infoStream.toString(strEncoding);  
	    } catch (UnsupportedEncodingException e) {  
	        throw new Exception(e);  
	    }  
	}
	
}
