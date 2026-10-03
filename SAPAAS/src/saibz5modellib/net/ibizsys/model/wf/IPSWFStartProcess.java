package net.ibizsys.model.wf;

/**
 * 工作流开始处理对象接口
 * @author Administrator
 *
 */
public interface IPSWFStartProcess extends IPSWFProcess {

	/**
	 * 获取启动流程实体视图标识
	 * @return
	 */
	String getStartPSDEViewId();
	
	

	/**
	 * 获取移动端启动流程实体视图标识
	 * @return
	 */
	String getMobStartPSDEViewId();
	
	
	/**
	 * 获取启动流程实体视图用户数据
	 * @return
	 */
	String getStartPSDEViewUserData();
	
	

	/**
	 * 获取移动端启动流程实体视图用户数据
	 * @return
	 */
	String getMobStartPSDEViewUserData();
}
