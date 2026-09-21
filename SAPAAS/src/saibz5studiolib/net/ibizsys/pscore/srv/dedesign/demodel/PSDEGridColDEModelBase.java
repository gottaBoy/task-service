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
package net.ibizsys.pscore.srv.dedesign.demodel;

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
import net.ibizsys.pscore.srv.dedesign.demodel.psdegridcol.ac.PSDEGridColDefaultACModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdegridcol.dataquery.PSDEGridColCurGridDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdegridcol.dataquery.PSDEGridColCurGridEditableDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdegridcol.dataquery.PSDEGridColDefaultDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdegridcol.dataset.PSDEGridColCurGridDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdegridcol.dataset.PSDEGridColCurGridEditableDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdegridcol.dataset.PSDEGridColDefaultDSModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;

public abstract class PSDEGridColDEModelBase
extends PSDataEntityModelBase<PSDEGridCol> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDEGridColService pSDEGridColService;

    public PSDEGridColDEModelBase() throws Exception {
        this.setId("ba42e103a81a9e0af8cadc4ae58d1c44");
        this.setName("PSDEGRIDCOL");
        this.setCodeName("PSDEGridCol");
        this.setTableName("T_SRFPSDEGRIDCOL");
        this.setViewName("v_PSDEGRIDCOL");
        this.setLogicName("\u8868\u683c\u5217");
        this.setMemo("\u5b9e\u4f53\u6570\u636e\u8868\u683c\u5217\u6a21\u578b\uff0c\u63d0\u4f9b\u591a\u79cd\u5217\u7c7b\u578b\u3002\u652f\u6301\u5b9a\u4e49\u5206\u7ec4\u5217\uff08\u591a\u5c42\uff09\u3001\u5217\u7f16\u8f91\u9879\u7684\u52a8\u6001\u903b\u8f91\u7b49");
        this.setDSLink("DEFAULT");
        this.setEnableMultiDS(true);
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setEnableTempData(true);
        this.setUserTag("MODELV2");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEGridColDEModel", (IDataEntityModel)this);
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

    public PSDEGridColService getRealService() {
        if (this.pSDEGridColService == null) {
            try {
                this.pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEGridColService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService";
    }

    public PSDEGridCol createEntity() {
        return new PSDEGridCol();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("AGGFIELD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("343254c15208e57bcacab8c7c4371d4f");
            pSDEFieldModel.setName("AGGFIELD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u805a\u5408\u503c\u5c5e\u6027");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("AggField");
            pSDEFieldModel.setMemo("\u6570\u636e\u8868\u683c\u4f7f\u7528\u805a\u5408\u884c\u4e3a\u65f6\u6307\u5b9a\u805a\u5408\u503c\u7684\u53d6\u503c\u5c5e\u6027\u540d\u79f0\uff0c");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("AGGMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6a532af6837abdd8c73d8abab7dfeecd");
            pSDEFieldModel.setName("AGGMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5217\u805a\u5408\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridColAggModeCodeListModel");
            pSDEFieldModel.setCodeName("AggMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u5217\u7684\u805a\u5408\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u805a\u5408\u3011\u3002\u9700\u6570\u636e\u8868\u683c\u542f\u7528\u805a\u5408\u529f\u80fd");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_AGGMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_AGGMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("AGGVALUEFORMAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f8b73717e7b7478c2a920999faa599f3");
            pSDEFieldModel.setName("AGGVALUEFORMAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u805a\u5408\u503c\u683c\u5f0f\u5316");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("AggValueFormat");
            pSDEFieldModel.setMemo("\u5c5e\u6027\u6570\u636e\u7c7b\u542f\u7528\u805a\u5408\u6a21\u5f0f\u6307\u5b9a\u503c\u683c\u5f0f\u5316");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ALIGN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2480cab8c03b8b7e4b4eeb7730a58e0e");
            pSDEFieldModel.setName("ALIGN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6c34\u5e73\u5bf9\u9f50");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridColAlignCodeListModel");
            pSDEFieldModel.setCodeName("Align");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5217\u7684\u6c34\u5e73\u5bf9\u9f50\u65b9\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u64cd\u4f5c\u5217\u4e3a\u3010\u53f3\u5bf9\u9f50\u3011");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ALIGN_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ALIGN_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ALLOWEMPTY");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("915e3c2544f73a7f92e4f765b26f0a13");
            pSDEFieldModel.setName("ALLOWEMPTY");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5141\u8bb8\u7a7a\u8f93\u5165");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("AllowEmpty");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u662f\u5426\u5141\u8bb8\u7a7a\u8f93\u5165\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CAPPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("821cb1a7752a2c8bbdee5f2a12647140");
            pSDEFieldModel.setName("CAPPSLANRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSLANGUAGERES_CAPPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESID");
            pSDEFieldModel.setCodeName("CapPSLanResId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CAPPSLANRESID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CAPPSLANRESID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CAPPSLANRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("42ab933d5fe1747258c6698cf4cd16d7");
            pSDEFieldModel.setName("CAPPSLANRESNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSLANGUAGERES_CAPPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESNAME");
            pSDEFieldModel.setCodeName("CapPSLanResName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u5c5e\u6027\u8868\u683c\u5217\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CAPPSLANRESNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CAPPSLANRESNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CAPPSLANRESNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CAPPSLANRESNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CAPTION");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("de77b7e3280cf61c2418f0f6752073fa");
            pSDEFieldModel.setName("CAPTION");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Caption");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7684\u6807\u9898\uff0c\u672a\u5b9a\u4e49\u65f6\u5c5e\u6027\u8868\u683c\u5217\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CAPTION_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CAPTION_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CELLPSSYSCSSID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cc5191d50ad7cae851199a5dbc235c9d");
            pSDEFieldModel.setName("CELLPSSYSCSSID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5355\u5143\u683c\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSSYSCSS_CELLPSSYSCSSID");
            pSDEFieldModel.setLinkDEFName("PSSYSCSSID");
            pSDEFieldModel.setCodeName("CellPSSysCssId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CELLPSSYSCSSID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CELLPSSYSCSSID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CELLPSSYSCSSNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d6926d2cc397d72a98ba2c8cecde8537");
            pSDEFieldModel.setName("CELLPSSYSCSSNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5355\u5143\u683c\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSSYSCSS_CELLPSSYSCSSID");
            pSDEFieldModel.setLinkDEFName("PSSYSCSSNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("CellPSSysCssName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u5355\u5143\u683c\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CELLPSSYSCSSNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CELLPSSYSCSSNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CELLPSSYSCSSNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CELLPSSYSCSSNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CLCONVERTMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b6f63a497e348deb0da4ea3b26e98522");
            pSDEFieldModel.setName("CLCONVERTMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u503c\u8f6c\u6362\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.CLConvertModesCodeListModel");
            pSDEFieldModel.setCodeName("CLConvertMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u6570\u636e\u9879\u7684\u4ee3\u7801\u503c\u8f6c\u6362\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u524d\u53f0\u3011");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CLCONVERTMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CLCONVERTMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CODELISTCONFIGMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("12f518ef68cdb79e7db0234c07afb016");
            pSDEFieldModel.setName("CODELISTCONFIGMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u4ee3\u7801\u8868\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.OutputCodeListConfigModeCodeListModel");
            pSDEFieldModel.setCodeName("CodeListConfigMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u4ee3\u7801\u8868\u914d\u7f6e\u7684\u8f93\u51fa\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u4e0e\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u4e00\u81f4\u5219\u4f7f\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\uff0c\u5426\u5219\u4e3a\u3010\u65e0\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CODELISTCONFIGMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CODELISTCONFIGMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COLENABLELINK");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8ab4e4e1db1ba36f79accb2463a6340b");
            pSDEFieldModel.setName("COLENABLELINK");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5217\u542f\u7528\u94fe\u63a5");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColLinkModeCodeListModel");
            pSDEFieldModel.setCodeName("ColEnableLink");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_COLENABLELINK_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_COLENABLELINK_EQ");
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
            pSDEFieldModel.setId("fff1f2e3808c32a281064fc5747ebe28");
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
        object = this.createDEField("CREATEDV");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a7fb3c28fd75d0e310e35aca62ef6632");
            pSDEFieldModel.setName("CREATEDV");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5efa\u7acb\u9ed8\u8ba4\u503c");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CreateDV");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u7684\u5efa\u7acb\u9ed8\u8ba4\u503c\uff0c\u672a\u6307\u5b9a\u9ed8\u8ba4\u503c\u7c7b\u578b\u65f6\u6309\u76f4\u63a5\u503c\u5904\u7406");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDVT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("078c1d3f1e412eec991af793ce5b0ca2");
            pSDEFieldModel.setName("CREATEDVT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u65b0\u5efa\u9ed8\u8ba4\u503c\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldDefaultValueTypeCodeListModel");
            pSDEFieldModel.setCodeName("CreateDVT");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u7684\u5efa\u7acb\u9ed8\u8ba4\u503c\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u76f4\u63a5\u503c\u3011");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CREATEDVT_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CREATEDVT_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEMAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f0e26113d9ec0f4ee02da926e9afbab4");
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
        object = this.createDEField("CUSTOMCODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d525ea690811f8955ab06f314d39488f");
            pSDEFieldModel.setName("CUSTOMCODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u4ee3\u7801");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CustomCode");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CUSTOMMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a23a294ddbe0ed3a95b5d6187409d703");
            pSDEFieldModel.setName("CUSTOMMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u811a\u672c\u4ee3\u7801\u6a21\u5f0f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("CustomMode");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DATAITEMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8ede4f901614a383718e8fda35fb30cb");
            pSDEFieldModel.setName("DATAITEMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6570\u636e\u9879");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DataItems");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7ed1\u5b9a\u6570\u636e\u5217\u7684\u540d\u79f0\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f53\u524d\u5217\u6807\u8bc6");
            pSDEFieldModel.setLength(300);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DYNAMODELFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("795df5fec39a16a692e307a42b23e582");
            pSDEFieldModel.setName("DYNAMODELFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u6a21\u578b\u7c7b\u578b");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DynaModelTypeCodeListModel");
            pSDEFieldModel.setCodeName("DynaModelFlag");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DYNAMODELFLAG_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DYNAMODELFLAG_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EDITORPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ce99fa2d80eec87416cbd49c8fa4fa12");
            pSDEFieldModel.setName("EDITORPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("EditorParams");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u7684\u53c2\u6570\uff0c\u5982\u7f16\u8f91\u9879\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\u7f16\u8f91\u5668\u7c7b\u578b\u4e0e\u5f53\u524d\u7f16\u8f91\u5668\u4e00\u81f4\uff0c\u540c\u65f6\u9644\u52a0\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u5668\u53c2\u6570");
            pSDEFieldModel.setLength(2000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EDITORTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6e7f8bf58d52b51442f989d8cc336dca");
            pSDEFieldModel.setName("EDITORTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridColumnEditorCodeListModel");
            pSDEFieldModel.setCodeName("EditorType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u7684\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
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
        object = this.createDEField("EDITORTYPENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a6a78d82d9dd69b5b886b8bfbbc30f2d");
            pSDEFieldModel.setName("EDITORTYPENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u7c7b\u578b");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("EditorTypeName");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLECOND");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("903e203b8cac090c3741e089a6392502");
            pSDEFieldModel.setName("ENABLECOND");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u6761\u4ef6");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormItemEnableCondCodeListModel");
            pSDEFieldModel.setCodeName("EnableCond");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u7684\u9759\u6001\u542f\u7528\u6761\u4ef6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ENABLECOND_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ENABLECOND_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLEINPUTTIP");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2a9ef66f7a10bfd052cc51595f14da08");
            pSDEFieldModel.setName("ENABLEINPUTTIP");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u8f93\u5165\u63d0\u793a");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableInputTip");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLEITEMPRIV");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9f9342439618839bce0dd33f45006e8f");
            pSDEFieldModel.setName("ENABLEITEMPRIV");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u5217\u6743\u9650\u63a7\u5236");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableItemPriv");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u662f\u5426\u542f\u7528\u5217\u6743\u9650\u63a7\u5236\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u8868\u683c\u5217\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5c5e\u6027\u51b3\u5b9a\uff0c\u65e0\u5b9e\u4f53\u5c5e\u6027\u5219\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLELINK");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fa32c5447441a538c6409637c7ea6800");
            pSDEFieldModel.setName("ENABLELINK");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u94fe\u63a5");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColLinkModeCodeListModel");
            pSDEFieldModel.setCodeName("EnableLink");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5c5e\u6027\u5217\u7684\u94fe\u63a5\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u6570\u636e\u8868\u683c\u7684\u914d\u7f6e");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ENABLELINK_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ENABLELINK_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLEROWEDIT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ce1fbc518acb05dcb91268baf1fe37c4");
            pSDEFieldModel.setName("ENABLEROWEDIT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u652f\u6301\u884c\u7f16\u8f91");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableRowEdit");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u8868\u683c\u5217\u662f\u5426\u652f\u6301\u884c\u7f16\u8f91\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("GCRPSSYSPFPLUGINID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ceda4cdfb4b2546c91d882a2faa5586a");
            pSDEFieldModel.setName("GCRPSSYSPFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8868\u683c\u5217\u7ed8\u5236\u5668\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSSYSPFPLUGIN_GCRPSSYSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSPFPLUGINID");
            pSDEFieldModel.setCodeName("GCRPSSysPFPluginId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_GCRPSSYSPFPLUGINID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_GCRPSSYSPFPLUGINID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("GCRPSSYSPFPLUGINNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("352c621d4dc956adfce01ac1a5fc007e");
            pSDEFieldModel.setName("GCRPSSYSPFPLUGINNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8868\u683c\u5217\u7ed8\u5236\u5668\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSSYSPFPLUGIN_GCRPSSYSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSPFPLUGINNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("GCRPSSysPFPluginName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7ed8\u5236\u5668\u63d2\u4ef6\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u6570\u636e\u8868\u683c\u5217\u7ed8\u5236\u63d2\u4ef6\u3011");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_GCRPSSYSPFPLUGINNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_GCRPSSYSPFPLUGINNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_GCRPSSYSPFPLUGINNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_GCRPSSYSPFPLUGINNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("GRIDCOLSTYLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9b5ecd158b739fc04614d0f155f618d9");
            pSDEFieldModel.setName("GRIDCOLSTYLE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8868\u683c\u5217\u6837\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColStypeCodeListModel");
            pSDEFieldModel.setCodeName("GridColStyle");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7684\u6837\u5f0f");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_GRIDCOLSTYLE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_GRIDCOLSTYLE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("GRIDCOLTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("51328f326b05b455776abb9c87909cd5");
            pSDEFieldModel.setName("GRIDCOLTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5217\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColTypeCodeListModel");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("GridColType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7684\u7c7b\u578b");
            pSDEFieldModel.setLength(40);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_GRIDCOLTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_GRIDCOLTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("GROUPITEM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6f34d0f2397922a20d7cbc21e7391195");
            pSDEFieldModel.setName("GROUPITEM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5206\u7ec4\u9879");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColGroupModeCodeListModel");
            pSDEFieldModel.setCodeName("GroupItem");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7684\u9ed8\u8ba4\u5206\u7ec4\u9879\uff0c\u6b64\u914d\u7f6e\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_GROUPITEM_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_GROUPITEM_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HEADERPSSYSCSSID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("404e2106c5e8da2969c6daf92ad8d7ab");
            pSDEFieldModel.setName("HEADERPSSYSCSSID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5934\u90e8\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSSYSCSS_HEADERPSSYSCSSID");
            pSDEFieldModel.setLinkDEFName("PSSYSCSSID");
            pSDEFieldModel.setCodeName("HeaderPSSysCssId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_HEADERPSSYSCSSID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_HEADERPSSYSCSSID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HEADERPSSYSCSSNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5b3b2d9f042f1fbadef61431a319f369");
            pSDEFieldModel.setName("HEADERPSSYSCSSNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5934\u90e8\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSSYSCSS_HEADERPSSYSCSSID");
            pSDEFieldModel.setLinkDEFName("PSSYSCSSNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("HeaderPSSysCssName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u5934\u90e8\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_HEADERPSSYSCSSNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_HEADERPSSYSCSSNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_HEADERPSSYSCSSNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_HEADERPSSYSCSSNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HIDDENDATAITEM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("43b616996ec2be2c54d9e43c9520b268");
            pSDEFieldModel.setName("HIDDENDATAITEM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9690\u85cf\u6570\u636e\u9879");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("HiddenDataItem");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u662f\u5426\u4e0d\u8f93\u51fa\u754c\u9762\uff0c\u4ec5\u8f93\u51fa\u6570\u636e\u9879\u4f9b\u5176\u5b83\u903b\u8f91\u4f7f\u7528\u3002\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HIDEDEFAULT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9fe5bff5592c417f1f590a27a4c3b1be");
            pSDEFieldModel.setName("HIDEDEFAULT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u9690\u85cf");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColHideModeCodeListModel");
            pSDEFieldModel.setCodeName("HideDefault");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u662f\u5426\u9ed8\u8ba4\u9690\u85cf\uff0c\u9700\u8981\u7528\u6237\u9009\u62e9\u8f93\u51fa\u3002\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("IGNOREINPUT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7f73ff9aecea0b0cfdb3fbd9a80a4134");
            pSDEFieldModel.setName("IGNOREINPUT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5ffd\u7565\u8f93\u5165\u503c");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormItemEnableCondCodeListModel");
            pSDEFieldModel.setCodeName("IgnoreInput");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7f16\u8f91\u9879\u7684\u5ffd\u7565\u8f93\u5165\u503c\u7684\u65b9\u5f0f\uff0c\u5982\u7f16\u8f91\u9879\u542f\u7528\u4ee3\u7801\u503c\u8f6c\u6362\u6587\u672c\u5904\u7406\u5219\u76f4\u63a5\u4e3a\u3010\u5efa\u7acb\u53ca\u66f4\u65b0\u3011\uff0c\u672a\u5b9a\u4e49\u65f6\uff081\uff09\u5982\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u5b58\u5728\u5ffd\u7565\u8f93\u5165\u503c\u914d\u7f6e\u5219\u4f7f\u7528\u8be5\u914d\u7f6e\uff082\uff09\u5982\u8868\u5355\u9879\u5c5e\u6027\u4e3a\u7cfb\u7edf\u5c5e\u6027\u5219\u4e3a\u3010\u5efa\u7acb\u53ca\u66f4\u65b0\u3011\uff083\uff09\u5982\u4ee5\u4e0a\u6761\u4ef6\u90fd\u4e0d\u6ee1\u8db3\u5219\u4e3a\u3010\u65e0\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_IGNOREINPUT_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_IGNOREINPUT_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LINKPSDEVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0eb87207f1f47d0a11e4a84352f73f20");
            pSDEFieldModel.setName("LINKPSDEVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6570\u636e\u94fe\u63a5\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEVIEWBASE_LINKPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setCodeName("LinkPSDEViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LINKPSDEVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LINKPSDEVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LINKPSDEVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9f2224532a53d6cad3f61db6de2a848d");
            pSDEFieldModel.setName("LINKPSDEVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6570\u636e\u94fe\u63a5\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEVIEWBASE_LINKPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("LinkPSDEViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u5f15\u7528\u6570\u636e\u7684\u94fe\u63a5\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LINKPSDEVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LINKPSDEVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LINKPSDEVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LINKPSDEVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LOGICNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4651611a6c6bdcdd691fc82d8c5159d9");
            pSDEFieldModel.setName("LOGICNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u6587\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("LogicName");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1ca6ad2bd92c47ebc95032fe998bd08f");
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
        object = this.createDEField("MODELSTATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("989921f3979e008d53d6c96a602ffd33");
            pSDEFieldModel.setName("MODELSTATE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u578b\u72b6\u6001");
            pSDEFieldModel.setDataType("NMCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColStateCodeListModel");
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("ModelState");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("NEEDCODELISTCONFIG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3eaba9030da31e8d958e0f13363c05cb");
            pSDEFieldModel.setName("NEEDCODELISTCONFIG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9700\u8981\u63d0\u4f9b\u4ee3\u7801\u8868\u914d\u7f6e");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("NeedCodeListConfig");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7f16\u8f91\u9879\u662f\u5426\u9700\u8981\u63d0\u4f9b\u4ee3\u7801\u8868\u914d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u4e0e\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u4e00\u81f4\u5219\u4f7f\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\uff0c\u5426\u5219\u4f7f\u7528\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u9ed8\u8ba4\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("NOPRIVDM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7418ffa649406d00979be93b20d64351");
            pSDEFieldModel.setName("NOPRIVDM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u65e0\u6743\u9650\u663e\u793a\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.NoPrivDisplayModesCodeListModel");
            pSDEFieldModel.setCodeName("NoPrivDM");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_NOPRIVDM_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_NOPRIVDM_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("NOSORT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b0f243ba16ef0b1098b897d7001f0fdc");
            pSDEFieldModel.setName("NOSORT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7981\u7528\u6392\u5e8f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("NoSort");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u662f\u5426\u7981\u7528\u8868\u683c\u5217\u7684\u6392\u5e8f\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u8868\u683c\u90e8\u4ef6\u7981\u7528\u6392\u5e8f\u5219\u7981\u7528\uff0c\u5426\u5219\u7531\u7ed1\u5b9a\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u51b3\u5b9a");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ORDERVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("df71abd333d7003609152ca9e277ce69");
            pSDEFieldModel.setName("ORDERVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u663e\u793a\u6b21\u5e8f");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("OrderValue");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setUserTag2("AUTOMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PHPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("222369cf7ab4a0ce52e6b6d80263489f");
            pSDEFieldModel.setName("PHPSLANRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5360\u4f4d\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSLANGUAGERES_PHPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESID");
            pSDEFieldModel.setCodeName("PHPSLanResId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PHPSLANRESID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PHPSLANRESID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PHPSLANRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a4601e73c0dc2200ff61aca41294df0f");
            pSDEFieldModel.setName("PHPSLANRESNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5360\u4f4d\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSLANGUAGERES_PHPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESNAME");
            pSDEFieldModel.setCodeName("PHPSLanResName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PHPSLANRESNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PHPSLANRESNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PHPSLANRESNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PHPSLANRESNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PICKUPPSDEVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("40be017ce41243be82de170fa9016654");
            pSDEFieldModel.setName("PICKUPPSDEVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9009\u62e9\u754c\u9762\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEVIEWBASE_PICKUPPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setCodeName("PickupPSDEViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PICKUPPSDEVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PICKUPPSDEVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PICKUPPSDEVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("dae23c44881074f98a77663a7f91c34b");
            pSDEFieldModel.setName("PICKUPPSDEVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u9009\u62e9\u754c\u9762\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEVIEWBASE_PICKUPPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PickupPSDEViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u5f15\u7528\u6570\u636e\u7684\u9009\u62e9\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PICKUPPSDEVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PICKUPPSDEVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PICKUPPSDEVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PICKUPPSDEVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PLACEHOLDER");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("30ef4a50bf9f8bd52fd203cd23208798");
            pSDEFieldModel.setName("PLACEHOLDER");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5360\u4f4d\u63d0\u793a");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PlaceHolder");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u7684\u5360\u4f4d\u63d0\u793a\u4fe1\u606f\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PPSDEGRIDCOLID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("825ef8139bfdaf4fb16a817f732f6bb0");
            pSDEFieldModel.setName("PPSDEGRIDCOLID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7236\u5217");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEGRIDCOL_PPSDEGRIDCOLID");
            pSDEFieldModel.setLinkDEFName("PSDEGRIDCOLID");
            pSDEFieldModel.setCodeName("PPSDEGridColId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PPSDEGRIDCOLID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PPSDEGRIDCOLID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PPSDEGRIDCOLNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b9f7eaca80768c6179cc0bd20a73774b");
            pSDEFieldModel.setName("PPSDEGRIDCOLNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7236\u5217");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEGRIDCOL_PPSDEGRIDCOLID");
            pSDEFieldModel.setLinkDEFName("PSDEGRIDCOLNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PPSDEGridColName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7236\u8868\u683c\u5217\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PPSDEGRIDCOLNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PPSDEGRIDCOLNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PPSDEGRIDCOLNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PPSDEGRIDCOLNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREDEFINEDTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("88a6221732abc2bb38ef0c3ff325e80e");
            pSDEFieldModel.setName("PREDEFINEDTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9884\u5b9a\u4e49\u7c7b\u578b");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PredefinedType");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREDEFINEDTYPETEXT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f8f96488ff8cdedca4dbbd87200e3bf7");
            pSDEFieldModel.setName("PREDEFINEDTYPETEXT");
            pSDEFieldModel.setDEFType(5);
            pSDEFieldModel.setLogicName("\u9884\u5b9a\u4e49\u7c7b\u578b");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PredefinedTypeText");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREVENTXSS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("121369c2b99e6df8e737b481592a8eee");
            pSDEFieldModel.setName("PREVENTXSS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9632\u6b62XSS\u653b\u51fb");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("PreventXSS");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREVIEWHTML");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("54ac52788885077969e566bc7cfb617a");
            pSDEFieldModel.setName("PREVIEWHTML");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9884\u89c8\u5185\u5bb9");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PreviewHtml");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(10);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSCODELISTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7876db75c824ede3c2c2d713787369b6");
            pSDEFieldModel.setName("PSCODELISTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u4ee3\u7801\u8868");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSCODELIST_PSCODELISTID");
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
            pSDEFieldModel.setId("3657149a888c2b6d8a78336afe8d026c");
            pSDEFieldModel.setName("PSCODELISTNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u4ee3\u7801\u8868");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSCODELIST_PSCODELISTID");
            pSDEFieldModel.setLinkDEFName("PSCODELISTNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSCodeListName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u7684\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
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
        object = this.createDEField("PSDEFID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("da7b977bafdeaf7d3bc1cac3ef4b03d0");
            pSDEFieldModel.setName("PSDEFID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5c5e\u6027");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEFIELD_PSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDEFIELDID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDEFId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7ff77fffc4b4d941058d2555f8d60218");
            pSDEFieldModel.setName("PSDEFNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5c5e\u6027");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEFIELD_PSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDEFIELDNAME");
            pSDEFieldModel.setCodeName("PSDEFName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u7ed1\u5b9a\u7684\u5c5e\u6027\u5bf9\u8c61");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFSFITEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bf6e9761ef07039563a039e7c37ea9f7");
            pSDEFieldModel.setName("PSDEFSFITEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEFSFITEM_PSDEFSFITEMID");
            pSDEFieldModel.setLinkDEFName("PSDEFSFITEMID");
            pSDEFieldModel.setCodeName("PSDEFSFItemId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFSFITEMID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFSFITEMID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFSFITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8fbed14a46f5ea75ee841c06633c1c6c");
            pSDEFieldModel.setName("PSDEFSFITEMNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8fc7\u6ee4\u5668\u641c\u7d22\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEFSFITEM_PSDEFSFITEMID");
            pSDEFieldModel.setLinkDEFName("PSDEFSFITEMNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEFSFItemName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFSFITEMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFSFITEMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFSFITEMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFSFITEMNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFUIMODEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e28a240646c7ee78ddef5000717f0b35");
            pSDEFieldModel.setName("PSDEFUIMODEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5c5e\u6027\u754c\u9762\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEFFORMITEM_PSDEFUIMODEID");
            pSDEFieldModel.setLinkDEFName("PSDEFFORMITEMID");
            pSDEFieldModel.setCodeName("PSDEFUIModeId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFUIMODEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFUIMODEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFUIMODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0c2834d4c2e381ee7aa5ef1bbdb008c8");
            pSDEFieldModel.setName("PSDEFUIMODENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5c5e\u6027\u754c\u9762\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEFFORMITEM_PSDEFUIMODEID");
            pSDEFieldModel.setLinkDEFName("PSDEFFORMITEMNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEFUIModeName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u9879\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u7167\u4ee5\u4e0b\u65b9\u5f0f\u8ba1\u7b97\u6a21\u5f0f\uff081\uff09\u5f53\u524d\u5e94\u7528\u7684\u9ed8\u8ba4\u6a21\u5f0f\uff082\uff09\u5f53\u524d\u5e94\u7528\u7c7b\u578b\u7684\u9ed8\u8ba4\u6a21\u5f0f");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFUIMODENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFUIMODENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFUIMODENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFUIMODENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEGEIUPDATEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4c10ca5b5e70e68f485e1ccac46fe749");
            pSDEFieldModel.setName("PSDEGEIUPDATEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEGEIUPDATE_PSDEGEIUPDATEID");
            pSDEFieldModel.setLinkDEFName("PSDEGEIUPDATEID");
            pSDEFieldModel.setCodeName("PSDEGEIUpdateId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEGEIUPDATEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEGEIUPDATEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEGEIUPDATENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c8e89f5a103f1f9e5454d64a9c638407");
            pSDEFieldModel.setName("PSDEGEIUPDATENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEGEIUPDATE_PSDEGEIUPDATEID");
            pSDEFieldModel.setLinkDEFName("PSDEGEIUPDATENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEGEIUpdateName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u503c\u53d8\u5316\u65f6\u89e6\u53d1\u7684\u7f16\u8f91\u9879\u66f4\u65b0\u64cd\u4f5c");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEGEIUPDATENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEGEIUPDATENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEGEIUPDATENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEGEIUPDATENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEGRIDCOLID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("91f5b15bfc71c282641eb1cbb9e57843");
            pSDEFieldModel.setName("PSDEGRIDCOLID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u8868\u683c\u5217\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDEGridColId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEGRIDCOLNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b3eb86c700a1ef14daf2c9e4d56ddd03");
            pSDEFieldModel.setName("PSDEGRIDCOLNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSDEGridColName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7684\u6807\u8bc6\uff0c\u5fc5\u987b\u5728\u6240\u5728\u8868\u683c\u90e8\u4ef6\u4e2d\u5177\u5907\u552f\u4e00\u6027");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEGRIDCOLNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEGRIDCOLNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEGRIDCOLNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEGRIDCOLNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEGRIDID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5ea1a9615062b87da679df5802d6e868");
            pSDEFieldModel.setName("PSDEGRIDID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u8868\u683c");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEGRID_PSDEGRIDID");
            pSDEFieldModel.setLinkDEFName("PSDEGRIDID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDEGridId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEGRIDID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEGRIDID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEGRIDNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e2b71d76acb27e2a56ee822900770be9");
            pSDEFieldModel.setName("PSDEGRIDNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u8868\u683c");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEGRID_PSDEGRIDID");
            pSDEFieldModel.setLinkDEFName("PSDEGRIDNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDEGridName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u6240\u5728\u7684\u8868\u683c\u90e8\u4ef6\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEGRIDNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEGRIDNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEGRIDNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEGRIDNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7bc6225e715a822ba0fb241eec73c7c0");
            pSDEFieldModel.setName("PSDEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("PSDEID");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEGRID_PSDEGRIDID");
            pSDEFieldModel.setLinkDEFName("PSDEID");
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDEId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEUAGROUPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7fbb31b5b3c4f361a34901cef10868be");
            pSDEFieldModel.setName("PSDEUAGROUPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u754c\u9762\u884c\u4e3a\u7ec4");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEUAGROUP_PSDEUAGROUPID");
            pSDEFieldModel.setLinkDEFName("PSDEUAGROUPID");
            pSDEFieldModel.setCodeName("PSDEUAGroupId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEUAGROUPID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEUAGROUPID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEUAGROUPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6722b9091da252649b9e8bbe4c6b9f35");
            pSDEFieldModel.setName("PSDEUAGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u754c\u9762\u884c\u4e3a\u7ec4");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEUAGROUP_PSDEUAGROUPID");
            pSDEFieldModel.setLinkDEFName("PSDEUAGROUPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEUAGroupName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u64cd\u4f5c\u5217\u7ed1\u5b9a\u7684\u754c\u9762\u884c\u4e3a\u7ec4\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEUAGROUPNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEUAGROUPNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEUAGROUPNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEUAGROUPNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEUIACTIONID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("419249c3b5031171d4fc268a33abe2be");
            pSDEFieldModel.setName("PSDEUIACTIONID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u7f6e\u754c\u9762\u884c\u4e3a");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEUIACTION_PSDEUIACTIONID");
            pSDEFieldModel.setLinkDEFName("PSDEUIACTIONID");
            pSDEFieldModel.setCodeName("PSDEUIActionId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEUIACTIONID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEUIACTIONID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEUIACTIONNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a8bda4e2690f1f0c19ac10e5d302d0ce");
            pSDEFieldModel.setName("PSDEUIACTIONNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5185\u7f6e\u754c\u9762\u884c\u4e3a");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEUIACTION_PSDEUIACTIONID");
            pSDEFieldModel.setLinkDEFName("PSDEUIACTIONNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEUIActionName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u8868\u683c\u5217\u5185\u7f6e\u7684\u754c\u9762\u884c\u4e3a");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEUIACTIONNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEUIACTIONNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEUIACTIONNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEUIACTIONNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDYNAINSTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f903ccc4d57c048fb448dcf4ddfadab4");
            pSDEFieldModel.setName("PSDYNAINSTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("PSDYNAINSTID");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSDynaInstId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDICTCATID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7d8c741248d7e338c651a4e7df835e8d");
            pSDEFieldModel.setName("PSSYSDICTCATID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u8bcd\u6761\u7c7b\u522b");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSSYSDICTCAT_PSSYSDICTCATID");
            pSDEFieldModel.setLinkDEFName("PSSYSDICTCATID");
            pSDEFieldModel.setCodeName("PSSysDictCatId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDICTCATID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDICTCATID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDICTCATNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7d13e7f1a1833713b9dde8aa0d90ef4f");
            pSDEFieldModel.setName("PSSYSDICTCATNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u8bcd\u6761\u7c7b\u522b");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSSYSDICTCAT_PSSYSDICTCATID");
            pSDEFieldModel.setLinkDEFName("PSSYSDICTCATNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysDictCatName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u4f7f\u7528\u7684\u8f85\u52a9\u8f93\u5165\u8bcd\u6761\u7c7b\u522b\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDICTCATNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDICTCATNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDICTCATNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDICTCATNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDYNAMODELID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("13cbd5a17f75496ab1ae3cf0b97e957e");
            pSDEFieldModel.setName("PSSYSDYNAMODELID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u7cfb\u7edf\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSSYSDYNAMODEL_PSSYSDYNAMODELID");
            pSDEFieldModel.setLinkDEFName("PSSYSDYNAMODELID");
            pSDEFieldModel.setCodeName("PSSysDynaModelId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDYNAMODELID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDYNAMODELID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDYNAMODELNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d3cf43eece2310cf87012d771988d396");
            pSDEFieldModel.setName("PSSYSDYNAMODELNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u7cfb\u7edf\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSSYSDYNAMODEL_PSSYSDYNAMODELID");
            pSDEFieldModel.setLinkDEFName("PSSYSDYNAMODELNAME");
            pSDEFieldModel.setCodeName("PSSysDynaModelName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDYNAMODELNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDYNAMODELNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDYNAMODELNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDYNAMODELNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSEDITORSTYLEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a9dfbc8392b25d8caa876d879d1c1055");
            pSDEFieldModel.setName("PSSYSEDITORSTYLEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID");
            pSDEFieldModel.setLinkDEFName("PSSYSEDITORSTYLEID");
            pSDEFieldModel.setCodeName("PSSysEditorStyleId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSEDITORSTYLEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSEDITORSTYLEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSEDITORSTYLENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8bb06efe4d83b39fda3a4633517bbff8");
            pSDEFieldModel.setName("PSSYSEDITORSTYLENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID");
            pSDEFieldModel.setLinkDEFName("PSSYSEDITORSTYLENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysEditorStyleName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u7684\u7f16\u8f91\u5668\u7684\u6269\u5c55\u6837\u5f0f");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSEDITORSTYLENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSEDITORSTYLENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSEDITORSTYLENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSEDITORSTYLENAME_LIKE");
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
            pSDEFieldModel.setId("bc7d49d8acbcf065f37139a49fb8eb0f");
            pSDEFieldModel.setName("PSSYSIMAGEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u56fe\u7247");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSSYSIMAGE_PSSYSIMAGEID");
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
            pSDEFieldModel.setId("e74e6bb63107567f7fdf5d967b73f554");
            pSDEFieldModel.setName("PSSYSIMAGENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u56fe\u7247");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSSYSIMAGE_PSSYSIMAGEID");
            pSDEFieldModel.setLinkDEFName("PSSYSIMAGENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysImageName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u5217\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
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
        object = this.createDEField("RAWSERVICEMETHOD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ab8f64126d9e0769c3cc6f51cd8743a8");
            pSDEFieldModel.setName("RAWSERVICEMETHOD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u76f4\u63a5\u670d\u52a1\u8bf7\u6c42\u65b9\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
            pSDEFieldModel.setCodeName("RawServiceMethod");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_RAWSERVICEMETHOD_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_RAWSERVICEMETHOD_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RAWSERVICEURL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c6044ee5b68514af95e9003a22ffef3c");
            pSDEFieldModel.setName("RAWSERVICEURL");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u76f4\u63a5\u670d\u52a1\u8def\u5f84");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RawServiceUrl");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDEACMODEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8e99ec6fce41719fce63a14e835eb70a");
            pSDEFieldModel.setName("REFPSDEACMODEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEACMODE_REFPSDEACMODEID");
            pSDEFieldModel.setLinkDEFName("PSDEACMODEID");
            pSDEFieldModel.setCodeName("RefPSDEACModeId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEACMODEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEACMODEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDEACMODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f2a7e4eba68ea3bd45ea12416d46f9d3");
            pSDEFieldModel.setName("REFPSDEACMODENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEACMODE_REFPSDEACMODEID");
            pSDEFieldModel.setLinkDEFName("PSDEACMODENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RefPSDEACModeName");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEACMODENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEACMODENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEACMODENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEACMODENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDEDATASETID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a984df0a1c55df2cfef111d39f700cce");
            pSDEFieldModel.setName("REFPSDEDATASETID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEDATASET_REFPSDEDATASETID");
            pSDEFieldModel.setLinkDEFName("PSDEDATASETID");
            pSDEFieldModel.setCodeName("RefPSDEDataSetId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEDATASETID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEDATASETID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDEDATASETNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b5b6f18d78950d5addf7a6831ef8d61a");
            pSDEFieldModel.setName("REFPSDEDATASETNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDEDATASET_REFPSDEDATASETID");
            pSDEFieldModel.setLinkDEFName("PSDEDATASETNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RefPSDEDataSetName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEDATASETNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEDATASETNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEDATASETNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEDATASETNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("dc21c310bddcdcd8fd3ead470a647800");
            pSDEFieldModel.setName("REFPSDEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDATAENTITY_REFPSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYID");
            pSDEFieldModel.setCodeName("RefPSDEId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1c5b1727d6d13e365c4e8b64b0a4e12b");
            pSDEFieldModel.setName("REFPSDENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDATAENTITY_REFPSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYNAME");
            pSDEFieldModel.setCodeName("RefPSDEName");
            pSDEFieldModel.setLength(60);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4e4d2c13dd7c4d6debf5e36ee7b186ee");
            pSDEFieldModel.setName("REFPSDERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u5173\u7cfb");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDER_REFPSDERID");
            pSDEFieldModel.setLinkDEFName("PSDERID");
            pSDEFieldModel.setCodeName("RefPSDERId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDERID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDERID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("29af2484f6752f3cfa87040719c3f636");
            pSDEFieldModel.setName("REFPSDERNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u5173\u7cfb");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEGRIDCOL_PSDER_REFPSDERID");
            pSDEFieldModel.setLinkDEFName("PSDERNAME");
            pSDEFieldModel.setCodeName("RefPSDERName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u7684\u5f15\u7528\u5b9e\u4f53\u5173\u7cfb");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDERNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDERNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDERNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDERNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RENDERMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("404208cf14ebc9188bf6c30ec2dd12a3");
            pSDEFieldModel.setName("RENDERMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7ed8\u5236\u6a21\u5f0f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RenderMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RENDERMODETEXT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4206a83fe503a9ab5bc7ef2c8057cc11");
            pSDEFieldModel.setName("RENDERMODETEXT");
            pSDEFieldModel.setDEFType(5);
            pSDEFieldModel.setLogicName("\u7ed8\u5236\u6a21\u5f0f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RenderModeText");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RESETITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1753896c6fc7811d22d4499d27a9f6b1");
            pSDEFieldModel.setName("RESETITEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u91cd\u7f6e\u9879\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ResetItemName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u76d1\u63a7\u7684\u91cd\u7f6e\u9879\u540d\u79f0\uff0c\u91cd\u7f6e\u9879\u503c\u53d8\u5316\u65f6\u91cd\u7f6e\u5f53\u524d\u9879");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TREEITEM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1181b08555fa8452090e86921f245070");
            pSDEFieldModel.setName("TREEITEM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6811\u8868\u5217\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridTreeColModeCodeListModel");
            pSDEFieldModel.setCodeName("TreeItem");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TREEITEM_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TREEITEM_EQ");
                dEFSearchModeModel.setValueOp("EQ");
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
            pSDEFieldModel.setId("3322affe0256b1517365d5f3aa0f7892");
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
        object = this.createDEField("UPDATEDV");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fcfa21faf8942b25b32c2dbd4ed9e5eb");
            pSDEFieldModel.setName("UPDATEDV");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u65b0\u9ed8\u8ba4\u503c");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UpdateDV");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u7684\u66f4\u65b0\u9ed8\u8ba4\u503c\uff0c\u672a\u6307\u5b9a\u9ed8\u8ba4\u503c\u7c7b\u578b\u65f6\u6309\u76f4\u63a5\u503c\u5904\u7406");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEDVT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("addf27f3a451594efbbf28fc4955477b");
            pSDEFieldModel.setName("UPDATEDVT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u65b0\u9ed8\u8ba4\u503c\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldDefaultValueType2CodeListModel");
            pSDEFieldModel.setCodeName("UpdateDVT");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u7684\u66f4\u65b0\u9ed8\u8ba4\u503c\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u76f4\u63a5\u503c\u3011");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_UPDATEDVT_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_UPDATEDVT_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEMAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c7a89ecfaa5be5a904aeef02497f7046");
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
        object = this.createDEField("USERPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("06616302e3b9518cfdcfcd1c974e2cb7");
            pSDEFieldModel.setName("USERPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u53c2\u6570");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserParams");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(2000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a2f7ca95798653a89d63d9a96f79e7b1");
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
            pSDEFieldModel.setId("48d10c0fd64f06ae34a5153213fc1e51");
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
        object = this.createDEField("VALUEFORMAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fb8abf6e33f518b8a3d722bb254cdee0");
            pSDEFieldModel.setName("VALUEFORMAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u503c\u683c\u5f0f\u5316");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ValueFormat");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u8868\u683c\u5217\u7684\u503c\u683c\u5f0f\u5316\u4e32\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VALUEITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ff03535434910c8217a9d63fbf673fa0");
            pSDEFieldModel.setName("VALUEITEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u503c\u9879\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ValueItemName");
            pSDEFieldModel.setMemo("\u7f16\u8f91\u5668\u5b9e\u9645\u503c\u9879\u56de\u586b\u7684\u7f16\u8f91\u9879");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIDTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("031b681f661cefa05c50ade9d0b28418");
            pSDEFieldModel.setName("WIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bbd\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Width");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7684\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010100\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIDTHUNIT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7b25621fdbfd5302535c5fb7edf856d9");
            pSDEFieldModel.setName("WIDTHUNIT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bbd\u5ea6\u5355\u4f4d");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColWidthUnitTypeCodeListModel");
            pSDEFieldModel.setCodeName("WidthUnit");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u5bbd\u5ea6\u7684\u5355\u4f4d\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010px\u3011");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_WIDTHUNIT_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_WIDTHUNIT_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSDEGridColDefaultACModel pSDEGridColDefaultACModel = new PSDEGridColDefaultACModel();
        pSDEGridColDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDEGridColDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDEGridColCurGridDSModel pSDEGridColCurGridDSModel = new PSDEGridColCurGridDSModel();
        pSDEGridColCurGridDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEGridColCurGridDSModel);
        PSDEGridColCurGridEditableDSModel pSDEGridColCurGridEditableDSModel = new PSDEGridColCurGridEditableDSModel();
        pSDEGridColCurGridEditableDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEGridColCurGridEditableDSModel);
        PSDEGridColDefaultDSModel pSDEGridColDefaultDSModel = new PSDEGridColDefaultDSModel();
        pSDEGridColDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEGridColDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDEGridColCurGridDQModel pSDEGridColCurGridDQModel = new PSDEGridColCurGridDQModel();
        pSDEGridColCurGridDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEGridColCurGridDQModel);
        PSDEGridColCurGridEditableDQModel pSDEGridColCurGridEditableDQModel = new PSDEGridColCurGridEditableDQModel();
        pSDEGridColCurGridEditableDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEGridColCurGridEditableDQModel);
        PSDEGridColDefaultDQModel pSDEGridColDefaultDQModel = new PSDEGridColDefaultDQModel();
        pSDEGridColDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEGridColDefaultDQModel);
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
        this.registerPDTDEView("EDITVIEW", "81e095a02f2b91407a98e3ef8e435aad");
        this.registerPDTDEView("MPICKUPVIEW", "3082dd152d848f9e53b8c286e4363780");
        this.registerPDTDEView("PICKUPVIEW", "01eac62428d7277731be78e2c3cfa5df");
        this.registerPDTDEView("REDIRECTVIEW", "7b406290b60cb1bfac82f48fb93c2507");
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
        dEDataSetCond2.setDEFName("PSDEGRIDCOLNAME");
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
        pSDEFGroupDetailModel.setId("343254c15208e57bcacab8c7c4371d4f");
        pSDEFGroupDetailModel.setName("AGGFIELD");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("AGGFIELD", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6570\u636e\u8868\u683c\u4f7f\u7528\u805a\u5408\u884c\u4e3a\u65f6\u6307\u5b9a\u805a\u5408\u503c\u7684\u53d6\u503c\u5c5e\u6027\u540d\u79f0\uff0c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6a532af6837abdd8c73d8abab7dfeecd");
        pSDEFGroupDetailModel.setName("AGGMODE");
        iPSDEFieldModel = this.getDEField("AGGMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridColAggModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u5217\u7684\u805a\u5408\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u805a\u5408\u3011\u3002\u9700\u6570\u636e\u8868\u683c\u542f\u7528\u805a\u5408\u529f\u80fd");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f8b73717e7b7478c2a920999faa599f3");
        pSDEFGroupDetailModel.setName("AGGVALUEFORMAT");
        iPSDEFieldModel = this.getDEField("AGGVALUEFORMAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5c5e\u6027\u6570\u636e\u7c7b\u542f\u7528\u805a\u5408\u6a21\u5f0f\u6307\u5b9a\u503c\u683c\u5f0f\u5316");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2480cab8c03b8b7e4b4eeb7730a58e0e");
        pSDEFGroupDetailModel.setName("ALIGN");
        iPSDEFieldModel = this.getDEField("ALIGN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridColAlignCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5217\u7684\u6c34\u5e73\u5bf9\u9f50\u65b9\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u64cd\u4f5c\u5217\u4e3a\u3010\u53f3\u5bf9\u9f50\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("915e3c2544f73a7f92e4f765b26f0a13");
        pSDEFGroupDetailModel.setName("ALLOWEMPTY");
        iPSDEFieldModel = this.getDEField("ALLOWEMPTY", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u662f\u5426\u5141\u8bb8\u7a7a\u8f93\u5165\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b6f63a497e348deb0da4ea3b26e98522");
        pSDEFGroupDetailModel.setName("CLCONVERTMODE");
        iPSDEFieldModel = this.getDEField("CLCONVERTMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.CLConvertModesCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u6570\u636e\u9879\u7684\u4ee3\u7801\u503c\u8f6c\u6362\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u524d\u53f0\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("821cb1a7752a2c8bbdee5f2a12647140");
        pSDEFGroupDetailModel.setName("CAPPSLANRESID");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u5c5e\u6027\u8868\u683c\u5217\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("42ab933d5fe1747258c6698cf4cd16d7");
        pSDEFGroupDetailModel.setName("CAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u5c5e\u6027\u8868\u683c\u5217\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("de77b7e3280cf61c2418f0f6752073fa");
        pSDEFGroupDetailModel.setName("CAPTION");
        iPSDEFieldModel = this.getDEField("CAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7684\u6807\u9898\uff0c\u672a\u5b9a\u4e49\u65f6\u5c5e\u6027\u8868\u683c\u5217\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cc5191d50ad7cae851199a5dbc235c9d");
        pSDEFGroupDetailModel.setName("CELLPSSYSCSSID");
        iPSDEFieldModel = this.getDEField("CELLPSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u5355\u5143\u683c\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6926d2cc397d72a98ba2c8cecde8537");
        pSDEFGroupDetailModel.setName("CELLPSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("CELLPSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u5355\u5143\u683c\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("12f518ef68cdb79e7db0234c07afb016");
        pSDEFGroupDetailModel.setName("CODELISTCONFIGMODE");
        iPSDEFieldModel = this.getDEField("CODELISTCONFIGMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.OutputCodeListConfigModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u4ee3\u7801\u8868\u914d\u7f6e\u7684\u8f93\u51fa\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u4e0e\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u4e00\u81f4\u5219\u4f7f\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\uff0c\u5426\u5219\u4e3a\u3010\u65e0\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7fb3c28fd75d0e310e35aca62ef6632");
        pSDEFGroupDetailModel.setName("CREATEDV");
        iPSDEFieldModel = this.getDEField("CREATEDV", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u7684\u5efa\u7acb\u9ed8\u8ba4\u503c\uff0c\u672a\u6307\u5b9a\u9ed8\u8ba4\u503c\u7c7b\u578b\u65f6\u6309\u76f4\u63a5\u503c\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("078c1d3f1e412eec991af793ce5b0ca2");
        pSDEFGroupDetailModel.setName("CREATEDVT");
        iPSDEFieldModel = this.getDEField("CREATEDVT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldDefaultValueTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u7684\u5efa\u7acb\u9ed8\u8ba4\u503c\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u76f4\u63a5\u503c\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d525ea690811f8955ab06f314d39488f");
        pSDEFGroupDetailModel.setName("CUSTOMCODE");
        iPSDEFieldModel = this.getDEField("CUSTOMCODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a23a294ddbe0ed3a95b5d6187409d703");
        pSDEFGroupDetailModel.setName("CUSTOMMODE");
        iPSDEFieldModel = this.getDEField("CUSTOMMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8ede4f901614a383718e8fda35fb30cb");
        pSDEFGroupDetailModel.setName("DATAITEMS");
        iPSDEFieldModel = this.getDEField("DATAITEMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7ed1\u5b9a\u6570\u636e\u5217\u7684\u540d\u79f0\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f53\u524d\u5217\u6807\u8bc6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ce99fa2d80eec87416cbd49c8fa4fa12");
        pSDEFGroupDetailModel.setName("EDITORPARAMS");
        iPSDEFieldModel = this.getDEField("EDITORPARAMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u7684\u53c2\u6570\uff0c\u5982\u7f16\u8f91\u9879\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\u7f16\u8f91\u5668\u7c7b\u578b\u4e0e\u5f53\u524d\u7f16\u8f91\u5668\u4e00\u81f4\uff0c\u540c\u65f6\u9644\u52a0\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u5668\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6e7f8bf58d52b51442f989d8cc336dca");
        pSDEFGroupDetailModel.setName("EDITORTYPE");
        iPSDEFieldModel = this.getDEField("EDITORTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridColumnEditorCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u7684\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("903e203b8cac090c3741e089a6392502");
        pSDEFGroupDetailModel.setName("ENABLECOND");
        iPSDEFieldModel = this.getDEField("ENABLECOND", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormItemEnableCondCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u7684\u9759\u6001\u542f\u7528\u6761\u4ef6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9f9342439618839bce0dd33f45006e8f");
        pSDEFGroupDetailModel.setName("ENABLEITEMPRIV");
        iPSDEFieldModel = this.getDEField("ENABLEITEMPRIV", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u662f\u5426\u542f\u7528\u5217\u6743\u9650\u63a7\u5236\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u8868\u683c\u5217\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5c5e\u6027\u51b3\u5b9a\uff0c\u65e0\u5b9e\u4f53\u5c5e\u6027\u5219\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("fa32c5447441a538c6409637c7ea6800");
        pSDEFGroupDetailModel.setName("ENABLELINK");
        iPSDEFieldModel = this.getDEField("ENABLELINK", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColLinkModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5c5e\u6027\u5217\u7684\u94fe\u63a5\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u6570\u636e\u8868\u683c\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ce1fbc518acb05dcb91268baf1fe37c4");
        pSDEFGroupDetailModel.setName("ENABLEROWEDIT");
        iPSDEFieldModel = this.getDEField("ENABLEROWEDIT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u8868\u683c\u5217\u662f\u5426\u652f\u6301\u884c\u7f16\u8f91\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ceda4cdfb4b2546c91d882a2faa5586a");
        pSDEFGroupDetailModel.setName("GCRPSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("GCRPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7ed8\u5236\u5668\u63d2\u4ef6\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u6570\u636e\u8868\u683c\u5217\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("352c621d4dc956adfce01ac1a5fc007e");
        pSDEFGroupDetailModel.setName("GCRPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("GCRPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7ed8\u5236\u5668\u63d2\u4ef6\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u6570\u636e\u8868\u683c\u5217\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9b5ecd158b739fc04614d0f155f618d9");
        pSDEFGroupDetailModel.setName("GRIDCOLSTYLE");
        iPSDEFieldModel = this.getDEField("GRIDCOLSTYLE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColStypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7684\u6837\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51328f326b05b455776abb9c87909cd5");
        pSDEFGroupDetailModel.setName("GRIDCOLTYPE");
        iPSDEFieldModel = this.getDEField("GRIDCOLTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7684\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6f34d0f2397922a20d7cbc21e7391195");
        pSDEFGroupDetailModel.setName("GROUPITEM");
        iPSDEFieldModel = this.getDEField("GROUPITEM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColGroupModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7684\u9ed8\u8ba4\u5206\u7ec4\u9879\uff0c\u6b64\u914d\u7f6e\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("404e2106c5e8da2969c6daf92ad8d7ab");
        pSDEFGroupDetailModel.setName("HEADERPSSYSCSSID");
        iPSDEFieldModel = this.getDEField("HEADERPSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u5934\u90e8\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5b3b2d9f042f1fbadef61431a319f369");
        pSDEFGroupDetailModel.setName("HEADERPSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("HEADERPSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u5934\u90e8\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("43b616996ec2be2c54d9e43c9520b268");
        pSDEFGroupDetailModel.setName("HIDDENDATAITEM");
        iPSDEFieldModel = this.getDEField("HIDDENDATAITEM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u662f\u5426\u4e0d\u8f93\u51fa\u754c\u9762\uff0c\u4ec5\u8f93\u51fa\u6570\u636e\u9879\u4f9b\u5176\u5b83\u903b\u8f91\u4f7f\u7528\u3002\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9fe5bff5592c417f1f590a27a4c3b1be");
        pSDEFGroupDetailModel.setName("HIDEDEFAULT");
        iPSDEFieldModel = this.getDEField("HIDEDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColHideModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u662f\u5426\u9ed8\u8ba4\u9690\u85cf\uff0c\u9700\u8981\u7528\u6237\u9009\u62e9\u8f93\u51fa\u3002\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0eb87207f1f47d0a11e4a84352f73f20");
        pSDEFGroupDetailModel.setName("LINKPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("LINKPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u5f15\u7528\u6570\u636e\u7684\u94fe\u63a5\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9f2224532a53d6cad3f61db6de2a848d");
        pSDEFGroupDetailModel.setName("LINKPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("LINKPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u5f15\u7528\u6570\u636e\u7684\u94fe\u63a5\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4651611a6c6bdcdd691fc82d8c5159d9");
        pSDEFGroupDetailModel.setName("LOGICNAME");
        iPSDEFieldModel = this.getDEField("LOGICNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1ca6ad2bd92c47ebc95032fe998bd08f");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3eaba9030da31e8d958e0f13363c05cb");
        pSDEFGroupDetailModel.setName("NEEDCODELISTCONFIG");
        iPSDEFieldModel = this.getDEField("NEEDCODELISTCONFIG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7f16\u8f91\u9879\u662f\u5426\u9700\u8981\u63d0\u4f9b\u4ee3\u7801\u8868\u914d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u4e0e\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u4e00\u81f4\u5219\u4f7f\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\uff0c\u5426\u5219\u4f7f\u7528\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u9ed8\u8ba4\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7418ffa649406d00979be93b20d64351");
        pSDEFGroupDetailModel.setName("NOPRIVDM");
        iPSDEFieldModel = this.getDEField("NOPRIVDM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.NoPrivDisplayModesCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b0f243ba16ef0b1098b897d7001f0fdc");
        pSDEFGroupDetailModel.setName("NOSORT");
        iPSDEFieldModel = this.getDEField("NOSORT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u7981\u7528\u8868\u683c\u5217\u7684\u6392\u5e8f\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u8868\u683c\u90e8\u4ef6\u7981\u7528\u6392\u5e8f\u5219\u7981\u7528\uff0c\u5426\u5219\u7531\u7ed1\u5b9a\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7876db75c824ede3c2c2d713787369b6");
        pSDEFGroupDetailModel.setName("PSCODELISTID");
        iPSDEFieldModel = this.getDEField("PSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u7684\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3657149a888c2b6d8a78336afe8d026c");
        pSDEFGroupDetailModel.setName("PSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("PSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u7684\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("da7b977bafdeaf7d3bc1cac3ef4b03d0");
        pSDEFGroupDetailModel.setName("PSDEFID");
        iPSDEFieldModel = this.getDEField("PSDEFID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u7ed1\u5b9a\u7684\u5c5e\u6027\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7ff77fffc4b4d941058d2555f8d60218");
        pSDEFGroupDetailModel.setName("PSDEFNAME");
        iPSDEFieldModel = this.getDEField("PSDEFNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u7ed1\u5b9a\u7684\u5c5e\u6027\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bf6e9761ef07039563a039e7c37ea9f7");
        pSDEFGroupDetailModel.setName("PSDEFSFITEMID");
        iPSDEFieldModel = this.getDEField("PSDEFSFITEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8fbed14a46f5ea75ee841c06633c1c6c");
        pSDEFGroupDetailModel.setName("PSDEFSFITEMNAME");
        iPSDEFieldModel = this.getDEField("PSDEFSFITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e28a240646c7ee78ddef5000717f0b35");
        pSDEFGroupDetailModel.setName("PSDEFUIMODEID");
        iPSDEFieldModel = this.getDEField("PSDEFUIMODEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u9879\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u7167\u4ee5\u4e0b\u65b9\u5f0f\u8ba1\u7b97\u6a21\u5f0f\uff081\uff09\u5f53\u524d\u5e94\u7528\u7684\u9ed8\u8ba4\u6a21\u5f0f\uff082\uff09\u5f53\u524d\u5e94\u7528\u7c7b\u578b\u7684\u9ed8\u8ba4\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0c2834d4c2e381ee7aa5ef1bbdb008c8");
        pSDEFGroupDetailModel.setName("PSDEFUIMODENAME");
        iPSDEFieldModel = this.getDEField("PSDEFUIMODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u9879\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u7167\u4ee5\u4e0b\u65b9\u5f0f\u8ba1\u7b97\u6a21\u5f0f\uff081\uff09\u5f53\u524d\u5e94\u7528\u7684\u9ed8\u8ba4\u6a21\u5f0f\uff082\uff09\u5f53\u524d\u5e94\u7528\u7c7b\u578b\u7684\u9ed8\u8ba4\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4c10ca5b5e70e68f485e1ccac46fe749");
        pSDEFGroupDetailModel.setName("PSDEGEIUPDATEID");
        iPSDEFieldModel = this.getDEField("PSDEGEIUPDATEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u503c\u53d8\u5316\u65f6\u89e6\u53d1\u7684\u7f16\u8f91\u9879\u66f4\u65b0\u64cd\u4f5c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c8e89f5a103f1f9e5454d64a9c638407");
        pSDEFGroupDetailModel.setName("PSDEGEIUPDATENAME");
        iPSDEFieldModel = this.getDEField("PSDEGEIUPDATENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u503c\u53d8\u5316\u65f6\u89e6\u53d1\u7684\u7f16\u8f91\u9879\u66f4\u65b0\u64cd\u4f5c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b3eb86c700a1ef14daf2c9e4d56ddd03");
        pSDEFGroupDetailModel.setName("PSDEGRIDCOLNAME");
        iPSDEFieldModel = this.getDEField("PSDEGRIDCOLNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7684\u6807\u8bc6\uff0c\u5fc5\u987b\u5728\u6240\u5728\u8868\u683c\u90e8\u4ef6\u4e2d\u5177\u5907\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5ea1a9615062b87da679df5802d6e868");
        pSDEFGroupDetailModel.setName("PSDEGRIDID");
        iPSDEFieldModel = this.getDEField("PSDEGRIDID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7bc6225e715a822ba0fb241eec73c7c0");
        pSDEFGroupDetailModel.setName("PSDEID");
        iPSDEFieldModel = this.getDEField("PSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("419249c3b5031171d4fc268a33abe2be");
        pSDEFGroupDetailModel.setName("PSDEUIACTIONID");
        iPSDEFieldModel = this.getDEField("PSDEUIACTIONID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u8868\u683c\u5217\u5185\u7f6e\u7684\u754c\u9762\u884c\u4e3a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a8bda4e2690f1f0c19ac10e5d302d0ce");
        pSDEFGroupDetailModel.setName("PSDEUIACTIONNAME");
        iPSDEFieldModel = this.getDEField("PSDEUIACTIONNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u8868\u683c\u5217\u5185\u7f6e\u7684\u754c\u9762\u884c\u4e3a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7d8c741248d7e338c651a4e7df835e8d");
        pSDEFGroupDetailModel.setName("PSSYSDICTCATID");
        iPSDEFieldModel = this.getDEField("PSSYSDICTCATID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u4f7f\u7528\u7684\u8f85\u52a9\u8f93\u5165\u8bcd\u6761\u7c7b\u522b\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7d13e7f1a1833713b9dde8aa0d90ef4f");
        pSDEFGroupDetailModel.setName("PSSYSDICTCATNAME");
        iPSDEFieldModel = this.getDEField("PSSYSDICTCATNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u4f7f\u7528\u7684\u8f85\u52a9\u8f93\u5165\u8bcd\u6761\u7c7b\u522b\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("13cbd5a17f75496ab1ae3cf0b97e957e");
        pSDEFGroupDetailModel.setName("PSSYSDYNAMODELID");
        iPSDEFieldModel = this.getDEField("PSSYSDYNAMODELID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3cf43eece2310cf87012d771988d396");
        pSDEFGroupDetailModel.setName("PSSYSDYNAMODELNAME");
        iPSDEFieldModel = this.getDEField("PSSYSDYNAMODELNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a9dfbc8392b25d8caa876d879d1c1055");
        pSDEFGroupDetailModel.setName("PSSYSEDITORSTYLEID");
        iPSDEFieldModel = this.getDEField("PSSYSEDITORSTYLEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u7684\u7f16\u8f91\u5668\u7684\u6269\u5c55\u6837\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8bb06efe4d83b39fda3a4633517bbff8");
        pSDEFGroupDetailModel.setName("PSSYSEDITORSTYLENAME");
        iPSDEFieldModel = this.getDEField("PSSYSEDITORSTYLENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u7684\u7f16\u8f91\u5668\u7684\u6269\u5c55\u6837\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bc7d49d8acbcf065f37139a49fb8eb0f");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u5217\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e74e6bb63107567f7fdf5d967b73f554");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u5217\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("40be017ce41243be82de170fa9016654");
        pSDEFGroupDetailModel.setName("PICKUPPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("PICKUPPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u5f15\u7528\u6570\u636e\u7684\u9009\u62e9\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("dae23c44881074f98a77663a7f91c34b");
        pSDEFGroupDetailModel.setName("PICKUPPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("PICKUPPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u5f15\u7528\u6570\u636e\u7684\u9009\u62e9\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("30ef4a50bf9f8bd52fd203cd23208798");
        pSDEFGroupDetailModel.setName("PLACEHOLDER");
        iPSDEFieldModel = this.getDEField("PLACEHOLDER", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6570\u636e\u8868\u683c\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u7684\u5360\u4f4d\u63d0\u793a\u4fe1\u606f\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8e99ec6fce41719fce63a14e835eb70a");
        pSDEFGroupDetailModel.setName("REFPSDEACMODEID");
        iPSDEFieldModel = this.getDEField("REFPSDEACMODEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f2a7e4eba68ea3bd45ea12416d46f9d3");
        pSDEFGroupDetailModel.setName("REFPSDEACMODENAME");
        iPSDEFieldModel = this.getDEField("REFPSDEACMODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a984df0a1c55df2cfef111d39f700cce");
        pSDEFGroupDetailModel.setName("REFPSDEDATASETID");
        iPSDEFieldModel = this.getDEField("REFPSDEDATASETID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b5b6f18d78950d5addf7a6831ef8d61a");
        pSDEFGroupDetailModel.setName("REFPSDEDATASETNAME");
        iPSDEFieldModel = this.getDEField("REFPSDEDATASETNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("dc21c310bddcdcd8fd3ead470a647800");
        pSDEFGroupDetailModel.setName("REFPSDEID");
        iPSDEFieldModel = this.getDEField("REFPSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1c5b1727d6d13e365c4e8b64b0a4e12b");
        pSDEFGroupDetailModel.setName("REFPSDENAME");
        iPSDEFieldModel = this.getDEField("REFPSDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1753896c6fc7811d22d4499d27a9f6b1");
        pSDEFGroupDetailModel.setName("RESETITEMNAME");
        iPSDEFieldModel = this.getDEField("RESETITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u76d1\u63a7\u7684\u91cd\u7f6e\u9879\u540d\u79f0\uff0c\u91cd\u7f6e\u9879\u503c\u53d8\u5316\u65f6\u91cd\u7f6e\u5f53\u524d\u9879");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1181b08555fa8452090e86921f245070");
        pSDEFGroupDetailModel.setName("TREEITEM");
        iPSDEFieldModel = this.getDEField("TREEITEM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridTreeColModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("fcfa21faf8942b25b32c2dbd4ed9e5eb");
        pSDEFGroupDetailModel.setName("UPDATEDV");
        iPSDEFieldModel = this.getDEField("UPDATEDV", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u7684\u66f4\u65b0\u9ed8\u8ba4\u503c\uff0c\u672a\u6307\u5b9a\u9ed8\u8ba4\u503c\u7c7b\u578b\u65f6\u6309\u76f4\u63a5\u503c\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("addf27f3a451594efbbf28fc4955477b");
        pSDEFGroupDetailModel.setName("UPDATEDVT");
        iPSDEFieldModel = this.getDEField("UPDATEDVT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldDefaultValueType2CodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u7f16\u8f91\u9879\u7684\u66f4\u65b0\u9ed8\u8ba4\u503c\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u76f4\u63a5\u503c\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a2f7ca95798653a89d63d9a96f79e7b1");
        pSDEFGroupDetailModel.setName("USERTAG");
        iPSDEFieldModel = this.getDEField("USERTAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("48d10c0fd64f06ae34a5153213fc1e51");
        pSDEFGroupDetailModel.setName("USERTAG2");
        iPSDEFieldModel = this.getDEField("USERTAG2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("fb8abf6e33f518b8a3d722bb254cdee0");
        pSDEFGroupDetailModel.setName("VALUEFORMAT");
        iPSDEFieldModel = this.getDEField("VALUEFORMAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u8868\u683c\u5217\u7684\u503c\u683c\u5f0f\u5316\u4e32\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ff03535434910c8217a9d63fbf673fa0");
        pSDEFGroupDetailModel.setName("VALUEITEMNAME");
        iPSDEFieldModel = this.getDEField("VALUEITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u5b9e\u9645\u503c\u9879\u56de\u586b\u7684\u7f16\u8f91\u9879");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("031b681f661cefa05c50ade9d0b28418");
        pSDEFGroupDetailModel.setName("WIDTH");
        iPSDEFieldModel = this.getDEField("WIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u7684\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010100\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7b25621fdbfd5302535c5fb7edf856d9");
        pSDEFGroupDetailModel.setName("WIDTHUNIT");
        iPSDEFieldModel = this.getDEField("WIDTHUNIT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColWidthUnitTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u5217\u5bbd\u5ea6\u7684\u5355\u4f4d\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010px\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

