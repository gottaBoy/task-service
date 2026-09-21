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
 *  net.ibizsys.paas.core.IDELogic
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
package net.ibizsys.pscore.srv.appdesign.demodel;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.IDEACMode;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDELogic;
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
import net.ibizsys.pscore.srv.appdesign.demodel.psappindexview.ac.PSAppIndexViewDefaultACModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psappindexview.dataquery.PSAppIndexViewCurAppDQModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psappindexview.dataquery.PSAppIndexViewCurModDQModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psappindexview.dataquery.PSAppIndexViewDefaultDQModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psappindexview.dataset.PSAppIndexViewCurAppDSModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psappindexview.dataset.PSAppIndexViewCurModDSModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psappindexview.dataset.PSAppIndexViewDefaultDSModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psappindexview.logic.PSAppIndexViewNode2ModLogicModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psappindexview.logic.PSAppIndexViewParent2AppLogicModel;
import net.ibizsys.pscore.srv.appdesign.demodel.psappindexview.uiaction.PSAppIndexViewJITPreviewUIActionModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewService;
import net.ibizsys.pscore.srv.core.IPSDEFGroupModel;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupDetailModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupModel;
import net.ibizsys.pscore.srv.core.PSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDataEntityModelBase;

public abstract class PSAppIndexViewDEModelBase
extends PSDataEntityModelBase<PSAppIndexView> {
    private PSCoreSysModel pSCoreSysModel;
    private PSAppIndexViewService pSAppIndexViewService;

    public PSAppIndexViewDEModelBase() throws Exception {
        this.setId("fda0cf7a290ea51975b76e16e3f3a416");
        this.setName("PSAPPINDEXVIEW");
        this.setCodeName("PSAppIndexView");
        this.setTableName("T_SRFPSAPPINDEXVIEW");
        this.setViewName("v_PSAPPINDEXVIEW");
        this.setLogicName("\u5e94\u7528\u9996\u9875\u89c6\u56fe");
        this.setMemo("\u5e94\u7528\u9996\u9875\u89c6\u56fe\u6a21\u578b\uff0c\u5e94\u7528\u9996\u9875\u89c6\u56fe\u4e00\u822c\u4f5c\u4e3a\u5e94\u7528\u7684\u8d77\u59cb\u89c6\u56fe\uff0c\u52a0\u8f7d\u4e3b\u83dc\u5355\uff0c\u63d0\u4f9b\u5e94\u7528\u529f\u80fd\u7684\u5165\u53e3");
        this.setDSLink("DEFAULT");
        this.setEnableMultiDS(true);
        this.setInheritDEId("7fb7186bc74741fbe7ee72bd472c5aa3");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setEnableTempData(true);
        this.setUserTag("MODELV2");
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppIndexViewDEModel", (IDataEntityModel)this);
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

    public PSAppIndexViewService getRealService() {
        if (this.pSAppIndexViewService == null) {
            try {
                this.pSAppIndexViewService = (PSAppIndexViewService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppIndexViewService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewService";
    }

    public PSAppIndexView createEntity() {
        return new PSAppIndexView();
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
            pSDEFieldModel.setId("72c86a6e330b18cf9cc2f070c1306d6b");
            pSDEFieldModel.setName("ACCUSERMODE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8bbf\u95ee\u7528\u6237\u6a21\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("ACCUSERMODE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ViewAccessUsersCodeListModel");
            pSDEFieldModel.setCodeName("AccUserMode");
            pSDEFieldModel.setLength(20);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("APPICONPATH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2276bb3f3a16825ceb0a26261a4bd537");
            pSDEFieldModel.setName("APPICONPATH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u56fe\u6807\u8def\u5f84");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("AppIconPath");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u7684\u56fe\u6807\u8def\u5f84");
            pSDEFieldModel.setLength(250);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("APPICONPATH2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("afaea870253c9b93cc649fb622e6f91f");
            pSDEFieldModel.setName("APPICONPATH2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u56fe\u6807\u8def\u5f842");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("AppIconPath2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u7684\u56fe\u6807\u8def\u5f842");
            pSDEFieldModel.setLength(250);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("APPSWITCHMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b8a0f293f4ee61c0277f069a903cb4fd");
            pSDEFieldModel.setName("APPSWITCHMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u9009\u62e9\u5668\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppSwitchModeCodeListModel");
            pSDEFieldModel.setCodeName("AppSwitchMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u7684\u5e94\u7528\u9009\u62e9\u5668\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_APPSWITCHMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_APPSWITCHMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("APPVIEWSN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5fc85198b7a5f3389399e3ceff059c06");
            pSDEFieldModel.setName("APPVIEWSN");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u89c6\u56fe\u7f16\u53f7");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("b6c452567700f520ea24864f6be5fda8");
            pSDEFieldModel.setName("APPVIEWSTATE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u89c6\u56fe\u72b6\u6001");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("APPVIEWSTATE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("AppViewState");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("BLANKMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7ed84244e0b36fe76c11fdbae93e731a");
            pSDEFieldModel.setName("BLANKMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7a7a\u767d\u9996\u9875\u6a21\u5f0f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("BlankMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u662f\u5426\u4e3a\u7a7a\u767d\u9996\u9875\u6a21\u5f0f\uff0c\u7a7a\u767d\u9996\u9875\u4f5c\u4e3a\u5b9e\u9645\u5185\u5bb9\u89c6\u56fe\u7684\u5bb9\u5668\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("BOTTOMSIDEPSAPPMENUID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0e53099d94aeb0379a2b3b2edf702a1e");
            pSDEFieldModel.setName("BOTTOMSIDEPSAPPMENUID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e0b\u8fb9\u680f\u5e94\u7528\u83dc\u5355");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPINDEXVIEW_PSAPPMENU_BOTTOMSIDEPSAPPMENUID");
            pSDEFieldModel.setLinkDEFName("PSAPPMENUID");
            pSDEFieldModel.setCodeName("BottomSidePSAppMenuId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_BOTTOMSIDEPSAPPMENUID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_BOTTOMSIDEPSAPPMENUID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("BOTTOMSIDEPSAPPMENUNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d8f9ba0cdb391fc6a5cda158d9fbd970");
            pSDEFieldModel.setName("BOTTOMSIDEPSAPPMENUNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u4e0b\u8fb9\u680f\u5e94\u7528\u83dc\u5355");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPINDEXVIEW_PSAPPMENU_BOTTOMSIDEPSAPPMENUID");
            pSDEFieldModel.setLinkDEFName("PSAPPMENUNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("BottomSidePSAppMenuName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_BOTTOMSIDEPSAPPMENUNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_BOTTOMSIDEPSAPPMENUNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_BOTTOMSIDEPSAPPMENUNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_BOTTOMSIDEPSAPPMENUNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
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
            pSDEFieldModel.setId("492bb43ea36212933c1b16e62fb2990f");
            pSDEFieldModel.setName("CAPPSLANRESID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("83c7a33c7b92ffbede9b26190f05fa0e");
            pSDEFieldModel.setName("CAPPSLANRESNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("6dc1b75766fc30d2cab6dd21d5af7a20");
            pSDEFieldModel.setName("CAPTION");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6807\u9898");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("f1e622bb0f14c584e9aa7eacda9546b3");
            pSDEFieldModel.setName("COLOR");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u989c\u8272");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("741095a6eafd81191eeb02b942823067");
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
            pSDEFieldModel.setId("cea23f099fc5009dffa453c6aed7b281");
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
        object = this.createDEField("DEFAULTPAGE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c711743d5d821f35c040995237444a09");
            pSDEFieldModel.setName("DEFAULTPAGE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u9ed8\u8ba4\u9875");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("DefaultPage");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u662f\u5426\u4e3a\u6240\u5c5e\u5e94\u7528\u7684\u9ed8\u8ba4\u9875\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFPSAPPVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("68970df5160badc0fe5a7fea69e9c63d");
            pSDEFieldModel.setName("DEFPSAPPVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPINDEXVIEW_PSAPPVIEW_DEFPSAPPVIEWID");
            pSDEFieldModel.setLinkDEFName("PSAPPVIEWID");
            pSDEFieldModel.setCodeName("DefPSAppViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEFPSAPPVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEFPSAPPVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFPSAPPVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b2ce005ca68bcf236aaeaf067b17a22f");
            pSDEFieldModel.setName("DEFPSAPPVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPINDEXVIEW_PSAPPVIEW_DEFPSAPPVIEWID");
            pSDEFieldModel.setLinkDEFName("PSAPPVIEWNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("DefPSAppViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u9ed8\u8ba4\u52a0\u8f7d\u7684\u5e94\u7528\u89c6\u56fe");
            pSDEFieldModel.setLength(80);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEFPSAPPVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEFPSAPPVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEFPSAPPVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEFPSAPPVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DYNAMODELFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("58d9a81905188d7ab34c4cbcbe6c57ec");
            pSDEFieldModel.setName("DYNAMODELFLAG");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u6a21\u578b\u7c7b\u578b");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("a41c457ec41df0ebfde1d80773302a28");
            pSDEFieldModel.setName("DYNCMODE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u4f18\u5148\u7ea7");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
        object = this.createDEField("ENABLECOUNTER");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ab0f905fc5abc38429d3c1e4c3aa74e1");
            pSDEFieldModel.setName("ENABLECOUNTER");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u8ba1\u6570\u5668");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableCounter");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u662f\u5426\u542f\u7528\u754c\u9762\u8ba1\u6570\u5668\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u662f\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLEVIEWSTYLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c6d1d177954ef0a9df52313f98f41917");
            pSDEFieldModel.setName("ENABLEVIEWSTYLE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u542f\u7528\u89c6\u56fe\u7ea7\u522b\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("ENABLEVIEWSTYLE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableViewStyle");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u89c6\u56fe\u662f\u5426\u542f\u7528\u89c6\u56fe\u7ea7\u522b\u754c\u9762\u6837\u5f0f\uff0c\u672a\u5b9a\u4e49\u662f\u4e3a\u3010\u5426\u3011\uff0c\u6b64\u914d\u7f6e\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LAYOUTPANELMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8b14016e936b187f0385bce327e34c8f");
            pSDEFieldModel.setName("LAYOUTPANELMODE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e03\u5c40\u9762\u677f\u5e94\u7528\u6a21\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("LAYOUTPANELMODE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ViewLayoutPanelModeCodeListModel");
            pSDEFieldModel.setCodeName("LayoutPanelMode");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LEFTSIDEPSAPPMENUID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("17a821922270665b52e75e0470f70852");
            pSDEFieldModel.setName("LEFTSIDEPSAPPMENUID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5de6\u8fb9\u680f\u5e94\u7528\u83dc\u5355");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPINDEXVIEW_PSAPPMENU_LEFTSIDEPSAPPMENUID");
            pSDEFieldModel.setLinkDEFName("PSAPPMENUID");
            pSDEFieldModel.setCodeName("LeftSidePSAppMenuId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LEFTSIDEPSAPPMENUID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LEFTSIDEPSAPPMENUID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LEFTSIDEPSAPPMENUNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4849c91ac169ee0c2969d01337fb7e0f");
            pSDEFieldModel.setName("LEFTSIDEPSAPPMENUNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5de6\u8fb9\u680f\u5e94\u7528\u83dc\u5355");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPINDEXVIEW_PSAPPMENU_LEFTSIDEPSAPPMENUID");
            pSDEFieldModel.setLinkDEFName("PSAPPMENUNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("LeftSidePSAppMenuName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LEFTSIDEPSAPPMENUNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LEFTSIDEPSAPPMENUNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LEFTSIDEPSAPPMENUNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LEFTSIDEPSAPPMENUNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MAINMENUSIDE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("eda4685b3df0107cbc00e5a7f7e956f2");
            pSDEFieldModel.setName("MAINMENUSIDE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u83dc\u5355\u65b9\u5411");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppIndexViewMenuAlignCodeListModel");
            pSDEFieldModel.setCodeName("MainMenuSide");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u4e3b\u83dc\u5355\u7684\u65b9\u5411");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MAINMENUSIDE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MAINMENUSIDE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
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
            pSDEFieldModel.setId("6bedf3a982fd2054e5915db79c2aa263");
            pSDEFieldModel.setName("MEMO");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5907\u6ce8");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("MEMO");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("Memo");
            pSDEFieldModel.setLength(2000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MENUMODEL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c65b42aa973e6ac5064af8a25dcea6bb");
            pSDEFieldModel.setName("MENUMODEL");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u83dc\u5355\u6a21\u578b");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MenuModel");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MODCOLOR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fd287142f7b9a14d936a43c3e0a87528");
            pSDEFieldModel.setName("MODCOLOR");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6a21\u5757\u989c\u8272");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("8dc225f859ef5e40c495532007072f41");
            pSDEFieldModel.setName("PREVENTXSS");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u9632\u6b62XSS\u653b\u51fb");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("edd9fd9a62ec4b3d057516bc67a7e1a2");
            pSDEFieldModel.setName("PSACHANDLERID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u540e\u53f0\u5904\u7406\u5bf9\u8c61");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("69fe639229a95e2dbb457c6a8ad90834");
            pSDEFieldModel.setName("PSACHANDLERNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5904\u7406\u5bf9\u8c61");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSACHANDLERNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSACHandlerName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPINDEXVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2ce814ebbcab751949d4351f47e72102");
            pSDEFieldModel.setName("PSAPPINDEXVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u9996\u9875\u89c6\u56fe\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSAppIndexViewId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPINDEXVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3b986f4536e070d509393a6e66e1071a");
            pSDEFieldModel.setName("PSAPPINDEXVIEWNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSAppIndexViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5728\u524d\u7aef\u5e94\u7528\u4e2d\u5177\u5907\u552f\u4e00\u6027");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPINDEXVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPINDEXVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSAPPINDEXVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSAPPINDEXVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPLOCALDEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("003948eb1e53a93f4340f621908f64c7");
            pSDEFieldModel.setName("PSAPPLOCALDEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u5b9e\u4f53");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("e5889d19778d116a7e48cc8c874bcdb6");
            pSDEFieldModel.setName("PSAPPLOCALDENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u5b9e\u4f53");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("1adc719bd274ee2cbfb8068687690679");
            pSDEFieldModel.setName("PSAPPMENUID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u83dc\u5355");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPINDEXVIEW_PSAPPMENU_PSAPPMENUID");
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
            pSDEFieldModel.setId("29471764591eb589dbdf04ead6942d19");
            pSDEFieldModel.setName("PSAPPMENUNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u83dc\u5355");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPINDEXVIEW_PSAPPMENU_PSAPPMENUID");
            pSDEFieldModel.setLinkDEFName("PSAPPMENUNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSAppMenuName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u52a0\u8f7d\u7684\u5e94\u7528\u83dc\u5355");
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
            pSDEFieldModel.setId("af30b350c2fc32c5a714590e95ea817d");
            pSDEFieldModel.setName("PSAPPMODULEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6a21\u5757");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("9e66ee228e9c67b2f26208b3e37ca603");
            pSDEFieldModel.setName("PSAPPMODULENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6a21\u5757");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("a2037180ab167a3ac48c5854aaa89aad");
            pSDEFieldModel.setName("PSAPPTITLEBARID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6807\u9898\u680f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("78685012a622935b1fce28625de955f8");
            pSDEFieldModel.setName("PSAPPTITLEBARNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6807\u9898\u680f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSAPPTITLEBARNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSAppTitleBarName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u4f7f\u7528\u7684\u6807\u9898\u680f\u90e8\u4ef6");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPUTILVIEWTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("26684bcc3e096df5c9ce2e4150e377a5");
            pSDEFieldModel.setName("PSAPPUTILVIEWTYPE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u529f\u80fd\u89c6\u56fe\u7c7b\u578b");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSAPPUTILVIEWTYPE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppUtilViewsCodeListModel");
            pSDEFieldModel.setCodeName("PSAppUtilViewType");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPVIEWSTYLEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9441abb0662a28dfb5f737aec4d4ecf7");
            pSDEFieldModel.setName("PSAPPVIEWSTYLEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u89c6\u56fe\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("5ad47da6526e2a34f2be0cddd804cda8");
            pSDEFieldModel.setName("PSAPPVIEWSTYLENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u89c6\u56fe\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("67d1d606a59abd4640dc3719085f1a2b");
            pSDEFieldModel.setName("PSAPPVIEWTYPE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u89c6\u56fe\u7c7b\u578b");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("bb4e3cc1c12c72a8a43421241f7e5a08");
            pSDEFieldModel.setName("PSCTRLLOGICGROUPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u754c\u9762\u903b\u8f91\u7ec4");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("e57d9f2ea34dbe3b560c405cc0bd3633");
            pSDEFieldModel.setName("PSCTRLLOGICGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u754c\u9762\u903b\u8f91\u7ec4");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("557203851c73d370f4b695fbd747924d");
            pSDEFieldModel.setName("PSDEVIEWBASEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u89c6\u56fe");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("74bb65e0d432f469a90471e62ccfcece");
            pSDEFieldModel.setName("PSDEVIEWBASENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u89c6\u56fe");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("60ea28f5a847816cc3869961a834171c");
            pSDEFieldModel.setName("PSDEVIEWTYPE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u89c6\u56fe\u7c7b\u578b");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWTYPE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEViewType2CodeListModel");
            pSDEFieldModel.setCodeName("PSDEViewType");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDYNADEVIEWTEMPLID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("44cca8c4d732e4e0b5d0ac014d42b22c");
            pSDEFieldModel.setName("PSDYNADEVIEWTEMPLID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u5b9e\u4f53\u6a21\u677f\u89c6\u56fe");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSDYNADEVIEWTEMPLID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDynaDEViewTemplId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDYNADEVIEWTEMPLNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("90a2e1412ef0ab20ab3cd121f958e25c");
            pSDEFieldModel.setName("PSDYNADEVIEWTEMPLNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u5b9e\u4f53\u6a21\u677f\u89c6\u56fe");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("2e75eaccf9c2f869f9c8bc5f56b4c9da");
            pSDEFieldModel.setName("PSDYNADEVIEWTYPE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u5b9e\u4f53\u89c6\u56fe\u7c7b\u578b");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSDYNADEVIEWTYPE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DynaDEViewTypesCodeListModel");
            pSDEFieldModel.setCodeName("PSDynaDEViewType");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDYNAINSTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3f6757814fa3132a7149e1b0c0c88659");
            pSDEFieldModel.setName("PSDYNAINSTID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("PSDYNAINSTID");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("57910a77232539d42a0869fdbb4f9f15");
            pSDEFieldModel.setName("PSHELPMODULEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5e2e\u52a9");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("49eaa0ab9c60a0c00b2dc7cc7a24ec22");
            pSDEFieldModel.setName("PSHELPMODULENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5e2e\u52a9");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("b4699f06efd338ec79ef2c31aea8727f");
            pSDEFieldModel.setName("PSPFID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6a21\u677f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("d8d4e81a03ba5dcefed157b551cb8cb7");
            pSDEFieldModel.setName("PSPFSTYLEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("01d5e18d736c8e34b995cfe10b03fbe1");
            pSDEFieldModel.setName("PSPFSTYLENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("d7d85d36ba4760710104d13bc96fc6ce");
            pSDEFieldModel.setName("PSSUBVIEWTYPEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u89c6\u56fe\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("3fd360c0eec876fc5439248616690f10");
            pSDEFieldModel.setName("PSSUBVIEWTYPENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u89c6\u56fe\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("8c978367c6bf3c679372f6dddae7d12b");
            pSDEFieldModel.setName("PSSYSAPPID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u5e94\u7528");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSAPPID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
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
            pSDEFieldModel.setId("8e247d219fcd9aebbed6dcc02d6d8359");
            pSDEFieldModel.setName("PSSYSAPPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u5e94\u7528");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSSYSAPPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSSysAppName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSCOUNTERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6c1c634572e7ecb079b8a68e2b206f18");
            pSDEFieldModel.setName("PSSYSCOUNTERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u754c\u9762\u8ba1\u6570\u5668");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPINDEXVIEW_PSSYSCOUNTER_PSSYSCOUNTERID");
            pSDEFieldModel.setLinkDEFName("PSSYSCOUNTERID");
            pSDEFieldModel.setCodeName("PSSysCounterId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSCOUNTERID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSCOUNTERID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSCOUNTERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("86940f1cdca6d1d8ecf244e0a6b85b7f");
            pSDEFieldModel.setName("PSSYSCOUNTERNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u754c\u9762\u8ba1\u6570\u5668");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPINDEXVIEW_PSSYSCOUNTER_PSSYSCOUNTERID");
            pSDEFieldModel.setLinkDEFName("PSSYSCOUNTERNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysCounterName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u52a0\u8f7d\u7684\u754c\u9762\u8ba1\u6570\u5668");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSCOUNTERNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSCOUNTERNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSCOUNTERNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSCOUNTERNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSCSSID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("278a8f2285aec5871548e389f4f915be");
            pSDEFieldModel.setName("PSSYSCSSID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u754c\u9762\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("2c29c2293c1be9d97cbc7d6eadd6a7e3");
            pSDEFieldModel.setName("PSSYSCSSNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u754c\u9762\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("5fdb3c56c6515ae8c8bbb5f313164b20");
            pSDEFieldModel.setName("PSSYSDYNAMODELID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6269\u5c55\u52a8\u6001\u6a21\u578b");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("405feac19822e4e3320d7bbbeae50c83");
            pSDEFieldModel.setName("PSSYSDYNAMODELNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6269\u5c55\u52a8\u6001\u6a21\u578b");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("755e967d613d6656f5f777087fc60e4f");
            pSDEFieldModel.setName("PSSYSIMAGEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u56fe\u6807");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("70fec232169ca5f22a5783649d345cf1");
            pSDEFieldModel.setName("PSSYSIMAGENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u56fe\u6807");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("9d6959c25dbfb767ea113b5f31d7bae2");
            pSDEFieldModel.setName("PSSYSREQITEMID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8bbe\u8ba1\u9700\u6c42");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("dba459ae9dc545c314994601ad5167bd");
            pSDEFieldModel.setName("PSSYSREQITEMNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8bbe\u8ba1\u9700\u6c42");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("89d10762c13fc02bbd0bf531c6229aec");
            pSDEFieldModel.setName("PSSYSTEMID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("e25fc69751dea23d21fc1e30d6e91da6");
            pSDEFieldModel.setName("PSSYSUNIRESID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("c91d564221fd38afaf38d2dc592f866a");
            pSDEFieldModel.setName("PSSYSUNIRESNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("6ec5f5da8c22e3fe96dabf1d0ac16b5d");
            pSDEFieldModel.setName("PSSYSVIEWPANELID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5e03\u5c40\u9762\u677f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("e8938ab195bcfd263fb8d66b4e0b2c95");
            pSDEFieldModel.setName("PSSYSVIEWPANELNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5e03\u5c40\u9762\u677f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("1afffb7fa8007aee24679790ba0bde6e");
            pSDEFieldModel.setName("PSVIEWENGINEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5f15\u64ce");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("4445442715efc4922a823edd873df96e");
            pSDEFieldModel.setName("PSVIEWENGINENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5f15\u64ce");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("141aef818ff173567a91982078540b21");
            pSDEFieldModel.setName("PSVIEWMSGGROUPID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6d88\u606f\u7ec4");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("30348e168c42975f2d1139c1767817fe");
            pSDEFieldModel.setName("PSVIEWMSGGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6d88\u606f\u7ec4");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("c9265fe27cf5a36656209593f16d8111");
            pSDEFieldModel.setName("PSVIEWWIZARDGROUPID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5411\u5bfc\u7ec4");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("56721a4917b44f9a2e12207446b5e1c6");
            pSDEFieldModel.setName("PSVIEWWIZARDGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5411\u5bfc\u7ec4");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("PSVIEWWIZARDGROUPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSViewWizardGroupName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RIGHTSIDEPSAPPMENUID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5892486d8e62e66b4fdd31afc2fe3d89");
            pSDEFieldModel.setName("RIGHTSIDEPSAPPMENUID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u53f3\u8fb9\u680f\u5e94\u7528\u83dc\u5355");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPINDEXVIEW_PSAPPMENU_RIGHTSIDEPSAPPMENUID");
            pSDEFieldModel.setLinkDEFName("PSAPPMENUID");
            pSDEFieldModel.setCodeName("RightSidePSAppMenuId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_RIGHTSIDEPSAPPMENUID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_RIGHTSIDEPSAPPMENUID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RIGHTSIDEPSAPPMENUNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8513558f2f8b0ad1dfc874c33adedfb5");
            pSDEFieldModel.setName("RIGHTSIDEPSAPPMENUNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u53f3\u8fb9\u680f\u5e94\u7528\u83dc\u5355");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPINDEXVIEW_PSAPPMENU_RIGHTSIDEPSAPPMENUID");
            pSDEFieldModel.setLinkDEFName("PSAPPMENUNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RightSidePSAppMenuName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_RIGHTSIDEPSAPPMENUNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_RIGHTSIDEPSAPPMENUNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_RIGHTSIDEPSAPPMENUNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_RIGHTSIDEPSAPPMENUNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SHOWCAPTIONBAR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fc628f024fb16b34a2e903dd0daaccab");
            pSDEFieldModel.setName("SHOWCAPTIONBAR");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u663e\u793a\u6807\u9898\u680f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("1e4f5a03fb1d3cd992df0d2905b35374");
            pSDEFieldModel.setName("SUBCAPPSLANRESID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b50\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("8029697301912d94a2eb765c5a5ef38d");
            pSDEFieldModel.setName("SUBCAPPSLANRESNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b50\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("1f5ed828e5633f5bdfe4d0492c6386e2");
            pSDEFieldModel.setName("SUBCAPTION");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5b50\u6807\u9898");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("161f376e8835b5d37aee7f8ecf6abccc");
            pSDEFieldModel.setName("SYNCCODENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u540c\u6b65\u4ee3\u7801\u6807\u8bc6");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("dd88840eb81dc77a5e4f8d64a3d49301");
            pSDEFieldModel.setName("SYSREFFLAG");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u5f15\u7528\u6807\u5fd7");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("SYSREFFLAG");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColorCodeListModel");
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("SysRefFlag");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TITLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a4b0ab161f2cec879b3a8fe63aec6f0a");
            pSDEFieldModel.setName("TITLE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u62ac\u5934");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("a9164c8bdac337a3390a796f12ec24e5");
            pSDEFieldModel.setName("TITLEPSLANRESID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u62ac\u5934\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("e94a06dc1be949b00aac6158db0a4ed9");
            pSDEFieldModel.setName("TITLEPSLANRESNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u62ac\u5934\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("4257de4b23ac45129e7f768e70782507");
            pSDEFieldModel.setName("TODOTASK");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("TODO");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
            pSDEFieldModel.setLinkDEFName("TODOTASK");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("ToDoTask");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TOPSIDEPSAPPMENUID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("62cb4baed2a9cc93cdfbb49417b42d93");
            pSDEFieldModel.setName("TOPSIDEPSAPPMENUID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e0a\u8fb9\u680f\u5e94\u7528\u83dc\u5355");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPINDEXVIEW_PSAPPMENU_TOPSIDEPSAPPMENUID");
            pSDEFieldModel.setLinkDEFName("PSAPPMENUID");
            pSDEFieldModel.setCodeName("TopSidePSAppMenuId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TOPSIDEPSAPPMENUID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TOPSIDEPSAPPMENUID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TOPSIDEPSAPPMENUNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("755c52cb36d8071c59f80df0ec57c122");
            pSDEFieldModel.setName("TOPSIDEPSAPPMENUNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u4e0a\u8fb9\u680f\u5e94\u7528\u83dc\u5355");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSAPPINDEXVIEW_PSAPPMENU_TOPSIDEPSAPPMENUID");
            pSDEFieldModel.setLinkDEFName("PSAPPMENUNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("TopSidePSAppMenuName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TOPSIDEPSAPPMENUNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TOPSIDEPSAPPMENUNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TOPSIDEPSAPPMENUNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TOPSIDEPSAPPMENUNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UISTYLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("33e9474b8a22d57beb42e9180db2653f");
            pSDEFieldModel.setName("UISTYLE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5185\u5efa\u754c\u9762\u6837\u5f0f");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("a67ae34ae2f7d5d4d653925af95c4dea");
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
            pSDEFieldModel.setId("88a32705523c5258212cc97d172186e7");
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
            pSDEFieldModel.setId("456703d986e87629b5c634ea50d41dc2");
            pSDEFieldModel.setName("USERPARAMS");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u53c2\u6570");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("de25811145164318cb7cab127fbc3f26");
            pSDEFieldModel.setName("USERREFFLAG");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7528\u6237\u5f15\u7528\u6807\u5fd7");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("a887bd1e11700b2da4078fd9cc95240e");
            pSDEFieldModel.setName("USERTAG");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb0");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("90ce6a41b1fcdc6877ad1e19aab53cca");
            pSDEFieldModel.setName("USERTAG2");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb02");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("3a05605a62d455ebcc5f4675bb9e0284");
            pSDEFieldModel.setName("USERTAG3");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb03");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
            pSDEFieldModel.setId("fbba1b1f52aecd77ec3f15c5f2496700");
            pSDEFieldModel.setName("USERTAG4");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb04");
            pSDEFieldModel.setDataType("INHERIT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setInheritDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DERINHERIT_PSAPPINDEXVIEW_PSAPPVIEW");
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
        PSAppIndexViewDefaultACModel pSAppIndexViewDefaultACModel = new PSAppIndexViewDefaultACModel();
        pSAppIndexViewDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSAppIndexViewDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSAppIndexViewCurAppDSModel pSAppIndexViewCurAppDSModel = new PSAppIndexViewCurAppDSModel();
        pSAppIndexViewCurAppDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSAppIndexViewCurAppDSModel);
        PSAppIndexViewCurModDSModel pSAppIndexViewCurModDSModel = new PSAppIndexViewCurModDSModel();
        pSAppIndexViewCurModDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSAppIndexViewCurModDSModel);
        PSAppIndexViewDefaultDSModel pSAppIndexViewDefaultDSModel = new PSAppIndexViewDefaultDSModel();
        pSAppIndexViewDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSAppIndexViewDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSAppIndexViewCurAppDQModel pSAppIndexViewCurAppDQModel = new PSAppIndexViewCurAppDQModel();
        pSAppIndexViewCurAppDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSAppIndexViewCurAppDQModel);
        PSAppIndexViewCurModDQModel pSAppIndexViewCurModDQModel = new PSAppIndexViewCurModDQModel();
        pSAppIndexViewCurModDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSAppIndexViewCurModDQModel);
        PSAppIndexViewDefaultDQModel pSAppIndexViewDefaultDQModel = new PSAppIndexViewDefaultDQModel();
        pSAppIndexViewDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSAppIndexViewDefaultDQModel);
    }

    protected void prepareDEActions() throws Exception {
    }

    protected void prepareDELogics() throws Exception {
        PSAppIndexViewNode2ModLogicModel pSAppIndexViewNode2ModLogicModel = new PSAppIndexViewNode2ModLogicModel();
        pSAppIndexViewNode2ModLogicModel.init((IDataEntity)this);
        this.registerDELogic((IDELogic)pSAppIndexViewNode2ModLogicModel);
        PSAppIndexViewParent2AppLogicModel pSAppIndexViewParent2AppLogicModel = new PSAppIndexViewParent2AppLogicModel();
        pSAppIndexViewParent2AppLogicModel.init((IDataEntity)this);
        this.registerDELogic((IDELogic)pSAppIndexViewParent2AppLogicModel);
    }

    @Override
    protected void onPrepareDEUIActions() throws Exception {
        PSAppIndexViewJITPreviewUIActionModel pSAppIndexViewJITPreviewUIActionModel = new PSAppIndexViewJITPreviewUIActionModel();
        pSAppIndexViewJITPreviewUIActionModel.init((IDataEntity)this);
        this.registerDEUIAction((IDEUIAction)pSAppIndexViewJITPreviewUIActionModel);
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
        this.registerPDTDEView("EDITVIEW", "f018a56e5b145f1097eb6afd70e98357");
        this.registerPDTDEView("MPICKUPVIEW", "000879e554380f478e09d3ccd5b98a47");
        this.registerPDTDEView("PICKUPVIEW", "f41c91d9b5e0c4402469f27e01664152");
        this.registerPDTDEView("REDIRECTVIEW", "2938564db70460d0a2d38e43a92abf68");
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
        dEDataSetCond2.setDEFName("CAPTION");
        dEDataSetCond2.setCondValue(string);
        dEDataSetCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)dEDataSetCond2);
        dEDataSetCond2 = new DEDataSetCond();
        dEDataSetCond2.setCondType("DEFIELD");
        dEDataSetCond2.setCondOp("LIKE");
        dEDataSetCond2.setDEFName("PSAPPINDEXVIEWNAME");
        dEDataSetCond2.setCondValue(string);
        dEDataSetCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)dEDataSetCond2);
        dEDataSetCond2 = new DEDataSetCond();
        dEDataSetCond2.setCondType("DEFIELD");
        dEDataSetCond2.setCondOp("LIKE");
        dEDataSetCond2.setDEFName("TITLE");
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
        pSDEFGroupDetailModel.setId("72c86a6e330b18cf9cc2f070c1306d6b");
        pSDEFGroupDetailModel.setName("ACCUSERMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("ACCUSERMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ViewAccessUsersCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2276bb3f3a16825ceb0a26261a4bd537");
        pSDEFGroupDetailModel.setName("APPICONPATH");
        iPSDEFieldModel = this.getDEField("APPICONPATH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u7684\u56fe\u6807\u8def\u5f84");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("afaea870253c9b93cc649fb622e6f91f");
        pSDEFGroupDetailModel.setName("APPICONPATH2");
        iPSDEFieldModel = this.getDEField("APPICONPATH2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u7684\u56fe\u6807\u8def\u5f842");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b8a0f293f4ee61c0277f069a903cb4fd");
        pSDEFGroupDetailModel.setName("APPSWITCHMODE");
        iPSDEFieldModel = this.getDEField("APPSWITCHMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppSwitchModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u7684\u5e94\u7528\u9009\u62e9\u5668\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5fc85198b7a5f3389399e3ceff059c06");
        pSDEFGroupDetailModel.setName("APPVIEWSN");
        iPSDEFieldModel = this.getDEField("APPVIEWSN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7ed84244e0b36fe76c11fdbae93e731a");
        pSDEFGroupDetailModel.setName("BLANKMODE");
        iPSDEFieldModel = this.getDEField("BLANKMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u662f\u5426\u4e3a\u7a7a\u767d\u9996\u9875\u6a21\u5f0f\uff0c\u7a7a\u767d\u9996\u9875\u4f5c\u4e3a\u5b9e\u9645\u5185\u5bb9\u89c6\u56fe\u7684\u5bb9\u5668\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("492bb43ea36212933c1b16e62fb2990f");
        pSDEFGroupDetailModel.setName("CAPPSLANRESID");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("83c7a33c7b92ffbede9b26190f05fa0e");
        pSDEFGroupDetailModel.setName("CAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dc1b75766fc30d2cab6dd21d5af7a20");
        pSDEFGroupDetailModel.setName("CAPTION");
        iPSDEFieldModel = this.getDEField("CAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("68970df5160badc0fe5a7fea69e9c63d");
        pSDEFGroupDetailModel.setName("DEFPSAPPVIEWID");
        iPSDEFieldModel = this.getDEField("DEFPSAPPVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u9ed8\u8ba4\u52a0\u8f7d\u7684\u5e94\u7528\u89c6\u56fe");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b2ce005ca68bcf236aaeaf067b17a22f");
        pSDEFGroupDetailModel.setName("DEFPSAPPVIEWNAME");
        iPSDEFieldModel = this.getDEField("DEFPSAPPVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u9ed8\u8ba4\u52a0\u8f7d\u7684\u5e94\u7528\u89c6\u56fe");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c711743d5d821f35c040995237444a09");
        pSDEFGroupDetailModel.setName("DEFAULTPAGE");
        iPSDEFieldModel = this.getDEField("DEFAULTPAGE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u662f\u5426\u4e3a\u6240\u5c5e\u5e94\u7528\u7684\u9ed8\u8ba4\u9875\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a41c457ec41df0ebfde1d80773302a28");
        pSDEFGroupDetailModel.setName("DYNCMODE");
        iPSDEFieldModel = this.getDEField("DYNCMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab0f905fc5abc38429d3c1e4c3aa74e1");
        pSDEFGroupDetailModel.setName("ENABLECOUNTER");
        iPSDEFieldModel = this.getDEField("ENABLECOUNTER", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u662f\u5426\u542f\u7528\u754c\u9762\u8ba1\u6570\u5668\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c6d1d177954ef0a9df52313f98f41917");
        pSDEFGroupDetailModel.setName("ENABLEVIEWSTYLE");
        iPSDEFieldModel = this.getDEField("ENABLEVIEWSTYLE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u89c6\u56fe\u662f\u5426\u542f\u7528\u89c6\u56fe\u7ea7\u522b\u754c\u9762\u6837\u5f0f\uff0c\u672a\u5b9a\u4e49\u662f\u4e3a\u3010\u5426\u3011\uff0c\u6b64\u914d\u7f6e\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eda4685b3df0107cbc00e5a7f7e956f2");
        pSDEFGroupDetailModel.setName("MAINMENUSIDE");
        iPSDEFieldModel = this.getDEField("MAINMENUSIDE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppIndexViewMenuAlignCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u4e3b\u83dc\u5355\u7684\u65b9\u5411");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6bedf3a982fd2054e5915db79c2aa263");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("edd9fd9a62ec4b3d057516bc67a7e1a2");
        pSDEFGroupDetailModel.setName("PSACHANDLERID");
        iPSDEFieldModel = this.getDEField("PSACHANDLERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("69fe639229a95e2dbb457c6a8ad90834");
        pSDEFGroupDetailModel.setName("PSACHANDLERNAME");
        iPSDEFieldModel = this.getDEField("PSACHANDLERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3b986f4536e070d509393a6e66e1071a");
        pSDEFGroupDetailModel.setName("PSAPPINDEXVIEWNAME");
        iPSDEFieldModel = this.getDEField("PSAPPINDEXVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5728\u524d\u7aef\u5e94\u7528\u4e2d\u5177\u5907\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1adc719bd274ee2cbfb8068687690679");
        pSDEFGroupDetailModel.setName("PSAPPMENUID");
        iPSDEFieldModel = this.getDEField("PSAPPMENUID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u52a0\u8f7d\u7684\u5e94\u7528\u83dc\u5355");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("29471764591eb589dbdf04ead6942d19");
        pSDEFGroupDetailModel.setName("PSAPPMENUNAME");
        iPSDEFieldModel = this.getDEField("PSAPPMENUNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u52a0\u8f7d\u7684\u5e94\u7528\u83dc\u5355");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("af30b350c2fc32c5a714590e95ea817d");
        pSDEFGroupDetailModel.setName("PSAPPMODULEID");
        iPSDEFieldModel = this.getDEField("PSAPPMODULEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9e66ee228e9c67b2f26208b3e37ca603");
        pSDEFGroupDetailModel.setName("PSAPPMODULENAME");
        iPSDEFieldModel = this.getDEField("PSAPPMODULENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a2037180ab167a3ac48c5854aaa89aad");
        pSDEFGroupDetailModel.setName("PSAPPTITLEBARID");
        iPSDEFieldModel = this.getDEField("PSAPPTITLEBARID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u4f7f\u7528\u7684\u6807\u9898\u680f\u90e8\u4ef6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("78685012a622935b1fce28625de955f8");
        pSDEFGroupDetailModel.setName("PSAPPTITLEBARNAME");
        iPSDEFieldModel = this.getDEField("PSAPPTITLEBARNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u4f7f\u7528\u7684\u6807\u9898\u680f\u90e8\u4ef6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("67d1d606a59abd4640dc3719085f1a2b");
        pSDEFGroupDetailModel.setName("PSAPPVIEWTYPE");
        iPSDEFieldModel = this.getDEField("PSAPPVIEWTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("57910a77232539d42a0869fdbb4f9f15");
        pSDEFGroupDetailModel.setName("PSHELPMODULEID");
        iPSDEFieldModel = this.getDEField("PSHELPMODULEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49eaa0ab9c60a0c00b2dc7cc7a24ec22");
        pSDEFGroupDetailModel.setName("PSHELPMODULENAME");
        iPSDEFieldModel = this.getDEField("PSHELPMODULENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d8d4e81a03ba5dcefed157b551cb8cb7");
        pSDEFGroupDetailModel.setName("PSPFSTYLEID");
        iPSDEFieldModel = this.getDEField("PSPFSTYLEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01d5e18d736c8e34b995cfe10b03fbe1");
        pSDEFGroupDetailModel.setName("PSPFSTYLENAME");
        iPSDEFieldModel = this.getDEField("PSPFSTYLENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d7d85d36ba4760710104d13bc96fc6ce");
        pSDEFGroupDetailModel.setName("PSSUBVIEWTYPEID");
        iPSDEFieldModel = this.getDEField("PSSUBVIEWTYPEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3fd360c0eec876fc5439248616690f10");
        pSDEFGroupDetailModel.setName("PSSUBVIEWTYPENAME");
        iPSDEFieldModel = this.getDEField("PSSUBVIEWTYPENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8c978367c6bf3c679372f6dddae7d12b");
        pSDEFGroupDetailModel.setName("PSSYSAPPID");
        iPSDEFieldModel = this.getDEField("PSSYSAPPID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8e247d219fcd9aebbed6dcc02d6d8359");
        pSDEFGroupDetailModel.setName("PSSYSAPPNAME");
        iPSDEFieldModel = this.getDEField("PSSYSAPPNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6c1c634572e7ecb079b8a68e2b206f18");
        pSDEFGroupDetailModel.setName("PSSYSCOUNTERID");
        iPSDEFieldModel = this.getDEField("PSSYSCOUNTERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u52a0\u8f7d\u7684\u754c\u9762\u8ba1\u6570\u5668");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("86940f1cdca6d1d8ecf244e0a6b85b7f");
        pSDEFGroupDetailModel.setName("PSSYSCOUNTERNAME");
        iPSDEFieldModel = this.getDEField("PSSYSCOUNTERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5e94\u7528\u9996\u9875\u89c6\u56fe\u52a0\u8f7d\u7684\u754c\u9762\u8ba1\u6570\u5668");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("278a8f2285aec5871548e389f4f915be");
        pSDEFGroupDetailModel.setName("PSSYSCSSID");
        iPSDEFieldModel = this.getDEField("PSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2c29c2293c1be9d97cbc7d6eadd6a7e3");
        pSDEFGroupDetailModel.setName("PSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("PSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5fdb3c56c6515ae8c8bbb5f313164b20");
        pSDEFGroupDetailModel.setName("PSSYSDYNAMODELID");
        iPSDEFieldModel = this.getDEField("PSSYSDYNAMODELID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("405feac19822e4e3320d7bbbeae50c83");
        pSDEFGroupDetailModel.setName("PSSYSDYNAMODELNAME");
        iPSDEFieldModel = this.getDEField("PSSYSDYNAMODELNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("755e967d613d6656f5f777087fc60e4f");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("70fec232169ca5f22a5783649d345cf1");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9d6959c25dbfb767ea113b5f31d7bae2");
        pSDEFGroupDetailModel.setName("PSSYSREQITEMID");
        iPSDEFieldModel = this.getDEField("PSSYSREQITEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("dba459ae9dc545c314994601ad5167bd");
        pSDEFGroupDetailModel.setName("PSSYSREQITEMNAME");
        iPSDEFieldModel = this.getDEField("PSSYSREQITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e25fc69751dea23d21fc1e30d6e91da6");
        pSDEFGroupDetailModel.setName("PSSYSUNIRESID");
        iPSDEFieldModel = this.getDEField("PSSYSUNIRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c91d564221fd38afaf38d2dc592f866a");
        pSDEFGroupDetailModel.setName("PSSYSUNIRESNAME");
        iPSDEFieldModel = this.getDEField("PSSYSUNIRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1afffb7fa8007aee24679790ba0bde6e");
        pSDEFGroupDetailModel.setName("PSVIEWENGINEID");
        iPSDEFieldModel = this.getDEField("PSVIEWENGINEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4445442715efc4922a823edd873df96e");
        pSDEFGroupDetailModel.setName("PSVIEWENGINENAME");
        iPSDEFieldModel = this.getDEField("PSVIEWENGINENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("141aef818ff173567a91982078540b21");
        pSDEFGroupDetailModel.setName("PSVIEWMSGGROUPID");
        iPSDEFieldModel = this.getDEField("PSVIEWMSGGROUPID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("30348e168c42975f2d1139c1767817fe");
        pSDEFGroupDetailModel.setName("PSVIEWMSGGROUPNAME");
        iPSDEFieldModel = this.getDEField("PSVIEWMSGGROUPNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("fc628f024fb16b34a2e903dd0daaccab");
        pSDEFGroupDetailModel.setName("SHOWCAPTIONBAR");
        iPSDEFieldModel = this.getDEField("SHOWCAPTIONBAR", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1e4f5a03fb1d3cd992df0d2905b35374");
        pSDEFGroupDetailModel.setName("SUBCAPPSLANRESID");
        iPSDEFieldModel = this.getDEField("SUBCAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8029697301912d94a2eb765c5a5ef38d");
        pSDEFGroupDetailModel.setName("SUBCAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("SUBCAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1f5ed828e5633f5bdfe4d0492c6386e2");
        pSDEFGroupDetailModel.setName("SUBCAPTION");
        iPSDEFieldModel = this.getDEField("SUBCAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a4b0ab161f2cec879b3a8fe63aec6f0a");
        pSDEFGroupDetailModel.setName("TITLE");
        iPSDEFieldModel = this.getDEField("TITLE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a9164c8bdac337a3390a796f12ec24e5");
        pSDEFGroupDetailModel.setName("TITLEPSLANRESID");
        iPSDEFieldModel = this.getDEField("TITLEPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e94a06dc1be949b00aac6158db0a4ed9");
        pSDEFGroupDetailModel.setName("TITLEPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("TITLEPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4257de4b23ac45129e7f768e70782507");
        pSDEFGroupDetailModel.setName("TODOTASK");
        iPSDEFieldModel = this.getDEField("TODOTASK", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("33e9474b8a22d57beb42e9180db2653f");
        pSDEFGroupDetailModel.setName("UISTYLE");
        iPSDEFieldModel = this.getDEField("UISTYLE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppUIStyleCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("de25811145164318cb7cab127fbc3f26");
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

