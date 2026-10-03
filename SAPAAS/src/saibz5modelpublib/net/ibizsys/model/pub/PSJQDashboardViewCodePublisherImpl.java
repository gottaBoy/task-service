package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.control.dashboard.IPSDashboard;

/**
 * 数据看版
 * @author lionlau
 *
 */
public class PSJQDashboardViewCodePublisherImpl extends PSJQCtrlCodePublisherImpl
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
		

	}

	
}
