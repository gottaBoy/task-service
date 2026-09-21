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
import net.ibizsys.pscore.srv.dedesign.demodel.psdefuimode.ac.PSDEFUIModeDefaultACModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdefuimode.dataquery.PSDEFUIModeCurAppDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdefuimode.dataquery.PSDEFUIModeCurDEFDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdefuimode.dataquery.PSDEFUIModeCurSysDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdefuimode.dataquery.PSDEFUIModeDefaultDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdefuimode.dataset.PSDEFUIModeCurAppDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdefuimode.dataset.PSDEFUIModeCurDEFDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdefuimode.dataset.PSDEFUIModeCurSysDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdefuimode.dataset.PSDEFUIModeDefaultDSModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;

public abstract class PSDEFUIModeDEModelBase
extends PSDataEntityModelBase<PSDEFUIMode> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDEFUIModeService pSDEFUIModeService;

    public PSDEFUIModeDEModelBase() throws Exception {
        this.setId("5872fb90094dc91ead3f278cc2d6b8ff");
        this.setName("PSDEFFORMITEM");
        this.setCodeName("PSDEFUIMode");
        this.setTableName("T_SRFPSDEFFORMITEM");
        this.setViewName("v_PSDEFFORMITEM");
        this.setLogicName("\u5b9e\u4f53\u5c5e\u6027\u754c\u9762\u914d\u7f6e");
        this.setMemo("\u5b9e\u4f53\u5c5e\u6027\u7684\u754c\u9762\u6a21\u5f0f\u6a21\u578b\uff0c\u5c5e\u6027\u5728\u684c\u9762\u7aef\u6216\u79fb\u52a8\u7aef\u4f1a\u5b58\u5728\u4e0d\u540c\u7684\u8868\u73b0\u6837\u5f0f\uff0c\u5728\u4e0d\u540c\u4e1a\u52a1\u573a\u666f\u751a\u81f3\u4e0d\u540c\u7684\u524d\u7aef\u5e94\u7528\u4e2d\u4e5f\u4f1a\u6709\u4e0d\u540c\u7684\u5c55\u73b0\u9700\u6c42\u3002\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u5c31\u662f\u5c06\u5c5e\u6027\u7684\u8868\u73b0\u9700\u6c42\u8fdb\u884c\u5f52\u7eb3\uff0c\u4ee5\u9ed8\u8ba4\u6216\u663e\u5f0f\u7684\u65b9\u5f0f\u8fdb\u884c\u4f7f\u7528");
        this.setDSLink("DEFAULT");
        this.setEnableMultiDS(true);
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setUserTag("MODELV2");
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFUIModeDEModel", (IDataEntityModel)this);
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

    public PSDEFUIModeService getRealService() {
        if (this.pSDEFUIModeService == null) {
            try {
                this.pSDEFUIModeService = (PSDEFUIModeService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFUIModeService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService";
    }

    public PSDEFUIMode createEntity() {
        return new PSDEFUIMode();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("ALLOWEMPTY");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8fe93d5a7bc7bf5487f95fba291eed50");
            pSDEFieldModel.setName("ALLOWEMPTY");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5141\u8bb8\u7a7a\u8f93\u5165");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("AllowEmpty");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u662f\u5426\u5141\u8bb8\u7a7a\u503c\u8f93\u5165\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5b9e\u4f53\u5c5e\u6027\u7684\u3010\u5141\u8bb8\u4e3a\u7a7a\u3011\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CAPPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4759e41bccdb337649f2d4d52c3182df");
            pSDEFieldModel.setName("CAPPSLANRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSLANGUAGERES_CAPPSLANRESID");
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
            pSDEFieldModel.setId("9b409f71506d6d245f538fa477509d50");
            pSDEFieldModel.setName("CAPPSLANRESNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSLANGUAGERES_CAPPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESNAME");
            pSDEFieldModel.setCodeName("CapPSLanResName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u6807\u9898\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u903b\u8f91\u540d\u79f0\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
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
            pSDEFieldModel.setId("6c9521cc369397d81526597df1b96cd8");
            pSDEFieldModel.setName("CAPTION");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Caption");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u6807\u9898\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u7684\u903b\u8f91\u540d\u79f0");
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
        object = this.createDEField("CODELISTCONFIGMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("79e5173d5d9ba250b89a61a21a7a8ca6");
            pSDEFieldModel.setName("CODELISTCONFIGMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u4ee3\u7801\u8868\u914d\u7f6e\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.OutputCodeListConfigModeCodeListModel");
            pSDEFieldModel.setCodeName("CodeListConfigMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u4ee3\u7801\u8868\u914d\u7f6e\u7684\u8f93\u51fa\u6a21\u5f0f\uff0c\u6b64\u914d\u7f6e\u5e94\u7528\u4e8e\u65e9\u671f\u6280\u672f\u7684\u524d\u7aef\u6a21\u677f\u3002\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u3011");
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
        object = this.createDEField("CODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c8fcf38440f5f28a64d608c9d68dbc22");
            pSDEFieldModel.setName("CODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CodeName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u8981\u5728\u6240\u5728\u7684\u5b9e\u4f53\u5c5e\u6027\u4e2d\u5177\u6709\u552f\u4e00\u6027");
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
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CONVERTCITEXT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ea80cadc7da9b89460cf98cdd88ab8bf");
            pSDEFieldModel.setName("CONVERTCITEXT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f6c\u6362\u4ee3\u7801\u9879\u6587\u672c");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ConvertCIText");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u4ee3\u7801\u503c\u8f6c\u6362\u4e3a\u663e\u793a\u6587\u672c\u8f93\u51fa");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c9a680fac6c393306a74a9439b719f40");
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
            pSDEFieldModel.setId("2b012b1ebf173fa6fcabd40ae794306a");
            pSDEFieldModel.setName("CREATEDV");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5efa\u7acb\u9ed8\u8ba4\u503c");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CreateDV");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5efa\u7acb\u9ed8\u8ba4\u503c\uff0c\u672a\u6307\u5b9a\u9ed8\u8ba4\u503c\u7c7b\u578b\u65f6\u6309\u76f4\u63a5\u503c\u5904\u7406");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDVT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("306d9fdbd2109d7d6a57d6898b3b7e5a");
            pSDEFieldModel.setName("CREATEDVT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u65b0\u5efa\u9ed8\u8ba4\u503c\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldDefaultValueTypeCodeListModel");
            pSDEFieldModel.setCodeName("CreateDVT");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5efa\u7acb\u9ed8\u8ba4\u503c\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u76f4\u63a5\u503c\u3011");
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
            pSDEFieldModel.setId("9cd00544b3dc9d303c367f91a2c47d44");
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
        object = this.createDEField("DYNAMODELFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6d940cf53055148277893cb46bf14911");
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
            pSDEFieldModel.setId("bf4137c66e6b467d857b17b4beec7428");
            pSDEFieldModel.setName("EDITORPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("EditorParams");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u5668\u53c2\u6570\u96c6\u5408");
            pSDEFieldModel.setLength(2000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EDITORTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c450ef53a15a83eca4e0144cd7f33515");
            pSDEFieldModel.setName("EDITORTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormItemEditorCodeListModel");
            pSDEFieldModel.setCodeName("EditorType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u7f16\u8f91\u5668\u7c7b\u578b");
            pSDEFieldModel.setLength(100);
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
            pSDEFieldModel.setId("ee5e3779617e5c1c432df74b4e4c154a");
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
        object = this.createDEField("ENABLEINPUTTIP");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6e9f318a70d600bc0e4a9a549b6971b1");
            pSDEFieldModel.setName("ENABLEINPUTTIP");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u8f93\u5165\u63d0\u793a");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableInputTip");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u662f\u5426\u6307\u5b9a\u8f93\u5165\u63d0\u793a\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u662f\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLERESETITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("670a89fc33feed286d69e6f5ed23830d");
            pSDEFieldModel.setName("ENABLERESETITEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u91cd\u7f6e\u9879\u540d\u79f0");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableResetItemName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u662f\u5426\u542f\u7528\u91cd\u7f6e\u9879\u540d\u79f0\u914d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLEUNITNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("929e470a3a06fd9f7ed412f026751764");
            pSDEFieldModel.setName("ENABLEUNITNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u5355\u4f4d\u540d\u79f0");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableUnitName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u662f\u5426\u542f\u7528\u5355\u4f4d\u540d\u79f0\u914d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u662f\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLEVALUERULE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d0db09103342c93d6c26c20bd0e9c275");
            pSDEFieldModel.setName("ENABLEVALUERULE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u503c\u89c4\u5219");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableValueRule");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FTMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ffcda9d4e699a79be984778e395986d0");
            pSDEFieldModel.setName("FTMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldUIModeCodeListModel");
            pSDEFieldModel.setCodeName("FTMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u5e94\u7528\u573a\u5408");
            pSDEFieldModel.setLength(40);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_FTMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_FTMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("GCRPSSYSPFPLUGINID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4117869a3ec3ac18fcf8eee952d36dfb");
            pSDEFieldModel.setName("GCRPSSYSPFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8868\u683c\u5217\u7ed8\u5236\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSSYSPFPLUGIN_GCRPSSYSPFPLUGINID");
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
            pSDEFieldModel.setId("cf8f9eb32cde50ec880529033eff2b3c");
            pSDEFieldModel.setName("GCRPSSYSPFPLUGINNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8868\u683c\u5217\u7ed8\u5236\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSSYSPFPLUGIN_GCRPSSYSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSPFPLUGINNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("GCRPSSysPFPluginName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u8868\u683c\u5217\u7ed8\u5236\u63d2\u4ef6\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u6570\u636e\u8868\u683c\u5217\u7ed8\u5236\u63d2\u4ef6\u3011");
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
        object = this.createDEField("GRIDCOLALIGN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bcd60b2ed94cf0f240880a37d6d55908");
            pSDEFieldModel.setName("GRIDCOLALIGN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8868\u683c\u5217\u5bf9\u9f50");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridColAlignCodeListModel");
            pSDEFieldModel.setCodeName("GridColAlign");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u8868\u683c\u5217\u7684\u5bf9\u9f50\u65b9\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5de6\u5bf9\u9f50\u3011");
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
            pSDEFieldModel.setId("d7d88b4d7198eaed80da095ed3e33d3f");
            pSDEFieldModel.setName("GRIDCOLCLMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8868\u683c\u5217\u4ee3\u7801\u503c\u8f6c\u6362");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.CLConvertModesCodeListModel");
            pSDEFieldModel.setCodeName("GridColCLMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u8868\u683c\u5217\u4ee3\u7801\u503c\u7684\u8f6c\u6362\u6a21\u5f0f");
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
            pSDEFieldModel.setId("47044650d18a6e6607428f48e61a528f");
            pSDEFieldModel.setName("GRIDCOLWIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u5217\u5bbd");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("GridColWidth");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u8868\u683c\u5217\u7684\u9ed8\u8ba4\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010100\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HEIGHT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ff4a0e5e114b8128ea548cb57a7d0288");
            pSDEFieldModel.setName("HEIGHT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u63a7\u4ef6\u9ad8\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Height");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u7684\u9ed8\u8ba4\u9ad8\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u7f16\u8f91\u5668\u9ed8\u8ba4\u9ad8\u5ea6");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("IGNOREINPUT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7e366170019cdd2ddf2a68df7445f4c2");
            pSDEFieldModel.setName("IGNOREINPUT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5ffd\u7565\u8f93\u5165\u503c");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FIValueIgnoreModeCodeListModel");
            pSDEFieldModel.setCodeName("IgnoreInput");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u5ffd\u7565\u8f93\u5165\u503c\u7684\u65b9\u5f0f");
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
        object = this.createDEField("ITEMPSACHANDLERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0a259fd345e25132356ad6e4af332a07");
            pSDEFieldModel.setName("ITEMPSACHANDLERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9879\u5904\u7406\u5bf9\u8c61");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSACHANDLER_ITEMPSACHANDLERID");
            pSDEFieldModel.setLinkDEFName("PSACHANDLERID");
            pSDEFieldModel.setCodeName("ItemPSACHandlerId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMPSACHANDLERID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMPSACHANDLERID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ITEMPSACHANDLERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e6f8aeaf7ec5c14726155a7a4831b7c8");
            pSDEFieldModel.setName("ITEMPSACHANDLERNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u9879\u5904\u7406\u5bf9\u8c61");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSACHANDLER_ITEMPSACHANDLERID");
            pSDEFieldModel.setLinkDEFName("PSACHANDLERNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("ItemPSACHandlerName");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMPSACHANDLERNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMPSACHANDLERNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMPSACHANDLERNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMPSACHANDLERNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("JSFORMAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5a18a67bce0ac7fd4b4881f3e420a747");
            pSDEFieldModel.setName("JSFORMAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("JS\u683c\u5f0f\u5316");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("JSFormat");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LOCKFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1408a3287e61c77ceea12371cbf85f1d");
            pSDEFieldModel.setName("LOCKFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u578b\u9501\u6807\u5fd7");
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
        object = this.createDEField("MAXVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2be66affc45b7a97f487e3b5c790ecc3");
            pSDEFieldModel.setName("MAXVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6700\u5927\u503c");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MaxValue");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("176f207e1633434296a069a6bd347674");
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
            pSDEFieldModel.setId("44f389e753d95ee6613a633a885d76e1");
            pSDEFieldModel.setName("MINSTRLENGTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6700\u5c0f\u5b57\u7b26\u957f\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MinStrLength");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MINVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d04550e80ad012ef5e560e591a693158");
            pSDEFieldModel.setName("MINVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6700\u5c0f\u503c");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MinValue");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("NEEDCODELISTCONFIG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("13c4a3ea6162ff19a662ffa7102bac3c");
            pSDEFieldModel.setName("NEEDCODELISTCONFIG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9700\u8981\u63d0\u4f9b\u4ee3\u7801\u8868\u914d\u7f6e");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("NeedCodeListConfig");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u662f\u5426\u9700\u8981\u63d0\u4f9b\u4ee3\u7801\u8868\u914d\u7f6e\uff0c\u672a\u5b9a\u4e49\u7531\u7f16\u8f91\u5668\u7c7b\u578b\u51b3\u5b9a");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("NOSORT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e239f7b9f554065aa0f5b8ccbf31ae4c");
            pSDEFieldModel.setName("NOSORT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7981\u7528\u6392\u5e8f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("NoSort");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u8868\u683c\u5217\u7684\u662f\u5426\u7981\u7528\u6392\u5e8f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u957f\u6587\u672c\u5c5e\u6027\uff08CLOB\uff09\u4e3a\u3010\u662f\u3011\uff0c\u5176\u5b83\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PHPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1ce5042d345b5e04398c74fe2fb26293");
            pSDEFieldModel.setName("PHPSLANRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5360\u4f4d\u63d0\u793a\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSLANGUAGERES_PHPSLANRESID");
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
            pSDEFieldModel.setId("ae1d9e6160654a0c2e06f492e471afc9");
            pSDEFieldModel.setName("PHPSLANRESNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5360\u4f4d\u63d0\u793a\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSLANGUAGERES_PHPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESNAME");
            pSDEFieldModel.setCodeName("PHPSLanResName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5360\u4f4d\u63d0\u793a\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
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
        object = this.createDEField("PICKUPTEXTOPTS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4ec479cc88eb6869603da8928c7a7a0f");
            pSDEFieldModel.setName("PICKUPTEXTOPTS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5916\u952e\u6587\u672c\u5c5e\u6027\u8bbe\u5b9a");
            pSDEFieldModel.setDataType("NMCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldUIPickupTextOptsCodeListModel");
            pSDEFieldModel.setCodeName("PickupTextOpts");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u5916\u952e\u6587\u672c\u7f16\u8f91\u9879\u7684\u8bbe\u5b9a\uff0c\u9ed8\u8ba4\u60c5\u51b5\u4e0b\u5916\u952e\u6587\u672c\u7f16\u8f91\u9879\u4f1a\u4f7f\u7528\u5f15\u7528\u5173\u7cfb\u4e2d\u5b9a\u4e49\u7684\u914d\u7f6e\u4fe1\u606f\uff0c\u5916\u952e\u6587\u672c\u5c5e\u6027\u8bbe\u5b9a\u652f\u6301\u5b9a\u4e49\u4f7f\u7528\u5f15\u7528\u5173\u7cfb\u914d\u7f6e\u7684\u6a21\u5f0f");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PLACEHOLDER");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("551a3e26cf59a722fea325cd80aaafcc");
            pSDEFieldModel.setName("PLACEHOLDER");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5360\u4f4d\u63d0\u793a");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PlaceHolder");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5360\u4f4d\u63d0\u793a");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PRECISION2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7efe0a14956f5c7f9195956e04a91092");
            pSDEFieldModel.setName("PRECISION2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6d6e\u70b9\u7cbe\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Precision2");
            pSDEFieldModel.setServiceCodeName("Precision");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREVENTXSS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("dda86e9dfb97827197eb74181f62da63");
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
            pSDEFieldModel.setId("e423f521de394fb2b25c64670348d9f0");
            pSDEFieldModel.setName("PSCODELISTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u4ee3\u7801\u8868");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSCODELIST_PSCODELISTID");
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
            pSDEFieldModel.setId("0f494c2743bcf14d27e1ecd250c3927e");
            pSDEFieldModel.setName("PSCODELISTNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u4ee3\u7801\u8868");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSCODELIST_PSCODELISTID");
            pSDEFieldModel.setLinkDEFName("PSCODELISTNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSCodeListName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u76f8\u5173\u7684\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u914d\u7f6e");
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
        object = this.createDEField("PSDEFFORMITEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("27387533390c48e69154f37bb1b12a47");
            pSDEFieldModel.setName("PSDEFFORMITEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5c5e\u6027\u8868\u5355\u9879\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDEFUIModeId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFFORMITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("962e97c113e1b042c35ea036de79290e");
            pSDEFieldModel.setName("PSDEFFORMITEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSDEFUIModeName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u754c\u9762\u6a21\u5f0f\u7684\u540d\u79f0");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFFORMITEMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFFORMITEMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFFORMITEMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFFORMITEMNAME_LIKE");
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
            pSDEFieldModel.setId("296bec8708d71d5738e2f3d101dc2cec");
            pSDEFieldModel.setName("PSDEFID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5c5e\u6027");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID");
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
        object = this.createDEField("PSDEFINPUTTIPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("687110b220b7c0fdb7250b16e0fc7c02");
            pSDEFieldModel.setName("PSDEFINPUTTIPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5c5e\u6027\u8f93\u5165\u63d0\u793a");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEFINPUTTIP_PSDEFINPUTTIPID");
            pSDEFieldModel.setLinkDEFName("PSDEFINPUTTIPID");
            pSDEFieldModel.setCodeName("PSDEFInputTipId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFINPUTTIPID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFINPUTTIPID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFINPUTTIPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d0f589a0b85f77857a496ce746c0bc2c");
            pSDEFieldModel.setName("PSDEFINPUTTIPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5c5e\u6027\u8f93\u5165\u63d0\u793a");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEFINPUTTIP_PSDEFINPUTTIPID");
            pSDEFieldModel.setLinkDEFName("PSDEFINPUTTIPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEFInputTipName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u76f8\u5173\u7684\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFINPUTTIPNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFINPUTTIPNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFINPUTTIPNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFINPUTTIPNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
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
            pSDEFieldModel.setId("874da3948465ec53fd89e81c01da98ea");
            pSDEFieldModel.setName("PSDEFNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5c5e\u6027");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDEFIELDNAME");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDEFName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u6240\u5728\u7684\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61");
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
            pSDEFieldModel.setId("b532ca948acbf5f712fba7cd6eca8c52");
            pSDEFieldModel.setName("PSDEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDEID");
            pSDEFieldModel.setPhisicalDEField(false);
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
            pSDEFieldModel.setId("44801cac5778d2db83e8f85ecc68eccd");
            pSDEFieldModel.setName("PSDENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDENAME");
            pSDEFieldModel.setPhisicalDEField(false);
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
        object = this.createDEField("PSDYNAINSTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9f1af6c78716da816d77f9589172fc41");
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
        object = this.createDEField("PSSYSAPPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5a0e6ff10703900dfba3904fee713e0f");
            pSDEFieldModel.setName("PSSYSAPPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u5e94\u7528");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSSYSAPP_PSSYSAPPID");
            pSDEFieldModel.setLinkDEFName("PSSYSAPPID");
            pSDEFieldModel.setCodeName("PSSysAppId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSAPPID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSAPPID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSAPPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("af375225170f05a0d9441b8f50892a13");
            pSDEFieldModel.setName("PSSYSAPPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u5e94\u7528");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSSYSAPP_PSSYSAPPID");
            pSDEFieldModel.setLinkDEFName("PSSYSAPPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysAppName");
            pSDEFieldModel.setMemo("\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u5e94\u7528\u573a\u5408\u4e3a\u6307\u5b9a\u524d\u7aef\u5e94\u7528\u9ed8\u8ba4\u65f6\u6307\u524d\u7aef\u5e94\u7528\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSAPPNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSAPPNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSAPPNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSAPPNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDICTCATID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("146ded7dcb68d816586b2627aa59ab6e");
            pSDEFieldModel.setName("PSSYSDICTCATID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u8bcd\u6761\u7c7b\u522b");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSSYSDICTCAT_PSSYSDICTCATID");
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
            pSDEFieldModel.setId("007160efacec5ed14b774c6eac989f2d");
            pSDEFieldModel.setName("PSSYSDICTCATNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u8bcd\u6761\u7c7b\u522b");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSSYSDICTCAT_PSSYSDICTCATID");
            pSDEFieldModel.setLinkDEFName("PSSYSDICTCATNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysDictCatName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u8f85\u52a9\u8f93\u5165\u8bcd\u6761\u7c7b\u522b\u5bf9\u8c61");
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
        object = this.createDEField("PSSYSEDITORSTYLEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e0d1dc61a4514909a1c0286d95649d11");
            pSDEFieldModel.setName("PSSYSEDITORSTYLEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID");
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
            pSDEFieldModel.setId("1a1e6b58c61eef200b019cbcfb754f79");
            pSDEFieldModel.setName("PSSYSEDITORSTYLENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID");
            pSDEFieldModel.setLinkDEFName("PSSYSEDITORSTYLENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysEditorStyleName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u7f16\u8f91\u5668\u6269\u5c55\u6837\u5f0f\u5bf9\u8c61");
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
            pSDEFieldModel.setId("b8a84d07cb9f549130705686f68a6cbc");
            pSDEFieldModel.setName("PSSYSIMAGEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u9879\u56fe\u7247");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSSYSIMAGE_PSSYSIMAGEID");
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
            pSDEFieldModel.setId("157f35f6e3baaac77bfe5c4382bf55f3");
            pSDEFieldModel.setName("PSSYSIMAGENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u9879\u56fe\u7247");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSSYSIMAGE_PSSYSIMAGEID");
            pSDEFieldModel.setLinkDEFName("PSSYSIMAGENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysImageName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u56fe\u7247\u5bf9\u8c61");
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
        object = this.createDEField("PSSYSTEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ad7866992e032b9e994c42167f5fe1c1");
            pSDEFieldModel.setName("PSSYSTEMID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("PSSYSTEMID");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEFIELD_PSDEFID");
            pSDEFieldModel.setLinkDEFName("PSSYSTEMID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSystemId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSUNITID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("01174b3a4d6dcd0bf4e094a802973967");
            pSDEFieldModel.setName("PSSYSUNITID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5355\u4f4d");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSSYSUNIT_PSSYSUNITID");
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
            pSDEFieldModel.setId("85838a316f3bf526fcb99a14eae6a0a5");
            pSDEFieldModel.setName("PSSYSUNITNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5355\u4f4d");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSSYSUNIT_PSSYSUNITID");
            pSDEFieldModel.setLinkDEFName("PSSYSUNITNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysUnitName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u6307\u5b9a\u7684\u5355\u4f4d\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u6240\u5c5e\u5c5e\u6027\u5b9a\u4e49\u7684\u5355\u4f4d\u5bf9\u8c61");
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
            pSDEFieldModel.setId("206f4eee35b809359ebb6dc240f6312f");
            pSDEFieldModel.setName("PSSYSVALUERULEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u503c\u89c4\u5219");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSSYSVALUERULE_PSSYSVALUERULEID");
            pSDEFieldModel.setLinkDEFName("PSSYSVALUERULEID");
            pSDEFieldModel.setCodeName("PSSysValueRuleId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
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
            pSDEFieldModel.setId("661d579b05734476ab4bd474f4752a1b");
            pSDEFieldModel.setName("PSSYSVALUERULENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u503c\u89c4\u5219");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSSYSVALUERULE_PSSYSVALUERULEID");
            pSDEFieldModel.setLinkDEFName("PSSYSVALUERULENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysValueRuleName");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
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
        object = this.createDEField("REFADPSDELOGICID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6e97272da6e44ffd37b0556c216d3670");
            pSDEFieldModel.setName("REFADPSDELOGICID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u6570\u636e\u96c6\u67e5\u8be2\u903b\u8f91");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDELOGIC_REFADPSDELOGICID");
            pSDEFieldModel.setLinkDEFName("PSDELOGICID");
            pSDEFieldModel.setCodeName("RefADPSDELogicId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFADPSDELOGICID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFADPSDELOGICID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFADPSDELOGICNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("11e740617f4ee81824c523a3c826c7bc");
            pSDEFieldModel.setName("REFADPSDELOGICNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u6570\u636e\u96c6\u67e5\u8be2\u903b\u8f91");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDELOGIC_REFADPSDELOGICID");
            pSDEFieldModel.setLinkDEFName("PSDELOGICNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RefADPSDELogicName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u96c6\u4e0a\u4e0b\u6587\u8f6c\u6362\u903b\u8f91\u5bf9\u8c61\uff0c\u5c06\u8c03\u7528\u73af\u5883\u53c2\u6570\u8f6c\u6362\u4e3a\u6570\u636e\u96c6\u7684\u8c03\u7528\u53c2\u6570");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFADPSDELOGICNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFADPSDELOGICNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFADPSDELOGICNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFADPSDELOGICNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFLINKPSDEVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f38549a5a876213c318024123df76d7d");
            pSDEFieldModel.setName("REFLINKPSDEVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u8054\u5b9e\u4f53\u94fe\u63a5\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEVIEWBASE_REFLINKPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setCodeName("RefLinkPSDEViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFLINKPSDEVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFLINKPSDEVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFLINKPSDEVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4d90a557f664b0411d55739258484f6d");
            pSDEFieldModel.setName("REFLINKPSDEVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5173\u8054\u5b9e\u4f53\u94fe\u63a5\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEVIEWBASE_REFLINKPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RefLinkPSDEViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u94fe\u63a5\u89c6\u56fe");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFLINKPSDEVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFLINKPSDEVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFLINKPSDEVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFLINKPSDEVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFMPICKUPPSDEVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bdb93432c8b7392d411cef146fcadfa1");
            pSDEFieldModel.setName("REFMPICKUPPSDEVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u8054\u5b9e\u4f53\u591a\u9009\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEVIEWBASE_REFMPICKUPPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setCodeName("RefMPickupPSDEViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFMPICKUPPSDEVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFMPICKUPPSDEVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFMPICKUPPSDEVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1c2e77886439bd490175c9f782526464");
            pSDEFieldModel.setName("REFMPICKUPPSDEVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5173\u8054\u5b9e\u4f53\u591a\u9009\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEVIEWBASE_REFMPICKUPPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RefMPickupPSDEViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u7684\u591a\u9879\u9009\u62e9\u89c6\u56fe");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFMPICKUPPSDEVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFMPICKUPPSDEVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFMPICKUPPSDEVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFMPICKUPPSDEVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPICKUPPSDEVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2987f2df2534c196e28beb8d4dc12f54");
            pSDEFieldModel.setName("REFPICKUPPSDEVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u8054\u5b9e\u4f53\u5355\u9009\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEVIEWBASE_REFPICKUPPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setCodeName("RefPickupPSDEViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPICKUPPSDEVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPICKUPPSDEVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPICKUPPSDEVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("39b0bb777bfb669394162bb01969408e");
            pSDEFieldModel.setName("REFPICKUPPSDEVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5173\u8054\u5b9e\u4f53\u5355\u9009\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEVIEWBASE_REFPICKUPPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RefPickupPSDEViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u7684\u5355\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPICKUPPSDEVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPICKUPPSDEVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPICKUPPSDEVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPICKUPPSDEVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDEACMODEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("69b3ca462ef56fe6095c41759f768daa");
            pSDEFieldModel.setName("REFPSDEACMODEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u8054\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEACMODE_REFPSDEACMODEID");
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
            pSDEFieldModel.setId("2e4efe629eb0193257a419aebc258d5f");
            pSDEFieldModel.setName("REFPSDEACMODENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5173\u8054\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEACMODE_REFPSDEACMODEID");
            pSDEFieldModel.setLinkDEFName("PSDEACMODENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RefPSDEACModeName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u81ea\u586b\u6a21\u5f0f\uff0c\u63d0\u4f9b\u81ea\u52a8\u586b\u5145\u80fd\u529b\u7684\u7f16\u8f91\u5668\u90fd\u9700\u8981\u6307\u5b9a\u5f15\u7528\u7684\u81ea\u586b\u6a21\u5f0f");
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
            pSDEFieldModel.setId("ff895a462a12e02b2432f8d5075e2077");
            pSDEFieldModel.setName("REFPSDEDATASETID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEDATASET_REFPSDEDATASETID");
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
            pSDEFieldModel.setId("c37f4ad01b30f93f4af947d99b0014ad");
            pSDEFieldModel.setName("REFPSDEDATASETNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDEDATASET_REFPSDEDATASETID");
            pSDEFieldModel.setLinkDEFName("PSDEDATASETNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RefPSDEDataSetName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u96c6\uff0c\u63d0\u4f9b\u81ea\u52a8\u586b\u5145\u80fd\u529b\u7684\u7f16\u8f91\u5668\u90fd\u9700\u8981\u6307\u5b9a\u5f15\u7528\u7684\u6570\u636e\u96c6");
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
            pSDEFieldModel.setId("168401198fe2287b50a935c356b4c2da");
            pSDEFieldModel.setName("REFPSDEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDATAENTITY_REFPSDEID");
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
            pSDEFieldModel.setId("bae83d82a5394c13ad0b5b4183b597d8");
            pSDEFieldModel.setName("REFPSDENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDATAENTITY_REFPSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYNAME");
            pSDEFieldModel.setCodeName("RefPSDEName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u96c6\u7684\u6240\u5728\u5b9e\u4f53");
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
            pSDEFieldModel.setId("988478076b48172a917ceb8d0e2b1d3f");
            pSDEFieldModel.setName("REFPSDERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u5173\u7cfb");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDER_REFPSDERID");
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
            pSDEFieldModel.setId("7fba748c9732fbc036200dd576685117");
            pSDEFieldModel.setName("REFPSDERNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u5173\u7cfb");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFFORMITEM_PSDER_REFPSDERID");
            pSDEFieldModel.setLinkDEFName("PSDERNAME");
            pSDEFieldModel.setCodeName("RefPSDERName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u96c6\u7684\u4f7f\u7528\u5173\u7cfb");
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
        object = this.createDEField("REFTEMPDATA");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("33001cbc0b0c3f55b70a9268e6924382");
            pSDEFieldModel.setName("REFTEMPDATA");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u4e34\u65f6\u6570\u636e");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("RefTempData");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u96c6\u662f\u5426\u4e3a\u4e34\u65f6\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RESETITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0a03692ca9d46ff14568b06e5b518ad0");
            pSDEFieldModel.setName("RESETITEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u91cd\u7f6e\u9879\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ResetItemName");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u91cd\u7f6e\u9879\u540d\u79f0\uff0c\u9700\u914d\u7f6e\u542f\u7528\u91cd\u7f6e\u9879\u540d\u79f0");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("STRINGCASE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a447a43da79cca909550031a9593f864");
            pSDEFieldModel.setName("STRINGCASE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b57\u7b26\u8f6c\u6362");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.StringCaseModeCodeListModel");
            pSDEFieldModel.setCodeName("StringCase");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_STRINGCASE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_STRINGCASE_EQ");
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
            pSDEFieldModel.setId("d4e7f267459da3629333c7b9eb1e076a");
            pSDEFieldModel.setName("STRLENGTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b57\u7b26\u957f\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("StrLength");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UNITNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("76debc82f2b3c62ea75897c1e84a3ccb");
            pSDEFieldModel.setName("UNITNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5355\u4f4d");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UnitName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u5355\u4f4d\u540d\u79f0\uff0c\u65e9\u671f\u6a21\u5f0f");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UNITNAMEWIDTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4eef0a15a55b835af12de4b6c7b69ba8");
            pSDEFieldModel.setName("UNITNAMEWIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5355\u4f4d\u5bbd\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UnitNameWidth");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u5355\u4f4d\u540d\u79f0\u5bbd\u5ea6\uff0c\u65e9\u671f\u6a21\u5f0f");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("59ba1909ca1124511c0cb22ca6a0956e");
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
            pSDEFieldModel.setId("ebffc1fcfbe34eee888c384bd7bfb85c");
            pSDEFieldModel.setName("UPDATEDV");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u65b0\u9ed8\u8ba4\u503c");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UpdateDV");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u66f4\u65b0\u9ed8\u8ba4\u503c\uff0c\u672a\u6307\u5b9a\u9ed8\u8ba4\u503c\u7c7b\u578b\u65f6\u6309\u76f4\u63a5\u503c\u5904\u7406");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEDVT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("203f525215b50afbfaaedc5cb37d492d");
            pSDEFieldModel.setName("UPDATEDVT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u65b0\u9ed8\u8ba4\u503c\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldDefaultValueType2CodeListModel");
            pSDEFieldModel.setCodeName("UpdateDVT");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u66f4\u65b0\u9ed8\u8ba4\u503c\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u76f4\u63a5\u503c\u3011");
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
            pSDEFieldModel.setId("1e18a4dc4e84fff0733364c5571c63aa");
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
            pSDEFieldModel.setId("d503119c82ae5d903e813546dfbe99b6");
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
            pSDEFieldModel.setId("bd629ead499f7ebae976516beac94ef6");
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
            pSDEFieldModel.setId("98dbdc86b8170aeb5954a7fbde07f638");
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
            pSDEFieldModel.setId("a79c57ff29de479c66ba9e54cdff25d7");
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
            pSDEFieldModel.setId("0bd91940e8eef3e23b246ddda4b8c8db");
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
            pSDEFieldModel.setId("4793e23743f255ed91694ddde8a0d3a7");
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
        object = this.createDEField("VALUEFORMAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1f99e27d665f7420a2544a9c2843d092");
            pSDEFieldModel.setName("VALUEFORMAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u503c\u683c\u5f0f\u5316");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ValueFormat");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u503c\u683c\u5f0f\u5316\u4e32\uff0c\u8f6c\u5316\u539f\u59cb\u503c\u5230\u754c\u9762\u5c55\u793a\u5185\u5bb9\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u7684\u683c\u5f0f\u5316\u4e32\u914d\u7f6e");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VALUEITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("092479872e5e275dfe05ba4cb91ac560");
            pSDEFieldModel.setName("VALUEITEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u503c\u9879\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ValueItemName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u503c\u9879\u540d\u79f0");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIDTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("70fcde6ca2943e01a806660bb7cc263a");
            pSDEFieldModel.setName("WIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u63a7\u4ef6\u5bbd\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Width");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u8868\u5355\u9879\u7f16\u8f91\u5668\u7684\u9ed8\u8ba4\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u7f16\u8f91\u5668\u9ed8\u8ba4\u5bbd\u5ea6");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSDEFUIModeDefaultACModel pSDEFUIModeDefaultACModel = new PSDEFUIModeDefaultACModel();
        pSDEFUIModeDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDEFUIModeDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDEFUIModeCurAppDSModel pSDEFUIModeCurAppDSModel = new PSDEFUIModeCurAppDSModel();
        pSDEFUIModeCurAppDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEFUIModeCurAppDSModel);
        PSDEFUIModeCurDEFDSModel pSDEFUIModeCurDEFDSModel = new PSDEFUIModeCurDEFDSModel();
        pSDEFUIModeCurDEFDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEFUIModeCurDEFDSModel);
        PSDEFUIModeCurSysDSModel pSDEFUIModeCurSysDSModel = new PSDEFUIModeCurSysDSModel();
        pSDEFUIModeCurSysDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEFUIModeCurSysDSModel);
        PSDEFUIModeDefaultDSModel pSDEFUIModeDefaultDSModel = new PSDEFUIModeDefaultDSModel();
        pSDEFUIModeDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEFUIModeDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDEFUIModeCurAppDQModel pSDEFUIModeCurAppDQModel = new PSDEFUIModeCurAppDQModel();
        pSDEFUIModeCurAppDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEFUIModeCurAppDQModel);
        PSDEFUIModeCurDEFDQModel pSDEFUIModeCurDEFDQModel = new PSDEFUIModeCurDEFDQModel();
        pSDEFUIModeCurDEFDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEFUIModeCurDEFDQModel);
        PSDEFUIModeCurSysDQModel pSDEFUIModeCurSysDQModel = new PSDEFUIModeCurSysDQModel();
        pSDEFUIModeCurSysDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEFUIModeCurSysDQModel);
        PSDEFUIModeDefaultDQModel pSDEFUIModeDefaultDQModel = new PSDEFUIModeDefaultDQModel();
        pSDEFUIModeDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEFUIModeDefaultDQModel);
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
        this.registerPDTDEView("EDITVIEW", "acb6d63968f978bae38073b3a0d1f1eb");
        this.registerPDTDEView("MPICKUPVIEW", "f1c651b7f25668f5eda38f5cfe9d5030");
        this.registerPDTDEView("PICKUPVIEW", "2c500a636a328e0e6f745c561afacca6");
        this.registerPDTDEView("REDIRECTVIEW", "b3681b072bfd7a0539ab067b47e767f6");
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
        dEDataSetCond2.setDEFName("PSDEFFORMITEMNAME");
        dEDataSetCond2.setCondValue(string);
        dEDataSetCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)dEDataSetCond2);
        dEDataSetCond2 = new DEDataSetCond();
        dEDataSetCond2.setCondType("DEFIELD");
        dEDataSetCond2.setCondOp("LIKE");
        dEDataSetCond2.setDEFName("PSDEFNAME");
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
        pSDEFGroupDetailModel.setId("4759e41bccdb337649f2d4d52c3182df");
        pSDEFGroupDetailModel.setName("CAPPSLANRESID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u6807\u9898\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u903b\u8f91\u540d\u79f0\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9b409f71506d6d245f538fa477509d50");
        pSDEFGroupDetailModel.setName("CAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u6807\u9898\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u903b\u8f91\u540d\u79f0\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6c9521cc369397d81526597df1b96cd8");
        pSDEFGroupDetailModel.setName("CAPTION");
        iPSDEFieldModel = this.getDEField("CAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u6807\u9898\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u7684\u903b\u8f91\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("79e5173d5d9ba250b89a61a21a7a8ca6");
        pSDEFGroupDetailModel.setName("CODELISTCONFIGMODE");
        iPSDEFieldModel = this.getDEField("CODELISTCONFIGMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.OutputCodeListConfigModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4ee3\u7801\u8868\u914d\u7f6e\u7684\u8f93\u51fa\u6a21\u5f0f\uff0c\u6b64\u914d\u7f6e\u5e94\u7528\u4e8e\u65e9\u671f\u6280\u672f\u7684\u524d\u7aef\u6a21\u677f\u3002\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c8fcf38440f5f28a64d608c9d68dbc22");
        pSDEFGroupDetailModel.setName("CODENAME");
        iPSDEFieldModel = this.getDEField("CODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u8981\u5728\u6240\u5728\u7684\u5b9e\u4f53\u5c5e\u6027\u4e2d\u5177\u6709\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2b012b1ebf173fa6fcabd40ae794306a");
        pSDEFGroupDetailModel.setName("CREATEDV");
        iPSDEFieldModel = this.getDEField("CREATEDV", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5efa\u7acb\u9ed8\u8ba4\u503c\uff0c\u672a\u6307\u5b9a\u9ed8\u8ba4\u503c\u7c7b\u578b\u65f6\u6309\u76f4\u63a5\u503c\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("306d9fdbd2109d7d6a57d6898b3b7e5a");
        pSDEFGroupDetailModel.setName("CREATEDVT");
        iPSDEFieldModel = this.getDEField("CREATEDVT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldDefaultValueTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5efa\u7acb\u9ed8\u8ba4\u503c\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u76f4\u63a5\u503c\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bf4137c66e6b467d857b17b4beec7428");
        pSDEFGroupDetailModel.setName("EDITORPARAMS");
        iPSDEFieldModel = this.getDEField("EDITORPARAMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u5668\u53c2\u6570\u96c6\u5408");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c450ef53a15a83eca4e0144cd7f33515");
        pSDEFGroupDetailModel.setName("EDITORTYPE");
        iPSDEFieldModel = this.getDEField("EDITORTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormItemEditorCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u7f16\u8f91\u5668\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6e9f318a70d600bc0e4a9a549b6971b1");
        pSDEFGroupDetailModel.setName("ENABLEINPUTTIP");
        iPSDEFieldModel = this.getDEField("ENABLEINPUTTIP", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u662f\u5426\u6307\u5b9a\u8f93\u5165\u63d0\u793a\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("670a89fc33feed286d69e6f5ed23830d");
        pSDEFGroupDetailModel.setName("ENABLERESETITEMNAME");
        iPSDEFieldModel = this.getDEField("ENABLERESETITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u662f\u5426\u542f\u7528\u91cd\u7f6e\u9879\u540d\u79f0\u914d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("929e470a3a06fd9f7ed412f026751764");
        pSDEFGroupDetailModel.setName("ENABLEUNITNAME");
        iPSDEFieldModel = this.getDEField("ENABLEUNITNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u662f\u5426\u542f\u7528\u5355\u4f4d\u540d\u79f0\u914d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ffcda9d4e699a79be984778e395986d0");
        pSDEFGroupDetailModel.setName("FTMODE");
        iPSDEFieldModel = this.getDEField("FTMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldUIModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u5e94\u7528\u573a\u5408");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4117869a3ec3ac18fcf8eee952d36dfb");
        pSDEFGroupDetailModel.setName("GCRPSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("GCRPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u8868\u683c\u5217\u7ed8\u5236\u63d2\u4ef6\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u6570\u636e\u8868\u683c\u5217\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cf8f9eb32cde50ec880529033eff2b3c");
        pSDEFGroupDetailModel.setName("GCRPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("GCRPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u8868\u683c\u5217\u7ed8\u5236\u63d2\u4ef6\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u6570\u636e\u8868\u683c\u5217\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bcd60b2ed94cf0f240880a37d6d55908");
        pSDEFGroupDetailModel.setName("GRIDCOLALIGN");
        iPSDEFieldModel = this.getDEField("GRIDCOLALIGN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridColAlignCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u8868\u683c\u5217\u7684\u5bf9\u9f50\u65b9\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5de6\u5bf9\u9f50\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d7d88b4d7198eaed80da095ed3e33d3f");
        pSDEFGroupDetailModel.setName("GRIDCOLCLMODE");
        iPSDEFieldModel = this.getDEField("GRIDCOLCLMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.CLConvertModesCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u8868\u683c\u5217\u4ee3\u7801\u503c\u7684\u8f6c\u6362\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("47044650d18a6e6607428f48e61a528f");
        pSDEFGroupDetailModel.setName("GRIDCOLWIDTH");
        iPSDEFieldModel = this.getDEField("GRIDCOLWIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u8868\u683c\u5217\u7684\u9ed8\u8ba4\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010100\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ff4a0e5e114b8128ea548cb57a7d0288");
        pSDEFGroupDetailModel.setName("HEIGHT");
        iPSDEFieldModel = this.getDEField("HEIGHT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7f16\u8f91\u5668\u7684\u9ed8\u8ba4\u9ad8\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u7f16\u8f91\u5668\u9ed8\u8ba4\u9ad8\u5ea6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7e366170019cdd2ddf2a68df7445f4c2");
        pSDEFGroupDetailModel.setName("IGNOREINPUT");
        iPSDEFieldModel = this.getDEField("IGNOREINPUT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FIValueIgnoreModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u5ffd\u7565\u8f93\u5165\u503c\u7684\u65b9\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0a259fd345e25132356ad6e4af332a07");
        pSDEFGroupDetailModel.setName("ITEMPSACHANDLERID");
        iPSDEFieldModel = this.getDEField("ITEMPSACHANDLERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e6f8aeaf7ec5c14726155a7a4831b7c8");
        pSDEFGroupDetailModel.setName("ITEMPSACHANDLERNAME");
        iPSDEFieldModel = this.getDEField("ITEMPSACHANDLERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1408a3287e61c77ceea12371cbf85f1d");
        pSDEFGroupDetailModel.setName("LOCKFLAG");
        iPSDEFieldModel = this.getDEField("LOCKFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("176f207e1633434296a069a6bd347674");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("13c4a3ea6162ff19a662ffa7102bac3c");
        pSDEFGroupDetailModel.setName("NEEDCODELISTCONFIG");
        iPSDEFieldModel = this.getDEField("NEEDCODELISTCONFIG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u662f\u5426\u9700\u8981\u63d0\u4f9b\u4ee3\u7801\u8868\u914d\u7f6e\uff0c\u672a\u5b9a\u4e49\u7531\u7f16\u8f91\u5668\u7c7b\u578b\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1ce5042d345b5e04398c74fe2fb26293");
        pSDEFGroupDetailModel.setName("PHPSLANRESID");
        iPSDEFieldModel = this.getDEField("PHPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5360\u4f4d\u63d0\u793a\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ae1d9e6160654a0c2e06f492e471afc9");
        pSDEFGroupDetailModel.setName("PHPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("PHPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5360\u4f4d\u63d0\u793a\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e423f521de394fb2b25c64670348d9f0");
        pSDEFGroupDetailModel.setName("PSCODELISTID");
        iPSDEFieldModel = this.getDEField("PSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u76f8\u5173\u7684\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0f494c2743bcf14d27e1ecd250c3927e");
        pSDEFGroupDetailModel.setName("PSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("PSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u76f8\u5173\u7684\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("296bec8708d71d5738e2f3d101dc2cec");
        pSDEFGroupDetailModel.setName("PSDEFID");
        iPSDEFieldModel = this.getDEField("PSDEFID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u6240\u5728\u7684\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("687110b220b7c0fdb7250b16e0fc7c02");
        pSDEFGroupDetailModel.setName("PSDEFINPUTTIPID");
        iPSDEFieldModel = this.getDEField("PSDEFINPUTTIPID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u76f8\u5173\u7684\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d0f589a0b85f77857a496ce746c0bc2c");
        pSDEFGroupDetailModel.setName("PSDEFINPUTTIPNAME");
        iPSDEFieldModel = this.getDEField("PSDEFINPUTTIPNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u76f8\u5173\u7684\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("874da3948465ec53fd89e81c01da98ea");
        pSDEFGroupDetailModel.setName("PSDEFNAME");
        iPSDEFieldModel = this.getDEField("PSDEFNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u6240\u5728\u7684\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("962e97c113e1b042c35ea036de79290e");
        pSDEFGroupDetailModel.setName("PSDEFFORMITEMNAME");
        iPSDEFieldModel = this.getDEField("PSDEFFORMITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u754c\u9762\u6a21\u5f0f\u7684\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b532ca948acbf5f712fba7cd6eca8c52");
        pSDEFGroupDetailModel.setName("PSDEID");
        iPSDEFieldModel = this.getDEField("PSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5a0e6ff10703900dfba3904fee713e0f");
        pSDEFGroupDetailModel.setName("PSSYSAPPID");
        iPSDEFieldModel = this.getDEField("PSSYSAPPID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u5e94\u7528\u573a\u5408\u4e3a\u6307\u5b9a\u524d\u7aef\u5e94\u7528\u9ed8\u8ba4\u65f6\u6307\u524d\u7aef\u5e94\u7528\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("af375225170f05a0d9441b8f50892a13");
        pSDEFGroupDetailModel.setName("PSSYSAPPNAME");
        iPSDEFieldModel = this.getDEField("PSSYSAPPNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u5e94\u7528\u573a\u5408\u4e3a\u6307\u5b9a\u524d\u7aef\u5e94\u7528\u9ed8\u8ba4\u65f6\u6307\u524d\u7aef\u5e94\u7528\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("146ded7dcb68d816586b2627aa59ab6e");
        pSDEFGroupDetailModel.setName("PSSYSDICTCATID");
        iPSDEFieldModel = this.getDEField("PSSYSDICTCATID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u8f85\u52a9\u8f93\u5165\u8bcd\u6761\u7c7b\u522b\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("007160efacec5ed14b774c6eac989f2d");
        pSDEFGroupDetailModel.setName("PSSYSDICTCATNAME");
        iPSDEFieldModel = this.getDEField("PSSYSDICTCATNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u8f85\u52a9\u8f93\u5165\u8bcd\u6761\u7c7b\u522b\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e0d1dc61a4514909a1c0286d95649d11");
        pSDEFGroupDetailModel.setName("PSSYSEDITORSTYLEID");
        iPSDEFieldModel = this.getDEField("PSSYSEDITORSTYLEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u7f16\u8f91\u5668\u6269\u5c55\u6837\u5f0f\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1a1e6b58c61eef200b019cbcfb754f79");
        pSDEFGroupDetailModel.setName("PSSYSEDITORSTYLENAME");
        iPSDEFieldModel = this.getDEField("PSSYSEDITORSTYLENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u7f16\u8f91\u5668\u6269\u5c55\u6837\u5f0f\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b8a84d07cb9f549130705686f68a6cbc");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u56fe\u7247\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("157f35f6e3baaac77bfe5c4382bf55f3");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u56fe\u7247\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01174b3a4d6dcd0bf4e094a802973967");
        pSDEFGroupDetailModel.setName("PSSYSUNITID");
        iPSDEFieldModel = this.getDEField("PSSYSUNITID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u6307\u5b9a\u7684\u5355\u4f4d\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u6240\u5c5e\u5c5e\u6027\u5b9a\u4e49\u7684\u5355\u4f4d\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("85838a316f3bf526fcb99a14eae6a0a5");
        pSDEFGroupDetailModel.setName("PSSYSUNITNAME");
        iPSDEFieldModel = this.getDEField("PSSYSUNITNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u6307\u5b9a\u7684\u5355\u4f4d\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u6240\u5c5e\u5c5e\u6027\u5b9a\u4e49\u7684\u5355\u4f4d\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ad7866992e032b9e994c42167f5fe1c1");
        pSDEFGroupDetailModel.setName("PSSYSTEMID");
        iPSDEFieldModel = this.getDEField("PSSYSTEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4ec479cc88eb6869603da8928c7a7a0f");
        pSDEFGroupDetailModel.setName("PICKUPTEXTOPTS");
        iPSDEFieldModel = this.getDEField("PICKUPTEXTOPTS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldUIPickupTextOptsCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u5916\u952e\u6587\u672c\u7f16\u8f91\u9879\u7684\u8bbe\u5b9a\uff0c\u9ed8\u8ba4\u60c5\u51b5\u4e0b\u5916\u952e\u6587\u672c\u7f16\u8f91\u9879\u4f1a\u4f7f\u7528\u5f15\u7528\u5173\u7cfb\u4e2d\u5b9a\u4e49\u7684\u914d\u7f6e\u4fe1\u606f\uff0c\u5916\u952e\u6587\u672c\u5c5e\u6027\u8bbe\u5b9a\u652f\u6301\u5b9a\u4e49\u4f7f\u7528\u5f15\u7528\u5173\u7cfb\u914d\u7f6e\u7684\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("551a3e26cf59a722fea325cd80aaafcc");
        pSDEFGroupDetailModel.setName("PLACEHOLDER");
        iPSDEFieldModel = this.getDEField("PLACEHOLDER", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5360\u4f4d\u63d0\u793a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("dda86e9dfb97827197eb74181f62da63");
        pSDEFGroupDetailModel.setName("PREVENTXSS");
        iPSDEFieldModel = this.getDEField("PREVENTXSS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6e97272da6e44ffd37b0556c216d3670");
        pSDEFGroupDetailModel.setName("REFADPSDELOGICID");
        iPSDEFieldModel = this.getDEField("REFADPSDELOGICID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u96c6\u4e0a\u4e0b\u6587\u8f6c\u6362\u903b\u8f91\u5bf9\u8c61\uff0c\u5c06\u8c03\u7528\u73af\u5883\u53c2\u6570\u8f6c\u6362\u4e3a\u6570\u636e\u96c6\u7684\u8c03\u7528\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("11e740617f4ee81824c523a3c826c7bc");
        pSDEFGroupDetailModel.setName("REFADPSDELOGICNAME");
        iPSDEFieldModel = this.getDEField("REFADPSDELOGICNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u96c6\u4e0a\u4e0b\u6587\u8f6c\u6362\u903b\u8f91\u5bf9\u8c61\uff0c\u5c06\u8c03\u7528\u73af\u5883\u53c2\u6570\u8f6c\u6362\u4e3a\u6570\u636e\u96c6\u7684\u8c03\u7528\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f38549a5a876213c318024123df76d7d");
        pSDEFGroupDetailModel.setName("REFLINKPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("REFLINKPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u94fe\u63a5\u89c6\u56fe");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4d90a557f664b0411d55739258484f6d");
        pSDEFGroupDetailModel.setName("REFLINKPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("REFLINKPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u94fe\u63a5\u89c6\u56fe");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bdb93432c8b7392d411cef146fcadfa1");
        pSDEFGroupDetailModel.setName("REFMPICKUPPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("REFMPICKUPPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u7684\u591a\u9879\u9009\u62e9\u89c6\u56fe");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1c2e77886439bd490175c9f782526464");
        pSDEFGroupDetailModel.setName("REFMPICKUPPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("REFMPICKUPPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u7684\u591a\u9879\u9009\u62e9\u89c6\u56fe");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("69b3ca462ef56fe6095c41759f768daa");
        pSDEFGroupDetailModel.setName("REFPSDEACMODEID");
        iPSDEFieldModel = this.getDEField("REFPSDEACMODEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u81ea\u586b\u6a21\u5f0f\uff0c\u63d0\u4f9b\u81ea\u52a8\u586b\u5145\u80fd\u529b\u7684\u7f16\u8f91\u5668\u90fd\u9700\u8981\u6307\u5b9a\u5f15\u7528\u7684\u81ea\u586b\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2e4efe629eb0193257a419aebc258d5f");
        pSDEFGroupDetailModel.setName("REFPSDEACMODENAME");
        iPSDEFieldModel = this.getDEField("REFPSDEACMODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u81ea\u586b\u6a21\u5f0f\uff0c\u63d0\u4f9b\u81ea\u52a8\u586b\u5145\u80fd\u529b\u7684\u7f16\u8f91\u5668\u90fd\u9700\u8981\u6307\u5b9a\u5f15\u7528\u7684\u81ea\u586b\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ff895a462a12e02b2432f8d5075e2077");
        pSDEFGroupDetailModel.setName("REFPSDEDATASETID");
        iPSDEFieldModel = this.getDEField("REFPSDEDATASETID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u96c6\uff0c\u63d0\u4f9b\u81ea\u52a8\u586b\u5145\u80fd\u529b\u7684\u7f16\u8f91\u5668\u90fd\u9700\u8981\u6307\u5b9a\u5f15\u7528\u7684\u6570\u636e\u96c6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c37f4ad01b30f93f4af947d99b0014ad");
        pSDEFGroupDetailModel.setName("REFPSDEDATASETNAME");
        iPSDEFieldModel = this.getDEField("REFPSDEDATASETNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u96c6\uff0c\u63d0\u4f9b\u81ea\u52a8\u586b\u5145\u80fd\u529b\u7684\u7f16\u8f91\u5668\u90fd\u9700\u8981\u6307\u5b9a\u5f15\u7528\u7684\u6570\u636e\u96c6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("168401198fe2287b50a935c356b4c2da");
        pSDEFGroupDetailModel.setName("REFPSDEID");
        iPSDEFieldModel = this.getDEField("REFPSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u96c6\u7684\u6240\u5728\u5b9e\u4f53");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bae83d82a5394c13ad0b5b4183b597d8");
        pSDEFGroupDetailModel.setName("REFPSDENAME");
        iPSDEFieldModel = this.getDEField("REFPSDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u96c6\u7684\u6240\u5728\u5b9e\u4f53");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("988478076b48172a917ceb8d0e2b1d3f");
        pSDEFGroupDetailModel.setName("REFPSDERID");
        iPSDEFieldModel = this.getDEField("REFPSDERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u96c6\u7684\u4f7f\u7528\u5173\u7cfb");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7fba748c9732fbc036200dd576685117");
        pSDEFGroupDetailModel.setName("REFPSDERNAME");
        iPSDEFieldModel = this.getDEField("REFPSDERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u96c6\u7684\u4f7f\u7528\u5173\u7cfb");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2987f2df2534c196e28beb8d4dc12f54");
        pSDEFGroupDetailModel.setName("REFPICKUPPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("REFPICKUPPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u7684\u5355\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("39b0bb777bfb669394162bb01969408e");
        pSDEFGroupDetailModel.setName("REFPICKUPPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("REFPICKUPPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u9879\u7684\u5f15\u7528\u6570\u636e\u7684\u5355\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("33001cbc0b0c3f55b70a9268e6924382");
        pSDEFGroupDetailModel.setName("REFTEMPDATA");
        iPSDEFieldModel = this.getDEField("REFTEMPDATA", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u96c6\u662f\u5426\u4e3a\u4e34\u65f6\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0a03692ca9d46ff14568b06e5b518ad0");
        pSDEFGroupDetailModel.setName("RESETITEMNAME");
        iPSDEFieldModel = this.getDEField("RESETITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u91cd\u7f6e\u9879\u540d\u79f0\uff0c\u9700\u914d\u7f6e\u542f\u7528\u91cd\u7f6e\u9879\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ebffc1fcfbe34eee888c384bd7bfb85c");
        pSDEFGroupDetailModel.setName("UPDATEDV");
        iPSDEFieldModel = this.getDEField("UPDATEDV", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u66f4\u65b0\u9ed8\u8ba4\u503c\uff0c\u672a\u6307\u5b9a\u9ed8\u8ba4\u503c\u7c7b\u578b\u65f6\u6309\u76f4\u63a5\u503c\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("203f525215b50afbfaaedc5cb37d492d");
        pSDEFGroupDetailModel.setName("UPDATEDVT");
        iPSDEFieldModel = this.getDEField("UPDATEDVT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldDefaultValueType2CodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u66f4\u65b0\u9ed8\u8ba4\u503c\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u76f4\u63a5\u503c\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d503119c82ae5d903e813546dfbe99b6");
        pSDEFGroupDetailModel.setName("USERCAT");
        iPSDEFieldModel = this.getDEField("USERCAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelUserCatCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("98dbdc86b8170aeb5954a7fbde07f638");
        pSDEFGroupDetailModel.setName("USERTAG");
        iPSDEFieldModel = this.getDEField("USERTAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a79c57ff29de479c66ba9e54cdff25d7");
        pSDEFGroupDetailModel.setName("USERTAG2");
        iPSDEFieldModel = this.getDEField("USERTAG2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0bd91940e8eef3e23b246ddda4b8c8db");
        pSDEFGroupDetailModel.setName("USERTAG3");
        iPSDEFieldModel = this.getDEField("USERTAG3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4793e23743f255ed91694ddde8a0d3a7");
        pSDEFGroupDetailModel.setName("USERTAG4");
        iPSDEFieldModel = this.getDEField("USERTAG4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1f99e27d665f7420a2544a9c2843d092");
        pSDEFGroupDetailModel.setName("VALUEFORMAT");
        iPSDEFieldModel = this.getDEField("VALUEFORMAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u503c\u683c\u5f0f\u5316\u4e32\uff0c\u8f6c\u5316\u539f\u59cb\u503c\u5230\u754c\u9762\u5c55\u793a\u5185\u5bb9\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5c5e\u6027\u7684\u683c\u5f0f\u5316\u4e32\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("092479872e5e275dfe05ba4cb91ac560");
        pSDEFGroupDetailModel.setName("VALUEITEMNAME");
        iPSDEFieldModel = this.getDEField("VALUEITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u503c\u9879\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("70fcde6ca2943e01a806660bb7cc263a");
        pSDEFGroupDetailModel.setName("WIDTH");
        iPSDEFieldModel = this.getDEField("WIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5c5e\u6027\u8868\u5355\u9879\u7f16\u8f91\u5668\u7684\u9ed8\u8ba4\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u7f16\u8f91\u5668\u9ed8\u8ba4\u5bbd\u5ea6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

