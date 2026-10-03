package net.ibizsys.model.pub;

import java.util.HashMap;

/**
 * ExtJS 5.0 部件成员代码发布器对象
 * @author Administrator
 *
 */
public class PSExtJS5CtrlPartCodePublisherImpl extends PSPFCtrlPartCodePublisherImpl
{
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		PSExtJSTemplHelper.fillParams(params);
	}
}
