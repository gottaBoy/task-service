package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.ModelBaseImpl;

/**
 * 实体属性数据库列模型对象
 * @author Administrator
 *
 */
public class DEFDTColumnModel extends ModelBaseImpl implements IDEFDTColumnModel{

	private String strColumnName = null;
	private String strDBType = null;
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEFDTColumn#getColumnName()
	 */
	@Override
	public String getColumnName() {
		return this.strColumnName;
	}

	/**
	 * 设置列名称
	 * @param strColumnName
	 */
	public void setColumnName(String strColumnName){
		this.strColumnName = strColumnName;
	}
	
	

	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDEFDTColumnModel#getDBType()
	 */
	@Override
	public String getDBType()  {
		return this.strDBType;
	}

	/**
	 * 设置列名称
	 * @param strDBType
	 */
	public void setDBType(String strDBType){
		this.strDBType = strDBType;
	}
	
}
