package net.ibizsys.model.pub.angularga;

import java.util.HashMap;

import net.ibizsys.model.control.dashboard.IPSDBChartPortlet;
import net.ibizsys.model.control.dashboard.IPSDBListPortletPart;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlCodePublisher;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;



/**
 * 门户部件
 * @author lionlau
 *
 */
public class PSAngularPortletViewCodePublisherImpl extends PSAngularCtrlCodePublisherImpl
{             
	protected IPSDBPortletPart iPSPortlet = null;
	//public final static String CTRLPART_STORE = "STORE";
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSPortlet = (IPSDBPortletPart)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		this.iPSPortlet = (IPSDBPortletPart)this.iPSControl;
		
		//输出结果集合代码
		if(this.iPSPortlet instanceof IPSDBChartPortlet)
		{
			IPSDBChartPortlet iPSChartPortlet = (IPSDBChartPortlet)this.iPSPortlet;
			IPSPFCtrlTempl iPSPFCtrlTempl = iPSPFStyle.getPSPFCtrlTempl(iPSChartPortlet.getPSChart().getPSControlType(), this.getPSPFPubCode());
			if(iPSPFCtrlTempl!=null)
			{
				IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(iPSChartPortlet.getPSChart());
				if(iPSGenerateCodeResult!=null)
				{
					params.put("chart", iPSGenerateCodeResult);
				}
			}
		}
		else
		if(this.iPSPortlet instanceof IPSDBListPortletPart)
		{
			IPSDBListPortletPart iPSListPortlet = (IPSDBListPortletPart)this.iPSPortlet;
			IPSPFCtrlTempl iPSPFCtrlTempl = iPSPFStyle.getPSPFCtrlTempl(iPSListPortlet.getPSList().getPSControlType(), this.getPSPFPubCode());
			if(iPSPFCtrlTempl!=null)
			{
				IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(iPSListPortlet.getPSList());
				if(iPSGenerateCodeResult!=null)
				{
					params.put("list", iPSGenerateCodeResult);
				}
			}
		}
		
	}

	

	
}
