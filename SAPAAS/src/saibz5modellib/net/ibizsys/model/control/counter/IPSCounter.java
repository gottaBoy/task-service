package net.ibizsys.model.control.counter;

import net.ibizsys.model.core.IPSModelObject;


/**
 *  平台预置计数器对象接口
 * @author lionlau
 *
 */
public interface IPSCounter extends IPSModelObject 
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
		
	
	
	
	/**
	 * 获取基类名称
	 * @param strPSSFStyleId
	 * @return
	 * @throws Exception
	 */
	String getBaseClass(String strPSSFStyleId) throws Exception;
	
	
	
	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getCodeName();
	
	

}
