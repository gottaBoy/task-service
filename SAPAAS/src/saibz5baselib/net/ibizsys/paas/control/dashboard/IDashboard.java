package net.ibizsys.paas.control.dashboard;

import net.ibizsys.paas.control.IControl;

/**
 * 数据看板部件接口
 * 
 * @author lionlau
 *
 */
public interface IDashboard extends IControl {
	/**
	 * 获取布局列模型
	 * 
	 * @return
	 */
	double[] getColumnModels();

	/**
	 * 获取门户部件集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPortlet> getPortlets();
}
