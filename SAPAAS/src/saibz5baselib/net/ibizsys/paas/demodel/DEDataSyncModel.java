package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;

/**
 * 实体数据同步处理模型
 * 
 * @author lionlau
 *
 */
public class DEDataSyncModel extends ModelBase3Impl implements IDEDataSyncModel {
	private IDataEntity iDataEntity = null;
	private boolean bInMode = false;
	private String strTestDEActionName = null;
	private ArrayList<String> fileFieldList = new ArrayList<String>();
	private ArrayList<String> deNameList = new ArrayList<String>();
	private String strSyncAgent = null;
	private int nEventType = 0;
	private String strImportDEActionName = null;
	private String strSyncTag = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSync#init(net.ibizsys.paas.core.IDataEntity)
	 */
	public void init(IDataEntity iDataEntity) throws Exception {
		this.setDataEntity(iDataEntity);
		this.onInit();
	}

	/**
	 * 获取实体模型对象
	 * 
	 * @return the iDataEntity
	 */
	public IDataEntity getDataEntity() {
		return iDataEntity;
	}

	/**
	 * 设置实体模型对象
	 * 
	 * @param iDataEntity the iDataEntity to set
	 */
	protected void setDataEntity(IDataEntity iDataEntity) {
		this.iDataEntity = iDataEntity;
	}

	/**
	 * 设置标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置名称
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSyncOut#getFileFields()
	 */
	@Override
	public java.util.Iterator<String> getFileFields() {
		if (fileFieldList == null || fileFieldList.size() == 0) return null;
		return this.fileFieldList.iterator();
	}

	/**
	 * 添加文件属性
	 * 
	 * @param strFileField
	 */
	public void addFileField(String strFileField) {
		this.fileFieldList.add(strFileField);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSyncIn#getDENames()
	 */
	@Override
	public Iterator<String> getDENames() {
		if (deNameList == null || deNameList.size() == 0) return null;
		return this.deNameList.iterator();
	}

	/**
	 * 添加实体名称
	 * 
	 * @param strDEName
	 */
	public void addDEName(String strDEName) {
		this.deNameList.add(strDEName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSyncIn#getTestDEActionName()
	 */
	@Override
	public String getTestDEActionName() {
		return this.strTestDEActionName;
	}

	/**
	 * 设置判断处理的实体行为名称
	 * 
	 * @param strTestDEActionName
	 */
	public void setTestDEActionName(String strTestDEActionName) {
		this.strTestDEActionName = strTestDEActionName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSyncIn#getImportDEActionName()
	 */
	@Override
	public String getImportDEActionName() {
		return this.strImportDEActionName;
	}

	/**
	 * 设置导入实体行为名称
	 * 
	 * @param strImportDEActionName
	 */
	public void setImportDEActionName(String strImportDEActionName) {
		this.strImportDEActionName = strImportDEActionName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSync#getSyncAgent()
	 */
	@Override
	public String getSyncAgent() {
		return this.strSyncAgent;
	}

	/**
	 * 设置同步代理
	 * 
	 * @param strSyncAgent
	 */
	public void setSyncAgent(String strSyncAgent) {
		this.strSyncAgent = strSyncAgent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSync#getEventType()
	 */
	@Override
	public int getEventType() {
		return this.nEventType;
	}

	/**
	 * 设置事件类型
	 * 
	 * @param nEventType
	 */
	public void setEventType(int nEventType) {
		this.nEventType = nEventType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSync#isInMode()
	 */
	@Override
	public boolean isInMode() {
		return this.bInMode;
	}

	/**
	 * 设置是否为输入模式
	 * 
	 * @param bInMode
	 */
	public void setInMode(boolean bInMode) {
		this.bInMode = bInMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSync#getSyncTag()
	 */
	@Override
	public String getSyncTag() {
		return this.strSyncTag;
	}

	/**
	 * 设置数据同步标识
	 * 
	 * @param strSyncTag
	 */
	public void setSyncTag(String strSyncTag) {
		this.strSyncTag = strSyncTag;
	}

}
