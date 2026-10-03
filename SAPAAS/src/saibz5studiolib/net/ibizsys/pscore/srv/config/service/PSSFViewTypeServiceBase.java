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
import net.ibizsys.pscore.srv.config.dao.PSSFViewTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSSFViewTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSSFViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFViewTypeServiceBase
extends PSCoreSysServiceBase<PSSFViewType> {
    private static final Log log = LogFactory.getLog(PSSFViewTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSFViewTypeDEModel pSSFViewTypeDEModel;
    private PSSFViewTypeDAO pSSFViewTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSSFViewTypeService";
    }

    public PSSFViewTypeDEModel getPSSFViewTypeDEModel() {
        if (this.pSSFViewTypeDEModel == null) {
            try {
                this.pSSFViewTypeDEModel = (PSSFViewTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSSFViewTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFViewTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSFViewTypeDEModel();
    }

    public PSSFViewTypeDAO getPSSFViewTypeDAO() {
        if (this.pSSFViewTypeDAO == null) {
            try {
                this.pSSFViewTypeDAO = (PSSFViewTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSSFViewTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSFViewTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSFViewTypeDAO();
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

    protected void onFillParentInfo(PSSFViewType pSSFViewType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFVIEWTYPE_PSSFSTYLE_PSSFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFStyleService", (SessionFactory)this.getSessionFactory());
            PSSFStyle pSSFStyle = (PSSFStyle)iService.getDEModel().createEntity();
            pSSFStyle.set("PSSFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSFStyle);
            } else {
                iService.get(pSSFStyle);
            }
            this.onFillParentInfo_PSSFStyle(pSSFViewType, pSSFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFVIEWTYPE_PSSF_PSSFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFService", (SessionFactory)this.getSessionFactory());
            PSSF pSSF = (PSSF)iService.getDEModel().createEntity();
            pSSF.set("PSSFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSF);
            } else {
                iService.get(pSSF);
            }
            this.onFillParentInfo_PSSF(pSSFViewType, pSSF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSFVIEWTYPE_PSVIEWTYPE_PSVIEWTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewTypeService", (SessionFactory)this.getSessionFactory());
            PSViewType pSViewType = (PSViewType)iService.getDEModel().createEntity();
            pSViewType.set("PSVIEWTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewType);
            } else {
                iService.get(pSViewType);
            }
            this.onFillParentInfo_PSViewType(pSSFViewType, pSViewType);
            return;
        }
        super.onFillParentInfo(pSSFViewType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSFStyle(PSSFViewType pSSFViewType, PSSFStyle pSSFStyle) throws Exception {
        pSSFViewType.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
        pSSFViewType.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
    }

    protected void onFillParentInfo_PSSF(PSSFViewType pSSFViewType, PSSF pSSF) throws Exception {
        pSSFViewType.setPSSFId(pSSF.getPSSFId());
        pSSFViewType.setPSSFName(pSSF.getPSSFName());
    }

    protected void onFillParentInfo_PSViewType(PSSFViewType pSSFViewType, PSViewType pSViewType) throws Exception {
        pSSFViewType.setPSViewTypeId(pSViewType.getPSViewTypeId());
        pSSFViewType.setPSViewTypeName(pSViewType.getPSViewTypeName());
    }

    protected void onFillEntityFullInfo(PSSFViewType pSSFViewType, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSFViewType, bl);
        this.onFillEntityFullInfo_PSSFStyle(pSSFViewType, bl);
        this.onFillEntityFullInfo_PSSF(pSSFViewType, bl);
        this.onFillEntityFullInfo_PSViewType(pSSFViewType, bl);
    }

    protected void onFillEntityFullInfo_PSSFStyle(PSSFViewType pSSFViewType, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSF(PSSFViewType pSSFViewType, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewType(PSSFViewType pSSFViewType, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSFViewType pSSFViewType, boolean bl) throws Exception {
        super.onWriteBackParent(pSSFViewType, bl);
    }

    public ArrayList<PSSFViewType> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, "", -1);
    }

    public ArrayList<PSSFViewType> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string) throws Exception {
        return this.selectByPSSFStyle(pSSFStyleBase, string, -1);
    }

    public ArrayList<PSSFViewType> selectByPSSFStyle(PSSFStyleBase pSSFStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFSTYLEID", (Object)pSSFStyleBase.getPSSFStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFViewType> selectByPSSF(PSSFBase pSSFBase) throws Exception {
        return this.selectByPSSF(pSSFBase, "", -1);
    }

    public ArrayList<PSSFViewType> selectByPSSF(PSSFBase pSSFBase, String string) throws Exception {
        return this.selectByPSSF(pSSFBase, string, -1);
    }

    public ArrayList<PSSFViewType> selectByPSSF(PSSFBase pSSFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFID", (Object)pSSFBase.getPSSFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSFViewType> selectByPSViewType(PSViewTypeBase pSViewTypeBase) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, "", -1);
    }

    public ArrayList<PSSFViewType> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, string, -1);
    }

    public ArrayList<PSSFViewType> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWTYPEID", (Object)pSViewTypeBase.getPSViewTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFViewType> arrayList = this.selectByPSSFStyle(pSSFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFVIEWTYPE_PSSFSTYLE_PSSFSTYLEID", "", iDataEntityModel.getName(), "PSSFVIEWTYPE", iDataEntityModel.getDataInfo(pSSFStyle), arrayList.get(0)));
        }
    }

    public void resetPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFViewType> arrayList = this.selectByPSSFStyle(pSSFStyle);
        for (PSSFViewType pSSFViewType : arrayList) {
            PSSFViewType pSSFViewType2 = (PSSFViewType)this.getDEModel().createEntity();
            pSSFViewType2.setPSSFViewTypeId(pSSFViewType.getPSSFViewTypeId());
            pSSFViewType2.setPSSFStyleId(null);
            this.update(pSSFViewType2);
        }
    }

    public void removeByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        final PSSFStyle pSSFStyle2 = pSSFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFViewTypeServiceBase.this.onBeforeRemoveByPSSFStyle(pSSFStyle2);
                PSSFViewTypeServiceBase.this.internalRemoveByPSSFStyle(pSSFStyle2);
                PSSFViewTypeServiceBase.this.onAfterRemoveByPSSFStyle(pSSFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void internalRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
        ArrayList<PSSFViewType> arrayList = this.selectByPSSFStyle(pSSFStyle);
        this.onBeforeRemoveByPSSFStyle(pSSFStyle, arrayList);
        for (PSSFViewType pSSFViewType : arrayList) {
            this.remove(pSSFViewType);
        }
        this.onAfterRemoveByPSSFStyle(pSSFStyle, arrayList);
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFViewType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSFStyle(PSSFStyle pSSFStyle, ArrayList<PSSFViewType> arrayList) throws Exception {
    }

    public void testRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFViewType> arrayList = this.selectByPSSF(pSSF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFVIEWTYPE_PSSF_PSSFID", "", iDataEntityModel.getName(), "PSSFVIEWTYPE", iDataEntityModel.getDataInfo(pSSF), arrayList.get(0)));
        }
    }

    public void resetPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFViewType> arrayList = this.selectByPSSF(pSSF);
        for (PSSFViewType pSSFViewType : arrayList) {
            PSSFViewType pSSFViewType2 = (PSSFViewType)this.getDEModel().createEntity();
            pSSFViewType2.setPSSFViewTypeId(pSSFViewType.getPSSFViewTypeId());
            pSSFViewType2.setPSSFId(null);
            this.update(pSSFViewType2);
        }
    }

    public void removeByPSSF(PSSF pSSF) throws Exception {
        final PSSF pSSF2 = pSSF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFViewTypeServiceBase.this.onBeforeRemoveByPSSF(pSSF2);
                PSSFViewTypeServiceBase.this.internalRemoveByPSSF(pSSF2);
                PSSFViewTypeServiceBase.this.onAfterRemoveByPSSF(pSSF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void internalRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSSFViewType> arrayList = this.selectByPSSF(pSSF);
        this.onBeforeRemoveByPSSF(pSSF, arrayList);
        for (PSSFViewType pSSFViewType : arrayList) {
            this.remove(pSSFViewType);
        }
        this.onAfterRemoveByPSSF(pSSF, arrayList);
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF, ArrayList<PSSFViewType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF, ArrayList<PSSFViewType> arrayList) throws Exception {
    }

    public void testRemoveByPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSSFViewType> arrayList = this.selectByPSViewType(pSViewType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSFVIEWTYPE_PSVIEWTYPE_PSVIEWTYPEID", "", iDataEntityModel.getName(), "PSSFVIEWTYPE", iDataEntityModel.getDataInfo(pSViewType), arrayList.get(0)));
        }
    }

    public void resetPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSSFViewType> arrayList = this.selectByPSViewType(pSViewType);
        for (PSSFViewType pSSFViewType : arrayList) {
            PSSFViewType pSSFViewType2 = (PSSFViewType)this.getDEModel().createEntity();
            pSSFViewType2.setPSSFViewTypeId(pSSFViewType.getPSSFViewTypeId());
            pSSFViewType2.setPSViewTypeId(null);
            this.update(pSSFViewType2);
        }
    }

    public void removeByPSViewType(PSViewType pSViewType) throws Exception {
        final PSViewType pSViewType2 = pSViewType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSFViewTypeServiceBase.this.onBeforeRemoveByPSViewType(pSViewType2);
                PSSFViewTypeServiceBase.this.internalRemoveByPSViewType(pSViewType2);
                PSSFViewTypeServiceBase.this.onAfterRemoveByPSViewType(pSViewType2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void internalRemoveByPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSSFViewType> arrayList = this.selectByPSViewType(pSViewType);
        this.onBeforeRemoveByPSViewType(pSViewType, arrayList);
        for (PSSFViewType pSSFViewType : arrayList) {
            this.remove(pSSFViewType);
        }
        this.onAfterRemoveByPSViewType(pSViewType, arrayList);
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSSFViewType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSSFViewType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSFViewType pSSFViewType) throws Exception {
        super.onBeforeRemove(pSSFViewType);
    }

    protected void replaceParentInfo(PSSFViewType pSSFViewType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSFViewType, cloneSession);
        if (pSSFViewType.getPSSFStyleId() != null && (iEntity = cloneSession.getEntity("PSSFSTYLE", (Object)pSSFViewType.getPSSFStyleId())) != null) {
            this.onFillParentInfo_PSSFStyle(pSSFViewType, (PSSFStyle)iEntity);
        }
        if (pSSFViewType.getPSSFId() != null && (iEntity = cloneSession.getEntity("PSSF", (Object)pSSFViewType.getPSSFId())) != null) {
            this.onFillParentInfo_PSSF(pSSFViewType, (PSSF)iEntity);
        }
        if (pSSFViewType.getPSViewTypeId() != null && (iEntity = cloneSession.getEntity("PSVIEWTYPE", (Object)pSSFViewType.getPSViewTypeId())) != null) {
            this.onFillParentInfo_PSViewType(pSSFViewType, (PSViewType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSFViewType pSSFViewType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSFViewType, bl);
    }

    protected void onCheckEntity(boolean bl, PSSFViewType pSSFViewType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ControllerClass(bl, pSSFViewType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelClass(bl, pSSFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFId(bl, pSSFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFStyleId(bl, pSSFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFViewTypeId(bl, pSSFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFViewTypeName(bl, pSSFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewTypeId(bl, pSSFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewClass(bl, pSSFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewDesc(bl, pSSFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSFViewType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ControllerClass(boolean bl, PSSFViewType pSSFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFViewType.isControllerClassDirty() : !pSSFViewType.isControllerClassDirty()) {
            return null;
        }
        String string = pSSFViewType.getControllerClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ControllerClass_Default(pSSFViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTROLLERCLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSFViewType pSSFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFViewType.isMemoDirty() : !pSSFViewType.isMemoDirty()) {
            return null;
        }
        String string = pSSFViewType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSFViewType, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelClass(boolean bl, PSSFViewType pSSFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFViewType.isModelClassDirty() : !pSSFViewType.isModelClassDirty()) {
            return null;
        }
        String string = pSSFViewType.getModelClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelClass_Default(pSSFViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELCLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFId(boolean bl, PSSFViewType pSSFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFViewType.isPSSFIdDirty() : !pSSFViewType.isPSSFIdDirty()) {
            return null;
        }
        String string = pSSFViewType.getPSSFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFId_Default(pSSFViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFStyleId(boolean bl, PSSFViewType pSSFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFViewType.isPSSFStyleIdDirty() : !pSSFViewType.isPSSFStyleIdDirty()) {
            return null;
        }
        String string = pSSFViewType.getPSSFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFStyleId_Default(pSSFViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFViewTypeId(boolean bl, PSSFViewType pSSFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFViewType.isPSSFViewTypeIdDirty() && !bl2 : !pSSFViewType.isPSSFViewTypeIdDirty()) {
            return null;
        }
        String string = pSSFViewType.getPSSFViewTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFVIEWTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFViewTypeId_Default(pSSFViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFVIEWTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFViewTypeName(boolean bl, PSSFViewType pSSFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFViewType.isPSSFViewTypeNameDirty() && !bl2 : !pSSFViewType.isPSSFViewTypeNameDirty()) {
            return null;
        }
        String string = pSSFViewType.getPSSFViewTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFVIEWTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFViewTypeName_Default(pSSFViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFVIEWTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewTypeId(boolean bl, PSSFViewType pSSFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFViewType.isPSViewTypeIdDirty() : !pSSFViewType.isPSViewTypeIdDirty()) {
            return null;
        }
        String string = pSSFViewType.getPSViewTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeId_Default(pSSFViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewClass(boolean bl, PSSFViewType pSSFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFViewType.isViewClassDirty() : !pSSFViewType.isViewClassDirty()) {
            return null;
        }
        String string = pSSFViewType.getViewClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewClass_Default(pSSFViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWCLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewDesc(boolean bl, PSSFViewType pSSFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSFViewType.isViewDescDirty() : !pSSFViewType.isViewDescDirty()) {
            return null;
        }
        String string = pSSFViewType.getViewDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewDesc_Default(pSSFViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSFViewType pSSFViewType, boolean bl) throws Exception {
        super.onSyncEntity(pSSFViewType, bl);
    }

    protected void onSyncIndexEntities(PSSFViewType pSSFViewType, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSFViewType, bl);
    }

    public Object getDataContextValue(PSSFViewType pSSFViewType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSFViewType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSFViewType pSSFViewType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSFViewType, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONTROLLERCLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ControllerClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELCLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFVIEWTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFViewTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFVIEWTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFViewTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWCLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewDesc_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ControllerClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTROLLERCLASS", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_ModelClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELCLASS", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFViewTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFVIEWTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFViewTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFVIEWTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ViewClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWCLASS", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ViewDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWDESC", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSSFViewType pSSFViewType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSFViewType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSFViewType pSSFViewType) throws Exception {
        super.onUpdateParent(pSSFViewType);
    }

    @Override
    protected void exportCurXmlModel(PSSFViewType pSSFViewType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSFVIEWTYPE");
        if (!bl) {
            pSSFViewType.setCreateDate(null);
            pSSFViewType.setCreateMan(null);
            pSSFViewType.setPSSFName(null);
            pSSFViewType.setPSSFStyleName(null);
            pSSFViewType.setPSSFViewTypeId(null);
            pSSFViewType.setPSViewTypeName(null);
            pSSFViewType.setUpdateDate(null);
            pSSFViewType.setUpdateMan(null);
            super.exportCurXmlModel(pSSFViewType, xmlNode, bl);
        }
    }
}

