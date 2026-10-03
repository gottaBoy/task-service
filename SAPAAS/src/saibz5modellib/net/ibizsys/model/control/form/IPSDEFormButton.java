package net.ibizsys.model.control.form;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.wf.uiaction.IPSWFUIAction;

/**
 * 表单按钮部件对象接口
 * @author Administrator
 *
 */
public interface IPSDEFormButton extends IPSDEFormDetail
{
	/**
	 * 处理类型：界面行为
	 */
	final static String ACTIONTYPE_UIACTION = "UIACTION";
	
	
	/**
	 * 处理类型：表单项更新 
	 */
	final static String ACTIONTYPE_FIUPDATE = "FIUPDATE";
	

	/**
	 * 获取按钮行为类型，值参考 SA.SRFDA.PS.Core.Control.Form.IPSDEFormButton.ACTIONTYPE_XXX 定义
	 * @return
	 */
	String getActionType();
	
	/**
	 * 获取界面行为标识
	 * @return
	 */
	String getPSUIActionId();
	
	/**
	 * 获取界面行为对象
	 * @return
	 */
	IPSUIAction getPSUIAction();
	
	
	/**
	 * 获取实体界面行为对象
	 * @return
	 */
	IPSDEUIAction getPSDEUIAction();
	
	
	/**
	 * 获取工作流界面行为对象
	 * @return
	 */
	IPSWFUIAction getPSWFUIAction();
	
	/**
	 * 获取对应的表单项更新标识
	 * @return
	 */
	String getPSDEFIUpdateId();
	
	/**
	 * 获取表单项更新对象
	 * @return
	 */
	IPSDEFormItemUpdate getPSDEFormItemUpdate();
	
	
	
	
	/**
	 * 获取按钮提示
	 * @return
	 */
	String getTooltip();
	
	
	
	
	/**
	 * 获取附加参数选择视图对象
	 * @return
	 * @throws Exception
	 */
	IPSAppView getParamPickupPSAppView() throws Exception;
	
	

	
}
