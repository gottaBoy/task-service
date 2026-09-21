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
package net.ibizsys.pscore.srv.config.demodel;

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
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.ac.PSVarSampleValueDefaultACModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.ac.PSVarSampleValueValueACModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.ac.PSVarSampleValueValueWithLogicNameACModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataquery.PSVarSampleValueDataViewItemDQModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataquery.PSVarSampleValueDefaultDQModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataquery.PSVarSampleValueFontFamilyDQModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataquery.PSVarSampleValueFontSizeDQModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataquery.PSVarSampleValueFormItemDQModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataquery.PSVarSampleValueFormVarDQModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataquery.PSVarSampleValueGridItemDQModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataquery.PSVarSampleValueLayoutTableDQModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataquery.PSVarSampleValueSysVarDQModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataquery.PSVarSampleValueViewFieldDQModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataset.PSVarSampleValueDataViewItemDSModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataset.PSVarSampleValueDefaultDSModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataset.PSVarSampleValueFontFamilyDSModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataset.PSVarSampleValueFontSizeDSModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataset.PSVarSampleValueFormItemDSModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataset.PSVarSampleValueFormVarDSModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataset.PSVarSampleValueGridItemDSModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataset.PSVarSampleValueLayoutTableDSModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataset.PSVarSampleValueSysVarDSModel;
import net.ibizsys.pscore.srv.config.demodel.psvarsamplevalue.dataset.PSVarSampleValueViewFieldDSModel;
import net.ibizsys.pscore.srv.config.entity.PSVarSampleValue;
import net.ibizsys.pscore.srv.config.service.PSVarSampleValueService;
import net.ibizsys.pscore.srv.core.IPSDEFGroupModel;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupDetailModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupModel;
import net.ibizsys.pscore.srv.core.PSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDataEntityModelBase;

public abstract class PSVarSampleValueDEModelBase
extends PSDataEntityModelBase<PSVarSampleValue> {
    private PSCoreSysModel pSCoreSysModel;
    private PSVarSampleValueService pSVarSampleValueService;

    public PSVarSampleValueDEModelBase() throws Exception {
        this.setId("e657526c38986dd269be6eb65630a410");
        this.setName("PSVARSAMPLEVALUE");
        this.setCodeName("PSVarSampleValue");
        this.setTableName("T_SRFPSVARSAMPLEVALUE");
        this.setViewName("v_PSVARSAMPLEVALUE");
        this.setLogicName("\u4e91\u5e73\u53f0\u53d8\u91cf\u793a\u4f8b\u503c");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSVarSampleValueDEModel", (IDataEntityModel)this);
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

    public PSVarSampleValueService getRealService() {
        if (this.pSVarSampleValueService == null) {
            try {
                this.pSVarSampleValueService = (PSVarSampleValueService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSVarSampleValueService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.config.service.PSVarSampleValueService";
    }

    public PSVarSampleValue createEntity() {
        return new PSVarSampleValue();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("ALLDCFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1c74088bde692247113f7234195a0085");
            pSDEFieldModel.setName("ALLDCFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5168\u90e8\u5e94\u7528\u4e2d\u5fc3\u6807\u5fd7");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("AllDCFlag");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6fa1c1d442cf691cf14153a95102cda3");
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
            pSDEFieldModel.setId("5a0e62f65df304602a8963cf8efa8843");
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
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8d0bd35c461c6a3162e50d83fcc6d309");
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
        object = this.createDEField("ORDERVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d8abdfffa4afb775ff48bf538e03e938");
            pSDEFieldModel.setName("ORDERVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u663e\u793a\u6b21\u5e8f");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("OrderValue");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVCENTERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("59b33c29cc763ccb878e6baebdd12988");
            pSDEFieldModel.setName("PSDEVCENTERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u4e2d\u5fc3");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSVARSAMPLEVALUE_PSDEVCENTER_PSDEVCENTERID");
            pSDEFieldModel.setLinkDEFName("PSDEVCENTERID");
            pSDEFieldModel.setCodeName("PSDevCenterId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVCENTERID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVCENTERID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVCENTERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("804bc020f2e13b02e5cc62d4ccde8024");
            pSDEFieldModel.setName("PSDEVCENTERNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u4e2d\u5fc3");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSVARSAMPLEVALUE_PSDEVCENTER_PSDEVCENTERID");
            pSDEFieldModel.setLinkDEFName("PSDEVCENTERNAME");
            pSDEFieldModel.setCodeName("PSDevCenterName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVCENTERNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVCENTERNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVCENTERNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVCENTERNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSVARSAMPLEVALUEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8ea6c41ee0a5b92c2a0cff9e68435a97");
            pSDEFieldModel.setName("PSVARSAMPLEVALUEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e91\u5e73\u53f0\u53d8\u91cf\u793a\u4f8b\u503c\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSVarSampleValueId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSVARSAMPLEVALUENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fcc692245df0a26eff5fecbb75740cda");
            pSDEFieldModel.setName("PSVARSAMPLEVALUENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSVarSampleValueName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSVARSAMPLEVALUENAME_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSVARSAMPLEVALUENAME_LIKE");
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
            pSDEFieldModel.setId("f222207a9717442a090999e810be1f47");
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
            pSDEFieldModel.setId("d1f2af34798b243b014dc2988b9a784e");
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
            pSDEFieldModel.setId("5bf853fb520f0ff3af20fb875e8250f5");
            pSDEFieldModel.setName("USERTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4087c6b04b5f1dd6abc4b4dbc0d48f94");
            pSDEFieldModel.setName("USERTAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb02");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VALIDFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("63c0f5e80dd4146365c30a5e6b7d56d3");
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
        object = this.createDEField("VALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("dc53ef0126316da74e846621237a962f");
            pSDEFieldModel.setName("VALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u53d8\u91cf\u503c");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Value");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VALUE2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4a76eaa5182d84ece146781bad00ba40");
            pSDEFieldModel.setName("VALUE2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u53d8\u91cf\u503c2");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Value2");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VARCAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("74a3d72508225bec037d54fc1d05aed8");
            pSDEFieldModel.setName("VARCAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u53d8\u91cf\u5f52\u7c7b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PSVarCatCodeListModel");
            pSDEFieldModel.setCodeName("VarCat");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_VARCAT_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_VARCAT_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VARTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d78ed074450c7eb138adfb5502d03642");
            pSDEFieldModel.setName("VARTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u53d8\u91cf\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PSVarTypeCodeListModel");
            pSDEFieldModel.setCodeName("VarType");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_VARTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_VARTYPE_EQ");
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
        PSVarSampleValueDefaultACModel pSVarSampleValueDefaultACModel = new PSVarSampleValueDefaultACModel();
        pSVarSampleValueDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSVarSampleValueDefaultACModel);
        PSVarSampleValueValueACModel pSVarSampleValueValueACModel = new PSVarSampleValueValueACModel();
        pSVarSampleValueValueACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSVarSampleValueValueACModel);
        PSVarSampleValueValueWithLogicNameACModel pSVarSampleValueValueWithLogicNameACModel = new PSVarSampleValueValueWithLogicNameACModel();
        pSVarSampleValueValueWithLogicNameACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSVarSampleValueValueWithLogicNameACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSVarSampleValueDataViewItemDSModel pSVarSampleValueDataViewItemDSModel = new PSVarSampleValueDataViewItemDSModel();
        pSVarSampleValueDataViewItemDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSVarSampleValueDataViewItemDSModel);
        PSVarSampleValueDefaultDSModel pSVarSampleValueDefaultDSModel = new PSVarSampleValueDefaultDSModel();
        pSVarSampleValueDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSVarSampleValueDefaultDSModel);
        PSVarSampleValueFontFamilyDSModel pSVarSampleValueFontFamilyDSModel = new PSVarSampleValueFontFamilyDSModel();
        pSVarSampleValueFontFamilyDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSVarSampleValueFontFamilyDSModel);
        PSVarSampleValueFontSizeDSModel pSVarSampleValueFontSizeDSModel = new PSVarSampleValueFontSizeDSModel();
        pSVarSampleValueFontSizeDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSVarSampleValueFontSizeDSModel);
        PSVarSampleValueFormItemDSModel pSVarSampleValueFormItemDSModel = new PSVarSampleValueFormItemDSModel();
        pSVarSampleValueFormItemDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSVarSampleValueFormItemDSModel);
        PSVarSampleValueFormVarDSModel pSVarSampleValueFormVarDSModel = new PSVarSampleValueFormVarDSModel();
        pSVarSampleValueFormVarDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSVarSampleValueFormVarDSModel);
        PSVarSampleValueGridItemDSModel pSVarSampleValueGridItemDSModel = new PSVarSampleValueGridItemDSModel();
        pSVarSampleValueGridItemDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSVarSampleValueGridItemDSModel);
        PSVarSampleValueLayoutTableDSModel pSVarSampleValueLayoutTableDSModel = new PSVarSampleValueLayoutTableDSModel();
        pSVarSampleValueLayoutTableDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSVarSampleValueLayoutTableDSModel);
        PSVarSampleValueSysVarDSModel pSVarSampleValueSysVarDSModel = new PSVarSampleValueSysVarDSModel();
        pSVarSampleValueSysVarDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSVarSampleValueSysVarDSModel);
        PSVarSampleValueViewFieldDSModel pSVarSampleValueViewFieldDSModel = new PSVarSampleValueViewFieldDSModel();
        pSVarSampleValueViewFieldDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSVarSampleValueViewFieldDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSVarSampleValueDataViewItemDQModel pSVarSampleValueDataViewItemDQModel = new PSVarSampleValueDataViewItemDQModel();
        pSVarSampleValueDataViewItemDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSVarSampleValueDataViewItemDQModel);
        PSVarSampleValueDefaultDQModel pSVarSampleValueDefaultDQModel = new PSVarSampleValueDefaultDQModel();
        pSVarSampleValueDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSVarSampleValueDefaultDQModel);
        PSVarSampleValueFontFamilyDQModel pSVarSampleValueFontFamilyDQModel = new PSVarSampleValueFontFamilyDQModel();
        pSVarSampleValueFontFamilyDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSVarSampleValueFontFamilyDQModel);
        PSVarSampleValueFontSizeDQModel pSVarSampleValueFontSizeDQModel = new PSVarSampleValueFontSizeDQModel();
        pSVarSampleValueFontSizeDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSVarSampleValueFontSizeDQModel);
        PSVarSampleValueFormItemDQModel pSVarSampleValueFormItemDQModel = new PSVarSampleValueFormItemDQModel();
        pSVarSampleValueFormItemDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSVarSampleValueFormItemDQModel);
        PSVarSampleValueFormVarDQModel pSVarSampleValueFormVarDQModel = new PSVarSampleValueFormVarDQModel();
        pSVarSampleValueFormVarDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSVarSampleValueFormVarDQModel);
        PSVarSampleValueGridItemDQModel pSVarSampleValueGridItemDQModel = new PSVarSampleValueGridItemDQModel();
        pSVarSampleValueGridItemDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSVarSampleValueGridItemDQModel);
        PSVarSampleValueLayoutTableDQModel pSVarSampleValueLayoutTableDQModel = new PSVarSampleValueLayoutTableDQModel();
        pSVarSampleValueLayoutTableDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSVarSampleValueLayoutTableDQModel);
        PSVarSampleValueSysVarDQModel pSVarSampleValueSysVarDQModel = new PSVarSampleValueSysVarDQModel();
        pSVarSampleValueSysVarDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSVarSampleValueSysVarDQModel);
        PSVarSampleValueViewFieldDQModel pSVarSampleValueViewFieldDQModel = new PSVarSampleValueViewFieldDQModel();
        pSVarSampleValueViewFieldDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSVarSampleValueViewFieldDQModel);
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
        this.registerPDTDEView("MDATAVIEW", "4b14255808ec7944baccb1152a105f4a");
        this.registerPDTDEView("MPICKUPVIEW", "e993c17b0b562d027fc297cc099b6bf7");
        this.registerPDTDEView("PICKUPVIEW", "98940fc7c37cfc99b9f469f299df46a4");
        this.registerPDTDEView("REDIRECTVIEW", "d1cf1a96de96278ec41f2a7c951a3709");
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
        dEDataSetCond2.setDEFName("PSVARSAMPLEVALUENAME");
        dEDataSetCond2.setCondValue(string);
        dEDataSetCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)dEDataSetCond2);
        dEDataSetCond2 = new DEDataSetCond();
        dEDataSetCond2.setCondType("DEFIELD");
        dEDataSetCond2.setCondOp("LIKE");
        dEDataSetCond2.setDEFName("VALUE");
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
        pSDEFGroupDetailModel.setId("fcc692245df0a26eff5fecbb75740cda");
        pSDEFGroupDetailModel.setName("PSVARSAMPLEVALUENAME");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSVARSAMPLEVALUENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

