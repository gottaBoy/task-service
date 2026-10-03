package net.ibizsys.pswf.core;

/**
 * 工作流引擎接口2，提供挂起及继续流程等功能
 * @author Administrator
 *
 */
public interface IWFService2 extends IWFService{

	/**
	 * 挂起指定流程
	 * 
	 * @param wpParam
	 * @return
	 */
	WFActionResult suspend(WFActionParam wpParam)throws Exception;
	
	
	/**
	 * 继续执行指定流程
	 * 
	 * @param wpParam
	 * @return
	 */
	WFActionResult resume(WFActionParam wpParam)throws Exception;
	
}
