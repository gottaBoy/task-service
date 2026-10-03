package net.ibizsys.model.wf.uiaction;

import net.ibizsys.model.view.IPSUIActionGroup;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflowObject;


/**
 * 流程界面行为组对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSWFUIActionGroup extends IPSWorkflowObject, IPSUIActionGroup {
	

	/**
	 * 获取流程版本对象
	 * 
	 * @return
	 */
	IPSWFVersion getPSWFVersion();

	/**
	 * 获取流程界面行为集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSWFUIAction> getPSWFUIActions();
	
	
	
	/**
	 * 获取工作流界面行为组成员集合
	 * @return
	 */
	java.util.Iterator<IPSWFUIActionGroupDetail> getPSWFUIActionGroupDetails();
}
