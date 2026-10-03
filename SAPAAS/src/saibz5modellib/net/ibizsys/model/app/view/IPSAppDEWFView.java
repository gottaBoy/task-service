package net.ibizsys.model.app.view;

import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflow;

/**
 * 应用实体流程视图对象接口
 * @author lionlau
 *
 */
public interface IPSAppDEWFView extends IPSAppDEView
{
	/**
	 * 获取流程实体
	 * @return
	 */
	IPSDEWF getPSDEWF();
	
	
	
	/**
	 * 获取流程版本对象
	 * @return
	 */
	IPSWFVersion getPSWFVersion();
	
	
	/**
	 * 获取工作流
	 * @return
	 */
	IPSWorkflow getPSWorkflow();
	
	
	
	/**
	 * 是否为流程交互模式
	 * @return
	 */
	boolean isWFIAMode();
	
	
}
