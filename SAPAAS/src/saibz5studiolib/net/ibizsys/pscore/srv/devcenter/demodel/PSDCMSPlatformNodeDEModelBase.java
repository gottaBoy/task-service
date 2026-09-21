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
package net.ibizsys.pscore.srv.devcenter.demodel;

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
import net.ibizsys.pscore.srv.devcenter.demodel.psdcmsplatformnode.ac.PSDCMSPlatformNodeDefaultACModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcmsplatformnode.dataquery.PSDCMSPlatformNodeAPINodeDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcmsplatformnode.dataquery.PSDCMSPlatformNodeAppNodeDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcmsplatformnode.dataquery.PSDCMSPlatformNodeCurMSPDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcmsplatformnode.dataquery.PSDCMSPlatformNodeCurSlnDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcmsplatformnode.dataquery.PSDCMSPlatformNodeDefaultDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcmsplatformnode.dataset.PSDCMSPlatformNodeAPINodeDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcmsplatformnode.dataset.PSDCMSPlatformNodeAppNodeDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcmsplatformnode.dataset.PSDCMSPlatformNodeCurMSPDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcmsplatformnode.dataset.PSDCMSPlatformNodeCurSlnDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcmsplatformnode.dataset.PSDCMSPlatformNodeDefaultDSModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNode;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService;

public abstract class PSDCMSPlatformNodeDEModelBase
extends PSDataEntityModelBase<PSDCMSPlatformNode> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDCMSPlatformNodeService pSDCMSPlatformNodeService;

    public PSDCMSPlatformNodeDEModelBase() throws Exception {
        this.setId("1a72fe085dcd86a1ff94801c812a20be");
        this.setName("PSDCMSPLATFORMNODE");
        this.setCodeName("PSDCMSPlatformNode");
        this.setTableName("T_SRFPSDCMSPLATFORMNODE");
        this.setViewName("v_PSDCMSPLATFORMNODE");
        this.setLogicName("\u4e2d\u5fc3\u5fae\u670d\u52a1\u5e73\u53f0\u8282\u70b9");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCMSPlatformNodeDEModel", (IDataEntityModel)this);
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

    public PSDCMSPlatformNodeService getRealService() {
        if (this.pSDCMSPlatformNodeService == null) {
            try {
                this.pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCMSPlatformNodeService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService";
    }

    public PSDCMSPlatformNode createEntity() {
        return new PSDCMSPlatformNode();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("CFGTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a9156fc3e04a25767b0eb51c88eaa796");
            pSDEFieldModel.setName("CFGTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u914d\u7f6e\u7c7b\u578b");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CfgType");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CONTAINERCFG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("abc98e8cde899174bc06af4f065bde04");
            pSDEFieldModel.setName("CONTAINERCFG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u76f4\u63a5\u914d\u7f6e");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ContainerCfg");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5eafe7048b3da6713a67b5a1c6365950");
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
            pSDEFieldModel.setId("4162e08f566d1786f31c4517e522583f");
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
        object = this.createDEField("DCREGISTRYITEMTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7b8d0eabe3e84fb27ae442f37eb9c04d");
            pSDEFieldModel.setName("DCREGISTRYITEMTAG");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u955c\u50cf\u9879\u6807\u8bb0");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCMSPLATFORMNODE_PSDCREGISTRYITEM_PSDCREGISTRYITEMID");
            pSDEFieldModel.setLinkDEFName("ITEMTAG");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("DCRegistryItemTag");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DCREGISTRYITEMTAG_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DCREGISTRYITEMTAG_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DCREGISTRYITEMTAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b7db3cc6ed5ed51a87a8f90491789ff7");
            pSDEFieldModel.setName("DCREGISTRYITEMTAG2");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u955c\u50cf\u9879\u6807\u8bb02");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCMSPLATFORMNODE_PSDCREGISTRYITEM_PSDCREGISTRYITEMID");
            pSDEFieldModel.setLinkDEFName("ITEMTAG2");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("DCRegistryItemTag2");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DCREGISTRYITEMTAG2_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DCREGISTRYITEMTAG2_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DCREGISTRYITEMTAG3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7e1619212aceb5f17991d784b59f19f1");
            pSDEFieldModel.setName("DCREGISTRYITEMTAG3");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u955c\u50cf\u9879\u6807\u8bb03");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCMSPLATFORMNODE_PSDCREGISTRYITEM_PSDCREGISTRYITEMID");
            pSDEFieldModel.setLinkDEFName("ITEMTAG3");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("DCRegistryItemTag3");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DCREGISTRYITEMTAG3_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DCREGISTRYITEMTAG3_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DCREGISTRYITEMTAG4");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c8c2c95e4e8a4e1693e3ce9f02a0a8b0");
            pSDEFieldModel.setName("DCREGISTRYITEMTAG4");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u955c\u50cf\u9879\u6807\u8bb04");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCMSPLATFORMNODE_PSDCREGISTRYITEM_PSDCREGISTRYITEMID");
            pSDEFieldModel.setLinkDEFName("ITEMTAG4");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("DCRegistryItemTag4");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DCREGISTRYITEMTAG4_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DCREGISTRYITEMTAG4_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENVPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("79c78931f53129728e791fbfcd017570");
            pSDEFieldModel.setName("ENVPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u73af\u5883\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("EnvParams");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("IPADDR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9485236bdaa5098039f5c610a545f081");
            pSDEFieldModel.setName("IPADDR");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5916\u7f51IP");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("IpAddr");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("IPADDR2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1406258dc95d6894583e8920bdaa86ca");
            pSDEFieldModel.setName("IPADDR2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u7f51IP");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("IpAddr2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MAXCPU");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a7e474ccfe8cad44ee0f7d0a8b6d9a0f");
            pSDEFieldModel.setName("MAXCPU");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6700\u5927CPU");
            pSDEFieldModel.setDataType("FLOAT");
            pSDEFieldModel.setStdDataType(7);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MaxCPU");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MAXMEN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0bb74b7ed78def75f00750648dc7014b");
            pSDEFieldModel.setName("MAXMEN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6700\u5927\u5185\u5b58");
            pSDEFieldModel.setDataType("FLOAT");
            pSDEFieldModel.setStdDataType(7);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MaxMem");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9f68a02e9c53e2ac20da76a4c0e96a4f");
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
        object = this.createDEField("MINCPU");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6a98d7a362eead4f1210abefe84103c6");
            pSDEFieldModel.setName("MINCPU");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6700\u5c0fCPU");
            pSDEFieldModel.setDataType("FLOAT");
            pSDEFieldModel.setStdDataType(7);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MinCPU");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MINMEN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3078bcede86762292e16228cec8035f9");
            pSDEFieldModel.setName("MINMEN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6700\u5c0f\u5185\u5b58");
            pSDEFieldModel.setDataType("FLOAT");
            pSDEFieldModel.setStdDataType(7);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MinMem");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("NODEINFO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bf36dfd107cc523e430c3c90df850967");
            pSDEFieldModel.setName("NODEINFO");
            pSDEFieldModel.setDEFType(5);
            pSDEFieldModel.setLogicName("\u8282\u70b9\u4fe1\u606f");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("NodeInfo");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("NODESTATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c9dbb1cce38c44d4ea9cfa63af6fa555");
            pSDEFieldModel.setName("NODESTATE");
            pSDEFieldModel.setDEFType(5);
            pSDEFieldModel.setLogicName("\u8282\u70b9\u72b6\u6001");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("NodeState");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("NODETAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("17c2ed044b300dd1886f7081fd0e6af6");
            pSDEFieldModel.setName("NODETAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8282\u70b9\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("NodeTag");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("NODETAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("deb943dae9d1f6d4d6e28f0b6523cf55");
            pSDEFieldModel.setName("NODETAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8282\u70b9\u6807\u8bb02");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("NodeTag2");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PASSWD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bf53ca60d1265b2e2a0ac85022f643b9");
            pSDEFieldModel.setName("PASSWD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e3b\u673a\u5bc6\u7801");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Passwd");
            pSDEFieldModel.setLength(40);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PORT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6e1eedb5c08e01c74f6b0124305710dc");
            pSDEFieldModel.setName("PORT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u670d\u52a1\u7aef\u53e3");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Port");
            pSDEFieldModel.setMinValue(1);
            pSDEFieldModel.setMaxValue(65535);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PORT2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a2538d9bb1aba3c6bcf499feea0d76ce");
            pSDEFieldModel.setName("PORT2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u90e8\u7aef\u53e3");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Port2");
            pSDEFieldModel.setMinValue(1);
            pSDEFieldModel.setMaxValue(65535);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDCMSPLATFORMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fc9a3c170b0beb61d04c2a9236e3b4a4");
            pSDEFieldModel.setName("PSDCMSPLATFORMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u5fc3\u5fae\u670d\u52a1\u5e73\u53f0");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCMSPLATFORMNODE_PSDCMSPLATFORM_PSDCMSPLATFORMID");
            pSDEFieldModel.setLinkDEFName("PSDCMSPLATFORMID");
            pSDEFieldModel.setCodeName("PSDCMSPlatformId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCMSPLATFORMID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDCMSPLATFORMID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDCMSPLATFORMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("df7fd8a0f187ecd2d4d8b962171939d2");
            pSDEFieldModel.setName("PSDCMSPLATFORMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u5fc3\u5fae\u670d\u52a1\u5e73\u53f0");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCMSPLATFORMNODE_PSDCMSPLATFORM_PSDCMSPLATFORMID");
            pSDEFieldModel.setLinkDEFName("PSDCMSPLATFORMNAME");
            pSDEFieldModel.setCodeName("PSDCMSPlatformName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCMSPLATFORMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDCMSPLATFORMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCMSPLATFORMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDCMSPLATFORMNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDCMSPLATFORMNODEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("12e03de3f321acede3f8618c0952631d");
            pSDEFieldModel.setName("PSDCMSPLATFORMNODEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u5fc3\u5fae\u670d\u52a1\u5e73\u53f0\u8282\u70b9\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDCMSPlatformNodeId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDCMSPLATFORMNODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("25e71dcfd350edc6414baf9e9b5a490a");
            pSDEFieldModel.setName("PSDCMSPLATFORMNODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8282\u70b9\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSDCMSPlatformNodeName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCMSPLATFORMNODENAME_LIKE");
            if (iDEFSearchMode == null) {
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
        object = this.createDEField("PSDCREGISTRYITEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("81c964783e49905e7293f3d8714fa788");
            pSDEFieldModel.setName("PSDCREGISTRYITEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8282\u70b9\u955c\u50cf");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCMSPLATFORMNODE_PSDCREGISTRYITEM_PSDCREGISTRYITEMID");
            pSDEFieldModel.setLinkDEFName("PSDCREGISTRYITEMID");
            pSDEFieldModel.setCodeName("PSDCRegistryItemId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCREGISTRYITEMID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDCREGISTRYITEMID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDCREGISTRYITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ddd4a5d76580fe18c786734fbda0c9df");
            pSDEFieldModel.setName("PSDCREGISTRYITEMNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8282\u70b9\u955c\u50cf");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCMSPLATFORMNODE_PSDCREGISTRYITEM_PSDCREGISTRYITEMID");
            pSDEFieldModel.setLinkDEFName("PSDCREGISTRYITEMNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDCRegistryItemName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCREGISTRYITEMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDCREGISTRYITEMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCREGISTRYITEMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDCREGISTRYITEMNAME_LIKE");
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
            pSDEFieldModel.setId("dd60347cbb74969958835709a454582c");
            pSDEFieldModel.setName("PSDEVSLNID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u65b9\u6848\u6807\u8bc6");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCMSPLATFORMNODE_PSDCMSPLATFORM_PSDCMSPLATFORMID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNID");
            pSDEFieldModel.setPhisicalDEField(false);
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
        object = this.createDEField("PSDEVSLNNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0c9a75ebdafa412b6f33d1aa8f3d1f78");
            pSDEFieldModel.setName("PSDEVSLNNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f00\u653e\u65b9\u6848");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCMSPLATFORMNODE_PSDCMSPLATFORM_PSDCMSPLATFORMID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDevSlnName");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSMSPLATFORMNODEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f59937cbe406f0e48e63c84bca9a325c");
            pSDEFieldModel.setName("PSMSPLATFORMNODEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e73\u53f0\u5fae\u670d\u52a1\u5e73\u53f0\u8282\u70b9");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCMSPLATFORMNODE_PSMSPLATFORMNODE_PSMSPLATFORMNODEID");
            pSDEFieldModel.setLinkDEFName("PSMSPLATFORMNODEID");
            pSDEFieldModel.setCodeName("PSMSPlatformNodeId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSMSPLATFORMNODEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSMSPLATFORMNODEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSMSPLATFORMNODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4ae5254f7f7f924b446474a211124fb9");
            pSDEFieldModel.setName("PSMSPLATFORMNODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e73\u53f0\u5fae\u670d\u52a1\u5e73\u53f0\u8282\u70b9");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCMSPLATFORMNODE_PSMSPLATFORMNODE_PSMSPLATFORMNODEID");
            pSDEFieldModel.setLinkDEFName("PSMSPLATFORMNODENAME");
            pSDEFieldModel.setCodeName("PSMSPlatformNodeName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSMSPLATFORMNODENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSMSPLATFORMNODENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSMSPLATFORMNODENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSMSPLATFORMNODENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFCOUNT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b64d5eb23deffe2b93cc5cfcec759708");
            pSDEFieldModel.setName("REFCOUNT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u6b21\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("RefCount");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFINFO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("eef70b38b3448723940012ec0fbd0d25");
            pSDEFieldModel.setName("REFINFO");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u4fe1\u606f");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("RefInfo");
            pSDEFieldModel.setLength(2000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REPLICATED");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4b9f7e7e596f6af90e1bed0a943724b7");
            pSDEFieldModel.setName("REPLICATED");
            pSDEFieldModel.setDEFType(5);
            pSDEFieldModel.setLogicName("\u8fd0\u884c\u526f\u672c");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("Replicated");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SCALE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("155e37f162332f75d55a495306dcaf84");
            pSDEFieldModel.setName("SCALE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9884\u671f\u89c4\u683c");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Scale");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SERVICEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3d2bee33d7f21e3bb48eb9ce2d6cca9a");
            pSDEFieldModel.setName("SERVICEID");
            pSDEFieldModel.setDEFType(5);
            pSDEFieldModel.setLogicName("\u670d\u52a1\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("ServiceId");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SERVICENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cc7c034d9a72b78d25e83735e365e115");
            pSDEFieldModel.setName("SERVICENAME");
            pSDEFieldModel.setDEFType(5);
            pSDEFieldModel.setLogicName("\u670d\u52a1\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("ServiceName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SERVICEURL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("99f0d5d1f4c1d8a7e0e132818ae0ec45");
            pSDEFieldModel.setName("SERVICEURL");
            pSDEFieldModel.setDEFType(5);
            pSDEFieldModel.setLogicName("\u670d\u52a1\u8def\u5f84");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("ServiceUrl");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SSHIPADDR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ee58151da53954ac71f9e4beca072f63");
            pSDEFieldModel.setName("SSHIPADDR");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("SSH IP\u5730\u5740");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("SSHIPAddr");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SSHPORT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2b0f841bfe8ed73a29aabed266f2455c");
            pSDEFieldModel.setName("SSHPORT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("SSH\u4e3b\u673a\u7aef\u53e3");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("SSHPort");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("975266ed312411b102629f8326636a1f");
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
            pSDEFieldModel.setId("bc363c02fe1e0fb284722ce14078df17");
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
        object = this.createDEField("UPLOADFILEMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("590ef67829b2def942563e4816ea0865");
            pSDEFieldModel.setName("UPLOADFILEMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e0a\u4f20\u6587\u4ef6\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ASFileUploadModeCodeListModel");
            pSDEFieldModel.setCodeName("UploadFileMode");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_UPLOADFILEMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_UPLOADFILEMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPLOADPATH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0ef11a90c882b63b8521439b6d686f66");
            pSDEFieldModel.setName("UPLOADPATH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6587\u4ef6\u4e0a\u4f20\u8def\u5f84");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UploadPath");
            pSDEFieldModel.setLength(250);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0feda0d06d0748e69056f8f34e08acd0");
            pSDEFieldModel.setName("USERNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e3b\u673a\u7528\u6237\u540d");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserName");
            pSDEFieldModel.setLength(40);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("190a9188458d7f07e23645db311fe9e7");
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
        object = this.createDEField("USERTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0e6e8f0a48d53f95dd1e5f0e7575fc23");
            pSDEFieldModel.setName("USERTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("950a946c431c6c4f6f8f2f23b2f075bf");
            pSDEFieldModel.setName("USERTAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb02");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag2");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f573057826f42c00142c17cefa30c1ca");
            pSDEFieldModel.setName("USERTAG3");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb03");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag3");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG4");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("69b28671e9cef8a5f8f7c4a09bffe819");
            pSDEFieldModel.setName("USERTAG4");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb04");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag4");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VALIDFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8377cbc59c9d182e587c0b293393b775");
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
        object = this.createDEField("WORKSHOPPATH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0b383dfea76238a1cc8b6dbaa68a1c1d");
            pSDEFieldModel.setName("WORKSHOPPATH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5de5\u7a0b\u76ee\u5f55\u8def\u5f84");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("WorkshopPath");
            pSDEFieldModel.setLength(250);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSDCMSPlatformNodeDefaultACModel pSDCMSPlatformNodeDefaultACModel = new PSDCMSPlatformNodeDefaultACModel();
        pSDCMSPlatformNodeDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDCMSPlatformNodeDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDCMSPlatformNodeAPINodeDSModel pSDCMSPlatformNodeAPINodeDSModel = new PSDCMSPlatformNodeAPINodeDSModel();
        pSDCMSPlatformNodeAPINodeDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCMSPlatformNodeAPINodeDSModel);
        PSDCMSPlatformNodeAppNodeDSModel pSDCMSPlatformNodeAppNodeDSModel = new PSDCMSPlatformNodeAppNodeDSModel();
        pSDCMSPlatformNodeAppNodeDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCMSPlatformNodeAppNodeDSModel);
        PSDCMSPlatformNodeCurMSPDSModel pSDCMSPlatformNodeCurMSPDSModel = new PSDCMSPlatformNodeCurMSPDSModel();
        pSDCMSPlatformNodeCurMSPDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCMSPlatformNodeCurMSPDSModel);
        PSDCMSPlatformNodeCurSlnDSModel pSDCMSPlatformNodeCurSlnDSModel = new PSDCMSPlatformNodeCurSlnDSModel();
        pSDCMSPlatformNodeCurSlnDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCMSPlatformNodeCurSlnDSModel);
        PSDCMSPlatformNodeDefaultDSModel pSDCMSPlatformNodeDefaultDSModel = new PSDCMSPlatformNodeDefaultDSModel();
        pSDCMSPlatformNodeDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCMSPlatformNodeDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDCMSPlatformNodeAPINodeDQModel pSDCMSPlatformNodeAPINodeDQModel = new PSDCMSPlatformNodeAPINodeDQModel();
        pSDCMSPlatformNodeAPINodeDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCMSPlatformNodeAPINodeDQModel);
        PSDCMSPlatformNodeAppNodeDQModel pSDCMSPlatformNodeAppNodeDQModel = new PSDCMSPlatformNodeAppNodeDQModel();
        pSDCMSPlatformNodeAppNodeDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCMSPlatformNodeAppNodeDQModel);
        PSDCMSPlatformNodeCurMSPDQModel pSDCMSPlatformNodeCurMSPDQModel = new PSDCMSPlatformNodeCurMSPDQModel();
        pSDCMSPlatformNodeCurMSPDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCMSPlatformNodeCurMSPDQModel);
        PSDCMSPlatformNodeCurSlnDQModel pSDCMSPlatformNodeCurSlnDQModel = new PSDCMSPlatformNodeCurSlnDQModel();
        pSDCMSPlatformNodeCurSlnDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCMSPlatformNodeCurSlnDQModel);
        PSDCMSPlatformNodeDefaultDQModel pSDCMSPlatformNodeDefaultDQModel = new PSDCMSPlatformNodeDefaultDQModel();
        pSDCMSPlatformNodeDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCMSPlatformNodeDefaultDQModel);
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
        this.registerPDTDEView("MDATAVIEW", "acda4ae0e1d5c5428e1455acee282c95");
        this.registerPDTDEView("MPICKUPVIEW", "ae92a070dbfbcd1e8884d18f333a19ef");
        this.registerPDTDEView("PICKUPVIEW", "385f564fb145b9cedb9ec1dfb093c5e0");
        this.registerPDTDEView("REDIRECTVIEW", "6317d797cf380caaabdc82a0948c61a2");
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
        dEDataSetCond2.setDEFName("PSDCMSPLATFORMNODENAME");
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
        pSDEFGroupDetailModel.setId("9485236bdaa5098039f5c610a545f081");
        pSDEFGroupDetailModel.setName("IPADDR");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("IPADDR", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1406258dc95d6894583e8920bdaa86ca");
        pSDEFGroupDetailModel.setName("IPADDR2");
        iPSDEFieldModel = this.getDEField("IPADDR2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9f68a02e9c53e2ac20da76a4c0e96a4f");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("fc9a3c170b0beb61d04c2a9236e3b4a4");
        pSDEFGroupDetailModel.setName("PSDCMSPLATFORMID");
        iPSDEFieldModel = this.getDEField("PSDCMSPLATFORMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("df7fd8a0f187ecd2d4d8b962171939d2");
        pSDEFGroupDetailModel.setName("PSDCMSPLATFORMNAME");
        iPSDEFieldModel = this.getDEField("PSDCMSPLATFORMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("25e71dcfd350edc6414baf9e9b5a490a");
        pSDEFGroupDetailModel.setName("PSDCMSPLATFORMNODENAME");
        iPSDEFieldModel = this.getDEField("PSDCMSPLATFORMNODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("81c964783e49905e7293f3d8714fa788");
        pSDEFGroupDetailModel.setName("PSDCREGISTRYITEMID");
        iPSDEFieldModel = this.getDEField("PSDCREGISTRYITEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ddd4a5d76580fe18c786734fbda0c9df");
        pSDEFGroupDetailModel.setName("PSDCREGISTRYITEMNAME");
        iPSDEFieldModel = this.getDEField("PSDCREGISTRYITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("dd60347cbb74969958835709a454582c");
        pSDEFGroupDetailModel.setName("PSDEVSLNID");
        iPSDEFieldModel = this.getDEField("PSDEVSLNID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6e1eedb5c08e01c74f6b0124305710dc");
        pSDEFGroupDetailModel.setName("PORT");
        iPSDEFieldModel = this.getDEField("PORT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("190a9188458d7f07e23645db311fe9e7");
        pSDEFGroupDetailModel.setName("USERPARAMS");
        iPSDEFieldModel = this.getDEField("USERPARAMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0e6e8f0a48d53f95dd1e5f0e7575fc23");
        pSDEFGroupDetailModel.setName("USERTAG");
        iPSDEFieldModel = this.getDEField("USERTAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("950a946c431c6c4f6f8f2f23b2f075bf");
        pSDEFGroupDetailModel.setName("USERTAG2");
        iPSDEFieldModel = this.getDEField("USERTAG2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f573057826f42c00142c17cefa30c1ca");
        pSDEFGroupDetailModel.setName("USERTAG3");
        iPSDEFieldModel = this.getDEField("USERTAG3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("69b28671e9cef8a5f8f7c4a09bffe819");
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

