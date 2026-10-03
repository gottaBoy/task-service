package net.ibizsys.paas.appmodel.vue;

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
 * Vue应用模型辅助对象
 * 
 * @author Administrator
 *
 */
public class VueAppPFHelper extends AppPFHelperBase {

	@Override
	protected void onFillAppViewJSONObject(IAppViewModel iAppViewModel, JSONObject jsonObj) throws Exception {
		jsonObj.put("viewurl", JSONObjectHelper.stripQuotes(StringHelper.format("%1$s_%2$s", iAppViewModel.getModuleName(), iAppViewModel.getName()).toLowerCase()));
		jsonObj.put("modulename", iAppViewModel.getModuleName());
		jsonObj.put("viewtag", iAppViewModel.getId());
		jsonObj.put("viewname", iAppViewModel.getName());
		jsonObj.put("title", JSONObjectHelper.stripQuotes(iAppViewModel.getTitle()));
		jsonObj.put("width", iAppViewModel.getWidth());
		jsonObj.put("height", iAppViewModel.getHeight());
		String openmode = "";
		if (!StringHelper.isNullOrEmpty(iAppViewModel.getOpenMode())) {
			jsonObj.put("openMode",JSONObjectHelper.stripQuotes( iAppViewModel.getOpenMode()));
			openmode = JSONObjectHelper.stripQuotes(iAppViewModel.getOpenMode()).toString();
		}
		jsonObj.put("openmode", openmode);
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
		return StringHelper.format("%1$s_%2$s", iAppViewModel.getModuleName(), iAppViewModel.getName()).toLowerCase();
	}
	
	
	
	@Override
	public String getAppViewUrl(IAppViewModel iAppViewModel, Map<String, String> params) throws Exception {
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
					VueAppPFHelper.replaceFullName(iAppViewModel.getModuleName()), 
					VueAppPFHelper.replaceFullName(iAppViewModel.getName()),
					VueAppPFHelper.replaceFullName(iAppViewModel.getName()),
					VueAppPFHelper.replaceFullName(iAppViewModel.getName()));
		}
		else{
			return StringHelper.format("/pages/%1$s/%2$s/%3$s.html#/%4$s", 
					VueAppPFHelper.replaceFullName(iAppViewModel.getModuleName()), 
					VueAppPFHelper.replaceFullName(iAppViewModel.getName()),
					VueAppPFHelper.replaceFullName(iAppViewModel.getName()),
					VueAppPFHelper.replaceFullName(iAppViewModel.getName())+"/"+strUrlParams);
		}
	}
	
	
	public static String replaceFullName(String strFullName) {
		strFullName = strFullName.replaceAll("_", "-");
		int state = 0;//0代表前一个字母是小写，1代表前一个字母是大写
        String str = strFullName;
        StringBuilder strBuilder = new StringBuilder();
		if(Character.isUpperCase(str.charAt(0))){
			strBuilder.append(str.substring(0,1).toLowerCase());
			state = 1;
		} else {
			strBuilder.append(str.substring(0,1));
			state = 0;
		}
        for(int i = 1; i< str.length(); i++){
        	char chr = str.charAt(i);
            if(Character.isUpperCase(chr)){
            	if(state == 1){
            		strBuilder.append(str.substring(i,(i+1)).toLowerCase());
            	} else {
            		strBuilder.append("-");
            		strBuilder.append(str.substring(i,(i+1)).toLowerCase());
            	}
            	state = 1;
            } else {
            	strBuilder.append(chr);
            	state = 0;
            }
        }
        String resultStr = strBuilder.toString();
        resultStr = resultStr.replaceAll("--", "-");
        resultStr = resultStr.replaceAll("---", "-");
		return resultStr;
	}
}
