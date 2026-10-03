package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

/**
 * 自定义系统用户角色对象模型
 * @author Administrator
 *
 */
public class CustomSystemUserRoleModel extends SystemUserRoleModelBase {

	@Override
	public String getRoleType() {
		return ISystemUserRoleModel.ROLETYPE_CUSTOM;
	}

	@Override
	public boolean testCurUser(IWebContext iWebContext) throws Exception {
		return WebContext.getUserRoleMgr2().testSysUserRole(this.getRoleTag());
	}

	
	
}
