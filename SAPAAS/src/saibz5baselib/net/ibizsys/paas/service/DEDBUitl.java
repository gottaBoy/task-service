package net.ibizsys.paas.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamDirections;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.demodel.ISqlCommandModel;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;


/**
 * 实体数据库辅助对象
 * 
 * @author Administrator
 *
 */
public class DEDBUitl {

	/**
	 * 同步实体数据
	 * @param iDataEntityModel
	 * @param iDataTable
	 * @return
	 * @throws Exception
	 */
	public static int syncData(IDataEntityModel iDataEntityModel,IDataTable iDataTable)throws Exception{
		return syncData(iDataEntityModel, iDataTable, null);
	}

	/**
	 *  同步实体数据
	 * @param iDataEntityModel
	 * @param iDataTable
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	public static int syncData(IDataEntityModel iDataEntityModel,IDataTable iDataTable,SessionFactory sessionFactory)throws Exception{
		return syncData(iDataEntityModel, iDataTable, sessionFactory,100);
	}

	/**
	 * 同步实体数据
	 * @param iDataEntityModel
	 * @param iDataTable
	 * @param sessionFactory
	 * @param nBatchSize
	 * @return
	 * @throws Exception
	 */
	public static int syncData(IDataEntityModel iDataEntityModel,IDataTable iDataTable,SessionFactory sessionFactory,int nBatchSize)throws Exception{
		
		IService iService = iDataEntityModel.getService(sessionFactory);
		
		ISqlCommandModel iSqlCommandModel = iDataEntityModel.getMergeSqlCommandModel(iService.getDAO().getRealDBDialect());
		
		int nCount = 0;
		while(true){
			ArrayList<SqlParamList> sqlParamListList = new ArrayList<SqlParamList>(); 
			int nRowCount = iDataTable.cacheRows(nBatchSize);
			for(int i = 0;i<nRowCount;i++){
				IDataRow iDataRow = iDataTable.getCachedRow(i);
				SqlParamList sqlParamList = getSqlParamList(iSqlCommandModel,iDataRow,null,iDataEntityModel);
				sqlParamListList.add(sqlParamList);
			}
			iService.executeRawBatch(new String[]{iSqlCommandModel.getSql()}, sqlParamListList.toArray(new SqlParamList[sqlParamListList.size()]), nBatchSize);
			nCount += nRowCount;
			if(nRowCount<nBatchSize)
				break;
		}
		
		
		
		return nCount;
	}
	
	
	/**
	 * 获取SQL 参数列表
	 * @param iSqlCommandModel
	 * @param iEntity
	 * @param iWebContext
	 * @param iDataEntityModel
	 * @return
	 * @throws Exception
	 */
	public static  SqlParamList getSqlParamList(ISqlCommandModel iSqlCommandModel,ISimpleDataObject iEntity,IWebContext iWebContext,IDataEntityModel iDataEntityModel)throws Exception {
	
		SqlParamList sqlParamList = new SqlParamList();
		Iterator<IProcParam> procParams = iSqlCommandModel.getProcParams();
		while (procParams.hasNext()) {
			IProcParam procParam = procParams.next();

			SqlParam callParam = getProcSqlParam(procParam, iEntity, iWebContext,iDataEntityModel);
			if (callParam == null) callParam = new SqlParam();
			sqlParamList.add(callParam);
		}
		
		return sqlParamList;
	}
	

	/**
	 * 获取SQL参数
	 * @param procParam
	 * @param iEntity
	 * @param iWebContext
	 * @param iDataEntityModel
	 * @return
	 * @throws Exception
	 */
	public static SqlParam getProcSqlParam(IProcParam procParam, ISimpleDataObject iEntity,IWebContext iWebContext,IDataEntityModel iDataEntityModel) throws Exception {
		SqlParam callParam = new SqlParam();
		callParam.setParamName(procParam.getParamName());
		callParam.setDataType(procParam.getDataType());

		String strParamName = procParam.getParamName().toUpperCase();
		if (strParamName.indexOf(IProcParam.TAG_VAR) == 0) {
			// 变量
			strParamName = strParamName.substring(4);


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
				java.sql.Timestamp curTime = DataTypeHelper.getTimestampValue(iEntity, IProcParam.TAG_CURTIME, null);
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
				String strTempOpPersonId = DataTypeHelper.getStringValue(iEntity, IProcParam.TAG_PERSONID, (iWebContext == null) ? null : iWebContext.getCurUserId());
				callParam.setValue(strTempOpPersonId);
			} else {
				callParam.setValue((iWebContext == null) ? null : iWebContext.getCurUserId());
			}
			callParam.setDataType(DataTypes.VARCHAR);
			return callParam;
		}
		
		if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_LOGINNAME, true) == 0) {
			if (iEntity != null) {
				String strTempOpPersonId = DataTypeHelper.getStringValue(iEntity, IProcParam.TAG_LOGINNAME, (iWebContext == null) ? null : iWebContext.getCurLoginName());
				callParam.setValue(strTempOpPersonId);
			} else {
				callParam.setValue((iWebContext == null) ? null : iWebContext.getCurLoginName());
			}
			callParam.setDataType(DataTypes.VARCHAR);
			return callParam;
		}
		

		if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_PERSONNAME, true) == 0) {
			if (iEntity != null) {
				String strTempOpPersonName = DataTypeHelper.getStringValue(iEntity, IProcParam.TAG_PERSONNAME, (iWebContext == null) ? null : iWebContext.getCurUserName());
				callParam.setValue(strTempOpPersonName);
			} else {
				callParam.setValue((iWebContext == null) ? null : iWebContext.getCurUserName());
			}
			callParam.setDataType(DataTypes.VARCHAR);
			return callParam;
		}
		
		if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_ORGID, true) == 0) {
			if (iEntity != null) {
				String strOrgId = DataTypeHelper.getStringValue(iEntity, IProcParam.TAG_ORGID, null);
				if (StringHelper.isNullOrEmpty(strOrgId) && iDataEntityModel != null) {
					IDEField ideField = iDataEntityModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGID, true);
					if (ideField != null) strOrgId = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
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
				String strOrgName = DataTypeHelper.getStringValue(iEntity, IProcParam.TAG_ORGNAME, null);
				if (StringHelper.isNullOrEmpty(strOrgName) && iDataEntityModel != null) {
					IDEField ideField = iDataEntityModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGNAME, true);
					if (ideField != null) strOrgName = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
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
				String strOrgSectorId = DataTypeHelper.getStringValue(iEntity, IProcParam.TAG_ORGSECTORID, null);
				if (StringHelper.isNullOrEmpty(strOrgSectorId) && iDataEntityModel != null) {
					IDEField ideField = iDataEntityModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGSECTORID, true);
					if (ideField != null) strOrgSectorId = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
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
				String strOrgSectorName = DataTypeHelper.getStringValue(iEntity, IProcParam.TAG_ORGSECTORNAME, null);
				if (StringHelper.isNullOrEmpty(strOrgSectorName) && iDataEntityModel != null) {
					IDEField ideField = iDataEntityModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGSECTORNAME, true);
					if (ideField != null) strOrgSectorName = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
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
			callParam.setValue(DataTypeHelper.getStringValue(iEntity, IProcParam.TAG_ACTIONARG, ""));
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
				callParam.setValue(DataTypeHelper.getIntegerValue(iEntity, IProcParam.TAG_DALOG, 1));
			} else
				callParam.setValue(1);
			return callParam;
		}

		// 检查传入的键值
		if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_CHECKKEY, true) == 0) {
			callParam.setDirection(SqlParamDirections.Input);
			callParam.setDataType(DataTypes.INT);
			if (iEntity != null) {
				callParam.setValue(DataTypeHelper.getIntegerValue(iEntity, IProcParam.TAG_CHECKKEY, 1));
			} else
				callParam.setValue(1);
			return callParam;
		}

		// 返回结果集
		if (StringHelper.compare(procParam.getParamName(), IProcParam.TAG_RETDATA, true) == 0) {
			callParam.setDirection(SqlParamDirections.Input);
			callParam.setDataType(DataTypes.INT);
			if (iEntity != null) {
				callParam.setValue(DataTypeHelper.getIntegerValue(iEntity, IProcParam.TAG_RETDATA, 1));
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
		
		callParam.setValue(procParam.getDefaultValue());
		return callParam;
	}
}
