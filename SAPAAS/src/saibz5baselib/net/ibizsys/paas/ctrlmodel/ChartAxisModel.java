package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.chart.IChart;
import net.ibizsys.paas.core.ModelBaseImpl;

/**
 * 图表坐标轴模型
 * 
 * @author Administrator
 *
 */
public class ChartAxisModel extends ModelBaseImpl implements IChartAxisModel {
	private String strCaption = null;
	private String strAxisType = null;
	private String strAxisPos = null;

	private IChart iChart = null;

	/**
	 * 初始化
	 * 
	 * @param iChart
	 */
	public void init(IChart iChart) {
		this.iChart = iChart;
	}

	/**
	 * 设置图表轴标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置图表轴名称
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	/**
	 * 获取图表轴标题
	 * 
	 * @return the strCaption
	 */
	@Override
	public String getCaption() {
		return strCaption;
	}

	/**
	 * 设置图表轴标题
	 * 
	 * @param strCaption the strCaption to set
	 */
	public void setCaption(String strCaption) {
		this.strCaption = strCaption;
	}

	/**
	 * 获取图表轴类型
	 * 
	 * @return the strAxisType
	 */
	@Override
	public String getAxisType() {
		return strAxisType;
	}

	/**
	 * 设置图表轴类型
	 * 
	 * @param strAxisType the strAxisType to set
	 */
	public void setAxisType(String strAxisType) {
		this.strAxisType = strAxisType;
	}

	/**
	 * 获取图表轴位置
	 * 
	 * @return the strAxisPos
	 */
	@Override
	public String getAxisPos() {
		return strAxisPos;
	}

	/**
	 * 设置图表轴位置
	 * 
	 * @param strAxisPos the strAxisPos to set
	 */
	public void setAxisPos(String strAxisPos) {
		this.strAxisPos = strAxisPos;
	}
}
