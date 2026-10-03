package net.ibizsys.model.pub.reactmob;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl;

public class PSReactMobCtrlPartCodePublisherImpl extends PSPFCtrlPartCodePublisherImpl
{
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		PSReactMobTemplHelper.fillParams(params);
	}
}
