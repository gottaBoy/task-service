package net.ibizsys.model.pf;

import java.util.Map;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;

/**
 * @author Administrator
 *
 */
public class PSJQPFImpl extends PSPFImpl
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
		if(StringHelper.isNullOrEmpty(strUrlParams)){
			return StringHelper.format("/%1$s/%2$s.jsp",iPSAppView.getPSAppModule().getCodeName(), iPSAppView.getName()).toLowerCase();
		}
		else{
			return StringHelper.format("/%1$s/%2$s.jsp",iPSAppView.getPSAppModule().getCodeName(), iPSAppView.getName()).toLowerCase()+"?"+strUrlParams;
		}
	}
	
	
	

}
