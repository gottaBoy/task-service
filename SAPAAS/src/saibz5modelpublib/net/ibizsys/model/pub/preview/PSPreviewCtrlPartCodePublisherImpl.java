package net.ibizsys.model.pub.preview;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl;

/**
 * PreViewPCuery部件成员代码发布器对象
 * @author Administrator
 *
 */
public class PSPreviewCtrlPartCodePublisherImpl extends PSPFCtrlPartCodePublisherImpl
{
	private static PSPreviewLogicMethod psPreviewLogicMethod = new PSPreviewLogicMethod();
	private static PSPreviewLogicNodeMethod psPreviewLogicNodeMethod = new PSPreviewLogicNodeMethod();
	private static PSPreviewPanelItemLogicMethod psPreviewPanelItemLogicMethod = new PSPreviewPanelItemLogicMethod();
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		params.put("srfpanellogic", psPreviewLogicMethod);
		params.put("srflogicnode", psPreviewLogicNodeMethod);
		params.put("srfpanelitemlogic", psPreviewPanelItemLogicMethod);
		PSPreviewTemplHelper.fillParams(params);
	}
}
