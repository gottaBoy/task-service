package net.ibizsys.paas.entity;

/**
 * 数据对象操作支持对象接口
 * @author Administrator
 *
 */
public interface IEntityActionSupporter {
	
	/**
	 * 设置操作辅助对象
	 * @param iEntityActionHelper
	 */
	void setActionHelper(IEntityActionHelper iEntityActionHelper);
	
	
	/**
	 * 获取操作辅助对象
	 * @return
	 */
	IEntityActionHelper getActionHelper();
	
	/**
	 * 建立数据
	 * @throws Exception
	 */
	void create()throws Exception;
	
	
	
	/**
	 * 更新数据
	 * @throws Exception
	 */
	void update()throws Exception;
	
	
	
	
	/**
	 * 删除数据
	 * @throws Exception
	 */
	void remove()throws Exception;
	
	
	
	
	/**
	 * 保存数据
	 * @throws Exception
	 */
	void save()throws Exception;
	
	
	
	
	/**
	 * 获取数据
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	boolean get(boolean bTryMode)throws Exception;
	
	
	
	/**
	 * 获取数据
	 * @return
	 * @throws Exception
	 */
	void get()throws Exception;
	
	
	
	
	/**
	 * 选择数据
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	boolean select(boolean bTryMode)throws Exception;
	
	
	
	/**
	 * 选择数据
	 * @return
	 * @throws Exception
	 */
	void select()throws Exception;
	
	
	
}
