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
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.demodel.DEFSearchModeModel
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.SysModelGlobal
 */
package net.ibizsys.pscore.srv.appdesign.demodel;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.IDEACMode;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.demodel.DEFSearchModeModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.pscore.srv.PSCoreSysModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psapppvpart.ac.PSAppPVPartDefaultACModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psapppvpart.dataquery.PSAppPVPartDefaultDQModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psapppvpart.dataset.PSAppPVPartDefaultDSModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPVPart;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartService;
import net.ibizsys.pscore.srv.core.IPSDEFGroupModel;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupDetailModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupModel;
import net.ibizsys.pscore.srv.core.PSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDataEntityModelBase;

public abstract class PSAppPVPartDEModelBase
extends PSDataEntityModelBase<PSAppPVPart> {
    private PSCoreSysModel pSCoreSysModel;
    private PSAppPVPartService pSAppPVPartService;

    public PSAppPVPartDEModelBase() throws Exception {
        this.setId("c14525266fd0bba31fa8d12ab966c601");
        this.setName("PSAPPPVPART");
        this.setCodeName("PSAppPVPart");
        this.setTableName("T_SRFPSAPPPVPART");
        this.setViewName("v_PSAPPPVPART");
        this.setLogicName("\u5e94\u7528\u95e8\u6237\u89c6\u56fe\u90e8\u4ef6");
        this.setMemo("\u5e94\u7528\u6570\u636e\u770b\u677f\u89c6\u56fe\u90e8\u4ef6\u6210\u5458\u6a21\u578b\uff0c\u5b9a\u4e49\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u754c\u9762\u8868\u73b0\u53ca\u5904\u7406\u903b\u8f91\u3002\u652f\u6301\u591a\u79cd\u7c7b\u578b\uff0c\u652f\u6301\u591a\u5c42\u7ed3\u6784");
        this.setDSLink("DEFAULT");
        this.setEnableMultiDS(true);
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setEnableTempData(true);
        this.setUserTag("MODELV2");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppPVPartDEModel", (IDataEntityModel)this);
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

    public PSAppPVPartService getRealService() {
        if (this.pSAppPVPartService == null) {
            try {
                this.pSAppPVPartService = (PSAppPVPartService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppPVPartService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartService";
    }

    public PSAppPVPart createEntity() {
        return new PSAppPVPart();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("AMPSSYSPFPLUGINID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cf9aac447372237807154f3722b78133");
            pSDEFieldModel.setName("AMPSSYSPFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5feb\u901f\u83dc\u5355\u680f\u524d\u7aef\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSSYSPFPLUGIN_AMPSSYSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSPFPLUGINID");
            pSDEFieldModel.setCodeName("AMPSSysPFPluginId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_AMPSSYSPFPLUGINID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_AMPSSYSPFPLUGINID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("AMPSSYSPFPLUGINNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9c11109d8e0246730d23566bb9bd92fc");
            pSDEFieldModel.setName("AMPSSYSPFPLUGINNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5feb\u901f\u83dc\u5355\u680f\u524d\u7aef\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSSYSPFPLUGIN_AMPSSYSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSPFPLUGINNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("AMPSSysPFPluginName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5feb\u901f\u83dc\u5355\u680f\u524d\u7aef\u63d2\u4ef6\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u5217\u8868\u7ed8\u5236\u63d2\u4ef6\u3011");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_AMPSSYSPFPLUGINNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_AMPSSYSPFPLUGINNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_AMPSSYSPFPLUGINNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_AMPSSYSPFPLUGINNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("BL_POS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("410d27fd2d7b483eab88d1709a44c326");
            pSDEFieldModel.setName("BL_POS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4f4d\u7f6e\u5e03\u5c40\u4f4d\u7f6e");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.BorderLayoutPosCodeListModel");
            pSDEFieldModel.setCodeName("BL_Pos");
            pSDEFieldModel.setMemo("\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8fb9\u7f18\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u7684\u4f4d\u7f6e");
            pSDEFieldModel.setLength(10);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COLID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4a70d0f4211f1c5b76ebd39cb1cbd414");
            pSDEFieldModel.setName("COLID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5217\u6807\u8bc6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ColId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6570\u636e\u9762\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u5360\u4f4d\u5217\u6807\u8bc6\uff0c-1\u4e3a\u81ea\u52a8\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COLSPAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("74ea22f42de843643f64de7475d4a263");
            pSDEFieldModel.setName("COLSPAN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5217\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ColSpan");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u7684\u5360\u4f4d\u5217\u6570\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u30101\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_LG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("25c327ef456453dc66fa78e043a66419");
            pSDEFieldModel.setName("COL_LG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5927\u578b\u5217\u5bbd");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_LG");
            pSDEFieldModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u5927\u578b\u754c\u9762\u7684\u5217\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_LG_OS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ea2c2c25b6f15a32998558dae28c87ba");
            pSDEFieldModel.setName("COL_LG_OS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5927\u578b\u504f\u79fb");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_LG_OS");
            pSDEFieldModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u5927\u578b\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_MD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ee28b7742af2e7ba0694856293a21e75");
            pSDEFieldModel.setName("COL_MD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u578b\u5217\u5bbd");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_MD");
            pSDEFieldModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u4e2d\u578b\u754c\u9762\u7684\u5217\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_MD_OS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f47e124b33085d25a76599c889f8f41a");
            pSDEFieldModel.setName("COL_MD_OS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u578b\u504f\u79fb");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_MD_OS");
            pSDEFieldModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u4e2d\u578b\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_SM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("63b310fd20ace1de1d22413c2b2b804e");
            pSDEFieldModel.setName("COL_SM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5c0f\u578b\u5217\u5bbd");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_SM");
            pSDEFieldModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u5c0f\u578b\u754c\u9762\u7684\u5217\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_SM_OS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f7f42de5412ee08a848eabbf1eb885bf");
            pSDEFieldModel.setName("COL_SM_OS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5c0f\u578b\u504f\u79fb");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_SM_OS");
            pSDEFieldModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u5c0f\u578b\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_XS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1a32cc4ddd86de30a55fafb042a23850");
            pSDEFieldModel.setName("COL_XS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8d85\u5c0f\u5217\u5bbd");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_XS");
            pSDEFieldModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u8d85\u5c0f\u754c\u9762\u7684\u5217\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_XS_OS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("11da1d0a5991551e65d3743ef020e1c0");
            pSDEFieldModel.setName("COL_XS_OS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8d85\u5c0f\u504f\u79fb");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_XS_OS");
            pSDEFieldModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u8d85\u5c0f\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CONTENTTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6c62eb430145da3b6ff85ae9aac11563");
            pSDEFieldModel.setName("CONTENTTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u5bb9\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ContentTypeCodeListModel");
            pSDEFieldModel.setCodeName("ContentType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u770b\u677f\u89c6\u56fe\u76f4\u63a5\u5185\u5bb9\u9879\u7684\u5185\u5bb9\u7c7b\u578b");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CONTENTTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CONTENTTYPE_EQ");
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
            pSDEFieldModel.setId("6e6144a07a6a92dd1292b032bc10f1d3");
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
            pSDEFieldModel.setId("a75e3ee1ef64047fdf8fab942c025ab3");
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
        object = this.createDEField("DYNACLASS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("780fec18fcba0ae50136a2152698ff8a");
            pSDEFieldModel.setName("DYNACLASS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DynaClass");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLEANCHOR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2d7c89fc693a746d600aed2efe7da748");
            pSDEFieldModel.setName("ENABLEANCHOR");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u951a\u70b9");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableAnchor");
            pSDEFieldModel.setMemo("\u542f\u7528\u951a\u70b9\u63d0\u4f9b\u4e86\u5b9a\u4f4d\u5f53\u524d\u9879\u80fd\u529b\uff0c\u9ed8\u8ba4\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLECUSTOMMENU");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bb27311f8a2617ef414e1fe6af546b32");
            pSDEFieldModel.setName("ENABLECUSTOMMENU");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u652f\u6301\u81ea\u5b9a\u4e49\u83dc\u5355");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableCustomMenu");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u83dc\u5355\u770b\u677f\u6210\u5458\u662f\u5426\u652f\u6301\u81ea\u5b9a\u4e49\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FLEXALIGN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("af86e6dd9f8a50f8ea14689c3f0fa505");
            pSDEFieldModel.setName("FLEXALIGN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("Flex\u6a2a\u8f74\u5bf9\u9f50");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FlexAlignCodeListModel");
            pSDEFieldModel.setCodeName("FlexAlign");
            pSDEFieldModel.setMemo("\u6210\u5458\u5728\u3010Flex\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u6307\u5b9a\u6a2a\u8f74\u5bf9\u9f50\u65b9\u5f0f");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_FLEXALIGN_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_FLEXALIGN_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FLEXBASIS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("45949d3e2b13350d124ac7e5b067589d");
            pSDEFieldModel.setName("FLEXBASIS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("Flex\u4f38\u7f29\u57fa\u503c");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("FlexBasis");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FLEXDIR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("edc479a7e75b7b3e8c2423dce1c0e9fc");
            pSDEFieldModel.setName("FLEXDIR");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("Flex\u5e03\u5c40\u65b9\u5411");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FlexLayoutDirCodeListModel");
            pSDEFieldModel.setCodeName("FlexDir");
            pSDEFieldModel.setMemo("\u6210\u5458\u5728\u3010Flex\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u6307\u5b9a\u5e03\u5c40\u65b9\u5411");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_FLEXDIR_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_FLEXDIR_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FLEXGROW");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3a7e2f663fe2c9f0b823ab48271061fd");
            pSDEFieldModel.setName("FLEXGROW");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("Flex\u5ef6\u5c55\u503c");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("FlexGrow");
            pSDEFieldModel.setMemo("\u6210\u5458\u5728\u3010Flex\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u5ef6\u5c55\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FLEXSHRINK");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bfdd48333dd9a2b2d1940bf1765917a6");
            pSDEFieldModel.setName("FLEXSHRINK");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("Flex\u4f38\u7f29");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("FlexShrink");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FLEXVALIGN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9adf3ce6336578849728b6843e615efe");
            pSDEFieldModel.setName("FLEXVALIGN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("Flex\u7eb5\u8f74\u5bf9\u9f50");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FlexVAlignCodeListModel");
            pSDEFieldModel.setCodeName("FlexVAlign");
            pSDEFieldModel.setMemo("\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010Flex\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u7eb5\u8f74\u5bf9\u9f50\u65b9\u5f0f");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_FLEXVALIGN_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_FLEXVALIGN_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HALIGNSELF");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cdd6224bc17da673447c14cd3986c75e");
            pSDEFieldModel.setName("HALIGNSELF");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6c34\u5e73\u5bf9\u9f50\uff08\u81ea\u8eab\uff09");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TextAlignCodeListModel");
            pSDEFieldModel.setCodeName("HAlignSelf");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_HALIGNSELF_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_HALIGNSELF_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HEIGHT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("34e1a239e2cf2d464cf79cd4fb35fb8e");
            pSDEFieldModel.setName("HEIGHT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ad8\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Height");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u9ad8\u5ea6\uff0c0\u4e3a\u81ea\u52a8\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e\uff0c\u5176\u5b83\u4e3a\u30100\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HTMLCONTENT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("95dc9358bd091ee88ecd90a08ddcf5f2");
            pSDEFieldModel.setName("HTMLCONTENT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("HTML\u5185\u5bb9");
            pSDEFieldModel.setDataType("HTMLTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("HtmlContent");
            pSDEFieldModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u5185\u5bb9\u7c7b\u578b\u4e3a\u3010Html\u5185\u5bb9\u3011\u65f6\u6307\u5b9aHtml\u5185\u5bb9\uff0c\u672a\u6307\u5b9a\u65f6\u4f7f\u7528\u6307\u5b9a\u7684\u7cfb\u7edf\u8d44\u6e90\u5b9a\u4e49\u5185\u5bb9");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LAYOUTMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ae928a510aa97d2e50ae00a3e9d689d6");
            pSDEFieldModel.setName("LAYOUTMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e03\u5c40\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PanelLayoutMode2CodeListModel");
            pSDEFieldModel.setCodeName("LayoutMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u5e03\u5c40\u5bb9\u5668\u6a21\u5f0f");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LAYOUTMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LAYOUTMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
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
            pSDEFieldModel.setId("6f68c4e5919accbd6c18b853b1b8016a");
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
        object = this.createDEField("MENUPSAPPUTILVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8aa0c50bba9b2a3e3c3fd91fe518d1bd");
            pSDEFieldModel.setName("MENUPSAPPUTILVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u83dc\u5355\u529f\u80fd\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSAPPUTILVIEW_MENUPSAPPUTILVIEWID");
            pSDEFieldModel.setLinkDEFName("PSAPPUTILVIEWID");
            pSDEFieldModel.setCodeName("MenuPSAppUtilViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MENUPSAPPUTILVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MENUPSAPPUTILVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MENUPSAPPUTILVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8824fa133ec9d80b908adc88c47a854b");
            pSDEFieldModel.setName("MENUPSAPPUTILVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u83dc\u5355\u529f\u80fd\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSAPPUTILVIEW_MENUPSAPPUTILVIEWID");
            pSDEFieldModel.setLinkDEFName("PSAPPUTILVIEWNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("MenuPSAppUtilViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u83dc\u5355\u770b\u677f\u6210\u5458\u63d0\u4f9b\u81ea\u5b9a\u4e49\u7684\u529f\u80fd\u89c6\u56fe");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MENUPSAPPUTILVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MENUPSAPPUTILVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MENUPSAPPUTILVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MENUPSAPPUTILVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MOBAMTYLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ca06d3b44b75bd2d21353bc78fdc500e");
            pSDEFieldModel.setName("MOBAMTYLE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u83dc\u5355\u680f\u6837\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.MobMDCtrlTypesCodeListModel");
            pSDEFieldModel.setCodeName("MOBAMStyle");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u83dc\u5355\u770b\u677f\u6210\u5458\u7684\u7ed8\u5236\u6837\u5f0f");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MOBAMTYLE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MOBAMTYLE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("NEWROWMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fe1365574e2e25a972cc859d783eb428");
            pSDEFieldModel.setName("NEWROWMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u65b0\u8d77\u4e00\u884c");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("NewRowMode");
            pSDEFieldModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u662f\u5426\u5f3a\u5236\u65b0\u8d77\u4e00\u884c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ORDERVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3350ceedb9f72bc836a4048c5e26d8a4");
            pSDEFieldModel.setName("ORDERVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6392\u5e8f\u503c");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("OrderValue");
            pSDEFieldModel.setUserTag2("AUTOMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PARTPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7fa380d4ba4aa528f8f9c7b45b00642a");
            pSDEFieldModel.setName("PARTPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6210\u5458\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PartParams");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PARTSTYLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2b8623f69a97f8278aad1c8fe2b09788");
            pSDEFieldModel.setName("PARTSTYLE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u7f6e\u6837\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDetailStyleCodeListModel");
            pSDEFieldModel.setCodeName("PartStyle");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u5185\u7f6e\u6837\u5f0f");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PARTSTYLE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PARTSTYLE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PORTLETTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8ee9398f3fc685b3c64f185f178957a9");
            pSDEFieldModel.setName("PORTLETTYPE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u90e8\u4ef6\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSSYSPORTLET_PSSYSPORTLETID");
            pSDEFieldModel.setLinkDEFName("PORTLETTYPE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PortletTypeCodeListModel");
            pSDEFieldModel.setCodeName("PortletType");
            pSDEFieldModel.setLength(40);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("POSINFO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b6e5491b5acb0b900c0b2ad3a97ed6c5");
            pSDEFieldModel.setName("POSINFO");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4f4d\u7f6e\u4fe1\u606f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PosInfo");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.setLength(1000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PPSAPPPVPARTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("abdde1a541d2b6b3ec3813861018e3fa");
            pSDEFieldModel.setName("PPSAPPPVPARTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7236\u6570\u636e\u770b\u677f\u6210\u5458");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSAPPPVPART_PPSAPPPVPARTID");
            pSDEFieldModel.setLinkDEFName("PSAPPPVPARTID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PPSAppPVPartId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PPSAPPPVPARTID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PPSAPPPVPARTID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PPSAPPPVPARTNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d8c7a1eb267b3f4a8a45d689018c3d50");
            pSDEFieldModel.setName("PPSAPPPVPARTNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7236\u6570\u636e\u770b\u677f\u6210\u5458");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSAPPPVPART_PPSAPPPVPARTID");
            pSDEFieldModel.setLinkDEFName("PSAPPPVPARTNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PPSAppPVPartName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u7236\u6210\u5458");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PPSAPPPVPARTNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PPSAPPPVPARTNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PPSAPPPVPARTNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PPSAPPPVPARTNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPMENUID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("059e403877463855e29a6a584bd29ade");
            pSDEFieldModel.setName("PSAPPMENUID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u83dc\u5355");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSAPPMENU_PSAPPMENUID");
            pSDEFieldModel.setLinkDEFName("PSAPPMENUID");
            pSDEFieldModel.setCodeName("PSAppMenuId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPMENUID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPMENUID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPMENUNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ccae0211889d7367a92a2c0194c1b5d1");
            pSDEFieldModel.setName("PSAPPMENUNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u83dc\u5355");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSAPPMENU_PSAPPMENUID");
            pSDEFieldModel.setLinkDEFName("PSAPPMENUNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSAppMenuName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u83dc\u5355\u770b\u677f\u6210\u5458\u5f15\u7528\u7684\u5e94\u7528\u83dc\u5355");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPMENUNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPMENUNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPMENUNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPMENUNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPPORTALVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e8e4e6eed26fdeb20ac5dacfecf693e1");
            pSDEFieldModel.setName("PSAPPPORTALVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u95e8\u6237\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSAPPPORTALVIEW_PSAPPPORTALVIEWID");
            pSDEFieldModel.setLinkDEFName("PSAPPPORTALVIEWID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSAppPortalViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPPORTALVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPPORTALVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPPORTALVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f97c1c90552b4ffe02c8e3949f5dacd5");
            pSDEFieldModel.setName("PSAPPPORTALVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u95e8\u6237\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSAPPPORTALVIEW_PSAPPPORTALVIEWID");
            pSDEFieldModel.setLinkDEFName("PSAPPPORTALVIEWNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSAppPortalViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u6240\u5c5e\u7684\u5e94\u7528\u6570\u636e\u770b\u677f\u89c6\u56fe");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPPORTALVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPPORTALVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPPORTALVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPPORTALVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPPVPARTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f7d432f7d696ec4696de99d52d8a4124");
            pSDEFieldModel.setName("PSAPPPVPARTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u95e8\u6237\u89c6\u56fe\u90e8\u4ef6\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSAppPVPartId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPPVPARTNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0ad77c9fa1010e6eef16196d2c500056");
            pSDEFieldModel.setName("PSAPPPVPARTNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u90e8\u4ef6\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSAppPVPartName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5c5e\u7684\u5e94\u7528\u6570\u636e\u770b\u677f\u89c6\u56fe\u4e2d\u5177\u5907\u552f\u4e00\u6027");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPPVPARTNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPPVPARTNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPPVPARTNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPPVPARTNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d40d67fc04db1ea4be12ce38ef371994");
            pSDEFieldModel.setName("PSAPPVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSAPPVIEW_PSAPPVIEWID");
            pSDEFieldModel.setLinkDEFName("PSAPPVIEWID");
            pSDEFieldModel.setCodeName("PSAppViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6c2ada890e61a493ca24cd0fb352437d");
            pSDEFieldModel.setName("PSAPPVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSAPPVIEW_PSAPPVIEWID");
            pSDEFieldModel.setLinkDEFName("PSAPPVIEWNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSAppViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u89c6\u56fe\u770b\u677f\u6210\u5458\u5f15\u7528\u7684\u5e94\u7528\u89c6\u56fe");
            pSDEFieldModel.setLength(80);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSCSSID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("130ba40a719d2f5c2aee8839b6a78505");
            pSDEFieldModel.setName("PSSYSCSSID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u754c\u9762\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSSYSCSS_PSSYSCSSID");
            pSDEFieldModel.setLinkDEFName("PSSYSCSSID");
            pSDEFieldModel.setCodeName("PSSysCssId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSCSSID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSCSSID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSCSSNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6ab319d6a21cd5753e3f63b1d7687172");
            pSDEFieldModel.setName("PSSYSCSSNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u754c\u9762\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSSYSCSS_PSSYSCSSID");
            pSDEFieldModel.setLinkDEFName("PSSYSCSSNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysCssName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u5bb9\u5668\u754c\u9762\u6837\u5f0f\u8868\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSCSSNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSCSSNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSCSSNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSCSSNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSIMAGEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ef4ff7f49b93a9f547618daed8f31b43");
            pSDEFieldModel.setName("PSSYSIMAGEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u56fe\u7247");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSSYSIMAGE_PSSYSIMAGEID");
            pSDEFieldModel.setLinkDEFName("PSSYSIMAGEID");
            pSDEFieldModel.setCodeName("PSSysImageId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSIMAGEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSIMAGEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSIMAGENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b26e3fefc1805549babc09e589292cda");
            pSDEFieldModel.setName("PSSYSIMAGENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u56fe\u7247");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSSYSIMAGE_PSSYSIMAGEID");
            pSDEFieldModel.setLinkDEFName("PSSYSIMAGENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysImageName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u56fe\u7247\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSIMAGENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSIMAGENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSIMAGENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSIMAGENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSPFPLUGINID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f647a35e157a61cc01d7bba07bc5355d");
            pSDEFieldModel.setName("PSSYSPFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSSYSPFPLUGIN_PSSYSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSPFPLUGINID");
            pSDEFieldModel.setCodeName("PSSysPFPluginId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSPFPLUGINID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSPFPLUGINID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSPFPLUGINNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("36c9ff786419d17c8ea91e9ad4041515");
            pSDEFieldModel.setName("PSSYSPFPLUGINNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSSYSPFPLUGIN_PSSYSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSPFPLUGINNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysPFPluginName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSPFPLUGINNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSPFPLUGINNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSPFPLUGINNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSPFPLUGINNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSPORTLETID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c392ebf7c70c46cc1699a47b7a79fa3e");
            pSDEFieldModel.setName("PSSYSPORTLETID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSSYSPORTLET_PSSYSPORTLETID");
            pSDEFieldModel.setLinkDEFName("PSSYSPORTLETID");
            pSDEFieldModel.setCodeName("PSSysPortletId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSPORTLETID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSPORTLETID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSPORTLETNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1d3b0c6a4dd77bc4de7bf7d1437b6d8b");
            pSDEFieldModel.setName("PSSYSPORTLETNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSSYSPORTLET_PSSYSPORTLETID");
            pSDEFieldModel.setLinkDEFName("PSSYSPORTLETNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysPortletName");
            pSDEFieldModel.setMemo("\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u9879\u6307\u5b9a\u5f15\u7528\u7684\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSPORTLETNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSPORTLETNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSPORTLETNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSPORTLETNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSRESOURCEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e3088bea5043ee5572984129f9e07e63");
            pSDEFieldModel.setName("PSSYSRESOURCEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSSYSRESOURCE_PSSYSRESOURCEID");
            pSDEFieldModel.setLinkDEFName("PSSYSRESOURCEID");
            pSDEFieldModel.setCodeName("PSSysResourceId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSRESOURCEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSRESOURCEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSRESOURCENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("808172ee705921abbe6ce9df49358c6c");
            pSDEFieldModel.setName("PSSYSRESOURCENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSSYSRESOURCE_PSSYSRESOURCEID");
            pSDEFieldModel.setLinkDEFName("PSSYSRESOURCENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysResourceName");
            pSDEFieldModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u7c7b\u578b\u4e3a\u3010\u76f4\u63a5\u5185\u5bb9\u3011\u6216\u3010html\u5185\u5bb9\u3011\u65f6\u6307\u5b9a\u7cfb\u7edf\u9884\u7f6e\u7684\u8d44\u6e90\u5bf9\u8c61\u8fdb\u884c\u5185\u5bb9\u63d0\u4f9b");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSRESOURCENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSRESOURCENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSRESOURCENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSRESOURCENAME_LIKE");
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
            pSDEFieldModel.setId("cc248f0a3f002c988fe710f134778c99");
            pSDEFieldModel.setName("PSSYSTEMID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("PSSYSTEMID");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSAPPPORTALVIEW_PSAPPPORTALVIEWID");
            pSDEFieldModel.setLinkDEFName("PSSYSTEMID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSystemId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSUNIRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1a4f838958966e2171f7b1dc2b7231a9");
            pSDEFieldModel.setName("PSSYSUNIRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSSYSUNIRES_PSSYSUNIRESID");
            pSDEFieldModel.setLinkDEFName("PSSYSUNIRESID");
            pSDEFieldModel.setCodeName("PSSysUniResId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSUNIRESID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSUNIRESID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSUNIRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2a3202b6ab3cef2fca7ff8cb8ad30fb1");
            pSDEFieldModel.setName("PSSYSUNIRESNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSSYSUNIRES_PSSYSUNIRESID");
            pSDEFieldModel.setLinkDEFName("PSSYSUNIRESNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysUniResName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u8bbf\u95ee\u63a7\u5236\u7684\u7edf\u4e00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSUNIRESNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSUNIRESNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSUNIRESNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSUNIRESNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PVPARTTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4b0ffc0c3002256d804b8f94d320c7c4");
            pSDEFieldModel.setName("PVPARTTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u90e8\u4ef6\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMultiFormDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppPVPartTypesCodeListModel");
            pSDEFieldModel.setCodeName("PVPartType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7c7b\u578b");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PVPARTTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PVPARTTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RAWCONTENT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("075d72324f91b02f6675c2ed251d72da");
            pSDEFieldModel.setName("RAWCONTENT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u76f4\u63a5\u5185\u5bb9");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RawContent");
            pSDEFieldModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u5185\u5bb9\u7c7b\u578b\u4e3a\u3010\u76f4\u63a5\u5185\u5bb9\u3011\u65f6\u6307\u5b9a\u76f4\u63a5\u5185\u5bb9\uff0c\u672a\u6307\u5b9a\u65f6\u4f7f\u7528\u6307\u5b9a\u7684\u7cfb\u7edf\u8d44\u6e90\u5b9a\u4e49\u5185\u5bb9");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RAWCSSSTYLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cf8f3e7b63d81a0f3ee0e6cb3cfd1d76");
            pSDEFieldModel.setName("RAWCSSSTYLE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u76f4\u63a5\u6837\u5f0f");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RawCssStyle");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SHOWTITLEBAR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ba947fcbb6a0e21593ce1675a9ab533b");
            pSDEFieldModel.setName("SHOWTITLEBAR");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u663e\u793a\u6807\u9898\u680f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ShowTitleBar");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u662f\u5426\u8f93\u51fa\u6807\u9898\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e\uff0c\u5176\u5b83\u4e3a\u3010\u662f\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SWAPMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4e1565fd9abf9396e1f614fd6693d25c");
            pSDEFieldModel.setName("SWAPMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u5bb9\u6362\u884c\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.WrapModeCodeListModel");
            pSDEFieldModel.setCodeName("SwapMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u6587\u672c\u7684\u6362\u884c\u6a21\u5f0f");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPLATEMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1d41669a3a79899c00ef881be571bc4b");
            pSDEFieldModel.setName("TEMPLATEMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u677f\u6a21\u5f0f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("TemplateMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u76f4\u63a5\u5185\u5bb9\u8f93\u51fa\u662f\u5426\u4f7f\u7528\u6a21\u677f\u673a\u5236\uff0c\u9ed8\u8ba4\u4e3a\u3010\u5426\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TEMPLATEMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TEMPLATEMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TITLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bf6a2a9e60f6293952efbd4e38c25146");
            pSDEFieldModel.setName("TITLE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Title");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u6807\u9898\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TITLEBARCLOSEMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5eb4f9054fbc2d79859dea2077315fe0");
            pSDEFieldModel.setName("TITLEBARCLOSEMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTitleBarCloseModeCodeListModel");
            pSDEFieldModel.setCodeName("TitleBarCloseMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u5bb9\u5668\u5206\u7ec4\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u5173\u95ed\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TITLEBARCLOSEMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TITLEBARCLOSEMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TITLEPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("01117210e5d95534605428af5750cde9");
            pSDEFieldModel.setName("TITLEPSLANRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSLANGUAGERES_TITLEPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESID");
            pSDEFieldModel.setCodeName("TitlePSLanResId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TITLEPSLANRESID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TITLEPSLANRESID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TITLEPSLANRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8c5ef56bcd7746419a6a0d4ba9e0cd86");
            pSDEFieldModel.setName("TITLEPSLANRESNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPPVPART_PSLANGUAGERES_TITLEPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESNAME");
            pSDEFieldModel.setCodeName("TitlePSLanResName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TITLEPSLANRESNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TITLEPSLANRESNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TITLEPSLANRESNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TITLEPSLANRESNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TOOLTIPINFO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("581f1b8c4b74d80a85fe0232a5675c6f");
            pSDEFieldModel.setName("TOOLTIPINFO");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63d0\u793a\u4fe1\u606f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("TooltipInfo");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c70a3d6b52dd9e3b643371a03b04b39a");
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
            pSDEFieldModel.setId("5d4f1356038816205faf545269ed5788");
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
        object = this.createDEField("USERTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ad27d8421064e9d5991644a2f01463b4");
            pSDEFieldModel.setName("USERTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_USERTAG_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_USERTAG_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("637bb6ecfdb29e4e0707e646314290f2");
            pSDEFieldModel.setName("USERTAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb02");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag2");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_USERTAG2_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_USERTAG2_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VALIDFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5a1a17258db301e0e3cbf8045e1fd9b2");
            pSDEFieldModel.setName("VALIDFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColor3CodeListModel");
            pSDEFieldModel.setCodeName("ValidFlag");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VALIGNSELF");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1b143788134ab4b2123a025a06cf8d8b");
            pSDEFieldModel.setName("VALIGNSELF");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5782\u76f4\u5bf9\u9f50\uff08\u81ea\u8eab\uff09");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TextVAlignCodeListModel");
            pSDEFieldModel.setCodeName("VAlignSelf");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_VALIGNSELF_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_VALIGNSELF_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIDTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0672736ad6c12adcba36fe7ced82d807");
            pSDEFieldModel.setName("WIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bbd\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Width");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u5bbd\u5ea6\uff0c0\u4e3a\u81ea\u52a8\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u30100\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSAppPVPartDefaultACModel pSAppPVPartDefaultACModel = new PSAppPVPartDefaultACModel();
        pSAppPVPartDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSAppPVPartDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSAppPVPartDefaultDSModel pSAppPVPartDefaultDSModel = new PSAppPVPartDefaultDSModel();
        pSAppPVPartDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSAppPVPartDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSAppPVPartDefaultDQModel pSAppPVPartDefaultDQModel = new PSAppPVPartDefaultDQModel();
        pSAppPVPartDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSAppPVPartDefaultDQModel);
    }

    protected void prepareDEActions() throws Exception {
    }

    protected void prepareDELogics() throws Exception {
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
        this.registerPDTDEView("EDITVIEW", "cd0ecea5d799eef49ac56a6b45525379");
        this.registerPDTDEView("EDITVIEW:APPMENU", "FB95B97B-6121-4C4F-A12F-ED2CCC178DB3");
        this.registerPDTDEView("EDITVIEW:APPVIEW", "731C730A-5DC2-49B9-ABFB-FA4FF25D2AE7");
        this.registerPDTDEView("EDITVIEW:CONTAINER", "A7307ADD-1BA5-4701-967D-26D2D9135652");
        this.registerPDTDEView("EDITVIEW:RAWITEM", "208E5784-D80E-4673-842D-42F9D89F9CBE");
        this.registerPDTDEView("EDITVIEW:SYSPORTLET", "086C478F-127B-476F-8E5B-7165EECD5A06");
        this.registerPDTDEView("MPICKUPVIEW", "e34208742579b8b62d90b6b2bb73a9e8");
        this.registerPDTDEView("PICKUPVIEW", "d607353b0cefa77f83c2fe3b1db48112");
        this.registerPDTDEView("REDIRECTVIEW", "15f6a2248d17bf751530c9c62ac9eaa8");
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
        dEDataSetCond2.setDEFName("PSAPPPVPARTNAME");
        dEDataSetCond2.setCondValue(string);
        dEDataSetCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)dEDataSetCond2);
    }

    @Override
    protected void onPreparePSDEFGroupModels() throws Exception {
        IPSDEFGroupModel iPSDEFGroupModel = this.preparePSDEFGroupModel_APPMENU();
        if (iPSDEFGroupModel != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_APPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_CONTAINER()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_RAWITEM()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_SYSPORTLET()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel__DEFAULT()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_APPMENU() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("APPMENU");
        pSDEFGroupModel.setName("\u5feb\u6377\u83dc\u5355\u680f");
        pSDEFGroupModel.setUserTag("APPMENU");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cf9aac447372237807154f3722b78133");
        pSDEFGroupDetailModel.setName("AMPSSYSPFPLUGINID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("AMPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5feb\u901f\u83dc\u5355\u680f\u524d\u7aef\u63d2\u4ef6\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u5217\u8868\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9c11109d8e0246730d23566bb9bd92fc");
        pSDEFGroupDetailModel.setName("AMPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("AMPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5feb\u901f\u83dc\u5355\u680f\u524d\u7aef\u63d2\u4ef6\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u5217\u8868\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bb27311f8a2617ef414e1fe6af546b32");
        pSDEFGroupDetailModel.setName("ENABLECUSTOMMENU");
        iPSDEFieldModel = this.getDEField("ENABLECUSTOMMENU", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u83dc\u5355\u770b\u677f\u6210\u5458\u662f\u5426\u652f\u6301\u81ea\u5b9a\u4e49\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ca06d3b44b75bd2d21353bc78fdc500e");
        pSDEFGroupDetailModel.setName("MOBAMTYLE");
        iPSDEFieldModel = this.getDEField("MOBAMTYLE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.MobMDCtrlTypesCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u83dc\u5355\u770b\u677f\u6210\u5458\u7684\u7ed8\u5236\u6837\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8aa0c50bba9b2a3e3c3fd91fe518d1bd");
        pSDEFGroupDetailModel.setName("MENUPSAPPUTILVIEWID");
        iPSDEFieldModel = this.getDEField("MENUPSAPPUTILVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u83dc\u5355\u770b\u677f\u6210\u5458\u63d0\u4f9b\u81ea\u5b9a\u4e49\u7684\u529f\u80fd\u89c6\u56fe");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8824fa133ec9d80b908adc88c47a854b");
        pSDEFGroupDetailModel.setName("MENUPSAPPUTILVIEWNAME");
        iPSDEFieldModel = this.getDEField("MENUPSAPPUTILVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u83dc\u5355\u770b\u677f\u6210\u5458\u63d0\u4f9b\u81ea\u5b9a\u4e49\u7684\u529f\u80fd\u89c6\u56fe");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("059e403877463855e29a6a584bd29ade");
        pSDEFGroupDetailModel.setName("PSAPPMENUID");
        iPSDEFieldModel = this.getDEField("PSAPPMENUID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u83dc\u5355\u770b\u677f\u6210\u5458\u5f15\u7528\u7684\u5e94\u7528\u83dc\u5355");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ccae0211889d7367a92a2c0194c1b5d1");
        pSDEFGroupDetailModel.setName("PSAPPMENUNAME");
        iPSDEFieldModel = this.getDEField("PSAPPMENUNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u83dc\u5355\u770b\u677f\u6210\u5458\u5f15\u7528\u7684\u5e94\u7528\u83dc\u5355");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_APPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("APPVIEW");
        pSDEFGroupModel.setName("\u5e94\u7528\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("APPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d40d67fc04db1ea4be12ce38ef371994");
        pSDEFGroupDetailModel.setName("PSAPPVIEWID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSAPPVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u89c6\u56fe\u770b\u677f\u6210\u5458\u5f15\u7528\u7684\u5e94\u7528\u89c6\u56fe");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6c2ada890e61a493ca24cd0fb352437d");
        pSDEFGroupDetailModel.setName("PSAPPVIEWNAME");
        iPSDEFieldModel = this.getDEField("PSAPPVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u89c6\u56fe\u770b\u677f\u6210\u5458\u5f15\u7528\u7684\u5e94\u7528\u89c6\u56fe");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_CONTAINER() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("CONTAINER");
        pSDEFGroupModel.setName("\u5e03\u5c40\u5bb9\u5668");
        pSDEFGroupModel.setUserTag("CONTAINER");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("af86e6dd9f8a50f8ea14689c3f0fa505");
        pSDEFGroupDetailModel.setName("FLEXALIGN");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("FLEXALIGN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FlexAlignCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010Flex\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u6307\u5b9a\u6a2a\u8f74\u5bf9\u9f50\u65b9\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("edc479a7e75b7b3e8c2423dce1c0e9fc");
        pSDEFGroupDetailModel.setName("FLEXDIR");
        iPSDEFieldModel = this.getDEField("FLEXDIR", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FlexLayoutDirCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010Flex\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u6307\u5b9a\u5e03\u5c40\u65b9\u5411");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9adf3ce6336578849728b6843e615efe");
        pSDEFGroupDetailModel.setName("FLEXVALIGN");
        iPSDEFieldModel = this.getDEField("FLEXVALIGN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FlexVAlignCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010Flex\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u7eb5\u8f74\u5bf9\u9f50\u65b9\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ae928a510aa97d2e50ae00a3e9d689d6");
        pSDEFGroupDetailModel.setName("LAYOUTMODE");
        iPSDEFieldModel = this.getDEField("LAYOUTMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PanelLayoutMode2CodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u5e03\u5c40\u5bb9\u5668\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_RAWITEM() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("RAWITEM");
        pSDEFGroupModel.setName("\u76f4\u63a5\u5185\u5bb9");
        pSDEFGroupModel.setUserTag("RAWITEM");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6c62eb430145da3b6ff85ae9aac11563");
        pSDEFGroupDetailModel.setName("CONTENTTYPE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CONTENTTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ContentTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u770b\u677f\u89c6\u56fe\u76f4\u63a5\u5185\u5bb9\u9879\u7684\u5185\u5bb9\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("95dc9358bd091ee88ecd90a08ddcf5f2");
        pSDEFGroupDetailModel.setName("HTMLCONTENT");
        iPSDEFieldModel = this.getDEField("HTMLCONTENT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u5185\u5bb9\u7c7b\u578b\u4e3a\u3010Html\u5185\u5bb9\u3011\u65f6\u6307\u5b9aHtml\u5185\u5bb9\uff0c\u672a\u6307\u5b9a\u65f6\u4f7f\u7528\u6307\u5b9a\u7684\u7cfb\u7edf\u8d44\u6e90\u5b9a\u4e49\u5185\u5bb9");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e3088bea5043ee5572984129f9e07e63");
        pSDEFGroupDetailModel.setName("PSSYSRESOURCEID");
        iPSDEFieldModel = this.getDEField("PSSYSRESOURCEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u7c7b\u578b\u4e3a\u3010\u76f4\u63a5\u5185\u5bb9\u3011\u6216\u3010html\u5185\u5bb9\u3011\u65f6\u6307\u5b9a\u7cfb\u7edf\u9884\u7f6e\u7684\u8d44\u6e90\u5bf9\u8c61\u8fdb\u884c\u5185\u5bb9\u63d0\u4f9b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("808172ee705921abbe6ce9df49358c6c");
        pSDEFGroupDetailModel.setName("PSSYSRESOURCENAME");
        iPSDEFieldModel = this.getDEField("PSSYSRESOURCENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u7c7b\u578b\u4e3a\u3010\u76f4\u63a5\u5185\u5bb9\u3011\u6216\u3010html\u5185\u5bb9\u3011\u65f6\u6307\u5b9a\u7cfb\u7edf\u9884\u7f6e\u7684\u8d44\u6e90\u5bf9\u8c61\u8fdb\u884c\u5185\u5bb9\u63d0\u4f9b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("075d72324f91b02f6675c2ed251d72da");
        pSDEFGroupDetailModel.setName("RAWCONTENT");
        iPSDEFieldModel = this.getDEField("RAWCONTENT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u5185\u5bb9\u7c7b\u578b\u4e3a\u3010\u76f4\u63a5\u5185\u5bb9\u3011\u65f6\u6307\u5b9a\u76f4\u63a5\u5185\u5bb9\uff0c\u672a\u6307\u5b9a\u65f6\u4f7f\u7528\u6307\u5b9a\u7684\u7cfb\u7edf\u8d44\u6e90\u5b9a\u4e49\u5185\u5bb9");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_SYSPORTLET() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("SYSPORTLET");
        pSDEFGroupModel.setName("\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6");
        pSDEFGroupModel.setUserTag("SYSPORTLET");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c392ebf7c70c46cc1699a47b7a79fa3e");
        pSDEFGroupDetailModel.setName("PSSYSPORTLETID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSSYSPORTLETID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u9879\u6307\u5b9a\u5f15\u7528\u7684\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1d3b0c6a4dd77bc4de7bf7d1437b6d8b");
        pSDEFGroupDetailModel.setName("PSSYSPORTLETNAME");
        iPSDEFieldModel = this.getDEField("PSSYSPORTLETNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u9879\u6307\u5b9a\u5f15\u7528\u7684\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel__DEFAULT() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("_DEFAULT");
        pSDEFGroupModel.setName("\u901a\u7528");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("410d27fd2d7b483eab88d1709a44c326");
        pSDEFGroupDetailModel.setName("BL_POS");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("BL_POS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.BorderLayoutPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8fb9\u7f18\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u7684\u4f4d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4a70d0f4211f1c5b76ebd39cb1cbd414");
        pSDEFGroupDetailModel.setName("COLID");
        iPSDEFieldModel = this.getDEField("COLID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u9762\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u5360\u4f4d\u5217\u6807\u8bc6\uff0c-1\u4e3a\u81ea\u52a8\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("74ea22f42de843643f64de7475d4a263");
        pSDEFGroupDetailModel.setName("COLSPAN");
        iPSDEFieldModel = this.getDEField("COLSPAN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u7684\u5360\u4f4d\u5217\u6570\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u30101\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("25c327ef456453dc66fa78e043a66419");
        pSDEFGroupDetailModel.setName("COL_LG");
        iPSDEFieldModel = this.getDEField("COL_LG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u5927\u578b\u754c\u9762\u7684\u5217\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ea2c2c25b6f15a32998558dae28c87ba");
        pSDEFGroupDetailModel.setName("COL_LG_OS");
        iPSDEFieldModel = this.getDEField("COL_LG_OS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u5927\u578b\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ee28b7742af2e7ba0694856293a21e75");
        pSDEFGroupDetailModel.setName("COL_MD");
        iPSDEFieldModel = this.getDEField("COL_MD", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u4e2d\u578b\u754c\u9762\u7684\u5217\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f47e124b33085d25a76599c889f8f41a");
        pSDEFGroupDetailModel.setName("COL_MD_OS");
        iPSDEFieldModel = this.getDEField("COL_MD_OS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u4e2d\u578b\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("63b310fd20ace1de1d22413c2b2b804e");
        pSDEFGroupDetailModel.setName("COL_SM");
        iPSDEFieldModel = this.getDEField("COL_SM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u5c0f\u578b\u754c\u9762\u7684\u5217\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f7f42de5412ee08a848eabbf1eb885bf");
        pSDEFGroupDetailModel.setName("COL_SM_OS");
        iPSDEFieldModel = this.getDEField("COL_SM_OS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u5c0f\u578b\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1a32cc4ddd86de30a55fafb042a23850");
        pSDEFGroupDetailModel.setName("COL_XS");
        iPSDEFieldModel = this.getDEField("COL_XS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u8d85\u5c0f\u754c\u9762\u7684\u5217\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("11da1d0a5991551e65d3743ef020e1c0");
        pSDEFGroupDetailModel.setName("COL_XS_OS");
        iPSDEFieldModel = this.getDEField("COL_XS_OS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u8d85\u5c0f\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3a7e2f663fe2c9f0b823ab48271061fd");
        pSDEFGroupDetailModel.setName("FLEXGROW");
        iPSDEFieldModel = this.getDEField("FLEXGROW", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010Flex\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u5ef6\u5c55\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("34e1a239e2cf2d464cf79cd4fb35fb8e");
        pSDEFGroupDetailModel.setName("HEIGHT");
        iPSDEFieldModel = this.getDEField("HEIGHT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u9ad8\u5ea6\uff0c0\u4e3a\u81ea\u52a8\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e\uff0c\u5176\u5b83\u4e3a\u30100\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6f68c4e5919accbd6c18b853b1b8016a");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("fe1365574e2e25a972cc859d783eb428");
        pSDEFGroupDetailModel.setName("NEWROWMODE");
        iPSDEFieldModel = this.getDEField("NEWROWMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u662f\u5426\u5f3a\u5236\u65b0\u8d77\u4e00\u884c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("abdde1a541d2b6b3ec3813861018e3fa");
        pSDEFGroupDetailModel.setName("PPSAPPPVPARTID");
        iPSDEFieldModel = this.getDEField("PPSAPPPVPARTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0ad77c9fa1010e6eef16196d2c500056");
        pSDEFGroupDetailModel.setName("PSAPPPVPARTNAME");
        iPSDEFieldModel = this.getDEField("PSAPPPVPARTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5c5e\u7684\u5e94\u7528\u6570\u636e\u770b\u677f\u89c6\u56fe\u4e2d\u5177\u5907\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e8e4e6eed26fdeb20ac5dacfecf693e1");
        pSDEFGroupDetailModel.setName("PSAPPPORTALVIEWID");
        iPSDEFieldModel = this.getDEField("PSAPPPORTALVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("130ba40a719d2f5c2aee8839b6a78505");
        pSDEFGroupDetailModel.setName("PSSYSCSSID");
        iPSDEFieldModel = this.getDEField("PSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u5bb9\u5668\u754c\u9762\u6837\u5f0f\u8868\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6ab319d6a21cd5753e3f63b1d7687172");
        pSDEFGroupDetailModel.setName("PSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("PSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u5bb9\u5668\u754c\u9762\u6837\u5f0f\u8868\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ef4ff7f49b93a9f547618daed8f31b43");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u56fe\u7247\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b26e3fefc1805549babc09e589292cda");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u56fe\u7247\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f647a35e157a61cc01d7bba07bc5355d");
        pSDEFGroupDetailModel.setName("PSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("PSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("36c9ff786419d17c8ea91e9ad4041515");
        pSDEFGroupDetailModel.setName("PSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("PSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1a4f838958966e2171f7b1dc2b7231a9");
        pSDEFGroupDetailModel.setName("PSSYSUNIRESID");
        iPSDEFieldModel = this.getDEField("PSSYSUNIRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u8bbf\u95ee\u63a7\u5236\u7684\u7edf\u4e00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2a3202b6ab3cef2fca7ff8cb8ad30fb1");
        pSDEFGroupDetailModel.setName("PSSYSUNIRESNAME");
        iPSDEFieldModel = this.getDEField("PSSYSUNIRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u8bbf\u95ee\u63a7\u5236\u7684\u7edf\u4e00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cc248f0a3f002c988fe710f134778c99");
        pSDEFGroupDetailModel.setName("PSSYSTEMID");
        iPSDEFieldModel = this.getDEField("PSSYSTEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4b0ffc0c3002256d804b8f94d320c7c4");
        pSDEFGroupDetailModel.setName("PVPARTTYPE");
        iPSDEFieldModel = this.getDEField("PVPARTTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppPVPartTypesCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ba947fcbb6a0e21593ce1675a9ab533b");
        pSDEFGroupDetailModel.setName("SHOWTITLEBAR");
        iPSDEFieldModel = this.getDEField("SHOWTITLEBAR", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u662f\u5426\u8f93\u51fa\u6807\u9898\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e\uff0c\u5176\u5b83\u4e3a\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bf6a2a9e60f6293952efbd4e38c25146");
        pSDEFGroupDetailModel.setName("TITLE");
        iPSDEFieldModel = this.getDEField("TITLE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u6807\u9898\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5eb4f9054fbc2d79859dea2077315fe0");
        pSDEFGroupDetailModel.setName("TITLEBARCLOSEMODE");
        iPSDEFieldModel = this.getDEField("TITLEBARCLOSEMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTitleBarCloseModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u5bb9\u5668\u5206\u7ec4\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u5173\u95ed\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01117210e5d95534605428af5750cde9");
        pSDEFGroupDetailModel.setName("TITLEPSLANRESID");
        iPSDEFieldModel = this.getDEField("TITLEPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8c5ef56bcd7746419a6a0d4ba9e0cd86");
        pSDEFGroupDetailModel.setName("TITLEPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("TITLEPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ad27d8421064e9d5991644a2f01463b4");
        pSDEFGroupDetailModel.setName("USERTAG");
        iPSDEFieldModel = this.getDEField("USERTAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("637bb6ecfdb29e4e0707e646314290f2");
        pSDEFGroupDetailModel.setName("USERTAG2");
        iPSDEFieldModel = this.getDEField("USERTAG2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5a1a17258db301e0e3cbf8045e1fd9b2");
        pSDEFGroupDetailModel.setName("VALIDFLAG");
        iPSDEFieldModel = this.getDEField("VALIDFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColor3CodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0672736ad6c12adcba36fe7ced82d807");
        pSDEFGroupDetailModel.setName("WIDTH");
        iPSDEFieldModel = this.getDEField("WIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u5bbd\u5ea6\uff0c0\u4e3a\u81ea\u52a8\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u30100\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

