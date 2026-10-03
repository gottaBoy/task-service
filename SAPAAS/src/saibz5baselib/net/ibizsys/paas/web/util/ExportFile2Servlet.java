package net.ibizsys.paas.web.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;

/**
 * 系统级临时文件下载Servlet处理对象
 * 
 * @author Administrator
 *
 */
public class ExportFile2Servlet extends HttpServletBase {
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
		String strFileName = this.getWebContext().getParamValue("FILEID");
		if (StringHelper.isNullOrEmpty(strFileName)) {
			throw new Exception(StringHelper.format("没有指定文件信息"));
		}

		String strTempFilePath = StringHelper.format("%1$s%2$s", WebConfig.getCurrent().getTempPath(), strFileName);

		ExportFileServlet.downloadFile(strTempFilePath, strFileName, this.getWebContext().getResponse());
		return ajaxActionResult;
	}
}
