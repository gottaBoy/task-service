package net.ibizsys.psba.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.entity.IBAEntity;

/**
 * 大数据表模型对象
 * 
 * @author Administrator
 *
 */
public class BATableModel extends BASchemeObjectModelBase implements IBATableModel {

	private ArrayList<IBAColumn> baColumnList = new ArrayList<IBAColumn>();
	private HashMap<String, IBAColumn> baColumnMap = new HashMap<String, IBAColumn>();
	private ArrayList<IBAColSet> baColSetList = new ArrayList<IBAColSet>();
	private HashMap<String, IBAColSet> baColSetMap = new HashMap<String, IBAColSet>();

	private ArrayList<IBATableDE> baTableDEList = new ArrayList<IBATableDE>();
	private HashMap<String, IBATableDE> baTableDEMap = new HashMap<String, IBATableDE>();
	
	private ArrayList<IBATableDER> baTableDERList = new ArrayList<IBATableDER>();
	private HashMap<String, IBATableDER> baTableDERMap = new HashMap<String, IBATableDER>();
	

	private int nBATableType = BATABLETYPE_MAJOR;
	
	
	/**
	 * 初始化
	 * 
	 * @param iBAScheme
	 * @throws Exception
	 */
	public void init(IBAScheme iBAScheme) throws Exception {
		this.setBAScheme(iBAScheme);
		
		this.onInit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBATableModel#registerBAColumn(net.ibizsys.psba.core.IBAColumn)
	 */
	@Override
	public void registerBAColumn(IBAColumn iBAColumn) throws Exception{
		this.baColumnList.add(iBAColumn);
		this.baColumnMap.put(iBAColumn.getId(), iBAColumn);
		((IBAColSetModel)this.getBAColSet(iBAColumn.getBAColSetName())).registerBAColumn(iBAColumn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBATableModel#registerBAColSet(net.ibizsys.psba.core.IBAColSet)
	 */
	@Override
	public void registerBAColSet(IBAColSet iBAColSet)  throws Exception{
		this.baColSetList.add(iBAColSet);
		this.baColSetMap.put(iBAColSet.getId(), iBAColSet);
		this.baColSetMap.put(iBAColSet.getName(), iBAColSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBATableModel#registerBATableDE(net.ibizsys.psba.core.IBATableDE)
	 */
	@Override
	public void registerBATableDE(IBATableDE iBATableDE)  throws Exception{
		this.baTableDEList.add(iBATableDE);
		this.baTableDEMap.put(iBATableDE.getId(), iBATableDE);
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBATableModel#registerBATableDER(net.ibizsys.psba.core.IBATableDER)
	 */
	@Override
	public void registerBATableDER(IBATableDER iBATableDER)  throws Exception{
		this.baTableDERList.add(iBATableDER);
		this.baTableDERMap.put(iBATableDER.getId(), iBATableDER);
		this.baTableDERMap.put(iBATableDER.getName(), iBATableDER);
	}

	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBATable#getBAColSets()
	 */
	@Override
	public Iterator<IBAColSet> getBAColSets() {
		if (this.baColSetList == null || this.baColSetList.size() == 0) return null;
		return this.baColSetList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBATable#getBAColumns()
	 */
	@Override
	public Iterator<IBAColumn> getBAColumns() {
		if (this.baColumnList == null || this.baColumnList.size() == 0) return null;
		return this.baColumnList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBATable#getBATableDE(java.lang.String)
	 */
	@Override
	public IBATableDE getBATableDE(String strDEName) throws Exception {
		IBATableDE iBATableDE = baTableDEMap.get(strDEName);
		if (iBATableDE == null) {
			throw new Exception(StringHelper.format("无法获取大数据表实体[%1$s]", strDEName));
		}
		return iBATableDE;
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBATable#getBATableDE(java.lang.String, boolean)
	 */
	@Override
	public IBATableDE getBATableDE(String strDEName, boolean bTryMode) throws Exception {
		IBATableDE iBATableDE = baTableDEMap.get(strDEName);
		if (iBATableDE == null && !bTryMode) {
			throw new Exception(StringHelper.format("无法获取大数据表实体[%1$s]", strDEName));
		}
		return iBATableDE;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBATable#getBATableDER(java.lang.String)
	 */
	@Override
	public IBATableDER getBATableDER(String strDERName) throws Exception {
		IBATableDER iBATableDER = baTableDERMap.get(strDERName);
		if (iBATableDER == null) {
			throw new Exception(StringHelper.format("无法获取大数据表实体关系[%1$s]", strDERName));
		}
		return iBATableDER;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBATable#getBAColumn(java.lang.String)
	 */
	@Override
	public IBAColumn getBAColumn(String strBAColumnName) throws Exception {
		IBAColumn iBAColumn = baColumnMap.get(strBAColumnName);
		if (iBAColumn == null) {
			throw new Exception(StringHelper.format("无法获取大数据表列[%1$s]", strBAColumnName));
		}
		return iBAColumn;
	}
	
	
	


	@Override
	public IBAColumn getBAColumn(String strBAColSetId, String strBAColumnId) throws Exception {
		return this.getBAColSet(strBAColSetId).getBAColumn(strBAColumnId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBATable#getBAColSet(java.lang.String)
	 */
	@Override
	public IBAColSet getBAColSet(String strBAColSetName) throws Exception {
		IBAColSet iBAColSet = baColSetMap.get(strBAColSetName);
		if (iBAColSet == null) {
			throw new Exception(StringHelper.format("无法获取大数据表列族[%1$s]", strBAColSetName));
		}
		return iBAColSet;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBATable#getBATableType()
	 */
	@Override
	public int getBATableType() {
		return nBATableType;
	}

	/**
	 * 设置大数据表类型
	 * @param nBATableType
	 */
	public void setBATableType(int nBATableType){
		this.nBATableType = nBATableType;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBATableModel#getBATableDERCount()
	 */
	@Override
	public int getBATableDERCount() {
		return baTableDERList.size();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBATableModel#getBATableDERAt(int)
	 */
	@Override
	public IBATableDER getBATableDERAt(int nPos) throws Exception {
		return baTableDERList.get(nPos);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBATable#getBATableDEs()
	 */
	@Override
	public Iterator<IBATableDE> getBATableDEs() {
		return baTableDEList.iterator();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBATableRuntime#createBAEntity()
	 */
	@Override
	public IBAEntity createBAEntity()throws Exception{
		return this.getBASchemeModel().createBAEntity(this);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBATableRuntime#getBAEntity(java.lang.String)
	 */
	@Override
	public IBAEntity getBAEntity(String strRowKey) throws Exception {
		IBAEntity iBAEntity = createBAEntity();
		iBAEntity.setRowKey(strRowKey);
		iBAEntity.get();
		return iBAEntity;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBATableRuntime#getBAEntity(java.lang.String, java.lang.String[])
	 */
	@Override
	public IBAEntity getBAEntity(String strRowKey, String[] families) throws Exception {
		IBAEntity iBAEntity = createBAEntity();
		iBAEntity.setRowKey(strRowKey);
		iBAEntity.get(families);
		return iBAEntity;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBATableRuntime#getBAEntity(java.lang.String, java.lang.String[], boolean)
	 */
	@Override
	public IBAEntity getBAEntity(String strRowKey, String[] families, boolean bTryMode) throws Exception {
		IBAEntity iBAEntity = createBAEntity();
		iBAEntity.setRowKey(strRowKey);
		if(iBAEntity.get(families,bTryMode))
			return iBAEntity;
		return null;
	}
	
	
	
	
}
