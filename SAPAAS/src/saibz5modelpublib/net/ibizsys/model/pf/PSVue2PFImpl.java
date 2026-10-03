package net.ibizsys.model.pf;

import java.util.Map;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.pub.vue2.PSVue2FileNameMethod;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;

/**
 * @author Administrator
 *
 */
public class PSVue2PFImpl extends PSPFImpl
{

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.PF.PSPFImpl#getPSAppViewPageUrl(SA.SRFDA.PS.Core.App.View.IPSAppView)
	 */
	@Override
	public String getPSAppViewPageUrl(IPSAppView iPSAppView) throws Exception
	{
		String strPageUrl = StringHelper.format("/%1$s/%2$s.jsp",iPSAppView.getPSAppModule().getCodeName(), iPSAppView.getName()).toLowerCase();
		return strPageUrl;
	}
	
		@Override
	public String getPSAppViewPageUrl(IPSAppView iPSAppView, Map<String, String> params) throws Exception {
		String strUrlParams = "";
		if(params != null){
			strUrlParams = WebUtility.getQueryString(params);
		}
//		/pages/common/customer-edit-view/customer-edit-view.html#/customer-edit-view
		if(StringHelper.isNullOrEmpty(strUrlParams)){
			return StringHelper.format("/pages/%1$s/%2$s/%3$s.html#/%4$s", 
					PSVue2FileNameMethod.replaceFullName(iPSAppView.getPSAppModule().getCodeName()), 
					PSVue2FileNameMethod.replaceFullName(((IPSAppViewRuntime)iPSAppView).getCodeName()),
					PSVue2FileNameMethod.replaceFullName(((IPSAppViewRuntime)iPSAppView).getCodeName()),
					PSVue2FileNameMethod.replaceFullName(((IPSAppViewRuntime)iPSAppView).getCodeName()));
		}
		else{
			return StringHelper.format("/pages/%1$s/%2$s/%3$s.html#/%4$s", 
					PSVue2FileNameMethod.replaceFullName(iPSAppView.getPSAppModule().getCodeName()), 
					PSVue2FileNameMethod.replaceFullName(((IPSAppViewRuntime)iPSAppView).getCodeName()),
					PSVue2FileNameMethod.replaceFullName(((IPSAppViewRuntime)iPSAppView).getCodeName()),
					PSVue2FileNameMethod.replaceFullName(((IPSAppViewRuntime)iPSAppView).getCodeName())+"/"+strUrlParams);
		}
	}

}
