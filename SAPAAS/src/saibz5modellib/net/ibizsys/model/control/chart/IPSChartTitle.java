package net.ibizsys.model.control.chart;


/**
 * 图表标题对象接口
 * @author Administrator
 *
 */
public interface IPSChartTitle extends IPSChartObject
{
	
	/**
	 * 标题位置，上方
	 */
	public final String TITLEPOS_TOP = "TOP";
	
	
	/**
	 * 标题位置，下方
	 */
	public final String TITLEPOS_BOTTOM = "BOTTOM";
	
	
	/**
	 * 标题位置，左侧
	 */
	public final String TITLEPOS_LEFT = "LEFT";
	
	
	/**
	 * 标题位置，右侧
	 */
	public final String TITLEPOS_RIGHT = "RIGHT";
	
	/**
	 * 获取图表标题
	 * @return
	 */
	String getTitle();
	
	
	/**
	 * 获取图表子标题
	 * @return
	 */
	String getSubTitle();
	
	
	/**
	 * 是否显示标题
	 * @return
	 */
	boolean isShowTitle();
	
	
	
//	/**
//	 * 获取标题语言资源对象
//	 * @return
//	 */
//	IPSLanguageRes getTitlePSLanguageRes();
//	
//	
//	
//	
//	/**
//	 * 获取子标题语言资源对象
//	 * @return
//	 */
//	IPSLanguageRes getSubTitlePSLanguageRes();
	
	
	
	/**
	 * 获取标题位置，值参考 IPSChartTitle.TITLEPOS_XXX
	 * @return
	 */
	String getTitlePos();
}
