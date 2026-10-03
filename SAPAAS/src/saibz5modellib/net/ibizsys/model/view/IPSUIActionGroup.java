package net.ibizsys.model.view;

import net.ibizsys.model.core.IPSModelObject;


/**
 * 界面行为组对象接口
 * @author lionlau
 *
 */
public interface IPSUIActionGroup extends IPSModelObject
{
	/**
	 * 获取界面行为集合
	 * @return
	 */
	java.util.Iterator<IPSUIAction> getPSUIActions();
	
	
	/**
	 * 获取界面行为组成员集合
	 * @return
	 */
	java.util.Iterator<IPSUIActionGroupDetail> getPSUIActionGroupDetails();
}
