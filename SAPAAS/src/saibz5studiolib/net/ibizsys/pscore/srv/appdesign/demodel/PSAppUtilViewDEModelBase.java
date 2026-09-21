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
package net.ibizsys.pscore.srv.appdesign.demodel;

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
import net.ibizsys.pscore.srv.appdesign.demodel.psapputilview.ac.PSAppUtilViewDefaultACModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psapputilview.dataquery.PSAppUtilViewCurAppDQModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psapputilview.dataquery.PSAppUtilViewCurAppFuncDQModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psapputilview.dataquery.PSAppUtilViewDefaultDQModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psapputilview.dataset.PSAppUtilViewCurAppDSModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psapputilview.dataset.PSAppUtilViewCurAppFuncDSModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psapputilview.dataset.PSAppUtilViewDefaultDSModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilViewService;
import net.ibizsys.pscore.srv.core.IPSDEFGroupModel;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupDetailModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupModel;
import net.ibizsys.pscore.srv.core.PSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDataEntityModelBase;

public abstract class PSAppUtilViewDEModelBase
extends PSDataEntityModelBase<PSAppUtilView> {
    private PSCoreSysModel pSCoreSysModel;
    private PSAppUtilViewService pSAppUtilViewService;

    public PSAppUtilViewDEModelBase() throws Exception {
        this.setId("aa1df850a31555d1119dcb26f390e730");
        this.setName("PSAPPUTILVIEW");
        this.setCodeName("PSAppUtilView");
        this.setTableName("T_SRFPSAPPUTILVIEW");
        this.setViewName("v_PSAPPUTILVIEW");
        this.setLogicName("\u5e94\u7528\u529f\u80fd\u89c6\u56fe");
        this.setMemo("\u5e94\u7528\u529f\u80fd\u89c6\u56fe\u6a21\u578b\uff0c\u5b9a\u4e49\u5e94\u7528\u7684\u9884\u7f6e\u529f\u80fd\u89c6\u56fe");
        this.setDSLink("DEFAULT");
        this.setInheritDEId("7fb7186bc74741fbe7ee72bd472c5aa3");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setEnableTempData(true);
        this.setUserTag("MODELV2");
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppUtilViewDEModel", (IDataEntityModel)this);
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

    public PSAppUtilViewService getRealService() {
        if (this.pSAppUtilViewService == null) {
            try {
                this.pSAppUtilViewService = (PSAppUtilViewService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppUtilViewService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppUtilViewService";
    }

    public PSAppUtilView createEntity() {
        return new PSAppUtilView();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("ACCUSERMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fed2d60142c37d2b37c00d3b2345ea67");
            pSDEFieldModel.setName("ACCUSERMODE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8bbf\u95ee\u7528\u6237\u6a21\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("ACCUSERMODE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ViewAccessUsersCodeListModel");
            pSDEFieldModel.setCodeName("AccUserMode");
            pSDEFieldModel.setLength(20);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("APPVIEWSN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ddc75f2d61bf7fcfe72ccd7bdc46cc6a");
            pSDEFieldModel.setName("APPVIEWSN");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u89c6\u56fe\u7f16\u53f7");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("APPVIEWSN");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("AppViewSN");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("APPVIEWSTATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c901dc42bae730fabf76ff628e0bd786");
            pSDEFieldModel.setName("APPVIEWSTATE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u89c6\u56fe\u72b6\u6001");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("APPVIEWSTATE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("AppViewState");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CAPPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("374e01f87155113f903123da2d0210b0");
            pSDEFieldModel.setName("CAPPSLANRESID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("CAPPSLANRESID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("CapPSLanResId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CAPPSLANRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2699c8fb2c7c0b5ec90c0cdb7e9646a3");
            pSDEFieldModel.setName("CAPPSLANRESNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("CAPPSLANRESNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("CapPSLanResName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CAPTION");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0182d51059a9fc3220ee9a40b76af529");
            pSDEFieldModel.setName("CAPTION");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6807\u9898");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("CAPTION");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("Caption");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COLOR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8b2c7762ce83f620e3b0c53de66a0ad9");
            pSDEFieldModel.setName("COLOR");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u989c\u8272");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("COLOR");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("Color");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2f38c7a58d2491cee9b7bf149636a446");
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
            pSDEFieldModel.setId("41f7bddd93caaed0a373089d1b293606");
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
            pSDEFieldModel.setId("c1ba668ff505598e36c975c6db8a7cfd");
            pSDEFieldModel.setName("DYNAMODELFLAG");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u6a21\u578b\u7c7b\u578b");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("DYNAMODELFLAG");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DynaModelTypeCodeListModel");
            pSDEFieldModel.setCodeName("DynaModelFlag");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DYNCMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6d358f3c57e958a61e1846cce63a188a");
            pSDEFieldModel.setName("DYNCMODE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u4f18\u5148\u7ea7");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("DYNCMODE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
            pSDEFieldModel.setCodeName("DyncMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLEVIEWSTYLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b6b243c7362bf6e800c138651ed61605");
            pSDEFieldModel.setName("ENABLEVIEWSTYLE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u542f\u7528\u89c6\u56fe\u7ea7\u522b\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("ENABLEVIEWSTYLE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableViewStyle");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u89c6\u56fe\u662f\u5426\u542f\u7528\u89c6\u56fe\u7ea7\u522b\u754c\u9762\u6837\u5f0f\uff0c\u672a\u5b9a\u4e49\u662f\u4e3a\u3010\u5426\u3011\uff0c\u6b64\u914d\u7f6e\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ERRCODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2d6d9f978faa98c06d7cd4ce96bd1b74");
            pSDEFieldModel.setName("ERRCODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9519\u8bef\u4ee3\u7801");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ErrCode");
            pSDEFieldModel.setLength(1000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LAYOUTPANELMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("421bab8eab8231419b331f4895ca0c34");
            pSDEFieldModel.setName("LAYOUTPANELMODE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e03\u5c40\u9762\u677f\u5e94\u7528\u6a21\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("LAYOUTPANELMODE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ViewLayoutPanelModeCodeListModel");
            pSDEFieldModel.setCodeName("LayoutPanelMode");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c5179216725106630a3564c39d602551");
            pSDEFieldModel.setName("MEMO");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5907\u6ce8");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("MEMO");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("Memo");
            pSDEFieldModel.setLength(2000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MODCOLOR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cf8bf3bf443f37d5f0cfb18230e415c1");
            pSDEFieldModel.setName("MODCOLOR");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6a21\u5757\u989c\u8272");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("MODCOLOR");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("ModColor");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREVENTXSS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("33ec03d491c79b52c58cb2a75550755d");
            pSDEFieldModel.setName("PREVENTXSS");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u9632\u6b62XSS\u653b\u51fb");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PREVENTXSS");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("PreventXSS");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSACHANDLERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("71e1fceae09e960da116acf69ead26a9");
            pSDEFieldModel.setName("PSACHANDLERID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u540e\u53f0\u5904\u7406\u5bf9\u8c61");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSACHANDLERID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSACHandlerId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSACHANDLERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fcd73a555dcfd504c64ce2121a212580");
            pSDEFieldModel.setName("PSACHANDLERNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5904\u7406\u5bf9\u8c61");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSACHANDLERNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSACHandlerName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPLOCALDEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bcc338b94d992ee30833a268dd4d5a19");
            pSDEFieldModel.setName("PSAPPLOCALDEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u5b9e\u4f53");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSAPPLOCALDEID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSAppLocalDEId");
            pSDEFieldModel.setServiceCodeName("PSAppDataEntityId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPLOCALDENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b892a1ce0e4c58c2ad12a61ba6113edc");
            pSDEFieldModel.setName("PSAPPLOCALDENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u5b9e\u4f53");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSAPPLOCALDENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSAppLocalDEName");
            pSDEFieldModel.setServiceCodeName("PSAppDataEntityName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPMENUID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0dfa780263e6542ae64300a991a13304");
            pSDEFieldModel.setName("PSAPPMENUID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6e90\u5e94\u7528\u83dc\u5355");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPUTILVIEW_PSAPPMENU_PSAPPMENUID");
            pSDEFieldModel.setLinkDEFName("PSAPPMENUID");
            pSDEFieldModel.setCodeName("PSAppMenuId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPMENUID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPMENUID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPMENUNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d9c50f154dbf8757002c74f60e15748c");
            pSDEFieldModel.setName("PSAPPMENUNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6e90\u5e94\u7528\u83dc\u5355");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPUTILVIEW_PSAPPMENU_PSAPPMENUID");
            pSDEFieldModel.setLinkDEFName("PSAPPMENUNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSAppMenuName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPMENUNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPMENUNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPMENUNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPMENUNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPMODULEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d11ef91cecdb49c352df7420f817de7d");
            pSDEFieldModel.setName("PSAPPMODULEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6a21\u5757");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSAPPMODULEID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSAppModuleId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPMODULENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f2782556255a7dfbb209a24815ecf79b");
            pSDEFieldModel.setName("PSAPPMODULENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6a21\u5757");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSAPPMODULENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSAppModuleName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPTITLEBARID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f326f6675edad5abde7d982ad3841c90");
            pSDEFieldModel.setName("PSAPPTITLEBARID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6807\u9898\u680f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSAPPTITLEBARID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSAppTitleBarId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPTITLEBARNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("df5eb8cac9fe73853ad88f5798dac621");
            pSDEFieldModel.setName("PSAPPTITLEBARNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6807\u9898\u680f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSAPPTITLEBARNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSAppTitleBarName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u529f\u80fd\u89c6\u56fe\u4f7f\u7528\u7684\u6807\u9898\u680f\u90e8\u4ef6");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPUTILVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("931b01c0f645bd26d713ed01cbcdb0bf");
            pSDEFieldModel.setName("PSAPPUTILVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u529f\u80fd\u89c6\u56fe\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSAppUtilViewId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPUTILVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("84a1b020f65b9463490e1cf19e4553ba");
            pSDEFieldModel.setName("PSAPPUTILVIEWNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSAppUtilViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u529f\u80fd\u89c6\u56fe\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5728\u524d\u7aef\u5e94\u7528\u4e2d\u5177\u5907\u552f\u4e00\u6027");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPUTILVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPUTILVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPUTILVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPUTILVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPUTILVIEWTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("aef52236ecb3c86e2d55a702d7049ce8");
            pSDEFieldModel.setName("PSAPPUTILVIEWTYPE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u529f\u80fd\u89c6\u56fe\u7c7b\u578b");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSAPPUTILVIEWTYPE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppUtilViewsCodeListModel");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSAppUtilViewType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u529f\u80fd\u89c6\u56fe\u7684\u7c7b\u578b");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPVIEWSTYLEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f139dcb62aead8f3905e5c0bf19047d4");
            pSDEFieldModel.setName("PSAPPVIEWSTYLEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u89c6\u56fe\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSAPPVIEWSTYLEID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSAppViewStyleId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPVIEWSTYLENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2d934be5f56acfc95b4e908e5f0471f8");
            pSDEFieldModel.setName("PSAPPVIEWSTYLENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u89c6\u56fe\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSAPPVIEWSTYLENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSAppViewStyleName");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPVIEWTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4b490eaeadebc8096b706d4bc02a88eb");
            pSDEFieldModel.setName("PSAPPVIEWTYPE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u89c6\u56fe\u7c7b\u578b");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSAPPVIEWTYPE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewTypeCodeListModel");
            pSDEFieldModel.setCodeName("PSAppViewType");
            pSDEFieldModel.setLength(40);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSCTRLLOGICGROUPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("aea18c4781894963686c54c6bbd47911");
            pSDEFieldModel.setName("PSCTRLLOGICGROUPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u754c\u9762\u903b\u8f91\u7ec4");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSCTRLLOGICGROUPID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSCtrlLogicGroupId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSCTRLLOGICGROUPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1fc0fdaed7dc25cfbd09335be7d8654e");
            pSDEFieldModel.setName("PSCTRLLOGICGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u754c\u9762\u903b\u8f91\u7ec4");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSCTRLLOGICGROUPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSCtrlLogicGroupName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVIEWBASEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("00a4bee3ece40bd34d2989960d0107d9");
            pSDEFieldModel.setName("PSDEVIEWBASEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u89c6\u56fe");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEViewBaseId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVIEWBASENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8553bab00b7ade8c6daaa72504650b34");
            pSDEFieldModel.setName("PSDEVIEWBASENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u89c6\u56fe");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEViewBaseName");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVIEWTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7bd0c55312d6af12f8600fe66a8213b5");
            pSDEFieldModel.setName("PSDEVIEWTYPE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u89c6\u56fe\u7c7b\u578b");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWTYPE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEViewType2CodeListModel");
            pSDEFieldModel.setCodeName("PSDEViewType");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDYNADEVIEWTEMPLID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7cb516a98806129448218bbc0375b0fc");
            pSDEFieldModel.setName("PSDYNADEVIEWTEMPLID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u5b9e\u4f53\u6a21\u677f\u89c6\u56fe");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSDYNADEVIEWTEMPLID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDynaDEViewTemplId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setMemo("IGNOREMODELV2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDYNADEVIEWTEMPLNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cf56c0bed6dbf749b65739762c511f0f");
            pSDEFieldModel.setName("PSDYNADEVIEWTEMPLNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u5b9e\u4f53\u6a21\u677f\u89c6\u56fe");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSDYNADEVIEWTEMPLNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDynaDEViewTemplName");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDYNADEVIEWTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("acf35de4d7639ac39c8c39fb78c5e0d1");
            pSDEFieldModel.setName("PSDYNADEVIEWTYPE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u5b9e\u4f53\u89c6\u56fe\u7c7b\u578b");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSDYNADEVIEWTYPE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DynaDEViewTypesCodeListModel");
            pSDEFieldModel.setCodeName("PSDynaDEViewType");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDYNAINSTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("39a7913648b01a83ecfcef7c76946a92");
            pSDEFieldModel.setName("PSDYNAINSTID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("PSDYNAINSTID");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSDYNAINSTID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDynaInstId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSHELPMODULEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("68b8962a608b1079ba9ca3613231ef8a");
            pSDEFieldModel.setName("PSHELPMODULEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5e2e\u52a9");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSHELPMODULEID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSHelpModuleId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSHELPMODULENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ea1df6f74f4c94eaead6ad718ead4195");
            pSDEFieldModel.setName("PSHELPMODULENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5e2e\u52a9");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSHELPMODULENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSHelpModuleName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSPFID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("47d2a7c337e9999bfeb8e5df9c8fcffa");
            pSDEFieldModel.setName("PSPFID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6a21\u677f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSPFID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSPFId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSPFSTYLEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4494337beb8a4314123c979703f3edeb");
            pSDEFieldModel.setName("PSPFSTYLEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSPFSTYLEID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSPFStyleId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSPFSTYLENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a54af7755193aa0644ff156fe7348a0f");
            pSDEFieldModel.setName("PSPFSTYLENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSPFSTYLENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSPFStyleName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSUBVIEWTYPEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5307e32618df83a6830d42d72e720e8e");
            pSDEFieldModel.setName("PSSUBVIEWTYPEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u5b50\u89c6\u56fe\u7c7b\u578b");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSUBVIEWTYPEID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSubViewTypeId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSUBVIEWTYPENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a24398a9e1e013b76ae351d68322fc72");
            pSDEFieldModel.setName("PSSUBVIEWTYPENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u89c6\u56fe\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSUBVIEWTYPENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSubViewTypeName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSAPPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ffc9f408d5422969ac71ced7a0b5c302");
            pSDEFieldModel.setName("PSSYSAPPID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u5e94\u7528");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSAPPID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysAppId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSAPPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1e12356cd1ce2a63a024983aedc3df6a");
            pSDEFieldModel.setName("PSSYSAPPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u5e94\u7528");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSAPPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSSysAppName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSCSSID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("936496e875cd2cff6aecf1e445ad977e");
            pSDEFieldModel.setName("PSSYSCSSID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u754c\u9762\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSCSSID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysCssId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSCSSNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3c3a18ba1d449501468e326774493156");
            pSDEFieldModel.setName("PSSYSCSSNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u754c\u9762\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSCSSNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysCssName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDYNAMODELID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("64766f2c44b72e526ac14c279adb069e");
            pSDEFieldModel.setName("PSSYSDYNAMODELID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6269\u5c55\u52a8\u6001\u6a21\u578b");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSDYNAMODELID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysDynaModelId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDYNAMODELNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("200c21f9c56ff4b3439f84bbe1f56e7d");
            pSDEFieldModel.setName("PSSYSDYNAMODELNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6269\u5c55\u52a8\u6001\u6a21\u578b");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSDYNAMODELNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysDynaModelName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSIMAGEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("85e5823079db971fff741c380ffcc3a3");
            pSDEFieldModel.setName("PSSYSIMAGEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u56fe\u6807");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSIMAGEID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysImageId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSIMAGENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a30be6994b3c9927b5a9c321941a6212");
            pSDEFieldModel.setName("PSSYSIMAGENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u56fe\u6807");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSIMAGENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysImageName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSREQITEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("65557776a1947dff9d813b96dcf4cfd8");
            pSDEFieldModel.setName("PSSYSREQITEMID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8bbe\u8ba1\u9700\u6c42");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSREQITEMID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysReqItemId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSREQITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1c3cecc40be4a210b5da1acdd1d4640f");
            pSDEFieldModel.setName("PSSYSREQITEMNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8bbe\u8ba1\u9700\u6c42");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSREQITEMNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysReqItemName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bdcd39d1ce4a45ecef648772c8d83a94");
            pSDEFieldModel.setName("PSSYSTEMID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSTEMID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSystemId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSUNIRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a41d3f355551fea898bc6eafe5197c7d");
            pSDEFieldModel.setName("PSSYSUNIRESID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSUNIRESID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysUniResId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSUNIRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("38981c877508d11716caf0564ba8c999");
            pSDEFieldModel.setName("PSSYSUNIRESNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSUNIRESNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysUniResName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSVIEWPANELID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("20c6e7c12295678ec6eea3e09fd06e67");
            pSDEFieldModel.setName("PSSYSVIEWPANELID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5e03\u5c40\u9762\u677f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSVIEWPANELID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysViewPanelId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSVIEWPANELNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8978d1c2924d61311af4d8a2aa0cab07");
            pSDEFieldModel.setName("PSSYSVIEWPANELNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5e03\u5c40\u9762\u677f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSVIEWPANELNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysViewPanelName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSVIEWENGINEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("df85d8a290ac6be8a698da5a23c6ede2");
            pSDEFieldModel.setName("PSVIEWENGINEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5f15\u64ce");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSVIEWENGINEID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSViewEngineId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSVIEWENGINENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ba448045c1cf5eded8b3c1ba71de6ca9");
            pSDEFieldModel.setName("PSVIEWENGINENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5f15\u64ce");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSVIEWENGINENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSViewEngineName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSVIEWMSGGROUPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b3c704e9107917f6eef122296b975fba");
            pSDEFieldModel.setName("PSVIEWMSGGROUPID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6d88\u606f\u7ec4");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSVIEWMSGGROUPID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSViewMsgGroupId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSVIEWMSGGROUPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fb8a3744c1108f0c270f18f68aff1a58");
            pSDEFieldModel.setName("PSVIEWMSGGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6d88\u606f\u7ec4");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSVIEWMSGGROUPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSViewMsgGroupName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSVIEWWIZARDGROUPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("896a43e6ab0ceb0a61a8a7cee7b0f27f");
            pSDEFieldModel.setName("PSVIEWWIZARDGROUPID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5411\u5bfc\u7ec4");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSVIEWWIZARDGROUPID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSViewWizardGroupId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSVIEWWIZARDGROUPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9ddc7b48e4068820e31343c2262ad83e");
            pSDEFieldModel.setName("PSVIEWWIZARDGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5411\u5bfc\u7ec4");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSVIEWWIZARDGROUPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSViewWizardGroupName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SHOWCAPTIONBAR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d95fa17e12df95fa94781c50384db1f9");
            pSDEFieldModel.setName("SHOWCAPTIONBAR");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u663e\u793a\u6807\u9898\u680f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("SHOWCAPTIONBAR");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ShowCaptionBar");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SUBCAPPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e2696ed109a0173b5c5fea4fb7d27592");
            pSDEFieldModel.setName("SUBCAPPSLANRESID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b50\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("SUBCAPPSLANRESID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("SubCapPSLanResId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SUBCAPPSLANRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3ab6cf7356f70383689a09442262bb7f");
            pSDEFieldModel.setName("SUBCAPPSLANRESNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b50\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("SUBCAPPSLANRESNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("SubCapPSLanResName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SUBCAPTION");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0ae071b8b9a251076c482652e10ab1bd");
            pSDEFieldModel.setName("SUBCAPTION");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5b50\u6807\u9898");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("SUBCAPTION");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("SubCaption");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SYNCCODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("78cda7f4afec3ef73afcdb16134478c3");
            pSDEFieldModel.setName("SYNCCODENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u540c\u6b65\u4ee3\u7801\u6807\u8bc6");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("SYNCCODENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("SyncCodeName");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SYSREFFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bb3deb73c67225681d9269fdcff6ce1d");
            pSDEFieldModel.setName("SYSREFFLAG");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u5f15\u7528\u6807\u5fd7");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("SYSREFFLAG");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColorCodeListModel");
            pSDEFieldModel.setCodeName("SysRefFlag");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TITLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e7696f2dd27d8b56003663f3aed53a65");
            pSDEFieldModel.setName("TITLE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u62ac\u5934");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("TITLE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("Title");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TITLEPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e84c890460c14b8533581b7d85cad7ff");
            pSDEFieldModel.setName("TITLEPSLANRESID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u62ac\u5934\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("TITLEPSLANRESID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("TitlePSLanResId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TITLEPSLANRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a947c96e49cac33c340445c02cc96fbf");
            pSDEFieldModel.setName("TITLEPSLANRESNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u62ac\u5934\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("TITLEPSLANRESNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("TitlePSLanResName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TODOTASK");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f264107d6ed92d20d468c87e2f6feb34");
            pSDEFieldModel.setName("TODOTASK");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("TODO");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("TODOTASK");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("ToDoTask");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UISTYLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("10b8f704b29c2f7289a98647db197733");
            pSDEFieldModel.setName("UISTYLE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5185\u5efa\u754c\u9762\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("UISTYLE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppUIStyleCodeListModel");
            pSDEFieldModel.setCodeName("UIStyle");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("697d438873247108e1c6f777d8829b9c");
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
            pSDEFieldModel.setId("9a36e3952805d6c3d6b6c2aa1419b56c");
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
            pSDEFieldModel.setId("acf0aad544a5c1557d81b5a7fc9ae7e4");
            pSDEFieldModel.setName("USERPARAMS");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u53c2\u6570");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("USERPARAMS");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("UserParams");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(2000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERREFFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fa187be981f57bc55c3d41e83a4144ad");
            pSDEFieldModel.setName("USERREFFLAG");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7528\u6237\u5f15\u7528\u6807\u5fd7");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("USERREFFLAG");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColor8CodeListModel");
            pSDEFieldModel.setCodeName("UserRefFlag");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("feb437aec77f854092f4267c99d9090a");
            pSDEFieldModel.setName("USERTAG");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb0");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("USERTAG");
            pSDEFieldModel.setPhisicalDEField(false);
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
            pSDEFieldModel.setId("9bfc5cf34d287cfa2cdb928110f3fb8b");
            pSDEFieldModel.setName("USERTAG2");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb02");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("USERTAG2");
            pSDEFieldModel.setPhisicalDEField(false);
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
            pSDEFieldModel.setId("68227f4af631002f7689e98218502e66");
            pSDEFieldModel.setName("USERTAG3");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb03");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("USERTAG3");
            pSDEFieldModel.setPhisicalDEField(false);
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
            pSDEFieldModel.setId("3f36551de58593042a818427bf219774");
            pSDEFieldModel.setName("USERTAG4");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb04");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPUTILVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("USERTAG4");
            pSDEFieldModel.setPhisicalDEField(false);
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
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSAppUtilViewDefaultACModel pSAppUtilViewDefaultACModel = new PSAppUtilViewDefaultACModel();
        pSAppUtilViewDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSAppUtilViewDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSAppUtilViewCurAppDSModel pSAppUtilViewCurAppDSModel = new PSAppUtilViewCurAppDSModel();
        pSAppUtilViewCurAppDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSAppUtilViewCurAppDSModel);
        PSAppUtilViewCurAppFuncDSModel pSAppUtilViewCurAppFuncDSModel = new PSAppUtilViewCurAppFuncDSModel();
        pSAppUtilViewCurAppFuncDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSAppUtilViewCurAppFuncDSModel);
        PSAppUtilViewDefaultDSModel pSAppUtilViewDefaultDSModel = new PSAppUtilViewDefaultDSModel();
        pSAppUtilViewDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSAppUtilViewDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSAppUtilViewCurAppDQModel pSAppUtilViewCurAppDQModel = new PSAppUtilViewCurAppDQModel();
        pSAppUtilViewCurAppDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSAppUtilViewCurAppDQModel);
        PSAppUtilViewCurAppFuncDQModel pSAppUtilViewCurAppFuncDQModel = new PSAppUtilViewCurAppFuncDQModel();
        pSAppUtilViewCurAppFuncDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSAppUtilViewCurAppFuncDQModel);
        PSAppUtilViewDefaultDQModel pSAppUtilViewDefaultDQModel = new PSAppUtilViewDefaultDQModel();
        pSAppUtilViewDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSAppUtilViewDefaultDQModel);
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
        this.registerPDTDEView("EDITVIEW", "33ab78017cd31ef3e93a4ab206d080d2");
        this.registerPDTDEView("MDATAVIEW", "0c61b352685083f376cbb0292b5dbcb5");
        this.registerPDTDEView("MPICKUPVIEW", "ea352d57dd8fa423b6f35923675a2c3e");
        this.registerPDTDEView("PICKUPVIEW", "66d8a8949e345991c3644cfcf7bc5604");
        this.registerPDTDEView("REDIRECTVIEW", "d8e4e842e0844018f0b5fc90659d9485");
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
        dEDataSetCond2.setDEFName("PSAPPUTILVIEWNAME");
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
        pSDEFGroupDetailModel.setId("fed2d60142c37d2b37c00d3b2345ea67");
        pSDEFGroupDetailModel.setName("ACCUSERMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("ACCUSERMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ViewAccessUsersCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ddc75f2d61bf7fcfe72ccd7bdc46cc6a");
        pSDEFGroupDetailModel.setName("APPVIEWSN");
        iPSDEFieldModel = this.getDEField("APPVIEWSN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("374e01f87155113f903123da2d0210b0");
        pSDEFGroupDetailModel.setName("CAPPSLANRESID");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2699c8fb2c7c0b5ec90c0cdb7e9646a3");
        pSDEFGroupDetailModel.setName("CAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0182d51059a9fc3220ee9a40b76af529");
        pSDEFGroupDetailModel.setName("CAPTION");
        iPSDEFieldModel = this.getDEField("CAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2d6d9f978faa98c06d7cd4ce96bd1b74");
        pSDEFGroupDetailModel.setName("ERRCODE");
        iPSDEFieldModel = this.getDEField("ERRCODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c5179216725106630a3564c39d602551");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("71e1fceae09e960da116acf69ead26a9");
        pSDEFGroupDetailModel.setName("PSACHANDLERID");
        iPSDEFieldModel = this.getDEField("PSACHANDLERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("fcd73a555dcfd504c64ce2121a212580");
        pSDEFGroupDetailModel.setName("PSACHANDLERNAME");
        iPSDEFieldModel = this.getDEField("PSACHANDLERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0dfa780263e6542ae64300a991a13304");
        pSDEFGroupDetailModel.setName("PSAPPMENUID");
        iPSDEFieldModel = this.getDEField("PSAPPMENUID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d9c50f154dbf8757002c74f60e15748c");
        pSDEFGroupDetailModel.setName("PSAPPMENUNAME");
        iPSDEFieldModel = this.getDEField("PSAPPMENUNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d11ef91cecdb49c352df7420f817de7d");
        pSDEFGroupDetailModel.setName("PSAPPMODULEID");
        iPSDEFieldModel = this.getDEField("PSAPPMODULEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f2782556255a7dfbb209a24815ecf79b");
        pSDEFGroupDetailModel.setName("PSAPPMODULENAME");
        iPSDEFieldModel = this.getDEField("PSAPPMODULENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f326f6675edad5abde7d982ad3841c90");
        pSDEFGroupDetailModel.setName("PSAPPTITLEBARID");
        iPSDEFieldModel = this.getDEField("PSAPPTITLEBARID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u529f\u80fd\u89c6\u56fe\u4f7f\u7528\u7684\u6807\u9898\u680f\u90e8\u4ef6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("df5eb8cac9fe73853ad88f5798dac621");
        pSDEFGroupDetailModel.setName("PSAPPTITLEBARNAME");
        iPSDEFieldModel = this.getDEField("PSAPPTITLEBARNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u529f\u80fd\u89c6\u56fe\u4f7f\u7528\u7684\u6807\u9898\u680f\u90e8\u4ef6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("84a1b020f65b9463490e1cf19e4553ba");
        pSDEFGroupDetailModel.setName("PSAPPUTILVIEWNAME");
        iPSDEFieldModel = this.getDEField("PSAPPUTILVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u529f\u80fd\u89c6\u56fe\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5728\u524d\u7aef\u5e94\u7528\u4e2d\u5177\u5907\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("aef52236ecb3c86e2d55a702d7049ce8");
        pSDEFGroupDetailModel.setName("PSAPPUTILVIEWTYPE");
        iPSDEFieldModel = this.getDEField("PSAPPUTILVIEWTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppUtilViewsCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u529f\u80fd\u89c6\u56fe\u7684\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4494337beb8a4314123c979703f3edeb");
        pSDEFGroupDetailModel.setName("PSPFSTYLEID");
        iPSDEFieldModel = this.getDEField("PSPFSTYLEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a54af7755193aa0644ff156fe7348a0f");
        pSDEFGroupDetailModel.setName("PSPFSTYLENAME");
        iPSDEFieldModel = this.getDEField("PSPFSTYLENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5307e32618df83a6830d42d72e720e8e");
        pSDEFGroupDetailModel.setName("PSSUBVIEWTYPEID");
        iPSDEFieldModel = this.getDEField("PSSUBVIEWTYPEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a24398a9e1e013b76ae351d68322fc72");
        pSDEFGroupDetailModel.setName("PSSUBVIEWTYPENAME");
        iPSDEFieldModel = this.getDEField("PSSUBVIEWTYPENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ffc9f408d5422969ac71ced7a0b5c302");
        pSDEFGroupDetailModel.setName("PSSYSAPPID");
        iPSDEFieldModel = this.getDEField("PSSYSAPPID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1e12356cd1ce2a63a024983aedc3df6a");
        pSDEFGroupDetailModel.setName("PSSYSAPPNAME");
        iPSDEFieldModel = this.getDEField("PSSYSAPPNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("936496e875cd2cff6aecf1e445ad977e");
        pSDEFGroupDetailModel.setName("PSSYSCSSID");
        iPSDEFieldModel = this.getDEField("PSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3c3a18ba1d449501468e326774493156");
        pSDEFGroupDetailModel.setName("PSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("PSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("85e5823079db971fff741c380ffcc3a3");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a30be6994b3c9927b5a9c321941a6212");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a41d3f355551fea898bc6eafe5197c7d");
        pSDEFGroupDetailModel.setName("PSSYSUNIRESID");
        iPSDEFieldModel = this.getDEField("PSSYSUNIRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("38981c877508d11716caf0564ba8c999");
        pSDEFGroupDetailModel.setName("PSSYSUNIRESNAME");
        iPSDEFieldModel = this.getDEField("PSSYSUNIRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d95fa17e12df95fa94781c50384db1f9");
        pSDEFGroupDetailModel.setName("SHOWCAPTIONBAR");
        iPSDEFieldModel = this.getDEField("SHOWCAPTIONBAR", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e2696ed109a0173b5c5fea4fb7d27592");
        pSDEFGroupDetailModel.setName("SUBCAPPSLANRESID");
        iPSDEFieldModel = this.getDEField("SUBCAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3ab6cf7356f70383689a09442262bb7f");
        pSDEFGroupDetailModel.setName("SUBCAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("SUBCAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0ae071b8b9a251076c482652e10ab1bd");
        pSDEFGroupDetailModel.setName("SUBCAPTION");
        iPSDEFieldModel = this.getDEField("SUBCAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e7696f2dd27d8b56003663f3aed53a65");
        pSDEFGroupDetailModel.setName("TITLE");
        iPSDEFieldModel = this.getDEField("TITLE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e84c890460c14b8533581b7d85cad7ff");
        pSDEFGroupDetailModel.setName("TITLEPSLANRESID");
        iPSDEFieldModel = this.getDEField("TITLEPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a947c96e49cac33c340445c02cc96fbf");
        pSDEFGroupDetailModel.setName("TITLEPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("TITLEPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("10b8f704b29c2f7289a98647db197733");
        pSDEFGroupDetailModel.setName("UISTYLE");
        iPSDEFieldModel = this.getDEField("UISTYLE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppUIStyleCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("fa187be981f57bc55c3d41e83a4144ad");
        pSDEFGroupDetailModel.setName("USERREFFLAG");
        iPSDEFieldModel = this.getDEField("USERREFFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColor8CodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

