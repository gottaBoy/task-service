/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetCond
 *  net.ibizsys.paas.core.IDEACMode
 *  net.ibizsys.paas.core.IDEDataQuery
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 *  net.ibizsys.paas.core.IDEDataSet
 *  net.ibizsys.paas.core.IDEFSearchMode
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.core.IDEUIAction
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.demodel.DEFSearchModeModel
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.SysModelGlobal
 */
package net.ibizsys.pscore.srv.devcenter.demodel;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.IDEACMode;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.demodel.DEFSearchModeModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.pscore.srv.PSCoreSysModel;
import net.ibizsys.pscore.srv.core.IPSDEFGroupModel;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupDetailModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupModel;
import net.ibizsys.pscore.srv.core.PSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDataEntityModelBase;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.ac.PSDCCodeSnippetDefaultACModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetAllDCAppDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetAllDCCLDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetAllDCDBDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetAllDCDEActionDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetAllDCDEDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetAllDCDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetAllDCNoneDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetAllDCSysDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetAllDCViewDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetCurDCAppDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetCurDCCLDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetCurDCDBDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetCurDCDEActionDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetCurDCDEDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetCurDCDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetCurDCNoneDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetCurDCSysDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetCurDCViewDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataquery.PSDCCodeSnippetDefaultDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataset.PSDCCodeSnippetAllDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataset.PSDCCodeSnippetCurDCAppDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataset.PSDCCodeSnippetCurDCCLDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataset.PSDCCodeSnippetCurDCDBDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataset.PSDCCodeSnippetCurDCDEActionDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataset.PSDCCodeSnippetCurDCDEDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataset.PSDCCodeSnippetCurDCDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataset.PSDCCodeSnippetCurDCNoneDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataset.PSDCCodeSnippetCurDCSysDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataset.PSDCCodeSnippetCurDCViewDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataset.PSDCCodeSnippetDefaultDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.uiaction.PSDCCodeSnippetPublishUIActionModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService;

public abstract class PSDCCodeSnippetDEModelBase
extends PSDataEntityModelBase<PSDCCodeSnippet> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDCCodeSnippetService pSDCCodeSnippetService;

    public PSDCCodeSnippetDEModelBase() throws Exception {
        this.setId("e56d1d16ea2c448b74c49c27e75fcdb6");
        this.setName("PSDCCODESNIPPET");
        this.setCodeName("PSDCCodeSnippet");
        this.setTableName("T_SRFPSDCCODESNIPPET");
        this.setViewName("v_PSDCCODESNIPPET");
        this.setLogicName("\u4e2d\u5fc3\u4ee3\u7801\u7247\u6bb5");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCCodeSnippetDEModel", (IDataEntityModel)this);
            this.getPSCoreSysModel().registerDataEntityModel(this);
        }
        this.prepareModels();
    }

    public PSCoreSysModel getPSCoreSysModel() {
        if (this.pSCoreSysModel == null) {
            try {
                this.pSCoreSysModel = (PSCoreSysModel)SysModelGlobal.getSystem((String)"net.ibizsys.pscore.srv.PSCoreSysModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCoreSysModel;
    }

    public ISystem getSystem() {
        return this.getPSCoreSysModel();
    }

    public PSDCCodeSnippetService getRealService() {
        if (this.pSDCCodeSnippetService == null) {
            try {
                this.pSDCCodeSnippetService = (PSDCCodeSnippetService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCCodeSnippetService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService";
    }

    public PSDCCodeSnippet createEntity() {
        return new PSDCCodeSnippet();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("ALLDCFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("737f383db9bb7b28041633ee75f84d4a");
            pSDEFieldModel.setName("ALLDCFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e73\u53f0\u6a21\u677f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("AllDCFlag");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CODECAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f5ba2a0288dc35dfe4b322e3cd016a22");
            pSDEFieldModel.setName("CODECAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u5206\u7c7b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PSCodeSnippetCatCodeListModel");
            pSDEFieldModel.setCodeName("CodeCat");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CODECAT_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CODECAT_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CODETARGET");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3b200dda34b865e6a7093985690908d2");
            pSDEFieldModel.setName("CODETARGET");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u76ee\u6807");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PSCodeSnippetTypeCodeListModel");
            pSDEFieldModel.setCodeName("CodeTarget");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CODETARGET_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CODETARGET_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ff102dc963ef1312cbeebce23bc799e7");
            pSDEFieldModel.setName("CREATEDATE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5efa\u7acb\u65f6\u95f4");
            pSDEFieldModel.setDataType("DATETIME");
            pSDEFieldModel.setStdDataType(5);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPreDefinedType("CREATEDATE");
            pSDEFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("CreateDate");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEMAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4fb8698d5158870a4be0aa51d0c54d65");
            pSDEFieldModel.setName("CREATEMAN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5efa\u7acb\u4eba");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPreDefinedType("CREATEMAN");
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.SysOperatorCodeListModel");
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("CreateMan");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("KEYWORDS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3860a4c8c4a2e047d981cda81f554e5b");
            pSDEFieldModel.setName("KEYWORDS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u952e\u5b57");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Keywords");
            pSDEFieldModel.setLength(500);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_KEYWORDS_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_KEYWORDS_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f14d075a203346302628791c75128038");
            pSDEFieldModel.setName("MEMO");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5907\u6ce8");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Memo");
            pSDEFieldModel.setLength(2000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDCCODESNIPPETID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("84398d668913454aa52f0e80450d0c16");
            pSDEFieldModel.setName("PSDCCODESNIPPETID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u5fc3\u4ee3\u7801\u7247\u6bb5\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDCCodeSnippetId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDCCODESNIPPETNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e568c631157b583557d0901624bcfdfb");
            pSDEFieldModel.setName("PSDCCODESNIPPETNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7247\u6bb5\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSDCCodeSnippetName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCCODESNIPPETNAME_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDCCODESNIPPETNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVCENTERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("539f60f93da06f97a9cfad4d068ecf5a");
            pSDEFieldModel.setName("PSDEVCENTERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u4e2d\u5fc3");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCCODESNIPPET_PSDEVCENTER_PSDEVCENTERID");
            pSDEFieldModel.setLinkDEFName("PSDEVCENTERID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDevCenterId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVCENTERID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVCENTERID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVCENTERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5009009d7b68c29ed00c7b0ef39a4a21");
            pSDEFieldModel.setName("PSDEVCENTERNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u4e2d\u5fc3");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCCODESNIPPET_PSDEVCENTER_PSDEVCENTERID");
            pSDEFieldModel.setLinkDEFName("PSDEVCENTERNAME");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDevCenterName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVCENTERNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVCENTERNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVCENTERNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVCENTERNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("92549ffd18452e24a59e230ca5c213ac");
            pSDEFieldModel.setName("PSDEVSLNID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u65b9\u6848");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCCODESNIPPET_PSDEVSLN_PSDEVSLNID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNID");
            pSDEFieldModel.setCodeName("PSDevSlnId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8e2766a4aa30e72a8d086bc49b8be676");
            pSDEFieldModel.setName("PSDEVSLNNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u65b9\u6848");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCCODESNIPPET_PSDEVSLN_PSDEVSLNID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDevSlnName");
            pSDEFieldModel.setLength(60);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("507ec147618ce0fbdda10b14913dd8aa");
            pSDEFieldModel.setName("REFMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u5f15\u7528\u6a21\u5f0f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RefMode");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPLCODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c16cc5c1415043d50418743fe9b7ef5c");
            pSDEFieldModel.setName("TEMPLCODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u6a21\u7248");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("TemplCode");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPLCODE2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("883d767c6eb29118e4a6f2f5fac8d240");
            pSDEFieldModel.setName("TEMPLCODE2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u6a21\u72482");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("TemplCode2");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b312529c2481475d95bcf1f40a81ba7e");
            pSDEFieldModel.setName("UPDATEDATE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u65b0\u65f6\u95f4");
            pSDEFieldModel.setDataType("DATETIME");
            pSDEFieldModel.setStdDataType(5);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPreDefinedType("UPDATEDATE");
            pSDEFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("UpdateDate");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEMAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1c90ff301181cb14fa78665e87811782");
            pSDEFieldModel.setName("UPDATEMAN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u65b0\u4eba");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPreDefinedType("UPDATEMAN");
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.SysOperatorCodeListModel");
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("UpdateMan");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSDCCodeSnippetDefaultACModel pSDCCodeSnippetDefaultACModel = new PSDCCodeSnippetDefaultACModel();
        pSDCCodeSnippetDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDCCodeSnippetDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDCCodeSnippetAllDSModel pSDCCodeSnippetAllDSModel = new PSDCCodeSnippetAllDSModel();
        pSDCCodeSnippetAllDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCCodeSnippetAllDSModel);
        PSDCCodeSnippetCurDCDSModel pSDCCodeSnippetCurDCDSModel = new PSDCCodeSnippetCurDCDSModel();
        pSDCCodeSnippetCurDCDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCCodeSnippetCurDCDSModel);
        PSDCCodeSnippetCurDCAppDSModel pSDCCodeSnippetCurDCAppDSModel = new PSDCCodeSnippetCurDCAppDSModel();
        pSDCCodeSnippetCurDCAppDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCCodeSnippetCurDCAppDSModel);
        PSDCCodeSnippetCurDCCLDSModel pSDCCodeSnippetCurDCCLDSModel = new PSDCCodeSnippetCurDCCLDSModel();
        pSDCCodeSnippetCurDCCLDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCCodeSnippetCurDCCLDSModel);
        PSDCCodeSnippetCurDCDBDSModel pSDCCodeSnippetCurDCDBDSModel = new PSDCCodeSnippetCurDCDBDSModel();
        pSDCCodeSnippetCurDCDBDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCCodeSnippetCurDCDBDSModel);
        PSDCCodeSnippetCurDCDEDSModel pSDCCodeSnippetCurDCDEDSModel = new PSDCCodeSnippetCurDCDEDSModel();
        pSDCCodeSnippetCurDCDEDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCCodeSnippetCurDCDEDSModel);
        PSDCCodeSnippetCurDCDEActionDSModel pSDCCodeSnippetCurDCDEActionDSModel = new PSDCCodeSnippetCurDCDEActionDSModel();
        pSDCCodeSnippetCurDCDEActionDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCCodeSnippetCurDCDEActionDSModel);
        PSDCCodeSnippetCurDCNoneDSModel pSDCCodeSnippetCurDCNoneDSModel = new PSDCCodeSnippetCurDCNoneDSModel();
        pSDCCodeSnippetCurDCNoneDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCCodeSnippetCurDCNoneDSModel);
        PSDCCodeSnippetCurDCSysDSModel pSDCCodeSnippetCurDCSysDSModel = new PSDCCodeSnippetCurDCSysDSModel();
        pSDCCodeSnippetCurDCSysDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCCodeSnippetCurDCSysDSModel);
        PSDCCodeSnippetCurDCViewDSModel pSDCCodeSnippetCurDCViewDSModel = new PSDCCodeSnippetCurDCViewDSModel();
        pSDCCodeSnippetCurDCViewDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCCodeSnippetCurDCViewDSModel);
        PSDCCodeSnippetDefaultDSModel pSDCCodeSnippetDefaultDSModel = new PSDCCodeSnippetDefaultDSModel();
        pSDCCodeSnippetDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCCodeSnippetDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDCCodeSnippetAllDCDQModel pSDCCodeSnippetAllDCDQModel = new PSDCCodeSnippetAllDCDQModel();
        pSDCCodeSnippetAllDCDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetAllDCDQModel);
        PSDCCodeSnippetAllDCAppDQModel pSDCCodeSnippetAllDCAppDQModel = new PSDCCodeSnippetAllDCAppDQModel();
        pSDCCodeSnippetAllDCAppDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetAllDCAppDQModel);
        PSDCCodeSnippetAllDCCLDQModel pSDCCodeSnippetAllDCCLDQModel = new PSDCCodeSnippetAllDCCLDQModel();
        pSDCCodeSnippetAllDCCLDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetAllDCCLDQModel);
        PSDCCodeSnippetAllDCDBDQModel pSDCCodeSnippetAllDCDBDQModel = new PSDCCodeSnippetAllDCDBDQModel();
        pSDCCodeSnippetAllDCDBDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetAllDCDBDQModel);
        PSDCCodeSnippetAllDCDEDQModel pSDCCodeSnippetAllDCDEDQModel = new PSDCCodeSnippetAllDCDEDQModel();
        pSDCCodeSnippetAllDCDEDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetAllDCDEDQModel);
        PSDCCodeSnippetAllDCDEActionDQModel pSDCCodeSnippetAllDCDEActionDQModel = new PSDCCodeSnippetAllDCDEActionDQModel();
        pSDCCodeSnippetAllDCDEActionDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetAllDCDEActionDQModel);
        PSDCCodeSnippetAllDCNoneDQModel pSDCCodeSnippetAllDCNoneDQModel = new PSDCCodeSnippetAllDCNoneDQModel();
        pSDCCodeSnippetAllDCNoneDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetAllDCNoneDQModel);
        PSDCCodeSnippetAllDCSysDQModel pSDCCodeSnippetAllDCSysDQModel = new PSDCCodeSnippetAllDCSysDQModel();
        pSDCCodeSnippetAllDCSysDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetAllDCSysDQModel);
        PSDCCodeSnippetAllDCViewDQModel pSDCCodeSnippetAllDCViewDQModel = new PSDCCodeSnippetAllDCViewDQModel();
        pSDCCodeSnippetAllDCViewDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetAllDCViewDQModel);
        PSDCCodeSnippetCurDCDQModel pSDCCodeSnippetCurDCDQModel = new PSDCCodeSnippetCurDCDQModel();
        pSDCCodeSnippetCurDCDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetCurDCDQModel);
        PSDCCodeSnippetCurDCAppDQModel pSDCCodeSnippetCurDCAppDQModel = new PSDCCodeSnippetCurDCAppDQModel();
        pSDCCodeSnippetCurDCAppDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetCurDCAppDQModel);
        PSDCCodeSnippetCurDCCLDQModel pSDCCodeSnippetCurDCCLDQModel = new PSDCCodeSnippetCurDCCLDQModel();
        pSDCCodeSnippetCurDCCLDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetCurDCCLDQModel);
        PSDCCodeSnippetCurDCDBDQModel pSDCCodeSnippetCurDCDBDQModel = new PSDCCodeSnippetCurDCDBDQModel();
        pSDCCodeSnippetCurDCDBDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetCurDCDBDQModel);
        PSDCCodeSnippetCurDCDEDQModel pSDCCodeSnippetCurDCDEDQModel = new PSDCCodeSnippetCurDCDEDQModel();
        pSDCCodeSnippetCurDCDEDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetCurDCDEDQModel);
        PSDCCodeSnippetCurDCDEActionDQModel pSDCCodeSnippetCurDCDEActionDQModel = new PSDCCodeSnippetCurDCDEActionDQModel();
        pSDCCodeSnippetCurDCDEActionDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetCurDCDEActionDQModel);
        PSDCCodeSnippetCurDCNoneDQModel pSDCCodeSnippetCurDCNoneDQModel = new PSDCCodeSnippetCurDCNoneDQModel();
        pSDCCodeSnippetCurDCNoneDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetCurDCNoneDQModel);
        PSDCCodeSnippetCurDCSysDQModel pSDCCodeSnippetCurDCSysDQModel = new PSDCCodeSnippetCurDCSysDQModel();
        pSDCCodeSnippetCurDCSysDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetCurDCSysDQModel);
        PSDCCodeSnippetCurDCViewDQModel pSDCCodeSnippetCurDCViewDQModel = new PSDCCodeSnippetCurDCViewDQModel();
        pSDCCodeSnippetCurDCViewDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetCurDCViewDQModel);
        PSDCCodeSnippetDefaultDQModel pSDCCodeSnippetDefaultDQModel = new PSDCCodeSnippetDefaultDQModel();
        pSDCCodeSnippetDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCCodeSnippetDefaultDQModel);
    }

    protected void prepareDEActions() throws Exception {
    }

    protected void prepareDELogics() throws Exception {
    }

    @Override
    protected void onPrepareDEUIActions() throws Exception {
        PSDCCodeSnippetPublishUIActionModel pSDCCodeSnippetPublishUIActionModel = new PSDCCodeSnippetPublishUIActionModel();
        pSDCCodeSnippetPublishUIActionModel.init((IDataEntity)this);
        this.registerDEUIAction((IDEUIAction)pSDCCodeSnippetPublishUIActionModel);
    }

    protected void prepareDEWFs() throws Exception {
    }

    protected void prepareDEUniStates() throws Exception {
    }

    protected void prepareDEMainStates() throws Exception {
    }

    protected void prepareDEDataSyncs() throws Exception {
    }

    @Override
    protected void onPreparePDTDEViews() throws Exception {
        this.registerPDTDEView("MDATAVIEW", "e32df2f770c17dcfca5aba9b788f3a0e");
        this.registerPDTDEView("MPICKUPVIEW", "ba9ce62969c3dcbfb94a56330c8342f6");
        this.registerPDTDEView("PICKUPVIEW", "170b5d933b5a543a9f973601b0a7b203");
        this.registerPDTDEView("REDIRECTVIEW", "27e20c082168e6c820615921e7ff0be0");
    }

    protected void prepareDEOPPrivTagMaps() throws Exception {
    }

    protected void prepareDEPrints() throws Exception {
    }

    protected void prepareDEReports() throws Exception {
    }

    protected void prepareDEDataExports() throws Exception {
    }

    protected void prepareDEActionWizards() throws Exception {
    }

    protected void prepareDEActionWizardGroups() throws Exception {
    }

    protected void prepareDEBATables() throws Exception {
    }

    protected void prepareDEUserRoles() throws Exception {
    }

    protected void prepareDEOPPrivRoles() throws Exception {
    }

    protected void onFillFetchQuickSearchConditions(DEDataSetCond dEDataSetCond, String string) throws Exception {
        super.onFillFetchQuickSearchConditions(dEDataSetCond, string);
        DEDataSetCond dEDataSetCond2 = new DEDataSetCond();
        dEDataSetCond2.setCondType("DEFIELD");
        dEDataSetCond2.setCondOp("LIKE");
        dEDataSetCond2.setDEFName("PSDCCODESNIPPETNAME");
        dEDataSetCond2.setCondValue(string);
        dEDataSetCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)dEDataSetCond2);
    }

    @Override
    protected void onPreparePSDEFGroupModels() throws Exception {
        IPSDEFGroupModel iPSDEFGroupModel = this.preparePSDEFGroupModel__DEFAULT();
        if (iPSDEFGroupModel != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel__DEFAULT() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("_DEFAULT");
        pSDEFGroupModel.setName("\u901a\u7528");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f5ba2a0288dc35dfe4b322e3cd016a22");
        pSDEFGroupDetailModel.setName("CODECAT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CODECAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PSCodeSnippetCatCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3b200dda34b865e6a7093985690908d2");
        pSDEFGroupDetailModel.setName("CODETARGET");
        iPSDEFieldModel = this.getDEField("CODETARGET", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PSCodeSnippetTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3860a4c8c4a2e047d981cda81f554e5b");
        pSDEFGroupDetailModel.setName("KEYWORDS");
        iPSDEFieldModel = this.getDEField("KEYWORDS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f14d075a203346302628791c75128038");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e568c631157b583557d0901624bcfdfb");
        pSDEFGroupDetailModel.setName("PSDCCODESNIPPETNAME");
        iPSDEFieldModel = this.getDEField("PSDCCODESNIPPETNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("539f60f93da06f97a9cfad4d068ecf5a");
        pSDEFGroupDetailModel.setName("PSDEVCENTERID");
        iPSDEFieldModel = this.getDEField("PSDEVCENTERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5009009d7b68c29ed00c7b0ef39a4a21");
        pSDEFGroupDetailModel.setName("PSDEVCENTERNAME");
        iPSDEFieldModel = this.getDEField("PSDEVCENTERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c16cc5c1415043d50418743fe9b7ef5c");
        pSDEFGroupDetailModel.setName("TEMPLCODE");
        iPSDEFieldModel = this.getDEField("TEMPLCODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("883d767c6eb29118e4a6f2f5fac8d240");
        pSDEFGroupDetailModel.setName("TEMPLCODE2");
        iPSDEFieldModel = this.getDEField("TEMPLCODE2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

