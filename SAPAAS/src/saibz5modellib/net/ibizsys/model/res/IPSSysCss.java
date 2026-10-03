package net.ibizsys.model.res;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.core.IPSModelObject;


/**
 * 系统表现样式表对象接口
 * @author lionlau
 *
 */
public interface IPSSysCss extends IPSSystemObject,IPSModelObject
{

	
	
	/**
	 * 获取平台表现样式表模版标识
	 * @return
	 */
	String getPSCssTemplId();
	
	
	
	
	/**
	 * 获取式样名称
	 * @return
	 */
	String getCssName();
	
	

	/**
	 * 获取式样内容
	 * @return
	 */
	String getCssStyle();
	
	
	/**
	 * 获取直接的Css样式
	 * @return
	 */
	String getRawCssStyle();
	
	

}
