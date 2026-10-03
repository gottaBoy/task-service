package net.ibizsys.pswf.core;

import net.ibizsys.psrt.srv.wf.entity.WFInstance;

/**
 * 工作流数据访问对象接口2，提供挂起及继续流程实例等功能
 * @author Administrator
 *
 */
public interface IWFDataCtrl2 extends IWFDataCtrl {

	/**
	 * 挂起流程实例
	 * @param iWFActionContext
	 * @param instance
	 * @throws Exception
	 */
	void suspendWFInstance(IWFActionContext2 iWFActionContext,WFInstance instance) throws Exception;
	
	
	/**
	 * 继续流程实例
	 * @param iWFActionContext
	 * @param instance
	 * @throws Exception
	 */
	void resumeWFInstance(IWFActionContext2 iWFActionContext,WFInstance instance) throws Exception;
	
}
