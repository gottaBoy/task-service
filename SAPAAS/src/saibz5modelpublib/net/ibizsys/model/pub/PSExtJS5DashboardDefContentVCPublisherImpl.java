package net.ibizsys.model.pub;

import java.util.HashMap;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.dashboard.IPSDashboard;

public class PSExtJS5DashboardDefContentVCPublisherImpl extends PSExtJS5CtrlPartCodePublisherImpl
{
	
	protected IPSDashboard iPSDashboard = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception
	{
		iPSDashboard = (IPSDashboard)iPSControl;
		return super.generateCode(iPSControl, object);
	}
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
//		if(true)
//		{
//			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_PART).getPSPFCtrlPartCodePublisher();
//			ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult> ();
//			java.util.Iterator<IPSPortlet> psPortlets = 	iPSDashboard.getPSPortlets();
//			while(psPortlets.hasNext())
//			{
//				IPSPortlet iPSPortlet = psPortlets.next();
//				
//				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext,iPSDashboard, iPSPortlet);
//				gridRecordList.add(iPSGenerateCodeResult);
//			}
//			iPSPFCtrlPartCodePublisher.close();
//			params.put("parts", gridRecordList);
//		}
	}
	

	
}
