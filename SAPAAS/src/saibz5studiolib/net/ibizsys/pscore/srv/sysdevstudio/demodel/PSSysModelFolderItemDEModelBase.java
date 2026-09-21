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
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupDetailModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupModel;
import net.ibizsys.pscore.srv.core.PSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDataEntityModelBase;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysmodelfolderitem.ac.PSSysModelFolderItemDefaultACModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysmodelfolderitem.dataquery.PSSysModelFolderItemCurUser2DQModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysmodelfolderitem.dataquery.PSSysModelFolderItemCurUser3DQModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysmodelfolderitem.dataquery.PSSysModelFolderItemCurUserDQModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysmodelfolderitem.dataquery.PSSysModelFolderItemDefaultDQModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysmodelfolderitem.dataset.PSSysModelFolderItemCurUser2DSModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysmodelfolderitem.dataset.PSSysModelFolderItemCurUser3DSModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysmodelfolderitem.dataset.PSSysModelFolderItemCurUserAllDSModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysmodelfolderitem.dataset.PSSysModelFolderItemCurUserDSModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysmodelfolderitem.dataset.PSSysModelFolderItemDefaultDSModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysModelFolderItem;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderItemService;

public abstract class PSSysModelFolderItemDEModelBase
extends PSDataEntityModelBase<PSSysModelFolderItem> {
    private PSCoreSysModel pSCoreSysModel;
    private PSSysModelFolderItemService pSSysModelFolderItemService;

    public PSSysModelFolderItemDEModelBase() throws Exception {
        this.setId("61be71763d040c25e32f30e4df8bafea");
        this.setName("PSSYSMODELFOLDERITEM");
        this.setCodeName("PSSysModelFolderItem");
        this.setTableName("T_SRFPSSYSMODELFOLDERITEM");
        this.setViewName("v_PSSYSMODELFOLDERITEM");
        this.setLogicName("\u7cfb\u7edf\u6a21\u578b\u76ee\u5f55\u6210\u5458");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setUserTag("MODELV2");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSSysModelFolderItemDEModel", (IDataEntityModel)this);
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

    public PSSysModelFolderItemService getRealService() {
        if (this.pSSysModelFolderItemService == null) {
            try {
                this.pSSysModelFolderItemService = (PSSysModelFolderItemService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysModelFolderItemService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSSysModelFolderItemService";
    }

    public PSSysModelFolderItem createEntity() {
        return new PSSysModelFolderItem();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("ALLUSERFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7df16f8215c586ceefe479fec99c620a");
            pSDEFieldModel.setName("ALLUSERFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5168\u90e8\u7528\u6237");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("AllUserFlag");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b69b0f37049b94f4d586c1b19754b582");
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
            pSDEFieldModel.setId("e2b8593aa1f99e0b82c4e1e0e4247586");
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
        object = this.createDEField("DATA");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("288ea94f32c550a91cb0c8ee162de072");
            pSDEFieldModel.setName("DATA");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6570\u636e");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Data");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ICONCLS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ec1256c1b43060adeddd335383d25276");
            pSDEFieldModel.setName("ICONCLS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u56fe\u6807\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("IconCls");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ITEMPARAM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("367812399fba97299cd9a038624ca130");
            pSDEFieldModel.setName("ITEMPARAM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6210\u5458\u53c2\u6570");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ItemParam");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ITEMPARAM2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c28cb4f139f0a8e56649d14e6e9e418a");
            pSDEFieldModel.setName("ITEMPARAM2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6210\u5458\u53c2\u65702");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ItemParam2");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3b37c07361ab555b9d4f08b42eb3e118");
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
        object = this.createDEField("ORDERVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("62544c7300f8145de641a5db773784dd");
            pSDEFieldModel.setName("ORDERVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u663e\u793a\u6b21\u5e8f");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("OrderValue");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSOBJID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("de219cc6b9792e83261cd69ca9350d1f");
            pSDEFieldModel.setName("PSOBJID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bf9\u8c61\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSObjId");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSOBJNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("384873f4b41b915e1a30998d5ba445eb");
            pSDEFieldModel.setName("PSOBJNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bf9\u8c61\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSObjName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSOBJNAME_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSOBJNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSOBJTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("da7f22f2b406c562078e077064190cf5");
            pSDEFieldModel.setName("PSOBJTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6210\u5458\u7c7b\u578b");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSObjType");
            pSDEFieldModel.setLength(40);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSOBJTYPENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ab851b507286a3d396e669ac82bd52d0");
            pSDEFieldModel.setName("PSOBJTYPENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6210\u5458\u7c7b\u578b\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSObjTypeName");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSOBJTYPENAME_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSOBJTYPENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSMODELFOLDERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("556290d6da559c57b7770d646c99340b");
            pSDEFieldModel.setName("PSSYSMODELFOLDERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u578b\u76ee\u5f55");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSMODELFOLDERITEM_PSSYSMODELFOLDER_PSSYSMODELFOLDERID");
            pSDEFieldModel.setLinkDEFName("PSSYSMODELFOLDERID");
            pSDEFieldModel.setCodeName("PSSysModelFolderId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSMODELFOLDERID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSMODELFOLDERID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSMODELFOLDERITEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("53c545fcf9d53de11d5800dc236520b6");
            pSDEFieldModel.setName("PSSYSMODELFOLDERITEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u6a21\u578b\u76ee\u5f55\u6210\u5458\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSSysModelFolderItemId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSMODELFOLDERITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2ad803c5f02f19e9f20d49080a16758a");
            pSDEFieldModel.setName("PSSYSMODELFOLDERITEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSSysModelFolderItemName");
            pSDEFieldModel.setValueRuleName("\u540d\u79f0\u4e0d\u5305\u62ec\u8def\u5f84\u7b26\u53f7");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSMODELFOLDERITEMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSMODELFOLDERITEMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSMODELFOLDERITEMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSMODELFOLDERITEMNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSMODELFOLDERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ce743e4d6dd448a6557aa42d35a69a0e");
            pSDEFieldModel.setName("PSSYSMODELFOLDERNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u578b\u76ee\u5f55");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSSYSMODELFOLDERITEM_PSSYSMODELFOLDER_PSSYSMODELFOLDERID");
            pSDEFieldModel.setLinkDEFName("PSSYSMODELFOLDERNAME");
            pSDEFieldModel.setCodeName("PSSysModelFolderName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSMODELFOLDERNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSMODELFOLDERNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSMODELFOLDERNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSMODELFOLDERNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("STUDIOTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("856c1e662aad351a2287b23e8ef978a8");
            pSDEFieldModel.setName("STUDIOTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5de5\u5177\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("StudioTag");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_STUDIOTAG_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_STUDIOTAG_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("STUDIOTAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cead151936ba6592ff04df1395d827fb");
            pSDEFieldModel.setName("STUDIOTAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5de5\u5177\u6807\u8bb02");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("StudioTag2");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_STUDIOTAG2_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_STUDIOTAG2_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("STUDIOTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0bbbddb823e49afb05b18ae116c48eae");
            pSDEFieldModel.setName("STUDIOTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5de5\u5177\u7c7b\u578b");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("StudioType");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_STUDIOTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_STUDIOTYPE_EQ");
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
            pSDEFieldModel.setId("275007f9c1b2b06afd2e065c7fa43ad0");
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
            pSDEFieldModel.setId("48a4b16163187c9ded4586d6d27a01bb");
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
        object = this.createDEField("USERTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e7d0cebdfdbdf79e38311cb39333d128");
            pSDEFieldModel.setName("USERTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag");
            pSDEFieldModel.setLength(100);
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
            pSDEFieldModel.setId("3c33541b1b23607bd97e40ec847fd824");
            pSDEFieldModel.setName("USERTAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb02");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserTag2");
            pSDEFieldModel.setLength(100);
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
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSSysModelFolderItemDefaultACModel pSSysModelFolderItemDefaultACModel = new PSSysModelFolderItemDefaultACModel();
        pSSysModelFolderItemDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSSysModelFolderItemDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSSysModelFolderItemCurUserDSModel pSSysModelFolderItemCurUserDSModel = new PSSysModelFolderItemCurUserDSModel();
        pSSysModelFolderItemCurUserDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysModelFolderItemCurUserDSModel);
        PSSysModelFolderItemCurUser2DSModel pSSysModelFolderItemCurUser2DSModel = new PSSysModelFolderItemCurUser2DSModel();
        pSSysModelFolderItemCurUser2DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysModelFolderItemCurUser2DSModel);
        PSSysModelFolderItemCurUser3DSModel pSSysModelFolderItemCurUser3DSModel = new PSSysModelFolderItemCurUser3DSModel();
        pSSysModelFolderItemCurUser3DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysModelFolderItemCurUser3DSModel);
        PSSysModelFolderItemCurUserAllDSModel pSSysModelFolderItemCurUserAllDSModel = new PSSysModelFolderItemCurUserAllDSModel();
        pSSysModelFolderItemCurUserAllDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysModelFolderItemCurUserAllDSModel);
        PSSysModelFolderItemDefaultDSModel pSSysModelFolderItemDefaultDSModel = new PSSysModelFolderItemDefaultDSModel();
        pSSysModelFolderItemDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSSysModelFolderItemDefaultDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSSysModelFolderItemCurUserDQModel pSSysModelFolderItemCurUserDQModel = new PSSysModelFolderItemCurUserDQModel();
        pSSysModelFolderItemCurUserDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysModelFolderItemCurUserDQModel);
        PSSysModelFolderItemCurUser2DQModel pSSysModelFolderItemCurUser2DQModel = new PSSysModelFolderItemCurUser2DQModel();
        pSSysModelFolderItemCurUser2DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysModelFolderItemCurUser2DQModel);
        PSSysModelFolderItemCurUser3DQModel pSSysModelFolderItemCurUser3DQModel = new PSSysModelFolderItemCurUser3DQModel();
        pSSysModelFolderItemCurUser3DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysModelFolderItemCurUser3DQModel);
        PSSysModelFolderItemDefaultDQModel pSSysModelFolderItemDefaultDQModel = new PSSysModelFolderItemDefaultDQModel();
        pSSysModelFolderItemDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSSysModelFolderItemDefaultDQModel);
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
        this.registerPDTDEView("EDITVIEW", "9f07126e30e2b614c096600f6f20e1e6");
        this.registerPDTDEView("MDATAVIEW", "31ce67214b2deb484155b3c0eff483a6");
        this.registerPDTDEView("MPICKUPVIEW", "5fcc13558608f180295e42e1c1e0ad8f");
        this.registerPDTDEView("PICKUPVIEW", "91ba7cce099d7c5422ea9f9b0d4aa1c3");
        this.registerPDTDEView("REDIRECTVIEW", "33ef063612cc610a0fd2545af17b9a5b");
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
        dEDataSetCond2.setDEFName("PSSYSMODELFOLDERITEMNAME");
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
        pSDEFGroupDetailModel.setId("7df16f8215c586ceefe479fec99c620a");
        pSDEFGroupDetailModel.setName("ALLUSERFLAG");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("ALLUSERFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("367812399fba97299cd9a038624ca130");
        pSDEFGroupDetailModel.setName("ITEMPARAM");
        iPSDEFieldModel = this.getDEField("ITEMPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c28cb4f139f0a8e56649d14e6e9e418a");
        pSDEFGroupDetailModel.setName("ITEMPARAM2");
        iPSDEFieldModel = this.getDEField("ITEMPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3b37c07361ab555b9d4f08b42eb3e118");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("62544c7300f8145de641a5db773784dd");
        pSDEFGroupDetailModel.setName("ORDERVALUE");
        iPSDEFieldModel = this.getDEField("ORDERVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("de219cc6b9792e83261cd69ca9350d1f");
        pSDEFGroupDetailModel.setName("PSOBJID");
        iPSDEFieldModel = this.getDEField("PSOBJID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("384873f4b41b915e1a30998d5ba445eb");
        pSDEFGroupDetailModel.setName("PSOBJNAME");
        iPSDEFieldModel = this.getDEField("PSOBJNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("da7f22f2b406c562078e077064190cf5");
        pSDEFGroupDetailModel.setName("PSOBJTYPE");
        iPSDEFieldModel = this.getDEField("PSOBJTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("556290d6da559c57b7770d646c99340b");
        pSDEFGroupDetailModel.setName("PSSYSMODELFOLDERID");
        iPSDEFieldModel = this.getDEField("PSSYSMODELFOLDERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2ad803c5f02f19e9f20d49080a16758a");
        pSDEFGroupDetailModel.setName("PSSYSMODELFOLDERITEMNAME");
        iPSDEFieldModel = this.getDEField("PSSYSMODELFOLDERITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ce743e4d6dd448a6557aa42d35a69a0e");
        pSDEFGroupDetailModel.setName("PSSYSMODELFOLDERNAME");
        iPSDEFieldModel = this.getDEField("PSSYSMODELFOLDERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

