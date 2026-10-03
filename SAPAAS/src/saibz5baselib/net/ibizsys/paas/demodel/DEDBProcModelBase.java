package net.ibizsys.paas.demodel;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.core.DBProcParams;
import net.ibizsys.paas.core.DEDBProc;
import net.ibizsys.paas.core.DEDBProcDialect;
import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamDirections;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

/**
 * 实体存储过程模型
 * 
 * @author lionlau
 *
 */
public abstract class DEDBProcModelBase extends DEActionModelBase implements IDEDBProcModel {
	private IDataEntity iDataEntity = null;
	private DEDBProc deDBProc = null;

	private HashMap<String, DEDBProcParamsModel> dbProcParamsMap = new HashMap<String, DEDBProcParamsModel>();

	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	public void init(IDataEntity iDataEntity) throws Exception {
		this.setDataEntity(iDataEntity);
		this.onInit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.ModelBaseImpl#onInit()
	 */
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
				if (annotation instanceof DEDBProc) {
					prepareDEDBProc((DEDBProc) annotation);
					continue;
				}

				if (annotation instanceof DEDBProcDialect) {
					prepareDEDBProcDialect((DEDBProcDialect) annotation);
					continue;
				}
			}
		}
	}

	protected void prepareDEDBProc(DEDBProc deDBProc) {
		this.deDBProc = deDBProc;
	}

	protected void prepareDEDBProcDialect(DEDBProcDialect deDBProcDialect) {

		for (DBProcParams deProcParams : deDBProcDialect.value()) {
			DEDBProcParamsModel deDBProcParamsModel = createDEDBProcParamsModel(deProcParams);
			dbProcParamsMap.put(deDBProcParamsModel.getDBType(), deDBProcParamsModel);
		}
	}

	protected DEDBProcParamsModel createDEDBProcParamsModel(DBProcParams deProcParams) {
		DEDBProcParamsModel deDBProcParamsModel = new DEDBProcParamsModel();
		deDBProcParamsModel.init(deProcParams);
		return deDBProcParamsModel;
	}

	/**
	 * @return the iDataEntity
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDBSysProcAction#getTimeOut()
	 */
	@Override
	public int getTimeOut() {
		return this.deDBProc.timeout();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDBSysProcAction#getDBProcName()
	 */
	@Override
	public String getDBProcName() {
		return this.deDBProc.procname();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDBSysProcAction#getActionMode()
	 */
	@Override
	public String getActionMode() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDBSysProcAction#getProcParams(java.lang.String)
	 */
	@Override
	public Iterator<IProcParam> getProcParams(String strDBType) throws Exception {
		DEDBProcParamsModel deDBProcParamsModel = dbProcParamsMap.get(strDBType);
		if (deDBProcParamsModel == null) {
			throw new Exception(StringHelper.format("无法获取制定数据库类型过程参数[%1$s]", strDBType));
		}
		return deDBProcParamsModel.getProcParams();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.impl.ModelBaseImpl#getId()
	 */
	@Override
	public String getId() {
		return deDBProc.id();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.impl.ModelBaseImpl#getName()
	 */
	@Override
	public String getName() {
		return deDBProc.name();
	}

	/*
	 * 填充过程参数
	 * 
	 * @param iDataObject
	 * 
	 * @param procParams
	 * 
	 * @param callPrams
	 */
	@Override
	public void fillSqlParams(String strDBType, IEntity iEntity, IWebContext iWebContext, SqlParamList sqlParamList) throws Exception {
		java.util.Iterator<IProcParam> procParams = this.getProcParams(strDBType);
		while (procParams.hasNext()) {
			IProcParam procParam = procParams.next();

			SqlParam callParam = getProcSqlParam(strDBType, procParam, iEntity, iWebContext);
			if (callParam == null) callParam = new SqlParam();
			sqlParamList.add(callParam);
		}
	}

	protected SqlParam getProcSqlParam(String strDBType, IProcParam procParam, IEntity iEntity, IWebContext iWebContext) throws Exception {
		return getProcSqlParam(procParam, iEntity, iWebContext);
	}

	protected SqlParam getProcSqlParam(IProcParam procParam, IEntity iEntity, IWebContext iWebContext) throws Exception {
		return getProcSqlParam(procParam, iEntity, iWebContext, this.getDataEntity());
	}

	public static SqlParam getProcSqlParam(IProcParam procParam, IEntity iEntity, IWebContext iWebContext, IDataEntity iDataEntity) throws Exception {
		SqlParam callParam = new SqlParam();
		callParam.setParamName(procParam.getParamName());
		callParam.setDataType(procParam.getDataType());
		if(!StringHelper.isNullOrEmpty(procParam.getParamName())){
			String strParamName = procParam.getParamName().toUpperCase();
			if (strParamName.indexOf(IProcParam.TAG_VAR) == 0) {
				// 变量
				strParamName = strParamName.substring(4);
				// IDEField iDEField = iDataEntity.getDEField(strParamName,true);
				// if (iDEField != null)
				// {
				// callParam.setDataType(DataTypeHelper.FromString(iDEField.GetStdDataType()));
				// }

				Object objValue = (iEntity == null) ? null : iEntity.get(strParamName);
				if (objValue != null && objValue instanceof String) {
					if (StringHelper.isNullOrEmpty((String) objValue)) {
						objValue = null;
					}
				}
				callParam.setValue(objValue);

				callParam.setDirection(procParam.getDirection());
				callParam.setOutputParamName(strParamName);
				return callParam;
			}

			if (strParamName.indexOf(IProcParam.TAG_VF) == 0) {
				// 变量
				strParamName = strParamName.substring(3);
				if (iEntity != null && iEntity.contains(strParamName))
					callParam.setValue(1);
				else
					callParam.setValue(0);
				callParam.setDataType(DataTypes.INT);
				return callParam;
			}

			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_CURTIME, true) == 0) {
				if (iEntity != null) {
					java.sql.Timestamp curTime = DataObject.getTimestampValue(iEntity, IProcParam.TAG_CURTIME, null);
					if (curTime == null) curTime = DateHelper.getCurTime();
					callParam.setValue(curTime);
				} else {
					callParam.setValue(DateHelper.getCurTime());
				}
				callParam.setDataType(DataTypes.DATETIME);
				return callParam;
			}

			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_PERSONID, true) == 0) {
				if (iEntity != null) {
					String strTempOpPersonId = DataObject.getStringValue(iEntity, IProcParam.TAG_PERSONID, (iWebContext == null) ? null : iWebContext.getCurUserId());
					callParam.setValue(strTempOpPersonId);
				} else {
					callParam.setValue((iWebContext == null) ? null : iWebContext.getCurUserId());
				}
				callParam.setDataType(DataTypes.VARCHAR);
				return callParam;
			}
			
			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_LOGINNAME, true) == 0) {
				if (iEntity != null) {
					String strTempLoginName =  DataObject.getStringValue(iEntity, IProcParam.TAG_LOGINNAME, (iWebContext == null) ? null : iWebContext.getCurLoginName());
					if(StringHelper.isNullOrEmpty(strTempLoginName)) {
						strTempLoginName = DataObject.getStringValue(iEntity, IProcParam.TAG_PERSONID, (iWebContext == null) ? null : iWebContext.getCurUserId());
					}
					callParam.setValue(strTempLoginName);
				} else {
					String strTempLoginName =  (iWebContext == null) ? null : iWebContext.getCurLoginName();
					if(StringHelper.isNullOrEmpty(strTempLoginName)) {
						strTempLoginName = (iWebContext == null) ? null : iWebContext.getCurUserId();
					}
					callParam.setValue(strTempLoginName);
				}
				callParam.setDataType(DataTypes.VARCHAR);
				return callParam;
			}
			
			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_PERSONNAME, true) == 0) {
				if (iEntity != null) {
					String strTempOpPersonName = DataObject.getStringValue(iEntity, IProcParam.TAG_PERSONNAME, (iWebContext == null) ? null : iWebContext.getCurUserName());
					callParam.setValue(strTempOpPersonName);
				} else {
					callParam.setValue((iWebContext == null) ? null : iWebContext.getCurUserName());
				}
				callParam.setDataType(DataTypes.VARCHAR);
				return callParam;
			}

			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_ORGID, true) == 0) {
				if (iEntity != null) {
					String strOrgId = DataObject.getStringValue(iEntity, IProcParam.TAG_ORGID, null);
					if (StringHelper.isNullOrEmpty(strOrgId) && iDataEntity != null) {
						IDEField ideField = ((IDataEntityModel) iDataEntity).getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGID, true);
						if (ideField != null) strOrgId = DataObject.getStringValue(iEntity, ideField.getName(), null);
					}
					if (StringHelper.isNullOrEmpty(strOrgId) && (iWebContext != null)) {
						strOrgId = iWebContext.getCurOrgId();
					}
					callParam.setValue(strOrgId);
				} else {
					callParam.setValue((iWebContext == null) ? null : iWebContext.getCurOrgId());
				}
				callParam.setDataType(DataTypes.VARCHAR);
				return callParam;
			}

			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_ORGNAME, true) == 0) {
				if (iEntity != null) {
					String strOrgName = DataObject.getStringValue(iEntity, IProcParam.TAG_ORGNAME, null);
					if (StringHelper.isNullOrEmpty(strOrgName) && iDataEntity != null) {
						IDEField ideField = ((IDataEntityModel) iDataEntity).getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGNAME, true);
						if (ideField != null) strOrgName = DataObject.getStringValue(iEntity, ideField.getName(), null);
					}
					if (StringHelper.isNullOrEmpty(strOrgName) && (iWebContext != null)) {
						strOrgName = iWebContext.getCurOrgName();
					}
					callParam.setValue(strOrgName);
				} else {
					callParam.setValue((iWebContext == null) ? null : iWebContext.getCurOrgName());
				}
				callParam.setDataType(DataTypes.VARCHAR);
				return callParam;
			}

			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_ORGSECTORID, true) == 0) {
				if (iEntity != null) {
					String strOrgSectorId = DataObject.getStringValue(iEntity, IProcParam.TAG_ORGSECTORID, null);
					if (StringHelper.isNullOrEmpty(strOrgSectorId) && iDataEntity != null) {
						IDEField ideField = ((IDataEntityModel) iDataEntity).getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGSECTORID, true);
						if (ideField != null) strOrgSectorId = DataObject.getStringValue(iEntity, ideField.getName(), null);
					}
					if (StringHelper.isNullOrEmpty(strOrgSectorId) && (iWebContext != null)) {
						strOrgSectorId = iWebContext.getCurOrgSectorId();
					}
					callParam.setValue(strOrgSectorId);
				} else {
					callParam.setValue((iWebContext == null) ? null : iWebContext.getCurOrgSectorId());
				}
				callParam.setDataType(DataTypes.VARCHAR);
				return callParam;
			}

			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_ORGSECTORNAME, true) == 0) {
				if (iEntity != null) {
					String strOrgSectorName = DataObject.getStringValue(iEntity, IProcParam.TAG_ORGSECTORNAME, null);
					if (StringHelper.isNullOrEmpty(strOrgSectorName) && iDataEntity != null) {
						IDEField ideField = ((IDataEntityModel) iDataEntity).getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGSECTORNAME, true);
						if (ideField != null) strOrgSectorName = DataObject.getStringValue(iEntity, ideField.getName(), null);
					}
					if (StringHelper.isNullOrEmpty(strOrgSectorName) && (iWebContext != null)) {
						strOrgSectorName = iWebContext.getCurOrgSectorName();
					}
					callParam.setValue(strOrgSectorName);
				} else {
					callParam.setValue((iWebContext == null) ? null : iWebContext.getCurOrgSectorName());
				}
				callParam.setDataType(DataTypes.VARCHAR);
				return callParam;
			}

			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_ACTIONARG, true) == 0) {
				callParam.setValue(DataObject.getStringValue(iEntity, IProcParam.TAG_ACTIONARG, ""));
				callParam.setDataType(DataTypes.VARCHAR);
				return callParam;
			}

			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_RD, true) == 0) {
				callParam.setDirection(SqlParamDirections.Output);
				callParam.setOutputParamName(IProcParam.TAG_RD);
				return callParam;
			}

			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_RETCODE, true) == 0) {
				callParam.setDirection(SqlParamDirections.Output);
				callParam.setDataType(DataTypes.INT);
				callParam.setOutputParamName(IProcParam.TAG_RETCODE);
				return callParam;
			}

			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_RETINFO, true) == 0) {
				callParam.setDirection(SqlParamDirections.Output);
				callParam.setDataType(DataTypes.VARCHAR);
				callParam.setOutputParamName(IProcParam.TAG_RETINFO);
				return callParam;
			}

			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_RETINFORES, true) == 0) {
				callParam.setDirection(SqlParamDirections.Output);
				callParam.setDataType(DataTypes.VARCHAR);
				callParam.setOutputParamName(IProcParam.TAG_RETINFORES);
				return callParam;
			}

			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_RETINFORESARG, true) == 0) {
				callParam.setDirection(SqlParamDirections.Output);
				callParam.setDataType(DataTypes.VARCHAR);
				callParam.setOutputParamName(IProcParam.TAG_RETINFORESARG);
				return callParam;
			}

			// 检查DALOG
			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_DALOG, true) == 0) {
				callParam.setDirection(SqlParamDirections.Input);
				callParam.setDataType(DataTypes.INT);
				if (iEntity != null) {
					callParam.setValue(DataObject.getIntegerValue(iEntity, IProcParam.TAG_DALOG, 1));
				} else
					callParam.setValue(1);
				return callParam;
			}

			// 检查传入的键值
			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_CHECKKEY, true) == 0) {
				callParam.setDirection(SqlParamDirections.Input);
				callParam.setDataType(DataTypes.INT);
				if (iEntity != null) {
					callParam.setValue(DataObject.getIntegerValue(iEntity, IProcParam.TAG_CHECKKEY, 1));
				} else
					callParam.setValue(1);
				return callParam;
			}

			// 返回结果集
			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_RETDATA, true) == 0) {
				callParam.setDirection(SqlParamDirections.Input);
				callParam.setDataType(DataTypes.INT);
				if (iEntity != null) {
					callParam.setValue(DataObject.getIntegerValue(iEntity, IProcParam.TAG_RETDATA, 1));
				} else
					callParam.setValue(1);
				return callParam;
			}

			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_TAG, true) == 0) {
				callParam.setDirection(SqlParamDirections.Output);
				callParam.setDataType(DataTypes.VARCHAR);
				callParam.setOutputParamName(IProcParam.TAG_TAG);
				return callParam;
			}

			if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_DRAFTFLAG, true) == 0) {
				if (EntityBase.hasDraftFlag(iEntity)) {
					callParam.setValue(EntityBase.isDraft(iEntity) ? 1 : 0);
				} else {
					callParam.setValue(procParam.getDefaultValue());
					int nDefaultValue = 1;
					if (procParam.getDefaultValue() != null) nDefaultValue = (int) procParam.getDefaultValue();
					if (nDefaultValue == 1) {
						// 进一步判断是否与原始键值
						Object objValue = (iEntity == null) ? null : iEntity.get(ServiceBase.ORIGINKEY);
						if (objValue != null) {
							callParam.setValue(0);
						}
					}
				}
				return callParam;

			}
		}
		

		callParam.setValue(procParam.getDefaultValue());
		return callParam;
	}

}
