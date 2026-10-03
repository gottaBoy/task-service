package net.ibizsys.model.pub.ionic;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Pub.PSFR7TemplHelper;
import SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl;

public class PSIonicCtrlPartCodePublisherImpl extends PSPFCtrlPartCodePublisherImpl
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
