package net.ibizsys.paas.view;

import net.ibizsys.paas.core.IModelBase;
import net.sf.json.JSONObject;

/**
 * 界面行为组成员对象接口
 * @author Administrator
 *
 */
public interface IUIActionGroupDetail extends IModelBase  {

	/**
	 * 获取界面行为对象
	 * @return
	 */
	IUIAction getUIAction();
	
	
	/**
	 * 获取界面行为参数
	 * @return
	 */
	JSONObject getUIActionParam();
}
