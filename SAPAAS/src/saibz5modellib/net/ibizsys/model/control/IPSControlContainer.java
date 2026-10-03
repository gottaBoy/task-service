package net.ibizsys.model.control;

import java.util.Iterator;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;

/**
 * 控件容器对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSControlContainer extends IPSModelObject {
	/**
	 * 获取标识
	 * 
	 * @return
	 */
	String getId();

	/**
	 * 获取名称
	 * 
	 * @return
	 */
	String getName();

	/**
	 * 获取应用视图
	 * 
	 * @return
	 */
	IPSAppView getPSAppView();

	/**
	 * 是否有指定控件
	 * 
	 * @param strControlName
	 * @return
	 */
	boolean hasPSControl(String strControlName);

	/**
	 * 获取控件集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSControl> getPSControls();

	/**
	 * 获取指定部件
	 * 
	 * @param strControlName
	 * @return
	 * @throws Exception
	 */
	IPSControl getPSControl(String strControlName) throws Exception;

	/**
	 * 获取异步控件集合
	 * 
	 * @return
	 */
	Iterator<IPSAjaxControl> getPSAjaxControls();

	/* INTERNAL-BEGIN */
	/**
	 * 注册控件
	 * 
	 * @param strKey
	 * @param strPSCtrlType
	 * @param iPSControlParam
	 * @return
	 * @throws Exception
	 */
	IPSControl registerPSControl(String strKey, String strPSCtrlType, IPSControlParam iPSControlParam) throws Exception;
	/* INTERNAL-END */
}
