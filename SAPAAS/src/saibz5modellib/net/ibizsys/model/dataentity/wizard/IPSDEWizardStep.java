package net.ibizsys.model.dataentity.wizard;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;


/**
 * 实体向导步骤对象接口
 * @author lionlau
 *
 */
public interface IPSDEWizardStep extends IPSModelObject
{


	
	/**
	 * 获取实体向导对象
	 * @return
	 */
	IPSDEWizard getPSDEWizard();
	
	
	/**
	 * 获取步骤标识
	 * @return
	 */
	String getStepTag();
	
	
	
	/**
	 * 是否支持直接链接
	 * @return
	 */
	boolean isEnableLink();
	
	
	/**
	 * 获取标题（与名称一致）
	 * @return
	 */
	String getTitle();
	
	
	/**
	 * 获取子标题
	 * @return
	 */
	String getSubTitle();
	
	
	
	/**
	 * 获取标题样式对象
	 * @return
	 */
	IPSSysCss getTitlePSSysCss();
	
	
	
	
	/**
	 * 获取步骤图标对象
	 * @return
	 */
	IPSSysImage getPSSysImage();
	
	
	
//	/**
//	 * 获取标题语言资源对象
//	 * 
//	 * @return
//	 */
//	IPSLanguageRes getTitlePSLanguageRes();
//	
//	
//	
//	/**
//	 * 获取子标题语言资源对象
//	 * 
//	 * @return
//	 */
//	IPSLanguageRes getSubTitlePSLanguageRes();
}
