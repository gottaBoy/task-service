package net.ibizsys.paas.sysmodel;

import java.util.Properties;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.Service;

/**
 * 后台服务基类
 * 
 * @author Administrator
 *
 */
public abstract class BackendServiceBase extends TimerTask implements IBackendService {
	protected Service service = null;
	protected boolean bStart = false;
	protected Properties serviceParams = null;
	private static final Log log = LogFactory.getLog(BackendServiceBase.class);
	private boolean bRunFlag = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.IBackendService#init(net.ibizsys.psrt.srv.common.entity.Service)
	 */
	@Override
	public void init(Service service) throws Exception {
		this.service = service;

		try {
			if (!StringHelper.isNullOrEmpty(service.getServiceParam())) serviceParams = PropertiesHelper.load(service.getServiceParam());
		} catch (Exception e) {
			throw new Exception(StringHelper.format("加载服务配置参数发生错误"), e);
		}

		onInit();
	}

	/**
	 * 初始化触发
	 * 
	 * @throws Exception
	 */
	protected void onInit() throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.IBackendService#start()
	 */
	@Override
	public void start() throws Exception {
		if (bStart) {
			return;
		}
		try {
			onStart();
			bStart = true;
		} catch (Exception ex) {
			onStop();
			throw ex;
		}
	}

	/**
	 * 服务启动触发
	 * 
	 * @throws Exception
	 */
	protected void onStart() throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.IBackendService#stop()
	 */
	public void stop() throws Exception {
		if (!bStart) return;
		onStop();
		bStart = false;
	}

	/**
	 * 服务停止触发
	 * 
	 * @throws Exception
	 */
	protected void onStop() throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.IBackendService#isStarted()
	 */
	@Override
	public boolean isStarted() {
		return this.bStart;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.IBackendService#getServiceId()
	 */
	@Override
	public String getServiceId() {
		return this.service.getServiceId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.IBackendService#getServiceName()
	 */
	@Override
	public String getServiceName() {
		return this.service.getServiceName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.IBackendService#quit()
	 */
	@Override
	public void quit() throws Exception {
		onQuit();
	}

	/**
	 * 服务退出时触发
	 * 
	 * @throws Exception
	 */
	protected void onQuit() throws Exception {
		stop();
	}

	/**
	 * 获取服务参数
	 * 
	 * @param strPropertyName
	 * @return
	 */
	protected String getServiceParam(String strPropertyName) {
		strPropertyName = strPropertyName.toUpperCase();
		String strDefaultValue = "";
		return PropertiesHelper.getProperty(serviceParams, strPropertyName, strDefaultValue);
	}

	/**
	 * 获取服务参数
	 * 
	 * @param strPropertyName
	 * @param strDefaultValue
	 * @return
	 */
	protected String getServiceParam(String strPropertyName, String strDefaultValue) {
		strPropertyName = strPropertyName.toUpperCase();
		return PropertiesHelper.getProperty(serviceParams, strPropertyName, strDefaultValue);
	}

	/**
	 * 运行任务
	 */
	protected void runTask() {
		synchronized (this) {
			if (bRunFlag) return;

			bRunFlag = true;
		}

		try {
			onRun();
		} catch (Exception ex) {
			log.error(StringHelper.format("服务[%1$s]处理发生异常，%2$s", this.getServiceId(), ex.getMessage()), ex);
		}

		synchronized (this) {
			bRunFlag = false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		runTask();
	}

	/**
	 * 运行计划任务
	 */
	protected void onRun() throws Exception {

	}
}
