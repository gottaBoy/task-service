package net.ibizsys.model.pub;

import java.util.HashMap;

/**
 * AngularJS部件成员代码发布器对象
 * @author Administrator
 *
 */
public class PSNGCtrlPartCodePublisherImpl extends PSPFCtrlPartCodePublisherImpl
{
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		PSNGTemplHelper.fillParams(params);
	}
}
