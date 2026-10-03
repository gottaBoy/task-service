package net.ibizsys.model.pub.vuemob;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Pub.PSFR7TemplHelper;
import net.ibizsys.model.pub.PSPFCtrlPartCodePublisherImpl;

public class PSVueMobCtrlPartCodePublisherImpl extends PSPFCtrlPartCodePublisherImpl
{
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		PSFR7TemplHelper.fillParams(params);
	}
}
