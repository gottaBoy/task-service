package net.ibizsys.paas.entity;

/**
 * 数据对象操作辅助对象接口
 * @author Administrator
 *
 */
public interface IEntityActionHelper {
	
	/**
	 * 建立数据对象
	 * @param iEntity
	 * @throws Exception
	 */
	void create(IEntity iEntity)throws Exception;

	
	
	
	/**
	 * 更新数据对象
	 * @param iEntity
	 * @throws Exception
	 */
	void update(IEntity iEntity)throws Exception;
	
	
	
	
	
	/**
	 * 保存数据对象
	 * @param iEntity
	 * @throws Exception
	 */
	void save(IEntity iEntity)throws Exception;
	
	
	
	
	/**
	 * 删除数据对象
	 * @param iEntity
	 * @throws Exception
	 */
	void remove(IEntity iEntity)throws Exception;
	
	
	
	
	/**
	 * 获取数据对象
	 * @param iEntity
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	boolean get(IEntity iEntity,boolean bTryMode)throws Exception;
	
	
	
	/**
	 * 选择数据对象
	 * @param iEntity
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	boolean select(IEntity iEntity,boolean bTryMode)throws Exception;
	
	
}
