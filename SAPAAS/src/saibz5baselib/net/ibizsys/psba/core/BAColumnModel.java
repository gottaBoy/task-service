package net.ibizsys.psba.core;

import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.util.StringHelper;

/**
 * 大数据列模型接口实现对象
 * 
 * @author Administrator
 *
 */
public class BAColumnModel extends BAModelBase implements IBAColumnModel {

	private IBATable iBATable = null;
	private String strDEFieldName = null;
	private String strBAColSetName = null;
	private String strDEName = null;
	private IDEField iDEField = null;
	private IBATableDE iBATableDE = null;
	private IBAColSet iBAColSet = null;
	private String strUnionKeyValue = null;
	private String strBATableDEId = null;

	/**
	 * 初始化
	 * 
	 * @param iBATable
	 */
	public void init(IBATable iBATable) throws Exception {
		this.iBATable = iBATable;

		if (!StringHelper.isNullOrEmpty(this.getBAColSetName())) {
			this.iBAColSet = this.getBATable().getBAColSet(this.getBAColSetName());
		}

		this.iBATableDE = this.getBATable().getBATableDE(this.getBATableDEId());
		if (!StringHelper.isNullOrEmpty(this.getDEFieldName())) {
			this.iDEField = (IDEField) this.iBATableDE.getDataEntity().getDEField(this.getDEFieldName(), false);
		}

		if (this.iDEField == null) {
			throw new Exception(StringHelper.format("大数据列[%1$s][%2$s]未指定实体属性", this.iBATable.getName(), this.getName()));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAColumnModel#getBATable()
	 */
	@Override
	public IBATable getBATable() {
		return this.iBATable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAColumnModel#getDEField()
	 */
	@Override
	public IDEField getDEField() {
		return this.iDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAColumnModel#getBAColSet()
	 */
	@Override
	public IBAColSet getBAColSet() {
		return this.iBAColSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAColumnModel#getBATableDE()
	 */
	@Override
	public IBATableDE getBATableDE() {
		return this.iBATableDE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAColumnModel#getDBValueFunc()
	 */
	@Override
	public String getDBValueFunc() {
		return this.getDEField().getDBValueFunc();
	}

	/**
	 * 设置实体属性名称
	 * 
	 * @param strDEFieldName
	 */
	public void setDEFieldName(String strDEFieldName) {
		this.strDEFieldName = strDEFieldName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAColumnModel#getDEFieldName()
	 */
	@Override
	public String getDEFieldName() {
		return this.strDEFieldName;
	}

	/**
	 * 设置实体名称
	 * 
	 * @param strDEName
	 */
	public void setDEName(String strDEName) {
		this.strDEName = strDEName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAColumnModel#getDEName()
	 */
	@Override
	public String getDEName() {
		return this.strDEName;
	}

	/**
	 * 设置列族名称
	 * 
	 * @param strBAColSetName
	 */
	public void setBAColSetName(String strBAColSetName) {
		this.strBAColSetName = strBAColSetName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAColumnModel#getBAColSetName()
	 */
	@Override
	public String getBAColSetName() {
		return this.strBAColSetName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAColumnModel#getPreDefinedType()
	 */
	@Override
	public String getPreDefinedType() {
		return this.getDEField().getPreDefinedType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAColumnModel#isEnableTempData()
	 */
	@Override
	public boolean isEnableTempData() {
		return this.getDEField().isEnableTempData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBAColumn#getStdDataType()
	 */
	@Override
	public int getStdDataType() {
		return this.getDEField().getStdDataType();
	}

	@Override
	public String getUnionKeyValue() {
		return strUnionKeyValue;
	}

	/**
	 * 设置联合键值
	 * @param strUnionKeyValue
	 */
	public void setUnionKeyValue(String strUnionKeyValue){
		this.strUnionKeyValue = strUnionKeyValue;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBAColumn#getBATableDEId()
	 */
	@Override
	public String getBATableDEId() {
		return this.strBATableDEId;
	}
	
	/**
	 * 设置大数据表实体标识
	 * @param strBATableDEId
	 */
	public void setBATableDEId(String strBATableDEId) {
		 this.strBATableDEId = strBATableDEId;
	}
	
	
}
