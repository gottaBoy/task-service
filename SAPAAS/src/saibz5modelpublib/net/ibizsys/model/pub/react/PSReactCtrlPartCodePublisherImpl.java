package net.ibizsys.model.pub.react;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl;

public class PSReactCtrlPartCodePublisherImpl extends PSPFCtrlPartCodePublisherImpl
{
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		PSReactTemplHelper.fillParams(params);
	}
}
