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
 *  net.ibizsys.paas.core.IDEUIAction
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
import net.ibizsys.paas.core.IDEUIAction;
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
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysserviceapi.ac.PSSysServiceAPIDefaultACModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysserviceapi.dataquery.PSSysServiceAPICurSysDQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysserviceapi.dataquery.PSSysServiceAPIDefaultDQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysserviceapi.dataset.PSSysServiceAPICurSysDSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysserviceapi.dataset.PSSysServiceAPIDefaultDSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysserviceapi.uiaction.PSSysServiceAPIAddSyncClientModelTaskUIActionModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysserviceapi.uiaction.PSSysServiceAPICreateSubSysFileUIActionModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysserviceapi.uiaction.PSSysServiceAPIGenUniqueTagUIActionModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysserviceapi.uiaction.PSSysServiceAPIRebuildByAppDEUIActionModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.pssysserviceapi.uiaction.PSSysServiceAPIRebuildDESARSUIActionModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService;

public abstract class PSSysServiceAPIDEModelBase
extends PSDataEntityModelBase<PSSysServiceAPI> {
    private PSCoreSysModel pSCoreSysModel;
    private PSSysServiceAPIService pSSysServiceAPIService;

    public PSSysServiceAPIDEModelBase() throws Exception {
        this.setId("fb4a3aa813544c1c95349b27c6b2de71");
        this.setName("PSSYSSERVICEAPI");
        this.setCodeName("PSSysServiceAPI");
        this.setTableName("T_SRFPSSYSSERVICEAPI");
        this.setViewName("v_PSSYSSERVICEAPI");
        this.setLogicName("\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3");
        this.setMemo("\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u6a21\u578b\uff0c\u5b9a\u4e49\u7cfb\u7edf\u5bf9\u5916\u63d0\u4f9b\u7684\u670d\u52a1\u63a5\u53e3\uff0c\u5305\u62ec\u4e86\u63a5\u53e3\u7c7b\u578b\u3001\u6a21\u5f0f\u7b49\u4fe1\u606f\uff0c\u4e5f\u5305\u542b\u4e86\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u3001\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u5173\u7cfb\u7b49\u6210\u5458\u6a21\u578b");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setUserTag("MODELV2");
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysServiceAPIDEModel", (IDataEntityModel)this);
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

    public PSSysServiceAPIService getRealService() {
        if (this.pSSysServiceAPIService == null) {
            try {
                this.pSSysServiceAPIService = (PSSysServiceAPIService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysServiceAPIService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIService";
    }

    public PSSysServiceAPI createEntity() {
        return new PSSysServiceAPI();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("APILEVEL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7f112fddfadaeccf8a764e858fff5caf");
            pSDEFieldModel.setName("APILEVEL");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63a5\u53e3\u7ea7\u522b");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.APILevelCodeListModel");
            pSDEFieldModel.setCodeName("APILevel");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u7ea7\u522b\uff0c\u9ed8\u8ba4\u4e3a\u3010\u7528\u6237\u7ea7\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_APILEVEL_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_APILEVEL_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("APIMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8711fda2c3a8fdeea8f023abce76e38d");
            pSDEFieldModel.setName("APIMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63a5\u53e3\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ServiceAPIModeCodeListModel");
            pSDEFieldModel.setCodeName("APIMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u6a21\u5f0f\uff0c\u9ed8\u8ba4\u4e3a\u3010\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\uff08\u6307\u5b9a\u5b9e\u4f53\uff09\uff08\u9ed8\u8ba4\uff09\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_APIMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_APIMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("APITAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4cbf5a7a73fb6d321facbfb488a43acb");
            pSDEFieldModel.setName("APITAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63a5\u53e3\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("APITag");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u6807\u8bb0");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("APITAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d8954355657c733859798ade5fbd9b41");
            pSDEFieldModel.setName("APITAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63a5\u53e3\u6807\u8bb02");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("APITag2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u6807\u8bb02");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("APITYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("70b374c7ba02a8ad124b051fb7b36af1");
            pSDEFieldModel.setName("APITYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63a5\u53e3\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ServiceAPITypeCodeListModel");
            pSDEFieldModel.setCodeName("APIType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u7c7b\u578b\uff0c\u9ed8\u8ba4\u4e3a\u3010RESTful API\u3011");
            pSDEFieldModel.setLength(40);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_APITYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_APITYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("AUTHCHECKTOKENURI");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5b9f8933a624b715bd7fbcc61e090c6b");
            pSDEFieldModel.setName("AUTHCHECKTOKENURI");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8ba4\u8bc1token\u8def\u5f84");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("AuthCheckTokenUri");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u8def\u5f84\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("AUTHCLIENTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e5948d632f3306e4641a16e232b33453");
            pSDEFieldModel.setName("AUTHCLIENTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8ba4\u8bc1\u5ba2\u6237\u7aef\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("AuthClientId");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u5ba2\u6237\u7aef\u6807\u8bc6\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("AUTHCLIENTSECRET");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("937e2ea4501b1ec782efa80cb35f925b");
            pSDEFieldModel.setName("AUTHCLIENTSECRET");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8ba4\u8bc1\u5ba2\u6237\u7aef\u5bc6\u94a5");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("AuthClientSecret");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u5ba2\u6237\u7aef\u5bc6\u94a5\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
            pSDEFieldModel.setLength(1000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("AUTHMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("326db5e86d914c1f9f478d7dd00594eb");
            pSDEFieldModel.setName("AUTHMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8ba4\u8bc1\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.APIAuthModeCodeListModel");
            pSDEFieldModel.setCodeName("AuthMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u6a21\u5f0f\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("AUTHPARAM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6077dda338ce4b6f249ffd92b2bea92a");
            pSDEFieldModel.setName("AUTHPARAM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8ba4\u8bc1\u53c2\u6570");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("AuthParam");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u53c2\u6570\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("AUTHPARAM2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bbd4a48d5ec26d3c33f04ae9f4f33594");
            pSDEFieldModel.setName("AUTHPARAM2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8ba4\u8bc1\u53c2\u65702");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("AuthParam2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u53c2\u65702\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("AUTHPARAM3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7bb6b5cb1017b9ffb3710aebd6110b82");
            pSDEFieldModel.setName("AUTHPARAM3");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8ba4\u8bc1\u53c2\u65703");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("AuthParam3");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u53c2\u65703\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("AUTHPARAM4");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("340d00db19018f51147c12e6d6c38b21");
            pSDEFieldModel.setName("AUTHPARAM4");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8ba4\u8bc1\u53c2\u65704");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("AuthParam4");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u53c2\u65704\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("BASECLSPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("695427df4cb697b9b8dfea60404d35a4");
            pSDEFieldModel.setName("BASECLSPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u53d1\u5e03\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("BaseClsParams");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CFGPSMODELSTORAGEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("36adca72acf8e1c2b658a56289427b26");
            pSDEFieldModel.setName("CFGPSMODELSTORAGEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u914d\u7f6e\u6a21\u578b\u5b58\u50a8\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CfgPSModelStorageId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CFGTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e2fb29f87a9639bada3025cf8d9e2e3b");
            pSDEFieldModel.setName("CFGTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u914d\u7f6e\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CfgTag");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f2129b58869473bd9e1ec5b8abebf458");
            pSDEFieldModel.setName("CODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CodeName");
            pSDEFieldModel.setUserTag("MODELV2TAG");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u8981\u5728\u670d\u52a1\u63a5\u53e3\u6240\u5728\u7684\u6a21\u578b\u57df\uff08\u7cfb\u7edf\u6a21\u5757\u6216\u7cfb\u7edf\uff09\u4e2d\u5177\u6709\u552f\u4e00\u6027");
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
        object = this.createDEField("CODENAMEMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c59d5b9a6ebca3fb4d4741a1a757f97f");
            pSDEFieldModel.setName("CODENAMEMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63a5\u53e3\u4ee3\u7801\u6807\u8bc6\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.CodeNameModeCodeListModel");
            pSDEFieldModel.setCodeName("CodeNameMode");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("92ae35126ea0aecc3e2eff697fa1e7e2");
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
            pSDEFieldModel.setId("6ff33f1419e5709d7ac5d1136a722e7b");
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
            pSDEFieldModel.setId("76b695deeb86a2a67aca0628fb049909");
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
            pSDEFieldModel.setId("ffaf94fd45f222e2e5163d8422fbce12");
            pSDEFieldModel.setName("CUSTOMMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u811a\u672c\u4ee3\u7801\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ScriptMode2CodeListModel");
            pSDEFieldModel.setCodeName("CustomMode");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFAULTPORT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8bc92a91f0083e610c85989956c601a3");
            pSDEFieldModel.setName("DEFAULTPORT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u7aef\u53e3");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DefaultPort");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u670d\u52a1\u7aef\u53e3\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFAULTPSDEOPPRIVID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2dc0d192c1597130e08f608705516a25");
            pSDEFieldModel.setName("DEFAULTPSDEOPPRIVID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u8bbf\u95ee\u64cd\u4f5c\u6807\u8bc6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSDEOPPRIV_DEFAULTPSDEOPPRIVID");
            pSDEFieldModel.setLinkDEFName("PSDEOPPRIVID");
            pSDEFieldModel.setCodeName("DefaultPSDEOPPrivId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEFAULTPSDEOPPRIVID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEFAULTPSDEOPPRIVID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFAULTPSDEOPPRIVNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d23349dec6225e8b59b1eb998edfdaee");
            pSDEFieldModel.setName("DEFAULTPSDEOPPRIVNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u8bbf\u95ee\u64cd\u4f5c\u6807\u8bc6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSDEOPPRIV_DEFAULTPSDEOPPRIVID");
            pSDEFieldModel.setLinkDEFName("PSDEOPPRIVNAME");
            pSDEFieldModel.setCodeName("DefaultPSDEOPPrivName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEFAULTPSDEOPPRIVNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEFAULTPSDEOPPRIVNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEFAULTPSDEOPPRIVNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEFAULTPSDEOPPRIVNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFCREATEREQMETHOD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cf2fac4d3db76e98163dca7e84b3f5df");
            pSDEFieldModel.setName("DEFCREATEREQMETHOD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u5efa\u7acb\u884c\u4e3a\u8bf7\u6c42\u65b9\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
            pSDEFieldModel.setCodeName("DefCreateReqMethod");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEFCREATEREQMETHOD_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEFCREATEREQMETHOD_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFDEACTIONREQMETHOD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ffc030c6e27f2f21f5c550e0099c6552");
            pSDEFieldModel.setName("DEFDEACTIONREQMETHOD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u5b9e\u4f53\u884c\u4e3a\u8bf7\u6c42\u65b9\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
            pSDEFieldModel.setCodeName("DefDEActionReqMethod");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5230\u670d\u52a1\u63a5\u53e3\u4e2d\u5b9e\u4f53\u884c\u4e3a\u9ed8\u8ba4\u7684\u8bf7\u6c42\u65b9\u5f0f\uff0c\u4f9b\u672a\u5b9a\u4e49\u8bf7\u6c42\u65b9\u5f0f\u7684\u5b9e\u4f53\u884c\u4e3a\u4f7f\u7528");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEFDEACTIONREQMETHOD_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEFDEACTIONREQMETHOD_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFDEDATASETREQMETHOD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("640a8581e22e74bdd729c2a814bb8efb");
            pSDEFieldModel.setName("DEFDEDATASETREQMETHOD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u7ed3\u679c\u96c6\u8bf7\u6c42\u65b9\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
            pSDEFieldModel.setCodeName("DefDEDataSetReqMethod");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5230\u670d\u52a1\u63a5\u53e3\u4e2d\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u9ed8\u8ba4\u7684\u8bf7\u6c42\u65b9\u5f0f\uff0c\u4f9b\u672a\u5b9a\u4e49\u8bf7\u6c42\u65b9\u5f0f\u7684\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u4f7f\u7528");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEFDEDATASETREQMETHOD_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEFDEDATASETREQMETHOD_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFDELETEREQMETHOD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3edc342c4eb89aff51cb3d077416be17");
            pSDEFieldModel.setName("DEFDELETEREQMETHOD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u5220\u9664\u884c\u4e3a\u8bf7\u6c42\u65b9\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
            pSDEFieldModel.setCodeName("DefDeleteReqMethod");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEFDELETEREQMETHOD_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEFDELETEREQMETHOD_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFGETDRAFTREQMETHOD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("559eb54eab498301bd7d84c19a934fc9");
            pSDEFieldModel.setName("DEFGETDRAFTREQMETHOD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u83b7\u53d6\u8349\u7a3f\u884c\u4e3a\u8bf7\u6c42\u65b9\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
            pSDEFieldModel.setCodeName("DefGetDraftReqMethod");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEFGETDRAFTREQMETHOD_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEFGETDRAFTREQMETHOD_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFGETREQMETHOD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1457e67c4801aba6926a1a8c5e407f00");
            pSDEFieldModel.setName("DEFGETREQMETHOD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u83b7\u53d6\u884c\u4e3a\u8bf7\u6c42\u65b9\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
            pSDEFieldModel.setCodeName("DefGetReqMethod");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEFGETREQMETHOD_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEFGETREQMETHOD_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFNEEDRESOURCEKEY");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8fc30d515aa7fab33ca5ad5092d14508");
            pSDEFieldModel.setName("DEFNEEDRESOURCEKEY");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u72ec\u7acb\u8f93\u51fa\u8d44\u6e90\u952e\u503c");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("DefNeedResourceKey");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFSELECTREQMETHOD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6ac479c7e3acbb13d2f4d07326acfc8e");
            pSDEFieldModel.setName("DEFSELECTREQMETHOD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u67e5\u8be2\u8bf7\u6c42\u65b9\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
            pSDEFieldModel.setCodeName("DefSelectReqMethod");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5230\u670d\u52a1\u63a5\u53e3\u4e2d\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u9ed8\u8ba4\u7684\u8bf7\u6c42\u65b9\u5f0f\uff0c\u4f9b\u672a\u5b9a\u4e49\u8bf7\u6c42\u65b9\u5f0f\u7684\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u4f7f\u7528");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEFSELECTREQMETHOD_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEFSELECTREQMETHOD_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFUPDATEREQMETHOD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8b474dbd26288b68fde1696af4be7377");
            pSDEFieldModel.setName("DEFUPDATEREQMETHOD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u66f4\u65b0\u884c\u4e3a\u8bf7\u6c42\u65b9\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
            pSDEFieldModel.setCodeName("DefUpdateReqMethod");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEFUPDATEREQMETHOD_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEFUPDATEREQMETHOD_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEPSSYSSFPLUGINID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f664293942311ed95b1f78bc39100a82");
            pSDEFieldModel.setName("DEPSSYSSFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u540e\u53f0\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSSFPLUGIN_DEPSSYSSFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSSFPLUGINID");
            pSDEFieldModel.setCodeName("DEPSSysSFPluginId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEPSSYSSFPLUGINID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEPSSYSSFPLUGINID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEPSSYSSFPLUGINNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5c22df1b2ae49d171e23497978cd0b96");
            pSDEFieldModel.setName("DEPSSYSSFPLUGINNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u540e\u53f0\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSSFPLUGIN_DEPSSYSSFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSSFPLUGINNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("DEPSSysSFPluginName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u7684\u540e\u53f0\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u7528\u4e8e\u6269\u5c55\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u4ee3\u7801");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEPSSYSSFPLUGINNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEPSSYSSFPLUGINNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEPSSYSSFPLUGINNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEPSSYSSFPLUGINNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLEAPIMODELEX");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("28fd36c789e756ca8487c9bb8eb15a7d");
            pSDEFieldModel.setName("ENABLEAPIMODELEX");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u63a5\u53e3\u6a21\u578b\u6269\u5c55");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableAPIModelEx");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLEGATEWAY");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a712bdf3eba617e5ba9722b3795c10d6");
            pSDEFieldModel.setName("ENABLEGATEWAY");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u63a5\u53e3\u7f51\u5173");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableGateway");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("IGNOREAUTHPATTERNS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("82760b79d2454d9f568416b3a37d834b");
            pSDEFieldModel.setName("IGNOREAUTHPATTERNS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5ffd\u7565\u8ba4\u8bc1\u8def\u5f84\u96c6\u5408");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("IgnoreAuthPatterns");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LOCKFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d9a174ae329b1ab9bb880ad07e634df7");
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
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a1c22a749980ee309016007aec96542e");
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
        object = this.createDEField("NAMINGSERVICE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d631e04ac7db20c2489351add18d3554");
            pSDEFieldModel.setName("NAMINGSERVICE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u547d\u540d\u670d\u52a1");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("NamingService");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ORDERVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3f265d45cfe680464f3d71bf46748a1c");
            pSDEFieldModel.setName("ORDERVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6392\u5e8f\u503c");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("OrderValue");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTPSSYSTRANSLATORID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2a546aae38e86f054793f57dc9951bad");
            pSDEFieldModel.setName("OUTPSSYSTRANSLATORID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u8f6c\u6362\u5668");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSTRANSLATOR_OUTPSSYSTRANSLATORID");
            pSDEFieldModel.setLinkDEFName("PSSYSTRANSLATORID");
            pSDEFieldModel.setCodeName("OutPSSysTranslatorId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSSYSTRANSLATORID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSSYSTRANSLATORID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OUTPSSYSTRANSLATORNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("786cc569725be8406e7c2e81d70d3875");
            pSDEFieldModel.setName("OUTPSSYSTRANSLATORNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u51fa\u8f6c\u6362\u5668");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSTRANSLATOR_OUTPSSYSTRANSLATORID");
            pSDEFieldModel.setLinkDEFName("PSSYSTRANSLATORNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("OutPSSysTranslatorName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSSYSTRANSLATORNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSSYSTRANSLATORNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OUTPSSYSTRANSLATORNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OUTPSSYSTRANSLATORNAME_LIKE");
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
            pSDEFieldModel.setId("3d25a4e67ba1d9a468950ae0e6f843c3");
            pSDEFieldModel.setName("PREDEFINEDTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9884\u5b9a\u4e49\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PredefinedServiceAPICodeListModel");
            pSDEFieldModel.setCodeName("PredefinedType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u9884\u5b9a\u4e49\u7c7b\u578b");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PREDEFINEDTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PREDEFINEDTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNSYSAPIID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4c29ae0ac473b449211ee89cafa7aecf");
            pSDEFieldModel.setName("PSDEVSLNSYSAPIID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSDevSlnSysAPIId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSMODULEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("49d50d1184d2974c127a2ae738fcd261");
            pSDEFieldModel.setName("PSMODULEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u6a21\u5757");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSMODULE_PSMODULEID");
            pSDEFieldModel.setLinkDEFName("PSMODULEID");
            pSDEFieldModel.setCodeName("PSModuleId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSMODULEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSMODULEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSMODULENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6728c37913e3a7f794a9ace17da3c7b3");
            pSDEFieldModel.setName("PSMODULENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u6a21\u5757");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSMODULE_PSMODULEID");
            pSDEFieldModel.setLinkDEFName("PSMODULENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSModuleName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u6240\u5c5e\u6a21\u5757");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSMODULENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSMODULENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSMODULENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSMODULENAME_LIKE");
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
            pSDEFieldModel.setId("c050582619c8838163df5d70f226ee73");
            pSDEFieldModel.setName("PSSYSDYNAMODELID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6269\u5c55\u52a8\u6001\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSDYNAMODEL_PSSYSDYNAMODELID");
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
            pSDEFieldModel.setId("3df1087d0de489fb3b2938c6f967e30d");
            pSDEFieldModel.setName("PSSYSDYNAMODELNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6269\u5c55\u52a8\u6001\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSDYNAMODEL_PSSYSDYNAMODELID");
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
        object = this.createDEField("PSSYSREQITEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("257230fd908d17ce91e90df0607c0dfd");
            pSDEFieldModel.setName("PSSYSREQITEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8bbe\u8ba1\u9700\u6c42");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSREQITEM_PSSYSREQITEMID");
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
            pSDEFieldModel.setId("6b7d834221751852d35c8d1f2e800bd5");
            pSDEFieldModel.setName("PSSYSREQITEMNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8bbe\u8ba1\u9700\u6c42");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSREQITEM_PSSYSREQITEMID");
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
        object = this.createDEField("PSSYSRESOURCEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("06a31c76d4a5b90c41e9e7ddb3b94e91");
            pSDEFieldModel.setName("PSSYSRESOURCEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSRESOURCE_PSSYSRESOURCEID");
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
            pSDEFieldModel.setId("5948a19011aa43a2dc445eefef24485c");
            pSDEFieldModel.setName("PSSYSRESOURCENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSRESOURCE_PSSYSRESOURCEID");
            pSDEFieldModel.setLinkDEFName("PSSYSRESOURCENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysResourceName");
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
        object = this.createDEField("PSSYSSAHANDLERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1abf2d78597aab5b4fc12e5346960fbb");
            pSDEFieldModel.setName("PSSYSSAHANDLERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u670d\u52a1\u63a5\u53e3\u5904\u7406\u5668");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSSAHANDLER_PSSYSSAHANDLERID");
            pSDEFieldModel.setLinkDEFName("PSSYSSAHANDLERID");
            pSDEFieldModel.setCodeName("PSSysSAHandlerId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSSAHANDLERID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSSAHANDLERID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSSAHANDLERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ecfb391a0915a64cee515a0178c2e80a");
            pSDEFieldModel.setName("PSSYSSAHANDLERNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u63a5\u53e3\u5904\u7406\u5668");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSSAHANDLER_PSSYSSAHANDLERID");
            pSDEFieldModel.setLinkDEFName("PSSYSSAHANDLERNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysSAHandlerName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u7684\u5904\u7406\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSSAHANDLERNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSSAHANDLERNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSSAHANDLERNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSSAHANDLERNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSSERVICEAPIID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("63e212811e06c80f63713c5a960a3d03");
            pSDEFieldModel.setName("PSSYSSERVICEAPIID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSSysServiceAPIId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSSERVICEAPINAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ee9e59a281d930d611ba93e03e777e52");
            pSDEFieldModel.setName("PSSYSSERVICEAPINAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u670d\u52a1\u63a5\u53e3\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSSysServiceAPIName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u540d\u79f0\uff0c\u9700\u5728\u6240\u5728\u6a21\u578b\u57df\uff08\u7cfb\u7edf\u6a21\u5757\u6216\u7cfb\u7edf\uff09\u4e2d\u5177\u5907\u552f\u4e00\u6027");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSSERVICEAPINAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSSERVICEAPINAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSSERVICEAPINAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSSERVICEAPINAME_LIKE");
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
            pSDEFieldModel.setId("9447fa65e39d79c354708389b6667f68");
            pSDEFieldModel.setName("PSSYSSFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540e\u53f0\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSSFPLUGIN_PSSYSSFPLUGINID");
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
            pSDEFieldModel.setId("25126dcb573841becd60af3fb205780e");
            pSDEFieldModel.setName("PSSYSSFPLUGINNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u540e\u53f0\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSSFPLUGIN_PSSYSSFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSSFPLUGINNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysSFPluginName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u540e\u53f0\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u7528\u4e8e\u6269\u5c55\u670d\u52a1\u63a5\u53e3\u4ee3\u7801");
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
        object = this.createDEField("PSSYSTEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ff369839f564756fa4db611c09407235");
            pSDEFieldModel.setName("PSSYSTEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSTEM_PSSYSTEMID");
            pSDEFieldModel.setLinkDEFName("PSSYSTEMID");
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
            pSDEFieldModel.setId("7b9af31638165eee0d7337ecc55e3d65");
            pSDEFieldModel.setName("PSSYSTEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSSERVICEAPI_PSSYSTEM_PSSYSTEMID");
            pSDEFieldModel.setLinkDEFName("PSSYSTEMNAME");
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
        object = this.createDEField("RESETDEFACTIONCODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8f246743fbc80d84dffe16c846a31840");
            pSDEFieldModel.setName("RESETDEFACTIONCODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u91cd\u7f6e\u9ed8\u8ba4\u884c\u4e3a\u4ee3\u7801\u6807\u8bc6");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ResetDefActionCodeName");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SERVICECODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2b5cd2ce9cc8c05e4b0c5b039737deb4");
            pSDEFieldModel.setName("SERVICECODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u670d\u52a1\u4ee3\u7801\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ServiceCodeName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u670d\u52a1\u4ee3\u7801\u6807\u8bc6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u63a5\u53e3\u7684\u3010\u4ee3\u7801\u6807\u8bc6\u3011");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SERVICEDTOFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8ee2f937fcab5716dbe72fd85e2a2717");
            pSDEFieldModel.setName("SERVICEDTOFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4f7f\u7528DTO");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ServiceDTOFlag");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SERVICEPARAM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a061d83995a033f699058f2baf407aac");
            pSDEFieldModel.setName("SERVICEPARAM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u670d\u52a1\u53c2\u6570");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ServiceParam");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u53c2\u6570\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SERVICEPARAM2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e049317c715dd1e55911654bc2dc5de1");
            pSDEFieldModel.setName("SERVICEPARAM2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u670d\u52a1\u53c2\u65702");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ServiceParam2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u53c2\u65702\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SERVICEPARAM3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d71b44f5129a47007e1653a66107d8ce");
            pSDEFieldModel.setName("SERVICEPARAM3");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u670d\u52a1\u53c2\u65703");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ServiceParam3");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u53c2\u65703\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SERVICEPARAM4");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("df679682b7720858fe552bfc65d89c2f");
            pSDEFieldModel.setName("SERVICEPARAM4");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u670d\u52a1\u53c2\u65704");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ServiceParam4");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u53c2\u65704\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SERVICEPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c3e7634d114b05c81bd94b2bdf9fe3e5");
            pSDEFieldModel.setName("SERVICEPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u591a\u670d\u52a1\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ServiceParams");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SERVICETYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5c0866aec8e88b77cd67155b929934c2");
            pSDEFieldModel.setName("SERVICETYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u670d\u52a1\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ServiceTypeCodeListModel");
            pSDEFieldModel.setCodeName("ServiceType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u670d\u52a1\u7c7b\u578b\uff0c\u672a\u6307\u5b9a\u65f6\u4e3a\u3010\u9ed8\u8ba4\u3011");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SERVICETYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SERVICETYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UNIQUETAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6f1dcf5fd410663f56e4c7f91ea8bc23");
            pSDEFieldModel.setName("UNIQUETAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u552f\u4e00\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UniqueTag");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1a9191cca8bbf157dfb7cc9aa8c0e251");
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
            pSDEFieldModel.setId("a4cb28031f83b4f294be179d59405a2f");
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
            pSDEFieldModel.setId("34c4c0ed27b866b34f1e461b1e11af1e");
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
            pSDEFieldModel.setId("3627b66ad6fa5166d009e8c892e415ff");
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
            pSDEFieldModel.setId("72e4a9e75d0ea602988ca6fc064fb57a");
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
            pSDEFieldModel.setId("0217bcf68ebb88ab4b79973ef0e74500");
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
            pSDEFieldModel.setId("8c2ca253c614422a06080b086fbcae0f");
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
            pSDEFieldModel.setId("b7a583d344e28725732ac017a15de14c");
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
        object = this.createDEField("VER");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("83d5aa891e2ca917428fdb3b2f41151d");
            pSDEFieldModel.setName("VER");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7248\u672c");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Ver");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u7248\u672c");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSSysServiceAPIDefaultACModel pSSysServiceAPIDefaultACModel = new PSSysServiceAPIDefaultACModel();
        pSSysServiceAPIDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSSysServiceAPIDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSSysServiceAPICurSysDSModel pSSysServiceAPICurSysDSModel = new PSSysServiceAPICurSysDSModel();
        pSSysServiceAPICurSysDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysServiceAPICurSysDSModel);
        PSSysServiceAPIDefaultDSModel pSSysServiceAPIDefaultDSModel = new PSSysServiceAPIDefaultDSModel();
        pSSysServiceAPIDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysServiceAPIDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSSysServiceAPICurSysDQModel pSSysServiceAPICurSysDQModel = new PSSysServiceAPICurSysDQModel();
        pSSysServiceAPICurSysDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysServiceAPICurSysDQModel);
        PSSysServiceAPIDefaultDQModel pSSysServiceAPIDefaultDQModel = new PSSysServiceAPIDefaultDQModel();
        pSSysServiceAPIDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysServiceAPIDefaultDQModel);
    }

    protected void prepareDEActions() throws Exception {
    }

    protected void prepareDELogics() throws Exception {
    }

    @Override
    protected void onPrepareDEUIActions() throws Exception {
        PSSysServiceAPIAddSyncClientModelTaskUIActionModel pSSysServiceAPIAddSyncClientModelTaskUIActionModel = new PSSysServiceAPIAddSyncClientModelTaskUIActionModel();
        pSSysServiceAPIAddSyncClientModelTaskUIActionModel.init((IDataEntity)this);
        this.registerDEUIAction((IDEUIAction)pSSysServiceAPIAddSyncClientModelTaskUIActionModel);
        PSSysServiceAPICreateSubSysFileUIActionModel pSSysServiceAPICreateSubSysFileUIActionModel = new PSSysServiceAPICreateSubSysFileUIActionModel();
        pSSysServiceAPICreateSubSysFileUIActionModel.init((IDataEntity)this);
        this.registerDEUIAction((IDEUIAction)pSSysServiceAPICreateSubSysFileUIActionModel);
        PSSysServiceAPIGenUniqueTagUIActionModel pSSysServiceAPIGenUniqueTagUIActionModel = new PSSysServiceAPIGenUniqueTagUIActionModel();
        pSSysServiceAPIGenUniqueTagUIActionModel.init((IDataEntity)this);
        this.registerDEUIAction((IDEUIAction)pSSysServiceAPIGenUniqueTagUIActionModel);
        PSSysServiceAPIRebuildByAppDEUIActionModel pSSysServiceAPIRebuildByAppDEUIActionModel = new PSSysServiceAPIRebuildByAppDEUIActionModel();
        pSSysServiceAPIRebuildByAppDEUIActionModel.init((IDataEntity)this);
        this.registerDEUIAction((IDEUIAction)pSSysServiceAPIRebuildByAppDEUIActionModel);
        PSSysServiceAPIRebuildDESARSUIActionModel pSSysServiceAPIRebuildDESARSUIActionModel = new PSSysServiceAPIRebuildDESARSUIActionModel();
        pSSysServiceAPIRebuildDESARSUIActionModel.init((IDataEntity)this);
        this.registerDEUIAction((IDEUIAction)pSSysServiceAPIRebuildDESARSUIActionModel);
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
        this.registerPDTDEView("EDITVIEW", "f852288b0a2157eed39bcfe95fe5a4b7");
        this.registerPDTDEView("MDATAVIEW", "3d2b86b7f72e2992f36d9427da09d59b");
        this.registerPDTDEView("MPICKUPVIEW", "0df7a90b85aefa2270a957fe74a2c02f");
        this.registerPDTDEView("PICKUPVIEW", "708ca085ede36f155e344d20046e9452");
        this.registerPDTDEView("REDIRECTVIEW", "d3d21fe53bc33a98b1b673f92e9071f7");
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
        dEDataSetCond2.setDEFName("PSSYSSERVICEAPINAME");
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
        pSDEFGroupDetailModel.setId("7f112fddfadaeccf8a764e858fff5caf");
        pSDEFGroupDetailModel.setName("APILEVEL");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("APILEVEL", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.APILevelCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u7ea7\u522b\uff0c\u9ed8\u8ba4\u4e3a\u3010\u7528\u6237\u7ea7\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8711fda2c3a8fdeea8f023abce76e38d");
        pSDEFGroupDetailModel.setName("APIMODE");
        iPSDEFieldModel = this.getDEField("APIMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ServiceAPIModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u6a21\u5f0f\uff0c\u9ed8\u8ba4\u4e3a\u3010\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\uff08\u6307\u5b9a\u5b9e\u4f53\uff09\uff08\u9ed8\u8ba4\uff09\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("70b374c7ba02a8ad124b051fb7b36af1");
        pSDEFGroupDetailModel.setName("APITYPE");
        iPSDEFieldModel = this.getDEField("APITYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ServiceAPITypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u7c7b\u578b\uff0c\u9ed8\u8ba4\u4e3a\u3010RESTful API\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5b9f8933a624b715bd7fbcc61e090c6b");
        pSDEFGroupDetailModel.setName("AUTHCHECKTOKENURI");
        iPSDEFieldModel = this.getDEField("AUTHCHECKTOKENURI", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u8def\u5f84\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e5948d632f3306e4641a16e232b33453");
        pSDEFGroupDetailModel.setName("AUTHCLIENTID");
        iPSDEFieldModel = this.getDEField("AUTHCLIENTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u5ba2\u6237\u7aef\u6807\u8bc6\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("937e2ea4501b1ec782efa80cb35f925b");
        pSDEFGroupDetailModel.setName("AUTHCLIENTSECRET");
        iPSDEFieldModel = this.getDEField("AUTHCLIENTSECRET", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u5ba2\u6237\u7aef\u5bc6\u94a5\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("326db5e86d914c1f9f478d7dd00594eb");
        pSDEFGroupDetailModel.setName("AUTHMODE");
        iPSDEFieldModel = this.getDEField("AUTHMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.APIAuthModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u6a21\u5f0f\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6077dda338ce4b6f249ffd92b2bea92a");
        pSDEFGroupDetailModel.setName("AUTHPARAM");
        iPSDEFieldModel = this.getDEField("AUTHPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u53c2\u6570\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bbd4a48d5ec26d3c33f04ae9f4f33594");
        pSDEFGroupDetailModel.setName("AUTHPARAM2");
        iPSDEFieldModel = this.getDEField("AUTHPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u53c2\u65702\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7bb6b5cb1017b9ffb3710aebd6110b82");
        pSDEFGroupDetailModel.setName("AUTHPARAM3");
        iPSDEFieldModel = this.getDEField("AUTHPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u53c2\u65703\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("340d00db19018f51147c12e6d6c38b21");
        pSDEFGroupDetailModel.setName("AUTHPARAM4");
        iPSDEFieldModel = this.getDEField("AUTHPARAM4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u8ba4\u8bc1\u53c2\u65704\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("695427df4cb697b9b8dfea60404d35a4");
        pSDEFGroupDetailModel.setName("BASECLSPARAMS");
        iPSDEFieldModel = this.getDEField("BASECLSPARAMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f2129b58869473bd9e1ec5b8abebf458");
        pSDEFGroupDetailModel.setName("CODENAME");
        iPSDEFieldModel = this.getDEField("CODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u8981\u5728\u670d\u52a1\u63a5\u53e3\u6240\u5728\u7684\u6a21\u578b\u57df\uff08\u7cfb\u7edf\u6a21\u5757\u6216\u7cfb\u7edf\uff09\u4e2d\u5177\u6709\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c59d5b9a6ebca3fb4d4741a1a757f97f");
        pSDEFGroupDetailModel.setName("CODENAMEMODE");
        iPSDEFieldModel = this.getDEField("CODENAMEMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.CodeNameModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f664293942311ed95b1f78bc39100a82");
        pSDEFGroupDetailModel.setName("DEPSSYSSFPLUGINID");
        iPSDEFieldModel = this.getDEField("DEPSSYSSFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u7684\u540e\u53f0\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u7528\u4e8e\u6269\u5c55\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u4ee3\u7801");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5c22df1b2ae49d171e23497978cd0b96");
        pSDEFGroupDetailModel.setName("DEPSSYSSFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("DEPSSYSSFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u7684\u540e\u53f0\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u7528\u4e8e\u6269\u5c55\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u4ee3\u7801");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ffc030c6e27f2f21f5c550e0099c6552");
        pSDEFGroupDetailModel.setName("DEFDEACTIONREQMETHOD");
        iPSDEFieldModel = this.getDEField("DEFDEACTIONREQMETHOD", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5230\u670d\u52a1\u63a5\u53e3\u4e2d\u5b9e\u4f53\u884c\u4e3a\u9ed8\u8ba4\u7684\u8bf7\u6c42\u65b9\u5f0f\uff0c\u4f9b\u672a\u5b9a\u4e49\u8bf7\u6c42\u65b9\u5f0f\u7684\u5b9e\u4f53\u884c\u4e3a\u4f7f\u7528");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("640a8581e22e74bdd729c2a814bb8efb");
        pSDEFGroupDetailModel.setName("DEFDEDATASETREQMETHOD");
        iPSDEFieldModel = this.getDEField("DEFDEDATASETREQMETHOD", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5230\u670d\u52a1\u63a5\u53e3\u4e2d\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u9ed8\u8ba4\u7684\u8bf7\u6c42\u65b9\u5f0f\uff0c\u4f9b\u672a\u5b9a\u4e49\u8bf7\u6c42\u65b9\u5f0f\u7684\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u4f7f\u7528");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6ac479c7e3acbb13d2f4d07326acfc8e");
        pSDEFGroupDetailModel.setName("DEFSELECTREQMETHOD");
        iPSDEFieldModel = this.getDEField("DEFSELECTREQMETHOD", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5230\u670d\u52a1\u63a5\u53e3\u4e2d\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u9ed8\u8ba4\u7684\u8bf7\u6c42\u65b9\u5f0f\uff0c\u4f9b\u672a\u5b9a\u4e49\u8bf7\u6c42\u65b9\u5f0f\u7684\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u4f7f\u7528");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2dc0d192c1597130e08f608705516a25");
        pSDEFGroupDetailModel.setName("DEFAULTPSDEOPPRIVID");
        iPSDEFieldModel = this.getDEField("DEFAULTPSDEOPPRIVID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d23349dec6225e8b59b1eb998edfdaee");
        pSDEFGroupDetailModel.setName("DEFAULTPSDEOPPRIVNAME");
        iPSDEFieldModel = this.getDEField("DEFAULTPSDEOPPRIVNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8bc92a91f0083e610c85989956c601a3");
        pSDEFGroupDetailModel.setName("DEFAULTPORT");
        iPSDEFieldModel = this.getDEField("DEFAULTPORT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u670d\u52a1\u7aef\u53e3\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d9a174ae329b1ab9bb880ad07e634df7");
        pSDEFGroupDetailModel.setName("LOCKFLAG");
        iPSDEFieldModel = this.getDEField("LOCKFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a1c22a749980ee309016007aec96542e");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3f265d45cfe680464f3d71bf46748a1c");
        pSDEFGroupDetailModel.setName("ORDERVALUE");
        iPSDEFieldModel = this.getDEField("ORDERVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2a546aae38e86f054793f57dc9951bad");
        pSDEFGroupDetailModel.setName("OUTPSSYSTRANSLATORID");
        iPSDEFieldModel = this.getDEField("OUTPSSYSTRANSLATORID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("786cc569725be8406e7c2e81d70d3875");
        pSDEFGroupDetailModel.setName("OUTPSSYSTRANSLATORNAME");
        iPSDEFieldModel = this.getDEField("OUTPSSYSTRANSLATORNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49d50d1184d2974c127a2ae738fcd261");
        pSDEFGroupDetailModel.setName("PSMODULEID");
        iPSDEFieldModel = this.getDEField("PSMODULEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u6240\u5c5e\u6a21\u5757");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6728c37913e3a7f794a9ace17da3c7b3");
        pSDEFGroupDetailModel.setName("PSMODULENAME");
        iPSDEFieldModel = this.getDEField("PSMODULENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u6240\u5c5e\u6a21\u5757");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c050582619c8838163df5d70f226ee73");
        pSDEFGroupDetailModel.setName("PSSYSDYNAMODELID");
        iPSDEFieldModel = this.getDEField("PSSYSDYNAMODELID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3df1087d0de489fb3b2938c6f967e30d");
        pSDEFGroupDetailModel.setName("PSSYSDYNAMODELNAME");
        iPSDEFieldModel = this.getDEField("PSSYSDYNAMODELNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("06a31c76d4a5b90c41e9e7ddb3b94e91");
        pSDEFGroupDetailModel.setName("PSSYSRESOURCEID");
        iPSDEFieldModel = this.getDEField("PSSYSRESOURCEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5948a19011aa43a2dc445eefef24485c");
        pSDEFGroupDetailModel.setName("PSSYSRESOURCENAME");
        iPSDEFieldModel = this.getDEField("PSSYSRESOURCENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1abf2d78597aab5b4fc12e5346960fbb");
        pSDEFGroupDetailModel.setName("PSSYSSAHANDLERID");
        iPSDEFieldModel = this.getDEField("PSSYSSAHANDLERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u7684\u5904\u7406\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ecfb391a0915a64cee515a0178c2e80a");
        pSDEFGroupDetailModel.setName("PSSYSSAHANDLERNAME");
        iPSDEFieldModel = this.getDEField("PSSYSSAHANDLERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u7684\u5904\u7406\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9447fa65e39d79c354708389b6667f68");
        pSDEFGroupDetailModel.setName("PSSYSSFPLUGINID");
        iPSDEFieldModel = this.getDEField("PSSYSSFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u540e\u53f0\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u7528\u4e8e\u6269\u5c55\u670d\u52a1\u63a5\u53e3\u4ee3\u7801");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("25126dcb573841becd60af3fb205780e");
        pSDEFGroupDetailModel.setName("PSSYSSFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("PSSYSSFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u540e\u53f0\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u7528\u4e8e\u6269\u5c55\u670d\u52a1\u63a5\u53e3\u4ee3\u7801");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ee9e59a281d930d611ba93e03e777e52");
        pSDEFGroupDetailModel.setName("PSSYSSERVICEAPINAME");
        iPSDEFieldModel = this.getDEField("PSSYSSERVICEAPINAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u540d\u79f0\uff0c\u9700\u5728\u6240\u5728\u6a21\u578b\u57df\uff08\u7cfb\u7edf\u6a21\u5757\u6216\u7cfb\u7edf\uff09\u4e2d\u5177\u5907\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ff369839f564756fa4db611c09407235");
        pSDEFGroupDetailModel.setName("PSSYSTEMID");
        iPSDEFieldModel = this.getDEField("PSSYSTEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7b9af31638165eee0d7337ecc55e3d65");
        pSDEFGroupDetailModel.setName("PSSYSTEMNAME");
        iPSDEFieldModel = this.getDEField("PSSYSTEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3d25a4e67ba1d9a468950ae0e6f843c3");
        pSDEFGroupDetailModel.setName("PREDEFINEDTYPE");
        iPSDEFieldModel = this.getDEField("PREDEFINEDTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PredefinedServiceAPICodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u9884\u5b9a\u4e49\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8f246743fbc80d84dffe16c846a31840");
        pSDEFGroupDetailModel.setName("RESETDEFACTIONCODENAME");
        iPSDEFieldModel = this.getDEField("RESETDEFACTIONCODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2b5cd2ce9cc8c05e4b0c5b039737deb4");
        pSDEFGroupDetailModel.setName("SERVICECODENAME");
        iPSDEFieldModel = this.getDEField("SERVICECODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u670d\u52a1\u4ee3\u7801\u6807\u8bc6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u63a5\u53e3\u7684\u3010\u4ee3\u7801\u6807\u8bc6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8ee2f937fcab5716dbe72fd85e2a2717");
        pSDEFGroupDetailModel.setName("SERVICEDTOFLAG");
        iPSDEFieldModel = this.getDEField("SERVICEDTOFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a061d83995a033f699058f2baf407aac");
        pSDEFGroupDetailModel.setName("SERVICEPARAM");
        iPSDEFieldModel = this.getDEField("SERVICEPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u53c2\u6570\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e049317c715dd1e55911654bc2dc5de1");
        pSDEFGroupDetailModel.setName("SERVICEPARAM2");
        iPSDEFieldModel = this.getDEField("SERVICEPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u53c2\u65702\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d71b44f5129a47007e1653a66107d8ce");
        pSDEFGroupDetailModel.setName("SERVICEPARAM3");
        iPSDEFieldModel = this.getDEField("SERVICEPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u53c2\u65703\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("df679682b7720858fe552bfc65d89c2f");
        pSDEFGroupDetailModel.setName("SERVICEPARAM4");
        iPSDEFieldModel = this.getDEField("SERVICEPARAM4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u53c2\u65704\uff0c\u652f\u6301\u5728\u8fd0\u884c\u73af\u5883\u8fdb\u884c\u914d\u7f6e\u8c03\u6574");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c3e7634d114b05c81bd94b2bdf9fe3e5");
        pSDEFGroupDetailModel.setName("SERVICEPARAMS");
        iPSDEFieldModel = this.getDEField("SERVICEPARAMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5c0866aec8e88b77cd67155b929934c2");
        pSDEFGroupDetailModel.setName("SERVICETYPE");
        iPSDEFieldModel = this.getDEField("SERVICETYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ServiceTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u670d\u52a1\u7c7b\u578b\uff0c\u672a\u6307\u5b9a\u65f6\u4e3a\u3010\u9ed8\u8ba4\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("34c4c0ed27b866b34f1e461b1e11af1e");
        pSDEFGroupDetailModel.setName("USERCAT");
        iPSDEFieldModel = this.getDEField("USERCAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelUserCatCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3627b66ad6fa5166d009e8c892e415ff");
        pSDEFGroupDetailModel.setName("USERTAG");
        iPSDEFieldModel = this.getDEField("USERTAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("72e4a9e75d0ea602988ca6fc064fb57a");
        pSDEFGroupDetailModel.setName("USERTAG2");
        iPSDEFieldModel = this.getDEField("USERTAG2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0217bcf68ebb88ab4b79973ef0e74500");
        pSDEFGroupDetailModel.setName("USERTAG3");
        iPSDEFieldModel = this.getDEField("USERTAG3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8c2ca253c614422a06080b086fbcae0f");
        pSDEFGroupDetailModel.setName("USERTAG4");
        iPSDEFieldModel = this.getDEField("USERTAG4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b7a583d344e28725732ac017a15de14c");
        pSDEFGroupDetailModel.setName("VALIDFLAG");
        iPSDEFieldModel = this.getDEField("VALIDFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColor3CodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("83d5aa891e2ca917428fdb3b2f41151d");
        pSDEFGroupDetailModel.setName("VER");
        iPSDEFieldModel = this.getDEField("VER", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u670d\u52a1\u63a5\u53e3\u7684\u7248\u672c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

