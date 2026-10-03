package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.core.IModelBase;

/**
 * 图表坐标轴接口
 * 
 * @author Administrator
 *
 */
public interface IChartAxisModel extends IModelBase {
	/**
	 * left
	 */
	static String AXISPOS_LEFT = "left";

	/**
	 * bottom
	 */
	static String AXISPOS_BOTTOM = "bottom";

	/**
	 * right
	 */
	static String AXISPOS_RIGHT = "right";

	/**
	 * top
	 */
	static String AXISPOS_TOP = "top";

	/**
	 * radial
	 */
	static String AXISPOS_RADIAL = "radial";

	/**
	 * angular
	 */
	static String AXISPOS_ANGULAR = "angular";

	// 定义类型代码表

	/**
	 * numeric
	 */
	static String AXISTYPE_NUMERIC = "numeric";

	/**
	 * time
	 */
	static String AXISTYPE_TIME = "time";

	/**
	 * category
	 */
	static String AXISTYPE_CATEGORY = "category";

	/**
	 * 获取标题
	 * 
	 * @return
	 */
	String getCaption();

	/**
	 * 获取坐标轴类型
	 * 
	 * @return
	 */
	String getAxisType();

	/**
	 * 获取坐标轴位置
	 * 
	 * @return
	 */
	String getAxisPos();
}
