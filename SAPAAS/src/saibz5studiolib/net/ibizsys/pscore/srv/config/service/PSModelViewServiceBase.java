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
import net.ibizsys.pscore.srv.config.dao.PSModelViewDAO;
import net.ibizsys.pscore.srv.config.demodel.PSModelViewDEModel;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelBase;
import net.ibizsys.pscore.srv.config.entity.PSModelView;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeBase;
import net.ibizsys.pscore.srv.config.service.PSModelSubViewService;
import net.ibizsys.pscore.srv.config.service.PSModelSubViewServiceBase;
import net.ibizsys.pscore.srv.config.service.PSModelViewUIActionService;
import net.ibizsys.pscore.srv.config.service.PSModelViewUIActionServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelViewServiceBase
extends PSCoreSysServiceBase<PSModelView> {
    private static final Log log = LogFactory.getLog(PSModelViewServiceBase.class);
    private PSModelViewDEModel pSModelViewDEModel;
    private PSModelViewDAO pSModelViewDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSModelViewService";
    }

    public PSModelViewDEModel getPSModelViewDEModel() {
        if (this.pSModelViewDEModel == null) {
            try {
                this.pSModelViewDEModel = (PSModelViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSModelViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelViewDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSModelViewDEModel();
    }

    public PSModelViewDAO getPSModelViewDAO() {
        if (this.pSModelViewDAO == null) {
            try {
                this.pSModelViewDAO = (PSModelViewDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSModelViewDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSModelViewDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSModelViewDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    protected void onFillParentInfo(PSModelView pSModelView, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELVIEW_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEViewBase);
            } else {
                iService.get(pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSModelView, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELVIEW_PSMODEL_PSMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelService", (SessionFactory)this.getSessionFactory());
            PSModel pSModel = (PSModel)iService.getDEModel().createEntity();
            pSModel.set("PSMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModel);
            } else {
                iService.get(pSModel);
            }
            this.onFillParentInfo_PSModel(pSModelView, pSModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMODELVIEW_PSVIEWTYPE_PSVIEWTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewTypeService", (SessionFactory)this.getSessionFactory());
            PSViewType pSViewType = (PSViewType)iService.getDEModel().createEntity();
            pSViewType.set("PSVIEWTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewType);
            } else {
                iService.get(pSViewType);
            }
            this.onFillParentInfo_PSViewType(pSModelView, pSViewType);
            return;
        }
        super.onFillParentInfo(pSModelView, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDEViewBase(PSModelView pSModelView, PSDEViewBase pSDEViewBase) throws Exception {
        pSModelView.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSModelView.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_PSModel(PSModelView pSModelView, PSModel pSModel) throws Exception {
        pSModelView.setPSModelId(pSModel.getPSModelId());
        pSModelView.setPSModelName(pSModel.getPSModelName());
    }

    protected void onFillParentInfo_PSViewType(PSModelView pSModelView, PSViewType pSViewType) throws Exception {
        pSModelView.setPSViewTypeId(pSViewType.getPSViewTypeId());
        pSModelView.setPSViewTypeName(pSViewType.getPSViewTypeName());
    }

    protected void onFillEntityFullInfo(PSModelView pSModelView, boolean bl) throws Exception {
        if (bl && pSModelView.getValidFlag() == null) {
            pSModelView.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSModelView, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSModelView, bl);
        this.onFillEntityFullInfo_PSModel(pSModelView, bl);
        this.onFillEntityFullInfo_PSViewType(pSModelView, bl);
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSModelView pSModelView, boolean bl) throws Exception {
        if (pSModelView.isPSDEViewBaseIdDirty()) {
            if (pSModelView.getPSDEViewBaseId() != null) {
                if (pSModelView.getPSDEViewBaseId() == null || pSModelView.getPSDEViewBaseName() == null) {
                    PSDEViewBase pSDEViewBase = pSModelView.getPSDEViewBase();
                    pSModelView.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                }
            } else {
                pSModelView.setPSDEViewBaseName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModel(PSModelView pSModelView, boolean bl) throws Exception {
        if (pSModelView.isPSModelIdDirty()) {
            if (pSModelView.getPSModelId() != null) {
                if (pSModelView.getPSModelId() == null || pSModelView.getPSModelName() == null) {
                    PSModel pSModel = pSModelView.getPSModel();
                    pSModelView.setPSModelName(pSModel.getPSModelName());
                }
            } else {
                pSModelView.setPSModelName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSViewType(PSModelView pSModelView, boolean bl) throws Exception {
        if (pSModelView.isPSViewTypeIdDirty()) {
            if (pSModelView.getPSViewTypeId() != null) {
                if (pSModelView.getPSViewTypeId() == null || pSModelView.getPSViewTypeName() == null) {
                    PSViewType pSViewType = pSModelView.getPSViewType();
                    pSModelView.setPSViewTypeName(pSViewType.getPSViewTypeName());
                }
            } else {
                pSModelView.setPSViewTypeName(null);
            }
        }
    }

    protected void onWriteBackParent(PSModelView pSModelView, boolean bl) throws Exception {
        super.onWriteBackParent(pSModelView, bl);
    }

    public ArrayList<PSModelView> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSModelView> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSModelView> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWBASEID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEViewBaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEViewBaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSModelView> selectByPSModel(PSModelBase pSModelBase) throws Exception {
        return this.selectByPSModel(pSModelBase, "", -1);
    }

    public ArrayList<PSModelView> selectByPSModel(PSModelBase pSModelBase, String string) throws Exception {
        return this.selectByPSModel(pSModelBase, string, -1);
    }

    public ArrayList<PSModelView> selectByPSModel(PSModelBase pSModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSModelView> selectByPSViewType(PSViewTypeBase pSViewTypeBase) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, "", -1);
    }

    public ArrayList<PSModelView> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, string, -1);
    }

    public ArrayList<PSModelView> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string, int n) throws Exception {
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

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSModelView> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSModelView pSModelView : arrayList) {
            PSModelView pSModelView2 = (PSModelView)this.getDEModel().createEntity();
            pSModelView2.setPSModelViewId(pSModelView.getPSModelViewId());
            pSModelView2.setPSDEViewBaseId(null);
            this.update(pSModelView2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelViewServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSModelViewServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSModelViewServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSModelView> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSModelView pSModelView : arrayList) {
            this.remove(pSModelView);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSModelView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSModelView> arrayList) throws Exception {
    }

    public void testRemoveByPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSModelView> arrayList = this.selectByPSModel(pSModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSMODELVIEW_PSMODEL_PSMODELID", "", iDataEntityModel.getName(), "PSMODELVIEW", iDataEntityModel.getDataInfo(pSModel), arrayList.get(0)));
        }
    }

    public void resetPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSModelView> arrayList = this.selectByPSModel(pSModel);
        for (PSModelView pSModelView : arrayList) {
            PSModelView pSModelView2 = (PSModelView)this.getDEModel().createEntity();
            pSModelView2.setPSModelViewId(pSModelView.getPSModelViewId());
            pSModelView2.setPSModelId(null);
            this.update(pSModelView2);
        }
    }

    public void removeByPSModel(PSModel pSModel) throws Exception {
        final PSModel pSModel2 = pSModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelViewServiceBase.this.onBeforeRemoveByPSModel(pSModel2);
                PSModelViewServiceBase.this.internalRemoveByPSModel(pSModel2);
                PSModelViewServiceBase.this.onAfterRemoveByPSModel(pSModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSModel(PSModel pSModel) throws Exception {
    }

    protected void internalRemoveByPSModel(PSModel pSModel) throws Exception {
        ArrayList<PSModelView> arrayList = this.selectByPSModel(pSModel);
        this.onBeforeRemoveByPSModel(pSModel, arrayList);
        for (PSModelView pSModelView : arrayList) {
            this.remove(pSModelView);
        }
        this.onAfterRemoveByPSModel(pSModel, arrayList);
    }

    protected void onAfterRemoveByPSModel(PSModel pSModel) throws Exception {
    }

    protected void onBeforeRemoveByPSModel(PSModel pSModel, ArrayList<PSModelView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModel(PSModel pSModel, ArrayList<PSModelView> arrayList) throws Exception {
    }

    public void testRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    public void resetPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSModelView> arrayList = this.selectByPSViewType(pSViewType);
        for (PSModelView pSModelView : arrayList) {
            PSModelView pSModelView2 = (PSModelView)this.getDEModel().createEntity();
            pSModelView2.setPSModelViewId(pSModelView.getPSModelViewId());
            pSModelView2.setPSViewTypeId(null);
            this.update(pSModelView2);
        }
    }

    public void removeByPSViewType(PSViewType pSViewType) throws Exception {
        final PSViewType pSViewType2 = pSViewType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelViewServiceBase.this.onBeforeRemoveByPSViewType(pSViewType2);
                PSModelViewServiceBase.this.internalRemoveByPSViewType(pSViewType2);
                PSModelViewServiceBase.this.onAfterRemoveByPSViewType(pSViewType2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void internalRemoveByPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSModelView> arrayList = this.selectByPSViewType(pSViewType);
        this.onBeforeRemoveByPSViewType(pSViewType, arrayList);
        for (PSModelView pSModelView : arrayList) {
            this.remove(pSModelView);
        }
        this.onAfterRemoveByPSViewType(pSViewType, arrayList);
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSModelView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSModelView> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSModelView pSModelView) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSModelSubViewService)ServiceGlobal.getService(PSModelSubViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelSubViewServiceBase)pSCoreSysServiceBase).testRemoveByPSModelView(pSModelView);
        ((PSModelSubViewServiceBase)pSCoreSysServiceBase).removeByPSModelView(pSModelView);
        pSCoreSysServiceBase = (PSModelViewUIActionService)ServiceGlobal.getService(PSModelViewUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSModelViewUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSModelView(pSModelView);
        super.onBeforeRemove(pSModelView);
    }

    protected void replaceParentInfo(PSModelView pSModelView, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSModelView, cloneSession);
        if (pSModelView.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSModelView.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSModelView, (PSDEViewBase)iEntity);
        }
        if (pSModelView.getPSModelId() != null && (iEntity = cloneSession.getEntity("PSMODEL", (Object)pSModelView.getPSModelId())) != null) {
            this.onFillParentInfo_PSModel(pSModelView, (PSModel)iEntity);
        }
        if (pSModelView.getPSViewTypeId() != null && (iEntity = cloneSession.getEntity("PSVIEWTYPE", (Object)pSModelView.getPSViewTypeId())) != null) {
            this.onFillParentInfo_PSViewType(pSModelView, (PSViewType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSModelView pSModelView, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSModelView, bl);
    }

    protected void onCheckEntity(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BottomContent(bl, pSModelView, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Content(bl, pSModelView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeaderContent(bl, pSModelView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ImageFlag(bl, pSModelView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSModelView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSModelView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseName(bl, pSModelView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelId(bl, pSModelView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelName(bl, pSModelView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelViewId(bl, pSModelView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModelViewName(bl, pSModelView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewTypeId(bl, pSModelView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewTypeName(bl, pSModelView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSModelView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewDesc(bl, pSModelView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewTag(bl, pSModelView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSModelView, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BottomContent(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isBottomContentDirty() : !pSModelView.isBottomContentDirty()) {
            return null;
        }
        String string = pSModelView.getBottomContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BottomContent_Default(pSModelView, bl2, bl3);
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

    protected EntityFieldError onCheckField_Content(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isContentDirty() : !pSModelView.isContentDirty()) {
            return null;
        }
        String string = pSModelView.getContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Content_Default(pSModelView, bl2, bl3);
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

    protected EntityFieldError onCheckField_HeaderContent(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isHeaderContentDirty() : !pSModelView.isHeaderContentDirty()) {
            return null;
        }
        String string = pSModelView.getHeaderContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeaderContent_Default(pSModelView, bl2, bl3);
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

    protected EntityFieldError onCheckField_ImageFlag(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isImageFlagDirty() : !pSModelView.isImageFlagDirty()) {
            return null;
        }
        Integer n = pSModelView.getImageFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ImageFlag_Default(pSModelView, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isMemoDirty() : !pSModelView.isMemoDirty()) {
            return null;
        }
        String string = pSModelView.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSModelView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isPSDEViewBaseIdDirty() : !pSModelView.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSModelView.getPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default(pSModelView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewBaseName(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isPSDEViewBaseNameDirty() : !pSModelView.isPSDEViewBaseNameDirty()) {
            return null;
        }
        String string = pSModelView.getPSDEViewBaseName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseName_Default(pSModelView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelId(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isPSModelIdDirty() : !pSModelView.isPSModelIdDirty()) {
            return null;
        }
        String string = pSModelView.getPSModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelId_Default(pSModelView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelName(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isPSModelNameDirty() : !pSModelView.isPSModelNameDirty()) {
            return null;
        }
        String string = pSModelView.getPSModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelName_Default(pSModelView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModelViewId(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isPSModelViewIdDirty() && !bl2 : !pSModelView.isPSModelViewIdDirty()) {
            return null;
        }
        String string = pSModelView.getPSModelViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelViewId_Default(pSModelView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModelViewName(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isPSModelViewNameDirty() && !bl2 : !pSModelView.isPSModelViewNameDirty()) {
            return null;
        }
        String string = pSModelView.getPSModelViewName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELVIEWNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModelViewName_Default(pSModelView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODELVIEWNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewTypeId(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isPSViewTypeIdDirty() : !pSModelView.isPSViewTypeIdDirty()) {
            return null;
        }
        String string = pSModelView.getPSViewTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeId_Default(pSModelView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewTypeName(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isPSViewTypeNameDirty() : !pSModelView.isPSViewTypeNameDirty()) {
            return null;
        }
        String string = pSModelView.getPSViewTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeName_Default(pSModelView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isValidFlagDirty() && !bl2 : !pSModelView.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSModelView.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSModelView, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewDesc(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isViewDescDirty() : !pSModelView.isViewDescDirty()) {
            return null;
        }
        String string = pSModelView.getViewDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewDesc_Default(pSModelView, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewTag(boolean bl, PSModelView pSModelView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSModelView.isViewTagDirty() && !bl2 : !pSModelView.isViewTagDirty()) {
            return null;
        }
        String string = pSModelView.getViewTag();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWTAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewTag_Default(pSModelView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSModelView pSModelView, boolean bl) throws Exception {
        super.onSyncEntity(pSModelView, bl);
    }

    protected void onSyncIndexEntities(PSModelView pSModelView, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSModelView, bl);
    }

    public Object getDataContextValue(PSModelView pSModelView, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSModelView, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSModelView pSModelView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSModelView, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BOTTOMCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_BottomContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Content_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEADERCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_HeaderContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IMAGEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ImageFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODELVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSModelViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ViewDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT", (boolean)true) == 0) {
            return this.onTestValueRule_ViewTag_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_PSDEViewBaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewBaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSModelViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModelViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODELVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ViewTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSModelView pSModelView) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSModelView)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSModelView pSModelView) throws Exception {
        super.onUpdateParent(pSModelView);
    }

    @Override
    protected void exportCurXmlModel(PSModelView pSModelView, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMODELVIEW");
        if (!bl) {
            pSModelView.setCreateDate(null);
            pSModelView.setCreateMan(null);
            pSModelView.setPSModelViewId(null);
            pSModelView.setUpdateDate(null);
            pSModelView.setUpdateMan(null);
            super.exportCurXmlModel(pSModelView, xmlNode, bl);
        }
    }
}

