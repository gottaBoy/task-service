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
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.ac.PSDCRegistryItemDefaultACModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCodeServerDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurDC2DQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurDCAPI2DQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurDCAPIDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurDCApp2DQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurDCAppDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurDCCodeServer2DQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurDCCodeServerDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurDCDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurDCGenerator2DQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurDCGeneratorDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurDCRunner2DQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurDCRunnerDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurRepoDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurSlnDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurSlnGeneratorDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurSysAPIDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurSysAppDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemCurSysDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemDefaultDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemGeneratorDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemRunnerDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataquery.PSDCRegistryItemToolDQModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCodeServerDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurDC2DSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurDCAPI2DSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurDCAPIDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurDCAndSlnDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurDCAndSlnGeneratorDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurDCApp2DSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurDCAppDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurDCCodeServer2DSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurDCCodeServerDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurDCDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurDCGenerator2DSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurDCGeneratorDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurDCRunner2DSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurDCRunnerDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurRepoDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurSlnDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurSlnGeneratorDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurSysAPIDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurSysAppDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemCurSysDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemDefaultDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemGeneratorDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemRunnerDSModel;
import net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset.PSDCRegistryItemToolDSModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRegistryItem;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService;

public abstract class PSDCRegistryItemDEModelBase
extends PSDataEntityModelBase<PSDCRegistryItem> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDCRegistryItemService pSDCRegistryItemService;

    public PSDCRegistryItemDEModelBase() throws Exception {
        this.setId("403a0496a3355c1e591b12285bc3da0f");
        this.setName("PSDCREGISTRYITEM");
        this.setCodeName("PSDCRegistryItem");
        this.setTableName("T_SRFPSDCREGISTRYITEM");
        this.setViewName("v_PSDCREGISTRYITEM");
        this.setLogicName("\u4e2d\u5fc3\u955c\u50cf\u4ed3\u5e93\u9879");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.devcenter.demodel.PSDCRegistryItemDEModel", (IDataEntityModel)this);
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

    public PSDCRegistryItemService getRealService() {
        if (this.pSDCRegistryItemService == null) {
            try {
                this.pSDCRegistryItemService = (PSDCRegistryItemService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDCRegistryItemService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService";
    }

    public PSDCRegistryItem createEntity() {
        return new PSDCRegistryItem();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("CONNSTR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("07c1431871475e1d78352a3db5c78ced");
            pSDEFieldModel.setName("CONNSTR");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8fde\u63a5\u4e32");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ConnStr");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("26106e89ba2433d1b7888b36460259c7");
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
            pSDEFieldModel.setId("b35a6c3108cab362b4a1cac209e2d96a");
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
        object = this.createDEField("DOCKERFILE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("22ed227b96776788fa65740caa52f1fd");
            pSDEFieldModel.setName("DOCKERFILE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u955c\u50cf\u6587\u4ef6");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DockerFile");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ITEMPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6493035c0a1099dd675fe8e471cf8528");
            pSDEFieldModel.setName("ITEMPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9879\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ItemParams");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ITEMTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d30cd6870864ab9c4c7c678046e6472f");
            pSDEFieldModel.setName("ITEMTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9879\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ItemTag");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMTAG_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMTAG_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMTAG_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMTAG_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ITEMTAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f19680a73dcb07fce0f2fff2d04cf414");
            pSDEFieldModel.setName("ITEMTAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9879\u6807\u8bc62");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ItemTag2");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMTAG2_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMTAG2_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMTAG2_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMTAG2_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ITEMTAG3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bcb08ee42115e40c57cd2d1c89a00b7d");
            pSDEFieldModel.setName("ITEMTAG3");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9879\u6807\u8bc63");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ItemTag3");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMTAG3_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMTAG3_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMTAG3_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMTAG3_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ITEMTAG4");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f444d670882241274de3c1ba7202b95c");
            pSDEFieldModel.setName("ITEMTAG4");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9879\u6807\u8bc64");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ItemTag4");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMTAG4_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMTAG4_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMTAG4_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMTAG4_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LOGICNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("dfdbc44fb516e9d7e7690029ebc97565");
            pSDEFieldModel.setName("LOGICNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u903b\u8f91\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("LogicName");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c61d410b7c34c5ae4e5979b8b9a9ea5d");
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
        object = this.createDEField("PSDCREGISTRYITEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9c26b5ba10058dc9eb5d42ae07b5a9aa");
            pSDEFieldModel.setName("PSDCREGISTRYITEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u5fc3\u955c\u50cf\u4ed3\u5e93\u9879\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDCRegistryItemId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDCREGISTRYITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("634132164a657e32f3cb83839b5c1106");
            pSDEFieldModel.setName("PSDCREGISTRYITEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSDCRegistryItemName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCREGISTRYITEMNAME_LIKE");
            if (iDEFSearchMode == null) {
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
        object = this.createDEField("PSDCREGISTRYREPOID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1329d901419b065329fe2c459c3c458e");
            pSDEFieldModel.setName("PSDCREGISTRYREPOID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u955c\u50cf\u4ed3\u5e93");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCREGISTRYITEM_PSDCREGISTRYREPO_PSDCREGISTRYREPOID");
            pSDEFieldModel.setLinkDEFName("PSDCREGISTRYREPOID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDCRegistryRepoId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCREGISTRYREPOID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDCREGISTRYREPOID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDCREGISTRYREPONAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6ae387de4c3a889788b66d27505a14b7");
            pSDEFieldModel.setName("PSDCREGISTRYREPONAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u955c\u50cf\u4ed3\u5e93");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCREGISTRYITEM_PSDCREGISTRYREPO_PSDCREGISTRYREPOID");
            pSDEFieldModel.setLinkDEFName("PSDCREGISTRYREPONAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDCRegistryRepoName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCREGISTRYREPONAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDCREGISTRYREPONAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDCREGISTRYREPONAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDCREGISTRYREPONAME_LIKE");
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
            pSDEFieldModel.setId("54a0bcf3053b7d8601d28e2cc3fbebd8");
            pSDEFieldModel.setName("PSDEVCENTERSVNID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6e90\u7801\u4ed3\u5e93");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCREGISTRYITEM_PSDEVCENTERSVN_PSDEVCENTERSVNID");
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
            pSDEFieldModel.setId("d5d269b0c36f399d7cc30ca1a6ce10c0");
            pSDEFieldModel.setName("PSDEVCENTERSVNNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6e90\u7801\u4ed3\u5e93");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCREGISTRYITEM_PSDEVCENTERSVN_PSDEVCENTERSVNID");
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
            pSDEFieldModel.setId("14458ec40a72b253ee987fbfee94aa1e");
            pSDEFieldModel.setName("PSDEVSLNID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u65b9\u6848\u6807\u8bc6");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCREGISTRYITEM_PSDEVSLNSYS_PSDEVSLNSYSID");
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
        object = this.createDEField("PSDEVSLNMSDEPLOYID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("01c2abe38e2e51da51c2785f44238f39");
            pSDEFieldModel.setName("PSDEVSLNMSDEPLOYID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5fae\u670d\u52a1\u90e8\u7f72");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCREGISTRYITEM_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNMSDEPLOYID");
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
            pSDEFieldModel.setId("66b9e117fd499c40537be2222ccd335c");
            pSDEFieldModel.setName("PSDEVSLNMSDEPLOYNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5fae\u670d\u52a1\u90e8\u7f72");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCREGISTRYITEM_PSDEVSLNMSDEPLOY_PSDEVSLNMSDEPLOYID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNMSDEPLOYNAME");
            pSDEFieldModel.setPhisicalDEField(false);
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
            pSDEFieldModel.setId("af628ffb7ab2f829bf4120ec286ad25b");
            pSDEFieldModel.setName("PSDEVSLNNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u65b9\u6848\u540d\u79f0");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCREGISTRYITEM_PSDEVSLNSYS_PSDEVSLNSYSID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDevSlnName");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVSLNSYSID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ad6cd634cd4a75251361efd4118547e3");
            pSDEFieldModel.setName("PSDEVSLNSYSID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCREGISTRYITEM_PSDEVSLNSYS_PSDEVSLNSYSID");
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
            pSDEFieldModel.setId("497a46b18fef6c9a4b5a2103ce3f540a");
            pSDEFieldModel.setName("PSDEVSLNSYSNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f00\u53d1\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDCREGISTRYITEM_PSDEVSLNSYS_PSDEVSLNSYSID");
            pSDEFieldModel.setLinkDEFName("PSDEVSLNSYSNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
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
        object = this.createDEField("RESSTATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6156fe41724bff43e2293d6c5b26f973");
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
        object = this.createDEField("TAGS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("745f88e7271af24e0770d88100c45382");
            pSDEFieldModel.setName("TAGS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u8bb0");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Tags");
            pSDEFieldModel.setLength(1000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f5ace4df78af2c5b594717114fd0684b");
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
            pSDEFieldModel.setId("46f856dc53a48d18e617ee84c548833e");
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
            pSDEFieldModel.setId("ec6adfbb3b5a25764ed967186925e223");
            pSDEFieldModel.setName("USERCAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u5206\u7c7b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelUserCatCodeListModel");
            pSDEFieldModel.setCodeName("UserCat");
            pSDEFieldModel.setLength(10);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_USERCAT_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_USERCAT_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4ae66775855ff2ecd9c02dab4f17b830");
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
            pSDEFieldModel.setId("43d6b6d5bca102a406f750ad2c710a57");
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
        object = this.createDEField("USERTAG3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1604454800b646aefffa4e589f24d8a1");
            pSDEFieldModel.setName("USERTAG3");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb03");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
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
            pSDEFieldModel.setId("ccd3daf992593c2360d5ea6e7a80fb46");
            pSDEFieldModel.setName("USERTAG4");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7528\u6237\u6807\u8bb04");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
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
        object = this.createDEField("VALIDFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("221c82a4391419e4dce2e32842635d58");
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
        PSDCRegistryItemDefaultACModel pSDCRegistryItemDefaultACModel = new PSDCRegistryItemDefaultACModel();
        pSDCRegistryItemDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDCRegistryItemDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDCRegistryItemCodeServerDSModel pSDCRegistryItemCodeServerDSModel = new PSDCRegistryItemCodeServerDSModel();
        pSDCRegistryItemCodeServerDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCodeServerDSModel);
        PSDCRegistryItemCurDCDSModel pSDCRegistryItemCurDCDSModel = new PSDCRegistryItemCurDCDSModel();
        pSDCRegistryItemCurDCDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurDCDSModel);
        PSDCRegistryItemCurDC2DSModel pSDCRegistryItemCurDC2DSModel = new PSDCRegistryItemCurDC2DSModel();
        pSDCRegistryItemCurDC2DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurDC2DSModel);
        PSDCRegistryItemCurDCAPIDSModel pSDCRegistryItemCurDCAPIDSModel = new PSDCRegistryItemCurDCAPIDSModel();
        pSDCRegistryItemCurDCAPIDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurDCAPIDSModel);
        PSDCRegistryItemCurDCAPI2DSModel pSDCRegistryItemCurDCAPI2DSModel = new PSDCRegistryItemCurDCAPI2DSModel();
        pSDCRegistryItemCurDCAPI2DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurDCAPI2DSModel);
        PSDCRegistryItemCurDCAndSlnDSModel pSDCRegistryItemCurDCAndSlnDSModel = new PSDCRegistryItemCurDCAndSlnDSModel();
        pSDCRegistryItemCurDCAndSlnDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurDCAndSlnDSModel);
        PSDCRegistryItemCurDCAndSlnGeneratorDSModel pSDCRegistryItemCurDCAndSlnGeneratorDSModel = new PSDCRegistryItemCurDCAndSlnGeneratorDSModel();
        pSDCRegistryItemCurDCAndSlnGeneratorDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurDCAndSlnGeneratorDSModel);
        PSDCRegistryItemCurDCAppDSModel pSDCRegistryItemCurDCAppDSModel = new PSDCRegistryItemCurDCAppDSModel();
        pSDCRegistryItemCurDCAppDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurDCAppDSModel);
        PSDCRegistryItemCurDCApp2DSModel pSDCRegistryItemCurDCApp2DSModel = new PSDCRegistryItemCurDCApp2DSModel();
        pSDCRegistryItemCurDCApp2DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurDCApp2DSModel);
        PSDCRegistryItemCurDCCodeServerDSModel pSDCRegistryItemCurDCCodeServerDSModel = new PSDCRegistryItemCurDCCodeServerDSModel();
        pSDCRegistryItemCurDCCodeServerDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurDCCodeServerDSModel);
        PSDCRegistryItemCurDCCodeServer2DSModel pSDCRegistryItemCurDCCodeServer2DSModel = new PSDCRegistryItemCurDCCodeServer2DSModel();
        pSDCRegistryItemCurDCCodeServer2DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurDCCodeServer2DSModel);
        PSDCRegistryItemCurDCGeneratorDSModel pSDCRegistryItemCurDCGeneratorDSModel = new PSDCRegistryItemCurDCGeneratorDSModel();
        pSDCRegistryItemCurDCGeneratorDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurDCGeneratorDSModel);
        PSDCRegistryItemCurDCGenerator2DSModel pSDCRegistryItemCurDCGenerator2DSModel = new PSDCRegistryItemCurDCGenerator2DSModel();
        pSDCRegistryItemCurDCGenerator2DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurDCGenerator2DSModel);
        PSDCRegistryItemCurDCRunnerDSModel pSDCRegistryItemCurDCRunnerDSModel = new PSDCRegistryItemCurDCRunnerDSModel();
        pSDCRegistryItemCurDCRunnerDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurDCRunnerDSModel);
        PSDCRegistryItemCurDCRunner2DSModel pSDCRegistryItemCurDCRunner2DSModel = new PSDCRegistryItemCurDCRunner2DSModel();
        pSDCRegistryItemCurDCRunner2DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurDCRunner2DSModel);
        PSDCRegistryItemCurRepoDSModel pSDCRegistryItemCurRepoDSModel = new PSDCRegistryItemCurRepoDSModel();
        pSDCRegistryItemCurRepoDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurRepoDSModel);
        PSDCRegistryItemCurSlnDSModel pSDCRegistryItemCurSlnDSModel = new PSDCRegistryItemCurSlnDSModel();
        pSDCRegistryItemCurSlnDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurSlnDSModel);
        PSDCRegistryItemCurSlnGeneratorDSModel pSDCRegistryItemCurSlnGeneratorDSModel = new PSDCRegistryItemCurSlnGeneratorDSModel();
        pSDCRegistryItemCurSlnGeneratorDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurSlnGeneratorDSModel);
        PSDCRegistryItemCurSysDSModel pSDCRegistryItemCurSysDSModel = new PSDCRegistryItemCurSysDSModel();
        pSDCRegistryItemCurSysDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurSysDSModel);
        PSDCRegistryItemCurSysAPIDSModel pSDCRegistryItemCurSysAPIDSModel = new PSDCRegistryItemCurSysAPIDSModel();
        pSDCRegistryItemCurSysAPIDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurSysAPIDSModel);
        PSDCRegistryItemCurSysAppDSModel pSDCRegistryItemCurSysAppDSModel = new PSDCRegistryItemCurSysAppDSModel();
        pSDCRegistryItemCurSysAppDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemCurSysAppDSModel);
        PSDCRegistryItemDefaultDSModel pSDCRegistryItemDefaultDSModel = new PSDCRegistryItemDefaultDSModel();
        pSDCRegistryItemDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemDefaultDSModel);
        PSDCRegistryItemGeneratorDSModel pSDCRegistryItemGeneratorDSModel = new PSDCRegistryItemGeneratorDSModel();
        pSDCRegistryItemGeneratorDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemGeneratorDSModel);
        PSDCRegistryItemRunnerDSModel pSDCRegistryItemRunnerDSModel = new PSDCRegistryItemRunnerDSModel();
        pSDCRegistryItemRunnerDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemRunnerDSModel);
        PSDCRegistryItemToolDSModel pSDCRegistryItemToolDSModel = new PSDCRegistryItemToolDSModel();
        pSDCRegistryItemToolDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDCRegistryItemToolDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDCRegistryItemCodeServerDQModel pSDCRegistryItemCodeServerDQModel = new PSDCRegistryItemCodeServerDQModel();
        pSDCRegistryItemCodeServerDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCodeServerDQModel);
        PSDCRegistryItemCurDCDQModel pSDCRegistryItemCurDCDQModel = new PSDCRegistryItemCurDCDQModel();
        pSDCRegistryItemCurDCDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurDCDQModel);
        PSDCRegistryItemCurDC2DQModel pSDCRegistryItemCurDC2DQModel = new PSDCRegistryItemCurDC2DQModel();
        pSDCRegistryItemCurDC2DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurDC2DQModel);
        PSDCRegistryItemCurDCAPIDQModel pSDCRegistryItemCurDCAPIDQModel = new PSDCRegistryItemCurDCAPIDQModel();
        pSDCRegistryItemCurDCAPIDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurDCAPIDQModel);
        PSDCRegistryItemCurDCAPI2DQModel pSDCRegistryItemCurDCAPI2DQModel = new PSDCRegistryItemCurDCAPI2DQModel();
        pSDCRegistryItemCurDCAPI2DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurDCAPI2DQModel);
        PSDCRegistryItemCurDCAppDQModel pSDCRegistryItemCurDCAppDQModel = new PSDCRegistryItemCurDCAppDQModel();
        pSDCRegistryItemCurDCAppDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurDCAppDQModel);
        PSDCRegistryItemCurDCApp2DQModel pSDCRegistryItemCurDCApp2DQModel = new PSDCRegistryItemCurDCApp2DQModel();
        pSDCRegistryItemCurDCApp2DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurDCApp2DQModel);
        PSDCRegistryItemCurDCCodeServerDQModel pSDCRegistryItemCurDCCodeServerDQModel = new PSDCRegistryItemCurDCCodeServerDQModel();
        pSDCRegistryItemCurDCCodeServerDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurDCCodeServerDQModel);
        PSDCRegistryItemCurDCCodeServer2DQModel pSDCRegistryItemCurDCCodeServer2DQModel = new PSDCRegistryItemCurDCCodeServer2DQModel();
        pSDCRegistryItemCurDCCodeServer2DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurDCCodeServer2DQModel);
        PSDCRegistryItemCurDCGeneratorDQModel pSDCRegistryItemCurDCGeneratorDQModel = new PSDCRegistryItemCurDCGeneratorDQModel();
        pSDCRegistryItemCurDCGeneratorDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurDCGeneratorDQModel);
        PSDCRegistryItemCurDCGenerator2DQModel pSDCRegistryItemCurDCGenerator2DQModel = new PSDCRegistryItemCurDCGenerator2DQModel();
        pSDCRegistryItemCurDCGenerator2DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurDCGenerator2DQModel);
        PSDCRegistryItemCurDCRunnerDQModel pSDCRegistryItemCurDCRunnerDQModel = new PSDCRegistryItemCurDCRunnerDQModel();
        pSDCRegistryItemCurDCRunnerDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurDCRunnerDQModel);
        PSDCRegistryItemCurDCRunner2DQModel pSDCRegistryItemCurDCRunner2DQModel = new PSDCRegistryItemCurDCRunner2DQModel();
        pSDCRegistryItemCurDCRunner2DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurDCRunner2DQModel);
        PSDCRegistryItemCurRepoDQModel pSDCRegistryItemCurRepoDQModel = new PSDCRegistryItemCurRepoDQModel();
        pSDCRegistryItemCurRepoDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurRepoDQModel);
        PSDCRegistryItemCurSlnDQModel pSDCRegistryItemCurSlnDQModel = new PSDCRegistryItemCurSlnDQModel();
        pSDCRegistryItemCurSlnDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurSlnDQModel);
        PSDCRegistryItemCurSlnGeneratorDQModel pSDCRegistryItemCurSlnGeneratorDQModel = new PSDCRegistryItemCurSlnGeneratorDQModel();
        pSDCRegistryItemCurSlnGeneratorDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurSlnGeneratorDQModel);
        PSDCRegistryItemCurSysDQModel pSDCRegistryItemCurSysDQModel = new PSDCRegistryItemCurSysDQModel();
        pSDCRegistryItemCurSysDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurSysDQModel);
        PSDCRegistryItemCurSysAPIDQModel pSDCRegistryItemCurSysAPIDQModel = new PSDCRegistryItemCurSysAPIDQModel();
        pSDCRegistryItemCurSysAPIDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurSysAPIDQModel);
        PSDCRegistryItemCurSysAppDQModel pSDCRegistryItemCurSysAppDQModel = new PSDCRegistryItemCurSysAppDQModel();
        pSDCRegistryItemCurSysAppDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemCurSysAppDQModel);
        PSDCRegistryItemDefaultDQModel pSDCRegistryItemDefaultDQModel = new PSDCRegistryItemDefaultDQModel();
        pSDCRegistryItemDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemDefaultDQModel);
        PSDCRegistryItemGeneratorDQModel pSDCRegistryItemGeneratorDQModel = new PSDCRegistryItemGeneratorDQModel();
        pSDCRegistryItemGeneratorDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemGeneratorDQModel);
        PSDCRegistryItemRunnerDQModel pSDCRegistryItemRunnerDQModel = new PSDCRegistryItemRunnerDQModel();
        pSDCRegistryItemRunnerDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemRunnerDQModel);
        PSDCRegistryItemToolDQModel pSDCRegistryItemToolDQModel = new PSDCRegistryItemToolDQModel();
        pSDCRegistryItemToolDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDCRegistryItemToolDQModel);
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
        this.registerPDTDEView("EDITVIEW", "0aa73930b288a30537638d3521c6435a");
        this.registerPDTDEView("MDATAVIEW", "739f7c8e3ea2f06de8f77db691699481");
        this.registerPDTDEView("MPICKUPVIEW", "8ee985b19f6900d4ac2032b5a9cd8142");
        this.registerPDTDEView("PICKUPVIEW", "3af40f6b8d2ee802d316f070c262b15c");
        this.registerPDTDEView("REDIRECTVIEW", "9ee5cad120cd3dae027871955f026000");
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
        dEDataSetCond2.setDEFName("PSDCREGISTRYITEMNAME");
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
        pSDEFGroupDetailModel.setId("634132164a657e32f3cb83839b5c1106");
        pSDEFGroupDetailModel.setName("PSDCREGISTRYITEMNAME");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSDCREGISTRYITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

