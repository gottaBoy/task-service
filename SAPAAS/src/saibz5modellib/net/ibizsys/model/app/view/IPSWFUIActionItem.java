package net.ibizsys.model.app.view;

import net.ibizsys.model.wf.uiaction.IPSWFUIAction;


/**
 * 流程界面行为项对象接口
 * @author lionlau
 *
 */
public interface IPSWFUIActionItem extends IPSUIActionItem
{
	/**
	 * 获取
	 * @return
	 */
	IPSWFUIAction getPSWFUIAction();

}
