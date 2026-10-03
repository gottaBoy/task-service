package net.ibizsys.model.pub.ionic4;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboard;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;

/**
 * 部件代码
 * @author lionlau
 *
 */
public class PSIonic4DashboardPartVCPublisherImpl extends PSIonic4CtrlPartCodePublisherImpl
{
	public final static String CTRLPART_PART = "PART";

	
	protected IPSDashboard iPSDashboard = null;
	protected IPSDBPortletPart iPSPortlet = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSPublisherContext iPSPublisherContext, IPSControl iPSControl, Object object) throws Exception
	{
		iPSDashboard = (IPSDashboard)iPSControl;
		iPSPortlet = (IPSDBPortletPart)object;
		return super.generateCode(iPSPublisherContext, iPSControl, object);
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
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, contentPSControl);
				if(iPSGenerateCodeResult!=null)
				{
					params.put("content", iPSGenerateCodeResult);
				}
				iPSPFCtrlCodePublisher.close();
			}
		}
		
		if(true)
		{
			IPSPFCtrlTempl iPSPFCtrlTempl = iPSPFStyle.getPSPFCtrlTempl(iPSPortlet.getPSControlType(), this.getPSPFPubCode());
			if(iPSPFCtrlTempl!=null)
			{
				IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, iPSPortlet);
				if(iPSGenerateCodeResult!=null)
				{
					params.put("portlet", iPSGenerateCodeResult);
				}
				iPSPFCtrlCodePublisher.close();
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
//				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, iPSControl);
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
	

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose()
	{
		this.iPSDashboard= null;
		this.iPSPortlet = null;
		super.onClose();
	}

	
	
}
