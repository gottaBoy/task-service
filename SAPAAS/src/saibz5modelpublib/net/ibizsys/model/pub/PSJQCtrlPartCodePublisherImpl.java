package net.ibizsys.model.pub;

import java.util.HashMap;

/**
 * JQuery部件成员代码发布器对象
 * @author Administrator
 *
 */
public class PSJQCtrlPartCodePublisherImpl extends PSPFCtrlPartCodePublisherImpl
{
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		PSJQTemplHelper.fillParams(params);
	}
}
