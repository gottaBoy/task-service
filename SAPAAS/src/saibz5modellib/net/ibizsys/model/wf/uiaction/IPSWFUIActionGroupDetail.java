package net.ibizsys.model.wf.uiaction;

import net.ibizsys.model.view.IPSUIActionGroupDetail;


/**
 * 工作流界面行为组成员接口
 * @author Administrator
 *
 */
public interface IPSWFUIActionGroupDetail extends IPSUIActionGroupDetail {

	

	/**
	 * 获取界面行为组对象
	 * @return
	 */
	IPSWFUIActionGroup getPSWFUIActionGroup();
	
	
	
	/**
	 * 获取实体界面行为对象
	 * @return
	 */
	IPSWFUIAction getPSWFUIAction();
	

}
