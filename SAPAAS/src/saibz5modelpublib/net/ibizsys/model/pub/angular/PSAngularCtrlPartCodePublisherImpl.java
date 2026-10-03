package net.ibizsys.model.pub.angular;

import java.util.HashMap;

import net.ibizsys.model.pub.PSPFCtrlPartCodePublisherImpl;

public class PSAngularCtrlPartCodePublisherImpl extends PSPFCtrlPartCodePublisherImpl
{
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		PSAngularTemplHelper.fillParams(params);
	}
}
