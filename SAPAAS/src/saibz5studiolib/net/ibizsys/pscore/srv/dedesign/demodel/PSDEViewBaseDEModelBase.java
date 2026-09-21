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
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.ac.PSDEViewBaseDefaultACModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseByTypeDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseCurAppAddDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseCurAppDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseCurAppNotAddDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseCurDE2DQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseCurDEDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseCurDEMobDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseCurDEWebDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseCurSysDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseCurWF2DQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseCurWFVerDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseDEPDTDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseDefaultDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseMobDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBasePDTCnt2DQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBasePDTCntDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseWFDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataquery.PSDEViewBaseWebDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseByTypeDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseCurAppAddDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseCurAppDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseCurAppNotAddDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseCurDE2DSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseCurDEDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseCurDEMobDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseCurDEWebDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseCurSysDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseCurWF2DSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseCurWFVerDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseDEPDTDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseDefaultDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseFormTypeDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseMobDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseWFDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.dataset.PSDEViewBaseWebDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.logic.PSDEViewBaseNode2DELogicModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.logic.PSDEViewBaseNode2WFLogicModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.logic.PSDEViewBaseNode2WFVerLogicModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.uiaction.PSDEViewBaseJITPreviewUIActionModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;

public abstract class PSDEViewBaseDEModelBase
extends PSDataEntityModelBase<PSDEViewBase> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDEViewBaseService pSDEViewBaseService;

    public PSDEViewBaseDEModelBase() throws Exception {
        this.setId("e486241a0b2b4aef5a2742f6ae54204b");
        this.setName("PSDEVIEWBASE");
        this.setCodeName("PSDEViewBase");
        this.setTableName("T_SRFPSDEVIEWBASE");
        this.setViewName("v_PSDEVIEWBASE");
        this.setLogicName("\u5b9e\u4f53\u89c6\u56fe");
        this.setMemo("\u5b9e\u4f53\u89c6\u56fe\u662f\u5b9e\u4f53\u7684\u754c\u9762\u89c6\u56fe\u6a21\u578b\uff0c\u5305\u62ec\u4e86\u89c6\u56fe\u90e8\u4ef6\u3001\u89c6\u56fe\u903b\u8f91\u7b49\u6a21\u578b\uff0c\u5b9e\u4f53\u89c6\u56fe\u901a\u8fc7\u89c6\u56fe\u7c7b\u578b\u4f7f\u7528\u9ed8\u8ba4\u5e03\u5c40\u6a21\u677f\uff0c\u4e5f\u53ef\u4ee5\u6307\u5b9a\u89c6\u56fe\u5e03\u5c40\u9762\u677f\u5b9e\u73b0\u81ea\u5b9a\u4e49\u5e03\u5c40\u3002\u5b9e\u4f53\u89c6\u56fe\u65e2\u53ef\u4ee5\u72ec\u7acb\u4f7f\u7528\uff0c\u4e5f\u53ef\u4ee5\u4f5c\u4e3a\u90e8\u4ef6\u89c6\u56fe\u88ab\u5f15\u7528\u3002\u5b9e\u4f53\u89c6\u56fe\u52a0\u5165\u5230\u5e94\u7528\u5f62\u6210\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe\uff0c\u4e00\u4e2a\u5b9e\u4f53\u89c6\u56fe\u53ef\u4ee5\u52a0\u5165\u5230\u591a\u4e2a\u5e94\u7528\u4e2d\u3002");
        this.setDSLink("DEFAULT");
        this.setEnableMultiDS(true);
        this.setEnableMultiForm(true);
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setEnableTempData(true);
        this.setUserTag("MODELV2");
        this.setUserTag2("CENTRALMODEL");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewBaseDEModel", (IDataEntityModel)this);
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

    public PSDEViewBaseService getRealService() {
        if (this.pSDEViewBaseService == null) {
            try {
                this.pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewBaseService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService";
    }

    public PSDEViewBase createEntity() {
        return new PSDEViewBase();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("ACCUSERMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("27682ba0fe2a141fa00fb4ec949aa789");
            pSDEFieldModel.setName("ACCUSERMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8bbf\u95ee\u7528\u6237\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ViewAccessUsersCodeListModel");
            pSDEFieldModel.setCodeName("AccUserMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6388\u6743\u8bbf\u95ee\u8be5\u89c6\u56fe\u7684\u7528\u6237\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u767b\u5f55\u7528\u6237\u3011");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ACCUSERMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ACCUSERMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("BOTTOMINFO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e31fe74b1c7c32dd9172d03b56f71d28");
            pSDEFieldModel.setName("BOTTOMINFO");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5c3e\u90e8\u63d0\u793a\u4fe1\u606f");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("BottomInfo");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CAPPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("15e3e27db3753ca0f5a29ec7c33f8543");
            pSDEFieldModel.setName("CAPPSLANRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSLANGUAGERES_CAPPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESID");
            pSDEFieldModel.setCodeName("CapPSLanResId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CAPPSLANRESID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CAPPSLANRESID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CAPPSLANRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("58f9c01b5df4ee0dce170a5ffe53a5e8");
            pSDEFieldModel.setName("CAPPSLANRESNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSLANGUAGERES_CAPPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESNAME");
            pSDEFieldModel.setCodeName("CapPSLanResName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CAPPSLANRESNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CAPPSLANRESNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CAPPSLANRESNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CAPPSLANRESNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CAPTION");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("46bbf178060ad1c78336e3ce458fba23");
            pSDEFieldModel.setName("CAPTION");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6807\u9898");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Caption");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5b9e\u4f53\u7684\u6807\u9898");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ecd95d4a30798980b3b6876cd93b0d58");
            pSDEFieldModel.setName("CODENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CodeName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u8981\u5728\u6240\u5728\u7684\u5b9e\u4f53\u4e2d\u5177\u6709\u552f\u4e00\u6027");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210");
            pSDEFieldModel.setLength(40);
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
            pSDEFieldModel.setId("543394fb883ce9d14dc37db7f80414e1");
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
            pSDEFieldModel.setId("37f97f0858f03b84a58ec819453df6f2");
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
        object = this.createDEField("DEVIEWTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e18414e54dba19629013adc7cf2f28b5");
            pSDEFieldModel.setName("DEVIEWTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DEViewTag");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(40);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEVIEWTAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ee505f49a24ffb69a68ddfa1249e0874");
            pSDEFieldModel.setName("DEVIEWTAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u56fa\u5b9a\u5e94\u7528\u89c6\u56fe\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DEViewTag2");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEVIEWTAG3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fb569435bb187c17eb7b046531f42412");
            pSDEFieldModel.setName("DEVIEWTAG3");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6807\u8bb03");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DEViewTag3");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEVIEWTAG4");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b442bdda7f1d87490f2fa4cfe88b2c5d");
            pSDEFieldModel.setName("DEVIEWTAG4");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6807\u8bb04");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DEViewTag4");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DYNAMODELFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c05d7254c4cb87df939fcc560562cf28");
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
        object = this.createDEField("DYNCMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("51409c0e9dfe03118f7070aaad1cd3a3");
            pSDEFieldModel.setName("DYNCMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u4f18\u5148\u7ea7");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
            pSDEFieldModel.setCodeName("DyncMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLEVIEWACTIONS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("666a948ebf493fdffea2c5806195bb4a");
            pSDEFieldModel.setName("ENABLEVIEWACTIONS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u89c6\u56fe\u64cd\u4f5c\u63a7\u5236");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableViewActions");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u89c6\u56fe\u64cd\u4f5c\u63a7\u5236\uff0c\u542f\u7528\u89c6\u56fe\u64cd\u4f5c\u63a7\u5236\u9700\u8981\u663e\u793a\u6307\u5b9a\u89c6\u56fe\u652f\u6301\u54ea\u4e9b\u64cd\u4f5c\u3002\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("GROUPPSCODELISTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
            pSDEFieldModel.setName("GROUPPSCODELISTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSCODELIST_GROUPPSCODELISTID");
            pSDEFieldModel.setLinkDEFName("PSCODELISTID");
            pSDEFieldModel.setCodeName("GroupPSCodeListId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_GROUPPSCODELISTID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_GROUPPSCODELISTID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("GROUPPSCODELISTNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ed4472d907aa35708e89f7b1718a65dc");
            pSDEFieldModel.setName("GROUPPSCODELISTNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSCODELIST_GROUPPSCODELISTID");
            pSDEFieldModel.setLinkDEFName("PSCODELISTNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("GroupPSCodeListName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_GROUPPSCODELISTNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_GROUPPSCODELISTNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_GROUPPSCODELISTNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_GROUPPSCODELISTNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HEADERINFO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5213884796ccd0d7766c2bcacc9c602e");
            pSDEFieldModel.setName("HEADERINFO");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5934\u90e8\u63d0\u793a\u4fe1\u606f");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("HeaderInfo");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HEIGHT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2ac49818ec53fb0f5525875bf3e40176");
            pSDEFieldModel.setName("HEIGHT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ad8\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Height");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u9ad8\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u30100\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LAYOUTPANELMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("12fb18bee5a18cf187ef3097cc94c87e");
            pSDEFieldModel.setName("LAYOUTPANELMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e03\u5c40\u9762\u677f\u5e94\u7528\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ViewLayoutPanelModeCodeListModel");
            pSDEFieldModel.setCodeName("LayoutPanelMode");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LAYOUTPANELMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LAYOUTPANELMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LOADDEFAULT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("eaaa7e24b62ecde7807e508c56a03094");
            pSDEFieldModel.setName("LOADDEFAULT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u52a0\u8f7d\u6570\u636e");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("LoadDefault");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LOCKFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b6f095db6460d0229ebe734316ce81be");
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
        object = this.createDEField("MEMO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1b2d9ab97b6223dae919780a7fd9dc83");
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
        object = this.createDEField("MODELSTATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e7d2105fda57f2272d94c28f4f1e81a5");
            pSDEFieldModel.setName("MODELSTATE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6a21\u578b\u72b6\u6001");
            pSDEFieldModel.setDataType("NMCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEViewStateCodeListModel");
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("ModelState");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OPENMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5be49cf8e54782fe945de8797a42d05c");
            pSDEFieldModel.setName("OPENMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u6253\u5f00\u65b9\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEViewOpenModeCodeListModel");
            pSDEFieldModel.setCodeName("OpenMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u6253\u5f00\u65b9\u5f0f");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OPENMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OPENMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PDTPARAMPRE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("652a33f253e6cd690846e570dd484df6");
            pSDEFieldModel.setName("PDTPARAMPRE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9644\u52a0\u529f\u80fd\u53c2\u6570\u524d\u7f00");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PDTParamPre");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.setLength(20);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PDVTPARAM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cd445eea935835d9b0a9994bbb148177");
            pSDEFieldModel.setName("PDVTPARAM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u529f\u80fd\u89c6\u56fe\u53c2\u6570");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PDVTParam");
            pSDEFieldModel.setMemo("\u5f53\u89c6\u56fe\u8bbe\u7f6e\u529f\u80fd\u89c6\u56fe\u6a21\u5f0f\u540e\u53ef\u8fdb\u4e00\u6b65\u6307\u5b9a\u76f8\u5e94\u7684\u529f\u80fd\u6a21\u5f0f\u53c2\u6570");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREDEFINEVIEWTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a84e03b061f75a056e5b2b0d43d4c642");
            pSDEFieldModel.setName("PREDEFINEVIEWTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u529f\u80fd\u89c6\u56fe\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PredefinedViewTypeCodeListModel");
            pSDEFieldModel.setCodeName("PredefinedViewType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u5728\u6240\u5728\u5b9e\u4f53\u7684\u529f\u80fd\u6a21\u5f0f\uff0c\u529f\u80fd\u6a21\u5f0f\u652f\u6301\u9644\u52a0\u53c2\u6570\u3002\u5728\u67d0\u4e9b\u573a\u666f\u4e0b\uff0c\u6a21\u578b\u5f15\u64ce\u4f1a\u6309\u7167\u6307\u5b9a\u529f\u80fd\u6a21\u5f0f\u5c1d\u8bd5\u83b7\u53d6\u89c6\u56fe\u3002\u529f\u80fd\u6a21\u5f0f+\u6a21\u5f0f\u53c2\u6570 \u9700\u8981\u5728\u6240\u5728\u5b9e\u4f53\u5177\u5907\u552f\u4e00\u6027");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PREDEFINEVIEWTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PREDEFINEVIEWTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSACHANDLERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("db86865951120fe0592aa6c581fc7184");
            pSDEFieldModel.setName("PSACHANDLERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5904\u7406\u5bf9\u8c61");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSACHANDLER_PSACHANDLERID");
            pSDEFieldModel.setLinkDEFName("PSACHANDLERID");
            pSDEFieldModel.setCodeName("PSACHandlerId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSACHANDLERID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSACHANDLERID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSACHANDLERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9e5870b51a142eb03f68c669d5235d5d");
            pSDEFieldModel.setName("PSACHANDLERNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5904\u7406\u5bf9\u8c61");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSACHANDLER_PSACHANDLERID");
            pSDEFieldModel.setLinkDEFName("PSACHANDLERNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSACHandlerName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u7684\u5904\u7406\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSACHANDLERNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSACHANDLERNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSACHANDLERNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSACHANDLERNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPVIEWCNT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("897979c3c8dbea93abd3c84e27145f7f");
            pSDEFieldModel.setName("PSAPPVIEWCNT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e94\u7528\u5f15\u7528\u6b21\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PSAppViewCnt");
            pSDEFieldModel.setEnableTempData(false);
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSAPPVIEWSCNT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("429a9a8b2114e5c7d8d675f66c7fbfbb");
            pSDEFieldModel.setName("PSAPPVIEWSCNT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e91\u5e94\u7528\u89c6\u56fe\u8ba1\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSAppViewsCnt");
            pSDEFieldModel.setEnableTempData(false);
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSCTRLLOGICGROUPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("858f1976a69f95fe75f5600f90e67d57");
            pSDEFieldModel.setName("PSCTRLLOGICGROUPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u754c\u9762\u903b\u8f91\u7ec4");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID");
            pSDEFieldModel.setLinkDEFName("PSCTRLLOGICGROUPID");
            pSDEFieldModel.setCodeName("PSCtrlLogicGroupId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSCTRLLOGICGROUPID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSCTRLLOGICGROUPID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSCTRLLOGICGROUPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8b3aa3346aad00b3d029a5ce0aab87b7");
            pSDEFieldModel.setName("PSCTRLLOGICGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u754c\u9762\u903b\u8f91\u7ec4");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID");
            pSDEFieldModel.setLinkDEFName("PSCTRLLOGICGROUPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSCtrlLogicGroupName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSCTRLLOGICGROUPNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSCTRLLOGICGROUPNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSCTRLLOGICGROUPNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSCTRLLOGICGROUPNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEAWGROUPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c498473710b741e74d33857b4cfce372");
            pSDEFieldModel.setName("PSDEAWGROUPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7ec4");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSDEAWGROUP_PSDEAWGROUPID");
            pSDEFieldModel.setLinkDEFName("PSDEAWGROUPID");
            pSDEFieldModel.setCodeName("PSDEAWGroupId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEAWGROUPID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEAWGROUPID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEAWGROUPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("addfdb3b8f4df731784d0b7999c68d2c");
            pSDEFieldModel.setName("PSDEAWGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7ec4");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSDEAWGROUP_PSDEAWGROUPID");
            pSDEFieldModel.setLinkDEFName("PSDEAWGROUPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEAWGroupName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEAWGROUPNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEAWGROUPNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEAWGROUPNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEAWGROUPNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("feebb339ef77a80ec858de6061271e24");
            pSDEFieldModel.setName("PSDEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSDATAENTITY_PSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYID");
            pSDEFieldModel.setCodeName("PSDEId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEMAINSTATEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("128610243a04a0ef32feaa0baaee4798");
            pSDEFieldModel.setName("PSDEMAINSTATEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u4e3b\u72b6\u6001");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSDEMAINSTATE_PSDEMAINSTATEID");
            pSDEFieldModel.setLinkDEFName("PSDEMAINSTATEID");
            pSDEFieldModel.setCodeName("PSDEMainStateId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEMAINSTATEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEMAINSTATEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEMAINSTATENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("618fca06260a99f2c364f19dc194b943");
            pSDEFieldModel.setName("PSDEMAINSTATENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u4e3b\u72b6\u6001");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSDEMAINSTATE_PSDEMAINSTATEID");
            pSDEFieldModel.setLinkDEFName("PSDEMAINSTATENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEMainStateName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u5173\u8054\u7684\u4e3b\u72b6\u6001\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEMAINSTATENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEMAINSTATENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEMAINSTATENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEMAINSTATENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9906caf7f403ac6b2a6c277a5464a0a4");
            pSDEFieldModel.setName("PSDENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSDATAENTITY_PSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYNAME");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDEName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u6240\u5728\u7684\u5b9e\u4f53\u5bf9\u8c61");
            pSDEFieldModel.setLength(60);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("74102fa0875d6ba3484494fc33de8085");
            pSDEFieldModel.setName("PSDERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63a7\u5236\u5173\u7cfb");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSDER_PSDERID");
            pSDEFieldModel.setLinkDEFName("PSDERID");
            pSDEFieldModel.setCodeName("PSDERId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(60);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDERID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDERID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3184d5badc636b79abb92e31a64317ad");
            pSDEFieldModel.setName("PSDERNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63a7\u5236\u5173\u7cfb");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSDER_PSDERID");
            pSDEFieldModel.setLinkDEFName("PSDERNAME");
            pSDEFieldModel.setCodeName("PSDERName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u63a7\u5236\u5173\u7cfb\u5bf9\u8c61\uff0c\u5982\u6307\u5b9a\u63a7\u5236\u5173\u7cfb\uff0c\u5219\u8981\u6c42\u89c6\u56fe\u53ea\u80fd\u5728\u5b58\u5728\u6b64\u5173\u7cfb\u7684\u573a\u5408\u4f7f\u7528\uff0c\u7b80\u5355\u7684\u8bf4\u5c31\u662f\u663e\u793a\u7279\u5b9a\u7236\u7684\u5173\u7cfb\u6570\u636e");
            pSDEFieldModel.setLength(199);
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
        object = this.createDEField("PSDEVIEWBASEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c9cdb851a1b7932c203b3f0542c445df");
            pSDEFieldModel.setName("PSDEVIEWBASEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u89c6\u56fe\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDEViewBaseId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVIEWBASENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c693edc255cb68204bd9d9a2133d22c3");
            pSDEFieldModel.setName("PSDEVIEWBASENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u89c6\u56fe\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSDEViewBaseName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u7684\u540d\u79f0");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVIEWBASENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVIEWBASENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVIEWBASENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVIEWBASENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEVIEWBASETYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("15f22656aa6dc79c5f9c4bb9241a99c4");
            pSDEFieldModel.setName("PSDEVIEWBASETYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMultiFormDEField(true);
            pSDEFieldModel.setIndexTypeDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEViewType2CodeListModel");
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDEViewBaseType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u7684\u7c7b\u578b");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEVIEWBASETYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEVIEWBASETYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDYNADEVIEWTEMPLID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1ae02ac0b595781824d38a1c44196e37");
            pSDEFieldModel.setName("PSDYNADEVIEWTEMPLID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u5b9e\u4f53\u89c6\u56fe\u6a21\u677f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSDYNADEVIEWTEMPL_PSDYNADEVIEWTEMPLID");
            pSDEFieldModel.setLinkDEFName("PSDYNADEVIEWTEMPLID");
            pSDEFieldModel.setCodeName("PSDynaDEViewTemplId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDYNADEVIEWTEMPLID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDYNADEVIEWTEMPLID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDYNADEVIEWTEMPLNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e0f75a88fa336239e2d12806531773b6");
            pSDEFieldModel.setName("PSDYNADEVIEWTEMPLNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u5b9e\u4f53\u89c6\u56fe\u6a21\u677f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSDYNADEVIEWTEMPL_PSDYNADEVIEWTEMPLID");
            pSDEFieldModel.setLinkDEFName("PSDYNADEVIEWTEMPLNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDynaDEViewTemplName");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u4f7f\u7528\u7684\u52a8\u6001\u5b9e\u4f53\u89c6\u56fe\u6a21\u677f");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDYNADEVIEWTEMPLNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDYNADEVIEWTEMPLNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDYNADEVIEWTEMPLNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDYNADEVIEWTEMPLNAME_LIKE");
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
            pSDEFieldModel.setId("e499263148aa45588f4bdbaa46b1b8cb");
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
        object = this.createDEField("PSHELPMODULEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b1e6fb333f35be78fdc0004724a07e49");
            pSDEFieldModel.setName("PSHELPMODULEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5e2e\u52a9");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSHELPMODULE_PSHELPMODULEID");
            pSDEFieldModel.setLinkDEFName("PSHELPMODULEID");
            pSDEFieldModel.setCodeName("PSHelpModuleId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSHELPMODULEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSHELPMODULEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSHELPMODULENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("15f44628342cb9a2e4ef302e7a377e95");
            pSDEFieldModel.setName("PSHELPMODULENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5e2e\u52a9");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSHELPMODULE_PSHELPMODULEID");
            pSDEFieldModel.setLinkDEFName("PSHELPMODULENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSHelpModuleName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSHELPMODULENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSHELPMODULENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSHELPMODULENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSHELPMODULENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSUBVIEWTYPEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1def04b2296d3dc1352a87f59761fe63");
            pSDEFieldModel.setName("PSSUBVIEWTYPEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u89c6\u56fe\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSUBVIEWTYPE_PSSUBVIEWTYPEID");
            pSDEFieldModel.setLinkDEFName("PSSUBVIEWTYPEID");
            pSDEFieldModel.setCodeName("PSSubViewTypeId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSUBVIEWTYPEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSUBVIEWTYPEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSUBVIEWTYPENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("79ca7334b131bee25a4275627111a719");
            pSDEFieldModel.setName("PSSUBVIEWTYPENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u89c6\u56fe\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSUBVIEWTYPE_PSSUBVIEWTYPEID");
            pSDEFieldModel.setLinkDEFName("PSSUBVIEWTYPENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSubViewTypeName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u6837\u5f0f\uff0c\u89c6\u56fe\u6837\u5f0f\u652f\u6301\u6a21\u677f\u63d2\u4ef6\uff0c\u89c6\u56fe\u6837\u5f0f\u5728\u6807\u51c6\u89c6\u56fe\u7c7b\u578b\u7684\u57fa\u7840\u4e0a\u8fdb\u4e00\u6b65\u589e\u5f3a\u89c6\u56fe\u7684\u8868\u73b0\u6837\u5f0f");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSUBVIEWTYPENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSUBVIEWTYPENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSUBVIEWTYPENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSUBVIEWTYPENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSCOUNTERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5465e6c1fcdbccfa1df4782438dd94af");
            pSDEFieldModel.setName("PSSYSCOUNTERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8ba1\u6570\u5668");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSCOUNTER_PSSYSCOUNTERID");
            pSDEFieldModel.setLinkDEFName("PSSYSCOUNTERID");
            pSDEFieldModel.setCodeName("PSSysCounterId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSCOUNTERID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSCOUNTERID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSCOUNTERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("191b527b852dcce1605a11ef4e4c20e9");
            pSDEFieldModel.setName("PSSYSCOUNTERNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8ba1\u6570\u5668");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSCOUNTER_PSSYSCOUNTERID");
            pSDEFieldModel.setLinkDEFName("PSSYSCOUNTERNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysCounterName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u9ed8\u8ba4\u52a0\u8f7d\u7684\u754c\u9762\u8ba1\u6570\u5668\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSCOUNTERNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSCOUNTERNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSCOUNTERNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSCOUNTERNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSCSSID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c5199447d171178cda6d1e13d75f0669");
            pSDEFieldModel.setName("PSSYSCSSID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u754c\u9762\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSCSS_PSSYSCSSID");
            pSDEFieldModel.setLinkDEFName("PSSYSCSSID");
            pSDEFieldModel.setCodeName("PSSysCssId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSCSSID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSCSSID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSCSSNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("46275655490b91b86d689a98ba93e19a");
            pSDEFieldModel.setName("PSSYSCSSNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u754c\u9762\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSCSS_PSSYSCSSID");
            pSDEFieldModel.setLinkDEFName("PSSYSCSSNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysCssName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u754c\u9762\u8868\uff0c\u754c\u9762\u6837\u5f0f\u8868\u5c06\u9644\u52a0\u5230\u89c6\u56fe\u7684\u9876\u7ea7\u5bb9\u5668\uff0c\u7ea6\u675f\u6574\u4f53\u754c\u9762\u5448\u73b0");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSCSSNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSCSSNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSCSSNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSCSSNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDYNAMODELID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("805ccad6c53e5e56981579eb64335f37");
            pSDEFieldModel.setName("PSSYSDYNAMODELID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6269\u5c55\u52a8\u6001\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSDYNAMODEL_PSSYSDYNAMODELID");
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
            pSDEFieldModel.setId("762bac1002cd8a9129cb8193c4475340");
            pSDEFieldModel.setName("PSSYSDYNAMODELNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6269\u5c55\u52a8\u6001\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSDYNAMODEL_PSSYSDYNAMODELID");
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
        object = this.createDEField("PSSYSIMAGEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("22e625210c5225bda3a551b41f19f494");
            pSDEFieldModel.setName("PSSYSIMAGEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u56fe\u6807");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSIMAGE_PSSYSIMAGEID");
            pSDEFieldModel.setLinkDEFName("PSSYSIMAGEID");
            pSDEFieldModel.setCodeName("PSSysImageId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSIMAGEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSIMAGEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSIMAGENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9f46304bad97fa3e09843c92ad871aa2");
            pSDEFieldModel.setName("PSSYSIMAGENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u56fe\u6807");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSIMAGE_PSSYSIMAGEID");
            pSDEFieldModel.setLinkDEFName("PSSYSIMAGENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysImageName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u663e\u793a\u56fe\u6807\uff0c\u672a\u5b9a\u4e49\u662f\u4f7f\u7528\u6240\u5728\u5b9e\u4f53\u7684\u9ed8\u8ba4\u56fe\u6807");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSIMAGENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSIMAGENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSIMAGENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSIMAGENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSPFPLUGINID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("56073c6cfe97bf318bb3f63f7483da2a");
            pSDEFieldModel.setName("PSSYSPFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSPFPLUGIN_PSSYSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSPFPLUGINID");
            pSDEFieldModel.setCodeName("PSSysPFPluginId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSPFPLUGINID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSPFPLUGINID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSPFPLUGINNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("129c3c21f12bb05646a79f409f97ae84");
            pSDEFieldModel.setName("PSSYSPFPLUGINNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u524d\u7aef\u6269\u5c55\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSPFPLUGIN_PSSYSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSPFPLUGINNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysPFPluginName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u4f7f\u7528\u63d2\u4ef6\u7c7b\u578b\u3010\u5b9e\u4f53\u89c6\u56fe\u7ed8\u5236\u63d2\u4ef6\u3011");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSPFPLUGINNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSPFPLUGINNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSPFPLUGINNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSPFPLUGINNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSREQITEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("41b8e43c27a0b6189b8368a9212b0875");
            pSDEFieldModel.setName("PSSYSREQITEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8bbe\u8ba1\u9700\u6c42");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSREQITEM_PSSYSREQITEMID");
            pSDEFieldModel.setLinkDEFName("PSSYSREQITEMID");
            pSDEFieldModel.setCodeName("PSSysReqItemId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSREQITEMID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSREQITEMID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSREQITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d58e374975b30aa73c91b440e5feea16");
            pSDEFieldModel.setName("PSSYSREQITEMNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8bbe\u8ba1\u9700\u6c42");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSREQITEM_PSSYSREQITEMID");
            pSDEFieldModel.setLinkDEFName("PSSYSREQITEMNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysReqItemName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSREQITEMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSREQITEMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSREQITEMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSREQITEMNAME_LIKE");
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
            pSDEFieldModel.setId("8a5750bd88eeedc511fade13c4a71cf3");
            pSDEFieldModel.setName("PSSYSTEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSTEM_PSSYSTEMID");
            pSDEFieldModel.setLinkDEFName("PSSYSTEMID");
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
            pSDEFieldModel.setId("479801544268f9a4336f6b723e67c0df");
            pSDEFieldModel.setName("PSSYSTEMNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSTEM_PSSYSTEMID");
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
        object = this.createDEField("PSSYSUNIRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ccf3eb10cfb9a6aa19acf47bde40bb90");
            pSDEFieldModel.setName("PSSYSUNIRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSUNIRES_PSSYSUNIRESID");
            pSDEFieldModel.setLinkDEFName("PSSYSUNIRESID");
            pSDEFieldModel.setCodeName("PSSysUniResId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSUNIRESID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSUNIRESID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSUNIRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("823a0561c735abfdb198f3cd0a33095f");
            pSDEFieldModel.setName("PSSYSUNIRESNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSUNIRES_PSSYSUNIRESID");
            pSDEFieldModel.setLinkDEFName("PSSYSUNIRESNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysUniResName");
            pSDEFieldModel.setMemo("\u5b9e\u4f53\u89c6\u56fe\u8bbf\u95ee\u7528\u6237\u6a21\u5f0f\u8bbe\u7f6e\u4e3a\u9700\u8981\u62e5\u6709\u6307\u5b9a\u8d44\u6e90\u80fd\u529b\u65f6\uff0c\u6307\u5b9a\u76f8\u5e94\u7684\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSUNIRESNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSUNIRESNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSUNIRESNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSUNIRESNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSVIEWPANELID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d9e0ee2cbfe1b29581da17a2d539ac2c");
            pSDEFieldModel.setName("PSSYSVIEWPANELID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5e03\u5c40\u9762\u677f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSVIEWPANEL_PSSYSVIEWPANELID");
            pSDEFieldModel.setLinkDEFName("PSSYSVIEWPANELID");
            pSDEFieldModel.setCodeName("PSSysViewPanelId");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u7684\u5e03\u5c40\u9762\u677f");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSVIEWPANELID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSVIEWPANELID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSVIEWPANELNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("99a45bdba86538610e4ec8feab045014");
            pSDEFieldModel.setName("PSSYSVIEWPANELNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5e03\u5c40\u9762\u677f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSSYSVIEWPANEL_PSSYSVIEWPANELID");
            pSDEFieldModel.setLinkDEFName("PSSYSVIEWPANELNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysViewPanelName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u7684\u5e03\u5c40\u9762\u677f");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSVIEWPANELNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSVIEWPANELNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSVIEWPANELNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSVIEWPANELNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSVIEWENGINEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("75526e36c5fc35044f278caaa5dd41d8");
            pSDEFieldModel.setName("PSVIEWENGINEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5f15\u64ce");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSVIEWENGINE_PSVIEWENGINEID");
            pSDEFieldModel.setLinkDEFName("PSVIEWENGINEID");
            pSDEFieldModel.setCodeName("PSViewEngineId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSVIEWENGINEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSVIEWENGINEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSVIEWENGINENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0e3d7acc75d343d092479217e42e4780");
            pSDEFieldModel.setName("PSVIEWENGINENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5f15\u64ce");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSVIEWENGINE_PSVIEWENGINEID");
            pSDEFieldModel.setLinkDEFName("PSVIEWENGINENAME");
            pSDEFieldModel.setCodeName("PSViewEngineName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSVIEWENGINENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSVIEWENGINENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSVIEWENGINENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSVIEWENGINENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSVIEWMSGGROUPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c28f210f2642b9d5991b762dfd87dbbd");
            pSDEFieldModel.setName("PSVIEWMSGGROUPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6d88\u606f\u7ec4");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSVIEWMSGGROUP_PSVIEWMSGGROUPID");
            pSDEFieldModel.setLinkDEFName("PSVIEWMSGGROUPID");
            pSDEFieldModel.setCodeName("PSViewMsgGroupId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSVIEWMSGGROUPID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSVIEWMSGGROUPID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSVIEWMSGGROUPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ec0d5dc1fb2325b300be058101381cf5");
            pSDEFieldModel.setName("PSVIEWMSGGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6d88\u606f\u7ec4");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSVIEWMSGGROUP_PSVIEWMSGGROUPID");
            pSDEFieldModel.setLinkDEFName("PSVIEWMSGGROUPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSViewMsgGroupName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u4f7f\u7528\u7684\u89c6\u56fe\u6d88\u606f\u7ec4");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSVIEWMSGGROUPNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSVIEWMSGGROUPNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSVIEWMSGGROUPNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSVIEWMSGGROUPNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSVTSTYLEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("be6120353a50e42d9c55ea3e679d1bf7");
            pSDEFieldModel.setName("PSVTSTYLEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSVTSTYLE_PSVTSTYLEID");
            pSDEFieldModel.setLinkDEFName("PSVTSTYLEID");
            pSDEFieldModel.setCodeName("PSVTStyleId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSVTSTYLEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSVTSTYLEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSVTSTYLENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a6ab959204982f5ae3cef78bcc918b1b");
            pSDEFieldModel.setName("PSVTSTYLENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSVTSTYLE_PSVTSTYLEID");
            pSDEFieldModel.setLinkDEFName("PSVTSTYLENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSVTStyleName");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSVTSTYLENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSVTSTYLENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSVTSTYLENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSVTSTYLENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSWFDEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4aa751038d50bc67bf85a128f2711741");
            pSDEFieldModel.setName("PSWFDEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5de5\u4f5c\u6d41");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSWFDE_PSWFDEID");
            pSDEFieldModel.setLinkDEFName("PSWFDEID");
            pSDEFieldModel.setCodeName("PSWFDEId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSWFDEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSWFDEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSWFDENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("541f0d8cebb4204f1b71d9899306fce2");
            pSDEFieldModel.setName("PSWFDENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5de5\u4f5c\u6d41\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSWFDE_PSWFDEID");
            pSDEFieldModel.setLinkDEFName("PSWFDENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSWFDEName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSWFDENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSWFDENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSWFDENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSWFDENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSWFID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9267ce763f3d9ccbe6ee1ac0ab838f0e");
            pSDEFieldModel.setName("PSWFID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("PSWFID");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSWFDE_PSWFDEID");
            pSDEFieldModel.setLinkDEFName("PSWFID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSWFId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSWFVERSIONID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("179b61f0599a780039139480525cdd1a");
            pSDEFieldModel.setName("PSWFVERSIONID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5de5\u4f5c\u6d41\u7248\u672c");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSWFVERSION_PSWFVERSIONID");
            pSDEFieldModel.setLinkDEFName("PSWFVERSIONID");
            pSDEFieldModel.setCodeName("PSWFVersionId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSWFVERSIONID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSWFVERSIONID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSWFVERSIONNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2be3ff11a9b0e59656e532fc370f9a42");
            pSDEFieldModel.setName("PSWFVERSIONNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5de5\u4f5c\u6d41\u7248\u672c");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSWFVERSION_PSWFVERSIONID");
            pSDEFieldModel.setLinkDEFName("PSWFVERSIONNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSWFVersionName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u4f7f\u7528\u7684\u5de5\u4f5c\u6d41\u7248\u672c\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSWFVERSIONNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSWFVERSIONNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSWFVERSIONNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSWFVERSIONNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("READONLYMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e584bbec89ff8abffe83acb5ba0eb210");
            pSDEFieldModel.setName("READONLYMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u53ea\u8bfb\u6a21\u5f0f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ReadOnlyMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u662f\u5426\u5904\u4e8e\u81ea\u8bfb\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SHOWCAPTIONBAR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3ffa98d87cc08cf5f81f3bb5ad2fd7ac");
            pSDEFieldModel.setName("SHOWCAPTIONBAR");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u663e\u793a\u6807\u9898\u680f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ShowCaptionBar");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u662f\u5426\u663e\u793a\u6807\u9898\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SRFSYSPUB");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2101390d706ae9798bacf7596968159e");
            pSDEFieldModel.setName("SRFSYSPUB");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u578b\u53d1\u5e03");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("SRFSysPub");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SUBCAPPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6c61b5c2106002d166ef33fd4a4d6611");
            pSDEFieldModel.setName("SUBCAPPSLANRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b50\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSLANGUAGERES_SUBCAPPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESID");
            pSDEFieldModel.setCodeName("SubCapPSLanResId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SUBCAPPSLANRESID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SUBCAPPSLANRESID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SUBCAPPSLANRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b4aa3c9c5beca0d045261a85edf73325");
            pSDEFieldModel.setName("SUBCAPPSLANRESNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b50\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSLANGUAGERES_SUBCAPPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESNAME");
            pSDEFieldModel.setCodeName("SubCapPSLanResName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SUBCAPPSLANRESNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SUBCAPPSLANRESNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SUBCAPPSLANRESNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SUBCAPPSLANRESNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SUBCAPTION");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fc114364f50a2f002bf892f01ff182f3");
            pSDEFieldModel.setName("SUBCAPTION");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u5b50\u6807\u9898");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("SubCaption");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b6713bd5d8f111ef7ba0f7aebc63b7d7");
            pSDEFieldModel.setName("TEMPMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e34\u65f6\u6570\u636e\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TempDataModeCodeListModel");
            pSDEFieldModel.setCodeName("TempMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u7684\u4e34\u65f6\u6570\u636e\u6a21\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u4e34\u65f6\u6570\u636e\u6a21\u5f0f\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TEMPMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TEMPMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TITLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("36ce12dea1f5a06d7523fb3b22ffeb95");
            pSDEFieldModel.setName("TITLE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u62ac\u5934");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Title");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u62ac\u5934");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TITLE_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TITLE_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TITLEPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1f0d36104ee7eaeed5b70dcd4a96fb62");
            pSDEFieldModel.setName("TITLEPSLANRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u62ac\u5934\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSLANGUAGERES_TITLEPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESID");
            pSDEFieldModel.setCodeName("TitlePSLanResId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TITLEPSLANRESID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TITLEPSLANRESID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TITLEPSLANRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6413cecd62adc61cacf4924ca872468c");
            pSDEFieldModel.setName("TITLEPSLANRESNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u62ac\u5934\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEVIEWBASE_PSLANGUAGERES_TITLEPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESNAME");
            pSDEFieldModel.setCodeName("TitlePSLanResName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u62ac\u5934\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TITLEPSLANRESNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TITLEPSLANRESNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TITLEPSLANRESNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TITLEPSLANRESNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TODOTASK");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6947e63c0d598bc6135223983b76a2f4");
            pSDEFieldModel.setName("TODOTASK");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("TODO");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ToDoTask");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("07444f93cc3bf43b2da7a5644e9f9271");
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
            pSDEFieldModel.setId("1bae19d806acc9bc30ef0a4c7e031774");
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
        object = this.createDEField("USERDATA");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("543c938a123ca04faa3b7b36f0c7e951");
            pSDEFieldModel.setName("USERDATA");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6570\u636e");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserData");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERDATA2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("60a543afe4f046a63adac8aa4e1541e1");
            pSDEFieldModel.setName("USERDATA2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6570\u636e2");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UserData2");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("USERPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3c07e145a6e27d54253c6952c7a685b8");
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
        object = this.createDEField("VIEWACTIONS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6ceddbe10f03bd20837a2a441dfbc5ea");
            pSDEFieldModel.setName("VIEWACTIONS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u64cd\u4f5c\u63a7\u5236");
            pSDEFieldModel.setDataType("NMCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEViewActionsCodeListModel");
            pSDEFieldModel.setCodeName("ViewActions");
            pSDEFieldModel.setMemo("\u89c6\u56fe\u542f\u7528\u64cd\u4f5c\u63a7\u5236\u65f6\uff0c\u6307\u5b9a\u89c6\u56fe\u652f\u6301\u7684\u64cd\u4f5c\u96c6\u5408");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWMODEL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("402b6b6bfaea2027fbc03d14e571f696");
            pSDEFieldModel.setName("VIEWMODEL");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u6a21\u578b");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewModel");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6dcd3bba666a0098ac5bc442430681e6");
            pSDEFieldModel.setName("VIEWPARAM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u6570");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u6570");
            pSDEFieldModel.setLength(40);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM10");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
            pSDEFieldModel.setName("VIEWPARAM10");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u657010");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam10");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u657010");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM11");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("eeadce576ff46f5d303daf0885dbfc89");
            pSDEFieldModel.setName("VIEWPARAM11");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u657011");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam11");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM12");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("68d302ec065230b58d4505464779f1ec");
            pSDEFieldModel.setName("VIEWPARAM12");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u657012");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam12");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM13");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0214e9899ca4b6784d8c30c0bc4acc1c");
            pSDEFieldModel.setName("VIEWPARAM13");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u657013");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam13");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM14");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bb753fb88c51f690ece12b74b490b288");
            pSDEFieldModel.setName("VIEWPARAM14");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u657014");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam14");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM15");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d4805da5f9ed6f67115fe3647a074446");
            pSDEFieldModel.setName("VIEWPARAM15");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u657015");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam15");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM16");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7f143664aa2e3600fa2092cbc40586bf");
            pSDEFieldModel.setName("VIEWPARAM16");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u657016");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam16");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(200);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM17");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5e4c1cd45c2b814466362ebf98c84ad6");
            pSDEFieldModel.setName("VIEWPARAM17");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u657017");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam17");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM18");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4bfc762175a25200563bb70755b441b2");
            pSDEFieldModel.setName("VIEWPARAM18");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u657018");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam18");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("933b2be794930f6a5d58db01b597e3f7");
            pSDEFieldModel.setName("VIEWPARAM2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u65702");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam2");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65702");
            pSDEFieldModel.setLength(40);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0335283c277b7d521bbc46a3d3b35572");
            pSDEFieldModel.setName("VIEWPARAM3");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u65703");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam3");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65703");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM4");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3608091c9b8e45f61407b626937c02bd");
            pSDEFieldModel.setName("VIEWPARAM4");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u65704");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam4");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65704");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM5");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a7a33d08d19703b5724a078fae7a9b34");
            pSDEFieldModel.setName("VIEWPARAM5");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u65705");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ViewParam5");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM6");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
            pSDEFieldModel.setName("VIEWPARAM6");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u65706");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ViewParam6");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65706");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM7");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8faebbefc7015e50a20f9212418c4710");
            pSDEFieldModel.setName("VIEWPARAM7");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u65707");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam7");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65707");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM8");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8996c1b6cd9905e912670edf8b019f54");
            pSDEFieldModel.setName("VIEWPARAM8");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u65708");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam8");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65708");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAM9");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
            pSDEFieldModel.setName("VIEWPARAM9");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u53c2\u65709");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParam9");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65709");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f259244b256cdeb4587f9608bf9c0e40");
            pSDEFieldModel.setName("VIEWPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u52a8\u6001\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewParams");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u52a8\u6001\u53c2\u6570\uff0c\u4f7f\u7528Properties\u683c\u5f0f");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VIEWSN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7c8000d06365691f85ab1f7eb8bc5ce0");
            pSDEFieldModel.setName("VIEWSN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u89c6\u56fe\u7f16\u53f7");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ViewSN");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7f16\u53f7");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WFVIEWPARAM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("31cf583ffead0dc6c269b85b3dea8a15");
            pSDEFieldModel.setName("WFVIEWPARAM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6d41\u7a0b\u89c6\u56fe\u53c2\u6570");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("WFViewParam");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u6570");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WFVIEWPARAM2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5533a0957e0a88799f8d26d692864015");
            pSDEFieldModel.setName("WFVIEWPARAM2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6d41\u7a0b\u89c6\u56fe\u53c2\u65702");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("WFViewParam2");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65702");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WFVIEWPARAM3");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6288968d0a372e4e46262723d63fbb7c");
            pSDEFieldModel.setName("WFVIEWPARAM3");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6d41\u7a0b\u89c6\u56fe\u53c2\u65703");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("WFViewParam3");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65703");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WFVIEWPARAM4");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a7b7376a062ef1747c55e6901d4e3441");
            pSDEFieldModel.setName("WFVIEWPARAM4");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6d41\u7a0b\u89c6\u56fe\u53c2\u65704");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("WFViewParam4");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65704");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIDTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6e0010bbec89bb231014493b5a64c1e6");
            pSDEFieldModel.setName("WIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bbd\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Width");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u30100\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
    }

    @Override
    protected void onPrepareDEACModes() throws Exception {
        PSDEViewBaseDefaultACModel pSDEViewBaseDefaultACModel = new PSDEViewBaseDefaultACModel();
        pSDEViewBaseDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDEViewBaseDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDEViewBaseByTypeDSModel pSDEViewBaseByTypeDSModel = new PSDEViewBaseByTypeDSModel();
        pSDEViewBaseByTypeDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseByTypeDSModel);
        PSDEViewBaseCurAppDSModel pSDEViewBaseCurAppDSModel = new PSDEViewBaseCurAppDSModel();
        pSDEViewBaseCurAppDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseCurAppDSModel);
        PSDEViewBaseCurAppAddDSModel pSDEViewBaseCurAppAddDSModel = new PSDEViewBaseCurAppAddDSModel();
        pSDEViewBaseCurAppAddDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseCurAppAddDSModel);
        PSDEViewBaseCurAppNotAddDSModel pSDEViewBaseCurAppNotAddDSModel = new PSDEViewBaseCurAppNotAddDSModel();
        pSDEViewBaseCurAppNotAddDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseCurAppNotAddDSModel);
        PSDEViewBaseCurDEDSModel pSDEViewBaseCurDEDSModel = new PSDEViewBaseCurDEDSModel();
        pSDEViewBaseCurDEDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseCurDEDSModel);
        PSDEViewBaseCurDE2DSModel pSDEViewBaseCurDE2DSModel = new PSDEViewBaseCurDE2DSModel();
        pSDEViewBaseCurDE2DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseCurDE2DSModel);
        PSDEViewBaseCurDEMobDSModel pSDEViewBaseCurDEMobDSModel = new PSDEViewBaseCurDEMobDSModel();
        pSDEViewBaseCurDEMobDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseCurDEMobDSModel);
        PSDEViewBaseCurDEWebDSModel pSDEViewBaseCurDEWebDSModel = new PSDEViewBaseCurDEWebDSModel();
        pSDEViewBaseCurDEWebDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseCurDEWebDSModel);
        PSDEViewBaseCurSysDSModel pSDEViewBaseCurSysDSModel = new PSDEViewBaseCurSysDSModel();
        pSDEViewBaseCurSysDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseCurSysDSModel);
        PSDEViewBaseCurWF2DSModel pSDEViewBaseCurWF2DSModel = new PSDEViewBaseCurWF2DSModel();
        pSDEViewBaseCurWF2DSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseCurWF2DSModel);
        PSDEViewBaseCurWFVerDSModel pSDEViewBaseCurWFVerDSModel = new PSDEViewBaseCurWFVerDSModel();
        pSDEViewBaseCurWFVerDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseCurWFVerDSModel);
        PSDEViewBaseDEPDTDSModel pSDEViewBaseDEPDTDSModel = new PSDEViewBaseDEPDTDSModel();
        pSDEViewBaseDEPDTDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseDEPDTDSModel);
        PSDEViewBaseDefaultDSModel pSDEViewBaseDefaultDSModel = new PSDEViewBaseDefaultDSModel();
        pSDEViewBaseDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseDefaultDSModel);
        PSDEViewBaseFormTypeDSModel pSDEViewBaseFormTypeDSModel = new PSDEViewBaseFormTypeDSModel();
        pSDEViewBaseFormTypeDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseFormTypeDSModel);
        PSDEViewBaseMobDSModel pSDEViewBaseMobDSModel = new PSDEViewBaseMobDSModel();
        pSDEViewBaseMobDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseMobDSModel);
        PSDEViewBaseWFDSModel pSDEViewBaseWFDSModel = new PSDEViewBaseWFDSModel();
        pSDEViewBaseWFDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseWFDSModel);
        PSDEViewBaseWebDSModel pSDEViewBaseWebDSModel = new PSDEViewBaseWebDSModel();
        pSDEViewBaseWebDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEViewBaseWebDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDEViewBaseByTypeDQModel pSDEViewBaseByTypeDQModel = new PSDEViewBaseByTypeDQModel();
        pSDEViewBaseByTypeDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseByTypeDQModel);
        PSDEViewBaseCurAppDQModel pSDEViewBaseCurAppDQModel = new PSDEViewBaseCurAppDQModel();
        pSDEViewBaseCurAppDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseCurAppDQModel);
        PSDEViewBaseCurAppAddDQModel pSDEViewBaseCurAppAddDQModel = new PSDEViewBaseCurAppAddDQModel();
        pSDEViewBaseCurAppAddDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseCurAppAddDQModel);
        PSDEViewBaseCurAppNotAddDQModel pSDEViewBaseCurAppNotAddDQModel = new PSDEViewBaseCurAppNotAddDQModel();
        pSDEViewBaseCurAppNotAddDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseCurAppNotAddDQModel);
        PSDEViewBaseCurDEDQModel pSDEViewBaseCurDEDQModel = new PSDEViewBaseCurDEDQModel();
        pSDEViewBaseCurDEDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseCurDEDQModel);
        PSDEViewBaseCurDE2DQModel pSDEViewBaseCurDE2DQModel = new PSDEViewBaseCurDE2DQModel();
        pSDEViewBaseCurDE2DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseCurDE2DQModel);
        PSDEViewBaseCurDEMobDQModel pSDEViewBaseCurDEMobDQModel = new PSDEViewBaseCurDEMobDQModel();
        pSDEViewBaseCurDEMobDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseCurDEMobDQModel);
        PSDEViewBaseCurDEWebDQModel pSDEViewBaseCurDEWebDQModel = new PSDEViewBaseCurDEWebDQModel();
        pSDEViewBaseCurDEWebDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseCurDEWebDQModel);
        PSDEViewBaseCurSysDQModel pSDEViewBaseCurSysDQModel = new PSDEViewBaseCurSysDQModel();
        pSDEViewBaseCurSysDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseCurSysDQModel);
        PSDEViewBaseCurWF2DQModel pSDEViewBaseCurWF2DQModel = new PSDEViewBaseCurWF2DQModel();
        pSDEViewBaseCurWF2DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseCurWF2DQModel);
        PSDEViewBaseCurWFVerDQModel pSDEViewBaseCurWFVerDQModel = new PSDEViewBaseCurWFVerDQModel();
        pSDEViewBaseCurWFVerDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseCurWFVerDQModel);
        PSDEViewBaseDEPDTDQModel pSDEViewBaseDEPDTDQModel = new PSDEViewBaseDEPDTDQModel();
        pSDEViewBaseDEPDTDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseDEPDTDQModel);
        PSDEViewBaseDefaultDQModel pSDEViewBaseDefaultDQModel = new PSDEViewBaseDefaultDQModel();
        pSDEViewBaseDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseDefaultDQModel);
        PSDEViewBaseMobDQModel pSDEViewBaseMobDQModel = new PSDEViewBaseMobDQModel();
        pSDEViewBaseMobDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseMobDQModel);
        PSDEViewBasePDTCntDQModel pSDEViewBasePDTCntDQModel = new PSDEViewBasePDTCntDQModel();
        pSDEViewBasePDTCntDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBasePDTCntDQModel);
        PSDEViewBasePDTCnt2DQModel pSDEViewBasePDTCnt2DQModel = new PSDEViewBasePDTCnt2DQModel();
        pSDEViewBasePDTCnt2DQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBasePDTCnt2DQModel);
        PSDEViewBaseWFDQModel pSDEViewBaseWFDQModel = new PSDEViewBaseWFDQModel();
        pSDEViewBaseWFDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseWFDQModel);
        PSDEViewBaseWebDQModel pSDEViewBaseWebDQModel = new PSDEViewBaseWebDQModel();
        pSDEViewBaseWebDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEViewBaseWebDQModel);
    }

    protected void prepareDEActions() throws Exception {
    }

    protected void prepareDELogics() throws Exception {
        PSDEViewBaseNode2DELogicModel pSDEViewBaseNode2DELogicModel = new PSDEViewBaseNode2DELogicModel();
        pSDEViewBaseNode2DELogicModel.init((IDataEntity)this);
        this.registerDELogic((IDELogic)pSDEViewBaseNode2DELogicModel);
        PSDEViewBaseNode2WFLogicModel pSDEViewBaseNode2WFLogicModel = new PSDEViewBaseNode2WFLogicModel();
        pSDEViewBaseNode2WFLogicModel.init((IDataEntity)this);
        this.registerDELogic((IDELogic)pSDEViewBaseNode2WFLogicModel);
        PSDEViewBaseNode2WFVerLogicModel pSDEViewBaseNode2WFVerLogicModel = new PSDEViewBaseNode2WFVerLogicModel();
        pSDEViewBaseNode2WFVerLogicModel.init((IDataEntity)this);
        this.registerDELogic((IDELogic)pSDEViewBaseNode2WFVerLogicModel);
    }

    @Override
    protected void onPrepareDEUIActions() throws Exception {
        PSDEViewBaseJITPreviewUIActionModel pSDEViewBaseJITPreviewUIActionModel = new PSDEViewBaseJITPreviewUIActionModel();
        pSDEViewBaseJITPreviewUIActionModel.init((IDataEntity)this);
        this.registerDEUIAction((IDEUIAction)pSDEViewBaseJITPreviewUIActionModel);
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
        this.registerPDTDEView("EDITVIEW:DECALENDAREXPVIEW", "F0F82F1C-DE5C-44CB-83E3-73007FCB9C2C");
        this.registerPDTDEView("EDITVIEW:DECALENDARVIEW", "340C6FC7-1B02-41B1-8616-AC71120C3AC2");
        this.registerPDTDEView("EDITVIEW:DECALENDARVIEW9", "C0212A9C-0885-462B-851A-775BFA3558DD");
        this.registerPDTDEView("EDITVIEW:DECHARTEXPVIEW", "C1666CB1-5A73-4D0F-8C9F-89A0714AD6B6");
        this.registerPDTDEView("EDITVIEW:DECHARTVIEW", "6DEF82E1-878D-4F58-9AE5-C91505E55362");
        this.registerPDTDEView("EDITVIEW:DECHARTVIEW9", "72959B4C-48D5-4C0D-99B4-509D0852A461");
        this.registerPDTDEView("EDITVIEW:DECUSTOMVIEW", "ADE36DFC-2DA3-4842-BFFE-437BB1F0CB39");
        this.registerPDTDEView("EDITVIEW:DEDATAVIEW", "9CCC3AD0-F62C-4D0F-9201-5BF804E81AC2");
        this.registerPDTDEView("EDITVIEW:DEDATAVIEW9", "0A25A278-06A8-42D2-B876-E75DBF714E28");
        this.registerPDTDEView("EDITVIEW:DEDATAVIEWEXPVIEW", "D43105A7-BE60-437F-91A5-B6F18A8D66E7");
        this.registerPDTDEView("EDITVIEW:DEEDITVIEW", "5AAF2034-3A8E-45B5-BC34-A72612EB1A0D");
        this.registerPDTDEView("EDITVIEW:DEEDITVIEW2", "7C612E86-DBF4-454F-B867-45C85C1D3C8F");
        this.registerPDTDEView("EDITVIEW:DEEDITVIEW3", "2D3BCB96-9472-4CCF-BBF5-CB8C4658570F");
        this.registerPDTDEView("EDITVIEW:DEEDITVIEW4", "6AA183D1-EDA4-4391-BCB1-D707B06C5CD1");
        this.registerPDTDEView("EDITVIEW:DEEDITVIEW9", "A8014129-4A76-4F9A-9571-5994B13A9845");
        this.registerPDTDEView("EDITVIEW:DEFORMPICKUPDATAVIEW", "73C1353A-27F3-4377-A45B-78B52A2264C2");
        this.registerPDTDEView("EDITVIEW:DEGANTTEXPVIEW", "54C5500A-6B39-47A7-B08D-25A1021B1296");
        this.registerPDTDEView("EDITVIEW:DEGANTTVIEW", "C11B792E-F58C-4800-99FA-8482697DC0E0");
        this.registerPDTDEView("EDITVIEW:DEGANTTVIEW9", "B77F67A2-F837-42F8-8BAA-78C38FDB1D2B");
        this.registerPDTDEView("EDITVIEW:DEGRIDEXPVIEW", "81495BC6-91BE-4022-BC0B-2156C8D75291");
        this.registerPDTDEView("EDITVIEW:DEGRIDVIEW", "B2EC516F-72BE-4057-A3DF-C8EDAB0DE371");
        this.registerPDTDEView("EDITVIEW:DEGRIDVIEW2", "0F7C2669-A167-4C78-9203-F26E07482E63");
        this.registerPDTDEView("EDITVIEW:DEGRIDVIEW4", "83EE3FF2-6D4B-4F72-87CD-DEE448104671");
        this.registerPDTDEView("EDITVIEW:DEGRIDVIEW8", "F0CCE8BC-15C5-49E0-97A8-20CB4CE2C6F2");
        this.registerPDTDEView("EDITVIEW:DEGRIDVIEW9", "F1191821-D734-4B1E-8766-9766B118E87A");
        this.registerPDTDEView("EDITVIEW:DEHTMLVIEW", "6E7B184F-7910-4DF6-AD92-AE402E7AD5FA");
        this.registerPDTDEView("EDITVIEW:DEINDEXPICKUPDATAVIEW", "E547361B-F2E5-4AD3-A646-1D425B8EAB57");
        this.registerPDTDEView("EDITVIEW:DEINDEXVIEW", "226471FC-160A-4840-9353-1AB4310768D4");
        this.registerPDTDEView("EDITVIEW:DEKANBANVIEW", "681D03A1-32DD-4B62-BF1D-B8022C819E9F");
        this.registerPDTDEView("EDITVIEW:DEKANBANVIEW9", "93482852-EC4B-438C-9C2A-F16B34263054");
        this.registerPDTDEView("EDITVIEW:DELISTEXPVIEW", "50B83532-5F94-41B0-90DC-9AC4DC17AE6D");
        this.registerPDTDEView("EDITVIEW:DELISTVIEW", "C6FEF097-3873-48A6-82C1-740D42FBBC2B");
        this.registerPDTDEView("EDITVIEW:DELISTVIEW9", "DCF2514B-6D29-41AA-B86C-E90D12E34C7D");
        this.registerPDTDEView("EDITVIEW:DEMAPEXPVIEW", "5EA630C3-27DC-4C51-B655-76413FBB4A21");
        this.registerPDTDEView("EDITVIEW:DEMAPVIEW", "00C22A58-3F3F-438A-9CCB-C1B1CF40718E");
        this.registerPDTDEView("EDITVIEW:DEMAPVIEW9", "1537BF91-0D1C-4656-ABBE-9DD6073C06B5");
        this.registerPDTDEView("EDITVIEW:DEMDCUSTOMVIEW", "61A0BEE4-3BB5-4C51-BE50-6445AFB5EC44");
        this.registerPDTDEView("EDITVIEW:DEMEDITVIEW9", "A810F590-E4EB-4F80-8BB3-65A5104B5E00");
        this.registerPDTDEView("EDITVIEW:DEMOBCALENDAREXPVIEW", "3CBD1342-95F4-483B-BB5F-177C0008E3CE");
        this.registerPDTDEView("EDITVIEW:DEMOBCALENDARVIEW", "C23398A5-E0AF-4FB6-8E57-1CDEBBE1BCE1");
        this.registerPDTDEView("EDITVIEW:DEMOBCALENDARVIEW9", "3435A532-7404-4348-AFD7-AC19398B3369");
        this.registerPDTDEView("EDITVIEW:DEMOBCHARTEXPVIEW", "DD026FE8-7092-4939-AB66-10FED9F9712D");
        this.registerPDTDEView("EDITVIEW:DEMOBCHARTVIEW", "44BE3044-13C7-40AA-BEAC-02B87AE0EEDF");
        this.registerPDTDEView("EDITVIEW:DEMOBCHARTVIEW9", "2B58ADF4-0AAD-4400-A0C1-27657432FD91");
        this.registerPDTDEView("EDITVIEW:DEMOBCUSTOMVIEW", "46F3E940-792C-451A-AE67-05CE58ACCF5B");
        this.registerPDTDEView("EDITVIEW:DEMOBDATAVIEWEXPVIEW", "220E417F-1A00-456A-B517-7365AD578A56");
        this.registerPDTDEView("EDITVIEW:DEMOBEDITVIEW", "EC37D17C-4CDF-48CB-BB9A-F8D55EE54751");
        this.registerPDTDEView("EDITVIEW:DEMOBEDITVIEW3", "1AC499A0-5F2E-4F81-A2A8-F15023DC9502");
        this.registerPDTDEView("EDITVIEW:DEMOBEDITVIEW9", "42D9B20A-D77A-4B1A-9A7A-6114D7A7D281");
        this.registerPDTDEView("EDITVIEW:DEMOBFORMPICKUPMDVIEW", "5573550A-A178-444B-A2CD-A315FB0ED3D3");
        this.registerPDTDEView("EDITVIEW:DEMOBGANTTEXPVIEW", "16016C1E-1B5E-4A59-85C2-7BD4CDE60288");
        this.registerPDTDEView("EDITVIEW:DEMOBGANTTVIEW", "654B634E-9BEE-4CB1-86C9-F98AB05E7685");
        this.registerPDTDEView("EDITVIEW:DEMOBGANTTVIEW9", "D0BC5253-F3C8-47B3-B0DE-9E7A0BB6BB45");
        this.registerPDTDEView("EDITVIEW:DEMOBHTMLVIEW", "F9C099C3-03BD-4553-AACC-69E159D85DBC");
        this.registerPDTDEView("EDITVIEW:DEMOBINDEXPICKUPMDVIEW", "9FA8B8A8-3CB6-46A5-887E-A5DF828108B2");
        this.registerPDTDEView("EDITVIEW:DEMOBLISTEXPVIEW", "DEC185C0-F323-4C5B-B976-A80F0E5665F3");
        this.registerPDTDEView("EDITVIEW:DEMOBLISTVIEW", "07765C8C-5DCA-41EB-AC9B-284B2AA65333");
        this.registerPDTDEView("EDITVIEW:DEMOBMAPEXPVIEW", "4EDBA7BE-2791-4C4F-8B65-17A60DFAA395");
        this.registerPDTDEView("EDITVIEW:DEMOBMAPVIEW", "F5616F84-D7CA-4739-8C4F-AA0CB95C84E8");
        this.registerPDTDEView("EDITVIEW:DEMOBMAPVIEW9", "821B5C2E-3B04-43FA-8326-9DE6ABFFBC55");
        this.registerPDTDEView("EDITVIEW:DEMOBMDVIEW", "344E2B39-83D0-4E93-A23A-8C48F56B2B19");
        this.registerPDTDEView("EDITVIEW:DEMOBMDVIEW9", "9267FDB5-5266-4E0D-9CC0-3D1311EE6C1B");
        this.registerPDTDEView("EDITVIEW:DEMOBMEDITVIEW9", "9AE92E2C-8621-44F1-A446-76B097345531");
        this.registerPDTDEView("EDITVIEW:DEMOBMPICKUPVIEW", "6256D518-0FE2-4427-85B7-789C173A7F7A");
        this.registerPDTDEView("EDITVIEW:DEMOBOPTVIEW", "2DAB7A88-B219-43F1-A1B4-1A44DF44D040");
        this.registerPDTDEView("EDITVIEW:DEMOBPANELVIEW", "147A44DF-8A95-4042-BD43-972E323F0585");
        this.registerPDTDEView("EDITVIEW:DEMOBPANELVIEW9", "6E03A2E6-7E86-4B5D-B0DF-A98F840E273A");
        this.registerPDTDEView("EDITVIEW:DEMOBPICKUPLISTVIEW", "A45EE7DB-A4F9-493B-8C9D-91BBC5347BF0");
        this.registerPDTDEView("EDITVIEW:DEMOBPICKUPMDVIEW", "5F02CA36-65F5-4B65-8269-07AB2FAA002A");
        this.registerPDTDEView("EDITVIEW:DEMOBPICKUPTREEVIEW", "A0614A19-1E71-4092-9DE5-FA21B6084710");
        this.registerPDTDEView("EDITVIEW:DEMOBPICKUPVIEW", "5BB99FC3-B823-4B45-A87A-C02AAF6D7889");
        this.registerPDTDEView("EDITVIEW:DEMOBPORTALVIEW", "59D3F87E-3A0E-4D2E-A7C8-1095D2F4EA54");
        this.registerPDTDEView("EDITVIEW:DEMOBPORTALVIEW9", "31F99BD5-421D-492C-8367-19C0AFF307F5");
        this.registerPDTDEView("EDITVIEW:DEMOBREDIRECTVIEW", "32BC5F0A-D8C4-45D7-A2A9-E9788EF8D3BD");
        this.registerPDTDEView("EDITVIEW:DEMOBREPORTVIEW", "E57CA6EC-70D3-41F0-95DF-AA511950790E");
        this.registerPDTDEView("EDITVIEW:DEMOBTABEXPVIEW", "01980FF1-B85A-4910-9CEE-502E19839EC3");
        this.registerPDTDEView("EDITVIEW:DEMOBTABEXPVIEW9", "3441B1ED-171F-4D2F-A0F0-C2FB24AC5D44");
        this.registerPDTDEView("EDITVIEW:DEMOBTABSEARCHVIEW", "332AFAFF-115B-4000-AC94-BA52F75A4CDF");
        this.registerPDTDEView("EDITVIEW:DEMOBTABSEARCHVIEW9", "12736B57-FF6F-406E-B3D3-28B1B546B275");
        this.registerPDTDEView("EDITVIEW:DEMOBTREEEXPVIEW", "E627E819-286B-4B25-BE3F-2F46727DA6D7");
        this.registerPDTDEView("EDITVIEW:DEMOBTREEEXPVIEW9", "27EF1CC0-D135-46F0-9989-AC96602916F7");
        this.registerPDTDEView("EDITVIEW:DEMOBTREEVIEW", "FA83FC22-682C-41A0-AD67-A9BCA64DC563");
        this.registerPDTDEView("EDITVIEW:DEMOBWFACTIONVIEW", "367BBDF5-16C6-4628-9537-4CDDCEE0BF8B");
        this.registerPDTDEView("EDITVIEW:DEMOBWFDATAREDIRECTVIEW", "99A9129F-0282-4013-A05B-F53CB4967271");
        this.registerPDTDEView("EDITVIEW:DEMOBWFDYNAACTIONVIEW", "A44B0D1D-43D7-43C4-8A02-0A05F378C8F9");
        this.registerPDTDEView("EDITVIEW:DEMOBWFDYNAEDITVIEW", "F5E9234D-62BF-4DCD-9D61-EEE4B3CE8824");
        this.registerPDTDEView("EDITVIEW:DEMOBWFDYNAEDITVIEW3", "29EBE3E6-92CC-4740-8681-B63591BAF4C0");
        this.registerPDTDEView("EDITVIEW:DEMOBWFDYNAEXPMDVIEW", "B38C3DCF-33F6-433E-AE3E-FAA8B8D13DC2");
        this.registerPDTDEView("EDITVIEW:DEMOBWFDYNASTARTVIEW", "FB0658C8-08A5-4BAE-8A82-5E08F99B72E0");
        this.registerPDTDEView("EDITVIEW:DEMOBWFEDITVIEW", "8D159C91-B7AC-4741-88C7-8094613FE7F8");
        this.registerPDTDEView("EDITVIEW:DEMOBWFEDITVIEW3", "5207B99C-0B54-4135-AE20-8B8FB168CDBB");
        this.registerPDTDEView("EDITVIEW:DEMOBWFMDVIEW", "7C9CFE8B-0737-4E33-8F38-A126593FACB0");
        this.registerPDTDEView("EDITVIEW:DEMOBWFPROXYRESULTVIEW", "13250A7E-5F58-4EE6-89E6-149AA6E07787");
        this.registerPDTDEView("EDITVIEW:DEMOBWFPROXYSTARTVIEW", "A356B458-9847-4326-963C-BDB22811584E");
        this.registerPDTDEView("EDITVIEW:DEMOBWFSTARTVIEW", "38C24E0B-E9A2-43FA-82B0-77E42ACE8EDC");
        this.registerPDTDEView("EDITVIEW:DEMOBWIZARDVIEW", "C9DEC641-BC2D-49F8-AD2E-33DA019F6AD6");
        this.registerPDTDEView("EDITVIEW:DEMPICKUPVIEW", "27B592FD-12B2-429E-BF48-1A33ED0C1647");
        this.registerPDTDEView("EDITVIEW:DEMPICKUPVIEW2", "EDE2D369-FE74-487D-9812-3B40D2FB92EF");
        this.registerPDTDEView("EDITVIEW:DEOPTVIEW", "D6C58196-0477-4D8D-A2C7-C4CB99A0AE7E");
        this.registerPDTDEView("EDITVIEW:DEPANELVIEW", "5BACFEE5-0549-4A29-BB26-72289F622FF0");
        this.registerPDTDEView("EDITVIEW:DEPANELVIEW9", "0EB596E3-4AFD-49AF-8007-7AAE82242A7A");
        this.registerPDTDEView("EDITVIEW:DEPICKUPDATAVIEW", "B958344E-030D-4CD0-84C9-580EF2081E3E");
        this.registerPDTDEView("EDITVIEW:DEPICKUPGRIDVIEW", "DDBBB553-1FC4-48AC-BA64-3A7812998095");
        this.registerPDTDEView("EDITVIEW:DEPICKUPTREEVIEW", "40DE0FAC-F837-4F39-8931-43E62D582DC2");
        this.registerPDTDEView("EDITVIEW:DEPICKUPVIEW", "4D463F61-7F89-4D8F-9DFC-56D87428AA01");
        this.registerPDTDEView("EDITVIEW:DEPICKUPVIEW2", "00D9B106-8618-466C-AE18-48789B34A11E");
        this.registerPDTDEView("EDITVIEW:DEPICKUPVIEW3", "89C33266-040C-45DF-8315-CD2C18BB1A25");
        this.registerPDTDEView("EDITVIEW:DEPORTALVIEW", "89C33ED1-5EBD-41A4-99CB-A4F8E2D5C657");
        this.registerPDTDEView("EDITVIEW:DEPORTALVIEW9", "492DE8C6-0E02-4C69-BCB9-0C5C06FFA30C");
        this.registerPDTDEView("EDITVIEW:DEREDIRECTVIEW", "440E6ADD-5F37-4B11-A73E-DB8226CAE9AE");
        this.registerPDTDEView("EDITVIEW:DEREPORTVIEW", "3B09A2E4-836D-438F-A3F0-2B8488CC67A0");
        this.registerPDTDEView("EDITVIEW:DESUBAPPREFVIEW", "60A43A68-998F-4D91-A3B9-8BC228DD0227");
        this.registerPDTDEView("EDITVIEW:DETABEXPVIEW", "EB1DD9F0-D527-4F7F-8866-589409F6E807");
        this.registerPDTDEView("EDITVIEW:DETABEXPVIEW9", "F633AD8B-8D55-4F41-9AD4-18FD84923FF5");
        this.registerPDTDEView("EDITVIEW:DETABFORMVIEW9", "B0986589-2C31-4170-9429-1818B17E1494");
        this.registerPDTDEView("EDITVIEW:DETABSEARCHVIEW", "BAD3D5E4-BB76-4F1F-9607-D4F389AA34ED");
        this.registerPDTDEView("EDITVIEW:DETABSEARCHVIEW9", "9DCE3CB8-657D-4A85-8A50-304B2F9A0AB9");
        this.registerPDTDEView("EDITVIEW:DETREEEXPVIEW", "A808C5B0-8196-44EE-B82A-7DBBF2329A4A");
        this.registerPDTDEView("EDITVIEW:DETREEEXPVIEW2", "E71DEA2E-6597-417E-AC12-EF226355D5BC");
        this.registerPDTDEView("EDITVIEW:DETREEEXPVIEW3", "5900E412-A2A3-432C-8FFA-D7C6FF8CF04B");
        this.registerPDTDEView("EDITVIEW:DETREEGRIDEXVIEW", "A3740C7E-79B9-462A-81DA-1395DFD71A1C");
        this.registerPDTDEView("EDITVIEW:DETREEGRIDEXVIEW9", "F98C1B64-8BA7-429A-BC6E-01B507036BD6");
        this.registerPDTDEView("EDITVIEW:DETREEGRIDVIEW9", "679316B8-C22C-49CF-9BA2-944D2C13D59D");
        this.registerPDTDEView("EDITVIEW:DETREEVIEW", "0331A4A2-C1AC-4B7F-9DF4-7FE91CBD50DF");
        this.registerPDTDEView("EDITVIEW:DETREEVIEW9", "BAD8431E-6885-4464-9F6C-561A875A2F36");
        this.registerPDTDEView("EDITVIEW:DEWFACTIONVIEW", "22D3FBBA-84B5-42E7-9FB3-2773C1CAF13D");
        this.registerPDTDEView("EDITVIEW:DEWFDATAREDIRECTVIEW", "75DD1FAD-4A92-4D20-B561-761330135A5D");
        this.registerPDTDEView("EDITVIEW:DEWFDYNAACTIONVIEW", "5226F785-669B-4B32-BE64-4EFD5404A383");
        this.registerPDTDEView("EDITVIEW:DEWFDYNAEDITVIEW", "DFE6C10A-768D-4C2B-A280-E568AD9F8924");
        this.registerPDTDEView("EDITVIEW:DEWFDYNAEDITVIEW3", "77F17119-BC09-44B1-9F0E-CE46F2D771C2");
        this.registerPDTDEView("EDITVIEW:DEWFDYNAEXPGRIDVIEW", "6BA08016-458D-4EC8-8061-278E3A0A0F1B");
        this.registerPDTDEView("EDITVIEW:DEWFDYNASTARTVIEW", "DCB92AE6-9157-4729-839C-41D6BA9EC845");
        this.registerPDTDEView("EDITVIEW:DEWFEDITVIEW", "9AC2AC57-2A2A-4EFA-A2DF-A0DCA587CBD1");
        this.registerPDTDEView("EDITVIEW:DEWFEDITVIEW2", "EFB10AAA-09CF-4A02-AB0D-BB11676B0E18");
        this.registerPDTDEView("EDITVIEW:DEWFEDITVIEW3", "4F84C1E0-4965-4DB1-BA54-8AF5F9914EF1");
        this.registerPDTDEView("EDITVIEW:DEWFEDITVIEW9", "92B7150A-9DB6-411F-8B81-6994A2A3E1CF");
        this.registerPDTDEView("EDITVIEW:DEWFEXPVIEW", "11DD5321-8087-4D05-A95C-D835E6333C49");
        this.registerPDTDEView("EDITVIEW:DEWFGRIDVIEW", "B4E3DF9E-F550-4182-955C-357C8EB247AB");
        this.registerPDTDEView("EDITVIEW:DEWFPROXYDATAREDIRECTVIEW", "F12630EB-53E1-4C84-8E08-50BB2AA15E21");
        this.registerPDTDEView("EDITVIEW:DEWFPROXYDATAVIEW", "C18C5895-38AF-4065-B62A-E850933562E3");
        this.registerPDTDEView("EDITVIEW:DEWFPROXYRESULTVIEW", "7947417A-3117-4916-BCD8-3A5A3AEBB5A8");
        this.registerPDTDEView("EDITVIEW:DEWFPROXYSTARTVIEW", "117E20A6-3F57-41D2-AF63-63A2FEBCCD8A");
        this.registerPDTDEView("EDITVIEW:DEWFSTARTVIEW", "320AE179-5738-4E24-8C08-959AF68D9E7D");
        this.registerPDTDEView("EDITVIEW:DEWIZARDVIEW", "68279F93-A03A-437B-8CE4-DEC3C177A85C");
        this.registerPDTDEView("EDITVIEW:SUBSYSDEVIEW", "4655E6C4-0361-4D0A-8F09-BDF6D58E3291");
        this.registerPDTDEView("FORMPICKUPVIEW", "2CEF5550-84C9-418C-B281-194B0665CB16");
        this.registerPDTDEView("MPICKUPVIEW", "a2f271c0caebba6d9e5268561e828402");
        this.registerPDTDEView("PICKUPVIEW", "1dcee1cd878b464b93af7369068e4126");
        this.registerPDTDEView("REDIRECTVIEW", "ed9438d13c53c4a43e98a8f830418d3b");
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
        dEDataSetCond2.setDEFName("CODENAME");
        dEDataSetCond2.setCondValue(string);
        dEDataSetCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)dEDataSetCond2);
        dEDataSetCond2 = new DEDataSetCond();
        dEDataSetCond2.setCondType("DEFIELD");
        dEDataSetCond2.setCondOp("LIKE");
        dEDataSetCond2.setDEFName("PSDEVIEWBASENAME");
        dEDataSetCond2.setCondValue(string);
        dEDataSetCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)dEDataSetCond2);
    }

    @Override
    protected void onPreparePSDEFGroupModels() throws Exception {
        IPSDEFGroupModel iPSDEFGroupModel = this.preparePSDEFGroupModel_DECALENDAREXPVIEW();
        if (iPSDEFGroupModel != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DECALENDARVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DECALENDARVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DECHARTEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DECHARTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DECHARTVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DECUSTOMVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEDATAVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEDATAVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEDATAVIEWEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEEDITVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEEDITVIEW2()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEEDITVIEW3()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEEDITVIEW4()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEEDITVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEFORMPICKUPDATAVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEGANTTEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEGANTTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEGANTTVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEGRIDEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEGRIDVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEGRIDVIEW2()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEGRIDVIEW4()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEGRIDVIEW8()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEGRIDVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEHTMLVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEINDEXPICKUPDATAVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEINDEXVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEKANBANVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEKANBANVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DELISTEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DELISTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DELISTVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMAPEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMAPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMAPVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMDCUSTOMVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMEDITVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBCALENDAREXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBCALENDARVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBCALENDARVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBCHARTEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBCHARTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBCHARTVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBCUSTOMVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBDATAVIEWEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBEDITVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBEDITVIEW3()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBEDITVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBFORMPICKUPMDVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBGANTTEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBGANTTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBGANTTVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBHTMLVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBINDEXPICKUPMDVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBLISTEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBLISTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBMAPEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBMAPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBMAPVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBMDVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBMDVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBMEDITVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBMPICKUPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBOPTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBPANELVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBPANELVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBPICKUPLISTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBPICKUPMDVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBPICKUPTREEVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBPICKUPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBPORTALVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBPORTALVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBREDIRECTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBREPORTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBTABEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBTABEXPVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBTABSEARCHVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBTABSEARCHVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBTREEEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBTREEEXPVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBTREEVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBWFACTIONVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBWFDATAREDIRECTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBWFDYNAACTIONVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBWFDYNAEDITVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBWFDYNAEDITVIEW3()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBWFDYNAEXPMDVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBWFDYNASTARTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBWFEDITVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBWFEDITVIEW3()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBWFMDVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBWFPROXYRESULTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBWFPROXYSTARTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBWFSTARTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMOBWIZARDVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMPICKUPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEMPICKUPVIEW2()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEOPTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEPANELVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEPANELVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEPICKUPDATAVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEPICKUPGRIDVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEPICKUPTREEVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEPICKUPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEPICKUPVIEW2()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEPICKUPVIEW3()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEPORTALVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEPORTALVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEREDIRECTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEREPORTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DETABEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DETABEXPVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DETABSEARCHVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DETABSEARCHVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DETREEEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DETREEEXPVIEW2()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DETREEEXPVIEW3()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DETREEGRIDEXVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DETREEGRIDEXVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DETREEGRIDVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DETREEVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DETREEVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFACTIONVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFDATAREDIRECTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFDYNAACTIONVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFDYNAEDITVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFDYNAEDITVIEW3()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFDYNAEXPGRIDVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFDYNASTARTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFEDITVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFEDITVIEW2()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFEDITVIEW3()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFEDITVIEW9()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFEXPVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFGRIDVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFPROXYDATAREDIRECTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFPROXYDATAVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFPROXYRESULTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFPROXYSTARTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWFSTARTVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DEWIZARDVIEW()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel__DEFAULT()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DECALENDAREXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DECALENDAREXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u65e5\u5386\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DECALENDAREXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8996c1b6cd9905e912670edf8b019f54");
        pSDEFGroupDetailModel.setName("VIEWPARAM8");
        iPSDEFieldModel = this.getDEField("VIEWPARAM8", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ExpBarPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u5bfc\u822a\u680f\u7684\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u684c\u9762\u7aef\u89c6\u56fe\u653e\u7f6e\u5de6\u4fa7\uff0c\u79fb\u52a8\u7aef\u89c6\u56fe\u653e\u7f6e\u4e0a\u65b9");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DECALENDARVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DECALENDARVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u65e5\u5386\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DECALENDARVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DECALENDARVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DECALENDARVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u65e5\u5386\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DECALENDARVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DECHARTEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DECHARTEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u56fe\u8868\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DECHARTEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8996c1b6cd9905e912670edf8b019f54");
        pSDEFGroupDetailModel.setName("VIEWPARAM8");
        iPSDEFieldModel = this.getDEField("VIEWPARAM8", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ExpBarPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u5bfc\u822a\u680f\u7684\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u684c\u9762\u7aef\u89c6\u56fe\u653e\u7f6e\u5de6\u4fa7\uff0c\u79fb\u52a8\u7aef\u89c6\u56fe\u653e\u7f6e\u4e0a\u65b9");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DECHARTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DECHARTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u56fe\u8868\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DECHARTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DECHARTVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DECHARTVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u56fe\u8868\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DECHARTVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DECUSTOMVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DECUSTOMVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u81ea\u5b9a\u4e49\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DECUSTOMVIEW");
        pSDEFGroupModel.setMemo("");
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEDATAVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEDATAVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6570\u636e\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEDATAVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEDATAVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEDATAVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEDATAVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEDATAVIEWEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEDATAVIEWEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5361\u7247\u89c6\u56fe\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEDATAVIEWEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8996c1b6cd9905e912670edf8b019f54");
        pSDEFGroupDetailModel.setName("VIEWPARAM8");
        iPSDEFieldModel = this.getDEField("VIEWPARAM8", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ExpBarPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u5bfc\u822a\u680f\u7684\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u684c\u9762\u7aef\u89c6\u56fe\u653e\u7f6e\u5de6\u4fa7\uff0c\u79fb\u52a8\u7aef\u89c6\u56fe\u653e\u7f6e\u4e0a\u65b9");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEEDITVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEEDITVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEEDITVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u4f20\u5165\u7236\u952e\u8f6c\u6362\u4e3a\u5f53\u524d\u952e\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0214e9899ca4b6784d8c30c0bc4acc1c");
        pSDEFGroupDetailModel.setName("VIEWPARAM13");
        iPSDEFieldModel = this.getDEField("VIEWPARAM13", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.EditViewMarkOpenDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5e4c1cd45c2b814466362ebf98c84ad6");
        pSDEFGroupDetailModel.setName("VIEWPARAM17");
        iPSDEFieldModel = this.getDEField("VIEWPARAM17", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0335283c277b7d521bbc46a3d3b35572");
        pSDEFGroupDetailModel.setName("VIEWPARAM3");
        iPSDEFieldModel = this.getDEField("VIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65703");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3608091c9b8e45f61407b626937c02bd");
        pSDEFGroupDetailModel.setName("VIEWPARAM4");
        iPSDEFieldModel = this.getDEField("VIEWPARAM4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.EditViewMultiFormModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65704");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEEDITVIEW2() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEEDITVIEW2");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09");
        pSDEFGroupModel.setUserTag("DEEDITVIEW2");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u4f20\u5165\u7236\u952e\u8f6c\u6362\u4e3a\u5f53\u524d\u952e\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3608091c9b8e45f61407b626937c02bd");
        pSDEFGroupDetailModel.setName("VIEWPARAM4");
        iPSDEFieldModel = this.getDEField("VIEWPARAM4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.EditViewMultiFormModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65704");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u7f16\u8f91\u89c6\u56fe\u662f\u5426\u9690\u85cf\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEEDITVIEW3() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEEDITVIEW3");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09");
        pSDEFGroupModel.setUserTag("DEEDITVIEW3");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u4f20\u5165\u7236\u952e\u8f6c\u6362\u4e3a\u5f53\u524d\u952e\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3608091c9b8e45f61407b626937c02bd");
        pSDEFGroupDetailModel.setName("VIEWPARAM4");
        iPSDEFieldModel = this.getDEField("VIEWPARAM4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.EditViewMultiFormModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65704");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u7f16\u8f91\u89c6\u56fe\u662f\u5426\u9690\u85cf\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEEDITVIEW4() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEEDITVIEW4");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u4e0a\u4e0b\u5173\u7cfb\uff09");
        pSDEFGroupModel.setUserTag("DEEDITVIEW4");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u4f20\u5165\u7236\u952e\u8f6c\u6362\u4e3a\u5f53\u524d\u952e\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u7f16\u8f91\u89c6\u56fe\u662f\u5426\u9690\u85cf\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEEDITVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEEDITVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u7f16\u8f91\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEEDITVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u4f20\u5165\u7236\u952e\u8f6c\u6362\u4e3a\u5f53\u524d\u952e\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEFORMPICKUPDATAVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEFORMPICKUPDATAVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u8868\u5355\u9009\u62e9\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEFORMPICKUPDATAVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEGANTTEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEGANTTEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u7518\u7279\u56fe\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEGANTTEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8996c1b6cd9905e912670edf8b019f54");
        pSDEFGroupDetailModel.setName("VIEWPARAM8");
        iPSDEFieldModel = this.getDEField("VIEWPARAM8", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ExpBarPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u5bfc\u822a\u680f\u7684\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u684c\u9762\u7aef\u89c6\u56fe\u653e\u7f6e\u5de6\u4fa7\uff0c\u79fb\u52a8\u7aef\u89c6\u56fe\u653e\u7f6e\u4e0a\u65b9");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEGANTTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEGANTTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u7518\u7279\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEGANTTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEGANTTVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEGANTTVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u7518\u7279\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEGANTTVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEGRIDEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEGRIDEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u8868\u683c\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEGRIDEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eeadce576ff46f5d303daf0885dbfc89");
        pSDEFGroupDetailModel.setName("VIEWPARAM11");
        iPSDEFieldModel = this.getDEField("VIEWPARAM11", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8996c1b6cd9905e912670edf8b019f54");
        pSDEFGroupDetailModel.setName("VIEWPARAM8");
        iPSDEFieldModel = this.getDEField("VIEWPARAM8", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ExpBarPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u5bfc\u822a\u680f\u7684\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u684c\u9762\u7aef\u89c6\u56fe\u653e\u7f6e\u5de6\u4fa7\uff0c\u79fb\u52a8\u7aef\u89c6\u56fe\u653e\u7f6e\u4e0a\u65b9");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEGRIDVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEGRIDVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u8868\u683c\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEGRIDVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0335283c277b7d521bbc46a3d3b35572");
        pSDEFGroupDetailModel.setName("VIEWPARAM3");
        iPSDEFieldModel = this.getDEField("VIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5f00\u542f\u884c\u7f16\u8f91\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEGRIDVIEW2() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEGRIDVIEW2");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u8868\u683c\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09");
        pSDEFGroupModel.setUserTag("DEGRIDVIEW2");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0335283c277b7d521bbc46a3d3b35572");
        pSDEFGroupDetailModel.setName("VIEWPARAM3");
        iPSDEFieldModel = this.getDEField("VIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5f00\u542f\u884c\u7f16\u8f91\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEGRIDVIEW4() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEGRIDVIEW4");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u8868\u683c\u89c6\u56fe\uff08\u4e0a\u4e0b\u5173\u7cfb\uff09");
        pSDEFGroupModel.setUserTag("DEGRIDVIEW4");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0335283c277b7d521bbc46a3d3b35572");
        pSDEFGroupDetailModel.setName("VIEWPARAM3");
        iPSDEFieldModel = this.getDEField("VIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5f00\u542f\u884c\u7f16\u8f91\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEGRIDVIEW8() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEGRIDVIEW8");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5173\u7cfb\u6570\u636e\u8868\u683c\u89c6\u56fe\uff08\u5d4c\u5165\uff09");
        pSDEFGroupModel.setUserTag("DEGRIDVIEW8");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0335283c277b7d521bbc46a3d3b35572");
        pSDEFGroupDetailModel.setName("VIEWPARAM3");
        iPSDEFieldModel = this.getDEField("VIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5f00\u542f\u884c\u7f16\u8f91\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEGRIDVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEGRIDVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u8868\u683c\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEGRIDVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0335283c277b7d521bbc46a3d3b35572");
        pSDEFGroupDetailModel.setName("VIEWPARAM3");
        iPSDEFieldModel = this.getDEField("VIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u683c\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5f00\u542f\u884c\u7f16\u8f91\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEHTMLVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEHTMLVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53HTML\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEHTMLVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e31fe74b1c7c32dd9172d03b56f71d28");
        pSDEFGroupDetailModel.setName("BOTTOMINFO");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("BOTTOMINFO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9aHTML\u89c6\u56fe\u7684Html\u8def\u5f84");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEINDEXPICKUPDATAVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEINDEXPICKUPDATAVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb\u9009\u62e9\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEINDEXPICKUPDATAVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEINDEXVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEINDEXVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u9996\u9875\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEINDEXVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0214e9899ca4b6784d8c30c0bc4acc1c");
        pSDEFGroupDetailModel.setName("VIEWPARAM13");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM13", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.EditViewMarkOpenDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEKANBANVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEKANBANVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u770b\u677f\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEKANBANVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEKANBANVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEKANBANVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u770b\u677f\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEKANBANVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DELISTEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DELISTEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5217\u8868\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DELISTEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8996c1b6cd9905e912670edf8b019f54");
        pSDEFGroupDetailModel.setName("VIEWPARAM8");
        iPSDEFieldModel = this.getDEField("VIEWPARAM8", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ExpBarPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u5bfc\u822a\u680f\u7684\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u684c\u9762\u7aef\u89c6\u56fe\u653e\u7f6e\u5de6\u4fa7\uff0c\u79fb\u52a8\u7aef\u89c6\u56fe\u653e\u7f6e\u4e0a\u65b9");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DELISTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DELISTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5217\u8868\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DELISTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DELISTVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DELISTVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5217\u8868\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DELISTVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMAPEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMAPEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5730\u56fe\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMAPEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8996c1b6cd9905e912670edf8b019f54");
        pSDEFGroupDetailModel.setName("VIEWPARAM8");
        iPSDEFieldModel = this.getDEField("VIEWPARAM8", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ExpBarPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u5bfc\u822a\u680f\u7684\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u684c\u9762\u7aef\u89c6\u56fe\u653e\u7f6e\u5de6\u4fa7\uff0c\u79fb\u52a8\u7aef\u89c6\u56fe\u653e\u7f6e\u4e0a\u65b9");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMAPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMAPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5730\u56fe\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMAPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMAPVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMAPVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5730\u56fe\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMAPVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMDCUSTOMVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMDCUSTOMVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u591a\u6570\u636e\u81ea\u5b9a\u4e49\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMDCUSTOMVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMEDITVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMEDITVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u591a\u8868\u5355\u7f16\u8f91\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMEDITVIEW9");
        pSDEFGroupModel.setMemo("");
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBCALENDAREXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBCALENDAREXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u65e5\u5386\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBCALENDAREXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBCALENDARVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBCALENDARVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u65e5\u5386\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBCALENDARVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBCALENDARVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBCALENDARVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u65e5\u5386\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBCALENDARVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBCHARTEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBCHARTEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u56fe\u8868\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBCHARTEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBCHARTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBCHARTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u56fe\u8868\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBCHARTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBCHARTVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBCHARTVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u56fe\u8868\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBCHARTVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBCUSTOMVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBCUSTOMVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u81ea\u5b9a\u4e49\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBCUSTOMVIEW");
        pSDEFGroupModel.setMemo("");
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBDATAVIEWEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBDATAVIEWEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5361\u7247\u89c6\u56fe\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBDATAVIEWEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBEDITVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBEDITVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u7f16\u8f91\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBEDITVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u4f20\u5165\u7236\u952e\u8f6c\u6362\u4e3a\u5f53\u524d\u952e\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3608091c9b8e45f61407b626937c02bd");
        pSDEFGroupDetailModel.setName("VIEWPARAM4");
        iPSDEFieldModel = this.getDEField("VIEWPARAM4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.EditViewMultiFormModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65704");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBEDITVIEW3() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBEDITVIEW3");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u7f16\u8f91\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09");
        pSDEFGroupModel.setUserTag("DEMOBEDITVIEW3");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u4f20\u5165\u7236\u952e\u8f6c\u6362\u4e3a\u5f53\u524d\u952e\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3608091c9b8e45f61407b626937c02bd");
        pSDEFGroupDetailModel.setName("VIEWPARAM4");
        iPSDEFieldModel = this.getDEField("VIEWPARAM4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.EditViewMultiFormModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65704");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBEDITVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBEDITVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u7f16\u8f91\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBEDITVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u4f20\u5165\u7236\u952e\u8f6c\u6362\u4e3a\u5f53\u524d\u952e\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3608091c9b8e45f61407b626937c02bd");
        pSDEFGroupDetailModel.setName("VIEWPARAM4");
        iPSDEFieldModel = this.getDEField("VIEWPARAM4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.EditViewMultiFormModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65704");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBFORMPICKUPMDVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBFORMPICKUPMDVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u8868\u5355\u7c7b\u578b\u9009\u62e9\u591a\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBFORMPICKUPMDVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBGANTTEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBGANTTEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u7518\u7279\u56fe\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBGANTTEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBGANTTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBGANTTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u7518\u7279\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBGANTTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBGANTTVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBGANTTVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u7518\u7279\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBGANTTVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBHTMLVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBHTMLVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aefHTML\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBHTMLVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e31fe74b1c7c32dd9172d03b56f71d28");
        pSDEFGroupDetailModel.setName("BOTTOMINFO");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("BOTTOMINFO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9aHTML\u89c6\u56fe\u7684Html\u8def\u5f84");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBINDEXPICKUPMDVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBINDEXPICKUPMDVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u7d22\u5f15\u7c7b\u578b\u9009\u62e9\u591a\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBINDEXPICKUPMDVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBLISTEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBLISTEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5217\u8868\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBLISTEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBLISTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBLISTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5217\u8868\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBLISTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBMAPEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBMAPEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5730\u56fe\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBMAPEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBMAPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBMAPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5730\u56fe\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBMAPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBMAPVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBMAPVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5730\u56fe\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBMAPVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBMDVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBMDVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u591a\u6570\u636e\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBMDVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBMDVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBMDVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u591a\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBMDVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBMEDITVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBMEDITVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u591a\u8868\u5355\u7f16\u8f91\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBMEDITVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBMPICKUPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBMPICKUPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u591a\u6570\u636e\u9009\u62e9\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBMPICKUPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u9009\u4e2d\u7684\u6570\u636e\u8fdb\u884c\u8f6c\u6362\u8fd4\u56de\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBOPTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBOPTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u9009\u9879\u64cd\u4f5c\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBOPTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBPANELVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBPANELVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u9762\u677f\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBPANELVIEW");
        pSDEFGroupModel.setMemo("");
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBPANELVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBPANELVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u9762\u677f\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBPANELVIEW9");
        pSDEFGroupModel.setMemo("");
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBPICKUPLISTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBPICKUPLISTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u9009\u62e9\u5217\u8868\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBPICKUPLISTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBPICKUPMDVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBPICKUPMDVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u9009\u62e9\u591a\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBPICKUPMDVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBPICKUPTREEVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBPICKUPTREEVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u9009\u62e9\u6811\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBPICKUPTREEVIEW");
        pSDEFGroupModel.setMemo("");
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBPICKUPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBPICKUPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u6570\u636e\u9009\u62e9\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBPICKUPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u9009\u4e2d\u7684\u6570\u636e\u8fdb\u884c\u8f6c\u6362\u8fd4\u56de\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBPORTALVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBPORTALVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u6570\u636e\u770b\u677f\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBPORTALVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBPORTALVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBPORTALVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u6570\u636e\u770b\u677f\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBPORTALVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBREDIRECTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBREDIRECTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBREDIRECTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u91cd\u5b9a\u5411\u89c6\u56fe\u662f\u5426\u652f\u6301\u5de5\u4f5c\u6d41\u89c6\u56fe\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBREPORTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBREPORTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u62a5\u8868\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBREPORTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBTABEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBTABEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5206\u9875\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBTABEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8faebbefc7015e50a20f9212418c4710");
        pSDEFGroupDetailModel.setName("VIEWPARAM7");
        iPSDEFieldModel = this.getDEField("VIEWPARAM7", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TabViewTabPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5206\u9875\u89c6\u56fe\u5206\u9875\u680f\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u4e0a\u65b9\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBTABEXPVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBTABEXPVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5206\u9875\u5bfc\u822a\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBTABEXPVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8faebbefc7015e50a20f9212418c4710");
        pSDEFGroupDetailModel.setName("VIEWPARAM7");
        iPSDEFieldModel = this.getDEField("VIEWPARAM7", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TabViewTabPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5206\u9875\u89c6\u56fe\u5206\u9875\u680f\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u4e0a\u65b9\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBTABSEARCHVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBTABSEARCHVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5206\u9875\u641c\u7d22\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBTABSEARCHVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8faebbefc7015e50a20f9212418c4710");
        pSDEFGroupDetailModel.setName("VIEWPARAM7");
        iPSDEFieldModel = this.getDEField("VIEWPARAM7", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TabViewTabPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5206\u9875\u89c6\u56fe\u5206\u9875\u680f\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u4e0a\u65b9\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBTABSEARCHVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBTABSEARCHVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5206\u9875\u641c\u7d22\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBTABSEARCHVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8faebbefc7015e50a20f9212418c4710");
        pSDEFGroupDetailModel.setName("VIEWPARAM7");
        iPSDEFieldModel = this.getDEField("VIEWPARAM7", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TabViewTabPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5206\u9875\u89c6\u56fe\u5206\u9875\u680f\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u4e0a\u65b9\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBTREEEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBTREEEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u6811\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBTREEEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBTREEEXPVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBTREEEXPVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u6811\u5bfc\u822a\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEMOBTREEEXPVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBTREEVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBTREEVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u6811\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBTREEVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBWFACTIONVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBWFACTIONVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u64cd\u4f5c\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBWFACTIONVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7b7376a062ef1747c55e6901d4e3441");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM4");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.WFUtilUIActionTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65704");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBWFDATAREDIRECTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBWFDATAREDIRECTVIEW");
        pSDEFGroupModel.setName("\u79fb\u52a8\u7aef\u5b9e\u4f53\u5168\u5c40\u6d41\u7a0b\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBWFDATAREDIRECTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u91cd\u5b9a\u5411\u89c6\u56fe\u662f\u5426\u652f\u6301\u5de5\u4f5c\u6d41\u89c6\u56fe\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBWFDYNAACTIONVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBWFDYNAACTIONVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u52a8\u6001\u64cd\u4f5c\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBWFDYNAACTIONVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7b7376a062ef1747c55e6901d4e3441");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM4");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.WFUtilUIActionTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65704");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBWFDYNAEDITVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBWFDYNAEDITVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u52a8\u6001\u7f16\u8f91\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBWFDYNAEDITVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51409c0e9dfe03118f7070aaad1cd3a3");
        pSDEFGroupDetailModel.setName("DYNCMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DYNCMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("31cf583ffead0dc6c269b85b3dea8a15");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6288968d0a372e4e46262723d63fbb7c");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM3");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65703");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBWFDYNAEDITVIEW3() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBWFDYNAEDITVIEW3");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u52a8\u6001\u7f16\u8f91\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09");
        pSDEFGroupModel.setUserTag("DEMOBWFDYNAEDITVIEW3");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51409c0e9dfe03118f7070aaad1cd3a3");
        pSDEFGroupDetailModel.setName("DYNCMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DYNCMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("31cf583ffead0dc6c269b85b3dea8a15");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6288968d0a372e4e46262723d63fbb7c");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM3");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65703");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBWFDYNAEXPMDVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBWFDYNAEXPMDVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u52a8\u6001\u5bfc\u822a\u591a\u6570\u636e\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBWFDYNAEXPMDVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51409c0e9dfe03118f7070aaad1cd3a3");
        pSDEFGroupDetailModel.setName("DYNCMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DYNCMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("31cf583ffead0dc6c269b85b3dea8a15");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6288968d0a372e4e46262723d63fbb7c");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM3");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65703");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBWFDYNASTARTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBWFDYNASTARTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u52a8\u6001\u542f\u52a8\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBWFDYNASTARTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBWFEDITVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBWFEDITVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBWFEDITVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51409c0e9dfe03118f7070aaad1cd3a3");
        pSDEFGroupDetailModel.setName("DYNCMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DYNCMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("31cf583ffead0dc6c269b85b3dea8a15");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6288968d0a372e4e46262723d63fbb7c");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM3");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65703");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBWFEDITVIEW3() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBWFEDITVIEW3");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09");
        pSDEFGroupModel.setUserTag("DEMOBWFEDITVIEW3");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51409c0e9dfe03118f7070aaad1cd3a3");
        pSDEFGroupDetailModel.setName("DYNCMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DYNCMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("31cf583ffead0dc6c269b85b3dea8a15");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6288968d0a372e4e46262723d63fbb7c");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM3");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65703");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBWFMDVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBWFMDVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u591a\u6570\u636e\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBWFMDVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51409c0e9dfe03118f7070aaad1cd3a3");
        pSDEFGroupDetailModel.setName("DYNCMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DYNCMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("31cf583ffead0dc6c269b85b3dea8a15");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6288968d0a372e4e46262723d63fbb7c");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM3");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65703");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBWFPROXYRESULTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBWFPROXYRESULTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u4ee3\u7406\u5e94\u7528\u7ed3\u679c\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBWFPROXYRESULTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBWFPROXYSTARTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBWFPROXYSTARTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u4ee3\u7406\u5e94\u7528\u542f\u52a8\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBWFPROXYSTARTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBWFSTARTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBWFSTARTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5de5\u4f5c\u6d41\u542f\u52a8\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBWFSTARTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51409c0e9dfe03118f7070aaad1cd3a3");
        pSDEFGroupDetailModel.setName("DYNCMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DYNCMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d6ff9e6697aa400187f6eec503b83b4d");
        pSDEFGroupDetailModel.setName("VIEWPARAM9");
        iPSDEFieldModel = this.getDEField("VIEWPARAM9", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u652f\u6301\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u62c9\u5237\u65b0\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMOBWIZARDVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMOBWIZARDVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u79fb\u52a8\u7aef\u5411\u5bfc\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMOBWIZARDVIEW");
        pSDEFGroupModel.setMemo("");
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMPICKUPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMPICKUPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6570\u636e\u591a\u9879\u9009\u62e9\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEMPICKUPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u9009\u4e2d\u7684\u6570\u636e\u8fdb\u884c\u8f6c\u6362\u8fd4\u56de\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEMPICKUPVIEW2() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEMPICKUPVIEW2");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u591a\u9879\u6570\u636e\u9009\u62e9\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09");
        pSDEFGroupModel.setUserTag("DEMPICKUPVIEW2");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u9009\u4e2d\u7684\u6570\u636e\u8fdb\u884c\u8f6c\u6362\u8fd4\u56de\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEOPTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEOPTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u9009\u9879\u64cd\u4f5c\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEOPTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5355\u6570\u636e\u89c6\u56fe\u662f\u5426\u663e\u793a\u5f53\u524d\u6570\u636e\u4fe1\u606f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEPANELVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEPANELVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u9762\u677f\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEPANELVIEW");
        pSDEFGroupModel.setMemo("");
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEPANELVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEPANELVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u9762\u677f\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEPANELVIEW9");
        pSDEFGroupModel.setMemo("");
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEPICKUPDATAVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEPICKUPDATAVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u9009\u62e9\u6570\u636e\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEPICKUPDATAVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEPICKUPGRIDVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEPICKUPGRIDVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u9009\u62e9\u8868\u683c\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEPICKUPGRIDVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEPICKUPTREEVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEPICKUPTREEVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u9009\u62e9\u6811\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEPICKUPTREEVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEPICKUPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEPICKUPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6570\u636e\u9009\u62e9\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEPICKUPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u9009\u4e2d\u7684\u6570\u636e\u8fdb\u884c\u8f6c\u6362\u8fd4\u56de\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEPICKUPVIEW2() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEPICKUPVIEW2");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6570\u636e\u9009\u62e9\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09");
        pSDEFGroupModel.setUserTag("DEPICKUPVIEW2");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u9009\u4e2d\u7684\u6570\u636e\u8fdb\u884c\u8f6c\u6362\u8fd4\u56de\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEPICKUPVIEW3() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEPICKUPVIEW3");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6570\u636e\u9009\u62e9\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09");
        pSDEFGroupModel.setUserTag("DEPICKUPVIEW3");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u5c06\u9009\u4e2d\u7684\u6570\u636e\u8fdb\u884c\u8f6c\u6362\u8fd4\u56de\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEPORTALVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEPORTALVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6570\u636e\u770b\u677f\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEPORTALVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEPORTALVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEPORTALVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6570\u636e\u770b\u677f\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEPORTALVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEREDIRECTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEREDIRECTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEREDIRECTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u91cd\u5b9a\u5411\u89c6\u56fe\u8bc6\u522b\u5c5e\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u91cd\u5b9a\u5411\u89c6\u56fe\u662f\u5426\u652f\u6301\u5de5\u4f5c\u6d41\u89c6\u56fe\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u91cd\u5b9a\u5411\u89c6\u56fe\u83b7\u53d6\u6570\u636e\u64cd\u4f5c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8996c1b6cd9905e912670edf8b019f54");
        pSDEFGroupDetailModel.setName("VIEWPARAM8");
        iPSDEFieldModel = this.getDEField("VIEWPARAM8", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u91cd\u5b9a\u5411\u89c6\u56fe\u83b7\u53d6\u6570\u636e\u884c\u4e3a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEREPORTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEREPORTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u62a5\u8868\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEREPORTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DETABEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DETABEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5206\u9875\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DETABEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8faebbefc7015e50a20f9212418c4710");
        pSDEFGroupDetailModel.setName("VIEWPARAM7");
        iPSDEFieldModel = this.getDEField("VIEWPARAM7", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TabViewTabPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5206\u9875\u89c6\u56fe\u5206\u9875\u680f\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u4e0a\u65b9\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DETABEXPVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DETABEXPVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5206\u9875\u5bfc\u822a\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DETABEXPVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8faebbefc7015e50a20f9212418c4710");
        pSDEFGroupDetailModel.setName("VIEWPARAM7");
        iPSDEFieldModel = this.getDEField("VIEWPARAM7", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TabViewTabPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5206\u9875\u89c6\u56fe\u5206\u9875\u680f\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u4e0a\u65b9\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DETABSEARCHVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DETABSEARCHVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5206\u9875\u641c\u7d22\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DETABSEARCHVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8faebbefc7015e50a20f9212418c4710");
        pSDEFGroupDetailModel.setName("VIEWPARAM7");
        iPSDEFieldModel = this.getDEField("VIEWPARAM7", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TabViewTabPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5206\u9875\u89c6\u56fe\u5206\u9875\u680f\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u4e0a\u65b9\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DETABSEARCHVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DETABSEARCHVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5206\u9875\u641c\u7d22\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DETABSEARCHVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8faebbefc7015e50a20f9212418c4710");
        pSDEFGroupDetailModel.setName("VIEWPARAM7");
        iPSDEFieldModel = this.getDEField("VIEWPARAM7", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TabViewTabPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5206\u9875\u89c6\u56fe\u5206\u9875\u680f\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u4e0a\u65b9\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DETREEEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DETREEEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6811\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DETREEEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8996c1b6cd9905e912670edf8b019f54");
        pSDEFGroupDetailModel.setName("VIEWPARAM8");
        iPSDEFieldModel = this.getDEField("VIEWPARAM8", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ExpBarPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u5bfc\u822a\u680f\u7684\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u684c\u9762\u7aef\u89c6\u56fe\u653e\u7f6e\u5de6\u4fa7\uff0c\u79fb\u52a8\u7aef\u89c6\u56fe\u653e\u7f6e\u4e0a\u65b9");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DETREEEXPVIEW2() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DETREEEXPVIEW2");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6811\u5bfc\u822a\u89c6\u56fe\uff08IFrame\uff09");
        pSDEFGroupModel.setUserTag("DETREEEXPVIEW2");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DETREEEXPVIEW3() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DETREEEXPVIEW3");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6811\u5bfc\u822a\u89c6\u56fe\uff08\u83dc\u5355\u6a21\u5f0f\uff09");
        pSDEFGroupModel.setUserTag("DETREEEXPVIEW3");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5bfc\u822a\u89c6\u56fe\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DETREEGRIDEXVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DETREEGRIDEXVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6811\u8868\u683c\u89c6\u56fe\uff08\u589e\u5f3a\uff09");
        pSDEFGroupModel.setUserTag("DETREEGRIDEXVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DETREEGRIDEXVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DETREEGRIDEXVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6811\u8868\u683c\u89c6\u56fe\uff08\u589e\u5f3a\uff09\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DETREEGRIDEXVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DETREEGRIDVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DETREEGRIDVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6811\u8868\u683c\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DETREEGRIDVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DETREEVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DETREEVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6811\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DETREEVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DETREEVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DETREEVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u6811\u89c6\u56fe\uff08\u90e8\u4ef6\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DETREEVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFACTIONVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFACTIONVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u64cd\u4f5c\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEWFACTIONVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7b7376a062ef1747c55e6901d4e3441");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM4");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.WFUtilUIActionTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65704");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFDATAREDIRECTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFDATAREDIRECTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5168\u5c40\u6d41\u7a0b\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEWFDATAREDIRECTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u91cd\u5b9a\u5411\u89c6\u56fe\u662f\u5426\u652f\u6301\u5de5\u4f5c\u6d41\u89c6\u56fe\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFDYNAACTIONVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFDYNAACTIONVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u52a8\u6001\u64cd\u4f5c\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEWFDYNAACTIONVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7b7376a062ef1747c55e6901d4e3441");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM4");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM4", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.WFUtilUIActionTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65704");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFDYNAEDITVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFDYNAEDITVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u52a8\u6001\u7f16\u8f91\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEWFDYNAEDITVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFDYNAEDITVIEW3() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFDYNAEDITVIEW3");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u52a8\u6001\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09");
        pSDEFGroupModel.setUserTag("DEWFDYNAEDITVIEW3");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u7f16\u8f91\u89c6\u56fe\u662f\u5426\u9690\u85cf\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFDYNAEXPGRIDVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFDYNAEXPGRIDVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u52a8\u6001\u5bfc\u822a\u8868\u683c\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEWFDYNAEXPGRIDVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFDYNASTARTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFDYNASTARTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u52a8\u6001\u542f\u52a8\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEWFDYNASTARTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFEDITVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFEDITVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEWFEDITVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51409c0e9dfe03118f7070aaad1cd3a3");
        pSDEFGroupDetailModel.setName("DYNCMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DYNCMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("31cf583ffead0dc6c269b85b3dea8a15");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6288968d0a372e4e46262723d63fbb7c");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM3");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65703");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFEDITVIEW2() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFEDITVIEW2");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u89c6\u56fe\uff08\u5de6\u53f3\u5173\u7cfb\uff09");
        pSDEFGroupModel.setUserTag("DEWFEDITVIEW2");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51409c0e9dfe03118f7070aaad1cd3a3");
        pSDEFGroupDetailModel.setName("DYNCMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DYNCMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u7f16\u8f91\u89c6\u56fe\u662f\u5426\u9690\u85cf\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("31cf583ffead0dc6c269b85b3dea8a15");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6288968d0a372e4e46262723d63fbb7c");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM3");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65703");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFEDITVIEW3() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFEDITVIEW3");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\uff08\u5206\u9875\u5173\u7cfb\uff09");
        pSDEFGroupModel.setUserTag("DEWFEDITVIEW3");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51409c0e9dfe03118f7070aaad1cd3a3");
        pSDEFGroupDetailModel.setName("DYNCMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DYNCMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u7f16\u8f91\u89c6\u56fe\u662f\u5426\u9690\u85cf\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("31cf583ffead0dc6c269b85b3dea8a15");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6288968d0a372e4e46262723d63fbb7c");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM3");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65703");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFEDITVIEW9() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFEDITVIEW9");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\uff08\u5d4c\u5165\u89c6\u56fe\uff09");
        pSDEFGroupModel.setUserTag("DEWFEDITVIEW9");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u7f16\u8f91\u89c6\u56fe\u662f\u5426\u9690\u85cf\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("31cf583ffead0dc6c269b85b3dea8a15");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6288968d0a372e4e46262723d63fbb7c");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM3");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65703");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFEXPVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFEXPVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bfc\u822a\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEWFEXPVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51409c0e9dfe03118f7070aaad1cd3a3");
        pSDEFGroupDetailModel.setName("DYNCMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DYNCMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFGRIDVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFGRIDVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u8868\u683c\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEWFGRIDVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51409c0e9dfe03118f7070aaad1cd3a3");
        pSDEFGroupDetailModel.setName("DYNCMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DYNCMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("646a9c180d63ea3c5d72a1e20d4db53f");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTID");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ed4472d907aa35708e89f7b1718a65dc");
        pSDEFGroupDetailModel.setName("GROUPPSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("GROUPPSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u5feb\u901f\u5206\u7ec4\u63d0\u4f9b\u9884\u7f6e\u6761\u4ef6\u67e5\u8be2\u53ca\u8ba1\u6570\u80fd\u529b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eaaa7e24b62ecde7807e508c56a03094");
        pSDEFGroupDetailModel.setName("LOADDEFAULT");
        iPSDEFieldModel = this.getDEField("LOADDEFAULT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u9ed8\u8ba4\u52a0\u8f7d\u89c6\u56fe\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u7c7b\u578b\u89c6\u56fe\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6dcd3bba666a0098ac5bc442430681e6");
        pSDEFGroupDetailModel.setName("VIEWPARAM");
        iPSDEFieldModel = this.getDEField("VIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewNewDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u65b0\u5efa\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ab5de7c966c5631ad77de1c06f4e6caf");
        pSDEFGroupDetailModel.setName("VIEWPARAM10");
        iPSDEFieldModel = this.getDEField("VIEWPARAM10", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u89c6\u56fe\u6216\u591a\u6570\u636e\u89c6\u56fe\u662f\u5426\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u7ea6\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("933b2be794930f6a5d58db01b597e3f7");
        pSDEFGroupDetailModel.setName("VIEWPARAM2");
        iPSDEFieldModel = this.getDEField("VIEWPARAM2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEGridViewEditDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u89c6\u56fe\u7684\u7f16\u8f91\u6570\u636e\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u5b9e\u4f53\u7c7b\u578b\u9ed8\u8ba4\u5904\u7406");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u591a\u9879\u89c6\u56fe\u7684\u5feb\u901f\u641c\u7d22\u529f\u80fd\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d3939dd57d141e8017ac05ebdbfd9caa");
        pSDEFGroupDetailModel.setName("VIEWPARAM6");
        iPSDEFieldModel = this.getDEField("VIEWPARAM6", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridViewRowActiveModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6fc0\u6d3b\u6570\u636e\u662f\u6307\u6267\u884c\u9009\u4e2d\u6570\u636e\u7684\u9ed8\u8ba4\u903b\u8f91\uff0c\u5982\u6253\u5f00\u89c6\u56fe\u3002\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u9ed8\u8ba4\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("31cf583ffead0dc6c269b85b3dea8a15");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6288968d0a372e4e46262723d63fbb7c");
        pSDEFGroupDetailModel.setName("WFVIEWPARAM3");
        iPSDEFieldModel = this.getDEField("WFVIEWPARAM3", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5de5\u4f5c\u6d41\u89c6\u56fe\u53c2\u65703");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFPROXYDATAREDIRECTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFPROXYDATAREDIRECTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u4ee3\u7406\u6570\u636e\u91cd\u5b9a\u5411\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEWFPROXYDATAREDIRECTVIEW");
        pSDEFGroupModel.setMemo("");
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFPROXYDATAVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFPROXYDATAVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u4ee3\u7406\u6570\u636e\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEWFPROXYDATAVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFPROXYRESULTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFPROXYRESULTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u4ee3\u7406\u5e94\u7528\u7ed3\u679c\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEWFPROXYRESULTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFPROXYSTARTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFPROXYSTARTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u4ee3\u7406\u5e94\u7528\u542f\u52a8\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEWFPROXYSTARTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWFSTARTVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWFSTARTVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5de5\u4f5c\u6d41\u542f\u52a8\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEWFSTARTVIEW");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51409c0e9dfe03118f7070aaad1cd3a3");
        pSDEFGroupDetailModel.setName("DYNCMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("DYNCMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.AppViewPriorityCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u63d2\u4ef6\u5e94\u7528\u6a21\u5f0f\u4e0b\u7684\u89c6\u56fe\u4f18\u5148\u7ea7");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4aa751038d50bc67bf85a128f2711741");
        pSDEFGroupDetailModel.setName("PSWFDEID");
        iPSDEFieldModel = this.getDEField("PSWFDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("541f0d8cebb4204f1b71d9899306fce2");
        pSDEFGroupDetailModel.setName("PSWFDENAME");
        iPSDEFieldModel = this.getDEField("PSWFDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61\uff0c\u5de5\u4f5c\u6d41\u89c6\u56fe\u4e00\u822c\u90fd\u7531\u6d41\u7a0b\u7248\u672c\u81ea\u52a8\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a7a33d08d19703b5724a078fae7a9b34");
        pSDEFGroupDetailModel.setName("VIEWPARAM5");
        iPSDEFieldModel = this.getDEField("VIEWPARAM5", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u53c2\u65705");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DEWIZARDVIEW() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DEWIZARDVIEW");
        pSDEFGroupModel.setName("\u5b9e\u4f53\u5411\u5bfc\u89c6\u56fe");
        pSDEFGroupModel.setUserTag("DEWIZARDVIEW");
        pSDEFGroupModel.setMemo("");
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel__DEFAULT() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("_DEFAULT");
        pSDEFGroupModel.setName("\u901a\u7528");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("27682ba0fe2a141fa00fb4ec949aa789");
        pSDEFGroupDetailModel.setName("ACCUSERMODE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("ACCUSERMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ViewAccessUsersCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6388\u6743\u8bbf\u95ee\u8be5\u89c6\u56fe\u7684\u7528\u6237\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u767b\u5f55\u7528\u6237\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("15e3e27db3753ca0f5a29ec7c33f8543");
        pSDEFGroupDetailModel.setName("CAPPSLANRESID");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("58f9c01b5df4ee0dce170a5ffe53a5e8");
        pSDEFGroupDetailModel.setName("CAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("46bbf178060ad1c78336e3ce458fba23");
        pSDEFGroupDetailModel.setName("CAPTION");
        iPSDEFieldModel = this.getDEField("CAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u5b9e\u4f53\u7684\u6807\u9898");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ecd95d4a30798980b3b6876cd93b0d58");
        pSDEFGroupDetailModel.setName("CODENAME");
        iPSDEFieldModel = this.getDEField("CODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u4ee3\u7801\u6807\u8bc6\uff0c\u9700\u8981\u5728\u6240\u5728\u7684\u5b9e\u4f53\u4e2d\u5177\u6709\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("666a948ebf493fdffea2c5806195bb4a");
        pSDEFGroupDetailModel.setName("ENABLEVIEWACTIONS");
        iPSDEFieldModel = this.getDEField("ENABLEVIEWACTIONS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u662f\u5426\u542f\u7528\u89c6\u56fe\u64cd\u4f5c\u63a7\u5236\uff0c\u542f\u7528\u89c6\u56fe\u64cd\u4f5c\u63a7\u5236\u9700\u8981\u663e\u793a\u6307\u5b9a\u89c6\u56fe\u652f\u6301\u54ea\u4e9b\u64cd\u4f5c\u3002\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2ac49818ec53fb0f5525875bf3e40176");
        pSDEFGroupDetailModel.setName("HEIGHT");
        iPSDEFieldModel = this.getDEField("HEIGHT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u9ad8\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u30100\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b6f095db6460d0229ebe734316ce81be");
        pSDEFGroupDetailModel.setName("LOCKFLAG");
        iPSDEFieldModel = this.getDEField("LOCKFLAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ModelLockModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1b2d9ab97b6223dae919780a7fd9dc83");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5be49cf8e54782fe945de8797a42d05c");
        pSDEFGroupDetailModel.setName("OPENMODE");
        iPSDEFieldModel = this.getDEField("OPENMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEViewOpenModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u6253\u5f00\u65b9\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cd445eea935835d9b0a9994bbb148177");
        pSDEFGroupDetailModel.setName("PDVTPARAM");
        iPSDEFieldModel = this.getDEField("PDVTPARAM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5f53\u89c6\u56fe\u8bbe\u7f6e\u529f\u80fd\u89c6\u56fe\u6a21\u5f0f\u540e\u53ef\u8fdb\u4e00\u6b65\u6307\u5b9a\u76f8\u5e94\u7684\u529f\u80fd\u6a21\u5f0f\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("db86865951120fe0592aa6c581fc7184");
        pSDEFGroupDetailModel.setName("PSACHANDLERID");
        iPSDEFieldModel = this.getDEField("PSACHANDLERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u7684\u5904\u7406\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9e5870b51a142eb03f68c669d5235d5d");
        pSDEFGroupDetailModel.setName("PSACHANDLERNAME");
        iPSDEFieldModel = this.getDEField("PSACHANDLERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u7684\u5904\u7406\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c498473710b741e74d33857b4cfce372");
        pSDEFGroupDetailModel.setName("PSDEAWGROUPID");
        iPSDEFieldModel = this.getDEField("PSDEAWGROUPID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("addfdb3b8f4df731784d0b7999c68d2c");
        pSDEFGroupDetailModel.setName("PSDEAWGROUPNAME");
        iPSDEFieldModel = this.getDEField("PSDEAWGROUPNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("feebb339ef77a80ec858de6061271e24");
        pSDEFGroupDetailModel.setName("PSDEID");
        iPSDEFieldModel = this.getDEField("PSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u6240\u5728\u7684\u5b9e\u4f53\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("128610243a04a0ef32feaa0baaee4798");
        pSDEFGroupDetailModel.setName("PSDEMAINSTATEID");
        iPSDEFieldModel = this.getDEField("PSDEMAINSTATEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u5173\u8054\u7684\u4e3b\u72b6\u6001\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("618fca06260a99f2c364f19dc194b943");
        pSDEFGroupDetailModel.setName("PSDEMAINSTATENAME");
        iPSDEFieldModel = this.getDEField("PSDEMAINSTATENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u5173\u8054\u7684\u4e3b\u72b6\u6001\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9906caf7f403ac6b2a6c277a5464a0a4");
        pSDEFGroupDetailModel.setName("PSDENAME");
        iPSDEFieldModel = this.getDEField("PSDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u6240\u5728\u7684\u5b9e\u4f53\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("74102fa0875d6ba3484494fc33de8085");
        pSDEFGroupDetailModel.setName("PSDERID");
        iPSDEFieldModel = this.getDEField("PSDERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u63a7\u5236\u5173\u7cfb\u5bf9\u8c61\uff0c\u5982\u6307\u5b9a\u63a7\u5236\u5173\u7cfb\uff0c\u5219\u8981\u6c42\u89c6\u56fe\u53ea\u80fd\u5728\u5b58\u5728\u6b64\u5173\u7cfb\u7684\u573a\u5408\u4f7f\u7528\uff0c\u7b80\u5355\u7684\u8bf4\u5c31\u662f\u663e\u793a\u7279\u5b9a\u7236\u7684\u5173\u7cfb\u6570\u636e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3184d5badc636b79abb92e31a64317ad");
        pSDEFGroupDetailModel.setName("PSDERNAME");
        iPSDEFieldModel = this.getDEField("PSDERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u63a7\u5236\u5173\u7cfb\u5bf9\u8c61\uff0c\u5982\u6307\u5b9a\u63a7\u5236\u5173\u7cfb\uff0c\u5219\u8981\u6c42\u89c6\u56fe\u53ea\u80fd\u5728\u5b58\u5728\u6b64\u5173\u7cfb\u7684\u573a\u5408\u4f7f\u7528\uff0c\u7b80\u5355\u7684\u8bf4\u5c31\u662f\u663e\u793a\u7279\u5b9a\u7236\u7684\u5173\u7cfb\u6570\u636e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c693edc255cb68204bd9d9a2133d22c3");
        pSDEFGroupDetailModel.setName("PSDEVIEWBASENAME");
        iPSDEFieldModel = this.getDEField("PSDEVIEWBASENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u7684\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("15f22656aa6dc79c5f9c4bb9241a99c4");
        pSDEFGroupDetailModel.setName("PSDEVIEWBASETYPE");
        iPSDEFieldModel = this.getDEField("PSDEVIEWBASETYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEViewType2CodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u7684\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b1e6fb333f35be78fdc0004724a07e49");
        pSDEFGroupDetailModel.setName("PSHELPMODULEID");
        iPSDEFieldModel = this.getDEField("PSHELPMODULEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("15f44628342cb9a2e4ef302e7a377e95");
        pSDEFGroupDetailModel.setName("PSHELPMODULENAME");
        iPSDEFieldModel = this.getDEField("PSHELPMODULENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1def04b2296d3dc1352a87f59761fe63");
        pSDEFGroupDetailModel.setName("PSSUBVIEWTYPEID");
        iPSDEFieldModel = this.getDEField("PSSUBVIEWTYPEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u6837\u5f0f\uff0c\u89c6\u56fe\u6837\u5f0f\u652f\u6301\u6a21\u677f\u63d2\u4ef6\uff0c\u89c6\u56fe\u6837\u5f0f\u5728\u6807\u51c6\u89c6\u56fe\u7c7b\u578b\u7684\u57fa\u7840\u4e0a\u8fdb\u4e00\u6b65\u589e\u5f3a\u89c6\u56fe\u7684\u8868\u73b0\u6837\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("79ca7334b131bee25a4275627111a719");
        pSDEFGroupDetailModel.setName("PSSUBVIEWTYPENAME");
        iPSDEFieldModel = this.getDEField("PSSUBVIEWTYPENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u6837\u5f0f\uff0c\u89c6\u56fe\u6837\u5f0f\u652f\u6301\u6a21\u677f\u63d2\u4ef6\uff0c\u89c6\u56fe\u6837\u5f0f\u5728\u6807\u51c6\u89c6\u56fe\u7c7b\u578b\u7684\u57fa\u7840\u4e0a\u8fdb\u4e00\u6b65\u589e\u5f3a\u89c6\u56fe\u7684\u8868\u73b0\u6837\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5465e6c1fcdbccfa1df4782438dd94af");
        pSDEFGroupDetailModel.setName("PSSYSCOUNTERID");
        iPSDEFieldModel = this.getDEField("PSSYSCOUNTERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u9ed8\u8ba4\u52a0\u8f7d\u7684\u754c\u9762\u8ba1\u6570\u5668\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("191b527b852dcce1605a11ef4e4c20e9");
        pSDEFGroupDetailModel.setName("PSSYSCOUNTERNAME");
        iPSDEFieldModel = this.getDEField("PSSYSCOUNTERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u9ed8\u8ba4\u52a0\u8f7d\u7684\u754c\u9762\u8ba1\u6570\u5668\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c5199447d171178cda6d1e13d75f0669");
        pSDEFGroupDetailModel.setName("PSSYSCSSID");
        iPSDEFieldModel = this.getDEField("PSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u754c\u9762\u8868\uff0c\u754c\u9762\u6837\u5f0f\u8868\u5c06\u9644\u52a0\u5230\u89c6\u56fe\u7684\u9876\u7ea7\u5bb9\u5668\uff0c\u7ea6\u675f\u6574\u4f53\u754c\u9762\u5448\u73b0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("46275655490b91b86d689a98ba93e19a");
        pSDEFGroupDetailModel.setName("PSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("PSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u754c\u9762\u8868\uff0c\u754c\u9762\u6837\u5f0f\u8868\u5c06\u9644\u52a0\u5230\u89c6\u56fe\u7684\u9876\u7ea7\u5bb9\u5668\uff0c\u7ea6\u675f\u6574\u4f53\u754c\u9762\u5448\u73b0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("805ccad6c53e5e56981579eb64335f37");
        pSDEFGroupDetailModel.setName("PSSYSDYNAMODELID");
        iPSDEFieldModel = this.getDEField("PSSYSDYNAMODELID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("762bac1002cd8a9129cb8193c4475340");
        pSDEFGroupDetailModel.setName("PSSYSDYNAMODELNAME");
        iPSDEFieldModel = this.getDEField("PSSYSDYNAMODELNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("22e625210c5225bda3a551b41f19f494");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u663e\u793a\u56fe\u6807\uff0c\u672a\u5b9a\u4e49\u662f\u4f7f\u7528\u6240\u5728\u5b9e\u4f53\u7684\u9ed8\u8ba4\u56fe\u6807");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9f46304bad97fa3e09843c92ad871aa2");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u663e\u793a\u56fe\u6807\uff0c\u672a\u5b9a\u4e49\u662f\u4f7f\u7528\u6240\u5728\u5b9e\u4f53\u7684\u9ed8\u8ba4\u56fe\u6807");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("41b8e43c27a0b6189b8368a9212b0875");
        pSDEFGroupDetailModel.setName("PSSYSREQITEMID");
        iPSDEFieldModel = this.getDEField("PSSYSREQITEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d58e374975b30aa73c91b440e5feea16");
        pSDEFGroupDetailModel.setName("PSSYSREQITEMNAME");
        iPSDEFieldModel = this.getDEField("PSSYSREQITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ccf3eb10cfb9a6aa19acf47bde40bb90");
        pSDEFGroupDetailModel.setName("PSSYSUNIRESID");
        iPSDEFieldModel = this.getDEField("PSSYSUNIRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5b9e\u4f53\u89c6\u56fe\u8bbf\u95ee\u7528\u6237\u6a21\u5f0f\u8bbe\u7f6e\u4e3a\u9700\u8981\u62e5\u6709\u6307\u5b9a\u8d44\u6e90\u80fd\u529b\u65f6\uff0c\u6307\u5b9a\u76f8\u5e94\u7684\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("823a0561c735abfdb198f3cd0a33095f");
        pSDEFGroupDetailModel.setName("PSSYSUNIRESNAME");
        iPSDEFieldModel = this.getDEField("PSSYSUNIRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5b9e\u4f53\u89c6\u56fe\u8bbf\u95ee\u7528\u6237\u6a21\u5f0f\u8bbe\u7f6e\u4e3a\u9700\u8981\u62e5\u6709\u6307\u5b9a\u8d44\u6e90\u80fd\u529b\u65f6\uff0c\u6307\u5b9a\u76f8\u5e94\u7684\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d9e0ee2cbfe1b29581da17a2d539ac2c");
        pSDEFGroupDetailModel.setName("PSSYSVIEWPANELID");
        iPSDEFieldModel = this.getDEField("PSSYSVIEWPANELID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u7684\u5e03\u5c40\u9762\u677f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("99a45bdba86538610e4ec8feab045014");
        pSDEFGroupDetailModel.setName("PSSYSVIEWPANELNAME");
        iPSDEFieldModel = this.getDEField("PSSYSVIEWPANELNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u7684\u5e03\u5c40\u9762\u677f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8a5750bd88eeedc511fade13c4a71cf3");
        pSDEFGroupDetailModel.setName("PSSYSTEMID");
        iPSDEFieldModel = this.getDEField("PSSYSTEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("479801544268f9a4336f6b723e67c0df");
        pSDEFGroupDetailModel.setName("PSSYSTEMNAME");
        iPSDEFieldModel = this.getDEField("PSSYSTEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("75526e36c5fc35044f278caaa5dd41d8");
        pSDEFGroupDetailModel.setName("PSVIEWENGINEID");
        iPSDEFieldModel = this.getDEField("PSVIEWENGINEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0e3d7acc75d343d092479217e42e4780");
        pSDEFGroupDetailModel.setName("PSVIEWENGINENAME");
        iPSDEFieldModel = this.getDEField("PSVIEWENGINENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c28f210f2642b9d5991b762dfd87dbbd");
        pSDEFGroupDetailModel.setName("PSVIEWMSGGROUPID");
        iPSDEFieldModel = this.getDEField("PSVIEWMSGGROUPID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u4f7f\u7528\u7684\u89c6\u56fe\u6d88\u606f\u7ec4");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ec0d5dc1fb2325b300be058101381cf5");
        pSDEFGroupDetailModel.setName("PSVIEWMSGGROUPNAME");
        iPSDEFieldModel = this.getDEField("PSVIEWMSGGROUPNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u4f7f\u7528\u7684\u89c6\u56fe\u6d88\u606f\u7ec4");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a84e03b061f75a056e5b2b0d43d4c642");
        pSDEFGroupDetailModel.setName("PREDEFINEVIEWTYPE");
        iPSDEFieldModel = this.getDEField("PREDEFINEVIEWTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PredefinedViewTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u5728\u6240\u5728\u5b9e\u4f53\u7684\u529f\u80fd\u6a21\u5f0f\uff0c\u529f\u80fd\u6a21\u5f0f\u652f\u6301\u9644\u52a0\u53c2\u6570\u3002\u5728\u67d0\u4e9b\u573a\u666f\u4e0b\uff0c\u6a21\u578b\u5f15\u64ce\u4f1a\u6309\u7167\u6307\u5b9a\u529f\u80fd\u6a21\u5f0f\u5c1d\u8bd5\u83b7\u53d6\u89c6\u56fe\u3002\u529f\u80fd\u6a21\u5f0f+\u6a21\u5f0f\u53c2\u6570 \u9700\u8981\u5728\u6240\u5728\u5b9e\u4f53\u5177\u5907\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e584bbec89ff8abffe83acb5ba0eb210");
        pSDEFGroupDetailModel.setName("READONLYMODE");
        iPSDEFieldModel = this.getDEField("READONLYMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u662f\u5426\u5904\u4e8e\u81ea\u8bfb\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3ffa98d87cc08cf5f81f3bb5ad2fd7ac");
        pSDEFGroupDetailModel.setName("SHOWCAPTIONBAR");
        iPSDEFieldModel = this.getDEField("SHOWCAPTIONBAR", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u662f\u5426\u663e\u793a\u6807\u9898\u680f\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u5404\u89c6\u56fe\u7c7b\u578b\u81ea\u884c\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6c61b5c2106002d166ef33fd4a4d6611");
        pSDEFGroupDetailModel.setName("SUBCAPPSLANRESID");
        iPSDEFieldModel = this.getDEField("SUBCAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b4aa3c9c5beca0d045261a85edf73325");
        pSDEFGroupDetailModel.setName("SUBCAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("SUBCAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("fc114364f50a2f002bf892f01ff182f3");
        pSDEFGroupDetailModel.setName("SUBCAPTION");
        iPSDEFieldModel = this.getDEField("SUBCAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b6713bd5d8f111ef7ba0f7aebc63b7d7");
        pSDEFGroupDetailModel.setName("TEMPMODE");
        iPSDEFieldModel = this.getDEField("TEMPMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TempDataModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b9e\u4f53\u89c6\u56fe\u7684\u4e34\u65f6\u6570\u636e\u6a21\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u4e34\u65f6\u6570\u636e\u6a21\u5f0f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("36ce12dea1f5a06d7523fb3b22ffeb95");
        pSDEFGroupDetailModel.setName("TITLE");
        iPSDEFieldModel = this.getDEField("TITLE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u62ac\u5934");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1f0d36104ee7eaeed5b70dcd4a96fb62");
        pSDEFGroupDetailModel.setName("TITLEPSLANRESID");
        iPSDEFieldModel = this.getDEField("TITLEPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u62ac\u5934\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6413cecd62adc61cacf4924ca872468c");
        pSDEFGroupDetailModel.setName("TITLEPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("TITLEPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u62ac\u5934\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6947e63c0d598bc6135223983b76a2f4");
        pSDEFGroupDetailModel.setName("TODOTASK");
        iPSDEFieldModel = this.getDEField("TODOTASK", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("543c938a123ca04faa3b7b36f0c7e951");
        pSDEFGroupDetailModel.setName("USERDATA");
        iPSDEFieldModel = this.getDEField("USERDATA", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("60a543afe4f046a63adac8aa4e1541e1");
        pSDEFGroupDetailModel.setName("USERDATA2");
        iPSDEFieldModel = this.getDEField("USERDATA2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6ceddbe10f03bd20837a2a441dfbc5ea");
        pSDEFGroupDetailModel.setName("VIEWACTIONS");
        iPSDEFieldModel = this.getDEField("VIEWACTIONS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEViewActionsCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u89c6\u56fe\u542f\u7528\u64cd\u4f5c\u63a7\u5236\u65f6\uff0c\u6307\u5b9a\u89c6\u56fe\u652f\u6301\u7684\u64cd\u4f5c\u96c6\u5408");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f259244b256cdeb4587f9608bf9c0e40");
        pSDEFGroupDetailModel.setName("VIEWPARAMS");
        iPSDEFieldModel = this.getDEField("VIEWPARAMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u52a8\u6001\u53c2\u6570\uff0c\u4f7f\u7528Properties\u683c\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7c8000d06365691f85ab1f7eb8bc5ce0");
        pSDEFGroupDetailModel.setName("VIEWSN");
        iPSDEFieldModel = this.getDEField("VIEWSN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7f16\u53f7");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6e0010bbec89bb231014493b5a64c1e6");
        pSDEFGroupDetailModel.setName("WIDTH");
        iPSDEFieldModel = this.getDEField("WIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u89c6\u56fe\u7684\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u30100\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

