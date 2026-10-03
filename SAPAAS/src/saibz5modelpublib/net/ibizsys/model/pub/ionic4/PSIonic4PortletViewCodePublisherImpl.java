package net.ibizsys.model.pub.ionic4;

import java.util.HashMap;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBChartPortlet;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBListPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;



/**
 * 门户部件
 * @author lionlau
 *
 */
public class PSIonic4PortletViewCodePublisherImpl extends PSIonic4CtrlCodePublisherImpl
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
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, iPSChartPortlet.getPSChart());
				if(iPSGenerateCodeResult!=null)
				{
					params.put("chart", iPSGenerateCodeResult);
				}
				iPSPFCtrlCodePublisher.close();
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
				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, iPSListPortlet.getPSList());
				if(iPSGenerateCodeResult!=null)
				{
					params.put("list", iPSGenerateCodeResult);
				}
				iPSPFCtrlCodePublisher.close();
			}
		}
		
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onClose()
	 */
	@Override
	protected void onClose()
	{
		this.iPSPortlet = null;
		super.onClose();
	}
	
}
