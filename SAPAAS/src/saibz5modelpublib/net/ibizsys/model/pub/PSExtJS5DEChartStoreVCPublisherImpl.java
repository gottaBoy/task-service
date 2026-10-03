package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.chart.IPSChartDataItem;
import net.ibizsys.model.control.chart.IPSDEChart;

public class PSExtJS5DEChartStoreVCPublisherImpl extends PSExtJS5CtrlPartCodePublisherImpl
{
	public final static String CTRLPART_RECORD = "RECORD";

	
	protected IPSDEChart iPSDEChart = null;
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlPartCodePublisherImpl#generateCode(SA.SRFDA.PS.Core.Pub.IPSPublisherContext, SA.SRFDA.PS.Core.Control.IPSControl, java.lang.Object)
	 */
	@Override
	public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception
	{
		iPSDEChart = (IPSDEChart)iPSControl;
		return super.generateCode( iPSControl, object);
	}
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		super.onFillGenerateCodeParams(params);
		
		if(true)
		{
			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_RECORD).getPSPFCtrlPartCodePublisher();
			ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult> ();
			java.util.Iterator<IPSChartDataItem> psChartDataItems = 	iPSDEChart.getPSChartDataItems();
			if(psChartDataItems!=null){
				while(psChartDataItems.hasNext())
				{
					IPSChartDataItem iPSChartDataItem = psChartDataItems.next();
					
					IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEChart, iPSChartDataItem);
					gridRecordList.add(iPSGenerateCodeResult);
				}
	
			}
			params.put("records", gridRecordList);
		}
		
	}

	

	
	
}
