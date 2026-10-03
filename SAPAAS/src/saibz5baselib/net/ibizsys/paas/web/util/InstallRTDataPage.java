package net.ibizsys.paas.web.util;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.util.SystemRTHelper;
import net.ibizsys.paas.web.Page;

/**
 * 安装运行数据页面处理对象
 * 
 * @author Administrator
 * 
 */
public class InstallRTDataPage extends Page {
	private String strInstallDataInfo = "";

	public InstallRTDataPage() {

	}

	@Override
	protected void onInit() throws Exception {
		super.onInit();

		if (!this.getWebContext().isSuperUser()) {
			throw new ErrorException(Errors.ACCESSDENY, "页面只允许系统超级管理员访问");
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

	/**
	 * 输出安装信息
	 * 
	 * @return
	 */
	public String outputInstallInfo() {
		return this.strInstallDataInfo;
	}

}
