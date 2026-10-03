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
package net.ibizsys.pscore.srv.config.service;

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
import net.ibizsys.pscore.srv.config.dao.PSPFStyleLogDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFStyleLogDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleLog;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFStyleLogServiceBase
extends PSCoreSysServiceBase<PSPFStyleLog> {
    private static final Log log = LogFactory.getLog(PSPFStyleLogServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFStyleLogDEModel pSPFStyleLogDEModel;
    private PSPFStyleLogDAO pSPFStyleLogDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFStyleLogService";
    }

    public PSPFStyleLogDEModel getPSPFStyleLogDEModel() {
        if (this.pSPFStyleLogDEModel == null) {
            try {
                this.pSPFStyleLogDEModel = (PSPFStyleLogDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFStyleLogDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFStyleLogDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFStyleLogDEModel();
    }

    public PSPFStyleLogDAO getPSPFStyleLogDAO() {
        if (this.pSPFStyleLogDAO == null) {
            try {
                this.pSPFStyleLogDAO = (PSPFStyleLogDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFStyleLogDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFStyleLogDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFStyleLogDAO();
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

    protected void onFillParentInfo(PSPFStyleLog pSPFStyleLog, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFSTYLELOG_PSPFSTYLE_PSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFStyle);
            } else {
                iService.get(pSPFStyle);
            }
            this.onFillParentInfo_PSPFStyle(pSPFStyleLog, pSPFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFSTYLELOG_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPF);
            } else {
                iService.get(pSPF);
            }
            this.onFillParentInfo_PSPF(pSPFStyleLog, pSPF);
            return;
        }
        super.onFillParentInfo(pSPFStyleLog, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSPFStyle(PSPFStyleLog pSPFStyleLog, PSPFStyle pSPFStyle) throws Exception {
        pSPFStyleLog.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
        pSPFStyleLog.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
    }

    protected void onFillParentInfo_PSPF(PSPFStyleLog pSPFStyleLog, PSPF pSPF) throws Exception {
        pSPFStyleLog.setPSPFId(pSPF.getPSPFId());
        pSPFStyleLog.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillEntityFullInfo(PSPFStyleLog pSPFStyleLog, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSPFStyleLog, bl);
        this.onFillEntityFullInfo_PSPFStyle(pSPFStyleLog, bl);
        this.onFillEntityFullInfo_PSPF(pSPFStyleLog, bl);
    }

    protected void onFillEntityFullInfo_PSPFStyle(PSPFStyleLog pSPFStyleLog, boolean bl) throws Exception {
        if (pSPFStyleLog.isPSPFStyleIdDirty()) {
            if (pSPFStyleLog.getPSPFStyleId() != null) {
                if (pSPFStyleLog.getPSPFStyleId() == null || pSPFStyleLog.getPSPFStyleName() == null) {
                    PSPFStyle pSPFStyle = pSPFStyleLog.getPSPFStyle();
                    pSPFStyleLog.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
                }
            } else {
                pSPFStyleLog.setPSPFStyleName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPF(PSPFStyleLog pSPFStyleLog, boolean bl) throws Exception {
        if (pSPFStyleLog.isPSPFIdDirty()) {
            if (pSPFStyleLog.getPSPFId() != null) {
                if (pSPFStyleLog.getPSPFId() == null || pSPFStyleLog.getPSPFName() == null) {
                    PSPF pSPF = pSPFStyleLog.getPSPF();
                    pSPFStyleLog.setPSPFName(pSPF.getPSPFName());
                }
            } else {
                pSPFStyleLog.setPSPFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSPFStyleLog pSPFStyleLog, boolean bl) throws Exception {
        super.onWriteBackParent(pSPFStyleLog, bl);
    }

    public ArrayList<PSPFStyleLog> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<PSPFStyleLog> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<PSPFStyleLog> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFSTYLEID", (Object)pSPFStyleBase.getPSPFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFStyleLog> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSPFStyleLog> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSPFStyleLog> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFID", (Object)pSPFBase.getPSPFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    public void resetPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFStyleLog> arrayList = this.selectByPSPFStyle(pSPFStyle);
        for (PSPFStyleLog pSPFStyleLog : arrayList) {
            PSPFStyleLog pSPFStyleLog2 = (PSPFStyleLog)this.getDEModel().createEntity();
            pSPFStyleLog2.setPSPFStyleLogId(pSPFStyleLog.getPSPFStyleLogId());
            pSPFStyleLog2.setPSPFStyleId(null);
            this.update(pSPFStyleLog2);
        }
    }

    public void removeByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFStyleLogServiceBase.this.onBeforeRemoveByPSPFStyle(pSPFStyle2);
                PSPFStyleLogServiceBase.this.internalRemoveByPSPFStyle(pSPFStyle2);
                PSPFStyleLogServiceBase.this.onAfterRemoveByPSPFStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFStyleLog> arrayList = this.selectByPSPFStyle(pSPFStyle);
        this.onBeforeRemoveByPSPFStyle(pSPFStyle, arrayList);
        for (PSPFStyleLog pSPFStyleLog : arrayList) {
            this.remove(pSPFStyleLog);
        }
        this.onAfterRemoveByPSPFStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFStyleLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFStyleLog> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFStyleLog> arrayList = this.selectByPSPF(pSPF);
        for (PSPFStyleLog pSPFStyleLog : arrayList) {
            PSPFStyleLog pSPFStyleLog2 = (PSPFStyleLog)this.getDEModel().createEntity();
            pSPFStyleLog2.setPSPFStyleLogId(pSPFStyleLog.getPSPFStyleLogId());
            pSPFStyleLog2.setPSPFId(null);
            this.update(pSPFStyleLog2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFStyleLogServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSPFStyleLogServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSPFStyleLogServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFStyleLog> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSPFStyleLog pSPFStyleLog : arrayList) {
            this.remove(pSPFStyleLog);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSPFStyleLog> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSPFStyleLog> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFStyleLog pSPFStyleLog) throws Exception {
        super.onBeforeRemove(pSPFStyleLog);
    }

    protected void replaceParentInfo(PSPFStyleLog pSPFStyleLog, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSPFStyleLog, cloneSession);
        if (pSPFStyleLog.getPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)pSPFStyleLog.getPSPFStyleId())) != null) {
            this.onFillParentInfo_PSPFStyle(pSPFStyleLog, (PSPFStyle)iEntity);
        }
        if (pSPFStyleLog.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSPFStyleLog.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSPFStyleLog, (PSPF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFStyleLog pSPFStyleLog, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPFStyleLog, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFStyleLog pSPFStyleLog, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ChangeLog(bl, pSPFStyleLog, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSPFStyleLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFName(bl, pSPFStyleLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleId(bl, pSPFStyleLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleLogId(bl, pSPFStyleLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleLogName(bl, pSPFStyleLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleName(bl, pSPFStyleLog, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPFStyleLog, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ChangeLog(boolean bl, PSPFStyleLog pSPFStyleLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyleLog.isChangeLogDirty() : !pSPFStyleLog.isChangeLogDirty()) {
            return null;
        }
        String string = pSPFStyleLog.getChangeLog();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ChangeLog_Default(pSPFStyleLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHANGELOG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSPFStyleLog pSPFStyleLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyleLog.isPSPFIdDirty() : !pSPFStyleLog.isPSPFIdDirty()) {
            return null;
        }
        String string = pSPFStyleLog.getPSPFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default(pSPFStyleLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFName(boolean bl, PSPFStyleLog pSPFStyleLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyleLog.isPSPFNameDirty() : !pSPFStyleLog.isPSPFNameDirty()) {
            return null;
        }
        String string = pSPFStyleLog.getPSPFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFName_Default(pSPFStyleLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStyleId(boolean bl, PSPFStyleLog pSPFStyleLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyleLog.isPSPFStyleIdDirty() : !pSPFStyleLog.isPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSPFStyleLog.getPSPFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleId_Default(pSPFStyleLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStyleLogId(boolean bl, PSPFStyleLog pSPFStyleLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyleLog.isPSPFStyleLogIdDirty() && !bl2 : !pSPFStyleLog.isPSPFStyleLogIdDirty()) {
            return null;
        }
        String string = pSPFStyleLog.getPSPFStyleLogId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLELOGID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleLogId_Default(pSPFStyleLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLELOGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStyleLogName(boolean bl, PSPFStyleLog pSPFStyleLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyleLog.isPSPFStyleLogNameDirty() && !bl2 : !pSPFStyleLog.isPSPFStyleLogNameDirty()) {
            return null;
        }
        String string = pSPFStyleLog.getPSPFStyleLogName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLELOGNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleLogName_Default(pSPFStyleLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLELOGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFStyleName(boolean bl, PSPFStyleLog pSPFStyleLog, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFStyleLog.isPSPFStyleNameDirty() : !pSPFStyleLog.isPSPFStyleNameDirty()) {
            return null;
        }
        String string = pSPFStyleLog.getPSPFStyleName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleName_Default(pSPFStyleLog, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFSTYLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSPFStyleLog pSPFStyleLog, boolean bl) throws Exception {
        super.onSyncEntity(pSPFStyleLog, bl);
    }

    protected void onSyncIndexEntities(PSPFStyleLog pSPFStyleLog, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPFStyleLog, bl);
    }

    public Object getDataContextValue(PSPFStyleLog pSPFStyleLog, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPFStyleLog, string, iDataContextParam)) != null) {
            return object;
        }
        PSPFStyle pSPFStyle = pSPFStyleLog.getPSPFStyle();
        if (pSPFStyle != null && pSPFStyle.contains(string)) {
            return pSPFStyle.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSPFStyleLog pSPFStyleLog, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPFStyleLog, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CHANGELOG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ChangeLog_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLELOGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleLogId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLELOGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleLogName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ChangeLog_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CHANGELOG", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSPFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleLogId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLELOGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleLogName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLELOGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSPFStyleLog pSPFStyleLog) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPFStyleLog)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFStyleLog pSPFStyleLog) throws Exception {
        super.onUpdateParent(pSPFStyleLog);
    }

    @Override
    protected void exportCurXmlModel(PSPFStyleLog pSPFStyleLog, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFSTYLELOG");
        if (!bl) {
            pSPFStyleLog.setCreateDate(null);
            pSPFStyleLog.setCreateMan(null);
            pSPFStyleLog.setPSPFStyleLogId(null);
            pSPFStyleLog.setUpdateDate(null);
            pSPFStyleLog.setUpdateMan(null);
            super.exportCurXmlModel(pSPFStyleLog, xmlNode, bl);
        }
    }
}

