package net.ibizsys.model.wf;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.wf.uiaction.IPSWFUIAction;
import net.ibizsys.model.wf.uiaction.IPSWFUIActionGroup;
import net.ibizsys.pswf.core.IWFVersionModel;


/**
 * 工作流版本对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSWFVersion extends IPSWorkflowObject, IWFVersionModel,IPSModelObject {
	

	/**
	 * 获取代码名称
	 * 
	 * @return
	 */
	String getCodeName();

	/**
	 * 获取流程版本
	 * 
	 * @return
	 */
	int getWFVersion();

	/**
	 * 获取起始节点
	 * 
	 * @return
	 */
	IPSWFProcess getStartPSWFProcess();

	/**
	 * 获取流程处理节点集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSWFProcess> getPSWFProcesses();

	/**
	 * 获取指定节点
	 * 
	 * @param strPSWFProcessId
	 * @return
	 * @throws Exception
	 */
	IPSWFProcess getPSWFProcess(String strPSWFProcessId, boolean bTryMode) throws Exception;

	/**
	 * 获取流程处理连接集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSWFLink> getPSWFLinks();

	/**
	 * 通过流程步骤值获取处理
	 * 
	 * @param strPSWFProcessId
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IPSWFProcess getPSWFProcessByWFStepValue(String strWFStepValue, boolean bTryMode) throws Exception;

	/**
	 * 获取全部流程界面行为
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSWFUIAction> getAllPSWFUIActions() throws Exception;

	/**
	 * 获取流程界面行为
	 * 
	 * @param strDEUIActionId
	 * @return
	 * @throws Exception
	 */
	IPSWFUIAction getPSWFUIAction(String strDEUIActionId) throws Exception;

	/**
	 * 获取流程界面行为
	 * 
	 * @param strDEUIActionId
	 * @param bTryMode
	 *            尝试模式
	 * @return
	 * @throws Exception
	 */
	IPSWFUIAction getPSWFUIAction(String strDEUIActionId, boolean bTryMode) throws Exception;

	

	/**
	 * 获取流程界面行为组
	 * 
	 * @param strDEUIActionGroupId
	 * @return
	 * @throws Exception
	 */
	IPSWFUIActionGroup getPSWFUIActionGroup(String strDEUIActionGroupId) throws Exception;

	/**
	 * 获取流程界面行为组
	 * 
	 * @param strDEUIActionGroupId
	 * @return
	 * @throws Exception
	 */
	IPSWFUIActionGroup getPSWFUIActionGroup(String strDEUIActionGroupId, boolean bTryMode) throws Exception;

	

	/**
	 * 是否启用
	 * 
	 * @return
	 */
	boolean isValid();
	
	
	/**
	 * 获取工作流界面行为集合
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSWFUIAction> getPSWFUIActions() throws Exception;
	
	
	/**
	 * 获取工作流界面行为组集合
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSWFUIActionGroup> getPSWFUIActionGroups() throws Exception;
	
	
	
	
	/**
	 * 获取流程步骤代码表对象
	 * 
	 * @return
	 */
	IPSCodeList getWFStepPSCodeList();
	
	
	/**
	 * 获取版本
	 * @return
	 */
	int getVersion();
	
}
