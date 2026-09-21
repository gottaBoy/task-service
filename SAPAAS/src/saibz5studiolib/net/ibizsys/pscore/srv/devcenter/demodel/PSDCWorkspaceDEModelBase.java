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
package net.ibizsys.pscore.srv.devcenter.demodel;

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
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.ac.PSDCWorkspaceDefaultACModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataquery.PSDCWorkspaceCurDCAssignedDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataquery.PSDCWorkspaceCurDCDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataquery.PSDCWorkspaceCurDCUnassignedDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataquery.PSDCWorkspaceCurDCUnusedDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataquery.PSDCWorkspaceCurDCUsedDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataquery.PSDCWorkspaceCurSlnDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataquery.PSDCWorkspaceCurSlnUnusedDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataquery.PSDCWorkspaceCurSlnUsedDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataquery.PSDCWorkspaceDefaultDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataset.PSDCWorkspaceCurDCAssignedDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataset.PSDCWorkspaceCurDCDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataset.PSDCWorkspaceCurDCUnassignedDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataset.PSDCWorkspaceCurDCUnusedDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataset.PSDCWorkspaceCurDCUsedDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataset.PSDCWorkspaceCurSlnDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataset.PSDCWorkspaceCurSlnUnusedDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataset.PSDCWorkspaceCurSlnUsedDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.dataset.PSDCWorkspaceDefaultDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.uiaction.PSDCWorkspaceUninstallSysUIActionModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.uiaction.PSDCWorkspaceUnssignSlnUIActionModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;

public abstract class PSDCWorkspaceDEModelBase
extends PSDataEntityModelBase<PSDCWorkspace> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDCWorkspaceService pSDCWorkspaceService;

    public PSDCWorkspaceDEModelBase() throws Exception {
        this.setId("9e13adb2a6339405a8ca039107c50f30");
        this.setName("PSDCWORKSPACE");
        this.setCodeName("PSDCWorkspace");
        this.setTableName("T_SRFPSDCWORKSPACE");
        this.setViewName("v_PSDCWORKSPACE");
        this.setLogicName("\u4e2d\u5fc3\u751f\u4ea7\u7ebf");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCWorkspaceDEModel", (IDataEntityModel)this);
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

    public PSDCWorkspaceService getRealService() {
        if (this.pSDCWorkspaceService == null) {
            try {
                this.pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCWorkspaceService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService";
    }

    public PSDCWorkspace createEntity() {
        return new PSDCWorkspace();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("ACCESSUSERS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("41c20424c214141035db18f7171199f6");
            pSDEFieldModel.setName("ACCESSUSERS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6388\u6743\u8bbf\u95ee\u7528\u6237");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("AccessUsers");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ACTIONOWNER");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("553bac39966319d6ec7bc57302b894a8");
            pSDEFieldModel.setName("ACTIONOWNER");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u4f5c\u4e1a\u6240\u6709\u8005");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSWORKSPACE_PSWORKSPACEID");
            pSDEFieldModel.setLinkDEFName("ACTIONOWNER");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("ActionOwner");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ACTIONPARAM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("46ceeac0e3ed4e1c91fb1f2d95874a03");
            pSDEFieldModel.setName("ACTIONPARAM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4f5c\u4e1a\u53c2\u6570");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ActionParam");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ACTIONPARAM2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d871951fa4a5835f381dffffef0ca234");
            pSDEFieldModel.setName("ACTIONPARAM2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4f5c\u4e1a\u53c2\u65702");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ActionParam2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ACTIONPARAM3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("913aa42e7050a9972ab3283e2a151c4b");
            pSDEFieldModel.setName("ACTIONPARAM3");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4f5c\u4e1a\u53c2\u65703");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ActionParam3");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ACTIONPARAM4");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9b63af1ed18d1c52b63da9b249f0731f");
            pSDEFieldModel.setName("ACTIONPARAM4");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4f5c\u4e1a\u53c2\u65704");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ActionParam4");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0c666a1672b5ad64d906ea2b04564159");
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
            pSDEFieldModel.setId("a770ab64d1d3cf25ac78cab5ab5e9ce5");
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
        object = this.createDEField("CURACTION");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6546de2d1e671283458ab4b130606e6d");
            pSDEFieldModel.setName("CURACTION");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f53\u524d\u4f5c\u4e1a");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSWORKSPACE_PSWORKSPACEID");
            pSDEFieldModel.setLinkDEFName("CURACTION");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DCWorkspaceLogTypeCodeListModel");
            pSDEFieldModel.setCodeName("CurAction");
            pSDEFieldModel.setLength(20);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CURACTIVETIME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6d2c46e92ccd33022a4f7f2e57247abd");
            pSDEFieldModel.setName("CURACTIVETIME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f53\u524d\u6fc0\u6d3b\u65f6\u95f4");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(5);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSWORKSPACE_PSWORKSPACEID");
            pSDEFieldModel.setLinkDEFName("CURACTIVETIME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            pSDEFieldModel.setCodeName("CurActiveTime");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CUREXPIREDTIME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0b57684043fe4d9b9f159d42e05dbe06");
            pSDEFieldModel.setName("CUREXPIREDTIME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f53\u524d\u8fc7\u671f\u65f6\u95f4");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(5);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSWORKSPACE_PSWORKSPACEID");
            pSDEFieldModel.setLinkDEFName("CUREXPIREDTIME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            pSDEFieldModel.setCodeName("CurExpiredTime");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXP");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a9ca6bd1401e2f1fdca719d3fdf72494");
            pSDEFieldModel.setName("EXP");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u751f\u4ea7\u7ebf\u7ecf\u9a8c");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(6);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSWORKSPACE_PSWORKSPACEID");
            pSDEFieldModel.setLinkDEFName("EXP");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("Exp");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXP2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a8217be071c59d1e4d66a40f46e4ca60");
            pSDEFieldModel.setName("EXP2");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u751f\u4ea7\u7ebf\u7ecf\u9a8c2");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(6);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSWORKSPACE_PSWORKSPACEID");
            pSDEFieldModel.setLinkDEFName("EXP2");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("Exp2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXPIREDTIME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("83d76c0c69577c420b707d59c08109e2");
            pSDEFieldModel.setName("EXPIREDTIME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8fc7\u671f\u65f6\u95f4");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(5);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSWORKSPACE_PSWORKSPACEID");
            pSDEFieldModel.setLinkDEFName("EXPIREDTIME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            pSDEFieldModel.setCodeName("ExpiredTime");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("IPADDRS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("622ff967c93002540f552af88642d708");
            pSDEFieldModel.setName("IPADDRS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8bbf\u95eeIP\u5730\u5740");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("IPAddrs");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a9949d5953c41878b7e67f4ddad8a91b");
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
        object = this.createDEField("PSDCWORKSPACEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("18f5e3443a3aa9e3cf058fa536f8280f");
            pSDEFieldModel.setName("PSDCWORKSPACEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDCWorkspaceId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDCWORKSPACENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("58574ef901fd0608ca8983ff8280085a");
            pSDEFieldModel.setName("PSDCWORKSPACENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u751f\u4ea7\u7ebf\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSDCWorkspaceName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCWORKSPACENAME_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDCWORKSPACENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVCENTERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1e844791398d9849252efaa55b5c2682");
            pSDEFieldModel.setName("PSDEVCENTERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u4e2d\u5fc3");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSDEVCENTER_PSDEVCENTERID");
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
            pSDEFieldModel.setId("163e2317fb19453d339060726a5af926");
            pSDEFieldModel.setName("PSDEVCENTERNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u4e2d\u5fc3");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSDEVCENTER_PSDEVCENTERID");
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
        object = this.createDEField("PSDEVSLNID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("31e22b29a08384d51cca6e4230900b7c");
            pSDEFieldModel.setName("PSDEVSLNID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5206\u914d\u5f00\u53d1\u65b9\u6848");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSDEVSLN_PSDEVSLNID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNID");
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
            pSDEFieldModel.setId("49345d5d393724af4b53ce155168838b");
            pSDEFieldModel.setName("PSDEVSLNNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5206\u914d\u5f00\u53d1\u65b9\u6848");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSDEVSLN_PSDEVSLNID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(0);
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
        object = this.createDEField("PSDEVSLNSYSID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("98f588fa367ec5bdf7a0a9b927604e2a");
            pSDEFieldModel.setName("PSDEVSLNSYSID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f53\u524d\u5f00\u53d1\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSDEVSLNSYS_PSDEVSLNSYSID");
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
            pSDEFieldModel.setId("290217f1da5320a49666b3c1806abc07");
            pSDEFieldModel.setName("PSDEVSLNSYSNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f53\u524d\u5f00\u53d1\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSDEVSLNSYS_PSDEVSLNSYSID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNSYSNAME");
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
        object = this.createDEField("PSWORKSPACEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8912fb001f38b699b55ca08676d4140d");
            pSDEFieldModel.setName("PSWORKSPACEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e73\u53f0\u751f\u4ea7\u7ebf");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSWORKSPACE_PSWORKSPACEID");
            pSDEFieldModel.setLinkDEFName("PSWORKSPACEID");
            pSDEFieldModel.setCodeName("PSWorkspaceId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSWORKSPACEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSWORKSPACEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSWORKSPACENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("aaef13b13151954a46f2a26941a28673");
            pSDEFieldModel.setName("PSWORKSPACENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e73\u53f0\u751f\u4ea7\u7ebf");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSWORKSPACE_PSWORKSPACEID");
            pSDEFieldModel.setLinkDEFName("PSWORKSPACENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSWorkspaceName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSWORKSPACENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSWORKSPACENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSWORKSPACENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSWORKSPACENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RESSTATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bc20debd9585699c29895fc856e034b2");
            pSDEFieldModel.setName("RESSTATE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8d44\u6e90\u72b6\u6001");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DevCenterResStateCodeListModel");
            pSDEFieldModel.setCodeName("ResState");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_RESSTATE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_RESSTATE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
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
            pSDEFieldModel.setId("84bb61d3bee2e844bc30a9466ceb0429");
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
            pSDEFieldModel.setId("094f3d58eb39f0a790cc96ed8ce6c31a");
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
        object = this.createDEField("WORKSPACELEVEL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7a66a9c155023eb4b1a3740ceedf6c8d");
            pSDEFieldModel.setName("WORKSPACELEVEL");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u751f\u4ea7\u7ebf\u7ea7\u522b");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSWORKSPACE_PSWORKSPACEID");
            pSDEFieldModel.setLinkDEFName("WORKSPACELEVEL");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("WorkspaceLevel");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WORKSPACESTATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("83ffc0e10313b8bd98ba38ffa04127aa");
            pSDEFieldModel.setName("WORKSPACESTATE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u751f\u4ea7\u7ebf\u72b6\u6001");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSWORKSPACE_PSWORKSPACEID");
            pSDEFieldModel.setLinkDEFName("WORKSPACESTATE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.SVNRepoState2CodeListModel");
            pSDEFieldModel.setCodeName("WorkspaceState");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WORKSPACETYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bbbdc6a682d739e05bff039dbfaf4b99");
            pSDEFieldModel.setName("WORKSPACETYPE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u751f\u4ea7\u7ebf\u7c7b\u578b");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSWORKSPACE_PSWORKSPACEID");
            pSDEFieldModel.setLinkDEFName("WORKSPACETYPE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.WorkspaceTypeCodeListModel");
            pSDEFieldModel.setCodeName("WorkspaceType");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WORKSPACEUPDATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("840a2f954166863d7646fb5c750c6b68");
            pSDEFieldModel.setName("WORKSPACEUPDATEDATE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u751f\u4ea7\u7ebf\u66f4\u65b0\u65f6\u95f4");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(5);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSWORKSPACE_PSWORKSPACEID");
            pSDEFieldModel.setLinkDEFName("UPDATEDATE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            pSDEFieldModel.setCodeName("WorkspaceUpdateDate");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WORKSPACEUSAGE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("201ffdb80697f51a3c3c36177eb4de38");
            pSDEFieldModel.setName("WORKSPACEUSAGE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u751f\u4ea7\u7ebf\u7528\u9014");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCWORKSPACE_PSWORKSPACE_PSWORKSPACEID");
            pSDEFieldModel.setLinkDEFName("WORKSPACEUSAGE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.WorkspaceUsageCodeListModel");
            pSDEFieldModel.setCodeName("WorkspaceUsage");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSDCWorkspaceDefaultACModel pSDCWorkspaceDefaultACModel = new PSDCWorkspaceDefaultACModel();
        pSDCWorkspaceDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDCWorkspaceDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDCWorkspaceCurDCDSModel pSDCWorkspaceCurDCDSModel = new PSDCWorkspaceCurDCDSModel();
        pSDCWorkspaceCurDCDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCWorkspaceCurDCDSModel);
        PSDCWorkspaceCurDCAssignedDSModel pSDCWorkspaceCurDCAssignedDSModel = new PSDCWorkspaceCurDCAssignedDSModel();
        pSDCWorkspaceCurDCAssignedDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCWorkspaceCurDCAssignedDSModel);
        PSDCWorkspaceCurDCUnassignedDSModel pSDCWorkspaceCurDCUnassignedDSModel = new PSDCWorkspaceCurDCUnassignedDSModel();
        pSDCWorkspaceCurDCUnassignedDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCWorkspaceCurDCUnassignedDSModel);
        PSDCWorkspaceCurDCUnusedDSModel pSDCWorkspaceCurDCUnusedDSModel = new PSDCWorkspaceCurDCUnusedDSModel();
        pSDCWorkspaceCurDCUnusedDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCWorkspaceCurDCUnusedDSModel);
        PSDCWorkspaceCurDCUsedDSModel pSDCWorkspaceCurDCUsedDSModel = new PSDCWorkspaceCurDCUsedDSModel();
        pSDCWorkspaceCurDCUsedDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCWorkspaceCurDCUsedDSModel);
        PSDCWorkspaceCurSlnDSModel pSDCWorkspaceCurSlnDSModel = new PSDCWorkspaceCurSlnDSModel();
        pSDCWorkspaceCurSlnDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCWorkspaceCurSlnDSModel);
        PSDCWorkspaceCurSlnUnusedDSModel pSDCWorkspaceCurSlnUnusedDSModel = new PSDCWorkspaceCurSlnUnusedDSModel();
        pSDCWorkspaceCurSlnUnusedDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCWorkspaceCurSlnUnusedDSModel);
        PSDCWorkspaceCurSlnUsedDSModel pSDCWorkspaceCurSlnUsedDSModel = new PSDCWorkspaceCurSlnUsedDSModel();
        pSDCWorkspaceCurSlnUsedDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCWorkspaceCurSlnUsedDSModel);
        PSDCWorkspaceDefaultDSModel pSDCWorkspaceDefaultDSModel = new PSDCWorkspaceDefaultDSModel();
        pSDCWorkspaceDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCWorkspaceDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDCWorkspaceCurDCDQModel pSDCWorkspaceCurDCDQModel = new PSDCWorkspaceCurDCDQModel();
        pSDCWorkspaceCurDCDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCWorkspaceCurDCDQModel);
        PSDCWorkspaceCurDCAssignedDQModel pSDCWorkspaceCurDCAssignedDQModel = new PSDCWorkspaceCurDCAssignedDQModel();
        pSDCWorkspaceCurDCAssignedDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCWorkspaceCurDCAssignedDQModel);
        PSDCWorkspaceCurDCUnassignedDQModel pSDCWorkspaceCurDCUnassignedDQModel = new PSDCWorkspaceCurDCUnassignedDQModel();
        pSDCWorkspaceCurDCUnassignedDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCWorkspaceCurDCUnassignedDQModel);
        PSDCWorkspaceCurDCUnusedDQModel pSDCWorkspaceCurDCUnusedDQModel = new PSDCWorkspaceCurDCUnusedDQModel();
        pSDCWorkspaceCurDCUnusedDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCWorkspaceCurDCUnusedDQModel);
        PSDCWorkspaceCurDCUsedDQModel pSDCWorkspaceCurDCUsedDQModel = new PSDCWorkspaceCurDCUsedDQModel();
        pSDCWorkspaceCurDCUsedDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCWorkspaceCurDCUsedDQModel);
        PSDCWorkspaceCurSlnDQModel pSDCWorkspaceCurSlnDQModel = new PSDCWorkspaceCurSlnDQModel();
        pSDCWorkspaceCurSlnDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCWorkspaceCurSlnDQModel);
        PSDCWorkspaceCurSlnUnusedDQModel pSDCWorkspaceCurSlnUnusedDQModel = new PSDCWorkspaceCurSlnUnusedDQModel();
        pSDCWorkspaceCurSlnUnusedDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCWorkspaceCurSlnUnusedDQModel);
        PSDCWorkspaceCurSlnUsedDQModel pSDCWorkspaceCurSlnUsedDQModel = new PSDCWorkspaceCurSlnUsedDQModel();
        pSDCWorkspaceCurSlnUsedDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCWorkspaceCurSlnUsedDQModel);
        PSDCWorkspaceDefaultDQModel pSDCWorkspaceDefaultDQModel = new PSDCWorkspaceDefaultDQModel();
        pSDCWorkspaceDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCWorkspaceDefaultDQModel);
    }

    protected void prepareDEActions() throws Exception {
    }

    protected void prepareDELogics() throws Exception {
    }

    @Override
    protected void onPrepareDEUIActions() throws Exception {
        PSDCWorkspaceUninstallSysUIActionModel pSDCWorkspaceUninstallSysUIActionModel = new PSDCWorkspaceUninstallSysUIActionModel();
        pSDCWorkspaceUninstallSysUIActionModel.init((IDataEntity)this);
        this.registerDEUIAction((IDEUIAction)pSDCWorkspaceUninstallSysUIActionModel);
        PSDCWorkspaceUnssignSlnUIActionModel pSDCWorkspaceUnssignSlnUIActionModel = new PSDCWorkspaceUnssignSlnUIActionModel();
        pSDCWorkspaceUnssignSlnUIActionModel.init((IDataEntity)this);
        this.registerDEUIAction((IDEUIAction)pSDCWorkspaceUnssignSlnUIActionModel);
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
        this.registerPDTDEView("EDITVIEW", "822bdf17f8351f545b17922d825605fd");
        this.registerPDTDEView("MDATAVIEW", "7d989f1a8a5dd8963e4b7101e1f0bd33");
        this.registerPDTDEView("MPICKUPVIEW", "a0b5137d38001c36299002ce0190c17e");
        this.registerPDTDEView("PICKUPVIEW", "6ccc2f8f1d221865cbc13bbc5c27d3cb");
        this.registerPDTDEView("REDIRECTVIEW", "02372aab78da0d4fb14828695b64d903");
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
        dEDataSetCond2.setDEFName("PSDCWORKSPACENAME");
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
        pSDEFGroupDetailModel.setId("58574ef901fd0608ca8983ff8280085a");
        pSDEFGroupDetailModel.setName("PSDCWORKSPACENAME");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSDCWORKSPACENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

