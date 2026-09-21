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
import net.ibizsys.pscore.srv.dedesign.demodel.psdeaction.ac.PSDEActionDefaultACModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeaction.dataquery.PSDEActionCurDEDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeaction.dataquery.PSDEActionCurModDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeaction.dataquery.PSDEActionCurSysDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeaction.dataquery.PSDEActionCurSysNotBuiltinDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeaction.dataquery.PSDEActionCurSysNotSubSysDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeaction.dataquery.PSDEActionDefaultDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeaction.dataset.PSDEActionCurDEDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeaction.dataset.PSDEActionCurModDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeaction.dataset.PSDEActionCurSysDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeaction.dataset.PSDEActionCurSysNotBuiltinDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeaction.dataset.PSDEActionCurSysNotSubSysDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeaction.dataset.PSDEActionDefaultDSModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;

public abstract class PSDEActionDEModelBase
extends PSDataEntityModelBase<PSDEAction> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDEActionService pSDEActionService;

    public PSDEActionDEModelBase() throws Exception {
        this.setId("10eb1eb0a5de91ef5437264b8d3397b9");
        this.setName("PSDEACTION");
        this.setCodeName("PSDEAction");
        this.setTableName("T_SRFPSDEACTION");
        this.setViewName("v_PSDEACTION");
        this.setLogicName("\u5b9e\u4f53\u884c\u4e3a");
        this.setMemo("\u5b9e\u4f53\u7684\u884c\u4e3a\u6a21\u578b\uff0c\u5b9a\u4e49\u5b9e\u4f53\u5bf9\u5916\u63d0\u4f9b\u7684\u64cd\u4f5c\u80fd\u529b\u3002\u5b9e\u4f53\u884c\u4e3a\u63d0\u4f9b\u5185\u7f6e\u3001\u5904\u7406\u903b\u8f91\u53ca\u81ea\u5b9a\u4e49\u7b49\u7c7b\u578b\uff0c\u652f\u6301\u5b9a\u4e49\u884c\u4e3a\u53c2\u6570\u53ca\u8c03\u7528\u7684\u68c0\u67e5\u89c4\u5219\uff0c\u540c\u65f6\u652f\u6301\u9644\u52a0\u5185\u5916\u90e8\u5904\u7406\u903b\u8f91");
        this.setDSLink("DEFAULT");
        this.setEnableMultiDS(true);
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setEnableTempData(true);
        this.setUserTag("MODELV2");
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEActionDEModel", (IDataEntityModel)this);
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

    public PSDEActionService getRealService() {
        if (this.pSDEActionService == null) {
            try {
                this.pSDEActionService = (PSDEActionService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEActionService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEActionService";
    }

    public PSDEAction createEntity() {
        return new PSDEAction();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("ACTIONHOLDER");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a919f9d8626ffd374b63e783570e1dd7");
            pSDEFieldModel.setName("ACTIONHOLDER");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u884c\u4e3a\u6301\u6709\u8005");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DELogicHolderCodeListModel");
            pSDEFieldModel.setCodeName("ActionHolder");
            pSDEFieldModel.setUserTag2("\u6307\u5b9a\u63d0\u4f9b\u884c\u4e3a\u80fd\u529b\u7684\u6301\u6709\u8005\uff0c\u672a\u6307\u5b9a\u65f6\u4e3a\u3010\u540e\u53f0\u53ca\u524d\u53f0\u3011,\u5982\u884c\u4e3a\u7c7b\u578b\u4e3a\u3010\u5904\u7406\u903b\u8f91\u3011\u5219\u7531\u76f8\u5e94\u7684\u5904\u7406\u903b\u8f91\u51b3\u5b9a\uff0c\u5982\u5b9e\u4f53\u542f\u7528\u3010\u4e34\u65f6\u6570\u636e\u3011\u5219\u7531\u4e34\u65f6\u6570\u636e\u6a21\u5f0f\u51b3\u5b9a");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u63d0\u4f9b\u884c\u4e3a\u80fd\u529b\u7684\u6301\u6709\u8005\uff0c\u672a\u6307\u5b9a\u65f6\u4e3a\u3010\u540e\u53f0\u53ca\u524d\u53f0\u3011,\u5982\u884c\u4e3a\u7c7b\u578b\u4e3a\u3010\u5904\u7406\u903b\u8f91\u3011\u5219\u7531\u76f8\u5e94\u7684\u5904\u7406\u903b\u8f91\u51b3\u5b9a");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ACTIONHOLDER_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ACTIONHOLDER_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ACTIONMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b249b8a1ab3338461d64b808b35b8353");
            pSDEFieldModel.setName("ACTIONMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u884c\u4e3a\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionModeCodeListModel");
            pSDEFieldModel.setCodeName("ActionMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u7684\u6a21\u5f0f\uff0c\u884c\u4e3a\u6a21\u5f0f\u5b9a\u4e49\u4e86\u884c\u4e3a\u7684\u76ee\u7684\uff0c\u7528\u4e8e\u9884\u7f6e\u903b\u8f91\u7684\u9644\u52a0\u3002\u672a\u6307\u5b9a\u65f6\u6a21\u578b\u5f15\u64ce\u5c06\u5c1d\u8bd5\u81ea\u52a8\u8ba1\u7b97\uff0c\u65e0\u6cd5\u8ba1\u7b97\u5219\u4e3a\u3010\u672a\u77e5\u64cd\u4f5c\u3011");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ACTIONOPTION");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4f4c7f8a6174fdf07d8c88d3089dcc3d");
            pSDEFieldModel.setName("ACTIONOPTION");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u884c\u4e3a\u9009\u9879");
            pSDEFieldModel.setDataType("NMCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ActionOption");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ACTIONPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("550e857246abb1d1c8192cb800ada9b1");
            pSDEFieldModel.setName("ACTIONPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u884c\u4e3a\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ActionParams");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ACTIONTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("75293a455dac2a8eb59a9e7f4cb11e96");
            pSDEFieldModel.setName("ACTIONTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u884c\u4e3a\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ActionTag");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ACTIONTAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f68d7758790ebf4326bfe3799382745c");
            pSDEFieldModel.setName("ACTIONTAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u884c\u4e3a\u6807\u8bb02");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ActionTag2");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ACTIONTAG3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7ec7cd86a6a7df7234466c1f65209b44");
            pSDEFieldModel.setName("ACTIONTAG3");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u884c\u4e3a\u6807\u8bb03");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ActionTag3");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ACTIONTAG4");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b85f55316cdc42d863616b1b719976f3");
            pSDEFieldModel.setName("ACTIONTAG4");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u884c\u4e3a\u6807\u8bb04");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ActionTag4");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ACTIONTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fbe4bb5b63cdebcd91b2d61e39889ed7");
            pSDEFieldModel.setName("ACTIONTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u884c\u4e3a\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionType2CodeListModel");
            pSDEFieldModel.setCodeName("ActionType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u7684\u7c7b\u578b");
            pSDEFieldModel.setLength(40);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ACTIONTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ACTIONTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("AFTERCODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1ae336fedeeb71579d9cdbd7e9395e9e");
            pSDEFieldModel.setName("AFTERCODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6267\u884c\u4e4b\u540e\u4ee3\u7801");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("AfterCode");
            pSDEFieldModel.setMemo("\u5b9a\u4e49\u524d\u7aef\u5728\u884c\u4e3a\u6267\u884c\u4e4b\u540e\u9644\u52a0\u7684\u6267\u884c\u4ee3\u7801");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("BATCHACTIONMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e3aa5294d81ddc880de58ecf64625dc6");
            pSDEFieldModel.setName("BATCHACTIONMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6279\u64cd\u4f5c\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionBatchModeCodeListModel");
            pSDEFieldModel.setCodeName("BatchActionMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u662f\u5426\u652f\u6301\u6279\u64cd\u4f5c\u6a21\u5f0f");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_BATCHACTIONMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_BATCHACTIONMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("BEFORECODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d75eba9f4605ce2dc2f9d8231837b933");
            pSDEFieldModel.setName("BEFORECODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6267\u884c\u4e4b\u524d\u4ee3\u7801");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("BeforeCode");
            pSDEFieldModel.setMemo("\u5b9a\u4e49\u524d\u7aef\u5728\u884c\u4e3a\u6267\u884c\u4e4b\u524d\u9644\u52a0\u7684\u6267\u884c\u4ee3\u7801");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CACHECAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6f338d08206db38ed216d3301d1a0968");
            pSDEFieldModel.setName("CACHECAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f13\u5b58\u5206\u7c7b");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CacheCat");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CACHESCOPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("04e08fc3e222e7b23b11c8c91400ee8a");
            pSDEFieldModel.setName("CACHESCOPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f13\u5b58\u8303\u56f4");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEDSCacheScopeCodeListModel");
            pSDEFieldModel.setCodeName("CacheScope");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CACHESCOPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CACHESCOPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CACHETAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a04908655508e5bcf9189360d7fe9a5e");
            pSDEFieldModel.setName("CACHETAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f13\u5b58\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CacheTag");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CACHETIMEOUT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0d792f03eb811cf7952b15645c4eab67");
            pSDEFieldModel.setName("CACHETIMEOUT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f13\u5b58\u5931\u6548\u65f6\u957f");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CacheTimeout");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CALLEROBJ");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d5f035068a3a7b50995342cca185df3f");
            pSDEFieldModel.setName("CALLEROBJ");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8c03\u7528\u5bf9\u8c61");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CallerObj");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(250);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CALLTIMEOUT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("39fa70a2bb4c45bd529053a09b64b8b5");
            pSDEFieldModel.setName("CALLTIMEOUT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8c03\u7528\u8d85\u65f6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CallTimeout");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u8c03\u7528\u7684\u8d85\u65f6\u65f6\u957f\uff0c\u5355\u4f4d\u4e3a\u3010\u6beb\u79d2\u3011\u3002\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e24416b4b4e8b0ff4ad7dbf098318eea");
            pSDEFieldModel.setName("CODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CodeName");
            pSDEFieldModel.setMemo("\u884c\u4e3a\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5c5e\u5b9e\u4f53\u4e2d\u5177\u5907\u552f\u4e00\u6027");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CODENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CODENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CODENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CODENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
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
            pSDEFieldModel.setId("c763d6c8bb2d79d048a3f78ec74de5fb");
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
            pSDEFieldModel.setId("aa0f4328ede67abee75101fe0d2a23b9");
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
            pSDEFieldModel.setId("d0943395b6c5f7933f3f2d9d469cd6b9");
            pSDEFieldModel.setName("CUSTOMCODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u8054\u4ee3\u7801");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CustomCode");
            pSDEFieldModel.setMemo("\u884c\u4e3a\u7c7b\u578b\u4e3a\u3010\u811a\u672c\u3011\u65f6\u6307\u5b9a\u5185\u8054\u4ee3\u7801");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CUSTOMMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bbea06a6b3c2896ec0fe28d9e4c3e5ac");
            pSDEFieldModel.setName("CUSTOMMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u811a\u672c\u4ee3\u7801\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ScriptMode2CodeListModel");
            pSDEFieldModel.setCodeName("CustomMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u8fdb\u4e00\u6b65\u6307\u5b9a\u811a\u672c\u4ee3\u7801\u7684\u6a21\u5f0f");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DYNAMODELFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5fe0f20c3cad632060691906e770ffa7");
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
        object = this.createDEField("ENABLEAUDIT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5d625a8eeaf86b8b68d5446b6d7fbe42");
            pSDEFieldModel.setName("ENABLEAUDIT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u8bbf\u95ee\u5ba1\u8ba1");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableAudit");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLECACHE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0600859889d78490a4dda6a474f62efb");
            pSDEFieldModel.setName("ENABLECACHE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f13\u5b58\u6a21\u5f0f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableCache");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXTENDMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1649c74ec82ce4786ba07d7223b982e7");
            pSDEFieldModel.setName("EXTENDMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6269\u5c55\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEExtendModeCodeListModel");
            pSDEFieldModel.setCodeName("ExtendMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u7684\u6269\u5c55\u6a21\u5f0f\uff0c\u6b64\u914d\u7f6e\u9488\u5bf9\u5b50\u7cfb\u7edf\u5b9e\u4f53\uff0c\u6807\u8bb0\u662f\u5426\u8981\u5bf9\u539f\u529f\u80fd\u8fdb\u884c\u6269\u5c55\u3002\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u6269\u5c55\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EXTENDMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EXTENDMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FINISHFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d85e2609d29931e2511e4e694930e110");
            pSDEFieldModel.setName("FINISHFLAG");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b8c\u6210\u6807\u8bb0");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSTASK_PSSYSTASKID");
            pSDEFieldModel.setLinkDEFName("FINISHFLAG");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("FinishFlag");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INPSDEFGROUPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("30ccea2a7750ef65eac7a4d1618acbd5");
            pSDEFieldModel.setName("INPSDEFGROUPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u5c5e\u6027\u96c6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDEFGROUP_INPSDEFGROUPID");
            pSDEFieldModel.setLinkDEFName("PSDEFGROUPID");
            pSDEFieldModel.setCodeName("InPSDEFGroupId");
            pSDEFieldModel.setMemo("\u5bf9\u8f93\u5165\u4e3a\u5f53\u524d\u5b9e\u4f53\u6570\u636e\u5bf9\u8c61\u7684\u53c2\u6570\u8fdb\u4e00\u6b65\u6307\u5b9a\u5c5e\u6027\u96c6");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSDEFGROUPID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSDEFGROUPID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INPSDEFGROUPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("45373704f432cbdc0d76b45c54449db4");
            pSDEFieldModel.setName("INPSDEFGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u5c5e\u6027\u96c6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDEFGROUP_INPSDEFGROUPID");
            pSDEFieldModel.setLinkDEFName("PSDEFGROUPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("InPSDEFGroupName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSDEFGROUPNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSDEFGROUPNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSDEFGROUPNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSDEFGROUPNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INPSDESAMPLEDATAID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("56354ab6d92b4cdb2b3722556ba20584");
            pSDEFieldModel.setName("INPSDESAMPLEDATAID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u793a\u4f8b\u6570\u636e");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDESAMPLEDATA_INPSDESAMPLEDATAID");
            pSDEFieldModel.setLinkDEFName("PSDESAMPLEDATAID");
            pSDEFieldModel.setCodeName("InPSDESampleDataId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSDESAMPLEDATAID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSDESAMPLEDATAID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INPSDESAMPLEDATANAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8b9e444fac9fcf2454c4f3d14d821ca4");
            pSDEFieldModel.setName("INPSDESAMPLEDATANAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u793a\u4f8b\u6570\u636e");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDESAMPLEDATA_INPSDESAMPLEDATAID");
            pSDEFieldModel.setLinkDEFName("PSDESAMPLEDATANAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("InPSDESampleDataName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSDESAMPLEDATANAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSDESAMPLEDATANAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSDESAMPLEDATANAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSDESAMPLEDATANAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INPSSYSDYNAMODELID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c85732d876dc1a6da7bb9ae4996975f1");
            pSDEFieldModel.setName("INPSSYSDYNAMODELID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u5bf9\u8c61\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSDYNAMODEL_INPSSYSDYNAMODELID");
            pSDEFieldModel.setLinkDEFName("PSSYSDYNAMODELID");
            pSDEFieldModel.setCodeName("InPSSysDynaModelId");
            pSDEFieldModel.setMemo("\u53c2\u6570\u6a21\u5f0f\u4e3a\u3010\u5176\u5b83\u5bf9\u8c61\u3011\u65f6\u6307\u5b9a\u7684\u5bf9\u8c61\u6a21\u578b");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSSYSDYNAMODELID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSSYSDYNAMODELID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INPSSYSDYNAMODELNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("682ae2f9a5c3223f02908841ff58ddbb");
            pSDEFieldModel.setName("INPSSYSDYNAMODELNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u5bf9\u8c61\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSDYNAMODEL_INPSSYSDYNAMODELID");
            pSDEFieldModel.setLinkDEFName("PSSYSDYNAMODELNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("InPSSysDynaModelName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSSYSDYNAMODELNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSSYSDYNAMODELNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSSYSDYNAMODELNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSSYSDYNAMODELNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LOCKFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("547ec205197b7c9eabd88a04a3de6140");
            pSDEFieldModel.setName("LOCKFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u578b\u9501\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
            pSDEFieldModel.setCodeName("LockFlag");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LOGICNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("70532934a1dd116dcea080352e2c48f5");
            pSDEFieldModel.setName("LOGICNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u6587\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("LogicName");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LOGICNAME_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LOGICNAME_LIKE");
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
            pSDEFieldModel.setId("6a7ba9812eb3dc5db872d72d48ddba95");
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
        object = this.createDEField("NEEDRESOURCEKEY");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("dc412734abdfae08d3d41d8c2b1fa3e2");
            pSDEFieldModel.setName("NEEDRESOURCEKEY");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u72ec\u7acb\u8f93\u51fa\u8d44\u6e90\u952e\u503c");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("NeedResourceKey");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u5728\u670d\u52a1\u63a5\u53e3\u4e2d\u662f\u5426\u9700\u8981\u72ec\u7acb\u8f93\u51fa\u8d44\u6e90\u952e\u503c\uff0c\u5982{key}/action\uff0c\u672a\u5b9a\u4e49\u7531\u884c\u4e3a\u6a21\u5f0f\u5224\u65ad");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ORDERVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("99e263cf76abbbd0728f6e9f95c8df45");
            pSDEFieldModel.setName("ORDERVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6392\u5e8f\u503c");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("OrderValue");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTPSDEFGROUPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ae2c082e58861cddbfc9764ae78df2fa");
            pSDEFieldModel.setName("OUTPSDEFGROUPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u5c5e\u6027\u96c6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDEFGROUP_OUTPSDEFGROUPID");
            pSDEFieldModel.setLinkDEFName("PSDEFGROUPID");
            pSDEFieldModel.setCodeName("OutPSDEFGroupId");
            pSDEFieldModel.setMemo("\u5bf9\u8f93\u51fa\u4e3a\u5f53\u524d\u5b9e\u4f53\u6570\u636e\u5bf9\u8c61\u7684\u8fd4\u56de\u503c\u8fd1\u4e00\u6b65\u6307\u5b9a\u5c5e\u6027\u96c6");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSDEFGROUPID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSDEFGROUPID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTPSDEFGROUPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5899142813c76f0bed341a6f1cfd19c3");
            pSDEFieldModel.setName("OUTPSDEFGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u5c5e\u6027\u96c6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDEFGROUP_OUTPSDEFGROUPID");
            pSDEFieldModel.setLinkDEFName("PSDEFGROUPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("OutPSDEFGroupName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSDEFGROUPNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSDEFGROUPNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSDEFGROUPNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSDEFGROUPNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTPSDESAMPLEDATAID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cb97c7ed5bb4942b66b511bc7dd20556");
            pSDEFieldModel.setName("OUTPSDESAMPLEDATAID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u793a\u4f8b\u6570\u636e");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDESAMPLEDATA_OUTPSDESAMPLEDATAID");
            pSDEFieldModel.setLinkDEFName("PSDESAMPLEDATAID");
            pSDEFieldModel.setCodeName("OutPSDESampleDataId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSDESAMPLEDATAID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSDESAMPLEDATAID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTPSDESAMPLEDATANAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0035ed02dcc17eb23a4f9cbe6eb3342e");
            pSDEFieldModel.setName("OUTPSDESAMPLEDATANAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u793a\u4f8b\u6570\u636e");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDESAMPLEDATA_OUTPSDESAMPLEDATAID");
            pSDEFieldModel.setLinkDEFName("PSDESAMPLEDATANAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("OutPSDESampleDataName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSDESAMPLEDATANAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSDESAMPLEDATANAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSDESAMPLEDATANAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSDESAMPLEDATANAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTPSSYSDYNAMODELID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("aa08a004f1eeb3337ef4aadf71793239");
            pSDEFieldModel.setName("OUTPSSYSDYNAMODELID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u5bf9\u8c61\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSDYNAMODEL_OUTPSSYSDYNAMODELID");
            pSDEFieldModel.setLinkDEFName("PSSYSDYNAMODELID");
            pSDEFieldModel.setCodeName("OutPSSysDynaModelId");
            pSDEFieldModel.setMemo("\u8fd4\u56de\u503c\u4e3a\u5176\u5b83\u5bf9\u8c61\u65f6\u6307\u5b9a\u7684\u52a8\u6001\u6a21\u578b\u5bf9\u8c61");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSSYSDYNAMODELID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSSYSDYNAMODELID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTPSSYSDYNAMODELNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("45fbc2756d2a2ea1bec5108ab4e2186f");
            pSDEFieldModel.setName("OUTPSSYSDYNAMODELNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u5bf9\u8c61\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSDYNAMODEL_OUTPSSYSDYNAMODELID");
            pSDEFieldModel.setLinkDEFName("PSSYSDYNAMODELNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("OutPSSysDynaModelName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSSYSDYNAMODELNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSSYSDYNAMODELNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSSYSDYNAMODELNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSSYSDYNAMODELNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTREFPSDEFGROUPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("464fe085868ead96760a7a4c3519a129");
            pSDEFieldModel.setName("OUTREFPSDEFGROUPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u5f15\u7528\u5b9e\u4f53\u7684\u5c5e\u6027\u7ec4");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDEFGROUP_OUTREFPSDEFGROUPID");
            pSDEFieldModel.setLinkDEFName("PSDEFGROUPID");
            pSDEFieldModel.setCodeName("OutRefPSDEFGroupId");
            pSDEFieldModel.setMemo("\u8fdb\u4e00\u6b65\u4e3a\u8f93\u51fa\u5f15\u7528\u5b9e\u4f53\u6307\u5b9a\u5c5e\u6027\u7ec4");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTREFPSDEFGROUPID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTREFPSDEFGROUPID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTREFPSDEFGROUPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d334641e1a802060a81e787b70524cbc");
            pSDEFieldModel.setName("OUTREFPSDEFGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u5f15\u7528\u5b9e\u4f53\u7684\u5c5e\u6027\u7ec4");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDEFGROUP_OUTREFPSDEFGROUPID");
            pSDEFieldModel.setLinkDEFName("PSDEFGROUPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("OutRefPSDEFGroupName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTREFPSDEFGROUPNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTREFPSDEFGROUPNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTREFPSDEFGROUPNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTREFPSDEFGROUPNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTREFPSDEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ada8daa3acd0e78f6be3a32f7e5c901b");
            pSDEFieldModel.setName("OUTREFPSDEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u5f15\u7528\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDATAENTITY_OUTREFPSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYID");
            pSDEFieldModel.setCodeName("OutRefPSDEId");
            pSDEFieldModel.setMemo("\u8fd4\u56de\u503c\u4e3a\u5916\u90e8\u6570\u636e\u65f6\u6307\u5b9a\u7684\u5f15\u7528\u5b9e\u4f53");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTREFPSDEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTREFPSDEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTREFPSDENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2eeff023d6985995109688845fe084e7");
            pSDEFieldModel.setName("OUTREFPSDENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u5f15\u7528\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDATAENTITY_OUTREFPSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("OutRefPSDEName");
            pSDEFieldModel.setLength(60);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTREFPSDENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTREFPSDENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTREFPSDENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTREFPSDENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PARAMTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5fcd9a9326cf6540ebb58732c5d7f038");
            pSDEFieldModel.setName("PARAMTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u53c2\u6570\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionParamModeCodeListModel");
            pSDEFieldModel.setCodeName("ParamType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u4f20\u5165\u7684\u53c2\u6570\u6a21\u5f0f\uff0c\u6307\u5b9a\u4e3a\u3010\u6307\u5b9a\u53c2\u6570\u3011\u65f6\u9700\u989d\u5916\u5b9a\u4e49\u53c2\u6570\u6e05\u5355\u3002\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5168\u90e8\u53c2\u6570\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PARAMTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PARAMTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("POTIME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7b118187ed66074a64375fee6a09fb3d");
            pSDEFieldModel.setName("POTIME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6027\u80fd\u4f18\u5316\u65f6\u95f4");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("POTime");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u6027\u80fd\u4f18\u5316\u68c0\u6d4b\u65f6\u957f\uff08\u6beb\u79d2\uff09\uff0c\u8d85\u8fc7\u6b64\u65f6\u957f\u5c06\u9700\u8981\u8fdb\u884c\u65e5\u5fd7\u7b49\u5904\u7406\u3002\u672a\u6307\u5b9a\u65f6\u4e3a\u3010-1\u3011\uff0c\u4f7f\u7528\u9ed8\u8ba4\u68c0\u6d4b\u65f6\u957f");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREDEFINEDTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c9f352bf4763ac235a24683ab8d650dc");
            pSDEFieldModel.setName("PREDEFINEDTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9884\u5b9a\u4e49\u7c7b\u578b");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PredefinedType");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREDEFINEDTYPEPARAM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fc913b103fa892b3e49a3648d3a287b3");
            pSDEFieldModel.setName("PREDEFINEDTYPEPARAM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9884\u5b9a\u4e49\u7c7b\u578b\u53c2\u6570");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PredefinedTypeParam");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREDEFINEDTYPETEXT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e1dacad94f588d3ad61b61ca65eb444c");
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
        object = this.createDEField("PREPARELAST");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("06f1ae43cf9381df966222ad8f85b317");
            pSDEFieldModel.setName("PREPARELAST");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u51c6\u5907\u4e0a\u6b21\u6570\u636e");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionPrepareLastModeCodeListModel");
            pSDEFieldModel.setCodeName("PrepareLast");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5728\u64cd\u4f5c\u4e4b\u524d\u51c6\u5907\u6700\u540e\u6570\u636e\u6a21\u5f0f\uff0c\u9ed8\u8ba4\u4e3a\u3010\u4e0d\u51c6\u5907\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEACTIONID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("96f08d99e8f37031ab660d786fd96ca8");
            pSDEFieldModel.setName("PSDEACTIONID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u884c\u4e3a\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDEActionId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEACTIONLOGICSCNT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9ce1d9015eeddf2b1cd0dea76602a8d1");
            pSDEFieldModel.setName("PSDEACTIONLOGICSCNT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u884c\u4e3a\u903b\u8f91\u8ba1\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDEActionLogicsCnt");
            pSDEFieldModel.setEnableTempData(false);
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEACTIONNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c3fbabe9b766a4c87bafd76621048daa");
            pSDEFieldModel.setName("PSDEACTIONNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u884c\u4e3a\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSDEActionName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u7684\u6807\u8bc6\uff0c\u9700\u8981\u5728\u6240\u5728\u7684\u5b9e\u4f53\u4e2d\u5177\u6709\u552f\u4e00\u6027");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEACTIONNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEACTIONNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEACTIONNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEACTIONNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEACTIONTEMPLID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("496bc28d5517a92b3020a608e40d2b90");
            pSDEFieldModel.setName("PSDEACTIONTEMPLID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u884c\u4e3a\u6a21\u677f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDEACTIONTEMPL_PSDEACTIONTEMPLID");
            pSDEFieldModel.setLinkDEFName("PSDEACTIONTEMPLID");
            pSDEFieldModel.setCodeName("PSDEActionTemplId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEACTIONTEMPLID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEACTIONTEMPLID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEACTIONTEMPLNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("62f8185b66c950a53df47ac8f90de1d5");
            pSDEFieldModel.setName("PSDEACTIONTEMPLNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u884c\u4e3a\u6a21\u677f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDEACTIONTEMPL_PSDEACTIONTEMPLID");
            pSDEFieldModel.setLinkDEFName("PSDEACTIONTEMPLNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEActionTemplName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEACTIONTEMPLNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEACTIONTEMPLNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEACTIONTEMPLNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEACTIONTEMPLNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDATAFLOWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("669158ca0eabe20964a532ad8720dd45");
            pSDEFieldModel.setName("PSDEDATAFLOWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6570\u636e\u6d41\u903b\u8f91");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDELOGIC_PSDEDATAFLOWID");
            pSDEFieldModel.setLinkDEFName("PSDELOGICID");
            pSDEFieldModel.setCodeName("PSDEDataFlowId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATAFLOWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATAFLOWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDATAFLOWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("351ca9613218b5034a4909215a1b2314");
            pSDEFieldModel.setName("PSDEDATAFLOWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6570\u636e\u6d41\u903b\u8f91");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDELOGIC_PSDEDATAFLOWID");
            pSDEFieldModel.setLinkDEFName("PSDELOGICNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEDataFlowName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATAFLOWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATAFLOWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATAFLOWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATAFLOWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDATAQUERYID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b257e4f692154380c22c6b5cde473214");
            pSDEFieldModel.setName("PSDEDATAQUERYID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6570\u636e\u67e5\u8be2");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDEDATAQUERY_PSDEDATAQUERYID");
            pSDEFieldModel.setLinkDEFName("PSDEDATAQUERYID");
            pSDEFieldModel.setCodeName("PSDEDataQueryId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATAQUERYID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATAQUERYID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDATAQUERYNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1ca50810f693fb44fd8c6dd1264f87a5");
            pSDEFieldModel.setName("PSDEDATAQUERYNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6570\u636e\u67e5\u8be2");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDEDATAQUERY_PSDEDATAQUERYID");
            pSDEFieldModel.setLinkDEFName("PSDEDATAQUERYNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEDataQueryName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATAQUERYNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATAQUERYNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATAQUERYNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATAQUERYNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDATASETID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e3e2f09e2511bf6036eb804010d7cb38");
            pSDEFieldModel.setName("PSDEDATASETID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6570\u636e\u96c6\u5408");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDEDATASET_PSDEDATASETID");
            pSDEFieldModel.setLinkDEFName("PSDEDATASETID");
            pSDEFieldModel.setCodeName("PSDEDataSetId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATASETID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATASETID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDATASETNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5291473666a7af55dd6d9dd1938d1f3a");
            pSDEFieldModel.setName("PSDEDATASETNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6570\u636e\u96c6\u5408");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDEDATASET_PSDEDATASETID");
            pSDEFieldModel.setLinkDEFName("PSDEDATASETNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEDataSetName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATASETNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATASETNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATASETNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATASETNAME_LIKE");
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
            pSDEFieldModel.setId("420fc9269671a42af24a5e9fdacca603");
            pSDEFieldModel.setName("PSDEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDATAENTITY_PSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDEId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDELOGICID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("35f2ec81e4bbc0f36bd8b6006b6a99b5");
            pSDEFieldModel.setName("PSDELOGICID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5904\u7406\u903b\u8f91");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDELOGIC_PSDELOGICID");
            pSDEFieldModel.setLinkDEFName("PSDELOGICID");
            pSDEFieldModel.setCodeName("PSDELogicId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDELOGICID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDELOGICID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDELOGICNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("19641de24eaec680c00024d8a164a207");
            pSDEFieldModel.setName("PSDELOGICNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5904\u7406\u903b\u8f91");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDELOGIC_PSDELOGICID");
            pSDEFieldModel.setLinkDEFName("PSDELOGICNAME");
            pSDEFieldModel.setCodeName("PSDELogicName");
            pSDEFieldModel.setMemo("\u5f53\u884c\u4e3a\u7c7b\u578b\u4e3a\u3010\u5904\u7406\u903b\u8f91\u3011\u65f6\u6307\u5b9a\u5f53\u524d\u5b9e\u4f53\u7684\u5904\u7406\u903b\u8f91");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDELOGICNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDELOGICNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDELOGICNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDELOGICNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEMSACTIONSCNT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f0a8065d05d3d969901405afeac8d04a");
            pSDEFieldModel.setName("PSDEMSACTIONSCNT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u4e3b\u72b6\u6001\u64cd\u4f5c\u8ba1\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDEMSActionsCnt");
            pSDEFieldModel.setEnableTempData(false);
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1b57e3d029a41001a31899131a291076");
            pSDEFieldModel.setName("PSDENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDATAENTITY_PSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYNAME");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDEName");
            pSDEFieldModel.setLength(60);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEOPPRIVID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c85223dd6122c7cec9a38449ec87648a");
            pSDEFieldModel.setName("PSDEOPPRIVID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8bbf\u95ee\u64cd\u4f5c\u6807\u8bc6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDEOPPRIV_PSDEOPPRIVID");
            pSDEFieldModel.setLinkDEFName("PSDEOPPRIVID");
            pSDEFieldModel.setCodeName("PSDEOPPrivId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEOPPRIVID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEOPPRIVID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEOPPRIVNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("dcb9ec9cfa9902a410822d13deed1d8e");
            pSDEFieldModel.setName("PSDEOPPRIVNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8bbf\u95ee\u64cd\u4f5c\u6807\u8bc6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDEOPPRIV_PSDEOPPRIVID");
            pSDEFieldModel.setLinkDEFName("PSDEOPPRIVNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEOPPrivName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8c03\u7528\u8be5\u884c\u4e3a\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\uff0c\u672a\u6307\u5b9a\u65f6\u6a21\u578b\u5f15\u64ce\u4f1a\u5c1d\u8bd5\u8ba1\u7b97");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEOPPRIVNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEOPPRIVNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEOPPRIVNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEOPPRIVNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDESYSPROCID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e6e02cd109a0560a23a5a1f1dff644e1");
            pSDEFieldModel.setName("PSDESYSPROCID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u7cfb\u7edf\u8fc7\u7a0b");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDESYSPROC_PSDESYSPROCID");
            pSDEFieldModel.setLinkDEFName("PSDESYSPROCID");
            pSDEFieldModel.setCodeName("PSDESysProcId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDESYSPROCID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDESYSPROCID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDESYSPROCNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("04e68a6343125fc24f6513a77ccca298");
            pSDEFieldModel.setName("PSDESYSPROCNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u7cfb\u7edf\u8fc7\u7a0b");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDESYSPROC_PSDESYSPROCID");
            pSDEFieldModel.setLinkDEFName("PSDESYSPROCNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDESysProcName");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDESYSPROCNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDESYSPROCNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDESYSPROCNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDESYSPROCNAME_LIKE");
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
            pSDEFieldModel.setId("82c06a5272c693ed84ff0fd4f32b6a3a");
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
        object = this.createDEField("PSSUBSYSSADEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0baf9c182c470a6ada3c4e53f550c168");
            pSDEFieldModel.setName("PSSUBSYSSADEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("PSSUBSYSSADEID");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSDATAENTITY_PSDEID");
            pSDEFieldModel.setLinkDEFName("PSSUBSYSSADEID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSubSysSADEId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSUBSYSSADETAILID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("aee141e636d5ace6d851a707cf9f4eb3");
            pSDEFieldModel.setName("PSSUBSYSSADETAILID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSUBSYSSADETAIL_PSSUBSYSSADETAILID");
            pSDEFieldModel.setLinkDEFName("PSSUBSYSSADETAILID");
            pSDEFieldModel.setCodeName("PSSubSysSADetailId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSUBSYSSADETAILID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSUBSYSSADETAILID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSUBSYSSADETAILNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ab2f900d20f36d44ceb23001ece943ce");
            pSDEFieldModel.setName("PSSUBSYSSADETAILNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSUBSYSSADETAIL_PSSUBSYSSADETAILID");
            pSDEFieldModel.setLinkDEFName("PSSUBSYSSADETAILNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSubSysSADetailName");
            pSDEFieldModel.setMemo("\u5b9e\u4f53\u652f\u6301\u5916\u90e8\u63a5\u53e3\u6301\u4e45\u5316\u65f6\u6307\u5b9a\u884c\u4e3a\u7ed1\u5b9a\u7684\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5\uff0c\u672a\u6307\u5b9a\u65f6\u5f15\u64ce\u5c06\u901a\u8fc7\u4ee3\u7801\u540d\u79f0\u5c1d\u8bd5\u83b7\u53d6\u5bf9\u5e94\u7684\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSUBSYSSADETAILNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSUBSYSSADETAILNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSUBSYSSADETAILNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSUBSYSSADETAILNAME_LIKE");
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
            pSDEFieldModel.setId("af4545a0c7be5d44b41082c1e59e9159");
            pSDEFieldModel.setName("PSSYSDYNAMODELID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u7cfb\u7edf\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSDYNAMODEL_PSSYSDYNAMODELID");
            pSDEFieldModel.setLinkDEFName("PSSYSDYNAMODELID");
            pSDEFieldModel.setCodeName("PSSysDynaModelId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
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
            pSDEFieldModel.setId("28e3b7be9066587321655400f54f4ddf");
            pSDEFieldModel.setName("PSSYSDYNAMODELNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u7cfb\u7edf\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSDYNAMODEL_PSSYSDYNAMODELID");
            pSDEFieldModel.setLinkDEFName("PSSYSDYNAMODELNAME");
            pSDEFieldModel.setPhisicalDEField(false);
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
        object = this.createDEField("PSSYSPFPLUGINID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("429094ae7d5e415c46983750fad00362");
            pSDEFieldModel.setName("PSSYSPFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSPFPLUGIN_PSSYSPFPLUGINID");
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
            pSDEFieldModel.setId("1e944d70348e2a34aefbfa2dfc94f7cd");
            pSDEFieldModel.setName("PSSYSPFPLUGINNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSPFPLUGIN_PSSYSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSPFPLUGINNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysPFPluginName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5\u63d2\u4ef6\u3011");
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
        object = this.createDEField("PSSYSREQITEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("774bb92c8ba80b2e80a754e68e6f52ea");
            pSDEFieldModel.setName("PSSYSREQITEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8bbe\u8ba1\u9700\u6c42");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSREQITEM_PSSYSREQITEMID");
            pSDEFieldModel.setLinkDEFName("PSSYSREQITEMID");
            pSDEFieldModel.setCodeName("PSSysReqItemId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSREQITEMID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSREQITEMID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSREQITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b9e79893337afee2964ede4ea5c0e209");
            pSDEFieldModel.setName("PSSYSREQITEMNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8bbe\u8ba1\u9700\u6c42");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSREQITEM_PSSYSREQITEMID");
            pSDEFieldModel.setLinkDEFName("PSSYSREQITEMNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysReqItemName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSREQITEMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSREQITEMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSREQITEMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSREQITEMNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSSFPLUGINID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("163c8d734b963caa38eea49d11640ae5");
            pSDEFieldModel.setName("PSSYSSFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540e\u53f0\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSSFPLUGIN_PSSYSSFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSSFPLUGINID");
            pSDEFieldModel.setCodeName("PSSysSFPluginId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSSFPLUGINID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSSFPLUGINID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSSFPLUGINNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c5e35b0592da79ff7605e16bcdaddb80");
            pSDEFieldModel.setName("PSSYSSFPLUGINNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u540e\u53f0\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSSFPLUGIN_PSSYSSFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSSFPLUGINNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysSFPluginName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u4f7f\u7528\u7684\u540e\u53f0\u6a21\u677f\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSSFPLUGINNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSSFPLUGINNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSSFPLUGINNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSSFPLUGINNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTASKID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9c35aeb20a7c3466ee964c0b26ecd6f0");
            pSDEFieldModel.setName("PSSYSTASKID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u4efb\u52a1");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSTASK_PSSYSTASKID");
            pSDEFieldModel.setLinkDEFName("PSSYSTASKID");
            pSDEFieldModel.setCodeName("PSSysTaskId");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTASKID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTASKID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTASKNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cbac98dd0e221e7b24d30d1a6dd5ba7d");
            pSDEFieldModel.setName("PSSYSTASKNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u4efb\u52a1");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSTASK_PSSYSTASKID");
            pSDEFieldModel.setLinkDEFName("PSSYSTASKNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysTaskName");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTASKNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTASKNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTASKNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTASKNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTESTCASESCNT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7218636cb4ef9fbc6dae1ae1eb002ad3");
            pSDEFieldModel.setName("PSSYSTESTCASESCNT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u6d4b\u8bd5\u7528\u4f8b\u8ba1\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSSysTestCasesCnt");
            pSDEFieldModel.setEnableTempData(false);
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSUNISTATEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("60561ec72473bde59acece0cb2621af4");
            pSDEFieldModel.setName("PSSYSUNISTATEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u72b6\u6001\u534f\u8c03");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSUNISTATE_PSSYSUNISTATEID");
            pSDEFieldModel.setLinkDEFName("PSSYSUNISTATEID");
            pSDEFieldModel.setCodeName("PSSysUniStateId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSUNISTATEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSUNISTATEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSUNISTATENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("34a7b1b573302c9247bfad3e6dce1574");
            pSDEFieldModel.setName("PSSYSUNISTATENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u72b6\u6001\u534f\u8c03");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEACTION_PSSYSUNISTATE_PSSYSUNISTATEID");
            pSDEFieldModel.setLinkDEFName("PSSYSUNISTATENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysUniStateName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSUNISTATENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSUNISTATENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSUNISTATENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSUNISTATENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PUBMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8d5f8776e30751a4ade1efb1186abf74");
            pSDEFieldModel.setName("PUBMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u542f\u7528\u670d\u52a1");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColor5CodeListModel");
            pSDEFieldModel.setCodeName("PubMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u662f\u5426\u9ed8\u8ba4\u63d0\u4f9b\u670d\u52a1\u80fd\u529b\uff0c\u672a\u6307\u5b9a\u65f6\u4f7f\u7528\u5b9e\u4f53\u5b9a\u4e49\u7684\u9ed8\u8ba4\u884c\u4e3a\u670d\u52a1\u80fd\u529b");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RAWSERVICEMETHOD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b04075a905d9e050c44fdd77fd8c55f1");
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
            pSDEFieldModel.setId("c231ebea94a2e2be4c85989db03f16b9");
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
        object = this.createDEField("REQUESTFIELD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a21821441804709dfd2e0e54c5890bb0");
            pSDEFieldModel.setName("REQUESTFIELD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8bf7\u6c42\u5c5e\u6027\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RequestField");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u5728\u670d\u52a1\u53c2\u6570\u7c7b\u578b\u4e3a\u3010\u6307\u5b9a\u5c5e\u6027\u3011\u65f6\u5c5e\u6027\u7684\u540d\u79f0\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5b9e\u4f53\u7684\u4e3b\u952e\u5c5e\u6027");
            pSDEFieldModel.setLength(40);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REQUESTMETHOD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8668b444df909a4b22bf365b0e352308");
            pSDEFieldModel.setName("REQUESTMETHOD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8bf7\u6c42\u65b9\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
            pSDEFieldModel.setCodeName("RequestMethod");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u5728\u63d0\u4f9b\u670d\u52a1\u65f6\u4f7f\u7528\u7684\u8bf7\u6c42\u65b9\u5f0f");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REQUESTMETHOD_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REQUESTMETHOD_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REQUESTPARAMTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b2566d17d0fa0d5dfd857fbd01743e26");
            pSDEFieldModel.setName("REQUESTPARAMTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8bf7\u6c42\u53c2\u6570\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ServiceReqParamTypeCodeListModel");
            pSDEFieldModel.setCodeName("RequestParamType");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u5728\u63d0\u4f9b\u670d\u52a1\u65f6\u4f7f\u7528\u7684\u53c2\u6570\u7c7b\u578b");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REQUESTPARAMTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REQUESTPARAMTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REQUESTPATH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cecdbcbfa68850e4f4b2c88dbcfd5e54");
            pSDEFieldModel.setName("REQUESTPATH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8bf7\u6c42\u8def\u5f84");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RequestPath");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RETSTDDATATYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("efc9240f7b66db667bd07dc007ed6e3f");
            pSDEFieldModel.setName("RETSTDDATATYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8fd4\u56de\u6570\u636e\u7c7b\u578b");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.StdDataTypeCodeListModel");
            pSDEFieldModel.setCodeName("RetStdDataType");
            pSDEFieldModel.setMemo("\u8fd4\u56de\u503c\u7c7b\u578b\u4e3a\u7b80\u5355\u503c\u65f6\u6307\u5b9a\u5177\u4f53\u7684\u6570\u636e\u7c7b\u578b");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_RETSTDDATATYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_RETSTDDATATYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RETVALTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bc98b65a6478b78a4d72f8795666137c");
            pSDEFieldModel.setName("RETVALTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8fd4\u56de\u503c\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionRetValTypeCodeListModel");
            pSDEFieldModel.setCodeName("RetValType");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_RETVALTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_RETVALTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SERVICECODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f1bfa69c66bb813904ad98b75bd20d1e");
            pSDEFieldModel.setName("SERVICECODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u670d\u52a1\u4ee3\u7801\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ServiceCodeName");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SUBSYSSADETAILMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8f49da87672b7bee9e87313bc67134c5");
            pSDEFieldModel.setName("SUBSYSSADETAILMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5916\u90e8\u63a5\u53e3\u65b9\u6cd5\u7ed1\u5b9a");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.SubSysSADEMethodBindingModeCodeListModel");
            pSDEFieldModel.setCodeName("SubSysSADetailMode");
            pSDEFieldModel.setMemo("\u5b9e\u4f53\u652f\u6301\u5916\u90e8\u63a5\u53e3\u6301\u4e45\u5316\u65f6\u6307\u5b9a\u884c\u4e3a\u7ed1\u5b9a\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5\u6a21\u5f0f\uff0c\u9ed8\u8ba4\u4e3a\u3010\u81ea\u52a8\u7ed1\u5b9a\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SYNCEVENT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3dfc8a40b4f4d4032a8cb90d5f7f63a1");
            pSDEFieldModel.setName("SYNCEVENT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540c\u6b65\u4e8b\u4ef6");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionSyncEventCodeListModel");
            pSDEFieldModel.setCodeName("SyncEvent");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u89e6\u53d1\u7684\u540c\u6b65\u4e8b\u4ef6");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SYNCEVENT_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SYNCEVENT_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TESTACTIONMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4da40c0c6b79b7818bcc604be9374c20");
            pSDEFieldModel.setName("TESTACTIONMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6d4b\u8bd5\u884c\u4e3a\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionTestActionModeCodeListModel");
            pSDEFieldModel.setCodeName("TestActionMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u7684\u6d4b\u8bd5\u884c\u4e3a\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u6d4b\u8bd5\u884c\u4e3a\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TESTACTIONMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TESTACTIONMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TESTCASEFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d79e3fa9f85a219e934cbced241c34ba");
            pSDEFieldModel.setName("TESTCASEFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u6d4b\u8bd5\u5355\u5143");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColor8CodeListModel");
            pSDEFieldModel.setCodeName("TestCaseFlag");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u662f\u5426\u5bf9\u884c\u4e3a\u4ea7\u751f\u6d4b\u8bd5\u5355\u5143\uff0c\u672a\u5b9a\u4e49\u65f6\u5185\u7f6e\u884c\u4e3a\u5c06\u8bbe\u5b9a\u4e3a\u3010\u662f\u3011\uff0c\u5176\u4ed6\u884c\u4e3a\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TODOTASK");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0026db2e0d54983995080811040d98dc");
            pSDEFieldModel.setName("TODOTASK");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("TODO");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ToDoTask");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TSMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cefaebc659c7a476baf4839a0adb8a88");
            pSDEFieldModel.setName("TSMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e8b\u52a1\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionTSModeCodeListModel");
            pSDEFieldModel.setCodeName("TSMode");
            pSDEFieldModel.setUserTag2("\u6307\u5b9a\u884c\u4e3a\u7684\u4e8b\u52a1\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u884c\u4e3a\u65f6\u903b\u8f91\u7ee7\u627f\u7684\u5b9e\u4f53\u884c\u4e3a\u5c06\u88ab\u8bbe\u5b9a\u4e3a\u3010\u5206\u5e03\u5f0f\u4e8b\u52a1\u3011\uff0c\u5176\u4f59\u4e3a\u3010\u9ed8\u8ba4\u3011\uff0c\u7531\u6267\u884c\u4f53\u7cfb\u51b3\u5b9a");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u7684\u4e8b\u52a1\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u4e3a\u3010\u9ed8\u8ba4\u3011\uff0c\u7531\u6267\u884c\u4f53\u7cfb\u51b3\u5b9a");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TSMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TSMODE_EQ");
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
            pSDEFieldModel.setId("ea9fc424e7f8d3140b5f966852637999");
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
            pSDEFieldModel.setId("4995ce743bd2ca20d387c35d5935f599");
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
        object = this.createDEField("USERCAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a5dbd5aaf63af55f8c3b7406f4e76205");
            pSDEFieldModel.setName("USERCAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u5206\u7c7b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelUserCatCodeListModel");
            pSDEFieldModel.setCodeName("UserCat");
            pSDEFieldModel.setLength(10);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_USERCAT_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_USERCAT_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e854b408498807cb60a383702108bf6e");
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
            pSDEFieldModel.setId("205de8dda07dcfda15ba491c566c9793");
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
            pSDEFieldModel.setId("3bb2082e5dfc97e9e33fa48f62d5f8a9");
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
        object = this.createDEField("USERTAG3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("93c3c82251456eb98b832c924567dec5");
            pSDEFieldModel.setName("USERTAG3");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb03");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag3");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_USERTAG3_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_USERTAG3_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG4");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("32202013f6388d31adbe38a87db7a8ca");
            pSDEFieldModel.setName("USERTAG4");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb04");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag4");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_USERTAG4_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_USERTAG4_EQ");
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
            pSDEFieldModel.setId("1afd8b19bee8b13eb9cdf631bad46947");
            pSDEFieldModel.setName("VALIDFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ValidFlag");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSDEActionDefaultACModel pSDEActionDefaultACModel = new PSDEActionDefaultACModel();
        pSDEActionDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDEActionDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDEActionCurDEDSModel pSDEActionCurDEDSModel = new PSDEActionCurDEDSModel();
        pSDEActionCurDEDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEActionCurDEDSModel);
        PSDEActionCurModDSModel pSDEActionCurModDSModel = new PSDEActionCurModDSModel();
        pSDEActionCurModDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEActionCurModDSModel);
        PSDEActionCurSysDSModel pSDEActionCurSysDSModel = new PSDEActionCurSysDSModel();
        pSDEActionCurSysDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEActionCurSysDSModel);
        PSDEActionCurSysNotBuiltinDSModel pSDEActionCurSysNotBuiltinDSModel = new PSDEActionCurSysNotBuiltinDSModel();
        pSDEActionCurSysNotBuiltinDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEActionCurSysNotBuiltinDSModel);
        PSDEActionCurSysNotSubSysDSModel pSDEActionCurSysNotSubSysDSModel = new PSDEActionCurSysNotSubSysDSModel();
        pSDEActionCurSysNotSubSysDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEActionCurSysNotSubSysDSModel);
        PSDEActionDefaultDSModel pSDEActionDefaultDSModel = new PSDEActionDefaultDSModel();
        pSDEActionDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEActionDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDEActionCurDEDQModel pSDEActionCurDEDQModel = new PSDEActionCurDEDQModel();
        pSDEActionCurDEDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEActionCurDEDQModel);
        PSDEActionCurModDQModel pSDEActionCurModDQModel = new PSDEActionCurModDQModel();
        pSDEActionCurModDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEActionCurModDQModel);
        PSDEActionCurSysDQModel pSDEActionCurSysDQModel = new PSDEActionCurSysDQModel();
        pSDEActionCurSysDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEActionCurSysDQModel);
        PSDEActionCurSysNotBuiltinDQModel pSDEActionCurSysNotBuiltinDQModel = new PSDEActionCurSysNotBuiltinDQModel();
        pSDEActionCurSysNotBuiltinDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEActionCurSysNotBuiltinDQModel);
        PSDEActionCurSysNotSubSysDQModel pSDEActionCurSysNotSubSysDQModel = new PSDEActionCurSysNotSubSysDQModel();
        pSDEActionCurSysNotSubSysDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEActionCurSysNotSubSysDQModel);
        PSDEActionDefaultDQModel pSDEActionDefaultDQModel = new PSDEActionDefaultDQModel();
        pSDEActionDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEActionDefaultDQModel);
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
        this.registerPDTDEView("EDITVIEW", "1d2508208ed974596916b0cd36c8c0b5");
        this.registerPDTDEView("MPICKUPVIEW", "2f8e7c99090bf9102bb5127e15513fb8");
        this.registerPDTDEView("PICKUPVIEW", "07a9b2590cbcdfc20acd21d62f9a6311");
        this.registerPDTDEView("REDIRECTVIEW", "35e1965f862a8d3414c29039c227db90");
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
        dEDataSetCond2.setDEFName("CODENAME");
        dEDataSetCond2.setCondValue(string);
        dEDataSetCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)dEDataSetCond2);
        dEDataSetCond2 = new DEDataSetCond();
        dEDataSetCond2.setCondType("DEFIELD");
        dEDataSetCond2.setCondOp("LIKE");
        dEDataSetCond2.setDEFName("LOGICNAME");
        dEDataSetCond2.setCondValue(string);
        dEDataSetCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)dEDataSetCond2);
        dEDataSetCond2 = new DEDataSetCond();
        dEDataSetCond2.setCondType("DEFIELD");
        dEDataSetCond2.setCondOp("LIKE");
        dEDataSetCond2.setDEFName("PSDEACTIONNAME");
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
        pSDEFGroupDetailModel.setId("a919f9d8626ffd374b63e783570e1dd7");
        pSDEFGroupDetailModel.setName("ACTIONHOLDER");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("ACTIONHOLDER", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DELogicHolderCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u63d0\u4f9b\u884c\u4e3a\u80fd\u529b\u7684\u6301\u6709\u8005\uff0c\u672a\u6307\u5b9a\u65f6\u4e3a\u3010\u540e\u53f0\u53ca\u524d\u53f0\u3011,\u5982\u884c\u4e3a\u7c7b\u578b\u4e3a\u3010\u5904\u7406\u903b\u8f91\u3011\u5219\u7531\u76f8\u5e94\u7684\u5904\u7406\u903b\u8f91\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b249b8a1ab3338461d64b808b35b8353");
        pSDEFGroupDetailModel.setName("ACTIONMODE");
        iPSDEFieldModel = this.getDEField("ACTIONMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u7684\u6a21\u5f0f\uff0c\u884c\u4e3a\u6a21\u5f0f\u5b9a\u4e49\u4e86\u884c\u4e3a\u7684\u76ee\u7684\uff0c\u7528\u4e8e\u9884\u7f6e\u903b\u8f91\u7684\u9644\u52a0\u3002\u672a\u6307\u5b9a\u65f6\u6a21\u578b\u5f15\u64ce\u5c06\u5c1d\u8bd5\u81ea\u52a8\u8ba1\u7b97\uff0c\u65e0\u6cd5\u8ba1\u7b97\u5219\u4e3a\u3010\u672a\u77e5\u64cd\u4f5c\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("fbe4bb5b63cdebcd91b2d61e39889ed7");
        pSDEFGroupDetailModel.setName("ACTIONTYPE");
        iPSDEFieldModel = this.getDEField("ACTIONTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionType2CodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u7684\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e3aa5294d81ddc880de58ecf64625dc6");
        pSDEFGroupDetailModel.setName("BATCHACTIONMODE");
        iPSDEFieldModel = this.getDEField("BATCHACTIONMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionBatchModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u662f\u5426\u652f\u6301\u6279\u64cd\u4f5c\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("39fa70a2bb4c45bd529053a09b64b8b5");
        pSDEFGroupDetailModel.setName("CALLTIMEOUT");
        iPSDEFieldModel = this.getDEField("CALLTIMEOUT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u8c03\u7528\u7684\u8d85\u65f6\u65f6\u957f\uff0c\u5355\u4f4d\u4e3a\u3010\u6beb\u79d2\u3011\u3002\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e24416b4b4e8b0ff4ad7dbf098318eea");
        pSDEFGroupDetailModel.setName("CODENAME");
        iPSDEFieldModel = this.getDEField("CODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u884c\u4e3a\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5c5e\u5b9e\u4f53\u4e2d\u5177\u5907\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d0943395b6c5f7933f3f2d9d469cd6b9");
        pSDEFGroupDetailModel.setName("CUSTOMCODE");
        iPSDEFieldModel = this.getDEField("CUSTOMCODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u884c\u4e3a\u7c7b\u578b\u4e3a\u3010\u811a\u672c\u3011\u65f6\u6307\u5b9a\u5185\u8054\u4ee3\u7801");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5d625a8eeaf86b8b68d5446b6d7fbe42");
        pSDEFGroupDetailModel.setName("ENABLEAUDIT");
        iPSDEFieldModel = this.getDEField("ENABLEAUDIT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1649c74ec82ce4786ba07d7223b982e7");
        pSDEFGroupDetailModel.setName("EXTENDMODE");
        iPSDEFieldModel = this.getDEField("EXTENDMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEExtendModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u7684\u6269\u5c55\u6a21\u5f0f\uff0c\u6b64\u914d\u7f6e\u9488\u5bf9\u5b50\u7cfb\u7edf\u5b9e\u4f53\uff0c\u6807\u8bb0\u662f\u5426\u8981\u5bf9\u539f\u529f\u80fd\u8fdb\u884c\u6269\u5c55\u3002\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u6269\u5c55\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("30ccea2a7750ef65eac7a4d1618acbd5");
        pSDEFGroupDetailModel.setName("INPSDEFGROUPID");
        iPSDEFieldModel = this.getDEField("INPSDEFGROUPID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5bf9\u8f93\u5165\u4e3a\u5f53\u524d\u5b9e\u4f53\u6570\u636e\u5bf9\u8c61\u7684\u53c2\u6570\u8fdb\u4e00\u6b65\u6307\u5b9a\u5c5e\u6027\u96c6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("45373704f432cbdc0d76b45c54449db4");
        pSDEFGroupDetailModel.setName("INPSDEFGROUPNAME");
        iPSDEFieldModel = this.getDEField("INPSDEFGROUPNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c85732d876dc1a6da7bb9ae4996975f1");
        pSDEFGroupDetailModel.setName("INPSSYSDYNAMODELID");
        iPSDEFieldModel = this.getDEField("INPSSYSDYNAMODELID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u53c2\u6570\u6a21\u5f0f\u4e3a\u3010\u5176\u5b83\u5bf9\u8c61\u3011\u65f6\u6307\u5b9a\u7684\u5bf9\u8c61\u6a21\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("682ae2f9a5c3223f02908841ff58ddbb");
        pSDEFGroupDetailModel.setName("INPSSYSDYNAMODELNAME");
        iPSDEFieldModel = this.getDEField("INPSSYSDYNAMODELNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("547ec205197b7c9eabd88a04a3de6140");
        pSDEFGroupDetailModel.setName("LOCKFLAG");
        iPSDEFieldModel = this.getDEField("LOCKFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("70532934a1dd116dcea080352e2c48f5");
        pSDEFGroupDetailModel.setName("LOGICNAME");
        iPSDEFieldModel = this.getDEField("LOGICNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6a7ba9812eb3dc5db872d72d48ddba95");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("99e263cf76abbbd0728f6e9f95c8df45");
        pSDEFGroupDetailModel.setName("ORDERVALUE");
        iPSDEFieldModel = this.getDEField("ORDERVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ae2c082e58861cddbfc9764ae78df2fa");
        pSDEFGroupDetailModel.setName("OUTPSDEFGROUPID");
        iPSDEFieldModel = this.getDEField("OUTPSDEFGROUPID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5bf9\u8f93\u51fa\u4e3a\u5f53\u524d\u5b9e\u4f53\u6570\u636e\u5bf9\u8c61\u7684\u8fd4\u56de\u503c\u8fd1\u4e00\u6b65\u6307\u5b9a\u5c5e\u6027\u96c6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5899142813c76f0bed341a6f1cfd19c3");
        pSDEFGroupDetailModel.setName("OUTPSDEFGROUPNAME");
        iPSDEFieldModel = this.getDEField("OUTPSDEFGROUPNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("aa08a004f1eeb3337ef4aadf71793239");
        pSDEFGroupDetailModel.setName("OUTPSSYSDYNAMODELID");
        iPSDEFieldModel = this.getDEField("OUTPSSYSDYNAMODELID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u8fd4\u56de\u503c\u4e3a\u5176\u5b83\u5bf9\u8c61\u65f6\u6307\u5b9a\u7684\u52a8\u6001\u6a21\u578b\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("45fbc2756d2a2ea1bec5108ab4e2186f");
        pSDEFGroupDetailModel.setName("OUTPSSYSDYNAMODELNAME");
        iPSDEFieldModel = this.getDEField("OUTPSSYSDYNAMODELNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("464fe085868ead96760a7a4c3519a129");
        pSDEFGroupDetailModel.setName("OUTREFPSDEFGROUPID");
        iPSDEFieldModel = this.getDEField("OUTREFPSDEFGROUPID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u8fdb\u4e00\u6b65\u4e3a\u8f93\u51fa\u5f15\u7528\u5b9e\u4f53\u6307\u5b9a\u5c5e\u6027\u7ec4");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d334641e1a802060a81e787b70524cbc");
        pSDEFGroupDetailModel.setName("OUTREFPSDEFGROUPNAME");
        iPSDEFieldModel = this.getDEField("OUTREFPSDEFGROUPNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ada8daa3acd0e78f6be3a32f7e5c901b");
        pSDEFGroupDetailModel.setName("OUTREFPSDEID");
        iPSDEFieldModel = this.getDEField("OUTREFPSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u8fd4\u56de\u503c\u4e3a\u5916\u90e8\u6570\u636e\u65f6\u6307\u5b9a\u7684\u5f15\u7528\u5b9e\u4f53");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2eeff023d6985995109688845fe084e7");
        pSDEFGroupDetailModel.setName("OUTREFPSDENAME");
        iPSDEFieldModel = this.getDEField("OUTREFPSDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c3fbabe9b766a4c87bafd76621048daa");
        pSDEFGroupDetailModel.setName("PSDEACTIONNAME");
        iPSDEFieldModel = this.getDEField("PSDEACTIONNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u7684\u6807\u8bc6\uff0c\u9700\u8981\u5728\u6240\u5728\u7684\u5b9e\u4f53\u4e2d\u5177\u6709\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("496bc28d5517a92b3020a608e40d2b90");
        pSDEFGroupDetailModel.setName("PSDEACTIONTEMPLID");
        iPSDEFieldModel = this.getDEField("PSDEACTIONTEMPLID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("62f8185b66c950a53df47ac8f90de1d5");
        pSDEFGroupDetailModel.setName("PSDEACTIONTEMPLNAME");
        iPSDEFieldModel = this.getDEField("PSDEACTIONTEMPLNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b257e4f692154380c22c6b5cde473214");
        pSDEFGroupDetailModel.setName("PSDEDATAQUERYID");
        iPSDEFieldModel = this.getDEField("PSDEDATAQUERYID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1ca50810f693fb44fd8c6dd1264f87a5");
        pSDEFGroupDetailModel.setName("PSDEDATAQUERYNAME");
        iPSDEFieldModel = this.getDEField("PSDEDATAQUERYNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("420fc9269671a42af24a5e9fdacca603");
        pSDEFGroupDetailModel.setName("PSDEID");
        iPSDEFieldModel = this.getDEField("PSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("35f2ec81e4bbc0f36bd8b6006b6a99b5");
        pSDEFGroupDetailModel.setName("PSDELOGICID");
        iPSDEFieldModel = this.getDEField("PSDELOGICID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5f53\u884c\u4e3a\u7c7b\u578b\u4e3a\u3010\u5904\u7406\u903b\u8f91\u3011\u65f6\u6307\u5b9a\u5f53\u524d\u5b9e\u4f53\u7684\u5904\u7406\u903b\u8f91");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("19641de24eaec680c00024d8a164a207");
        pSDEFGroupDetailModel.setName("PSDELOGICNAME");
        iPSDEFieldModel = this.getDEField("PSDELOGICNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5f53\u884c\u4e3a\u7c7b\u578b\u4e3a\u3010\u5904\u7406\u903b\u8f91\u3011\u65f6\u6307\u5b9a\u5f53\u524d\u5b9e\u4f53\u7684\u5904\u7406\u903b\u8f91");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1b57e3d029a41001a31899131a291076");
        pSDEFGroupDetailModel.setName("PSDENAME");
        iPSDEFieldModel = this.getDEField("PSDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c85223dd6122c7cec9a38449ec87648a");
        pSDEFGroupDetailModel.setName("PSDEOPPRIVID");
        iPSDEFieldModel = this.getDEField("PSDEOPPRIVID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8c03\u7528\u8be5\u884c\u4e3a\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\uff0c\u672a\u6307\u5b9a\u65f6\u6a21\u578b\u5f15\u64ce\u4f1a\u5c1d\u8bd5\u8ba1\u7b97");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("dcb9ec9cfa9902a410822d13deed1d8e");
        pSDEFGroupDetailModel.setName("PSDEOPPRIVNAME");
        iPSDEFieldModel = this.getDEField("PSDEOPPRIVNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8c03\u7528\u8be5\u884c\u4e3a\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\uff0c\u672a\u6307\u5b9a\u65f6\u6a21\u578b\u5f15\u64ce\u4f1a\u5c1d\u8bd5\u8ba1\u7b97");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("aee141e636d5ace6d851a707cf9f4eb3");
        pSDEFGroupDetailModel.setName("PSSUBSYSSADETAILID");
        iPSDEFieldModel = this.getDEField("PSSUBSYSSADETAILID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5b9e\u4f53\u652f\u6301\u5916\u90e8\u63a5\u53e3\u6301\u4e45\u5316\u65f6\u6307\u5b9a\u884c\u4e3a\u7ed1\u5b9a\u7684\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5\uff0c\u672a\u6307\u5b9a\u65f6\u5f15\u64ce\u5c06\u901a\u8fc7\u4ee3\u7801\u540d\u79f0\u5c1d\u8bd5\u83b7\u53d6\u5bf9\u5e94\u7684\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab2f900d20f36d44ceb23001ece943ce");
        pSDEFGroupDetailModel.setName("PSSUBSYSSADETAILNAME");
        iPSDEFieldModel = this.getDEField("PSSUBSYSSADETAILNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5b9e\u4f53\u652f\u6301\u5916\u90e8\u63a5\u53e3\u6301\u4e45\u5316\u65f6\u6307\u5b9a\u884c\u4e3a\u7ed1\u5b9a\u7684\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5\uff0c\u672a\u6307\u5b9a\u65f6\u5f15\u64ce\u5c06\u901a\u8fc7\u4ee3\u7801\u540d\u79f0\u5c1d\u8bd5\u83b7\u53d6\u5bf9\u5e94\u7684\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("af4545a0c7be5d44b41082c1e59e9159");
        pSDEFGroupDetailModel.setName("PSSYSDYNAMODELID");
        iPSDEFieldModel = this.getDEField("PSSYSDYNAMODELID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("28e3b7be9066587321655400f54f4ddf");
        pSDEFGroupDetailModel.setName("PSSYSDYNAMODELNAME");
        iPSDEFieldModel = this.getDEField("PSSYSDYNAMODELNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("429094ae7d5e415c46983750fad00362");
        pSDEFGroupDetailModel.setName("PSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("PSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1e944d70348e2a34aefbfa2dfc94f7cd");
        pSDEFGroupDetailModel.setName("PSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("PSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("774bb92c8ba80b2e80a754e68e6f52ea");
        pSDEFGroupDetailModel.setName("PSSYSREQITEMID");
        iPSDEFieldModel = this.getDEField("PSSYSREQITEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b9e79893337afee2964ede4ea5c0e209");
        pSDEFGroupDetailModel.setName("PSSYSREQITEMNAME");
        iPSDEFieldModel = this.getDEField("PSSYSREQITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("163c8d734b963caa38eea49d11640ae5");
        pSDEFGroupDetailModel.setName("PSSYSSFPLUGINID");
        iPSDEFieldModel = this.getDEField("PSSYSSFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u4f7f\u7528\u7684\u540e\u53f0\u6a21\u677f\u6269\u5c55\u63d2\u4ef6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c5e35b0592da79ff7605e16bcdaddb80");
        pSDEFGroupDetailModel.setName("PSSYSSFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("PSSYSSFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u4f7f\u7528\u7684\u540e\u53f0\u6a21\u677f\u6269\u5c55\u63d2\u4ef6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9c35aeb20a7c3466ee964c0b26ecd6f0");
        pSDEFGroupDetailModel.setName("PSSYSTASKID");
        iPSDEFieldModel = this.getDEField("PSSYSTASKID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cbac98dd0e221e7b24d30d1a6dd5ba7d");
        pSDEFGroupDetailModel.setName("PSSYSTASKNAME");
        iPSDEFieldModel = this.getDEField("PSSYSTASKNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5fcd9a9326cf6540ebb58732c5d7f038");
        pSDEFGroupDetailModel.setName("PARAMTYPE");
        iPSDEFieldModel = this.getDEField("PARAMTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionParamModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u4f20\u5165\u7684\u53c2\u6570\u6a21\u5f0f\uff0c\u6307\u5b9a\u4e3a\u3010\u6307\u5b9a\u53c2\u6570\u3011\u65f6\u9700\u989d\u5916\u5b9a\u4e49\u53c2\u6570\u6e05\u5355\u3002\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5168\u90e8\u53c2\u6570\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("06f1ae43cf9381df966222ad8f85b317");
        pSDEFGroupDetailModel.setName("PREPARELAST");
        iPSDEFieldModel = this.getDEField("PREPARELAST", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionPrepareLastModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u64cd\u4f5c\u4e4b\u524d\u51c6\u5907\u6700\u540e\u6570\u636e\u6a21\u5f0f\uff0c\u9ed8\u8ba4\u4e3a\u3010\u4e0d\u51c6\u5907\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8d5f8776e30751a4ade1efb1186abf74");
        pSDEFGroupDetailModel.setName("PUBMODE");
        iPSDEFieldModel = this.getDEField("PUBMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColor5CodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u662f\u5426\u9ed8\u8ba4\u63d0\u4f9b\u670d\u52a1\u80fd\u529b\uff0c\u672a\u6307\u5b9a\u65f6\u4f7f\u7528\u5b9e\u4f53\u5b9a\u4e49\u7684\u9ed8\u8ba4\u884c\u4e3a\u670d\u52a1\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a21821441804709dfd2e0e54c5890bb0");
        pSDEFGroupDetailModel.setName("REQUESTFIELD");
        iPSDEFieldModel = this.getDEField("REQUESTFIELD", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u5728\u670d\u52a1\u53c2\u6570\u7c7b\u578b\u4e3a\u3010\u6307\u5b9a\u5c5e\u6027\u3011\u65f6\u5c5e\u6027\u7684\u540d\u79f0\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5b9e\u4f53\u7684\u4e3b\u952e\u5c5e\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8668b444df909a4b22bf365b0e352308");
        pSDEFGroupDetailModel.setName("REQUESTMETHOD");
        iPSDEFieldModel = this.getDEField("REQUESTMETHOD", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u5728\u63d0\u4f9b\u670d\u52a1\u65f6\u4f7f\u7528\u7684\u8bf7\u6c42\u65b9\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b2566d17d0fa0d5dfd857fbd01743e26");
        pSDEFGroupDetailModel.setName("REQUESTPARAMTYPE");
        iPSDEFieldModel = this.getDEField("REQUESTPARAMTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ServiceReqParamTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u5728\u63d0\u4f9b\u670d\u52a1\u65f6\u4f7f\u7528\u7684\u53c2\u6570\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cecdbcbfa68850e4f4b2c88dbcfd5e54");
        pSDEFGroupDetailModel.setName("REQUESTPATH");
        iPSDEFieldModel = this.getDEField("REQUESTPATH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("efc9240f7b66db667bd07dc007ed6e3f");
        pSDEFGroupDetailModel.setName("RETSTDDATATYPE");
        iPSDEFieldModel = this.getDEField("RETSTDDATATYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.StdDataTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u8fd4\u56de\u503c\u7c7b\u578b\u4e3a\u7b80\u5355\u503c\u65f6\u6307\u5b9a\u5177\u4f53\u7684\u6570\u636e\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bc98b65a6478b78a4d72f8795666137c");
        pSDEFGroupDetailModel.setName("RETVALTYPE");
        iPSDEFieldModel = this.getDEField("RETVALTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionRetValTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8f49da87672b7bee9e87313bc67134c5");
        pSDEFGroupDetailModel.setName("SUBSYSSADETAILMODE");
        iPSDEFieldModel = this.getDEField("SUBSYSSADETAILMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.SubSysSADEMethodBindingModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u5b9e\u4f53\u652f\u6301\u5916\u90e8\u63a5\u53e3\u6301\u4e45\u5316\u65f6\u6307\u5b9a\u884c\u4e3a\u7ed1\u5b9a\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5\u6a21\u5f0f\uff0c\u9ed8\u8ba4\u4e3a\u3010\u81ea\u52a8\u7ed1\u5b9a\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3dfc8a40b4f4d4032a8cb90d5f7f63a1");
        pSDEFGroupDetailModel.setName("SYNCEVENT");
        iPSDEFieldModel = this.getDEField("SYNCEVENT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionSyncEventCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u89e6\u53d1\u7684\u540c\u6b65\u4e8b\u4ef6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cefaebc659c7a476baf4839a0adb8a88");
        pSDEFGroupDetailModel.setName("TSMODE");
        iPSDEFieldModel = this.getDEField("TSMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionTSModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u7684\u4e8b\u52a1\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u4e3a\u3010\u9ed8\u8ba4\u3011\uff0c\u7531\u6267\u884c\u4f53\u7cfb\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4da40c0c6b79b7818bcc604be9374c20");
        pSDEFGroupDetailModel.setName("TESTACTIONMODE");
        iPSDEFieldModel = this.getDEField("TESTACTIONMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEActionTestActionModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u884c\u4e3a\u7684\u6d4b\u8bd5\u884c\u4e3a\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u6d4b\u8bd5\u884c\u4e3a\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0026db2e0d54983995080811040d98dc");
        pSDEFGroupDetailModel.setName("TODOTASK");
        iPSDEFieldModel = this.getDEField("TODOTASK", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a5dbd5aaf63af55f8c3b7406f4e76205");
        pSDEFGroupDetailModel.setName("USERCAT");
        iPSDEFieldModel = this.getDEField("USERCAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelUserCatCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("205de8dda07dcfda15ba491c566c9793");
        pSDEFGroupDetailModel.setName("USERTAG");
        iPSDEFieldModel = this.getDEField("USERTAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3bb2082e5dfc97e9e33fa48f62d5f8a9");
        pSDEFGroupDetailModel.setName("USERTAG2");
        iPSDEFieldModel = this.getDEField("USERTAG2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("93c3c82251456eb98b832c924567dec5");
        pSDEFGroupDetailModel.setName("USERTAG3");
        iPSDEFieldModel = this.getDEField("USERTAG3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("32202013f6388d31adbe38a87db7a8ca");
        pSDEFGroupDetailModel.setName("USERTAG4");
        iPSDEFieldModel = this.getDEField("USERTAG4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1afd8b19bee8b13eb9cdf631bad46947");
        pSDEFGroupDetailModel.setName("VALIDFLAG");
        iPSDEFieldModel = this.getDEField("VALIDFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

