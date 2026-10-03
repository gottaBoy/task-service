package net.ibizsys.model.pub.vuemob;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.control.dashboard.IPSDashboard;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlCodePublisher;

/**
 * 部件代码
 * @author lionlau
 *
 */
public class PSVueMobDashboardPartVCPublisherImpl extends PSVueMobCtrlPartCodePublisherImpl
{
	public final static String CTRLPART_PART = "PART";

	
	protected IPSDashboard iPSDashboard = null;
	protected IPSDBPortletPart iPSPortlet = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception
	{
		iPSDashboard = (IPSDashboard)iPSControl;
		iPSPortlet = (IPSDBPortletPart)object;
		return super.generateCode(iPSControl, object);
	}
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		//部件
		IPSControl contentPSControl = iPSPortlet.getContentPSControl();
		if(contentPSControl!=null)
		{
			IPSPFCtrlTempl iPSPFCtrlTempl = iPSPFStyle.getPSPFCtrlTempl(contentPSControl.getPSControlType(), this.getPSPFPubCode());
			if(iPSPFCtrlTempl!=null)
			{
				IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(contentPSControl);
				if(iPSGenerateCodeResult!=null)
				{
					params.put("content", iPSGenerateCodeResult);
				}
			}
		}
		
		if(true)
		{
			IPSPFCtrlTempl iPSPFCtrlTempl = iPSPFStyle.getPSPFCtrlTempl(iPSPortlet.getPSControlType(), this.getPSPFPubCode());
			if(iPSPFCtrlTempl!=null)
			{
				IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(iPSPortlet);
				if(iPSGenerateCodeResult!=null)
				{
					params.put("portlet", iPSGenerateCodeResult);
				}
			}
		}
//		if(true)
//		{
//			ArrayList<IPSGenerateCodeResult> psGenerateCodeResultList = new ArrayList<IPSGenerateCodeResult> ();
//			java.util.Iterator<IPSControl> psControls = iPSPortlet.getPSControls();
//			//找到对应的发布器
//			while(psControls.hasNext())
//			{
//				IPSControl iPSControl = psControls.next();
//				IPSPFCtrlTempl iPSPFCtrlTempl = iPSPFStyle.getPSPFCtrlTempl(iPSControl, this.getPSPFPubCode());
//				if(iPSPFCtrlTempl==null)
//					continue;
//				
//				IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
//				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(iPSControl);
//				if(iPSGenerateCodeResult!=null)
//				{
//					params.put(iPSControl.getName(), iPSGenerateCodeResult);
//					psGenerateCodeResultList.add(iPSGenerateCodeResult);
//				}
//				
//				iPSPFCtrlCodePublisher.close();
//			}
//		}
		
	}
	



	
	
}
