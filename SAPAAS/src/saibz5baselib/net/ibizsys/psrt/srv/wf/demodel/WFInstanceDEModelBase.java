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
import net.ibizsys.psrt.srv.wf.demodel.wfinstance.ac.WFInstanceDefaultACModel;
import net.ibizsys.psrt.srv.wf.demodel.wfinstance.dataquery.WFInstanceDefaultDQModel;
import net.ibizsys.psrt.srv.wf.demodel.wfinstance.dataset.WFInstanceDefaultDSModel;
import net.ibizsys.psrt.srv.wf.demodel.wfinstance.uiaction.WFInstanceRestartUIActionModel;
import net.ibizsys.psrt.srv.wf.demodel.wfinstance.uiaction.WFInstanceUserCancelUIActionModel;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;

public abstract class WFInstanceDEModelBase
extends DataEntityModelBase<WFInstance> {
    private PSRuntimeSysModel pSRuntimeSysModel;
    private WFInstanceService wFInstanceService;

    public WFInstanceDEModelBase() throws Exception {
        this.setId("0211d06b901d7948d2394149b7d0d96e");
        this.setName("WFINSTANCE");
        this.setTableName("T_SRFWFINSTANCE");
        this.setViewName("v_WFINSTANCE");
        this.setLogicName("\u5de5\u4f5c\u6d41\u5b9e\u4f8b");
        this.setLogicValid(true);
        this.setValidValue("1");
        this.setInvalidValue("0");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel("net.ibizsys.psrt.srv.wf.demodel.WFInstanceDEModel", this);
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

    public WFInstanceService getRealService() {
        if (this.wFInstanceService == null) {
            try {
                this.wFInstanceService = (WFInstanceService)ServiceGlobal.getService(this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFInstanceService;
    }

    @Override
    public IService getService() {
        return this.getRealService();
    }

    @Override
    public String getServiceId() {
        return "net.ibizsys.psrt.srv.wf.service.WFInstanceService";
    }

    @Override
    public WFInstance createEntity() {
        return new WFInstance();
    }

    @Override
    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel defSearchModeModel;
        DEFieldModel deFieldModel;
        IDEField iDEField = null;
        IDEFSearchMode iDEFSearchMode = null;
        iDEField = this.createDEField("ACTIVESTEPID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("4efac673cfd77067adaa0144f9e00e26");
            deFieldModel.setName("ACTIVESTEPID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("ACTIVESTEPID");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("ACTIVESTEPNAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("d4c5dc5c4015ae99f10593fbef71cb6e");
            deFieldModel.setName("ACTIVESTEPNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5f53\u524d\u6b65\u9aa4\u540d\u79f0");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("CANCELREASON");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("14133fb4b1fad696733c694b5247550f");
            deFieldModel.setName("CANCELREASON");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u53d6\u6d88\u539f\u56e0");
            deFieldModel.setDataType("LONGTEXT");
            deFieldModel.setStdDataType(21);
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
            deFieldModel.setId("d98479d13aa8ccbc0caff44afdfbea60");
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
            deFieldModel.setId("66d75684f2987dfc53dcd7127ce50bbb");
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
        iDEField = this.createDEField("ENABLE");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("c4e335f2c1595f8fcc995614101b9371");
            deFieldModel.setName("ENABLE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u903b\u8f91\u6709\u6548\u6807\u5fd7");
            deFieldModel.setDataType("YESNO");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setPreDefinedType("LOGICVALID");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("ENDTIME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("bd5822880757597166aca02123b3a371");
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
        iDEField = this.createDEField("ERRORINFO");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("874d9872d4641ab67ff08101caed0c0b");
            deFieldModel.setName("ERRORINFO");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u9519\u8bef\u4fe1\u606f");
            deFieldModel.setDataType("LONGTEXT");
            deFieldModel.setStdDataType(21);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("IMPORTANCEFLAG");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("915a07468a92b09e0452462e982ceae8");
            deFieldModel.setName("IMPORTANCEFLAG");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u91cd\u8981\u7a0b\u5ea6");
            deFieldModel.setDataType("INT");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("ISCANCEL");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("15213a2881910db35d41142f5b35de5e");
            deFieldModel.setName("ISCANCEL");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u662f\u5426\u53d6\u6d88");
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
        iDEField = this.createDEField("ISCLOSE");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("0b18d43b49a8466338960955b5a19d2e");
            deFieldModel.setName("ISCLOSE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u662f\u5426\u5173\u95ed");
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
        iDEField = this.createDEField("ISERROR");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("e45f82e174b432fa16bd46a1cfd74001");
            deFieldModel.setName("ISERROR");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u662f\u5426\u9519\u8bef");
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
        iDEField = this.createDEField("ISFINISH");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("bf8fc221a2d01067a309f8a23c8a4138");
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
        iDEField = this.createDEField("LASTACTION");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("c2a5090898ecec500227e485cbecaf14");
            deFieldModel.setName("LASTACTION");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u4e0a\u4e00\u4e2a\u64cd\u4f5c");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("LASTACTORID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("d500a0535816ee3b84d389616712c4e2");
            deFieldModel.setName("LASTACTORID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u4e0a\u4e00\u4e2a\u64cd\u4f5c\u8005");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("LASTWFSTEPID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("9a2181eafdeea78e02bc699dce56d4aa");
            deFieldModel.setName("LASTWFSTEPID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u4e0a\u4e00\u4e2a\u64cd\u4f5c\u6b65\u9aa4");
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
            deFieldModel.setId("bfc1b584167420b6aee1ea28da9c69a7");
            deFieldModel.setName("MEMO");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5de5\u4f5c\u6d41\u8bf4\u660e");
            deFieldModel.setDataType("LONGTEXT_1000");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("ORGID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("a808b3cfa19d27c2a980c849a77f6ec6");
            deFieldModel.setName("ORGID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u7ec4\u7ec7\u6807\u8bc6");
            deFieldModel.setDataType("PICKUP");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFINSTANCE_ORG_ORGID");
            deFieldModel.setLinkDEFName("ORGID");
            deFieldModel.setPreDefinedType("ORGID");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_ORGID_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_ORGID_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("ORGNAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("b7a3ffe645c5daeb63a15a77063c0f2a");
            deFieldModel.setName("ORGNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u7ec4\u7ec7\u540d\u79f0");
            deFieldModel.setDataType("PICKUPTEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFINSTANCE_ORG_ORGID");
            deFieldModel.setLinkDEFName("ORGNAME");
            deFieldModel.setPreDefinedType("ORGNAME");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_ORGNAME_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_ORGNAME_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_ORGNAME_LIKE")) == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_ORGNAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("OWNER");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("7366077136d868586867b1246528ca1f");
            deFieldModel.setName("OWNER");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("OWNER");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("PARALLELINST");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("8f199a43c0d6fb3e907e8e4bf678d8f7");
            deFieldModel.setName("PARALLELINST");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5e76\u884c\u5b9e\u4f8b");
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
        iDEField = this.createDEField("PSTEPID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("f740ad8cfe7cc7095b5c0ffaa0ff5a8d");
            deFieldModel.setName("PSTEPID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u7236\u6b65\u9aa4\u7f16\u53f7");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("PWFINSTANCEID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("bf3f3791cb2b5bfa5ba45683f88f6eab");
            deFieldModel.setName("PWFINSTANCEID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u7236\u5b9e\u4f8b");
            deFieldModel.setDataType("PICKUP");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFINSTANCE_WFINSTANCE_PWFINSTANCEID");
            deFieldModel.setLinkDEFName("WFINSTANCEID");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_PWFINSTANCEID_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_PWFINSTANCEID_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("PWFINSTANCENAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("3c1d5c9f4ee8bce85a492fdd10e581fa");
            deFieldModel.setName("PWFINSTANCENAME");
            deFieldModel.setDEFType(3);
            deFieldModel.setLogicName("\u7236\u5b9e\u4f8b");
            deFieldModel.setDataType("PICKUPTEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFINSTANCE_WFINSTANCE_PWFINSTANCEID");
            deFieldModel.setLinkDEFName("WFINSTANCENAME");
            deFieldModel.setPhisicalDEField(false);
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_PWFINSTANCENAME_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_PWFINSTANCENAME_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_PWFINSTANCENAME_LIKE")) == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_PWFINSTANCENAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("RESULT");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("ac067355805264091dac8eb4d0f9a2e8");
            deFieldModel.setName("RESULT");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u7ed3\u679c\u4fe1\u606f");
            deFieldModel.setDataType("TEXT");
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
            deFieldModel.setId("19408ce904b4299a6dc226ca454e95a0");
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
        iDEField = this.createDEField("SUSPENDFLAG");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("897176366605317938c4cbbc285dca3d");
            deFieldModel.setName("SUSPENDFLAG");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6d41\u7a0b\u6302\u8d77");
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
        iDEField = this.createDEField("TRACESTEP");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("883836035a130f1940cb9a9eaa202070");
            deFieldModel.setName("TRACESTEP");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u8ddf\u8e2a\u6b65\u9aa4");
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
            deFieldModel.setId("ef04f346005e49049b7c10ed67af1e3e");
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
            deFieldModel.setId("c6ea1f6a56af7306a46686304da6ff06");
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
            deFieldModel.setId("3456223a93f358bd96f57dfbbfa13999");
            deFieldModel.setName("USERDATA");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u7528\u6237\u6570\u636e");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_USERDATA_LIKE");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_USERDATA_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("USERDATA2");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("fed3ba82d7e85ee76819cbbb11ef11f3");
            deFieldModel.setName("USERDATA2");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u7528\u6237\u6570\u636e2");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_USERDATA2_LIKE");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_USERDATA2_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("USERDATA3");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("4e8a34e6c42d7911d0c1e88ed16f9168");
            deFieldModel.setName("USERDATA3");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u7528\u6237\u6570\u636e3");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_USERDATA3_LIKE");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_USERDATA3_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("USERDATA4");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("4b3e14c38a2c13e2eb227a6f269ab705");
            deFieldModel.setName("USERDATA4");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u7528\u6237\u6570\u636e4");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_USERDATA4_LIKE");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_USERDATA4_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("USERDATAINFO");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("0a6ff772aeb1a19eb7b31516459872b0");
            deFieldModel.setName("USERDATAINFO");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u7528\u6237\u6570\u636e\u4fe1\u606f");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("USERTAG");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("7b96cae2a7627b00e5cd3d28373710be");
            deFieldModel.setName("USERTAG");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u6570\u636e");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("USERTAG2");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("55d0c8dec4fceb24f8bbfd8a89fa41b4");
            deFieldModel.setName("USERTAG2");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u6570\u636e");
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
            deFieldModel.setId("762ef667190c429c1fdb7c4086ee598b");
            deFieldModel.setName("WFINSTANCEID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u6807\u8bc6");
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
        iDEField = this.createDEField("WFINSTANCENAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("81fb5724d6523b09eebd72ba090d0187");
            deFieldModel.setName("WFINSTANCENAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u540d\u79f0");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setMajorDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_WFINSTANCENAME_LIKE");
            if (iDEFSearchMode == null) {
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
        iDEField = this.createDEField("WFMODEL");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("d4250cf2c944e594b34a46c9c3afb99a");
            deFieldModel.setName("WFMODEL");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6d41\u7a0b\u914d\u7f6e");
            deFieldModel.setDataType("LONGTEXT");
            deFieldModel.setStdDataType(21);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFVERSION");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("4da4ae9b43f349b81746b7fedfd4c496");
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
        iDEField = this.createDEField("WFWORKFLOWID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("a6a6b9eae8571930b75510acb3c9241c");
            deFieldModel.setName("WFWORKFLOWID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5de5\u4f5c\u6d41\u540d\u79f0");
            deFieldModel.setDataType("PICKUP");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFINSTANCE_WFWORKFLOW_WFWORKFLOWID");
            deFieldModel.setLinkDEFName("WFWORKFLOWID");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_WFWORKFLOWID_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WFWORKFLOWID_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFWORKFLOWNAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("d5501d829143e64ea1d9becfbb182fcb");
            deFieldModel.setName("WFWORKFLOWNAME");
            deFieldModel.setDEFType(3);
            deFieldModel.setLogicName("\u5de5\u4f5c\u6d41\u540d\u79f0");
            deFieldModel.setDataType("PICKUPTEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_WFINSTANCE_WFWORKFLOW_WFWORKFLOWID");
            deFieldModel.setLinkDEFName("WFWORKFLOWNAME");
            deFieldModel.setPhisicalDEField(false);
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_WFWORKFLOWNAME_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WFWORKFLOWNAME_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_WFWORKFLOWNAME_LIKE")) == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WFWORKFLOWNAME_LIKE");
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
        WFInstanceDefaultACModel _defaultACModel = new WFInstanceDefaultACModel();
        _defaultACModel.init(this);
        this.registerDEACMode(_defaultACModel);
    }

    @Override
    protected void prepareDEDBConfigs() throws Exception {
        DEDBConfigModel mYSQL5ConfigModel = new DEDBConfigModel();
        mYSQL5ConfigModel.setDBType("MYSQL5");
        mYSQL5ConfigModel.setTableName("t_srfwfinstance");
        mYSQL5ConfigModel.setViewName("v_wfinstance");
        this.registerDEDBConfig(mYSQL5ConfigModel);
    }

    @Override
    protected void prepareDEDataSets() throws Exception {
        WFInstanceDefaultDSModel _defaultDSModel = new WFInstanceDefaultDSModel();
        _defaultDSModel.init(this);
        this.registerDEDataSet(_defaultDSModel);
    }

    @Override
    protected void prepareDEDataQueries() throws Exception {
        WFInstanceDefaultDQModel _defaultDQModel = new WFInstanceDefaultDQModel();
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
        WFInstanceRestartUIActionModel restartUIActionModel = new WFInstanceRestartUIActionModel();
        restartUIActionModel.init(this);
        this.registerDEUIAction(restartUIActionModel);
        WFInstanceUserCancelUIActionModel userCancelUIActionModel = new WFInstanceUserCancelUIActionModel();
        userCancelUIActionModel.init(this);
        this.registerDEUIAction(userCancelUIActionModel);
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
        this.registerPDTDEView("MPICKUPVIEW", "3c6b83af7073df8bbb007ec40b28eede");
        this.registerPDTDEView("PICKUPVIEW", "22887fbb4cc60eed9d7aa8aa845a5d76");
        this.registerPDTDEView("REDIRECTVIEW", "4e6b6f9be7646d050948ba84ef06935e");
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
        deDataSetCondImpl.setDEFName("WFINSTANCENAME");
        deDataSetCondImpl.setCondValue(strQuickSearch);
        groupCondImpl.addChildDEDataQueryCond(deDataSetCondImpl);
    }
}

