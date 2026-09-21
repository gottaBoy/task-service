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
import net.ibizsys.psrt.srv.wf.demodel.wfstepdata.ac.WFStepDataDefaultACModel;
import net.ibizsys.psrt.srv.wf.demodel.wfstepdata.dataquery.WFStepDataDefaultDQModel;
import net.ibizsys.psrt.srv.wf.demodel.wfstepdata.dataquery.WFStepDataMyHistDQModel;
import net.ibizsys.psrt.srv.wf.demodel.wfstepdata.dataset.WFStepDataDefaultDSModel;
import net.ibizsys.psrt.srv.wf.demodel.wfstepdata.dataset.WFStepDataMyHistDSModel;
import net.ibizsys.psrt.srv.wf.demodel.wfstepdata.uiaction.WFStepDataRollbackUIActionModel;
import net.ibizsys.psrt.srv.wf.entity.WFStepData;
import net.ibizsys.psrt.srv.wf.service.WFStepDataService;

public abstract class WFStepDataDEModelBase
extends DataEntityModelBase<WFStepData> {
    private PSRuntimeSysModel pSRuntimeSysModel;
    private WFStepDataService wFStepDataService;

    public WFStepDataDEModelBase() throws Exception {
        this.setId("095ff4eab83529a1b8f093180a7ef3fa");
        this.setName("WFSTEPDATA");
        this.setTableName("T_SRFWFSTEPDATA");
        this.setViewName("v_WFSTEPDATA");
        this.setLogicName("\u5de5\u4f5c\u6d41\u6b65\u9aa4\u6570\u636e");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel("net.ibizsys.psrt.srv.wf.demodel.WFStepDataDEModel", this);
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

    public WFStepDataService getRealService() {
        if (this.wFStepDataService == null) {
            try {
                this.wFStepDataService = (WFStepDataService)ServiceGlobal.getService(this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFStepDataService;
    }

    @Override
    public IService getService() {
        return this.getRealService();
    }

    @Override
    public String getServiceId() {
        return "net.ibizsys.psrt.srv.wf.service.WFStepDataService";
    }

    @Override
    public WFStepData createEntity() {
        return new WFStepData();
    }

    @Override
    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel defSearchModeModel;
        DEFieldModel deFieldModel;
        IDEField iDEField = null;
        IDEFSearchMode iDEFSearchMode = null;
        iDEField = this.createDEField("ACTIONTIME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("3a3b017025cf1d517061eba1ece1fd3b");
            deFieldModel.setName("ACTIONTIME");
            deFieldModel.setDEFType(2);
            deFieldModel.setLogicName("\u64cd\u4f5c\u65f6\u95f4");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setPhisicalDEField(false);
            deFieldModel.setFormulaDEField(true);
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("ACTORID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("82768302c73254df9370bda52e6ee18d");
            deFieldModel.setName("ACTORID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u64cd\u4f5c\u4eba");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("ACTORNAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("369eb5547a2744784c59ecafd04cacf9");
            deFieldModel.setName("ACTORNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u64cd\u4f5c\u4eba\u540d\u79f0");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("ACTORNAME2");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("1b3e1488b47c278066cf55772fad3e67");
            deFieldModel.setName("ACTORNAME2");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u4ee3\u529e\u4eba\u540d\u79f0");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("CONNECTIONNAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("eedd9b2f47607734a1dabeef04e45fdc");
            deFieldModel.setName("CONNECTIONNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u8fde\u63a5\u540d\u79f0");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("CREATEDATE");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("a1d71d9a971291cc7682cffa7c9be641");
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
            deFieldModel.setId("3d5369f4e73d58c063599868753ebeb9");
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
        iDEField = this.createDEField("MEMO");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("887e3734f04aec8a741271aff79a3755");
            deFieldModel.setName("MEMO");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5185\u5bb9");
            deFieldModel.setDataType("LONGTEXT");
            deFieldModel.setStdDataType(21);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("NEXTTO");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("6f44bb6d7e445379f81a3f5117dea3b1");
            deFieldModel.setName("NEXTTO");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u4e0b\u4e00\u6b65");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("ORIGINALWFUSERID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("32509c1e050b78ad10ed8e0a6cc06236");
            deFieldModel.setName("ORIGINALWFUSERID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6e90\u6d41\u7a0b\u7528\u6237");
            deFieldModel.setDataType("PICKUP");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFSTEPDATA_WFUSER_ORIGINALWFUSERID");
            deFieldModel.setLinkDEFName("WFUSERID");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_ORIGINALWFUSERID_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_ORIGINALWFUSERID_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("ORIGINALWFUSERNAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("0ad92a6cfd860be82baa8f866c66ffed");
            deFieldModel.setName("ORIGINALWFUSERNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6e90\u6d41\u7a0b\u7528\u6237");
            deFieldModel.setDataType("PICKUPTEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFSTEPDATA_WFUSER_ORIGINALWFUSERID");
            deFieldModel.setLinkDEFName("WFUSERNAME");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_ORIGINALWFUSERNAME_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_ORIGINALWFUSERNAME_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_ORIGINALWFUSERNAME_LIKE")) == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_ORIGINALWFUSERNAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("SDPARAM");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("263233aad4b48326ab5dda0794fb2aed");
            deFieldModel.setName("SDPARAM");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("SDPARAM");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("SDPARAM2");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("1533f7d370f5572c67e388f9537de624");
            deFieldModel.setName("SDPARAM2");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u4ee3\u529e\u4eba");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
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
            deFieldModel.setId("9025721063d322f91c4c068ed6366e61");
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
            deFieldModel.setId("e927f5b348cef87eb8dfbf0405a1bf21");
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
        iDEField = this.createDEField("USERDATA");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("f83218fb2f86645970062f9baf1255ff");
            deFieldModel.setName("USERDATA");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u7528\u6237\u6570\u636e\u6807\u8bc6");
            deFieldModel.setDataType("PICKUPDATA");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFSTEPDATA_WFINSTANCE_WFINSTANCEID");
            deFieldModel.setLinkDEFName("USERDATA");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("USERDATADESC");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("bf95cab1e5ce95fe58f26dbe5a3da0cb");
            deFieldModel.setName("USERDATADESC");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u7528\u6237\u6570\u636e");
            deFieldModel.setDataType("PICKUPDATA");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFSTEPDATA_WFINSTANCE_WFINSTANCEID");
            deFieldModel.setLinkDEFName("USERDATAINFO");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFACTIONLANRESTAG");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("e17287d34c2d414794f9b89e71b9aa3b");
            deFieldModel.setName("WFACTIONLANRESTAG");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u64cd\u4f5c\u7c7b\u578b\u8bed\u8a00\u8d44\u6e90");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFINSTANCEID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("a35543ee6976042341072cbd2f6b793c");
            deFieldModel.setName("WFINSTANCEID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("WFInstanceId");
            deFieldModel.setDataType("PICKUP");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFSTEPDATA_WFINSTANCE_WFINSTANCEID");
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
            deFieldModel.setId("776d1d8fca7332ebfc2f35f056cf5332");
            deFieldModel.setName("WFINSTANCENAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6d41\u7a0b\u5b9e\u4f8b");
            deFieldModel.setDataType("PICKUPTEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFSTEPDATA_WFINSTANCE_WFINSTANCEID");
            deFieldModel.setLinkDEFName("WFINSTANCENAME");
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
            deFieldModel.setId("6f5a7000789cd051fd4279a3a6f83f57");
            deFieldModel.setName("WFPLOGICNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6267\u884c\u6b65\u9aa4");
            deFieldModel.setDataType("PICKUPDATA");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFSTEPDATA_WFSTEP_WFSTEPID");
            deFieldModel.setLinkDEFName("WFPLOGICNAME");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFSTEPDATAID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("0527f25d7ac992c5b5343b2b2af9e40b");
            deFieldModel.setName("WFSTEPDATAID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5de5\u4f5c\u6d41\u6b65\u9aa4\u6570\u636e\u6807\u8bc6");
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
        iDEField = this.createDEField("WFSTEPDATANAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("ebdecdcc5ec42bd656836577cbaa6536");
            deFieldModel.setName("WFSTEPDATANAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6d41\u7a0b\u64cd\u4f5c");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setMajorDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_WFSTEPDATANAME_LIKE");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WFSTEPDATANAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFSTEPID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("93a87877f382e013a8268e0772604bf6");
            deFieldModel.setName("WFSTEPID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6b65\u9aa4\u6570\u636e_\u76f8\u5173\u6b65\u9aa4");
            deFieldModel.setDataType("PICKUP");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFSTEPDATA_WFSTEP_WFSTEPID");
            deFieldModel.setLinkDEFName("WFSTEPID");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_WFSTEPID_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WFSTEPID_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFSTEPLANRESTAG");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("2844d3ebdf1a560afff26469881a7e6c");
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
            deFieldModel.setId("3def7078358432e1c972d9fbf8dd1d3b");
            deFieldModel.setName("WFSTEPNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6b65\u9aa4\u540d\u79f0");
            deFieldModel.setDataType("PICKUPTEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFSTEPDATA_WFSTEP_WFSTEPID");
            deFieldModel.setLinkDEFName("WFSTEPNAME");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_WFSTEPNAME_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WFSTEPNAME_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_WFSTEPNAME_LIKE")) == null) {
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
    }

    @Override
    protected void prepareDEACModes() throws Exception {
        WFStepDataDefaultACModel _defaultACModel = new WFStepDataDefaultACModel();
        _defaultACModel.init(this);
        this.registerDEACMode(_defaultACModel);
    }

    @Override
    protected void prepareDEDBConfigs() throws Exception {
        DEDBConfigModel mYSQL5ConfigModel = new DEDBConfigModel();
        mYSQL5ConfigModel.setDBType("MYSQL5");
        mYSQL5ConfigModel.setTableName("t_srfwfstepdata");
        mYSQL5ConfigModel.setViewName("v_wfstepdata");
        this.registerDEDBConfig(mYSQL5ConfigModel);
    }

    @Override
    protected void prepareDEDataSets() throws Exception {
        WFStepDataDefaultDSModel _defaultDSModel = new WFStepDataDefaultDSModel();
        _defaultDSModel.init(this);
        this.registerDEDataSet(_defaultDSModel);
        WFStepDataMyHistDSModel myHistDSModel = new WFStepDataMyHistDSModel();
        myHistDSModel.init(this);
        this.registerDEDataSet(myHistDSModel);
    }

    @Override
    protected void prepareDEDataQueries() throws Exception {
        WFStepDataDefaultDQModel _defaultDQModel = new WFStepDataDefaultDQModel();
        _defaultDQModel.init(this);
        this.registerDEDataQuery(_defaultDQModel);
        WFStepDataMyHistDQModel myHistDQModel = new WFStepDataMyHistDQModel();
        myHistDQModel.init(this);
        this.registerDEDataQuery(myHistDQModel);
    }

    @Override
    protected void prepareDEActions() throws Exception {
    }

    @Override
    protected void prepareDELogics() throws Exception {
    }

    @Override
    protected void prepareDEUIActions() throws Exception {
        WFStepDataRollbackUIActionModel rollbackUIActionModel = new WFStepDataRollbackUIActionModel();
        rollbackUIActionModel.init(this);
        this.registerDEUIAction(rollbackUIActionModel);
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
        this.registerPDTDEView("MPICKUPVIEW", "bbcf1e0f2d46be639ced7aab464b51b2");
        this.registerPDTDEView("PICKUPVIEW", "57a0f2c552b497cb6a8a598530fa5e6c");
        this.registerPDTDEView("REDIRECTVIEW", "691e71c01b2f6ad1b71494dab62f6be0");
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
        deDataSetCondImpl.setDEFName("WFSTEPDATANAME");
        deDataSetCondImpl.setCondValue(strQuickSearch);
        groupCondImpl.addChildDEDataQueryCond(deDataSetCondImpl);
    }
}

