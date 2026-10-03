package net.ibizsys.model.pub.vue2;

import java.util.HashMap;

import net.ibizsys.model.pub.PSPFCtrlPartCodePublisherImpl;

/**
 * PreViewPCuery部件成员代码发布器对象
 * @author Administrator
 *
 */
public class PSVue2CtrlPartCodePublisherImpl extends PSPFCtrlPartCodePublisherImpl
{
//	private static PSVue2LogicMethod psVue2LogicMethod = new PSVue2LogicMethod();
//	private static PSVue2LogicNodeMethod psVue2LogicNodeMethod = new PSVue2LogicNodeMethod();
//	private static PSVue2PanelItemLogicMethod psVue2PanelItemLogicMethod = new PSVue2PanelItemLogicMethod();
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
//		params.put("srfpanellogic", psVue2LogicMethod);
//		params.put("srflogicnode", psVue2LogicNodeMethod);
//		params.put("srfpanelitemlogic", psVue2PanelItemLogicMethod);
		PSVue2TemplHelper.fillParams(params);
	}
}
