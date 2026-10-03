package net.ibizsys.paas.api;

import net.ibizsys.paas.core.IModelBase2;

/**
 * 服务API的操作接口
 * @author Administrator
 *
 */
public interface IServiceAPIAction extends IModelBase2 {

	/**
	 * 操作类型，实体操作
	 */
	public final static String ACTIONTYPE_DEACTION = "DEACTION";
	
	
	/**
	 * 操作类型，简单查询
	 */
	public final static String ACTIONTYPE_SELECT = "SELECT";
	
	/**
	 * 操作类型，复杂查询
	 */
	public final static String ACTIONTYPE_FETCH = "FETCH";
	
	
	/**
	 * 操作类型，简单查询（针对临时数据）
	 */
	public final static String ACTIONTYPE_SELECTTEMP = "SELECTTEMP";
	
	/**
	 * 操作类型，复杂查询（针对临时数据）
	 */
	public final static String ACTIONTYPE_FETCHTEMP = "FETCHTEMP";
	
	
	/**
	 * 获取行为类型
	 * @return
	 */
	String getActionType();
	
	
	
	/**
	 * 获取操作的唯一标记
	 * @return
	 */
	String getUniqueTag();
	
	
	
	
	/**
	 * 获取实体名称
	 * @return
	 */
	String getDEName();
	
}
