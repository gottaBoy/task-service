/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import java.lang.annotation.Annotation;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.DBProcParams;
import net.ibizsys.paas.core.DEDBProc;
import net.ibizsys.paas.core.DEDBProcDialect;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEActionModelBase;
import net.ibizsys.paas.demodel.DEDBProcParamsModel;
import net.ibizsys.paas.demodel.IDEDBProcModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

public abstract class DEDBProcModelBase
extends DEActionModelBase
implements IDEDBProcModel {
    private IDataEntity iDataEntity = null;
    private DEDBProc deDBProc = null;
    private HashMap<String, DEDBProcParamsModel> dbProcParamsMap = new HashMap();

    public void init(IDataEntity iDataEntity) throws Exception {
        this.setDataEntity(iDataEntity);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
    }

    protected void initAnnotation(Class c) {
        Annotation[] annotations = c.getAnnotations();
        if (annotations != null) {
            Annotation[] annotationArray = annotations;
            int n = annotations.length;
            int n2 = 0;
            while (n2 < n) {
                Annotation annotation = annotationArray[n2];
                if (annotation instanceof DEDBProc) {
                    this.prepareDEDBProc((DEDBProc)annotation);
                } else if (annotation instanceof DEDBProcDialect) {
                    this.prepareDEDBProcDialect((DEDBProcDialect)annotation);
                }
                ++n2;
            }
        }
    }

    protected void prepareDEDBProc(DEDBProc deDBProc) {
        this.deDBProc = deDBProc;
    }

    protected void prepareDEDBProcDialect(DEDBProcDialect deDBProcDialect) {
        DBProcParams[] dBProcParamsArray = deDBProcDialect.value();
        int n = dBProcParamsArray.length;
        int n2 = 0;
        while (n2 < n) {
            DBProcParams deProcParams = dBProcParamsArray[n2];
            DEDBProcParamsModel deDBProcParamsModel = this.createDEDBProcParamsModel(deProcParams);
            this.dbProcParamsMap.put(deDBProcParamsModel.getDBType(), deDBProcParamsModel);
            ++n2;
        }
    }

    protected DEDBProcParamsModel createDEDBProcParamsModel(DBProcParams deProcParams) {
        DEDBProcParamsModel deDBProcParamsModel = new DEDBProcParamsModel();
        deDBProcParamsModel.init(deProcParams);
        return deDBProcParamsModel;
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    protected void setDataEntity(IDataEntity iDataEntity) {
        this.iDataEntity = iDataEntity;
    }

    @Override
    public int getTimeOut() {
        return this.deDBProc.timeout();
    }

    @Override
    public String getDBProcName() {
        return this.deDBProc.procname();
    }

    @Override
    public String getActionMode() {
        return null;
    }

    @Override
    public Iterator<IProcParam> getProcParams(String strDBType) throws Exception {
        DEDBProcParamsModel deDBProcParamsModel = this.dbProcParamsMap.get(strDBType);
        if (deDBProcParamsModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5236\u5b9a\u6570\u636e\u5e93\u7c7b\u578b\u8fc7\u7a0b\u53c2\u6570[%1$s]", strDBType));
        }
        return deDBProcParamsModel.getProcParams();
    }

    @Override
    public String getId() {
        return this.deDBProc.id();
    }

    @Override
    public String getName() {
        return this.deDBProc.name();
    }

    @Override
    public void fillSqlParams(String strDBType, IEntity iEntity, IWebContext iWebContext, SqlParamList sqlParamList) throws Exception {
        Iterator<IProcParam> procParams = this.getProcParams(strDBType);
        while (procParams.hasNext()) {
            IProcParam procParam = procParams.next();
            SqlParam callParam = this.getProcSqlParam(strDBType, procParam, iEntity, iWebContext);
            if (callParam == null) {
                callParam = new SqlParam();
            }
            sqlParamList.add(callParam);
        }
    }

    protected SqlParam getProcSqlParam(String strDBType, IProcParam procParam, IEntity iEntity, IWebContext iWebContext) throws Exception {
        return this.getProcSqlParam(procParam, iEntity, iWebContext);
    }

    protected SqlParam getProcSqlParam(IProcParam procParam, IEntity iEntity, IWebContext iWebContext) throws Exception {
        return DEDBProcModelBase.getProcSqlParam(procParam, iEntity, iWebContext, this.getDataEntity());
    }

    public static SqlParam getProcSqlParam(IProcParam procParam, IEntity iEntity, IWebContext iWebContext, IDataEntity iDataEntity) throws Exception {
        SqlParam callParam = new SqlParam();
        callParam.setParamName(procParam.getParamName());
        callParam.setDataType(procParam.getDataType());
        if (!StringHelper.isNullOrEmpty(procParam.getParamName())) {
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
                    Timestamp curTime = DataObject.getTimestampValue(iEntity, "SRF_CURTIME", null);
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
                    String strTempOpPersonId = DataObject.getStringValue(iEntity, "SRF_PERSONID", iWebContext == null ? null : iWebContext.getCurUserId());
                    callParam.setValue(strTempOpPersonId);
                } else {
                    callParam.setValue(iWebContext == null ? null : iWebContext.getCurUserId());
                }
                callParam.setDataType(25);
                return callParam;
            }
            if (StringHelper.compare(procParam.getParamName(), "SRF_LOGINNAME", true) == 0) {
                if (iEntity != null) {
                    String strTempLoginName = DataObject.getStringValue(iEntity, "SRF_LOGINNAME", iWebContext == null ? null : iWebContext.getCurLoginName());
                    if (StringHelper.isNullOrEmpty(strTempLoginName)) {
                        strTempLoginName = DataObject.getStringValue(iEntity, "SRF_PERSONID", iWebContext == null ? null : iWebContext.getCurUserId());
                    }
                    callParam.setValue(strTempLoginName);
                } else {
                    String strTempLoginName;
                    String string = strTempLoginName = iWebContext == null ? null : iWebContext.getCurLoginName();
                    if (StringHelper.isNullOrEmpty(strTempLoginName)) {
                        strTempLoginName = iWebContext == null ? null : iWebContext.getCurUserId();
                    }
                    callParam.setValue(strTempLoginName);
                }
                callParam.setDataType(25);
                return callParam;
            }
            if (StringHelper.compare(procParam.getParamName(), "SRF_PERSONNAME", true) == 0) {
                if (iEntity != null) {
                    String strTempOpPersonName = DataObject.getStringValue(iEntity, "SRF_PERSONNAME", iWebContext == null ? null : iWebContext.getCurUserName());
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
                    String strOrgId = DataObject.getStringValue(iEntity, "SRF_ORGID", null);
                    if (StringHelper.isNullOrEmpty(strOrgId) && iDataEntity != null && (ideField = ((IDataEntityModel)iDataEntity).getDEFieldByPDT("ORGID", true)) != null) {
                        strOrgId = DataObject.getStringValue(iEntity, ideField.getName(), null);
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
                    String strOrgName = DataObject.getStringValue(iEntity, "SRF_ORGNAME", null);
                    if (StringHelper.isNullOrEmpty(strOrgName) && iDataEntity != null && (ideField = ((IDataEntityModel)iDataEntity).getDEFieldByPDT("ORGNAME", true)) != null) {
                        strOrgName = DataObject.getStringValue(iEntity, ideField.getName(), null);
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
                    String strOrgSectorId = DataObject.getStringValue(iEntity, "SRF_ORGSECTORID", null);
                    if (StringHelper.isNullOrEmpty(strOrgSectorId) && iDataEntity != null && (ideField = ((IDataEntityModel)iDataEntity).getDEFieldByPDT("ORGSECTORID", true)) != null) {
                        strOrgSectorId = DataObject.getStringValue(iEntity, ideField.getName(), null);
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
                    String strOrgSectorName = DataObject.getStringValue(iEntity, "SRF_ORGSECTORNAME", null);
                    if (StringHelper.isNullOrEmpty(strOrgSectorName) && iDataEntity != null && (ideField = ((IDataEntityModel)iDataEntity).getDEFieldByPDT("ORGSECTORNAME", true)) != null) {
                        strOrgSectorName = DataObject.getStringValue(iEntity, ideField.getName(), null);
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
                callParam.setValue(DataObject.getStringValue(iEntity, "SRF_ACTIONARG", ""));
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
                    callParam.setValue(DataObject.getIntegerValue(iEntity, "SRF_DALOG", 1));
                } else {
                    callParam.setValue(1);
                }
                return callParam;
            }
            if (StringHelper.compare(procParam.getParamName(), "SRF_CHECKKEY", true) == 0) {
                callParam.setDirection(1);
                callParam.setDataType(9);
                if (iEntity != null) {
                    callParam.setValue(DataObject.getIntegerValue(iEntity, "SRF_CHECKKEY", 1));
                } else {
                    callParam.setValue(1);
                }
                return callParam;
            }
            if (StringHelper.compare(procParam.getParamName(), "SRF_RETDATA", true) == 0) {
                callParam.setDirection(1);
                callParam.setDataType(9);
                if (iEntity != null) {
                    callParam.setValue(DataObject.getIntegerValue(iEntity, "SRF_RETDATA", 1));
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
            if (StringHelper.compare(procParam.getParamName(), "SRF_DRAFTFLAG", true) == 0) {
                if (EntityBase.hasDraftFlag(iEntity)) {
                    callParam.setValue(EntityBase.isDraft(iEntity) ? 1 : 0);
                } else {
                    callParam.setValue(procParam.getDefaultValue());
                    int nDefaultValue = 1;
                    if (procParam.getDefaultValue() != null) {
                        nDefaultValue = (Integer)procParam.getDefaultValue();
                    }
                    if (nDefaultValue == 1) {
                        Object objValue;
                        Object object = objValue = iEntity == null ? null : iEntity.get("SRFORIKEY");
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

