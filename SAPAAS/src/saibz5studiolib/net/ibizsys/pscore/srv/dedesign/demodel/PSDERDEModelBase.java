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
package net.ibizsys.pscore.srv.dedesign.demodel;

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
import net.ibizsys.pscore.srv.core.IPSDEFGroupModel;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupDetailModel;
import net.ibizsys.pscore.srv.core.PSDEFGroupModel;
import net.ibizsys.pscore.srv.core.PSDEFieldModel;
import net.ibizsys.pscore.srv.core.PSDataEntityModelBase;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.ac.PSDERDefaultACModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataquery.PSDERCurDEDER11DQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataquery.PSDERCurDEDER1N2DQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataquery.PSDERCurDEDER1NDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataquery.PSDERCurDEDERCustomDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataquery.PSDERCurDEMajor2DQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataquery.PSDERCurDEMajorAggDataDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataquery.PSDERCurDEMajorDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataquery.PSDERCurDEMinor2DQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataquery.PSDERCurDEMinorDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataquery.PSDERCurSysDER1NDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataquery.PSDERCurSysDERDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataquery.PSDERDefaultDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataquery.PSDERMajorMinorDER1NDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataquery.PSDERX1NDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERCurDEDER11DSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERCurDEDER11_CustomDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERCurDEDER1N2DSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERCurDEDER1NDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERCurDEDER1N_CustomDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERCurDEDERCustomDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERCurDEMajor2DSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERCurDEMajorAggDataDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERCurDEMajorDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERCurDEMinor2DSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERCurDEMinorDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERCurSysDER1NDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERCurSysDERDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERDefaultDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERFormTypeDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERMajorMinorDER1NDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.dataset.PSDERX1NDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.logic.PSDERNode2DELogicModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.uiaction.PSDERCreateDEOPPrivUIActionModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.uiaction.PSDERCreateDefaultVRUIActionModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psder.uiaction.PSDERCreatePickupTextFieldUIActionModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;

public abstract class PSDERDEModelBase
extends PSDataEntityModelBase<PSDER> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDERService pSDERService;

    public PSDERDEModelBase() throws Exception {
        this.setId("cd0e76e3551b2d95646054aafa51562a");
        this.setName("PSDER");
        this.setCodeName("PSDER");
        this.setTableName("T_SRFPSDER");
        this.setViewName("v_PSDER");
        this.setLogicName("\u5b9e\u4f53\u5173\u7cfb");
        this.setMemo("\u5b9e\u4f53\u7684\u5173\u7cfb\u6a21\u578b\uff0c\u5b83\u7528\u4e8e\u5b9a\u4e49\u5b9e\u4f53\u4e4b\u95f4\u7684\u5173\u7cfb\u3002\u5173\u7cfb\u7c7b\u578b\u5305\u62ec\u4e00\u5bf9\u4e00\u5173\u7cfb\u3001\u4e00\u5bf9\u591a\u5173\u7cfb\uff0c\u9762\u5411\u5bf9\u8c61\u7684\u7ee7\u627f\u5173\u7cfb\u3001\u865a\u62df\u7ee7\u627f\u5173\u7cfb\u3001\u7d22\u5f15\u5173\u7cfb\u7b49\u4ee5\u53ca\u81ea\u5b9a\u4e49\u5173\u7cfb");
        this.setDSLink("DEFAULT");
        this.setEnableMultiDS(true);
        this.setEnableMultiForm(true);
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setUserTag("MODELV2");
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDERDEModel", (IDataEntityModel)this);
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

    public PSDERService getRealService() {
        if (this.pSDERService == null) {
            try {
                this.pSDERService = (PSDERService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDERService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDERService";
    }

    public PSDER createEntity() {
        return new PSDER();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("CLONEORDERVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0e224f9d4a743ca265fcc0ec6bcbd569");
            pSDEFieldModel.setName("CLONEORDERVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u514b\u9686\u5173\u7cfb");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
            pSDEFieldModel.setCodeName("CloneOrderValue");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7684\u514b\u9686\u5173\u7cfb\u7684\u7ea7\u522b");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CLONEORDERVALUE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CLONEORDERVALUE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CLONERSFIELDS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("65c893054647f92b11790bc0ba4947a5");
            pSDEFieldModel.setName("CLONERSFIELDS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u514b\u9686\u5173\u7cfb\u5c5e\u6027");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CloneRSFields");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CNTPSDEFID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b243a9ada11e4a2633b27b9a7bb802b7");
            pSDEFieldModel.setName("CNTPSDEFID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7236\u6570\u636e\u8ba1\u6570\u5c5e\u6027");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEFIELD_CNTPSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDEFIELDID");
            pSDEFieldModel.setCodeName("CntPSDEFId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CNTPSDEFID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CNTPSDEFID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CNTPSDEFNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8792b6fc1ab116d1941eb77c939a4b1d");
            pSDEFieldModel.setName("CNTPSDEFNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7236\u6570\u636e\u8ba1\u6570\u5c5e\u6027");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEFIELD_CNTPSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDEFIELDNAME");
            pSDEFieldModel.setCodeName("CntPSDEFName");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CNTPSDEFNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CNTPSDEFNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CNTPSDEFNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CNTPSDEFNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9b02e42f7aab7da636543794d13690b4");
            pSDEFieldModel.setName("CODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CodeName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u8981\u5728\u5173\u7cfb\u7684\u4ece\u5b9e\u4f53\u4e2d\u5177\u6709\u552f\u4e00\u6027");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd");
            pSDEFieldModel.setLength(60);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CODENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CODENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CODENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CODENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fc2f930e7d24e9e9573dc51462b6e44b");
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
            pSDEFieldModel.setId("022fc3cf9cb522a753d2b4d5cbe6dcaa");
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
        object = this.createDEField("DEFINHERITMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d5751cc8fccd623cba2829d89de107fc");
            pSDEFieldModel.setName("DEFINHERITMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5c5e\u6027\u7ee7\u627f\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEFDERInheritModeCodeListModel");
            pSDEFieldModel.setCodeName("DEFInheritMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7ee7\u627f\u5173\u7cfb\u7684\u5c5e\u6027\u7ee7\u627f\u6a21\u5f0f");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DEFINHERITMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DEFINHERITMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DERFIELDLNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("19a864d83b83cff87d37c4c7defc2c0f");
            pSDEFieldModel.setName("DERFIELDLNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b57\u6bb5\u903b\u8f91\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DERFieldLName");
            pSDEFieldModel.setMemo("\u6307\u5b9a1:N\u5173\u7cfb\u8fde\u63a5\u5c5e\u6027\u7684\u903b\u8f91\u540d\u79f0");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DERFIELDNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d9581418b44a0b48708d32a0621957e8");
            pSDEFieldModel.setName("DERFIELDNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u7cfb\u5b57\u6bb5\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DERFieldName");
            pSDEFieldModel.setMemo("\u6307\u5b9a1:N\u5173\u7cfb\u8fde\u63a5\u5c5e\u6027\u7684\u540d\u79f0");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DERSUBTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("adea2958d0c743610165fa6f048325de");
            pSDEFieldModel.setName("DERSUBTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u7cfb\u5b50\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DERSubTypeCodeListModel");
            pSDEFieldModel.setCodeName("DERSubType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u81ea\u5b9a\u4e49\u5173\u7cfb\u7684\u5b50\u7c7b\u578b");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DERSUBTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DERSUBTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DERTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0e31c0e75cd2660c0226f42ff4630d69");
            pSDEFieldModel.setName("DERTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u7cfb\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DERTag");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DERTAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("77a93ba8090319d95e8494bfb0ae37b9");
            pSDEFieldModel.setName("DERTAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u7cfb\u6807\u8bb02");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DERTag2");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DERTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3678512f2ae869d2dd9874c0a44ef94c");
            pSDEFieldModel.setName("DERTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u7cfb\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMultiFormDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DERTypeCodeListModel");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("DERType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u7684\u7c7b\u578b");
            pSDEFieldModel.setLength(10);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DERTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DERTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DERTYPE_IN")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DERTYPE_IN");
                dEFSearchModeModel.setValueOp("IN");
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
            pSDEFieldModel.setId("f56da576271a35fc1a619f411d6bc309");
            pSDEFieldModel.setName("DYNAMODELFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u6a21\u578b\u7c7b\u578b");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DynaModelTypeCodeListModel");
            pSDEFieldModel.setCodeName("DynaModelFlag");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DYNAMODELFLAG_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DYNAMODELFLAG_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLECLONE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("66dcab0f8c2f91d16c8215b892451dd4");
            pSDEFieldModel.setName("ENABLECLONE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u5173\u8054\u590d\u5236");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableClone");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENADEFIELDWRITEBACK");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4f5b93dd702b4810562465b4a4ca4143");
            pSDEFieldModel.setName("ENADEFIELDWRITEBACK");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u652f\u6301\u5173\u7cfb\u5c5e\u6027\u56de\u5199");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEFWriteBackModeCodeListModel");
            pSDEFieldModel.setCodeName("EnaDEFieldWriteBack");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u7684\u94fe\u63a5\u5c5e\u6027\u540c\u6b65\u6a21\u5f0f");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENAEXTRANGE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a99fe8d12b0b30320912ad9f427e16b4");
            pSDEFieldModel.setName("ENAEXTRANGE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u9644\u52a0\u7ea6\u675f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnaExtRange");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u5bf9\u5f15\u7528\u5b9e\u4f53\u7684\u9644\u52a0\u7ea6\u675f\uff0c\u5982\u542f\u7528\u9700\u540c\u65f6\u6307\u5b9a\u7b49\u4ef7\u7ea6\u675f\u7684\u4e3b\u5b9e\u4f53\u5c5e\u6027\u53ca\u4ece\u5b9e\u4f53\u5c5e\u6027\uff0c\u9ed8\u8ba4\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENAPDEREQ");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7608ed614b7c1a763c14f5acde0d6415");
            pSDEFieldModel.setName("ENAPDEREQ");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7236\u5173\u7cfb\u7b49\u4ef7");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnaPDEREQ");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u662f\u5426\u8981\u6c42\u4e3b\u5b9e\u4f53\u53ca\u4ece\u5b9e\u4f53\u90fd\u5b58\u5728\u5bf9\u540c\u4e00\u4e2a\u7b2c\u4e09\u65b9\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb\uff0c\u5982\u542f\u7528\u9700\u540c\u65f6\u6307\u5b9a\u4e3b\u5b9e\u4f53\u53ca\u4ece\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb\uff0c\u9ed8\u8ba4\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXPORTMAJORMODEL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("87ef6d7726660fd53c8ef0d27e3ae618");
            pSDEFieldModel.setName("EXPORTMAJORMODEL");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bfc\u51fa\u5f15\u7528\u6a21\u578b\u5173\u7cfb");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DERExportMajorModelCodeListModel");
            pSDEFieldModel.setCodeName("ExportMajorModel");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EXPORTMAJORMODEL_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EXPORTMAJORMODEL_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXPORTMODEL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8e64c9a7a1e16c9ec1666c6e83ca440f");
            pSDEFieldModel.setName("EXPORTMODEL");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bfc\u51fa\u6a21\u578b\u5173\u7cfb");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
            pSDEFieldModel.setCodeName("ExportModel");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EXPORTMODEL_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EXPORTMODEL_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXPORTSCOPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("610c0bb31c39c0e51f1a6294ee0f46c2");
            pSDEFieldModel.setName("EXPORTSCOPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u5bfc\u51fa\u5173\u7cfb");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
            pSDEFieldModel.setCodeName("ExportScope");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EXPORTSCOPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EXPORTSCOPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXPORTSCOPE2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6a42e10c33328d1c72de3f971a434e03");
            pSDEFieldModel.setName("EXPORTSCOPE2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u5bfc\u51fa\u5173\u7cfb2");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
            pSDEFieldModel.setCodeName("ExportScope2");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EXPORTSCOPE2_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EXPORTSCOPE2_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXPORTSCOPE3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d36d1fad1741e3fac9cfe342265505aa");
            pSDEFieldModel.setName("EXPORTSCOPE3");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u5bfc\u51fa\u5173\u7cfb3");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ExportModelScope2CodeListModel");
            pSDEFieldModel.setCodeName("ExportScope3");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EXPORTSCOPE3_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EXPORTSCOPE3_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXPORTSCOPE4");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bd8b095dfec5bd804cf0415c99364990");
            pSDEFieldModel.setName("EXPORTSCOPE4");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u5bfc\u51fa\u5173\u7cfb4");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
            pSDEFieldModel.setCodeName("ExportScope4");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EXPORTSCOPE4_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EXPORTSCOPE4_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXPORTSCOPE5");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6a9b2ba053ed5e17f3f59f135d239f25");
            pSDEFieldModel.setName("EXPORTSCOPE5");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u5bfc\u51fa\u5173\u7cfb5");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ExportModelScope2CodeListModel");
            pSDEFieldModel.setCodeName("ExportScope5");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EXPORTSCOPE5_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EXPORTSCOPE5_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXPORTSCOPE6");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("99f2a67533d94e859dc74d8c513a38eb");
            pSDEFieldModel.setName("EXPORTSCOPE6");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u5bfc\u51fa\u5173\u7cfb6");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ExportModelScope2CodeListModel");
            pSDEFieldModel.setCodeName("ExportScope6");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EXPORTSCOPE6_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EXPORTSCOPE6_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXTMAJORPSDEFID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4b4188e934bbefda719b5a4a4510a964");
            pSDEFieldModel.setName("EXTMAJORPSDEFID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9644\u52a0\u7ea6\u675f\u4e3b\u5b9e\u4f53\u5c5e\u6027");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEFIELD_EXTMAJORPSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDEFIELDID");
            pSDEFieldModel.setCodeName("EXTMajorPSDEFId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EXTMAJORPSDEFID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EXTMAJORPSDEFID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXTMAJORPSDEFNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8c978ab50c570aba28520b4a36390838");
            pSDEFieldModel.setName("EXTMAJORPSDEFNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u9644\u52a0\u7ea6\u675f\u4e3b\u5b9e\u4f53\u5c5e\u6027");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEFIELD_EXTMAJORPSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDEFIELDNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("EXTMajorPSDEFName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u542f\u7528\u5f15\u7528\u5b9e\u4f53\u7684\u9644\u52a0\u7ea6\u675f\u65f6\u7684\u4e3b\u5b9e\u4f53\u5c5e\u6027");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EXTMAJORPSDEFNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EXTMAJORPSDEFNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EXTMAJORPSDEFNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EXTMAJORPSDEFNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXTMINORPSDEFID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("48eb1c1d2c6e9ff4c248e7fa3ab29912");
            pSDEFieldModel.setName("EXTMINORPSDEFID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9644\u52a0\u7ea6\u675f\u4ece\u5b9e\u4f53\u5c5e\u6027");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEFIELD_EXTMINORPSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDEFIELDID");
            pSDEFieldModel.setCodeName("EXTMinorPSDEFId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EXTMINORPSDEFID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EXTMINORPSDEFID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EXTMINORPSDEFNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b128334a9f8638dbf59de1bf2a133de1");
            pSDEFieldModel.setName("EXTMINORPSDEFNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u9644\u52a0\u7ea6\u675f\u4ece\u5b9e\u4f53\u5c5e\u6027");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEFIELD_EXTMINORPSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDEFIELDNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("EXTMinorPSDEFName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u542f\u7528\u5f15\u7528\u5b9e\u4f53\u7684\u9644\u52a0\u7ea6\u675f\u65f6\u7684\u4ece\u5b9e\u4f53\u5c5e\u6027");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EXTMINORPSDEFNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EXTMINORPSDEFNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EXTMINORPSDEFNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EXTMINORPSDEFNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FKEYNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("167e11ef70e671e27268644a19729ac0");
            pSDEFieldModel.setName("FKEYNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5916\u952e\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("FKeyName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u53d1\u5e03\u6570\u636e\u5e93\u5916\u952e\u65f6\u4f7f\u7528\u7684\u540d\u79f0\uff0c\u4e0d\u6307\u5b9a\u65f6\u7531\u5f15\u64ce\u81ea\u52a8\u8ba1\u7b97");
            pSDEFieldModel.setLength(20);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FOREIGNKEY");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0f22ccfebe52db05ef657c353027b4a9");
            pSDEFieldModel.setName("FOREIGNKEY");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u5916\u952e");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ForeignKey");
            pSDEFieldModel.setMemo("\u6307\u5b9a1:N\u5173\u7cfb\u662f\u5426\u53d1\u5e03\u5bf9\u5e94\u6570\u636e\u5e93\u5916\u952e\u7ea6\u675f\uff0c\u9ed8\u8ba4\u4e3a\u3010\u662f\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("IGNOREDEFIELDS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4439b9bf05a7130259750ae557443db7");
            pSDEFieldModel.setName("IGNOREDEFIELDS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7ee7\u627f\u5c5e\u6027\u96c6\u5408");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("IgnoreDEFields");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7ee7\u627f\u5173\u7cfb\u7ee7\u627f\u5c5e\u6027\u6e05\u5355\uff0c\u4f7f\u7528\u3010\u7ee7\u627f\u5c5e\u6027\u3011=\u3010\u6e90\u5c5e\u6027\u3011\u683c\u5f0f");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INDEXVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8f350511e28db82c9572be1065cd5f4c");
            pSDEFieldModel.setName("INDEXVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7c7b\u578b\u8bc6\u522b\u503c");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("IndexValue");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7ee7\u627f\u6216\u7d22\u5f15\u5173\u7cfb\u7684\u7c7b\u578b\u8bc6\u522b\u503c");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INHERITMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("01169d6a6be9dc0bd1cebb8324844396");
            pSDEFieldModel.setName("INHERITMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7ee7\u627f\u5904\u7406\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DERInheritModeCodeListModel");
            pSDEFieldModel.setCodeName("InheritMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7ee7\u627f\u5173\u7cfb\u7684\u7ee7\u627f\u6a21\u5f0f\uff0c\u9ed8\u8ba4\u4e3a\u3010\u5b58\u50a8\u7ee7\u627f\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_INHERITMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_INHERITMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LINKPSDEVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8aca65e398d1bd1c7b4bf4b2819b70b3");
            pSDEFieldModel.setName("LINKPSDEVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u94fe\u63a5\u5c55\u73b0\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEVIEWBASE_LINKPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setCodeName("LinkPSDEViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LINKPSDEVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LINKPSDEVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LINKPSDEVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("606a8590e087541c3bf8d7b0d9f35b1a");
            pSDEFieldModel.setName("LINKPSDEVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u94fe\u63a5\u5c55\u73b0\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEVIEWBASE_LINKPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("LinkPSDEViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u94fe\u63a5\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u7f51\u9875\u7aef\uff09");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LINKPSDEVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LINKPSDEVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LINKPSDEVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LINKPSDEVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LOCKFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a5b75059bbe74de254457c8f83c4bcae");
            pSDEFieldModel.setName("LOCKFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u578b\u9501\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
            pSDEFieldModel.setCodeName("LockFlag");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LOGICNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("88ad64a210cfa9e5d34829e19fd5bc9c");
            pSDEFieldModel.setName("LOGICNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u6587\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("LogicName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7684\u4e2d\u6587\u540d\u79f0");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MAJORPSDEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("62eba04dff0d4ad90a26978f4dfc64fa");
            pSDEFieldModel.setName("MAJORPSDEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u7cfb\u4e3b\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDATAENTITY_MAJORPSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("MajorPSDEId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MAJORPSDEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MAJORPSDEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MAJORPSDENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("70d8f1ddb298aba01b1507ea1cf36190");
            pSDEFieldModel.setName("MAJORPSDENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u7cfb\u4e3b\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDATAENTITY_MAJORPSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYNAME");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("MajorPSDEName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u7684\u4e3b\u5b9e\u4f53");
            pSDEFieldModel.setLength(60);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MAJORPSDENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MAJORPSDENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MAJORPSDENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MAJORPSDENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MAJORPSDERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("949201e2be724df0354b9f9a8dd1955a");
            pSDEFieldModel.setName("MAJORPSDERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e3b\u5b9e\u4f53\u7236\u5173\u7cfb");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDER_MAJORPSDERID");
            pSDEFieldModel.setLinkDEFName("PSDERID");
            pSDEFieldModel.setCodeName("MajorPSDERId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MAJORPSDERID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MAJORPSDERID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MAJORPSDERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1ebcd0fd7625b0d92852f08389bcd740");
            pSDEFieldModel.setName("MAJORPSDERNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e3b\u5b9e\u4f53\u7236\u5173\u7cfb");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDER_MAJORPSDERID");
            pSDEFieldModel.setLinkDEFName("PSDERNAME");
            pSDEFieldModel.setCodeName("MajorPSDERName");
            pSDEFieldModel.setMemo("\u5728\u542f\u7528\u7236\u5173\u7cfb\u7b49\u4ef7\u65f6\u6307\u5b9a\u4e3b\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MAJORPSDERNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MAJORPSDERNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MAJORPSDERNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MAJORPSDERNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MASTERORDERVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7cb29d24e7d6dd5da2bfda1e1786a437");
            pSDEFieldModel.setName("MASTERORDERVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e3b\u63a7\u5173\u7cfb\u6392\u5e8f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
            pSDEFieldModel.setCodeName("MasterOrderValue");
            pSDEFieldModel.setMemo("\u6307\u5b9a1:N\u5173\u7cfb\u4e3b\u63a7\u6a21\u5f0f\u7684\u7ea7\u522b");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MASTERRS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1dfa8aea50c0df4a585dfd4280270825");
            pSDEFieldModel.setName("MASTERRS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e3b\u4ece\u5173\u7cfb");
            pSDEFieldModel.setDataType("NMCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NMasterRSCodeListModel");
            pSDEFieldModel.setCodeName("MasterRS");
            pSDEFieldModel.setMemo("\u989d\u5916\u6307\u5b9a\u4e3b\u4ece\u5173\u7cfb\u7684\u7c7b\u578b");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MDPSDEVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("396c9610e6475b6ae04d787edecfc2c6");
            pSDEFieldModel.setName("MDPSDEVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u591a\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEVIEWBASE_MDPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setCodeName("MDPSDEViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSDEVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSDEVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MDPSDEVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("69052c36fc6aad75b97f194530f47204");
            pSDEFieldModel.setName("MDPSDEVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u591a\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEVIEWBASE_MDPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("MDPSDEViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u591a\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u684c\u9762\u7aef\uff09");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSDEVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSDEVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSDEVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSDEVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
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
            pSDEFieldModel.setId("e684734a9ade36eacae86fb286482fa2");
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
        object = this.createDEField("MINORCODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("62218b7ad932ec94f6db3357879bec30");
            pSDEFieldModel.setName("MINORCODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ece\u5173\u7cfb\u4ee3\u7801\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MinorCodeName");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MINORLOGICNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f9843cdf9833be83d15cb4a0359cfc17");
            pSDEFieldModel.setName("MINORLOGICNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ece\u5173\u7cfb\u903b\u8f91\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MinorLogicName");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MINORPSDEDSID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5b357b7d8d03af6ef34a488f62559c5b");
            pSDEFieldModel.setName("MINORPSDEDSID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ece\u5b9e\u4f53\u6570\u636e\u96c6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEDATASET_MINORPSDEDSID");
            pSDEFieldModel.setLinkDEFName("PSDEDATASETID");
            pSDEFieldModel.setCodeName("MinorPSDEDSId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MINORPSDEDSID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MINORPSDEDSID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MINORPSDEDSNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("93d9d4c3f8e447e82bc8b603d2a0b700");
            pSDEFieldModel.setName("MINORPSDEDSNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u4ece\u5b9e\u4f53\u6570\u636e\u96c6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEDATASET_MINORPSDEDSID");
            pSDEFieldModel.setLinkDEFName("PSDEDATASETNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("MinorPSDEDSName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MINORPSDEDSNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MINORPSDEDSNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MINORPSDEDSNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MINORPSDEDSNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MINORPSDEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("187e4a12852be4cb121adf6f4b96ff1f");
            pSDEFieldModel.setName("MINORPSDEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u7cfb\u4ece\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDATAENTITY_MINORPSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("MinorPSDEId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MINORPSDEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MINORPSDEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MINORPSDENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f5fdaacac00f8381b9378081457267eb");
            pSDEFieldModel.setName("MINORPSDENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u7cfb\u4ece\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDATAENTITY_MINORPSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYNAME");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("MinorPSDEName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u7684\u4ece\u5b9e\u4f53\uff0c\u9664\u4e86\u30101:N\u5173\u7cfb\u3011\u7c7b\u578b\u5916\uff0c\u5176\u5b83\u7c7b\u578b\u5173\u7cfb\u4ece\u5b9e\u4f53\u4e0d\u80fd\u4e0e\u4e3b\u5b9e\u4f53\u4e00\u81f4");
            pSDEFieldModel.setLength(60);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MINORPSDENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MINORPSDENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MINORPSDENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MINORPSDENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MINORPSDERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c07e90e27ae1ddc2496b7db3c3a7a5bf");
            pSDEFieldModel.setName("MINORPSDERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9644\u5c5e\u5b9e\u4f53\u7236\u5173\u7cfb");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDER_MINORPSDERID");
            pSDEFieldModel.setLinkDEFName("PSDERID");
            pSDEFieldModel.setCodeName("MinorPSDERId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MINORPSDERID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MINORPSDERID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MINORPSDERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("79d8ec6390fbbb95c027084f6437649c");
            pSDEFieldModel.setName("MINORPSDERNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9644\u5c5e\u5b9e\u4f53\u7236\u5173\u7cfb");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDER_MINORPSDERID");
            pSDEFieldModel.setLinkDEFName("PSDERNAME");
            pSDEFieldModel.setCodeName("MinorPSDERName");
            pSDEFieldModel.setMemo("\u5728\u542f\u7528\u7236\u5173\u7cfb\u7b49\u4ef7\u65f6\u6307\u5b9a\u4ece\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MINORPSDERNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MINORPSDERNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MINORPSDERNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MINORPSDERNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MINORSERVICECODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8e55a752d07f882e7517c484eee87519");
            pSDEFieldModel.setName("MINORSERVICECODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ece\u5173\u7cfb\u670d\u52a1\u4ee3\u7801\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MinorServiceCodeName");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MOBLINKPSDEVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("28a69bb256dbedba6f9089b8911712b3");
            pSDEFieldModel.setName("MOBLINKPSDEVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u79fb\u52a8\u7aef\u94fe\u63a5\u5c55\u73b0\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEVIEWBASE_MOBLINKPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setCodeName("MobLinkPSDEViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MOBLINKPSDEVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MOBLINKPSDEVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MOBLINKPSDEVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0a2f92d60e7361101370d411cf3a7f34");
            pSDEFieldModel.setName("MOBLINKPSDEVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u79fb\u52a8\u7aef\u94fe\u63a5\u5c55\u73b0\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEVIEWBASE_MOBLINKPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("MobLinkPSDEViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u94fe\u63a5\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u79fb\u52a8\u7aef\uff09");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MOBLINKPSDEVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MOBLINKPSDEVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MOBLINKPSDEVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MOBLINKPSDEVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MOBMDPSDEVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("41b165ab241264a92e005f91c3714555");
            pSDEFieldModel.setName("MOBMDPSDEVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u79fb\u52a8\u7aef\u591a\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEVIEWBASE_MOBMDPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setCodeName("MobMDPSDEViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MOBMDPSDEVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MOBMDPSDEVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MOBMDPSDEVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3a951192cd90f3149901d894bb09141c");
            pSDEFieldModel.setName("MOBMDPSDEVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u79fb\u52a8\u7aef\u591a\u9009\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEVIEWBASE_MOBMDPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("MobMDPSDEViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u591a\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u79fb\u52a8\u7aef\uff09");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MOBMDPSDEVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MOBMDPSDEVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MOBMDPSDEVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MOBMDPSDEVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MOBSDPSDEVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3840796f8243450a820e48702dea1320");
            pSDEFieldModel.setName("MOBSDPSDEVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u79fb\u52a8\u7aef\u5355\u9009\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEVIEWBASE_MOBSDPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setCodeName("MobSDPSDEViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MOBSDPSDEVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MOBSDPSDEVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MOBSDPSDEVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("04b62af302bf649d2d0b4386a2d48f1a");
            pSDEFieldModel.setName("MOBSDPSDEVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u79fb\u52a8\u7aef\u5355\u9009\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEVIEWBASE_MOBSDPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("MobSDPSDEViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u5355\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u79fb\u52a8\u7aef\uff09");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MOBSDPSDEVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MOBSDPSDEVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MOBSDPSDEVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MOBSDPSDEVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ORDERVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("55b369aeac828ecc8a640e1e6e7fbad3");
            pSDEFieldModel.setName("ORDERVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6392\u5e8f\u503c");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("OrderValue");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREDEFINEDTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f4aa45355d1468e0fd4656a14d79145b");
            pSDEFieldModel.setName("PREDEFINEDTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9884\u7f6e\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PredefinedCLTypeCodeListModel");
            pSDEFieldModel.setCodeName("PredefinedType");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PREDEFINEDTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PREDEFINEDTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PROPERTYMAP");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("01f0c251f54c620ba212b188286f6608");
            pSDEFieldModel.setName("PROPERTYMAP");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u53c2\u6570\u6620\u5c04");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PropertyMap");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEACMODEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("797111fa20da5564cacd5536d71586ca");
            pSDEFieldModel.setName("PSDEACMODEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u81ea\u586b\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEACMODE_PSDEACMODEID");
            pSDEFieldModel.setLinkDEFName("PSDEACMODEID");
            pSDEFieldModel.setCodeName("PSDEACModeId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEACMODEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEACMODEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEACMODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9da6861f42e8ae1ecc0718063efb85ab");
            pSDEFieldModel.setName("PSDEACMODENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u81ea\u586b\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEACMODE_PSDEACMODEID");
            pSDEFieldModel.setLinkDEFName("PSDEACMODENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEACModeName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u81ea\u52a8\u586b\u5145\u529f\u80fd\u65f6\u9ed8\u8ba4\u914d\u7f6e");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEACMODENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEACMODENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEACMODENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEACMODENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDATASETID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d6dd20c459d589fdb2cd53798e445047");
            pSDEFieldModel.setName("PSDEDATASETID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u6570\u636e\u96c6\u5408");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEDATASET_PSDEDATASETID");
            pSDEFieldModel.setLinkDEFName("PSDEDATASETID");
            pSDEFieldModel.setCodeName("PSDEDataSetId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATASETID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATASETID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDATASETNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b5ef47981d03a18cce2e50cd0c3df7a4");
            pSDEFieldModel.setName("PSDEDATASETNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u6570\u636e\u96c6\u5408");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEDATASET_PSDEDATASETID");
            pSDEFieldModel.setLinkDEFName("PSDEDATASETNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEDataSetName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u7684\u6570\u636e\u96c6\u5408");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATASETNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATASETNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDATASETNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDATASETNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDRITEMSCNT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("87b92b6b6028ec84b2d99f788e74e2b4");
            pSDEFieldModel.setName("PSDEDRITEMSCNT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5173\u7cfb\u754c\u9762\u8ba1\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDEDRItemsCnt");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFGROUPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("786fdab6bbc7a185e148ac4d75087fbe");
            pSDEFieldModel.setName("PSDEFGROUPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5c5e\u6027\u7ec4");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEFGROUP_PSDEFGROUPID");
            pSDEFieldModel.setLinkDEFName("PSDEFGROUPID");
            pSDEFieldModel.setCodeName("PSDEFGroupId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFGROUPID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFGROUPID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFGROUPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8d217716c7e37edcd4c6c68ddcd702c0");
            pSDEFieldModel.setName("PSDEFGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5c5e\u6027\u7ec4");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEFGROUP_PSDEFGROUPID");
            pSDEFieldModel.setLinkDEFName("PSDEFGROUPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEFGroupName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFGROUPNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFGROUPNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFGROUPNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFGROUPNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFIELDSCNT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9b401e1dbf77da7db18bd1fb9c7a8448");
            pSDEFieldModel.setName("PSDEFIELDSCNT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5c5e\u6027\u8ba1\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDEFieldsCnt");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEOPPRIVSCNT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e3ee46b9b6042fa161e33d3798ea7066");
            pSDEFieldModel.setName("PSDEOPPRIVSCNT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u64cd\u4f5c\u6743\u9650\u8ba1\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDEOPPrivsCnt");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDERDEFMAPSCNT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("73d1b5270bbb0a5b596009c8955edd02");
            pSDEFieldModel.setName("PSDERDEFMAPSCNT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5173\u7cfb\u5c5e\u6027\u6620\u5c04\u8ba1\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDERDEFMapsCnt");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bc95fc85418a0d8a90d940434d9ed9ec");
            pSDEFieldModel.setName("PSDERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5173\u7cfb\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDERId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("593e8a672c0d720c61c3defce2ab8c2b");
            pSDEFieldModel.setName("PSDERNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u7cfb\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDERName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7684\u540d\u79f0");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDERNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDERNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDERNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDERNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDYNAINSTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e44f09261eca5c926545baa48c091e2d");
            pSDEFieldModel.setName("PSDYNAINSTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("PSDYNAINSTID");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSDynaInstId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDYNAMODELID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("aa69ef8fe801c9c7a2d2e225b23d77f3");
            pSDEFieldModel.setName("PSSYSDYNAMODELID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u7cfb\u7edf\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSSYSDYNAMODEL_PSSYSDYNAMODELID");
            pSDEFieldModel.setLinkDEFName("PSSYSDYNAMODELID");
            pSDEFieldModel.setCodeName("PSSysDynaModelId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDYNAMODELID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDYNAMODELID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDYNAMODELNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("01a868ad56d939f95c5b79c3218be9d8");
            pSDEFieldModel.setName("PSSYSDYNAMODELNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u7cfb\u7edf\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSSYSDYNAMODEL_PSSYSDYNAMODELID");
            pSDEFieldModel.setLinkDEFName("PSSYSDYNAMODELNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysDynaModelName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDYNAMODELNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDYNAMODELNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDYNAMODELNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDYNAMODELNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSSFPLUGINID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d6d1e9951230a38dbe327004830fcd5b");
            pSDEFieldModel.setName("PSSYSSFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540e\u7aef\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSSYSSFPLUGIN_PSSYSSFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSSFPLUGINID");
            pSDEFieldModel.setCodeName("PSSysSFPluginId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSSFPLUGINID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSSFPLUGINID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSSFPLUGINNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cb6387486afd18cf764be8618f03d349");
            pSDEFieldModel.setName("PSSYSSFPLUGINNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u540e\u7aef\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSSYSSFPLUGIN_PSSYSSFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSSFPLUGINNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysSFPluginName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSSFPLUGINNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSSFPLUGINNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSSFPLUGINNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSSFPLUGINNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("38d22bb23a2ef1c4b375a31cd49320be");
            pSDEFieldModel.setName("PSSYSTEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSSYSTEM_PSSYSTEMID");
            pSDEFieldModel.setLinkDEFName("PSSYSTEMID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSSystemId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTEMID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTEMID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSTEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("02bec097b2f6f4d03271f6b752e59091");
            pSDEFieldModel.setName("PSSYSTEMNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSSYSTEM_PSSYSTEMID");
            pSDEFieldModel.setLinkDEFName("PSSYSTEMNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSSystemName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTEMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTEMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSTEMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSTEMNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REMOVEACTIONTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b5dea2c2a4ff8d47bc53d8be2093a2b6");
            pSDEFieldModel.setName("REMOVEACTIONTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e3b\u5b9e\u4f53\u5220\u9664\u64cd\u4f5c");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RemoveActionTypeCodeListModel");
            pSDEFieldModel.setCodeName("RemoveActionType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u4e3b\u5b9e\u4f53\u6570\u636e\u5220\u9664\u65f6\u4ece\u5b9e\u4f53\u7684\u64cd\u4f5c");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REMOVEACTIONTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REMOVEACTIONTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REMOVEORDER");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0be02327ff3bd990d5e96fd638c57030");
            pSDEFieldModel.setName("REMOVEORDER");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5220\u9664\u6b21\u5e8f");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RemoveOrder");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u4ece\u5b9e\u4f53\u5728\u8fdb\u884c\u6570\u636e\u5173\u8054\u5220\u9664\u65f6\u7684\u6b21\u5e8f\uff0c\u6309\u5347\u5e8f\u5904\u7406");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REMOVEREJECTMSG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0b81001e0e91008aebf2e3ee0e432452");
            pSDEFieldModel.setName("REMOVEREJECTMSG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5220\u9664\u62d2\u7edd\u6d88\u606f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RemoveRejectMsg");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u9650\u5236\u4e3b\u5b9e\u4f53\u8fdb\u884c\u6570\u636e\u65f6\u7684\u63d0\u793a\u4fe1\u606f");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REMOVEREJECTPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("31ae00289e7ac9aa385d3575775b2fd3");
            pSDEFieldModel.setName("REMOVEREJECTPSLANRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5220\u9664\u62d2\u7edd\u6d88\u606f\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSLANGUAGERES_REMOVEREJECTPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESID");
            pSDEFieldModel.setCodeName("RemoveRejectPSLanResId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REMOVEREJECTPSLANRESID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REMOVEREJECTPSLANRESID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REMOVEREJECTPSLANRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("447c27174d1965e903b70f2c96c0933c");
            pSDEFieldModel.setName("REMOVEREJECTPSLANRESNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5220\u9664\u62d2\u7edd\u6d88\u606f\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSLANGUAGERES_REMOVEREJECTPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESNAME");
            pSDEFieldModel.setCodeName("RemoveRejectPSLanResName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REMOVEREJECTPSLANRESNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REMOVEREJECTPSLANRESNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REMOVEREJECTPSLANRESNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REMOVEREJECTPSLANRESNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RSPSDEVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d0297f62604b049712551c09a402f033");
            pSDEFieldModel.setName("RSPSDEVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5173\u7cfb\u6570\u636e\u5c55\u73b0\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEVIEWBASE_RSPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setCodeName("RSPSDEViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_RSPSDEVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_RSPSDEVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RSPSDEVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2a3c7cf084905a1b59a0c440a38b80cb");
            pSDEFieldModel.setName("RSPSDEVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5173\u7cfb\u6570\u636e\u5c55\u73b0\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEVIEWBASE_RSPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RSPSDEViewName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_RSPSDEVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_RSPSDEVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_RSPSDEVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_RSPSDEVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SDPSDEVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("00e5d77170b0e9a6e4bad7ed1341a0ce");
            pSDEFieldModel.setName("SDPSDEVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5355\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEVIEWBASE_SDPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setCodeName("SDPSDEViewID");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SDPSDEVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SDPSDEVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SDPSDEVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7fe0b66c383d90f7755bf3dcd0ffcf63");
            pSDEFieldModel.setName("SDPSDEVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5355\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDER_PSDEVIEWBASE_SDPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("SDPSDEViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u5355\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u684c\u9762\u7aef\uff09");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SDPSDEVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SDPSDEVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SDPSDEVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SDPSDEVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SERVICECODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c475d5ff8fe08c748f0087f9cb442a6f");
            pSDEFieldModel.setName("SERVICECODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e3b\u5173\u7cfb\u670d\u52a1\u4ee3\u7801\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ServiceCodeName");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SYNCEXPORTMODEL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("28966544b4d3db15ba9e63c60a4d5b73");
            pSDEFieldModel.setName("SYNCEXPORTMODEL");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540c\u6b65\u6a21\u578b");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NSyncActionCodeListModel");
            pSDEFieldModel.setCodeName("SyncExportModel");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SYNCEXPORTMODEL_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SYNCEXPORTMODEL_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPORDERVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0df0912abbf68fb1d9406534af0a2563");
            pSDEFieldModel.setName("TEMPORDERVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e34\u65f6\u6570\u636e\u5173\u7cfb");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
            pSDEFieldModel.setCodeName("TempOrderValue");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7684\u4e34\u65f6\u6570\u636e\u5904\u7406\u6a21\u5f0f");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TEMPORDERVALUE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TEMPORDERVALUE_EQ");
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
            pSDEFieldModel.setId("f6a19ca3f415a45894362767965a42b5");
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
            pSDEFieldModel.setId("f98c440b2d1fde2e5486b60431741156");
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
        object = this.createDEField("UPDATEPHYSICALDEFIELD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cba2cf07765b7e8218fa1bb903d36ab4");
            pSDEFieldModel.setName("UPDATEPHYSICALDEFIELD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u65b0\u7269\u7406\u5316\u66f4\u65b0\u5c5e\u6027");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("UpdatePhsicalDEField");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERCAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f202b19f884e01953d267b5471b2d32a");
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
        object = this.createDEField("USERPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d38612b4f26b57934344687307fa1035");
            pSDEFieldModel.setName("USERPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u53c2\u6570");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserParams");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(2000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ce23400dc90a174c3e95bb0be8c5812b");
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
            pSDEFieldModel.setId("6b022c122d8622b0042cf927e2321b4e");
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
            pSDEFieldModel.setId("b29b454f27af8d51aaaf9a210e677b45");
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
            pSDEFieldModel.setId("4f26dc64e53b59eaa01efddfd5d4b2c3");
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
            pSDEFieldModel.setId("4de679d7236f36f14e1df38fbf8ef35e");
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
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSDERDefaultACModel pSDERDefaultACModel = new PSDERDefaultACModel();
        pSDERDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDERDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDERCurDEDER11DSModel pSDERCurDEDER11DSModel = new PSDERCurDEDER11DSModel();
        pSDERCurDEDER11DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERCurDEDER11DSModel);
        PSDERCurDEDER11_CustomDSModel pSDERCurDEDER11_CustomDSModel = new PSDERCurDEDER11_CustomDSModel();
        pSDERCurDEDER11_CustomDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERCurDEDER11_CustomDSModel);
        PSDERCurDEDER1NDSModel pSDERCurDEDER1NDSModel = new PSDERCurDEDER1NDSModel();
        pSDERCurDEDER1NDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERCurDEDER1NDSModel);
        PSDERCurDEDER1N2DSModel pSDERCurDEDER1N2DSModel = new PSDERCurDEDER1N2DSModel();
        pSDERCurDEDER1N2DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERCurDEDER1N2DSModel);
        PSDERCurDEDER1N_CustomDSModel pSDERCurDEDER1N_CustomDSModel = new PSDERCurDEDER1N_CustomDSModel();
        pSDERCurDEDER1N_CustomDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERCurDEDER1N_CustomDSModel);
        PSDERCurDEDERCustomDSModel pSDERCurDEDERCustomDSModel = new PSDERCurDEDERCustomDSModel();
        pSDERCurDEDERCustomDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERCurDEDERCustomDSModel);
        PSDERCurDEMajorDSModel pSDERCurDEMajorDSModel = new PSDERCurDEMajorDSModel();
        pSDERCurDEMajorDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERCurDEMajorDSModel);
        PSDERCurDEMajor2DSModel pSDERCurDEMajor2DSModel = new PSDERCurDEMajor2DSModel();
        pSDERCurDEMajor2DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERCurDEMajor2DSModel);
        PSDERCurDEMajorAggDataDSModel pSDERCurDEMajorAggDataDSModel = new PSDERCurDEMajorAggDataDSModel();
        pSDERCurDEMajorAggDataDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERCurDEMajorAggDataDSModel);
        PSDERCurDEMinorDSModel pSDERCurDEMinorDSModel = new PSDERCurDEMinorDSModel();
        pSDERCurDEMinorDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERCurDEMinorDSModel);
        PSDERCurDEMinor2DSModel pSDERCurDEMinor2DSModel = new PSDERCurDEMinor2DSModel();
        pSDERCurDEMinor2DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERCurDEMinor2DSModel);
        PSDERCurSysDERDSModel pSDERCurSysDERDSModel = new PSDERCurSysDERDSModel();
        pSDERCurSysDERDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERCurSysDERDSModel);
        PSDERCurSysDER1NDSModel pSDERCurSysDER1NDSModel = new PSDERCurSysDER1NDSModel();
        pSDERCurSysDER1NDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERCurSysDER1NDSModel);
        PSDERDefaultDSModel pSDERDefaultDSModel = new PSDERDefaultDSModel();
        pSDERDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERDefaultDSModel);
        PSDERFormTypeDSModel pSDERFormTypeDSModel = new PSDERFormTypeDSModel();
        pSDERFormTypeDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERFormTypeDSModel);
        PSDERMajorMinorDER1NDSModel pSDERMajorMinorDER1NDSModel = new PSDERMajorMinorDER1NDSModel();
        pSDERMajorMinorDER1NDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERMajorMinorDER1NDSModel);
        PSDERX1NDSModel pSDERX1NDSModel = new PSDERX1NDSModel();
        pSDERX1NDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDERX1NDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDERCurDEDER11DQModel pSDERCurDEDER11DQModel = new PSDERCurDEDER11DQModel();
        pSDERCurDEDER11DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDERCurDEDER11DQModel);
        PSDERCurDEDER1NDQModel pSDERCurDEDER1NDQModel = new PSDERCurDEDER1NDQModel();
        pSDERCurDEDER1NDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDERCurDEDER1NDQModel);
        PSDERCurDEDER1N2DQModel pSDERCurDEDER1N2DQModel = new PSDERCurDEDER1N2DQModel();
        pSDERCurDEDER1N2DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDERCurDEDER1N2DQModel);
        PSDERCurDEDERCustomDQModel pSDERCurDEDERCustomDQModel = new PSDERCurDEDERCustomDQModel();
        pSDERCurDEDERCustomDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDERCurDEDERCustomDQModel);
        PSDERCurDEMajorDQModel pSDERCurDEMajorDQModel = new PSDERCurDEMajorDQModel();
        pSDERCurDEMajorDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDERCurDEMajorDQModel);
        PSDERCurDEMajor2DQModel pSDERCurDEMajor2DQModel = new PSDERCurDEMajor2DQModel();
        pSDERCurDEMajor2DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDERCurDEMajor2DQModel);
        PSDERCurDEMajorAggDataDQModel pSDERCurDEMajorAggDataDQModel = new PSDERCurDEMajorAggDataDQModel();
        pSDERCurDEMajorAggDataDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDERCurDEMajorAggDataDQModel);
        PSDERCurDEMinorDQModel pSDERCurDEMinorDQModel = new PSDERCurDEMinorDQModel();
        pSDERCurDEMinorDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDERCurDEMinorDQModel);
        PSDERCurDEMinor2DQModel pSDERCurDEMinor2DQModel = new PSDERCurDEMinor2DQModel();
        pSDERCurDEMinor2DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDERCurDEMinor2DQModel);
        PSDERCurSysDERDQModel pSDERCurSysDERDQModel = new PSDERCurSysDERDQModel();
        pSDERCurSysDERDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDERCurSysDERDQModel);
        PSDERCurSysDER1NDQModel pSDERCurSysDER1NDQModel = new PSDERCurSysDER1NDQModel();
        pSDERCurSysDER1NDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDERCurSysDER1NDQModel);
        PSDERDefaultDQModel pSDERDefaultDQModel = new PSDERDefaultDQModel();
        pSDERDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDERDefaultDQModel);
        PSDERMajorMinorDER1NDQModel pSDERMajorMinorDER1NDQModel = new PSDERMajorMinorDER1NDQModel();
        pSDERMajorMinorDER1NDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDERMajorMinorDER1NDQModel);
        PSDERX1NDQModel pSDERX1NDQModel = new PSDERX1NDQModel();
        pSDERX1NDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDERX1NDQModel);
    }

    protected void prepareDEActions() throws Exception {
    }

    protected void prepareDELogics() throws Exception {
        PSDERNode2DELogicModel pSDERNode2DELogicModel = new PSDERNode2DELogicModel();
        pSDERNode2DELogicModel.init((IDataEntity)this);
        this.registerDELogic((IDELogic)pSDERNode2DELogicModel);
    }

    @Override
    protected void onPrepareDEUIActions() throws Exception {
        PSDERCreateDEOPPrivUIActionModel pSDERCreateDEOPPrivUIActionModel = new PSDERCreateDEOPPrivUIActionModel();
        pSDERCreateDEOPPrivUIActionModel.init((IDataEntity)this);
        this.registerDEUIAction((IDEUIAction)pSDERCreateDEOPPrivUIActionModel);
        PSDERCreateDefaultVRUIActionModel pSDERCreateDefaultVRUIActionModel = new PSDERCreateDefaultVRUIActionModel();
        pSDERCreateDefaultVRUIActionModel.init((IDataEntity)this);
        this.registerDEUIAction((IDEUIAction)pSDERCreateDefaultVRUIActionModel);
        PSDERCreatePickupTextFieldUIActionModel pSDERCreatePickupTextFieldUIActionModel = new PSDERCreatePickupTextFieldUIActionModel();
        pSDERCreatePickupTextFieldUIActionModel.init((IDataEntity)this);
        this.registerDEUIAction((IDEUIAction)pSDERCreatePickupTextFieldUIActionModel);
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
        this.registerPDTDEView("EDITVIEW:DER11", "D48E933E-0F82-4EA2-A291-1C80BC0687C6");
        this.registerPDTDEView("EDITVIEW:DER1N", "645B6377-D2BD-4B63-9E5D-4C277B2FA26A");
        this.registerPDTDEView("EDITVIEW:DERAGGDATA", "21A34A9E-43EC-492A-AE3A-7105FD0D9F6B");
        this.registerPDTDEView("EDITVIEW:DERCUSTOM", "65A749C2-844E-48E8-819A-4B50985C6B85");
        this.registerPDTDEView("EDITVIEW:DERINDEX", "6CDAEA1D-182C-45EC-9AF7-55B2EC115306");
        this.registerPDTDEView("EDITVIEW:DERINHERIT", "B343FAFE-20D8-4C69-8F64-F1BF449729DF");
        this.registerPDTDEView("EDITVIEW:DERMULINH", "3CE5CF9D-C225-4D5A-BB1D-7940A2D1B8B5");
        this.registerPDTDEView("FORMPICKUPVIEW", "dff0181177dc36312b1216435a3571e1");
        this.registerPDTDEView("MPICKUPVIEW", "6cff6177e224bd5099f0247315bb5660");
        this.registerPDTDEView("PICKUPVIEW", "d3c0bd7cfd7c7623ee8a483433262ed0");
        this.registerPDTDEView("REDIRECTVIEW", "9fa2a42eb43b8b6cb3fd30ae41f3b5d8");
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
        dEDataSetCond2.setDEFName("PSDERNAME");
        dEDataSetCond2.setCondValue(string);
        dEDataSetCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)dEDataSetCond2);
    }

    @Override
    protected void onPreparePSDEFGroupModels() throws Exception {
        IPSDEFGroupModel iPSDEFGroupModel = this.preparePSDEFGroupModel_DER11();
        if (iPSDEFGroupModel != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DER1N()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DERCUSTOM()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DERINDEX()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DERINHERIT()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DERMULINH()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel__DEFAULT()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DER11() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DER11");
        pSDEFGroupModel.setName("1:1 \u5173\u7cfb");
        pSDEFGroupModel.setUserTag("DER11");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0e224f9d4a743ca265fcc0ec6bcbd569");
        pSDEFGroupDetailModel.setName("CLONEORDERVALUE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CLONEORDERVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7684\u514b\u9686\u5173\u7cfb\u7684\u7ea7\u522b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d9581418b44a0b48708d32a0621957e8");
        pSDEFGroupDetailModel.setName("DERFIELDNAME");
        iPSDEFieldModel = this.getDEField("DERFIELDNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a1:N\u5173\u7cfb\u8fde\u63a5\u5c5e\u6027\u7684\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4f5b93dd702b4810562465b4a4ca4143");
        pSDEFGroupDetailModel.setName("ENADEFIELDWRITEBACK");
        iPSDEFieldModel = this.getDEField("ENADEFIELDWRITEBACK", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEFWriteBackModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u7684\u94fe\u63a5\u5c5e\u6027\u540c\u6b65\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7608ed614b7c1a763c14f5acde0d6415");
        pSDEFGroupDetailModel.setName("ENAPDEREQ");
        iPSDEFieldModel = this.getDEField("ENAPDEREQ", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u8981\u6c42\u4e3b\u5b9e\u4f53\u53ca\u4ece\u5b9e\u4f53\u90fd\u5b58\u5728\u5bf9\u540c\u4e00\u4e2a\u7b2c\u4e09\u65b9\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb\uff0c\u5982\u542f\u7528\u9700\u540c\u65f6\u6307\u5b9a\u4e3b\u5b9e\u4f53\u53ca\u4ece\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb\uff0c\u9ed8\u8ba4\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8e64c9a7a1e16c9ec1666c6e83ca440f");
        pSDEFGroupDetailModel.setName("EXPORTMODEL");
        iPSDEFieldModel = this.getDEField("EXPORTMODEL", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("167e11ef70e671e27268644a19729ac0");
        pSDEFGroupDetailModel.setName("FKEYNAME");
        iPSDEFieldModel = this.getDEField("FKEYNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u53d1\u5e03\u6570\u636e\u5e93\u5916\u952e\u65f6\u4f7f\u7528\u7684\u540d\u79f0\uff0c\u4e0d\u6307\u5b9a\u65f6\u7531\u5f15\u64ce\u81ea\u52a8\u8ba1\u7b97");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0f22ccfebe52db05ef657c353027b4a9");
        pSDEFGroupDetailModel.setName("FOREIGNKEY");
        iPSDEFieldModel = this.getDEField("FOREIGNKEY", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a1:N\u5173\u7cfb\u662f\u5426\u53d1\u5e03\u5bf9\u5e94\u6570\u636e\u5e93\u5916\u952e\u7ea6\u675f\uff0c\u9ed8\u8ba4\u4e3a\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8aca65e398d1bd1c7b4bf4b2819b70b3");
        pSDEFGroupDetailModel.setName("LINKPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("LINKPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u94fe\u63a5\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u7f51\u9875\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("606a8590e087541c3bf8d7b0d9f35b1a");
        pSDEFGroupDetailModel.setName("LINKPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("LINKPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u94fe\u63a5\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u7f51\u9875\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a5b75059bbe74de254457c8f83c4bcae");
        pSDEFGroupDetailModel.setName("LOCKFLAG");
        iPSDEFieldModel = this.getDEField("LOCKFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("88ad64a210cfa9e5d34829e19fd5bc9c");
        pSDEFGroupDetailModel.setName("LOGICNAME");
        iPSDEFieldModel = this.getDEField("LOGICNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7684\u4e2d\u6587\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("949201e2be724df0354b9f9a8dd1955a");
        pSDEFGroupDetailModel.setName("MAJORPSDERID");
        iPSDEFieldModel = this.getDEField("MAJORPSDERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5728\u542f\u7528\u7236\u5173\u7cfb\u7b49\u4ef7\u65f6\u6307\u5b9a\u4e3b\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1ebcd0fd7625b0d92852f08389bcd740");
        pSDEFGroupDetailModel.setName("MAJORPSDERNAME");
        iPSDEFieldModel = this.getDEField("MAJORPSDERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5728\u542f\u7528\u7236\u5173\u7cfb\u7b49\u4ef7\u65f6\u6307\u5b9a\u4e3b\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1dfa8aea50c0df4a585dfd4280270825");
        pSDEFGroupDetailModel.setName("MASTERRS");
        iPSDEFieldModel = this.getDEField("MASTERRS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER11MasterRSCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u989d\u5916\u6307\u5b9a\u4e3b\u4ece\u5173\u7cfb\u7684\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("62218b7ad932ec94f6db3357879bec30");
        pSDEFGroupDetailModel.setName("MINORCODENAME");
        iPSDEFieldModel = this.getDEField("MINORCODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c07e90e27ae1ddc2496b7db3c3a7a5bf");
        pSDEFGroupDetailModel.setName("MINORPSDERID");
        iPSDEFieldModel = this.getDEField("MINORPSDERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5728\u542f\u7528\u7236\u5173\u7cfb\u7b49\u4ef7\u65f6\u6307\u5b9a\u4ece\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("79d8ec6390fbbb95c027084f6437649c");
        pSDEFGroupDetailModel.setName("MINORPSDERNAME");
        iPSDEFieldModel = this.getDEField("MINORPSDERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5728\u542f\u7528\u7236\u5173\u7cfb\u7b49\u4ef7\u65f6\u6307\u5b9a\u4ece\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("797111fa20da5564cacd5536d71586ca");
        pSDEFGroupDetailModel.setName("PSDEACMODEID");
        iPSDEFieldModel = this.getDEField("PSDEACMODEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u81ea\u52a8\u586b\u5145\u529f\u80fd\u65f6\u9ed8\u8ba4\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9da6861f42e8ae1ecc0718063efb85ab");
        pSDEFGroupDetailModel.setName("PSDEACMODENAME");
        iPSDEFieldModel = this.getDEField("PSDEACMODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u81ea\u52a8\u586b\u5145\u529f\u80fd\u65f6\u9ed8\u8ba4\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6dd20c459d589fdb2cd53798e445047");
        pSDEFGroupDetailModel.setName("PSDEDATASETID");
        iPSDEFieldModel = this.getDEField("PSDEDATASETID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u7684\u6570\u636e\u96c6\u5408");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b5ef47981d03a18cce2e50cd0c3df7a4");
        pSDEFGroupDetailModel.setName("PSDEDATASETNAME");
        iPSDEFieldModel = this.getDEField("PSDEDATASETNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u7684\u6570\u636e\u96c6\u5408");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("38d22bb23a2ef1c4b375a31cd49320be");
        pSDEFGroupDetailModel.setName("PSSYSTEMID");
        iPSDEFieldModel = this.getDEField("PSSYSTEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d0297f62604b049712551c09a402f033");
        pSDEFGroupDetailModel.setName("RSPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("RSPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2a3c7cf084905a1b59a0c440a38b80cb");
        pSDEFGroupDetailModel.setName("RSPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("RSPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b5dea2c2a4ff8d47bc53d8be2093a2b6");
        pSDEFGroupDetailModel.setName("REMOVEACTIONTYPE");
        iPSDEFieldModel = this.getDEField("REMOVEACTIONTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RemoveActionType2CodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4e3b\u5b9e\u4f53\u6570\u636e\u5220\u9664\u65f6\u4ece\u5b9e\u4f53\u7684\u64cd\u4f5c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0be02327ff3bd990d5e96fd638c57030");
        pSDEFGroupDetailModel.setName("REMOVEORDER");
        iPSDEFieldModel = this.getDEField("REMOVEORDER", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4ece\u5b9e\u4f53\u5728\u8fdb\u884c\u6570\u636e\u5173\u8054\u5220\u9664\u65f6\u7684\u6b21\u5e8f\uff0c\u6309\u5347\u5e8f\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0b81001e0e91008aebf2e3ee0e432452");
        pSDEFGroupDetailModel.setName("REMOVEREJECTMSG");
        iPSDEFieldModel = this.getDEField("REMOVEREJECTMSG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u9650\u5236\u4e3b\u5b9e\u4f53\u8fdb\u884c\u6570\u636e\u65f6\u7684\u63d0\u793a\u4fe1\u606f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("31ae00289e7ac9aa385d3575775b2fd3");
        pSDEFGroupDetailModel.setName("REMOVEREJECTPSLANRESID");
        iPSDEFieldModel = this.getDEField("REMOVEREJECTPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("447c27174d1965e903b70f2c96c0933c");
        pSDEFGroupDetailModel.setName("REMOVEREJECTPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("REMOVEREJECTPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("00e5d77170b0e9a6e4bad7ed1341a0ce");
        pSDEFGroupDetailModel.setName("SDPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("SDPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u5355\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u684c\u9762\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7fe0b66c383d90f7755bf3dcd0ffcf63");
        pSDEFGroupDetailModel.setName("SDPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("SDPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u5355\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u684c\u9762\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0df0912abbf68fb1d9406534af0a2563");
        pSDEFGroupDetailModel.setName("TEMPORDERVALUE");
        iPSDEFieldModel = this.getDEField("TEMPORDERVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7684\u4e34\u65f6\u6570\u636e\u5904\u7406\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DER1N() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DER1N");
        pSDEFGroupModel.setName("1:N\u5173\u7cfb");
        pSDEFGroupModel.setUserTag("DER1N");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0e224f9d4a743ca265fcc0ec6bcbd569");
        pSDEFGroupDetailModel.setName("CLONEORDERVALUE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CLONEORDERVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7684\u514b\u9686\u5173\u7cfb\u7684\u7ea7\u522b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("19a864d83b83cff87d37c4c7defc2c0f");
        pSDEFGroupDetailModel.setName("DERFIELDLNAME");
        iPSDEFieldModel = this.getDEField("DERFIELDLNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a1:N\u5173\u7cfb\u8fde\u63a5\u5c5e\u6027\u7684\u903b\u8f91\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d9581418b44a0b48708d32a0621957e8");
        pSDEFGroupDetailModel.setName("DERFIELDNAME");
        iPSDEFieldModel = this.getDEField("DERFIELDNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a1:N\u5173\u7cfb\u8fde\u63a5\u5c5e\u6027\u7684\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4b4188e934bbefda719b5a4a4510a964");
        pSDEFGroupDetailModel.setName("EXTMAJORPSDEFID");
        iPSDEFieldModel = this.getDEField("EXTMAJORPSDEFID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u542f\u7528\u5f15\u7528\u5b9e\u4f53\u7684\u9644\u52a0\u7ea6\u675f\u65f6\u7684\u4e3b\u5b9e\u4f53\u5c5e\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8c978ab50c570aba28520b4a36390838");
        pSDEFGroupDetailModel.setName("EXTMAJORPSDEFNAME");
        iPSDEFieldModel = this.getDEField("EXTMAJORPSDEFNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u542f\u7528\u5f15\u7528\u5b9e\u4f53\u7684\u9644\u52a0\u7ea6\u675f\u65f6\u7684\u4e3b\u5b9e\u4f53\u5c5e\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("48eb1c1d2c6e9ff4c248e7fa3ab29912");
        pSDEFGroupDetailModel.setName("EXTMINORPSDEFID");
        iPSDEFieldModel = this.getDEField("EXTMINORPSDEFID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u542f\u7528\u5f15\u7528\u5b9e\u4f53\u7684\u9644\u52a0\u7ea6\u675f\u65f6\u7684\u4ece\u5b9e\u4f53\u5c5e\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b128334a9f8638dbf59de1bf2a133de1");
        pSDEFGroupDetailModel.setName("EXTMINORPSDEFNAME");
        iPSDEFieldModel = this.getDEField("EXTMINORPSDEFNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u542f\u7528\u5f15\u7528\u5b9e\u4f53\u7684\u9644\u52a0\u7ea6\u675f\u65f6\u7684\u4ece\u5b9e\u4f53\u5c5e\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4f5b93dd702b4810562465b4a4ca4143");
        pSDEFGroupDetailModel.setName("ENADEFIELDWRITEBACK");
        iPSDEFieldModel = this.getDEField("ENADEFIELDWRITEBACK", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEFWriteBackModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u7684\u94fe\u63a5\u5c5e\u6027\u540c\u6b65\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a99fe8d12b0b30320912ad9f427e16b4");
        pSDEFGroupDetailModel.setName("ENAEXTRANGE");
        iPSDEFieldModel = this.getDEField("ENAEXTRANGE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u5bf9\u5f15\u7528\u5b9e\u4f53\u7684\u9644\u52a0\u7ea6\u675f\uff0c\u5982\u542f\u7528\u9700\u540c\u65f6\u6307\u5b9a\u7b49\u4ef7\u7ea6\u675f\u7684\u4e3b\u5b9e\u4f53\u5c5e\u6027\u53ca\u4ece\u5b9e\u4f53\u5c5e\u6027\uff0c\u9ed8\u8ba4\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7608ed614b7c1a763c14f5acde0d6415");
        pSDEFGroupDetailModel.setName("ENAPDEREQ");
        iPSDEFieldModel = this.getDEField("ENAPDEREQ", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u8981\u6c42\u4e3b\u5b9e\u4f53\u53ca\u4ece\u5b9e\u4f53\u90fd\u5b58\u5728\u5bf9\u540c\u4e00\u4e2a\u7b2c\u4e09\u65b9\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb\uff0c\u5982\u542f\u7528\u9700\u540c\u65f6\u6307\u5b9a\u4e3b\u5b9e\u4f53\u53ca\u4ece\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb\uff0c\u9ed8\u8ba4\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("87ef6d7726660fd53c8ef0d27e3ae618");
        pSDEFGroupDetailModel.setName("EXPORTMAJORMODEL");
        iPSDEFieldModel = this.getDEField("EXPORTMAJORMODEL", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DERExportMajorModelCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8e64c9a7a1e16c9ec1666c6e83ca440f");
        pSDEFGroupDetailModel.setName("EXPORTMODEL");
        iPSDEFieldModel = this.getDEField("EXPORTMODEL", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("610c0bb31c39c0e51f1a6294ee0f46c2");
        pSDEFGroupDetailModel.setName("EXPORTSCOPE");
        iPSDEFieldModel = this.getDEField("EXPORTSCOPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6a42e10c33328d1c72de3f971a434e03");
        pSDEFGroupDetailModel.setName("EXPORTSCOPE2");
        iPSDEFieldModel = this.getDEField("EXPORTSCOPE2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("167e11ef70e671e27268644a19729ac0");
        pSDEFGroupDetailModel.setName("FKEYNAME");
        iPSDEFieldModel = this.getDEField("FKEYNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u53d1\u5e03\u6570\u636e\u5e93\u5916\u952e\u65f6\u4f7f\u7528\u7684\u540d\u79f0\uff0c\u4e0d\u6307\u5b9a\u65f6\u7531\u5f15\u64ce\u81ea\u52a8\u8ba1\u7b97");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0f22ccfebe52db05ef657c353027b4a9");
        pSDEFGroupDetailModel.setName("FOREIGNKEY");
        iPSDEFieldModel = this.getDEField("FOREIGNKEY", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a1:N\u5173\u7cfb\u662f\u5426\u53d1\u5e03\u5bf9\u5e94\u6570\u636e\u5e93\u5916\u952e\u7ea6\u675f\uff0c\u9ed8\u8ba4\u4e3a\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8aca65e398d1bd1c7b4bf4b2819b70b3");
        pSDEFGroupDetailModel.setName("LINKPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("LINKPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u94fe\u63a5\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u7f51\u9875\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("606a8590e087541c3bf8d7b0d9f35b1a");
        pSDEFGroupDetailModel.setName("LINKPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("LINKPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u94fe\u63a5\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u7f51\u9875\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a5b75059bbe74de254457c8f83c4bcae");
        pSDEFGroupDetailModel.setName("LOCKFLAG");
        iPSDEFieldModel = this.getDEField("LOCKFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("88ad64a210cfa9e5d34829e19fd5bc9c");
        pSDEFGroupDetailModel.setName("LOGICNAME");
        iPSDEFieldModel = this.getDEField("LOGICNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7684\u4e2d\u6587\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("396c9610e6475b6ae04d787edecfc2c6");
        pSDEFGroupDetailModel.setName("MDPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("MDPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u591a\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u684c\u9762\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("69052c36fc6aad75b97f194530f47204");
        pSDEFGroupDetailModel.setName("MDPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("MDPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u591a\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u684c\u9762\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("949201e2be724df0354b9f9a8dd1955a");
        pSDEFGroupDetailModel.setName("MAJORPSDERID");
        iPSDEFieldModel = this.getDEField("MAJORPSDERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5728\u542f\u7528\u7236\u5173\u7cfb\u7b49\u4ef7\u65f6\u6307\u5b9a\u4e3b\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1ebcd0fd7625b0d92852f08389bcd740");
        pSDEFGroupDetailModel.setName("MAJORPSDERNAME");
        iPSDEFieldModel = this.getDEField("MAJORPSDERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5728\u542f\u7528\u7236\u5173\u7cfb\u7b49\u4ef7\u65f6\u6307\u5b9a\u4e3b\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7cb29d24e7d6dd5da2bfda1e1786a437");
        pSDEFGroupDetailModel.setName("MASTERORDERVALUE");
        iPSDEFieldModel = this.getDEField("MASTERORDERVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a1:N\u5173\u7cfb\u4e3b\u63a7\u6a21\u5f0f\u7684\u7ea7\u522b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1dfa8aea50c0df4a585dfd4280270825");
        pSDEFGroupDetailModel.setName("MASTERRS");
        iPSDEFieldModel = this.getDEField("MASTERRS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NMasterRSCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u989d\u5916\u6307\u5b9a\u4e3b\u4ece\u5173\u7cfb\u7684\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("62218b7ad932ec94f6db3357879bec30");
        pSDEFGroupDetailModel.setName("MINORCODENAME");
        iPSDEFieldModel = this.getDEField("MINORCODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f9843cdf9833be83d15cb4a0359cfc17");
        pSDEFGroupDetailModel.setName("MINORLOGICNAME");
        iPSDEFieldModel = this.getDEField("MINORLOGICNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5b357b7d8d03af6ef34a488f62559c5b");
        pSDEFGroupDetailModel.setName("MINORPSDEDSID");
        iPSDEFieldModel = this.getDEField("MINORPSDEDSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("93d9d4c3f8e447e82bc8b603d2a0b700");
        pSDEFGroupDetailModel.setName("MINORPSDEDSNAME");
        iPSDEFieldModel = this.getDEField("MINORPSDEDSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c07e90e27ae1ddc2496b7db3c3a7a5bf");
        pSDEFGroupDetailModel.setName("MINORPSDERID");
        iPSDEFieldModel = this.getDEField("MINORPSDERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5728\u542f\u7528\u7236\u5173\u7cfb\u7b49\u4ef7\u65f6\u6307\u5b9a\u4ece\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("79d8ec6390fbbb95c027084f6437649c");
        pSDEFGroupDetailModel.setName("MINORPSDERNAME");
        iPSDEFieldModel = this.getDEField("MINORPSDERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5728\u542f\u7528\u7236\u5173\u7cfb\u7b49\u4ef7\u65f6\u6307\u5b9a\u4ece\u5b9e\u4f53\u7684\u5f15\u7528\u5173\u7cfb");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8e55a752d07f882e7517c484eee87519");
        pSDEFGroupDetailModel.setName("MINORSERVICECODENAME");
        iPSDEFieldModel = this.getDEField("MINORSERVICECODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("28a69bb256dbedba6f9089b8911712b3");
        pSDEFGroupDetailModel.setName("MOBLINKPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("MOBLINKPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u94fe\u63a5\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u79fb\u52a8\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0a2f92d60e7361101370d411cf3a7f34");
        pSDEFGroupDetailModel.setName("MOBLINKPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("MOBLINKPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u94fe\u63a5\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u79fb\u52a8\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("41b165ab241264a92e005f91c3714555");
        pSDEFGroupDetailModel.setName("MOBMDPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("MOBMDPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u591a\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u79fb\u52a8\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3a951192cd90f3149901d894bb09141c");
        pSDEFGroupDetailModel.setName("MOBMDPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("MOBMDPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u591a\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u79fb\u52a8\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3840796f8243450a820e48702dea1320");
        pSDEFGroupDetailModel.setName("MOBSDPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("MOBSDPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u5355\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u79fb\u52a8\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("04b62af302bf649d2d0b4386a2d48f1a");
        pSDEFGroupDetailModel.setName("MOBSDPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("MOBSDPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u5355\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u79fb\u52a8\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("797111fa20da5564cacd5536d71586ca");
        pSDEFGroupDetailModel.setName("PSDEACMODEID");
        iPSDEFieldModel = this.getDEField("PSDEACMODEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u81ea\u52a8\u586b\u5145\u529f\u80fd\u65f6\u9ed8\u8ba4\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9da6861f42e8ae1ecc0718063efb85ab");
        pSDEFGroupDetailModel.setName("PSDEACMODENAME");
        iPSDEFieldModel = this.getDEField("PSDEACMODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u81ea\u52a8\u586b\u5145\u529f\u80fd\u65f6\u9ed8\u8ba4\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6dd20c459d589fdb2cd53798e445047");
        pSDEFGroupDetailModel.setName("PSDEDATASETID");
        iPSDEFieldModel = this.getDEField("PSDEDATASETID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u7684\u6570\u636e\u96c6\u5408");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b5ef47981d03a18cce2e50cd0c3df7a4");
        pSDEFGroupDetailModel.setName("PSDEDATASETNAME");
        iPSDEFieldModel = this.getDEField("PSDEDATASETNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u7684\u6570\u636e\u96c6\u5408");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("38d22bb23a2ef1c4b375a31cd49320be");
        pSDEFGroupDetailModel.setName("PSSYSTEMID");
        iPSDEFieldModel = this.getDEField("PSSYSTEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d0297f62604b049712551c09a402f033");
        pSDEFGroupDetailModel.setName("RSPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("RSPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2a3c7cf084905a1b59a0c440a38b80cb");
        pSDEFGroupDetailModel.setName("RSPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("RSPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b5dea2c2a4ff8d47bc53d8be2093a2b6");
        pSDEFGroupDetailModel.setName("REMOVEACTIONTYPE");
        iPSDEFieldModel = this.getDEField("REMOVEACTIONTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RemoveActionTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4e3b\u5b9e\u4f53\u6570\u636e\u5220\u9664\u65f6\u4ece\u5b9e\u4f53\u7684\u64cd\u4f5c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0be02327ff3bd990d5e96fd638c57030");
        pSDEFGroupDetailModel.setName("REMOVEORDER");
        iPSDEFieldModel = this.getDEField("REMOVEORDER", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4ece\u5b9e\u4f53\u5728\u8fdb\u884c\u6570\u636e\u5173\u8054\u5220\u9664\u65f6\u7684\u6b21\u5e8f\uff0c\u6309\u5347\u5e8f\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0b81001e0e91008aebf2e3ee0e432452");
        pSDEFGroupDetailModel.setName("REMOVEREJECTMSG");
        iPSDEFieldModel = this.getDEField("REMOVEREJECTMSG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u9650\u5236\u4e3b\u5b9e\u4f53\u8fdb\u884c\u6570\u636e\u65f6\u7684\u63d0\u793a\u4fe1\u606f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("31ae00289e7ac9aa385d3575775b2fd3");
        pSDEFGroupDetailModel.setName("REMOVEREJECTPSLANRESID");
        iPSDEFieldModel = this.getDEField("REMOVEREJECTPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("447c27174d1965e903b70f2c96c0933c");
        pSDEFGroupDetailModel.setName("REMOVEREJECTPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("REMOVEREJECTPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("00e5d77170b0e9a6e4bad7ed1341a0ce");
        pSDEFGroupDetailModel.setName("SDPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("SDPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u5355\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u684c\u9762\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7fe0b66c383d90f7755bf3dcd0ffcf63");
        pSDEFGroupDetailModel.setName("SDPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("SDPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5f15\u7528\u6570\u636e\u5728\u754c\u9762\u4e0a\u9700\u8981\u63d0\u4f9b\u5355\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\u65f6\u9ed8\u8ba4\u4f7f\u7528\u7684\u5b9e\u4f53\u89c6\u56fe\uff08\u684c\u9762\u7aef\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c475d5ff8fe08c748f0087f9cb442a6f");
        pSDEFGroupDetailModel.setName("SERVICECODENAME");
        iPSDEFieldModel = this.getDEField("SERVICECODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("28966544b4d3db15ba9e63c60a4d5b73");
        pSDEFGroupDetailModel.setName("SYNCEXPORTMODEL");
        iPSDEFieldModel = this.getDEField("SYNCEXPORTMODEL", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NSyncActionCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0df0912abbf68fb1d9406534af0a2563");
        pSDEFGroupDetailModel.setName("TEMPORDERVALUE");
        iPSDEFieldModel = this.getDEField("TEMPORDERVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7684\u4e34\u65f6\u6570\u636e\u5904\u7406\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DERCUSTOM() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DERCUSTOM");
        pSDEFGroupModel.setName("\u81ea\u5b9a\u4e49\u5173\u7cfb");
        pSDEFGroupModel.setUserTag("DERCUSTOM");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("19a864d83b83cff87d37c4c7defc2c0f");
        pSDEFGroupDetailModel.setName("DERFIELDLNAME");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DERFIELDLNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u81ea\u5b9a\u4e49\u5173\u7cfb\u5728\u5b50\u7c7b\u578b\u4e3a\u3010\u4e00\u5bf9\u591a\u3011\u65f6\u989d\u5916\u6307\u5b9a\u7684\u4e3b\u4fe1\u606f\u5c5e\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d9581418b44a0b48708d32a0621957e8");
        pSDEFGroupDetailModel.setName("DERFIELDNAME");
        iPSDEFieldModel = this.getDEField("DERFIELDNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a1:N\u5173\u7cfb\u8fde\u63a5\u5c5e\u6027\u7684\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("adea2958d0c743610165fa6f048325de");
        pSDEFGroupDetailModel.setName("DERSUBTYPE");
        iPSDEFieldModel = this.getDEField("DERSUBTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DERSubTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u81ea\u5b9a\u4e49\u5173\u7cfb\u7684\u5b50\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("610c0bb31c39c0e51f1a6294ee0f46c2");
        pSDEFGroupDetailModel.setName("EXPORTSCOPE");
        iPSDEFieldModel = this.getDEField("EXPORTSCOPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6a42e10c33328d1c72de3f971a434e03");
        pSDEFGroupDetailModel.setName("EXPORTSCOPE2");
        iPSDEFieldModel = this.getDEField("EXPORTSCOPE2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NRemoveActionCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8f350511e28db82c9572be1065cd5f4c");
        pSDEFGroupDetailModel.setName("INDEXVALUE");
        iPSDEFieldModel = this.getDEField("INDEXVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7ee7\u627f\u6216\u7d22\u5f15\u5173\u7cfb\u7684\u7c7b\u578b\u8bc6\u522b\u503c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a5b75059bbe74de254457c8f83c4bcae");
        pSDEFGroupDetailModel.setName("LOCKFLAG");
        iPSDEFieldModel = this.getDEField("LOCKFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("88ad64a210cfa9e5d34829e19fd5bc9c");
        pSDEFGroupDetailModel.setName("LOGICNAME");
        iPSDEFieldModel = this.getDEField("LOGICNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7684\u4e2d\u6587\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1dfa8aea50c0df4a585dfd4280270825");
        pSDEFGroupDetailModel.setName("MASTERRS");
        iPSDEFieldModel = this.getDEField("MASTERRS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DER1NMasterRSCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u989d\u5916\u6307\u5b9a\u4e3b\u4ece\u5173\u7cfb\u7684\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("62218b7ad932ec94f6db3357879bec30");
        pSDEFGroupDetailModel.setName("MINORCODENAME");
        iPSDEFieldModel = this.getDEField("MINORCODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5b357b7d8d03af6ef34a488f62559c5b");
        pSDEFGroupDetailModel.setName("MINORPSDEDSID");
        iPSDEFieldModel = this.getDEField("MINORPSDEDSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("93d9d4c3f8e447e82bc8b603d2a0b700");
        pSDEFGroupDetailModel.setName("MINORPSDEDSNAME");
        iPSDEFieldModel = this.getDEField("MINORPSDEDSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8e55a752d07f882e7517c484eee87519");
        pSDEFGroupDetailModel.setName("MINORSERVICECODENAME");
        iPSDEFieldModel = this.getDEField("MINORSERVICECODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("38d22bb23a2ef1c4b375a31cd49320be");
        pSDEFGroupDetailModel.setName("PSSYSTEMID");
        iPSDEFieldModel = this.getDEField("PSSYSTEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b5dea2c2a4ff8d47bc53d8be2093a2b6");
        pSDEFGroupDetailModel.setName("REMOVEACTIONTYPE");
        iPSDEFieldModel = this.getDEField("REMOVEACTIONTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RemoveActionTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4e3b\u5b9e\u4f53\u6570\u636e\u5220\u9664\u65f6\u4ece\u5b9e\u4f53\u7684\u64cd\u4f5c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0be02327ff3bd990d5e96fd638c57030");
        pSDEFGroupDetailModel.setName("REMOVEORDER");
        iPSDEFieldModel = this.getDEField("REMOVEORDER", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4ece\u5b9e\u4f53\u5728\u8fdb\u884c\u6570\u636e\u5173\u8054\u5220\u9664\u65f6\u7684\u6b21\u5e8f\uff0c\u6309\u5347\u5e8f\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0b81001e0e91008aebf2e3ee0e432452");
        pSDEFGroupDetailModel.setName("REMOVEREJECTMSG");
        iPSDEFieldModel = this.getDEField("REMOVEREJECTMSG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u9650\u5236\u4e3b\u5b9e\u4f53\u8fdb\u884c\u6570\u636e\u65f6\u7684\u63d0\u793a\u4fe1\u606f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("31ae00289e7ac9aa385d3575775b2fd3");
        pSDEFGroupDetailModel.setName("REMOVEREJECTPSLANRESID");
        iPSDEFieldModel = this.getDEField("REMOVEREJECTPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("447c27174d1965e903b70f2c96c0933c");
        pSDEFGroupDetailModel.setName("REMOVEREJECTPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("REMOVEREJECTPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c475d5ff8fe08c748f0087f9cb442a6f");
        pSDEFGroupDetailModel.setName("SERVICECODENAME");
        iPSDEFieldModel = this.getDEField("SERVICECODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4de679d7236f36f14e1df38fbf8ef35e");
        pSDEFGroupDetailModel.setName("VALIDFLAG");
        iPSDEFieldModel = this.getDEField("VALIDFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColor3CodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DERINDEX() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DERINDEX");
        pSDEFGroupModel.setName("\u7d22\u5f15\u5173\u7cfb");
        pSDEFGroupModel.setUserTag("DERINDEX");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8f350511e28db82c9572be1065cd5f4c");
        pSDEFGroupDetailModel.setName("INDEXVALUE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("INDEXVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7ee7\u627f\u6216\u7d22\u5f15\u5173\u7cfb\u7684\u7c7b\u578b\u8bc6\u522b\u503c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a5b75059bbe74de254457c8f83c4bcae");
        pSDEFGroupDetailModel.setName("LOCKFLAG");
        iPSDEFieldModel = this.getDEField("LOCKFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("88ad64a210cfa9e5d34829e19fd5bc9c");
        pSDEFGroupDetailModel.setName("LOGICNAME");
        iPSDEFieldModel = this.getDEField("LOGICNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7684\u4e2d\u6587\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("38d22bb23a2ef1c4b375a31cd49320be");
        pSDEFGroupDetailModel.setName("PSSYSTEMID");
        iPSDEFieldModel = this.getDEField("PSSYSTEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01f0c251f54c620ba212b188286f6608");
        pSDEFGroupDetailModel.setName("PROPERTYMAP");
        iPSDEFieldModel = this.getDEField("PROPERTYMAP", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DERINHERIT() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DERINHERIT");
        pSDEFGroupModel.setName("\u7ee7\u627f\u5173\u7cfb");
        pSDEFGroupModel.setUserTag("DERINHERIT");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d5751cc8fccd623cba2829d89de107fc");
        pSDEFGroupDetailModel.setName("DEFINHERITMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DEFINHERITMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEFDERInheritModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7ee7\u627f\u5173\u7cfb\u7684\u5c5e\u6027\u7ee7\u627f\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4439b9bf05a7130259750ae557443db7");
        pSDEFGroupDetailModel.setName("IGNOREDEFIELDS");
        iPSDEFieldModel = this.getDEField("IGNOREDEFIELDS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7ee7\u627f\u5173\u7cfb\u7ee7\u627f\u5c5e\u6027\u6e05\u5355\uff0c\u4f7f\u7528\u3010\u7ee7\u627f\u5c5e\u6027\u3011=\u3010\u6e90\u5c5e\u6027\u3011\u683c\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8f350511e28db82c9572be1065cd5f4c");
        pSDEFGroupDetailModel.setName("INDEXVALUE");
        iPSDEFieldModel = this.getDEField("INDEXVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7ee7\u627f\u6216\u7d22\u5f15\u5173\u7cfb\u7684\u7c7b\u578b\u8bc6\u522b\u503c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01169d6a6be9dc0bd1cebb8324844396");
        pSDEFGroupDetailModel.setName("INHERITMODE");
        iPSDEFieldModel = this.getDEField("INHERITMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DERInheritModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7ee7\u627f\u5173\u7cfb\u7684\u7ee7\u627f\u6a21\u5f0f\uff0c\u9ed8\u8ba4\u4e3a\u3010\u5b58\u50a8\u7ee7\u627f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a5b75059bbe74de254457c8f83c4bcae");
        pSDEFGroupDetailModel.setName("LOCKFLAG");
        iPSDEFieldModel = this.getDEField("LOCKFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("88ad64a210cfa9e5d34829e19fd5bc9c");
        pSDEFGroupDetailModel.setName("LOGICNAME");
        iPSDEFieldModel = this.getDEField("LOGICNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7684\u4e2d\u6587\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("38d22bb23a2ef1c4b375a31cd49320be");
        pSDEFGroupDetailModel.setName("PSSYSTEMID");
        iPSDEFieldModel = this.getDEField("PSSYSTEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DERMULINH() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DERMULINH");
        pSDEFGroupModel.setName("\u591a\u7ee7\u627f\u5173\u7cfb\uff08\u865a\u62df\u5b9e\u4f53\uff09");
        pSDEFGroupModel.setUserTag("DERMULINH");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d5751cc8fccd623cba2829d89de107fc");
        pSDEFGroupDetailModel.setName("DEFINHERITMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DEFINHERITMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEFDERInheritModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7ee7\u627f\u5173\u7cfb\u7684\u5c5e\u6027\u7ee7\u627f\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4439b9bf05a7130259750ae557443db7");
        pSDEFGroupDetailModel.setName("IGNOREDEFIELDS");
        iPSDEFieldModel = this.getDEField("IGNOREDEFIELDS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u7ee7\u627f\u5173\u7cfb\u7ee7\u627f\u5c5e\u6027\u6e05\u5355\uff0c\u4f7f\u7528\u3010\u7ee7\u627f\u5c5e\u6027\u3011=\u3010\u6e90\u5c5e\u6027\u3011\u683c\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a5b75059bbe74de254457c8f83c4bcae");
        pSDEFGroupDetailModel.setName("LOCKFLAG");
        iPSDEFieldModel = this.getDEField("LOCKFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("88ad64a210cfa9e5d34829e19fd5bc9c");
        pSDEFGroupDetailModel.setName("LOGICNAME");
        iPSDEFieldModel = this.getDEField("LOGICNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7684\u4e2d\u6587\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("38d22bb23a2ef1c4b375a31cd49320be");
        pSDEFGroupDetailModel.setName("PSSYSTEMID");
        iPSDEFieldModel = this.getDEField("PSSYSTEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel__DEFAULT() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("_DEFAULT");
        pSDEFGroupModel.setName("\u901a\u7528");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9b02e42f7aab7da636543794d13690b4");
        pSDEFGroupDetailModel.setName("CODENAME");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u8981\u5728\u5173\u7cfb\u7684\u4ece\u5b9e\u4f53\u4e2d\u5177\u6709\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3678512f2ae869d2dd9874c0a44ef94c");
        pSDEFGroupDetailModel.setName("DERTYPE");
        iPSDEFieldModel = this.getDEField("DERTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DERTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u7684\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("62eba04dff0d4ad90a26978f4dfc64fa");
        pSDEFGroupDetailModel.setName("MAJORPSDEID");
        iPSDEFieldModel = this.getDEField("MAJORPSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u7684\u4e3b\u5b9e\u4f53");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("70d8f1ddb298aba01b1507ea1cf36190");
        pSDEFGroupDetailModel.setName("MAJORPSDENAME");
        iPSDEFieldModel = this.getDEField("MAJORPSDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u7684\u4e3b\u5b9e\u4f53");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e684734a9ade36eacae86fb286482fa2");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("187e4a12852be4cb121adf6f4b96ff1f");
        pSDEFGroupDetailModel.setName("MINORPSDEID");
        iPSDEFieldModel = this.getDEField("MINORPSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u7684\u4ece\u5b9e\u4f53\uff0c\u9664\u4e86\u30101:N\u5173\u7cfb\u3011\u7c7b\u578b\u5916\uff0c\u5176\u5b83\u7c7b\u578b\u5173\u7cfb\u4ece\u5b9e\u4f53\u4e0d\u80fd\u4e0e\u4e3b\u5b9e\u4f53\u4e00\u81f4");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f5fdaacac00f8381b9378081457267eb");
        pSDEFGroupDetailModel.setName("MINORPSDENAME");
        iPSDEFieldModel = this.getDEField("MINORPSDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u7684\u4ece\u5b9e\u4f53\uff0c\u9664\u4e86\u30101:N\u5173\u7cfb\u3011\u7c7b\u578b\u5916\uff0c\u5176\u5b83\u7c7b\u578b\u5173\u7cfb\u4ece\u5b9e\u4f53\u4e0d\u80fd\u4e0e\u4e3b\u5b9e\u4f53\u4e00\u81f4");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("55b369aeac828ecc8a640e1e6e7fbad3");
        pSDEFGroupDetailModel.setName("ORDERVALUE");
        iPSDEFieldModel = this.getDEField("ORDERVALUE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("593e8a672c0d720c61c3defce2ab8c2b");
        pSDEFGroupDetailModel.setName("PSDERNAME");
        iPSDEFieldModel = this.getDEField("PSDERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7684\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("aa69ef8fe801c9c7a2d2e225b23d77f3");
        pSDEFGroupDetailModel.setName("PSSYSDYNAMODELID");
        iPSDEFieldModel = this.getDEField("PSSYSDYNAMODELID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01a868ad56d939f95c5b79c3218be9d8");
        pSDEFGroupDetailModel.setName("PSSYSDYNAMODELNAME");
        iPSDEFieldModel = this.getDEField("PSSYSDYNAMODELNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f202b19f884e01953d267b5471b2d32a");
        pSDEFGroupDetailModel.setName("USERCAT");
        iPSDEFieldModel = this.getDEField("USERCAT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelUserCatCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d38612b4f26b57934344687307fa1035");
        pSDEFGroupDetailModel.setName("USERPARAMS");
        iPSDEFieldModel = this.getDEField("USERPARAMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ce23400dc90a174c3e95bb0be8c5812b");
        pSDEFGroupDetailModel.setName("USERTAG");
        iPSDEFieldModel = this.getDEField("USERTAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6b022c122d8622b0042cf927e2321b4e");
        pSDEFGroupDetailModel.setName("USERTAG2");
        iPSDEFieldModel = this.getDEField("USERTAG2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b29b454f27af8d51aaaf9a210e677b45");
        pSDEFGroupDetailModel.setName("USERTAG3");
        iPSDEFieldModel = this.getDEField("USERTAG3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4f26dc64e53b59eaa01efddfd5d4b2c3");
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

