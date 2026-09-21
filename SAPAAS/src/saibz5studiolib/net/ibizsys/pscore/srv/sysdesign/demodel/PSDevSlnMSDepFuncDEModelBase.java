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
package net.ibizsys.pscore.srv.sysdesign.demodel;

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
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnmsdepfunc.ac.PSDevSlnMSDepFuncDefaultACModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnmsdepfunc.dataquery.PSDevSlnMSDepFuncCurDeployDQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnmsdepfunc.dataquery.PSDevSlnMSDepFuncCurSlnDQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnmsdepfunc.dataquery.PSDevSlnMSDepFuncCurSysDQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnmsdepfunc.dataquery.PSDevSlnMSDepFuncDefaultDQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnmsdepfunc.dataset.PSDevSlnMSDepFuncCurDeployDSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnmsdepfunc.dataset.PSDevSlnMSDepFuncCurSlnDSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnmsdepfunc.dataset.PSDevSlnMSDepFuncCurSysDSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnmsdepfunc.dataset.PSDevSlnMSDepFuncDefaultDSModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFunc;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService;

public abstract class PSDevSlnMSDepFuncDEModelBase
extends PSDataEntityModelBase<PSDevSlnMSDepFunc> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDevSlnMSDepFuncService pSDevSlnMSDepFuncService;

    public PSDevSlnMSDepFuncDEModelBase() throws Exception {
        this.setId("1cce1174a7bdb39ecb2da0ba91ebc39c");
        this.setName("PSDEVSLNMSDEPFUNC");
        this.setCodeName("PSDevSlnMSDepFunc");
        this.setTableName("T_SRFPSDEVSLNMSDEPFUNC");
        this.setViewName("v_PSDEVSLNMSDEPFUNC");
        this.setLogicName("\u5f00\u53d1\u65b9\u6848\u5fae\u670d\u52a1\u529f\u80fd\u90e8\u7f72");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(2);
        this.setAuditMode(0);
        this.setEnableTempData(true);
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnMSDepFuncDEModel", (IDataEntityModel)this);
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

    public PSDevSlnMSDepFuncService getRealService() {
        if (this.pSDevSlnMSDepFuncService == null) {
            try {
                this.pSDevSlnMSDepFuncService = (PSDevSlnMSDepFuncService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnMSDepFuncService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService";
    }

    public PSDevSlnMSDepFunc createEntity() {
        return new PSDevSlnMSDepFunc();
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
            pSDEFieldModel.setId("dcb38ba495bc0bcf9097e6630002ed94");
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
            pSDEFieldModel.setId("89b879a30127708d3eb33c9dc0c503fa");
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
        object = this.createDEField("DEPLOYSTATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8f964032d4ffaa6672c59c2d2e9fdbf7");
            pSDEFieldModel.setName("DEPLOYSTATE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u90e8\u7f72\u72b6\u6001");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.MSDeployItemStateCodeListModel");
            pSDEFieldModel.setCodeName("DeployState");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEPLOYSTATE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEPLOYSTATE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FUNCTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1a01ea1c506f27d43e3284f3a7016446");
            pSDEFieldModel.setName("FUNCTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u529f\u80fd\u7c7b\u578b");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("FuncType");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HTTPADDRESS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2365b131ab4a47cbc7c8b4e5d51fba5f");
            pSDEFieldModel.setName("HTTPADDRESS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("Http\u5730\u5740");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("HttpAddress");
            pSDEFieldModel.setLength(250);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HTTPPORT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bff83d51c5fa48cb75e72aebfeac642c");
            pSDEFieldModel.setName("HTTPPORT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("HTTP\u7aef\u53e3");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("HttpPort");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HTTPSPORT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4b0b27714068263388552c77dd15e75b");
            pSDEFieldModel.setName("HTTPSPORT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("HTTPS\u7aef\u53e3");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("HttpsPort");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("69cff6bec58078a1f39d6575d35d844d");
            pSDEFieldModel.setName("MEMO");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5907\u6ce8");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Memo");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDCMSPLATFORMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2a23060718d0985f9338c33096d5f0ab");
            pSDEFieldModel.setName("PSDCMSPLATFORMID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("PSDCMSPLATFORMID");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID");
            pSDEFieldModel.setLinkDEFName("PSDCMSPLATFORMID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDCMSPlatformId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDCMSPLATFORMNODEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("16a92df562eaf56e6704ccd83b13a093");
            pSDEFieldModel.setName("PSDCMSPLATFORMNODEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u5fc3\u5fae\u670d\u52a1\u5e73\u53f0\u8282\u70b9");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNMSDEPFUNC_PSDCMSPLATFORMNODE_PSDCMSPLATFORMNODEID");
            pSDEFieldModel.setLinkDEFName("PSDCMSPLATFORMNODEID");
            pSDEFieldModel.setCodeName("PSDCMSPlatformNodeId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCMSPLATFORMNODEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDCMSPLATFORMNODEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDCMSPLATFORMNODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d7c71ae3219d039dca8af75004684944");
            pSDEFieldModel.setName("PSDCMSPLATFORMNODENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u4e2d\u5fc3\u5fae\u670d\u52a1\u5e73\u53f0\u8282\u70b9");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNMSDEPFUNC_PSDCMSPLATFORMNODE_PSDCMSPLATFORMNODEID");
            pSDEFieldModel.setLinkDEFName("PSDCMSPLATFORMNODENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDCMSPlatformNodeName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCMSPLATFORMNODENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDCMSPLATFORMNODENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCMSPLATFORMNODENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDCMSPLATFORMNODENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVCENTERDBINSTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2df61da234f2c9fdcfca46ad561040e4");
            pSDEFieldModel.setName("PSDEVCENTERDBINSTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5b9e\u4f8b");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNMSDEPFUNC_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID");
            pSDEFieldModel.setLinkDEFName("PSDEVCENTERDBINSTID");
            pSDEFieldModel.setCodeName("PSDevCenterDBInstId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVCENTERDBINSTID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVCENTERDBINSTID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVCENTERDBINSTNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("010017ae557905c5728a6bd36f584e0c");
            pSDEFieldModel.setName("PSDEVCENTERDBINSTNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5b9e\u4f8b");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNMSDEPFUNC_PSDEVCENTERDBINST_PSDEVCENTERDBINSTID");
            pSDEFieldModel.setLinkDEFName("PSDEVCENTERDBINSTNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDevCenterDBInstName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVCENTERDBINSTNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVCENTERDBINSTNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVCENTERDBINSTNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVCENTERDBINSTNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVCENTERSVNID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("db45528a129dc70f240834133121ee3d");
            pSDEFieldModel.setName("PSDEVCENTERSVNID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u4ed3\u5e93");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNMSDEPFUNC_PSDEVCENTERSVN_PSDEVCENTERSVNID");
            pSDEFieldModel.setLinkDEFName("PSDEVCENTERSVNID");
            pSDEFieldModel.setCodeName("PSDevCenterSVNId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVCENTERSVNID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVCENTERSVNID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVCENTERSVNNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("23689ca36a45c1aa8436b0a5e186b454");
            pSDEFieldModel.setName("PSDEVCENTERSVNNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u4ed3\u5e93");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNMSDEPFUNC_PSDEVCENTERSVN_PSDEVCENTERSVNID");
            pSDEFieldModel.setLinkDEFName("PSDEVCENTERSVNNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDevCenterSVNName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVCENTERSVNNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVCENTERSVNNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVCENTERSVNNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVCENTERSVNNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8eecb1264a7d06d4861758a5a9ef0478");
            pSDEFieldModel.setName("PSDEVSLNID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u65b9\u6848");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLN_PSDEVSLNID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDevSlnId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNMSDEPFUNCID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("827036f3ee3d0e5e63a9b5bd21b955fa");
            pSDEFieldModel.setName("PSDEVSLNMSDEPFUNCID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u65b9\u6848\u5fae\u670d\u52a1\u529f\u80fd\u90e8\u7f72\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDevSlnMSDepFuncId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNMSDEPFUNCNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("24818b0b1ade1678bab853636ab1807c");
            pSDEFieldModel.setName("PSDEVSLNMSDEPFUNCNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u529f\u80fd\u90e8\u7f72\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSDevSlnMSDepFuncName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNMSDEPFUNCNAME_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNMSDEPFUNCNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNMSDEPLOYID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("90bf21051978b8736180067f4334627a");
            pSDEFieldModel.setName("PSDEVSLNMSDEPLOYID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u65b9\u6848\u5fae\u670d\u52a1\u90e8\u7f72");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNMSDEPLOYID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDevSlnMSDeployId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNMSDEPLOYID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNMSDEPLOYID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNMSDEPLOYNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("47d05462e59e84408c687d16ca35083f");
            pSDEFieldModel.setName("PSDEVSLNMSDEPLOYNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u65b9\u6848\u5fae\u670d\u52a1\u90e8\u7f72");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNMSDEPLOYNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDevSlnMSDeployName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNMSDEPLOYNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNMSDEPLOYNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNMSDEPLOYNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNMSDEPLOYNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6d039fa3695ed36d7a8b33c361ed92d2");
            pSDEFieldModel.setName("PSDEVSLNNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u65b9\u6848");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLN_PSDEVSLNID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDevSlnName");
            pSDEFieldModel.setLength(60);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNPIPELINEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a9228a724d751956ded5a05ccaf7ccc5");
            pSDEFieldModel.setName("PSDEVSLNPIPELINEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u65b9\u6848Pipeline");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLNPIPELINE_PSDEVSLNPIPELINEID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNPIPELINEID");
            pSDEFieldModel.setCodeName("PSDevSlnPipelineId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNPIPELINEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNPIPELINEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNPIPELINENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e8aa56ccc364bdba6f910bc543edff37");
            pSDEFieldModel.setName("PSDEVSLNPIPELINENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u65b9\u6848Pipeline");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLNPIPELINE_PSDEVSLNPIPELINEID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNPIPELINENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDevSlnPipelineName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNPIPELINENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNPIPELINENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNPIPELINENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNPIPELINENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNSYSID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ce11a6113024de19585fd7c5f187a3b0");
            pSDEFieldModel.setName("PSDEVSLNSYSID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLNSYS_PSDEVSLNSYSID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNSYSID");
            pSDEFieldModel.setCodeName("PSDevSlnSysId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNSYSID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNSYSID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNSYSNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e31c988bf3dbf6c1d222ce66343d10ff");
            pSDEFieldModel.setName("PSDEVSLNSYSNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNMSDEPFUNC_PSDEVSLNSYS_PSDEVSLNSYSID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNSYSNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDevSlnSysName");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNSYSNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNSYSNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNSYSNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNSYSNAME_LIKE");
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
            pSDEFieldModel.setId("2c76ed64276e1b13e56a6fd03e42aa98");
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
            pSDEFieldModel.setId("b60ccfcd1260880ed66784465d206242");
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
            pSDEFieldModel.setId("e053ebd076ee683ecdf97ddf1c89d5fe");
            pSDEFieldModel.setName("USERPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserParams");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VALIDFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d8821c8479a3c8437331564899ab97c0");
            pSDEFieldModel.setName("VALIDFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ValidFlag");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSDevSlnMSDepFuncDefaultACModel pSDevSlnMSDepFuncDefaultACModel = new PSDevSlnMSDepFuncDefaultACModel();
        pSDevSlnMSDepFuncDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDevSlnMSDepFuncDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDevSlnMSDepFuncCurDeployDSModel pSDevSlnMSDepFuncCurDeployDSModel = new PSDevSlnMSDepFuncCurDeployDSModel();
        pSDevSlnMSDepFuncCurDeployDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnMSDepFuncCurDeployDSModel);
        PSDevSlnMSDepFuncCurSlnDSModel pSDevSlnMSDepFuncCurSlnDSModel = new PSDevSlnMSDepFuncCurSlnDSModel();
        pSDevSlnMSDepFuncCurSlnDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnMSDepFuncCurSlnDSModel);
        PSDevSlnMSDepFuncCurSysDSModel pSDevSlnMSDepFuncCurSysDSModel = new PSDevSlnMSDepFuncCurSysDSModel();
        pSDevSlnMSDepFuncCurSysDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnMSDepFuncCurSysDSModel);
        PSDevSlnMSDepFuncDefaultDSModel pSDevSlnMSDepFuncDefaultDSModel = new PSDevSlnMSDepFuncDefaultDSModel();
        pSDevSlnMSDepFuncDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnMSDepFuncDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDevSlnMSDepFuncCurDeployDQModel pSDevSlnMSDepFuncCurDeployDQModel = new PSDevSlnMSDepFuncCurDeployDQModel();
        pSDevSlnMSDepFuncCurDeployDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnMSDepFuncCurDeployDQModel);
        PSDevSlnMSDepFuncCurSlnDQModel pSDevSlnMSDepFuncCurSlnDQModel = new PSDevSlnMSDepFuncCurSlnDQModel();
        pSDevSlnMSDepFuncCurSlnDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnMSDepFuncCurSlnDQModel);
        PSDevSlnMSDepFuncCurSysDQModel pSDevSlnMSDepFuncCurSysDQModel = new PSDevSlnMSDepFuncCurSysDQModel();
        pSDevSlnMSDepFuncCurSysDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnMSDepFuncCurSysDQModel);
        PSDevSlnMSDepFuncDefaultDQModel pSDevSlnMSDepFuncDefaultDQModel = new PSDevSlnMSDepFuncDefaultDQModel();
        pSDevSlnMSDepFuncDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnMSDepFuncDefaultDQModel);
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
        this.registerPDTDEView("EDITVIEW", "c37aa7eebea7aaa1fbebf84d4cd858dd");
        this.registerPDTDEView("MDATAVIEW", "e864404214bbb5a039acd2b6b584f2af");
        this.registerPDTDEView("MPICKUPVIEW", "69fb1c0f701cd7865389dfdec3d0cba0");
        this.registerPDTDEView("PICKUPVIEW", "464ef9bf73026505a1c04e35841c4737");
        this.registerPDTDEView("REDIRECTVIEW", "4a5227ad930e7a95eb0769fb5f63a859");
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
        dEDataSetCond2.setDEFName("PSDEVSLNMSDEPFUNCNAME");
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
        pSDEFGroupDetailModel.setId("bff83d51c5fa48cb75e72aebfeac642c");
        pSDEFGroupDetailModel.setName("HTTPPORT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("HTTPPORT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("69cff6bec58078a1f39d6575d35d844d");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("16a92df562eaf56e6704ccd83b13a093");
        pSDEFGroupDetailModel.setName("PSDCMSPLATFORMNODEID");
        iPSDEFieldModel = this.getDEField("PSDCMSPLATFORMNODEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d7c71ae3219d039dca8af75004684944");
        pSDEFGroupDetailModel.setName("PSDCMSPLATFORMNODENAME");
        iPSDEFieldModel = this.getDEField("PSDCMSPLATFORMNODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2df61da234f2c9fdcfca46ad561040e4");
        pSDEFGroupDetailModel.setName("PSDEVCENTERDBINSTID");
        iPSDEFieldModel = this.getDEField("PSDEVCENTERDBINSTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("010017ae557905c5728a6bd36f584e0c");
        pSDEFGroupDetailModel.setName("PSDEVCENTERDBINSTNAME");
        iPSDEFieldModel = this.getDEField("PSDEVCENTERDBINSTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8eecb1264a7d06d4861758a5a9ef0478");
        pSDEFGroupDetailModel.setName("PSDEVSLNID");
        iPSDEFieldModel = this.getDEField("PSDEVSLNID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("24818b0b1ade1678bab853636ab1807c");
        pSDEFGroupDetailModel.setName("PSDEVSLNMSDEPFUNCNAME");
        iPSDEFieldModel = this.getDEField("PSDEVSLNMSDEPFUNCNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("90bf21051978b8736180067f4334627a");
        pSDEFGroupDetailModel.setName("PSDEVSLNMSDEPLOYID");
        iPSDEFieldModel = this.getDEField("PSDEVSLNMSDEPLOYID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("47d05462e59e84408c687d16ca35083f");
        pSDEFGroupDetailModel.setName("PSDEVSLNMSDEPLOYNAME");
        iPSDEFieldModel = this.getDEField("PSDEVSLNMSDEPLOYNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ce11a6113024de19585fd7c5f187a3b0");
        pSDEFGroupDetailModel.setName("PSDEVSLNSYSID");
        iPSDEFieldModel = this.getDEField("PSDEVSLNSYSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e31c988bf3dbf6c1d222ce66343d10ff");
        pSDEFGroupDetailModel.setName("PSDEVSLNSYSNAME");
        iPSDEFieldModel = this.getDEField("PSDEVSLNSYSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

