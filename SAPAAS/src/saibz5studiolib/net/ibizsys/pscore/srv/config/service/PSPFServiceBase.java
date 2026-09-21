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
import net.ibizsys.pscore.srv.appdesign.service.PSAppUIStyleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUIStyleServiceBase;
import net.ibizsys.pscore.srv.config.dao.PSPFDAO;
import net.ibizsys.pscore.srv.config.demodel.PSPFDEModel;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSAppTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.service.PSPFAppTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFAppTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFCodeFolderService;
import net.ibizsys.pscore.srv.config.service.PSPFCodeFolderServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTypeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFEditorTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFEditorTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFEditorTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFEditorTypeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFPkgCatService;
import net.ibizsys.pscore.srv.config.service.PSPFPkgCatServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFPkgService;
import net.ibizsys.pscore.srv.config.service.PSPFPkgServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFPluginTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFPluginTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFPreviewNodeService;
import net.ibizsys.pscore.srv.config.service.PSPFPreviewNodeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFPubObjService;
import net.ibizsys.pscore.srv.config.service.PSPFPubObjServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFQuickTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFQuickTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFResourceService;
import net.ibizsys.pscore.srv.config.service.PSPFResourceServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFStyleLogService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleLogServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFUATemplService;
import net.ibizsys.pscore.srv.config.service.PSPFUATemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFVLTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFVLTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFViewTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFViewTemplServiceBase;
import net.ibizsys.pscore.srv.config.service.PSPFViewTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFViewTypeServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSFPFService;
import net.ibizsys.pscore.srv.config.service.PSSFPFServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSubAppService;
import net.ibizsys.pscore.srv.config.service.PSSubAppServiceBase;
import net.ibizsys.pscore.srv.config.service.PSVTSampleService;
import net.ibizsys.pscore.srv.config.service.PSVTSampleServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCAbilityService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCAbilityServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterPFService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterPFServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFServiceBase
extends PSCoreSysServiceBase<PSPF> {
    private static final Log log = LogFactory.getLog(PSPFServiceBase.class);
    public static final String DATASET_CURAPPTYPE = "CurAppType";
    public static final String DATASET_CURAPPTYPEVALID = "CurAppTypeValid";
    public static final String DATASET_CURDC = "CurDC";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_VALID = "Valid";
    private PSPFDEModel pSPFDEModel;
    private PSPFDAO pSPFDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSPFService";
    }

    public PSPFDEModel getPSPFDEModel() {
        if (this.pSPFDEModel == null) {
            try {
                this.pSPFDEModel = (PSPFDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSPFDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSPFDEModel();
    }

    public PSPFDAO getPSPFDAO() {
        if (this.pSPFDAO == null) {
            try {
                this.pSPFDAO = (PSPFDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.config.dao.PSPFDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSPFDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSPFDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPTYPE, (boolean)true) == 0) {
            return this.fetchCurAppType(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPTYPEVALID, (boolean)true) == 0) {
            return this.fetchCurAppTypeValid(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDC, (boolean)true) == 0) {
            return this.fetchCurDC(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VALID, (boolean)true) == 0) {
            return this.fetchValid(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurAppType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPTYPE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurAppTypeValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPTYPEVALID, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDC(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDC, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchValid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VALID, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSPF pSPF, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSPF_PSAPPTYPE_PSAPPTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSAppTypeService", (SessionFactory)this.getSessionFactory());
            PSAppType pSAppType = (PSAppType)iService.getDEModel().createEntity();
            pSAppType.set("PSAPPTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppType);
            } else {
                iService.get((IEntity)pSAppType);
            }
            this.onFillParentInfo_PSAppType(pSPF, pSAppType);
            return;
        }
        super.onFillParentInfo((IEntity)pSPF, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSAppType(PSPF pSPF, PSAppType pSAppType) throws Exception {
        pSPF.setPSAppTypeId(pSAppType.getPSAppTypeId());
        pSPF.setPSAppTypeName(pSAppType.getPSAppTypeName());
    }

    protected void onFillEntityFullInfo(PSPF pSPF, boolean bl) throws Exception {
        if (bl && pSPF.getValidFlag() == null) {
            pSPF.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSPF, bl);
        this.onFillEntityFullInfo_PSAppType(pSPF, bl);
    }

    protected void onFillEntityFullInfo_PSAppType(PSPF pSPF, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSPF pSPF, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSPF, bl);
    }

    public ArrayList<PSPF> selectByPSAppType(PSAppTypeBase pSAppTypeBase) throws Exception {
        return this.selectByPSAppType(pSAppTypeBase, "", -1);
    }

    public ArrayList<PSPF> selectByPSAppType(PSAppTypeBase pSAppTypeBase, String string) throws Exception {
        return this.selectByPSAppType(pSAppTypeBase, string, -1);
    }

    public ArrayList<PSPF> selectByPSAppType(PSAppTypeBase pSAppTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPTYPEID", (Object)pSAppTypeBase.getPSAppTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSPF> arrayList = this.selectByPSAppType(pSAppType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSAppType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSPF_PSAPPTYPE_PSAPPTYPEID", "", iDataEntityModel.getName(), "PSPF", iDataEntityModel.getDataInfo((IEntity)pSAppType), arrayList.get(0)));
        }
    }

    public void resetPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSPF> arrayList = this.selectByPSAppType(pSAppType);
        for (PSPF pSPF : arrayList) {
            PSPF pSPF2 = (PSPF)this.getDEModel().createEntity();
            pSPF2.setPSPFId(pSPF.getPSPFId());
            pSPF2.setPSAppTypeId(null);
            this.update(pSPF2);
        }
    }

    public void removeByPSAppType(PSAppType pSAppType) throws Exception {
        final PSAppType pSAppType2 = pSAppType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSPFServiceBase.this.onBeforeRemoveByPSAppType(pSAppType2);
                PSPFServiceBase.this.internalRemoveByPSAppType(pSAppType2);
                PSPFServiceBase.this.onAfterRemoveByPSAppType(pSAppType2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppType(PSAppType pSAppType) throws Exception {
    }

    protected void internalRemoveByPSAppType(PSAppType pSAppType) throws Exception {
        ArrayList<PSPF> arrayList = this.selectByPSAppType(pSAppType);
        this.onBeforeRemoveByPSAppType(pSAppType, arrayList);
        for (PSPF pSPF : arrayList) {
            this.remove((IEntity)pSPF);
        }
        this.onAfterRemoveByPSAppType(pSAppType, arrayList);
    }

    protected void onAfterRemoveByPSAppType(PSAppType pSAppType) throws Exception {
    }

    protected void onBeforeRemoveByPSAppType(PSAppType pSAppType, ArrayList<PSPF> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppType(PSAppType pSAppType, ArrayList<PSPF> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSPF pSPF) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppUIStyleService)ServiceGlobal.getService(PSAppUIStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppUIStyleServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSDCAbilityService)ServiceGlobal.getService(PSDCAbilityService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCAbilityServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSDevCenterPFService)ServiceGlobal.getService(PSDevCenterPFService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevCenterPFServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSDevSlnSysAppService)ServiceGlobal.getService(PSDevSlnSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFAppTemplService)ServiceGlobal.getService(PSPFAppTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFAppTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        ((PSPFAppTemplServiceBase)pSCoreSysServiceBase).removeByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFCodeFolderService)ServiceGlobal.getService(PSPFCodeFolderService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFCodeFolderServiceBase)pSCoreSysServiceBase).testRemoveByPSSF(pSPF);
        ((PSPFCodeFolderServiceBase)pSCoreSysServiceBase).removeByPSSF(pSPF);
        pSCoreSysServiceBase = (PSPFCtrlTemplService)ServiceGlobal.getService(PSPFCtrlTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFCtrlTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFCtrlTypeService)ServiceGlobal.getService(PSPFCtrlTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFCtrlTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFEditorTemplService)ServiceGlobal.getService(PSPFEditorTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFEditorTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFEditorTypeService)ServiceGlobal.getService(PSPFEditorTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFEditorTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFPkgCatService)ServiceGlobal.getService(PSPFPkgCatService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPkgCatServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFPkgService)ServiceGlobal.getService(PSPFPkgService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPkgServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFPluginTemplService)ServiceGlobal.getService(PSPFPluginTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPluginTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFPreviewNodeService)ServiceGlobal.getService(PSPFPreviewNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPreviewNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFPubCodeService)ServiceGlobal.getService(PSPFPubCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPubCodeServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        ((PSPFPubCodeServiceBase)pSCoreSysServiceBase).removeByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFPubObjService)ServiceGlobal.getService(PSPFPubObjService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFPubObjServiceBase)pSCoreSysServiceBase).testRemoveByPspf(pSPF);
        pSCoreSysServiceBase = (PSPFQuickTemplService)ServiceGlobal.getService(PSPFQuickTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFQuickTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        ((PSPFQuickTemplServiceBase)pSCoreSysServiceBase).removeByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFResourceService)ServiceGlobal.getService(PSPFResourceService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFResourceServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFStyleLogService)ServiceGlobal.getService(PSPFStyleLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFStyleLogServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        ((PSPFStyleLogServiceBase)pSCoreSysServiceBase).removeByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFStyleServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        ((PSPFStyleServiceBase)pSCoreSysServiceBase).removeByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFUATemplService)ServiceGlobal.getService(PSPFUATemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFUATemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        ((PSPFUATemplServiceBase)pSCoreSysServiceBase).removeByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFViewTemplService)ServiceGlobal.getService(PSPFViewTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFViewTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        ((PSPFViewTemplServiceBase)pSCoreSysServiceBase).removeByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFViewTypeService)ServiceGlobal.getService(PSPFViewTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFViewTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSPFVLTemplService)ServiceGlobal.getService(PSPFVLTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSPFVLTemplServiceBase)pSCoreSysServiceBase).testRemoveByPspf(pSPF);
        pSCoreSysServiceBase = (PSSFPFService)ServiceGlobal.getService(PSSFPFService.class, (SessionFactory)this.getSessionFactory());
        ((PSSFPFServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSSubAppService)ServiceGlobal.getService(PSSubAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubAppServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPFPITemplServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        pSCoreSysServiceBase = (PSVTSampleService)ServiceGlobal.getService(PSVTSampleService.class, (SessionFactory)this.getSessionFactory());
        ((PSVTSampleServiceBase)pSCoreSysServiceBase).testRemoveByPSPF(pSPF);
        super.onBeforeRemove(pSPF);
    }

    protected void replaceParentInfo(PSPF pSPF, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSPF, cloneSession);
        if (pSPF.getPSAppTypeId() != null && (iEntity = cloneSession.getEntity("PSAPPTYPE", (Object)pSPF.getPSAppTypeId())) != null) {
            this.onFillParentInfo_PSAppType(pSPF, (PSAppType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSPF pSPF, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSPF, bl);
    }

    protected void onCheckEntity(boolean bl, PSPF pSPF, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AppPubObj(bl, pSPF, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlPartPubObj(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlPubObj(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorPubObj(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableJIT(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FormLayoutMode(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JITAppObj(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppTypeId(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFName(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubMode(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Style2Obj(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StyleObj(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TypeObj(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UAPubObj(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UseJITPreview(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_V2Folder(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_V2GitPath(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_V2ViewMacroParams(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_V2ViewPubObj(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewPubObj(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VLPubObj(bl, pSPF, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSPF, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AppPubObj(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isAppPubObjDirty() : !pSPF.isAppPubObjDirty()) {
            return null;
        }
        String string = pSPF.getAppPubObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AppPubObj_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPPUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlPartPubObj(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isCtrlPartPubObjDirty() : !pSPF.isCtrlPartPubObjDirty()) {
            return null;
        }
        String string = pSPF.getCtrlPartPubObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlPartPubObj_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARTPUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlPubObj(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isCtrlPubObjDirty() : !pSPF.isCtrlPubObjDirty()) {
            return null;
        }
        String string = pSPF.getCtrlPubObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlPubObj_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditorPubObj(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isEditorPubObjDirty() : !pSPF.isEditorPubObjDirty()) {
            return null;
        }
        String string = pSPF.getEditorPubObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorPubObj_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORPUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableJIT(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isEnableJITDirty() : !pSPF.isEnableJITDirty()) {
            return null;
        }
        Integer n = pSPF.getEnableJIT();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableJIT_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEJIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FormLayoutMode(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isFormLayoutModeDirty() : !pSPF.isFormLayoutModeDirty()) {
            return null;
        }
        String string = pSPF.getFormLayoutMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FormLayoutMode_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORMLAYOUTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JITAppObj(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isJITAppObjDirty() : !pSPF.isJITAppObjDirty()) {
            return null;
        }
        String string = pSPF.getJITAppObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JITAppObj_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JITAPPOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isMemoDirty() : !pSPF.isMemoDirty()) {
            return null;
        }
        String string = pSPF.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSPF, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppTypeId(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isPSAppTypeIdDirty() : !pSPF.isPSAppTypeIdDirty()) {
            return null;
        }
        String string = pSPF.getPSAppTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppTypeId_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isPSPFIdDirty() && !bl2 : !pSPF.isPSPFIdDirty()) {
            return null;
        }
        String string = pSPF.getPSPFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default((IEntity)pSPF, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFName(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isPSPFNameDirty() && !bl2 : !pSPF.isPSPFNameDirty()) {
            return null;
        }
        String string = pSPF.getPSPFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFName_Default((IEntity)pSPF, bl2, bl3);
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

    protected EntityFieldError onCheckField_PubMode(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isPubModeDirty() : !pSPF.isPubModeDirty()) {
            return null;
        }
        Integer n = pSPF.getPubMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubMode_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Style2Obj(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isStyle2ObjDirty() : !pSPF.isStyle2ObjDirty()) {
            return null;
        }
        String string = pSPF.getStyle2Obj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Style2Obj_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STYLE2OBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StyleObj(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isStyleObjDirty() : !pSPF.isStyleObjDirty()) {
            return null;
        }
        String string = pSPF.getStyleObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StyleObj_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STYLEOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TypeObj(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isTypeObjDirty() : !pSPF.isTypeObjDirty()) {
            return null;
        }
        String string = pSPF.getTypeObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TypeObj_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TYPEOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UAPubObj(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isUAPubObjDirty() : !pSPF.isUAPubObjDirty()) {
            return null;
        }
        String string = pSPF.getUAPubObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UAPubObj_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UAPUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UseJITPreview(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isUseJITPreviewDirty() : !pSPF.isUseJITPreviewDirty()) {
            return null;
        }
        Integer n = pSPF.getUseJITPreview();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UseJITPreview_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USEJITPREVIEW");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_V2Folder(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isV2FolderDirty() : !pSPF.isV2FolderDirty()) {
            return null;
        }
        String string = pSPF.getV2Folder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_V2Folder_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("V2FOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_V2GitPath(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isV2GitPathDirty() : !pSPF.isV2GitPathDirty()) {
            return null;
        }
        String string = pSPF.getV2GitPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_V2GitPath_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("V2GITPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_V2ViewMacroParams(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isV2ViewMacroParamsDirty() : !pSPF.isV2ViewMacroParamsDirty()) {
            return null;
        }
        String string = pSPF.getV2ViewMacroParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_V2ViewMacroParams_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("V2VIEWMACROPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_V2ViewPubObj(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isV2ViewPubObjDirty() : !pSPF.isV2ViewPubObjDirty()) {
            return null;
        }
        String string = pSPF.getV2ViewPubObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_V2ViewPubObj_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("V2VIEWPUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isValidFlagDirty() : !pSPF.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSPF.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSPF, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewPubObj(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isViewPubObjDirty() : !pSPF.isViewPubObjDirty()) {
            return null;
        }
        String string = pSPF.getViewPubObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewPubObj_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWPUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VLPubObj(boolean bl, PSPF pSPF, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSPF.isVLPubObjDirty() : !pSPF.isVLPubObjDirty()) {
            return null;
        }
        String string = pSPF.getVLPubObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VLPubObj_Default((IEntity)pSPF, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VLPUBOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSPF pSPF, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSPF, bl);
    }

    protected void onSyncIndexEntities(PSPF pSPF, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSPF, bl);
    }

    public Object getDataContextValue(PSPF pSPF, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSPF, string, iDataContextParam)) != null) {
            return object;
        }
        PSAppType pSAppType = pSPF.getPSAppType();
        if (pSAppType != null && pSAppType.contains(string)) {
            return pSAppType.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSPF pSPF, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSPF, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"APPPUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppPubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARTPUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlPartPubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlPubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORPUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorPubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEJIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableJIT_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORMLAYOUTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FormLayoutMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JITAPPOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JITAppObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STYLE2OBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Style2Obj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STYLEOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StyleObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TYPEOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TypeObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UAPUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UAPubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USEJITPREVIEW", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UseJITPreview_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"V2FOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_V2Folder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"V2GITPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_V2GitPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"V2VIEWMACROPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_V2ViewMacroParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"V2VIEWPUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_V2ViewPubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWPUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewPubObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VLPUBOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VLPubObj_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AppPubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("APPPUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
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

    protected String onTestValueRule_CtrlPartPubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLPARTPUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlPubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLPUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditorPubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORPUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableJIT_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FormLayoutMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FORMLAYOUTMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JITAppObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JITAPPOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_PSAppTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PubMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Style2Obj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STYLE2OBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StyleObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STYLEOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TypeObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TYPEOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UAPubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UAPUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
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

    protected String onTestValueRule_UseJITPreview_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_V2Folder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("V2FOLDER", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_V2GitPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("V2GITPATH", iEntity, bl2, null, false, 400, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[400]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[400]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_V2ViewMacroParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("V2VIEWMACROPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_V2ViewPubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("V2VIEWPUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewPubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWPUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VLPubObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VLPUBOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected boolean onMergeChild(String string, String string2, PSPF pSPF) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSPF)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSPF pSPF) throws Exception {
        super.onUpdateParent((IEntity)pSPF);
    }

    @Override
    protected void exportCurXmlModel(PSPF pSPF, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSPF");
        if (!bl) {
            pSPF.setCreateDate(null);
            pSPF.setCreateMan(null);
            pSPF.setPSAppTypeName(null);
            pSPF.setUpdateDate(null);
            pSPF.setUpdateMan(null);
            super.exportCurXmlModel(pSPF, xmlNode, bl);
        }
    }
}

