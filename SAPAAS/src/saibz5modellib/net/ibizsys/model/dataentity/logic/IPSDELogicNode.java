package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.wf.IPSWorkflow;

/**
 * 实体逻辑节点对象接口
 * @author lionlau
 *
 */
public interface IPSDELogicNode extends IPSModelObject
{



	
	
	/**
	 * 获取逻辑连接集合
	 * @return
	 */
	java.util.Iterator<IPSDELogicLink> getPSDELogicLinks();
	
	
	
	
	/**
	 * 获取逻辑处理节点参数集合
	 * @return
	 */
	java.util.Iterator<IPSDELogicNodeParam> getPSDELogicNodeParams();
	
	
	/**
	 * 获取逻辑节点类型
	 * @return
	 */
	String getLogicNodeType();
	
	
	
	
	/**
	 * 获取实体逻辑对象
	 * @return
	 */
	IPSDELogic getPSDELogic();
	
	
	
	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getCodeName();
	
	
	
	
	/**
	 * 是否为并行输出
	 * @return
	 */
	boolean isParallelOutput();
	
	
	
	
	/**
	 * 获取目标实体
	 * @return
	 */
	IPSDataEntity getDstPSDataEntity() throws Exception;
	
	
	/**
	 * 获取目标行为
	 * @return
	 */
	IPSDEAction getDstPSDEAction() throws Exception;
	
	
	
	/**
	 * 获取目标参数
	 * @return
	 */
	IPSDELogicParam getDstPSDELogicParam() throws Exception;
	
	
	
	
	/**
	 * 获取参数值
	 * @param strParamName
	 * @param objDefault
	 * @return
	 */
	Object getParam(String strParamName,Object objDefault);
	
	
	
	/**
	 * 获取源参数
	 * @return
	 */
	IPSDELogicParam getSrcPSDELogicParam() throws Exception;
	
	
	/**
	 * 获取工作流对象 
	 * @return
	 * @throws Exception
	 */
	IPSWorkflow getPSWorkflow()throws Exception;
	
	
	
	/**
	 * 获取实体工作流配置
	 * @return
	 * @throws Exception
	 */
	IPSDEWF getPSDEWF()throws Exception;
	
	
//	/**
//	 * 获取系统逻辑对象
//	 * @return
//	 * @throws Exception
//	 */
//	IPSSysLogic getPSSysLogic()throws Exception;
//	
//	
//	
//	
//	
//	
//	/**
//	 * 获取系统后台服务插件
//	 * @return
//	 */
//	IPSSysSFPlugin getPSSysSFPlugin();
}
