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
import net.ibizsys.pscore.srv.dedesign.demodel.psdefdtcol.ac.PSDEFDTColDefaultACModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdefdtcol.dataquery.PSDEFDTColCurDEDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdefdtcol.dataquery.PSDEFDTColCurSysDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdefdtcol.dataquery.PSDEFDTColDefaultDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdefdtcol.dataset.PSDEFDTColCurDEDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdefdtcol.dataset.PSDEFDTColCurSysDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdefdtcol.dataset.PSDEFDTColDefaultDSModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDTCol;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDTColService;

public abstract class PSDEFDTColDEModelBase
extends PSDataEntityModelBase<PSDEFDTCol> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDEFDTColService pSDEFDTColService;

    public PSDEFDTColDEModelBase() throws Exception {
        this.setId("08b8e71384f0c3d45ac791433703116c");
        this.setName("PSDEFDTCOL");
        this.setCodeName("PSDEFDTCol");
        this.setTableName("T_SRFPSDEFDTCOL");
        this.setViewName("v_PSDEFDTCOL");
        this.setLogicName("\u5c5e\u6027\u6570\u636e\u5e93\u5217\u914d\u7f6e");
        this.setMemo("\u5b9e\u4f53\u5c5e\u6027\u7684\u6570\u636e\u5e93\u5217\u914d\u7f6e\u6a21\u578b\uff0c\u652f\u6301\u5c5e\u6027\u9488\u5bf9\u7279\u5b9a\u6570\u636e\u5e93\u7c7b\u578b\u7684\u8fdb\u884c\u989d\u5916\u914d\u7f6e");
        this.setDSLink("DEFAULT");
        this.setEnableMultiDS(true);
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setUserTag("MODELV2");
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFDTColDEModel", (IDataEntityModel)this);
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

    public PSDEFDTColService getRealService() {
        if (this.pSDEFDTColService == null) {
            try {
                this.pSDEFDTColService = (PSDEFDTColService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFDTColService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFDTColService";
    }

    public PSDEFDTCol createEntity() {
        return new PSDEFDTCol();
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
            pSDEFieldModel.setId("b10670647671c119fca7d371f22f48a9");
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
            pSDEFieldModel.setId("8068ec0bf4a63bf12d9c51bff348d33a");
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
        object = this.createDEField("CUSTOMDATATYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f9eaddbab815519e9ab473e640f4364a");
            pSDEFieldModel.setName("CUSTOMDATATYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u6570\u636e\u7c7b\u578b");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColor8CodeListModel");
            pSDEFieldModel.setCodeName("CustomDataType");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u662f\u5426\u81ea\u5b9a\u4e49\u5c5e\u6027\u5217\u7684\u6570\u636e\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u4e3a\u3010\u5426\u3011\u3002\u5f15\u64ce\u6682\u4e0d\u652f\u6301\u6b64\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DATATYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5848b191a2a49434ce7be60a19136410");
            pSDEFieldModel.setName("DATATYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6570\u636e\u7c7b\u578b");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DataType");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DBTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8c2c19f6e5398810e143c8379b52c55e");
            pSDEFieldModel.setName("DBTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6570\u636e\u5e93\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setUnionKeyValue("KEY2");
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DBType2CodeListModel");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("DBType");
            pSDEFieldModel.setUserTag("MODELV2TAG");
            pSDEFieldModel.setLength(40);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DBTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DBTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFAULTVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e288891f96cf56bb53bfadf8582cc7de");
            pSDEFieldModel.setName("DEFAULTVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6570\u636e\u5e93\u9ed8\u8ba4\u503c");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DefaultValue");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u7684\u6570\u636e\u5e93\u9ed8\u8ba4\u503c");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FORMULAFIELDS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("46897d26942fbf0ef3d7771c0cf2aa06");
            pSDEFieldModel.setName("FORMULAFIELDS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u903b\u8f91\u5c5e\u6027\u53c2\u6570");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("FormulaFields");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u516c\u5f0f\u5c5e\u6027\u5217\u683c\u5f0f\u53c2\u6570\u96c6\u5408\uff0c\u591a\u4e2a\u53c2\u6570\u4f7f\u7528\u5206\u53f7\uff08\uff1b\uff09\u5206\u9694\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FORMULAFORMAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("87045d1b5de1410b832bcd3481430071");
            pSDEFieldModel.setName("FORMULAFORMAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u903b\u8f91\u5b57\u6bb5\u683c\u5f0f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("FormulaFormat");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u516c\u5f0f\u5c5e\u6027\u5217\u683c\u5f0f\uff0c\u5982\u5b58\u5728\u516c\u5f0f\u5c5e\u6027\u53c2\u6570\uff0c\u53ef\u4f7f\u7528java\u5b57\u7b26\u4e32\u683c\u5f0f\u5316\u5360\u4f4d\u7b26\u53f7\uff1a %1$s\u3001 %2$s...\u8fdb\u884c\u53c2\u6570\u5360\u4f4d\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u914d\u7f6e");
            pSDEFieldModel.setLength(2000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LENGTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cda31b3a6817dc2b0ce9e92311810646");
            pSDEFieldModel.setName("LENGTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u957f\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Length");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u7684\u6570\u636e\u7c7b\u578b\u957f\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b9f4cf415f3a3bee9ae85a11c35512df");
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
        object = this.createDEField("NULLVALORDER");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f15562f745a2f11f363e56252085895d");
            pSDEFieldModel.setName("NULLVALORDER");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7a7a\u503c\u6392\u5e8f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DBNullValueOrderModeCodeListModel");
            pSDEFieldModel.setCodeName("NullValOrder");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u6570\u636e\u5217\u5728\u6570\u636e\u5e93\u6392\u5e8f\u65f6\u5904\u7406\u7a7a\u503c\u7684\u65b9\u5f0f\uff0c\u672a\u6307\u5b9a\u65f6\u5219\u4f9d\u6b21\u4ece\u5c5e\u6027\u3001\u6570\u636e\u5e93\u7c7b\u578b\u8bfb\u53d6\u8bbe\u7f6e");
            pSDEFieldModel.setLength(10);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_NULLVALORDER_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_NULLVALORDER_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PRECISION2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a0202d6c2860d112e548a6dbf4a5014b");
            pSDEFieldModel.setName("PRECISION2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6d6e\u70b9\u7cbe\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Precision2");
            pSDEFieldModel.setServiceCodeName("Precision");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u6570\u636e\u7c7b\u578b\u7684\u6d6e\u70b9\u7cbe\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFDTCOLID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6ebe17d20dcdb2aec53a180e43ea3fe5");
            pSDEFieldModel.setName("PSDEFDTCOLID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5c5e\u6027\u5217\u5b9a\u4e49\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDEFDTColId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFDTCOLNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ed3b55a5df8d3035470cc962f49ea549");
            pSDEFieldModel.setName("PSDEFDTCOLNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5217\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSDEFDTColName");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFDTCOLNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFDTCOLNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFDTCOLNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFDTCOLNAME_LIKE");
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
            pSDEFieldModel.setId("cada4523cdb228aff32a9bf4f33561d5");
            pSDEFieldModel.setName("PSDEFID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5c5e\u6027");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setUnionKeyValue("KEY1");
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID");
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
            pSDEFieldModel.setId("15e001186240e3303ac963971d790130");
            pSDEFieldModel.setName("PSDEFNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5c5e\u6027");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDEFIELDNAME");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDEFName");
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
        object = this.createDEField("PSDEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ca8ce70da559e8e775bd7093f633ac4b");
            pSDEFieldModel.setName("PSDEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u6807\u8bc6");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDEID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(0);
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
            pSDEFieldModel.setId("12df196fe10706026d8af058ce97972d");
            pSDEFieldModel.setName("PSDENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u540d\u79f0");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(0);
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
        object = this.createDEField("TABLENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ed5099b04eee5dce65d64ea597e6c495");
            pSDEFieldModel.setName("TABLENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6570\u636e\u8868\u540d\u79f0");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFDTCOL_PSDEFIELD_PSDEFID");
            pSDEFieldModel.setLinkDEFName("TABLENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("TableName");
            pSDEFieldModel.setLength(60);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TABLENAME_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TABLENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
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
            pSDEFieldModel.setId("fe15913800568b2c26a30a1f27bae74e");
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
            pSDEFieldModel.setId("00419b0f0177d6d7ac0e2041beb1e590");
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
            pSDEFieldModel.setId("b01b9738ed56a02f805ca7cd4a7437ec");
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
            pSDEFieldModel.setId("873b2d8af41d0866974bb6fc58b0e1ff");
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
            pSDEFieldModel.setId("5cd9831090fd09dbc7b5ee8254d1c28a");
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
            pSDEFieldModel.setId("5ec277de55535e2be497dc435fe7e2a3");
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
        object = this.createDEField("USERTAG3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a26419731dfe4589c80f156c61fd663b");
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
            pSDEFieldModel.setId("58a79b52f2e68ca223467fd9505ab3e6");
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
        object = this.createDEField("VALUEFUNC2FIELDS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9797942d054e3ba719433a85e362b1a0");
            pSDEFieldModel.setName("VALUEFUNC2FIELDS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u65b0\u5efa\u503c\u51fd\u6570\u53c2\u6570");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ValueFunc2Fields");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u63d2\u5165\u51fd\u6570\u53c2\u6570\u96c6\u5408\uff0c\u591a\u4e2a\u53c2\u6570\u4f7f\u7528\u5206\u53f7\uff08\uff1b\uff09\u5206\u9694");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VALUEFUNC2FORMAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c9a87a1c2046f9cb26d4bcec117601a5");
            pSDEFieldModel.setName("VALUEFUNC2FORMAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u65b0\u5efa\u503c\u51fd\u6570\u683c\u5f0f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ValueFunc2Format");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u63d2\u5165\u51fd\u6570\u683c\u5f0f\uff0c\u5982\u5b58\u5728\u63d2\u5165\u51fd\u6570\u53c2\u6570\uff0c\u53ef\u4f7f\u7528java\u5b57\u7b26\u4e32\u683c\u5f0f\u5316\u5360\u4f4d\u7b26\u53f7\uff1a %1$s\u3001 %2$s...\u8fdb\u884c\u53c2\u6570\u5360\u4f4d");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VALUEFUNCFIELDS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b02f9f33c86406d8a816427cb3beb02b");
            pSDEFieldModel.setName("VALUEFUNCFIELDS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u65b0\u503c\u51fd\u6570\u53c2\u6570");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ValueFuncFields");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u66f4\u65b0\u51fd\u6570\u53c2\u6570\u96c6\u5408\uff0c\u591a\u4e2a\u53c2\u6570\u4f7f\u7528\u5206\u53f7\uff08\uff1b\uff09\u5206\u9694");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VALUEFUNCFORMAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7e15819f5cf4971abfbf1b964ddaf69c");
            pSDEFieldModel.setName("VALUEFUNCFORMAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u65b0\u503c\u51fd\u6570\u683c\u5f0f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ValueFuncFormat");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u66f4\u65b0\u51fd\u6570\u683c\u5f0f\uff0c\u5982\u5b58\u5728\u66f4\u65b0\u51fd\u6570\u53c2\u6570\uff0c\u53ef\u4f7f\u7528java\u5b57\u7b26\u4e32\u683c\u5f0f\u5316\u5360\u4f4d\u7b26\u53f7\uff1a %1$s\u3001 %2$s...\u8fdb\u884c\u53c2\u6570\u5360\u4f4d");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSDEFDTColDefaultACModel pSDEFDTColDefaultACModel = new PSDEFDTColDefaultACModel();
        pSDEFDTColDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDEFDTColDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDEFDTColCurDEDSModel pSDEFDTColCurDEDSModel = new PSDEFDTColCurDEDSModel();
        pSDEFDTColCurDEDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEFDTColCurDEDSModel);
        PSDEFDTColCurSysDSModel pSDEFDTColCurSysDSModel = new PSDEFDTColCurSysDSModel();
        pSDEFDTColCurSysDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEFDTColCurSysDSModel);
        PSDEFDTColDefaultDSModel pSDEFDTColDefaultDSModel = new PSDEFDTColDefaultDSModel();
        pSDEFDTColDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEFDTColDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDEFDTColCurDEDQModel pSDEFDTColCurDEDQModel = new PSDEFDTColCurDEDQModel();
        pSDEFDTColCurDEDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEFDTColCurDEDQModel);
        PSDEFDTColCurSysDQModel pSDEFDTColCurSysDQModel = new PSDEFDTColCurSysDQModel();
        pSDEFDTColCurSysDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEFDTColCurSysDQModel);
        PSDEFDTColDefaultDQModel pSDEFDTColDefaultDQModel = new PSDEFDTColDefaultDQModel();
        pSDEFDTColDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEFDTColDefaultDQModel);
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
        this.registerPDTDEView("EDITVIEW", "524be894135739394463bc3c0b5be60f");
        this.registerPDTDEView("MPICKUPVIEW", "e8994f6f43e8da1bbd8c3d0843de50c5");
        this.registerPDTDEView("PICKUPVIEW", "577422576fa97a2355285910a6a0c703");
        this.registerPDTDEView("REDIRECTVIEW", "e9cf1e4a13a084ac3b97af45d6ba6152");
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
        dEDataSetCond2.setDEFName("PSDEFDTCOLNAME");
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
        pSDEFGroupDetailModel.setId("f9eaddbab815519e9ab473e640f4364a");
        pSDEFGroupDetailModel.setName("CUSTOMDATATYPE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CUSTOMDATATYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColor8CodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u81ea\u5b9a\u4e49\u5c5e\u6027\u5217\u7684\u6570\u636e\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u4e3a\u3010\u5426\u3011\u3002\u5f15\u64ce\u6682\u4e0d\u652f\u6301\u6b64\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8c2c19f6e5398810e143c8379b52c55e");
        pSDEFGroupDetailModel.setName("DBTYPE");
        iPSDEFieldModel = this.getDEField("DBTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DBType2CodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5848b191a2a49434ce7be60a19136410");
        pSDEFGroupDetailModel.setName("DATATYPE");
        iPSDEFieldModel = this.getDEField("DATATYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e288891f96cf56bb53bfadf8582cc7de");
        pSDEFGroupDetailModel.setName("DEFAULTVALUE");
        iPSDEFieldModel = this.getDEField("DEFAULTVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u7684\u6570\u636e\u5e93\u9ed8\u8ba4\u503c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("46897d26942fbf0ef3d7771c0cf2aa06");
        pSDEFGroupDetailModel.setName("FORMULAFIELDS");
        iPSDEFieldModel = this.getDEField("FORMULAFIELDS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u516c\u5f0f\u5c5e\u6027\u5217\u683c\u5f0f\u53c2\u6570\u96c6\u5408\uff0c\u591a\u4e2a\u53c2\u6570\u4f7f\u7528\u5206\u53f7\uff08\uff1b\uff09\u5206\u9694\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("87045d1b5de1410b832bcd3481430071");
        pSDEFGroupDetailModel.setName("FORMULAFORMAT");
        iPSDEFieldModel = this.getDEField("FORMULAFORMAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u516c\u5f0f\u5c5e\u6027\u5217\u683c\u5f0f\uff0c\u5982\u5b58\u5728\u516c\u5f0f\u5c5e\u6027\u53c2\u6570\uff0c\u53ef\u4f7f\u7528java\u5b57\u7b26\u4e32\u683c\u5f0f\u5316\u5360\u4f4d\u7b26\u53f7\uff1a %1$s\u3001 %2$s...\u8fdb\u884c\u53c2\u6570\u5360\u4f4d\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cda31b3a6817dc2b0ce9e92311810646");
        pSDEFGroupDetailModel.setName("LENGTH");
        iPSDEFieldModel = this.getDEField("LENGTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u7684\u6570\u636e\u7c7b\u578b\u957f\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b9f4cf415f3a3bee9ae85a11c35512df");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f15562f745a2f11f363e56252085895d");
        pSDEFGroupDetailModel.setName("NULLVALORDER");
        iPSDEFieldModel = this.getDEField("NULLVALORDER", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DBNullValueOrderModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u6570\u636e\u5217\u5728\u6570\u636e\u5e93\u6392\u5e8f\u65f6\u5904\u7406\u7a7a\u503c\u7684\u65b9\u5f0f\uff0c\u672a\u6307\u5b9a\u65f6\u5219\u4f9d\u6b21\u4ece\u5c5e\u6027\u3001\u6570\u636e\u5e93\u7c7b\u578b\u8bfb\u53d6\u8bbe\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed3b55a5df8d3035470cc962f49ea549");
        pSDEFGroupDetailModel.setName("PSDEFDTCOLNAME");
        iPSDEFieldModel = this.getDEField("PSDEFDTCOLNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cada4523cdb228aff32a9bf4f33561d5");
        pSDEFGroupDetailModel.setName("PSDEFID");
        iPSDEFieldModel = this.getDEField("PSDEFID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("15e001186240e3303ac963971d790130");
        pSDEFGroupDetailModel.setName("PSDEFNAME");
        iPSDEFieldModel = this.getDEField("PSDEFNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a0202d6c2860d112e548a6dbf4a5014b");
        pSDEFGroupDetailModel.setName("PRECISION2");
        iPSDEFieldModel = this.getDEField("PRECISION2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u6570\u636e\u7c7b\u578b\u7684\u6d6e\u70b9\u7cbe\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b01b9738ed56a02f805ca7cd4a7437ec");
        pSDEFGroupDetailModel.setName("USERCAT");
        iPSDEFieldModel = this.getDEField("USERCAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelUserCatCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5cd9831090fd09dbc7b5ee8254d1c28a");
        pSDEFGroupDetailModel.setName("USERTAG");
        iPSDEFieldModel = this.getDEField("USERTAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5ec277de55535e2be497dc435fe7e2a3");
        pSDEFGroupDetailModel.setName("USERTAG2");
        iPSDEFieldModel = this.getDEField("USERTAG2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a26419731dfe4589c80f156c61fd663b");
        pSDEFGroupDetailModel.setName("USERTAG3");
        iPSDEFieldModel = this.getDEField("USERTAG3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("58a79b52f2e68ca223467fd9505ab3e6");
        pSDEFGroupDetailModel.setName("USERTAG4");
        iPSDEFieldModel = this.getDEField("USERTAG4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9797942d054e3ba719433a85e362b1a0");
        pSDEFGroupDetailModel.setName("VALUEFUNC2FIELDS");
        iPSDEFieldModel = this.getDEField("VALUEFUNC2FIELDS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u63d2\u5165\u51fd\u6570\u53c2\u6570\u96c6\u5408\uff0c\u591a\u4e2a\u53c2\u6570\u4f7f\u7528\u5206\u53f7\uff08\uff1b\uff09\u5206\u9694");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c9a87a1c2046f9cb26d4bcec117601a5");
        pSDEFGroupDetailModel.setName("VALUEFUNC2FORMAT");
        iPSDEFieldModel = this.getDEField("VALUEFUNC2FORMAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u63d2\u5165\u51fd\u6570\u683c\u5f0f\uff0c\u5982\u5b58\u5728\u63d2\u5165\u51fd\u6570\u53c2\u6570\uff0c\u53ef\u4f7f\u7528java\u5b57\u7b26\u4e32\u683c\u5f0f\u5316\u5360\u4f4d\u7b26\u53f7\uff1a %1$s\u3001 %2$s...\u8fdb\u884c\u53c2\u6570\u5360\u4f4d");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b02f9f33c86406d8a816427cb3beb02b");
        pSDEFGroupDetailModel.setName("VALUEFUNCFIELDS");
        iPSDEFieldModel = this.getDEField("VALUEFUNCFIELDS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u66f4\u65b0\u51fd\u6570\u53c2\u6570\u96c6\u5408\uff0c\u591a\u4e2a\u53c2\u6570\u4f7f\u7528\u5206\u53f7\uff08\uff1b\uff09\u5206\u9694");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7e15819f5cf4971abfbf1b964ddaf69c");
        pSDEFGroupDetailModel.setName("VALUEFUNCFORMAT");
        iPSDEFieldModel = this.getDEField("VALUEFUNCFORMAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u5217\u66f4\u65b0\u51fd\u6570\u683c\u5f0f\uff0c\u5982\u5b58\u5728\u66f4\u65b0\u51fd\u6570\u53c2\u6570\uff0c\u53ef\u4f7f\u7528java\u5b57\u7b26\u4e32\u683c\u5f0f\u5316\u5360\u4f4d\u7b26\u53f7\uff1a %1$s\u3001 %2$s...\u8fdb\u884c\u53c2\u6570\u5360\u4f4d");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

