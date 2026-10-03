package net.ibizsys.paas.demodel;

import java.lang.annotation.Annotation;
import java.util.HashMap;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.db.DBTypes;
import net.ibizsys.paas.util.StringHelper;

/**
 * 实体查询模型
 * 
 * @author lionlau
 *
 */
public abstract class DEDataQueryModelBase extends ModelBase3Impl  implements IDEDataQuery {
	
	private static HashMap<String,String> dbCompatibleMap = new HashMap<String,String>();
	
	static{
		dbCompatibleMap.put(DBTypes.HANA, DBTypes.Oracle);
		dbCompatibleMap.put(DBTypes.DM, DBTypes.Oracle);
		dbCompatibleMap.put(DBTypes.SQLite, DBTypes.MySQL5);
	}
	
	private IDataEntity iDataEntity = null;
	private DEDataQuery deDataQuery = null;

	protected HashMap<String, IDEDataQueryCode> deDataQueryCodeMap = new HashMap<String, IDEDataQueryCode>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQuery#init(net.ibizsys.paas.core.IDataEntity)
	 */
	public void init(IDataEntity iDataEntity) throws Exception {
		this.setDataEntity(iDataEntity);
		this.onInit();
	}

	protected void onInit() throws Exception {

	}

	/**
	 * 初始化注解
	 * 
	 * @param c
	 * @throws Exception
	 */
	protected void initAnnotation(Class c) {
		Annotation[] annotations = c.getAnnotations();
		if (annotations != null) {
			for (Annotation annotation : annotations) {
				if (annotation instanceof DEDataQuery) {
					setDEDataQueryAnno((DEDataQuery) annotation);
					continue;
				}

				if (annotation instanceof DEDataQueryCodes) {
					setDEDataQueryCodesAnno((DEDataQueryCodes) annotation);
					continue;
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntityObject#getDataEntity()
	 */
	public IDataEntity getDataEntity() {
		return iDataEntity;
	}

	/**
	 * @param iDataEntity the iDataEntity to set
	 */
	protected void setDataEntity(IDataEntity iDataEntity) {
		this.iDataEntity = iDataEntity;
	}

	/**
	 * @return the deDataQuery
	 */
	protected DEDataQuery getDEDataQueryAnno() {
		return deDataQuery;
	}

	/**
	 * @param deDataQuery the deDataQuery to set
	 */
	protected void setDEDataQueryAnno(DEDataQuery deDataQuery) {
		this.deDataQuery = deDataQuery;
	}

	/**
	 * @param deDataQuery the deDataQuery to set
	 */
	protected void setDEDataQueryCodesAnno(DEDataQueryCodes deDataQueryCodes) {
		for (DEDataQueryCode deDataQueryCode : deDataQueryCodes.value()) {
			IDEDataQueryCode iDEDataQueryCode = createDEDataQueryCode(deDataQueryCode);
			deDataQueryCodeMap.put(iDEDataQueryCode.getDBType(), iDEDataQueryCode);
		}
	}

	protected IDEDataQueryCode createDEDataQueryCode(DEDataQueryCode deDataQueryCode) {
		DEDataQueryCodeModel deDataQueryCodeModel = new DEDataQueryCodeModel(this, deDataQueryCode);
		return deDataQueryCodeModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getId()
	 */
	@Override
	public String getId() {
		return getDEDataQueryAnno().id();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getName()
	 */
	@Override
	public String getName() {
		return getDEDataQueryAnno().name();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQuery#getDEDataQueryCode(java.lang.String)
	 */
	@Override
	public IDEDataQueryCode getDEDataQueryCode(String strDBType) throws Exception {
		IDEDataQueryCode iDEDataQueryCode = deDataQueryCodeMap.get(strDBType);
		if (iDEDataQueryCode == null) {
			String strDBType2 = dbCompatibleMap.get(strDBType);
			if(!StringHelper.isNullOrEmpty(strDBType2)){
				iDEDataQueryCode = deDataQueryCodeMap.get(strDBType2);
			}
			if(iDEDataQueryCode==null)
				throw new Exception(StringHelper.format("无法获取数据库[%1$s]代码", strDBType));
		}
		return iDEDataQueryCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataQuery#isDefaultMode()
	 */
	@Override
	public boolean isDefaultMode() {
		return this.getDEDataQueryAnno().defaultmode();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataQuery#getViewLevel()
	 */
	@Override
	public int getViewLevel() {
		return this.getDEDataQueryAnno().viewlevel();
	}

	
	
	
}
