package net.ibizsys.model.pub.ionic;

import java.util.ArrayList;
import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboard;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;

/**
 * 数据看版
 * @author hebao
 *
 */
public class PSIonicDashboardViewCodePublisherImpl extends PSIonicCtrlCodePublisherImpl
{
	protected IPSDashboard iPSDashboard = null;
	public final static String CTRLPART_PART = "PART";
	public final static String CTRLPART_DEFCONTENT = "DEFCONTENT";
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSDashboard = (IPSDashboard)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		this.iPSDashboard = (IPSDashboard)this.iPSControl;

		//输出结果集合代码
		if(true)
		{
			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_PART).getPSPFCtrlPartCodePublisher();
			ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult> ();
			java.util.Iterator<IPSDBPortletPart> psPortlets = 	iPSDashboard.getPSPortlets();
			while(psPortlets.hasNext())
			{
				IPSDBPortletPart iPSPortlet = psPortlets.next();
				
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext,iPSDashboard, iPSPortlet);
				gridRecordList.add(iPSGenerateCodeResult);
			}
			iPSPFCtrlPartCodePublisher.close();
			params.put("parts", gridRecordList);
		}
		
//		if(true)
//		{
//			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_DEFCONTENT).getPSPFCtrlPartCodePublisher();
//			ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult> ();
//			java.util.Iterator<IPSPortlet> psPortlets = 	iPSDashboard.getPSPortlets();
//			while(psPortlets.hasNext())
//			{
//				IPSPortlet iPSPortlet = psPortlets.next();
//				if(iPSPortlet.getDefaultColId()<0)
//					continue;
//				
//				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSPublisherContext,iPSDashboard, iPSPortlet);
//				gridRecordList.add(iPSGenerateCodeResult);
//			}
//			iPSPFCtrlPartCodePublisher.close();
//			params.put("defcontents", gridRecordList);
//		}
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose()
	{
		this.iPSDashboard = null;
		super.onClose();
	}
	
}
