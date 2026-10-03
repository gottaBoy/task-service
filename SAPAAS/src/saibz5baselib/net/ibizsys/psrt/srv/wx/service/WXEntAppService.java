/**
 *  iBizSys 5.0 用户自定义代码
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.service;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.psrt.srv.wx.entity.WXEntApp;
import net.ibizsys.pswx.core.IWXAccountModel;
import net.ibizsys.pswx.core.IWXEntAppModel;
import net.ibizsys.pswx.core.WXGlobal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * 实体[WXEntApp] 服务对象
 */
@Component
public class WXEntAppService extends WXEntAppServiceBase {

	private static final Log log = LogFactory.getLog(WXEntAppService.class);

	public WXEntAppService() {
		super();
	}

	@Override
	protected void onPubMenu(WXEntApp wXEntApp) throws Exception {
		IWXAccountModel accountModel = WXGlobal.getWXAccountModel(wXEntApp.getWXAccountId());
		if (accountModel == null) {
			throw new Exception("无法获取微信企业号模型对象");
		}
		if (wXEntApp.getAgentId() == null) {
			throw new Exception("未配置企业应用标识");
		}
		IWXEntAppModel iEntAppModel = accountModel.getWXEntAppModel(wXEntApp.getAgentId());

		if (iEntAppModel == null) {
			throw new Exception("无法获取微信应用模型对象");
		}
		CallResult callResult = iEntAppModel.publishMenu();

		if (callResult.isError()) {
			throw new Exception(callResult.getErrorInfo());
		}
	}

}