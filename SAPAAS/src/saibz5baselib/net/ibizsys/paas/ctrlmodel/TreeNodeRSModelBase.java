package net.ibizsys.paas.ctrlmodel;

import java.util.HashMap;

import net.ibizsys.paas.core.ModelBaseImpl;

/**
 * 树节点关系模型基类
 * 
 * @author Administrator
 *
 */
public abstract class TreeNodeRSModelBase extends ModelBaseImpl implements ITreeNodeRSModel {
	private String strParentTreeNodeId = "";
	private ITreeModel iTreeModel = null;
	private String strChildTreeNodeId = "";
	private String strDEActionName = null;
	private int nParentValueLevel = 1;
	private int nSearchMode = ITreeNodeRSModel.SEARCHMODE_ALL;
	
	private HashMap<String, String> parentModeParamMap = new HashMap<String, String>();

	/**
	 * 初始化
	 * 
	 * @param iTreeModel
	 * @throws Exception
	 */
	public void init(ITreeModel iTreeModel) throws Exception {
		this.iTreeModel = iTreeModel;
		this.onInit();
	}

	/**
	 * 获取树模型对象
	 * 
	 * @return
	 */
	public ITreeModel getTreeModel() {
		return this.iTreeModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel#getParentTreeNodeId()
	 */
	@Override
	public String getParentTreeNodeId() {
		return this.strParentTreeNodeId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel#getChildTreeNodeId()
	 */
	@Override
	public String getChildTreeNodeId() {
		return strChildTreeNodeId;
	}

	/**
	 * 设置父节点标识
	 * 
	 * @param strParentTreeNodeId the strParentTreeNodeId to set
	 */
	public void setParentTreeNodeId(String strParentTreeNodeId) {
		this.strParentTreeNodeId = strParentTreeNodeId;
	}

	/**
	 * 设置子节点标识
	 * 
	 * @param strChildTreeNodeId the strChildTreeNodeId to set
	 */
	public void setChildTreeNodeId(String strChildTreeNodeId) {
		this.strChildTreeNodeId = strChildTreeNodeId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel#getDEActionName()
	 */
	@Override
	public String getDEActionName() {
		return this.strDEActionName;
	}

	/**
	 * 设置处理的行为名称
	 * 
	 * @param strDEActionName
	 */
	public void setDEActionName(String strDEActionName) {
		this.strDEActionName = strDEActionName;
	}
	
	
	
	
	/**
	 * 设置父模式参数
	 * @param strKey
	 * @param objValue
	 */
	public void setParentModeParam(String strKey, String objValue) {
		if (objValue == null) {
			this.parentModeParamMap.remove(strKey.toLowerCase());
		} else {
			this.parentModeParamMap.put(strKey.toLowerCase(), objValue);
		}
	}

	/**
	 * 获取父模式参数
	 * 
	 * @param strKey
	 * @return
	 */
	public String getParentModeParam(String strKey) {
		return this.parentModeParamMap.get(strKey.toLowerCase());
	}

	/**
	 * 获取父模式参数的名称集合
	 * 
	 * @return
	 */
	public java.util.Iterator<String> getParentModeParamNames() {
		return this.parentModeParamMap.keySet().iterator();
	}
	
	
	/**
	 * 设置父值的节点级别
	 * @param nParentValueLevel
	 */
	public void setParentValueLevel(int nParentValueLevel){
		this.nParentValueLevel = nParentValueLevel;
	}
	
	/**
	 * 获取父值的节点级别
	 * @param nParentValueLevel
	 */
	public int getParentValueLevel(){
		return this.nParentValueLevel;
	}

	@Override
	public int getSearchMode() {
		return this.nSearchMode;
	}
	
	
	/**
	 * 设置节点关系是否用于搜索模式
	 * @param nSearchMode
	 */
	public void setSearchMode(int nSearchMode){
		this.nSearchMode = nSearchMode;
	}
	
	
}
