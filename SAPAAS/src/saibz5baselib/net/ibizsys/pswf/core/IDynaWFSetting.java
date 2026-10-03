package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.IModelBase3;

/**
 * 动态工作流设置对象接口
 * @author Administrator
 *
 */
public interface IDynaWFSetting extends IModelBase3{
	
	/**
	 * 获取工作流实体名称
	 * @return
	 */
	String getWFDEName();
	
	
	
	/**
	 * 获取工作流版本实体名称
	 * @return
	 */
	String getWFVersionDEName();
}
