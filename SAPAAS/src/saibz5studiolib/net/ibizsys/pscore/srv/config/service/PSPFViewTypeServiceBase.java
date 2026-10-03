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
import net.ibizsys.pscore.srv.config.dao.PSPFViewTypeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFViewTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSPFViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFViewTypeServiceBase
extends PSCoreSysServiceBase<PSPFViewType> {
    private static final Log log = LogFactory.getLog(PSPFViewTypeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFViewTypeDEModel pSPFViewTypeDEModel;
    private PSPFViewTypeDAO pSPFViewTypeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFViewTypeService";
    }

    public PSPFViewTypeDEModel getPSPFViewTypeDEModel() {
        if (this.pSPFViewTypeDEModel == null) {
            try {
                this.pSPFViewTypeDEModel = (PSPFViewTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFViewTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFViewTypeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFViewTypeDEModel();
    }

    public PSPFViewTypeDAO getPSPFViewTypeDAO() {
        if (this.pSPFViewTypeDAO == null) {
            try {
                this.pSPFViewTypeDAO = (PSPFViewTypeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFViewTypeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFViewTypeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFViewTypeDAO();
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

    protected void onFillParentInfo(PSPFViewType pSPFViewType, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFVIEWTYPE_PSPFSTYLE_PSPFSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFStyleService", (SessionFactory)this.getSessionFactory());
            PSPFStyle pSPFStyle = (PSPFStyle)iService.getDEModel().createEntity();
            pSPFStyle.set("PSPFSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFStyle);
            } else {
                iService.get(pSPFStyle);
            }
            this.onFillParentInfo_PSPFStyle(pSPFViewType, pSPFStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFVIEWTYPE_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPF);
            } else {
                iService.get(pSPF);
            }
            this.onFillParentInfo_PSPF(pSPFViewType, pSPF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFVIEWTYPE_PSVIEWTYPE_PSVIEWTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewTypeService", (SessionFactory)this.getSessionFactory());
            PSViewType pSViewType = (PSViewType)iService.getDEModel().createEntity();
            pSViewType.set("PSVIEWTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewType);
            } else {
                iService.get(pSViewType);
            }
            this.onFillParentInfo_PSViewType(pSPFViewType, pSViewType);
            return;
        }
        super.onFillParentInfo(pSPFViewType, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSPFStyle(PSPFViewType pSPFViewType, PSPFStyle pSPFStyle) throws Exception {
        pSPFViewType.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
        pSPFViewType.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
    }

    protected void onFillParentInfo_PSPF(PSPFViewType pSPFViewType, PSPF pSPF) throws Exception {
        pSPFViewType.setPSPFId(pSPF.getPSPFId());
        pSPFViewType.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillParentInfo_PSViewType(PSPFViewType pSPFViewType, PSViewType pSViewType) throws Exception {
        pSPFViewType.setPSViewTypeId(pSViewType.getPSViewTypeId());
        pSPFViewType.setPSViewTypeName(pSViewType.getPSViewTypeName());
    }

    protected void onFillEntityFullInfo(PSPFViewType pSPFViewType, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSPFViewType, bl);
        this.onFillEntityFullInfo_PSPFStyle(pSPFViewType, bl);
        this.onFillEntityFullInfo_PSPF(pSPFViewType, bl);
        this.onFillEntityFullInfo_PSViewType(pSPFViewType, bl);
    }

    protected void onFillEntityFullInfo_PSPFStyle(PSPFViewType pSPFViewType, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPF(PSPFViewType pSPFViewType, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewType(PSPFViewType pSPFViewType, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPFViewType pSPFViewType, boolean bl) throws Exception {
        super.onWriteBackParent(pSPFViewType, bl);
    }

    public ArrayList<PSPFViewType> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, "", -1);
    }

    public ArrayList<PSPFViewType> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string) throws Exception {
        return this.selectByPSPFStyle(pSPFStyleBase, string, -1);
    }

    public ArrayList<PSPFViewType> selectByPSPFStyle(PSPFStyleBase pSPFStyleBase, String string, int n) throws Exception {
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

    public ArrayList<PSPFViewType> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSPFViewType> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSPFViewType> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
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

    public ArrayList<PSPFViewType> selectByPSViewType(PSViewTypeBase pSViewTypeBase) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, "", -1);
    }

    public ArrayList<PSPFViewType> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, string, -1);
    }

    public ArrayList<PSPFViewType> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string, int n) throws Exception {
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

    public void testRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFViewType> arrayList = this.selectByPSPFStyle(pSPFStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFVIEWTYPE_PSPFSTYLE_PSPFSTYLEID", "", iDataEntityModel.getName(), "PSPFVIEWTYPE", iDataEntityModel.getDataInfo(pSPFStyle), arrayList.get(0)));
        }
    }

    public void resetPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFViewType> arrayList = this.selectByPSPFStyle(pSPFStyle);
        for (PSPFViewType pSPFViewType : arrayList) {
            PSPFViewType pSPFViewType2 = (PSPFViewType)this.getDEModel().createEntity();
            pSPFViewType2.setPSPFViewTypeId(pSPFViewType.getPSPFViewTypeId());
            pSPFViewType2.setPSPFStyleId(null);
            this.update(pSPFViewType2);
        }
    }

    public void removeByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        final PSPFStyle pSPFStyle2 = pSPFStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFViewTypeServiceBase.this.onBeforeRemoveByPSPFStyle(pSPFStyle2);
                PSPFViewTypeServiceBase.this.internalRemoveByPSPFStyle(pSPFStyle2);
                PSPFViewTypeServiceBase.this.onAfterRemoveByPSPFStyle(pSPFStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void internalRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
        ArrayList<PSPFViewType> arrayList = this.selectByPSPFStyle(pSPFStyle);
        this.onBeforeRemoveByPSPFStyle(pSPFStyle, arrayList);
        for (PSPFViewType pSPFViewType : arrayList) {
            this.remove(pSPFViewType);
        }
        this.onAfterRemoveByPSPFStyle(pSPFStyle, arrayList);
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFViewType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFStyle(PSPFStyle pSPFStyle, ArrayList<PSPFViewType> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFViewType> arrayList = this.selectByPSPF(pSPF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFVIEWTYPE_PSPF_PSPFID", "", iDataEntityModel.getName(), "PSPFVIEWTYPE", iDataEntityModel.getDataInfo(pSPF), arrayList.get(0)));
        }
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFViewType> arrayList = this.selectByPSPF(pSPF);
        for (PSPFViewType pSPFViewType : arrayList) {
            PSPFViewType pSPFViewType2 = (PSPFViewType)this.getDEModel().createEntity();
            pSPFViewType2.setPSPFViewTypeId(pSPFViewType.getPSPFViewTypeId());
            pSPFViewType2.setPSPFId(null);
            this.update(pSPFViewType2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFViewTypeServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSPFViewTypeServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSPFViewTypeServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFViewType> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSPFViewType pSPFViewType : arrayList) {
            this.remove(pSPFViewType);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSPFViewType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSPFViewType> arrayList) throws Exception {
    }

    public void testRemoveByPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSPFViewType> arrayList = this.selectByPSViewType(pSViewType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFVIEWTYPE_PSVIEWTYPE_PSVIEWTYPEID", "", iDataEntityModel.getName(), "PSPFVIEWTYPE", iDataEntityModel.getDataInfo(pSViewType), arrayList.get(0)));
        }
    }

    public void resetPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSPFViewType> arrayList = this.selectByPSViewType(pSViewType);
        for (PSPFViewType pSPFViewType : arrayList) {
            PSPFViewType pSPFViewType2 = (PSPFViewType)this.getDEModel().createEntity();
            pSPFViewType2.setPSPFViewTypeId(pSPFViewType.getPSPFViewTypeId());
            pSPFViewType2.setPSViewTypeId(null);
            this.update(pSPFViewType2);
        }
    }

    public void removeByPSViewType(PSViewType pSViewType) throws Exception {
        final PSViewType pSViewType2 = pSViewType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFViewTypeServiceBase.this.onBeforeRemoveByPSViewType(pSViewType2);
                PSPFViewTypeServiceBase.this.internalRemoveByPSViewType(pSViewType2);
                PSPFViewTypeServiceBase.this.onAfterRemoveByPSViewType(pSViewType2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void internalRemoveByPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSPFViewType> arrayList = this.selectByPSViewType(pSViewType);
        this.onBeforeRemoveByPSViewType(pSViewType, arrayList);
        for (PSPFViewType pSPFViewType : arrayList) {
            this.remove(pSPFViewType);
        }
        this.onAfterRemoveByPSViewType(pSViewType, arrayList);
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSPFViewType> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSPFViewType> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFViewType pSPFViewType) throws Exception {
        super.onBeforeRemove(pSPFViewType);
    }

    protected void replaceParentInfo(PSPFViewType pSPFViewType, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSPFViewType, cloneSession);
        if (pSPFViewType.getPSPFStyleId() != null && (iEntity = cloneSession.getEntity("PSPFSTYLE", (Object)pSPFViewType.getPSPFStyleId())) != null) {
            this.onFillParentInfo_PSPFStyle(pSPFViewType, (PSPFStyle)iEntity);
        }
        if (pSPFViewType.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSPFViewType.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSPFViewType, (PSPF)iEntity);
        }
        if (pSPFViewType.getPSViewTypeId() != null && (iEntity = cloneSession.getEntity("PSVIEWTYPE", (Object)pSPFViewType.getPSViewTypeId())) != null) {
            this.onFillParentInfo_PSViewType(pSPFViewType, (PSViewType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFViewType pSPFViewType, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSPFViewType, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFViewType pSPFViewType, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ControllerClass(bl, pSPFViewType, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelClass(bl, pSPFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSPFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFStyleId(bl, pSPFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFViewTypeId(bl, pSPFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFViewTypeName(bl, pSPFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewTypeId(bl, pSPFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewClass(bl, pSPFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewDesc(bl, pSPFViewType, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSPFViewType, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ControllerClass(boolean bl, PSPFViewType pSPFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewType.isControllerClassDirty() : !pSPFViewType.isControllerClassDirty()) {
            return null;
        }
        String string = pSPFViewType.getControllerClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ControllerClass_Default(pSPFViewType, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFViewType pSPFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewType.isMemoDirty() : !pSPFViewType.isMemoDirty()) {
            return null;
        }
        String string = pSPFViewType.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSPFViewType, bl2, bl3);
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

    protected EntityFieldError onCheckField_ModelClass(boolean bl, PSPFViewType pSPFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewType.isModelClassDirty() : !pSPFViewType.isModelClassDirty()) {
            return null;
        }
        String string = pSPFViewType.getModelClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelClass_Default(pSPFViewType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSPFViewType pSPFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewType.isPSPFIdDirty() : !pSPFViewType.isPSPFIdDirty()) {
            return null;
        }
        String string = pSPFViewType.getPSPFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default(pSPFViewType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFStyleId(boolean bl, PSPFViewType pSPFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewType.isPSPFStyleIdDirty() : !pSPFViewType.isPSPFStyleIdDirty()) {
            return null;
        }
        String string = pSPFViewType.getPSPFStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFStyleId_Default(pSPFViewType, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFViewTypeId(boolean bl, PSPFViewType pSPFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewType.isPSPFViewTypeIdDirty() && !bl2 : !pSPFViewType.isPSPFViewTypeIdDirty()) {
            return null;
        }
        String string = pSPFViewType.getPSPFViewTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFVIEWTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFViewTypeId_Default(pSPFViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFVIEWTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFViewTypeName(boolean bl, PSPFViewType pSPFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewType.isPSPFViewTypeNameDirty() && !bl2 : !pSPFViewType.isPSPFViewTypeNameDirty()) {
            return null;
        }
        String string = pSPFViewType.getPSPFViewTypeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFVIEWTYPENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFViewTypeName_Default(pSPFViewType, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFVIEWTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewTypeId(boolean bl, PSPFViewType pSPFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewType.isPSViewTypeIdDirty() : !pSPFViewType.isPSViewTypeIdDirty()) {
            return null;
        }
        String string = pSPFViewType.getPSViewTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeId_Default(pSPFViewType, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewClass(boolean bl, PSPFViewType pSPFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewType.isViewClassDirty() : !pSPFViewType.isViewClassDirty()) {
            return null;
        }
        String string = pSPFViewType.getViewClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewClass_Default(pSPFViewType, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewDesc(boolean bl, PSPFViewType pSPFViewType, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFViewType.isViewDescDirty() : !pSPFViewType.isViewDescDirty()) {
            return null;
        }
        String string = pSPFViewType.getViewDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewDesc_Default(pSPFViewType, bl2, bl3);
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

    protected void onSyncEntity(PSPFViewType pSPFViewType, boolean bl) throws Exception {
        super.onSyncEntity(pSPFViewType, bl);
    }

    protected void onSyncIndexEntities(PSPFViewType pSPFViewType, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSPFViewType, bl);
    }

    public Object getDataContextValue(PSPFViewType pSPFViewType, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSPFViewType, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSPFViewType pSPFViewType, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSPFViewType, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFVIEWTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFViewTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFVIEWTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFViewTypeName_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSPFViewTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFVIEWTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFViewTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFVIEWTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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
            if (this.checkFieldStringLengthRule("VIEWDESC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSPFViewType pSPFViewType) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSPFViewType)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFViewType pSPFViewType) throws Exception {
        super.onUpdateParent(pSPFViewType);
    }

    @Override
    protected void exportCurXmlModel(PSPFViewType pSPFViewType, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFVIEWTYPE");
        if (!bl) {
            pSPFViewType.setCreateDate(null);
            pSPFViewType.setCreateMan(null);
            pSPFViewType.setPSPFName(null);
            pSPFViewType.setPSPFStyleName(null);
            pSPFViewType.setPSPFViewTypeId(null);
            pSPFViewType.setPSViewTypeName(null);
            pSPFViewType.setUpdateDate(null);
            pSPFViewType.setUpdateMan(null);
            super.exportCurXmlModel(pSPFViewType, xmlNode, bl);
        }
    }
}

