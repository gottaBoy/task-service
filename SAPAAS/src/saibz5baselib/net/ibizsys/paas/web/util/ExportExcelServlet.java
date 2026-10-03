package net.ibizsys.paas.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DEDataImportTemplateHelper;
import net.ibizsys.paas.util.FileHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;

/**
 * 导出Excel文件Servlet处理对象
 * 
 * @author Administrator
 *
 */
public class ExportExcelServlet extends HttpServletBase {
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
			String strDEId = WebContext.getDEId(this.getWebContext());
			if (!StringHelper.isNullOrEmpty(strDEId)) {
				IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(strDEId);

				String strDEDataImport = WebContext.getDEDataImport(this.getWebContext());
				String strTempFileName = StringHelper.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new java.util.Date());
				String strTempFilePath = FileHelper.getTmpFileName(this.getWebContext(), strTempFileName, ".xls");

				DEDataImportTemplateHelper.output(iDataEntityModel, strTempFilePath);
				
				strFileName = strTempFileName;
			} 
		}
		
		if (StringHelper.isNullOrEmpty(strFileName)) {
			ajaxActionResult.setRetCode(Errors.INPUTERROR);
			ajaxActionResult.setErrorInfo(StringHelper.format("没有指定文件信息"));
			return ajaxActionResult;
			//throw new Exception(StringHelper.format("没有指定文件信息"));
		}

		String strExportType = this.getWebContext().getParamValue("EXPORTTYPE");
		String strFullFileName = "";
		try {
			String strFileSuffix = "";
			if (StringHelper.compare(strExportType, "HTML", true) == 0) {
				strFileSuffix = "htm";
				this.getWebContext().getResponse().setContentType("text/html;charset=GBK");
				this.getWebContext().getResponse().setCharacterEncoding("GBK");
				strFullFileName = StringHelper.format("%1$s%2$s%3$s%4$s.%5$s", WebConfig.getCurrent().getTempPath(), getWebContext().getSessionId(), File.separator, strFileName, strFileSuffix);
				exportGridViewHTML(strFullFileName);
			} else {
				this.getWebContext().getResponse().setContentType("application/vnd.ms-excel;charset=GBK");
				this.getWebContext().getResponse().setCharacterEncoding("GBK");
				strFileSuffix = "xls";
				strFullFileName = StringHelper.format("%1$s%2$s%3$s%4$s.%5$s", WebConfig.getCurrent().getTempPath(), getWebContext().getSessionId(), File.separator, strFileName, strFileSuffix);

				ExportFilePage.downloadFile(strFullFileName, strFileName + "." + strFileSuffix, this.getWebContext().getResponse());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return ajaxActionResult;
	}
	
	/**
	 * 导出表格视图HTML
	 * 
	 * @param strFullFileName
	 */
	public void exportGridViewHTML(String strFullFileName) {
		FileInputStream fis = null;
		try {
			this.getWebContext().getResponse().getOutputStream().flush();
			fis = new FileInputStream(new File(strFullFileName));
			if (fis == null || fis.available() <= 0) {
				return;
			}
			byte[] bytes = new byte[fis.available()];
			int nCnt = fis.read(bytes);
			this.getWebContext().getResponse().getOutputStream().write(bytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
