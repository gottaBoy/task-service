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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCRobotLogDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCRobotLogDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotLog;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCRobotLogServiceBase
extends PSCoreSysServiceBase<PSDCRobotLog> {
    private static final Log log = LogFactory.getLog(PSDCRobotLogServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCRobotLogDEModel pSDCRobotLogDEModel;
    private PSDCRobotLogDAO pSDCRobotLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCRobotLogService";
    }

    public PSDCRobotLogDEModel getPSDCRobotLogDEModel() {
        if (this.pSDCRobotLogDEModel == null) {
            try {
                this.pSDCRobotLogDEModel = (PSDCRobotLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCRobotLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRobotLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCRobotLogDEModel();
    }

    public PSDCRobotLogDAO getPSDCRobotLogDAO() {
        if (this.pSDCRobotLogDAO == null) {
            try {
                this.pSDCRobotLogDAO = (PSDCRobotLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCRobotLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRobotLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCRobotLogDAO();
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

    protected void onFillParentInfo(PSDCRobotLog pSDCRobotLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCROBOTLOG_PSDCROBOT_PSDCROBOTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService", (SessionFactory)this.getSessionFactory());
            PSDCRobot pSDCRobot = (PSDCRobot)iService.getDEModel().createEntity();
            pSDCRobot.set("PSDCROBOTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCRobot);
            } else {
                iService.get(pSDCRobot);
            }
            this.onFillParentInfo_PSDCRobot(pSDCRobotLog, pSDCRobot);
            return;
        }
        super.onFillParentInfo(pSDCRobotLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCRobot(PSDCRobotLog pSDCRobotLog, PSDCRobot pSDCRobot) throws Exception {
        pSDCRobotLog.setPSDCRobotId(pSDCRobot.getPSDCRobotId());
        pSDCRobotLog.setPSDCRobotName(pSDCRobot.getPSDCRobotName());
    }

    protected void onFillEntityFullInfo(PSDCRobotLog pSDCRobotLog, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCRobotLog, bl);
        this.onFillEntityFullInfo_PSDCRobot(pSDCRobotLog, bl);
    }

    protected void onFillEntityFullInfo_PSDCRobot(PSDCRobotLog pSDCRobotLog, boolean bl) throws Exception {
        if (pSDCRobotLog.isPSDCRobotIdDirty()) {
            if (pSDCRobotLog.getPSDCRobotId() != null) {
                if (pSDCRobotLog.getPSDCRobotId() == null || pSDCRobotLog.getPSDCRobotName() == null) {
                    PSDCRobot pSDCRobot = pSDCRobotLog.getPSDCRobot();
                    pSDCRobotLog.setPSDCRobotName(pSDCRobot.getPSDCRobotName());
                }
            } else {
                pSDCRobotLog.setPSDCRobotName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCRobotLog pSDCRobotLog, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCRobotLog, bl);
    }

    public ArrayList<PSDCRobotLog> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase) throws Exception {
        return this.selectByPSDCRobot(pSDCRobotBase, "", -1);
    }

    public ArrayList<PSDCRobotLog> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase, String string) throws Exception {
        return this.selectByPSDCRobot(pSDCRobotBase, string, -1);
    }

    public ArrayList<PSDCRobotLog> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCROBOTID", (Object)pSDCRobotBase.getPSDCRobotId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCRobotCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCRobotCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    public void resetPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSDCRobotLog> arrayList = this.selectByPSDCRobot(pSDCRobot);
        for (PSDCRobotLog pSDCRobotLog : arrayList) {
            PSDCRobotLog pSDCRobotLog2 = (PSDCRobotLog)this.getDEModel().createEntity();
            pSDCRobotLog2.setPSDCRobotLogId(pSDCRobotLog.getPSDCRobotLogId());
            pSDCRobotLog2.setPSDCRobotId(null);
            this.update(pSDCRobotLog2);
        }
    }

    public void removeByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        final PSDCRobot pSDCRobot2 = pSDCRobot;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCRobotLogServiceBase.this.onBeforeRemoveByPSDCRobot(pSDCRobot2);
                PSDCRobotLogServiceBase.this.internalRemoveByPSDCRobot(pSDCRobot2);
                PSDCRobotLogServiceBase.this.onAfterRemoveByPSDCRobot(pSDCRobot2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void internalRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSDCRobotLog> arrayList = this.selectByPSDCRobot(pSDCRobot);
        this.onBeforeRemoveByPSDCRobot(pSDCRobot, arrayList);
        for (PSDCRobotLog pSDCRobotLog : arrayList) {
            this.remove(pSDCRobotLog);
        }
        this.onAfterRemoveByPSDCRobot(pSDCRobot, arrayList);
    }

    protected void onAfterRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void onBeforeRemoveByPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSDCRobotLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSDCRobotLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCRobotLog pSDCRobotLog) throws Exception {
        super.onBeforeRemove(pSDCRobotLog);
    }

    protected void replaceParentInfo(PSDCRobotLog pSDCRobotLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCRobotLog, cloneSession);
        if (pSDCRobotLog.getPSDCRobotId() != null && (iEntity = cloneSession.getEntity("PSDCROBOT", (Object)pSDCRobotLog.getPSDCRobotId())) != null) {
            this.onFillParentInfo_PSDCRobot(pSDCRobotLog, (PSDCRobot)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCRobotLog pSDCRobotLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCRobotLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCRobotLog pSDCRobotLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CancelFlag(bl, pSDCRobotLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Energy(bl, pSDCRobotLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogInfo(bl, pSDCRobotLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogLevel(bl, pSDCRobotLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogLevel2(bl, pSDCRobotLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogType(bl, pSDCRobotLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotId(bl, pSDCRobotLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotLogId(bl, pSDCRobotLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotLogName(bl, pSDCRobotLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotName(bl, pSDCRobotLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDCRobotLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDCRobotLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDCRobotLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDCRobotLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCRobotLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CancelFlag(boolean bl, PSDCRobotLog pSDCRobotLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotLog.isCancelFlagDirty() : !pSDCRobotLog.isCancelFlagDirty()) {
            return null;
        }
        Integer n = pSDCRobotLog.getCancelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CancelFlag_Default(pSDCRobotLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_Energy(boolean bl, PSDCRobotLog pSDCRobotLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotLog.isEnergyDirty() : !pSDCRobotLog.isEnergyDirty()) {
            return null;
        }
        Integer n = pSDCRobotLog.getEnergy();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Energy_Default(pSDCRobotLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENERGY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogInfo(boolean bl, PSDCRobotLog pSDCRobotLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotLog.isLogInfoDirty() : !pSDCRobotLog.isLogInfoDirty()) {
            return null;
        }
        String string = pSDCRobotLog.getLogInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogInfo_Default(pSDCRobotLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogLevel(boolean bl, PSDCRobotLog pSDCRobotLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotLog.isLogLevelDirty() : !pSDCRobotLog.isLogLevelDirty()) {
            return null;
        }
        String string = pSDCRobotLog.getLogLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogLevel_Default(pSDCRobotLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogLevel2(boolean bl, PSDCRobotLog pSDCRobotLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotLog.isLogLevel2Dirty() : !pSDCRobotLog.isLogLevel2Dirty()) {
            return null;
        }
        Integer n = pSDCRobotLog.getLogLevel2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LogLevel2_Default(pSDCRobotLog, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogType(boolean bl, PSDCRobotLog pSDCRobotLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotLog.isLogTypeDirty() && !bl2 : !pSDCRobotLog.isLogTypeDirty()) {
            return null;
        }
        String string = pSDCRobotLog.getLogType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogType_Default(pSDCRobotLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRobotId(boolean bl, PSDCRobotLog pSDCRobotLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotLog.isPSDCRobotIdDirty() : !pSDCRobotLog.isPSDCRobotIdDirty()) {
            return null;
        }
        String string = pSDCRobotLog.getPSDCRobotId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotId_Default(pSDCRobotLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRobotLogId(boolean bl, PSDCRobotLog pSDCRobotLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotLog.isPSDCRobotLogIdDirty() && !bl2 : !pSDCRobotLog.isPSDCRobotLogIdDirty()) {
            return null;
        }
        String string = pSDCRobotLog.getPSDCRobotLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTLOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotLogId_Default(pSDCRobotLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTLOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRobotLogName(boolean bl, PSDCRobotLog pSDCRobotLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotLog.isPSDCRobotLogNameDirty() && !bl2 : !pSDCRobotLog.isPSDCRobotLogNameDirty()) {
            return null;
        }
        String string = pSDCRobotLog.getPSDCRobotLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTLOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotLogName_Default(pSDCRobotLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTLOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRobotName(boolean bl, PSDCRobotLog pSDCRobotLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotLog.isPSDCRobotNameDirty() : !pSDCRobotLog.isPSDCRobotNameDirty()) {
            return null;
        }
        String string = pSDCRobotLog.getPSDCRobotName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotName_Default(pSDCRobotLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDCRobotLog pSDCRobotLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotLog.isUserTagDirty() : !pSDCRobotLog.isUserTagDirty()) {
            return null;
        }
        String string = pSDCRobotLog.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDCRobotLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDCRobotLog pSDCRobotLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotLog.isUserTag2Dirty() : !pSDCRobotLog.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDCRobotLog.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDCRobotLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDCRobotLog pSDCRobotLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotLog.isUserTag3Dirty() : !pSDCRobotLog.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDCRobotLog.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDCRobotLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDCRobotLog pSDCRobotLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCRobotLog.isUserTag4Dirty() : !pSDCRobotLog.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDCRobotLog.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDCRobotLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCRobotLog pSDCRobotLog, boolean bl) throws Exception {
        super.onSyncEntity(pSDCRobotLog, bl);
    }

    protected void onSyncIndexEntities(PSDCRobotLog pSDCRobotLog, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCRobotLog, bl);
    }

    public Object getDataContextValue(PSDCRobotLog pSDCRobotLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCRobotLog, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSDCRobotLog pSDCRobotLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCRobotLog, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CANCELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CancelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENERGY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Energy_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogLevel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGLEVEL2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogLevel2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCROBOTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRobotId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCROBOTLOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRobotLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCROBOTLOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRobotLogName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCROBOTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRobotName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_Energy_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_LogLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGLEVEL", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogLevel2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRobotId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCROBOTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRobotLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCROBOTLOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRobotLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCROBOTLOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRobotName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCROBOTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSDCRobotLog pSDCRobotLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCRobotLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCRobotLog pSDCRobotLog) throws Exception {
        super.onUpdateParent(pSDCRobotLog);
    }

    @Override
    protected void exportCurXmlModel(PSDCRobotLog pSDCRobotLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCROBOTLOG");
        if (!bl) {
            pSDCRobotLog.setCreateDate(null);
            pSDCRobotLog.setCreateMan(null);
            pSDCRobotLog.setLogLevel2(null);
            pSDCRobotLog.setPSDCRobotLogId(null);
            pSDCRobotLog.setUpdateDate(null);
            pSDCRobotLog.setUpdateMan(null);
            super.exportCurXmlModel(pSDCRobotLog, xmlNode, bl);
        }
    }
}

