package net.ibizsys.model.dynasys;

import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.core.IPSModelObject;

/**
 * 系统动态实例对象接口
 * @author Administrator
 *
 */
public interface IPSDynaInst extends IPSModelObject,IPSSystem {

	/**
	 * 动态实例模式
	 */
	/**
	*默认
	*/
	public final static String INSTMODE_DEFAULT = "DEFAULT" ;

	/**
	*代理模式
	*/
	public final static String INSTMODE_PROXY = "PROXY" ;
	
	
	/**
	 * 获取动态实例模式
	 * @return
	 */
	String getInstMode();
	
	
	/**
	 * 获取动态标记
	 * @return
	 */
	String getDynaTag();
	
	
	
	
}
