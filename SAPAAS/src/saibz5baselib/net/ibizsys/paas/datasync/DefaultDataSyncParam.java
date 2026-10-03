package net.ibizsys.paas.datasync;

import java.util.ArrayList;

import net.ibizsys.psrt.srv.common.entity.DataSyncIn;
import net.ibizsys.psrt.srv.common.entity.DataSyncOut;

/**
 * 数据同步参数对象
 * 
 * @author LionLau
 *
 */
public class DefaultDataSyncParam implements IDataSyncParam {
	private DataSyncOut dataSyncOut = null;
	private ArrayList<DataSyncIn> dataSyncInList = new ArrayList<DataSyncIn>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.datasync.IDataSyncParam#getDataSyncOut()
	 */
	@Override
	public DataSyncOut getDataSyncOut() {
		return this.dataSyncOut;
	}

	/**
	 * 设置输出数据对象
	 * 
	 * @param dataSyncOut
	 */
	public void setDataSyncOut(DataSyncOut dataSyncOut) {
		this.dataSyncOut = dataSyncOut;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.datasync.IDataSyncParam#addDataSyncIn(net.ibizsys.psrt.srv.common.entity.DataSyncIn)
	 */
	@Override
	public void addDataSyncIn(DataSyncIn dataSyncIn) {
		dataSyncInList.add(dataSyncIn);
	}

	/**
	 * 重置数据输入集合
	 */
	public void resetDataSyncIns() {
		dataSyncInList.clear();
	}

	/**
	 * 获取数据输入集合
	 * 
	 * @return
	 */
	public ArrayList<DataSyncIn> getDataSyncIns() {
		return dataSyncInList;
	}

}
