package net.ibizsys.model.control.expbar;

import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.pswf.control.expbar.IWFExpBar;

/**
 * 工作流导航栏对象接口
 * @author lionlau
 *
 */
public interface IPSWFExpBar extends IPSExpBar,IWFExpBar
{
	/**
	 * 获取工作流对象
	 * @return
	 */
	IPSWorkflow getPSWorkflow();
	
		
	
	/**
	 * 获取流程实体对象
	 * @return
	 */
	IPSDEWF getPSDEWF();
}
