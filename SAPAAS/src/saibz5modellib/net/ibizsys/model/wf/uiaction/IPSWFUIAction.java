package net.ibizsys.model.wf.uiaction;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflowObject;


/**
 * 工作流界面行为对象接口
 * @author lionlau
 *
 */
public interface IPSWFUIAction extends IPSWorkflowObject,IPSUIAction
{
	final String UIACTIONTYPE_WFUIACTION = "WFUIACTION";
	
	
	
	
	
	/**
	 * 获取工作流版本对象
	 * @return
	 */
	IPSWFVersion getPSWFVersion();
	
	

	/**
	 * 获取前端实体视图
	 * @return
	 */
	String getFrontPSDEViewId();
}
