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
import net.ibizsys.pscore.srv.dedesign.demodel.psdelistitem.ac.PSDEListItemDefaultACModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdelistitem.dataquery.PSDEListItemDefaultDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdelistitem.dataquery.PSDEListItemQ1DQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdelistitem.dataquery.PSDEListItemQ2DQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdelistitem.dataset.PSDEListItemDefaultDSModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListItem;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemService;

public abstract class PSDEListItemDEModelBase
extends PSDataEntityModelBase<PSDEListItem> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDEListItemService pSDEListItemService;

    public PSDEListItemDEModelBase() throws Exception {
        this.setId("6bd0fb04c84d7b9a0cd3618c6101fd05");
        this.setName("PSDELISTITEM");
        this.setCodeName("PSDEListItem");
        this.setTableName("T_SRFPSDELISTITEM");
        this.setViewName("v_PSDELISTITEM");
        this.setLogicName("\u5b9e\u4f53\u591a\u6570\u636e\u90e8\u4ef6\u9879");
        this.setMemo("\u5b9e\u4f53\u591a\u6570\u636e\u90e8\u4ef6\u6570\u636e\u9879\u6a21\u578b\uff0c\u4e3a\u6570\u636e\u5217\u8868\u53ca\u5361\u7247\u89c6\u56fe\u7b49\u591a\u6570\u636e\u90e8\u4ef6\u63d0\u4f9b\u6570\u636e\u9879\u652f\u6301\uff0c\u5b9a\u4e49\u53d6\u503c\u5c5e\u6027\u3001\u503c\u683c\u5f0f\u5316\u7b49\u903b\u8f91");
        this.setDSLink("DEFAULT");
        this.setEnableMultiDS(true);
        this.setDataAccCtrlMode(2);
        this.setAuditMode(0);
        this.setEnableTempData(true);
        this.setUserTag("MODELV2");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEListItemDEModel", (IDataEntityModel)this);
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

    public PSDEListItemService getRealService() {
        if (this.pSDEListItemService == null) {
            try {
                this.pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEListItemService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEListItemService";
    }

    public PSDEListItem createEntity() {
        return new PSDEListItem();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("ALIGN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0f858872c8d3245c60c5171142ddb7de");
            pSDEFieldModel.setName("ALIGN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6c34\u5e73\u5bf9\u9f50");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridColAlignCodeListModel");
            pSDEFieldModel.setCodeName("Align");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u663e\u793a\u5185\u5bb9\u9879\u7684\u6c34\u5e73\u5bf9\u9f50\u65b9\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5de6\u5bf9\u9f50\u3011");
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
        object = this.createDEField("CAPPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2af3c5fddf8fc79839ff8784c20352e3");
            pSDEFieldModel.setName("CAPPSLANRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDELISTITEM_PSLANGUAGERES_CAPPSLANRESID");
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
            pSDEFieldModel.setId("22f475550e5f39d631408688fc1ebb31");
            pSDEFieldModel.setName("CAPPSLANRESNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDELISTITEM_PSLANGUAGERES_CAPPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESNAME");
            pSDEFieldModel.setCodeName("CapPSLanResName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u9879\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u9879\u5b58\u5728\u7ed1\u5b9a\u5c5e\u6027\uff0c\u4f7f\u7528\u5c5e\u6027\u903b\u8f91\u540d\u79f0\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
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
            pSDEFieldModel.setId("6ad72cdaf463d51a5ed51b0b707e1a12");
            pSDEFieldModel.setName("CAPTION");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Caption");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u9879\u7684\u6807\u9898\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u9879\u5b58\u5728\u7ed1\u5b9a\u5c5e\u6027\uff0c\u4f7f\u7528\u5c5e\u6027\u7684\u903b\u8f91\u540d\u79f0");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CLCONVERTMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0d6e99783cd9e2253b2a7b5d972b44c8");
            pSDEFieldModel.setName("CLCONVERTMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u503c\u8f6c\u6362\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.CLConvertModesCodeListModel");
            pSDEFieldModel.setCodeName("CLConvertMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5217\u8868\u6570\u636e\u9879\u7684\u4ee3\u7801\u503c\u8f6c\u6362\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u524d\u53f0\u3011");
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
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b22987b039b45e5c263e5749f11b5c28");
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
            pSDEFieldModel.setId("d5998490a095f036e89f2c43fd436ea2");
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
        object = this.createDEField("CUSTOMCODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("262459946a92d3ddac61fd057dba26cd");
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
            pSDEFieldModel.setId("dcac1f9ab0c2697877cf3ca8d9fece21");
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
            pSDEFieldModel.setId("22fa53dd59ee3cae1838efaf48347fda");
            pSDEFieldModel.setName("DATAITEMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6570\u636e\u9879\u53c2\u6570");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DataItems");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5217\u8868\u5185\u5bb9\u9879\u7ed1\u5b9a\u7684\u6570\u636e\u9879\u96c6\u5408\uff0c\u591a\u9879\u4f7f\u7528\u3010;\u3011\u5206\u9694");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DATAVIEWPSDEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("89854c5fb113acbdec3caa1237e8199e");
            pSDEFieldModel.setName("DATAVIEWPSDEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5361\u7247\u90e8\u4ef6\u5b9e\u4f53\u6807\u8bc6");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDELISTITEM_PSDEDATAVIEW_PSDEDATAVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("DataViewPSDEId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DYNAMODELFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a12de564534f4980dd20403a73896644");
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
        object = this.createDEField("ENABLEITEMPRIV");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cb191e898e55c5873e5b6560b32e0e60");
            pSDEFieldModel.setName("ENABLEITEMPRIV");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u5217\u6743\u9650\u63a7\u5236");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableItemPriv");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5217\u8868\u9879\u662f\u5426\u542f\u7528\u5217\u6743\u9650\u63a7\u5236\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5217\u8868\u9879\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5c5e\u6027\u51b3\u5b9a\uff0c\u65e0\u5b9e\u4f53\u5c5e\u6027\u5219\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("GROUPITEM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3375aa8fcfce744f35c16cb5c2dbf5fe");
            pSDEFieldModel.setName("GROUPITEM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5206\u7ec4\u9879");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColGroupModeCodeListModel");
            pSDEFieldModel.setCodeName("GroupItem");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5217\u8868\u9879\u7684\u9ed8\u8ba4\u5206\u7ec4\u9879\uff0c\u6b64\u914d\u7f6e\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559");
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
        object = this.createDEField("ITEMTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("91555ed3a48eb8de32eb5fdf0f0bac9d");
            pSDEFieldModel.setName("ITEMTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9879\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ListItemTypeCodeListModel");
            pSDEFieldModel.setCodeName("ItemType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5217\u8868\u9879\u7684\u7c7b\u578b");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LCRPSSYSPFPLUGINID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("69520a0d0389b8291c6376e04c94aefa");
            pSDEFieldModel.setName("LCRPSSYSPFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5217\u8868\u9879\u7ed8\u5236\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDELISTITEM_PSSYSPFPLUGIN_LCRPSSYSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSPFPLUGINID");
            pSDEFieldModel.setCodeName("LCRPSSysPFPluginId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LCRPSSYSPFPLUGINID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LCRPSSYSPFPLUGINID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LCRPSSYSPFPLUGINNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bbc276cfb79f18a64d719672a9ac2ea1");
            pSDEFieldModel.setName("LCRPSSYSPFPLUGINNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5217\u8868\u9879\u7ed8\u5236\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDELISTITEM_PSSYSPFPLUGIN_LCRPSSYSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSPFPLUGINNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("LCRPSSysPFPluginName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5217\u8868\u9879\u7ed8\u5236\u63d2\u4ef6\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u5217\u8868\u9879\u7ed8\u5236\u63d2\u4ef6\u3011");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LCRPSSYSPFPLUGINNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LCRPSSYSPFPLUGINNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LCRPSSYSPFPLUGINNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LCRPSSYSPFPLUGINNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LISTPSDEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("db75227202396c476ced89ce4a983786");
            pSDEFieldModel.setName("LISTPSDEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5217\u8868\u90e8\u4ef6\u5b9e\u4f53\u6807\u8bc6");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDELISTITEM_PSDELIST_PSDELISTID");
            pSDEFieldModel.setLinkDEFName("PSDEID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("ListPSDEId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1755800ebe3cc8346266e3e3e1118fe1");
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
        object = this.createDEField("NOSORT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bca62258f40aa68845434cc4e02e0523");
            pSDEFieldModel.setName("NOSORT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7981\u7528\u6392\u5e8f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("NoSort");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u662f\u5426\u7981\u7528\u9879\u7684\u6392\u5e8f\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u6240\u5728\u90e8\u4ef6\u51b3\u5b9a");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ORDERVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("557ad23c68f6863b31b16644a24218e8");
            pSDEFieldModel.setName("ORDERVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u663e\u793a\u6b21\u5e8f");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("OrderValue");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREDEFINEDTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("844b0355ededfd2cec180bb0b26941df");
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
            pSDEFieldModel.setId("83d28815a1aab07ceab5bdf16127949c");
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
            pSDEFieldModel.setId("cb89d6461259a45d48640e000928cc63");
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
        object = this.createDEField("PSCODELISTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0ae0e0403f1629dfc7843a20b19c1186");
            pSDEFieldModel.setName("PSCODELISTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u8868");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDELISTITEM_PSCODELIST_PSCODELISTID");
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
            pSDEFieldModel.setId("2e048a518efa87af6378c17ed1db86b7");
            pSDEFieldModel.setName("PSCODELISTNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u8868");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDELISTITEM_PSCODELIST_PSCODELISTID");
            pSDEFieldModel.setLinkDEFName("PSCODELISTNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSCodeListName");
            pSDEFieldModel.setMemo("\u542f\u7528\u8f6c\u6362\u4ee3\u7801\u503c\u8f6c\u6362\u6a21\u5f0f\u65f6\uff0c\u6307\u5b9a\u8f6c\u6362\u7684\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u53d6\u503c\u5c5e\u6027\u7684\u4ee3\u7801\u8868");
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
        object = this.createDEField("PSDEDATAVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cfcf7a3fd9b8b39a4295521d686425e3");
            pSDEFieldModel.setName("PSDEDATAVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5361\u7247\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDELISTITEM_PSDEDATAVIEW_PSDEDATAVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEDATAVIEWID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDEDataViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATAVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATAVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDATAVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("11d260cdbae4b6303557912bc6c13f1a");
            pSDEFieldModel.setName("PSDEDATAVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5361\u7247\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDELISTITEM_PSDEDATAVIEW_PSDEDATAVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEDATAVIEWNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDEDataViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u9879\u6240\u5728\u7684\u5361\u7247\u89c6\u56fe\u90e8\u4ef6");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATAVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATAVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATAVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATAVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDELISTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ec4fae9baf867e377e76b5664c00ed5e");
            pSDEFieldModel.setName("PSDELISTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5217\u8868");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDELISTITEM_PSDELIST_PSDELISTID");
            pSDEFieldModel.setLinkDEFName("PSDELISTID");
            pSDEFieldModel.setCodeName("PSDEListId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDELISTID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDELISTID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDELISTITEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bc27d6cd262e8d7de6a58b5034679745");
            pSDEFieldModel.setName("PSDELISTITEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5217\u8868\u9879\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSDEListItemId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDELISTITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9f4977133e6166cd8536955e4bafff8d");
            pSDEFieldModel.setName("PSDELISTITEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9879\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSDEListItemName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u9879\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5728\u90e8\u4ef6\u4e2d\u5177\u5907\u552f\u4e00\u6027\u3002\u6a21\u578b\u5f15\u64ce\u4f1a\u4f7f\u7528\u8be5\u6807\u8bc6\u4ece\u5f53\u524d\u5b9e\u4f53\u4e2d\u5c1d\u8bd5\u83b7\u53d6\u9879\u7ed1\u5b9a\u7684\u5c5e\u6027");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDELISTITEMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDELISTITEMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDELISTITEMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDELISTITEMNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDELISTNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0008f1e30943c2d446f3eaa96f3c5231");
            pSDEFieldModel.setName("PSDELISTNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5217\u8868");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDELISTITEM_PSDELIST_PSDELISTID");
            pSDEFieldModel.setLinkDEFName("PSDELISTNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDEListName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u9879\u6240\u5728\u7684\u6570\u636e\u5217\u8868\u90e8\u4ef6");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDELISTNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDELISTNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDELISTNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDELISTNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEUAGROUPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5cdbd373539f47268068c54e1543f7b1");
            pSDEFieldModel.setName("PSDEUAGROUPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u754c\u9762\u884c\u4e3a\u7ec4");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDELISTITEM_PSDEUAGROUP_PSDEUAGROUPID");
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
            pSDEFieldModel.setId("535628029c1d21e82efeed83e94f8936");
            pSDEFieldModel.setName("PSDEUAGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u754c\u9762\u884c\u4e3a\u7ec4");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDELISTITEM_PSDEUAGROUP_PSDEUAGROUPID");
            pSDEFieldModel.setLinkDEFName("PSDEUAGROUPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEUAGroupName");
            pSDEFieldModel.setMemo("\u9879\u7c7b\u578b\u4e3a\u3010\u64cd\u4f5c\u9879\u3011\u65f6\u6307\u5b9a\u76f8\u5173\u7684\u754c\u9762\u884c\u4e3a\u7ec4");
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
        object = this.createDEField("PSDYNAINSTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f074feb70bc71e421d97dcaf2d70328b");
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
        object = this.createDEField("RENDERMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7bd6844709aeaa459ff0d6f5009664da");
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
            pSDEFieldModel.setId("8793840eb19825f8ba018e320553aa5b");
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
        object = this.createDEField("UPDATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("599efa4bc207f8fe2a00bc0ecf315c8b");
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
            pSDEFieldModel.setId("0f67357a7ecb3a2254ca57d201d21cf7");
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
            pSDEFieldModel.setId("257bb590ec2085299c24a3ec582a7bae");
            pSDEFieldModel.setName("USERTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag");
            pSDEFieldModel.setLength(200);
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
            pSDEFieldModel.setId("1b074f0e3781babddf315da8f507023b");
            pSDEFieldModel.setName("USERTAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb02");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag2");
            pSDEFieldModel.setLength(200);
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
            pSDEFieldModel.setId("dbb459160d953e781f670f77d14f580f");
            pSDEFieldModel.setName("VALUEFORMAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u503c\u683c\u5f0f\u5316");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ValueFormat");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5217\u8868\u9879\u7684\u503c\u683c\u5f0f\u5316\u4e32\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u53d6\u503c\u5c5e\u6027\u7684\u914d\u7f6e");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIDTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("336b535b5b03f11967950f0617c5289d");
            pSDEFieldModel.setName("WIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bbd\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Width");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5217\u8868\u5185\u5bb9\u9879\u7684\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010150\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIDTHUNIT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9748ed9a98f7cfc7f17285908c342758");
            pSDEFieldModel.setName("WIDTHUNIT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bbd\u5ea6\u5355\u4f4d");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColWidthUnitTypeCodeListModel");
            pSDEFieldModel.setCodeName("WidthUnit");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5217\u8868\u5185\u5bb9\u9879\u7684\u5bbd\u5ea6\u5355\u4f4d\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010PX\u3011");
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
        PSDEListItemDefaultACModel pSDEListItemDefaultACModel = new PSDEListItemDefaultACModel();
        pSDEListItemDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDEListItemDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDEListItemDefaultDSModel pSDEListItemDefaultDSModel = new PSDEListItemDefaultDSModel();
        pSDEListItemDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEListItemDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDEListItemDefaultDQModel pSDEListItemDefaultDQModel = new PSDEListItemDefaultDQModel();
        pSDEListItemDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEListItemDefaultDQModel);
        PSDEListItemQ1DQModel pSDEListItemQ1DQModel = new PSDEListItemQ1DQModel();
        pSDEListItemQ1DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEListItemQ1DQModel);
        PSDEListItemQ2DQModel pSDEListItemQ2DQModel = new PSDEListItemQ2DQModel();
        pSDEListItemQ2DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEListItemQ2DQModel);
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
        this.registerPDTDEView("EDITVIEW", "e02f884d8ed0b6ffbd5dbdb5c967dd46");
        this.registerPDTDEView("MPICKUPVIEW", "e59260765f1d753a9dc781a4b09200fb");
        this.registerPDTDEView("PICKUPVIEW", "bbc3926b19d323776694eb509c6c2b52");
        this.registerPDTDEView("REDIRECTVIEW", "4cb6c32f51bc93b113c52763a20363ec");
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
        dEDataSetCond2.setDEFName("PSDELISTITEMNAME");
        dEDataSetCond2.setCondValue(string);
        dEDataSetCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)dEDataSetCond2);
    }

    @Override
    protected void onPreparePSDEFGroupModels() throws Exception {
        IPSDEFGroupModel iPSDEFGroupModel = this.preparePSDEFGroupModel_DataViewItem();
        if (iPSDEFGroupModel != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_ListItem()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel__DEFAULT()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DataViewItem() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DataViewItem");
        pSDEFGroupModel.setName("\u5361\u7247\u89c6\u56fe\u9879");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2af3c5fddf8fc79839ff8784c20352e3");
        pSDEFGroupDetailModel.setName("CAPPSLANRESID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u9879\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u9879\u5b58\u5728\u7ed1\u5b9a\u5c5e\u6027\uff0c\u4f7f\u7528\u5c5e\u6027\u903b\u8f91\u540d\u79f0\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("22f475550e5f39d631408688fc1ebb31");
        pSDEFGroupDetailModel.setName("CAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u9879\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u9879\u5b58\u5728\u7ed1\u5b9a\u5c5e\u6027\uff0c\u4f7f\u7528\u5c5e\u6027\u903b\u8f91\u540d\u79f0\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6ad72cdaf463d51a5ed51b0b707e1a12");
        pSDEFGroupDetailModel.setName("CAPTION");
        iPSDEFieldModel = this.getDEField("CAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u9879\u7684\u6807\u9898\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u9879\u5b58\u5728\u7ed1\u5b9a\u5c5e\u6027\uff0c\u4f7f\u7528\u5c5e\u6027\u7684\u903b\u8f91\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("262459946a92d3ddac61fd057dba26cd");
        pSDEFGroupDetailModel.setName("CUSTOMCODE");
        iPSDEFieldModel = this.getDEField("CUSTOMCODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("dcac1f9ab0c2697877cf3ca8d9fece21");
        pSDEFGroupDetailModel.setName("CUSTOMMODE");
        iPSDEFieldModel = this.getDEField("CUSTOMMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("22fa53dd59ee3cae1838efaf48347fda");
        pSDEFGroupDetailModel.setName("DATAITEMS");
        iPSDEFieldModel = this.getDEField("DATAITEMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5217\u8868\u5185\u5bb9\u9879\u7ed1\u5b9a\u7684\u6570\u636e\u9879\u96c6\u5408\uff0c\u591a\u9879\u4f7f\u7528\u3010;\u3011\u5206\u9694");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("91555ed3a48eb8de32eb5fdf0f0bac9d");
        pSDEFGroupDetailModel.setName("ITEMTYPE");
        iPSDEFieldModel = this.getDEField("ITEMTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DataViewItemTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5361\u7247\u89c6\u56fe\u9879\u7684\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bca62258f40aa68845434cc4e02e0523");
        pSDEFGroupDetailModel.setName("NOSORT");
        iPSDEFieldModel = this.getDEField("NOSORT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u7981\u7528\u9879\u7684\u6392\u5e8f\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u6240\u5728\u90e8\u4ef6\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("557ad23c68f6863b31b16644a24218e8");
        pSDEFGroupDetailModel.setName("ORDERVALUE");
        iPSDEFieldModel = this.getDEField("ORDERVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cfcf7a3fd9b8b39a4295521d686425e3");
        pSDEFGroupDetailModel.setName("PSDEDATAVIEWID");
        iPSDEFieldModel = this.getDEField("PSDEDATAVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5cdbd373539f47268068c54e1543f7b1");
        pSDEFGroupDetailModel.setName("PSDEUAGROUPID");
        iPSDEFieldModel = this.getDEField("PSDEUAGROUPID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u9879\u7c7b\u578b\u4e3a\u3010\u64cd\u4f5c\u9879\u3011\u65f6\u6307\u5b9a\u76f8\u5173\u7684\u754c\u9762\u884c\u4e3a\u7ec4");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("535628029c1d21e82efeed83e94f8936");
        pSDEFGroupDetailModel.setName("PSDEUAGROUPNAME");
        iPSDEFieldModel = this.getDEField("PSDEUAGROUPNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u9879\u7c7b\u578b\u4e3a\u3010\u64cd\u4f5c\u9879\u3011\u65f6\u6307\u5b9a\u76f8\u5173\u7684\u754c\u9762\u884c\u4e3a\u7ec4");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_ListItem() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("ListItem");
        pSDEFGroupModel.setName("\u5217\u8868\u9879");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0f858872c8d3245c60c5171142ddb7de");
        pSDEFGroupDetailModel.setName("ALIGN");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("ALIGN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridColAlignCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u663e\u793a\u5185\u5bb9\u9879\u7684\u6c34\u5e73\u5bf9\u9f50\u65b9\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5de6\u5bf9\u9f50\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2af3c5fddf8fc79839ff8784c20352e3");
        pSDEFGroupDetailModel.setName("CAPPSLANRESID");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u9879\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u9879\u5b58\u5728\u7ed1\u5b9a\u5c5e\u6027\uff0c\u4f7f\u7528\u5c5e\u6027\u903b\u8f91\u540d\u79f0\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("22f475550e5f39d631408688fc1ebb31");
        pSDEFGroupDetailModel.setName("CAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u9879\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u9879\u5b58\u5728\u7ed1\u5b9a\u5c5e\u6027\uff0c\u4f7f\u7528\u5c5e\u6027\u903b\u8f91\u540d\u79f0\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6ad72cdaf463d51a5ed51b0b707e1a12");
        pSDEFGroupDetailModel.setName("CAPTION");
        iPSDEFieldModel = this.getDEField("CAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u9879\u7684\u6807\u9898\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u9879\u5b58\u5728\u7ed1\u5b9a\u5c5e\u6027\uff0c\u4f7f\u7528\u5c5e\u6027\u7684\u903b\u8f91\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("262459946a92d3ddac61fd057dba26cd");
        pSDEFGroupDetailModel.setName("CUSTOMCODE");
        iPSDEFieldModel = this.getDEField("CUSTOMCODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("dcac1f9ab0c2697877cf3ca8d9fece21");
        pSDEFGroupDetailModel.setName("CUSTOMMODE");
        iPSDEFieldModel = this.getDEField("CUSTOMMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("22fa53dd59ee3cae1838efaf48347fda");
        pSDEFGroupDetailModel.setName("DATAITEMS");
        iPSDEFieldModel = this.getDEField("DATAITEMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5217\u8868\u5185\u5bb9\u9879\u7ed1\u5b9a\u7684\u6570\u636e\u9879\u96c6\u5408\uff0c\u591a\u9879\u4f7f\u7528\u3010;\u3011\u5206\u9694");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cb191e898e55c5873e5b6560b32e0e60");
        pSDEFGroupDetailModel.setName("ENABLEITEMPRIV");
        iPSDEFieldModel = this.getDEField("ENABLEITEMPRIV", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5217\u8868\u9879\u662f\u5426\u542f\u7528\u5217\u6743\u9650\u63a7\u5236\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5217\u8868\u9879\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5c5e\u6027\u51b3\u5b9a\uff0c\u65e0\u5b9e\u4f53\u5c5e\u6027\u5219\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3375aa8fcfce744f35c16cb5c2dbf5fe");
        pSDEFGroupDetailModel.setName("GROUPITEM");
        iPSDEFieldModel = this.getDEField("GROUPITEM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridColGroupModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5217\u8868\u9879\u7684\u9ed8\u8ba4\u5206\u7ec4\u9879\uff0c\u6b64\u914d\u7f6e\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("91555ed3a48eb8de32eb5fdf0f0bac9d");
        pSDEFGroupDetailModel.setName("ITEMTYPE");
        iPSDEFieldModel = this.getDEField("ITEMTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ListItemTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5217\u8868\u9879\u7684\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("69520a0d0389b8291c6376e04c94aefa");
        pSDEFGroupDetailModel.setName("LCRPSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("LCRPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5217\u8868\u9879\u7ed8\u5236\u63d2\u4ef6\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u5217\u8868\u9879\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bbc276cfb79f18a64d719672a9ac2ea1");
        pSDEFGroupDetailModel.setName("LCRPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("LCRPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5217\u8868\u9879\u7ed8\u5236\u63d2\u4ef6\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u5217\u8868\u9879\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bca62258f40aa68845434cc4e02e0523");
        pSDEFGroupDetailModel.setName("NOSORT");
        iPSDEFieldModel = this.getDEField("NOSORT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u7981\u7528\u9879\u7684\u6392\u5e8f\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u6240\u5728\u90e8\u4ef6\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("557ad23c68f6863b31b16644a24218e8");
        pSDEFGroupDetailModel.setName("ORDERVALUE");
        iPSDEFieldModel = this.getDEField("ORDERVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ec4fae9baf867e377e76b5664c00ed5e");
        pSDEFGroupDetailModel.setName("PSDELISTID");
        iPSDEFieldModel = this.getDEField("PSDELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5cdbd373539f47268068c54e1543f7b1");
        pSDEFGroupDetailModel.setName("PSDEUAGROUPID");
        iPSDEFieldModel = this.getDEField("PSDEUAGROUPID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u9879\u7c7b\u578b\u4e3a\u3010\u64cd\u4f5c\u9879\u3011\u65f6\u6307\u5b9a\u76f8\u5173\u7684\u754c\u9762\u884c\u4e3a\u7ec4");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("535628029c1d21e82efeed83e94f8936");
        pSDEFGroupDetailModel.setName("PSDEUAGROUPNAME");
        iPSDEFieldModel = this.getDEField("PSDEUAGROUPNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u9879\u7c7b\u578b\u4e3a\u3010\u64cd\u4f5c\u9879\u3011\u65f6\u6307\u5b9a\u76f8\u5173\u7684\u754c\u9762\u884c\u4e3a\u7ec4");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("336b535b5b03f11967950f0617c5289d");
        pSDEFGroupDetailModel.setName("WIDTH");
        iPSDEFieldModel = this.getDEField("WIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5217\u8868\u5185\u5bb9\u9879\u7684\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010150\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel__DEFAULT() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("_DEFAULT");
        pSDEFGroupModel.setName("\u901a\u7528");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0d6e99783cd9e2253b2a7b5d972b44c8");
        pSDEFGroupDetailModel.setName("CLCONVERTMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CLCONVERTMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.CLConvertModesCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5217\u8868\u6570\u636e\u9879\u7684\u4ee3\u7801\u503c\u8f6c\u6362\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u524d\u53f0\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1755800ebe3cc8346266e3e3e1118fe1");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0ae0e0403f1629dfc7843a20b19c1186");
        pSDEFGroupDetailModel.setName("PSCODELISTID");
        iPSDEFieldModel = this.getDEField("PSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u542f\u7528\u8f6c\u6362\u4ee3\u7801\u503c\u8f6c\u6362\u6a21\u5f0f\u65f6\uff0c\u6307\u5b9a\u8f6c\u6362\u7684\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u53d6\u503c\u5c5e\u6027\u7684\u4ee3\u7801\u8868");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2e048a518efa87af6378c17ed1db86b7");
        pSDEFGroupDetailModel.setName("PSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("PSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u542f\u7528\u8f6c\u6362\u4ee3\u7801\u503c\u8f6c\u6362\u6a21\u5f0f\u65f6\uff0c\u6307\u5b9a\u8f6c\u6362\u7684\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u53d6\u503c\u5c5e\u6027\u7684\u4ee3\u7801\u8868");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9f4977133e6166cd8536955e4bafff8d");
        pSDEFGroupDetailModel.setName("PSDELISTITEMNAME");
        iPSDEFieldModel = this.getDEField("PSDELISTITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u9879\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5728\u90e8\u4ef6\u4e2d\u5177\u5907\u552f\u4e00\u6027\u3002\u6a21\u578b\u5f15\u64ce\u4f1a\u4f7f\u7528\u8be5\u6807\u8bc6\u4ece\u5f53\u524d\u5b9e\u4f53\u4e2d\u5c1d\u8bd5\u83b7\u53d6\u9879\u7ed1\u5b9a\u7684\u5c5e\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("257bb590ec2085299c24a3ec582a7bae");
        pSDEFGroupDetailModel.setName("USERTAG");
        iPSDEFieldModel = this.getDEField("USERTAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1b074f0e3781babddf315da8f507023b");
        pSDEFGroupDetailModel.setName("USERTAG2");
        iPSDEFieldModel = this.getDEField("USERTAG2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("dbb459160d953e781f670f77d14f580f");
        pSDEFGroupDetailModel.setName("VALUEFORMAT");
        iPSDEFieldModel = this.getDEField("VALUEFORMAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5217\u8868\u9879\u7684\u503c\u683c\u5f0f\u5316\u4e32\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u53d6\u503c\u5c5e\u6027\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

