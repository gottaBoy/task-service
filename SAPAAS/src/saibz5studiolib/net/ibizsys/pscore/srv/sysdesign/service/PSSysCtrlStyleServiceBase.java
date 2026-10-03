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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysCtrlStyleDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCtrlStyleDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCtrlStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCtrlStyleServiceBase
extends PSCoreSysServiceBase<PSSysCtrlStyle> {
    private static final Log log = LogFactory.getLog(PSSysCtrlStyleServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysCtrlStyleDEModel pSSysCtrlStyleDEModel;
    private PSSysCtrlStyleDAO pSSysCtrlStyleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysCtrlStyleService";
    }

    public PSSysCtrlStyleDEModel getPSSysCtrlStyleDEModel() {
        if (this.pSSysCtrlStyleDEModel == null) {
            try {
                this.pSSysCtrlStyleDEModel = (PSSysCtrlStyleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCtrlStyleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCtrlStyleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysCtrlStyleDEModel();
    }

    public PSSysCtrlStyleDAO getPSSysCtrlStyleDAO() {
        if (this.pSSysCtrlStyleDAO == null) {
            try {
                this.pSSysCtrlStyleDAO = (PSSysCtrlStyleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysCtrlStyleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCtrlStyleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysCtrlStyleDAO();
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

    protected void onFillParentInfo(PSSysCtrlStyle pSSysCtrlStyle, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCTRLSTYLE_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_Pssystem(pSSysCtrlStyle, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysCtrlStyle, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_Pssystem(PSSysCtrlStyle pSSysCtrlStyle, PSSystem pSSystem) throws Exception {
        pSSysCtrlStyle.setPSSystemId(pSSystem.getPSSystemId());
        pSSysCtrlStyle.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysCtrlStyle pSSysCtrlStyle, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysCtrlStyle, bl);
        this.onFillEntityFullInfo_Pssystem(pSSysCtrlStyle, bl);
    }

    protected void onFillEntityFullInfo_Pssystem(PSSysCtrlStyle pSSysCtrlStyle, boolean bl) throws Exception {
        if (pSSysCtrlStyle.isPSSystemIdDirty()) {
            if (pSSysCtrlStyle.getPSSystemId() != null) {
                if (pSSysCtrlStyle.getPSSystemId() == null || pSSysCtrlStyle.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysCtrlStyle.getPssystem();
                    pSSysCtrlStyle.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysCtrlStyle.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysCtrlStyle pSSysCtrlStyle, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysCtrlStyle, bl);
    }

    public ArrayList<PSSysCtrlStyle> selectByPssystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPssystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysCtrlStyle> selectByPssystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPssystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysCtrlStyle> selectByPssystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPssystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPssystemCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPssystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPssystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysCtrlStyle> arrayList = this.selectByPssystem(pSSystem);
        for (PSSysCtrlStyle pSSysCtrlStyle : arrayList) {
            PSSysCtrlStyle pSSysCtrlStyle2 = (PSSysCtrlStyle)this.getDEModel().createEntity();
            pSSysCtrlStyle2.setPSSysCtrlStyleId(pSSysCtrlStyle.getPSSysCtrlStyleId());
            pSSysCtrlStyle2.setPSSystemId(null);
            this.update(pSSysCtrlStyle2);
        }
    }

    public void removeByPssystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCtrlStyleServiceBase.this.onBeforeRemoveByPssystem(pSSystem2);
                PSSysCtrlStyleServiceBase.this.internalRemoveByPssystem(pSSystem2);
                PSSysCtrlStyleServiceBase.this.onAfterRemoveByPssystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPssystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPssystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysCtrlStyle> arrayList = this.selectByPssystem(pSSystem);
        this.onBeforeRemoveByPssystem(pSSystem, arrayList);
        for (PSSysCtrlStyle pSSysCtrlStyle : arrayList) {
            this.remove(pSSysCtrlStyle);
        }
        this.onAfterRemoveByPssystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPssystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPssystem(PSSystem pSSystem, ArrayList<PSSysCtrlStyle> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPssystem(PSSystem pSSystem, ArrayList<PSSysCtrlStyle> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysCtrlStyle pSSysCtrlStyle) throws Exception {
        super.onBeforeRemove(pSSysCtrlStyle);
    }

    protected void replaceParentInfo(PSSysCtrlStyle pSSysCtrlStyle, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysCtrlStyle, cloneSession);
        if (pSSysCtrlStyle.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysCtrlStyle.getPSSystemId())) != null) {
            this.onFillParentInfo_Pssystem(pSSysCtrlStyle, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysCtrlStyle pSSysCtrlStyle, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysCtrlStyle, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CtrlParam(bl, pSSysCtrlStyle, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam10(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam11(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam12(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam2(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam3(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam4(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam5(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam6(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam7(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam8(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam9(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlType(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCtrlStyleId(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCtrlStyleName(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysCtrlStyle, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysCtrlStyle, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CtrlParam(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isCtrlParamDirty() : !pSSysCtrlStyle.isCtrlParamDirty()) {
            return null;
        }
        String string = pSSysCtrlStyle.getCtrlParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlParam_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam10(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isCtrlParam10Dirty() : !pSSysCtrlStyle.isCtrlParam10Dirty()) {
            return null;
        }
        Double d = pSSysCtrlStyle.getCtrlParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam10_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam11(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isCtrlParam11Dirty() : !pSSysCtrlStyle.isCtrlParam11Dirty()) {
            return null;
        }
        Integer n = pSSysCtrlStyle.getCtrlParam11();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam11_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM11");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam12(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isCtrlParam12Dirty() : !pSSysCtrlStyle.isCtrlParam12Dirty()) {
            return null;
        }
        Integer n = pSSysCtrlStyle.getCtrlParam12();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam12_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM12");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam2(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isCtrlParam2Dirty() : !pSSysCtrlStyle.isCtrlParam2Dirty()) {
            return null;
        }
        String string = pSSysCtrlStyle.getCtrlParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlParam2_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam3(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isCtrlParam3Dirty() : !pSSysCtrlStyle.isCtrlParam3Dirty()) {
            return null;
        }
        String string = pSSysCtrlStyle.getCtrlParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlParam3_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam4(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isCtrlParam4Dirty() : !pSSysCtrlStyle.isCtrlParam4Dirty()) {
            return null;
        }
        String string = pSSysCtrlStyle.getCtrlParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlParam4_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam5(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isCtrlParam5Dirty() : !pSSysCtrlStyle.isCtrlParam5Dirty()) {
            return null;
        }
        Integer n = pSSysCtrlStyle.getCtrlParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam5_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam6(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isCtrlParam6Dirty() : !pSSysCtrlStyle.isCtrlParam6Dirty()) {
            return null;
        }
        Integer n = pSSysCtrlStyle.getCtrlParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam6_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam7(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isCtrlParam7Dirty() : !pSSysCtrlStyle.isCtrlParam7Dirty()) {
            return null;
        }
        Integer n = pSSysCtrlStyle.getCtrlParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam7_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam8(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isCtrlParam8Dirty() : !pSSysCtrlStyle.isCtrlParam8Dirty()) {
            return null;
        }
        Integer n = pSSysCtrlStyle.getCtrlParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam8_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam9(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isCtrlParam9Dirty() : !pSSysCtrlStyle.isCtrlParam9Dirty()) {
            return null;
        }
        Double d = pSSysCtrlStyle.getCtrlParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam9_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlType(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isCtrlTypeDirty() && !bl2 : !pSSysCtrlStyle.isCtrlTypeDirty()) {
            return null;
        }
        String string = pSSysCtrlStyle.getCtrlType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlType_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isMemoDirty() : !pSSysCtrlStyle.isMemoDirty()) {
            return null;
        }
        String string = pSSysCtrlStyle.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCtrlStyleId(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isPSSysCtrlStyleIdDirty() && !bl2 : !pSSysCtrlStyle.isPSSysCtrlStyleIdDirty()) {
            return null;
        }
        String string = pSSysCtrlStyle.getPSSysCtrlStyleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCTRLSTYLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCtrlStyleId_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCTRLSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCtrlStyleName(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isPSSysCtrlStyleNameDirty() && !bl2 : !pSSysCtrlStyle.isPSSysCtrlStyleNameDirty()) {
            return null;
        }
        String string = pSSysCtrlStyle.getPSSysCtrlStyleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCTRLSTYLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCtrlStyleName_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCTRLSTYLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isPSSystemIdDirty() : !pSSysCtrlStyle.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysCtrlStyle.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysCtrlStyle pSSysCtrlStyle, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCtrlStyle.isPSSystemNameDirty() : !pSSysCtrlStyle.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysCtrlStyle.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysCtrlStyle, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysCtrlStyle pSSysCtrlStyle, boolean bl) throws Exception {
        super.onSyncEntity(pSSysCtrlStyle, bl);
    }

    protected void onSyncIndexEntities(PSSysCtrlStyle pSSysCtrlStyle, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysCtrlStyle, bl);
    }

    public Object getDataContextValue(PSSysCtrlStyle pSSysCtrlStyle, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysCtrlStyle, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysCtrlStyle pSSysCtrlStyle, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysCtrlStyle, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM11", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam11_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM12", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam12_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCTRLSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCtrlStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCTRLSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCtrlStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_CtrlParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlParam10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlParam11_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlParam12_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlParam7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlParam8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlParam9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCtrlStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCTRLSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCtrlStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCTRLSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSSysCtrlStyle pSSysCtrlStyle) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysCtrlStyle)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysCtrlStyle pSSysCtrlStyle) throws Exception {
        super.onUpdateParent(pSSysCtrlStyle);
    }

    @Override
    protected void exportCurXmlModel(PSSysCtrlStyle pSSysCtrlStyle, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSCTRLSTYLE");
        if (!bl) {
            pSSysCtrlStyle.setCreateDate(null);
            pSSysCtrlStyle.setCreateMan(null);
            pSSysCtrlStyle.setCtrlType(null);
            pSSysCtrlStyle.setPSSysCtrlStyleId(null);
            pSSysCtrlStyle.setUpdateDate(null);
            pSSysCtrlStyle.setUpdateMan(null);
            super.exportCurXmlModel(pSSysCtrlStyle, xmlNode, bl);
        }
    }

    @Override
    public Object getDataType(PSSysCtrlStyle pSSysCtrlStyle) throws Exception {
        return pSSysCtrlStyle.getCtrlType();
    }
}

