package net.ibizsys.paas.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.service.FileService;

/**
 * 文件下载Servlet处理对象
 * 
 * @author Administrator
 *
 */
public class ExportFileServlet extends HttpServletBase {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.addTimeOutHeaders(response);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=UTF-8");

		try {
			SessionFactoryManager.enter();
			IWebContext iWebContext = this.createWebContext(request, response);
			WebContext.setCurrent(iWebContext);

			onProcessAction();
			
			resetCurrent();
			return;

		} catch (Exception ex) {

			resetCurrent();
		}
	}

	@Override
	protected AjaxActionResult onProcessAction() throws Exception {
		AjaxActionResult ajaxActionResult = new AjaxActionResult();
		
		String strFileId = this.getWebContext().getParamValue("FILEID");
		String strRotate = this.getWebContext().getParamValue("ROTATE");

		if (StringHelper.isNullOrEmpty(strFileId)) {
			throw new Exception(StringHelper.format("没有指定文件信息"));
		}

		net.ibizsys.psrt.srv.common.entity.File file = new net.ibizsys.psrt.srv.common.entity.File();
		FileService fileService = (FileService) ServiceGlobal.getService(FileService.class, this.getSessionFactory());

		file.setFileId(strFileId);
		fileService.get(file);

		String strPreview = this.getWebContext().getParamValue("PREVIEW");
		if (StringHelper.isNullOrEmpty(strPreview)) strPreview = "TRUE";

		String strFileLocalPath = WebConfig.getCurrent().getFilePath();
		if (StringHelper.isNullOrEmpty(strFileLocalPath)) {
			throw new Exception(StringHelper.format("系统没有配置文件存储路径"));
		}

		String strLocalPath = "";
		String strFileName = "";
		if (StringHelper.compare(strPreview, "TRUE", true) != 0) {
			// 非预览，使用原始文件路径及文件名称
			strLocalPath = file.getLocalPath2();
			strFileName = file.getFileName2();
		}

		if (StringHelper.isNullOrEmpty(strLocalPath)) {
			strLocalPath = file.getLocalPath();
		}
		if (StringHelper.isNullOrEmpty(strFileName)) {
			strFileName = file.getFileName();
		}

		String strTempFilePath = strFileLocalPath + strLocalPath;
		String strNewFileName = new String(strFileName.getBytes("GB2312"), "ISO-8859-1");

		// 下载旋转后的图片
		if (!StringHelper.isNullOrEmpty(strRotate)) {
			try {
				String strTmp = strTempFilePath.substring(0, strTempFilePath.indexOf(".")) + "_" + strRotate + ".png";

				File tmpFile = new File(strTmp);
				if (tmpFile.exists()) {
					strTempFilePath = strTmp;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		downloadFile(strTempFilePath, strNewFileName, this.getWebContext().getResponse());
		
		return ajaxActionResult;
	}
	
	/**
	 * 文件下载
	 * 
	 * @param filePath 文件路径
	 * @param fileName 文件名称
	 * @param response 
	 */
	public static void downloadFile(String filePath, String fileName, HttpServletResponse response) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			File file = new File(filePath);
			if (file != null && file.isFile() && file.canRead()) {
				response.setCharacterEncoding("utf-8");

				response.setContentType(WebUtility.getHttpContentType(fileName.substring(fileName.lastIndexOf("."))));
				response.setHeader("Pragma", "No-cache");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
				// response.setHeader("Content-Disposition", "attachment;fileName="+new String(fileName.getBytes("GBK"),"iso8859-1"));
				response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
				response.setHeader("Cache-Control", "max-age=0");
				inputStream = new FileInputStream(file);
				outputStream = response.getOutputStream();
				byte[] b = new byte[1024];
				int length;
				while ((length = inputStream.read(b)) > 0) {
					outputStream.write(b, 0, length);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
