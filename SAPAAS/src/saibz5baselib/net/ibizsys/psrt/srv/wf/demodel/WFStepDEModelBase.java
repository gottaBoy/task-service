/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.demodel.DEDBConfigModel;
import net.ibizsys.paas.demodel.DEFSearchModeModel;
import net.ibizsys.paas.demodel.DEFieldModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.DataEntityModelBase;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.psrt.srv.PSRuntimeSysModel;
import net.ibizsys.psrt.srv.wf.demodel.wfstep.ac.WFStepDefaultACModel;
import net.ibizsys.psrt.srv.wf.demodel.wfstep.dataquery.WFStepDefaultDQModel;
import net.ibizsys.psrt.srv.wf.demodel.wfstep.dataset.WFStepDefaultDSModel;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.service.WFStepService;

public abstract class WFStepDEModelBase
extends DataEntityModelBase<WFStep> {
    private PSRuntimeSysModel pSRuntimeSysModel;
    private WFStepService wFStepService;

    public WFStepDEModelBase() throws Exception {
        this.setId("aa16d05a90245cec51dc8a2fb7f63fdb");
        this.setName("WFSTEP");
        this.setTableName("T_SRFWFSTEP");
        this.setViewName("v_WFSTEP");
        this.setLogicName("\u5de5\u4f5c\u6d41\u6b65\u9aa4");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel("net.ibizsys.psrt.srv.wf.demodel.WFStepDEModel", this);
            this.getPSRuntimeSysModel().registerDataEntityModel(this);
        }
        this.prepareModels();
    }

    public PSRuntimeSysModel getPSRuntimeSysModel() {
        if (this.pSRuntimeSysModel == null) {
            try {
                this.pSRuntimeSysModel = (PSRuntimeSysModel)SysModelGlobal.getSystem("net.ibizsys.psrt.srv.PSRuntimeSysModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSRuntimeSysModel;
    }

    @Override
    public ISystem getSystem() {
        return this.getPSRuntimeSysModel();
    }

    public WFStepService getRealService() {
        if (this.wFStepService == null) {
            try {
                this.wFStepService = (WFStepService)ServiceGlobal.getService(this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFStepService;
    }

    @Override
    public IService getService() {
        return this.getRealService();
    }

    @Override
    public String getServiceId() {
        return "net.ibizsys.psrt.srv.wf.service.WFStepService";
    }

    @Override
    public WFStep createEntity() {
        return new WFStep();
    }

    @Override
    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel defSearchModeModel;
        DEFieldModel deFieldModel;
        IDEField iDEField = null;
        IDEFSearchMode iDEFSearchMode = null;
        iDEField = this.createDEField("CREATEDATE");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("f2bf8b0e4bb60f168eaa2c7b4acd8c1d");
            deFieldModel.setName("CREATEDATE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5efa\u7acb\u65f6\u95f4");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setPreDefinedType("CREATEDATE");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("CREATEMAN");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("678868365d9681f40a7ace2ee6ffd094");
            deFieldModel.setName("CREATEMAN");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5efa\u7acb\u4eba");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setPreDefinedType("CREATEMAN");
            deFieldModel.setCodeListId("net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("DEADLINE");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("6521a2391aa4f2215b11c0e949b21700");
            deFieldModel.setName("DEADLINE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6b65\u9aa4\u9650\u65f6");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("ENDTIME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("551b9ef6ab3cfc4ab7ceeb5aac90322c");
            deFieldModel.setName("ENDTIME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u7ed3\u675f\u65f6\u95f4");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("FROMWFSTEPID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("0e52fbc4cb1c6c3977255f05f0314a86");
            deFieldModel.setName("FROMWFSTEPID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("FROMWFSTEPID");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("ISFINISH");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("08ef327c0462edc10c21b88b1d2efa4f");
            deFieldModel.setName("ISFINISH");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u662f\u5426\u5b8c\u6210");
            deFieldModel.setDataType("YESNO");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setCodeListId("net.ibizsys.psrt.srv.codelist.YesNoCodeListModel");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("ISINTERACTIVE");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("4430ac77df8a8c5a385bac5c20ec4444");
            deFieldModel.setName("ISINTERACTIVE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("ISINTERACTIVE");
            deFieldModel.setDataType("YESNO");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setCodeListId("net.ibizsys.psrt.srv.codelist.YesNoCodeListModel");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("LASTACTORID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("8ba134ec2f3b081eca8b2094abe561fa");
            deFieldModel.setName("LASTACTORID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("LASTACTORID");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("MEMO");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("9e3a7b43d33a99baca0dd0d7724b22c4");
            deFieldModel.setName("MEMO");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5907\u6ce8");
            deFieldModel.setDataType("LONGTEXT_1000");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("STARTTIME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("1a6bd191cb985c2a13515b4126db4418");
            deFieldModel.setName("STARTTIME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5f00\u59cb\u65f6\u95f4");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("TRACESTEP");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("e59c5d1ce84fdd2577e726cb15fbe21a");
            deFieldModel.setName("TRACESTEP");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6b65\u9aa4\u6b21\u5e8f");
            deFieldModel.setDataType("INT");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("UPDATEDATE");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("208a45ca8d5ecdf2c8aa42ac46dc5b8a");
            deFieldModel.setName("UPDATEDATE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u66f4\u65b0\u65f6\u95f4");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setPreDefinedType("UPDATEDATE");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("UPDATEMAN");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("316130e2a60f8800913aab8a13364ea5");
            deFieldModel.setName("UPDATEMAN");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u66f4\u65b0\u4eba");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setPreDefinedType("UPDATEMAN");
            deFieldModel.setCodeListId("net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFINSTANCEID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("6a0ace1e71a3393d62225ee361362576");
            deFieldModel.setName("WFINSTANCEID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5904\u7406\u6b65\u9aa4\u76f8\u5173\u5b9e\u4f8b");
            deFieldModel.setDataType("PICKUP");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFSTEP_WFINSTANCE_WFINSTANCEID");
            deFieldModel.setLinkDEFName("WFINSTANCEID");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_WFINSTANCEID_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WFINSTANCEID_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFINSTANCENAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("063b4bd91109c872c41d47f92794f4dd");
            deFieldModel.setName("WFINSTANCENAME");
            deFieldModel.setDEFType(3);
            deFieldModel.setLogicName("\u6d41\u7a0b\u5b9e\u4f8b");
            deFieldModel.setDataType("PICKUPTEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFSTEP_WFINSTANCE_WFINSTANCEID");
            deFieldModel.setLinkDEFName("WFINSTANCENAME");
            deFieldModel.setPhisicalDEField(false);
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_WFINSTANCENAME_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WFINSTANCENAME_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_WFINSTANCENAME_LIKE")) == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WFINSTANCENAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFPLOGICNAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("5be00aa6e4d725a0e69d4d19a2e5065e");
            deFieldModel.setName("WFPLOGICNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6b65\u9aa4\u540d\u79f0");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_WFPLOGICNAME_LIKE");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WFPLOGICNAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFPMODEL");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("9dbeea5948907621d28e3d4d3b7fca68");
            deFieldModel.setName("WFPMODEL");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("WFPMODEL");
            deFieldModel.setDataType("LONGTEXT");
            deFieldModel.setStdDataType(21);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFPNAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("745990a353fd01fd25a2a5e29925b8e5");
            deFieldModel.setName("WFPNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("WFPNAME");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFSTEPID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("a28ebeb74760aab292498bd87fa70a31");
            deFieldModel.setName("WFSTEPID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5de5\u4f5c\u6d41\u6b65\u9aa4\u6807\u8bc6");
            deFieldModel.setDataType("GUID");
            deFieldModel.setStdDataType(25);
            deFieldModel.setKeyDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFSTEPLANRESTAG");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("3fc01cb0c6c0ee77784eff5334e0b4e5");
            deFieldModel.setName("WFSTEPLANRESTAG");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6b65\u9aa4\u8bed\u8a00\u8d44\u6e90");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFSTEPNAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("911bf02beb775c68660dc5763bafcd8e");
            deFieldModel.setName("WFSTEPNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5de5\u4f5c\u6d41\u6b65\u9aa4\u540d\u79f0");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setMajorDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_WFSTEPNAME_LIKE");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WFSTEPNAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFVERSION");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("4ab6854a92104ebf5ad4f7375751af4a");
            deFieldModel.setName("WFVERSION");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5de5\u4f5c\u6d41\u7248\u672c");
            deFieldModel.setDataType("INT");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
    }

    @Override
    protected void prepareDEACModes() throws Exception {
        WFStepDefaultACModel _defaultACModel = new WFStepDefaultACModel();
        _defaultACModel.init(this);
        this.registerDEACMode(_defaultACModel);
    }

    @Override
    protected void prepareDEDBConfigs() throws Exception {
        DEDBConfigModel mYSQL5ConfigModel = new DEDBConfigModel();
        mYSQL5ConfigModel.setDBType("MYSQL5");
        mYSQL5ConfigModel.setTableName("t_srfwfstep");
        mYSQL5ConfigModel.setViewName("v_wfstep");
        this.registerDEDBConfig(mYSQL5ConfigModel);
    }

    @Override
    protected void prepareDEDataSets() throws Exception {
        WFStepDefaultDSModel _defaultDSModel = new WFStepDefaultDSModel();
        _defaultDSModel.init(this);
        this.registerDEDataSet(_defaultDSModel);
    }

    @Override
    protected void prepareDEDataQueries() throws Exception {
        WFStepDefaultDQModel _defaultDQModel = new WFStepDefaultDQModel();
        _defaultDQModel.init(this);
        this.registerDEDataQuery(_defaultDQModel);
    }

    @Override
    protected void prepareDEActions() throws Exception {
    }

    @Override
    protected void prepareDELogics() throws Exception {
    }

    @Override
    protected void prepareDEUIActions() throws Exception {
    }

    @Override
    protected void prepareDEWFs() throws Exception {
    }

    @Override
    protected void prepareDEUniStates() throws Exception {
    }

    @Override
    protected void prepareDEMainStates() throws Exception {
    }

    @Override
    protected void prepareDEDataSyncs() throws Exception {
    }

    @Override
    protected void preparePDTDEViews() throws Exception {
        this.registerPDTDEView("MPICKUPVIEW", "abb415ea48364eb93267884f37052bcb");
        this.registerPDTDEView("PICKUPVIEW", "dae47e55e6650348ffede3a5a6afa6dd");
        this.registerPDTDEView("REDIRECTVIEW", "65fb6e6f35368cbbb29047b63cdbdb5c");
    }

    @Override
    protected void prepareDEOPPrivTagMaps() throws Exception {
    }

    @Override
    protected void prepareDEPrints() throws Exception {
    }

    @Override
    protected void prepareDEReports() throws Exception {
    }

    @Override
    protected void prepareDEDataExports() throws Exception {
    }

    @Override
    protected void prepareDEActionWizards() throws Exception {
    }

    @Override
    protected void prepareDEActionWizardGroups() throws Exception {
    }

    @Override
    protected void prepareDEBATables() throws Exception {
    }

    @Override
    protected void prepareDEUserRoles() throws Exception {
    }

    @Override
    protected void prepareDEOPPrivRoles() throws Exception {
    }

    @Override
    protected void onFillFetchQuickSearchConditions(DEDataSetCond groupCondImpl, String strQuickSearch) throws Exception {
        super.onFillFetchQuickSearchConditions(groupCondImpl, strQuickSearch);
        DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
        deDataSetCondImpl.setCondType("DEFIELD");
        deDataSetCondImpl.setCondOp("LIKE");
        deDataSetCondImpl.setDEFName("WFSTEPNAME");
        deDataSetCondImpl.setCondValue(strQuickSearch);
        groupCondImpl.addChildDEDataQueryCond(deDataSetCondImpl);
    }
}

