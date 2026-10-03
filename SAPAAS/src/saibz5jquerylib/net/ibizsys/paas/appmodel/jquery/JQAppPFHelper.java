package net.ibizsys.paas.appmodel.jquery;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.ibizsys.paas.appmodel.AppPFHelperBase;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.sf.json.JSONObject;

/**
 * JQ应用模型辅助对象
 * 
 * @author Administrator
 *
 */
public class JQAppPFHelper extends AppPFHelperBase {

	@Override
	protected void onFillAppViewJSONObject(IAppViewModel iAppViewModel, JSONObject jsonObj) throws Exception {
		jsonObj.put("viewurl", JSONObjectHelper.stripQuotes(StringHelper.format("/%1$s/%2$s.jsp", iAppViewModel.getModuleName(), iAppViewModel.getName()).toLowerCase()));
		if (iAppViewModel.getWidth() > 0) jsonObj.put("width", iAppViewModel.getWidth());
		if (iAppViewModel.getHeight() > 0) jsonObj.put("height", iAppViewModel.getHeight());
		jsonObj.put("title", JSONObjectHelper.stripQuotes(iAppViewModel.getTitle()));
		if (!StringHelper.isNullOrEmpty(iAppViewModel.getOpenMode())) {
			jsonObj.put("openMode", JSONObjectHelper.stripQuotes(iAppViewModel.getOpenMode()));
		}
	}

	@Override
	protected String mapRealAppUrl(String strUrl) throws Exception {
		return "../../" + strUrl;
	}

	@Override
	public int getAppType() {
		return IApplication.APPTYPE_DESKTOP;
	}
	
	@Override
	public String getAppViewTag(IAppViewModel iAppViewModel) throws Exception {
		return StringHelper.format("/%1$s/%2$s.jsp", iAppViewModel.getModuleName().toLowerCase(), iAppViewModel.getName()).toLowerCase();
	}
	
	@Override
	public String getAppViewUrl(IAppViewModel iAppViewModel, Map<String, String> params) throws Exception {
			String strUrlParams = "";
		if(params != null && params.size()>0){
			Map<String, String> params2 = new HashMap<String, String>();
			for(Entry<String,String> entry:params.entrySet()) {
				params2.put(entry.getKey().toLowerCase(), entry.getValue());
			}
			strUrlParams = WebUtility.getQueryString(params2);
		}
		if(StringHelper.isNullOrEmpty(strUrlParams)){
			return StringHelper.format("/jsp/%1$s/%2$s.jsp?",iAppViewModel.getModuleName().toLowerCase(), iAppViewModel.getName().toLowerCase());
		}
		else{
			return StringHelper.format("/jsp/%1$s/%2$s.jsp?%3$s",iAppViewModel.getModuleName().toLowerCase(), iAppViewModel.getName().toLowerCase(), strUrlParams);
		}
	}
}
