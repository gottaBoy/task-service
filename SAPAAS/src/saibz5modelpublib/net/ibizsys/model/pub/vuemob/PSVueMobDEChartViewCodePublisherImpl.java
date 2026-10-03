package net.ibizsys.model.pub.vuemob;

import java.util.HashMap;

import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;

/**
 * 实体图表
 * @author hebao
 *
 */
public class PSVueMobDEChartViewCodePublisherImpl extends PSVueMobCtrlCodePublisherImpl
{
	protected IPSDEChart iPSDEChart = null;
	public final static String CTRLPART_STORE = "STORE";
	public final static String CTRLPART_AXES = "AXES";
	public final static String CTRLPART_SERIES = "SERIES";
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl#onGenerateCode()
	 */
	@Override
	protected PSGenerateCodeResultImpl onGenerateCode() throws Exception
	{
		this.iPSDEChart = (IPSDEChart)this.iPSControl;
		return  super.onGenerateCode();
	}

	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.Pub.PSPFViewCodePublisherImpl#onFillGenerateCodeParams(java.util.HashMap)
	 */
	@Override
	protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception
	{
		this.iPSDEChart = (IPSDEChart)this.iPSControl;
		super.onFillGenerateCodeParams(params);
		
		//输出结果集合代码
//		if(true)
//		{
//			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(CTRLPART_STORE).getPSPFCtrlPartCodePublisher();
//			IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEChart, null);
//			iPSPFCtrlPartCodePublisher.close();
//			params.put("store", iPSGenerateCodeResult);
//		}
//		
//		if(true)
//		{
//			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_AXES).getPSPFCtrlPartCodePublisher();
//			ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult> ();
//			java.util.Iterator<IPSDEChartAxes> psDEChartAxeses = 	iPSDEChart.getPSDEChartAxeses();
//			while(psDEChartAxeses.hasNext())
//			{
//				IPSDEChartAxes iPSDEChartAxes = psDEChartAxeses.next();
//					IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEChart, iPSDEChartAxes);
//				gridRecordList.add(iPSGenerateCodeResult);
//			}
//			iPSPFCtrlPartCodePublisher.close();
//			params.put("axeses", gridRecordList);
//		}
//		
//		if(true)
//		{
//			IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_SERIES).getPSPFCtrlPartCodePublisher();
//			ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult> ();
//			java.util.Iterator<IPSDEChartSeries> psDEChartSerieses = 	iPSDEChart.getPSDEChartSerieses();
//			while(psDEChartSerieses.hasNext())
//			{
//				IPSDEChartSeries iPSDEChartSeries = psDEChartSerieses.next();
//				IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(iPSDEChart, iPSDEChartSeries);
//				gridRecordList.add(iPSGenerateCodeResult);
//			}
//			iPSPFCtrlPartCodePublisher.close();
//			params.put("serieses", gridRecordList);
//		}
		
	}

	

	
}
