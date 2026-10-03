package net.ibizsys.pswf.core;

/**
 * 工作流引擎接口3，提供使用代理流程系统能力
 * @author Administrator
 *
 */
public interface IWFService3 extends IWFService{

	/**
	 * 获取指定流程实例信息
	 * @param wfParam
	 * @return
	 * @throws Exception
	 */
	WFActionResult getInstance(WFActionParam wfParam)throws Exception;
	
}
