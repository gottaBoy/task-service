package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.codelist.ICodeList;

/**
 * 全局字典代码表模型对象
 * 
 * @author Administrator
 *
 */
public class GlobalScopeDictCatCodeListModel extends DynamicCodeListModelBase {
	/**
	 * 词条类别
	 */
	private String strCat = "";

	/**
	 * 所有者类型
	 */
	private String strOwnerType = "";

	/**
	 * 所有者标识
	 */
	private String strOwnerId = "";

	/**
	 * 获取分类
	 * 
	 * @return the strCat
	 */
	public String getCat() {
		return strCat;
	}

	/**
	 * 设置分类
	 * 
	 * @param strCat the strCat to set
	 */
	public void setCat(String strCat) {
		this.strCat = strCat;
	}

	/**
	 * 获取所有者类型
	 * 
	 * @return the strOwnerType
	 */
	public String getOwnerType() {
		return strOwnerType;
	}

	/**
	 * 设置所有者类型
	 * 
	 * @param strOwnerType the strOwnerType to set
	 */
	public void setOwnerType(String strOwnerType) {
		this.strOwnerType = strOwnerType;
	}

	/**
	 * 获取所有者标识
	 * 
	 * @return the strOwnerId
	 */
	public String getOwnerId() {
		return strOwnerId;
	}

	/**
	 * 设置所有者标识
	 * 
	 * @param strOwnerId the strOwnerId to set
	 */
	public void setOwnerId(String strOwnerId) {
		this.strOwnerId = strOwnerId;
	}

	/**
	 * 设置标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.CodeListModelBase#getId()
	 */
	@Override
	public String getId() {
		return this.strId;
	}

	/**
	 * 获取名称
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.CodeListModelBase#getName()
	 */
	@Override
	public String getName() {
		return this.strName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.CodeListModelBase#getCodeListType()
	 */
	@Override
	public String getCodeListType() {
		return ICodeList.CLTYPE_DYNAMIC;
	}

}
