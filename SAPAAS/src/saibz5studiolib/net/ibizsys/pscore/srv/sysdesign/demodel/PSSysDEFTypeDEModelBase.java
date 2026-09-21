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
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysdeftype.ac.PSSysDEFTypeDefaultACModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysdeftype.dataquery.PSSysDEFTypeCurSysDQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysdeftype.dataquery.PSSysDEFTypeDefaultDQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysdeftype.dataset.PSSysDEFTypeCurSysDSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysdeftype.dataset.PSSysDEFTypeDefaultDSModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDEFType;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDEFTypeService;

public abstract class PSSysDEFTypeDEModelBase
extends PSDataEntityModelBase<PSSysDEFType> {
    private PSCoreSysModel pSCoreSysModel;
    private PSSysDEFTypeService pSSysDEFTypeService;

    public PSSysDEFTypeDEModelBase() throws Exception {
        this.setId("eec59019786b1129021303a5c1fd4ca2");
        this.setName("PSSYSDEFTYPE");
        this.setCodeName("PSSysDEFType");
        this.setTableName("T_SRFPSSYSDEFTYPE");
        this.setViewName("v_PSSYSDEFTYPE");
        this.setLogicName("\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91");
        this.setMemo("\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u6a21\u578b\uff0c\u5b9a\u4e49\u7cfb\u7edf\u7ea7\u522b\u7684\u5c5e\u6027\u7c7b\u578b\u5904\u7406\u903b\u8f91\u5bf9\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u8fdb\u884c\u8986\u76d6\uff0c\u903b\u8f91\u503c\u672a\u914d\u7f6e\u65f6\u5c06\u9ed8\u8ba4\u4f7f\u7528\u9884\u7f6e\u903b\u8f91\u7684\u5b9a\u4e49");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setUserTag("MODELV2");
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysDEFTypeDEModel", (IDataEntityModel)this);
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

    public PSSysDEFTypeService getRealService() {
        if (this.pSSysDEFTypeService == null) {
            try {
                this.pSSysDEFTypeService = (PSSysDEFTypeService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysDEFTypeService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysDEFTypeService";
    }

    public PSSysDEFType createEntity() {
        return new PSSysDEFType();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1408c213525c435f69f58fdd0ed2a799");
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
            pSDEFieldModel.setId("f53b787dd6fbb6ef2917233e0d8e27bf");
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
        object = this.createDEField("EDITORHEIGHT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7626b99c543842586f3d8b928af806ea");
            pSDEFieldModel.setName("EDITORHEIGHT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u9ad8\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("EditorHeight");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u7f16\u8f91\u5668\u9ad8\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EDITORTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("841aa39a6c1447a9d5bd2e00de6f1cd2");
            pSDEFieldModel.setName("EDITORTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormItemEditorCodeListModel");
            pSDEFieldModel.setCodeName("EditorType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u7f16\u8f91\u5668\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.setLength(40);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EDITORTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EDITORTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EDITORWIDTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("52cd457da3760b242d0b71232af1d220");
            pSDEFieldModel.setName("EDITORWIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u5bbd\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("EditorWidth");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u7f16\u8f91\u5668\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FIELDS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1526d90826274f6fed78fbc9726bc2b8");
            pSDEFieldModel.setName("FIELDS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5c5e\u6027\u9009\u62e9\u8868\u8fbe\u5f0f");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Fields");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u5c5e\u6027\u9009\u62e9\u8868\u683c\u5f0f\uff0c\u5b9a\u4e49\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u9488\u5bf9\u7684\u76ee\u6807\u5c5e\u6027\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.setLength(2000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("GRIDCOLALIGN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("dbd81c14f1b195259cb971272022d650");
            pSDEFieldModel.setName("GRIDCOLALIGN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8868\u683c\u5217\u5bf9\u9f50");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridColAlignCodeListModel");
            pSDEFieldModel.setCodeName("GridColAlign");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_GRIDCOLALIGN_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_GRIDCOLALIGN_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("GRIDCOLCLMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6b524a2478b6a68de19059ae13220fc8");
            pSDEFieldModel.setName("GRIDCOLCLMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8868\u683c\u5217\u4ee3\u7801\u503c\u8f6c\u6362");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.CLConvertModesCodeListModel");
            pSDEFieldModel.setCodeName("GridColCLMode");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_GRIDCOLCLMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_GRIDCOLCLMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("GRIDCOLWIDTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fff849341fb85444eb94dd434f4a6f9a");
            pSDEFieldModel.setName("GRIDCOLWIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u5217\u5bbd");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("GridColWidth");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("JSFORMAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("98bf01d747ad269292223c467d8bbd1a");
            pSDEFieldModel.setName("JSFORMAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("JS\u683c\u5f0f\u5316");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("JSFormat");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4JS\u683c\u5f0f\u5316\u4e32\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MAXVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7f6d1fe1805963663f4b596948624ffa");
            pSDEFieldModel.setName("MAXVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6700\u5927\u503c");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MaxValue");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u6700\u5927\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MBEDITORHEIGHT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3445946e1c82e5586dad2ce4028029bc");
            pSDEFieldModel.setName("MBEDITORHEIGHT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u79fb\u52a8\u7aef\u7f16\u8f91\u5668\u9ad8\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MBEditorHeight");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u79fb\u52a8\u7aef\u7f16\u8f91\u5668\u9ad8\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MBEDITORTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c8fd94c85509f2de52674cf0e67b06a6");
            pSDEFieldModel.setName("MBEDITORTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u79fb\u52a8\u7aef\u7f16\u8f91\u5668\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.MobFormItemEditorCodeListModel");
            pSDEFieldModel.setCodeName("MBEditorType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u79fb\u52a8\u7aef\u7f16\u8f91\u5668\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.setLength(40);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MBEDITORTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MBEDITORTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MBEDITORWIDTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("54b1118e6f5c6e33371f46f0f217b7e5");
            pSDEFieldModel.setName("MBEDITORWIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u79fb\u52a8\u7aef\u7f16\u8f91\u5668\u5bbd\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MBEditorWidth");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u79fb\u52a8\u7aef\u7f16\u8f91\u5668\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9bf50047ac858d169c749decb9f7bc25");
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
        object = this.createDEField("MINSTRLENGTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cdbbd3778cee61830a0bb15b90634265");
            pSDEFieldModel.setName("MINSTRLENGTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6700\u5c0f\u5b57\u7b26\u957f\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MinStrLength");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u6700\u5c0f\u5b57\u7b26\u4e32\u957f\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MINVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f6a4e8ad014e8a6f911f3932ffe095c4");
            pSDEFieldModel.setName("MINVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6700\u5c0f\u503c");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MinValue");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u6700\u5c0f\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ORDERVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1c162e1f796df36b652c34974dd5d200");
            pSDEFieldModel.setName("ORDERVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5904\u7406\u6b21\u5e8f");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("OrderValue");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PRECISION2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d03773f3c7da531491fe735d214f014a");
            pSDEFieldModel.setName("PRECISION2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6d6e\u70b9\u7cbe\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Precision2");
            pSDEFieldModel.setServiceCodeName("Precision");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u6d6e\u70b9\u7cbe\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSCODELISTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8b135090af9b64d4a9af2a1bc9c8c206");
            pSDEFieldModel.setName("PSCODELISTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u4ee3\u7801\u8868");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDEFTYPE_PSCODELIST_PSCODELISTID");
            pSDEFieldModel.setLinkDEFName("PSCODELISTID");
            pSDEFieldModel.setCodeName("PSCodeListId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSCODELISTID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSCODELISTID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSCODELISTNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("493790317c51d92caab431e0cc61190d");
            pSDEFieldModel.setName("PSCODELISTNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u4ee3\u7801\u8868");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDEFTYPE_PSCODELIST_PSCODELISTID");
            pSDEFieldModel.setLinkDEFName("PSCODELISTNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSCodeListName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u4ee3\u7801\u8868\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSCODELISTNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSCODELISTNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSCODELISTNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSCODELISTNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFTYPEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("49cdc6be5a06eb000a0858477626a725");
            pSDEFieldModel.setName("PSDEFTYPEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e73\u53f0\u9884\u7f6e\u903b\u8f91");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDEFTYPE_PSDEFTYPE_PSDEFTYPEID");
            pSDEFieldModel.setLinkDEFName("PSDEFTYPEID");
            pSDEFieldModel.setCodeName("PSDEFTypeId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFTYPEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFTYPEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFTYPENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0c226a528f70518fa3c950e96df6d17e");
            pSDEFieldModel.setName("PSDEFTYPENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e73\u53f0\u9884\u7f6e\u903b\u8f91");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDEFTYPE_PSDEFTYPE_PSDEFTYPEID");
            pSDEFieldModel.setLinkDEFName("PSDEFTYPENAME");
            pSDEFieldModel.setCodeName("PSDEFTypeName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u91cd\u5199\u7684\u5e73\u53f0\u9884\u7f6e\u903b\u8f91");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFTYPENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFTYPENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFTYPENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFTYPENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDEFTYPEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cbf247b2b9ee9717484c729b3aa4255c");
            pSDEFieldModel.setName("PSSYSDEFTYPEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u5b9a\u4e49\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSSysDEFTypeId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDEFTYPENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5fa5587661626ff6e88bceff3244b658");
            pSDEFieldModel.setName("PSSYSDEFTYPENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSSysDEFTypeName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u7684\u540d\u79f0");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDEFTYPENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDEFTYPENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDEFTYPENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDEFTYPENAME_LIKE");
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
            pSDEFieldModel.setId("589a4f3902e316dbb037724c25f47c77");
            pSDEFieldModel.setName("PSSYSTEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDEFTYPE_PSSYSTEM_PSSYSTEMID");
            pSDEFieldModel.setLinkDEFName("PSSYSTEMID");
            pSDEFieldModel.setUserInputMode(1);
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
            pSDEFieldModel.setId("13371c9f746b4d2d97a46228b49b1748");
            pSDEFieldModel.setName("PSSYSTEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDEFTYPE_PSSYSTEM_PSSYSTEMID");
            pSDEFieldModel.setLinkDEFName("PSSYSTEMNAME");
            pSDEFieldModel.setUserInputMode(1);
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
        object = this.createDEField("PSSYSUNITID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5b62bf1bcbd7190b23a6349c1c282af6");
            pSDEFieldModel.setName("PSSYSUNITID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u5355\u4f4d");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDEFTYPE_PSSYSUNIT_PSSYSUNITID");
            pSDEFieldModel.setLinkDEFName("PSSYSUNITID");
            pSDEFieldModel.setCodeName("PSSysUnitId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSUNITID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSUNITID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSUNITNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bd860c3705bf35ef372f6d7499054917");
            pSDEFieldModel.setName("PSSYSUNITNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u5355\u4f4d");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDEFTYPE_PSSYSUNIT_PSSYSUNITID");
            pSDEFieldModel.setLinkDEFName("PSSYSUNITNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysUnitName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u7cfb\u7edf\u5355\u4f4d\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSUNITNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSUNITNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSUNITNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSUNITNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSVALUERULEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a9935be3fb849338443b3caeed02e03b");
            pSDEFieldModel.setName("PSSYSVALUERULEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u503c\u89c4\u5219");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDEFTYPE_PSSYSVALUERULE_PSSYSVALUERULEID");
            pSDEFieldModel.setLinkDEFName("PSSYSVALUERULEID");
            pSDEFieldModel.setCodeName("PSSysValueRuleId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSVALUERULEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSVALUERULEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSVALUERULENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("988e7c2fd23e891f52d4179b945b3c88");
            pSDEFieldModel.setName("PSSYSVALUERULENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u503c\u89c4\u5219");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSDEFTYPE_PSSYSVALUERULE_PSSYSVALUERULEID");
            pSDEFieldModel.setLinkDEFName("PSSYSVALUERULENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysValueRuleName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u7cfb\u7edf\u503c\u89c4\u5219\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSVALUERULENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSVALUERULENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSVALUERULENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSVALUERULENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PYFORMAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("af6aab571c872fbc7efe102de505d299");
            pSDEFieldModel.setName("PYFORMAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("PY\u683c\u5f0f\u5316");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PYFormat");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4PY\u683c\u5f0f\u5316\u4e32\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SEARCHEDITORHEIGHT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("71e55d48ef04ac90f3523bb43a27dfa6");
            pSDEFieldModel.setName("SEARCHEDITORHEIGHT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u641c\u7d22\u7f16\u8f91\u5668\u9ad8\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("SearchEditorHeight");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u641c\u7d22\u7f16\u8f91\u5668\u9ad8\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SEARCHEDITORTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("db19f469387ccfce1b93817342d8aaad");
            pSDEFieldModel.setName("SEARCHEDITORTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u641c\u7d22\u7f16\u8f91\u5668\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormItemEditorCodeListModel");
            pSDEFieldModel.setCodeName("SearchEditorType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u641c\u7d22\u7f16\u8f91\u5668\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.setLength(40);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SEARCHEDITORTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SEARCHEDITORTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SEARCHEDITORWIDTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("afb8990a005ef53d095418cfc5fae554");
            pSDEFieldModel.setName("SEARCHEDITORWIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u641c\u7d22\u7f16\u8f91\u5668\u5bbd\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("SearchEditorWidth");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u641c\u7d22\u7f16\u8f91\u5668\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SEARCHMBEDITORHEIGHT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2c87df4b4b3c8ecabc072ffdf0df0402");
            pSDEFieldModel.setName("SEARCHMBEDITORHEIGHT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u641c\u7d22\u79fb\u52a8\u7aef\u7f16\u8f91\u5668\u9ad8\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("SearchMBEditorHeight");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u79fb\u52a8\u7aef\u641c\u7d22\u7f16\u8f91\u5668\u9ad8\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SEARCHMBEDITORTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("56bef3e17498ed2edf8326a4c2ea6de4");
            pSDEFieldModel.setName("SEARCHMBEDITORTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u641c\u7d22\u79fb\u52a8\u7aef\u7f16\u8f91\u5668\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.MobFormItemEditorCodeListModel");
            pSDEFieldModel.setCodeName("SearchMBEditorType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u79fb\u52a8\u7aef\u641c\u7d22\u7f16\u8f91\u5668\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.setLength(40);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SEARCHMBEDITORTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SEARCHMBEDITORTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SEARCHMBEDITORWIDTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("92ededb47fb5871870a873470b65391f");
            pSDEFieldModel.setName("SEARCHMBEDITORWIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u641c\u7d22\u79fb\u52a8\u7aef\u7f16\u8f91\u5668\u5bbd\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("SearchMBEditorWidth");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u79fb\u52a8\u7aef\u641c\u7d22\u7f16\u8f91\u5668\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("STDDATATYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6d789a96b26fb5f26e218dbe97145901");
            pSDEFieldModel.setName("STDDATATYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u51c6\u6570\u636e\u7c7b\u578b");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.StdDataTypeCodeListModel");
            pSDEFieldModel.setCodeName("StdDataType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u6807\u51c6\u6570\u636e\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u9ed8\u8ba4\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u914d\u7f6e");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_STDDATATYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_STDDATATYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("STRLENGTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1130d0c4c9cb45863a777666f708f677");
            pSDEFieldModel.setName("STRLENGTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u957f\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("StrLength");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u5b57\u7b26\u4e32\u957f\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TSFORMAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2bff7b115c69ce799840907bf593ef8a");
            pSDEFieldModel.setName("TSFORMAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("TS\u683c\u5f0f\u5316");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("TSFormat");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4TS\u683c\u5f0f\u5316\u4e32\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bfa8481e3a2f7a77ec97bc45aa050165");
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
            pSDEFieldModel.setId("c34be1d8d5e480679d8eed96036dd1bf");
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
        object = this.createDEField("VALIDFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8e90ff14ac9c857f9a7e4ea1d058d7d6");
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
        object = this.createDEField("VALUEFORMAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a4d254d2c398e9b04ba07782a342ed15");
            pSDEFieldModel.setName("VALUEFORMAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u503c\u683c\u5f0f\u5316");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ValueFormat");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u503c\u683c\u5f0f\u5316\u4e32\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSSysDEFTypeDefaultACModel pSSysDEFTypeDefaultACModel = new PSSysDEFTypeDefaultACModel();
        pSSysDEFTypeDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSSysDEFTypeDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSSysDEFTypeCurSysDSModel pSSysDEFTypeCurSysDSModel = new PSSysDEFTypeCurSysDSModel();
        pSSysDEFTypeCurSysDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysDEFTypeCurSysDSModel);
        PSSysDEFTypeDefaultDSModel pSSysDEFTypeDefaultDSModel = new PSSysDEFTypeDefaultDSModel();
        pSSysDEFTypeDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysDEFTypeDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSSysDEFTypeCurSysDQModel pSSysDEFTypeCurSysDQModel = new PSSysDEFTypeCurSysDQModel();
        pSSysDEFTypeCurSysDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysDEFTypeCurSysDQModel);
        PSSysDEFTypeDefaultDQModel pSSysDEFTypeDefaultDQModel = new PSSysDEFTypeDefaultDQModel();
        pSSysDEFTypeDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysDEFTypeDefaultDQModel);
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
        this.registerPDTDEView("MDATAVIEW", "348925f7deff489c2fd87523670c8d98");
        this.registerPDTDEView("MPICKUPVIEW", "2181de7bad62ea06f273bfb6e773488f");
        this.registerPDTDEView("PICKUPVIEW", "cd32f5f632bfc9ba08141cb0770feef3");
        this.registerPDTDEView("REDIRECTVIEW", "eef904661ad2476c8b377a3316127360");
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
        dEDataSetCond2.setDEFName("PSSYSDEFTYPENAME");
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
        pSDEFGroupDetailModel.setId("7626b99c543842586f3d8b928af806ea");
        pSDEFGroupDetailModel.setName("EDITORHEIGHT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("EDITORHEIGHT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u7f16\u8f91\u5668\u9ad8\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("841aa39a6c1447a9d5bd2e00de6f1cd2");
        pSDEFGroupDetailModel.setName("EDITORTYPE");
        iPSDEFieldModel = this.getDEField("EDITORTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormItemEditorCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u7f16\u8f91\u5668\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("52cd457da3760b242d0b71232af1d220");
        pSDEFGroupDetailModel.setName("EDITORWIDTH");
        iPSDEFieldModel = this.getDEField("EDITORWIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u7f16\u8f91\u5668\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1526d90826274f6fed78fbc9726bc2b8");
        pSDEFGroupDetailModel.setName("FIELDS");
        iPSDEFieldModel = this.getDEField("FIELDS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u5c5e\u6027\u9009\u62e9\u8868\u683c\u5f0f\uff0c\u5b9a\u4e49\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u9488\u5bf9\u7684\u76ee\u6807\u5c5e\u6027\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("dbd81c14f1b195259cb971272022d650");
        pSDEFGroupDetailModel.setName("GRIDCOLALIGN");
        iPSDEFieldModel = this.getDEField("GRIDCOLALIGN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridColAlignCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("98bf01d747ad269292223c467d8bbd1a");
        pSDEFGroupDetailModel.setName("JSFORMAT");
        iPSDEFieldModel = this.getDEField("JSFORMAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4JS\u683c\u5f0f\u5316\u4e32\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3445946e1c82e5586dad2ce4028029bc");
        pSDEFGroupDetailModel.setName("MBEDITORHEIGHT");
        iPSDEFieldModel = this.getDEField("MBEDITORHEIGHT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u79fb\u52a8\u7aef\u7f16\u8f91\u5668\u9ad8\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c8fd94c85509f2de52674cf0e67b06a6");
        pSDEFGroupDetailModel.setName("MBEDITORTYPE");
        iPSDEFieldModel = this.getDEField("MBEDITORTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.MobFormItemEditorCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u79fb\u52a8\u7aef\u7f16\u8f91\u5668\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("54b1118e6f5c6e33371f46f0f217b7e5");
        pSDEFGroupDetailModel.setName("MBEDITORWIDTH");
        iPSDEFieldModel = this.getDEField("MBEDITORWIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u79fb\u52a8\u7aef\u7f16\u8f91\u5668\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7f6d1fe1805963663f4b596948624ffa");
        pSDEFGroupDetailModel.setName("MAXVALUE");
        iPSDEFieldModel = this.getDEField("MAXVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u6700\u5927\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9bf50047ac858d169c749decb9f7bc25");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cdbbd3778cee61830a0bb15b90634265");
        pSDEFGroupDetailModel.setName("MINSTRLENGTH");
        iPSDEFieldModel = this.getDEField("MINSTRLENGTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u6700\u5c0f\u5b57\u7b26\u4e32\u957f\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f6a4e8ad014e8a6f911f3932ffe095c4");
        pSDEFGroupDetailModel.setName("MINVALUE");
        iPSDEFieldModel = this.getDEField("MINVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u6700\u5c0f\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1c162e1f796df36b652c34974dd5d200");
        pSDEFGroupDetailModel.setName("ORDERVALUE");
        iPSDEFieldModel = this.getDEField("ORDERVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8b135090af9b64d4a9af2a1bc9c8c206");
        pSDEFGroupDetailModel.setName("PSCODELISTID");
        iPSDEFieldModel = this.getDEField("PSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u4ee3\u7801\u8868\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("493790317c51d92caab431e0cc61190d");
        pSDEFGroupDetailModel.setName("PSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("PSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u4ee3\u7801\u8868\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49cdc6be5a06eb000a0858477626a725");
        pSDEFGroupDetailModel.setName("PSDEFTYPEID");
        iPSDEFieldModel = this.getDEField("PSDEFTYPEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u91cd\u5199\u7684\u5e73\u53f0\u9884\u7f6e\u903b\u8f91");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0c226a528f70518fa3c950e96df6d17e");
        pSDEFGroupDetailModel.setName("PSDEFTYPENAME");
        iPSDEFieldModel = this.getDEField("PSDEFTYPENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u91cd\u5199\u7684\u5e73\u53f0\u9884\u7f6e\u903b\u8f91");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5fa5587661626ff6e88bceff3244b658");
        pSDEFGroupDetailModel.setName("PSSYSDEFTYPENAME");
        iPSDEFieldModel = this.getDEField("PSSYSDEFTYPENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u7684\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5b62bf1bcbd7190b23a6349c1c282af6");
        pSDEFGroupDetailModel.setName("PSSYSUNITID");
        iPSDEFieldModel = this.getDEField("PSSYSUNITID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u7cfb\u7edf\u5355\u4f4d\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bd860c3705bf35ef372f6d7499054917");
        pSDEFGroupDetailModel.setName("PSSYSUNITNAME");
        iPSDEFieldModel = this.getDEField("PSSYSUNITNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u7cfb\u7edf\u5355\u4f4d\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a9935be3fb849338443b3caeed02e03b");
        pSDEFGroupDetailModel.setName("PSSYSVALUERULEID");
        iPSDEFieldModel = this.getDEField("PSSYSVALUERULEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u7cfb\u7edf\u503c\u89c4\u5219\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("988e7c2fd23e891f52d4179b945b3c88");
        pSDEFGroupDetailModel.setName("PSSYSVALUERULENAME");
        iPSDEFieldModel = this.getDEField("PSSYSVALUERULENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u7cfb\u7edf\u503c\u89c4\u5219\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("589a4f3902e316dbb037724c25f47c77");
        pSDEFGroupDetailModel.setName("PSSYSTEMID");
        iPSDEFieldModel = this.getDEField("PSSYSTEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("13371c9f746b4d2d97a46228b49b1748");
        pSDEFGroupDetailModel.setName("PSSYSTEMNAME");
        iPSDEFieldModel = this.getDEField("PSSYSTEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d03773f3c7da531491fe735d214f014a");
        pSDEFGroupDetailModel.setName("PRECISION2");
        iPSDEFieldModel = this.getDEField("PRECISION2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u6d6e\u70b9\u7cbe\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("71e55d48ef04ac90f3523bb43a27dfa6");
        pSDEFGroupDetailModel.setName("SEARCHEDITORHEIGHT");
        iPSDEFieldModel = this.getDEField("SEARCHEDITORHEIGHT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u641c\u7d22\u7f16\u8f91\u5668\u9ad8\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("db19f469387ccfce1b93817342d8aaad");
        pSDEFGroupDetailModel.setName("SEARCHEDITORTYPE");
        iPSDEFieldModel = this.getDEField("SEARCHEDITORTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormItemEditorCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u641c\u7d22\u7f16\u8f91\u5668\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("afb8990a005ef53d095418cfc5fae554");
        pSDEFGroupDetailModel.setName("SEARCHEDITORWIDTH");
        iPSDEFieldModel = this.getDEField("SEARCHEDITORWIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u641c\u7d22\u7f16\u8f91\u5668\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2c87df4b4b3c8ecabc072ffdf0df0402");
        pSDEFGroupDetailModel.setName("SEARCHMBEDITORHEIGHT");
        iPSDEFieldModel = this.getDEField("SEARCHMBEDITORHEIGHT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u79fb\u52a8\u7aef\u641c\u7d22\u7f16\u8f91\u5668\u9ad8\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("56bef3e17498ed2edf8326a4c2ea6de4");
        pSDEFGroupDetailModel.setName("SEARCHMBEDITORTYPE");
        iPSDEFieldModel = this.getDEField("SEARCHMBEDITORTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.MobFormItemEditorCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u79fb\u52a8\u7aef\u641c\u7d22\u7f16\u8f91\u5668\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("92ededb47fb5871870a873470b65391f");
        pSDEFGroupDetailModel.setName("SEARCHMBEDITORWIDTH");
        iPSDEFieldModel = this.getDEField("SEARCHMBEDITORWIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u79fb\u52a8\u7aef\u641c\u7d22\u7f16\u8f91\u5668\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6d789a96b26fb5f26e218dbe97145901");
        pSDEFGroupDetailModel.setName("STDDATATYPE");
        iPSDEFieldModel = this.getDEField("STDDATATYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.StdDataTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u6807\u51c6\u6570\u636e\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u9ed8\u8ba4\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1130d0c4c9cb45863a777666f708f677");
        pSDEFGroupDetailModel.setName("STRLENGTH");
        iPSDEFieldModel = this.getDEField("STRLENGTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u5b57\u7b26\u4e32\u957f\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8e90ff14ac9c857f9a7e4ea1d058d7d6");
        pSDEFGroupDetailModel.setName("VALIDFLAG");
        iPSDEFieldModel = this.getDEField("VALIDFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColor3CodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a4d254d2c398e9b04ba07782a342ed15");
        pSDEFGroupDetailModel.setName("VALUEFORMAT");
        iPSDEFieldModel = this.getDEField("VALUEFORMAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u5c5e\u6027\u7c7b\u578b\u903b\u8f91\u7684\u9ed8\u8ba4\u503c\u683c\u5f0f\u5316\u4e32\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e73\u53f0\u9884\u7f6e\u903b\u8f91\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

