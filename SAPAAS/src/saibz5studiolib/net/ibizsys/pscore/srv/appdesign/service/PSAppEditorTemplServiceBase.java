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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.dao.PSAppEditorTemplDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppEditorTemplDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppEditorTempl;
import net.ibizsys.pscore.srv.config.entity.PSEditorType;
import net.ibizsys.pscore.srv.config.entity.PSEditorTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCodeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyleBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppEditorTemplServiceBase
extends PSCoreSysServiceBase<PSAppEditorTempl> {
    private static final Log log = LogFactory.getLog(PSAppEditorTemplServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSAppEditorTemplDEModel pSAppEditorTemplDEModel;
    private PSAppEditorTemplDAO pSAppEditorTemplDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppEditorTemplService";
    }

    public PSAppEditorTemplDEModel getPSAppEditorTemplDEModel() {
        if (this.pSAppEditorTemplDEModel == null) {
            try {
                this.pSAppEditorTemplDEModel = (PSAppEditorTemplDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppEditorTemplDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppEditorTemplDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppEditorTemplDEModel();
    }

    public PSAppEditorTemplDAO getPSAppEditorTemplDAO() {
        if (this.pSAppEditorTemplDAO == null) {
            try {
                this.pSAppEditorTemplDAO = (PSAppEditorTemplDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppEditorTemplDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppEditorTemplDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppEditorTemplDAO();
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

    protected void onFillParentInfo(PSAppEditorTempl pSAppEditorTempl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPEDITORTEMPL_PSEDITORTYPE_PSEDITORTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSEditorTypeService", (SessionFactory)this.getSessionFactory());
            PSEditorType pSEditorType = (PSEditorType)iService.getDEModel().createEntity();
            pSEditorType.set("PSEDITORTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSEditorType);
            } else {
                iService.get(pSEditorType);
            }
            this.onFillParentInfo_PSEditorType(pSAppEditorTempl, pSEditorType);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPEDITORTEMPL_PSPFPUBCODE_PSPFPUBCODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPubCodeService", (SessionFactory)this.getSessionFactory());
            PSPFPubCode pSPFPubCode = (PSPFPubCode)iService.getDEModel().createEntity();
            pSPFPubCode.set("PSPFPUBCODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPFPubCode);
            } else {
                iService.get(pSPFPubCode);
            }
            this.onFillParentInfo_PSPFPubCode(pSAppEditorTempl, pSPFPubCode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPEDITORTEMPL_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSAppEditorTempl, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPEDITORTEMPL_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService", (SessionFactory)this.getSessionFactory());
            PSSysEditorStyle pSSysEditorStyle = (PSSysEditorStyle)iService.getDEModel().createEntity();
            pSSysEditorStyle.set("PSSYSEDITORSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysEditorStyle);
            } else {
                iService.get(pSSysEditorStyle);
            }
            this.onFillParentInfo_PSSysEditorStyle(pSAppEditorTempl, pSSysEditorStyle);
            return;
        }
        super.onFillParentInfo(pSAppEditorTempl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSEditorType(PSAppEditorTempl pSAppEditorTempl, PSEditorType pSEditorType) throws Exception {
        pSAppEditorTempl.setPSEditorTypeId(pSEditorType.getPSEditorTypeId());
        pSAppEditorTempl.setPSEditorTypeName(pSEditorType.getPSEditorTypeName());
    }

    protected void onFillParentInfo_PSPFPubCode(PSAppEditorTempl pSAppEditorTempl, PSPFPubCode pSPFPubCode) throws Exception {
        pSAppEditorTempl.setPSPFPubCodeId(pSPFPubCode.getPSPFPubCodeId());
        pSAppEditorTempl.setPSPFPubCodeName(pSPFPubCode.getPSPFPubCodeName());
    }

    protected void onFillParentInfo_PSSysApp(PSAppEditorTempl pSAppEditorTempl, PSSysApp pSSysApp) throws Exception {
        pSAppEditorTempl.setPSPFId(pSSysApp.getPSPFId());
        pSAppEditorTempl.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSAppEditorTempl.setPSSysAppName(pSSysApp.getPSSysAppName());
        pSAppEditorTempl.setPSSystemId(pSSysApp.getPSSystemId());
    }

    protected void onFillParentInfo_PSSysEditorStyle(PSAppEditorTempl pSAppEditorTempl, PSSysEditorStyle pSSysEditorStyle) throws Exception {
        pSAppEditorTempl.setPSSysEditorStyleId(pSSysEditorStyle.getPSSysEditorStyleId());
        pSAppEditorTempl.setPSSysEditorStyleName(pSSysEditorStyle.getPSSysEditorStyleName());
    }

    protected void onFillEntityFullInfo(PSAppEditorTempl pSAppEditorTempl, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSAppEditorTempl, bl);
        this.onFillEntityFullInfo_PSEditorType(pSAppEditorTempl, bl);
        this.onFillEntityFullInfo_PSPFPubCode(pSAppEditorTempl, bl);
        this.onFillEntityFullInfo_PSSysApp(pSAppEditorTempl, bl);
        this.onFillEntityFullInfo_PSSysEditorStyle(pSAppEditorTempl, bl);
    }

    protected void onFillEntityFullInfo_PSEditorType(PSAppEditorTempl pSAppEditorTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPFPubCode(PSAppEditorTempl pSAppEditorTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSAppEditorTempl pSAppEditorTempl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysEditorStyle(PSAppEditorTempl pSAppEditorTempl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppEditorTempl pSAppEditorTempl, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppEditorTempl, bl);
    }

    public ArrayList<PSAppEditorTempl> selectByPSEditorType(PSEditorTypeBase pSEditorTypeBase) throws Exception {
        return this.selectByPSEditorType(pSEditorTypeBase, "", -1);
    }

    public ArrayList<PSAppEditorTempl> selectByPSEditorType(PSEditorTypeBase pSEditorTypeBase, String string) throws Exception {
        return this.selectByPSEditorType(pSEditorTypeBase, string, -1);
    }

    public ArrayList<PSAppEditorTempl> selectByPSEditorType(PSEditorTypeBase pSEditorTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSEDITORTYPEID", (Object)pSEditorTypeBase.getPSEditorTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSEditorTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSEditorTypeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppEditorTempl> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase) throws Exception {
        return this.selectByPSPFPubCode(pSPFPubCodeBase, "", -1);
    }

    public ArrayList<PSAppEditorTempl> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string) throws Exception {
        return this.selectByPSPFPubCode(pSPFPubCodeBase, string, -1);
    }

    public ArrayList<PSAppEditorTempl> selectByPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppEditorTempl> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSAppEditorTempl> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSAppEditorTempl> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSAppEditorTempl> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase) throws Exception {
        return this.selectByPSSysEditorStyle(pSSysEditorStyleBase, "", -1);
    }

    public ArrayList<PSAppEditorTempl> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase, String string) throws Exception {
        return this.selectByPSSysEditorStyle(pSSysEditorStyleBase, string, -1);
    }

    public ArrayList<PSAppEditorTempl> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEDITORSTYLEID", (Object)pSSysEditorStyleBase.getPSSysEditorStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEditorStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEditorStyleCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSEditorType(PSEditorType pSEditorType) throws Exception {
        ArrayList<PSAppEditorTempl> arrayList = this.selectByPSEditorType(pSEditorType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSEDITORTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSEditorType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPEDITORTEMPL_PSEDITORTYPE_PSEDITORTYPEID", "", iDataEntityModel.getName(), "PSAPPEDITORTEMPL", iDataEntityModel.getDataInfo(pSEditorType), arrayList.get(0)));
        }
    }

    public void resetPSEditorType(PSEditorType pSEditorType) throws Exception {
        ArrayList<PSAppEditorTempl> arrayList = this.selectByPSEditorType(pSEditorType);
        for (PSAppEditorTempl pSAppEditorTempl : arrayList) {
            PSAppEditorTempl pSAppEditorTempl2 = (PSAppEditorTempl)this.getDEModel().createEntity();
            pSAppEditorTempl2.setPSAppEditorTemplId(pSAppEditorTempl.getPSAppEditorTemplId());
            pSAppEditorTempl2.setPSEditorTypeId(null);
            this.update(pSAppEditorTempl2);
        }
    }

    public void removeByPSEditorType(PSEditorType pSEditorType) throws Exception {
        final PSEditorType pSEditorType2 = pSEditorType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppEditorTemplServiceBase.this.onBeforeRemoveByPSEditorType(pSEditorType2);
                PSAppEditorTemplServiceBase.this.internalRemoveByPSEditorType(pSEditorType2);
                PSAppEditorTemplServiceBase.this.onAfterRemoveByPSEditorType(pSEditorType2);
            }
        });
    }

    protected void onBeforeRemoveByPSEditorType(PSEditorType pSEditorType) throws Exception {
    }

    protected void internalRemoveByPSEditorType(PSEditorType pSEditorType) throws Exception {
        ArrayList<PSAppEditorTempl> arrayList = this.selectByPSEditorType(pSEditorType);
        this.onBeforeRemoveByPSEditorType(pSEditorType, arrayList);
        for (PSAppEditorTempl pSAppEditorTempl : arrayList) {
            this.remove(pSAppEditorTempl);
        }
        this.onAfterRemoveByPSEditorType(pSEditorType, arrayList);
    }

    protected void onAfterRemoveByPSEditorType(PSEditorType pSEditorType) throws Exception {
    }

    protected void onBeforeRemoveByPSEditorType(PSEditorType pSEditorType, ArrayList<PSAppEditorTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSEditorType(PSEditorType pSEditorType, ArrayList<PSAppEditorTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSAppEditorTempl> arrayList = this.selectByPSPFPubCode(pSPFPubCode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFPUBCODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPFPubCode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPEDITORTEMPL_PSPFPUBCODE_PSPFPUBCODEID", "", iDataEntityModel.getName(), "PSAPPEDITORTEMPL", iDataEntityModel.getDataInfo(pSPFPubCode), arrayList.get(0)));
        }
    }

    public void resetPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSAppEditorTempl> arrayList = this.selectByPSPFPubCode(pSPFPubCode);
        for (PSAppEditorTempl pSAppEditorTempl : arrayList) {
            PSAppEditorTempl pSAppEditorTempl2 = (PSAppEditorTempl)this.getDEModel().createEntity();
            pSAppEditorTempl2.setPSAppEditorTemplId(pSAppEditorTempl.getPSAppEditorTemplId());
            pSAppEditorTempl2.setPSPFPubCodeId(null);
            this.update(pSAppEditorTempl2);
        }
    }

    public void removeByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        final PSPFPubCode pSPFPubCode2 = pSPFPubCode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppEditorTemplServiceBase.this.onBeforeRemoveByPSPFPubCode(pSPFPubCode2);
                PSAppEditorTemplServiceBase.this.internalRemoveByPSPFPubCode(pSPFPubCode2);
                PSAppEditorTemplServiceBase.this.onAfterRemoveByPSPFPubCode(pSPFPubCode2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void internalRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSAppEditorTempl> arrayList = this.selectByPSPFPubCode(pSPFPubCode);
        this.onBeforeRemoveByPSPFPubCode(pSPFPubCode, arrayList);
        for (PSAppEditorTempl pSAppEditorTempl : arrayList) {
            this.remove(pSAppEditorTempl);
        }
        this.onAfterRemoveByPSPFPubCode(pSPFPubCode, arrayList);
    }

    protected void onAfterRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void onBeforeRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSAppEditorTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSAppEditorTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppEditorTempl> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSAppEditorTempl pSAppEditorTempl : arrayList) {
            PSAppEditorTempl pSAppEditorTempl2 = (PSAppEditorTempl)this.getDEModel().createEntity();
            pSAppEditorTempl2.setPSAppEditorTemplId(pSAppEditorTempl.getPSAppEditorTemplId());
            pSAppEditorTempl2.setPSSysAppId(null);
            this.update(pSAppEditorTempl2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppEditorTemplServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSAppEditorTemplServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSAppEditorTemplServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppEditorTempl> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSAppEditorTempl pSAppEditorTempl : arrayList) {
            this.remove(pSAppEditorTempl);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppEditorTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppEditorTempl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSAppEditorTempl> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEDITORSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysEditorStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPEDITORTEMPL_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID", "", iDataEntityModel.getName(), "PSAPPEDITORTEMPL", iDataEntityModel.getDataInfo(pSSysEditorStyle), arrayList.get(0)));
        }
    }

    public void resetPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSAppEditorTempl> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle);
        for (PSAppEditorTempl pSAppEditorTempl : arrayList) {
            PSAppEditorTempl pSAppEditorTempl2 = (PSAppEditorTempl)this.getDEModel().createEntity();
            pSAppEditorTempl2.setPSAppEditorTemplId(pSAppEditorTempl.getPSAppEditorTemplId());
            pSAppEditorTempl2.setPSSysEditorStyleId(null);
            this.update(pSAppEditorTempl2);
        }
    }

    public void removeByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        final PSSysEditorStyle pSSysEditorStyle2 = pSSysEditorStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppEditorTemplServiceBase.this.onBeforeRemoveByPSSysEditorStyle(pSSysEditorStyle2);
                PSAppEditorTemplServiceBase.this.internalRemoveByPSSysEditorStyle(pSSysEditorStyle2);
                PSAppEditorTemplServiceBase.this.onAfterRemoveByPSSysEditorStyle(pSSysEditorStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
    }

    protected void internalRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSAppEditorTempl> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle);
        this.onBeforeRemoveByPSSysEditorStyle(pSSysEditorStyle, arrayList);
        for (PSAppEditorTempl pSAppEditorTempl : arrayList) {
            this.remove(pSAppEditorTempl);
        }
        this.onAfterRemoveByPSSysEditorStyle(pSSysEditorStyle, arrayList);
    }

    protected void onAfterRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle, ArrayList<PSAppEditorTempl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle, ArrayList<PSAppEditorTempl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppEditorTempl pSAppEditorTempl) throws Exception {
        super.onBeforeRemove(pSAppEditorTempl);
    }

    protected void replaceParentInfo(PSAppEditorTempl pSAppEditorTempl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppEditorTempl, cloneSession);
        if (pSAppEditorTempl.getPSEditorTypeId() != null && (iEntity = cloneSession.getEntity("PSEDITORTYPE", (Object)pSAppEditorTempl.getPSEditorTypeId())) != null) {
            this.onFillParentInfo_PSEditorType(pSAppEditorTempl, (PSEditorType)iEntity);
        }
        if (pSAppEditorTempl.getPSPFPubCodeId() != null && (iEntity = cloneSession.getEntity("PSPFPUBCODE", (Object)pSAppEditorTempl.getPSPFPubCodeId())) != null) {
            this.onFillParentInfo_PSPFPubCode(pSAppEditorTempl, (PSPFPubCode)iEntity);
        }
        if (pSAppEditorTempl.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSAppEditorTempl.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSAppEditorTempl, (PSSysApp)iEntity);
        }
        if (pSAppEditorTempl.getPSSysEditorStyleId() != null && (iEntity = cloneSession.getEntity("PSSYSEDITORSTYLE", (Object)pSAppEditorTempl.getPSSysEditorStyleId())) != null) {
            this.onFillParentInfo_PSSysEditorStyle(pSAppEditorTempl, (PSSysEditorStyle)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppEditorTempl pSAppEditorTempl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppEditorTempl, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppEditorTempl pSAppEditorTempl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ContainerType(bl, pSAppEditorTempl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppEditorTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppEditorTemplId(bl, pSAppEditorTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppEditorTemplName(bl, pSAppEditorTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSEditorTypeId(bl, pSAppEditorTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubCodeId(bl, pSAppEditorTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSAppEditorTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEditorStyleId(bl, pSAppEditorTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubObj(bl, pSAppEditorTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_REQCode(bl, pSAppEditorTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode(bl, pSAppEditorTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode2(bl, pSAppEditorTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode3(bl, pSAppEditorTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplCode4(bl, pSAppEditorTempl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppEditorTempl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ContainerType(boolean bl, PSAppEditorTempl pSAppEditorTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppEditorTempl.isContainerTypeDirty() && !bl2 : !pSAppEditorTempl.isContainerTypeDirty()) {
            return null;
        }
        String string = pSAppEditorTempl.getContainerType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTAINERTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContainerType_Default(pSAppEditorTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTAINERTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppEditorTempl pSAppEditorTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppEditorTempl.isMemoDirty() : !pSAppEditorTempl.isMemoDirty()) {
            return null;
        }
        String string = pSAppEditorTempl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppEditorTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppEditorTemplId(boolean bl, PSAppEditorTempl pSAppEditorTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppEditorTempl.isPSAppEditorTemplIdDirty() && !bl2 : !pSAppEditorTempl.isPSAppEditorTemplIdDirty()) {
            return null;
        }
        String string = pSAppEditorTempl.getPSAppEditorTemplId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPEDITORTEMPLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppEditorTemplId_Default(pSAppEditorTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPEDITORTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppEditorTemplName(boolean bl, PSAppEditorTempl pSAppEditorTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppEditorTempl.isPSAppEditorTemplNameDirty() && !bl2 : !pSAppEditorTempl.isPSAppEditorTemplNameDirty()) {
            return null;
        }
        String string = pSAppEditorTempl.getPSAppEditorTemplName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPEDITORTEMPLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppEditorTemplName_Default(pSAppEditorTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPEDITORTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSEditorTypeId(boolean bl, PSAppEditorTempl pSAppEditorTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppEditorTempl.isPSEditorTypeIdDirty() && !bl2 : !pSAppEditorTempl.isPSEditorTypeIdDirty()) {
            return null;
        }
        String string = pSAppEditorTempl.getPSEditorTypeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSEDITORTYPEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSEditorTypeId_Default(pSAppEditorTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSEDITORTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFPubCodeId(boolean bl, PSAppEditorTempl pSAppEditorTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppEditorTempl.isPSPFPubCodeIdDirty() && !bl2 : !pSAppEditorTempl.isPSPFPubCodeIdDirty()) {
            return null;
        }
        String string = pSAppEditorTempl.getPSPFPubCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubCodeId_Default(pSAppEditorTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSAppEditorTempl pSAppEditorTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppEditorTempl.isPSSysAppIdDirty() && !bl2 : !pSAppEditorTempl.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSAppEditorTempl.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSAppEditorTempl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysEditorStyleId(boolean bl, PSAppEditorTempl pSAppEditorTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppEditorTempl.isPSSysEditorStyleIdDirty() : !pSAppEditorTempl.isPSSysEditorStyleIdDirty()) {
            return null;
        }
        String string = pSAppEditorTempl.getPSSysEditorStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEditorStyleId_Default(pSAppEditorTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEDITORSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubObj(boolean bl, PSAppEditorTempl pSAppEditorTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppEditorTempl.isPubObjDirty() : !pSAppEditorTempl.isPubObjDirty()) {
            return null;
        }
        String string = pSAppEditorTempl.getPubObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubObj_Default(pSAppEditorTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_REQCode(boolean bl, PSAppEditorTempl pSAppEditorTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppEditorTempl.isREQCodeDirty() : !pSAppEditorTempl.isREQCodeDirty()) {
            return null;
        }
        String string = pSAppEditorTempl.getREQCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_REQCode_Default(pSAppEditorTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REQCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode(boolean bl, PSAppEditorTempl pSAppEditorTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppEditorTempl.isTemplCodeDirty() : !pSAppEditorTempl.isTemplCodeDirty()) {
            return null;
        }
        String string = pSAppEditorTempl.getTemplCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode_Default(pSAppEditorTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode2(boolean bl, PSAppEditorTempl pSAppEditorTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppEditorTempl.isTemplCode2Dirty() : !pSAppEditorTempl.isTemplCode2Dirty()) {
            return null;
        }
        String string = pSAppEditorTempl.getTemplCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode2_Default(pSAppEditorTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode3(boolean bl, PSAppEditorTempl pSAppEditorTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppEditorTempl.isTemplCode3Dirty() : !pSAppEditorTempl.isTemplCode3Dirty()) {
            return null;
        }
        String string = pSAppEditorTempl.getTemplCode3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode3_Default(pSAppEditorTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplCode4(boolean bl, PSAppEditorTempl pSAppEditorTempl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppEditorTempl.isTemplCode4Dirty() : !pSAppEditorTempl.isTemplCode4Dirty()) {
            return null;
        }
        String string = pSAppEditorTempl.getTemplCode4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplCode4_Default(pSAppEditorTempl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLCODE4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSAppEditorTempl pSAppEditorTempl, boolean bl) throws Exception {
        super.onSyncEntity(pSAppEditorTempl, bl);
    }

    protected void onSyncIndexEntities(PSAppEditorTempl pSAppEditorTempl, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppEditorTempl, bl);
    }

    public Object getDataContextValue(PSAppEditorTempl pSAppEditorTempl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppEditorTempl, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysApp pSSysApp = pSAppEditorTempl.getPSSysApp();
        if (pSSysApp != null && pSSysApp.contains(string)) {
            return pSSysApp.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSAppEditorTempl pSAppEditorTempl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSAppEditorTempl, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CONTAINERTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContainerType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSAPPEDITORTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppEditorTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPEDITORTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppEditorTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSEDITORTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSEditorTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSEDITORTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSEditorTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSEDITORSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEditorStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEDITORSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEditorStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_REQCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLCODE4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplCode4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ContainerType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTAINERTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_PSAppEditorTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPEDITORTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppEditorTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPEDITORTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSEditorTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSEDITORTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSEditorTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSEDITORTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSysEditorStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEDITORSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEditorStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEDITORSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_REQCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REQCODE", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE2", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE3", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplCode4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLCODE4", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
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

    protected boolean onMergeChild(String string, String string2, PSAppEditorTempl pSAppEditorTempl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppEditorTempl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppEditorTempl pSAppEditorTempl) throws Exception {
        Object object = pSAppEditorTempl.get("PSSYSAPPID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSAPPEDITORTEMPL_PSSYSAPP_PSSYSAPPID", object);
        }
        super.onUpdateParent(pSAppEditorTempl);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSAppEditorTempl pSAppEditorTempl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPEDITORTEMPL");
        if (!bl) {
            pSAppEditorTempl.setCreateDate(null);
            pSAppEditorTempl.setCreateMan(null);
            pSAppEditorTempl.setPSAppEditorTemplId(null);
            pSAppEditorTempl.setUpdateDate(null);
            pSAppEditorTempl.setUpdateMan(null);
            super.exportCurXmlModel(pSAppEditorTempl, xmlNode, bl);
        }
    }
}

