package net.ibizsys.model.control.viewpanel;

import net.ibizsys.model.control.counter.IPSSysCounterRef;

/**
 * 实体分页视图面板对象接口
 * @author Administrator
 *
 */
public interface IPSDETabViewPanel extends IPSDEViewPanel {

	/**
	 * 获取系统计数器引用
	 * @return
	 */
	IPSSysCounterRef getPSSysCounterRef();
	
	
	
	/**
	 * 获取计数标识
	 * @return
	 */
	String getCounterId();
}
