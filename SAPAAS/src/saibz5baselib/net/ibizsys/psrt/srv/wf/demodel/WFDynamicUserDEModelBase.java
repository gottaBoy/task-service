/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.demodel.DEDBConfigModel;
import net.ibizsys.paas.demodel.DEFSearchModeModel;
import net.ibizsys.paas.demodel.DEFieldModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.DataEntityModelBase;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.psrt.srv.PSRuntimeSysModel;
import net.ibizsys.psrt.srv.wf.demodel.wfdynamicuser.ac.WFDynamicUserDefaultACModel;
import net.ibizsys.psrt.srv.wf.demodel.wfdynamicuser.dataquery.WFDynamicUserDefaultDQModel;
import net.ibizsys.psrt.srv.wf.demodel.wfdynamicuser.dataset.WFDynamicUserDefaultDSModel;
import net.ibizsys.psrt.srv.wf.entity.WFDynamicUser;
import net.ibizsys.psrt.srv.wf.service.WFDynamicUserService;

public abstract class WFDynamicUserDEModelBase
extends DataEntityModelBase<WFDynamicUser> {
    private PSRuntimeSysModel pSRuntimeSysModel;
    private WFDynamicUserService wFDynamicUserService;

    public WFDynamicUserDEModelBase() throws Exception {
        this.setId("733170434261be84089d353a6a231373");
        this.setName("WFDYNAMICUSER");
        this.setTableName("T_SRFWFDYNAMICUSER");
        this.setViewName("v_WFDYNAMICUSER");
        this.setLogicName("\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel("net.ibizsys.psrt.srv.wf.demodel.WFDynamicUserDEModel", this);
            this.getPSRuntimeSysModel().registerDataEntityModel(this);
        }
        this.prepareModels();
    }

    public PSRuntimeSysModel getPSRuntimeSysModel() {
        if (this.pSRuntimeSysModel == null) {
            try {
                this.pSRuntimeSysModel = (PSRuntimeSysModel)SysModelGlobal.getSystem("net.ibizsys.psrt.srv.PSRuntimeSysModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSRuntimeSysModel;
    }

    @Override
    public ISystem getSystem() {
        return this.getPSRuntimeSysModel();
    }

    public WFDynamicUserService getRealService() {
        if (this.wFDynamicUserService == null) {
            try {
                this.wFDynamicUserService = (WFDynamicUserService)ServiceGlobal.getService(this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.wFDynamicUserService;
    }

    @Override
    public IService getService() {
        return this.getRealService();
    }

    @Override
    public String getServiceId() {
        return "net.ibizsys.psrt.srv.wf.service.WFDynamicUserService";
    }

    @Override
    public WFDynamicUser createEntity() {
        return new WFDynamicUser();
    }

    @Override
    protected void prepareDEFields() throws Exception {
        DEFieldModel deFieldModel;
        IDEField iDEField = null;
        IDEFSearchMode iDEFSearchMode = null;
        iDEField = this.createDEField("CREATEDATE");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("718261b5e6806c7e8b9d1ef60d5fccea");
            deFieldModel.setName("CREATEDATE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5efa\u7acb\u65f6\u95f4");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setPreDefinedType("CREATEDATE");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("CREATEMAN");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("7b5b462031108d2ed3b2d41f7e3bf626");
            deFieldModel.setName("CREATEMAN");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5efa\u7acb\u4eba");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setPreDefinedType("CREATEMAN");
            deFieldModel.setCodeListId("net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("PARAMS");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("1a896d156964b88fa3a054fa37c278f6");
            deFieldModel.setName("PARAMS");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5904\u7406\u53d8\u91cf");
            deFieldModel.setDataType("LONGTEXT");
            deFieldModel.setStdDataType(21);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("UPDATEDATE");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("c3012f1d8a0a99bf1b22df247ccf09d8");
            deFieldModel.setName("UPDATEDATE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u66f4\u65b0\u65f6\u95f4");
            deFieldModel.setDataType("DATETIME");
            deFieldModel.setStdDataType(5);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setPreDefinedType("UPDATEDATE");
            deFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("UPDATEMAN");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("23659803ae3538002d032db01129f813");
            deFieldModel.setName("UPDATEMAN");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u66f4\u65b0\u4eba");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setPreDefinedType("UPDATEMAN");
            deFieldModel.setCodeListId("net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("USEROBJECT");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("a5a332933d6d9ad844c1363622a0f418");
            deFieldModel.setName("USEROBJECT");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u7528\u6237\u5904\u7406\u5bf9\u8c61");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("USERTYPE");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("9ccab7654eaa074923240e438bdcaf2f");
            deFieldModel.setName("USERTYPE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u7528\u6237\u7c7b\u578b");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFDYNAMICUSERID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("91dc792102c9bd02fd1c06e855dace37");
            deFieldModel.setName("WFDYNAMICUSERID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237\u6807\u8bc6");
            deFieldModel.setDataType("GUID");
            deFieldModel.setStdDataType(25);
            deFieldModel.setKeyDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("WFDYNAMICUSERNAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("c8b360e931b0f37f206201eea72f249d");
            deFieldModel.setName("WFDYNAMICUSERNAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u5de5\u4f5c\u6d41\u52a8\u6001\u7528\u6237\u540d\u79f0");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setMajorDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_WFDYNAMICUSERNAME_LIKE");
            if (iDEFSearchMode == null) {
                DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_WFDYNAMICUSERNAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
    }

    @Override
    protected void prepareDEACModes() throws Exception {
        WFDynamicUserDefaultACModel _defaultACModel = new WFDynamicUserDefaultACModel();
        _defaultACModel.init(this);
        this.registerDEACMode(_defaultACModel);
    }

    @Override
    protected void prepareDEDBConfigs() throws Exception {
        DEDBConfigModel mYSQL5ConfigModel = new DEDBConfigModel();
        mYSQL5ConfigModel.setDBType("MYSQL5");
        mYSQL5ConfigModel.setTableName("t_srfwfdynamicuser");
        mYSQL5ConfigModel.setViewName("v_wfdynamicuser");
        this.registerDEDBConfig(mYSQL5ConfigModel);
    }

    @Override
    protected void prepareDEDataSets() throws Exception {
        WFDynamicUserDefaultDSModel _defaultDSModel = new WFDynamicUserDefaultDSModel();
        _defaultDSModel.init(this);
        this.registerDEDataSet(_defaultDSModel);
    }

    @Override
    protected void prepareDEDataQueries() throws Exception {
        WFDynamicUserDefaultDQModel _defaultDQModel = new WFDynamicUserDefaultDQModel();
        _defaultDQModel.init(this);
        this.registerDEDataQuery(_defaultDQModel);
    }

    @Override
    protected void prepareDEActions() throws Exception {
    }

    @Override
    protected void prepareDELogics() throws Exception {
    }

    @Override
    protected void prepareDEUIActions() throws Exception {
    }

    @Override
    protected void prepareDEWFs() throws Exception {
    }

    @Override
    protected void prepareDEUniStates() throws Exception {
    }

    @Override
    protected void prepareDEMainStates() throws Exception {
    }

    @Override
    protected void prepareDEDataSyncs() throws Exception {
    }

    @Override
    protected void preparePDTDEViews() throws Exception {
        this.registerPDTDEView("MPICKUPVIEW", "5360640395186cf409238a4c36917b84");
        this.registerPDTDEView("PICKUPVIEW", "60f8de33077b1f3256226252560a90fb");
        this.registerPDTDEView("REDIRECTVIEW", "14b82f2d05dd5f1a61a8dbe07fe0250f");
    }

    @Override
    protected void prepareDEOPPrivTagMaps() throws Exception {
    }

    @Override
    protected void prepareDEPrints() throws Exception {
    }

    @Override
    protected void prepareDEReports() throws Exception {
    }

    @Override
    protected void prepareDEDataExports() throws Exception {
    }

    @Override
    protected void prepareDEActionWizards() throws Exception {
    }

    @Override
    protected void prepareDEActionWizardGroups() throws Exception {
    }

    @Override
    protected void prepareDEBATables() throws Exception {
    }

    @Override
    protected void prepareDEUserRoles() throws Exception {
    }

    @Override
    protected void prepareDEOPPrivRoles() throws Exception {
    }

    @Override
    protected void onFillFetchQuickSearchConditions(DEDataSetCond groupCondImpl, String strQuickSearch) throws Exception {
        super.onFillFetchQuickSearchConditions(groupCondImpl, strQuickSearch);
        DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
        deDataSetCondImpl.setCondType("DEFIELD");
        deDataSetCondImpl.setCondOp("LIKE");
        deDataSetCondImpl.setDEFName("WFDYNAMICUSERNAME");
        deDataSetCondImpl.setCondValue(strQuickSearch);
        groupCondImpl.addChildDEDataQueryCond(deDataSetCondImpl);
    }
}

