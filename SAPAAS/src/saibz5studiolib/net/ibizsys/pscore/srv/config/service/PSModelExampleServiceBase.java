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
 *  net.ibizsys.paas.demodel.IDataEntityModel
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
import net.ibizsys.paas.demodel.IDataEntityModel;
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
import net.ibizsys.pscore.srv.config.dao.PSModelExampleDAO;
import net.ibizsys.pscore.srv.config.demodel.PSModelExampleDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelBase;
import net.ibizsys.pscore.srv.config.entity.PSModelExample;
import net.ibizsys.pscore.srv.config.entity.PSModelExampleBase;
import net.ibizsys.pscore.srv.config.entity.PSModelExampleCat;
import net.ibizsys.pscore.srv.config.entity.PSModelExampleCatBase;
import net.ibizsys.pscore.srv.config.service.PSModelExampleService;
import net.ibizsys.pscore.srv.config.service.PSModelExampleStepService;
import net.ibizsys.pscore.srv.config.service.PSModelExampleStepServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelExampleServiceBase
extends PSCoreSysServiceBase<PSModelExample> {
    private static final Log log = LogFactory.getLog(PSModelExampleServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSModelExampleDEModel pSModelExampleDEModel;
    private PSModelExampleDAO pSModelExampleDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSModelExampleService";
    }

    public PSModelExampleDEModel getPSModelExampleDEModel() {
        if (this.pSModelExampleDEModel == null) {
            try {
                this.pSModelExampleDEModel = (PSModelExampleDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelExampleDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelExampleDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelExampleDEModel();
    }

    public PSModelExampleDAO getPSModelExampleDAO() {
        if (this.pSModelExampleDAO == null) {
            try {
                this.pSModelExampleDAO = (PSModelExampleDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSModelExampleDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelExampleDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelExampleDAO();
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

    protected void onFillParentInfo(PSModelExample pSModelExample, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELEXAMPLE_PSMODELEXAMPLECAT_PSMODELEXAMPLECATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelExampleCatService", (SessionFactory)this.getSessionFactory());
            PSModelExampleCat pSModelExampleCat = (PSModelExampleCat)iService.getDEModel().createEntity();
            pSModelExampleCat.set("PSMODELEXAMPLECATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModelExampleCat);
            } else {
                iService.get((IEntity)pSModelExampleCat);
            }
            this.onFillParentInfo_PSModelExampleCat(pSModelExample, pSModelExampleCat);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELEXAMPLE_PSMODELEXAMPLE_REFPSMODELEXAMPLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelExampleService", (SessionFactory)this.getSessionFactory());
            PSModelExample pSModelExample2 = (PSModelExample)iService.getDEModel().createEntity();
            pSModelExample2.set("PSMODELEXAMPLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModelExample2);
            } else {
                iService.get((IEntity)pSModelExample2);
            }
            this.onFillParentInfo_RefPSModelExample(pSModelExample, pSModelExample2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELEXAMPLE_PSMODEL_PSMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelService", (SessionFactory)this.getSessionFactory());
            PSModel pSModel = (PSModel)iService.getDEModel().createEntity();
            pSModel.set("PSMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModel);
            } else {
                iService.get((IEntity)pSModel);
            }
            this.onFillParentInfo_PSModel(pSModelExample, pSModel);
            return;
        }
        super.onFillParentInfo((IEntity)pSModelExample, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSModelExampleCat(PSModelExample pSModelExample, PSModelExampleCat pSModelExampleCat) throws Exception {
        pSModelExample.setCatOrderValue(pSModelExampleCat.getOrderValue());
        pSModelExample.setPSModelExampleCatId(pSModelExampleCat.getPSModelExampleCatId());
        pSModelExample.setPSModelExampleCatName(pSModelExampleCat.getPSModelExampleCatName());
    }

    protected void onFillParentInfo_RefPSModelExample(PSModelExample pSModelExample, PSModelExample pSModelExample2) throws Exception {
        pSModelExample.setRefPSModelExampleId(pSModelExample2.getPSModelExampleId());
        pSModelExample.setRefPSModelExampleName(pSModelExample2.getPSModelExampleName());
    }

    protected void onFillParentInfo_PSModel(PSModelExample pSModelExample, PSModel pSModel) throws Exception {
        pSModelExample.setPSModelId(pSModel.getPSModelId());
        pSModelExample.setPSModelName(pSModel.getPSModelName());
    }

    protected void onFillEntityFullInfo(PSModelExample pSModelExample, boolean bl) throws Exception {
        if (bl && pSModelExample.getValidFlag() == null) {
            pSModelExample.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSModelExample, bl);
        this.onFillEntityFullInfo_PSModelExampleCat(pSModelExample, bl);
        this.onFillEntityFullInfo_RefPSModelExample(pSModelExample, bl);
        this.onFillEntityFullInfo_PSModel(pSModelExample, bl);
    }

    protected void onFillEntityFullInfo_PSModelExampleCat(PSModelExample pSModelExample, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSModelExample(PSModelExample pSModelExample, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModel(PSModelExample pSModelExample, boolean bl) throws Exception {
        if (pSModelExample.isPSModelIdDirty()) {
            if (pSModelExample.getPSModelId() != null) {
                if (pSModelExample.getPSModelId() == null || pSModelExample.getPSModelName() == null) {
                    PSModel pSModel = pSModelExample.getPSModel();
                    pSModelExample.setPSModelName(pSModel.getPSModelName());
                }
            } else {
                pSModelExample.setPSModelName(null);
            }
        }
    }

    protected void onWriteBackParent(PSModelExample pSModelExample, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSModelExample, bl);
    }

    public ArrayList<PSModelExample> selectByPSModelExampleCat(PSModelExampleCatBase pSModelExampleCatBase) throws Exception {
        return this.selectByPSModelExampleCat(pSModelExampleCatBase, "", -1);
    }

    public ArrayList<PSModelExample> selectByPSModelExampleCat(PSModelExampleCatBase pSModelExampleCatBase, String string) throws Exception {
        return this.selectByPSModelExampleCat(pSModelExampleCatBase, string, -1);
    }

    public ArrayList<PSModelExample> selectByPSModelExampleCat(PSModelExampleCatBase pSModelExampleCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELEXAMPLECATID", (Object)pSModelExampleCatBase.getPSModelExampleCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelExampleCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelExampleCatCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSModelExample> selectByRefPSModelExample(PSModelExampleBase pSModelExampleBase) throws Exception {
        return this.selectByRefPSModelExample(pSModelExampleBase, "", -1);
    }

    public ArrayList<PSModelExample> selectByRefPSModelExample(PSModelExampleBase pSModelExampleBase, String string) throws Exception {
        return this.selectByRefPSModelExample(pSModelExampleBase, string, -1);
    }

    public ArrayList<PSModelExample> selectByRefPSModelExample(PSModelExampleBase pSModelExampleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSMODELEXAMPLEID", (Object)pSModelExampleBase.getPSModelExampleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSModelExampleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSModelExampleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSModelExample> selectByPSModel(PSModelBase pSModelBase) throws Exception {
        return this.selectByPSModel(pSModelBase, "", -1);
    }

    public ArrayList<PSModelExample> selectByPSModel(PSModelBase pSModelBase, String string) throws Exception {
        return this.selectByPSModel(pSModelBase, string, -1);
    }

    public ArrayList<PSModelExample> selectByPSModel(PSModelBase pSModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODELID", (Object)pSModelBase.getPSModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSModelExampleCat(PSModelExampleCat pSModelExampleCat) throws Exception {
        ArrayList<PSModelExample> arrayList = this.selectByPSModelExampleCat(pSModelExampleCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELEXAMPLECAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModelExampleCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELEXAMPLE_PSMODELEXAMPLECAT_PSMODELEXAMPLECATID", "", iDataEntityModel.getName(), "PSMODELEXAMPLE", iDataEntityModel.getDataInfo((IEntity)pSModelExampleCat), arrayList.get(0)));
        }
    }

    public void resetPSModelExampleCat(PSModelExampleCat pSModelExampleCat) throws Exception {
        ArrayList<PSModelExample> arrayList = this.selectByPSModelExampleCat(pSModelExampleCat);
        for (PSModelExample pSModelExample : arrayList) {
            PSModelExample pSModelExample2 = (PSModelExample)this.getDEModel().createEntity();
            pSModelExample2.setPSModelExampleId(pSModelExample.getPSModelExampleId());
            pSModelExample2.setPSModelExampleCatId(null);
            this.update(pSModelExample2);
        }
    }

    public void removeByPSModelExampleCat(PSModelExampleCat pSModelExampleCat) throws Exception {
        final PSModelExampleCat pSModelExampleCat2 = pSModelExampleCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelExampleServiceBase.this.onBeforeRemoveByPSModelExampleCat(pSModelExampleCat2);
                PSModelExampleServiceBase.this.internalRemoveByPSModelExampleCat(pSModelExampleCat2);
                PSModelExampleServiceBase.this.onAfterRemoveByPSModelExampleCat(pSModelExampleCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSModelExampleCat(PSModelExampleCat pSModelExampleCat) throws Exception {
    }

    protected void internalRemoveByPSModelExampleCat(PSModelExampleCat pSModelExampleCat) throws Exception {
        ArrayList<PSModelExample> arrayList = this.selectByPSModelExampleCat(pSModelExampleCat);
        this.onBeforeRemoveByPSModelExampleCat(pSModelExampleCat, arrayList);
        for (PSModelExample pSModelExample : arrayList) {
            this.remove((IEntity)pSModelExample);
        }
        this.onAfterRemoveByPSModelExampleCat(pSModelExampleCat, arrayList);
    }

    protected void onAfterRemoveByPSModelExampleCat(PSModelExampleCat pSModelExampleCat) throws Exception {
    }

    protected void onBeforeRemoveByPSModelExampleCat(PSModelExampleCat pSModelExampleCat, ArrayList<PSModelExample> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModelExampleCat(PSModelExampleCat pSModelExampleCat, ArrayList<PSModelExample> arrayList) throws Exception {
    }

    public void testRemoveByRefPSModelExample(PSModelExample pSModelExample) throws Exception {
        ArrayList<PSModelExample> arrayList = this.selectByRefPSModelExample(pSModelExample, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODELEXAMPLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModelExample);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELEXAMPLE_PSMODELEXAMPLE_REFPSMODELEXAMPLEID", "", iDataEntityModel.getName(), "PSMODELEXAMPLE", iDataEntityModel.getDataInfo((IEntity)pSModelExample), arrayList.get(0)));
        }
    }

    public void resetRefPSModelExample(PSModelExample pSModelExample) throws Exception {
        ArrayList<PSModelExample> arrayList = this.selectByRefPSModelExample(pSModelExample);
        for (PSModelExample pSModelExample2 : arrayList) {
            PSModelExample pSModelExample3 = (PSModelExample)this.getDEModel().createEntity();
            pSModelExample3.setPSModelExampleId(pSModelExample2.getPSModelExampleId());
            pSModelExample3.setRefPSModelExampleId(null);
            this.update(pSModelExample3);
        }
    }

    public void removeByRefPSModelExample(PSModelExample pSModelExample) throws Exception {
        final PSModelExample pSModelExample2 = pSModelExample;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelExampleServiceBase.this.onBeforeRemoveByRefPSModelExample(pSModelExample2);
                PSModelExampleServiceBase.this.internalRemoveByRefPSModelExample(pSModelExample2);
                PSModelExampleServiceBase.this.onAfterRemoveByRefPSModelExample(pSModelExample2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSModelExample(PSModelExample pSModelExample) throws Exception {
    }

    protected void internalRemoveByRefPSModelExample(PSModelExample pSModelExample) throws Exception {
        ArrayList<PSModelExample> arrayList = this.selectByRefPSModelExample(pSModelExample);
        this.onBeforeRemoveByRefPSModelExample(pSModelExample, arrayList);
        for (PSModelExample pSModelExample2 : arrayList) {
            this.remove((IEntity)pSModelExample2);
        }
        this.onAfterRemoveByRefPSModelExample(pSModelExample, arrayList);
    }

    protected void onAfterRemoveByRefPSModelExample(PSModelExample pSModelExample) throws Exception {
    }

    protected void onBeforeRemoveByRefPSModelExample(PSModelExample pSModelExample, ArrayList<PSModelExample> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSModelExample(PSModelExample pSModelExample, ArrayList<PSModelExample> arrayList) throws Exception {
    }

    public void testRemoveByPSModel(PSModel pSModel) throws Exception {
    }

    public void resetPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSModelExample> arrayList = this.selectByPSModel(pSModel);
        for (PSModelExample pSModelExample : arrayList) {
            PSModelExample pSModelExample2 = (PSModelExample)this.getDEModel().createEntity();
            pSModelExample2.setPSModelExampleId(pSModelExample.getPSModelExampleId());
            pSModelExample2.setPSModelId(null);
            this.update(pSModelExample2);
        }
    }

    public void removeByPSModel(PSModel pSModel) throws Exception {
        final PSModel pSModel2 = pSModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelExampleServiceBase.this.onBeforeRemoveByPSModel(pSModel2);
                PSModelExampleServiceBase.this.internalRemoveByPSModel(pSModel2);
                PSModelExampleServiceBase.this.onAfterRemoveByPSModel(pSModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSModel(PSModel pSModel) throws Exception {
    }

    protected void internalRemoveByPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSModelExample> arrayList = this.selectByPSModel(pSModel);
        this.onBeforeRemoveByPSModel(pSModel, arrayList);
        for (PSModelExample pSModelExample : arrayList) {
            this.remove((IEntity)pSModelExample);
        }
        this.onAfterRemoveByPSModel(pSModel, arrayList);
    }

    protected void onAfterRemoveByPSModel(PSModel pSModel) throws Exception {
    }

    protected void onBeforeRemoveByPSModel(PSModel pSModel, ArrayList<PSModelExample> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModel(PSModel pSModel, ArrayList<PSModelExample> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelExample pSModelExample) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSModelExampleStepService)ServiceGlobal.getService(PSModelExampleStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelExampleStepServiceBase)pSCoreSysServiceBase).testRemoveByPSModelExample(pSModelExample);
        ((PSModelExampleStepServiceBase)pSCoreSysServiceBase).removeByPSModelExample(pSModelExample);
        pSCoreSysServiceBase = (PSModelExampleService)ServiceGlobal.getService(PSModelExampleService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelExampleServiceBase)pSCoreSysServiceBase).testRemoveByRefPSModelExample(pSModelExample);
        super.onBeforeRemove(pSModelExample);
    }

    protected void replaceParentInfo(PSModelExample pSModelExample, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSModelExample, cloneSession);
        if (pSModelExample.getPSModelExampleCatId() != null && (iEntity = cloneSession.getEntity("PSMODELEXAMPLECAT", (Object)pSModelExample.getPSModelExampleCatId())) != null) {
            this.onFillParentInfo_PSModelExampleCat(pSModelExample, (PSModelExampleCat)iEntity);
        }
        if (pSModelExample.getRefPSModelExampleId() != null && (iEntity = cloneSession.getEntity("PSMODELEXAMPLE", (Object)pSModelExample.getRefPSModelExampleId())) != null) {
            this.onFillParentInfo_RefPSModelExample(pSModelExample, (PSModelExample)iEntity);
        }
        if (pSModelExample.getPSModelId() != null && (iEntity = cloneSession.getEntity("PSMODEL", (Object)pSModelExample.getPSModelId())) != null) {
            this.onFillParentInfo_PSModel(pSModelExample, (PSModel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelExample pSModelExample, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSModelExample, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BottomContent(bl, pSModelExample, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentAsCode(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DocUrl(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExamDesc(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExampleSN(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExampleType(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExampleUrl(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderContent(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImageFlag(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LinkFlag(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MajorFlag(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelExampleCatId(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelExampleId(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelExampleName(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelId(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelName(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSModelExampleId(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Title(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionSN(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSModelExample, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSModelExample, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BottomContent(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isBottomContentDirty() : !pSModelExample.isBottomContentDirty()) {
            return null;
        }
        String string = pSModelExample.getBottomContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BottomContent_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOTTOMCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Content(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isContentDirty() : !pSModelExample.isContentDirty()) {
            return null;
        }
        String string = pSModelExample.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentAsCode(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isContentAsCodeDirty() : !pSModelExample.isContentAsCodeDirty()) {
            return null;
        }
        Integer n = pSModelExample.getContentAsCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ContentAsCode_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTASCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DocUrl(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isDocUrlDirty() : !pSModelExample.isDocUrlDirty()) {
            return null;
        }
        String string = pSModelExample.getDocUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DocUrl_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOCURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExamDesc(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isExamDescDirty() : !pSModelExample.isExamDescDirty()) {
            return null;
        }
        String string = pSModelExample.getExamDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExamDesc_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXAMDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExampleSN(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isExampleSNDirty() && !bl2 : !pSModelExample.isExampleSNDirty()) {
            return null;
        }
        String string = pSModelExample.getExampleSN();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXAMPLESN");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExampleSN_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXAMPLESN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExampleType(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isExampleTypeDirty() : !pSModelExample.isExampleTypeDirty()) {
            return null;
        }
        String string = pSModelExample.getExampleType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExampleType_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXAMPLETYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExampleUrl(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isExampleUrlDirty() : !pSModelExample.isExampleUrlDirty()) {
            return null;
        }
        String string = pSModelExample.getExampleUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ExampleUrl_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXAMPLEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeaderContent(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isHeaderContentDirty() : !pSModelExample.isHeaderContentDirty()) {
            return null;
        }
        String string = pSModelExample.getHeaderContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderContent_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEADERCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ImageFlag(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isImageFlagDirty() : !pSModelExample.isImageFlagDirty()) {
            return null;
        }
        Integer n = pSModelExample.getImageFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ImageFlag_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IMAGEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LinkFlag(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isLinkFlagDirty() : !pSModelExample.isLinkFlagDirty()) {
            return null;
        }
        Integer n = pSModelExample.getLinkFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LinkFlag_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LINKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MajorFlag(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isMajorFlagDirty() : !pSModelExample.isMajorFlagDirty()) {
            return null;
        }
        Integer n = pSModelExample.getMajorFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MajorFlag_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAJORFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isMemoDirty() : !pSModelExample.isMemoDirty()) {
            return null;
        }
        String string = pSModelExample.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSModelExample, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isOrderValueDirty() : !pSModelExample.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSModelExample.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelExampleCatId(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isPSModelExampleCatIdDirty() : !pSModelExample.isPSModelExampleCatIdDirty()) {
            return null;
        }
        String string = pSModelExample.getPSModelExampleCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelExampleCatId_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELEXAMPLECATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelExampleId(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isPSModelExampleIdDirty() && !bl2 : !pSModelExample.isPSModelExampleIdDirty()) {
            return null;
        }
        String string = pSModelExample.getPSModelExampleId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELEXAMPLEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelExampleId_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELEXAMPLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelExampleName(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isPSModelExampleNameDirty() && !bl2 : !pSModelExample.isPSModelExampleNameDirty()) {
            return null;
        }
        String string = pSModelExample.getPSModelExampleName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELEXAMPLENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelExampleName_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELEXAMPLENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelId(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isPSModelIdDirty() : !pSModelExample.isPSModelIdDirty()) {
            return null;
        }
        String string = pSModelExample.getPSModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelId_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelName(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isPSModelNameDirty() : !pSModelExample.isPSModelNameDirty()) {
            return null;
        }
        String string = pSModelExample.getPSModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelName_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSModelExampleId(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isRefPSModelExampleIdDirty() : !pSModelExample.isRefPSModelExampleIdDirty()) {
            return null;
        }
        String string = pSModelExample.getRefPSModelExampleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSModelExampleId_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSMODELEXAMPLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Title(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isTitleDirty() : !pSModelExample.isTitleDirty()) {
            return null;
        }
        String string = pSModelExample.getTitle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Title_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionSN(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isUIActionSNDirty() : !pSModelExample.isUIActionSNDirty()) {
            return null;
        }
        String string = pSModelExample.getUIActionSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIActionSN_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSModelExample pSModelExample, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelExample.isValidFlagDirty() && !bl2 : !pSModelExample.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSModelExample.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSModelExample, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSModelExample pSModelExample, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSModelExample, bl);
    }

    protected void onSyncIndexEntities(PSModelExample pSModelExample, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSModelExample, bl);
    }

    public Object getDataContextValue(PSModelExample pSModelExample, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSModelExample, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelExample pSModelExample, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSModelExample, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BOTTOMCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BottomContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CATORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CatOrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTASCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentAsCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOCURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DocUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXAMDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExamDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXAMPLESN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExampleSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXAMPLETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExampleType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXAMPLEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExampleUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeaderContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMAGEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ImageFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LINKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LinkFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAJORFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MajorFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELEXAMPLECATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelExampleCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELEXAMPLECATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelExampleCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELEXAMPLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelExampleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELEXAMPLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelExampleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSMODELEXAMPLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSModelExampleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSMODELEXAMPLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSModelExampleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Title_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BottomContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BOTTOMCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CatOrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Content_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ContentAsCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_DocUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOCURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExamDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXAMDESC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExampleSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXAMPLESN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExampleType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXAMPLETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ExampleUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EXAMPLEURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HeaderContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEADERCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ImageFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LinkFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MajorFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSModelExampleCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELEXAMPLECATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelExampleCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELEXAMPLECATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelExampleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELEXAMPLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelExampleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELEXAMPLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSModelExampleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSMODELEXAMPLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSModelExampleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSMODELEXAMPLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Title_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLE", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UIActionSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UIACTIONSN", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSModelExample pSModelExample) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSModelExample)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelExample pSModelExample) throws Exception {
        super.onUpdateParent((IEntity)pSModelExample);
    }

    @Override
    protected void exportCurXmlModel(PSModelExample pSModelExample, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELEXAMPLE");
        if (!bl) {
            pSModelExample.setCreateDate(null);
            pSModelExample.setCreateMan(null);
            pSModelExample.setPSModelExampleCatName(null);
            pSModelExample.setPSModelExampleId(null);
            pSModelExample.setUpdateDate(null);
            pSModelExample.setUpdateMan(null);
            super.exportCurXmlModel(pSModelExample, xmlNode, bl);
        }
    }
}

