package net.ibizsys.paas.web.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.util.SystemRTHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;

/**
 * 安装运行数据Servlet处理对象
 * 
 * @author 
 *
 */
public class InstallRTDataServlet extends HttpServletBase {

	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(LoginServlet.class);

	private String strInstallDataInfo = "";

	@Override
	protected AjaxActionResult onProcessAction() {
		AjaxActionResult ajaxActionResult = new AjaxActionResult();

		try {
			onInstallData();
			ajaxActionResult.setRetCode(Errors.OK);
			ajaxActionResult.setErrorInfo(strInstallDataInfo);
		} catch (Exception e) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(e.getMessage());
			log.error(e);
		}

		return ajaxActionResult;
	}

	/**
	 * 执行安装运行数据
	 * 
	 * @throws Exception
	 */
	protected void onInstallData() throws Exception {
		if (!this.getWebContext().isSuperUser()) {
			throw new ErrorException(Errors.ACCESSDENY, "只允许系统超级管理员操作");
		}

		ActionSessionManager.openSession("安装运行数据");
		try {
			SystemRTHelper.installAll();
			strInstallDataInfo = ActionSessionManager.getActionInfo();
			ActionSessionManager.closeSession();

			if (strInstallDataInfo != null) {
				strInstallDataInfo = strInstallDataInfo.replace("\r\n", "<BR>");
			}
		} catch (Exception ex) {
			ActionSessionManager.closeSession();
			throw ex;
		}
	}

}