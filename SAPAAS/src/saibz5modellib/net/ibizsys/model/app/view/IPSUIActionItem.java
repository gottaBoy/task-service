package net.ibizsys.model.app.view;

import net.ibizsys.model.view.IPSUIAction;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 界面行为项对象接口
 * @author lionlau
 *
 */
public interface IPSUIActionItem 
{
	/**
	 * 获取界面行为对象
	 * @return
	 */
	IPSUIAction getPSUIAction();
	
	
	/**
	 * 获取当前视图对象
	 * @return
	 */
	IPSAppView getPSAppView();
	
	
	
	/**
	 * 获取实体界面行为Json参数对象
	 * @return
	 */
	ObjectNode getUIActionParamJO();
}
