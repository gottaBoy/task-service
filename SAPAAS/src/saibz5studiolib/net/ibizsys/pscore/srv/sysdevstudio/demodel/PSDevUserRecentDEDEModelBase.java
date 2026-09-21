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
package net.ibizsys.pscore.srv.sysdevstudio.demodel;

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
import net.ibizsys.pscore.srv.core.PSDEFGroupModel;
import net.ibizsys.pscore.srv.core.PSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDataEntityModelBase;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdevuserrecentde.ac.PSDevUserRecentDEDefaultACModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdevuserrecentde.dataquery.PSDevUserRecentDECurUserAppDQModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdevuserrecentde.dataquery.PSDevUserRecentDECurUserDQModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdevuserrecentde.dataquery.PSDevUserRecentDEDefaultDQModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdevuserrecentde.dataquery.PSDevUserRecentDEViewDQModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdevuserrecentde.dataset.PSDevUserRecentDECurUserAppDSModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdevuserrecentde.dataset.PSDevUserRecentDECurUserDSModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdevuserrecentde.dataset.PSDevUserRecentDEDefaultDSModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevUserRecentDE;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevUserRecentDEService;

public abstract class PSDevUserRecentDEDEModelBase
extends PSDataEntityModelBase<PSDevUserRecentDE> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDevUserRecentDEService pSDevUserRecentDEService;

    public PSDevUserRecentDEDEModelBase() throws Exception {
        this.setId("9d403d6a2edefd78f1083e76f4af5f96");
        this.setName("PSDEVUSERRECENTDE");
        this.setCodeName("PSDevUserRecentDE");
        this.setTableName("T_SRFPSDEVUSERRECENT");
        this.setViewName("");
        this.setLogicName("\u4e91\u5e94\u7528\u7528\u6237\u6700\u8fd1\u8bbf\u95ee\u5b9e\u4f53");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setNoViewMode(true);
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDevUserRecentDEDEModel", (IDataEntityModel)this);
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

    public PSDevUserRecentDEService getRealService() {
        if (this.pSDevUserRecentDEService == null) {
            try {
                this.pSDevUserRecentDEService = (PSDevUserRecentDEService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevUserRecentDEService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSDevUserRecentDEService";
    }

    public PSDevUserRecentDE createEntity() {
        return new PSDevUserRecentDE();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("LOGICNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4ea90bfe99dbd9e47c5514be754f234c");
            pSDEFieldModel.setName("LOGICNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u4e2d\u6587\u540d\u79f0");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVUSERRECENTDE_PSDATAENTITY_OBJID");
            pSDEFieldModel.setLinkDEFName("LOGICNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("LogicName");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OBJID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0ae0df0461263794c7ad7183fdb985b1");
            pSDEFieldModel.setName("OBJID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u6807\u8bc6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVUSERRECENTDE_PSDATAENTITY_OBJID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYID");
            pSDEFieldModel.setCodeName("ObjId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OBJID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OBJID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OBJTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d5296d841bca3ef41a420c098372422c");
            pSDEFieldModel.setName("OBJTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8bbf\u95ee\u5bf9\u8c61\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DevUserRecentObjTypeCodeListModel");
            pSDEFieldModel.setCodeName("ObjType");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OBJTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OBJTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDATAENTITYNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9b1073a258ba35fa3338c11f91395900");
            pSDEFieldModel.setName("PSDATAENTITYNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u540d\u79f0");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVUSERRECENTDE_PSDATAENTITY_OBJID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDataEntityName");
            pSDEFieldModel.setLength(60);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDATAENTITYNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDATAENTITYNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDATAENTITYNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDATAENTITYNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVUSERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f80704a284e6671cfd958815c0132679");
            pSDEFieldModel.setName("PSDEVUSERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e91\u5e94\u7528\u4e2d\u5fc3\u7528\u6237");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSDevUserId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVUSERRECENTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("011eeecdfcfb561edf0dd91961437671");
            pSDEFieldModel.setName("PSDEVUSERRECENTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e91\u5e94\u7528\u7528\u6237\u6700\u8fd1\u8bbf\u95ee\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDevUserRecentId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVUSERRECENTNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9823c1975f3569208796e290ccd11ec5");
            pSDEFieldModel.setName("PSDEVUSERRECENTNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e91\u5e94\u7528\u7528\u6237\u6700\u8fd1\u8bbf\u95ee");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSDevUserRecentName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVUSERRECENTNAME_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVUSERRECENTNAME_LIKE");
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
            pSDEFieldModel.setId("c5c0c1d555f1a1f113b1a4324c390b4d");
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
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSDevUserRecentDEDefaultACModel pSDevUserRecentDEDefaultACModel = new PSDevUserRecentDEDefaultACModel();
        pSDevUserRecentDEDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDevUserRecentDEDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDevUserRecentDECurUserDSModel pSDevUserRecentDECurUserDSModel = new PSDevUserRecentDECurUserDSModel();
        pSDevUserRecentDECurUserDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevUserRecentDECurUserDSModel);
        PSDevUserRecentDECurUserAppDSModel pSDevUserRecentDECurUserAppDSModel = new PSDevUserRecentDECurUserAppDSModel();
        pSDevUserRecentDECurUserAppDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevUserRecentDECurUserAppDSModel);
        PSDevUserRecentDEDefaultDSModel pSDevUserRecentDEDefaultDSModel = new PSDevUserRecentDEDefaultDSModel();
        pSDevUserRecentDEDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevUserRecentDEDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDevUserRecentDECurUserDQModel pSDevUserRecentDECurUserDQModel = new PSDevUserRecentDECurUserDQModel();
        pSDevUserRecentDECurUserDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevUserRecentDECurUserDQModel);
        PSDevUserRecentDECurUserAppDQModel pSDevUserRecentDECurUserAppDQModel = new PSDevUserRecentDECurUserAppDQModel();
        pSDevUserRecentDECurUserAppDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevUserRecentDECurUserAppDQModel);
        PSDevUserRecentDEDefaultDQModel pSDevUserRecentDEDefaultDQModel = new PSDevUserRecentDEDefaultDQModel();
        pSDevUserRecentDEDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevUserRecentDEDefaultDQModel);
        PSDevUserRecentDEViewDQModel pSDevUserRecentDEViewDQModel = new PSDevUserRecentDEViewDQModel();
        pSDevUserRecentDEViewDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevUserRecentDEViewDQModel);
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
        this.registerPDTDEView("EDITVIEW", "8b3227db10458789a195ec2995ef54b2");
        this.registerPDTDEView("MDATAVIEW", "4e1eabc33b96c4b20048cc3c63902615");
        this.registerPDTDEView("MPICKUPVIEW", "be793dc6851647b247fe85d66519a569");
        this.registerPDTDEView("PICKUPVIEW", "c0843b00db440b9139f2fc3067c0752b");
        this.registerPDTDEView("REDIRECTVIEW", "a34090e8d1ac34112251e235e580e2b1");
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
        dEDataSetCond2.setDEFName("PSDEVUSERRECENTNAME");
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
        return pSDEFGroupModel;
    }
}

