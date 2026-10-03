package net.ibizsys.model.dataentity.wizard;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;


/**
 * 实体向导表单对象接口
 * @author lionlau
 *
 */
public interface IPSDEWizardForm extends IPSModelObject
{
	/**
	*	支持步骤：上一步
	*/
	public final static String STEPACTION_PREV = "PREV" ;

	/**
	*	支持步骤：下一步
	*/
	public final static String STEPACTION_NEXT = "NEXT" ;

	/**
	*	支持步骤：完成
	*/
	public final static String STEPACTION_FINISH = "FINISH" ;
	
	

	
	/**
	 * 获取实体向导对象
	 * @return
	 */
	IPSDEWizard getPSDEWizard();
	
	
	/**
	 * 获取实体向导步骤
	 * @return
	 */
	IPSDEWizardStep getPSDEWizardStep();
	
	
	
	/**
	 * 获取表单标识
	 * @return
	 */
	String getFormTag();
	
	
	/**
	 * 获取加载实体行为
	 * @return
	 */
	IPSDEAction getLoadPSDEAction();

	
	
	/**
	 * 获取保存实体行为
	 * @return
	 */
	IPSDEAction getSavePSDEAction();
	
	
	
	/**
	 * 获取步骤操作，支持步骤参考 SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardForm.STEPACTIONS_XXX
	 * @return
	 */
	String [] getStepActions();
	
	
	/**
	 * 是否为默认表单
	 * @return
	 */
	boolean isFirstForm();
	
	
	
	/**
	 * 获取实体表单标识
	 * @return
	 */
	String getPSDEFormId();
	
	/**
	 * 获取实体表单名称
	 * @return
	 */
	String getPSDEFormName();
}
