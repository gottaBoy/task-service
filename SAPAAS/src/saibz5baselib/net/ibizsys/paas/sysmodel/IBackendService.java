package net.ibizsys.paas.sysmodel;

import net.ibizsys.psrt.srv.common.entity.Service;

/**
 * 后台服务接口
 * 
 * @author Administrator
 *
 */
public interface IBackendService {
	/**
	 * 初始化服务
	 * 
	 * @param service
	 * @param iDAGlobalHelper
	 * @return
	 */
	void init(Service service) throws Exception;

	/**
	 * 退出服务
	 * 
	 * @return
	 */
	void quit() throws Exception;

	/**
	 * 启动服务
	 * 
	 * @return
	 */
	void start() throws Exception;

	/**
	 * 停止服务
	 * 
	 * @return
	 */
	void stop() throws Exception;

	/**
	 * 判断服务是否启动
	 * 
	 * @return
	 */
	boolean isStarted() throws Exception;

	/**
	 * 获取服务编号
	 * 
	 * @return
	 */
	String getServiceId();

	/**
	 * 获取服务名称
	 * 
	 * @return
	 */
	String getServiceName();
}
