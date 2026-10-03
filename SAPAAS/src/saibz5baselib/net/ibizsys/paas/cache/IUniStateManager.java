package net.ibizsys.paas.cache;

import net.ibizsys.paas.entity.IEntity;

/**
 * 系统统一状态管理器对象接口
 * @author Administrator
 *
 */
public interface IUniStateManager {
	
	/**
	 * 注册统一状态
	 * @param iUniState
	 * @throws Exception
	 */
	void regUniState(IUniState iUniState)throws Exception;
	
	
	
	
	/**
	 * 注销统一状态
	 * @param iUniState
	 * @throws Exception
	 */
	void unregUniState(IUniState iUniState)throws Exception;
	
	
	
	
	/**
	 * 是否注册指定统一状态
	 * @param iUniState
	 * @return
	 * @throws Exception
	 */
	boolean containsUniState(IUniState iUniState)throws Exception;
	
	
	
	
	/**
	 * 获取指定数据对象
	 * @param iUniState
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	boolean getEntity(IUniState iUniState,IEntity iEntity)throws Exception;
	
	
	
	/**
	 * 获取指定数据对象
	 * @param iUniState
	 * @param iEntity
	 * @param bForceUpdate 强制重新更新
	 * @return
	 * @throws Exception
	 */
	boolean getEntity(IUniState iUniState,IEntity iEntity,boolean bForceUpdate)throws Exception;
	
	
	
	

	/**
	 * 获取指定数据相应状态值
	 * @param iUniState
	 * @param objKey
	 * @param strStateField
	 * @return
	 * @throws Exception
	 */
	Object getEntityState(IUniState iUniState,Object objKey,String strStateField)throws Exception;
	
	

	/**
	 * 获取指定数据相应状态值
	 * @param iUniState
	 * @param objKey
	 * @param strStateField
	 * @param bForceUpdate 强制重新更新
	 * @return
	 * @throws Exception
	 */
	Object getEntityState(IUniState iUniState,Object objKey,String strStateField,boolean bForceUpdate)throws Exception;
	
	
	
	
	
	
	/**
	 * 是否存在指定数据对象
	 * @param iUniState
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	boolean containsEntity(IUniState iUniState,IEntity iEntity)throws Exception;
	
	
	/**
	 * 是否存在指定数据对象
	 * @param iUniState
	 * @param objKey
	 * @return
	 * @throws Exception
	 */
	boolean containsEntity(IUniState iUniState,Object objKey)throws Exception;
	
	
	
	/**
	 * 移除指定数据对象
	 * @param iUniState
	 * @param iEntity
	 * @throws Exception
	 */
	void removeEntity(IUniState iUniState,IEntity iEntity)throws Exception;
	
	
	
	/**
	 * 移除指定数据对象
	 * @param iUniState
	 * @param objKey
	 * @throws Exception
	 */
	void removeEntity(IUniState iUniState,Object objKey)throws Exception;
	
	/**
	 * 更新指定数据对象
	 * @param iUniState
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	void updateEntity(IUniState iUniState,IEntity iEntity)throws Exception;
}
