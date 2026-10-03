package net.ibizsys.model.pub.vue2;

import java.util.HashMap;

import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;

/**
 * 实体图表
 * @author lionlau
 *
 */
public class PSVue2DEChartViewCodePublisherImpl extends PSVue2CtrlCodePublisherImpl
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
		super.onFillGenerateCodeParams(params);
		
	
	}

	

}
