package net.ibizsys.model.dataentity.dr;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;

/**
 * 实体关系界面分组对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSDEDRGroup extends IPSDataEntityObject {

	

	/**
	 * 获取标题
	 * 
	 * @return
	 */
	String getCaption();

	
	/**
	 * 获取标题
	 * @param strLanguage 指定语言
	 * @return
	 */
	String getCaption(String strLanguage);

	/**
	 * 获取系统图片资源
	 * 
	 * @return
	 */
	IPSSysImage getPSSysImage();

	/**
	 * 获取标题语言资源对象
	 * 
	 * @return
	 */
	IPSLanguageRes getCapPSLanguageRes();

	/**
	 * 是否为隐藏分组
	 * 
	 * @return
	 */
	boolean isHidden();

}
