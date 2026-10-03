package net.ibizsys.model.control.chart;


/**
 * 图表图例对象接口
 * @author Administrator
 *
 */
public interface IPSChartLegend extends IPSChartObject
{
	
	/**
	 * 图例位置，上方
	 */
	public final String LEGENDPOS_TOP = "TOP";
	
	
	/**
	 * 图例位置，下方
	 */
	public final String LEGENDPOS_BOTTOM = "BOTTOM";
	
	
	/**
	 * 图例位置，左侧
	 */
	public final String LEGENDPOS_LEFT = "LEFT";
	
	
	/**
	 * 图例位置，右侧
	 */
	public final String LEGENDPOS_RIGHT = "RIGHT";
	

	
	/**
	 * 是否显示图例
	 * @return
	 */
	boolean isShowLegend();
	
	
	
	/**
	 * 获取图例位置，值参考
	 * @return
	 */
	String getLegendPos();
}
