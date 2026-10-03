package net.ibizsys.model.view;

import net.ibizsys.model.core.IPSModelObject;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 实体界面行为组成员接口
 * @author Administrator
 *
 */
public interface IPSUIActionGroupDetail extends IPSModelObject {
	
	/**
	 * 获取界面行为组对象
	 * @return
	 */
	IPSUIActionGroup getPSUIActionGroup();
	
	
	
	/**
	 * 获取实体界面行为对象
	 * @return
	 */
	IPSUIAction getPSUIAction();
	
	
	/**
	 * 获取界面行为参数Json对象
	 * @return
	 */
	ObjectNode getUIActionParamJO();
	

	
	/**
	 * 获取界面行为参数
	 * @return
	 */
	String getUIActionParam();
	
	
	/**
	 * 是否添加分隔栏
	 * @return
	 */
	boolean isAddSeparator();
}
