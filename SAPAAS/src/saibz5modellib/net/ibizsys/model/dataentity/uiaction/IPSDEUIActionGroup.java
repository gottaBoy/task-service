package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.view.IPSUIActionGroup;


/**
 * 实体界面行为组接口对象
 * 
 * @author lionlau
 *
 */
public interface IPSDEUIActionGroup extends IPSDataEntityObject, IPSUIActionGroup, IPSSystemObject {
	
	/**
	 * 获取实体界面行为集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSDEUIAction> getPSDEUIActions();

	/**
	 * 获取界面行为组成员集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSDEUIActionGroupDetail> getPSDEUIActionGroupDetails();
}
