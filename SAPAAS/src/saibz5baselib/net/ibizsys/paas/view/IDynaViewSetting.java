package net.ibizsys.paas.view;

import net.ibizsys.paas.core.IModelBase3;

/**
 * 动态视图设置对象接口
 * @author Administrator
 *
 */
public interface IDynaViewSetting extends IModelBase3 {

	/**
	 * 获取动态视图实体名称
	 * @return
	 */
	String getDynaViewDEName();
	
	
	/**
	 * 获取动态视图实例实体名称
	 * @return
	 */
	String getDynaViewInstDEName();
}
