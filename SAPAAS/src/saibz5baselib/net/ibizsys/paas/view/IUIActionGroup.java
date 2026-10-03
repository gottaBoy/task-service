package net.ibizsys.paas.view;

import net.ibizsys.paas.core.IModelBase;

/**
 * 界面行为组对象接口
 * @author Administrator
 *
 */
public interface IUIActionGroup extends IModelBase {

	/**
	 * 获取成员集合
	 * @return
	 */
	java.util.Iterator<IUIActionGroupDetail> getDetails();
}
