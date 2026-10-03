package net.ibizsys.paas.web.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.report.IPrintService;
import net.ibizsys.paas.report.PrintServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

/**
 * 打印Servlet对象
 * 
 * @author Administrator
 *
 */
public class PrintServlet extends HttpServletBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(PrintServlet.class);

	private String strContentType = "";
	private String strFileFolder = "";

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		this.strContentType = config.getInitParameter("CONTENTTYPE");
		if (StringHelper.isNullOrEmpty(strContentType)) strContentType = IPrintService.CONTENTTYPE_PDF;
		this.strFileFolder = config.getInitParameter("FILEFOLDER");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.addTimeOutHeaders(response);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=UTF-8");

		try {
			IWebContext iWebContext = this.createWebContext(request, response);
			WebContext.setCurrent(iWebContext);

			processPrint();

			resetCurrent();
			return;

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);

			resetCurrent();

		}
	}

	/**
	 * 处理打印
	 * 
	 * @throws Exception
	 */
	protected void processPrint() throws Exception {
		String strPrintId = WebContext.getPrintId(this.getWebContext());
		String strKeys = WebContext.getKeys(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strKeys)){
			strKeys = WebContext.getKey(this.getWebContext());
		}
		IPrintService iPrintService = PrintServiceGlobal.getPrintService(strPrintId);
		String strReportFile = iPrintService.getPrintFile(strKeys, this.getWebContext(), null, strContentType, strFileFolder);
		sendBackFile(strReportFile, strContentType, this.getWebContext().getRequest(), this.getWebContext().getResponse());
	}

	/**
	 * 发送内容
	 * 
	 * @param strReportFile
	 * @param strReportType
	 * @param request
	 * @param response
	 */
	protected static boolean sendBackFile(String strReportFile, String strReportType, HttpServletRequest request, HttpServletResponse response) {
		boolean bRet = true;

		try {
			// String strReportFileName = report.getREPORTNAME();
			if (StringHelper.compare(strReportType, IPrintService.CONTENTTYPE_PDF, true) == 0) {
				response.setContentType("application/pdf");
			}

			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				bis = new BufferedInputStream(new FileInputStream(strReportFile));
				bos = new BufferedOutputStream(response.getOutputStream());

				byte[] buff = new byte[2048];
				int bytesRead;

				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}

			} catch (final IOException e) {
				bRet = false;
				System.out.println("出现IOException." + e);
			} finally {
				if (bis != null) bis.close();
				if (bos != null) bos.close();
			}
		} catch (Exception ex) {
			bRet = false;
			ex.printStackTrace();
		}

		return bRet;
	}
}
