package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.IDEFDBValueFunc;
import net.ibizsys.paas.core.IDEFDTColumn;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;
import net.ibizsys.paas.util.StringHelper;

/**
 * 实体属性模型
 * 
 * @author lionlau
 * 
 */
public class DEFieldModel extends ModelBase3Impl implements IDEFieldModel,IDEFDTColumn {
	
	
	protected ArrayList<IDEFSearchMode> defSearchModes = new ArrayList<IDEFSearchMode>();

	protected IDataEntity iDataEntity = null;

	private String strDataType = null;

	private int nStdDataType = DataTypes.UNKNOWN;

	private boolean bInheritDEField = false;

	private String strPreDefinedType = null;

	private boolean bKeyDEField = false;

	private boolean bUniTagDEField = false;

	private boolean bMajorDEField = false;

	private boolean bLinkDEField = false;

	private boolean bPhisicalDEField = true;

	// private String strDBValueFunc = null;

	private String strLogicName = null;

	private int nImportOrder = 100;

	private String strImportTag = "";

	private String strMemo = "";

	private String strDERName = "";

	private IDEFieldModel linkDEField = null;

	private IDEFieldModel realDEField = null;

	private String strLinkDEFName = "";

	private String strCodeListId = null;

	private String strValueFormat = "%1$s";

	private boolean bEnableAudit = false;

	private String strAuditInfoFormat = "[%1$s]从[%2$s]变更为[%3$s]";

	private boolean bMultiFormDEField = false;

	private boolean bIndexTypeDEField = false;

	private boolean bEnableTempData = true;

	private String strUnionKeyValue = null;

	private boolean bEnableDBAutoValue = false;

	private String strDBValueInsertMode = null;

	private String strDBValueUpdateMode = null;

	private HashMap<String, IDEFDBValueFunc> dbValueFuncMap = null;

	private HashMap<String, IDEFDTColumn> defDTColumnMap = null;
	
	private int nDEFType = IDEField.DEFTYPE_UNKNOWN;
	
	private boolean bDynaStorageDEField = false;
	
	public DEFieldModel() {

	}

	/**
	 * 初始化
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception {
		onInit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.ModelBaseImpl#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();

		// prepareDEFSearchModes();
	}

	/**
	 * 注册属性搜索模式
	 * 
	 * @param iDEFSearchMode
	 */
	public void registerDEFSearchMode(IDEFSearchMode iDEFSearchMode) {
		this.defSearchModes.add(iDEFSearchMode);
	}

	/**
	 * 设置属性标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置属性名称
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getDataType()
	 */
	@Override
	public String getDataType() {
		return strDataType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getStdDataType()
	 */
	@Override
	public int getStdDataType() {
		return nStdDataType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#isEnableQuickSearch()
	 */
	@Override
	public boolean isEnableQuickSearch() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getDEFSearchModes()
	 */
	@Override
	public Iterator<IDEFSearchMode> getDEFSearchModes() {
		return defSearchModes.iterator();
	}

	/**
	 * 设置实体模型对象
	 * 
	 * @param iDataEntity
	 */
	public void setDataEntity(IDataEntity iDataEntity) {
		this.iDataEntity = iDataEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getDataEntity()
	 */
	@Override
	public IDataEntity getDataEntity() {
		return this.iDataEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getLogicName()
	 */
	@Override
	public String getLogicName() {
		return strLogicName;
	}

	/**
	 * 设置逻辑名称
	 * 
	 * @param strLogicName
	 */
	public void setLogicName(String strLogicName) {
		this.strLogicName = strLogicName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getLogicName(java.lang.String)
	 */
	@Override
	public String getLogicName(String strLanguange) {
		return getLogicName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#isKeyDEField()
	 */
	@Override
	public boolean isKeyDEField() {
		return bKeyDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#isMajorDEField()
	 */
	@Override
	public boolean isMajorDEField() {
		return bMajorDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#isLinkDEField()
	 */
	@Override
	public boolean isLinkDEField() {
		return bLinkDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#isEnablePrivilege()
	 */
	@Override
	public boolean isEnablePrivilege() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getCodeListId()
	 */
	@Override
	public String getCodeListId() {
		return this.strCodeListId;
	}

	/**
	 * 设置代码表标识
	 * 
	 * @param strCodeListId
	 */
	public void setCodeListId(String strCodeListId) {
		this.strCodeListId = strCodeListId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getDEFValueRule(java.lang.String)
	 */
	@Override
	public IDEFValueRule getDEFValueRule(String strDVRId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getPreDefinedType()
	 */
	@Override
	public String getPreDefinedType() {
		return strPreDefinedType;
	}

	private boolean bFormulaDEField = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#isFormulaDEField()
	 */
	@Override
	public boolean isFormulaDEField() {
		return bFormulaDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#isPhisicalDEField()
	 */
	@Override
	public boolean isPhisicalDEField() {
		return bPhisicalDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#isInheritDEField()
	 */
	@Override
	public boolean isInheritDEField() {
		return bInheritDEField;
	}

	/**
	 * 设置数据类型
	 * 
	 * @param strDataType the strDataType to set
	 */
	public void setDataType(String strDataType) {
		this.strDataType = strDataType;
	}

	/**
	 * 设置标准数据类型
	 * 
	 * @param nStdDataType the nStdDataType to set
	 */
	public void setStdDataType(int nStdDataType) {
		this.nStdDataType = nStdDataType;
	}

	/**
	 * 设置是否为主键属性
	 * 
	 * @param bKeyDEField the bKeyDEField to set
	 */
	public void setKeyDEField(boolean bKeyDEField) {
		this.bKeyDEField = bKeyDEField;
	}

	/**
	 * 设置是否为唯一标记属性
	 * 
	 * @param bUniTagDEField the bUniTagDEField to set
	 */
	public void setUniTagDEField(boolean bUniTagDEField) {
		this.bUniTagDEField = bUniTagDEField;
	}

	/**
	 * 设置是否为主文本属性
	 * 
	 * @param bMajorDEField the bMajorDEField to set
	 */
	public void setMajorDEField(boolean bMajorDEField) {
		this.bMajorDEField = bMajorDEField;
	}

	/**
	 * 设置是否为链接属性
	 * 
	 * @param bLinkDEField the bLinkDEField to set
	 */
	public void setLinkDEField(boolean bLinkDEField) {
		this.bLinkDEField = bLinkDEField;
	}

	/**
	 * 设置属性预定义类型
	 * 
	 * @param strPreDefinedType the strPreDefinedType to set
	 */
	public void setPreDefinedType(String strPreDefinedType) {
		this.strPreDefinedType = strPreDefinedType;
	}

	/**
	 * 设置属性预定义类型
	 * 
	 * @param strPreDefinedType the strPreDefinedType to set
	 */
	public void setPreDefineType(String strPreDefinedType) {
		this.strPreDefinedType = strPreDefinedType;
	}

	/**
	 * 设置是否为公式属性
	 * 
	 * @param bFormulaDEField the bFormulaDEField to set
	 */
	public void setFormulaDEField(boolean bFormulaDEField) {
		this.bFormulaDEField = bFormulaDEField;
	}

	/**
	 * 设置是否为物理属性
	 * 
	 * @param bPhisicalDEField the bPhisicalDEField to set
	 */
	public void setPhisicalDEField(boolean bPhisicalDEField) {
		this.bPhisicalDEField = bPhisicalDEField;
	}

	/**
	 * 设置是否为继承属性
	 * 
	 * @param bInheritDEField the bInheritDEField to set
	 */
	public void setInheritDEField(boolean bInheritDEField) {
		this.bInheritDEField = bInheritDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getDBValueFunc()
	 */
	@Override
	public String getDBValueFunc() {
		return this.getDBValueUpdateMode();
	}

	/**
	 * 设置数据库值函数
	 * 
	 * @param strDBValueFunc the strDBValueFunc to set
	 */
	public void setDBValueFunc(String strDBValueFunc) {
		this.strDBValueUpdateMode = strDBValueFunc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getImportOrder()
	 */
	@Override
	public int getImportOrder() {
		return nImportOrder;
	}

	/**
	 * 设置导入次序
	 * 
	 * @param nImportOrder
	 */
	public void setImportOrder(int nImportOrder) {
		this.nImportOrder = nImportOrder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getImportTag()
	 */
	@Override
	public String getImportTag() {
		if (StringHelper.isNullOrEmpty(strImportTag)) return this.getName();
		return strImportTag;
	}

	/**
	 * 设置导入标记
	 * 
	 * @param strImportTag
	 */
	public void setImportTag(String strImportTag) {
		this.strImportTag = strImportTag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getMemo()
	 */
	@Override
	public String getMemo() {
		return this.strMemo;
	}

	/**
	 * 设置备注
	 * 
	 * @param strMemo
	 */
	public void setMemo(String strMemo) {
		this.strMemo = strMemo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getDERName()
	 */
	@Override
	public String getDERName() {
		return this.strDERName;
	}

	/**
	 * 设置关系名称
	 * 
	 * @param strDERName
	 */
	public void setDERName(String strDERName) {
		this.strDERName = strDERName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getLinkDEFName()
	 */
	@Override
	public String getLinkDEFName() {
		return this.strLinkDEFName;
	}

	/**
	 * 设置链接属性名称
	 * 
	 * @param strLinkDEFName
	 */
	public void setLinkDEFName(String strLinkDEFName) {
		this.strLinkDEFName = strLinkDEFName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEFieldModel#getLinkDEField()
	 */
	@Override
	public IDEFieldModel getLinkDEField() throws Exception {
		if (!this.isLinkDEField()) return null;

		if (linkDEField != null) return linkDEField;

		if (StringHelper.isNullOrEmpty(getLinkDEFName())) return null;

		if (StringHelper.isNullOrEmpty(getDERName())) return null;
		String strMajorDEId = this.getDataEntity().getSystem().getDER(this.getDERName()).getMajorDEId();
		linkDEField = (IDEFieldModel) DEModelGlobal.getDEModel(strMajorDEId).getDEField(getLinkDEFName(), false);
		return linkDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEFieldModel#getRealDEField()
	 */
	@Override
	public IDEFieldModel getRealDEField() throws Exception {
		if (!this.isLinkDEField()) return this;

		// if(this.isPhisicalDEField())
		// return this;

		if (realDEField != null) return realDEField;

		IDEFieldModel linkDEField = this.getLinkDEField();
		realDEField = linkDEField.getRealDEField();
		return realDEField;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEFieldModel#getDEModel()
	 */
	@Override
	public IDataEntityModel getDEModel() {
		return (IDataEntityModel) this.getDataEntity();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getValueFormat()
	 */
	@Override
	public String getValueFormat() {
		return strValueFormat;
	}

	/**
	 * 设置值格式化
	 * 
	 * @param strValueFormat
	 */
	public void setValueFormat(String strValueFormat) {
		this.strValueFormat = strValueFormat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#isEnableAudit()
	 */
	@Override
	public boolean isEnableAudit() {
		return this.bEnableAudit;
	}

	/**
	 * 设置是否支持属性变更审计
	 * 
	 * @param bEnableAudit
	 */
	public void setEnableAudit(boolean bEnableAudit) {
		this.bEnableAudit = bEnableAudit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getAuditInfoFormat()
	 */
	@Override
	public String getAuditInfoFormat() {
		return strAuditInfoFormat;
	}

	/**
	 * 设置审计格式
	 * 
	 * @param strAuditInfoFormat
	 */
	public void setAuditInfoFormat(String strAuditInfoFormat) {
		this.strAuditInfoFormat = strAuditInfoFormat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#isMultiFormDEField()
	 */
	@Override
	public boolean isMultiFormDEField() {
		return bMultiFormDEField;
	}

	/**
	 * 设置多表单属性
	 * 
	 * @param bMultiFormDEField
	 */
	public void setMultiFormDEField(boolean bMultiFormDEField) {
		this.bMultiFormDEField = bMultiFormDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#isIndexTypeDEField()
	 */
	@Override
	public boolean isIndexTypeDEField() {
		return bIndexTypeDEField;
	}

	/**
	 * 设置索引类型实体属性
	 * 
	 * @param bIndexTypeDEField
	 */
	public void setIndexTypeDEField(boolean bIndexTypeDEField) {
		this.bIndexTypeDEField = bIndexTypeDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#isEnableTempData()
	 */
	@Override
	public boolean isEnableTempData() {
		return this.bEnableTempData;
	}

	/**
	 * 是否支持临时数据
	 * 
	 * @param bEnableTempData
	 */
	public void setEnableTempData(boolean bEnableTempData) {
		this.bEnableTempData = bEnableTempData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getUnionKeyValue()
	 */
	@Override
	public String getUnionKeyValue() {
		return this.strUnionKeyValue;
	}

	/**
	 * 设置联合键值模式
	 * 
	 * @param strUnionKeyValue
	 */
	public void setUnionKeyValue(String strUnionKeyValue) {
		this.strUnionKeyValue = strUnionKeyValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#isEnableDBAutoValue()
	 */
	@Override
	public boolean isEnableDBAutoValue() {
		return this.bEnableDBAutoValue;
	}

	/**
	 * 设置数据库值是否为自动增加模式
	 * 
	 * @param bEnableDBAutoValue
	 */
	public void setEnableDBAutoValue(boolean bEnableDBAutoValue) {
		this.bEnableDBAutoValue = bEnableDBAutoValue;
	}

	@Override
	public boolean isUniTagField() {
		return this.bUniTagDEField;
	}

	/**
	 * 设置唯一标记属性
	 * 
	 * @param bUniTagDEField
	 */
	public void setUniTagField(boolean bUniTagDEField) {
		this.bUniTagDEField = bUniTagDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getDBValueInsertMode()
	 */
	@Override
	public String getDBValueInsertMode() {
		return this.strDBValueInsertMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#getDBValueUpdateMode()
	 */
	@Override
	public String getDBValueUpdateMode() {
		return this.strDBValueUpdateMode;
	}

	/**
	 * 设置数据库值插入模式
	 * 
	 * @param strDBValueInsertMode
	 */
	public void setDBValueInsertMode(String strDBValueInsertMode) {
		this.strDBValueInsertMode = strDBValueInsertMode;
	}

	/**
	 * 设置数据库值更新模式
	 * 
	 * @param strDBValueUpdateMode
	 */
	public void setDBValueUpdateMode(String strDBValueUpdateMode) {
		this.strDBValueUpdateMode = strDBValueUpdateMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEField#isEnableDBValueInsertUpdateMode()
	 */
	@Override
	public boolean isEnableDBValueInsertUpdateMode() {
		return getDEModel().getSystemModel().getSystemSetting().isEnableDBValueInsertUpdateMode();
	}



	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEField#getDEFDBValueFunc(java.lang.String, boolean)
	 */
	@Override
	public IDEFDBValueFunc getDEFDBValueFunc(String strDBType, boolean bInsert) throws Exception {
		if (this.dbValueFuncMap == null) {
			throw new Exception(StringHelper.format("没有获取数据库类型[%1$s]值函数定义", strDBType));
		}
		String strTag = StringHelper.format("%1$s.%2$s", strDBType, (bInsert ? "INSERT" : "UPDATE")).toUpperCase();
		IDEFDBValueFunc iDEFDBValueFunc = this.dbValueFuncMap.get(strTag);
		if (iDEFDBValueFunc == null) {
			throw new Exception(StringHelper.format("没有获取数据库类型[%1$s][%2$s]值函数定义", strDBType, (bInsert ? "INSERT" : "UPDATE")));
		}
		return iDEFDBValueFunc;
	}

	/**
	 * 注册数据库值函数代码
	 * @param strDBType
	 * @param bInsert
	 * @param strValueFuncFormat
	 * @param strValueFuncFields
	 */
	public void registerDBValueFuncCode(String strDBType, boolean bInsert, String strValueFuncFormat, String strValueFuncFields) {
		if (this.dbValueFuncMap == null) {
			this.dbValueFuncMap = new HashMap<String, IDEFDBValueFunc>();
		}
		String strTag = StringHelper.format("%1$s.%2$s", strDBType, (bInsert ? "INSERT" : "UPDATE")).toUpperCase();
		DEFDBValueFuncModel dbValueFuncModel = new DEFDBValueFuncModel();
		dbValueFuncModel.setCodeFormat(strValueFuncFormat);
		if (!StringHelper.isNullOrEmpty(strValueFuncFields)) {
			dbValueFuncModel.setFields(StringHelper.splitEx(strValueFuncFields));
		}
		this.dbValueFuncMap.put(strTag, dbValueFuncModel);
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEFDTColumn#getColumnName()
	 */
	@Override
	public String getColumnName() {
		return this.getName();
	}
	
	@Override
	public IDEFDTColumn getDEFDTColumn(String strDBType)  throws Exception{
		if(defDTColumnMap == null)
			return this;
		
		IDEFDTColumn iDEFDTColumn = this.defDTColumnMap.get(strDBType);
		if(iDEFDTColumn!=null)
			return iDEFDTColumn;
		return this;
	}


	@Override
	public void registerDEFDTColumn(IDEFDTColumn iDEFDTColumn) {
		IDEFDTColumnModel iDEFDTColumnModel = (IDEFDTColumnModel)iDEFDTColumn;
		if(this.defDTColumnMap == null)
			this.defDTColumnMap = new HashMap<String, IDEFDTColumn>();
		this.defDTColumnMap.put(iDEFDTColumnModel.getDBType(), iDEFDTColumn);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEField#getDEFType()
	 */
	@Override
	public int getDEFType() {
		return nDEFType;
	}
	
	
	/**
	 * 设置属性类型
	 * @param nDEFType
	 */
	public void setDEFType(int nDEFType){
		this.nDEFType = nDEFType;
	}

	@Override
	public boolean isDynaStorageDEField() {
		//return this.getDEFType() == IDEField.DEFTYPE_DYNASTORAGE;
		return this.bDynaStorageDEField;
	}
	
	/**
	 * 设置是否为动态存储属性
	 * @param bDynaStorageDEField
	 */
	public void setDynaStorageDEField(boolean bDynaStorageDEField){
		this.bDynaStorageDEField = bDynaStorageDEField;
	}
	
	
	
}
