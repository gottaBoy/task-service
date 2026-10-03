/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
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

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
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
import net.ibizsys.pscore.srv.config.dao.PSVTCtrlDAO;
import net.ibizsys.pscore.srv.config.demodel.PSVTCtrlDEModel;
import net.ibizsys.pscore.srv.config.entity.PSSysACHandler;
import net.ibizsys.pscore.srv.config.entity.PSSysACHandlerBase;
import net.ibizsys.pscore.srv.config.entity.PSSysToolbar;
import net.ibizsys.pscore.srv.config.entity.PSSysToolbarBase;
import net.ibizsys.pscore.srv.config.entity.PSVTCtrl;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSVTCtrlServiceBase
extends PSCoreSysServiceBase<PSVTCtrl> {
    private static final Log log = LogFactory.getLog(PSVTCtrlServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSVTCtrlDEModel pSVTCtrlDEModel;
    private PSVTCtrlDAO pSVTCtrlDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSVTCtrlService";
    }

    public PSVTCtrlDEModel getPSVTCtrlDEModel() {
        if (this.pSVTCtrlDEModel == null) {
            try {
                this.pSVTCtrlDEModel = (PSVTCtrlDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSVTCtrlDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSVTCtrlDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSVTCtrlDEModel();
    }

    public PSVTCtrlDAO getPSVTCtrlDAO() {
        if (this.pSVTCtrlDAO == null) {
            try {
                this.pSVTCtrlDAO = (PSVTCtrlDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSVTCtrlDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSVTCtrlDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSVTCtrlDAO();
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

    protected void onFillParentInfo(PSVTCtrl pSVTCtrl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVTCTRL_PSSYSACHANDLER_PSSYSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysACHandlerService", (SessionFactory)this.getSessionFactory());
            PSSysACHandler pSSysACHandler = (PSSysACHandler)iService.getDEModel().createEntity();
            pSSysACHandler.set("PSSYSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysACHandler);
            } else {
                iService.get(pSSysACHandler);
            }
            this.onFillParentInfo_PSSysACHandler(pSVTCtrl, pSSysACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVTCTRL_PSSYSTOOLBAR_PSSYSTOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysToolbarService", (SessionFactory)this.getSessionFactory());
            PSSysToolbar pSSysToolbar = (PSSysToolbar)iService.getDEModel().createEntity();
            pSSysToolbar.set("PSSYSTOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysToolbar);
            } else {
                iService.get(pSSysToolbar);
            }
            this.onFillParentInfo_PSSysToolbar(pSVTCtrl, pSSysToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSVTCTRL_PSVIEWTYPE_PSVIEWTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewTypeService", (SessionFactory)this.getSessionFactory());
            PSViewType pSViewType = (PSViewType)iService.getDEModel().createEntity();
            pSViewType.set("PSVIEWTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewType);
            } else {
                iService.get(pSViewType);
            }
            this.onFillParentInfo_PSViewType(pSVTCtrl, pSViewType);
            return;
        }
        super.onFillParentInfo(pSVTCtrl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysACHandler(PSVTCtrl pSVTCtrl, PSSysACHandler pSSysACHandler) throws Exception {
        pSVTCtrl.setPSSysACHandlerId(pSSysACHandler.getPSSysACHandlerId());
        pSVTCtrl.setPSSysACHandlerName(pSSysACHandler.getPSSysACHandlerName());
    }

    protected void onFillParentInfo_PSSysToolbar(PSVTCtrl pSVTCtrl, PSSysToolbar pSSysToolbar) throws Exception {
        pSVTCtrl.setPSSysToolbarId(pSSysToolbar.getPSSysToolbarId());
        pSVTCtrl.setPSSysToolbarName(pSSysToolbar.getPSSysToolbarName());
    }

    protected void onFillParentInfo_PSViewType(PSVTCtrl pSVTCtrl, PSViewType pSViewType) throws Exception {
        pSVTCtrl.setPSViewTypeId(pSViewType.getPSViewTypeId());
        pSVTCtrl.setPSViewTypeName(pSViewType.getPSViewTypeName());
    }

    protected void onFillEntityFullInfo(PSVTCtrl pSVTCtrl, boolean bl) throws Exception {
        if (bl && pSVTCtrl.getValidFlag() == null) {
            pSVTCtrl.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSVTCtrl, bl);
        this.onFillEntityFullInfo_PSSysACHandler(pSVTCtrl, bl);
        this.onFillEntityFullInfo_PSSysToolbar(pSVTCtrl, bl);
        this.onFillEntityFullInfo_PSViewType(pSVTCtrl, bl);
    }

    protected void onFillEntityFullInfo_PSSysACHandler(PSVTCtrl pSVTCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysToolbar(PSVTCtrl pSVTCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewType(PSVTCtrl pSVTCtrl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSVTCtrl pSVTCtrl, boolean bl) throws Exception {
        super.onWriteBackParent(pSVTCtrl, bl);
    }

    public ArrayList<PSVTCtrl> selectByPSSysACHandler(PSSysACHandlerBase pSSysACHandlerBase) throws Exception {
        return this.selectByPSSysACHandler(pSSysACHandlerBase, "", -1);
    }

    public ArrayList<PSVTCtrl> selectByPSSysACHandler(PSSysACHandlerBase pSSysACHandlerBase, String string) throws Exception {
        return this.selectByPSSysACHandler(pSSysACHandlerBase, string, -1);
    }

    public ArrayList<PSVTCtrl> selectByPSSysACHandler(PSSysACHandlerBase pSSysACHandlerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSACHANDLERID", (Object)pSSysACHandlerBase.getPSSysACHandlerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysACHandlerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysACHandlerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSVTCtrl> selectByPSSysToolbar(PSSysToolbarBase pSSysToolbarBase) throws Exception {
        return this.selectByPSSysToolbar(pSSysToolbarBase, "", -1);
    }

    public ArrayList<PSVTCtrl> selectByPSSysToolbar(PSSysToolbarBase pSSysToolbarBase, String string) throws Exception {
        return this.selectByPSSysToolbar(pSSysToolbarBase, string, -1);
    }

    public ArrayList<PSVTCtrl> selectByPSSysToolbar(PSSysToolbarBase pSSysToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTOOLBARID", (Object)pSSysToolbarBase.getPSSysToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSVTCtrl> selectByPSViewType(PSViewTypeBase pSViewTypeBase) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, "", -1);
    }

    public ArrayList<PSVTCtrl> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string) throws Exception {
        return this.selectByPSViewType(pSViewTypeBase, string, -1);
    }

    public ArrayList<PSVTCtrl> selectByPSViewType(PSViewTypeBase pSViewTypeBase, String string, int n) throws Exception {
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

    public void testRemoveByPSSysACHandler(PSSysACHandler pSSysACHandler) throws Exception {
        ArrayList<PSVTCtrl> arrayList = this.selectByPSSysACHandler(pSSysACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVTCTRL_PSSYSACHANDLER_PSSYSACHANDLERID", "", iDataEntityModel.getName(), "PSVTCTRL", iDataEntityModel.getDataInfo(pSSysACHandler), arrayList.get(0)));
        }
    }

    public void resetPSSysACHandler(PSSysACHandler pSSysACHandler) throws Exception {
        ArrayList<PSVTCtrl> arrayList = this.selectByPSSysACHandler(pSSysACHandler);
        for (PSVTCtrl pSVTCtrl : arrayList) {
            PSVTCtrl pSVTCtrl2 = (PSVTCtrl)this.getDEModel().createEntity();
            pSVTCtrl2.setPSVTCtrlId(pSVTCtrl.getPSVTCtrlId());
            pSVTCtrl2.setPSSysACHandlerId(null);
            this.update(pSVTCtrl2);
        }
    }

    public void removeByPSSysACHandler(PSSysACHandler pSSysACHandler) throws Exception {
        final PSSysACHandler pSSysACHandler2 = pSSysACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSVTCtrlServiceBase.this.onBeforeRemoveByPSSysACHandler(pSSysACHandler2);
                PSVTCtrlServiceBase.this.internalRemoveByPSSysACHandler(pSSysACHandler2);
                PSVTCtrlServiceBase.this.onAfterRemoveByPSSysACHandler(pSSysACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysACHandler(PSSysACHandler pSSysACHandler) throws Exception {
    }

    protected void internalRemoveByPSSysACHandler(PSSysACHandler pSSysACHandler) throws Exception {
        ArrayList<PSVTCtrl> arrayList = this.selectByPSSysACHandler(pSSysACHandler);
        this.onBeforeRemoveByPSSysACHandler(pSSysACHandler, arrayList);
        for (PSVTCtrl pSVTCtrl : arrayList) {
            this.remove(pSVTCtrl);
        }
        this.onAfterRemoveByPSSysACHandler(pSSysACHandler, arrayList);
    }

    protected void onAfterRemoveByPSSysACHandler(PSSysACHandler pSSysACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSSysACHandler(PSSysACHandler pSSysACHandler, ArrayList<PSVTCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysACHandler(PSSysACHandler pSSysACHandler, ArrayList<PSVTCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
        ArrayList<PSVTCtrl> arrayList = this.selectByPSSysToolbar(pSSysToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSVTCTRL_PSSYSTOOLBAR_PSSYSTOOLBARID", "", iDataEntityModel.getName(), "PSVTCTRL", iDataEntityModel.getDataInfo(pSSysToolbar), arrayList.get(0)));
        }
    }

    public void resetPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
        ArrayList<PSVTCtrl> arrayList = this.selectByPSSysToolbar(pSSysToolbar);
        for (PSVTCtrl pSVTCtrl : arrayList) {
            PSVTCtrl pSVTCtrl2 = (PSVTCtrl)this.getDEModel().createEntity();
            pSVTCtrl2.setPSVTCtrlId(pSVTCtrl.getPSVTCtrlId());
            pSVTCtrl2.setPSSysToolbarId(null);
            this.update(pSVTCtrl2);
        }
    }

    public void removeByPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
        final PSSysToolbar pSSysToolbar2 = pSSysToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSVTCtrlServiceBase.this.onBeforeRemoveByPSSysToolbar(pSSysToolbar2);
                PSVTCtrlServiceBase.this.internalRemoveByPSSysToolbar(pSSysToolbar2);
                PSVTCtrlServiceBase.this.onAfterRemoveByPSSysToolbar(pSSysToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
    }

    protected void internalRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
        ArrayList<PSVTCtrl> arrayList = this.selectByPSSysToolbar(pSSysToolbar);
        this.onBeforeRemoveByPSSysToolbar(pSSysToolbar, arrayList);
        for (PSVTCtrl pSVTCtrl : arrayList) {
            this.remove(pSVTCtrl);
        }
        this.onAfterRemoveByPSSysToolbar(pSSysToolbar, arrayList);
    }

    protected void onAfterRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
    }

    protected void onBeforeRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar, ArrayList<PSVTCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar, ArrayList<PSVTCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    public void resetPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSVTCtrl> arrayList = this.selectByPSViewType(pSViewType);
        for (PSVTCtrl pSVTCtrl : arrayList) {
            PSVTCtrl pSVTCtrl2 = (PSVTCtrl)this.getDEModel().createEntity();
            pSVTCtrl2.setPSVTCtrlId(pSVTCtrl.getPSVTCtrlId());
            pSVTCtrl2.setPSViewTypeId(null);
            this.update(pSVTCtrl2);
        }
    }

    public void removeByPSViewType(PSViewType pSViewType) throws Exception {
        final PSViewType pSViewType2 = pSViewType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSVTCtrlServiceBase.this.onBeforeRemoveByPSViewType(pSViewType2);
                PSVTCtrlServiceBase.this.internalRemoveByPSViewType(pSViewType2);
                PSVTCtrlServiceBase.this.onAfterRemoveByPSViewType(pSViewType2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void internalRemoveByPSViewType(PSViewType pSViewType) throws Exception {
        ArrayList<PSVTCtrl> arrayList = this.selectByPSViewType(pSViewType);
        this.onBeforeRemoveByPSViewType(pSViewType, arrayList);
        for (PSVTCtrl pSVTCtrl : arrayList) {
            this.remove(pSVTCtrl);
        }
        this.onAfterRemoveByPSViewType(pSViewType, arrayList);
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType) throws Exception {
    }

    protected void onBeforeRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSVTCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewType(PSViewType pSViewType, ArrayList<PSVTCtrl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSVTCtrl pSVTCtrl) throws Exception {
        super.onBeforeRemove(pSVTCtrl);
    }

    protected void replaceParentInfo(PSVTCtrl pSVTCtrl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSVTCtrl, cloneSession);
        if (pSVTCtrl.getPSSysACHandlerId() != null && (iEntity = cloneSession.getEntity("PSSYSACHANDLER", (Object)pSVTCtrl.getPSSysACHandlerId())) != null) {
            this.onFillParentInfo_PSSysACHandler(pSVTCtrl, (PSSysACHandler)iEntity);
        }
        if (pSVTCtrl.getPSSysToolbarId() != null && (iEntity = cloneSession.getEntity("PSSYSTOOLBAR", (Object)pSVTCtrl.getPSSysToolbarId())) != null) {
            this.onFillParentInfo_PSSysToolbar(pSVTCtrl, (PSSysToolbar)iEntity);
        }
        if (pSVTCtrl.getPSViewTypeId() != null && (iEntity = cloneSession.getEntity("PSVIEWTYPE", (Object)pSVTCtrl.getPSViewTypeId())) != null) {
            this.onFillParentInfo_PSViewType(pSVTCtrl, (PSViewType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSVTCtrl pSVTCtrl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSVTCtrl, bl);
    }

    protected void onCheckEntity(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CtrlParam(bl, pSVTCtrl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam10(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam11(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam12(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam2(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam3(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam4(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam5(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam6(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam7(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam8(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam9(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlType(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDynaTool(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableViewActions(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysACHandlerId(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysToolbarId(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewTypeId(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSVTCtrlId(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSVTCtrlName(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSVTCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSVTCtrl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CtrlParam(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isCtrlParamDirty() : !pSVTCtrl.isCtrlParamDirty()) {
            return null;
        }
        String string = pSVTCtrl.getCtrlParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlParam_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CtrlParam10(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isCtrlParam10Dirty() : !pSVTCtrl.isCtrlParam10Dirty()) {
            return null;
        }
        Double d = pSVTCtrl.getCtrlParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam10_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CtrlParam11(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isCtrlParam11Dirty() : !pSVTCtrl.isCtrlParam11Dirty()) {
            return null;
        }
        Integer n = pSVTCtrl.getCtrlParam11();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam11_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CtrlParam12(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isCtrlParam12Dirty() : !pSVTCtrl.isCtrlParam12Dirty()) {
            return null;
        }
        Integer n = pSVTCtrl.getCtrlParam12();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam12_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CtrlParam2(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isCtrlParam2Dirty() : !pSVTCtrl.isCtrlParam2Dirty()) {
            return null;
        }
        String string = pSVTCtrl.getCtrlParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlParam2_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CtrlParam3(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isCtrlParam3Dirty() : !pSVTCtrl.isCtrlParam3Dirty()) {
            return null;
        }
        String string = pSVTCtrl.getCtrlParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlParam3_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CtrlParam4(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isCtrlParam4Dirty() : !pSVTCtrl.isCtrlParam4Dirty()) {
            return null;
        }
        String string = pSVTCtrl.getCtrlParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlParam4_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CtrlParam5(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isCtrlParam5Dirty() : !pSVTCtrl.isCtrlParam5Dirty()) {
            return null;
        }
        Integer n = pSVTCtrl.getCtrlParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam5_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CtrlParam6(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isCtrlParam6Dirty() : !pSVTCtrl.isCtrlParam6Dirty()) {
            return null;
        }
        Integer n = pSVTCtrl.getCtrlParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam6_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CtrlParam7(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isCtrlParam7Dirty() : !pSVTCtrl.isCtrlParam7Dirty()) {
            return null;
        }
        Integer n = pSVTCtrl.getCtrlParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam7_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CtrlParam8(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isCtrlParam8Dirty() : !pSVTCtrl.isCtrlParam8Dirty()) {
            return null;
        }
        Integer n = pSVTCtrl.getCtrlParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam8_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CtrlParam9(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isCtrlParam9Dirty() : !pSVTCtrl.isCtrlParam9Dirty()) {
            return null;
        }
        Double d = pSVTCtrl.getCtrlParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam9_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CtrlType(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isCtrlTypeDirty() && !bl2 : !pSVTCtrl.isCtrlTypeDirty()) {
            return null;
        }
        String string = pSVTCtrl.getCtrlType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlType_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isDefaultFlagDirty() : !pSVTCtrl.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSVTCtrl.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default(pSVTCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDynaTool(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isEnableDynaToolDirty() : !pSVTCtrl.isEnableDynaToolDirty()) {
            return null;
        }
        Integer n = pSVTCtrl.getEnableDynaTool();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDynaTool_Default(pSVTCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDYNATOOL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableViewActions(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isEnableViewActionsDirty() : !pSVTCtrl.isEnableViewActionsDirty()) {
            return null;
        }
        Integer n = pSVTCtrl.getEnableViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableViewActions_Default(pSVTCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEVIEWACTIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isMemoDirty() : !pSVTCtrl.isMemoDirty()) {
            return null;
        }
        String string = pSVTCtrl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isOrderValueDirty() : !pSVTCtrl.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSVTCtrl.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysACHandlerId(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isPSSysACHandlerIdDirty() : !pSVTCtrl.isPSSysACHandlerIdDirty()) {
            return null;
        }
        String string = pSVTCtrl.getPSSysACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysACHandlerId_Default(pSVTCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSACHANDLERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysToolbarId(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isPSSysToolbarIdDirty() : !pSVTCtrl.isPSSysToolbarIdDirty()) {
            return null;
        }
        String string = pSVTCtrl.getPSSysToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysToolbarId_Default(pSVTCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTOOLBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewTypeId(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isPSViewTypeIdDirty() && !bl2 : !pSVTCtrl.isPSViewTypeIdDirty()) {
            return null;
        }
        String string = pSVTCtrl.getPSViewTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewTypeId_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSVTCtrlId(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isPSVTCtrlIdDirty() && !bl2 : !pSVTCtrl.isPSVTCtrlIdDirty()) {
            return null;
        }
        String string = pSVTCtrl.getPSVTCtrlId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVTCTRLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSVTCtrlId_Default(pSVTCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVTCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSVTCtrlName(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isPSVTCtrlNameDirty() && !bl2 : !pSVTCtrl.isPSVTCtrlNameDirty()) {
            return null;
        }
        String string = pSVTCtrl.getPSVTCtrlName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVTCTRLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSVTCtrlName_Default(pSVTCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVTCTRLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isUserCatDirty() : !pSVTCtrl.isUserCatDirty()) {
            return null;
        }
        String string = pSVTCtrl.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSVTCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isUserTagDirty() : !pSVTCtrl.isUserTagDirty()) {
            return null;
        }
        String string = pSVTCtrl.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isUserTag2Dirty() : !pSVTCtrl.isUserTag2Dirty()) {
            return null;
        }
        String string = pSVTCtrl.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isUserTag3Dirty() : !pSVTCtrl.isUserTag3Dirty()) {
            return null;
        }
        String string = pSVTCtrl.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isUserTag4Dirty() : !pSVTCtrl.isUserTag4Dirty()) {
            return null;
        }
        String string = pSVTCtrl.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSVTCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSVTCtrl pSVTCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSVTCtrl.isValidFlagDirty() : !pSVTCtrl.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSVTCtrl.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSVTCtrl, bl2, bl3);
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

    protected void onSyncEntity(PSVTCtrl pSVTCtrl, boolean bl) throws Exception {
        super.onSyncEntity(pSVTCtrl, bl);
    }

    protected void onSyncIndexEntities(PSVTCtrl pSVTCtrl, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSVTCtrl, bl);
    }

    public Object getDataContextValue(PSVTCtrl pSVTCtrl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSVTCtrl, string, iDataContextParam)) != null) {
            return object;
        }
        PSViewType pSViewType = pSVTCtrl.getPSViewType();
        if (pSViewType != null && pSViewType.contains(string)) {
            return pSViewType.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSVTCtrl pSVTCtrl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSVTCtrl, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDYNATOOL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDynaTool_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEVIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableViewActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSACHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysACHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSACHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysACHandlerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysToolbarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVTCTRLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSVTCtrlId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVTCTRLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSVTCtrlName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CTRLTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDynaTool_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSSysACHandlerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSACHANDLERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysACHandlerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSACHANDLERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysToolbarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTOOLBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysToolbarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTOOLBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSVTCtrlId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVTCTRLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSVTCtrlName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVTCTRLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
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
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSVTCtrl pSVTCtrl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSVTCtrl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSVTCtrl pSVTCtrl) throws Exception {
        super.onUpdateParent(pSVTCtrl);
    }

    @Override
    protected void exportCurXmlModel(PSVTCtrl pSVTCtrl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSVTCTRL");
        if (!bl) {
            pSVTCtrl.setCreateDate(null);
            pSVTCtrl.setCreateMan(null);
            pSVTCtrl.setPSVTCtrlId(null);
            pSVTCtrl.setUpdateDate(null);
            pSVTCtrl.setUpdateMan(null);
            super.exportCurXmlModel(pSVTCtrl, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSVTCtrl pSVTCtrl, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSVTCtrl, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSVIEWTYPEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSVIEWTYPE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSVIEWTYPEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSVTCTRL_PSVIEWTYPE_PSVIEWTYPEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSVIEWTYPEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSVIEWTYPENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSVIEWTYPE", (boolean)true) == 0) {
            iEntity.set("PSVIEWTYPEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSVIEWTYPEID"};
    }

    @Override
    public String getModelV2Tag(PSVTCtrl pSVTCtrl) {
        return super.getModelV2Tag(pSVTCtrl);
    }

    @Override
    public boolean setModelV2Tag(PSVTCtrl pSVTCtrl, String string) {
        return super.setModelV2Tag(pSVTCtrl, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSVIEWTYPEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSVTCtrl pSVTCtrl, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSVTCtrl.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSVTCtrl, true);
        return super.getModelV2Entity(pSVTCtrl, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSVTCtrl pSVTCtrl, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSVTCtrl, objectNode, string, string2, n);
    }
}

