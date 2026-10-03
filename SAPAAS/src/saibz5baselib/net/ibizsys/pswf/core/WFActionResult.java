package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.CallResult;


/**
 * 工作流交互结果对象
 * @author lionlau
 *
 */
public class WFActionResult extends CallResult
{
	private String strInstanceId = null;
	private String strReturnInfo = null;
	private String strExitStateValue = null;
	
	/**
	 * 获取当前流程实例标识
	 * @return the strInstanceId
	 */
	public String getInstanceId()
	{
		return strInstanceId;
	}

	/**
	 * 设置当前流程实例标识
	 * @param strInstanceId the strInstanceId to set
	 */
	public void setInstanceId(String strInstanceId)
	{
		this.strInstanceId = strInstanceId;
	}

	/**
	 * 获取当前处理信息
	 * @return the strReturnInfo
	 */
	public String getReturnInfo()
	{
		return strReturnInfo;
	}

	/**
	 * 设置当前处理信息
	 * @param strReturnInfo the strReturnInfo to set
	 */
	public void setReturnInfo(String strReturnInfo)
	{
		this.strReturnInfo = strReturnInfo;
	}
	
	/**
	 * 获取流程完成状态信息
	 * @return
	 */
	public String getExitStateValue() {
		return strExitStateValue;
	}

	/**
	 * 设置流程完成状态信息
	 * @param strExitStateValue
	 */
	public void setExitStateValue(String strExitStateValue) {
		this.strExitStateValue = strExitStateValue;
	}

	
	
}
