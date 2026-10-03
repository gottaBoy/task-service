package net.ibizsys.model.res;

import net.ibizsys.model.IPSSystemObject;


/**
 * 系统语言资源项对象接口
 * @author lionlau
 *
 */
public interface IPSLanguageItem extends IPSSystemObject
{
	
	
	/**
	 * 获取语言资源项
	 * @return
	 */
	IPSLanguageRes getPSLanguageRes();
	
	
	/**
	 * 获取内容
	 * @return
	 */
	String getContent();
}
