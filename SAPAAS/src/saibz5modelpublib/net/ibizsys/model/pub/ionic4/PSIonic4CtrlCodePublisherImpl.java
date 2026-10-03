package net.ibizsys.model.pub.ionic4;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl;
import SA.SRFramework.Utility.StringHelper;

public class PSIonic4CtrlCodePublisherImpl extends PSPFCtrlCodePublisherImpl
{
	private static final Log log = LogFactory.getLog(PSPFCtrlCodePublisherImpl.class);

	
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);

		PSIonic4TemplHelper.fillParams(params);

	}

	@Override
	protected String getPSControlCodeName(IPSAppView iPSAppView,IPSControl iPSControl)
	{
		String strFullName = iPSAppView.getFullCodeName();;
		int nPos = strFullName.lastIndexOf(".");
		if(nPos != -1){
			strFullName = StringHelper.Format("%1$s.%2$s",strFullName.substring(0, nPos).toLowerCase(),strFullName.substring(nPos+1));
		}
		
		return strFullName+"_"+iPSControl.getName().toLowerCase();
	}
}
