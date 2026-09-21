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
 *  net.ibizsys.paas.core.IDELogic
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.demodel.DEFSearchModeModel
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.SysModelGlobal
 */
package net.ibizsys.pscore.srv.dedesign.demodel;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.IDEACMode;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDELogic;
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
import net.ibizsys.pscore.srv.core.PSDEFGroupModel;
import net.ibizsys.pscore.srv.core.PSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDataEntityModelBase;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.ac.PSDEUAWizardCodeNameACModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.ac.PSDEUAWizardCurSFExceptionACModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.ac.PSDEUAWizardDefault2ACModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.ac.PSDEUAWizardDefaultACModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataquery.PSDEUAWizardDefaultDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEDEFName2DSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEDEFNameDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEDQCondCondValueDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEFCodeNameDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEFDCondValueDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDELNParamOrderDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDELogicDstParamKeyDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDELogicSrcParamKeyDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEMSState2ValueDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEMSState3ValueDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEMSStateValueDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEViewRVModeDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDEViewRVParamDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurDstDELNParamKeyDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurJITUserDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurModelOrderDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurSFExceptionDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardCurSrcDELNParamKeyDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardDefaultDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.dataset.PSDEUAWizardValueFmtDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.logic.PSDEUAWizardGetBatAddAppViewDraftLogicModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAWizard;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAWizardService;

public abstract class PSDEUAWizardDEModelBase
extends PSDataEntityModelBase<PSDEUAWizard> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDEUAWizardService pSDEUAWizardService;

    public PSDEUAWizardDEModelBase() throws Exception {
        this.setId("b801a9bf47a34a848ff405c8dcfc0bcf");
        this.setName("PSUAWIZARD");
        this.setCodeName("PSDEUAWizard");
        this.setTableName("T_SRFPSUAWIZARD");
        this.setViewName("v_PSUAWIZARD");
        this.setLogicName("\u5b9e\u4f53\u754c\u9762\u64cd\u4f5c\u5411\u5bfc");
        this.setDSLink("DEFAULT");
        this.setEnableMultiDS(true);
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setUserTag("UWMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEUAWizardDEModel", (IDataEntityModel)this);
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

    public PSDEUAWizardService getRealService() {
        if (this.pSDEUAWizardService == null) {
            try {
                this.pSDEUAWizardService = (PSDEUAWizardService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUAWizardService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEUAWizardService";
    }

    public PSDEUAWizard createEntity() {
        return new PSDEUAWizard();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("ACTIONDATA");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7b7d11589f5f47b792b6dcebda4b01cc");
            pSDEFieldModel.setName("ACTIONDATA");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u64cd\u4f5c\u6570\u636e");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ActionData");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ACTIONDATA2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c72c3acdf0cd5254c619ce3e23579cc5");
            pSDEFieldModel.setName("ACTIONDATA2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u64cd\u4f5c\u6570\u636e2");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ActionData2");
            pSDEFieldModel.setLength(2000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("107d037bca962f4a821655b886078b49");
            pSDEFieldModel.setName("CREATEDATE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5efa\u7acb\u65f6\u95f4");
            pSDEFieldModel.setDataType("DATETIME");
            pSDEFieldModel.setStdDataType(5);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPreDefinedType("CREATEDATE");
            pSDEFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            pSDEFieldModel.setCodeName("CreateDate");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEMAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e10f01eaa872b1296c8ac75552d7098f");
            pSDEFieldModel.setName("CREATEMAN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5efa\u7acb\u4eba");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPreDefinedType("CREATEMAN");
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.SysOperatorCodeListModel");
            pSDEFieldModel.setCodeName("CreateMan");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPMODULEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("608ea2f2e2398a2feb0e047675de356e");
            pSDEFieldModel.setName("PSAPPMODULEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6a21\u5757");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSUAWIZARD_PSAPPMODULE_PSAPPMODULEID");
            pSDEFieldModel.setLinkDEFName("PSAPPMODULEID");
            pSDEFieldModel.setCodeName("PSAppModuleId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPMODULEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPMODULEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPMODULENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("af1cbe7796f8c404cc453e274d9812d5");
            pSDEFieldModel.setName("PSAPPMODULENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6a21\u5757");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSUAWIZARD_PSAPPMODULE_PSAPPMODULEID");
            pSDEFieldModel.setLinkDEFName("PSAPPMODULENAME");
            pSDEFieldModel.setCodeName("PSAppModuleName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPMODULENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPMODULENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPMODULENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPMODULENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDSCONSOLEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8b746863022f81490fe0710767c151bd");
            pSDEFieldModel.setName("PSDSCONSOLEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63a7\u5236\u53f0\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSDSConsoleId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSAPPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("830bd6d1bc49be5ce167791797adc940");
            pSDEFieldModel.setName("PSSYSAPPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u5e94\u7528");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSUAWIZARD_PSSYSAPP_PSSYSAPPID");
            pSDEFieldModel.setLinkDEFName("PSSYSAPPID");
            pSDEFieldModel.setCodeName("PSSysAppId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSAPPID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSAPPID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSAPPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3e4eb67b6bcaa0d2d5f13b92d154e22f");
            pSDEFieldModel.setName("PSSYSAPPNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u5e94\u7528");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSUAWIZARD_PSSYSAPP_PSSYSAPPID");
            pSDEFieldModel.setLinkDEFName("PSSYSAPPNAME");
            pSDEFieldModel.setCodeName("PSSysAppName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSAPPNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSAPPNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSAPPNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSAPPNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d9c1078f0917ba0472749eb42f830044");
            pSDEFieldModel.setName("PSSYSTEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSUAWIZARD_PSSYSTEM_PSSYSTEMID");
            pSDEFieldModel.setLinkDEFName("PSSYSTEMID");
            pSDEFieldModel.setCodeName("PSSystemId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTEMID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTEMID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("84fc974549d50248a1e257f88b97351e");
            pSDEFieldModel.setName("PSSYSTEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSUAWIZARD_PSSYSTEM_PSSYSTEMID");
            pSDEFieldModel.setLinkDEFName("PSSYSTEMNAME");
            pSDEFieldModel.setCodeName("PSSystemName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTEMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTEMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTEMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTEMNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSUAWIZARDID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9e82b773da25ed09f41f2df10a4d48bd");
            pSDEFieldModel.setName("PSUAWIZARDID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u754c\u9762\u64cd\u4f5c\u5411\u5bfc\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSUAWizardId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSUAWIZARDNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("53b0764e3808a2ee753724432134b137");
            pSDEFieldModel.setName("PSUAWIZARDNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u754c\u9762\u64cd\u4f5c\u5411\u5bfc\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSUAWizardName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSUAWIZARDNAME_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSUAWIZARDNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3294e04dc425c5bb5506fc8f6893d6d7");
            pSDEFieldModel.setName("UPDATEDATE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u65b0\u65f6\u95f4");
            pSDEFieldModel.setDataType("DATETIME");
            pSDEFieldModel.setStdDataType(5);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPreDefinedType("UPDATEDATE");
            pSDEFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            pSDEFieldModel.setCodeName("UpdateDate");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEMAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2b22ba7fe81c207b5648e2f729eb40ff");
            pSDEFieldModel.setName("UPDATEMAN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u65b0\u4eba");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPreDefinedType("UPDATEMAN");
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.SysOperatorCodeListModel");
            pSDEFieldModel.setCodeName("UpdateMan");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIZARDMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5254f493d0966a89321be8815cf59fa8");
            pSDEFieldModel.setName("WIZARDMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5411\u5bfc\u6a21\u5f0f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("WizardMode");
            pSDEFieldModel.setLength(40);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIZARDPARAM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("173aaae7f6bcbf9688d03fede5552c6d");
            pSDEFieldModel.setName("WIZARDPARAM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5411\u5bfc\u53c2\u6570");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("WizardParam");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIZARDPARAM2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("42f4e1645a95bbbbfb60d2993d31a8cd");
            pSDEFieldModel.setName("WIZARDPARAM2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5411\u5bfc\u53c2\u65702");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("WizardParam2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIZARDPARAM3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("445229cc110ebaaf6d971ff9e03a5a2c");
            pSDEFieldModel.setName("WIZARDPARAM3");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5411\u5bfc\u53c2\u65703");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("WizardParam3");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIZARDPARAM4");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7e873170ff18b7fa2ee52dd7b8eaba4b");
            pSDEFieldModel.setName("WIZARDPARAM4");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5411\u5bfc\u53c2\u65704");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("WizardParam4");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIZARDPARAM5");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("616e5392e9959d9f311e496f8025de5e");
            pSDEFieldModel.setName("WIZARDPARAM5");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5411\u5bfc\u53c2\u65705");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("WizardParam5");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIZARDPARAM6");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9c0f0f72ba0939219412b0422ffc5579");
            pSDEFieldModel.setName("WIZARDPARAM6");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5411\u5bfc\u53c2\u65706");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("WizardParam6");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSDEUAWizardCodeNameACModel pSDEUAWizardCodeNameACModel = new PSDEUAWizardCodeNameACModel();
        pSDEUAWizardCodeNameACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDEUAWizardCodeNameACModel);
        PSDEUAWizardCurSFExceptionACModel pSDEUAWizardCurSFExceptionACModel = new PSDEUAWizardCurSFExceptionACModel();
        pSDEUAWizardCurSFExceptionACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDEUAWizardCurSFExceptionACModel);
        PSDEUAWizardDefaultACModel pSDEUAWizardDefaultACModel = new PSDEUAWizardDefaultACModel();
        pSDEUAWizardDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDEUAWizardDefaultACModel);
        PSDEUAWizardDefault2ACModel pSDEUAWizardDefault2ACModel = new PSDEUAWizardDefault2ACModel();
        pSDEUAWizardDefault2ACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDEUAWizardDefault2ACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDEUAWizardCurDEDEFNameDSModel pSDEUAWizardCurDEDEFNameDSModel = new PSDEUAWizardCurDEDEFNameDSModel();
        pSDEUAWizardCurDEDEFNameDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurDEDEFNameDSModel);
        PSDEUAWizardCurDEDEFName2DSModel pSDEUAWizardCurDEDEFName2DSModel = new PSDEUAWizardCurDEDEFName2DSModel();
        pSDEUAWizardCurDEDEFName2DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurDEDEFName2DSModel);
        PSDEUAWizardCurDEDQCondCondValueDSModel pSDEUAWizardCurDEDQCondCondValueDSModel = new PSDEUAWizardCurDEDQCondCondValueDSModel();
        pSDEUAWizardCurDEDQCondCondValueDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurDEDQCondCondValueDSModel);
        PSDEUAWizardCurDEFCodeNameDSModel pSDEUAWizardCurDEFCodeNameDSModel = new PSDEUAWizardCurDEFCodeNameDSModel();
        pSDEUAWizardCurDEFCodeNameDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurDEFCodeNameDSModel);
        PSDEUAWizardCurDEFDCondValueDSModel pSDEUAWizardCurDEFDCondValueDSModel = new PSDEUAWizardCurDEFDCondValueDSModel();
        pSDEUAWizardCurDEFDCondValueDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurDEFDCondValueDSModel);
        PSDEUAWizardCurDELNParamOrderDSModel pSDEUAWizardCurDELNParamOrderDSModel = new PSDEUAWizardCurDELNParamOrderDSModel();
        pSDEUAWizardCurDELNParamOrderDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurDELNParamOrderDSModel);
        PSDEUAWizardCurDELogicDstParamKeyDSModel pSDEUAWizardCurDELogicDstParamKeyDSModel = new PSDEUAWizardCurDELogicDstParamKeyDSModel();
        pSDEUAWizardCurDELogicDstParamKeyDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurDELogicDstParamKeyDSModel);
        PSDEUAWizardCurDELogicSrcParamKeyDSModel pSDEUAWizardCurDELogicSrcParamKeyDSModel = new PSDEUAWizardCurDELogicSrcParamKeyDSModel();
        pSDEUAWizardCurDELogicSrcParamKeyDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurDELogicSrcParamKeyDSModel);
        PSDEUAWizardCurDEMSState2ValueDSModel pSDEUAWizardCurDEMSState2ValueDSModel = new PSDEUAWizardCurDEMSState2ValueDSModel();
        pSDEUAWizardCurDEMSState2ValueDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurDEMSState2ValueDSModel);
        PSDEUAWizardCurDEMSState3ValueDSModel pSDEUAWizardCurDEMSState3ValueDSModel = new PSDEUAWizardCurDEMSState3ValueDSModel();
        pSDEUAWizardCurDEMSState3ValueDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurDEMSState3ValueDSModel);
        PSDEUAWizardCurDEMSStateValueDSModel pSDEUAWizardCurDEMSStateValueDSModel = new PSDEUAWizardCurDEMSStateValueDSModel();
        pSDEUAWizardCurDEMSStateValueDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurDEMSStateValueDSModel);
        PSDEUAWizardCurDEViewRVModeDSModel pSDEUAWizardCurDEViewRVModeDSModel = new PSDEUAWizardCurDEViewRVModeDSModel();
        pSDEUAWizardCurDEViewRVModeDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurDEViewRVModeDSModel);
        PSDEUAWizardCurDEViewRVParamDSModel pSDEUAWizardCurDEViewRVParamDSModel = new PSDEUAWizardCurDEViewRVParamDSModel();
        pSDEUAWizardCurDEViewRVParamDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurDEViewRVParamDSModel);
        PSDEUAWizardCurDstDELNParamKeyDSModel pSDEUAWizardCurDstDELNParamKeyDSModel = new PSDEUAWizardCurDstDELNParamKeyDSModel();
        pSDEUAWizardCurDstDELNParamKeyDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurDstDELNParamKeyDSModel);
        PSDEUAWizardCurJITUserDSModel pSDEUAWizardCurJITUserDSModel = new PSDEUAWizardCurJITUserDSModel();
        pSDEUAWizardCurJITUserDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurJITUserDSModel);
        PSDEUAWizardCurModelOrderDSModel pSDEUAWizardCurModelOrderDSModel = new PSDEUAWizardCurModelOrderDSModel();
        pSDEUAWizardCurModelOrderDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurModelOrderDSModel);
        PSDEUAWizardCurSFExceptionDSModel pSDEUAWizardCurSFExceptionDSModel = new PSDEUAWizardCurSFExceptionDSModel();
        pSDEUAWizardCurSFExceptionDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurSFExceptionDSModel);
        PSDEUAWizardCurSrcDELNParamKeyDSModel pSDEUAWizardCurSrcDELNParamKeyDSModel = new PSDEUAWizardCurSrcDELNParamKeyDSModel();
        pSDEUAWizardCurSrcDELNParamKeyDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardCurSrcDELNParamKeyDSModel);
        PSDEUAWizardDefaultDSModel pSDEUAWizardDefaultDSModel = new PSDEUAWizardDefaultDSModel();
        pSDEUAWizardDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardDefaultDSModel);
        PSDEUAWizardValueFmtDSModel pSDEUAWizardValueFmtDSModel = new PSDEUAWizardValueFmtDSModel();
        pSDEUAWizardValueFmtDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEUAWizardValueFmtDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDEUAWizardDefaultDQModel pSDEUAWizardDefaultDQModel = new PSDEUAWizardDefaultDQModel();
        pSDEUAWizardDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEUAWizardDefaultDQModel);
    }

    protected void prepareDEActions() throws Exception {
    }

    protected void prepareDELogics() throws Exception {
        PSDEUAWizardGetBatAddAppViewDraftLogicModel pSDEUAWizardGetBatAddAppViewDraftLogicModel = new PSDEUAWizardGetBatAddAppViewDraftLogicModel();
        pSDEUAWizardGetBatAddAppViewDraftLogicModel.init((IDataEntity)this);
        this.registerDELogic((IDELogic)pSDEUAWizardGetBatAddAppViewDraftLogicModel);
    }

    @Override
    protected void onPrepareDEUIActions() throws Exception {
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
        this.registerPDTDEView("EDITVIEW", "6d9bad4675fd537b745f181b18669fd3");
        this.registerPDTDEView("MPICKUPVIEW", "8e4e5c9baf74417bc7bb1913314fb1b4");
        this.registerPDTDEView("PICKUPVIEW", "c2e672da4140d12a27463997c0a831ad");
        this.registerPDTDEView("REDIRECTVIEW", "e00b613767b7236b919e6123e80b9a6d");
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
        dEDataSetCond2.setDEFName("PSUAWIZARDNAME");
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
        return pSDEFGroupModel;
    }
}

