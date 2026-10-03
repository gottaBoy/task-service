package net.ibizsys.model.pf;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.paas.util.StringHelper;

/**
 * @author Administrator
 *
 */
public class PSAngularPFImpl extends PSPFImpl
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
	
	
	

}
