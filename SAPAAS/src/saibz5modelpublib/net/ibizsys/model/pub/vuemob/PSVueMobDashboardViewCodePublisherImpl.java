package net.ibizsys.model.pub.vuemob;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.control.dashboard.IPSDashboard;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;

/**
 * 数据看版
 * @author hebao
 *
 */
public class PSVueMobDashboardViewCodePublisherImpl extends PSVueMobCtrlCodePublisherImpl
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
				
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDashboard, iPSPortlet);
				gridRecordList.add(iPSGenerateCodeResult);
			}
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
//				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDashboard, iPSPortlet);
//				gridRecordList.add(iPSGenerateCodeResult);
//			}
//			iPSPFCtrlPartCodePublisher.close();
//			params.put("defcontents", gridRecordList);
//		}
	}

	

	
}
