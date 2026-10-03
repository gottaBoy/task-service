package net.ibizsys.paas.datasync;

import java.util.Properties;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.DataSyncAgent;

/**
 * 数据同步引擎基类
 * 
 * @author LionLau
 *
 */
public class DataSyncEngineBase implements IDataSyncEngine, IDataSyncOutEngine, IDataSyncInEngine {
	protected DataSyncAgent dataSyncAgent = null;
	private boolean bSyncOut = false;

	protected Properties properties = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.datasync.IDataSyncEngine#init(net.ibizsys.psrt.srv.common.entity.DataSyncAgent)
	 */
	@Override
	public void init(DataSyncAgent dataSyncAgent) throws Exception {
		this.dataSyncAgent = dataSyncAgent;

		bSyncOut = StringHelper.compare(dataSyncAgent.getSyncDir(), IDataSyncEngine.SYNCDIR_OUT, true) == 0;

		// properties = PropertiesHelper.load(dataSyncAgent.get

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
	 * @see net.ibizsys.paas.datasync.IDataSyncEngine#getId()
	 */
	@Override
	public String getId() {
		return this.dataSyncAgent.getDataSyncAgentId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.datasync.IDataSyncEngine#getName()
	 */
	@Override
	public String getName() {
		return this.dataSyncAgent.getDataSyncAgentName();
	}

	/**
	 * 获取数据同步方向
	 * 
	 * @return
	 */
	@Override
	public String getSyncDir() {
		return this.dataSyncAgent.getSyncDir();
	}

	/**
	 * 获取引擎参数
	 * 
	 * @return
	 */
	protected Properties getParams() {
		return this.properties;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.datasync.IDataSyncOutEngine#checkSend()
	 */
	@Override
	public boolean checkSend() throws Exception {
		return onCheckSend();
	}

	protected boolean onCheckSend() throws Exception {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.datasync.IDataSyncOutEngine#send(net.ibizsys.paas.datasync.IDataSyncParam)
	 */
	@Override
	public void send(IDataSyncParam iDataSyncParam) throws Exception {
		if (!bSyncOut) {
			throw new Exception("ͬ当前引擎不是输出引擎");
		}
		onSend(iDataSyncParam);
	}

	/**
	 * 发送数据触发
	 * 
	 * @param param
	 * @throws Exception
	 */
	protected void onSend(IDataSyncParam iDataSyncParam) throws Exception {
		throw new Exception("没有实现");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.datasync.IDataSyncInEngine#recv(net.ibizsys.paas.datasync.IDataSyncParam)
	 */
	@Override
	public void recv(IDataSyncParam iDataSyncParam) throws Exception {
		if (bSyncOut) {
			throw new Exception("ͬ当前引擎不是输入引擎");
		}
		onRecv(iDataSyncParam);
	}

	/**
	 * 接收数据触发
	 * 
	 * @param iDataSyncParam
	 * @throws Exception
	 */
	protected void onRecv(IDataSyncParam iDataSyncParam) throws Exception {
		throw new Exception("没有实现");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.datasync.IDataSyncEngine#quit()
	 */
	public void quit() throws Exception {
		onQuit();
	}

	protected void onQuit() throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.datasync.IDataSyncInEngine#checkRecv()
	 */
	public boolean checkRecv() throws Exception {
		return onCheckRecv();
	}

	/**
	 * 检查数据接收功能是否正常
	 * 
	 * @return
	 * @throws Exception
	 */
	protected boolean onCheckRecv() throws Exception {
		return true;
	}
}
