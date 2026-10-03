package net.ibizsys.paas.view;

/**
 * 后台界面行为
 * @author Administrator
 *
 */
public interface IDynaBackendUIAction extends IUIAction {
	
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
	 * 获取数据访问行为
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
}
