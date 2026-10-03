package net.ibizsys.psba.dao;

import java.util.Date;

import net.ibizsys.paas.db.SelectCond;

/**
 * 大数据查询条件
 * @author Administrator
 *
 */
public class BASelectContext extends SelectCond implements IBASelectContext {

	private String[] colSets = null;
	private String strRowKeyPrefix = null;
	private int nMaxVersions = -1; //默认
	private java.util.Date startTimeStamp = null;
	private java.util.Date stopTimeStamp = null;
	private String strStartRowKey = null;
	private String strStopRowKey = null;
	private int nBatchSize = -1;
	private java.util.Date timeStamp = null;
	
	
	@Override
	public String[] getColSets() {
		return this.colSets;
	}

	@Override
	public String getRowKeyPrefix() {
		return this.strRowKeyPrefix;
	}

	@Override
	public int getMaxVersions() {
		return this.nMaxVersions;
	}

	@Override
	public Date getStartTimeStamp() {
		return this.startTimeStamp;
	}

	@Override
	public Date getStopTimeStamp() {
		return this.stopTimeStamp;
	}

	@Override
	public String getStartRowKey() {
		return this.strStartRowKey;
	}

	@Override
	public String getStopRowKey() {
		return this.strStopRowKey;
	}

	@Override
	public int getBatchSize() {
		return nBatchSize;
	}

	public void setColSets(String[] colSets) {
		this.colSets = colSets;
	}

	public void setRowKeyPrefix(String strRowKeyPrefix) {
		this.strRowKeyPrefix = strRowKeyPrefix;
	}

	public void setMaxVersions(int nMaxVersions) {
		this.nMaxVersions = nMaxVersions;
	}

	public void setStartTimeStamp(java.util.Date startTimeStamp) {
		this.startTimeStamp = startTimeStamp;
	}

	public void setStopTimeStamp(java.util.Date stopTimeStamp) {
		this.stopTimeStamp = stopTimeStamp;
	}

	public void setStartRowKey(String strStartRowKey) {
		this.strStartRowKey = strStartRowKey;
	}

	public void setStopRowKey(String strStopRowKey) {
		this.strStopRowKey = strStopRowKey;
	}

	public void setBatchSize(int nBatchSize) {
		this.nBatchSize = nBatchSize;
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.dao.IBASelectContext#getTimeStamp()
	 */
	@Override
	public Date getTimeStamp() {
		return this.timeStamp;
	}
	
	

	/**
	 * 设置时间戳
	 * @param timeStamp
	 */
	public void setTimeStamp(java.util.Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	protected void onReset() {
		this.colSets = null;
		this.strRowKeyPrefix = null;
		this.nMaxVersions = -1; //默认
		this.startTimeStamp = null;
		this.stopTimeStamp = null;
		this.strStartRowKey = null;
		this.strStopRowKey = null;
		this.nBatchSize = -1;
		this.timeStamp = null;
		super.onReset();
	}


	
	
}
