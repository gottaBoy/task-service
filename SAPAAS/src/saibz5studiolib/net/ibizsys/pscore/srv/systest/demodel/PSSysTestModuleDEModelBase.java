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
package net.ibizsys.pscore.srv.systest.demodel;

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
import net.ibizsys.pscore.srv.systest.demodel.pssystestmodule.ac.PSSysTestModuleDefaultACModel;
import net.ibizsys.pscore.srv.systest.demodel.pssystestmodule.dataquery.PSSysTestModuleCurAppDQModel;
import net.ibizsys.pscore.srv.systest.demodel.pssystestmodule.dataquery.PSSysTestModuleCurPrjDQModel;
import net.ibizsys.pscore.srv.systest.demodel.pssystestmodule.dataquery.PSSysTestModuleCurSysAPIDQModel;
import net.ibizsys.pscore.srv.systest.demodel.pssystestmodule.dataquery.PSSysTestModuleCurSysDQModel;
import net.ibizsys.pscore.srv.systest.demodel.pssystestmodule.dataquery.PSSysTestModuleDefaultDQModel;
import net.ibizsys.pscore.srv.systest.demodel.pssystestmodule.dataset.PSSysTestModuleCurAppDSModel;
import net.ibizsys.pscore.srv.systest.demodel.pssystestmodule.dataset.PSSysTestModuleCurPrjDSModel;
import net.ibizsys.pscore.srv.systest.demodel.pssystestmodule.dataset.PSSysTestModuleCurSysAPIDSModel;
import net.ibizsys.pscore.srv.systest.demodel.pssystestmodule.dataset.PSSysTestModuleCurSysDSModel;
import net.ibizsys.pscore.srv.systest.demodel.pssystestmodule.dataset.PSSysTestModuleDefaultDSModel;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestModule;
import net.ibizsys.pscore.srv.systest.service.PSSysTestModuleService;

public abstract class PSSysTestModuleDEModelBase
extends PSDataEntityModelBase<PSSysTestModule> {
    private PSCoreSysModel pSCoreSysModel;
    private PSSysTestModuleService pSSysTestModuleService;

    public PSSysTestModuleDEModelBase() throws Exception {
        this.setId("74ed6946631db9730f7c7964b24e5a7d");
        this.setName("PSSYSTESTMODULE");
        this.setCodeName("PSSysTestModule");
        this.setTableName("T_SRFPSSYSTESTMODULE");
        this.setViewName("v_PSSYSTESTMODULE");
        this.setLogicName("\u6d4b\u8bd5\u6a21\u5757");
        this.setMemo("\u6d4b\u8bd5\u6a21\u5757\u6a21\u578b\uff0c\u5b9a\u4e49\u9879\u76ee\u6d4b\u8bd5\u4e2d\u7684\u6a21\u5757");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setUserTag("MODELV2");
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.systest.demodel.PSSysTestModuleDEModel", (IDataEntityModel)this);
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

    public PSSysTestModuleService getRealService() {
        if (this.pSSysTestModuleService == null) {
            try {
                this.pSSysTestModuleService = (PSSysTestModuleService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysTestModuleService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.systest.service.PSSysTestModuleService";
    }

    public PSSysTestModule createEntity() {
        return new PSSysTestModule();
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
            pSDEFieldModel.setId("f6857308e8ff502060e66a00f26ccc64");
            pSDEFieldModel.setName("CODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CodeName");
            pSDEFieldModel.setUserTag("MODELV2TAG");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u8981\u5728\u6240\u5728\u7684\u6d4b\u8bd5\u9879\u76ee\u4e2d\u5177\u6709\u552f\u4e00\u6027");
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
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d133dd0bd290357293285872fcbcb0bc");
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
            pSDEFieldModel.setId("2bcd4f22c353f79f83c780b6124f35e9");
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
        object = this.createDEField("DATA");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("21e69b24649465406daae7bff6388e81");
            pSDEFieldModel.setName("DATA");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6570\u636e");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Data");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0af5783f3f2f41e96c455a63638a6766");
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
        object = this.createDEField("MODULETAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b0be29f1a53c119e6a95b6106dfd0c53");
            pSDEFieldModel.setName("MODULETAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u5757\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ModuleTag");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u7684\u6807\u8bb0");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MODULETAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7b6c0dc6561fe167491ce74710b99a7e");
            pSDEFieldModel.setName("MODULETAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u5757\u6807\u8bb02");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ModuleTag2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u7684\u6807\u8bb02");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MODULETYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1b927431fb7234f0e63e742ef98c42e2");
            pSDEFieldModel.setName("MODULETYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u5757\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TestModuleTypeCodeListModel");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("ModuleType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u7684\u7c7b\u578b");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MODULETYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MODULETYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ORDERVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5f638b81942c74f9b7c6b479fc98a794");
            pSDEFieldModel.setName("ORDERVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6392\u5e8f\u503c");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("OrderValue");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u7684\u663e\u793a\u6b21\u5e8f");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PPSSYSTESTMODULEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9d02c64df2d47466ad99e1bae2014a85");
            pSDEFieldModel.setName("PPSSYSTESTMODULEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7236\u6d4b\u8bd5\u6a21\u5757");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSTESTMODULE_PSSYSTESTMODULE_PPSSYSTESTMODULEID");
            pSDEFieldModel.setLinkDEFName("PSSYSTESTMODULEID");
            pSDEFieldModel.setCodeName("PPSSysTestModuleId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PPSSYSTESTMODULENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a5151de5fad35f65b6d0476c28a1beec");
            pSDEFieldModel.setName("PPSSYSTESTMODULENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7236\u6d4b\u8bd5\u6a21\u5757");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSTESTMODULE_PSSYSTESTMODULE_PPSSYSTESTMODULEID");
            pSDEFieldModel.setLinkDEFName("PSSYSTESTMODULENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PPSSysTestModuleName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSAPPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("dfa6a5e313f67b23576f57ccf65a3844");
            pSDEFieldModel.setName("PSSYSAPPID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6807\u8bc6");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSTESTMODULE_PSSYSTESTPRJ_PSSYSTESTPRJID");
            pSDEFieldModel.setLinkDEFName("PSSYSAPPID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysAppId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSSERVICEAPIID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("dd59c2725c14b5ea42931ffe2ff42be5");
            pSDEFieldModel.setName("PSSYSSERVICEAPIID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u6807\u8bc6");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSTESTMODULE_PSSYSTESTPRJ_PSSYSTESTPRJID");
            pSDEFieldModel.setLinkDEFName("PSSYSSERVICEAPIID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysServiceAPIId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTESTDATAID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("61f189c3e1d43c83cce35c14b5deb246");
            pSDEFieldModel.setName("PSSYSTESTDATAID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6d4b\u8bd5\u6570\u636e");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSTESTMODULE_PSSYSTESTDATA_PSSYSTESTDATAID");
            pSDEFieldModel.setLinkDEFName("PSSYSTESTDATAID");
            pSDEFieldModel.setCodeName("PSSysTestDataId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTESTDATANAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("02010cca0533ea4cf8426a3e8cb9aa05");
            pSDEFieldModel.setName("PSSYSTESTDATANAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6d4b\u8bd5\u6570\u636e");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSTESTMODULE_PSSYSTESTDATA_PSSYSTESTDATAID");
            pSDEFieldModel.setLinkDEFName("PSSYSTESTDATANAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysTestDataName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTESTMODULEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0b991172483d28add017e6e37cf1f3e8");
            pSDEFieldModel.setName("PSSYSTESTMODULEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6d4b\u8bd5\u6a21\u5757\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSSysTestModuleId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTESTMODULENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2fe7afabff12c5097da8b4af7b48b6b8");
            pSDEFieldModel.setName("PSSYSTESTMODULENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6d4b\u8bd5\u6a21\u5757\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSSysTestModuleName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u7684\u540d\u79f0");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTESTMODULENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTESTMODULENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTESTMODULENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTESTMODULENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTESTPRJID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("18679a1a7452f753ff57c065dcc46acb");
            pSDEFieldModel.setName("PSSYSTESTPRJID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6d4b\u8bd5\u9879\u76ee");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSTESTMODULE_PSSYSTESTPRJ_PSSYSTESTPRJID");
            pSDEFieldModel.setLinkDEFName("PSSYSTESTPRJID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSSysTestPrjId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTESTPRJID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTESTPRJID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTESTPRJNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("da6ba927c9c9a1a830950a214ad82ce5");
            pSDEFieldModel.setName("PSSYSTESTPRJNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6d4b\u8bd5\u9879\u76ee");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSTESTMODULE_PSSYSTESTPRJ_PSSYSTESTPRJID");
            pSDEFieldModel.setLinkDEFName("PSSYSTESTPRJNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSSysTestPrjName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u6240\u5c5e\u7684\u6d4b\u8bd5\u9879\u76ee");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTESTPRJNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTESTPRJNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTESTPRJNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTESTPRJNAME_LIKE");
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
            pSDEFieldModel.setId("b9b690971bac5f330b60772ae3a141ce");
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
            pSDEFieldModel.setId("160a132c013979377068fe329e326131");
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
            pSDEFieldModel.setId("ed9f46b40ad3463ff01fba107c7dbb5e");
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
            pSDEFieldModel.setId("f1bdd41cd3bec4d0c85fc0d4daf0ff59");
            pSDEFieldModel.setName("USERPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u81ea\u5b9a\u4e49\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserParams");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("04331a46531b41492cc4b50030bc7e9a");
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
            pSDEFieldModel.setId("a9bae1d172ea9e3c336d7f1b0dbe7fb1");
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
            pSDEFieldModel.setId("57b4c38e4a5c34683906a2ab6d4f5d82");
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
            pSDEFieldModel.setId("8877abce18e5598042d1a5dc4c64c1ba");
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
        object = this.createDEField("UTILPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8888da54fd0add1af44b00d9b2df0911");
            pSDEFieldModel.setName("UTILPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u529f\u80fd\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UtilParams");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UTILTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("09a04c53ed12d0909b17c651d2c5280b");
            pSDEFieldModel.setName("UTILTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u529f\u80fd\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UtilTag");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSSysTestModuleDefaultACModel pSSysTestModuleDefaultACModel = new PSSysTestModuleDefaultACModel();
        pSSysTestModuleDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSSysTestModuleDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSSysTestModuleCurAppDSModel pSSysTestModuleCurAppDSModel = new PSSysTestModuleCurAppDSModel();
        pSSysTestModuleCurAppDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysTestModuleCurAppDSModel);
        PSSysTestModuleCurPrjDSModel pSSysTestModuleCurPrjDSModel = new PSSysTestModuleCurPrjDSModel();
        pSSysTestModuleCurPrjDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysTestModuleCurPrjDSModel);
        PSSysTestModuleCurSysDSModel pSSysTestModuleCurSysDSModel = new PSSysTestModuleCurSysDSModel();
        pSSysTestModuleCurSysDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysTestModuleCurSysDSModel);
        PSSysTestModuleCurSysAPIDSModel pSSysTestModuleCurSysAPIDSModel = new PSSysTestModuleCurSysAPIDSModel();
        pSSysTestModuleCurSysAPIDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysTestModuleCurSysAPIDSModel);
        PSSysTestModuleDefaultDSModel pSSysTestModuleDefaultDSModel = new PSSysTestModuleDefaultDSModel();
        pSSysTestModuleDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysTestModuleDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSSysTestModuleCurAppDQModel pSSysTestModuleCurAppDQModel = new PSSysTestModuleCurAppDQModel();
        pSSysTestModuleCurAppDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysTestModuleCurAppDQModel);
        PSSysTestModuleCurPrjDQModel pSSysTestModuleCurPrjDQModel = new PSSysTestModuleCurPrjDQModel();
        pSSysTestModuleCurPrjDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysTestModuleCurPrjDQModel);
        PSSysTestModuleCurSysDQModel pSSysTestModuleCurSysDQModel = new PSSysTestModuleCurSysDQModel();
        pSSysTestModuleCurSysDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysTestModuleCurSysDQModel);
        PSSysTestModuleCurSysAPIDQModel pSSysTestModuleCurSysAPIDQModel = new PSSysTestModuleCurSysAPIDQModel();
        pSSysTestModuleCurSysAPIDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysTestModuleCurSysAPIDQModel);
        PSSysTestModuleDefaultDQModel pSSysTestModuleDefaultDQModel = new PSSysTestModuleDefaultDQModel();
        pSSysTestModuleDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysTestModuleDefaultDQModel);
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
        this.registerPDTDEView("EDITVIEW", "fcac92e148b60f3dd4fe155111c70f1c");
        this.registerPDTDEView("MDATAVIEW", "6747ba9a811d3c5173253b03ab9cebb2");
        this.registerPDTDEView("MPICKUPVIEW", "0bd279b171abfe731ad1903603a17fd8");
        this.registerPDTDEView("PICKUPVIEW", "76a7bafe9f42de04e2c20d3ab74e20a6");
        this.registerPDTDEView("REDIRECTVIEW", "be612957ca82ca31f609db1d5682f953");
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
        dEDataSetCond2.setDEFName("PSSYSTESTMODULENAME");
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
        pSDEFGroupDetailModel.setId("f6857308e8ff502060e66a00f26ccc64");
        pSDEFGroupDetailModel.setName("CODENAME");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u8981\u5728\u6240\u5728\u7684\u6d4b\u8bd5\u9879\u76ee\u4e2d\u5177\u6709\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0af5783f3f2f41e96c455a63638a6766");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b0be29f1a53c119e6a95b6106dfd0c53");
        pSDEFGroupDetailModel.setName("MODULETAG");
        iPSDEFieldModel = this.getDEField("MODULETAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u7684\u6807\u8bb0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7b6c0dc6561fe167491ce74710b99a7e");
        pSDEFGroupDetailModel.setName("MODULETAG2");
        iPSDEFieldModel = this.getDEField("MODULETAG2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u7684\u6807\u8bb02");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1b927431fb7234f0e63e742ef98c42e2");
        pSDEFGroupDetailModel.setName("MODULETYPE");
        iPSDEFieldModel = this.getDEField("MODULETYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TestModuleTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u7684\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5f638b81942c74f9b7c6b479fc98a794");
        pSDEFGroupDetailModel.setName("ORDERVALUE");
        iPSDEFieldModel = this.getDEField("ORDERVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u7684\u663e\u793a\u6b21\u5e8f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("dfa6a5e313f67b23576f57ccf65a3844");
        pSDEFGroupDetailModel.setName("PSSYSAPPID");
        iPSDEFieldModel = this.getDEField("PSSYSAPPID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("dd59c2725c14b5ea42931ffe2ff42be5");
        pSDEFGroupDetailModel.setName("PSSYSSERVICEAPIID");
        iPSDEFieldModel = this.getDEField("PSSYSSERVICEAPIID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2fe7afabff12c5097da8b4af7b48b6b8");
        pSDEFGroupDetailModel.setName("PSSYSTESTMODULENAME");
        iPSDEFieldModel = this.getDEField("PSSYSTESTMODULENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u7684\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("18679a1a7452f753ff57c065dcc46acb");
        pSDEFGroupDetailModel.setName("PSSYSTESTPRJID");
        iPSDEFieldModel = this.getDEField("PSSYSTESTPRJID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u6240\u5c5e\u7684\u6d4b\u8bd5\u9879\u76ee");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("da6ba927c9c9a1a830950a214ad82ce5");
        pSDEFGroupDetailModel.setName("PSSYSTESTPRJNAME");
        iPSDEFieldModel = this.getDEField("PSSYSTESTPRJNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6d4b\u8bd5\u9879\u76ee\u6a21\u5757\u6240\u5c5e\u7684\u6d4b\u8bd5\u9879\u76ee");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed9f46b40ad3463ff01fba107c7dbb5e");
        pSDEFGroupDetailModel.setName("USERCAT");
        iPSDEFieldModel = this.getDEField("USERCAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelUserCatCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("04331a46531b41492cc4b50030bc7e9a");
        pSDEFGroupDetailModel.setName("USERTAG");
        iPSDEFieldModel = this.getDEField("USERTAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a9bae1d172ea9e3c336d7f1b0dbe7fb1");
        pSDEFGroupDetailModel.setName("USERTAG2");
        iPSDEFieldModel = this.getDEField("USERTAG2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("57b4c38e4a5c34683906a2ab6d4f5d82");
        pSDEFGroupDetailModel.setName("USERTAG3");
        iPSDEFieldModel = this.getDEField("USERTAG3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8877abce18e5598042d1a5dc4c64c1ba");
        pSDEFGroupDetailModel.setName("USERTAG4");
        iPSDEFieldModel = this.getDEField("USERTAG4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

