package net.ibizsys.ssdynawf.controller;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.sswf.api.SaaSWFActionParam;
import net.ibizsys.sswf.entity.WFProxyEntity;

/**
 * 动态工作流代理数据视图控制器实例基类
 * @author Administrator
 *
 */
public abstract class DynaWFProxyDataViewControllerInstBase extends DynaWFViewControllerInstBase{

	public DynaWFProxyDataViewControllerInstBase() throws Exception {
		super();
	}

	
	@Override
	protected AjaxActionResult onLoadViewModel() throws Exception {

		AjaxActionResult ajaxActionResult =  super.onLoadViewModel();
		if(ajaxActionResult.isError()) {
			return ajaxActionResult;
		}
		//
		String strKey = WebContext.getKey(this.getWebContext());
		if(StringHelper.isNullOrEmpty(strKey)) {
			strKey = WebContext.getParentKey(this.getWebContext());
		}
		if(StringHelper.isNullOrEmpty(strKey)) {
			ajaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
			return ajaxActionResult;
		}
		
		
		//获取代理业务数据
		SaaSWFActionParam wfActionParam = new SaaSWFActionParam();
		wfActionParam.setUserData((String) strKey);
		wfActionParam.setUserData4(this.getDEModel().getId());
		wfActionParam.setWorkflowId(this.getWFModel().getId());
		
		WFProxyEntity wfProxyEntity	= ((net.ibizsys.paas.sysmodel.SystemModelBase) this.getDynaSysModel()).getSaaSWFServiceUtil().getProxyEntity(wfActionParam);
		//下发路径
		ajaxActionResult.setExtAttr("viewurl", wfProxyEntity.getViewUrl());
		
		return ajaxActionResult;
	}
}
