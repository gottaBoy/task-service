package net.ibizsys.paas.core;

import net.ibizsys.paas.view.IUIAction;

/**
 * 实体界面行为接口
 * 
 * @author lionlau
 *
 */
public interface IDEUIAction extends IDataEntityObject,IUIAction {
	/**
	 * 单数据
	 */
	public final String ACTIONTARGET_SINGLEDATA = "SINGLEDATA";

	/**
	 * 单数据主键
	 */
	public final String ACTIONTARGET_SINGLEKEY = "SINGLEKEY";

	/**
	 * 多数据
	 */
	public final String ACTIONTARGET_MULTIDATA = "MULTIDATA";

	/**
	 * 多数据主键
	 */
	public final String ACTIONTARGET_MULTIKEY = "MULTIKEY";

	/**
	 * 无数据
	 */
	public final String ACTIONTARGET_NONE = "NONE";

	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	void init(IDataEntity iDataEntity) throws Exception;

	/**
	 * 获取数据操作目标
	 * 
	 * @return
	 */
	String getActionTarget();

	/**
	 * 获取是否重新加载数据
	 * 
	 * @return
	 */
	boolean isReloadData();

	/**
	 * 获取操作完成提示信息
	 * 
	 * @return
	 */
	String getSuccessMsg();

	/**
	 * 获取数据范围行为
	 * 
	 * @return
	 */
	String getDataAccessAction();

	/**
	 * 关闭编辑视图
	 * 
	 * @return
	 */
	boolean isCloseEditView();
	
	
	
	/**
	 * 是否为全局的界面行为，全局界面行为支持跨实体调用
	 * @return
	 */
	boolean isGlobalUIAction();
}
