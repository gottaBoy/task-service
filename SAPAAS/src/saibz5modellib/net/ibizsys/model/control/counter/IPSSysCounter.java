package net.ibizsys.model.control.counter;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.core.IPSModelObject;


/**
 * 系统计数器接口
 * @author lionlau
 *
 */
public interface IPSSysCounter extends IPSSystemObject ,IPSModelObject
{
	
	
	
	/**
	 * 获取类型
	 * @return
	 */
	String getCounterType();
	
	
	
	/**
	 * 获取应用插件类型
	 * @return
	 */
	IPSCounterType getPSCounterType();
		

	
//	/**
//	 * 获取基类名称
//	 * @param strPSSFStyleId
//	 * @return
//	 * @throws Exception
//	 */
//	String getBaseClass(String strPSSFStyleId) throws Exception;
//	
//	
	
	/**
	 * 获取刷新时长
	 * @return
	 */
	int getTimer();
	
	
	
	/**
	 * 获取引用标志
	 * @return
	 */
	boolean getRefFlag();
	
	
//	/**
//	 * 获取系统模块
//	 * @return
//	 */
//	IPSSystemModule getPSSystemModule();
	
	
	/**
	 * 是否为子系统计数器
	 * @return
	 */
	boolean isSubSysCounter();
	
	
	
	/**
	 * 获取计数项集合
	 * @return
	 */
	java.util.Iterator<IPSSysCounterItem> getPSSysCounterItems();
	
	
	
	/**
	 * 获取平台预制计算器
	 * @return
	 */
	IPSCounter getPSCounter();
}
