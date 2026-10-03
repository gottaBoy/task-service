
package net.ibizsys.pswf.core;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;

/**
 * 流程服务接口
 * @author lionlau
 *
 */
public interface IWFService
{
	/**
	 * 流程跳转操作
	 */
	public static final String CONNECTION_IAGOTO = "SRFWFIAGOTO";

	/**
	 * 流程超时操作
	 */
	public static final String CONNECTION_TIMEOUT = "SRFWFTIMEOUT";
	
	/**
	 * 重新指派操作
	 */
	public static final String CONNECTION_WFRESUBMIT = "SRFWFRESUBMIT";
	
	
	/**
	 * 初始化流程服务
	 * @param iWFModel
	 * @throws Exception
	 */
	void init(IWFModel iWFModel)throws Exception;
	
	

	/**
	 * 启动一个新流程
	 * @param wfParam
	 * @return
	 * @throws Exception
	 */
	WFActionResult start(WFActionParam wfParam)throws Exception;
	
	
	/**
	 * 提交交互性处理
	 * @param wfParam
	 * @return
	 */
	WFActionResult submit(WFActionParam wfParam)throws Exception;
	
	
	
	
	/**
	 * 用户关闭当前实例
	 * @param wfParam
	 * @return
	 */
	WFActionResult close(WFActionParam wfParam)throws Exception;
	
	
	
	
	/**
	 * 重新启动流程
	 * @param wfParam
	 * @return
	 */
	WFActionResult restart(WFActionParam wfParam)throws Exception;
	
	
	
	/**
	 * 提交嵌入流程
	 * @param wpParam
	 * @param strWFInstanceId
	 * @param dataEntity
	 * @param bNormalClose
	 * @return
	 * @throws Exception
	 */
	WFActionResult submitEmbedWorkflow(WFActionParam wpParam, WFInstance childWfInstance, IEntity dataEntity, boolean bNormalClose) throws Exception;
	
	
	
	
	
	/**
	 * 撤销上一次操作
	 * @param wpParam
	 */
	WFActionResult rollbackIAAction(WFActionParam wpParam) throws Exception;
	
	
	
	/**
	 * 超时当前的交互操作
	 * @param wpParam
	 * @return
	 */
	WFActionResult timeoutIAAction(WFActionParam wpParam)throws Exception;
	
	
	
	
	/**
	 * 标记数据读取标志
	 * 
	 * @param wpParam
	 * @return
	 */
	WFActionResult markReadFlag(WFActionParam wpParam)throws Exception;
}
