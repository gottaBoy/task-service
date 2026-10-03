package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.codelist.ServiceRunStateCodeListModel;
import net.ibizsys.psrt.srv.common.entity.Service;
import net.ibizsys.psrt.srv.common.service.ServiceService;

/**
 * 后台服务管理对象
 * 
 * @author Administrator
 *
 */
public class BackendServiceMgr {
	private static BackendServiceMgr curBackendServiceMgr = null;

	private HashMap<String, IBackendService> backendServiceMap = new HashMap<String, IBackendService>();

	private static final Log log = LogFactory.getLog(BackendServiceMgr.class);

	private String strServiceContainerId = "";

	public void init(String strServiceContainerId) throws Exception {
		this.strServiceContainerId = strServiceContainerId;
		this.onInit();
	}

	/**
	 * 获取服务容器标识
	 * 
	 * @return
	 */
	public String getServiceContainerId() {
		return this.strServiceContainerId;
	}

	/**
	 * 初始化调用
	 * 
	 * @throws Exception
	 */
	protected void onInit() throws Exception {
		ServiceService serviceService = (ServiceService) ServiceGlobal.getService(ServiceService.class);
		SelectCond selectCond = new SelectCond();
		selectCond.set(Service.FIELD_CONTAINER, getServiceContainerId());
		selectCond.setOrderInfo("order by RUNORDER");
		ArrayList<Service> serviceList = serviceService.select(selectCond);
		for (Service service : serviceList) {
			try {
				IBackendService iBackendService = registerBackendService(service);
				if (StringHelper.compare(service.getStartMode(), "AUTO", true) == 0) {
					iBackendService.start();
					service.setServiceState(ServiceRunStateCodeListModel.START);
				} else {
					service.setServiceState(ServiceRunStateCodeListModel.STOP);
				}
				serviceService.update(service);
			} catch (Exception ex) {
				log.error(StringHelper.format("启动后台服务[%1$s]发生异常，%2$s", service.getServiceName(), ex.getMessage()));
				service.setServiceState(ServiceRunStateCodeListModel.STARTERROR);
				service.setErrorInfo(ex.getMessage());
				serviceService.update(service);
			}
		}
	}

	protected IBackendService registerBackendService(Service service) throws Exception {
		IBackendService iBackendService = (IBackendService) ObjectHelper.create(service.getServiceObject());
		iBackendService.init(service);
		backendServiceMap.put(iBackendService.getServiceId(), iBackendService);
		return iBackendService;
	}

	protected IBackendService getBackendService(String strServiceId) throws Exception {
		IBackendService iBackendService = backendServiceMap.get(strServiceId);
		if (iBackendService != null) return iBackendService;

		ServiceService serviceService = (ServiceService) ServiceGlobal.getService(ServiceService.class);
		Service service = new Service();
		service.setServiceId(strServiceId);
		if (!serviceService.get(service, true)) {
			throw new Exception(StringHelper.format("无法获取指定后台服务[%1$s]", strServiceId));
		}

		iBackendService = registerBackendService(service);
		return iBackendService;
	}

	/**
	 * 启动服务
	 * 
	 * @param strServiceId
	 * @throws Exception
	 */
	public void start(String strServiceId) throws Exception {
		IBackendService iBackendService = getBackendService(strServiceId);
		if (iBackendService.isStarted()) {
			return;
		}

		ServiceService serviceService = (ServiceService) ServiceGlobal.getService(ServiceService.class);
		Service service = new Service();
		service.setServiceId(strServiceId);

		try {
			iBackendService.start();
			service.setServiceState(ServiceRunStateCodeListModel.START);
			serviceService.update(service);

		} catch (Exception ex) {
			log.error(StringHelper.format("启动后台服务[%1$s]发生异常，%2$s", iBackendService.getServiceName(), ex.getMessage()));
			service.setServiceState(ServiceRunStateCodeListModel.STARTERROR);
			service.setErrorInfo(ex.getMessage());
			serviceService.update(service);
		}

	}

	public void stop(String strServiceId) throws Exception {
		IBackendService iBackendService = getBackendService(strServiceId);
		if (!iBackendService.isStarted()) {
			return;
		}

		ServiceService serviceService = (ServiceService) ServiceGlobal.getService(ServiceService.class);
		Service service = new Service();
		service.setServiceId(strServiceId);
		try {
			iBackendService.stop();
			service.setServiceState(ServiceRunStateCodeListModel.STOP);
			serviceService.update(service);

			// 移除后台处理，再次启动时将重新加载
			backendServiceMap.put(iBackendService.getServiceId(), iBackendService);
		} catch (Exception ex) {
			log.error(StringHelper.format("停止后台服务[%1$s]发生异常，%2$s", iBackendService.getServiceName(), ex.getMessage()));
			service.setServiceState(ServiceRunStateCodeListModel.STOP);
			serviceService.update(service);
			// service.setServiceState(ServiceRunStateCodeListModel.STOP);
			// serviceService.update(service);
			throw ex;
		}
	}

	/**
	 * 建立当前实例
	 * 
	 * @param strServiceContainerId
	 * @return
	 * @throws Exception
	 */
	public static BackendServiceMgr createInstance(String strServiceContainerId) throws Exception {
		BackendServiceMgr backendServiceMgr = new BackendServiceMgr();
		BackendServiceMgr.curBackendServiceMgr = backendServiceMgr;
		backendServiceMgr.init(strServiceContainerId);
		return BackendServiceMgr.curBackendServiceMgr;
	}

	/**
	 * 获取当前实例
	 * 
	 * @return
	 * @throws Exception
	 */
	public static BackendServiceMgr getInstance() throws Exception {
		return BackendServiceMgr.curBackendServiceMgr;
	}
}
