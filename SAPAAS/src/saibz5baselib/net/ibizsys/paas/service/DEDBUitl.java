/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.demodel.ISqlCommandModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import org.hibernate.SessionFactory;

public class DEDBUitl {
    public static int syncData(IDataEntityModel iDataEntityModel, IDataTable iDataTable) throws Exception {
        return DEDBUitl.syncData(iDataEntityModel, iDataTable, null);
    }

    public static int syncData(IDataEntityModel iDataEntityModel, IDataTable iDataTable, SessionFactory sessionFactory) throws Exception {
        return DEDBUitl.syncData(iDataEntityModel, iDataTable, sessionFactory, 100);
    }

    public static int syncData(IDataEntityModel iDataEntityModel, IDataTable iDataTable, SessionFactory sessionFactory, int nBatchSize) throws Exception {
        int nRowCount;
        IService iService = iDataEntityModel.getService(sessionFactory);
        ISqlCommandModel iSqlCommandModel = iDataEntityModel.getMergeSqlCommandModel(iService.getDAO().getRealDBDialect());
        int nCount = 0;
        do {
            ArrayList<SqlParamList> sqlParamListList = new ArrayList<SqlParamList>();
            nRowCount = iDataTable.cacheRows(nBatchSize);
            int i = 0;
            while (i < nRowCount) {
                IDataRow iDataRow = iDataTable.getCachedRow(i);
                SqlParamList sqlParamList = DEDBUitl.getSqlParamList(iSqlCommandModel, iDataRow, null, iDataEntityModel);
                sqlParamListList.add(sqlParamList);
                ++i;
            }
            iService.executeRawBatch(new String[]{iSqlCommandModel.getSql()}, sqlParamListList.toArray(new SqlParamList[sqlParamListList.size()]), nBatchSize);
            nCount += nRowCount;
        } while (nRowCount >= nBatchSize);
        return nCount;
    }

    public static SqlParamList getSqlParamList(ISqlCommandModel iSqlCommandModel, ISimpleDataObject iEntity, IWebContext iWebContext, IDataEntityModel iDataEntityModel) throws Exception {
        SqlParamList sqlParamList = new SqlParamList();
        Iterator<IProcParam> procParams = iSqlCommandModel.getProcParams();
        while (procParams.hasNext()) {
            IProcParam procParam = procParams.next();
            SqlParam callParam = DEDBUitl.getProcSqlParam(procParam, iEntity, iWebContext, iDataEntityModel);
            if (callParam == null) {
                callParam = new SqlParam();
            }
            sqlParamList.add(callParam);
        }
        return sqlParamList;
    }

    public static SqlParam getProcSqlParam(IProcParam procParam, ISimpleDataObject iEntity, IWebContext iWebContext, IDataEntityModel iDataEntityModel) throws Exception {
        SqlParam callParam = new SqlParam();
        callParam.setParamName(procParam.getParamName());
        callParam.setDataType(procParam.getDataType());
        String strParamName = procParam.getParamName().toUpperCase();
        if (strParamName.indexOf("VAR_") == 0) {
            Object objValue;
            strParamName = strParamName.substring(4);
            Object object = objValue = iEntity == null ? null : iEntity.get(strParamName);
            if (objValue != null && objValue instanceof String && StringHelper.isNullOrEmpty((String)objValue)) {
                objValue = null;
            }
            callParam.setValue(objValue);
            callParam.setDirection(procParam.getDirection());
            callParam.setOutputParamName(strParamName);
            return callParam;
        }
        if (strParamName.indexOf("VF_") == 0) {
            strParamName = strParamName.substring(3);
            if (iEntity != null && iEntity.contains(strParamName)) {
                callParam.setValue(1);
            } else {
                callParam.setValue(0);
            }
            callParam.setDataType(9);
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_CURTIME", true) == 0) {
            if (iEntity != null) {
                Timestamp curTime = DataTypeHelper.getTimestampValue(iEntity, "SRF_CURTIME", null);
                if (curTime == null) {
                    curTime = DateHelper.getCurTime();
                }
                callParam.setValue(curTime);
            } else {
                callParam.setValue(DateHelper.getCurTime());
            }
            callParam.setDataType(5);
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_PERSONID", true) == 0) {
            if (iEntity != null) {
                String strTempOpPersonId = DataTypeHelper.getStringValue(iEntity, "SRF_PERSONID", iWebContext == null ? null : iWebContext.getCurUserId());
                callParam.setValue(strTempOpPersonId);
            } else {
                callParam.setValue(iWebContext == null ? null : iWebContext.getCurUserId());
            }
            callParam.setDataType(25);
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_LOGINNAME", true) == 0) {
            if (iEntity != null) {
                String strTempOpPersonId = DataTypeHelper.getStringValue(iEntity, "SRF_LOGINNAME", iWebContext == null ? null : iWebContext.getCurLoginName());
                callParam.setValue(strTempOpPersonId);
            } else {
                callParam.setValue(iWebContext == null ? null : iWebContext.getCurLoginName());
            }
            callParam.setDataType(25);
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_PERSONNAME", true) == 0) {
            if (iEntity != null) {
                String strTempOpPersonName = DataTypeHelper.getStringValue(iEntity, "SRF_PERSONNAME", iWebContext == null ? null : iWebContext.getCurUserName());
                callParam.setValue(strTempOpPersonName);
            } else {
                callParam.setValue(iWebContext == null ? null : iWebContext.getCurUserName());
            }
            callParam.setDataType(25);
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_ORGID", true) == 0) {
            if (iEntity != null) {
                IDEField ideField;
                String strOrgId = DataTypeHelper.getStringValue(iEntity, "SRF_ORGID", null);
                if (StringHelper.isNullOrEmpty(strOrgId) && iDataEntityModel != null && (ideField = iDataEntityModel.getDEFieldByPDT("ORGID", true)) != null) {
                    strOrgId = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
                }
                if (StringHelper.isNullOrEmpty(strOrgId) && iWebContext != null) {
                    strOrgId = iWebContext.getCurOrgId();
                }
                callParam.setValue(strOrgId);
            } else {
                callParam.setValue(iWebContext == null ? null : iWebContext.getCurOrgId());
            }
            callParam.setDataType(25);
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_ORGNAME", true) == 0) {
            if (iEntity != null) {
                IDEField ideField;
                String strOrgName = DataTypeHelper.getStringValue(iEntity, "SRF_ORGNAME", null);
                if (StringHelper.isNullOrEmpty(strOrgName) && iDataEntityModel != null && (ideField = iDataEntityModel.getDEFieldByPDT("ORGNAME", true)) != null) {
                    strOrgName = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
                }
                if (StringHelper.isNullOrEmpty(strOrgName) && iWebContext != null) {
                    strOrgName = iWebContext.getCurOrgName();
                }
                callParam.setValue(strOrgName);
            } else {
                callParam.setValue(iWebContext == null ? null : iWebContext.getCurOrgName());
            }
            callParam.setDataType(25);
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_ORGSECTORID", true) == 0) {
            if (iEntity != null) {
                IDEField ideField;
                String strOrgSectorId = DataTypeHelper.getStringValue(iEntity, "SRF_ORGSECTORID", null);
                if (StringHelper.isNullOrEmpty(strOrgSectorId) && iDataEntityModel != null && (ideField = iDataEntityModel.getDEFieldByPDT("ORGSECTORID", true)) != null) {
                    strOrgSectorId = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
                }
                if (StringHelper.isNullOrEmpty(strOrgSectorId) && iWebContext != null) {
                    strOrgSectorId = iWebContext.getCurOrgSectorId();
                }
                callParam.setValue(strOrgSectorId);
            } else {
                callParam.setValue(iWebContext == null ? null : iWebContext.getCurOrgSectorId());
            }
            callParam.setDataType(25);
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_ORGSECTORNAME", true) == 0) {
            if (iEntity != null) {
                IDEField ideField;
                String strOrgSectorName = DataTypeHelper.getStringValue(iEntity, "SRF_ORGSECTORNAME", null);
                if (StringHelper.isNullOrEmpty(strOrgSectorName) && iDataEntityModel != null && (ideField = iDataEntityModel.getDEFieldByPDT("ORGSECTORNAME", true)) != null) {
                    strOrgSectorName = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
                }
                if (StringHelper.isNullOrEmpty(strOrgSectorName) && iWebContext != null) {
                    strOrgSectorName = iWebContext.getCurOrgSectorName();
                }
                callParam.setValue(strOrgSectorName);
            } else {
                callParam.setValue(iWebContext == null ? null : iWebContext.getCurOrgSectorName());
            }
            callParam.setDataType(25);
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_ACTIONARG", true) == 0) {
            callParam.setValue(DataTypeHelper.getStringValue(iEntity, "SRF_ACTIONARG", ""));
            callParam.setDataType(25);
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_RD", true) == 0) {
            callParam.setDirection(2);
            callParam.setOutputParamName("SRF_RD");
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_RETCODE", true) == 0) {
            callParam.setDirection(2);
            callParam.setDataType(9);
            callParam.setOutputParamName("SRF_RETCODE");
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_RETINFO", true) == 0) {
            callParam.setDirection(2);
            callParam.setDataType(25);
            callParam.setOutputParamName("SRF_RETINFO");
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_RETINFORES", true) == 0) {
            callParam.setDirection(2);
            callParam.setDataType(25);
            callParam.setOutputParamName("SRF_RETINFORES");
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_RETINFORESARG", true) == 0) {
            callParam.setDirection(2);
            callParam.setDataType(25);
            callParam.setOutputParamName("SRF_RETINFORESARG");
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_DALOG", true) == 0) {
            callParam.setDirection(1);
            callParam.setDataType(9);
            if (iEntity != null) {
                callParam.setValue(DataTypeHelper.getIntegerValue(iEntity, "SRF_DALOG", 1));
            } else {
                callParam.setValue(1);
            }
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_CHECKKEY", true) == 0) {
            callParam.setDirection(1);
            callParam.setDataType(9);
            if (iEntity != null) {
                callParam.setValue(DataTypeHelper.getIntegerValue(iEntity, "SRF_CHECKKEY", 1));
            } else {
                callParam.setValue(1);
            }
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_RETDATA", true) == 0) {
            callParam.setDirection(1);
            callParam.setDataType(9);
            if (iEntity != null) {
                callParam.setValue(DataTypeHelper.getIntegerValue(iEntity, "SRF_RETDATA", 1));
            } else {
                callParam.setValue(1);
            }
            return callParam;
        }
        if (StringHelper.compare(procParam.getParamName(), "SRF_TAG", true) == 0) {
            callParam.setDirection(2);
            callParam.setDataType(25);
            callParam.setOutputParamName("SRF_TAG");
            return callParam;
        }
        callParam.setValue(procParam.getDefaultValue());
        return callParam;
    }
}

