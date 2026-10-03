package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.IModelBase;

/**
 * 工作流连接条件模型接口
 * @author Administrator
 *
 */
public interface IWFLinkCondModel extends IModelBase
{
	/**
	 * 分组条件
	 */
	final static String CONDTYPE_GROUP = "GROUP";
	
	
	/**
	 * 单项条件
	 */
	final static String CONDTYPE_SINGLE = "SINGLE";
	
	
	/**
	 * 自定义条件
	 */
	final static String CONDTYPE_CUSTOM = "CUSTOM";
	
	
	
	/**
	 * 获取上级条件标识
	 * @return
	 */
	String getPId();
	
	
	/**
	 * 获取条件类型
	 * @return
	 */
	String getCondType();
}
