package net.ibizsys.model.app.view;

import net.ibizsys.model.wf.IPSWFInteractiveProcess;

/**
 * 应用实体工作流操作处理视图对象接口
 * @author lionlau
 *
 */
public interface IPSAppDEWFActionView extends IPSAppDEWFView
{
	/**
	 * 获取当前的流程步骤值
	 * @return
	 */
	String getWFStepValue();
	
	
	/**
	 * 获取工作流交互处理对象
	 * @return
	 */
	IPSWFInteractiveProcess getPSWFInteractiveProcess();
}
