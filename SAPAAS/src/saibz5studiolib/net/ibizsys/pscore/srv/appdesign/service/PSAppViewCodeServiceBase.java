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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.appdesign.service;

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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.dao.PSAppViewCodeDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppViewCodeDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewCode;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCodeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppViewCodeServiceBase
extends PSCoreSysServiceBase<PSAppViewCode> {
    private static final Log log = LogFactory.getLog(PSAppViewCodeServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSAppViewCodeDEModel pSAppViewCodeDEModel;
    private PSAppViewCodeDAO pSAppViewCodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppViewCodeService";
    }

    public PSAppViewCodeDEModel getPSAppViewCodeDEModel() {
        if (this.pSAppViewCodeDEModel == null) {
            try {
                this.pSAppViewCodeDEModel = (PSAppViewCodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppViewCodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppViewCodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppViewCodeDEModel();
    }

    public PSAppViewCodeDAO getPSAppViewCodeDAO() {
        if (this.pSAppViewCodeDAO == null) {
            try {
                this.pSAppViewCodeDAO = (PSAppViewCodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppViewCodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppViewCodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppViewCodeDAO();
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

    protected void onFillParentInfo(PSAppViewCode pSAppViewCode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEWCODE_PSAPPVIEW_PSAPPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewService", (SessionFactory)this.getSessionFactory());
            PSAppView pSAppView = (PSAppView)iService.getDEModel().createEntity();
            pSAppView.set("PSAPPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppView);
            } else {
                iService.get(pSAppView);
            }
            this.onFillParentInfo_PSAppView(pSAppViewCode, pSAppView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEWCODE_PSPFPUBCODE_PSPFPUBCODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPubCodeService", (SessionFactory)this.getSessionFactory());
            PSPFPubCode pSPFPubCode = (PSPFPubCode)iService.getDEModel().createEntity();
            pSPFPubCode.set("PSPFPUBCODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFPubCode);
            } else {
                iService.get(pSPFPubCode);
            }
            this.onFillParentInfo_PSPFPubCode(pSAppViewCode, pSPFPubCode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPVIEWCODE_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSAppViewCode, pSSysApp);
            return;
        }
        super.onFillParentInfo(pSAppViewCode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppView(PSAppViewCode pSAppViewCode, PSAppView pSAppView) throws Exception {
        pSAppViewCode.setPSAppViewId(pSAppView.getPSAppViewId());
        pSAppViewCode.setPSAppViewName(pSAppView.getPSAppViewName());
    }

    protected void onFillParentInfo_PSPFPubCode(PSAppViewCode pSAppViewCode, PSPFPubCode pSPFPubCode) throws Exception {
        pSAppViewCode.setPSPFPubCodeId(pSPFPubCode.getPSPFPubCodeId());
        pSAppViewCode.setPSPFPubCodeName(pSPFPubCode.getPSPFPubCodeName());
    }

    protected void onFillParentInfo_PSSysApp(PSAppViewCode pSAppViewCode, PSSysApp pSSysApp) throws Exception {
        pSAppViewCode.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSAppViewCode.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected boolean onFillEntityKeyValue(PSAppViewCode pSAppViewCode, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSAppViewCode.get("PSSYSAPPID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSAppViewCode.get("PRJTYPE");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        stringBuilderEx.append("||");
        Object object3 = pSAppViewCode.get("PSAPPVIEWCODENAME");
        if (object3 == null) {
            object3 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object3);
        stringBuilderEx.append("||");
        Object object4 = pSAppViewCode.get("CODEPATH");
        if (object4 == null) {
            object4 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object4);
        String string = stringBuilderEx.toString();
        pSAppViewCode.set(this.getPSAppViewCodeDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSAppViewCode pSAppViewCode, boolean bl) throws Exception {
        if (bl && pSAppViewCode.getValidFlag() == null) {
            pSAppViewCode.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo(pSAppViewCode, bl);
        this.onFillEntityFullInfo_PSAppView(pSAppViewCode, bl);
        this.onFillEntityFullInfo_PSPFPubCode(pSAppViewCode, bl);
        this.onFillEntityFullInfo_PSSysApp(pSAppViewCode, bl);
    }

    protected void onFillEntityFullInfo_PSAppView(PSAppViewCode pSAppViewCode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFPubCode(PSAppViewCode pSAppViewCode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSAppViewCode pSAppViewCode, boolean bl) throws Exception {
        if (pSAppViewCode.isPSSysAppIdDirty()) {
            if (pSAppViewCode.getPSSysAppId() != null) {
                if (pSAppViewCode.getPSSysAppId() == null || pSAppViewCode.getPSSysAppName() == null) {
                    PSSysApp pSSysApp = pSAppViewCode.getPSSysApp();
                    pSAppViewCode.setPSSysAppName(pSSysApp.getPSSysAppName());
                }
            } else {
                pSAppViewCode.setPSSysAppName(null);
            }
        }
    }

    protected void onWriteBackParent(PSAppViewCode pSAppViewCode, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppViewCode, bl);
    }

    public ArrayList<PSAppViewCode> selectByPSAppView(PSAppViewBase pSAppViewBase) throws Exception {
        return this.selectByPSAppView(pSAppViewBase, "", -1);
    }

    public ArrayList<PSAppViewCode> selectByPSAppView(PSAppViewBase pSAppViewBase, String string) throws Exception {
        return this.selectByPSAppView(pSAppViewBase, string, -1);
    }

    public ArrayList<PSAppViewCode> selectByPSAppView(PSAppViewBase pSAppViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPVIEWID", (Object)pSAppViewBase.getPSAppViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppViewCode> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase) throws Exception {
        return this.selectByPSPFPubCode(pSPFPubCodeBase, "", -1);
    }

    public ArrayList<PSAppViewCode> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string) throws Exception {
        return this.selectByPSPFPubCode(pSPFPubCodeBase, string, -1);
    }

    public ArrayList<PSAppViewCode> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFPUBCODEID", (Object)pSPFPubCodeBase.getPSPFPubCodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFPubCodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFPubCodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppViewCode> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSAppViewCode> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSAppViewCode> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    public void resetPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppViewCode> arrayList = this.selectByPSAppView(pSAppView);
        for (PSAppViewCode pSAppViewCode : arrayList) {
            PSAppViewCode pSAppViewCode2 = (PSAppViewCode)this.getDEModel().createEntity();
            pSAppViewCode2.setPSAppViewCodeId(pSAppViewCode.getPSAppViewCodeId());
            pSAppViewCode2.setPSAppViewId(null);
            this.update(pSAppViewCode2);
        }
    }

    public void removeByPSAppView(PSAppView pSAppView) throws Exception {
        final PSAppView pSAppView2 = pSAppView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewCodeServiceBase.this.onBeforeRemoveByPSAppView(pSAppView2);
                PSAppViewCodeServiceBase.this.internalRemoveByPSAppView(pSAppView2);
                PSAppViewCodeServiceBase.this.onAfterRemoveByPSAppView(pSAppView2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void internalRemoveByPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSAppViewCode> arrayList = this.selectByPSAppView(pSAppView);
        this.onBeforeRemoveByPSAppView(pSAppView, arrayList);
        for (PSAppViewCode pSAppViewCode : arrayList) {
            this.remove(pSAppViewCode);
        }
        this.onAfterRemoveByPSAppView(pSAppView, arrayList);
    }

    protected void onAfterRemoveByPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void onBeforeRemoveByPSAppView(PSAppView pSAppView, ArrayList<PSAppViewCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppView(PSAppView pSAppView, ArrayList<PSAppViewCode> arrayList) throws Exception {
    }

    public void testRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSAppViewCode> arrayList = this.selectByPSPFPubCode(pSPFPubCode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFPUBCODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFPubCode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPVIEWCODE_PSPFPUBCODE_PSPFPUBCODEID", "", iDataEntityModel.getName(), "PSAPPVIEWCODE", iDataEntityModel.getDataInfo(pSPFPubCode), arrayList.get(0)));
        }
    }

    public void resetPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSAppViewCode> arrayList = this.selectByPSPFPubCode(pSPFPubCode);
        for (PSAppViewCode pSAppViewCode : arrayList) {
            PSAppViewCode pSAppViewCode2 = (PSAppViewCode)this.getDEModel().createEntity();
            pSAppViewCode2.setPSAppViewCodeId(pSAppViewCode.getPSAppViewCodeId());
            pSAppViewCode2.setPSPFPubCodeId(null);
            this.update(pSAppViewCode2);
        }
    }

    public void removeByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        final PSPFPubCode pSPFPubCode2 = pSPFPubCode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewCodeServiceBase.this.onBeforeRemoveByPSPFPubCode(pSPFPubCode2);
                PSAppViewCodeServiceBase.this.internalRemoveByPSPFPubCode(pSPFPubCode2);
                PSAppViewCodeServiceBase.this.onAfterRemoveByPSPFPubCode(pSPFPubCode2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void internalRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSAppViewCode> arrayList = this.selectByPSPFPubCode(pSPFPubCode);
        this.onBeforeRemoveByPSPFPubCode(pSPFPubCode, arrayList);
        for (PSAppViewCode pSAppViewCode : arrayList) {
            this.remove(pSAppViewCode);
        }
        this.onAfterRemoveByPSPFPubCode(pSPFPubCode, arrayList);
    }

    protected void onAfterRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSAppViewCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSAppViewCode> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppViewCode> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSAppViewCode pSAppViewCode : arrayList) {
            PSAppViewCode pSAppViewCode2 = (PSAppViewCode)this.getDEModel().createEntity();
            pSAppViewCode2.setPSAppViewCodeId(pSAppViewCode.getPSAppViewCodeId());
            pSAppViewCode2.setPSSysAppId(null);
            this.update(pSAppViewCode2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppViewCodeServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSAppViewCodeServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSAppViewCodeServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppViewCode> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSAppViewCode pSAppViewCode : arrayList) {
            this.remove(pSAppViewCode);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppViewCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppViewCode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppViewCode pSAppViewCode) throws Exception {
        super.onBeforeRemove(pSAppViewCode);
    }

    protected void replaceParentInfo(PSAppViewCode pSAppViewCode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppViewCode, cloneSession);
        if (pSAppViewCode.getPSAppViewId() != null && (iEntity = cloneSession.getEntity("PSAPPVIEW", (Object)pSAppViewCode.getPSAppViewId())) != null) {
            this.onFillParentInfo_PSAppView(pSAppViewCode, (PSAppView)iEntity);
        }
        if (pSAppViewCode.getPSPFPubCodeId() != null && (iEntity = cloneSession.getEntity("PSPFPUBCODE", (Object)pSAppViewCode.getPSPFPubCodeId())) != null) {
            this.onFillParentInfo_PSPFPubCode(pSAppViewCode, (PSPFPubCode)iEntity);
        }
        if (pSAppViewCode.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSAppViewCode.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSAppViewCode, (PSSysApp)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppViewCode pSAppViewCode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppViewCode, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodePath(bl, pSAppViewCode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppViewCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MergeCode(bl, pSAppViewCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrjType(bl, pSAppViewCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewCodeId(bl, pSAppViewCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewCodeName(bl, pSAppViewCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppViewId(bl, pSAppViewCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubCodeId(bl, pSAppViewCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSAppViewCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppName(bl, pSAppViewCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubCode(bl, pSAppViewCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIStyle(bl, pSAppViewCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCode(bl, pSAppViewCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSAppViewCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSAppViewCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppViewCode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodePath(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewCode.isCodePathDirty() && !bl2 : !pSAppViewCode.isCodePathDirty()) {
            return null;
        }
        String string = pSAppViewCode.getCodePath();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEPATH");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodePath_Default(pSAppViewCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewCode.isMemoDirty() : !pSAppViewCode.isMemoDirty()) {
            return null;
        }
        String string = pSAppViewCode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppViewCode, bl2, bl3);
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

    protected EntityFieldError onCheckField_MergeCode(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewCode.isMergeCodeDirty() : !pSAppViewCode.isMergeCodeDirty()) {
            return null;
        }
        String string = pSAppViewCode.getMergeCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MergeCode_Default(pSAppViewCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MERGECODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrjType(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewCode.isPrjTypeDirty() && !bl2 : !pSAppViewCode.isPrjTypeDirty()) {
            return null;
        }
        String string = pSAppViewCode.getPrjType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRJTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PrjType_Default(pSAppViewCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRJTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewCodeId(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewCode.isPSAppViewCodeIdDirty() && !bl2 : !pSAppViewCode.isPSAppViewCodeIdDirty()) {
            return null;
        }
        String string = pSAppViewCode.getPSAppViewCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewCodeId_Default(pSAppViewCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewCodeName(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewCode.isPSAppViewCodeNameDirty() && !bl2 : !pSAppViewCode.isPSAppViewCodeNameDirty()) {
            return null;
        }
        String string = pSAppViewCode.getPSAppViewCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWCODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewCodeName_Default(pSAppViewCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppViewId(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewCode.isPSAppViewIdDirty() : !pSAppViewCode.isPSAppViewIdDirty()) {
            return null;
        }
        String string = pSAppViewCode.getPSAppViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppViewId_Default(pSAppViewCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPubCodeId(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewCode.isPSPFPubCodeIdDirty() : !pSAppViewCode.isPSPFPubCodeIdDirty()) {
            return null;
        }
        String string = pSAppViewCode.getPSPFPubCodeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubCodeId_Default(pSAppViewCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewCode.isPSSysAppIdDirty() && !bl2 : !pSAppViewCode.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSAppViewCode.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSAppViewCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppName(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewCode.isPSSysAppNameDirty() && !bl2 : !pSAppViewCode.isPSSysAppNameDirty()) {
            return null;
        }
        String string = pSAppViewCode.getPSSysAppName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppName_Default(pSAppViewCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubCode(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewCode.isPubCodeDirty() : !pSAppViewCode.isPubCodeDirty()) {
            return null;
        }
        String string = pSAppViewCode.getPubCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubCode_Default(pSAppViewCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIStyle(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewCode.isUIStyleDirty() : !pSAppViewCode.isUIStyleDirty()) {
            return null;
        }
        String string = pSAppViewCode.getUIStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIStyle_Default(pSAppViewCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UISTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCode(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewCode.isUserCodeDirty() : !pSAppViewCode.isUserCodeDirty()) {
            return null;
        }
        String string = pSAppViewCode.getUserCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCode_Default(pSAppViewCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewCode.isUserParamsDirty() : !pSAppViewCode.isUserParamsDirty()) {
            return null;
        }
        String string = pSAppViewCode.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSAppViewCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSAppViewCode pSAppViewCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppViewCode.isValidFlagDirty() : !pSAppViewCode.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSAppViewCode.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSAppViewCode, bl2, bl3);
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

    protected void onSyncEntity(PSAppViewCode pSAppViewCode, boolean bl) throws Exception {
        super.onSyncEntity(pSAppViewCode, bl);
    }

    protected void onSyncIndexEntities(PSAppViewCode pSAppViewCode, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppViewCode, bl);
    }

    public Object getDataContextValue(PSAppViewCode pSAppViewCode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppViewCode, string, iDataContextParam)) != null) {
            return object;
        }
        PSAppView pSAppView = pSAppViewCode.getPSAppView();
        if (pSAppView != null && pSAppView.contains(string)) {
            return pSAppView.get(string);
        }
        PSSysApp pSSysApp = pSAppViewCode.getPSSysApp();
        if (pSSysApp != null && pSSysApp.contains(string)) {
            return pSSysApp.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSAppViewCode pSAppViewCode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSAppViewCode, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODEPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodePath_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"MERGECODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MergeCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRJTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrjType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UISTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodePath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEPATH", iEntity, bl2, null, false, 150, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[150]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[150]";
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

    protected String onTestValueRule_MergeCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MERGECODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PrjType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PRJTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWCODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPVIEWNAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPubCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPUBCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFPubCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFPUBCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UIStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UISTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_UserCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSAppViewCode pSAppViewCode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppViewCode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppViewCode pSAppViewCode) throws Exception {
        Object object = pSAppViewCode.get("PSSYSAPPID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSAPPVIEWCODE_PSSYSAPP_PSSYSAPPID", object);
        }
        super.onUpdateParent(pSAppViewCode);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSAppViewCode pSAppViewCode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPVIEWCODE");
        if (!bl) {
            pSAppViewCode.setCreateDate(null);
            pSAppViewCode.setCreateMan(null);
            pSAppViewCode.setMergeCode(null);
            pSAppViewCode.setPSAppViewCodeId(null);
            pSAppViewCode.setPSSysAppName(null);
            pSAppViewCode.setPubCode(null);
            pSAppViewCode.setUpdateDate(null);
            pSAppViewCode.setUpdateMan(null);
            super.exportCurXmlModel(pSAppViewCode, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSAppViewCode pSAppViewCode, PSSystem pSSystem) throws Exception {
        PSAppViewCode pSAppViewCode2 = new PSAppViewCode();
        pSAppViewCode2.setPSSysAppId(pSAppViewCode.getPSSysAppId());
        pSAppViewCode2.setPrjType(pSAppViewCode.getPrjType());
        pSAppViewCode2.setPSAppViewCodeName(pSAppViewCode.getPSAppViewCodeName());
        pSAppViewCode2.setCodePath(pSAppViewCode.getCodePath());
        if (this.selectOne(pSAppViewCode2, true)) {
            return pSAppViewCode2.getPSAppViewCodeId();
        }
        return super.getEntityFolderKeyValue(pSAppViewCode, pSSystem);
    }
}

