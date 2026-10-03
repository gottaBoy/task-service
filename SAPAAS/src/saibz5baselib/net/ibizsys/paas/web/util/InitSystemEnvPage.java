package net.ibizsys.paas.web.util;

import java.util.ArrayList;

import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.web.Page;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.entity.User;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.ibizsys.psrt.srv.common.service.UserService;

/**
 * 初始化系统环境页面处理对象
 * 
 * @author Administrator
 * 
 */
public class InitSystemEnvPage extends Page {
	public InitSystemEnvPage() {

	}

	@Override
	protected void onInit() throws Exception {
		super.onInit();

		// 初始化系统环境只能在系统有任何用户的情况下进行。
		UserService userService = (UserService) ServiceGlobal.getService(UserService.class);
		SelectCond selectCond = new SelectCond();
		selectCond.setFetchFirst(true);
		ArrayList<User> userList = userService.select(selectCond);
		if (userList.size() > 0) {
			// 系统已经初始化
			return;
		}

		onInitSystemEnv();
	}

	/**
	 * @throws Exception
	 */
	protected void onInitSystemEnv() throws Exception {
		UserService userService = (UserService) ServiceGlobal.getService(UserService.class);
		LoginAccountService loginAccountService = (LoginAccountService) ServiceGlobal.getService(LoginAccountService.class);
		// 建立系统超级用户
		if (true) {
			User user = new User();
			user.setUserName("系统管理员");
			user.setIsSystem(1);
			user.setValidFlag(1);
			user.setEnable(1);
			user.setMemo("系统超级管理员");
			userService.create(user);

			String strPassword = KeyValueHelper.genUniqueId("ibzadmin", "123456");
			// 设置登录账户
			LoginAccount loginAccount = new LoginAccount();
			loginAccount.setUserId(user.getUserId());
			loginAccount.setUserName(user.getUserName());
			loginAccount.setLoginAccountName("ibzadmin");
			loginAccount.setSuperUser(1);
			loginAccount.setIsEnable(1);
			loginAccount.setPwd(strPassword);
			loginAccountService.create(loginAccount);
		}
	}

}
