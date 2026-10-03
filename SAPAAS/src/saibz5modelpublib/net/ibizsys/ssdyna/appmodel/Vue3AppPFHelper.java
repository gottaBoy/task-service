package net.ibizsys.ssdyna.appmodel;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.ibizsys.model.pub.vue2.PSVue2FileNameMethod;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.appmodel.vue.VueAppPFHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.WebContext;

/**
 * Vue3应用前端辅助对象
 * @author Administrator
 *
 */
public class Vue3AppPFHelper extends VueAppPFHelper implements IDynaAppPFHelper{

	@Override
	public String getAppViewUrl(IAppViewModel iAppViewModel, Map<String, String> params) throws Exception {
		if(iAppViewModel instanceof IDynaAppViewModel) {
			if(params == null) {
				params = new HashMap<String, String>();
			}
			params.put(WebContext.PARAM_VIEWID, iAppViewModel.getId());
		}
		String strUrlParams = "";
		if(params != null && params.size()>0){
			Map<String, String> params2 = new HashMap<String, String>();
			for(Entry<String,String> entry:params.entrySet()) {
				params2.put(entry.getKey().toLowerCase(), entry.getValue());
			}
			strUrlParams = WebUtility.getQueryString(params2,";");
		}
//		/pages/common/customer-edit-view/customer-edit-view.html#/customer-edit-view
		if(StringHelper.isNullOrEmpty(strUrlParams)){
			return StringHelper.format("/pages/%1$s/%2$s/%3$s.html#/%4$s", 
					PSVue2FileNameMethod.replaceFullName(iAppViewModel.getModuleName()), 
					PSVue2FileNameMethod.replaceFullName(iAppViewModel.getName()),
					PSVue2FileNameMethod.replaceFullName(iAppViewModel.getName()),
					PSVue2FileNameMethod.replaceFullName(iAppViewModel.getName()));
		}
		else{
			return StringHelper.format("/pages/%1$s/%2$s/%3$s.html#/%4$s", 
					PSVue2FileNameMethod.replaceFullName(iAppViewModel.getModuleName()), 
					PSVue2FileNameMethod.replaceFullName(iAppViewModel.getName()),
					PSVue2FileNameMethod.replaceFullName(iAppViewModel.getName()),
					PSVue2FileNameMethod.replaceFullName(iAppViewModel.getName())+"/"+strUrlParams);
		}
	}
	
	
	
}
