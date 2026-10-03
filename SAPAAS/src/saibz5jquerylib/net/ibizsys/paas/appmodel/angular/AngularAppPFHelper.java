package net.ibizsys.paas.appmodel.angular;

import net.ibizsys.paas.appmodel.AppPFHelperBase;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

/**
 * Angular应用模型辅助对象
 * 
 * @author Administrator
 *
 */
public class AngularAppPFHelper extends AppPFHelperBase {

	@Override
	protected void onFillAppViewJSONObject(IAppViewModel iAppViewModel, JSONObject jsonObj) throws Exception {
		jsonObj.put("viewurl",JSONObjectHelper.stripQuotes(StringHelper.format("%1$s_%2$s", iAppViewModel.getModuleName(), iAppViewModel.getName()).toLowerCase()));
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
		return StringHelper.format("%1$s_%2$s", iAppViewModel.getModuleName(), iAppViewModel.getName()).toLowerCase();
	}

	
	
}
