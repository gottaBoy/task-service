package net.ibizsys.model.pub.vuemob;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import SA.SRFDA.PS.Core.Pub.PSFR7TemplHelper;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.pub.PSPFCtrlCodePublisherImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSVueMobCtrlCodePublisherImpl extends PSPFCtrlCodePublisherImpl
{
	private static final Log log = LogFactory.getLog(PSPFCtrlCodePublisherImpl.class);

	
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);

		PSFR7TemplHelper.fillParams(params);

	}

	protected String getPSControlCodeName(IPSAppView iPSAppView,IPSControl iPSControl)
	{
		String strFullName = ((IPSAppViewRuntime)iPSAppView).getFullCodeName();
		int nPos = strFullName.lastIndexOf(".");
		if(nPos != -1){
			strFullName = strFullName.substring(0, nPos).toLowerCase() + "." + strFullName.substring(nPos+1);
		}
		
		return strFullName+"_"+iPSControl.getName().toLowerCase();
	}
}
