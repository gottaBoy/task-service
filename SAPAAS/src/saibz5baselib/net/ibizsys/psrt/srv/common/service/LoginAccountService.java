package net.ibizsys.psrt.srv.common.service;

import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

//@Service
//@Transactional
@Component
/**
 * 登录帐户 服务操作对象
 * 
 */
public class LoginAccountService extends LoginAccountServiceBase
{
	private static final String _PASSWORD_ = "__HASH_PASS__";

	private static final Log log = LogFactory.getLog(LoginAccountService.class);

	public LoginAccountService()
	{
		super();

	}

	@Override
	protected void onSaveHashMode(LoginAccount loginAccount) throws Exception
	{
		if (loginAccount.isPwdDirty())
		{
			if (StringHelper.compare(loginAccount.getPwd(), _PASSWORD_, true) == 0)
			{
				// 密码没有修改，移除
				loginAccount.resetPwd();
			}
			else
			{
				String strPassword = KeyValueHelper.genUniqueId(loginAccount.getLoginAccountName().toLowerCase(), loginAccount.getPwd());
				loginAccount.setPwd(strPassword);
				loginAccount.setLastChgPwdTime(DateHelper.getCurTime());
			}
		}

		this.save(loginAccount);
		loginAccount.setPwd(_PASSWORD_);
	}

	/*
	 * 执行操作[GetHashMode]
	 */
	@Override
	protected void onGetHashMode(LoginAccount loginAccount) throws Exception
	{
		this.get(loginAccount);
		loginAccount.setPwd(_PASSWORD_);
	}

}