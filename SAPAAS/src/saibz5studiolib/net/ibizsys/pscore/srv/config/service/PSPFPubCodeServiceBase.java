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
import net.ibizsys.pscore.srv.appdesign.service.PSAppEditorTemplService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppEditorTemplServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewCodeService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewCodeServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewTemplService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewTemplServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSPFPubCodeDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFPubCodeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFCodeFolder;
import net.ibizsys.pscore.srv.config.entity.PSPFCodeFolderBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCodeBase;
import net.ibizsys.pscore.srv.config.service.PSPFAppTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFAppTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFEditorTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFEditorTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.config.service.PSPFUATemplService;
import net.ibizsys.pscore.srv.config.service.PSPFUATemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFVLTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFVLTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFViewTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFViewTemplServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPubCodeServiceBase
extends PSCoreSysServiceBase<PSPFPubCode> {
    private static final Log log = LogFactory.getLog(PSPFPubCodeServiceBase.class);
    public static final String DATASET_CURPF = "CurPF";
    public static final String DATASET_CURPFAPP = "CurPFApp";
    public static final String DATASET_CURPFVIEW = "CurPFView";
    public static final String DATASET_CURPFVIEW2 = "CurPFView2";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSPFPubCodeDEModel pSPFPubCodeDEModel;
    private PSPFPubCodeDAO pSPFPubCodeDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFPubCodeService";
    }

    public PSPFPubCodeDEModel getPSPFPubCodeDEModel() {
        if (this.pSPFPubCodeDEModel == null) {
            try {
                this.pSPFPubCodeDEModel = (PSPFPubCodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFPubCodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPubCodeDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFPubCodeDEModel();
    }

    public PSPFPubCodeDAO getPSPFPubCodeDAO() {
        if (this.pSPFPubCodeDAO == null) {
            try {
                this.pSPFPubCodeDAO = (PSPFPubCodeDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFPubCodeDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFPubCodeDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFPubCodeDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPF, (boolean)true) == 0) {
            return this.fetchCurPF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPFAPP, (boolean)true) == 0) {
            return this.fetchCurPFApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPFVIEW, (boolean)true) == 0) {
            return this.fetchCurPFView(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPFVIEW2, (boolean)true) == 0) {
            return this.fetchCurPFView2(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurPF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurPFApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPFAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurPFView(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPFVIEW, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurPFView2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPFVIEW2, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSPFPubCode pSPFPubCode, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPUBCODE_PSPFCODEFOLDER_PSPFCODEFOLDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFCodeFolderService", (SessionFactory)this.getSessionFactory());
            PSPFCodeFolder pSPFCodeFolder = (PSPFCodeFolder)iService.getDEModel().createEntity();
            pSPFCodeFolder.set("PSPFCODEFOLDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFCodeFolder);
            } else {
                iService.get((IEntity)pSPFCodeFolder);
            }
            this.onFillParentInfo_PSPFCodeFolder(pSPFPubCode, pSPFCodeFolder);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPUBCODE_PSPFPUBCODE_PPSPFPUBCODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPubCodeService", (SessionFactory)this.getSessionFactory());
            PSPFPubCode pSPFPubCode2 = (PSPFPubCode)iService.getDEModel().createEntity();
            pSPFPubCode2.set("PSPFPUBCODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPFPubCode2);
            } else {
                iService.get((IEntity)pSPFPubCode2);
            }
            this.onFillParentInfo_PPSPFPubCode(pSPFPubCode, pSPFPubCode2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPFPUBCODE_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPF);
            } else {
                iService.get((IEntity)pSPF);
            }
            this.onFillParentInfo_PSPF(pSPFPubCode, pSPF);
            return;
        }
        super.onFillParentInfo((IEntity)pSPFPubCode, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSPFCodeFolder(PSPFPubCode pSPFPubCode, PSPFCodeFolder pSPFCodeFolder) throws Exception {
        pSPFPubCode.setPSPFCodeFolderId(pSPFCodeFolder.getPSPFCodeFolderId());
        pSPFPubCode.setPSPFCodeFolderName(pSPFCodeFolder.getPSPFCodeFolderName());
    }

    protected void onFillParentInfo_PPSPFPubCode(PSPFPubCode pSPFPubCode, PSPFPubCode pSPFPubCode2) throws Exception {
        pSPFPubCode.setPPSPFPubCodeId(pSPFPubCode2.getPSPFPubCodeId());
        pSPFPubCode.setPPSPFPubCodeName(pSPFPubCode2.getPSPFPubCodeName());
    }

    protected void onFillParentInfo_PSPF(PSPFPubCode pSPFPubCode, PSPF pSPF) throws Exception {
        pSPFPubCode.setPSPFId(pSPF.getPSPFId());
        pSPFPubCode.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillEntityFullInfo(PSPFPubCode pSPFPubCode, boolean bl) throws Exception {
        if (bl && pSPFPubCode.getValidFlag() == null) {
            pSPFPubCode.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSPFPubCode, bl);
        this.onFillEntityFullInfo_PSPFCodeFolder(pSPFPubCode, bl);
        this.onFillEntityFullInfo_PPSPFPubCode(pSPFPubCode, bl);
        this.onFillEntityFullInfo_PSPF(pSPFPubCode, bl);
    }

    protected void onFillEntityFullInfo_PSPFCodeFolder(PSPFPubCode pSPFPubCode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSPFPubCode(PSPFPubCode pSPFPubCode, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSPF(PSPFPubCode pSPFPubCode, boolean bl) throws Exception {
        if (pSPFPubCode.isPSPFIdDirty()) {
            if (pSPFPubCode.getPSPFId() != null) {
                if (pSPFPubCode.getPSPFId() == null || pSPFPubCode.getPSPFName() == null) {
                    PSPF pSPF = pSPFPubCode.getPSPF();
                    pSPFPubCode.setPSPFName(pSPF.getPSPFName());
                }
            } else {
                pSPFPubCode.setPSPFName(null);
            }
        }
    }

    protected void onWriteBackParent(PSPFPubCode pSPFPubCode, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSPFPubCode, bl);
    }

    public ArrayList<PSPFPubCode> selectByPSPFCodeFolder(PSPFCodeFolderBase pSPFCodeFolderBase) throws Exception {
        return this.selectByPSPFCodeFolder(pSPFCodeFolderBase, "", -1);
    }

    public ArrayList<PSPFPubCode> selectByPSPFCodeFolder(PSPFCodeFolderBase pSPFCodeFolderBase, String string) throws Exception {
        return this.selectByPSPFCodeFolder(pSPFCodeFolderBase, string, -1);
    }

    public ArrayList<PSPFPubCode> selectByPSPFCodeFolder(PSPFCodeFolderBase pSPFCodeFolderBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFCODEFOLDERID", (Object)pSPFCodeFolderBase.getPSPFCodeFolderId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFCodeFolderCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFCodeFolderCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFPubCode> selectByPPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase) throws Exception {
        return this.selectByPPSPFPubCode(pSPFPubCodeBase, "", -1);
    }

    public ArrayList<PSPFPubCode> selectByPPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string) throws Exception {
        return this.selectByPPSPFPubCode(pSPFPubCodeBase, string, -1);
    }

    public ArrayList<PSPFPubCode> selectByPPSPFPubCode(PSPFPubCodeBase pSPFPubCodeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSPFPUBCODEID", (Object)pSPFPubCodeBase.getPSPFPubCodeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSPFPubCodeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSPFPubCodeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSPFPubCode> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSPFPubCode> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSPFPubCode> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
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

    public void testRemoveByPSPFCodeFolder(PSPFCodeFolder pSPFCodeFolder) throws Exception {
        ArrayList<PSPFPubCode> arrayList = this.selectByPSPFCodeFolder(pSPFCodeFolder, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFCODEFOLDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPFCodeFolder);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFPUBCODE_PSPFCODEFOLDER_PSPFCODEFOLDERID", "", iDataEntityModel.getName(), "PSPFPUBCODE", iDataEntityModel.getDataInfo((IEntity)pSPFCodeFolder), arrayList.get(0)));
        }
    }

    public void resetPSPFCodeFolder(PSPFCodeFolder pSPFCodeFolder) throws Exception {
        ArrayList<PSPFPubCode> arrayList = this.selectByPSPFCodeFolder(pSPFCodeFolder);
        for (PSPFPubCode pSPFPubCode : arrayList) {
            PSPFPubCode pSPFPubCode2 = (PSPFPubCode)this.getDEModel().createEntity();
            pSPFPubCode2.setPSPFPubCodeId(pSPFPubCode.getPSPFPubCodeId());
            pSPFPubCode2.setPSPFCodeFolderId(null);
            this.update(pSPFPubCode2);
        }
    }

    public void removeByPSPFCodeFolder(PSPFCodeFolder pSPFCodeFolder) throws Exception {
        final PSPFCodeFolder pSPFCodeFolder2 = pSPFCodeFolder;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPubCodeServiceBase.this.onBeforeRemoveByPSPFCodeFolder(pSPFCodeFolder2);
                PSPFPubCodeServiceBase.this.internalRemoveByPSPFCodeFolder(pSPFCodeFolder2);
                PSPFPubCodeServiceBase.this.onAfterRemoveByPSPFCodeFolder(pSPFCodeFolder2);
            }
        });
    }

    protected void onBeforeRemoveByPSPFCodeFolder(PSPFCodeFolder pSPFCodeFolder) throws Exception {
    }

    protected void internalRemoveByPSPFCodeFolder(PSPFCodeFolder pSPFCodeFolder) throws Exception {
        ArrayList<PSPFPubCode> arrayList = this.selectByPSPFCodeFolder(pSPFCodeFolder);
        this.onBeforeRemoveByPSPFCodeFolder(pSPFCodeFolder, arrayList);
        for (PSPFPubCode pSPFPubCode : arrayList) {
            this.remove((IEntity)pSPFPubCode);
        }
        this.onAfterRemoveByPSPFCodeFolder(pSPFCodeFolder, arrayList);
    }

    protected void onAfterRemoveByPSPFCodeFolder(PSPFCodeFolder pSPFCodeFolder) throws Exception {
    }

    protected void onBeforeRemoveByPSPFCodeFolder(PSPFCodeFolder pSPFCodeFolder, ArrayList<PSPFPubCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPFCodeFolder(PSPFCodeFolder pSPFCodeFolder, ArrayList<PSPFPubCode> arrayList) throws Exception {
    }

    public void testRemoveByPPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSPFPubCode> arrayList = this.selectByPPSPFPubCode(pSPFPubCode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPFPUBCODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPFPubCode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPFPUBCODE_PSPFPUBCODE_PPSPFPUBCODEID", "", iDataEntityModel.getName(), "PSPFPUBCODE", iDataEntityModel.getDataInfo((IEntity)pSPFPubCode), arrayList.get(0)));
        }
    }

    public void resetPPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSPFPubCode> arrayList = this.selectByPPSPFPubCode(pSPFPubCode);
        for (PSPFPubCode pSPFPubCode2 : arrayList) {
            PSPFPubCode pSPFPubCode3 = (PSPFPubCode)this.getDEModel().createEntity();
            pSPFPubCode3.setPSPFPubCodeId(pSPFPubCode2.getPSPFPubCodeId());
            pSPFPubCode3.setPPSPFPubCodeId(null);
            this.update(pSPFPubCode3);
        }
    }

    public void removeByPPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        final PSPFPubCode pSPFPubCode2 = pSPFPubCode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPubCodeServiceBase.this.onBeforeRemoveByPPSPFPubCode(pSPFPubCode2);
                PSPFPubCodeServiceBase.this.internalRemoveByPPSPFPubCode(pSPFPubCode2);
                PSPFPubCodeServiceBase.this.onAfterRemoveByPPSPFPubCode(pSPFPubCode2);
            }
        });
    }

    protected void onBeforeRemoveByPPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void internalRemoveByPPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
        ArrayList<PSPFPubCode> arrayList = this.selectByPPSPFPubCode(pSPFPubCode);
        this.onBeforeRemoveByPPSPFPubCode(pSPFPubCode, arrayList);
        for (PSPFPubCode pSPFPubCode2 : arrayList) {
            this.remove((IEntity)pSPFPubCode2);
        }
        this.onAfterRemoveByPPSPFPubCode(pSPFPubCode, arrayList);
    }

    protected void onAfterRemoveByPPSPFPubCode(PSPFPubCode pSPFPubCode) throws Exception {
    }

    protected void onBeforeRemoveByPPSPFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSPFPubCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSPFPubCode(PSPFPubCode pSPFPubCode, ArrayList<PSPFPubCode> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFPubCode> arrayList = this.selectByPSPF(pSPF);
        for (PSPFPubCode pSPFPubCode : arrayList) {
            PSPFPubCode pSPFPubCode2 = (PSPFPubCode)this.getDEModel().createEntity();
            pSPFPubCode2.setPSPFPubCodeId(pSPFPubCode.getPSPFPubCodeId());
            pSPFPubCode2.setPSPFId(null);
            this.update(pSPFPubCode2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFPubCodeServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSPFPubCodeServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSPFPubCodeServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSPFPubCode> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSPFPubCode pSPFPubCode : arrayList) {
            this.remove((IEntity)pSPFPubCode);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSPFPubCode> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSPFPubCode> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPFPubCode pSPFPubCode) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppEditorTemplService)ServiceGlobal.getService(PSAppEditorTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppEditorTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPubCode(pSPFPubCode);
        pSCoreSysServiceBase = (PSAppViewCodeService)ServiceGlobal.getService(PSAppViewCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewCodeServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPubCode(pSPFPubCode);
        pSCoreSysServiceBase = (PSAppViewTemplService)ServiceGlobal.getService(PSAppViewTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPubCode(pSPFPubCode);
        pSCoreSysServiceBase = (PSPFAppTemplService)ServiceGlobal.getService(PSPFAppTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFAppTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPubCode(pSPFPubCode);
        pSCoreSysServiceBase = (PSPFCtrlTemplService)ServiceGlobal.getService(PSPFCtrlTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFCtrlTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPubCode(pSPFPubCode);
        pSCoreSysServiceBase = (PSPFEditorTemplService)ServiceGlobal.getService(PSPFEditorTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFEditorTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPubCode(pSPFPubCode);
        pSCoreSysServiceBase = (PSPFPubCodeService)ServiceGlobal.getService(PSPFPubCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPubCodeServiceBase)pSCoreSysServiceBase).testRemoveByPPSPFPubCode(pSPFPubCode);
        pSCoreSysServiceBase = (PSPFUATemplService)ServiceGlobal.getService(PSPFUATemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFUATemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPubCode(pSPFPubCode);
        pSCoreSysServiceBase = (PSPFViewTemplService)ServiceGlobal.getService(PSPFViewTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFViewTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPubCode(pSPFPubCode);
        pSCoreSysServiceBase = (PSPFVLTemplService)ServiceGlobal.getService(PSPFVLTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFVLTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPFPubCode(pSPFPubCode);
        super.onBeforeRemove(pSPFPubCode);
    }

    protected void replaceParentInfo(PSPFPubCode pSPFPubCode, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSPFPubCode, cloneSession);
        if (pSPFPubCode.getPSPFCodeFolderId() != null && (iEntity = cloneSession.getEntity("PSPFCODEFOLDER", (Object)pSPFPubCode.getPSPFCodeFolderId())) != null) {
            this.onFillParentInfo_PSPFCodeFolder(pSPFPubCode, (PSPFCodeFolder)iEntity);
        }
        if (pSPFPubCode.getPPSPFPubCodeId() != null && (iEntity = cloneSession.getEntity("PSPFPUBCODE", (Object)pSPFPubCode.getPPSPFPubCodeId())) != null) {
            this.onFillParentInfo_PPSPFPubCode(pSPFPubCode, (PSPFPubCode)iEntity);
        }
        if (pSPFPubCode.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSPFPubCode.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSPFPubCode, (PSPF)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPFPubCode pSPFPubCode, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSPFPubCode, bl);
    }

    protected void onCheckEntity(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CLASSEXT(bl, pSPFPubCode, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeEXT(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeFolder(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeFolder2(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaViewFlag(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HasPSPFPubCode(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PITemplCode(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PITemplCode2(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PKGName(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSPFPubCodeId(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreviewCode(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreviewFlag(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFCodeFolderId(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFName(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubCodeId(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFPubCodeName(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubCodeDesc(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetType(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSPFPubCode, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSPFPubCode, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CLASSEXT(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isCLASSEXTDirty() : !pSPFPubCode.isCLASSEXTDirty()) {
            return null;
        }
        String string = pSPFPubCode.getCLASSEXT();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CLASSEXT_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLASSEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeEXT(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isCodeEXTDirty() && !bl2 : !pSPFPubCode.isCodeEXTDirty()) {
            return null;
        }
        String string = pSPFPubCode.getCodeEXT();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEEXT");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeEXT_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeFolder(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isCodeFolderDirty() : !pSPFPubCode.isCodeFolderDirty()) {
            return null;
        }
        String string = pSPFPubCode.getCodeFolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeFolder_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEFOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeFolder2(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isCodeFolder2Dirty() : !pSPFPubCode.isCodeFolder2Dirty()) {
            return null;
        }
        String string = pSPFPubCode.getCodeFolder2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeFolder2_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODEFOLDER2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isDynaModelFlagDirty() : !pSPFPubCode.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSPFPubCode.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaViewFlag(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isDynaViewFlagDirty() : !pSPFPubCode.isDynaViewFlagDirty()) {
            return null;
        }
        Integer n = pSPFPubCode.getDynaViewFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaViewFlag_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAVIEWFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HasPSPFPubCode(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isHasPSPFPubCodeDirty() : !pSPFPubCode.isHasPSPFPubCodeDirty()) {
            return null;
        }
        Integer n = pSPFPubCode.getHasPSPFPubCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_HasPSPFPubCode_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HASPSPFPUBCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isMemoDirty() : !pSPFPubCode.isMemoDirty()) {
            return null;
        }
        String string = pSPFPubCode.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSPFPubCode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PITemplCode(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isPITemplCodeDirty() : !pSPFPubCode.isPITemplCodeDirty()) {
            return null;
        }
        String string = pSPFPubCode.getPITemplCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PITemplCode_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PITEMPLCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PITemplCode2(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isPITemplCode2Dirty() : !pSPFPubCode.isPITemplCode2Dirty()) {
            return null;
        }
        String string = pSPFPubCode.getPITemplCode2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PITemplCode2_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PITEMPLCODE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PKGName(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isPKGNameDirty() : !pSPFPubCode.isPKGNameDirty()) {
            return null;
        }
        String string = pSPFPubCode.getPKGName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PKGName_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PKGNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSPFPubCodeId(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isPPSPFPubCodeIdDirty() : !pSPFPubCode.isPPSPFPubCodeIdDirty()) {
            return null;
        }
        String string = pSPFPubCode.getPPSPFPubCodeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSPFPubCodeId_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSPFPUBCODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreviewCode(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isPreviewCodeDirty() : !pSPFPubCode.isPreviewCodeDirty()) {
            return null;
        }
        String string = pSPFPubCode.getPreviewCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreviewCode_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVIEWCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreviewFlag(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isPreviewFlagDirty() : !pSPFPubCode.isPreviewFlagDirty()) {
            return null;
        }
        Integer n = pSPFPubCode.getPreviewFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PreviewFlag_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVIEWFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFCodeFolderId(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isPSPFCodeFolderIdDirty() && !bl2 : !pSPFPubCode.isPSPFCodeFolderIdDirty()) {
            return null;
        }
        String string = pSPFPubCode.getPSPFCodeFolderId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFCODEFOLDERID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFCodeFolderId_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFCODEFOLDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isPSPFIdDirty() && !bl2 : !pSPFPubCode.isPSPFIdDirty()) {
            return null;
        }
        String string = pSPFPubCode.getPSPFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default((IEntity)pSPFPubCode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFName(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isPSPFNameDirty() && !bl2 : !pSPFPubCode.isPSPFNameDirty()) {
            return null;
        }
        String string = pSPFPubCode.getPSPFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFName_Default((IEntity)pSPFPubCode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPubCodeId(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isPSPFPubCodeIdDirty() && !bl2 : !pSPFPubCode.isPSPFPubCodeIdDirty()) {
            return null;
        }
        String string = pSPFPubCode.getPSPFPubCodeId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBCODEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubCodeId_Default((IEntity)pSPFPubCode, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFPubCodeName(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isPSPFPubCodeNameDirty() && !bl2 : !pSPFPubCode.isPSPFPubCodeNameDirty()) {
            return null;
        }
        String string = pSPFPubCode.getPSPFPubCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBCODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFPubCodeName_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFPUBCODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubCodeDesc(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isPubCodeDescDirty() : !pSPFPubCode.isPubCodeDescDirty()) {
            return null;
        }
        String string = pSPFPubCode.getPubCodeDesc();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PubCodeDesc_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBCODEDESC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetType(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isTargetTypeDirty() && !bl2 : !pSPFPubCode.isTargetTypeDirty()) {
            return null;
        }
        String string = pSPFPubCode.getTargetType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetType_Default((IEntity)pSPFPubCode, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSPFPubCode pSPFPubCode, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPFPubCode.isValidFlagDirty() && !bl2 : !pSPFPubCode.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSPFPubCode.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSPFPubCode, bl2, bl3);
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

    protected void onSyncEntity(PSPFPubCode pSPFPubCode, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSPFPubCode, bl);
    }

    protected void onSyncIndexEntities(PSPFPubCode pSPFPubCode, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSPFPubCode, bl);
    }

    public Object getDataContextValue(PSPFPubCode pSPFPubCode, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSPFPubCode, string, iDataContextParam)) != null) {
            return object;
        }
        PSPF pSPF = pSPFPubCode.getPSPF();
        if (pSPF != null && pSPF.contains(string)) {
            return pSPF.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSPFPubCode pSPFPubCode, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSPFPubCode, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CLASSEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CLASSEXT_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODEEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeEXT_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODEFOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeFolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODEFOLDER2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeFolder2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAVIEWFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaViewFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HASPSPFPUBCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HasPSPFPubCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PITEMPLCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PITemplCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PITEMPLCODE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PITemplCode2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PKGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PKGName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSPFPUBCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSPFPubCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSPFPUBCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSPFPubCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVIEWCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreviewCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVIEWFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreviewFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFCODEFOLDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFCodeFolderId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFCODEFOLDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFCodeFolderName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBCODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubCodeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFPUBCODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFPubCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBCODEDESC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubCodeDesc_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetType_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_CLASSEXT_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CLASSEXT", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeEXT_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEEXT", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeFolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEFOLDER", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeFolder2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODEFOLDER2", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaViewFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HasPSPFPubCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PITemplCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PITEMPLCODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PITemplCode2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PITEMPLCODE2", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PKGName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PKGNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSPFPubCodeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSPFPUBCODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSPFPubCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSPFPUBCODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreviewCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVIEWCODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreviewFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSPFCodeFolderId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFCODEFOLDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFCodeFolderName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFCODEFOLDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PubCodeDesc_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PUBCODEDESC", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
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

    protected boolean onMergeChild(String string, String string2, PSPFPubCode pSPFPubCode) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSPFPubCode)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPFPubCode pSPFPubCode) throws Exception {
        super.onUpdateParent((IEntity)pSPFPubCode);
    }

    @Override
    protected void exportCurXmlModel(PSPFPubCode pSPFPubCode, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPFPUBCODE");
        if (!bl) {
            pSPFPubCode.setCreateDate(null);
            pSPFPubCode.setCreateMan(null);
            pSPFPubCode.setPPSPFPubCodeName(null);
            pSPFPubCode.setPSPFPubCodeId(null);
            pSPFPubCode.setUpdateDate(null);
            pSPFPubCode.setUpdateMan(null);
            super.exportCurXmlModel(pSPFPubCode, xmlNode, bl);
        }
    }
}

