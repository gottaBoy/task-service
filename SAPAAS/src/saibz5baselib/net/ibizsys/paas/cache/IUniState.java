package net.ibizsys.paas.cache;

import net.ibizsys.paas.core.IModelBase2;

/**
 * 系统统一状态协同对象接口
 * @author Administrator
 *
 */
public interface IUniState extends IModelBase2 {

	/**
	 * 统一状态类型：实体
	 */
	final static String UNISTATETYPE_DE = "DE"; 
	
	/**
	 * 状态标识
	 */
	final static String STATE = "STATE";
	
	/**
	 * 状态2标识
	 */
	final static String STATE2 = "STATE2";
	
	/**
	 * 状态3标识
	 */
	final static String STATE3 = "STATE3";
	
	/**
	 * 状态4标识
	 */
	final static String STATE4 = "STATE4";
	
	/**
	 * 状态5标识
	 */
	final static String STATE5 = "STATE5";
	
	/**
	 * 状态6标识
	 */
	final static String STATE6 = "STATE6";
	
	/**
	 * 状态7标识
	 */
	final static String STATE7 = "STATE7";
	
	/**
	 * 状态8标识
	 */
	final static String STATE8 = "STATE8";
	
	
	
	/**
	 * 获取唯一业务标识
	 * @return
	 */
	String getUniqueTag();
	
	
	
	/**
	 * 获取相关的实体名称
	 * @return
	 */
	String getDEName();
	
	
	
	
	/**
	 * 获取主键属性
	 * @return
	 */
	String getKeyField();
	
	
	/**
	 * 获取目录属性
	 * @return
	 */
	String getFolderField();
	
	
	
	/**
	 * 获取目录2属性
	 * @return
	 */
	String getFolder2Field();
	
	
	/**
	 * 获取目录3属性
	 * @return
	 */
	String getFolder3Field();
	
	/**
	 * 获取状态属性
	 * @return
	 */
	String getStateField();
	
	
	/**
	 * 获取状态2属性
	 * @return
	 */
	String getState2Field();
	
	
	/**
	 * 获取状态3属性
	 * @return
	 */
	String getState3Field();
	
	
	
	/**
	 * 获取状态4属性
	 * @return
	 */
	String getState4Field();
	
	
	
	
	/**
	 * 获取状态5属性
	 * @return
	 */
	String getState5Field();
	
	
	
	
	/**
	 * 获取状态6属性
	 * @return
	 */
	String getState6Field();
	
	
	
	

	/**
	 * 获取状态7属性
	 * @return
	 */
	String getState7Field();
	
	
	
	

	/**
	 * 获取状态8属性
	 * @return
	 */
	String getState8Field();
	
	
	
	/**
	 * 获取统一状态类型，参考net.ibizsys.paas.cache.IUniState.UNISTATETYPE定义
	 * @return
	 */
	String getUniStateType();
}
