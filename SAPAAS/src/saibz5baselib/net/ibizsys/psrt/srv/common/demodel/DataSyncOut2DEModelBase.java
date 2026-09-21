/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel;

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
import net.ibizsys.psrt.srv.common.demodel.datasyncout2.ac.DataSyncOut2DefaultACModel;
import net.ibizsys.psrt.srv.common.demodel.datasyncout2.dataquery.DataSyncOut2DefaultDQModel;
import net.ibizsys.psrt.srv.common.demodel.datasyncout2.dataset.DataSyncOut2DefaultDSModel;
import net.ibizsys.psrt.srv.common.entity.DataSyncOut2;
import net.ibizsys.psrt.srv.common.service.DataSyncOut2Service;

public abstract class DataSyncOut2DEModelBase
extends DataEntityModelBase<DataSyncOut2> {
    private PSRuntimeSysModel pSRuntimeSysModel;
    private DataSyncOut2Service dataSyncOut2Service;

    public DataSyncOut2DEModelBase() throws Exception {
        this.setId("1cecb3d95febd748a2daf8e9c86a8ec5");
        this.setName("DATASYNCOUT2");
        this.setTableName("T_SRFDATASYNCOUT2");
        this.setViewName("v_DATASYNCOUT2");
        this.setLogicName("\u6570\u636e\u540c\u6b65\u53d1\u9001\u961f\u52172");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel("net.ibizsys.psrt.srv.common.demodel.DataSyncOut2DEModel", this);
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

    public DataSyncOut2Service getRealService() {
        if (this.dataSyncOut2Service == null) {
            try {
                this.dataSyncOut2Service = (DataSyncOut2Service)ServiceGlobal.getService(this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.dataSyncOut2Service;
    }

    @Override
    public IService getService() {
        return this.getRealService();
    }

    @Override
    public String getServiceId() {
        return "net.ibizsys.psrt.srv.common.service.DataSyncOut2Service";
    }

    @Override
    public DataSyncOut2 createEntity() {
        return new DataSyncOut2();
    }

    @Override
    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel defSearchModeModel;
        DEFieldModel deFieldModel;
        IDEField iDEField = null;
        IDEFSearchMode iDEFSearchMode = null;
        iDEField = this.createDEField("CREATEDATE");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("14b0a82ac7e2efae77db9ed98ec27dba");
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
            deFieldModel.setId("18da56ec02f65328034d1fc5bc69fbe4");
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
        iDEField = this.createDEField("DATA");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("dedf386ce330fc0fec3333ea977c448e");
            deFieldModel.setName("DATA");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6570\u636e");
            deFieldModel.setDataType("LONGTEXT");
            deFieldModel.setStdDataType(21);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("DATAKEY");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("8c51e772a7bc544ba1481ac4e6d692de");
            deFieldModel.setName("DATAKEY");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6570\u636e\u4e3b\u952e");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("DATASYNCOUT2ID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("c263395c364334cd39f361a40855391a");
            deFieldModel.setName("DATASYNCOUT2ID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6570\u636e\u540c\u6b65\u53d1\u9001\u961f\u52172\u6807\u8bc6");
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
        iDEField = this.createDEField("DATASYNCOUT2NAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("e688256c3af77bcbaac11a124013422e");
            deFieldModel.setName("DATASYNCOUT2NAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u53d1\u9001\u961f\u52172\u540d\u79f0");
            deFieldModel.setDataType("TEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setMajorDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_DATASYNCOUT2NAME_LIKE");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_DATASYNCOUT2NAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("DEID");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("dbaeb5dc61d03a2e4f6a961c2a086ac7");
            deFieldModel.setName("DEID");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6570\u636e\u5b9e\u4f53");
            deFieldModel.setDataType("PICKUP");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_DATASYNCOUT2_DATAENTITY_DEID");
            deFieldModel.setLinkDEFName("DEID");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_DEID_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_DEID_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("DENAME");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("8f126eed95bdb204d09e1dc17f68a1a2");
            deFieldModel.setName("DENAME");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6570\u636e\u5b9e\u4f53");
            deFieldModel.setDataType("PICKUPTEXT");
            deFieldModel.setStdDataType(25);
            deFieldModel.setLinkDEField(true);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setDERName("DER1N_DATASYNCOUT2_DATAENTITY_DEID");
            deFieldModel.setLinkDEFName("DENAME");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_DENAME_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_DENAME_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_DENAME_LIKE")) == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_DENAME_LIKE");
                defSearchModeModel.setValueOp("LIKE");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("ERROR");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("f45d065d019d6ec7d9ecda8a7fde7d46");
            deFieldModel.setName("ERROR");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u540c\u6b65\u9519\u8bef\u4fe1\u606f");
            deFieldModel.setDataType("LONGTEXT_1000");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("EVENTTYPE");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("13acc93a3741453770b5b5ad582ae01a");
            deFieldModel.setName("EVENTTYPE");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u4e8b\u4ef6\u7c7b\u578b");
            deFieldModel.setDataType("NSCODELIST");
            deFieldModel.setStdDataType(9);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setCodeListId("net.ibizsys.psrt.srv.codelist.DataChangeEventCodeListModel");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_EVENTTYPE_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_EVENTTYPE_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("FILELIST");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("ada158bffcac9cf73b50835c23250bdd");
            deFieldModel.setName("FILELIST");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u540c\u6b65\u6587\u4ef6\u6e05\u5355");
            deFieldModel.setDataType("LONGTEXT");
            deFieldModel.setStdDataType(21);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("LOGICDATA");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("33d52894e56f27001e08db60fbf67705");
            deFieldModel.setName("LOGICDATA");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u903b\u8f91\u6570\u636e");
            deFieldModel.setDataType("LONGTEXT");
            deFieldModel.setStdDataType(21);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setValueFormat("%1$s");
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("SYNCAGENT");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("50040bc5bc1acf346eb8856507426c28");
            deFieldModel.setName("SYNCAGENT");
            deFieldModel.setDEFType(1);
            deFieldModel.setLogicName("\u6570\u636e\u8f93\u51fa\u4ee3\u7406");
            deFieldModel.setDataType("SSCODELIST");
            deFieldModel.setStdDataType(25);
            deFieldModel.setImportOrder(1000);
            deFieldModel.setImportTag("");
            deFieldModel.setCodeListId("net.ibizsys.psrt.srv.codelist.DataSyncInAgentCodeListModel");
            deFieldModel.setValueFormat("%1$s");
            iDEFSearchMode = this.createDEFSearchMode(deFieldModel, "N_SYNCAGENT_EQ");
            if (iDEFSearchMode == null) {
                defSearchModeModel = new DEFSearchModeModel();
                defSearchModeModel.setDEField(deFieldModel);
                defSearchModeModel.setName("N_SYNCAGENT_EQ");
                defSearchModeModel.setValueOp("EQ");
                defSearchModeModel.init();
                deFieldModel.registerDEFSearchMode(defSearchModeModel);
            }
            deFieldModel.init();
            iDEField = deFieldModel;
        }
        this.registerDEField(iDEField);
        iDEField = this.createDEField("UPDATEDATE");
        if (iDEField == null) {
            deFieldModel = new DEFieldModel();
            deFieldModel.setDataEntity(this);
            deFieldModel.setId("7719183d493cba0e5357cf15937104df");
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
            deFieldModel.setId("c644824aaa6b20a83daca2f56fdcd987");
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
    }

    @Override
    protected void prepareDEACModes() throws Exception {
        DataSyncOut2DefaultACModel _defaultACModel = new DataSyncOut2DefaultACModel();
        _defaultACModel.init(this);
        this.registerDEACMode(_defaultACModel);
    }

    @Override
    protected void prepareDEDBConfigs() throws Exception {
        DEDBConfigModel mYSQL5ConfigModel = new DEDBConfigModel();
        mYSQL5ConfigModel.setDBType("MYSQL5");
        mYSQL5ConfigModel.setTableName("t_srfdatasyncout2");
        mYSQL5ConfigModel.setViewName("v_datasyncout2");
        this.registerDEDBConfig(mYSQL5ConfigModel);
    }

    @Override
    protected void prepareDEDataSets() throws Exception {
        DataSyncOut2DefaultDSModel _defaultDSModel = new DataSyncOut2DefaultDSModel();
        _defaultDSModel.init(this);
        this.registerDEDataSet(_defaultDSModel);
    }

    @Override
    protected void prepareDEDataQueries() throws Exception {
        DataSyncOut2DefaultDQModel _defaultDQModel = new DataSyncOut2DefaultDQModel();
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
        this.registerPDTDEView("MDATAVIEW", "9433674f8ab384b0e4f3f172c1a2d4ca");
        this.registerPDTDEView("MPICKUPVIEW", "5043cc96fb0e8840e34c7b6abbbca673");
        this.registerPDTDEView("PICKUPVIEW", "9ef18254d610d304d65602fd88d7aaff");
        this.registerPDTDEView("REDIRECTVIEW", "d7048fd5c9fb196af265755dfe5c871c");
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
        deDataSetCondImpl.setDEFName("DATASYNCOUT2NAME");
        deDataSetCondImpl.setCondValue(strQuickSearch);
        groupCondImpl.addChildDEDataQueryCond(deDataSetCondImpl);
    }
}

