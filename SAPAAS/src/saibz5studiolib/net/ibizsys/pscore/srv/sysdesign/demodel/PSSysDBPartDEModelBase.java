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
package net.ibizsys.pscore.srv.sysdesign.demodel;

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
import net.ibizsys.pscore.srv.core.IPSDEFGroupModel;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupDetailModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupModel;
import net.ibizsys.pscore.srv.core.PSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDataEntityModelBase;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysdbpart.ac.PSSysDBPartDefaultACModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysdbpart.dataquery.PSSysDBPartDefaultDQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysdbpart.dataset.PSSysDBPartDefaultDSModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBPart;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartService;

public abstract class PSSysDBPartDEModelBase
extends PSDataEntityModelBase<PSSysDBPart> {
    private PSCoreSysModel pSCoreSysModel;
    private PSSysDBPartService pSSysDBPartService;

    public PSSysDBPartDEModelBase() throws Exception {
        this.setId("b14b9295ad19dd9878cd93c6ef1a7183");
        this.setName("PSSYSDBPART");
        this.setCodeName("PSSysDBPart");
        this.setTableName("T_SRFPSSYSDBPART");
        this.setViewName("v_PSSYSDBPART");
        this.setLogicName("\u6570\u636e\u770b\u677f\u6210\u5458");
        this.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u6a21\u578b\uff0c\u5b9a\u4e49\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u754c\u9762\u8868\u73b0\u53ca\u5904\u7406\u903b\u8f91\u3002\u652f\u6301\u591a\u79cd\u7c7b\u578b\uff0c\u652f\u6301\u591a\u5c42\u7ed3\u6784");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setEnableTempData(true);
        this.setUserTag("MODELV2");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDBPartDEModel", (IDataEntityModel)this);
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

    public PSSysDBPartService getRealService() {
        if (this.pSSysDBPartService == null) {
            try {
                this.pSSysDBPartService = (PSSysDBPartService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDBPartService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartService";
    }

    public PSSysDBPart createEntity() {
        return new PSSysDBPart();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("BL_POS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7a2c988a627d6a3649cd3031bb612e87");
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
            pSDEFieldModel.setId("4135f7f7fb376720bc330feb3c78a6d3");
            pSDEFieldModel.setName("COLID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5217\u6807\u8bc6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ColId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u5360\u4f4d\u5217\u6807\u8bc6\uff0c-1\u4e3a\u81ea\u52a8\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COLSPAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("90eb6ad6dd886185ba1706875698cdcd");
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
            pSDEFieldModel.setId("d4b296676f00364a29a4b3dcc8c52fb6");
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
            pSDEFieldModel.setId("3e47fe9ac89bfc32cb3c8747eee00f66");
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
            pSDEFieldModel.setId("bd393a9937d08461da85c16d83a848a4");
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
            pSDEFieldModel.setId("94d3b4437d55438ee9d79fd5e5cbd557");
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
            pSDEFieldModel.setId("c703d053387d4f5465b4d39e907993fa");
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
            pSDEFieldModel.setId("cbad1682b198f1a626a0c78d122025a1");
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
            pSDEFieldModel.setId("928ea6965b7369e1874130db7c45f65f");
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
            pSDEFieldModel.setId("0f0f0e11a955f8be6fb43b0214efc7f8");
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
            pSDEFieldModel.setId("d7ee654adacb5a36234ca0d8fe55f6db");
            pSDEFieldModel.setName("CONTENTTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u5bb9\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ContentTypeCodeListModel");
            pSDEFieldModel.setCodeName("ContentType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u76f4\u63a5\u5185\u5bb9\u9879\u7684\u5185\u5bb9\u7c7b\u578b");
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
            pSDEFieldModel.setId("a026f45d88a50b3c0a7266a8196cd6da");
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
            pSDEFieldModel.setId("9c58e6aded145b33a6638fcbe76bd5cb");
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
        object = this.createDEField("DBPARTTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0daf29e002b00e50d494b59ed762ce68");
            pSDEFieldModel.setName("DBPARTTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u90e8\u4ef6\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMultiFormDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DBPartTypesCodeListModel");
            pSDEFieldModel.setCodeName("DBPartType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7c7b\u578b");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DBPARTTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DBPARTTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DYNACLASS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a738cfc5ebb14bb8acd588df907a0602");
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
            pSDEFieldModel.setId("b0d9e4ccb85dd49f476f44a42a099ae1");
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
        object = this.createDEField("FLEXALIGN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("67cd09b72eecd0bd97602f0db7152ec1");
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
            pSDEFieldModel.setId("f7d8e0a50093d5d508cf95d13825bfb9");
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
            pSDEFieldModel.setId("79518a882e5773d3b5bc7c6942290028");
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
            pSDEFieldModel.setId("71fd86e65d5713c0e083dfb11feaf0bd");
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
            pSDEFieldModel.setId("d2ef32e9f32089c230dd0712895246e4");
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
            pSDEFieldModel.setId("4a5e73ba3db3c2a6fca2861dcd26b91a");
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
            pSDEFieldModel.setId("209dbc477c45cab197b2410b00135d75");
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
            pSDEFieldModel.setId("abca081b43e7a53256fb421662448d3b");
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
            pSDEFieldModel.setId("35d962521063bf0c76372c5c1d2c6acd");
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
            pSDEFieldModel.setId("a9c52f2cbdc3664d369e833597d4d600");
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
            pSDEFieldModel.setId("e4cf5539724eadee52e790e208294a4a");
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
        object = this.createDEField("NEWROWMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("04267e6c3887412e5dc74f8a871d11d9");
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
            pSDEFieldModel.setId("98289f98ceffa883945f8fd86fd3dd5b");
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
            pSDEFieldModel.setId("cd55ef8ede8cb21a95bd5a63102cb9fc");
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
            pSDEFieldModel.setId("6a2a8f3d8ab64791ae50d04d85d9221b");
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
            pSDEFieldModel.setId("5cffe1142100609912da96bf3d204956");
            pSDEFieldModel.setName("PORTLETTYPE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u90e8\u4ef6\u7c7b\u578b");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSPORTLET_PSSYSPORTLETID");
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
            pSDEFieldModel.setId("dd715c93a89779a439bab07d5ba766a0");
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
        object = this.createDEField("PPSSYSDBPARTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a3a794368d513667544922d95ab1bcc7");
            pSDEFieldModel.setName("PPSSYSDBPARTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7236\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSDBPART_PPSSYSDBPARTID");
            pSDEFieldModel.setLinkDEFName("PSSYSDBPARTID");
            pSDEFieldModel.setCodeName("PPSSysDBPartId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PPSSYSDBPARTID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PPSSYSDBPARTID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PPSSYSDBPARTNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ebb26504311d8879f7ca8914dc74b352");
            pSDEFieldModel.setName("PPSSYSDBPARTNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7236\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSDBPART_PPSSYSDBPARTID");
            pSDEFieldModel.setLinkDEFName("PSSYSDBPARTNAME");
            pSDEFieldModel.setCodeName("PPSSysDBPartName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u7236\u6210\u5458\u5bf9\u8c61");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PPSSYSDBPARTNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PPSSYSDBPARTNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PPSSYSDBPARTNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PPSSYSDBPARTNAME_LIKE");
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
            pSDEFieldModel.setId("877fd7a175d79751d67359db0b8a1327");
            pSDEFieldModel.setName("PSSYSCSSID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u754c\u9762\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSCSS_PSSYSCSSID");
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
            pSDEFieldModel.setId("71d51aedf113fda1134c1da30190cd56");
            pSDEFieldModel.setName("PSSYSCSSNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u754c\u9762\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSCSS_PSSYSCSSID");
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
        object = this.createDEField("PSSYSDASHBOARDID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("349584973be40adc6a548dd176f680d5");
            pSDEFieldModel.setName("PSSYSDASHBOARDID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u6570\u636e\u770b\u677f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSDASHBOARD_PSSYSDASHBOARDID");
            pSDEFieldModel.setLinkDEFName("PSSYSDASHBOARDID");
            pSDEFieldModel.setCodeName("PSSysDashboardId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDASHBOARDID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDASHBOARDID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDASHBOARDNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1c038e5215aa420aef7572838f8be006");
            pSDEFieldModel.setName("PSSYSDASHBOARDNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u6570\u636e\u770b\u677f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSDASHBOARD_PSSYSDASHBOARDID");
            pSDEFieldModel.setLinkDEFName("PSSYSDASHBOARDNAME");
            pSDEFieldModel.setCodeName("PSSysDashboardName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u6240\u5728\u7684\u6570\u636e\u770b\u677f\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDASHBOARDNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDASHBOARDNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDASHBOARDNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDASHBOARDNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDBPARTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("53ab597736ad72139eb9d609179f929d");
            pSDEFieldModel.setName("PSSYSDBPARTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u6570\u636e\u770b\u677f\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSSysDBPartId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDBPARTNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("362c12c7e1cab6e51d36c1b312670cc4");
            pSDEFieldModel.setName("PSSYSDBPARTNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u90e8\u4ef6\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSSysDBPartName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5728\u7684\u6570\u636e\u770b\u677f\u4e2d\u5177\u5907\u552f\u4e00\u6027");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDBPARTNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDBPARTNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDBPARTNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDBPARTNAME_LIKE");
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
            pSDEFieldModel.setId("bbb4927d06a5f4aa5f5ed2bc3e682535");
            pSDEFieldModel.setName("PSSYSIMAGEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u56fe\u7247");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSIMAGE_PSSYSIMAGEID");
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
            pSDEFieldModel.setId("a2f61f5538ae9ff75841ec4c778fd587");
            pSDEFieldModel.setName("PSSYSIMAGENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u56fe\u7247");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSIMAGE_PSSYSIMAGEID");
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
            pSDEFieldModel.setId("170a6a3584ea3629bd4e332865fac088");
            pSDEFieldModel.setName("PSSYSPFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSPFPLUGIN_PSSYSPFPLUGINID");
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
            pSDEFieldModel.setId("a76c320271f9d13ee44026a93ea9e484");
            pSDEFieldModel.setName("PSSYSPFPLUGINNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSPFPLUGIN_PSSYSPFPLUGINID");
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
            pSDEFieldModel.setId("51de47d36a46a16d6c8c539d4e4f87d9");
            pSDEFieldModel.setName("PSSYSPORTLETID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSPORTLET_PSSYSPORTLETID");
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
            pSDEFieldModel.setId("84e314dcf44573275a947268065a151d");
            pSDEFieldModel.setName("PSSYSPORTLETNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSPORTLET_PSSYSPORTLETID");
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
            pSDEFieldModel.setId("59424940fb6ceddb2ff21b55751b8578");
            pSDEFieldModel.setName("PSSYSRESOURCEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSRESOURCE_PSSYSRESOURCEID");
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
            pSDEFieldModel.setId("d763214f3b07212e156e7d63f25ad329");
            pSDEFieldModel.setName("PSSYSRESOURCENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSRESOURCE_PSSYSRESOURCEID");
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
        object = this.createDEField("PSSYSUNIRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("28b389983e523038d1443bf16fd69cf1");
            pSDEFieldModel.setName("PSSYSUNIRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSUNIRES_PSSYSUNIRESID");
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
            pSDEFieldModel.setId("452b9558d688e81d5b7b2076cad35151");
            pSDEFieldModel.setName("PSSYSUNIRESNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSSYSUNIRES_PSSYSUNIRESID");
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
        object = this.createDEField("RAWCONTENT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d55daf6e9596edbb202c26c8ffcac47a");
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
            pSDEFieldModel.setId("34fb67ec9378155569bf798900c6f058");
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
            pSDEFieldModel.setId("c8f7469723845824ff876d4d1b01e58c");
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
            pSDEFieldModel.setId("914608bb42715492403e3abacd9a117a");
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
            pSDEFieldModel.setId("777d93937c375210684f826aa44e4f45");
            pSDEFieldModel.setName("TEMPLATEMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u677f\u6a21\u5f0f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("TemplateMode");
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
            pSDEFieldModel.setId("644794f686e062bb937fa36a3cb533dd");
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
            pSDEFieldModel.setId("ab966d593a4045227c5b5a4decd80ac0");
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
            pSDEFieldModel.setId("d4c9fc4ad5ddc2007669a04de4b5817d");
            pSDEFieldModel.setName("TITLEPSLANRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSLANGUAGERES_TITLEPSLANRESID");
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
            pSDEFieldModel.setId("e0aca6b4ac7820add148f1837102d21a");
            pSDEFieldModel.setName("TITLEPSLANRESNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDBPART_PSLANGUAGERES_TITLEPSLANRESID");
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
            pSDEFieldModel.setId("512267665bf522bf608d2b13814c62f0");
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
            pSDEFieldModel.setId("253156775bed6e1ccf4821244218d34e");
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
            pSDEFieldModel.setId("5f5a8ced7b08213e9c0b93b8035cfa72");
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
        object = this.createDEField("USERTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("38f821a3b5d4a0c45b4597b7c2f8646a");
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
            pSDEFieldModel.setId("1dafb16fa77d501e76ad1d378f2efae9");
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
            pSDEFieldModel.setId("9f4979e8dfa99bc2dd4e032ae4c9bd3d");
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
            pSDEFieldModel.setId("d89bcf08b8ce6479fcd11c4268997090");
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
            pSDEFieldModel.setId("4eb0aa96a5b46a3a222d707c34c9df83");
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
        PSSysDBPartDefaultACModel pSSysDBPartDefaultACModel = new PSSysDBPartDefaultACModel();
        pSSysDBPartDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSSysDBPartDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSSysDBPartDefaultDSModel pSSysDBPartDefaultDSModel = new PSSysDBPartDefaultDSModel();
        pSSysDBPartDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysDBPartDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSSysDBPartDefaultDQModel pSSysDBPartDefaultDQModel = new PSSysDBPartDefaultDQModel();
        pSSysDBPartDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysDBPartDefaultDQModel);
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
        this.registerPDTDEView("EDITVIEW", "13916f421e75a5530167d0de48024ac1");
        this.registerPDTDEView("EDITVIEW:CONTAINER", "0846EFD1-A839-4D78-8A9E-960401026D9F");
        this.registerPDTDEView("EDITVIEW:RAWITEM", "39BC6003-9A17-498B-A0AE-FF5A2C0F283A");
        this.registerPDTDEView("EDITVIEW:SYSPORTLET", "50546225-CA3F-4BE0-AC49-358817241E96");
        this.registerPDTDEView("MDATAVIEW", "3b21dec8c5f7b2769c8e8425e78eb5df");
        this.registerPDTDEView("MPICKUPVIEW", "55eafffe0463c1794556987c33170a1e");
        this.registerPDTDEView("PICKUPVIEW", "6ce5579ea66978d6be2595a381ab503a");
        this.registerPDTDEView("REDIRECTVIEW", "dac9fee9deab94205519c0452b8a0139");
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
        dEDataSetCond2.setDEFName("PSSYSDBPARTNAME");
        dEDataSetCond2.setCondValue(string);
        dEDataSetCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)dEDataSetCond2);
    }

    @Override
    protected void onPreparePSDEFGroupModels() throws Exception {
        IPSDEFGroupModel iPSDEFGroupModel = this.preparePSDEFGroupModel_CONTAINER();
        if (iPSDEFGroupModel != null) {
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

    protected IPSDEFGroupModel preparePSDEFGroupModel_CONTAINER() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("CONTAINER");
        pSDEFGroupModel.setName("\u5e03\u5c40\u5bb9\u5668");
        pSDEFGroupModel.setUserTag("CONTAINER");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("67cd09b72eecd0bd97602f0db7152ec1");
        pSDEFGroupDetailModel.setName("FLEXALIGN");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("FLEXALIGN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FlexAlignCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010Flex\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u6307\u5b9a\u6a2a\u8f74\u5bf9\u9f50\u65b9\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("79518a882e5773d3b5bc7c6942290028");
        pSDEFGroupDetailModel.setName("FLEXDIR");
        iPSDEFieldModel = this.getDEField("FLEXDIR", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FlexLayoutDirCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010Flex\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u6307\u5b9a\u5e03\u5c40\u65b9\u5411");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4a5e73ba3db3c2a6fca2861dcd26b91a");
        pSDEFGroupDetailModel.setName("FLEXVALIGN");
        iPSDEFieldModel = this.getDEField("FLEXVALIGN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FlexVAlignCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010Flex\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u7eb5\u8f74\u5bf9\u9f50\u65b9\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a9c52f2cbdc3664d369e833597d4d600");
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
        pSDEFGroupDetailModel.setId("d7ee654adacb5a36234ca0d8fe55f6db");
        pSDEFGroupDetailModel.setName("CONTENTTYPE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CONTENTTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ContentTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u76f4\u63a5\u5185\u5bb9\u9879\u7684\u5185\u5bb9\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("35d962521063bf0c76372c5c1d2c6acd");
        pSDEFGroupDetailModel.setName("HTMLCONTENT");
        iPSDEFieldModel = this.getDEField("HTMLCONTENT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u5185\u5bb9\u7c7b\u578b\u4e3a\u3010Html\u5185\u5bb9\u3011\u65f6\u6307\u5b9aHtml\u5185\u5bb9\uff0c\u672a\u6307\u5b9a\u65f6\u4f7f\u7528\u6307\u5b9a\u7684\u7cfb\u7edf\u8d44\u6e90\u5b9a\u4e49\u5185\u5bb9");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("59424940fb6ceddb2ff21b55751b8578");
        pSDEFGroupDetailModel.setName("PSSYSRESOURCEID");
        iPSDEFieldModel = this.getDEField("PSSYSRESOURCEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u7c7b\u578b\u4e3a\u3010\u76f4\u63a5\u5185\u5bb9\u3011\u6216\u3010html\u5185\u5bb9\u3011\u65f6\u6307\u5b9a\u7cfb\u7edf\u9884\u7f6e\u7684\u8d44\u6e90\u5bf9\u8c61\u8fdb\u884c\u5185\u5bb9\u63d0\u4f9b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d763214f3b07212e156e7d63f25ad329");
        pSDEFGroupDetailModel.setName("PSSYSRESOURCENAME");
        iPSDEFieldModel = this.getDEField("PSSYSRESOURCENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u7c7b\u578b\u4e3a\u3010\u76f4\u63a5\u5185\u5bb9\u3011\u6216\u3010html\u5185\u5bb9\u3011\u65f6\u6307\u5b9a\u7cfb\u7edf\u9884\u7f6e\u7684\u8d44\u6e90\u5bf9\u8c61\u8fdb\u884c\u5185\u5bb9\u63d0\u4f9b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d55daf6e9596edbb202c26c8ffcac47a");
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
        pSDEFGroupDetailModel.setId("51de47d36a46a16d6c8c539d4e4f87d9");
        pSDEFGroupDetailModel.setName("PSSYSPORTLETID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSSYSPORTLETID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u9879\u6307\u5b9a\u5f15\u7528\u7684\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("84e314dcf44573275a947268065a151d");
        pSDEFGroupDetailModel.setName("PSSYSPORTLETNAME");
        iPSDEFieldModel = this.getDEField("PSSYSPORTLETNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u9879\u6307\u5b9a\u5f15\u7528\u7684\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9f4979e8dfa99bc2dd4e032ae4c9bd3d");
        pSDEFGroupDetailModel.setName("VALIDFLAG");
        iPSDEFieldModel = this.getDEField("VALIDFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColor3CodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel__DEFAULT() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("_DEFAULT");
        pSDEFGroupModel.setName("\u901a\u7528");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7a2c988a627d6a3649cd3031bb612e87");
        pSDEFGroupDetailModel.setName("BL_POS");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("BL_POS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.BorderLayoutPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8fb9\u7f18\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u7684\u4f4d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4135f7f7fb376720bc330feb3c78a6d3");
        pSDEFGroupDetailModel.setName("COLID");
        iPSDEFieldModel = this.getDEField("COLID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u5360\u4f4d\u5217\u6807\u8bc6\uff0c-1\u4e3a\u81ea\u52a8\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("90eb6ad6dd886185ba1706875698cdcd");
        pSDEFGroupDetailModel.setName("COLSPAN");
        iPSDEFieldModel = this.getDEField("COLSPAN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u7684\u5360\u4f4d\u5217\u6570\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u30101\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d4b296676f00364a29a4b3dcc8c52fb6");
        pSDEFGroupDetailModel.setName("COL_LG");
        iPSDEFieldModel = this.getDEField("COL_LG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u5927\u578b\u754c\u9762\u7684\u5217\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3e47fe9ac89bfc32cb3c8747eee00f66");
        pSDEFGroupDetailModel.setName("COL_LG_OS");
        iPSDEFieldModel = this.getDEField("COL_LG_OS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u5927\u578b\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bd393a9937d08461da85c16d83a848a4");
        pSDEFGroupDetailModel.setName("COL_MD");
        iPSDEFieldModel = this.getDEField("COL_MD", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u4e2d\u578b\u754c\u9762\u7684\u5217\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("94d3b4437d55438ee9d79fd5e5cbd557");
        pSDEFGroupDetailModel.setName("COL_MD_OS");
        iPSDEFieldModel = this.getDEField("COL_MD_OS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u4e2d\u578b\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c703d053387d4f5465b4d39e907993fa");
        pSDEFGroupDetailModel.setName("COL_SM");
        iPSDEFieldModel = this.getDEField("COL_SM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u5c0f\u578b\u754c\u9762\u7684\u5217\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cbad1682b198f1a626a0c78d122025a1");
        pSDEFGroupDetailModel.setName("COL_SM_OS");
        iPSDEFieldModel = this.getDEField("COL_SM_OS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u5c0f\u578b\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("928ea6965b7369e1874130db7c45f65f");
        pSDEFGroupDetailModel.setName("COL_XS");
        iPSDEFieldModel = this.getDEField("COL_XS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u8d85\u5c0f\u754c\u9762\u7684\u5217\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0f0f0e11a955f8be6fb43b0214efc7f8");
        pSDEFGroupDetailModel.setName("COL_XS_OS");
        iPSDEFieldModel = this.getDEField("COL_XS_OS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u6805\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u5728\u8d85\u5c0f\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0daf29e002b00e50d494b59ed762ce68");
        pSDEFGroupDetailModel.setName("DBPARTTYPE");
        iPSDEFieldModel = this.getDEField("DBPARTTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DBPartTypesCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("71fd86e65d5713c0e083dfb11feaf0bd");
        pSDEFGroupDetailModel.setName("FLEXGROW");
        iPSDEFieldModel = this.getDEField("FLEXGROW", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010Flex\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u5ef6\u5c55\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("abca081b43e7a53256fb421662448d3b");
        pSDEFGroupDetailModel.setName("HEIGHT");
        iPSDEFieldModel = this.getDEField("HEIGHT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u9ad8\u5ea6\uff0c0\u4e3a\u81ea\u52a8\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e\uff0c\u5176\u5b83\u4e3a\u30100\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e4cf5539724eadee52e790e208294a4a");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("04267e6c3887412e5dc74f8a871d11d9");
        pSDEFGroupDetailModel.setName("NEWROWMODE");
        iPSDEFieldModel = this.getDEField("NEWROWMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u770b\u677f\u6210\u5458\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u662f\u5426\u5f3a\u5236\u65b0\u8d77\u4e00\u884c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a3a794368d513667544922d95ab1bcc7");
        pSDEFGroupDetailModel.setName("PPSSYSDBPARTID");
        iPSDEFieldModel = this.getDEField("PPSSYSDBPARTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("877fd7a175d79751d67359db0b8a1327");
        pSDEFGroupDetailModel.setName("PSSYSCSSID");
        iPSDEFieldModel = this.getDEField("PSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u5bb9\u5668\u754c\u9762\u6837\u5f0f\u8868\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("71d51aedf113fda1134c1da30190cd56");
        pSDEFGroupDetailModel.setName("PSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("PSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u5bb9\u5668\u754c\u9762\u6837\u5f0f\u8868\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("362c12c7e1cab6e51d36c1b312670cc4");
        pSDEFGroupDetailModel.setName("PSSYSDBPARTNAME");
        iPSDEFieldModel = this.getDEField("PSSYSDBPARTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5728\u7684\u6570\u636e\u770b\u677f\u4e2d\u5177\u5907\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("349584973be40adc6a548dd176f680d5");
        pSDEFGroupDetailModel.setName("PSSYSDASHBOARDID");
        iPSDEFieldModel = this.getDEField("PSSYSDASHBOARDID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bbb4927d06a5f4aa5f5ed2bc3e682535");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u56fe\u7247\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a2f61f5538ae9ff75841ec4c778fd587");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u56fe\u7247\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("170a6a3584ea3629bd4e332865fac088");
        pSDEFGroupDetailModel.setName("PSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("PSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a76c320271f9d13ee44026a93ea9e484");
        pSDEFGroupDetailModel.setName("PSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("PSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("28b389983e523038d1443bf16fd69cf1");
        pSDEFGroupDetailModel.setName("PSSYSUNIRESID");
        iPSDEFieldModel = this.getDEField("PSSYSUNIRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u8bbf\u95ee\u63a7\u5236\u7684\u7edf\u4e00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("452b9558d688e81d5b7b2076cad35151");
        pSDEFGroupDetailModel.setName("PSSYSUNIRESNAME");
        iPSDEFieldModel = this.getDEField("PSSYSUNIRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u8bbf\u95ee\u63a7\u5236\u7684\u7edf\u4e00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c8f7469723845824ff876d4d1b01e58c");
        pSDEFGroupDetailModel.setName("SHOWTITLEBAR");
        iPSDEFieldModel = this.getDEField("SHOWTITLEBAR", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u662f\u5426\u8f93\u51fa\u6807\u9898\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e\uff0c\u5176\u5b83\u4e3a\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("644794f686e062bb937fa36a3cb533dd");
        pSDEFGroupDetailModel.setName("TITLE");
        iPSDEFieldModel = this.getDEField("TITLE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u6807\u9898\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab966d593a4045227c5b5a4decd80ac0");
        pSDEFGroupDetailModel.setName("TITLEBARCLOSEMODE");
        iPSDEFieldModel = this.getDEField("TITLEBARCLOSEMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTitleBarCloseModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u5bb9\u5668\u5206\u7ec4\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u5173\u95ed\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d4c9fc4ad5ddc2007669a04de4b5817d");
        pSDEFGroupDetailModel.setName("TITLEPSLANRESID");
        iPSDEFieldModel = this.getDEField("TITLEPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e0aca6b4ac7820add148f1837102d21a");
        pSDEFGroupDetailModel.setName("TITLEPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("TITLEPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u770b\u677f\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u95e8\u6237\u90e8\u4ef6\u9879\u4f7f\u7528\u5f15\u7528\u95e8\u6237\u90e8\u4ef6\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("38f821a3b5d4a0c45b4597b7c2f8646a");
        pSDEFGroupDetailModel.setName("USERTAG");
        iPSDEFieldModel = this.getDEField("USERTAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1dafb16fa77d501e76ad1d378f2efae9");
        pSDEFGroupDetailModel.setName("USERTAG2");
        iPSDEFieldModel = this.getDEField("USERTAG2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4eb0aa96a5b46a3a222d707c34c9df83");
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

