package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.util.StringHelper;

/**
 * 实体数据库配置模型对象
 * @author Administrator
 *
 */
public class DEDBConfigModel extends ModelBaseImpl implements IDEDBConfigModel{

	private String strTableName = null;
	private String strUserTable = null;
	private String strViewName = null;
	private String strView2Name = null;
	private String strView3Name = null;
	private String strView4Name = null;
	private String strDBType = null;
	
	@Override
	public String getTableName() {
		return this.strTableName;
	}

	@Override
	public String getUserTable() {
		return this.strUserTable;
	}

	@Override
	public String getViewName() {
		return this.strViewName;
	}

	@Override
	public String getView2Name() {
		return this.strView2Name;
	}

	@Override
	public String getView3Name() {
		return this.strView3Name;
	}

	@Override
	public String getView4Name() {
		return this.strView4Name;
	}

	/**
	 * 设置表名称
	 * @param strTableName
	 */
	public void setTableName(String strTableName) {
		this.strTableName = strTableName;
	}

	
	/**
	 * 设置用户扩展表名称
	 * @param strUserTable
	 */
	public void setUserTable(String strUserTable) {
		this.strUserTable = strUserTable;
	}

	/**
	 * 设置视图名称
	 * @param strViewName
	 */
	public void setViewName(String strViewName) {
		this.strViewName = strViewName;
	}

	/**
	 * 设置视图2名称
	 * @param strView2Name
	 */
	public void setView2Name(String strView2Name) {
		this.strView2Name = strView2Name;
	}

	/**
	 * 设置视图3名称
	 * @param strView3Name
	 */
	public void setView3Name(String strView3Name) {
		this.strView3Name = strView3Name;
	}

	/**
	 * 设置视图4名称
	 * @param strView4Name
	 */
	public void setView4Name(String strView4Name) {
		this.strView4Name = strView4Name;
	}
	


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDEDBConfigModel#getDBType()
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
	
	
	@Override
	public String getViewName(int nViewLevel) {
		//注意，此处故意没有break
		switch(nViewLevel){
		case IDataEntity.VIEWLEVEL_DEFAULT:
		case IDataEntity.VIEWLEVEL_UNKNOWN:
			return this.getViewName();
		case IDataEntity.VIEWLEVEL_LEVEL4:
			if(!StringHelper.isNullOrEmpty(this.getView4Name()))
				return this.getView4Name();
		case IDataEntity.VIEWLEVEL_LEVEL3:
			if(!StringHelper.isNullOrEmpty(this.getView3Name()))
				return this.getView3Name();	
		case IDataEntity.VIEWLEVEL_LEVEL2:
			if(!StringHelper.isNullOrEmpty(this.getView2Name()))
				return this.getView2Name();
		default:
			return this.getViewName();
		}
	}

}
