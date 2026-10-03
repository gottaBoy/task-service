package net.ibizsys.model.pub.ionic4;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl;

public class PSIonic4CtrlPartCodePublisherImpl extends PSPFCtrlPartCodePublisherImpl
{
	private static PSIonic4LogicMethod psIonic4LogicMethod = new PSIonic4LogicMethod();
	private static PSIonic4LogicNodeMethod psIonic4LogicNodeMethod = new PSIonic4LogicNodeMethod();
	private static PSIonic4PanelItemLogicMethod psIonic4PanelItemLogicMethod = new PSIonic4PanelItemLogicMethod();
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		params.put("srfpanellogic", psIonic4LogicMethod);
		params.put("srflogicnode", psIonic4LogicNodeMethod);
		params.put("srfpanelitemlogic", psIonic4PanelItemLogicMethod);
		PSIonic4TemplHelper.fillParams(params);
	}
}
