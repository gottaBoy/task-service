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
import net.ibizsys.pscore.srv.dedesign.demodel.psdedatasync.ac.PSDEDataSyncDefaultACModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdedatasync.dataquery.PSDEDataSyncCurDEDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdedatasync.dataquery.PSDEDataSyncCurDEInDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdedatasync.dataquery.PSDEDataSyncCurDEOutDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdedatasync.dataquery.PSDEDataSyncDefaultDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdedatasync.dataset.PSDEDataSyncCurDEDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdedatasync.dataset.PSDEDataSyncCurDEInDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdedatasync.dataset.PSDEDataSyncCurDEOutDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdedatasync.dataset.PSDEDataSyncDefaultDSModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSync;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncService;

public abstract class PSDEDataSyncDEModelBase
extends PSDataEntityModelBase<PSDEDataSync> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDEDataSyncService pSDEDataSyncService;

    public PSDEDataSyncDEModelBase() throws Exception {
        this.setId("bdeca0471cdaaf7d8fc39be62414c080");
        this.setName("PSDEDATASYNC");
        this.setCodeName("PSDEDataSync");
        this.setTableName("T_SRFPSDEDATASYNC");
        this.setViewName("v_PSDEDATASYNC");
        this.setLogicName("\u5b9e\u4f53\u6570\u636e\u540c\u6b65");
        this.setMemo("\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u6a21\u578b\uff0c\u5b9a\u4e49\u5b9e\u4f53\u6570\u636e\u7684\u540c\u6b65\u65b9\u5411\u53ca\u540c\u6b65\u4ee3\u7406\uff0c\u4e5f\u5305\u62ec\u4e86\u6570\u636e\u7684\u5bfc\u5165\u5bfc\u51fa\u5904\u7406\u7b49\u4fe1\u606f");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setUserTag("MODELV2");
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataSyncDEModel", (IDataEntityModel)this);
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

    public PSDEDataSyncService getRealService() {
        if (this.pSDEDataSyncService == null) {
            try {
                this.pSDEDataSyncService = (PSDEDataSyncService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataSyncService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncService";
    }

    public PSDEDataSync createEntity() {
        return new PSDEDataSync();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("CODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("21caf3c37b3619a8185c72ff534e07dd");
            pSDEFieldModel.setName("CODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CodeName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5c5e\u5b9e\u4f53\u4e2d\u5177\u6709\u552f\u4e00\u6027");
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
            pSDEFieldModel.setId("ba1de06d012d300fef26873d586d2ec3");
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
            pSDEFieldModel.setId("6ab491765bb9dfbedb93574041394c6d");
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
        object = this.createDEField("DENAMES");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("85a6b28eb8e656dc9279c59335e094fc");
            pSDEFieldModel.setName("DENAMES");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bfc\u5165\u6570\u636e\u5b9e\u4f53");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DENames");
            pSDEFieldModel.setMemo("\u989d\u5916\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u4ece\u961f\u5217\u4e2d\u63d0\u53d6\u7684\u5bf9\u8c61\u540d\u79f0\uff0c\u9ed8\u8ba4\u4e3a\u6240\u5728\u5b9e\u4f53\u540d\u79f0\uff0c\u591a\u503c\u4f7f\u7528\u3010;\u3011\u5206\u9694");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DYNAMODELFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7a28aea24315c20f2e084db416687d9b");
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
        object = this.createDEField("EVENTTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b95f6f883e72f21f39f1280438baac9e");
            pSDEFieldModel.setName("EVENTTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u76d1\u63a7\u540c\u6b65\u4e8b\u4ef6");
            pSDEFieldModel.setDataType("NMCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DataSyncInformTypeCodeListModel");
            pSDEFieldModel.setCodeName("EventType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u76d1\u63a7\u7684\u540c\u6b65\u4e8b\u4ef6");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXPORTFULL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c1be4389becc1b4722113f5d4185602d");
            pSDEFieldModel.setName("EXPORTFULL");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bfc\u51fa\u5173\u8054\u6570\u636e");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ExportFull");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u5bfc\u51fa\u6570\u636e\u662f\u5426\u5305\u62ec\u5173\u8054\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FILTERMODEL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1ebabe59afced27551908724811f3d6a");
            pSDEFieldModel.setName("FILTERMODEL");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8fc7\u6ee4\u5668\u6a21\u578b");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("FilterModel");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("IMPORTPSDEACTIONID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("90fe61d028ce9e18fe9dee8d6df65fe0");
            pSDEFieldModel.setName("IMPORTPSDEACTIONID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bfc\u5165\u6570\u636e\u884c\u4e3a");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSDEACTION_IMPORTPSDEACTIONID");
            pSDEFieldModel.setLinkDEFName("PSDEACTIONID");
            pSDEFieldModel.setCodeName("ImportPSDEActionId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_IMPORTPSDEACTIONID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_IMPORTPSDEACTIONID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("IMPORTPSDEACTIONNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("df6315a1f32feb01cb127b50b43954a8");
            pSDEFieldModel.setName("IMPORTPSDEACTIONNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5bfc\u5165\u6570\u636e\u884c\u4e3a");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSDEACTION_IMPORTPSDEACTIONID");
            pSDEFieldModel.setLinkDEFName("PSDEACTIONNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("ImportPSDEActionName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u5bfc\u5165\u65f6\u8c03\u7528\u7684\u5b9e\u4f53\u884c\u4e3a");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_IMPORTPSDEACTIONNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_IMPORTPSDEACTIONNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_IMPORTPSDEACTIONNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_IMPORTPSDEACTIONNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INCUSTOMCODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c4f0d6eb27f61625c7b15ae116f79951");
            pSDEFieldModel.setName("INCUSTOMCODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u811a\u672c\u4ee3\u7801");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("InCustomCode");
            pSDEFieldModel.setMemo("\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u542f\u7528\u8f93\u5165\u81ea\u5b9a\u4e49\u4ee3\u7801\u6a21\u5f0f\u65f6\u6307\u5b9a\u811a\u672c\u4ee3\u7801");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INCUSTOMMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8b95c18b39fa7dc7bd9324268890350b");
            pSDEFieldModel.setName("INCUSTOMMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u8f93\u5165\u4ee3\u7801\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ScriptModeCodeListModel");
            pSDEFieldModel.setCodeName("InCustomMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u662f\u5426\u542f\u7528\u8f93\u5165\u81ea\u5b9a\u4e49\u4ee3\u7801\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INPSDEACTIONID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e2901a51effcfc193714b41fefbb9bed");
            pSDEFieldModel.setName("INPSDEACTIONID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u8fc7\u6ee4\u884c\u4e3a");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSDEACTION_INPSDEACTIONID");
            pSDEFieldModel.setLinkDEFName("PSDEACTIONID");
            pSDEFieldModel.setCodeName("InPSDEActionId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSDEACTIONID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSDEACTIONID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INPSDEACTIONNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("96c5ccba89e4bacbeff2702953c2069f");
            pSDEFieldModel.setName("INPSDEACTIONNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u8fc7\u6ee4\u884c\u4e3a");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSDEACTION_INPSDEACTIONID");
            pSDEFieldModel.setLinkDEFName("PSDEACTIONNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("InPSDEActionName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u5bfc\u5165\u7684\u5224\u65ad\u884c\u4e3a");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSDEACTIONNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSDEACTIONNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSDEACTIONNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSDEACTIONNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INPSDEDATASETID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("29d60fabfe1fc9b8a7ab814d0d76c752");
            pSDEFieldModel.setName("INPSDEDATASETID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u6570\u636e\u96c6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSDEDATASET_INPSDEDATASETID");
            pSDEFieldModel.setLinkDEFName("PSDEDATASETID");
            pSDEFieldModel.setCodeName("InPSDEDataSetId");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u5165\u7684\u8fc7\u6ee4\u6570\u636e\u96c6\uff0c\u4f7f\u7528\u8be5\u6570\u636e\u96c6\u7684\u67e5\u8be2\u6761\u4ef6\u4f5c\u4e3a\u8f93\u5165\u8fc7\u6ee4\u6761\u4ef6");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSDEDATASETID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSDEDATASETID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INPSDEDATASETNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ca15f7105808815ba3722c14bc13c00a");
            pSDEFieldModel.setName("INPSDEDATASETNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u6570\u636e\u96c6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSDEDATASET_INPSDEDATASETID");
            pSDEFieldModel.setLinkDEFName("PSDEDATASETNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("InPSDEDataSetName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u5165\u7684\u6570\u636e\u96c6\uff0c\u4e00\u822c\u4f7f\u7528\u8be5\u6570\u636e\u96c6\u7684\u67e5\u8be2\u6761\u4ef6\u4f5c\u4e3a\u8f93\u5165\u8fc7\u6ee4\u6761\u4ef6");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSDEDATASETNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSDEDATASETNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSDEDATASETNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSDEDATASETNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INPSSYSDATASYNCAGENTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("34aee41fdb9d3bc1e77a0f3b481eda96");
            pSDEFieldModel.setName("INPSSYSDATASYNCAGENTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u6570\u636e\u4ee3\u7406");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSSYSDATASYNCAGENT_INPSSYSDATASYNCAGENTID");
            pSDEFieldModel.setLinkDEFName("PSSYSDATASYNCAGENTID");
            pSDEFieldModel.setCodeName("InPSSysDataSyncAgentId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSSYSDATASYNCAGENTID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSSYSDATASYNCAGENTID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INPSSYSDATASYNCAGENTNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("31a1ff69e6634647458cc9fae0baf9ff");
            pSDEFieldModel.setName("INPSSYSDATASYNCAGENTNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u6570\u636e\u4ee3\u7406");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSSYSDATASYNCAGENT_INPSSYSDATASYNCAGENTID");
            pSDEFieldModel.setLinkDEFName("PSSYSDATASYNCAGENTNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("InPSSysDataSyncAgentName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u5165\u4f7f\u7528\u7684\u7cfb\u7edf\u6570\u636e\u4ee3\u7406");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSSYSDATASYNCAGENTNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSSYSDATASYNCAGENTNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INPSSYSDATASYNCAGENTNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INPSSYSDATASYNCAGENTNAME_LIKE");
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
            pSDEFieldModel.setId("f7fa2608d633a672c40d5dfc59c2b8e1");
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
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a910819a02de879edff50fd0bd6894ac");
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
        object = this.createDEField("OUTCUSTOMCODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ca4d1bed3b2613c3676deeecb836db16");
            pSDEFieldModel.setName("OUTCUSTOMCODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u811a\u672c\u4ee3\u7801");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("OutCustomCode");
            pSDEFieldModel.setMemo("\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u542f\u7528\u8f93\u51fa\u81ea\u5b9a\u4e49\u4ee3\u7801\u6a21\u5f0f\u65f6\u6307\u5b9a\u811a\u672c\u4ee3\u7801");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTCUSTOMMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d4e2c64feb2c20f2b32d242e805eae89");
            pSDEFieldModel.setName("OUTCUSTOMMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u8f93\u51fa\u4ee3\u7801\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ScriptModeCodeListModel");
            pSDEFieldModel.setCodeName("OutCustomMode");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("60bde968ba2105eb6f48571f5f833afd");
            pSDEFieldModel.setName("OUTMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DataSyncOutModeCodeListModel");
            pSDEFieldModel.setCodeName("OutMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u7684\u89e6\u53d1\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5b9e\u65f6\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTPSDEACTIONID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("499352e1ff90ac7dc61635c41a74ce17");
            pSDEFieldModel.setName("OUTPSDEACTIONID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u8fc7\u6ee4\u884c\u4e3a");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSDEACTION_OUTPSDEACTIONID");
            pSDEFieldModel.setLinkDEFName("PSDEACTIONID");
            pSDEFieldModel.setCodeName("OutPSDEActionId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSDEACTIONID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSDEACTIONID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTPSDEACTIONNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7aaa19599aca0fa68c69135420cb39ea");
            pSDEFieldModel.setName("OUTPSDEACTIONNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u8fc7\u6ee4\u884c\u4e3a");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSDEACTION_OUTPSDEACTIONID");
            pSDEFieldModel.setLinkDEFName("PSDEACTIONNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("OutPSDEActionName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u7684\u5224\u65ad\u884c\u4e3a");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSDEACTIONNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSDEACTIONNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSDEACTIONNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSDEACTIONNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTPSDEDATASETID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d0652c1f140912e463cd25e3d161ac35");
            pSDEFieldModel.setName("OUTPSDEDATASETID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u6570\u636e\u96c6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSDEDATASET_OUTPSDEDATASETID");
            pSDEFieldModel.setLinkDEFName("PSDEDATASETID");
            pSDEFieldModel.setCodeName("OutPSDEDataSetId");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u7684\u8fc7\u6ee4\u6570\u636e\u96c6\uff0c\u4f7f\u7528\u8be5\u6570\u636e\u96c6\u7684\u67e5\u8be2\u6761\u4ef6\u4f5c\u4e3a\u8f93\u5165\u8fc7\u6ee4\u6761\u4ef6");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSDEDATASETID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSDEDATASETID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTPSDEDATASETNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c8839d121bf93e6c031d15df208c3b56");
            pSDEFieldModel.setName("OUTPSDEDATASETNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u6570\u636e\u96c6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSDEDATASET_OUTPSDEDATASETID");
            pSDEFieldModel.setLinkDEFName("PSDEDATASETNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("OutPSDEDataSetName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u7684\u6570\u636e\u96c6\uff0c\u4e00\u822c\u4f7f\u7528\u8be5\u6570\u636e\u96c6\u7684\u67e5\u8be2\u6761\u4ef6\u4f5c\u4e3a\u8f93\u51fa\u8fc7\u6ee4\u6761\u4ef6");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSDEDATASETNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSDEDATASETNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSDEDATASETNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSDEDATASETNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTPSSYSDATASYNCAGENTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("994e9ae178c928bb9b544e9ddd5c9955");
            pSDEFieldModel.setName("OUTPSSYSDATASYNCAGENTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u6570\u636e\u4ee3\u7406");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSSYSDATASYNCAGENT_OUTPSSYSDATASYNCAGENTID");
            pSDEFieldModel.setLinkDEFName("PSSYSDATASYNCAGENTID");
            pSDEFieldModel.setCodeName("OutPSSysDataSyncAgentId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSSYSDATASYNCAGENTID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSSYSDATASYNCAGENTID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTPSSYSDATASYNCAGENTNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("aff9cff7fe1c82ecedaa61f21a10b250");
            pSDEFieldModel.setName("OUTPSSYSDATASYNCAGENTNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u6570\u636e\u4ee3\u7406");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSSYSDATASYNCAGENT_OUTPSSYSDATASYNCAGENTID");
            pSDEFieldModel.setLinkDEFName("PSSYSDATASYNCAGENTNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("OutPSSysDataSyncAgentName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u4f7f\u7528\u7684\u7cfb\u7edf\u6570\u636e\u4ee3\u7406");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSSYSDATASYNCAGENTNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSSYSDATASYNCAGENTNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSSYSDATASYNCAGENTNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSSYSDATASYNCAGENTNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTTIMER");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2cecc1d7d7ec1108bda5475d5187fe8b");
            pSDEFieldModel.setName("OUTTIMER");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u95f4\u9694");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("OutTimer");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDATASYNCID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4e2805688900008410266fbb4af54508");
            pSDEFieldModel.setName("PSDEDATASYNCID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDEDataSyncId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDATASYNCNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("66a910e8e7c70770533806b8a14b4f22");
            pSDEFieldModel.setName("PSDEDATASYNCNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6570\u636e\u540c\u6b65\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSDEDataSyncName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u7684\u540d\u79f0");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATASYNCNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATASYNCNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATASYNCNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATASYNCNAME_LIKE");
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
            pSDEFieldModel.setId("b81dffa436d87ac46780e8b579ad7825");
            pSDEFieldModel.setName("PSDEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSDATAENTITY_PSDEID");
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
        object = this.createDEField("PSDENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5ff0c561a039c97eabaa7d28eef446bb");
            pSDEFieldModel.setName("PSDENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSDATAENTITY_PSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYNAME");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDEName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u6240\u5728\u7684\u5b9e\u4f53");
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
        object = this.createDEField("PSDYNAINSTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cc82bdff3c21223da4f1f3fdafbb3417");
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
        object = this.createDEField("PSSYSREQITEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("943613c2a9107341d3bd2e14092be5e7");
            pSDEFieldModel.setName("PSSYSREQITEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8bbe\u8ba1\u9700\u6c42");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSSYSREQITEM_PSSYSREQITEMID");
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
            pSDEFieldModel.setId("804f38450bbc09c8b8b46b84025fef71");
            pSDEFieldModel.setName("PSSYSREQITEMNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8bbe\u8ba1\u9700\u6c42");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSSYSREQITEM_PSSYSREQITEMID");
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
            pSDEFieldModel.setId("93f7e7881387ca65f99a1d867367f416");
            pSDEFieldModel.setName("PSSYSSFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540e\u7aef\u6a21\u677f\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSSYSSFPLUGIN_PSSYSSFPLUGINID");
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
            pSDEFieldModel.setId("c670314722246c0c149789dda8a2af06");
            pSDEFieldModel.setName("PSSYSSFPLUGINNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u540e\u7aef\u6a21\u677f\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEDATASYNC_PSSYSSFPLUGIN_PSSYSSFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSSFPLUGINNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysSFPluginName");
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
        object = this.createDEField("SYNCDIR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("66bcda26b1adcce45e0b1073d25d94ef");
            pSDEFieldModel.setName("SYNCDIR");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6570\u636e\u540c\u6b65\u65b9\u5411");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DataSyncDirCodeListModel");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("SyncDir");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u7684\u540c\u6b65\u65b9\u5411");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SYNCDIR_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SYNCDIR_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SYNCEXPORT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a6f5321c3560d3d77205bd270963a7ef");
            pSDEFieldModel.setName("SYNCEXPORT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540c\u6b65\u5bfc\u51fa\u6570\u636e");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("SyncExport");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TIMERMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("50ac27d94c376505779412a04625d567");
            pSDEFieldModel.setName("TIMERMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9a\u65f6\u89e6\u53d1\u6a21\u5f0f\uff08\u5e9f\u5f03\uff0c\u901aOUTMODE\uff09");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("TimerMode");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TODOTASK");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cd0ff04c3b85b19def424d7983b18b0f");
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
        object = this.createDEField("UPDATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b650e59776e07b7224c6d025b4cbc4b0");
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
            pSDEFieldModel.setId("2fffd97730da7d067d8ecea8ed25ea58");
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
            pSDEFieldModel.setId("7678d395adf697870ff904de1e694c72");
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
        object = this.createDEField("USERTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8d38e14a934e2a72a1ee97f4d9e9db86");
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
            pSDEFieldModel.setId("fd4cb1c2d42a4bce76f7d592c119bfcf");
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
            pSDEFieldModel.setId("35be43a5e6a115824469c65c46b27672");
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
            pSDEFieldModel.setId("59ffeda101bbffd29834781e8bc05fb9");
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
            pSDEFieldModel.setId("b8b53ad58c756efdece1989527706984");
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
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSDEDataSyncDefaultACModel pSDEDataSyncDefaultACModel = new PSDEDataSyncDefaultACModel();
        pSDEDataSyncDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDEDataSyncDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDEDataSyncCurDEDSModel pSDEDataSyncCurDEDSModel = new PSDEDataSyncCurDEDSModel();
        pSDEDataSyncCurDEDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEDataSyncCurDEDSModel);
        PSDEDataSyncCurDEInDSModel pSDEDataSyncCurDEInDSModel = new PSDEDataSyncCurDEInDSModel();
        pSDEDataSyncCurDEInDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEDataSyncCurDEInDSModel);
        PSDEDataSyncCurDEOutDSModel pSDEDataSyncCurDEOutDSModel = new PSDEDataSyncCurDEOutDSModel();
        pSDEDataSyncCurDEOutDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEDataSyncCurDEOutDSModel);
        PSDEDataSyncDefaultDSModel pSDEDataSyncDefaultDSModel = new PSDEDataSyncDefaultDSModel();
        pSDEDataSyncDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEDataSyncDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDEDataSyncCurDEDQModel pSDEDataSyncCurDEDQModel = new PSDEDataSyncCurDEDQModel();
        pSDEDataSyncCurDEDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEDataSyncCurDEDQModel);
        PSDEDataSyncCurDEInDQModel pSDEDataSyncCurDEInDQModel = new PSDEDataSyncCurDEInDQModel();
        pSDEDataSyncCurDEInDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEDataSyncCurDEInDQModel);
        PSDEDataSyncCurDEOutDQModel pSDEDataSyncCurDEOutDQModel = new PSDEDataSyncCurDEOutDQModel();
        pSDEDataSyncCurDEOutDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEDataSyncCurDEOutDQModel);
        PSDEDataSyncDefaultDQModel pSDEDataSyncDefaultDQModel = new PSDEDataSyncDefaultDQModel();
        pSDEDataSyncDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEDataSyncDefaultDQModel);
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
        this.registerPDTDEView("MDATAVIEW", "254682b6cb4532b13b8f7fc545577238");
        this.registerPDTDEView("MPICKUPVIEW", "8ee95dd7636f380dbb11c9d5edaf0d9b");
        this.registerPDTDEView("PICKUPVIEW", "60126b676191e75e67afe02f4ed6aa5f");
        this.registerPDTDEView("REDIRECTVIEW", "8fe8a013e074c800f7884ae2e6711111");
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
        dEDataSetCond2.setDEFName("PSDEDATASYNCNAME");
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
        pSDEFGroupDetailModel.setId("21caf3c37b3619a8185c72ff534e07dd");
        pSDEFGroupDetailModel.setName("CODENAME");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5c5e\u5b9e\u4f53\u4e2d\u5177\u6709\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("85a6b28eb8e656dc9279c59335e094fc");
        pSDEFGroupDetailModel.setName("DENAMES");
        iPSDEFieldModel = this.getDEField("DENAMES", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u989d\u5916\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u4ece\u961f\u5217\u4e2d\u63d0\u53d6\u7684\u5bf9\u8c61\u540d\u79f0\uff0c\u9ed8\u8ba4\u4e3a\u6240\u5728\u5b9e\u4f53\u540d\u79f0\uff0c\u591a\u503c\u4f7f\u7528\u3010;\u3011\u5206\u9694");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b95f6f883e72f21f39f1280438baac9e");
        pSDEFGroupDetailModel.setName("EVENTTYPE");
        iPSDEFieldModel = this.getDEField("EVENTTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DataSyncInformTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u76d1\u63a7\u7684\u540c\u6b65\u4e8b\u4ef6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c1be4389becc1b4722113f5d4185602d");
        pSDEFGroupDetailModel.setName("EXPORTFULL");
        iPSDEFieldModel = this.getDEField("EXPORTFULL", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u5bfc\u51fa\u6570\u636e\u662f\u5426\u5305\u62ec\u5173\u8054\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("90fe61d028ce9e18fe9dee8d6df65fe0");
        pSDEFGroupDetailModel.setName("IMPORTPSDEACTIONID");
        iPSDEFieldModel = this.getDEField("IMPORTPSDEACTIONID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u5bfc\u5165\u65f6\u8c03\u7528\u7684\u5b9e\u4f53\u884c\u4e3a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("df6315a1f32feb01cb127b50b43954a8");
        pSDEFGroupDetailModel.setName("IMPORTPSDEACTIONNAME");
        iPSDEFieldModel = this.getDEField("IMPORTPSDEACTIONNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u5bfc\u5165\u65f6\u8c03\u7528\u7684\u5b9e\u4f53\u884c\u4e3a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c4f0d6eb27f61625c7b15ae116f79951");
        pSDEFGroupDetailModel.setName("INCUSTOMCODE");
        iPSDEFieldModel = this.getDEField("INCUSTOMCODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u542f\u7528\u8f93\u5165\u81ea\u5b9a\u4e49\u4ee3\u7801\u6a21\u5f0f\u65f6\u6307\u5b9a\u811a\u672c\u4ee3\u7801");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8b95c18b39fa7dc7bd9324268890350b");
        pSDEFGroupDetailModel.setName("INCUSTOMMODE");
        iPSDEFieldModel = this.getDEField("INCUSTOMMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ScriptModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u662f\u5426\u542f\u7528\u8f93\u5165\u81ea\u5b9a\u4e49\u4ee3\u7801\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e2901a51effcfc193714b41fefbb9bed");
        pSDEFGroupDetailModel.setName("INPSDEACTIONID");
        iPSDEFieldModel = this.getDEField("INPSDEACTIONID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u5bfc\u5165\u7684\u5224\u65ad\u884c\u4e3a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("96c5ccba89e4bacbeff2702953c2069f");
        pSDEFGroupDetailModel.setName("INPSDEACTIONNAME");
        iPSDEFieldModel = this.getDEField("INPSDEACTIONNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u5bfc\u5165\u7684\u5224\u65ad\u884c\u4e3a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("34aee41fdb9d3bc1e77a0f3b481eda96");
        pSDEFGroupDetailModel.setName("INPSSYSDATASYNCAGENTID");
        iPSDEFieldModel = this.getDEField("INPSSYSDATASYNCAGENTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u5165\u4f7f\u7528\u7684\u7cfb\u7edf\u6570\u636e\u4ee3\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("31a1ff69e6634647458cc9fae0baf9ff");
        pSDEFGroupDetailModel.setName("INPSSYSDATASYNCAGENTNAME");
        iPSDEFieldModel = this.getDEField("INPSSYSDATASYNCAGENTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u5165\u4f7f\u7528\u7684\u7cfb\u7edf\u6570\u636e\u4ee3\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f7fa2608d633a672c40d5dfc59c2b8e1");
        pSDEFGroupDetailModel.setName("LOCKFLAG");
        iPSDEFieldModel = this.getDEField("LOCKFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a910819a02de879edff50fd0bd6894ac");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ca4d1bed3b2613c3676deeecb836db16");
        pSDEFGroupDetailModel.setName("OUTCUSTOMCODE");
        iPSDEFieldModel = this.getDEField("OUTCUSTOMCODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u542f\u7528\u8f93\u51fa\u81ea\u5b9a\u4e49\u4ee3\u7801\u6a21\u5f0f\u65f6\u6307\u5b9a\u811a\u672c\u4ee3\u7801");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("60bde968ba2105eb6f48571f5f833afd");
        pSDEFGroupDetailModel.setName("OUTMODE");
        iPSDEFieldModel = this.getDEField("OUTMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DataSyncOutModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u7684\u89e6\u53d1\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5b9e\u65f6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("499352e1ff90ac7dc61635c41a74ce17");
        pSDEFGroupDetailModel.setName("OUTPSDEACTIONID");
        iPSDEFieldModel = this.getDEField("OUTPSDEACTIONID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u7684\u5224\u65ad\u884c\u4e3a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7aaa19599aca0fa68c69135420cb39ea");
        pSDEFGroupDetailModel.setName("OUTPSDEACTIONNAME");
        iPSDEFieldModel = this.getDEField("OUTPSDEACTIONNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u7684\u5224\u65ad\u884c\u4e3a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d0652c1f140912e463cd25e3d161ac35");
        pSDEFGroupDetailModel.setName("OUTPSDEDATASETID");
        iPSDEFieldModel = this.getDEField("OUTPSDEDATASETID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u7684\u6570\u636e\u96c6\uff0c\u4e00\u822c\u4f7f\u7528\u8be5\u6570\u636e\u96c6\u7684\u67e5\u8be2\u6761\u4ef6\u4f5c\u4e3a\u8f93\u51fa\u8fc7\u6ee4\u6761\u4ef6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c8839d121bf93e6c031d15df208c3b56");
        pSDEFGroupDetailModel.setName("OUTPSDEDATASETNAME");
        iPSDEFieldModel = this.getDEField("OUTPSDEDATASETNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u7684\u6570\u636e\u96c6\uff0c\u4e00\u822c\u4f7f\u7528\u8be5\u6570\u636e\u96c6\u7684\u67e5\u8be2\u6761\u4ef6\u4f5c\u4e3a\u8f93\u51fa\u8fc7\u6ee4\u6761\u4ef6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("994e9ae178c928bb9b544e9ddd5c9955");
        pSDEFGroupDetailModel.setName("OUTPSSYSDATASYNCAGENTID");
        iPSDEFieldModel = this.getDEField("OUTPSSYSDATASYNCAGENTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u4f7f\u7528\u7684\u7cfb\u7edf\u6570\u636e\u4ee3\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("aff9cff7fe1c82ecedaa61f21a10b250");
        pSDEFGroupDetailModel.setName("OUTPSSYSDATASYNCAGENTNAME");
        iPSDEFieldModel = this.getDEField("OUTPSSYSDATASYNCAGENTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u8f93\u51fa\u4f7f\u7528\u7684\u7cfb\u7edf\u6570\u636e\u4ee3\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("66a910e8e7c70770533806b8a14b4f22");
        pSDEFGroupDetailModel.setName("PSDEDATASYNCNAME");
        iPSDEFieldModel = this.getDEField("PSDEDATASYNCNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u7684\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b81dffa436d87ac46780e8b579ad7825");
        pSDEFGroupDetailModel.setName("PSDEID");
        iPSDEFieldModel = this.getDEField("PSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u6240\u5728\u7684\u5b9e\u4f53");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5ff0c561a039c97eabaa7d28eef446bb");
        pSDEFGroupDetailModel.setName("PSDENAME");
        iPSDEFieldModel = this.getDEField("PSDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u6240\u5728\u7684\u5b9e\u4f53");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("943613c2a9107341d3bd2e14092be5e7");
        pSDEFGroupDetailModel.setName("PSSYSREQITEMID");
        iPSDEFieldModel = this.getDEField("PSSYSREQITEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("804f38450bbc09c8b8b46b84025fef71");
        pSDEFGroupDetailModel.setName("PSSYSREQITEMNAME");
        iPSDEFieldModel = this.getDEField("PSSYSREQITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("66bcda26b1adcce45e0b1073d25d94ef");
        pSDEFGroupDetailModel.setName("SYNCDIR");
        iPSDEFieldModel = this.getDEField("SYNCDIR", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DataSyncDirCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u7684\u540c\u6b65\u65b9\u5411");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cd0ff04c3b85b19def424d7983b18b0f");
        pSDEFGroupDetailModel.setName("TODOTASK");
        iPSDEFieldModel = this.getDEField("TODOTASK", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7678d395adf697870ff904de1e694c72");
        pSDEFGroupDetailModel.setName("USERCAT");
        iPSDEFieldModel = this.getDEField("USERCAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelUserCatCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8d38e14a934e2a72a1ee97f4d9e9db86");
        pSDEFGroupDetailModel.setName("USERTAG");
        iPSDEFieldModel = this.getDEField("USERTAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("fd4cb1c2d42a4bce76f7d592c119bfcf");
        pSDEFGroupDetailModel.setName("USERTAG2");
        iPSDEFieldModel = this.getDEField("USERTAG2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("35be43a5e6a115824469c65c46b27672");
        pSDEFGroupDetailModel.setName("USERTAG3");
        iPSDEFieldModel = this.getDEField("USERTAG3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("59ffeda101bbffd29834781e8bc05fb9");
        pSDEFGroupDetailModel.setName("USERTAG4");
        iPSDEFieldModel = this.getDEField("USERTAG4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b8b53ad58c756efdece1989527706984");
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
}

