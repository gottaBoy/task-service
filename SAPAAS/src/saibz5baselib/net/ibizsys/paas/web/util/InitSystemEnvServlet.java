package net.ibizsys.paas.web.util;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.entity.User;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.ibizsys.psrt.srv.common.service.UserService;

/**
 * 初始化系统环境Servlet处理对象
 * 
 * @author 
 *
 */
public class InitSystemEnvServlet extends HttpServletBase {

	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(LoginServlet.class);

	@Override
	protected AjaxActionResult onProcessAction() {
		AjaxActionResult ajaxActionResult = new AjaxActionResult();
		try {
			// 初始化系统环境只能在系统有任何用户的情况下进行。
			UserService userService = (UserService) ServiceGlobal.getService(UserService.class);
			SelectCond selectCond = new SelectCond();
			selectCond.setFetchFirst(true);
			ArrayList<User> userList = userService.select(selectCond);
			if (userList.size() > 0) {
				// 系统已经初始化
				ajaxActionResult.setErrorInfo("系统已初始化！");
			} else {
				onInitSystemEnv();
				ajaxActionResult.setErrorInfo("管理员账号已创建，系统初始化成功！");
			}
			ajaxActionResult.setRetCode(Errors.OK);

		} catch (Exception ex) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(ex.getMessage());
			log.error(ex);
		}

		return ajaxActionResult;
	}

	/**
	 * 执行初始化管理员账号
	 * 
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