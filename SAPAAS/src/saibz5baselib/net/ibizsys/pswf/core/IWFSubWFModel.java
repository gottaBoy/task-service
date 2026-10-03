package net.ibizsys.pswf.core;

/**
 * 流程子流程模型接口
 * @author lionlau
 *
 */
public interface IWFSubWFModel
{
	/**
	 * 获取子流程标识
	 * @return
	 */
	String getId();
	
	
	/**
	 * 获取子流程名称 
	 * @return
	 */
	String getName();
	
	/**
	 * 获取子流程编号
	 * @return
	 */
	String getWorkflowId();
}
