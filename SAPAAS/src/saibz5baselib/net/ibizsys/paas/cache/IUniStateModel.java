package net.ibizsys.paas.cache;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;

/**
 * 系统统一状态对象模型
 * @author Administrator
 *
 */
public interface IUniStateModel extends IUniState {
	
	/**
	 * 初始化
	 * @param iSystemModel
	 * @throws Exception
	 */
	void init(ISystemModel iSystemModel)throws Exception;
	
	
	
	
	
	/**
	 * 获取目录属性数组
	 * @return
	 */
	String[] getFolderFields();
	
	
	/**
	 * 获取状态属性数组
	 * @return
	 */
	String[] getStateFields();
	
	
	
	/**
	 * 是否有指定状态数据对象
	 * @param objKey
	 * @return
	 * @throws Exception
	 */
	boolean contains(Object objKey) throws Exception;
	
	
	
	
	/**
	 * 获取状态数据对象
	 * @param objKey
	 * @return
	 * @throws Exception
	 */
	IEntity get(Object objKey) throws Exception;
	
	
	/**
	 * 获取状态数据对象
	 * @param objKey
	 * @param bForceUpdate 强制更新状态
	 * @return
	 * @throws Exception
	 */
	IEntity get(Object objKey,boolean bForceUpdate) throws Exception;
	
	
	/**
	 * 获取指定数据的指定状态属性值
	 * @param objKey
	 * @param strStateField
	 * @return
	 * @throws Exception
	 */
	Object get(Object objKey,String strStateField) throws Exception;
	
	
	/**
	 * 获取指定数据的指定状态属性值
	 * @param objKey
	 * @param strStateField
	 * @param bForceUpdate 强制更新状态
	 * @return
	 * @throws Exception
	 */
	Object get(Object objKey,String strStateField,boolean bForceUpdate) throws Exception;
	
	
	/**
	 * 移除状态数据对象
	 * @param objKey
	 * @throws Exception
	 */
	void remove(Object objKey) throws Exception;
	
	
	
	/**
	 * 更新状态数据对象（写入）
	 * @param objKey
	 * @throws Exception
	 */
	IEntity update(Object objKey) throws Exception; 
	
	
	/**
	 * 更新状态数据对象（写入）
	 * @param iEntity
	 * @throws Exception
	 */
	void update(IEntity iEntity) throws Exception; 
	
	
	
	/**
	 * 是否启用
	 * @return
	 */
	boolean isEnabled();
}
