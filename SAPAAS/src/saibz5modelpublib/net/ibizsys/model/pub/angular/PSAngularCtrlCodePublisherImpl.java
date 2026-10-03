package net.ibizsys.model.pub.angular;

import java.util.HashMap;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.pub.PSPFCtrlCodePublisherImpl;
import net.ibizsys.paas.util.StringHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAngularCtrlCodePublisherImpl extends PSPFCtrlCodePublisherImpl
{
	private static final Log log = LogFactory.getLog(PSPFCtrlCodePublisherImpl.class);

	
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);

		PSAngularTemplHelper.fillParams(params);

	}

//	@Override
//	protected String getPSControlCodeName(IPSAppView iPSAppView,IPSControl iPSControl)
//	{
//		String strFullName = iPSAppView.getFullCodeName();;
//		int nPos = strFullName.lastIndexOf(".");
//		if(nPos != -1){
//			strFullName = StringHelper.Format("%1$s.%2$s",strFullName.substring(0, nPos).toLowerCase(),strFullName.substring(nPos+1));
//		}
//		
//		return strFullName+"_"+iPSControl.getName().toLowerCase();
//	}
}
