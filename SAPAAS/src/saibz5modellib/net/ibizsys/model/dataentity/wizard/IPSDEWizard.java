package net.ibizsys.model.dataentity.wizard;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;


/**
 * 实体向导对象接口
 * @author lionlau
 *
 */
public interface IPSDEWizard extends IPSDataEntityObject
{
	
	/**
	 * 获取向导步骤集合
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEWizardStep> getPSDEWizardSteps();
	
	
	
	/**
	 * 获取指定向导步骤
	 * @param strPSDEWizardStepId
	 * @return
	 * @throws Exception
	 */
	IPSDEWizardStep getPSDEWizardStep(String strPSDEWizardStepId) throws Exception;
	
	
	/**
	 * 获取向导表单集合
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEWizardForm> getPSDEWizardForms();
	
	
	
	
	/**
	 * 获取代码名称 
	 * @return
	 */
	String getCodeName();
	
	
	
	/**
	 * 获取初始化实体行为
	 * @return
	 */
	IPSDEAction getInitPSDEAction();
	
	
	/**
	 * 获取完成实体行为
	 * @return
	 */
	IPSDEAction getFinishPSDEAction();
	
	
	/**
	 * 获取上一步标题
	 * @return
	 */
	String getPrevCaption();
	
	
	/**
	 * 获取下一步标题
	 * @return
	 */
	String getNextCaption();
	
	
	/**
	 * 获取完成标题
	 * @return
	 */
	String getFinishCaption();
	
	
	
//	/**
//	 * 获取上一步标题语言资源
//	 * @return
//	 */
//	IPSLanguageRes getPrevCapPSLanguageRes();
//	
//	
//	
//	/**
//	 * 获取下一步标题语言资源
//	 * @return
//	 */
//	IPSLanguageRes getNextCapPSLanguageRes();
	
//	
//	/**
//	 * 获取完成标题语言资源
//	 * @return
//	 */
//	IPSLanguageRes getFinishCapPSLanguageRes();
	
	
	/**
	 * 获取上一步标题语言资源标识
	 * @return
	 */
	String getPrevCapLanResTag();
	
	
	
	/**
	 * 获取下一步标题语言资源标识
	 * @return
	 */
	String getNextCapLanResTag();
	
	
	/**
	 * 获取完成标题语言资源标识
	 * @return
	 */
	String getFinishCapLanResTag();
}
