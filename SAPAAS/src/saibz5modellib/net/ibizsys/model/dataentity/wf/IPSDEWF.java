package net.ibizsys.model.dataentity.wf;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.paas.core.IDEWF;


/**
 * 实体工作流对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDEWF extends IPSDataEntityObject, IDEWF {
	

	/**
	 * 是否启用
	 * 
	 * @return
	 */
	boolean isValid();

	/**
	 * 获取工作流
	 * 
	 * @return
	 */
	IPSWorkflow getPSWorkflow();

	/**
	 * 获取代码名称
	 * 
	 * @return
	 */
	String getCodeName();

	/**
	 * 获取流程步骤实体属性
	 * 
	 * @return
	 */
	IPSDEField getWFStepPSDEField();

	/**
	 * 获取流程状态实体属性
	 * 
	 * @return
	 */
	IPSDEField getWFStatePSDEField();

	/**
	 * 获取用户状态实体属性
	 * 
	 * @return
	 */
	IPSDEField getUDStatePSDEField();

	/**
	 * 获取流程实例属性
	 * 
	 * @return
	 */
	IPSDEField getWFInstPSDEField();

	/**
	 * 获取流程操作者属性
	 * 
	 * @return
	 */
	IPSDEField getWFActorsPSDEField();

	/**
	 * 获取流程结果属性
	 * 
	 * @return
	 */
	IPSDEField getWFRetPSDEField();

	/**
	 * 获取流程步骤代码表
	 * 
	 * @return
	 */
	IPSCodeList getWFStepPSCodeList() throws Exception;

	/**
	 * 获取业务状态步骤代码表
	 * 
	 * @return
	 */
	IPSCodeList getEntityStatePSCodeList() throws Exception;

	/**
	 * 是否为实体的默认流程
	 * 
	 * @return
	 */
	boolean isDefaultMode();

	/**
	 * 是否支持用户启动
	 * 
	 * @return
	 */
	boolean isEnableUserStart();

	/**
	 * 获取流程初始化的实体行为
	 * 
	 * @return
	 */
	IPSDEAction getInitPSDEAction();

	/**
	 * 获取流程完成的实体行为
	 * 
	 * @return
	 */
	IPSDEAction getFinishPSDEAction();

	/**
	 * 获取流程版本属性
	 * 
	 * @return
	 */
	IPSDEField getWFVerPSDEField();

	/**
	 * 获取流程标识存储属性
	 * 
	 * @return
	 */
	IPSDEField getWorkflowPSDEField();

	/**
	 * 获取我的流程工作标题
	 * 
	 * @return
	 */
	String getMyWFWorkCaption();

	/**
	 * 获取我的流程工作标题语言资源
	 * 
	 * @return
	 */
	IPSLanguageRes getMyWFWorkCapPSLanguageRes();

	/**
	 * 获取我的流程数据标题
	 * 
	 * @return
	 */
	String getMyWFDataCaption();

	/**
	 * 获取我的流程工作标题语言资源
	 * 
	 * @return
	 */
	IPSLanguageRes getMyWFDataCapPSLanguageRes();
	
	
	
	/**
	 * 获取工作流代理模式，值参考 net.ibizsys.model.wf.IPSWorkflow.WFPROXYMODE_XXX 定义
	 * @return
	 */
	int getWFProxyMode();
	
	
	/**
	 * 获取代理模块属性
	 * 
	 * @return
	 */
	IPSDEField getProxyModulePSDEField();
	
	
	/**
	 * 获取代理数据属性
	 * 
	 * @return
	 */
	IPSDEField getProxyDataPSDEField();
		

}
