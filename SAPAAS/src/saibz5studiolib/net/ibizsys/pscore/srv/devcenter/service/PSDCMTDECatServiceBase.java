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
import net.ibizsys.pscore.srv.devcenter.dao.PSDCMTDECatDAO;
import net.ibizsys.pscore.srv.devcenter.demodel.PSDCMTDECatDEModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMTDECat;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTemplBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMTDECatServiceBase
extends PSCoreSysServiceBase<PSDCMTDECat> {
    private static final Log log = LogFactory.getLog(PSDCMTDECatServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSDCMTDECatDEModel pSDCMTDECatDEModel;
    private PSDCMTDECatDAO pSDCMTDECatDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCMTDECatService";
    }

    public PSDCMTDECatDEModel getPSDCMTDECatDEModel() {
        if (this.pSDCMTDECatDEModel == null) {
            try {
                this.pSDCMTDECatDEModel = (PSDCMTDECatDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCMTDECatDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMTDECatDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDCMTDECatDEModel();
    }

    public PSDCMTDECatDAO getPSDCMTDECatDAO() {
        if (this.pSDCMTDECatDAO == null) {
            try {
                this.pSDCMTDECatDAO = (PSDCMTDECatDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.devcenter.dao.PSDCMTDECatDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMTDECatDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDCMTDECatDAO();
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

    protected void onFillParentInfo(PSDCMTDECat pSDCMTDECat, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDCMTDECAT_PSDCMODELTEMPL_PSDCMODELTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService", (SessionFactory)this.getSessionFactory());
            PSDCModelTempl pSDCModelTempl = (PSDCModelTempl)iService.getDEModel().createEntity();
            pSDCModelTempl.set("PSDCMODELTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCModelTempl);
            } else {
                iService.get(pSDCModelTempl);
            }
            this.onFillParentInfo_PSDCModelTempl(pSDCMTDECat, pSDCModelTempl);
            return;
        }
        super.onFillParentInfo(pSDCMTDECat, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCModelTempl(PSDCMTDECat pSDCMTDECat, PSDCModelTempl pSDCModelTempl) throws Exception {
        pSDCMTDECat.setPSDCModelTemplId(pSDCModelTempl.getPSDCModelTemplId());
        pSDCMTDECat.setPSDCModelTemplName(pSDCModelTempl.getPSDCModelTemplName());
    }

    protected void onFillEntityFullInfo(PSDCMTDECat pSDCMTDECat, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSDCMTDECat, bl);
        this.onFillEntityFullInfo_PSDCModelTempl(pSDCMTDECat, bl);
    }

    protected void onFillEntityFullInfo_PSDCModelTempl(PSDCMTDECat pSDCMTDECat, boolean bl) throws Exception {
        if (pSDCMTDECat.isPSDCModelTemplIdDirty()) {
            if (pSDCMTDECat.getPSDCModelTemplId() != null) {
                if (pSDCMTDECat.getPSDCModelTemplId() == null || pSDCMTDECat.getPSDCModelTemplName() == null) {
                    PSDCModelTempl pSDCModelTempl = pSDCMTDECat.getPSDCModelTempl();
                    pSDCMTDECat.setPSDCModelTemplName(pSDCModelTempl.getPSDCModelTemplName());
                }
            } else {
                pSDCMTDECat.setPSDCModelTemplName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDCMTDECat pSDCMTDECat, boolean bl) throws Exception {
        super.onWriteBackParent(pSDCMTDECat, bl);
    }

    public ArrayList<PSDCMTDECat> selectByPSDCModelTempl(PSDCModelTemplBase pSDCModelTemplBase) throws Exception {
        return this.selectByPSDCModelTempl(pSDCModelTemplBase, "", -1);
    }

    public ArrayList<PSDCMTDECat> selectByPSDCModelTempl(PSDCModelTemplBase pSDCModelTemplBase, String string) throws Exception {
        return this.selectByPSDCModelTempl(pSDCModelTemplBase, string, -1);
    }

    public ArrayList<PSDCMTDECat> selectByPSDCModelTempl(PSDCModelTemplBase pSDCModelTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCMODELTEMPLID", (Object)pSDCModelTemplBase.getPSDCModelTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCModelTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCModelTemplCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
    }

    public void resetPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
        ArrayList<PSDCMTDECat> arrayList = this.selectByPSDCModelTempl(pSDCModelTempl);
        for (PSDCMTDECat pSDCMTDECat : arrayList) {
            PSDCMTDECat pSDCMTDECat2 = (PSDCMTDECat)this.getDEModel().createEntity();
            pSDCMTDECat2.setPSDCMTDECatId(pSDCMTDECat.getPSDCMTDECatId());
            pSDCMTDECat2.setPSDCModelTemplId(null);
            this.update(pSDCMTDECat2);
        }
    }

    public void removeByPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
        final PSDCModelTempl pSDCModelTempl2 = pSDCModelTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMTDECatServiceBase.this.onBeforeRemoveByPSDCModelTempl(pSDCModelTempl2);
                PSDCMTDECatServiceBase.this.internalRemoveByPSDCModelTempl(pSDCModelTempl2);
                PSDCMTDECatServiceBase.this.onAfterRemoveByPSDCModelTempl(pSDCModelTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
    }

    protected void internalRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
        ArrayList<PSDCMTDECat> arrayList = this.selectByPSDCModelTempl(pSDCModelTempl);
        this.onBeforeRemoveByPSDCModelTempl(pSDCModelTempl, arrayList);
        for (PSDCMTDECat pSDCMTDECat : arrayList) {
            this.remove(pSDCMTDECat);
        }
        this.onAfterRemoveByPSDCModelTempl(pSDCModelTempl, arrayList);
    }

    protected void onAfterRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl, ArrayList<PSDCMTDECat> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl, ArrayList<PSDCMTDECat> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDCMTDECat pSDCMTDECat) throws Exception {
        super.onBeforeRemove(pSDCMTDECat);
    }

    protected void replaceParentInfo(PSDCMTDECat pSDCMTDECat, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDCMTDECat, cloneSession);
        if (pSDCMTDECat.getPSDCModelTemplId() != null && (iEntity = cloneSession.getEntity("PSDCMODELTEMPL", (Object)pSDCMTDECat.getPSDCModelTemplId())) != null) {
            this.onFillParentInfo_PSDCModelTempl(pSDCMTDECat, (PSDCModelTempl)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDCMTDECat pSDCMTDECat, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDCMTDECat, bl);
    }

    protected void onCheckEntity(boolean bl, PSDCMTDECat pSDCMTDECat, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_PSDCModelTemplId(bl, pSDCMTDECat, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCModelTemplName(bl, pSDCMTDECat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMTDECatId(bl, pSDCMTDECat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMTDECatName(bl, pSDCMTDECat, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDCMTDECat, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_PSDCModelTemplId(boolean bl, PSDCMTDECat pSDCMTDECat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDECat.isPSDCModelTemplIdDirty() : !pSDCMTDECat.isPSDCModelTemplIdDirty()) {
            return null;
        }
        String string = pSDCMTDECat.getPSDCModelTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCModelTemplId_Default(pSDCMTDECat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMODELTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCModelTemplName(boolean bl, PSDCMTDECat pSDCMTDECat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDECat.isPSDCModelTemplNameDirty() : !pSDCMTDECat.isPSDCModelTemplNameDirty()) {
            return null;
        }
        String string = pSDCMTDECat.getPSDCModelTemplName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCModelTemplName_Default(pSDCMTDECat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMODELTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMTDECatId(boolean bl, PSDCMTDECat pSDCMTDECat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDECat.isPSDCMTDECatIdDirty() && !bl2 : !pSDCMTDECat.isPSDCMTDECatIdDirty()) {
            return null;
        }
        String string = pSDCMTDECat.getPSDCMTDECatId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMTDECATID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMTDECatId_Default(pSDCMTDECat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMTDECATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMTDECatName(boolean bl, PSDCMTDECat pSDCMTDECat, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDCMTDECat.isPSDCMTDECatNameDirty() && !bl2 : !pSDCMTDECat.isPSDCMTDECatNameDirty()) {
            return null;
        }
        String string = pSDCMTDECat.getPSDCMTDECatName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMTDECATNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMTDECatName_Default(pSDCMTDECat, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMTDECATNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDCMTDECat pSDCMTDECat, boolean bl) throws Exception {
        super.onSyncEntity(pSDCMTDECat, bl);
    }

    protected void onSyncIndexEntities(PSDCMTDECat pSDCMTDECat, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDCMTDECat, bl);
    }

    public Object getDataContextValue(PSDCMTDECat pSDCMTDECat, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDCMTDECat, string, iDataContextParam)) != null) {
            return object;
        }
        PSDCModelTempl pSDCModelTempl = pSDCMTDECat.getPSDCModelTempl();
        if (pSDCModelTempl != null && pSDCModelTempl.contains(string)) {
            return pSDCModelTempl.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDCMTDECat pSDCMTDECat, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDCMTDECat, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMODELTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCModelTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMODELTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCModelTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMTDECATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMTDECatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMTDECATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMTDECatName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDCModelTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMODELTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCModelTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMODELTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMTDECatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMTDECATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMTDECatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMTDECATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDCMTDECat pSDCMTDECat) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDCMTDECat)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDCMTDECat pSDCMTDECat) throws Exception {
        super.onUpdateParent(pSDCMTDECat);
    }

    @Override
    protected void exportCurXmlModel(PSDCMTDECat pSDCMTDECat, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDCMTDECAT");
        if (!bl) {
            pSDCMTDECat.setCreateDate(null);
            pSDCMTDECat.setCreateMan(null);
            pSDCMTDECat.setPSDCMTDECatId(null);
            pSDCMTDECat.setUpdateDate(null);
            pSDCMTDECat.setUpdateMan(null);
            super.exportCurXmlModel(pSDCMTDECat, xmlNode, bl);
        }
    }
}

