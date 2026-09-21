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
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.ac.PSDevSlnTemplDefaultACModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataquery.PSDevSlnTemplCurSlnDQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataquery.PSDevSlnTemplCurSlnTrunkDQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataquery.PSDevSlnTemplCurTemplBranchDQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataquery.PSDevSlnTemplCurUser3DQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataquery.PSDevSlnTemplCurUser4DQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataquery.PSDevSlnTemplCurUser5DQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataquery.PSDevSlnTemplCurUser6DQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataquery.PSDevSlnTemplCurUserDQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataquery.PSDevSlnTemplCurUserTrunk3DQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataquery.PSDevSlnTemplCurUserTrunk4DQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataquery.PSDevSlnTemplCurUserTrunk5DQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataquery.PSDevSlnTemplCurUserTrunk6DQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataquery.PSDevSlnTemplCurUserTrunkDQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataquery.PSDevSlnTemplDefaultDQModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataset.PSDevSlnTemplCurSlnDSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataset.PSDevSlnTemplCurSlnTrunkDSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataset.PSDevSlnTemplCurTemplBranchDSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataset.PSDevSlnTemplCurUser3DSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataset.PSDevSlnTemplCurUser4DSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataset.PSDevSlnTemplCurUserAllDSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataset.PSDevSlnTemplCurUserDSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataset.PSDevSlnTemplCurUserTrunk3DSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataset.PSDevSlnTemplCurUserTrunk4DSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataset.PSDevSlnTemplCurUserTrunk5DSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataset.PSDevSlnTemplCurUserTrunk6DSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataset.PSDevSlnTemplCurUserTrunkDSModel;
import net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataset.PSDevSlnTemplDefaultDSModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;

public abstract class PSDevSlnTemplDEModelBase
extends PSDataEntityModelBase<PSDevSlnTempl> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDevSlnTemplService pSDevSlnTemplService;

    public PSDevSlnTemplDEModelBase() throws Exception {
        this.setId("cfd6002cde4eb3e0669af3a0deeac485");
        this.setName("PSDEVSLNTEMPL");
        this.setCodeName("PSDevSlnTempl");
        this.setTableName("T_SRFPSDEVSLNTEMPL");
        this.setViewName("v_PSDEVSLNTEMPL");
        this.setLogicName("\u5f00\u53d1\u6a21\u677f");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnTemplDEModel", (IDataEntityModel)this);
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

    public PSDevSlnTemplService getRealService() {
        if (this.pSDevSlnTemplService == null) {
            try {
                this.pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnTemplService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService";
    }

    public PSDevSlnTempl createEntity() {
        return new PSDevSlnTempl();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("ACTIONOWNER");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b64943e39ed5332a6f933c75605c38b0");
            pSDEFieldModel.setName("ACTIONOWNER");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u64cd\u4f5c\u6240\u6709\u8005");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("ActionOwner");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("51bfc9d1d22c6e39134460e42ef334e3");
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
            pSDEFieldModel.setId("bc052561c8c803e7a42b3925b8bf6c7d");
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
            pSDEFieldModel.setId("c939d97b2566bca95e3cec6a335138b3");
            pSDEFieldModel.setName("CURACTION");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f53\u524d\u64cd\u4f5c");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DevSysActionCodeListModel");
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("CurAction");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CURACTION_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CURACTION_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEVTEMPLSTATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e0fbc3d50b2ce9ef003bc7dfd61f81b7");
            pSDEFieldModel.setName("DEVTEMPLSTATE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u6a21\u677f\u72b6\u6001");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel");
            pSDEFieldModel.setCodeName("DevTemplState");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEVTEMPLSTATE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEVTEMPLSTATE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLEREF");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1c16de8649cc92f45481d2b034a267ec");
            pSDEFieldModel.setName("ENABLEREF");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u652f\u6301\u5916\u90e8\u5f15\u7528");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableRef");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXPRIEDTIME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("edac1f58f0df3c30db265eca924f4ddd");
            pSDEFieldModel.setName("EXPRIEDTIME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8fc7\u671f\u65f6\u95f4");
            pSDEFieldModel.setDataType("DATETIME");
            pSDEFieldModel.setStdDataType(5);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            pSDEFieldModel.setCodeName("ExpriedTime");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("GITBRANCH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9e411e2525be12995e7671ffb6c41a3a");
            pSDEFieldModel.setName("GITBRANCH");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("Git\u4ed3\u5e93\u5206\u652f");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVCENTERSVN_PSDEVCENTERSVNID");
            pSDEFieldModel.setLinkDEFName("GITBRANCH");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("GitBranch");
            pSDEFieldModel.setLength(250);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("GITPATH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("856eab2156e7c2947b645e01b5abcf92");
            pSDEFieldModel.setName("GITPATH");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("Git\u4ed3\u5e93\u8def\u5f84");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVCENTERSVN_PSDEVCENTERSVNID");
            pSDEFieldModel.setLinkDEFName("GITPATH");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("GitPath");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LASTACTIVETIME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7b051c8e518aef5afd1833fc5ac077d2");
            pSDEFieldModel.setName("LASTACTIVETIME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6700\u540e\u6d3b\u52a8\u65f6\u95f4");
            pSDEFieldModel.setDataType("DATETIME");
            pSDEFieldModel.setStdDataType(5);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            pSDEFieldModel.setCodeName("LastActiveTime");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LASTPUBDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a26ed36bde910f342b8a8d8497d1d75c");
            pSDEFieldModel.setName("LASTPUBDATE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6700\u540e\u53d1\u5e03\u65f6\u95f4");
            pSDEFieldModel.setDataType("DATETIME");
            pSDEFieldModel.setStdDataType(5);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setValueFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
            pSDEFieldModel.setCodeName("LastPubDate");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LOGICNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cd06557ed99d3bf6305c70e2a8b154a4");
            pSDEFieldModel.setName("LOGICNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u903b\u8f91\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("LogicName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MAINPSDEVSLNTEMPLID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2518550d8fbd626b42fd314f690869c2");
            pSDEFieldModel.setName("MAINPSDEVSLNTEMPLID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e3b\u6a21\u677f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVSLNTEMPL_MAINPSDEVSLNTEMPLID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNTEMPLID");
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("MainPSDevSlnTemplId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MAINPSDEVSLNTEMPLNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ce6b9dfe160b6f44d549ed69b5892575");
            pSDEFieldModel.setName("MAINPSDEVSLNTEMPLNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e3b\u6a21\u677f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVSLNTEMPL_MAINPSDEVSLNTEMPLID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNTEMPLNAME");
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("MainPSDevSlnTemplName");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6d72543fdfc162a1f4b8980ad5b73bbe");
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
        object = this.createDEField("PKGPARAM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d1b69cacb52d08afae8f3fac4ee568ea");
            pSDEFieldModel.setName("PKGPARAM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7ec4\u4ef6\u5305\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PkgParam");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PKGPARAM2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("071ebef81f835abb1d362c5492b9683d");
            pSDEFieldModel.setName("PKGPARAM2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7ec4\u4ef6\u5305\u53c2\u65702");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PkgParam2");
            pSDEFieldModel.setLength(1000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PKGPARAM3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("30912d5251878730b86c6f898bc79c87");
            pSDEFieldModel.setName("PKGPARAM3");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7ec4\u4ef6\u5305\u53c2\u65703");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PkgParam3");
            pSDEFieldModel.setLength(1000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PKGPARAM4");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d8a487bbf221a5b641c832f0a079c50b");
            pSDEFieldModel.setName("PKGPARAM4");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7ec4\u4ef6\u5305\u53c2\u65704");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PkgParam4");
            pSDEFieldModel.setLength(1000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PPSDEVSLNTEMPLID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1817779813e009edb5502cbdbe96df11");
            pSDEFieldModel.setName("PPSDEVSLNTEMPLID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7236\u6a21\u677f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVSLNTEMPL_PPSDEVSLNTEMPLID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNTEMPLID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PPSDevSlnTemplId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PPSDEVSLNTEMPLNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("829bec3127015edd97d4e89ce52bb7b1");
            pSDEFieldModel.setName("PPSDEVSLNTEMPLNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7236\u6a21\u677f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVSLNTEMPL_PPSDEVSLNTEMPLID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNTEMPLNAME");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PPSDevSlnTemplName");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVCENTERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3fe871fb0106e334d395bb0a66577800");
            pSDEFieldModel.setName("PSDEVCENTERID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u4e2d\u5fc3\u6807\u8bc6");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVSLN_PSDEVSLNID");
            pSDEFieldModel.setLinkDEFName("PSDEVCENTERID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDevCenterId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVCENTERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("beba8600efa7286aa2e67225c25d5104");
            pSDEFieldModel.setName("PSDEVCENTERNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u4e91\u5e94\u7528\u4e2d\u5fc3\u540d\u79f0");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVSLN_PSDEVSLNID");
            pSDEFieldModel.setLinkDEFName("PSDEVCENTERNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDevCenterName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVCENTERSVNID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5bf6747a27dc55912794af19258734cc");
            pSDEFieldModel.setName("PSDEVCENTERSVNID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u5fc3\u7248\u672c\u5e93");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVCENTERSVN_PSDEVCENTERSVNID");
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
            pSDEFieldModel.setId("a7856cdc99f3b033144e41d55c1a028f");
            pSDEFieldModel.setName("PSDEVCENTERSVNNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u5fc3\u7248\u672c\u5e93");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVCENTERSVN_PSDEVCENTERSVNID");
            pSDEFieldModel.setLinkDEFName("PSDEVCENTERSVNNAME");
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
            pSDEFieldModel.setId("177e7353a5c8308525f9b9ee748254b9");
            pSDEFieldModel.setName("PSDEVSLNID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u65b9\u6848");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVSLN_PSDEVSLNID");
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
            pSDEFieldModel.setId("f3dc5f97815a619aee30376be339cc63");
            pSDEFieldModel.setName("PSDEVSLNNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u65b9\u6848");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVSLN_PSDEVSLNID");
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
        object = this.createDEField("PSDEVSLNSYSAPPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("693b3033afac473a18bfa02b0013f8b9");
            pSDEFieldModel.setName("PSDEVSLNSYSAPPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u5e94\u7528");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVSLNSYSAPP_PSDEVSLNSYSAPPID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNSYSAPPID");
            pSDEFieldModel.setCodeName("PSDevSlnSysAppId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNSYSAPPID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNSYSAPPID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNSYSAPPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("abb259d3003b784709393a68c75f236d");
            pSDEFieldModel.setName("PSDEVSLNSYSAPPNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u5e94\u7528");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVSLNSYSAPP_PSDEVSLNSYSAPPID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNSYSAPPNAME");
            pSDEFieldModel.setCodeName("PSDevSlnSysAppName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNSYSAPPNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNSYSAPPNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNSYSAPPNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNSYSAPPNAME_LIKE");
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
            pSDEFieldModel.setId("0b82b43066174de189791c8afc93cdf3");
            pSDEFieldModel.setName("PSDEVSLNSYSID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8c03\u8bd5\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVSLNSYS_PSDEVSLNSYSID");
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
            pSDEFieldModel.setId("0e47d9be94a70fd20a004ede752bed6f");
            pSDEFieldModel.setName("PSDEVSLNSYSNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8c03\u8bd5\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVSLNSYS_PSDEVSLNSYSID");
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
        object = this.createDEField("PSDEVSLNSYSSRVID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("67ca875cdb86380212b5709735824806");
            pSDEFieldModel.setName("PSDEVSLNSYSSRVID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540e\u53f0\u4f53\u7cfb");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVSLNSYSSRV_PSDEVSLNSYSSRVID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNSYSSRVID");
            pSDEFieldModel.setCodeName("PSDevSlnSysSrvId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNSYSSRVID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNSYSSRVID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNSYSSRVNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2fbee805e72287018eb620b7950c98aa");
            pSDEFieldModel.setName("PSDEVSLNSYSSRVNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540e\u53f0\u4f53\u7cfb");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSDEVSLNSYSSRV_PSDEVSLNSYSSRVID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNSYSSRVNAME");
            pSDEFieldModel.setCodeName("PSDevSlnSysSrvName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNSYSSRVNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNSYSSRVNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNSYSSRVNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNSYSSRVNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNTEMPLID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a451c047fef11595ebb992e93a87bbb7");
            pSDEFieldModel.setName("PSDEVSLNTEMPLID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u6a21\u677f\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDevSlnTemplId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNTEMPLNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9a62d25165e0ed6025bfea4c9604da4a");
            pSDEFieldModel.setName("PSDEVSLNTEMPLNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u677f\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDevSlnTemplName");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVSLNTEMPLNAME_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVSLNTEMPLNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSPFID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5b12b4328384b7d0608609aa5f5ac6ee");
            pSDEFieldModel.setName("PSPFID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6a21\u677f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSPF_PSPFID");
            pSDEFieldModel.setLinkDEFName("PSPFID");
            pSDEFieldModel.setCodeName("PSPFId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSPFID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSPFID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSPFNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("79848038858a24cc256e8dcfb25beaaf");
            pSDEFieldModel.setName("PSPFNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6a21\u677f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSPF_PSPFID");
            pSDEFieldModel.setLinkDEFName("PSPFNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSPFName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSPFNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSPFNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSPFNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSPFNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSPFSTYLEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9b4eac370c03094c7409a630baa8b871");
            pSDEFieldModel.setName("PSPFSTYLEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6a21\u677f\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSPFSTYLE_PSPFSTYLEID");
            pSDEFieldModel.setLinkDEFName("PSPFSTYLEID");
            pSDEFieldModel.setCodeName("PSPFStyleId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSPFSTYLEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSPFSTYLEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSPFSTYLENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("af6d7624034174f16cc0662d82117086");
            pSDEFieldModel.setName("PSPFSTYLENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6a21\u677f\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSPFSTYLE_PSPFSTYLEID");
            pSDEFieldModel.setLinkDEFName("PSPFSTYLENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSPFStyleName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSPFSTYLENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSPFSTYLENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSPFSTYLENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSPFSTYLENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSFID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ce8e7b4c2cd992fa1b9d33bebc716fbf");
            pSDEFieldModel.setName("PSSFID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540e\u53f0\u4f53\u7cfb\u6a21\u677f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSSF_PSSFID");
            pSDEFieldModel.setLinkDEFName("PSSFID");
            pSDEFieldModel.setCodeName("PSSFId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSFID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSFID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSFNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a86e2d8aa68d06408464d973c67b14e6");
            pSDEFieldModel.setName("PSSFNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u540e\u53f0\u4f53\u7cfb\u6a21\u677f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSSF_PSSFID");
            pSDEFieldModel.setLinkDEFName("PSSFNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSSFName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSFNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSFNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSFNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSFNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSFSTYLEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1253ec9ec8f4385cff93215bf8634507");
            pSDEFieldModel.setName("PSSFSTYLEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540e\u53f0\u6a21\u677f\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSSFSTYLE_PSSFSTYLEID");
            pSDEFieldModel.setLinkDEFName("PSSFSTYLEID");
            pSDEFieldModel.setCodeName("PSSFStyleId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSFSTYLEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSFSTYLEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSFSTYLENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b0ee0554a1c1e4de9e6a66e23d7f9c71");
            pSDEFieldModel.setName("PSSFSTYLENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u540e\u53f0\u6a21\u677f\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSSFSTYLE_PSSFSTYLEID");
            pSDEFieldModel.setLinkDEFName("PSSFSTYLENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSSFStyleName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSFSTYLENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSFSTYLENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSFSTYLENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSFSTYLENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PUBMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("dc88244afbbfb03612275aa8782e0dc6");
            pSDEFieldModel.setName("PUBMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u516c\u5f00\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PSPFPubModesCodeListModel");
            pSDEFieldModel.setCodeName("PubMode");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PUBMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PUBMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFCODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f6c990de749010673ce29a0bc6b1a047");
            pSDEFieldModel.setName("REFCODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u4ee3\u7801");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("RefCode");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("STYLECODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("799a8ed148460ce280c5458ca4e90bd4");
            pSDEFieldModel.setName("STYLECODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6837\u5f0f\u4ee3\u7801");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("StyleCode");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_STYLECODE_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_STYLECODE_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("STYLEENGINE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a05040a2982221fdbb340aaee5cb7c72");
            pSDEFieldModel.setName("STYLEENGINE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6837\u5f0f\u5f15\u64ce");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PSTemplEngineCodeListModel");
            pSDEFieldModel.setCodeName("StyleEngine");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_STYLEENGINE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_STYLEENGINE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPLMDURL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("06724b445cdfadf913003d6690b2b621");
            pSDEFieldModel.setName("TEMPLMDURL");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u677fMD\u8def\u5f84");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("TemplMDUrl");
            pSDEFieldModel.setLength(250);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPLPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6c998f1dc173b9b7eb13be22dd01a4cb");
            pSDEFieldModel.setName("TEMPLPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6837\u5f0f\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("TemplParams");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPLPSPFSTYLEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6c4575d17ca7a2624b85f41e2850e6c2");
            pSDEFieldModel.setName("TEMPLPSPFSTYLEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u7248\u5e94\u7528\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSPFSTYLE_TEMPLPSPFSTYLEID");
            pSDEFieldModel.setLinkDEFName("PSPFSTYLEID");
            pSDEFieldModel.setCodeName("TemplPSPFStyleId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TEMPLPSPFSTYLEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TEMPLPSPFSTYLEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPLPSPFSTYLENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("61d2be10f82104e2ac9deaa4c28c113e");
            pSDEFieldModel.setName("TEMPLPSPFSTYLENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6a21\u7248\u5e94\u7528\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSPFSTYLE_TEMPLPSPFSTYLEID");
            pSDEFieldModel.setLinkDEFName("PSPFSTYLENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("TemplPSPFStyleName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TEMPLPSPFSTYLENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TEMPLPSPFSTYLENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TEMPLPSPFSTYLENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TEMPLPSPFSTYLENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPLPSSFSTYLEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f998ab27ccddc9498786cc1bc7afe354");
            pSDEFieldModel.setName("TEMPLPSSFSTYLEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7ee7\u627f\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSSFSTYLE_TEMPLPSSFSTYLEID");
            pSDEFieldModel.setLinkDEFName("PSSFSTYLEID");
            pSDEFieldModel.setCodeName("TemplPSSFStyleId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TEMPLPSSFSTYLEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TEMPLPSSFSTYLEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPLPSSFSTYLENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a2d815122e85f00bce17d5cb9c97550e");
            pSDEFieldModel.setName("TEMPLPSSFSTYLENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7ee7\u627f\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVSLNTEMPL_PSSFSTYLE_TEMPLPSSFSTYLEID");
            pSDEFieldModel.setLinkDEFName("PSSFSTYLENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("TemplPSSFStyleName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TEMPLPSSFSTYLENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TEMPLPSSFSTYLENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TEMPLPSSFSTYLENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TEMPLPSSFSTYLENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPLTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ebf35acafbddac27da94021aa8a08d24");
            pSDEFieldModel.setName("TEMPLTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u677f\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("TemplTag");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPLTAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6e6092490e28fb57ddf8fc0a9c5c34b2");
            pSDEFieldModel.setName("TEMPLTAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u677f\u6807\u8bb02");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("TemplTag2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPLTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4cc883c7568af0406fb526c00556c0cd");
            pSDEFieldModel.setName("TEMPLTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u677f\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DevSlnTemplTypeCodeListModel");
            pSDEFieldModel.setCodeName("TemplType");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TEMPLTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TEMPLTYPE_EQ");
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
            pSDEFieldModel.setId("239365c7bf688a01ecdb059b570b1233");
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
            pSDEFieldModel.setId("dc2b91ecac6570240bd1fde0092fc040");
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
            pSDEFieldModel.setId("c71467ff22140fc765e7ed4ca27d5821");
            pSDEFieldModel.setName("USERCAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u5206\u7c7b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelUserCatCodeListModel");
            pSDEFieldModel.setCodeName("UserCat");
            pSDEFieldModel.setLength(10);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3107354597ad0ec6b27980418031e8c8");
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
            pSDEFieldModel.setId("c4bf68522dd0e47cc0aaa9ec68826048");
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
        object = this.createDEField("USERTAG3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a76c10c5c93f4b4686351f0336b6cf15");
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
            pSDEFieldModel.setId("899dacbaa10dc80bbc3e9707766f0ad6");
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
        object = this.createDEField("V2GITPATH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b7273ee562e45ba597285b00c25e41d2");
            pSDEFieldModel.setName("V2GITPATH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6837\u5f0f\u8d44\u6e90\u4ed3\u5e93\u5730\u5740");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("V2GitPath");
            pSDEFieldModel.setLength(400);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VCTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2daf918d4d3642ec96f1076e9a42e6d9");
            pSDEFieldModel.setName("VCTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7248\u672c\u63a7\u5236\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DevSlnSysVCTypeCodeListModel");
            pSDEFieldModel.setCodeName("VCType");
            pSDEFieldModel.setLength(20);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VERSTR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("69b94fb470ba58b6313069202def9b9a");
            pSDEFieldModel.setName("VERSTR");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7248\u672c\u53f7");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("VerStr");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSDevSlnTemplDefaultACModel pSDevSlnTemplDefaultACModel = new PSDevSlnTemplDefaultACModel();
        pSDevSlnTemplDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDevSlnTemplDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDevSlnTemplCurSlnDSModel pSDevSlnTemplCurSlnDSModel = new PSDevSlnTemplCurSlnDSModel();
        pSDevSlnTemplCurSlnDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnTemplCurSlnDSModel);
        PSDevSlnTemplCurSlnTrunkDSModel pSDevSlnTemplCurSlnTrunkDSModel = new PSDevSlnTemplCurSlnTrunkDSModel();
        pSDevSlnTemplCurSlnTrunkDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnTemplCurSlnTrunkDSModel);
        PSDevSlnTemplCurTemplBranchDSModel pSDevSlnTemplCurTemplBranchDSModel = new PSDevSlnTemplCurTemplBranchDSModel();
        pSDevSlnTemplCurTemplBranchDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnTemplCurTemplBranchDSModel);
        PSDevSlnTemplCurUserDSModel pSDevSlnTemplCurUserDSModel = new PSDevSlnTemplCurUserDSModel();
        pSDevSlnTemplCurUserDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnTemplCurUserDSModel);
        PSDevSlnTemplCurUser3DSModel pSDevSlnTemplCurUser3DSModel = new PSDevSlnTemplCurUser3DSModel();
        pSDevSlnTemplCurUser3DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnTemplCurUser3DSModel);
        PSDevSlnTemplCurUser4DSModel pSDevSlnTemplCurUser4DSModel = new PSDevSlnTemplCurUser4DSModel();
        pSDevSlnTemplCurUser4DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnTemplCurUser4DSModel);
        PSDevSlnTemplCurUserAllDSModel pSDevSlnTemplCurUserAllDSModel = new PSDevSlnTemplCurUserAllDSModel();
        pSDevSlnTemplCurUserAllDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnTemplCurUserAllDSModel);
        PSDevSlnTemplCurUserTrunkDSModel pSDevSlnTemplCurUserTrunkDSModel = new PSDevSlnTemplCurUserTrunkDSModel();
        pSDevSlnTemplCurUserTrunkDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnTemplCurUserTrunkDSModel);
        PSDevSlnTemplCurUserTrunk3DSModel pSDevSlnTemplCurUserTrunk3DSModel = new PSDevSlnTemplCurUserTrunk3DSModel();
        pSDevSlnTemplCurUserTrunk3DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnTemplCurUserTrunk3DSModel);
        PSDevSlnTemplCurUserTrunk4DSModel pSDevSlnTemplCurUserTrunk4DSModel = new PSDevSlnTemplCurUserTrunk4DSModel();
        pSDevSlnTemplCurUserTrunk4DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnTemplCurUserTrunk4DSModel);
        PSDevSlnTemplCurUserTrunk5DSModel pSDevSlnTemplCurUserTrunk5DSModel = new PSDevSlnTemplCurUserTrunk5DSModel();
        pSDevSlnTemplCurUserTrunk5DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnTemplCurUserTrunk5DSModel);
        PSDevSlnTemplCurUserTrunk6DSModel pSDevSlnTemplCurUserTrunk6DSModel = new PSDevSlnTemplCurUserTrunk6DSModel();
        pSDevSlnTemplCurUserTrunk6DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnTemplCurUserTrunk6DSModel);
        PSDevSlnTemplDefaultDSModel pSDevSlnTemplDefaultDSModel = new PSDevSlnTemplDefaultDSModel();
        pSDevSlnTemplDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDevSlnTemplDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDevSlnTemplCurSlnDQModel pSDevSlnTemplCurSlnDQModel = new PSDevSlnTemplCurSlnDQModel();
        pSDevSlnTemplCurSlnDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnTemplCurSlnDQModel);
        PSDevSlnTemplCurSlnTrunkDQModel pSDevSlnTemplCurSlnTrunkDQModel = new PSDevSlnTemplCurSlnTrunkDQModel();
        pSDevSlnTemplCurSlnTrunkDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnTemplCurSlnTrunkDQModel);
        PSDevSlnTemplCurTemplBranchDQModel pSDevSlnTemplCurTemplBranchDQModel = new PSDevSlnTemplCurTemplBranchDQModel();
        pSDevSlnTemplCurTemplBranchDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnTemplCurTemplBranchDQModel);
        PSDevSlnTemplCurUserDQModel pSDevSlnTemplCurUserDQModel = new PSDevSlnTemplCurUserDQModel();
        pSDevSlnTemplCurUserDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnTemplCurUserDQModel);
        PSDevSlnTemplCurUser3DQModel pSDevSlnTemplCurUser3DQModel = new PSDevSlnTemplCurUser3DQModel();
        pSDevSlnTemplCurUser3DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnTemplCurUser3DQModel);
        PSDevSlnTemplCurUser4DQModel pSDevSlnTemplCurUser4DQModel = new PSDevSlnTemplCurUser4DQModel();
        pSDevSlnTemplCurUser4DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnTemplCurUser4DQModel);
        PSDevSlnTemplCurUser5DQModel pSDevSlnTemplCurUser5DQModel = new PSDevSlnTemplCurUser5DQModel();
        pSDevSlnTemplCurUser5DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnTemplCurUser5DQModel);
        PSDevSlnTemplCurUser6DQModel pSDevSlnTemplCurUser6DQModel = new PSDevSlnTemplCurUser6DQModel();
        pSDevSlnTemplCurUser6DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnTemplCurUser6DQModel);
        PSDevSlnTemplCurUserTrunkDQModel pSDevSlnTemplCurUserTrunkDQModel = new PSDevSlnTemplCurUserTrunkDQModel();
        pSDevSlnTemplCurUserTrunkDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnTemplCurUserTrunkDQModel);
        PSDevSlnTemplCurUserTrunk3DQModel pSDevSlnTemplCurUserTrunk3DQModel = new PSDevSlnTemplCurUserTrunk3DQModel();
        pSDevSlnTemplCurUserTrunk3DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnTemplCurUserTrunk3DQModel);
        PSDevSlnTemplCurUserTrunk4DQModel pSDevSlnTemplCurUserTrunk4DQModel = new PSDevSlnTemplCurUserTrunk4DQModel();
        pSDevSlnTemplCurUserTrunk4DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnTemplCurUserTrunk4DQModel);
        PSDevSlnTemplCurUserTrunk5DQModel pSDevSlnTemplCurUserTrunk5DQModel = new PSDevSlnTemplCurUserTrunk5DQModel();
        pSDevSlnTemplCurUserTrunk5DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnTemplCurUserTrunk5DQModel);
        PSDevSlnTemplCurUserTrunk6DQModel pSDevSlnTemplCurUserTrunk6DQModel = new PSDevSlnTemplCurUserTrunk6DQModel();
        pSDevSlnTemplCurUserTrunk6DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnTemplCurUserTrunk6DQModel);
        PSDevSlnTemplDefaultDQModel pSDevSlnTemplDefaultDQModel = new PSDevSlnTemplDefaultDQModel();
        pSDevSlnTemplDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDevSlnTemplDefaultDQModel);
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
        this.registerPDTDEView("EDITVIEW", "4ab72b8eb772d766410665ec9fb72852");
        this.registerPDTDEView("MDATAVIEW", "a92f782f3975f0218fc2615f00368f12");
        this.registerPDTDEView("MPICKUPVIEW", "1d511897269ebf163830606aa25e8fed");
        this.registerPDTDEView("PICKUPVIEW", "442840b7bbb2d07d2bff45734a5db39f");
        this.registerPDTDEView("REDIRECTVIEW", "8b47d5657344c391a76c467561b705ac");
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
        dEDataSetCond2.setDEFName("PSDEVSLNTEMPLNAME");
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
        pSDEFGroupDetailModel.setId("1c16de8649cc92f45481d2b034a267ec");
        pSDEFGroupDetailModel.setName("ENABLEREF");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("ENABLEREF", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a26ed36bde910f342b8a8d8497d1d75c");
        pSDEFGroupDetailModel.setName("LASTPUBDATE");
        iPSDEFieldModel = this.getDEField("LASTPUBDATE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cd06557ed99d3bf6305c70e2a8b154a4");
        pSDEFGroupDetailModel.setName("LOGICNAME");
        iPSDEFieldModel = this.getDEField("LOGICNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6d72543fdfc162a1f4b8980ad5b73bbe");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("177e7353a5c8308525f9b9ee748254b9");
        pSDEFGroupDetailModel.setName("PSDEVSLNID");
        iPSDEFieldModel = this.getDEField("PSDEVSLNID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f3dc5f97815a619aee30376be339cc63");
        pSDEFGroupDetailModel.setName("PSDEVSLNNAME");
        iPSDEFieldModel = this.getDEField("PSDEVSLNNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9a62d25165e0ed6025bfea4c9604da4a");
        pSDEFGroupDetailModel.setName("PSDEVSLNTEMPLNAME");
        iPSDEFieldModel = this.getDEField("PSDEVSLNTEMPLNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5b12b4328384b7d0608609aa5f5ac6ee");
        pSDEFGroupDetailModel.setName("PSPFID");
        iPSDEFieldModel = this.getDEField("PSPFID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("79848038858a24cc256e8dcfb25beaaf");
        pSDEFGroupDetailModel.setName("PSPFNAME");
        iPSDEFieldModel = this.getDEField("PSPFNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ce8e7b4c2cd992fa1b9d33bebc716fbf");
        pSDEFGroupDetailModel.setName("PSSFID");
        iPSDEFieldModel = this.getDEField("PSSFID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a86e2d8aa68d06408464d973c67b14e6");
        pSDEFGroupDetailModel.setName("PSSFNAME");
        iPSDEFieldModel = this.getDEField("PSSFNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f6c990de749010673ce29a0bc6b1a047");
        pSDEFGroupDetailModel.setName("REFCODE");
        iPSDEFieldModel = this.getDEField("REFCODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a05040a2982221fdbb340aaee5cb7c72");
        pSDEFGroupDetailModel.setName("STYLEENGINE");
        iPSDEFieldModel = this.getDEField("STYLEENGINE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PSTemplEngineCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6c998f1dc173b9b7eb13be22dd01a4cb");
        pSDEFGroupDetailModel.setName("TEMPLPARAMS");
        iPSDEFieldModel = this.getDEField("TEMPLPARAMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4cc883c7568af0406fb526c00556c0cd");
        pSDEFGroupDetailModel.setName("TEMPLTYPE");
        iPSDEFieldModel = this.getDEField("TEMPLTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DevSlnTemplTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

