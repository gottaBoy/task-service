/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.devcenter.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.dao.PSDCResHoursLogDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCResHoursLogDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCResHours;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCResHoursBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCResHoursLog;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCResHoursLogServiceBase
extends PSCoreSysServiceBase<PSDCResHoursLog> {
    private static final Log log = LogFactory.getLog(PSDCResHoursLogServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCResHoursLogDEModel pSDCResHoursLogDEModel;
    private PSDCResHoursLogDAO pSDCResHoursLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCResHoursLogService";
    }

    public PSDCResHoursLogDEModel getPSDCResHoursLogDEModel() {
        if (this.pSDCResHoursLogDEModel == null) {
            try {
                this.pSDCResHoursLogDEModel = (PSDCResHoursLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCResHoursLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCResHoursLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCResHoursLogDEModel();
    }

    public PSDCResHoursLogDAO getPSDCResHoursLogDAO() {
        if (this.pSDCResHoursLogDAO == null) {
            try {
                this.pSDCResHoursLogDAO = (PSDCResHoursLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCResHoursLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCResHoursLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCResHoursLogDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSDCResHoursLog pSDCResHoursLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCRESHOURSLOG_PSDCRESHOURS_PSDCRESHOURSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCResHoursService", (SessionFactory)this.getSessionFactory());
            PSDCResHours pSDCResHours = (PSDCResHours)iService.getDEModel().createEntity();
            pSDCResHours.set("PSDCRESHOURSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDCResHours);
            } else {
                iService.get((IEntity)pSDCResHours);
            }
            this.onFillParentInfo_PSDCResHours(pSDCResHoursLog, pSDCResHours);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCRESHOURSLOG_PSDEVCENTER_PSDEVCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService", (SessionFactory)this.getSessionFactory());
            PSDevCenter pSDevCenter = (PSDevCenter)iService.getDEModel().createEntity();
            pSDevCenter.set("PSDEVCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDevCenter);
            } else {
                iService.get((IEntity)pSDevCenter);
            }
            this.onFillParentInfo_PSDevCenter(pSDCResHoursLog, pSDevCenter);
            return;
        }
        super.onFillParentInfo((IEntity)pSDCResHoursLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCResHours(PSDCResHoursLog pSDCResHoursLog, PSDCResHours pSDCResHours) throws Exception {
        pSDCResHoursLog.setPSDCResHoursId(pSDCResHours.getPSDCResHoursId());
        pSDCResHoursLog.setPSDCResHoursName(pSDCResHours.getPSDCResHoursName());
    }

    protected void onFillParentInfo_PSDevCenter(PSDCResHoursLog pSDCResHoursLog, PSDevCenter pSDevCenter) throws Exception {
        pSDCResHoursLog.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCResHoursLog.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
    }

    protected void onFillEntityFullInfo(PSDCResHoursLog pSDCResHoursLog, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo((IEntity)pSDCResHoursLog, bl);
        this.onFillEntityFullInfo_PSDCResHours(pSDCResHoursLog, bl);
        this.onFillEntityFullInfo_PSDevCenter(pSDCResHoursLog, bl);
    }

    protected void onFillEntityFullInfo_PSDCResHours(PSDCResHoursLog pSDCResHoursLog, boolean bl) throws Exception {
        if (pSDCResHoursLog.isPSDCResHoursIdDirty()) {
            if (pSDCResHoursLog.getPSDCResHoursId() != null) {
                if (pSDCResHoursLog.getPSDCResHoursId() == null || pSDCResHoursLog.getPSDCResHoursName() == null) {
                    PSDCResHours pSDCResHours = pSDCResHoursLog.getPSDCResHours();
                    pSDCResHoursLog.setPSDCResHoursName(pSDCResHours.getPSDCResHoursName());
                }
            } else {
                pSDCResHoursLog.setPSDCResHoursName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevCenter(PSDCResHoursLog pSDCResHoursLog, boolean bl) throws Exception {
        if (pSDCResHoursLog.isPSDevCenterIdDirty()) {
            if (pSDCResHoursLog.getPSDevCenterId() != null) {
                if (pSDCResHoursLog.getPSDevCenterId() == null || pSDCResHoursLog.getPSDevCenterName() == null) {
                    PSDevCenter pSDevCenter = pSDCResHoursLog.getPSDevCenter();
                    pSDCResHoursLog.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
                }
            } else {
                pSDCResHoursLog.setPSDevCenterName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCResHoursLog pSDCResHoursLog, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDCResHoursLog, bl);
    }

    public ArrayList<PSDCResHoursLog> selectByPSDCResHours(PSDCResHoursBase pSDCResHoursBase) throws Exception {
        return this.selectByPSDCResHours(pSDCResHoursBase, "", -1);
    }

    public ArrayList<PSDCResHoursLog> selectByPSDCResHours(PSDCResHoursBase pSDCResHoursBase, String string) throws Exception {
        return this.selectByPSDCResHours(pSDCResHoursBase, string, -1);
    }

    public ArrayList<PSDCResHoursLog> selectByPSDCResHours(PSDCResHoursBase pSDCResHoursBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCRESHOURSID", (Object)pSDCResHoursBase.getPSDCResHoursId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCResHoursCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCResHoursCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDCResHoursLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, "", -1);
    }

    public ArrayList<PSDCResHoursLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string) throws Exception {
        return this.selectByPSDevCenter(pSDevCenterBase, string, -1);
    }

    public ArrayList<PSDCResHoursLog> selectByPSDevCenter(PSDevCenterBase pSDevCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERID", (Object)pSDevCenterBase.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCResHours(PSDCResHours pSDCResHours) throws Exception {
    }

    public void resetPSDCResHours(PSDCResHours pSDCResHours) throws Exception {
        ArrayList<PSDCResHoursLog> arrayList = this.selectByPSDCResHours(pSDCResHours);
        for (PSDCResHoursLog pSDCResHoursLog : arrayList) {
            PSDCResHoursLog pSDCResHoursLog2 = (PSDCResHoursLog)this.getDEModel().createEntity();
            pSDCResHoursLog2.setPSDCResHoursLogId(pSDCResHoursLog.getPSDCResHoursLogId());
            pSDCResHoursLog2.setPSDCResHoursId(null);
            this.update(pSDCResHoursLog2);
        }
    }

    public void removeByPSDCResHours(PSDCResHours pSDCResHours) throws Exception {
        final PSDCResHours pSDCResHours2 = pSDCResHours;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCResHoursLogServiceBase.this.onBeforeRemoveByPSDCResHours(pSDCResHours2);
                PSDCResHoursLogServiceBase.this.internalRemoveByPSDCResHours(pSDCResHours2);
                PSDCResHoursLogServiceBase.this.onAfterRemoveByPSDCResHours(pSDCResHours2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCResHours(PSDCResHours pSDCResHours) throws Exception {
    }

    protected void internalRemoveByPSDCResHours(PSDCResHours pSDCResHours) throws Exception {
        ArrayList<PSDCResHoursLog> arrayList = this.selectByPSDCResHours(pSDCResHours);
        this.onBeforeRemoveByPSDCResHours(pSDCResHours, arrayList);
        for (PSDCResHoursLog pSDCResHoursLog : arrayList) {
            this.remove((IEntity)pSDCResHoursLog);
        }
        this.onAfterRemoveByPSDCResHours(pSDCResHours, arrayList);
    }

    protected void onAfterRemoveByPSDCResHours(PSDCResHours pSDCResHours) throws Exception {
    }

    protected void onBeforeRemoveByPSDCResHours(PSDCResHours pSDCResHours, ArrayList<PSDCResHoursLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCResHours(PSDCResHours pSDCResHours, ArrayList<PSDCResHoursLog> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    public void resetPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCResHoursLog> arrayList = this.selectByPSDevCenter(pSDevCenter);
        for (PSDCResHoursLog pSDCResHoursLog : arrayList) {
            PSDCResHoursLog pSDCResHoursLog2 = (PSDCResHoursLog)this.getDEModel().createEntity();
            pSDCResHoursLog2.setPSDCResHoursLogId(pSDCResHoursLog.getPSDCResHoursLogId());
            pSDCResHoursLog2.setPSDevCenterId(null);
            this.update(pSDCResHoursLog2);
        }
    }

    public void removeByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCResHoursLogServiceBase.this.onBeforeRemoveByPSDevCenter(pSDevCenter2);
                PSDCResHoursLogServiceBase.this.internalRemoveByPSDevCenter(pSDevCenter2);
                PSDCResHoursLogServiceBase.this.onAfterRemoveByPSDevCenter(pSDevCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void internalRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        ArrayList<PSDCResHoursLog> arrayList = this.selectByPSDevCenter(pSDevCenter);
        this.onBeforeRemoveByPSDevCenter(pSDevCenter, arrayList);
        for (PSDCResHoursLog pSDCResHoursLog : arrayList) {
            this.remove((IEntity)pSDCResHoursLog);
        }
        this.onAfterRemoveByPSDevCenter(pSDevCenter, arrayList);
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCResHoursLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenter(PSDevCenter pSDevCenter, ArrayList<PSDCResHoursLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCResHoursLog pSDCResHoursLog) throws Exception {
        super.onBeforeRemove(pSDCResHoursLog);
    }

    protected void replaceParentInfo(PSDCResHoursLog pSDCResHoursLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDCResHoursLog, cloneSession);
        if (pSDCResHoursLog.getPSDCResHoursId() != null && (iEntity = cloneSession.getEntity("PSDCRESHOURS", (Object)pSDCResHoursLog.getPSDCResHoursId())) != null) {
            this.onFillParentInfo_PSDCResHours(pSDCResHoursLog, (PSDCResHours)iEntity);
        }
        if (pSDCResHoursLog.getPSDevCenterId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTER", (Object)pSDCResHoursLog.getPSDevCenterId())) != null) {
            this.onFillParentInfo_PSDevCenter(pSDCResHoursLog, (PSDevCenter)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCResHoursLog pSDCResHoursLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDCResHoursLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BeginTime(bl, pSDCResHoursLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CancelFlag(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EndTime(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Hours(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogInfo(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogLevel2(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCResHoursId(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCResHoursLogId(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCResHoursLogName(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCResHoursName(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCResId(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCResName(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterId(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterName(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSResId(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSResName(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResSpec(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResType(bl, pSDCResHoursLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDCResHoursLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BeginTime(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isBeginTimeDirty() && !bl2 : !pSDCResHoursLog.isBeginTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCResHoursLog.getBeginTime();
        if (bl) {
            if (bl2 && timestamp == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_BeginTime_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BEGINTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CancelFlag(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isCancelFlagDirty() : !pSDCResHoursLog.isCancelFlagDirty()) {
            return null;
        }
        Integer n = pSDCResHoursLog.getCancelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CancelFlag_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CANCELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EndTime(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isEndTimeDirty() && !bl2 : !pSDCResHoursLog.isEndTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDCResHoursLog.getEndTime();
        if (bl) {
            if (bl2 && timestamp == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_EndTime_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Hours(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isHoursDirty() && !bl2 : !pSDCResHoursLog.isHoursDirty()) {
            return null;
        }
        Integer n = pSDCResHoursLog.getHours();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOURS");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_Hours_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HOURS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogInfo(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isLogInfoDirty() : !pSDCResHoursLog.isLogInfoDirty()) {
            return null;
        }
        String string = pSDCResHoursLog.getLogInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogInfo_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogLevel2(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isLogLevel2Dirty() : !pSDCResHoursLog.isLogLevel2Dirty()) {
            return null;
        }
        Integer n = pSDCResHoursLog.getLogLevel2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LogLevel2_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGLEVEL2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCResHoursId(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isPSDCResHoursIdDirty() : !pSDCResHoursLog.isPSDCResHoursIdDirty()) {
            return null;
        }
        String string = pSDCResHoursLog.getPSDCResHoursId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCResHoursId_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRESHOURSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCResHoursLogId(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isPSDCResHoursLogIdDirty() && !bl2 : !pSDCResHoursLog.isPSDCResHoursLogIdDirty()) {
            return null;
        }
        String string = pSDCResHoursLog.getPSDCResHoursLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRESHOURSLOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCResHoursLogId_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRESHOURSLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCResHoursLogName(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isPSDCResHoursLogNameDirty() && !bl2 : !pSDCResHoursLog.isPSDCResHoursLogNameDirty()) {
            return null;
        }
        String string = pSDCResHoursLog.getPSDCResHoursLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRESHOURSLOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCResHoursLogName_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRESHOURSLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCResHoursName(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isPSDCResHoursNameDirty() : !pSDCResHoursLog.isPSDCResHoursNameDirty()) {
            return null;
        }
        String string = pSDCResHoursLog.getPSDCResHoursName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCResHoursName_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRESHOURSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCResId(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isPSDCResIdDirty() : !pSDCResHoursLog.isPSDCResIdDirty()) {
            return null;
        }
        String string = pSDCResHoursLog.getPSDCResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCResId_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCResName(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isPSDCResNameDirty() : !pSDCResHoursLog.isPSDCResNameDirty()) {
            return null;
        }
        String string = pSDCResHoursLog.getPSDCResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCResName_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterId(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isPSDevCenterIdDirty() : !pSDCResHoursLog.isPSDevCenterIdDirty()) {
            return null;
        }
        String string = pSDCResHoursLog.getPSDevCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterId_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterName(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isPSDevCenterNameDirty() : !pSDCResHoursLog.isPSDevCenterNameDirty()) {
            return null;
        }
        String string = pSDCResHoursLog.getPSDevCenterName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterName_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSResId(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isPSResIdDirty() : !pSDCResHoursLog.isPSResIdDirty()) {
            return null;
        }
        String string = pSDCResHoursLog.getPSResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSResId_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSResName(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isPSResNameDirty() : !pSDCResHoursLog.isPSResNameDirty()) {
            return null;
        }
        String string = pSDCResHoursLog.getPSResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSResName_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResSpec(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isResSpecDirty() && !bl2 : !pSDCResHoursLog.isResSpecDirty()) {
            return null;
        }
        String string = pSDCResHoursLog.getResSpec();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESSPEC");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResSpec_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESSPEC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResType(boolean bl, PSDCResHoursLog pSDCResHoursLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCResHoursLog.isResTypeDirty() && !bl2 : !pSDCResHoursLog.isResTypeDirty()) {
            return null;
        }
        String string = pSDCResHoursLog.getResType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResType_Default((IEntity)pSDCResHoursLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCResHoursLog pSDCResHoursLog, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDCResHoursLog, bl);
    }

    protected void onSyncIndexEntities(PSDCResHoursLog pSDCResHoursLog, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDCResHoursLog, bl);
    }

    public Object getDataContextValue(PSDCResHoursLog pSDCResHoursLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDCResHoursLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCResHoursLog pSDCResHoursLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSDCResHoursLog, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BEGINTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BeginTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CANCELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CancelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EndTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HOURS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Hours_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGLEVEL2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogLevel2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCRESHOURSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCResHoursId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCRESHOURSLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCResHoursLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCRESHOURSLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCResHoursLogName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCRESHOURSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCResHoursName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESSPEC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResSpec_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BeginTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CancelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EndTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Hours_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGINFO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogLevel2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDCResHoursId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCRESHOURSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCResHoursLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCRESHOURSLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCResHoursLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCRESHOURSLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCResHoursName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCRESHOURSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResSpec_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESSPEC", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDCResHoursLog pSDCResHoursLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDCResHoursLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCResHoursLog pSDCResHoursLog) throws Exception {
        super.onUpdateParent((IEntity)pSDCResHoursLog);
    }

    @Override
    protected void exportCurXmlModel(PSDCResHoursLog pSDCResHoursLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCRESHOURSLOG");
        if (!bl) {
            pSDCResHoursLog.setCreateDate(null);
            pSDCResHoursLog.setCreateMan(null);
            pSDCResHoursLog.setLogLevel2(null);
            pSDCResHoursLog.setPSDCResHoursLogId(null);
            pSDCResHoursLog.setUpdateDate(null);
            pSDCResHoursLog.setUpdateMan(null);
            super.exportCurXmlModel(pSDCResHoursLog, xmlNode, bl);
        }
    }
}

