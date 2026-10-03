package net.ibizsys.model.control.form;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.dataentity.dr.IPSDEDRItem;

/**
 * 表单关系界面部件
 * 
 * @author Administrator
 *
 */
public interface IPSDEFormDRUIPart extends IPSDEFormDetail {
	/**
	 * 关系部件刷新关注行为：数据加载
	 */
	public final static int REFRESHACTION_LOAD = 1;

	/**
	 * 关系部件刷新关注行为：数据保存
	 */
	public final static int REFRESHACTION_SAVE = 2;

	/**
	 * 获取实体关系界面项
	 * 
	 * @return
	 */
	IPSDEDRItem getPSDEDRItem();

	/**
	 * 获取关系视图对象
	 * 
	 * @return
	 */
	IPSAppView getPSAppView();

	/**
	 * 获取嵌入视图标识
	 * 
	 * @return
	 */
	String getEmbedViewId();

	/**
	 * 获取额外界面刷新项
	 * 
	 * @return
	 */
	String getRefreshItems();

	/**
	 * 获取对应的表单项更新标识
	 * 
	 * @return
	 */
	String getPSDEFIUpdateId();

	/**
	 * 获取表单更新对象
	 * 
	 * @return
	 * @throws Exception
	 */
	IPSDEFormItemUpdate getPSDEFormItemUpdate() throws Exception;
	
	
	/**
	 * 获取数据刷新监控行为，值参考  SA.SRFDA.PS.Core.Control.Form.IPSDEFormDRUIPart.REFRESHACTION_XXX 定义
	 * @return
	 */
	int getRefreshActions();
	
	
	/**
	 * 判断指定行为是否触发数据刷新
	 * @param nAction
	 * @return
	 */
	boolean isEnableRefreshAction(int nAction);
	
	
	
	/**
	 * 获取传入参数项名称
	 * @return
	 */
	String getParamItem();
	
	
	/**
	 * 是否需要进行保存
	 * @return
	 */
	boolean isNeedSave();
}
