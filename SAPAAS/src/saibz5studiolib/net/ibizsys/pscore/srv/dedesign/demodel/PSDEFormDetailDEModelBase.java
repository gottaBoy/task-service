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
import net.ibizsys.pscore.srv.dedesign.demodel.psdeformdetail.ac.PSDEFormDetailDefaultACModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeformdetail.dataquery.PSDEFormDetailCurFormItemDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeformdetail.dataquery.PSDEFormDetailDefaultDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeformdetail.dataquery.PSDEFormDetailFIDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeformdetail.dataquery.PSDEFormDetailFormItemDQModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeformdetail.dataset.PSDEFormDetailCurFormFIDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeformdetail.dataset.PSDEFormDetailDefaultDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeformdetail.dataset.PSDEFormDetailFIDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeformdetail.dataset.PSDEFormDetailFormItemDSModel;
import net.ibizsys.pscore.srv.dedesign.demodel.psdeformdetail.logic.PSDEFormDetailCalcRefPSDEFormIdLogicModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;

public abstract class PSDEFormDetailDEModelBase
extends PSDataEntityModelBase<PSDEFormDetail> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDEFormDetailService pSDEFormDetailService;

    public PSDEFormDetailDEModelBase() throws Exception {
        this.setId("b8e3b42cac55cdfb2dc0a059d518d0b8");
        this.setName("PSDEFORMDETAIL");
        this.setCodeName("PSDEFormDetail");
        this.setTableName("T_SRFPSDEFORMDETAIL");
        this.setViewName("v_PSDEFORMDETAIL");
        this.setLogicName("\u8868\u5355\u6210\u5458");
        this.setMemo("\u5b9e\u4f53\u8868\u5355\u6210\u5458\u6a21\u578b\uff0c\u63d0\u4f9b\u591a\u79cd\u6210\u5458\u7c7b\u578b\u3002\u652f\u6301\u5b9a\u4e49\u6210\u5458\u7684\u5b50\u6210\u5458\uff08\u591a\u5c42\uff09\u3001\u6210\u5458\u7684\u52a8\u6001\u903b\u8f91\u7b49\u3002\u4e3a\u5b9e\u73b0\u754c\u9762\u4e0e\u4e1a\u52a1\u903b\u8f91\u7684\u89e3\u8026\uff0c\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\uff08PSDEFUIMODE\uff09\u652f\u6301\u5b9a\u4e49\u5c5e\u6027\u7684\u754c\u9762\u8868\u73b0\u6a21\u5f0f\uff0c\u8986\u76d6\u7f16\u8f91\u3001\u5c55\u793a\u3001\u79fb\u52a8\u7aef\u9002\u914d\u7b49\u573a\u666f\uff1b\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\uff08PSDEFSFITEM\uff09\u5219\u5b9a\u4e49\u5c5e\u6027\u641c\u7d22\u6761\u4ef6\u8f93\u5165\u754c\u9762\u53ca\u5904\u7406\u6a21\u5f0f\uff0c\u6240\u4ee5\u8868\u5355\u9879\u5927\u90e8\u5206\u573a\u666f\u65e0\u9700\u4e13\u95e8\u914d\u7f6e\u53c2\u6570\uff08\u7531\u9884\u7f6e\u6a21\u5f0f\u63d0\u4f9b\uff09");
        this.setDSLink("DEFAULT");
        this.setEnableMultiDS(true);
        this.setEnableMultiForm(true);
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        this.setEnableTempData(true);
        this.setUserTag("MODELV2");
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEFormDetailDEModel", (IDataEntityModel)this);
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

    public PSDEFormDetailService getRealService() {
        if (this.pSDEFormDetailService == null) {
            try {
                this.pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFormDetailService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService";
    }

    public PSDEFormDetail createEntity() {
        return new PSDEFormDetail();
    }

    /*
     * Opcode count of 16590 triggered aggressive code reduction.  Override with --aggressivesizethreshold.
     */
    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("ALLOWEMPTY");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("08d3e9f32920cd9349e76a1f6d49706d");
            pSDEFieldModel.setName("ALLOWEMPTY");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5141\u8bb8\u7a7a\u8f93\u5165");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("AllowEmpty");
            pSDEFieldModel.setMemo("\u8868\u5355\u9879\u662f\u5426\u5141\u8bb8\u7a7a\u8f93\u5165");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("BLANKLOGIC");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("eed4cbd6283104fd60670933a16766bb");
            pSDEFieldModel.setName("BLANKLOGIC");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5141\u8bb8\u7a7a\u903b\u8f91");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("BlankLogic");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("BL_POS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d8ecef4ad7dfb7f927c8e137cb562a4f");
            pSDEFieldModel.setName("BL_POS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8fb9\u7f18\u5e03\u5c40\u4f4d\u7f6e");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.BorderLayoutPosCodeListModel");
            pSDEFieldModel.setCodeName("BL_Pos");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u8868\u5355\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8fb9\u7f18\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u7684\u4f4d\u7f6e");
            pSDEFieldModel.setLength(10);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("BORDERSTYLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a8eb4afa3613b1a1581fd3bc6ea6b5e1");
            pSDEFieldModel.setName("BORDERSTYLE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8fb9\u6846\u6837\u5f0f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("BorderStyle");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("BTNACTIONTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("274703b2a4bc3769091f4aaddd953a29");
            pSDEFieldModel.setName("BTNACTIONTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6309\u94ae\u884c\u4e3a\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormButtonActionTypeCodeListModel");
            pSDEFieldModel.setCodeName("BtnActionType");
            pSDEFieldModel.setMemo("\u8868\u5355\u6309\u94ae\u5904\u7406\u7c7b\u578b");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_BTNACTIONTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_BTNACTIONTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("BUILDINACTION");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("49223abdaa12308c9099355e43fb35c1");
            pSDEFieldModel.setName("BUILDINACTION");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u7f6e\u64cd\u4f5c");
            pSDEFieldModel.setDataType("NMCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormGroupMoreActionsCodeListModel");
            pSDEFieldModel.setCodeName("BuildInAction");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u9762\u677f\u63d0\u4f9b\u5185\u7f6e\u64cd\u4f5c\u529f\u80fd\uff0c\u4e00\u822c\u5e94\u7528\u4e8e\u5206\u7ec4\u5305\u542b\u591a\u6570\u636e\u754c\u9762\u90e8\u4ef6\u573a\u5408\uff0c\u8c03\u7528\u591a\u6570\u636e\u90e8\u4ef6\u754c\u9762\u63d0\u4f9b\u7684\u76f8\u5173\u529f\u80fd");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_BUILDINACTION_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_BUILDINACTION_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CAPPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("da1fe9caa70b71eb08d9e6fcfb6b53ab");
            pSDEFieldModel.setName("CAPPSLANRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSLANGUAGERES_CAPPSLANRESID");
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
            pSDEFieldModel.setId("269aa4eda4bc7b77015ac0ec90e02e3b");
            pSDEFieldModel.setName("CAPPSLANRESNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSLANGUAGERES_CAPPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESNAME");
            pSDEFieldModel.setCodeName("CapPSLanResName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
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
            pSDEFieldModel.setId("76521f0a30226e424d1fe23e14cbbbc7");
            pSDEFieldModel.setName("CAPTION");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Caption");
            pSDEFieldModel.setUserTag2("\u8868\u5355\u6210\u5458\u7684\u6807\u9898\uff0c\u4e0d\u540c\u7c7b\u578b\u7684\u6210\u5458\u6309\u7167\u81ea\u8eab\u903b\u8f91\u653e\u7f6e\u6807\u9898\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CHILD_COL_LG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1cd8921a11a6a80758297f7f172a4323");
            pSDEFieldModel.setName("CHILD_COL_LG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u5bb9\u5927\u578b\u5217\u5bbd");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Child_Col_LG");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b50\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u5927\u578b\u754c\u9762\u7684\u9ed8\u8ba4\u5360\u4f4d\u6570\u91cf");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CHILD_COL_MD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("12cad84720ccc6cb1c97cffa8377b1fe");
            pSDEFieldModel.setName("CHILD_COL_MD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u5bb9\u4e2d\u578b\u5217\u5bbd");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Child_Col_MD");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b50\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u4e2d\u578b\u754c\u9762\u7684\u9ed8\u8ba4\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u4e3a\u5f53\u524d\u6805\u683c\u5217\u6570\uff08\u5360\u6ee1\uff09");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CHILD_COL_SM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("67bfa22e450ce43d0d140b95435a87da");
            pSDEFieldModel.setName("CHILD_COL_SM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u5bb9\u5c0f\u578b\u5217\u5bbd");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Child_Col_SM");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b50\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u5c0f\u578b\u754c\u9762\u7684\u9ed8\u8ba4\u5360\u4f4d\u6570\u91cf");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CHILD_COL_XS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d21f0dd3acced7c36b786cc692600335");
            pSDEFieldModel.setName("CHILD_COL_XS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u5bb9\u8d85\u5c0f\u5217\u5bbd");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Child_Col_XS");
            pSDEFieldModel.setUserTag("IGNOREMODELDSLMEMO");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5b50\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u8d85\u5c0f\u578b\u754c\u9762\u7684\u9ed8\u8ba4\u5360\u4f4d\u6570\u91cf");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CODELISTCONFIGMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("623c5a9d1b7ceecee65606fd83893f47");
            pSDEFieldModel.setName("CODELISTCONFIGMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4ee3\u7801\u8868\u8f93\u51fa\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.OutputCodeListConfigModeCodeListModel");
            pSDEFieldModel.setCodeName("CodeListConfigMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setUserTag2("\u6307\u5b9a\u8868\u5355\u9879\u4ee3\u7801\u8868\u914d\u7f6e\u7684\u8f93\u51fa\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u8868\u5355\u9879\u7f16\u8f91\u5668\u4e0e\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u4e00\u81f4\u5219\u4f7f\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\uff0c\u5426\u5219\u4e3a\u3010\u65e0\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CODELISTCONFIGMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CODELISTCONFIGMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COLALIGN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7f9c1fde548f38ca84e65dd9f9dbefbc");
            pSDEFieldModel.setName("COLALIGN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8868\u683c\u5217\u5bf9\u9f50");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.GridColAlignCodeListModel");
            pSDEFieldModel.setCodeName("ColAlign");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_COLALIGN_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_COLALIGN_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COLID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("79b4c7b507456e68e12ec73fcc55a322");
            pSDEFieldModel.setName("COLID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5217\u53f7");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ColId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u8868\u5355\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u5360\u4f4d\u5217\u6807\u8bc6\uff0c-1\u4e3a\u81ea\u52a8\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COLMODEL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0bbbac2cf6c56a741416cbd8b5667a5d");
            pSDEFieldModel.setName("COLMODEL");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5217\u6a21\u578b");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ColModel");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u5e03\u5c40\u5bb9\u5668\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u8868\u683c\u5217\u5206\u5272\u6a21\u578b\uff0c\u591a\u5217\u4f7f\u7528\u5206\u53f7\u5206\u9694\uff0c\u5217\u5bbd\u5ea6\u53ef\u4ee5\u4f7f\u7528\u767e\u5206\u6570\uff08\u8868\u683c\u5bbd\u5ea6\u5360\u6bd4\uff09\u3001\u6570\u5b57\u3001\u661f\u53f7\uff08\u5269\u4f59\uff09\uff0c\u5982 100;50%;* \u8868\u73b0\u7b2c\u4e00\u5217100\u50cf\u7d20\u3001\u7b2c\u4e8c\u5217\u8868\u683c\u4e00\u534a\u5bbd\u5ea6\uff0c\u7b2c\u4e09\u5217\u4e3a\u5269\u4f59\u5bbd\u5ea6");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COLSPAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c5cb15b1a665388808e9e73937769be6");
            pSDEFieldModel.setName("COLSPAN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5217\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ColSpan");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u7684\u5360\u4f4d\u5217\u6570\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u30101\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_LG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5d5d4c395d48fdd00af3f501d9afff5a");
            pSDEFieldModel.setName("COL_LG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5927\u578b\u5217\u5bbd");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_LG");
            pSDEFieldModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u5927\u578b\u754c\u9762\u7684\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u7236\u5bb9\u5668\u7684\u9ed8\u8ba4\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_LG_OS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bddc608206ce843f6ae721cc077d9844");
            pSDEFieldModel.setName("COL_LG_OS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5927\u578b\u504f\u79fb");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_LG_OS");
            pSDEFieldModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u5927\u578b\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_MD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ea238d3022a350e601da505be6407abe");
            pSDEFieldModel.setName("COL_MD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u578b\u5217\u5bbd");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_MD");
            pSDEFieldModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u4e2d\u578b\u754c\u9762\u7684\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u7236\u5bb9\u5668\u7684\u9ed8\u8ba4\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_MD_OS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("11c4370b105d9872a27a1e71f60b5595");
            pSDEFieldModel.setName("COL_MD_OS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u578b\u504f\u79fb");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_MD_OS");
            pSDEFieldModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u4e2d\u578b\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_SM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("265df258da87aed7111eed7c82881b35");
            pSDEFieldModel.setName("COL_SM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5c0f\u578b\u5217\u5bbd");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_SM");
            pSDEFieldModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u5c0f\u578b\u754c\u9762\u7684\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u7236\u5bb9\u5668\u7684\u9ed8\u8ba4\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_SM_OS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("efa55b9e4e91ad6b1b4efeb865e738ab");
            pSDEFieldModel.setName("COL_SM_OS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5c0f\u578b\u504f\u79fb");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_SM_OS");
            pSDEFieldModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u5c0f\u578b\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_WIDTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d5c543e3ae3d39ff52596e01cca8c695");
            pSDEFieldModel.setName("COL_WIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u56fa\u5b9a\u5bbd\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_Width");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u56fa\u5b9a\u5217\u5bbd\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_XS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d9016c633bee24ceeedd6f4ca06df392");
            pSDEFieldModel.setName("COL_XS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8d85\u5c0f\u5217\u5bbd");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_XS");
            pSDEFieldModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u8d85\u5c0f\u754c\u9762\u7684\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u7236\u5bb9\u5668\u7684\u9ed8\u8ba4\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COL_XS_OS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("268765e89784ad670c6094b689104c0b");
            pSDEFieldModel.setName("COL_XS_OS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8d85\u5c0f\u504f\u79fb");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Col_XS_OS");
            pSDEFieldModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u8d85\u5c0f\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u9ed8\u8ba4\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CONTENTTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3dd168bd6db48f9de7ecf80bc42d2224");
            pSDEFieldModel.setName("CONTENTTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u5bb9\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ContentTypeCodeListModel");
            pSDEFieldModel.setCodeName("ContentType");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u76f4\u63a5\u5185\u5bb9\u6210\u5458\u7684\u5185\u5bb9\u7c7b\u578b");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CONTENTTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CONTENTTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CONVERTCITEXT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("144d290cc05d5f78cf4faba6fad1f6fb");
            pSDEFieldModel.setName("CONVERTCITEXT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f6c\u6362\u4ee3\u7801\u9879\u6587\u672c");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ConvertCIText");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u5728\u8868\u5355\u9879\u6307\u5b9a\u4ee3\u7801\u8868\u60c5\u51b5\u4e0b\uff0c\u6307\u5b9a\u662f\u5426\u5c06\u4ee3\u7801\u503c\u8f6c\u6362\u4e3a\u6587\u672c\u8f93\u51fa\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u8868\u5355\u9879\u7684\u7f16\u8f91\u5668\u51b3\u5b9a");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COUNTERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("acdf456f05f09b4fb25f811206355728");
            pSDEFieldModel.setName("COUNTERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8ba1\u6570\u5668\u6807\u8bc6");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CounterId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("COUNTERMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("492f9d51e01c6209f5e001172d96814c");
            pSDEFieldModel.setName("COUNTERMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8ba1\u6570\u5668\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DETreeNodeCounterModeCodeListModel");
            pSDEFieldModel.setCodeName("CounterMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_COUNTERMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_COUNTERMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
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
            pSDEFieldModel.setId("70599b30bd9b5fcb042effacffdf8bca");
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
        object = this.createDEField("CREATEDV");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2d1024aa0e789e5cc87a0836a4915820");
            pSDEFieldModel.setName("CREATEDV");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5efa\u7acb\u9ed8\u8ba4\u503c");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CreateDV");
            pSDEFieldModel.setUserTag2("\u6307\u5b9a\u8868\u5355\u9879\u7684\u5efa\u7acb\u9ed8\u8ba4\u503c\uff0c\u672a\u6307\u5b9a\u9ed8\u8ba4\u503c\u7c7b\u578b\u65f6\u6309\u76f4\u63a5\u503c\u5904\u7406");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDVT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4a8fe5541123224fca23781b512fc139");
            pSDEFieldModel.setName("CREATEDVT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u65b0\u5efa\u9ed8\u8ba4\u503c\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldDefaultValueTypeCodeListModel");
            pSDEFieldModel.setCodeName("CreateDVT");
            pSDEFieldModel.setMemo("\u8868\u5355\u9879\u7684\u65b0\u5efa\u9ed8\u8ba4\u503c\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u76f4\u63a5\u503c\u3011");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CREATEDVT_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CREATEDVT_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEMAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ce832d01260dac407176e374b9d97ee0");
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
        object = this.createDEField("CSSID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("45a4575d3effe91eb9034521d50ec4c9");
            pSDEFieldModel.setName("CSSID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u7f6e\u6210\u5458\u6837\u5f0f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CssId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CTRLCOLSPAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("743110fc4b02314efd87f0b5f0f5f55a");
            pSDEFieldModel.setName("CTRLCOLSPAN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63a7\u4ef6\u5217\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CtrlColSpan");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6805\u683c\u5e03\u5c40\u65f6\u8868\u5355\u9879\u5bb9\u5668\u4e2d\u7f16\u8f91\u63a7\u4ef6\u7684\u5360\u4f4d\u5217\u6570\uff0c\u6b64\u53c2\u6570\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559\uff0c\u73b0\u5df2\u4e0d\u518d\u4f7f\u7528");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CTRLDYNACLASS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d3424cc91f3cc3141a18d2ea11c01d2d");
            pSDEFieldModel.setName("CTRLDYNACLASS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u90e8\u4ef6\u52a8\u6001\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CtrlDynaClass");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CTRLHEIGHT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5afed07492d48e30752a92ef58d3451f");
            pSDEFieldModel.setName("CTRLHEIGHT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63a7\u4ef6\u9ad8\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CtrlHeight");
            pSDEFieldModel.setUserTag2("\u6307\u5b9a\u8868\u5355\u9879\u7f16\u8f91\u5668\u7684\u9ad8\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u8868\u5355\u9879\u7f16\u8f91\u5668\u4e0e\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u4e00\u81f4\u5219\u4f7f\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\u503c\uff0c\u5426\u5219\u4f7f\u7528\u7f16\u8f91\u5668\u7c7b\u578b\u7684\u9ed8\u8ba4\u9ad8\u5ea6");
            pSDEFieldModel.setMemo("\u7f16\u8f91\u5668\u9ad8\u5ea6");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CTRLPSSYSCSSID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cf49a90e01852facf32d565271a8daf3");
            pSDEFieldModel.setName("CTRLPSSYSCSSID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u90e8\u4ef6\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSCSS_CTRLPSSYSCSSID");
            pSDEFieldModel.setLinkDEFName("PSSYSCSSID");
            pSDEFieldModel.setCodeName("CtrlPSSysCssId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CTRLPSSYSCSSID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CTRLPSSYSCSSID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CTRLPSSYSCSSNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("507e856ba37669f0a8be7e0ffadb8714");
            pSDEFieldModel.setName("CTRLPSSYSCSSNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u90e8\u4ef6\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSCSS_CTRLPSSYSCSSID");
            pSDEFieldModel.setLinkDEFName("PSSYSCSSNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("CtrlPSSysCssName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CTRLPSSYSCSSNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CTRLPSSYSCSSNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_CTRLPSSYSCSSNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_CTRLPSSYSCSSNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CTRLRAWCSSSTYLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("99259a5ebfee29c9bc727260825f3aa8");
            pSDEFieldModel.setName("CTRLRAWCSSSTYLE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u90e8\u4ef6\u76f4\u63a5\u6837\u5f0f");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CtrlRawCssStyle");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CTRLWIDTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8933f03cf450132fb2491fd8ca7733b3");
            pSDEFieldModel.setName("CTRLWIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63a7\u4ef6\u5bbd\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CtrlWidth");
            pSDEFieldModel.setUserTag2("\u6307\u5b9a\u8868\u5355\u9879\u7f16\u8f91\u5668\u7684\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u8868\u5355\u9879\u7f16\u8f91\u5668\u4e0e\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u4e00\u81f4\u5219\u4f7f\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\u503c\uff0c\u5426\u5219\u4f7f\u7528\u7f16\u8f91\u5668\u7c7b\u578b\u7684\u9ed8\u8ba4\u5bbd\u5ea6");
            pSDEFieldModel.setMemo("\u7f16\u8f91\u5668\u5bbd\u5ea6");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CUSTOMCODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("89d45351a21d0c1674c5d1dc6e3b6613");
            pSDEFieldModel.setName("CUSTOMCODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u4ee3\u7801");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("CustomCode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DATA");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6f7d6bca92985114e6f442b82f022198");
            pSDEFieldModel.setName("DATA");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u641c\u7d22\u9879\u6570\u636e");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Data");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(2000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DEFAULTFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("127f16e1ab3000b35aacf511fe017a3f");
            pSDEFieldModel.setName("DEFAULTFLAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ed8\u8ba4\u641c\u7d22\u9879");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("DefaultFlag");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DETAILSTYLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("33cd492668d62198702d6aa658b564b1");
            pSDEFieldModel.setName("DETAILSTYLE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u7f6e\u6837\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDetailStyleCodeListModel");
            pSDEFieldModel.setCodeName("DetailStyle");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u5185\u7f6e\u5f0f\u6837\uff0c\u5185\u7f6e\u5f0f\u6837\u662f\u6a21\u677f\u63d0\u4f9b\u7684\u8868\u73b0\u5f0f\u6837\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u9ed8\u8ba4\u3011");
            pSDEFieldModel.setLength(16);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DETAILSTYLE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DETAILSTYLE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DETAILSTYLETEXT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7e4227ba5bccd1ff8479d80cb27849d0");
            pSDEFieldModel.setName("DETAILSTYLETEXT");
            pSDEFieldModel.setDEFType(5);
            pSDEFieldModel.setLogicName("\u6210\u5458\u6837\u5f0f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("DetailStyleText");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DETAILTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7e12cf88ffe9f1b31b1c9df013f49faa");
            pSDEFieldModel.setName("DETAILTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9879\u6807\u8bb0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DetailTag");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DETAILTAG2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("87df36e75183ace701456f615ad4a6ff");
            pSDEFieldModel.setName("DETAILTAG2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9879\u6807\u8bb02");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DetailTag2");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DETAILTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("076ab331669cb6814bb546b828cdced4");
            pSDEFieldModel.setName("DETAILTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMultiFormDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDetailType2CodeListModel");
            pSDEFieldModel.setCodeName("DetailType");
            pSDEFieldModel.setMemo("\u8868\u5355\u6210\u5458\u7c7b\u578b");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_DETAILTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_DETAILTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DYNACLASS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fc4f7d6a54358f1dcc6c6328a198e555");
            pSDEFieldModel.setName("DYNACLASS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("DynaClass");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("DYNAMODELFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("dc171e632e2da842bc6ebabc85e45aa5");
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
        object = this.createDEField("EDITORPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9edac5065f5ab52809b632502026543c");
            pSDEFieldModel.setName("EDITORPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("EditorParams");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7f16\u8f91\u5668\u7684\u53c2\u6570\uff0c\u5982\u8868\u5355\u9879\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\u7f16\u8f91\u5668\u7c7b\u578b\u4e0e\u5f53\u524d\u7f16\u8f91\u5668\u4e00\u81f4\uff0c\u540c\u65f6\u9644\u52a0\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u5668\u53c2\u6570");
            pSDEFieldModel.setLength(2000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EDITORTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a554d79b3564b10c0485ba827e39a3c4");
            pSDEFieldModel.setName("EDITORTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.EditorTypeCodeListModel");
            pSDEFieldModel.setCodeName("EditorType");
            pSDEFieldModel.setUserTag2("\u6307\u5b9a\u8868\u5355\u9879\u7f16\u8f91\u5668\u7684\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            pSDEFieldModel.setLength(40);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_EDITORTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_EDITORTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EDITORTYPENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2a767178e1bf2fe1cca4d44f6e4954da");
            pSDEFieldModel.setName("EDITORTYPENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u7c7b\u578b");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("EditorTypeName");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("EMPTYCAPTION");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e939ddbbf95c506f41256dff384bbd1d");
            pSDEFieldModel.setName("EMPTYCAPTION");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7a7a\u767d\u6807\u7b7e");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EmptyCaption");
            pSDEFieldModel.setUserTag2("\u6307\u5b9a\u8868\u5355\u9879\u662f\u5426\u542f\u7528\u7a7a\u767d\u6807\u7b7e\uff0c\u7a7a\u767d\u6807\u7b7e\u662f\u6307\u4f7f\u7528\u65e0\u5185\u5bb9\u7684\u6807\u7b7e\u8fdb\u884c\u5360\u4f4d\u3002\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.setMemo("\u662f\u5426\u542f\u7528\u7a7a\u767d\u6807\u7b7e\u5360\u4f4d\u3002\u9ed8\u8ba4\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLEANCHOR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c0d6cb638c87dc0887ef566aca3a505e");
            pSDEFieldModel.setName("ENABLEANCHOR");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u951a\u70b9");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableAnchor");
            pSDEFieldModel.setMemo("\u542f\u7528\u951a\u70b9\u63d0\u4f9b\u4e86\u5b9a\u4f4d\u5f53\u524d\u9879\u80fd\u529b\uff0c\u9ed8\u8ba4\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLECOND");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("668ceb8504d4e482564989c7544aaec7");
            pSDEFieldModel.setName("ENABLECOND");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u6761\u4ef6");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormItemEnableCondCodeListModel");
            pSDEFieldModel.setCodeName("EnableCond");
            pSDEFieldModel.setUserTag2("\u6307\u5b9a\u8868\u5355\u9879\u7684\u9759\u6001\u542f\u7528\u6761\u4ef6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            pSDEFieldModel.setMemo("\u8868\u5355\u9879\u7684\u9759\u6001\u542f\u7528\u6761\u4ef6");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ENABLECOND_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ENABLECOND_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLEINPUTTIP");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a3fd7d61c56019817f88e50232b56357");
            pSDEFieldModel.setName("ENABLEINPUTTIP");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u8f93\u5165\u63d0\u793a");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableInputTip");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLEITEMPRIV");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8156bb1b5c6550e15d17812bc75b9917");
            pSDEFieldModel.setName("ENABLEITEMPRIV");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u5217\u6743\u9650\u63a7\u5236");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("EnableItemPriv");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u662f\u5426\u542f\u7528\u5217\u6743\u9650\u63a7\u5236\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5c5e\u6027\u51b3\u5b9a\uff0c\u65e0\u5b9e\u4f53\u5c5e\u6027\u5219\u4e3a\u3010\u5426\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ENABLELOGIC");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d1b23fd6e724260ed4d05b5d7577db1f");
            pSDEFieldModel.setName("ENABLELOGIC");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u542f\u7528\u903b\u8f91");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("EnableLogic");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FIELDNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c8b15db2a662518522090514aefc301a");
            pSDEFieldModel.setName("FIELDNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u503c\u5c5e\u6027\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("FieldName");
            pSDEFieldModel.setMemo("\u76f4\u63a5\u6307\u5b9a\u8868\u5355\u9879\u7ed1\u5b9a\u7684\u503c\u5c5e\u6027\u540d\u79f0\uff0c\u4e00\u822c\u5728\u91cd\u590d\u5668\u91cc\u9762\u7684\u8868\u5355\u6210\u5458\u4f7f\u7528\uff08\u91cd\u590d\u5668\u7684\u5b9e\u4f53\u57df\u4e0e\u8868\u5355\u4e0d\u540c\uff0c\u4e0d\u80fd\u76f4\u63a5\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\uff09");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FLEXALIGN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d0a8d0b9d77bb0bdc714c525c7de6a18");
            pSDEFieldModel.setName("FLEXALIGN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("Flex\u6a2a\u8f74\u5bf9\u9f50");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FlexAlignCodeListModel");
            pSDEFieldModel.setCodeName("FlexAlign");
            pSDEFieldModel.setMemo("\u6210\u5458\u5728\u3010Flex\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u6307\u5b9a\u6a2a\u8f74\u5bf9\u9f50\u65b9\u5f0f");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_FLEXALIGN_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_FLEXALIGN_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FLEXBASIS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4f7efc677df2cf7e7e871fdbd11d86c6");
            pSDEFieldModel.setName("FLEXBASIS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("Flex\u4f38\u7f29\u57fa\u503c");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("FlexBasis");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FLEXDIR");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4068cb15de2a359be8646ac510ae9bb0");
            pSDEFieldModel.setName("FLEXDIR");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("Flex\u5e03\u5c40\u65b9\u5411");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FlexLayoutDirCodeListModel");
            pSDEFieldModel.setCodeName("FlexDir");
            pSDEFieldModel.setMemo("\u6210\u5458\u5728\u3010Flex\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u6307\u5b9a\u5e03\u5c40\u65b9\u5411");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_FLEXDIR_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_FLEXDIR_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FLEXGROW");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b83dcb2ac8b81125b98a63f63685684d");
            pSDEFieldModel.setName("FLEXGROW");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("Flex\u5ef6\u5c55\u503c");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("FlexGrow");
            pSDEFieldModel.setMemo("\u6210\u5458\u5728\u3010Flex\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u5ef6\u5c55\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FLEXSHRINK");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("bd562cf8a99cfb5249ddcd7fa6e91c35");
            pSDEFieldModel.setName("FLEXSHRINK");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("Flex\u4f38\u7f29");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("FlexShrink");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FLEXVALIGN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7c69d3f3beda2bc9782a7c8866be895e");
            pSDEFieldModel.setName("FLEXVALIGN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("Flex\u7eb5\u8f74\u5bf9\u9f50");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FlexVAlignCodeListModel");
            pSDEFieldModel.setCodeName("FlexVAlign");
            pSDEFieldModel.setMemo("\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010Flex\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u7eb5\u8f74\u5bf9\u9f50\u65b9\u5f0f");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_FLEXVALIGN_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_FLEXVALIGN_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("FORMTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("510601108256a8fc1140aab2d8d02b43");
            pSDEFieldModel.setName("FORMTYPE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8868\u5355\u7c7b\u578b");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFORM_PSDEFORMID");
            pSDEFieldModel.setLinkDEFName("FORMTYPE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTypeCodeListModel");
            pSDEFieldModel.setCodeName("FormType");
            pSDEFieldModel.setLength(20);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("GRIDROWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d394e6d4182e43133102ef7b40aeeb3d");
            pSDEFieldModel.setName("GRIDROWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u884c\u53f7");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("GridRowId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u5360\u4f4d\u884c\u6807\u8bc6\uff0c-1\u4e3a\u81ea\u52a8\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HALIGN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("90237b2371db400959d92211f119933e");
            pSDEFieldModel.setName("HALIGN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6c34\u5e73\u5bf9\u9f50");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TextAlignCodeListModel");
            pSDEFieldModel.setCodeName("HAlign");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_HALIGN_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_HALIGN_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HALIGNSELF");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a310605f1e797a988227fd08ec7923c9");
            pSDEFieldModel.setName("HALIGNSELF");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6c34\u5e73\u5bf9\u9f50\uff08\u81ea\u8eab\uff09");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TextAlignCodeListModel");
            pSDEFieldModel.setCodeName("HAlignSelf");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_HALIGNSELF_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_HALIGNSELF_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HEIGHT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e8ec912adf16fdd685ecf1c8cea399e1");
            pSDEFieldModel.setName("HEIGHT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ad8\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Height");
            pSDEFieldModel.setMemo("\u9ad8\u5ea6\uff0c\u9ed8\u8ba4\u4e3a0\uff08\u81ea\u52a8\u8ba1\u7b97\uff09");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HEIGHTMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("42bed04e276eed4a651a2e6372c352d7");
            pSDEFieldModel.setName("HEIGHTMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9ad8\u5ea6\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.HeightModeCodeListModel");
            pSDEFieldModel.setCodeName("HeightMode");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_HEIGHTMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_HEIGHTMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HTMLCONTENT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("265f49ab3dc6702c53c650f9aa9bd50e");
            pSDEFieldModel.setName("HTMLCONTENT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("HTML\u5185\u5bb9");
            pSDEFieldModel.setDataType("HTMLTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("HtmlContent");
            pSDEFieldModel.setUserTag2("\u76f4\u63a5\u5185\u5bb9\u9879\uff08Html\u5185\u5bb9\uff09\u7684Html\u5185\u5bb9\uff0c\u672a\u6307\u5b9a\u65f6\u4f7f\u7528\u6307\u5b9a\u7684\u7cfb\u7edf\u8d44\u6e90\u5b9a\u4e49\u5185\u5bb9");
            pSDEFieldModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\uff08Html\u5185\u5bb9\uff09\u7684Html\u5185\u5bb9");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("HTMLPAGEURL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ccc9a47cb5a71412dda8ff0d894d2338");
            pSDEFieldModel.setName("HTMLPAGEURL");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("HTML\u9875\u9762\u5730\u5740");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("HtmlPageUrl");
            pSDEFieldModel.setLength(300);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ICONALIGN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4c705c88fddb7e999533dc949e056b3c");
            pSDEFieldModel.setName("ICONALIGN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u56fe\u6807\u4f4d\u7f6e");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ButtonIconAlignCodeListModel");
            pSDEFieldModel.setCodeName("IconAlign");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ICONALIGN_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ICONALIGN_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("IGNOREINPUT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c2a675e41e203417f0631bc4ace6ccaa");
            pSDEFieldModel.setName("IGNOREINPUT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5ffd\u7565\u8f93\u5165\u503c");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FIValueIgnoreModeCodeListModel");
            pSDEFieldModel.setCodeName("IgnoreInput");
            pSDEFieldModel.setUserTag2("\u672a\u5b9a\u4e49\u65f6\uff081\uff09\u5982\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u5b58\u5728\u5ffd\u7565\u8f93\u5165\u503c\u914d\u7f6e\u5219\u4f7f\u7528\u8be5\u914d\u7f6e\uff082\uff09\u5982\u6210\u5458\u7236\u5bb9\u5668\u5b58\u5728\u5ffd\u7565\u8f93\u5165\u503c\u914d\u7f6e\u5219\u4f7f\u7528\u8be5\u914d\u7f6e\uff083\uff09\u5982\u8868\u5355\u9879\u5c5e\u6027\u4e3a\u7cfb\u7edf\u5c5e\u6027\u5219\u4e3a\u3010\u5efa\u7acb\u53ca\u66f4\u65b0\u3011\uff084\uff09\u5982\u4ee5\u4e0a\u6761\u4ef6\u90fd\u4e0d\u6ee1\u8db3\u5219\u4e3a\u3010\u65e0\u3011");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u5728\u4f55\u79cd\u60c5\u51b5\u4e0b\u4f1a\u5ffd\u7565\u8868\u5355\u9879\u7684\u8f93\u5165\u503c");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_IGNOREINPUT_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_IGNOREINPUT_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INSERTPOS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("81fe3e1775c55c9eac64f697d7b2c834");
            pSDEFieldModel.setName("INSERTPOS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63d2\u5165\u4f4d\u7f6e");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("InsertPos");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ITEMPSACHANDLERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a6419a98cc18fabc64209e9db24c493a");
            pSDEFieldModel.setName("ITEMPSACHANDLERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8868\u5355\u9879\u5904\u7406\u5bf9\u8c61");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSACHANDLER_ITEMPSACHANDLERID");
            pSDEFieldModel.setLinkDEFName("PSACHANDLERID");
            pSDEFieldModel.setCodeName("ItemPSACHandlerId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMPSACHANDLERID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMPSACHANDLERID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ITEMPSACHANDLERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e8d7a99b8f679f017538ec4995625ef4");
            pSDEFieldModel.setName("ITEMPSACHANDLERNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8868\u5355\u9879\u5904\u7406\u5bf9\u8c61");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSACHANDLER_ITEMPSACHANDLERID");
            pSDEFieldModel.setLinkDEFName("PSACHANDLERNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("ItemPSACHandlerName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u754c\u9762\u5904\u7406\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMPSACHANDLERNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMPSACHANDLERNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMPSACHANDLERNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMPSACHANDLERNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ITEMSTATES");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5562def26e3345387eaa78f64e53c20b");
            pSDEFieldModel.setName("ITEMSTATES");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8868\u5355\u9879\u9ed8\u8ba4\u72b6\u6001");
            pSDEFieldModel.setDataType("NMCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PanelFieldStateCodeListModel");
            pSDEFieldModel.setCodeName("ItemStates");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u8bbe\u7f6e\u8868\u5355\u9879\u7684\u9ed8\u8ba4\u72b6\u6001");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LABELCOLSPAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4ef3619c387ca8746cff85c0660f9243");
            pSDEFieldModel.setName("LABELCOLSPAN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u5217\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("LabelColSpan");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6805\u683c\u5e03\u5c40\u65f6\u8868\u5355\u9879\u5bb9\u5668\u4e2d\u6807\u7b7e\u7684\u5360\u4f4d\u5217\u6570\uff0c\u6b64\u53c2\u6570\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559\uff0c\u73b0\u5df2\u4e0d\u518d\u4f7f\u7528");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LABELCOLSPAN2");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e26ba975df7f4cdb31eece6248a74d11");
            pSDEFieldModel.setName("LABELCOLSPAN2");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9996\u5217\u6807\u7b7e\u5217\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("LabelColSpan2");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6805\u683c\u5e03\u5c40\u65f6\u8868\u5355\u9879\u5bb9\u5668\u4e2d\u9996\u5217\u6807\u7b7e\u7684\u5360\u4f4d\u5217\u6570\uff0c\u6b64\u53c2\u6570\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559\uff0c\u73b0\u5df2\u4e0d\u518d\u4f7f\u7528");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LABELCSSID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b2c129f22f63296ac5b9466e7b6fc8f4");
            pSDEFieldModel.setName("LABELCSSID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u7f6e\u6807\u9898\u6837\u5f0f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("LabelCssId");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(40);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LABELDYNACLASS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cfc91d7cc733bddf0f991e0bbf5c03c4");
            pSDEFieldModel.setName("LABELDYNACLASS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u7b7e\u52a8\u6001\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("LabelDynaClass");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LABELPOS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ae76ed5d4fd3c353c2fd22232ec2a0f8");
            pSDEFieldModel.setName("LABELPOS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u7b7e\u4f4d\u7f6e");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormItemLabelPosCodeListModel");
            pSDEFieldModel.setCodeName("LabelPos");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u6807\u7b7e\u7684\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5de6\u8fb9\u3011");
            pSDEFieldModel.setLength(10);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LABELPOS_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LABELPOS_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LABELPSSYSCSSID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("01296429cd95fb7a43003fcf46a19035");
            pSDEFieldModel.setName("LABELPSSYSCSSID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSCSS_LABELPSSYSCSSID");
            pSDEFieldModel.setLinkDEFName("PSSYSCSSID");
            pSDEFieldModel.setCodeName("LabelPSSysCssId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LABELPSSYSCSSID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LABELPSSYSCSSID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LABELPSSYSCSSNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("40625ae4923f99e988d69f755b9ac465");
            pSDEFieldModel.setName("LABELPSSYSCSSNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6807\u9898\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSCSS_LABELPSSYSCSSID");
            pSDEFieldModel.setLinkDEFName("PSSYSCSSNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("LabelPSSysCssName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LABELPSSYSCSSNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LABELPSSYSCSSNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LABELPSSYSCSSNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LABELPSSYSCSSNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LABELRAWCSSSTYLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("be57b35aefb2680507eef90338a599b8");
            pSDEFieldModel.setName("LABELRAWCSSSTYLE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u7b7e\u76f4\u63a5\u6837\u5f0f");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("LabelRawCssStyle");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LABELWIDTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f180130a56ccc316e14961f3c9293e04");
            pSDEFieldModel.setName("LABELWIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u7b7e\u5bbd\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("LabelWidth");
            pSDEFieldModel.setUserTag("IGNOREMODELDSLMEMO");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u6807\u7b7e\u7684\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u8868\u5355\u9ed8\u8ba4\u6807\u7b7e\u5bbd\u5ea6");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LAYOUTMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8880ab3bb3b133b8f178378aaaa9ca60");
            pSDEFieldModel.setName("LAYOUTMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5e03\u5c40\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDetailLayoutModeCodeListModel");
            pSDEFieldModel.setCodeName("LayoutMode");
            pSDEFieldModel.setMemo("\u5bb9\u5668\u6210\u5458\u7684\u5e03\u5c40\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u7236\u5bb9\u5668\u5e03\u5c40\uff08\u9876\u7ea7\u5bb9\u5668\u662f\u8868\u5355\u90e8\u4ef6\uff09");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_LAYOUTMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_LAYOUTMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LEVELTAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8952b6dfe0925c5806c2071bc7732efb");
            pSDEFieldModel.setName("LEVELTAG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u503c\u9879");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("LevelTag");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u52a8\u6001\u6807\u9898\u503c\u9879\uff0c\u503c\u9879\u5fc5\u987b\u662f\u5f53\u524d\u8868\u5355\u7684\u8868\u5355\u9879");
            pSDEFieldModel.setLength(40);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LEVELVALUE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1b86d20595c6e6846120ecd205905471");
            pSDEFieldModel.setName("LEVELVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5c42\u7ea7\u503c");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("LevelValue");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("LINKPSDEVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3042199642034714df10d98549f855ca");
            pSDEFieldModel.setName("LINKPSDEVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6570\u636e\u94fe\u63a5\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEVIEWBASE_LINKPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setCodeName("LinkPSDEViewId");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u7f16\u8f91\u5668\u7684\u6570\u636e\u94fe\u63a5\u89c6\u56fe\uff08\u67e5\u770b\u9009\u62e9\u6570\u636e\uff09\uff0c\u672a\u6307\u5b9a\u4f7f\u7528\u754c\u9762\u6a21\u5f0f\u5b9a\u4e49");
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
            pSDEFieldModel.setId("3403f1d024dc9311125499b511a97dc9");
            pSDEFieldModel.setName("LINKPSDEVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6570\u636e\u94fe\u63a5\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEVIEWBASE_LINKPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("LinkPSDEViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u5f15\u7528\u6570\u636e\u7684\u94fe\u63a5\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
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
        object = this.createDEField("LOGICNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7efc596ba7327afa69911558483aa92a");
            pSDEFieldModel.setName("LOGICNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e2d\u6587\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("LogicName");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u903b\u8f91\u540d\u79f0");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MARGIN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("529e14540a5f19ba839222d62725341d");
            pSDEFieldModel.setName("MARGIN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5916\u6846\u95f4\u9694");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Margin");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u5916\u8fb9\u8ddd\uff0c\u6ce8\u610f\uff1a\u6b64\u914d\u7f6e\u540e\u7eed\u5c06\u88ab\u53d6\u6d88\uff0c\u5efa\u8bae\u901a\u8fc7\u4f7f\u7528\u754c\u9762\u6837\u5f0f\u8868\u5b8c\u6210\u5bf9\u5e94\u7684\u529f\u80fd");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MASKINFO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1b22e2f100eb2b642724e57663a51096");
            pSDEFieldModel.setName("MASKINFO");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u906e\u7f69\u4fe1\u606f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("MaskInfo");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MASKMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4c5481981feab282fa5a5a6b9b26d05b");
            pSDEFieldModel.setName("MASKMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u906e\u7f69\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDRUIPartMaskModeCodeListModel");
            pSDEFieldModel.setCodeName("MaskMode");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MASKMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MASKMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MASKPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e31d1e423b26f96ee086a74efb42ccb5");
            pSDEFieldModel.setName("MASKPSLANRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u906e\u7f69\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSLANGUAGERES_MASKPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESID");
            pSDEFieldModel.setCodeName("MaskPSLanResId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MASKPSLANRESID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MASKPSLANRESID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MASKPSLANRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("08eebb178ac06811959b99852c8007ad");
            pSDEFieldModel.setName("MASKPSLANRESNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u906e\u7f69\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSLANGUAGERES_MASKPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESNAME");
            pSDEFieldModel.setCodeName("MaskPSLanResName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MASKPSLANRESNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MASKPSLANRESNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MASKPSLANRESNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MASKPSLANRESNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MDCTRLTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c914581735e0005407f15526ff95527a");
            pSDEFieldModel.setName("MDCTRLTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u591a\u6570\u636e\u90e8\u4ef6\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDetailMDCtrlTypeCodeListModel");
            pSDEFieldModel.setCodeName("MDCtrlType");
            pSDEFieldModel.setMemo("\u8868\u5355\u6210\u5458\u7c7b\u578b\u4e3a\u3010\u591a\u6570\u636e\u90e8\u4ef6\u3011\u65f6\u6307\u5b9a\u591a\u6570\u636e\u90e8\u4ef6\u7684\u7c7b\u578b");
            pSDEFieldModel.setLength(10);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDCTRLTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDCTRLTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MDPSDEDATAVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("43a0f5ea97168666ea67baa99f49273f");
            pSDEFieldModel.setName("MDPSDEDATAVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u591a\u6570\u636e\u5361\u7247\u89c6\u56fe\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEDATAVIEW_MDPSDEDATAVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEDATAVIEWID");
            pSDEFieldModel.setCodeName("MDPSDEDataViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSDEDATAVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSDEDATAVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MDPSDEDATAVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("571d73b1f665a686c61d2c0d2f4db23a");
            pSDEFieldModel.setName("MDPSDEDATAVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u591a\u6570\u636e\u5361\u7247\u89c6\u56fe\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEDATAVIEW_MDPSDEDATAVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEDATAVIEWNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("MDPSDEDataViewName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSDEDATAVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSDEDATAVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSDEDATAVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSDEDATAVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MDPSDEFORMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a1cfeea26da7ed5ce131a7dc307f8755");
            pSDEFieldModel.setName("MDPSDEFORMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u591a\u6570\u636e\u8868\u5355\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFORM_MDPSDEFORMID");
            pSDEFieldModel.setLinkDEFName("PSDEFORMID");
            pSDEFieldModel.setCodeName("MDPSDEFormId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSDEFORMID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSDEFORMID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MDPSDEFORMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("896791543b88ea2a33f72ab324ed147c");
            pSDEFieldModel.setName("MDPSDEFORMNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u591a\u6570\u636e\u8868\u5355\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFORM_MDPSDEFORMID");
            pSDEFieldModel.setLinkDEFName("PSDEFORMNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("MDPSDEFormName");
            pSDEFieldModel.setMemo("\u8868\u5355\u591a\u6570\u636e\u90e8\u4ef6\u7c7b\u578b\u4e3a\u3010\u8868\u5355\u3011\u65f6\u6307\u5b9a\u5faa\u73af\u7ed8\u5236\u7684\u8868\u5355\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSDEFORMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSDEFORMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSDEFORMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSDEFORMNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MDPSDEGRIDID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("426816b3a5f88b7aa1479e7f8003e236");
            pSDEFieldModel.setName("MDPSDEGRIDID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u591a\u6570\u636e\u8868\u683c\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEGRID_MDPSDEGRIDID");
            pSDEFieldModel.setLinkDEFName("PSDEGRIDID");
            pSDEFieldModel.setCodeName("MDPSDEGridId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSDEGRIDID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSDEGRIDID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MDPSDEGRIDNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0ba5c9806b6ffec4641a43918b86b591");
            pSDEFieldModel.setName("MDPSDEGRIDNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u591a\u6570\u636e\u8868\u683c\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEGRID_MDPSDEGRIDID");
            pSDEFieldModel.setLinkDEFName("PSDEGRIDNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("MDPSDEGridName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSDEGRIDNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSDEGRIDNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSDEGRIDNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSDEGRIDNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MDPSDELISTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("044122bb3b433df617a3abfbe583d460");
            pSDEFieldModel.setName("MDPSDELISTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u591a\u6570\u636e\u5217\u8868\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDELIST_MDPSDELISTID");
            pSDEFieldModel.setLinkDEFName("PSDELISTID");
            pSDEFieldModel.setCodeName("MDPSDEListId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSDELISTID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSDELISTID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MDPSDELISTNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e6d18b2779fdfb1e52a81e7d9847922f");
            pSDEFieldModel.setName("MDPSDELISTNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u591a\u6570\u636e\u5217\u8868\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDELIST_MDPSDELISTID");
            pSDEFieldModel.setLinkDEFName("PSDELISTNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("MDPSDEListName");
            pSDEFieldModel.setMemo("\u8868\u5355\u591a\u6570\u636e\u90e8\u4ef6\u7c7b\u578b\u4e3a\u3010\u5217\u8868\u3011\u65f6\u6307\u5b9a\u7ed8\u5236\u7684\u5217\u8868\u5bf9\u8c61");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSDELISTNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSDELISTNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSDELISTNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSDELISTNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MDPSSYSVIEWPANELID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4cf60423d4e4b85096fe3cae2dbbbdbe");
            pSDEFieldModel.setName("MDPSSYSVIEWPANELID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u591a\u6570\u636e\u9762\u677f\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSVIEWPANEL_MDPSSYSVIEWPANELID");
            pSDEFieldModel.setLinkDEFName("PSSYSVIEWPANELID");
            pSDEFieldModel.setCodeName("MDPSSysViewPanelId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSSYSVIEWPANELID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSSYSVIEWPANELID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MDPSSYSVIEWPANELNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("501ad23e490055089b8a80b916cda75e");
            pSDEFieldModel.setName("MDPSSYSVIEWPANELNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u591a\u6570\u636e\u9762\u677f\u90e8\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSVIEWPANEL_MDPSSYSVIEWPANELID");
            pSDEFieldModel.setLinkDEFName("PSSYSVIEWPANELNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("MDPSSysViewPanelName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSSYSVIEWPANELNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSSYSVIEWPANELNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_MDPSSYSVIEWPANELNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_MDPSSYSVIEWPANELNAME_LIKE");
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
            pSDEFieldModel.setId("b0b54264fc0c52a104b2eaf77a3b7b2e");
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
        object = this.createDEField("MOBFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6115172c46bba76604fc5af7cca903bf");
            pSDEFieldModel.setName("MOBFLAG");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u79fb\u52a8\u7aef\u8868\u5355");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFORM_PSDEFORMID");
            pSDEFieldModel.setLinkDEFName("MOBFLAG");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoColor8CodeListModel");
            pSDEFieldModel.setCodeName("MobFlag");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("MODELSTATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0d311585ccedc04f0452f882b2648492");
            pSDEFieldModel.setName("MODELSTATE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8bbe\u8ba1\u63a7\u5236\u72b6\u6001");
            pSDEFieldModel.setDataType("NMCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEFormDetailState2CodeListModel");
            pSDEFieldModel.setCodeName("ModelState");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u5728\u8fd0\u884c\u65f6\u8bbe\u8ba1\u5de5\u5177\u7684\u6269\u5c55\u63a7\u5236\u72b6\u6001\uff0c\u8fd0\u884c\u65f6\u8bbe\u8ba1\u5de5\u5177\u662f\u6307\u5728\u8fd0\u884c\u65f6\u73af\u5883\u63d0\u4f9b\u7684\u8868\u5355\u8bbe\u8ba1\u5de5\u5177");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("NEEDCODELISTCONFIG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("41ecea324ce07e15b7c011867bd0ff25");
            pSDEFieldModel.setName("NEEDCODELISTCONFIG");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9700\u8981\u63d0\u4f9b\u4ee3\u7801\u8868\u914d\u7f6e");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("NeedCodeListConfig");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u662f\u5426\u9700\u8981\u63d0\u4f9b\u4ee3\u7801\u8868\u914d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u8868\u5355\u9879\u7f16\u8f91\u5668\u4e0e\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u4e00\u81f4\u5219\u4f7f\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\uff0c\u5426\u5219\u4f7f\u7528\u8868\u5355\u9879\u7f16\u8f91\u5668\u9ed8\u8ba4\u914d\u7f6e");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("NOPRIVDM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ce2295135de86c51d367db072b1dd150");
            pSDEFieldModel.setName("NOPRIVDM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u65e0\u6743\u9650\u663e\u793a\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.NoPrivDisplayModesCodeListModel");
            pSDEFieldModel.setCodeName("NoPrivDM");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_NOPRIVDM_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_NOPRIVDM_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OPENPSDEVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b8c77e543701c51e18bd8d7c3aef546f");
            pSDEFieldModel.setName("OPENPSDEVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6253\u5f00\u5b9e\u4f53\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEVIEWBASE_OPENPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setCodeName("OpenPSDEViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OPENPSDEVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OPENPSDEVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OPENPSDEVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a01489ab4c3c9ef8fa15adf070ce95af");
            pSDEFieldModel.setName("OPENPSDEVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6253\u5f00\u5b9e\u4f53\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEVIEWBASE_OPENPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("OpenPSDEViewName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OPENPSDEVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OPENPSDEVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OPENPSDEVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OPENPSDEVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OPENPSSYSPDTVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d3581b5f842152af729bf16daf819efa");
            pSDEFieldModel.setName("OPENPSSYSPDTVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6253\u5f00\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSPDTVIEW_OPENPSSYSPDTVIEWID");
            pSDEFieldModel.setLinkDEFName("PSSYSPDTVIEWID");
            pSDEFieldModel.setCodeName("OpenPSSysPDTViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OPENPSSYSPDTVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OPENPSSYSPDTVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("OPENPSSYSPDTVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7a5b260b432b265fda3575a9543be583");
            pSDEFieldModel.setName("OPENPSSYSPDTVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6253\u5f00\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSPDTVIEW_OPENPSSYSPDTVIEWID");
            pSDEFieldModel.setLinkDEFName("PSSYSPDTVIEWNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("OpenPSSysPDTViewName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OPENPSSYSPDTVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OPENPSSYSPDTVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_OPENPSSYSPDTVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_OPENPSSYSPDTVIEWNAME_LIKE");
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
            pSDEFieldModel.setId("41eac94002e2d7f7996462b26ff7c0c0");
            pSDEFieldModel.setName("ORDERVALUE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6392\u5e8f\u503c");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("OrderValue");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setUserTag2("AUTOMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PADDING");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5d9108b672e83f765bd33a11d125d635");
            pSDEFieldModel.setName("PADDING");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u6846\u95f4\u9694");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Padding");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u5185\u8fb9\u8ddd\uff0c\u6ce8\u610f\uff1a\u6b64\u914d\u7f6e\u540e\u7eed\u5c06\u88ab\u53d6\u6d88\uff0c\u5efa\u8bae\u901a\u8fc7\u4f7f\u7528\u754c\u9762\u6837\u5f0f\u8868\u5b8c\u6210\u5bf9\u5e94\u7684\u529f\u80fd");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PHPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cdf76493c8493867f000ea26bf218bca");
            pSDEFieldModel.setName("PHPSLANRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5360\u4f4d\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSLANGUAGERES_PHPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESID");
            pSDEFieldModel.setCodeName("PHPSLanResId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PHPSLANRESID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PHPSLANRESID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PHPSLANRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0f475986b9bd69eacd3c2b30dfda199f");
            pSDEFieldModel.setName("PHPSLANRESNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5360\u4f4d\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSLANGUAGERES_PHPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESNAME");
            pSDEFieldModel.setCodeName("PHPSLanResName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PHPSLANRESNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PHPSLANRESNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PHPSLANRESNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PHPSLANRESNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PICKUPPSDEVIEWID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("51014af0b839103f5cd8d6536ef4dfbb");
            pSDEFieldModel.setName("PICKUPPSDEVIEWID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9009\u62e9\u754c\u9762\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEVIEWBASE_PICKUPPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASEID");
            pSDEFieldModel.setCodeName("PickupPSDEViewId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PICKUPPSDEVIEWID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PICKUPPSDEVIEWID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PICKUPPSDEVIEWNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3117eb1dc697b49f87720fa1aa5f1b6f");
            pSDEFieldModel.setName("PICKUPPSDEVIEWNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u9009\u62e9\u754c\u9762\u89c6\u56fe");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEVIEWBASE_PICKUPPSDEVIEWID");
            pSDEFieldModel.setLinkDEFName("PSDEVIEWBASENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PickupPSDEViewName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u5f15\u7528\u6570\u636e\u7684\u9009\u62e9\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PICKUPPSDEVIEWNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PICKUPPSDEVIEWNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PICKUPPSDEVIEWNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PICKUPPSDEVIEWNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PLACEHOLDER");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8a2ff6b14f510d6b84c46f2c40d491f8");
            pSDEFieldModel.setName("PLACEHOLDER");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5360\u4f4d\u63d0\u793a");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PlaceHolder");
            pSDEFieldModel.setUserTag2("\u6307\u5b9a\u8868\u5355\u9879\u7f16\u8f91\u5668\u7684\u5360\u4f4d\u63d0\u793a\u4fe1\u606f\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            pSDEFieldModel.setMemo("\u7f16\u8f91\u5668\u5360\u4f4d\u63d0\u793a\u4fe1\u606f");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PLAYOUTMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5947b967d94f9f36ff94287b57257c13");
            pSDEFieldModel.setName("PLAYOUTMODE");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7236\u5e03\u5c40\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFORMDETAIL_PPSDEFORMDETAILID");
            pSDEFieldModel.setLinkDEFName("LAYOUTMODE");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDetailLayoutModeCodeListModel");
            pSDEFieldModel.setCodeName("PLayoutMode");
            pSDEFieldModel.setLength(20);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PPSDEFORMDETAILID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("08781c842108d268b9f2c14611a4d101");
            pSDEFieldModel.setName("PPSDEFORMDETAILID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7236\u8868\u5355\u6210\u5458");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFORMDETAIL_PPSDEFORMDETAILID");
            pSDEFieldModel.setLinkDEFName("PSDEFORMDETAILID");
            pSDEFieldModel.setCodeName("PPSDEFormDetailId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PPSDEFORMDETAILID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PPSDEFORMDETAILID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PPSDEFORMDETAILNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("46564825112346ebb20bfe778de13349");
            pSDEFieldModel.setName("PPSDEFORMDETAILNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7236\u5bf9\u8c61");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFORMDETAIL_PPSDEFORMDETAILID");
            pSDEFieldModel.setLinkDEFName("PSDEFORMDETAILNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PPSDEFormDetailName");
            pSDEFieldModel.setLength(80);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PPSDEFORMDETAILNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PPSDEFORMDETAILNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PPSDEFORMDETAILNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PPSDEFORMDETAILNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREDEFINEDTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("da3ef5594e4bb16230de25aefd0d040d");
            pSDEFieldModel.setName("PREDEFINEDTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9884\u5b9a\u4e49\u7c7b\u578b");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PredefinedType");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREDEFINEDTYPETEXT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a0c4152296557fc92619b6ef3fb30de6");
            pSDEFieldModel.setName("PREDEFINEDTYPETEXT");
            pSDEFieldModel.setDEFType(5);
            pSDEFieldModel.setLogicName("\u9884\u5b9a\u4e49\u7c7b\u578b");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PredefinedTypeText");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREVENTXSS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c37453e25c196d8bcbde7d0c6df2b942");
            pSDEFieldModel.setName("PREVENTXSS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9632\u6b62XSS\u653b\u51fb");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("PreventXSS");
            pSDEFieldModel.setUserTag("RESERVEMODELV2");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PREVIEWHTML");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a8e77bfd630b89a978f1b21d58ca64c1");
            pSDEFieldModel.setName("PREVIEWHTML");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9884\u89c8\u5185\u5bb9");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("PreviewHtml");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(10);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSCODELISTID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("01c8adfa8469c374782a712ba5a01a78");
            pSDEFieldModel.setName("PSCODELISTID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u4ee3\u7801\u8868");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSCODELIST_PSCODELISTID");
            pSDEFieldModel.setLinkDEFName("PSCODELISTID");
            pSDEFieldModel.setCodeName("PSCodeListId");
            pSDEFieldModel.setMemo("\u7f16\u8f91\u5668\u7684\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u9ed8\u8ba4\u4f7f\u7528\u754c\u9762\u6a21\u5f0f\u5b9a\u4e49");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSCODELISTID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSCODELISTID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSCODELISTNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8f8154f919ecc41099d4f4e5d71f2ef4");
            pSDEFieldModel.setName("PSCODELISTNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u4ee3\u7801\u8868");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSCODELIST_PSCODELISTID");
            pSDEFieldModel.setLinkDEFName("PSCODELISTNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSCodeListName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSCODELISTNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSCODELISTNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSCODELISTNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSCODELISTNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDRID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8b4a301886105ad29fa534688087952d");
            pSDEFieldModel.setName("PSDEDRID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u7ec4");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEDATARELATION_PSDEDRID");
            pSDEFieldModel.setLinkDEFName("PSDEDATARELATIONID");
            pSDEFieldModel.setCodeName("PSDEDRId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDRID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDRID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDRITEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9d9390f00ca06358fdadf03359135315");
            pSDEFieldModel.setName("PSDEDRITEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6570\u636e\u5173\u7cfb\u754c\u9762");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEDRITEM_PSDEDRITEMID");
            pSDEFieldModel.setLinkDEFName("PSDEDRITEMID");
            pSDEFieldModel.setCodeName("PSDEDRItemId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDRITEMID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDRITEMID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDRITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c9043d75d61d700bc54f7f8dfcba1847");
            pSDEFieldModel.setName("PSDEDRITEMNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u6570\u636e\u5173\u7cfb\u754c\u9762");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEDRITEM_PSDEDRITEMID");
            pSDEFieldModel.setLinkDEFName("PSDEDRITEMNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEDRItemName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u5173\u7cfb\u754c\u9762\u90e8\u4ef6\u5d4c\u5165\u7684\u5173\u7cfb\u754c\u9762");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDRITEMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDRITEMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDRITEMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDRITEMNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEDRNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fc6e682017e488be55e017dc7a8f8ca9");
            pSDEFieldModel.setName("PSDEDRNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u7ec4");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEDATARELATION_PSDEDRID");
            pSDEFieldModel.setLinkDEFName("PSDEDATARELATIONNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEDRName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDRNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDRNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEDRNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEDRNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFFORMITEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("27026a4b627265fd4bc6afc09d2840cb");
            pSDEFieldModel.setName("PSDEFFORMITEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u9879\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFFORMITEM_PSDEFFORMITEMID");
            pSDEFieldModel.setLinkDEFName("PSDEFFORMITEMID");
            pSDEFieldModel.setCodeName("PSDEFUIModeId");
            pSDEFieldModel.setMemo("\u672a\u5b9a\u4e49\u65f6\u6309\u7167\u4ee5\u4e0b\u65b9\u5f0f\u8ba1\u7b97\uff081\uff09\u5f53\u524d\u5e94\u7528\u7684\u9ed8\u8ba4\u6a21\u5f0f\uff082\uff09\u5f53\u524d\u5e94\u7528\u7c7b\u578b\u7684\u9ed8\u8ba4\u6a21\u5f0f");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFFORMITEMID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFFORMITEMID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFFORMITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("12d469acb19d368849db3de732477fa9");
            pSDEFieldModel.setName("PSDEFFORMITEMNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5c5e\u6027\u754c\u9762\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFFORMITEM_PSDEFFORMITEMID");
            pSDEFieldModel.setLinkDEFName("PSDEFFORMITEMNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEFUIModeName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u7167\u4ee5\u4e0b\u65b9\u5f0f\u8ba1\u7b97\u6a21\u5f0f\uff081\uff09\u5f53\u524d\u5e94\u7528\u7684\u9ed8\u8ba4\u6a21\u5f0f\uff082\uff09\u5f53\u524d\u5e94\u7528\u7c7b\u578b\u7684\u9ed8\u8ba4\u6a21\u5f0f");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFFORMITEMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFFORMITEMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFFORMITEMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFFORMITEMNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1396c61926faf9451fa7fdaf317ad76e");
            pSDEFieldModel.setName("PSDEFID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5c5e\u6027");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFIELD_PSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDEFIELDID");
            pSDEFieldModel.setCodeName("PSDEFId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFIUPDATEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f6dac62ea4ffd9d7529bea6edcce87ec");
            pSDEFieldModel.setName("PSDEFIUPDATEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8868\u5355\u9879\u66f4\u65b0");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFIUPDATE_PSDEFIUPDATEID");
            pSDEFieldModel.setLinkDEFName("PSDEFIUPDATEID");
            pSDEFieldModel.setCodeName("PSDEFIUpdateId");
            pSDEFieldModel.setMemo("\u8868\u5355\u9879\u503c\u53d8\u5316\u65f6\u89e6\u53d1\u7684\u8868\u5355\u9879\u66f4\u65b0\u64cd\u4f5c");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFIUPDATEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFIUPDATEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFIUPDATENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4f4cb3b8c53e6d31eb3fac61ba46b5fc");
            pSDEFieldModel.setName("PSDEFIUPDATENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8868\u5355\u9879\u66f4\u65b0");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFIUPDATE_PSDEFIUPDATEID");
            pSDEFieldModel.setLinkDEFName("PSDEFIUPDATENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEFIUpdateName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u503c\u53d8\u5316\u65f6\u89e6\u53d1\u7684\u8868\u5355\u9879\u66f4\u65b0\u64cd\u4f5c");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFIUPDATENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFIUPDATENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFIUPDATENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFIUPDATENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("435ce18f42496bfaeb3e9a345fbd9843");
            pSDEFieldModel.setName("PSDEFNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u5c5e\u6027");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFIELD_PSDEFID");
            pSDEFieldModel.setLinkDEFName("PSDEFIELDNAME");
            pSDEFieldModel.setCodeName("PSDEFName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7ed1\u5b9a\u7684\u5c5e\u6027\u5bf9\u8c61");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFORMDETAILID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a3f6994a0c023d1c0b57fc059c616a50");
            pSDEFieldModel.setName("PSDEFORMDETAILID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u8868\u5355\u6210\u5458\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDEFormDetailId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFORMDETAILNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cf31c81e53d9f054f03ec6df4a49ecaa");
            pSDEFieldModel.setName("PSDEFORMDETAILNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSDEFormDetailName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5728\u8868\u5355\u4e2d\u5177\u6709\u552f\u4e00\u6027");
            pSDEFieldModel.setValueRuleName("\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u53ca@\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd");
            pSDEFieldModel.setLength(80);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFORMDETAILNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFORMDETAILNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFORMDETAILNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFORMDETAILNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFORMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a201de529fe5fe1b29d038e27ffa66f8");
            pSDEFieldModel.setName("PSDEFORMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u8868\u5355");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFORM_PSDEFORMID");
            pSDEFieldModel.setLinkDEFName("PSDEFORMID");
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDEFormId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFORMID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFORMID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFORMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("78a0c903100ffbdc9d0a474819f700ad");
            pSDEFieldModel.setName("PSDEFORMNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u8868\u5355");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFORM_PSDEFORMID");
            pSDEFieldModel.setLinkDEFName("PSDEFORMNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setUserInputMode(1);
            pSDEFieldModel.setCodeName("PSDEFormName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u6240\u5728\u7684\u8868\u5355\u5bf9\u8c61");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFORMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFORMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFORMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFORMNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFORMRFID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c690835ce4732e0fcb8b74fb9a3a8fd1");
            pSDEFieldModel.setName("PSDEFORMRFID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u8868\u5355\u5f15\u7528");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFORMRF_PSDEFORMRFID");
            pSDEFieldModel.setLinkDEFName("PSDEFORMRFID");
            pSDEFieldModel.setCodeName("PSDEFormRFId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFORMRFID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFORMRFID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFORMRFNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("0a3710434c75de36f1f57b5bf1361fc5");
            pSDEFieldModel.setName("PSDEFORMRFNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u8868\u5355\u5f15\u7528");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFORMRF_PSDEFORMRFID");
            pSDEFieldModel.setLinkDEFName("PSDEFORMRFNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEFormRFName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u90e8\u4ef6\u4f7f\u7528\u7684\u8868\u5355\u5f15\u7528\u5bf9\u8c61");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFORMRFNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFORMRFNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFORMRFNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFORMRFNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFSFITEMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("72cd1ff394ed498ccef6c9a302d1f1c7");
            pSDEFieldModel.setName("PSDEFSFITEMID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u641c\u7d22\u9879\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFSFITEM_PSDEFSFITEMID");
            pSDEFieldModel.setLinkDEFName("PSDEFSFITEMID");
            pSDEFieldModel.setCodeName("PSDEFSFItemId");
            pSDEFieldModel.setMemo("\u641c\u7d22\u8868\u5355\u9879\u4f7f\u7528\u7684\u641c\u7d22\u6a21\u5f0f");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFSFITEMID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFSFITEMID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEFSFITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7a7192b24882b57058bb1f3157ddef52");
            pSDEFieldModel.setName("PSDEFSFITEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u641c\u7d22\u9879\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFSFITEM_PSDEFSFITEMID");
            pSDEFieldModel.setLinkDEFName("PSDEFSFITEMNAME");
            pSDEFieldModel.setCodeName("PSDEFSFItemName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u641c\u7d22\u8868\u5355\u9879\u4f7f\u7528\u7684\u641c\u7d22\u6a21\u5f0f");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFSFITEMNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFSFITEMNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEFSFITEMNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEFSFITEMNAME_LIKE");
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
            pSDEFieldModel.setId("9b638b78ac5a73add30293b6430b06fb");
            pSDEFieldModel.setName("PSDEID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u7f16\u53f7");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFORM_PSDEFORMID");
            pSDEFieldModel.setLinkDEFName("PSDEID");
            pSDEFieldModel.setPhisicalDEField(false);
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
        object = this.createDEField("PSDELOGICID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4b7094d31ab4822a181769c03a1906a9");
            pSDEFieldModel.setName("PSDELOGICID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u754c\u9762\u903b\u8f91");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDELOGIC_PSDELOGICID");
            pSDEFieldModel.setLinkDEFName("PSDELOGICID");
            pSDEFieldModel.setCodeName("PSDELogicId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDELOGICID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDELOGICID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDELOGICNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("4b141d2b0d58943139e058d6231cbae5");
            pSDEFieldModel.setName("PSDELOGICNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u754c\u9762\u903b\u8f91");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDELOGIC_PSDELOGICID");
            pSDEFieldModel.setLinkDEFName("PSDELOGICNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDELogicName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDELOGICNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDELOGICNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDELOGICNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDELOGICNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEUAGROUPID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("da4d97c7e7289c918b9c9ab420bc7e3d");
            pSDEFieldModel.setName("PSDEUAGROUPID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEUAGROUP_PSDEUAGROUPID");
            pSDEFieldModel.setLinkDEFName("PSDEUAGROUPID");
            pSDEFieldModel.setCodeName("PSDEUAGroupId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEUAGROUPID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEUAGROUPID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEUAGROUPNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("d08c9c54348db00adac1a33329800929");
            pSDEFieldModel.setName("PSDEUAGROUPNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEUAGROUP_PSDEUAGROUPID");
            pSDEFieldModel.setLinkDEFName("PSDEUAGROUPNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEUAGroupName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u9762\u677f\u4f7f\u7528\u7684\u754c\u9762\u884c\u4e3a\u7ec4\uff0c\u754c\u9762\u884c\u4e3a\u7ec4\u5c06\u5728\u5206\u7ec4\u9762\u677f\u6807\u9898\u533a\u5c55\u5f00");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEUAGROUPNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEUAGROUPNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEUAGROUPNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEUAGROUPNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEUIACTIONID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9ccad7ae0109d6bba2a72ea7b4235b57");
            pSDEFieldModel.setName("PSDEUIACTIONID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u754c\u9762\u884c\u4e3a");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEUIACTION_PSDEUIACTIONID");
            pSDEFieldModel.setLinkDEFName("PSDEUIACTIONID");
            pSDEFieldModel.setCodeName("PSDEUIActionId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEUIACTIONID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEUIACTIONID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDEUIACTIONNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("66b45a408bcb2c3a9736b9752b7c69e6");
            pSDEFieldModel.setName("PSDEUIACTIONNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5b9e\u4f53\u754c\u9762\u884c\u4e3a");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEUIACTION_PSDEUIACTIONID");
            pSDEFieldModel.setLinkDEFName("PSDEUIACTIONNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSDEUIActionName");
            pSDEFieldModel.setMemo("\u8868\u5355\u6309\u94ae\u5904\u7406\u7c7b\u578b\u3010\u754c\u9762\u884c\u4e3a\u3011\u65f6\u6307\u5b9a\u89e6\u53d1\u7684\u754c\u9762\u884c\u4e3a\u64cd\u4f5c");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEUIACTIONNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEUIACTIONNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDEUIACTIONNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDEUIACTIONNAME_LIKE");
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
            pSDEFieldModel.setId("23a0389ebb606a0641a72609bb463b5b");
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
        object = this.createDEField("PSSYSCOUNTERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("55e68a8d421f55687ca79b117329f85e");
            pSDEFieldModel.setName("PSSYSCOUNTERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8ba1\u6570\u5668");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSCOUNTER_PSSYSCOUNTERID");
            pSDEFieldModel.setLinkDEFName("PSSYSCOUNTERID");
            pSDEFieldModel.setCodeName("PSSysCounterId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
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
            pSDEFieldModel.setId("7f1935538b729cbbdcdb8bd21be984bc");
            pSDEFieldModel.setName("PSSYSCOUNTERNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8ba1\u6570\u5668");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSCOUNTER_PSSYSCOUNTERID");
            pSDEFieldModel.setLinkDEFName("PSSYSCOUNTERNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysCounterName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u52a0\u8f7d\u7684\u8ba1\u6570\u5668\u5bf9\u8c61");
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
            pSDEFieldModel.setId("d4590b6f16a1d2e7a63ac42e0fae0156");
            pSDEFieldModel.setName("PSSYSCSSID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bb9\u5668\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSCSS_PSSYSCSSID");
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
            pSDEFieldModel.setId("40ef42b67c383ae69b686ab16856a463");
            pSDEFieldModel.setName("PSSYSCSSNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bb9\u5668\u6837\u5f0f\u8868");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSCSS_PSSYSCSSID");
            pSDEFieldModel.setLinkDEFName("PSSYSCSSNAME");
            pSDEFieldModel.setCodeName("PSSysCssName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u5bb9\u5668\u6837\u5f0f\u8868");
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
        object = this.createDEField("PSSYSDICTCATID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("c93e4f7ab1c34d22c4ea673d2ee1dfab");
            pSDEFieldModel.setName("PSSYSDICTCATID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u8bcd\u6761\u7c7b\u522b");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSDICTCAT_PSSYSDICTCATID");
            pSDEFieldModel.setLinkDEFName("PSSYSDICTCATID");
            pSDEFieldModel.setCodeName("PSSysDictCatId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDICTCATID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDICTCATID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSDICTCATNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a03ba05a65a859d5d0684742fc81f1d5");
            pSDEFieldModel.setName("PSSYSDICTCATNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8f93\u5165\u8bcd\u6761\u7c7b\u522b");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSDICTCAT_PSSYSDICTCATID");
            pSDEFieldModel.setLinkDEFName("PSSYSDICTCATNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysDictCatName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7f16\u8f91\u5668\u4f7f\u7528\u7684\u8f85\u52a9\u8f93\u5165\u8bcd\u6761\u7c7b\u522b\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDICTCATNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDICTCATNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSDICTCATNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSDICTCATNAME_LIKE");
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
            pSDEFieldModel.setId("e3ba63acd3311e92bb749961fe28d0d9");
            pSDEFieldModel.setName("PSSYSDYNAMODELID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u7cfb\u7edf\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSDYNAMODEL_PSSYSDYNAMODELID");
            pSDEFieldModel.setLinkDEFName("PSSYSDYNAMODELID");
            pSDEFieldModel.setCodeName("PSSysDynaModelId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
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
            pSDEFieldModel.setId("87845fc2b2a8bebb5a6107010c213e46");
            pSDEFieldModel.setName("PSSYSDYNAMODELNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u52a8\u6001\u7cfb\u7edf\u6a21\u578b");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSDYNAMODEL_PSSYSDYNAMODELID");
            pSDEFieldModel.setLinkDEFName("PSSYSDYNAMODELNAME");
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
        object = this.createDEField("PSSYSEDITORSTYLEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ce25ed87da180651604084ab78bed31d");
            pSDEFieldModel.setName("PSSYSEDITORSTYLEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID");
            pSDEFieldModel.setLinkDEFName("PSSYSEDITORSTYLEID");
            pSDEFieldModel.setCodeName("PSSysEditorStyleId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSEDITORSTYLEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSEDITORSTYLEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSEDITORSTYLENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("772d38c04e5f563d533615f7c140880f");
            pSDEFieldModel.setName("PSSYSEDITORSTYLENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7f16\u8f91\u5668\u6837\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID");
            pSDEFieldModel.setLinkDEFName("PSSYSEDITORSTYLENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysEditorStyleName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u7f16\u8f91\u5668\u7684\u6269\u5c55\u6837\u5f0f");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSEDITORSTYLENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSEDITORSTYLENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSEDITORSTYLENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSEDITORSTYLENAME_LIKE");
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
            pSDEFieldModel.setId("49e42309cb0365c0517a97a23f4b6d89");
            pSDEFieldModel.setName("PSSYSIMAGEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u663e\u793a\u56fe\u6807");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSIMAGE_PSSYSIMAGEID");
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
            pSDEFieldModel.setId("42b735dd62ba1f04ec385a31420f6196");
            pSDEFieldModel.setName("PSSYSIMAGENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u663e\u793a\u56fe\u6807");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSIMAGE_PSSYSIMAGEID");
            pSDEFieldModel.setLinkDEFName("PSSYSIMAGENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysImageName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
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
        object = this.createDEField("PSSYSRESOURCEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("fe2d79e0d7d749f0452fb3cd9ca0f39d");
            pSDEFieldModel.setName("PSSYSRESOURCEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSRESOURCE_PSSYSRESOURCEID");
            pSDEFieldModel.setLinkDEFName("PSSYSRESOURCEID");
            pSDEFieldModel.setCodeName("PSSysResourceId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSRESOURCEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSRESOURCEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSSYSRESOURCENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("81dd9635ef01b58542a9bfac86d21f84");
            pSDEFieldModel.setName("PSSYSRESOURCENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u7cfb\u7edf\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSRESOURCE_PSSYSRESOURCEID");
            pSDEFieldModel.setLinkDEFName("PSSYSRESOURCENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("PSSysResourceName");
            pSDEFieldModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u7c7b\u578b\u4e3a\u3010\u76f4\u63a5\u5185\u5bb9\u3011\u6216\u3010html\u5185\u5bb9\u3011\u65f6\u6307\u5b9a\u7cfb\u7edf\u9884\u7f6e\u7684\u8d44\u6e90\u5bf9\u8c61\u8fdb\u884c\u5185\u5bb9\u63d0\u4f9b");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSRESOURCENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSRESOURCENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSSYSRESOURCENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSSYSRESOURCENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RAWCONTENT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("1ab30a14e596bd7fd755c931b9a2ac2d");
            pSDEFieldModel.setName("RAWCONTENT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u76f4\u63a5\u5185\u5bb9");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RawContent");
            pSDEFieldModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u5185\u5bb9\u7c7b\u578b\u4e3a\u3010\u76f4\u63a5\u5185\u5bb9\u3011\u65f6\u6307\u5b9a\u76f4\u63a5\u5185\u5bb9\uff0c\u672a\u6307\u5b9a\u65f6\u4f7f\u7528\u6307\u5b9a\u7684\u7cfb\u7edf\u8d44\u6e90\u5b9a\u4e49\u5185\u5bb9");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RAWCSSSTYLE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3fbf77eacc859be12a07c0db1430025d");
            pSDEFieldModel.setName("RAWCSSSTYLE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u76f4\u63a5\u6837\u5f0f");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RawCssStyle");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RAWSERVICEMETHOD");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("984560040c22eabaf99861a6360a54be");
            pSDEFieldModel.setName("RAWSERVICEMETHOD");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u76f4\u63a5\u670d\u52a1\u8bf7\u6c42\u65b9\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.RequestMethodCodeListModel");
            pSDEFieldModel.setCodeName("RawServiceMethod");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_RAWSERVICEMETHOD_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_RAWSERVICEMETHOD_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RAWSERVICEURL");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3b86eeceee8d087fb0501266bd47dfa4");
            pSDEFieldModel.setName("RAWSERVICEURL");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u76f4\u63a5\u670d\u52a1\u8def\u5f84");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RawServiceUrl");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDEACMODEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6ebc8af2fa9ea19913bd2fdfaaebaec4");
            pSDEFieldModel.setName("REFPSDEACMODEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEACMODE_REFPSDEACMODEID");
            pSDEFieldModel.setLinkDEFName("PSDEACMODEID");
            pSDEFieldModel.setCodeName("RefPSDEACModeId");
            pSDEFieldModel.setMemo("\u7f16\u8f91\u5668\u6307\u5b9a\u81ea\u52a8\u586b\u5145\u914d\u7f6e\uff0c\u9ed8\u8ba4\u4f7f\u7528\u754c\u9762\u6a21\u5f0f\u5b9a\u4e49");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEACMODEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEACMODEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDEACMODENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("9455dce55295039bd40a14df34a484a1");
            pSDEFieldModel.setName("REFPSDEACMODENAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEACMODE_REFPSDEACMODEID");
            pSDEFieldModel.setLinkDEFName("PSDEACMODENAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RefPSDEACModeName");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEACMODENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEACMODENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEACMODENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEACMODENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDEDATASETID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("02e95128d495f64a1b2223a467614b37");
            pSDEFieldModel.setName("REFPSDEDATASETID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEDATASET_REFPSDEDATASETID");
            pSDEFieldModel.setLinkDEFName("PSDEDATASETID");
            pSDEFieldModel.setCodeName("RefPSDEDataSetId");
            pSDEFieldModel.setMemo("\u7f16\u8f91\u5668\u6307\u5b9a\u6570\u636e\u96c6\u5408\uff0c\u9ed8\u8ba4\u4f7f\u7528\u754c\u9762\u6a21\u5f0f\u5b9a\u4e49");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEDATASETID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEDATASETID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDEDATASETNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5a40a27a3efc0afb8ff1aabeb991ddc1");
            pSDEFieldModel.setName("REFPSDEDATASETNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEDATASET_REFPSDEDATASETID");
            pSDEFieldModel.setLinkDEFName("PSDEDATASETNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RefPSDEDataSetName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEDATASETNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEDATASETNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEDATASETNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEDATASETNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDEFORMDETAILID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("312b24da7f61c5067bdca48405eb24d7");
            pSDEFieldModel.setName("REFPSDEFORMDETAILID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u8868\u5355\u6210\u5458\u5f15\u7528");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFORMDETAIL_REFPSDEFORMDETAILID");
            pSDEFieldModel.setLinkDEFName("PSDEFORMDETAILID");
            pSDEFieldModel.setCodeName("RefPSDEFormDetailId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEFORMDETAILID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEFORMDETAILID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDEFORMDETAILNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("357725534e0954e385e7ba2e8dead291");
            pSDEFieldModel.setName("REFPSDEFORMDETAILNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u8868\u5355\u6210\u5458\u5f15\u7528");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFORMDETAIL_REFPSDEFORMDETAILID");
            pSDEFieldModel.setLinkDEFName("PSDEFORMDETAILNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RefPSDEFormDetailName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u90e8\u4ef6\u5f15\u7528\u7684\u8868\u5355\u90e8\u4ef6\u7684\u6210\u5458");
            pSDEFieldModel.setLength(80);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEFORMDETAILNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEFORMDETAILNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEFORMDETAILNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEFORMDETAILNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDEFORMID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5a7515d9a92ba032712f9e819a7f80b2");
            pSDEFieldModel.setName("REFPSDEFORMID");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("REFPSDEFORMID");
            pSDEFieldModel.setDataType("PICKUPDATA");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDEFORMRF_PSDEFORMRFID");
            pSDEFieldModel.setLinkDEFName("MINORPSDEFORMID");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RefPSDEFormId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDEID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6f3682b32e9d688ff756ff748de8bfca");
            pSDEFieldModel.setName("REFPSDEID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDATAENTITY_REFPSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYID");
            pSDEFieldModel.setCodeName("RefPSDEId");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u7f16\u8f91\u5668\u5f15\u7528\u6570\u636e\u96c6\u3001\u81ea\u586b\u914d\u7f6e\u7b49\u5bf9\u8c61\u6240\u5c5e\u7684\u5b9e\u4f53");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDEID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDEID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDENAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8c5ed015ab4a062263b35c8c862b9930");
            pSDEFieldModel.setName("REFPSDENAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDATAENTITY_REFPSDEID");
            pSDEFieldModel.setLinkDEFName("PSDATAENTITYNAME");
            pSDEFieldModel.setCodeName("RefPSDEName");
            pSDEFieldModel.setLength(60);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDENAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDENAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDENAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDENAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDERID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f81633c19aa5c02b028d6cef7a6707d7");
            pSDEFieldModel.setName("REFPSDERID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u5173\u7cfb");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDER_REFPSDERID");
            pSDEFieldModel.setLinkDEFName("PSDERID");
            pSDEFieldModel.setCodeName("RefPSDERId");
            pSDEFieldModel.setMemo("\u591a\u6570\u636e\u90e8\u4ef6\u6210\u5458\u6307\u5b9a\u6570\u636e\u5f15\u7528\u5173\u7cfb");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDERID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDERID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("REFPSDERNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("64c6b6afdeb26f8b0f62d09005f073db");
            pSDEFieldModel.setName("REFPSDERNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5f15\u7528\u5b9e\u4f53\u5173\u7cfb");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSDER_REFPSDERID");
            pSDEFieldModel.setLinkDEFName("PSDERNAME");
            pSDEFieldModel.setCodeName("RefPSDERName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u5f15\u7528\u5b9e\u4f53\u5173\u7cfb");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDERNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDERNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_REFPSDERNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_REFPSDERNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RENDERMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("60a5c8164f94e6ccaab31ca71689fd60");
            pSDEFieldModel.setName("RENDERMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u7ed8\u5236\u6a21\u5f0f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RenderMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RENDERMODETEXT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("6affbd9388594e99831d5973736152c9");
            pSDEFieldModel.setName("RENDERMODETEXT");
            pSDEFieldModel.setDEFType(5);
            pSDEFieldModel.setLogicName("\u7ed8\u5236\u6a21\u5f0f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("RenderModeText");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("RESETITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7716a2a212f0da1f1bed02706f740b80");
            pSDEFieldModel.setName("RESETITEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u91cd\u7f6e\u9879\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ResetItemName");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u76d1\u63a7\u7684\u91cd\u7f6e\u9879\u540d\u79f0\uff0c\u91cd\u7f6e\u9879\u503c\u751f\u53d8\u5316\u65f6\u91cd\u7f6e\u5f53\u524d\u9879");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ROWSPAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("b5bbb00b2c6670c519f8cc866c5924c3");
            pSDEFieldModel.setName("ROWSPAN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u884c\u6570");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("RowSpan");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u7684\u5360\u4f4d\u884c\u6570\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u30101\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SHOWCAPTION");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8d94a5d85a4550bda9955eb0a8a88079");
            pSDEFieldModel.setName("SHOWCAPTION");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u663e\u793a\u6807\u9898");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("ShowCaption");
            pSDEFieldModel.setUserTag2("\u6307\u5b9a\u662f\u5426\u663e\u793a\u6807\u9898\uff0c\u8868\u5355\u9879\u6210\u5458\u5ffd\u7565\u6b64\u53c2\u6570\uff0c\u5176\u5b83\u6210\u5458\u9ed8\u8ba4\u663e\u793a\u6807\u9898");
            pSDEFieldModel.setMemo("\u662f\u5426\u663e\u793a\u6807\u9898\uff0c\u9ed8\u8ba4\u3010\u662f\u3011");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SHOWMOREMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("36e0b286ca248645d14a3b97c4549079");
            pSDEFieldModel.setName("SHOWMOREMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u663e\u793a\u66f4\u591a\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDetailShowMoreModeCodeListModel");
            pSDEFieldModel.setCodeName("ShowMoreMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u7684\u663e\u793a\u66f4\u591a\u6a21\u5f0f\uff0c\u4e3a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SHOWMOREMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SHOWMOREMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SPACINGBOTTOM");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ddda3eb249b848eb5e883abcaef866cd");
            pSDEFieldModel.setName("SPACINGBOTTOM");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e0b\u65b9\u95f4\u9694");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.SpacingModeCodeListModel");
            pSDEFieldModel.setCodeName("SpacingBottom");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SPACINGBOTTOM_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SPACINGBOTTOM_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SPACINGLEFT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("3133679eaeed699ccc33fbd237ddecc1");
            pSDEFieldModel.setName("SPACINGLEFT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5de6\u4fa7\u95f4\u9694");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.SpacingModeCodeListModel");
            pSDEFieldModel.setCodeName("SpacingLeft");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SPACINGLEFT_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SPACINGLEFT_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SPACINGRIGHT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("02f00179312e6ad59f078a36b20c8c21");
            pSDEFieldModel.setName("SPACINGRIGHT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u53f3\u4fa7\u95f4\u9694");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.SpacingModeCodeListModel");
            pSDEFieldModel.setCodeName("SpacingRight");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SPACINGRIGHT_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SPACINGRIGHT_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SPACINGTOP");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8bad8464d2393f13c5ea7ec08f6ae6b8");
            pSDEFieldModel.setName("SPACINGTOP");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u4e0a\u65b9\u95f4\u9694");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.SpacingModeCodeListModel");
            pSDEFieldModel.setCodeName("SpacingTop");
            pSDEFieldModel.setLength(20);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_SPACINGTOP_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_SPACINGTOP_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("SWAPMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("a2ed30feb1f722224e2c24f1e25eeb08");
            pSDEFieldModel.setName("SWAPMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5185\u5bb9\u6362\u884c\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.WrapModeCodeListModel");
            pSDEFieldModel.setCodeName("SwapMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u6587\u672c\u7684\u6362\u884c\u6a21\u5f0f");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TEMPLATEMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("ae69a07e73da0879d9200d1d107b84a9");
            pSDEFieldModel.setName("TEMPLATEMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6a21\u677f\u6a21\u5f0f");
            pSDEFieldModel.setDataType("YESNO");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
            pSDEFieldModel.setCodeName("TemplateMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u76f4\u63a5\u5185\u5bb9\u8f93\u51fa\u662f\u5426\u4f7f\u7528\u6a21\u677f\u673a\u5236\uff0c\u9ed8\u8ba4\u4e3a\u3010\u5426\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TEMPLATEMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TEMPLATEMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TIPPSLANRESID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8fc7d3a34480f03280581a02d34997bc");
            pSDEFieldModel.setName("TIPPSLANRESID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63d0\u793a\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSLANGUAGERES_TIPPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESID");
            pSDEFieldModel.setCodeName("TipPSLanResId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TIPPSLANRESID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TIPPSLANRESID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TIPPSLANRESNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f9ac4fd5511eae51ef0b51bf97248d13");
            pSDEFieldModel.setName("TIPPSLANRESNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63d0\u793a\u8bed\u8a00\u8d44\u6e90");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSLANGUAGERES_TIPPSLANRESID");
            pSDEFieldModel.setLinkDEFName("PSLANGUAGERESNAME");
            pSDEFieldModel.setCodeName("TipPSLanResName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TIPPSLANRESNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TIPPSLANRESNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TIPPSLANRESNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TIPPSLANRESNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TITLEBARCLOSEMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("cd671a44970182a68e55fcf80fc64440");
            pSDEFieldModel.setName("TITLEBARCLOSEMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTitleBarCloseModeCodeListModel");
            pSDEFieldModel.setCodeName("TitleBarCloseMode");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u5173\u95ed\u3011");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TITLEBARCLOSEMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TITLEBARCLOSEMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TOGGLEMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("94b893c2bb527827ec61fe7e55f33c67");
            pSDEFieldModel.setName("TOGGLEMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5207\u6362\u6a21\u5f0f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ToggleMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TOOLTIPINFO");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("db98c1a563dc8e5ceff916439a316035");
            pSDEFieldModel.setName("TOOLTIPINFO");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63d0\u793a\u4fe1\u606f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("TooltipInfo");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UCPSSYSPFPLUGINID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("72ef77c7f5d63f3e9fc7e454832c8206");
            pSDEFieldModel.setName("UCPSSYSPFPLUGINID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u524d\u7aef\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUP");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSPFPLUGIN_UCPSSYSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSPFPLUGINID");
            pSDEFieldModel.setCodeName("UCPSSysPFPluginId");
            pSDEFieldModel.setLength(100);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_UCPSSYSPFPLUGINID_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_UCPSSYSPFPLUGINID_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UCPSSYSPFPLUGINNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7b8f4cfdc15ab8be6188fa4b6c7afa5c");
            pSDEFieldModel.setName("UCPSSYSPFPLUGINNAME");
            pSDEFieldModel.setDEFType(3);
            pSDEFieldModel.setLogicName("\u81ea\u5b9a\u4e49\u524d\u7aef\u63d2\u4ef6");
            pSDEFieldModel.setDataType("PICKUPTEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setLinkDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setDERName("DER1N_PSDEFORMDETAIL_PSSYSPFPLUGIN_UCPSSYSPFPLUGINID");
            pSDEFieldModel.setLinkDEFName("PSSYSPFPLUGINNAME");
            pSDEFieldModel.setPhisicalDEField(false);
            pSDEFieldModel.setCodeName("UCPSSysPFPluginName");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_UCPSSYSPFPLUGINNAME_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_UCPSSYSPFPLUGINNAME_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            if ((iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_UCPSSYSPFPLUGINNAME_LIKE")) == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_UCPSSYSPFPLUGINNAME_LIKE");
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
            pSDEFieldModel.setId("3349e14b2b952a54ccbc916b71d48b36");
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
        object = this.createDEField("UPDATEDV");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("63e3015cc5928b9810b8236f2fec9714");
            pSDEFieldModel.setName("UPDATEDV");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u65b0\u9ed8\u8ba4\u503c");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("UpdateDV");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setUserTag2("\u6307\u5b9a\u8868\u5355\u9879\u7684\u66f4\u65b0\u9ed8\u8ba4\u503c\uff0c\u672a\u6307\u5b9a\u9ed8\u8ba4\u503c\u7c7b\u578b\u65f6\u6309\u76f4\u63a5\u503c\u5904\u7406");
            pSDEFieldModel.setLength(500);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEDVT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8624dc05172003027900dba3ad61d749");
            pSDEFieldModel.setName("UPDATEDVT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u66f4\u65b0\u9ed8\u8ba4\u503c\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldDefaultValueType2CodeListModel");
            pSDEFieldModel.setCodeName("UpdateDVT");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL2");
            pSDEFieldModel.setMemo("\u66f4\u65b0\u9ed8\u8ba4\u503c\u7c7b\u578b\uff0c\u9ed8\u8ba4\u4e3a\u3010\u76f4\u63a5\u503c\u3011");
            pSDEFieldModel.setLength(50);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_UPDATEDVT_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_UPDATEDVT_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEMAN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("f24167275997b01bc923861c082a0417");
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
            pSDEFieldModel.setId("04d8faaba3964b63d09fb613096f91ec");
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
            pSDEFieldModel.setId("2e78ddd1e06e7607f70c3de68c35bd9e");
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
        object = this.createDEField("VALIGN");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("153e387bc8a16ce2d6c816498b6e03ca");
            pSDEFieldModel.setName("VALIGN");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5782\u76f4\u5bf9\u9f50");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TextVAlignCodeListModel");
            pSDEFieldModel.setCodeName("VAlign");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_VALIGN_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_VALIGN_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VALIGNSELF");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e38b25f8cab3ebff2ab648659ae1a378");
            pSDEFieldModel.setName("VALIGNSELF");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5782\u76f4\u5bf9\u9f50\uff08\u81ea\u8eab\uff09");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.TextVAlignCodeListModel");
            pSDEFieldModel.setCodeName("VAlignSelf");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_VALIGNSELF_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_VALIGNSELF_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VALUEFORMAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8aea57e6e9af2240e0cf34739820d206");
            pSDEFieldModel.setName("VALUEFORMAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u503c\u683c\u5f0f\u5316");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ValueFormat");
            pSDEFieldModel.setMemo("\u8868\u5355\u9879\u7684\u503c\u683c\u5f0f\u5316\u4e32");
            pSDEFieldModel.setLength(50);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VALUEITEMNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("13c4245a431e955c37120fead7ce536c");
            pSDEFieldModel.setName("VALUEITEMNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u503c\u9879\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ValueItemName");
            pSDEFieldModel.setMemo("\u7f16\u8f91\u5668\u5b9e\u9645\u503c\u9879\u56de\u586b\u7684\u8868\u5355\u9879");
            pSDEFieldModel.setLength(60);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("VISIBLELOGIC");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("e7aec273b57b3d5be81847e2b25bf607");
            pSDEFieldModel.setName("VISIBLELOGIC");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u53ef\u89c1\u903b\u8f91");
            pSDEFieldModel.setDataType("LONGTEXT");
            pSDEFieldModel.setStdDataType(21);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("VisibleLogic");
            pSDEFieldModel.setUserTag("IGNOREMODELV2");
            pSDEFieldModel.setLength(0x100000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WBDEFMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("acef2705f78253201370abb64af2c43a");
            pSDEFieldModel.setName("WBDEFMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u56de\u5199\u5c5e\u6027\u503c\u6a21\u5f0f");
            pSDEFieldModel.setDataType("NSCODELIST");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FIWriteBackDEFModeCodeListModel");
            pSDEFieldModel.setCodeName("WBDEFMode");
            pSDEFieldModel.setUserTag("IGNOREMODELDSL");
            pSDEFieldModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u56de\u5199\u5c5e\u6027\u503c\u7684\u6a21\u5f0f");
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_WBDEFMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_WBDEFMODE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIDTH");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("2fcb5c5639d38872ab3a3bb2bf48f776");
            pSDEFieldModel.setName("WIDTH");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bbd\u5ea6");
            pSDEFieldModel.setDataType("INT");
            pSDEFieldModel.setStdDataType(9);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Width");
            pSDEFieldModel.setMemo("\u5bbd\u5ea6\uff0c\u9ed8\u8ba4\u4e3a0\uff08\u81ea\u9002\u5e94\u5bb9\u5668\u5bbd\u5ea6\uff09");
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("WIDTHMODE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("535e4cf886fa9a63060b6f795611886c");
            pSDEFieldModel.setName("WIDTHMODE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5bbd\u5ea6\u6a21\u5f0f");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.WidthModeCodeListModel");
            pSDEFieldModel.setCodeName("WidthMode");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_WIDTHMODE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_WIDTHMODE_EQ");
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
        PSDEFormDetailDefaultACModel pSDEFormDetailDefaultACModel = new PSDEFormDetailDefaultACModel();
        pSDEFormDetailDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDEFormDetailDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDEFormDetailCurFormFIDSModel pSDEFormDetailCurFormFIDSModel = new PSDEFormDetailCurFormFIDSModel();
        pSDEFormDetailCurFormFIDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEFormDetailCurFormFIDSModel);
        PSDEFormDetailDefaultDSModel pSDEFormDetailDefaultDSModel = new PSDEFormDetailDefaultDSModel();
        pSDEFormDetailDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEFormDetailDefaultDSModel);
        PSDEFormDetailFIDSModel pSDEFormDetailFIDSModel = new PSDEFormDetailFIDSModel();
        pSDEFormDetailFIDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEFormDetailFIDSModel);
        PSDEFormDetailFormItemDSModel pSDEFormDetailFormItemDSModel = new PSDEFormDetailFormItemDSModel();
        pSDEFormDetailFormItemDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDEFormDetailFormItemDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDEFormDetailCurFormItemDQModel pSDEFormDetailCurFormItemDQModel = new PSDEFormDetailCurFormItemDQModel();
        pSDEFormDetailCurFormItemDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEFormDetailCurFormItemDQModel);
        PSDEFormDetailDefaultDQModel pSDEFormDetailDefaultDQModel = new PSDEFormDetailDefaultDQModel();
        pSDEFormDetailDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEFormDetailDefaultDQModel);
        PSDEFormDetailFIDQModel pSDEFormDetailFIDQModel = new PSDEFormDetailFIDQModel();
        pSDEFormDetailFIDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEFormDetailFIDQModel);
        PSDEFormDetailFormItemDQModel pSDEFormDetailFormItemDQModel = new PSDEFormDetailFormItemDQModel();
        pSDEFormDetailFormItemDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDEFormDetailFormItemDQModel);
    }

    protected void prepareDEActions() throws Exception {
    }

    protected void prepareDELogics() throws Exception {
        PSDEFormDetailCalcRefPSDEFormIdLogicModel pSDEFormDetailCalcRefPSDEFormIdLogicModel = new PSDEFormDetailCalcRefPSDEFormIdLogicModel();
        pSDEFormDetailCalcRefPSDEFormIdLogicModel.init((IDataEntity)this);
        this.registerDELogic((IDELogic)pSDEFormDetailCalcRefPSDEFormIdLogicModel);
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
        this.registerPDTDEView("EDITVIEW", "885f1e229fe704c731ccd4fd3ab8e3e8");
        this.registerPDTDEView("EDITVIEW:BUTTON", "06D35B9F-99AD-45F0-8C68-6CB6E5659743");
        this.registerPDTDEView("EDITVIEW:DRUIPART", "8D531C3C-A982-488E-9240-598710FF0554");
        this.registerPDTDEView("EDITVIEW:FORMITEM", "998782A8-FE95-4EA3-990A-38F3BAFA419D");
        this.registerPDTDEView("EDITVIEW:FORMITEMEX", "758CF9BC-5453-4B35-8A26-74F623E1680D");
        this.registerPDTDEView("EDITVIEW:FORMPAGE", "1FDF2D87-E2CE-4828-9B56-32762CC7C8F1");
        this.registerPDTDEView("EDITVIEW:FORMPART", "B60532B6-6B0B-443E-9066-E6522887C9FE");
        this.registerPDTDEView("EDITVIEW:GROUPPANEL", "E1FE9E3E-3F93-45D0-A42D-18ECB3DB1228");
        this.registerPDTDEView("EDITVIEW:IFRAME", "E34AD48A-4798-43D6-87C0-3D347BB512A8");
        this.registerPDTDEView("EDITVIEW:MDCTRL", "686E1518-F40B-45B0-9D1B-F1346BBC8A47");
        this.registerPDTDEView("EDITVIEW:RAWITEM", "DEA3EB0D-7390-49E4-89C0-0E60AD1584E5");
        this.registerPDTDEView("EDITVIEW:TABPAGE", "4D36E16C-11B1-4CC9-9E88-E7E40038C369");
        this.registerPDTDEView("EDITVIEW:TABPANEL", "EB061F7A-387F-4D32-97B4-C2A689BEF735");
        this.registerPDTDEView("EDITVIEW:USERCONTROL", "0DC274A8-B27E-4B6A-8F15-03F6514536E8");
        this.registerPDTDEView("MPICKUPVIEW", "9cd4c6ee333b34a99fe75d7be1a583da");
        this.registerPDTDEView("PICKUPVIEW", "6e50d1b1b347efe146bcdaec2b902766");
        this.registerPDTDEView("REDIRECTVIEW", "74b579c3e7e2573e435daafb419700eb");
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
        dEDataSetCond2.setDEFName("PSDEFORMDETAILNAME");
        dEDataSetCond2.setCondValue(string);
        dEDataSetCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)dEDataSetCond2);
    }

    @Override
    protected void onPreparePSDEFGroupModels() throws Exception {
        IPSDEFGroupModel iPSDEFGroupModel = this.preparePSDEFGroupModel_BUTTON();
        if (iPSDEFGroupModel != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_DRUIPART()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_FORMITEM()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_FORMITEMEX()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_FORMPAGE()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_FORMPART()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_GROUPPANEL()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_IFRAME()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_MDCTRL()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_RAWITEM()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_TABPAGE()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_TABPANEL()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel_USERCONTROL()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
        if ((iPSDEFGroupModel = this.preparePSDEFGroupModel__DEFAULT()) != null) {
            this.registerPSDEFGroupModel(iPSDEFGroupModel);
        }
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_BUTTON() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("BUTTON");
        pSDEFGroupModel.setName("\u8868\u5355\u6309\u94ae");
        pSDEFGroupModel.setUserTag("BUTTON");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("274703b2a4bc3769091f4aaddd953a29");
        pSDEFGroupDetailModel.setName("BTNACTIONTYPE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("BTNACTIONTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormButtonActionTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u6309\u94ae\u5904\u7406\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("da1fe9caa70b71eb08d9e6fcfb6b53ab");
        pSDEFGroupDetailModel.setName("CAPPSLANRESID");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("269aa4eda4bc7b77015ac0ec90e02e3b");
        pSDEFGroupDetailModel.setName("CAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("76521f0a30226e424d1fe23e14cbbbc7");
        pSDEFGroupDetailModel.setName("CAPTION");
        iPSDEFieldModel = this.getDEField("CAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9edac5065f5ab52809b632502026543c");
        pSDEFGroupDetailModel.setName("EDITORPARAMS");
        iPSDEFieldModel = this.getDEField("EDITORPARAMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f20\u9012\u7ed9\u9644\u52a0\u6570\u636e\u9009\u62e9\u89c6\u56fe\u7684\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("510601108256a8fc1140aab2d8d02b43");
        pSDEFGroupDetailModel.setName("FORMTYPE");
        iPSDEFieldModel = this.getDEField("FORMTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01296429cd95fb7a43003fcf46a19035");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSID");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("40625ae4923f99e988d69f755b9ac465");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f6dac62ea4ffd9d7529bea6edcce87ec");
        pSDEFGroupDetailModel.setName("PSDEFIUPDATEID");
        iPSDEFieldModel = this.getDEField("PSDEFIUPDATEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u6309\u94ae\u5904\u7406\u7c7b\u578b\u3010\u8868\u5355\u9879\u66f4\u65b0\u3011\u65f6\u6307\u5b9a\u89e6\u53d1\u7684\u8868\u5355\u9879\u66f4\u65b0\u64cd\u4f5c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4f4cb3b8c53e6d31eb3fac61ba46b5fc");
        pSDEFGroupDetailModel.setName("PSDEFIUPDATENAME");
        iPSDEFieldModel = this.getDEField("PSDEFIUPDATENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u6309\u94ae\u5904\u7406\u7c7b\u578b\u3010\u8868\u5355\u9879\u66f4\u65b0\u3011\u65f6\u6307\u5b9a\u89e6\u53d1\u7684\u8868\u5355\u9879\u66f4\u65b0\u64cd\u4f5c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9b638b78ac5a73add30293b6430b06fb");
        pSDEFGroupDetailModel.setName("PSDEID");
        iPSDEFieldModel = this.getDEField("PSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9ccad7ae0109d6bba2a72ea7b4235b57");
        pSDEFGroupDetailModel.setName("PSDEUIACTIONID");
        iPSDEFieldModel = this.getDEField("PSDEUIACTIONID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u6309\u94ae\u5904\u7406\u7c7b\u578b\u3010\u754c\u9762\u884c\u4e3a\u3011\u65f6\u6307\u5b9a\u89e6\u53d1\u7684\u754c\u9762\u884c\u4e3a\u64cd\u4f5c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("66b45a408bcb2c3a9736b9752b7c69e6");
        pSDEFGroupDetailModel.setName("PSDEUIACTIONNAME");
        iPSDEFieldModel = this.getDEField("PSDEUIACTIONNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u6309\u94ae\u5904\u7406\u7c7b\u578b\u3010\u754c\u9762\u884c\u4e3a\u3011\u65f6\u6307\u5b9a\u89e6\u53d1\u7684\u754c\u9762\u884c\u4e3a\u64cd\u4f5c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49e42309cb0365c0517a97a23f4b6d89");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("42b735dd62ba1f04ec385a31420f6196");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51014af0b839103f5cd8d6536ef4dfbb");
        pSDEFGroupDetailModel.setName("PICKUPPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("PICKUPPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6309\u94ae\u70b9\u51fb\u89e6\u53d1\u64cd\u4f5c\u4e4b\u524d\u5f39\u51fa\u7684\u9644\u52a0\u6570\u636e\u9009\u62e9\u89c6\u56fe");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3117eb1dc697b49f87720fa1aa5f1b6f");
        pSDEFGroupDetailModel.setName("PICKUPPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("PICKUPPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6309\u94ae\u70b9\u51fb\u89e6\u53d1\u64cd\u4f5c\u4e4b\u524d\u5f39\u51fa\u7684\u9644\u52a0\u6570\u636e\u9009\u62e9\u89c6\u56fe");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8d94a5d85a4550bda9955eb0a8a88079");
        pSDEFGroupDetailModel.setName("SHOWCAPTION");
        iPSDEFieldModel = this.getDEField("SHOWCAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u662f\u5426\u663e\u793a\u6807\u9898\uff0c\u9ed8\u8ba4\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("72ef77c7f5d63f3e9fc7e454832c8206");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7b8f4cfdc15ab8be6188fa4b6c7afa5c");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("13c4245a431e955c37120fead7ce536c");
        pSDEFGroupDetailModel.setName("VALUEITEMNAME");
        iPSDEFieldModel = this.getDEField("VALUEITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u52a8\u6001\u6807\u9898\u7684\u53d6\u503c\u8868\u5355\u9879");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_DRUIPART() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("DRUIPART");
        pSDEFGroupModel.setName("\u6570\u636e\u5173\u7cfb\u754c\u9762");
        pSDEFGroupModel.setUserTag("DRUIPART");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49223abdaa12308c9099355e43fb35c1");
        pSDEFGroupDetailModel.setName("BUILDINACTION");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("BUILDINACTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDRPartRefreshIgnoreActionCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u9762\u677f\u63d0\u4f9b\u5185\u7f6e\u64cd\u4f5c\u529f\u80fd\uff0c\u4e00\u822c\u5e94\u7528\u4e8e\u5206\u7ec4\u5305\u542b\u591a\u6570\u636e\u754c\u9762\u90e8\u4ef6\u573a\u5408\uff0c\u8c03\u7528\u591a\u6570\u636e\u90e8\u4ef6\u754c\u9762\u63d0\u4f9b\u7684\u76f8\u5173\u529f\u80fd");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("510601108256a8fc1140aab2d8d02b43");
        pSDEFGroupDetailModel.setName("FORMTYPE");
        iPSDEFieldModel = this.getDEField("FORMTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1b22e2f100eb2b642724e57663a51096");
        pSDEFGroupDetailModel.setName("MASKINFO");
        iPSDEFieldModel = this.getDEField("MASKINFO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4c5481981feab282fa5a5a6b9b26d05b");
        pSDEFGroupDetailModel.setName("MASKMODE");
        iPSDEFieldModel = this.getDEField("MASKMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDRUIPartMaskModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9d9390f00ca06358fdadf03359135315");
        pSDEFGroupDetailModel.setName("PSDEDRITEMID");
        iPSDEFieldModel = this.getDEField("PSDEDRITEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5173\u7cfb\u754c\u9762\u90e8\u4ef6\u5d4c\u5165\u7684\u5173\u7cfb\u754c\u9762");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c9043d75d61d700bc54f7f8dfcba1847");
        pSDEFGroupDetailModel.setName("PSDEDRITEMNAME");
        iPSDEFieldModel = this.getDEField("PSDEDRITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5173\u7cfb\u754c\u9762\u90e8\u4ef6\u5d4c\u5165\u7684\u5173\u7cfb\u754c\u9762");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f6dac62ea4ffd9d7529bea6edcce87ec");
        pSDEFGroupDetailModel.setName("PSDEFIUPDATEID");
        iPSDEFieldModel = this.getDEField("PSDEFIUPDATEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u754c\u9762\u5237\u65b0\u65f6\u89e6\u53d1\u7684\u8868\u5355\u9879\u66f4\u65b0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4f4cb3b8c53e6d31eb3fac61ba46b5fc");
        pSDEFGroupDetailModel.setName("PSDEFIUPDATENAME");
        iPSDEFieldModel = this.getDEField("PSDEFIUPDATENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u754c\u9762\u5237\u65b0\u65f6\u89e6\u53d1\u7684\u8868\u5355\u9879\u66f4\u65b0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9b638b78ac5a73add30293b6430b06fb");
        pSDEFGroupDetailModel.setName("PSDEID");
        iPSDEFieldModel = this.getDEField("PSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7716a2a212f0da1f1bed02706f740b80");
        pSDEFGroupDetailModel.setName("RESETITEMNAME");
        iPSDEFieldModel = this.getDEField("RESETITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u754c\u9762\u7684\u9644\u52a0\u5237\u65b0\u9879\uff0c\u591a\u9879\u4f7f\u7528\u3010;\u3011\u5206\u9694\u3002\u8868\u5355\u4e3b\u952e\u3010srfkey\u3011\u53d8\u5316\u65f6\u9ed8\u8ba4\u5237\u65b0\u5173\u7cfb\u754c\u9762");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("72ef77c7f5d63f3e9fc7e454832c8206");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7b8f4cfdc15ab8be6188fa4b6c7afa5c");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("13c4245a431e955c37120fead7ce536c");
        pSDEFGroupDetailModel.setName("VALUEITEMNAME");
        iPSDEFieldModel = this.getDEField("VALUEITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f20\u9012\u7ed9\u5173\u7cfb\u754c\u9762\u7684\u53c2\u6570\u9879\uff0c\u9ed8\u8ba4\u4e3a\u3010srfkey\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("acef2705f78253201370abb64af2c43a");
        pSDEFGroupDetailModel.setName("WBDEFMODE");
        iPSDEFieldModel = this.getDEField("WBDEFMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5173\u7cfb\u754c\u9762\u5728\u8868\u5355\u8fdb\u884c\u4fdd\u5b58\u64cd\u4f5c\u65f6\u662f\u5426\u540c\u65f6\u8c03\u7528\u5173\u7cfb\u754c\u9762\u4fdd\u5b58\u6570\u636e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_FORMITEM() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("FORMITEM");
        pSDEFGroupModel.setName("\u8868\u5355\u9879");
        pSDEFGroupModel.setUserTag("FORMITEM");
        pSDEFGroupModel.setMemo("\u8868\u5355\u9879\u6210\u5458\u4f1a\u5173\u8054\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\uff08\u6307\u5b9a\u6216\u81ea\u52a8\u8ba1\u7b97\uff09\uff0c\u8868\u5355\u9879\u7684\u67d0\u4e9b\u914d\u7f6e\u5728\u672a\u5b9a\u4e49\u65f6\u4f1a\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\u503c\uff0c\u8fd9\u79cd\u60c5\u51b5\u8981\u6c42\u8868\u5355\u9879\u7684\u7f16\u8f91\u5668\u7c7b\u578b\u4e0e\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u5668\u7c7b\u578b\u5fc5\u987b\u4e00\u81f4\uff0c\u907f\u514d\u903b\u8f91\u6df7\u6dc6\u3002\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\u4e5f\u662f\u4e00\u79cd\u5c5e\u6027\u754c\u9762\u6a21\u5f0f");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("08d3e9f32920cd9349e76a1f6d49706d");
        pSDEFGroupDetailModel.setName("ALLOWEMPTY");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("ALLOWEMPTY", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u9879\u662f\u5426\u5141\u8bb8\u7a7a\u8f93\u5165");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eed4cbd6283104fd60670933a16766bb");
        pSDEFGroupDetailModel.setName("BLANKLOGIC");
        iPSDEFieldModel = this.getDEField("BLANKLOGIC", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("da1fe9caa70b71eb08d9e6fcfb6b53ab");
        pSDEFGroupDetailModel.setName("CAPPSLANRESID");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("269aa4eda4bc7b77015ac0ec90e02e3b");
        pSDEFGroupDetailModel.setName("CAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("76521f0a30226e424d1fe23e14cbbbc7");
        pSDEFGroupDetailModel.setName("CAPTION");
        iPSDEFieldModel = this.getDEField("CAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("623c5a9d1b7ceecee65606fd83893f47");
        pSDEFGroupDetailModel.setName("CODELISTCONFIGMODE");
        iPSDEFieldModel = this.getDEField("CODELISTCONFIGMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.OutputCodeListConfigModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("144d290cc05d5f78cf4faba6fad1f6fb");
        pSDEFGroupDetailModel.setName("CONVERTCITEXT");
        iPSDEFieldModel = this.getDEField("CONVERTCITEXT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u5728\u8868\u5355\u9879\u6307\u5b9a\u4ee3\u7801\u8868\u60c5\u51b5\u4e0b\uff0c\u6307\u5b9a\u662f\u5426\u5c06\u4ee3\u7801\u503c\u8f6c\u6362\u4e3a\u6587\u672c\u8f93\u51fa\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u8868\u5355\u9879\u7684\u7f16\u8f91\u5668\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2d1024aa0e789e5cc87a0836a4915820");
        pSDEFGroupDetailModel.setName("CREATEDV");
        iPSDEFieldModel = this.getDEField("CREATEDV", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4a8fe5541123224fca23781b512fc139");
        pSDEFGroupDetailModel.setName("CREATEDVT");
        iPSDEFieldModel = this.getDEField("CREATEDVT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldDefaultValueTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u9879\u7684\u65b0\u5efa\u9ed8\u8ba4\u503c\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u76f4\u63a5\u503c\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("743110fc4b02314efd87f0b5f0f5f55a");
        pSDEFGroupDetailModel.setName("CTRLCOLSPAN");
        iPSDEFieldModel = this.getDEField("CTRLCOLSPAN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6805\u683c\u5e03\u5c40\u65f6\u8868\u5355\u9879\u5bb9\u5668\u4e2d\u7f16\u8f91\u63a7\u4ef6\u7684\u5360\u4f4d\u5217\u6570\uff0c\u6b64\u53c2\u6570\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559\uff0c\u73b0\u5df2\u4e0d\u518d\u4f7f\u7528");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5afed07492d48e30752a92ef58d3451f");
        pSDEFGroupDetailModel.setName("CTRLHEIGHT");
        iPSDEFieldModel = this.getDEField("CTRLHEIGHT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u9ad8\u5ea6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8933f03cf450132fb2491fd8ca7733b3");
        pSDEFGroupDetailModel.setName("CTRLWIDTH");
        iPSDEFieldModel = this.getDEField("CTRLWIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u5bbd\u5ea6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9edac5065f5ab52809b632502026543c");
        pSDEFGroupDetailModel.setName("EDITORPARAMS");
        iPSDEFieldModel = this.getDEField("EDITORPARAMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7f16\u8f91\u5668\u7684\u53c2\u6570\uff0c\u5982\u8868\u5355\u9879\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\u7f16\u8f91\u5668\u7c7b\u578b\u4e0e\u5f53\u524d\u7f16\u8f91\u5668\u4e00\u81f4\uff0c\u540c\u65f6\u9644\u52a0\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u5668\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a554d79b3564b10c0485ba827e39a3c4");
        pSDEFGroupDetailModel.setName("EDITORTYPE");
        iPSDEFieldModel = this.getDEField("EDITORTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.EditorTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e939ddbbf95c506f41256dff384bbd1d");
        pSDEFGroupDetailModel.setName("EMPTYCAPTION");
        iPSDEFieldModel = this.getDEField("EMPTYCAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u662f\u5426\u542f\u7528\u7a7a\u767d\u6807\u7b7e\u5360\u4f4d\u3002\u9ed8\u8ba4\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c0d6cb638c87dc0887ef566aca3a505e");
        pSDEFGroupDetailModel.setName("ENABLEANCHOR");
        iPSDEFieldModel = this.getDEField("ENABLEANCHOR", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u542f\u7528\u951a\u70b9\u63d0\u4f9b\u4e86\u5b9a\u4f4d\u5f53\u524d\u9879\u80fd\u529b\uff0c\u9ed8\u8ba4\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("668ceb8504d4e482564989c7544aaec7");
        pSDEFGroupDetailModel.setName("ENABLECOND");
        iPSDEFieldModel = this.getDEField("ENABLECOND", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormItemEnableCondCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u9879\u7684\u9759\u6001\u542f\u7528\u6761\u4ef6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8156bb1b5c6550e15d17812bc75b9917");
        pSDEFGroupDetailModel.setName("ENABLEITEMPRIV");
        iPSDEFieldModel = this.getDEField("ENABLEITEMPRIV", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u662f\u5426\u542f\u7528\u5217\u6743\u9650\u63a7\u5236\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5c5e\u6027\u51b3\u5b9a\uff0c\u65e0\u5b9e\u4f53\u5c5e\u6027\u5219\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d1b23fd6e724260ed4d05b5d7577db1f");
        pSDEFGroupDetailModel.setName("ENABLELOGIC");
        iPSDEFieldModel = this.getDEField("ENABLELOGIC", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("510601108256a8fc1140aab2d8d02b43");
        pSDEFGroupDetailModel.setName("FORMTYPE");
        iPSDEFieldModel = this.getDEField("FORMTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c2a675e41e203417f0631bc4ace6ccaa");
        pSDEFGroupDetailModel.setName("IGNOREINPUT");
        iPSDEFieldModel = this.getDEField("IGNOREINPUT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FIValueIgnoreModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u4f55\u79cd\u60c5\u51b5\u4e0b\u4f1a\u5ffd\u7565\u8868\u5355\u9879\u7684\u8f93\u5165\u503c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a6419a98cc18fabc64209e9db24c493a");
        pSDEFGroupDetailModel.setName("ITEMPSACHANDLERID");
        iPSDEFieldModel = this.getDEField("ITEMPSACHANDLERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u754c\u9762\u5904\u7406\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e8d7a99b8f679f017538ec4995625ef4");
        pSDEFGroupDetailModel.setName("ITEMPSACHANDLERNAME");
        iPSDEFieldModel = this.getDEField("ITEMPSACHANDLERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u754c\u9762\u5904\u7406\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4ef3619c387ca8746cff85c0660f9243");
        pSDEFGroupDetailModel.setName("LABELCOLSPAN");
        iPSDEFieldModel = this.getDEField("LABELCOLSPAN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6805\u683c\u5e03\u5c40\u65f6\u8868\u5355\u9879\u5bb9\u5668\u4e2d\u6807\u7b7e\u7684\u5360\u4f4d\u5217\u6570\uff0c\u6b64\u53c2\u6570\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559\uff0c\u73b0\u5df2\u4e0d\u518d\u4f7f\u7528");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01296429cd95fb7a43003fcf46a19035");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSID");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("40625ae4923f99e988d69f755b9ac465");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ae76ed5d4fd3c353c2fd22232ec2a0f8");
        pSDEFGroupDetailModel.setName("LABELPOS");
        iPSDEFieldModel = this.getDEField("LABELPOS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormItemLabelPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u6807\u7b7e\u7684\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5de6\u8fb9\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f180130a56ccc316e14961f3c9293e04");
        pSDEFGroupDetailModel.setName("LABELWIDTH");
        iPSDEFieldModel = this.getDEField("LABELWIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u6807\u7b7e\u7684\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u8868\u5355\u9ed8\u8ba4\u6807\u7b7e\u5bbd\u5ea6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8952b6dfe0925c5806c2071bc7732efb");
        pSDEFGroupDetailModel.setName("LEVELTAG");
        iPSDEFieldModel = this.getDEField("LEVELTAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u52a8\u6001\u6807\u9898\u7ed1\u5b9a\u7684\u8868\u5355\u9879");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3042199642034714df10d98549f855ca");
        pSDEFGroupDetailModel.setName("LINKPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("LINKPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u5f15\u7528\u6570\u636e\u7684\u94fe\u63a5\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3403f1d024dc9311125499b511a97dc9");
        pSDEFGroupDetailModel.setName("LINKPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("LINKPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u5f15\u7528\u6570\u636e\u7684\u94fe\u63a5\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7efc596ba7327afa69911558483aa92a");
        pSDEFGroupDetailModel.setName("LOGICNAME");
        iPSDEFieldModel = this.getDEField("LOGICNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u903b\u8f91\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("41ecea324ce07e15b7c011867bd0ff25");
        pSDEFGroupDetailModel.setName("NEEDCODELISTCONFIG");
        iPSDEFieldModel = this.getDEField("NEEDCODELISTCONFIG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u662f\u5426\u9700\u8981\u63d0\u4f9b\u4ee3\u7801\u8868\u914d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u8868\u5355\u9879\u7f16\u8f91\u5668\u4e0e\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u4e00\u81f4\u5219\u4f7f\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\uff0c\u5426\u5219\u4f7f\u7528\u8868\u5355\u9879\u7f16\u8f91\u5668\u9ed8\u8ba4\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ce2295135de86c51d367db072b1dd150");
        pSDEFGroupDetailModel.setName("NOPRIVDM");
        iPSDEFieldModel = this.getDEField("NOPRIVDM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.NoPrivDisplayModesCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01c8adfa8469c374782a712ba5a01a78");
        pSDEFGroupDetailModel.setName("PSCODELISTID");
        iPSDEFieldModel = this.getDEField("PSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8f8154f919ecc41099d4f4e5d71f2ef4");
        pSDEFGroupDetailModel.setName("PSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("PSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f6dac62ea4ffd9d7529bea6edcce87ec");
        pSDEFGroupDetailModel.setName("PSDEFIUPDATEID");
        iPSDEFieldModel = this.getDEField("PSDEFIUPDATEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u503c\u53d8\u5316\u65f6\u89e6\u53d1\u7684\u8868\u5355\u9879\u66f4\u65b0\u64cd\u4f5c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4f4cb3b8c53e6d31eb3fac61ba46b5fc");
        pSDEFGroupDetailModel.setName("PSDEFIUPDATENAME");
        iPSDEFieldModel = this.getDEField("PSDEFIUPDATENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u503c\u53d8\u5316\u65f6\u89e6\u53d1\u7684\u8868\u5355\u9879\u66f4\u65b0\u64cd\u4f5c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1396c61926faf9451fa7fdaf317ad76e");
        pSDEFGroupDetailModel.setName("PSDEFID");
        iPSDEFieldModel = this.getDEField("PSDEFID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7ed1\u5b9a\u7684\u5c5e\u6027\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("435ce18f42496bfaeb3e9a345fbd9843");
        pSDEFGroupDetailModel.setName("PSDEFNAME");
        iPSDEFieldModel = this.getDEField("PSDEFNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7ed1\u5b9a\u7684\u5c5e\u6027\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("72cd1ff394ed498ccef6c9a302d1f1c7");
        pSDEFGroupDetailModel.setName("PSDEFSFITEMID");
        iPSDEFieldModel = this.getDEField("PSDEFSFITEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u8868\u5355\u9879\u4f7f\u7528\u7684\u641c\u7d22\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7a7192b24882b57058bb1f3157ddef52");
        pSDEFGroupDetailModel.setName("PSDEFSFITEMNAME");
        iPSDEFieldModel = this.getDEField("PSDEFSFITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u641c\u7d22\u8868\u5355\u9879\u4f7f\u7528\u7684\u641c\u7d22\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("27026a4b627265fd4bc6afc09d2840cb");
        pSDEFGroupDetailModel.setName("PSDEFFORMITEMID");
        iPSDEFieldModel = this.getDEField("PSDEFFORMITEMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u7167\u4ee5\u4e0b\u65b9\u5f0f\u8ba1\u7b97\u6a21\u5f0f\uff081\uff09\u5f53\u524d\u5e94\u7528\u7684\u9ed8\u8ba4\u6a21\u5f0f\uff082\uff09\u5f53\u524d\u5e94\u7528\u7c7b\u578b\u7684\u9ed8\u8ba4\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("12d469acb19d368849db3de732477fa9");
        pSDEFGroupDetailModel.setName("PSDEFFORMITEMNAME");
        iPSDEFieldModel = this.getDEField("PSDEFFORMITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u6309\u7167\u4ee5\u4e0b\u65b9\u5f0f\u8ba1\u7b97\u6a21\u5f0f\uff081\uff09\u5f53\u524d\u5e94\u7528\u7684\u9ed8\u8ba4\u6a21\u5f0f\uff082\uff09\u5f53\u524d\u5e94\u7528\u7c7b\u578b\u7684\u9ed8\u8ba4\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9b638b78ac5a73add30293b6430b06fb");
        pSDEFGroupDetailModel.setName("PSDEID");
        iPSDEFieldModel = this.getDEField("PSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c93e4f7ab1c34d22c4ea673d2ee1dfab");
        pSDEFGroupDetailModel.setName("PSSYSDICTCATID");
        iPSDEFieldModel = this.getDEField("PSSYSDICTCATID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7f16\u8f91\u5668\u4f7f\u7528\u7684\u8f85\u52a9\u8f93\u5165\u8bcd\u6761\u7c7b\u522b\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a03ba05a65a859d5d0684742fc81f1d5");
        pSDEFGroupDetailModel.setName("PSSYSDICTCATNAME");
        iPSDEFieldModel = this.getDEField("PSSYSDICTCATNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7f16\u8f91\u5668\u4f7f\u7528\u7684\u8f85\u52a9\u8f93\u5165\u8bcd\u6761\u7c7b\u522b\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ce25ed87da180651604084ab78bed31d");
        pSDEFGroupDetailModel.setName("PSSYSEDITORSTYLEID");
        iPSDEFieldModel = this.getDEField("PSSYSEDITORSTYLEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u7f16\u8f91\u5668\u7684\u6269\u5c55\u6837\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("772d38c04e5f563d533615f7c140880f");
        pSDEFGroupDetailModel.setName("PSSYSEDITORSTYLENAME");
        iPSDEFieldModel = this.getDEField("PSSYSEDITORSTYLENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u7f16\u8f91\u5668\u7684\u6269\u5c55\u6837\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49e42309cb0365c0517a97a23f4b6d89");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("42b735dd62ba1f04ec385a31420f6196");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51014af0b839103f5cd8d6536ef4dfbb");
        pSDEFGroupDetailModel.setName("PICKUPPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("PICKUPPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u5f15\u7528\u6570\u636e\u7684\u9009\u62e9\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3117eb1dc697b49f87720fa1aa5f1b6f");
        pSDEFGroupDetailModel.setName("PICKUPPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("PICKUPPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u5f15\u7528\u6570\u636e\u7684\u9009\u62e9\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8a2ff6b14f510d6b84c46f2c40d491f8");
        pSDEFGroupDetailModel.setName("PLACEHOLDER");
        iPSDEFieldModel = this.getDEField("PLACEHOLDER", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u5360\u4f4d\u63d0\u793a\u4fe1\u606f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6ebc8af2fa9ea19913bd2fdfaaebaec4");
        pSDEFGroupDetailModel.setName("REFPSDEACMODEID");
        iPSDEFieldModel = this.getDEField("REFPSDEACMODEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u6307\u5b9a\u81ea\u52a8\u586b\u5145\u914d\u7f6e\uff0c\u9ed8\u8ba4\u4f7f\u7528\u754c\u9762\u6a21\u5f0f\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9455dce55295039bd40a14df34a484a1");
        pSDEFGroupDetailModel.setName("REFPSDEACMODENAME");
        iPSDEFieldModel = this.getDEField("REFPSDEACMODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("02e95128d495f64a1b2223a467614b37");
        pSDEFGroupDetailModel.setName("REFPSDEDATASETID");
        iPSDEFieldModel = this.getDEField("REFPSDEDATASETID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u6307\u5b9a\u6570\u636e\u96c6\u5408\uff0c\u9ed8\u8ba4\u4f7f\u7528\u754c\u9762\u6a21\u5f0f\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5a40a27a3efc0afb8ff1aabeb991ddc1");
        pSDEFGroupDetailModel.setName("REFPSDEDATASETNAME");
        iPSDEFieldModel = this.getDEField("REFPSDEDATASETNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6f3682b32e9d688ff756ff748de8bfca");
        pSDEFGroupDetailModel.setName("REFPSDEID");
        iPSDEFieldModel = this.getDEField("REFPSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u5f15\u7528\u6570\u636e\u96c6\u3001\u81ea\u586b\u914d\u7f6e\u7b49\u5bf9\u8c61\u6240\u5c5e\u7684\u5b9e\u4f53");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8c5ed015ab4a062263b35c8c862b9930");
        pSDEFGroupDetailModel.setName("REFPSDENAME");
        iPSDEFieldModel = this.getDEField("REFPSDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7716a2a212f0da1f1bed02706f740b80");
        pSDEFGroupDetailModel.setName("RESETITEMNAME");
        iPSDEFieldModel = this.getDEField("RESETITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u76d1\u63a7\u7684\u91cd\u7f6e\u9879\u540d\u79f0\uff0c\u91cd\u7f6e\u9879\u503c\u751f\u53d8\u5316\u65f6\u91cd\u7f6e\u5f53\u524d\u9879");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("36e0b286ca248645d14a3b97c4549079");
        pSDEFGroupDetailModel.setName("SHOWMOREMODE");
        iPSDEFieldModel = this.getDEField("SHOWMOREMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDetailShowMoreMode2CodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u7684\u663e\u793a\u66f4\u591a\u6a21\u5f0f\uff0c\u4e3a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("72ef77c7f5d63f3e9fc7e454832c8206");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7b8f4cfdc15ab8be6188fa4b6c7afa5c");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("63e3015cc5928b9810b8236f2fec9714");
        pSDEFGroupDetailModel.setName("UPDATEDV");
        iPSDEFieldModel = this.getDEField("UPDATEDV", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8624dc05172003027900dba3ad61d749");
        pSDEFGroupDetailModel.setName("UPDATEDVT");
        iPSDEFieldModel = this.getDEField("UPDATEDVT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldDefaultValueType2CodeListModel");
        pSDEFGroupDetailModel.setMemo("\u66f4\u65b0\u9ed8\u8ba4\u503c\u7c7b\u578b\uff0c\u9ed8\u8ba4\u4e3a\u3010\u76f4\u63a5\u503c\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("13c4245a431e955c37120fead7ce536c");
        pSDEFGroupDetailModel.setName("VALUEITEMNAME");
        iPSDEFieldModel = this.getDEField("VALUEITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u5b9e\u9645\u503c\u9879\u56de\u586b\u7684\u8868\u5355\u9879");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e7aec273b57b3d5be81847e2b25bf607");
        pSDEFGroupDetailModel.setName("VISIBLELOGIC");
        iPSDEFieldModel = this.getDEField("VISIBLELOGIC", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("acef2705f78253201370abb64af2c43a");
        pSDEFGroupDetailModel.setName("WBDEFMODE");
        iPSDEFieldModel = this.getDEField("WBDEFMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FIWriteBackDEFModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u56de\u5199\u5c5e\u6027\u503c\u7684\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_FORMITEMEX() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("FORMITEMEX");
        pSDEFGroupModel.setName("\u590d\u5408\u8868\u5355\u9879");
        pSDEFGroupModel.setUserTag("FORMITEMEX");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("08d3e9f32920cd9349e76a1f6d49706d");
        pSDEFGroupDetailModel.setName("ALLOWEMPTY");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("ALLOWEMPTY", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u9879\u662f\u5426\u5141\u8bb8\u7a7a\u8f93\u5165");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("eed4cbd6283104fd60670933a16766bb");
        pSDEFGroupDetailModel.setName("BLANKLOGIC");
        iPSDEFieldModel = this.getDEField("BLANKLOGIC", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("da1fe9caa70b71eb08d9e6fcfb6b53ab");
        pSDEFGroupDetailModel.setName("CAPPSLANRESID");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("269aa4eda4bc7b77015ac0ec90e02e3b");
        pSDEFGroupDetailModel.setName("CAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("76521f0a30226e424d1fe23e14cbbbc7");
        pSDEFGroupDetailModel.setName("CAPTION");
        iPSDEFieldModel = this.getDEField("CAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("623c5a9d1b7ceecee65606fd83893f47");
        pSDEFGroupDetailModel.setName("CODELISTCONFIGMODE");
        iPSDEFieldModel = this.getDEField("CODELISTCONFIGMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.OutputCodeListConfigModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("144d290cc05d5f78cf4faba6fad1f6fb");
        pSDEFGroupDetailModel.setName("CONVERTCITEXT");
        iPSDEFieldModel = this.getDEField("CONVERTCITEXT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u5728\u8868\u5355\u9879\u6307\u5b9a\u4ee3\u7801\u8868\u60c5\u51b5\u4e0b\uff0c\u6307\u5b9a\u662f\u5426\u5c06\u4ee3\u7801\u503c\u8f6c\u6362\u4e3a\u6587\u672c\u8f93\u51fa\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u8868\u5355\u9879\u7684\u7f16\u8f91\u5668\u51b3\u5b9a");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2d1024aa0e789e5cc87a0836a4915820");
        pSDEFGroupDetailModel.setName("CREATEDV");
        iPSDEFieldModel = this.getDEField("CREATEDV", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4a8fe5541123224fca23781b512fc139");
        pSDEFGroupDetailModel.setName("CREATEDVT");
        iPSDEFieldModel = this.getDEField("CREATEDVT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldDefaultValueTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u9879\u7684\u65b0\u5efa\u9ed8\u8ba4\u503c\u7c7b\u578b\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u76f4\u63a5\u503c\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("743110fc4b02314efd87f0b5f0f5f55a");
        pSDEFGroupDetailModel.setName("CTRLCOLSPAN");
        iPSDEFieldModel = this.getDEField("CTRLCOLSPAN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6805\u683c\u5e03\u5c40\u65f6\u8868\u5355\u9879\u5bb9\u5668\u4e2d\u7f16\u8f91\u63a7\u4ef6\u7684\u5360\u4f4d\u5217\u6570\uff0c\u6b64\u53c2\u6570\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559\uff0c\u73b0\u5df2\u4e0d\u518d\u4f7f\u7528");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5afed07492d48e30752a92ef58d3451f");
        pSDEFGroupDetailModel.setName("CTRLHEIGHT");
        iPSDEFieldModel = this.getDEField("CTRLHEIGHT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u9ad8\u5ea6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8933f03cf450132fb2491fd8ca7733b3");
        pSDEFGroupDetailModel.setName("CTRLWIDTH");
        iPSDEFieldModel = this.getDEField("CTRLWIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u5bbd\u5ea6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9edac5065f5ab52809b632502026543c");
        pSDEFGroupDetailModel.setName("EDITORPARAMS");
        iPSDEFieldModel = this.getDEField("EDITORPARAMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7f16\u8f91\u5668\u7684\u53c2\u6570\uff0c\u5982\u8868\u5355\u9879\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\u7f16\u8f91\u5668\u7c7b\u578b\u4e0e\u5f53\u524d\u7f16\u8f91\u5668\u4e00\u81f4\uff0c\u540c\u65f6\u9644\u52a0\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u7f16\u8f91\u5668\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a554d79b3564b10c0485ba827e39a3c4");
        pSDEFGroupDetailModel.setName("EDITORTYPE");
        iPSDEFieldModel = this.getDEField("EDITORTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.EditorTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e939ddbbf95c506f41256dff384bbd1d");
        pSDEFGroupDetailModel.setName("EMPTYCAPTION");
        iPSDEFieldModel = this.getDEField("EMPTYCAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u662f\u5426\u542f\u7528\u7a7a\u767d\u6807\u7b7e\u5360\u4f4d\u3002\u9ed8\u8ba4\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("668ceb8504d4e482564989c7544aaec7");
        pSDEFGroupDetailModel.setName("ENABLECOND");
        iPSDEFieldModel = this.getDEField("ENABLECOND", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormItemEnableCondCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u9879\u7684\u9759\u6001\u542f\u7528\u6761\u4ef6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8156bb1b5c6550e15d17812bc75b9917");
        pSDEFGroupDetailModel.setName("ENABLEITEMPRIV");
        iPSDEFieldModel = this.getDEField("ENABLEITEMPRIV", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u662f\u5426\u542f\u7528\u5217\u6743\u9650\u63a7\u5236\uff0c\u672a\u5b9a\u4e49\u65f6\u7531\u7ed1\u5b9a\u7684\u5b9e\u4f53\u5c5e\u6027\u51b3\u5b9a\uff0c\u65e0\u5b9e\u4f53\u5c5e\u6027\u5219\u4e3a\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d1b23fd6e724260ed4d05b5d7577db1f");
        pSDEFGroupDetailModel.setName("ENABLELOGIC");
        iPSDEFieldModel = this.getDEField("ENABLELOGIC", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("510601108256a8fc1140aab2d8d02b43");
        pSDEFGroupDetailModel.setName("FORMTYPE");
        iPSDEFieldModel = this.getDEField("FORMTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c2a675e41e203417f0631bc4ace6ccaa");
        pSDEFGroupDetailModel.setName("IGNOREINPUT");
        iPSDEFieldModel = this.getDEField("IGNOREINPUT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FIValueIgnoreModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5728\u4f55\u79cd\u60c5\u51b5\u4e0b\u4f1a\u5ffd\u7565\u8868\u5355\u9879\u7684\u8f93\u5165\u503c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a6419a98cc18fabc64209e9db24c493a");
        pSDEFGroupDetailModel.setName("ITEMPSACHANDLERID");
        iPSDEFieldModel = this.getDEField("ITEMPSACHANDLERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u754c\u9762\u5904\u7406\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e8d7a99b8f679f017538ec4995625ef4");
        pSDEFGroupDetailModel.setName("ITEMPSACHANDLERNAME");
        iPSDEFieldModel = this.getDEField("ITEMPSACHANDLERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u754c\u9762\u5904\u7406\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4ef3619c387ca8746cff85c0660f9243");
        pSDEFGroupDetailModel.setName("LABELCOLSPAN");
        iPSDEFieldModel = this.getDEField("LABELCOLSPAN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6805\u683c\u5e03\u5c40\u65f6\u8868\u5355\u9879\u5bb9\u5668\u4e2d\u6807\u7b7e\u7684\u5360\u4f4d\u5217\u6570\uff0c\u6b64\u53c2\u6570\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559\uff0c\u73b0\u5df2\u4e0d\u518d\u4f7f\u7528");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01296429cd95fb7a43003fcf46a19035");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSID");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("40625ae4923f99e988d69f755b9ac465");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ae76ed5d4fd3c353c2fd22232ec2a0f8");
        pSDEFGroupDetailModel.setName("LABELPOS");
        iPSDEFieldModel = this.getDEField("LABELPOS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormItemLabelPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u6807\u7b7e\u7684\u4f4d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u5de6\u8fb9\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f180130a56ccc316e14961f3c9293e04");
        pSDEFGroupDetailModel.setName("LABELWIDTH");
        iPSDEFieldModel = this.getDEField("LABELWIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u6807\u7b7e\u7684\u5bbd\u5ea6\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u8868\u5355\u9ed8\u8ba4\u6807\u7b7e\u5bbd\u5ea6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3042199642034714df10d98549f855ca");
        pSDEFGroupDetailModel.setName("LINKPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("LINKPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u5f15\u7528\u6570\u636e\u7684\u94fe\u63a5\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3403f1d024dc9311125499b511a97dc9");
        pSDEFGroupDetailModel.setName("LINKPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("LINKPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u5f15\u7528\u6570\u636e\u7684\u94fe\u63a5\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7efc596ba7327afa69911558483aa92a");
        pSDEFGroupDetailModel.setName("LOGICNAME");
        iPSDEFieldModel = this.getDEField("LOGICNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u903b\u8f91\u540d\u79f0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("41ecea324ce07e15b7c011867bd0ff25");
        pSDEFGroupDetailModel.setName("NEEDCODELISTCONFIG");
        iPSDEFieldModel = this.getDEField("NEEDCODELISTCONFIG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u662f\u5426\u9700\u8981\u63d0\u4f9b\u4ee3\u7801\u8868\u914d\u7f6e\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u8868\u5355\u9879\u7f16\u8f91\u5668\u4e0e\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u4e00\u81f4\u5219\u4f7f\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e\uff0c\u5426\u5219\u4f7f\u7528\u8868\u5355\u9879\u7f16\u8f91\u5668\u9ed8\u8ba4\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ce2295135de86c51d367db072b1dd150");
        pSDEFGroupDetailModel.setName("NOPRIVDM");
        iPSDEFieldModel = this.getDEField("NOPRIVDM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.NoPrivDisplayModesCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01c8adfa8469c374782a712ba5a01a78");
        pSDEFGroupDetailModel.setName("PSCODELISTID");
        iPSDEFieldModel = this.getDEField("PSCODELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8f8154f919ecc41099d4f4e5d71f2ef4");
        pSDEFGroupDetailModel.setName("PSCODELISTNAME");
        iPSDEFieldModel = this.getDEField("PSCODELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u4ee3\u7801\u8868\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f6dac62ea4ffd9d7529bea6edcce87ec");
        pSDEFGroupDetailModel.setName("PSDEFIUPDATEID");
        iPSDEFieldModel = this.getDEField("PSDEFIUPDATEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u503c\u53d8\u5316\u65f6\u89e6\u53d1\u7684\u8868\u5355\u9879\u66f4\u65b0\u64cd\u4f5c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4f4cb3b8c53e6d31eb3fac61ba46b5fc");
        pSDEFGroupDetailModel.setName("PSDEFIUPDATENAME");
        iPSDEFieldModel = this.getDEField("PSDEFIUPDATENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u503c\u53d8\u5316\u65f6\u89e6\u53d1\u7684\u8868\u5355\u9879\u66f4\u65b0\u64cd\u4f5c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9b638b78ac5a73add30293b6430b06fb");
        pSDEFGroupDetailModel.setName("PSDEID");
        iPSDEFieldModel = this.getDEField("PSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c93e4f7ab1c34d22c4ea673d2ee1dfab");
        pSDEFGroupDetailModel.setName("PSSYSDICTCATID");
        iPSDEFieldModel = this.getDEField("PSSYSDICTCATID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7f16\u8f91\u5668\u4f7f\u7528\u7684\u8f85\u52a9\u8f93\u5165\u8bcd\u6761\u7c7b\u522b\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a03ba05a65a859d5d0684742fc81f1d5");
        pSDEFGroupDetailModel.setName("PSSYSDICTCATNAME");
        iPSDEFieldModel = this.getDEField("PSSYSDICTCATNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7f16\u8f91\u5668\u4f7f\u7528\u7684\u8f85\u52a9\u8f93\u5165\u8bcd\u6761\u7c7b\u522b\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ce25ed87da180651604084ab78bed31d");
        pSDEFGroupDetailModel.setName("PSSYSEDITORSTYLEID");
        iPSDEFieldModel = this.getDEField("PSSYSEDITORSTYLEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u7f16\u8f91\u5668\u7684\u6269\u5c55\u6837\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("772d38c04e5f563d533615f7c140880f");
        pSDEFGroupDetailModel.setName("PSSYSEDITORSTYLENAME");
        iPSDEFieldModel = this.getDEField("PSSYSEDITORSTYLENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u7f16\u8f91\u5668\u7684\u6269\u5c55\u6837\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49e42309cb0365c0517a97a23f4b6d89");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("42b735dd62ba1f04ec385a31420f6196");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("51014af0b839103f5cd8d6536ef4dfbb");
        pSDEFGroupDetailModel.setName("PICKUPPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("PICKUPPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u5f15\u7528\u6570\u636e\u7684\u9009\u62e9\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3117eb1dc697b49f87720fa1aa5f1b6f");
        pSDEFGroupDetailModel.setName("PICKUPPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("PICKUPPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u5f15\u7528\u6570\u636e\u7684\u9009\u62e9\u89c6\u56fe\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5f15\u7528\u7684\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8a2ff6b14f510d6b84c46f2c40d491f8");
        pSDEFGroupDetailModel.setName("PLACEHOLDER");
        iPSDEFieldModel = this.getDEField("PLACEHOLDER", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u5360\u4f4d\u63d0\u793a\u4fe1\u606f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6ebc8af2fa9ea19913bd2fdfaaebaec4");
        pSDEFGroupDetailModel.setName("REFPSDEACMODEID");
        iPSDEFieldModel = this.getDEField("REFPSDEACMODEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u6307\u5b9a\u81ea\u52a8\u586b\u5145\u914d\u7f6e\uff0c\u9ed8\u8ba4\u4f7f\u7528\u754c\u9762\u6a21\u5f0f\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9455dce55295039bd40a14df34a484a1");
        pSDEFGroupDetailModel.setName("REFPSDEACMODENAME");
        iPSDEFieldModel = this.getDEField("REFPSDEACMODENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("02e95128d495f64a1b2223a467614b37");
        pSDEFGroupDetailModel.setName("REFPSDEDATASETID");
        iPSDEFieldModel = this.getDEField("REFPSDEDATASETID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u6307\u5b9a\u6570\u636e\u96c6\u5408\uff0c\u9ed8\u8ba4\u4f7f\u7528\u754c\u9762\u6a21\u5f0f\u5b9a\u4e49");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5a40a27a3efc0afb8ff1aabeb991ddc1");
        pSDEFGroupDetailModel.setName("REFPSDEDATASETNAME");
        iPSDEFieldModel = this.getDEField("REFPSDEDATASETNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6f3682b32e9d688ff756ff748de8bfca");
        pSDEFGroupDetailModel.setName("REFPSDEID");
        iPSDEFieldModel = this.getDEField("REFPSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u5f15\u7528\u6570\u636e\u96c6\u3001\u81ea\u586b\u914d\u7f6e\u7b49\u5bf9\u8c61\u6240\u5c5e\u7684\u5b9e\u4f53");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8c5ed015ab4a062263b35c8c862b9930");
        pSDEFGroupDetailModel.setName("REFPSDENAME");
        iPSDEFieldModel = this.getDEField("REFPSDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7716a2a212f0da1f1bed02706f740b80");
        pSDEFGroupDetailModel.setName("RESETITEMNAME");
        iPSDEFieldModel = this.getDEField("RESETITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u76d1\u63a7\u7684\u91cd\u7f6e\u9879\u540d\u79f0\uff0c\u91cd\u7f6e\u9879\u503c\u751f\u53d8\u5316\u65f6\u91cd\u7f6e\u5f53\u524d\u9879");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("72ef77c7f5d63f3e9fc7e454832c8206");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7b8f4cfdc15ab8be6188fa4b6c7afa5c");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("63e3015cc5928b9810b8236f2fec9714");
        pSDEFGroupDetailModel.setName("UPDATEDV");
        iPSDEFieldModel = this.getDEField("UPDATEDV", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8624dc05172003027900dba3ad61d749");
        pSDEFGroupDetailModel.setName("UPDATEDVT");
        iPSDEFieldModel = this.getDEField("UPDATEDVT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FieldDefaultValueType2CodeListModel");
        pSDEFGroupDetailModel.setMemo("\u66f4\u65b0\u9ed8\u8ba4\u503c\u7c7b\u578b\uff0c\u9ed8\u8ba4\u4e3a\u3010\u76f4\u63a5\u503c\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("13c4245a431e955c37120fead7ce536c");
        pSDEFGroupDetailModel.setName("VALUEITEMNAME");
        iPSDEFieldModel = this.getDEField("VALUEITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u5b9e\u9645\u503c\u9879\u56de\u586b\u7684\u8868\u5355\u9879");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e7aec273b57b3d5be81847e2b25bf607");
        pSDEFGroupDetailModel.setName("VISIBLELOGIC");
        iPSDEFieldModel = this.getDEField("VISIBLELOGIC", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("acef2705f78253201370abb64af2c43a");
        pSDEFGroupDetailModel.setName("WBDEFMODE");
        iPSDEFieldModel = this.getDEField("WBDEFMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FIWriteBackDEFModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u56de\u5199\u5c5e\u6027\u503c\u7684\u6a21\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_FORMPAGE() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("FORMPAGE");
        pSDEFGroupModel.setName("\u8868\u5355\u5206\u9875");
        pSDEFGroupModel.setUserTag("FORMPAGE");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("da1fe9caa70b71eb08d9e6fcfb6b53ab");
        pSDEFGroupDetailModel.setName("CAPPSLANRESID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("269aa4eda4bc7b77015ac0ec90e02e3b");
        pSDEFGroupDetailModel.setName("CAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("76521f0a30226e424d1fe23e14cbbbc7");
        pSDEFGroupDetailModel.setName("CAPTION");
        iPSDEFieldModel = this.getDEField("CAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c2a675e41e203417f0631bc4ace6ccaa");
        pSDEFGroupDetailModel.setName("IGNOREINPUT");
        iPSDEFieldModel = this.getDEField("IGNOREINPUT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FIValueIgnoreModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u7684\u5b50\u6210\u5458\u5ffd\u7565\u8f93\u5165\u503c\u7684\u65b9\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u5b58\u5728\u7236\u5bb9\u5668\u5219\u4f7f\u7528\u7236\u5bb9\u5668\u914d\u7f6e\uff0c\u5426\u5219\u4e3a\u3010\u65e0\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01296429cd95fb7a43003fcf46a19035");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSID");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("40625ae4923f99e988d69f755b9ac465");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("55e68a8d421f55687ca79b117329f85e");
        pSDEFGroupDetailModel.setName("PSSYSCOUNTERID");
        iPSDEFieldModel = this.getDEField("PSSYSCOUNTERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u52a0\u8f7d\u7684\u8ba1\u6570\u5668\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7f1935538b729cbbdcdb8bd21be984bc");
        pSDEFGroupDetailModel.setName("PSSYSCOUNTERNAME");
        iPSDEFieldModel = this.getDEField("PSSYSCOUNTERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u52a0\u8f7d\u7684\u8ba1\u6570\u5668\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49e42309cb0365c0517a97a23f4b6d89");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("42b735dd62ba1f04ec385a31420f6196");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("72ef77c7f5d63f3e9fc7e454832c8206");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7b8f4cfdc15ab8be6188fa4b6c7afa5c");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("13c4245a431e955c37120fead7ce536c");
        pSDEFGroupDetailModel.setName("VALUEITEMNAME");
        iPSDEFieldModel = this.getDEField("VALUEITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u52a8\u6001\u6807\u9898\u7684\u53d6\u503c\u8868\u5355\u9879");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_FORMPART() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("FORMPART");
        pSDEFGroupModel.setName("\u8868\u5355\u90e8\u4ef6");
        pSDEFGroupModel.setUserTag("FORMPART");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("da1fe9caa70b71eb08d9e6fcfb6b53ab");
        pSDEFGroupDetailModel.setName("CAPPSLANRESID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("269aa4eda4bc7b77015ac0ec90e02e3b");
        pSDEFGroupDetailModel.setName("CAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("76521f0a30226e424d1fe23e14cbbbc7");
        pSDEFGroupDetailModel.setName("CAPTION");
        iPSDEFieldModel = this.getDEField("CAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3dd168bd6db48f9de7ecf80bc42d2224");
        pSDEFGroupDetailModel.setName("CONTENTTYPE");
        iPSDEFieldModel = this.getDEField("CONTENTTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormPartTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u90e8\u4ef6\u7684\u5f15\u7528\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("510601108256a8fc1140aab2d8d02b43");
        pSDEFGroupDetailModel.setName("FORMTYPE");
        iPSDEFieldModel = this.getDEField("FORMTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01296429cd95fb7a43003fcf46a19035");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSID");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("40625ae4923f99e988d69f755b9ac465");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c690835ce4732e0fcb8b74fb9a3a8fd1");
        pSDEFGroupDetailModel.setName("PSDEFORMRFID");
        iPSDEFieldModel = this.getDEField("PSDEFORMRFID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u90e8\u4ef6\u4f7f\u7528\u7684\u8868\u5355\u5f15\u7528\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0a3710434c75de36f1f57b5bf1361fc5");
        pSDEFGroupDetailModel.setName("PSDEFORMRFNAME");
        iPSDEFieldModel = this.getDEField("PSDEFORMRFNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u90e8\u4ef6\u4f7f\u7528\u7684\u8868\u5355\u5f15\u7528\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9b638b78ac5a73add30293b6430b06fb");
        pSDEFGroupDetailModel.setName("PSDEID");
        iPSDEFieldModel = this.getDEField("PSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("312b24da7f61c5067bdca48405eb24d7");
        pSDEFGroupDetailModel.setName("REFPSDEFORMDETAILID");
        iPSDEFieldModel = this.getDEField("REFPSDEFORMDETAILID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u90e8\u4ef6\u5f15\u7528\u7684\u8868\u5355\u90e8\u4ef6\u7684\u6210\u5458");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("357725534e0954e385e7ba2e8dead291");
        pSDEFGroupDetailModel.setName("REFPSDEFORMDETAILNAME");
        iPSDEFieldModel = this.getDEField("REFPSDEFORMDETAILNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u90e8\u4ef6\u5f15\u7528\u7684\u8868\u5355\u90e8\u4ef6\u7684\u6210\u5458");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5a7515d9a92ba032712f9e819a7f80b2");
        pSDEFGroupDetailModel.setName("REFPSDEFORMID");
        iPSDEFieldModel = this.getDEField("REFPSDEFORMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8d94a5d85a4550bda9955eb0a8a88079");
        pSDEFGroupDetailModel.setName("SHOWCAPTION");
        iPSDEFieldModel = this.getDEField("SHOWCAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u662f\u5426\u663e\u793a\u6807\u9898\uff0c\u9ed8\u8ba4\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cd671a44970182a68e55fcf80fc64440");
        pSDEFGroupDetailModel.setName("TITLEBARCLOSEMODE");
        iPSDEFieldModel = this.getDEField("TITLEBARCLOSEMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTitleBarCloseModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u5173\u95ed\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e7aec273b57b3d5be81847e2b25bf607");
        pSDEFGroupDetailModel.setName("VISIBLELOGIC");
        iPSDEFieldModel = this.getDEField("VISIBLELOGIC", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_GROUPPANEL() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("GROUPPANEL");
        pSDEFGroupModel.setName("\u5206\u7ec4\u9762\u677f");
        pSDEFGroupModel.setUserTag("GROUPPANEL");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("08d3e9f32920cd9349e76a1f6d49706d");
        pSDEFGroupDetailModel.setName("ALLOWEMPTY");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("ALLOWEMPTY", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u5b50\u6210\u5458\u662f\u5426\u542f\u7528\u65e0\u503c\u9690\u85cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u7236\u5bb9\u5668\u914d\u7f6e\u3002\u542f\u7528\u65e0\u503c\u9690\u85cf\u65f6\u5f15\u64ce\u5c06\u4e3a\u8868\u5355\u6210\u5458\u4eff\u771f\u51fa\u65e0\u503c\u9690\u85cf\u7684\u52a8\u6001\u8868\u5355\u903b\u8f91\uff0c\u6a21\u677f\u65e0\u9700\u5173\u5fc3\u6b64\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49223abdaa12308c9099355e43fb35c1");
        pSDEFGroupDetailModel.setName("BUILDINACTION");
        iPSDEFieldModel = this.getDEField("BUILDINACTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormGroupMoreActionsCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u9762\u677f\u63d0\u4f9b\u5185\u7f6e\u64cd\u4f5c\u529f\u80fd\uff0c\u4e00\u822c\u5e94\u7528\u4e8e\u5206\u7ec4\u5305\u542b\u591a\u6570\u636e\u754c\u9762\u90e8\u4ef6\u573a\u5408\uff0c\u8c03\u7528\u591a\u6570\u636e\u90e8\u4ef6\u754c\u9762\u63d0\u4f9b\u7684\u76f8\u5173\u529f\u80fd");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("da1fe9caa70b71eb08d9e6fcfb6b53ab");
        pSDEFGroupDetailModel.setName("CAPPSLANRESID");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("269aa4eda4bc7b77015ac0ec90e02e3b");
        pSDEFGroupDetailModel.setName("CAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("76521f0a30226e424d1fe23e14cbbbc7");
        pSDEFGroupDetailModel.setName("CAPTION");
        iPSDEFieldModel = this.getDEField("CAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c0d6cb638c87dc0887ef566aca3a505e");
        pSDEFGroupDetailModel.setName("ENABLEANCHOR");
        iPSDEFieldModel = this.getDEField("ENABLEANCHOR", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u542f\u7528\u951a\u70b9\u63d0\u4f9b\u4e86\u5b9a\u4f4d\u5f53\u524d\u9879\u80fd\u529b\uff0c\u9ed8\u8ba4\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("668ceb8504d4e482564989c7544aaec7");
        pSDEFGroupDetailModel.setName("ENABLECOND");
        iPSDEFieldModel = this.getDEField("ENABLECOND", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormInfoModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u5b50\u6210\u5458\u662f\u5426\u542f\u7528\u4fe1\u606f\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u7236\u5bb9\u5668\u914d\u7f6e\uff08\u7236\u5206\u7ec4\u6216\u8868\u5355\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c2a675e41e203417f0631bc4ace6ccaa");
        pSDEFGroupDetailModel.setName("IGNOREINPUT");
        iPSDEFieldModel = this.getDEField("IGNOREINPUT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FIValueIgnoreModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u7684\u5b50\u6210\u5458\u5ffd\u7565\u8f93\u5165\u503c\u7684\u65b9\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u5b58\u5728\u7236\u5bb9\u5668\u5219\u4f7f\u7528\u7236\u5bb9\u5668\u914d\u7f6e\uff0c\u5426\u5219\u4e3a\u3010\u65e0\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01296429cd95fb7a43003fcf46a19035");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSID");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("40625ae4923f99e988d69f755b9ac465");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("da4d97c7e7289c918b9c9ab420bc7e3d");
        pSDEFGroupDetailModel.setName("PSDEUAGROUPID");
        iPSDEFieldModel = this.getDEField("PSDEUAGROUPID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u9762\u677f\u4f7f\u7528\u7684\u754c\u9762\u884c\u4e3a\u7ec4\uff0c\u754c\u9762\u884c\u4e3a\u7ec4\u5c06\u5728\u5206\u7ec4\u9762\u677f\u6807\u9898\u533a\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d08c9c54348db00adac1a33329800929");
        pSDEFGroupDetailModel.setName("PSDEUAGROUPNAME");
        iPSDEFieldModel = this.getDEField("PSDEUAGROUPNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u9762\u677f\u4f7f\u7528\u7684\u754c\u9762\u884c\u4e3a\u7ec4\uff0c\u754c\u9762\u884c\u4e3a\u7ec4\u5c06\u5728\u5206\u7ec4\u9762\u677f\u6807\u9898\u533a\u5c55\u5f00");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49e42309cb0365c0517a97a23f4b6d89");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("42b735dd62ba1f04ec385a31420f6196");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1ab30a14e596bd7fd755c931b9a2ac2d");
        pSDEFGroupDetailModel.setName("RAWCONTENT");
        iPSDEFieldModel = this.getDEField("RAWCONTENT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u9762\u677f\u5b50\u6807\u9898");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8d94a5d85a4550bda9955eb0a8a88079");
        pSDEFGroupDetailModel.setName("SHOWCAPTION");
        iPSDEFieldModel = this.getDEField("SHOWCAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u662f\u5426\u663e\u793a\u6807\u9898\uff0c\u9ed8\u8ba4\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("36e0b286ca248645d14a3b97c4549079");
        pSDEFGroupDetailModel.setName("SHOWMOREMODE");
        iPSDEFieldModel = this.getDEField("SHOWMOREMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDetailShowMoreModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u7684\u663e\u793a\u66f4\u591a\u6a21\u5f0f\uff0c\u4e3a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cd671a44970182a68e55fcf80fc64440");
        pSDEFGroupDetailModel.setName("TITLEBARCLOSEMODE");
        iPSDEFieldModel = this.getDEField("TITLEBARCLOSEMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTitleBarCloseModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u5173\u95ed\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("72ef77c7f5d63f3e9fc7e454832c8206");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7b8f4cfdc15ab8be6188fa4b6c7afa5c");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8624dc05172003027900dba3ad61d749");
        pSDEFGroupDetailModel.setName("UPDATEDVT");
        iPSDEFieldModel = this.getDEField("UPDATEDVT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.UGExtractModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u754c\u9762\u884c\u4e3a\u7ec4\u5c55\u5f00\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u6309\u9879\u5c55\u5f00\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("13c4245a431e955c37120fead7ce536c");
        pSDEFGroupDetailModel.setName("VALUEITEMNAME");
        iPSDEFieldModel = this.getDEField("VALUEITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u52a8\u6001\u6807\u9898\u7684\u53d6\u503c\u8868\u5355\u9879");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e7aec273b57b3d5be81847e2b25bf607");
        pSDEFGroupDetailModel.setName("VISIBLELOGIC");
        iPSDEFieldModel = this.getDEField("VISIBLELOGIC", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_IFRAME() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("IFRAME");
        pSDEFGroupModel.setName("\u76f4\u63a5\u9875\u9762\u5d4c\u5165");
        pSDEFGroupModel.setUserTag("IFRAME");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9edac5065f5ab52809b632502026543c");
        pSDEFGroupDetailModel.setName("EDITORPARAMS");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("EDITORPARAMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5d4c\u5165\u9875\u9762\u7684\u8def\u5f84");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("510601108256a8fc1140aab2d8d02b43");
        pSDEFGroupDetailModel.setName("FORMTYPE");
        iPSDEFieldModel = this.getDEField("FORMTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3042199642034714df10d98549f855ca");
        pSDEFGroupDetailModel.setName("LINKPSDEVIEWID");
        iPSDEFieldModel = this.getDEField("LINKPSDEVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5d4c\u5165\u7684\u5173\u7cfb\u89c6\u56fe\u8def\u5f84\uff0c\u6b64\u914d\u7f6e\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559\uff0c\u672a\u6765\u4e0d\u518d\u4f7f\u7528");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3403f1d024dc9311125499b511a97dc9");
        pSDEFGroupDetailModel.setName("LINKPSDEVIEWNAME");
        iPSDEFieldModel = this.getDEField("LINKPSDEVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5d4c\u5165\u7684\u5173\u7cfb\u89c6\u56fe\u8def\u5f84\uff0c\u6b64\u914d\u7f6e\u4e3a\u65e9\u671f\u6a21\u677f\u4fdd\u7559\uff0c\u672a\u6765\u4e0d\u518d\u4f7f\u7528");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f6dac62ea4ffd9d7529bea6edcce87ec");
        pSDEFGroupDetailModel.setName("PSDEFIUPDATEID");
        iPSDEFieldModel = this.getDEField("PSDEFIUPDATEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u754c\u9762\u5237\u65b0\u65f6\u89e6\u53d1\u7684\u8868\u5355\u9879\u66f4\u65b0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4f4cb3b8c53e6d31eb3fac61ba46b5fc");
        pSDEFGroupDetailModel.setName("PSDEFIUPDATENAME");
        iPSDEFieldModel = this.getDEField("PSDEFIUPDATENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u754c\u9762\u5237\u65b0\u65f6\u89e6\u53d1\u7684\u8868\u5355\u9879\u66f4\u65b0");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9b638b78ac5a73add30293b6430b06fb");
        pSDEFGroupDetailModel.setName("PSDEID");
        iPSDEFieldModel = this.getDEField("PSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7716a2a212f0da1f1bed02706f740b80");
        pSDEFGroupDetailModel.setName("RESETITEMNAME");
        iPSDEFieldModel = this.getDEField("RESETITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5173\u7cfb\u754c\u9762\u7684\u9644\u52a0\u5237\u65b0\u9879\uff0c\u591a\u9879\u4f7f\u7528\u3010;\u3011\u5206\u9694\u3002\u8868\u5355\u4e3b\u952e\u3010srfkey\u3011\u53d8\u5316\u65f6\u9ed8\u8ba4\u5237\u65b0\u5173\u7cfb\u754c\u9762");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("72ef77c7f5d63f3e9fc7e454832c8206");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7b8f4cfdc15ab8be6188fa4b6c7afa5c");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_MDCTRL() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("MDCTRL");
        pSDEFGroupModel.setName("\u591a\u6570\u636e\u90e8\u4ef6");
        pSDEFGroupModel.setUserTag("MDCTRL");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49223abdaa12308c9099355e43fb35c1");
        pSDEFGroupDetailModel.setName("BUILDINACTION");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("BUILDINACTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormMDCtrlActionCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u591a\u6570\u636e\u90e8\u4ef6\u63d0\u4f9b\u7684\u64cd\u4f5c");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("da1fe9caa70b71eb08d9e6fcfb6b53ab");
        pSDEFGroupDetailModel.setName("CAPPSLANRESID");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("269aa4eda4bc7b77015ac0ec90e02e3b");
        pSDEFGroupDetailModel.setName("CAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("76521f0a30226e424d1fe23e14cbbbc7");
        pSDEFGroupDetailModel.setName("CAPTION");
        iPSDEFieldModel = this.getDEField("CAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9edac5065f5ab52809b632502026543c");
        pSDEFGroupDetailModel.setName("EDITORPARAMS");
        iPSDEFieldModel = this.getDEField("EDITORPARAMS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u591a\u6570\u636e\u90e8\u4ef6\u53c2\u6570");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c0d6cb638c87dc0887ef566aca3a505e");
        pSDEFGroupDetailModel.setName("ENABLEANCHOR");
        iPSDEFieldModel = this.getDEField("ENABLEANCHOR", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u542f\u7528\u951a\u70b9\u63d0\u4f9b\u4e86\u5b9a\u4f4d\u5f53\u524d\u9879\u80fd\u529b\uff0c\u9ed8\u8ba4\u3010\u5426\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("510601108256a8fc1140aab2d8d02b43");
        pSDEFGroupDetailModel.setName("FORMTYPE");
        iPSDEFieldModel = this.getDEField("FORMTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01296429cd95fb7a43003fcf46a19035");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSID");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("40625ae4923f99e988d69f755b9ac465");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c914581735e0005407f15526ff95527a");
        pSDEFGroupDetailModel.setName("MDCTRLTYPE");
        iPSDEFieldModel = this.getDEField("MDCTRLTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDetailMDCtrlTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u6210\u5458\u7c7b\u578b\u4e3a\u3010\u591a\u6570\u636e\u90e8\u4ef6\u3011\u65f6\u6307\u5b9a\u591a\u6570\u636e\u90e8\u4ef6\u7684\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("43a0f5ea97168666ea67baa99f49273f");
        pSDEFGroupDetailModel.setName("MDPSDEDATAVIEWID");
        iPSDEFieldModel = this.getDEField("MDPSDEDATAVIEWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("571d73b1f665a686c61d2c0d2f4db23a");
        pSDEFGroupDetailModel.setName("MDPSDEDATAVIEWNAME");
        iPSDEFieldModel = this.getDEField("MDPSDEDATAVIEWNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a1cfeea26da7ed5ce131a7dc307f8755");
        pSDEFGroupDetailModel.setName("MDPSDEFORMID");
        iPSDEFieldModel = this.getDEField("MDPSDEFORMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u591a\u6570\u636e\u90e8\u4ef6\u7c7b\u578b\u4e3a\u3010\u8868\u5355\u3011\u65f6\u6307\u5b9a\u5faa\u73af\u7ed8\u5236\u7684\u8868\u5355\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("896791543b88ea2a33f72ab324ed147c");
        pSDEFGroupDetailModel.setName("MDPSDEFORMNAME");
        iPSDEFieldModel = this.getDEField("MDPSDEFORMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u591a\u6570\u636e\u90e8\u4ef6\u7c7b\u578b\u4e3a\u3010\u8868\u5355\u3011\u65f6\u6307\u5b9a\u5faa\u73af\u7ed8\u5236\u7684\u8868\u5355\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("426816b3a5f88b7aa1479e7f8003e236");
        pSDEFGroupDetailModel.setName("MDPSDEGRIDID");
        iPSDEFieldModel = this.getDEField("MDPSDEGRIDID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0ba5c9806b6ffec4641a43918b86b591");
        pSDEFGroupDetailModel.setName("MDPSDEGRIDNAME");
        iPSDEFieldModel = this.getDEField("MDPSDEGRIDNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("044122bb3b433df617a3abfbe583d460");
        pSDEFGroupDetailModel.setName("MDPSDELISTID");
        iPSDEFieldModel = this.getDEField("MDPSDELISTID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u591a\u6570\u636e\u90e8\u4ef6\u7c7b\u578b\u4e3a\u3010\u5217\u8868\u3011\u65f6\u6307\u5b9a\u7ed8\u5236\u7684\u5217\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e6d18b2779fdfb1e52a81e7d9847922f");
        pSDEFGroupDetailModel.setName("MDPSDELISTNAME");
        iPSDEFieldModel = this.getDEField("MDPSDELISTNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u591a\u6570\u636e\u90e8\u4ef6\u7c7b\u578b\u4e3a\u3010\u5217\u8868\u3011\u65f6\u6307\u5b9a\u7ed8\u5236\u7684\u5217\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1396c61926faf9451fa7fdaf317ad76e");
        pSDEFGroupDetailModel.setName("PSDEFID");
        iPSDEFieldModel = this.getDEField("PSDEFID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7ed1\u5b9a\u7684\u5c5e\u6027\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("435ce18f42496bfaeb3e9a345fbd9843");
        pSDEFGroupDetailModel.setName("PSDEFNAME");
        iPSDEFieldModel = this.getDEField("PSDEFNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7ed1\u5b9a\u7684\u5c5e\u6027\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9b638b78ac5a73add30293b6430b06fb");
        pSDEFGroupDetailModel.setName("PSDEID");
        iPSDEFieldModel = this.getDEField("PSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49e42309cb0365c0517a97a23f4b6d89");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("42b735dd62ba1f04ec385a31420f6196");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("6f3682b32e9d688ff756ff748de8bfca");
        pSDEFGroupDetailModel.setName("REFPSDEID");
        iPSDEFieldModel = this.getDEField("REFPSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7f16\u8f91\u5668\u5f15\u7528\u6570\u636e\u96c6\u3001\u81ea\u586b\u914d\u7f6e\u7b49\u5bf9\u8c61\u6240\u5c5e\u7684\u5b9e\u4f53");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8c5ed015ab4a062263b35c8c862b9930");
        pSDEFGroupDetailModel.setName("REFPSDENAME");
        iPSDEFieldModel = this.getDEField("REFPSDENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("f81633c19aa5c02b028d6cef7a6707d7");
        pSDEFGroupDetailModel.setName("REFPSDERID");
        iPSDEFieldModel = this.getDEField("REFPSDERID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u5f15\u7528\u5b9e\u4f53\u5173\u7cfb");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("64c6b6afdeb26f8b0f62d09005f073db");
        pSDEFGroupDetailModel.setName("REFPSDERNAME");
        iPSDEFieldModel = this.getDEField("REFPSDERNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u7684\u5f15\u7528\u5b9e\u4f53\u5173\u7cfb");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7716a2a212f0da1f1bed02706f740b80");
        pSDEFGroupDetailModel.setName("RESETITEMNAME");
        iPSDEFieldModel = this.getDEField("RESETITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u76d1\u63a7\u7684\u91cd\u7f6e\u9879\u540d\u79f0\uff0c\u91cd\u7f6e\u9879\u503c\u751f\u53d8\u5316\u65f6\u91cd\u7f6e\u5f53\u524d\u9879");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8d94a5d85a4550bda9955eb0a8a88079");
        pSDEFGroupDetailModel.setName("SHOWCAPTION");
        iPSDEFieldModel = this.getDEField("SHOWCAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.YesNoCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u662f\u5426\u663e\u793a\u6807\u9898\uff0c\u9ed8\u8ba4\u3010\u662f\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cd671a44970182a68e55fcf80fc64440");
        pSDEFGroupDetailModel.setName("TITLEBARCLOSEMODE");
        iPSDEFieldModel = this.getDEField("TITLEBARCLOSEMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTitleBarCloseModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u65e0\u5173\u95ed\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("72ef77c7f5d63f3e9fc7e454832c8206");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7b8f4cfdc15ab8be6188fa4b6c7afa5c");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("13c4245a431e955c37120fead7ce536c");
        pSDEFGroupDetailModel.setName("VALUEITEMNAME");
        iPSDEFieldModel = this.getDEField("VALUEITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u52a8\u6001\u6807\u9898\u7684\u53d6\u503c\u8868\u5355\u9879");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_RAWITEM() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("RAWITEM");
        pSDEFGroupModel.setName("\u76f4\u63a5\u5185\u5bb9");
        pSDEFGroupModel.setUserTag("RAWITEM");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("3dd168bd6db48f9de7ecf80bc42d2224");
        pSDEFGroupDetailModel.setName("CONTENTTYPE");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CONTENTTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.ContentTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u76f4\u63a5\u5185\u5bb9\u6210\u5458\u7684\u5185\u5bb9\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5afed07492d48e30752a92ef58d3451f");
        pSDEFGroupDetailModel.setName("CTRLHEIGHT");
        iPSDEFieldModel = this.getDEField("CTRLHEIGHT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5185\u5bb9\u7684\u9ad8\u5ea6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8933f03cf450132fb2491fd8ca7733b3");
        pSDEFGroupDetailModel.setName("CTRLWIDTH");
        iPSDEFieldModel = this.getDEField("CTRLWIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5185\u5bb9\u7684\u5bbd\u5ea6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("510601108256a8fc1140aab2d8d02b43");
        pSDEFGroupDetailModel.setName("FORMTYPE");
        iPSDEFieldModel = this.getDEField("FORMTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("265f49ab3dc6702c53c650f9aa9bd50e");
        pSDEFGroupDetailModel.setName("HTMLCONTENT");
        iPSDEFieldModel = this.getDEField("HTMLCONTENT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\uff08Html\u5185\u5bb9\uff09\u7684Html\u5185\u5bb9");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9b638b78ac5a73add30293b6430b06fb");
        pSDEFGroupDetailModel.setName("PSDEID");
        iPSDEFieldModel = this.getDEField("PSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49e42309cb0365c0517a97a23f4b6d89");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u76f4\u63a5\u5185\u5bb9\u9879\u7c7b\u578b\u4e3a\u3010\u56fe\u7247\u3011\u65f6\u6307\u5b9a\u56fe\u7247\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("42b735dd62ba1f04ec385a31420f6196");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u76f4\u63a5\u5185\u5bb9\u9879\u7c7b\u578b\u4e3a\u3010\u56fe\u7247\u3011\u65f6\u6307\u5b9a\u56fe\u7247\u8d44\u6e90\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("fe2d79e0d7d749f0452fb3cd9ca0f39d");
        pSDEFGroupDetailModel.setName("PSSYSRESOURCEID");
        iPSDEFieldModel = this.getDEField("PSSYSRESOURCEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u7c7b\u578b\u4e3a\u3010\u76f4\u63a5\u5185\u5bb9\u3011\u6216\u3010html\u5185\u5bb9\u3011\u65f6\u6307\u5b9a\u7cfb\u7edf\u9884\u7f6e\u7684\u8d44\u6e90\u5bf9\u8c61\u8fdb\u884c\u5185\u5bb9\u63d0\u4f9b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("81dd9635ef01b58542a9bfac86d21f84");
        pSDEFGroupDetailModel.setName("PSSYSRESOURCENAME");
        iPSDEFieldModel = this.getDEField("PSSYSRESOURCENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u7c7b\u578b\u4e3a\u3010\u76f4\u63a5\u5185\u5bb9\u3011\u6216\u3010html\u5185\u5bb9\u3011\u65f6\u6307\u5b9a\u7cfb\u7edf\u9884\u7f6e\u7684\u8d44\u6e90\u5bf9\u8c61\u8fdb\u884c\u5185\u5bb9\u63d0\u4f9b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1ab30a14e596bd7fd755c931b9a2ac2d");
        pSDEFGroupDetailModel.setName("RAWCONTENT");
        iPSDEFieldModel = this.getDEField("RAWCONTENT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u5185\u5bb9\u7c7b\u578b\u4e3a\u3010\u76f4\u63a5\u5185\u5bb9\u3011\u65f6\u6307\u5b9a\u76f4\u63a5\u5185\u5bb9\uff0c\u672a\u6307\u5b9a\u65f6\u4f7f\u7528\u6307\u5b9a\u7684\u7cfb\u7edf\u8d44\u6e90\u5b9a\u4e49\u5185\u5bb9");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("72ef77c7f5d63f3e9fc7e454832c8206");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7b8f4cfdc15ab8be6188fa4b6c7afa5c");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_TABPAGE() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("TABPAGE");
        pSDEFGroupModel.setName("\u5206\u9875\u9762\u677f");
        pSDEFGroupModel.setUserTag("TABPAGE");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("da1fe9caa70b71eb08d9e6fcfb6b53ab");
        pSDEFGroupDetailModel.setName("CAPPSLANRESID");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CAPPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("269aa4eda4bc7b77015ac0ec90e02e3b");
        pSDEFGroupDetailModel.setName("CAPPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("CAPPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u9898\u7684\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61\uff0c\u672a\u5b9a\u4e49\u65f6\u8868\u5355\u9879\u6210\u5458\u4f7f\u7528\u5f15\u7528\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u7684\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("76521f0a30226e424d1fe23e14cbbbc7");
        pSDEFGroupDetailModel.setName("CAPTION");
        iPSDEFieldModel = this.getDEField("CAPTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c2a675e41e203417f0631bc4ace6ccaa");
        pSDEFGroupDetailModel.setName("IGNOREINPUT");
        iPSDEFieldModel = this.getDEField("IGNOREINPUT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FIValueIgnoreModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u7684\u5b50\u6210\u5458\u5ffd\u7565\u8f93\u5165\u503c\u7684\u65b9\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u5b58\u5728\u7236\u5bb9\u5668\u5219\u4f7f\u7528\u7236\u5bb9\u5668\u914d\u7f6e\uff0c\u5426\u5219\u4e3a\u3010\u65e0\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("01296429cd95fb7a43003fcf46a19035");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSID");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("40625ae4923f99e988d69f755b9ac465");
        pSDEFGroupDetailModel.setName("LABELPSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("LABELPSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6807\u9898\u4f7f\u7528\u7684\u754c\u9762\u6837\u5f0f\u8868\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49e42309cb0365c0517a97a23f4b6d89");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("42b735dd62ba1f04ec385a31420f6196");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("72ef77c7f5d63f3e9fc7e454832c8206");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7b8f4cfdc15ab8be6188fa4b6c7afa5c");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("13c4245a431e955c37120fead7ce536c");
        pSDEFGroupDetailModel.setName("VALUEITEMNAME");
        iPSDEFieldModel = this.getDEField("VALUEITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u52a8\u6001\u6807\u9898\u7684\u53d6\u503c\u8868\u5355\u9879");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e7aec273b57b3d5be81847e2b25bf607");
        pSDEFGroupDetailModel.setName("VISIBLELOGIC");
        iPSDEFieldModel = this.getDEField("VISIBLELOGIC", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_TABPANEL() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("TABPANEL");
        pSDEFGroupModel.setName("\u5206\u9875\u90e8\u4ef6");
        pSDEFGroupModel.setUserTag("TABPANEL");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49223abdaa12308c9099355e43fb35c1");
        pSDEFGroupDetailModel.setName("BUILDINACTION");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("BUILDINACTION", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormGroupMoreActionsCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u9762\u677f\u63d0\u4f9b\u5185\u7f6e\u64cd\u4f5c\u529f\u80fd\uff0c\u4e00\u822c\u5e94\u7528\u4e8e\u5206\u7ec4\u5305\u542b\u591a\u6570\u636e\u754c\u9762\u90e8\u4ef6\u573a\u5408\uff0c\u8c03\u7528\u591a\u6570\u636e\u90e8\u4ef6\u754c\u9762\u63d0\u4f9b\u7684\u76f8\u5173\u529f\u80fd");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c2a675e41e203417f0631bc4ace6ccaa");
        pSDEFGroupDetailModel.setName("IGNOREINPUT");
        iPSDEFieldModel = this.getDEField("IGNOREINPUT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FIValueIgnoreModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u5206\u7ec4\u7684\u5b50\u6210\u5458\u5ffd\u7565\u8f93\u5165\u503c\u7684\u65b9\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u5982\u5b58\u5728\u7236\u5bb9\u5668\u5219\u4f7f\u7528\u7236\u5bb9\u5668\u914d\u7f6e\uff0c\u5426\u5219\u4e3a\u3010\u65e0\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("81fe3e1775c55c9eac64f697d7b2c834");
        pSDEFGroupDetailModel.setName("INSERTPOS");
        iPSDEFieldModel = this.getDEField("INSERTPOS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1b22e2f100eb2b642724e57663a51096");
        pSDEFGroupDetailModel.setName("MASKINFO");
        iPSDEFieldModel = this.getDEField("MASKINFO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4c5481981feab282fa5a5a6b9b26d05b");
        pSDEFGroupDetailModel.setName("MASKMODE");
        iPSDEFieldModel = this.getDEField("MASKMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDRUIPartMaskModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e31d1e423b26f96ee086a74efb42ccb5");
        pSDEFGroupDetailModel.setName("MASKPSLANRESID");
        iPSDEFieldModel = this.getDEField("MASKPSLANRESID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("08eebb178ac06811959b99852c8007ad");
        pSDEFGroupDetailModel.setName("MASKPSLANRESNAME");
        iPSDEFieldModel = this.getDEField("MASKPSLANRESNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8b4a301886105ad29fa534688087952d");
        pSDEFGroupDetailModel.setName("PSDEDRID");
        iPSDEFieldModel = this.getDEField("PSDEDRID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("fc6e682017e488be55e017dc7a8f8ca9");
        pSDEFGroupDetailModel.setName("PSDEDRNAME");
        iPSDEFieldModel = this.getDEField("PSDEDRNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9b638b78ac5a73add30293b6430b06fb");
        pSDEFGroupDetailModel.setName("PSDEID");
        iPSDEFieldModel = this.getDEField("PSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7716a2a212f0da1f1bed02706f740b80");
        pSDEFGroupDetailModel.setName("RESETITEMNAME");
        iPSDEFieldModel = this.getDEField("RESETITEMNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u9879\u76d1\u63a7\u7684\u91cd\u7f6e\u9879\u540d\u79f0\uff0c\u91cd\u7f6e\u9879\u503c\u751f\u53d8\u5316\u65f6\u91cd\u7f6e\u5f53\u524d\u9879");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("72ef77c7f5d63f3e9fc7e454832c8206");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7b8f4cfdc15ab8be6188fa4b6c7afa5c");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e7aec273b57b3d5be81847e2b25bf607");
        pSDEFGroupDetailModel.setName("VISIBLELOGIC");
        iPSDEFieldModel = this.getDEField("VISIBLELOGIC", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel_USERCONTROL() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("USERCONTROL");
        pSDEFGroupModel.setName("\u7528\u6237\u63a7\u4ef6");
        pSDEFGroupModel.setUserTag("USERCONTROL");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5afed07492d48e30752a92ef58d3451f");
        pSDEFGroupDetailModel.setName("CTRLHEIGHT");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("CTRLHEIGHT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5185\u5bb9\u7684\u9ad8\u5ea6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8933f03cf450132fb2491fd8ca7733b3");
        pSDEFGroupDetailModel.setName("CTRLWIDTH");
        iPSDEFieldModel = this.getDEField("CTRLWIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5185\u5bb9\u7684\u5bbd\u5ea6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("510601108256a8fc1140aab2d8d02b43");
        pSDEFGroupDetailModel.setName("FORMTYPE");
        iPSDEFieldModel = this.getDEField("FORMTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormTypeCodeListModel");
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("9b638b78ac5a73add30293b6430b06fb");
        pSDEFGroupDetailModel.setName("PSDEID");
        iPSDEFieldModel = this.getDEField("PSDEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("49e42309cb0365c0517a97a23f4b6d89");
        pSDEFGroupDetailModel.setName("PSSYSIMAGEID");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGEID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("42b735dd62ba1f04ec385a31420f6196");
        pSDEFGroupDetailModel.setName("PSSYSIMAGENAME");
        iPSDEFieldModel = this.getDEField("PSSYSIMAGENAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u56fe\u6807\u5bf9\u8c61\uff0c\u5404\u7c7b\u578b\u6210\u5458\u6309\u81ea\u8eab\u7ea6\u5b9a\u653e\u7f6e\u56fe\u6807\u5bf9\u8c61");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1ab30a14e596bd7fd755c931b9a2ac2d");
        pSDEFGroupDetailModel.setName("RAWCONTENT");
        iPSDEFieldModel = this.getDEField("RAWCONTENT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u76f4\u63a5\u5185\u5bb9\u9879\u5185\u5bb9\u7c7b\u578b\u4e3a\u3010\u76f4\u63a5\u5185\u5bb9\u3011\u65f6\u6307\u5b9a\u76f4\u63a5\u5185\u5bb9\uff0c\u672a\u6307\u5b9a\u65f6\u4f7f\u7528\u6307\u5b9a\u7684\u7cfb\u7edf\u8d44\u6e90\u5b9a\u4e49\u5185\u5bb9");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("72ef77c7f5d63f3e9fc7e454832c8206");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINID");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7b8f4cfdc15ab8be6188fa4b6c7afa5c");
        pSDEFGroupDetailModel.setName("UCPSSYSPFPLUGINNAME");
        iPSDEFieldModel = this.getDEField("UCPSSYSPFPLUGINNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u4f7f\u7528\u7684\u524d\u7aef\u6a21\u677f\u6269\u5c55\u63d2\u4ef6\uff0c\u63d2\u4ef6\u7c7b\u578b\u3010\u8868\u5355\u81ea\u5b9a\u4e49\u63a7\u4ef6\u7ed8\u5236\u63d2\u4ef6\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }

    protected IPSDEFGroupModel preparePSDEFGroupModel__DEFAULT() throws Exception {
        PSDEFGroupModel pSDEFGroupModel = new PSDEFGroupModel();
        pSDEFGroupModel.setId("_DEFAULT");
        pSDEFGroupModel.setName("\u901a\u7528");
        pSDEFGroupModel.setMemo("");
        PSDEFGroupDetailModel pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d8ecef4ad7dfb7f927c8e137cb562a4f");
        pSDEFGroupDetailModel.setName("BL_POS");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("BL_POS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.BorderLayoutPosCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8fb9\u7f18\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u7684\u4f4d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("1cd8921a11a6a80758297f7f172a4323");
        pSDEFGroupDetailModel.setName("CHILD_COL_LG");
        iPSDEFieldModel = this.getDEField("CHILD_COL_LG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b50\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u5927\u578b\u754c\u9762\u7684\u9ed8\u8ba4\u5360\u4f4d\u6570\u91cf");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("12cad84720ccc6cb1c97cffa8377b1fe");
        pSDEFGroupDetailModel.setName("CHILD_COL_MD");
        iPSDEFieldModel = this.getDEField("CHILD_COL_MD", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b50\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u4e2d\u578b\u754c\u9762\u7684\u9ed8\u8ba4\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u4e3a\u5f53\u524d\u6805\u683c\u5217\u6570\uff08\u5360\u6ee1\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("67bfa22e450ce43d0d140b95435a87da");
        pSDEFGroupDetailModel.setName("CHILD_COL_SM");
        iPSDEFieldModel = this.getDEField("CHILD_COL_SM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b50\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u5c0f\u578b\u754c\u9762\u7684\u9ed8\u8ba4\u5360\u4f4d\u6570\u91cf");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d21f0dd3acced7c36b786cc692600335");
        pSDEFGroupDetailModel.setName("CHILD_COL_XS");
        iPSDEFieldModel = this.getDEField("CHILD_COL_XS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u5b50\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u8d85\u5c0f\u578b\u754c\u9762\u7684\u9ed8\u8ba4\u5360\u4f4d\u6570\u91cf");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("79b4c7b507456e68e12ec73fcc55a322");
        pSDEFGroupDetailModel.setName("COLID");
        iPSDEFieldModel = this.getDEField("COLID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u6210\u5458\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u5360\u4f4d\u5217\u6807\u8bc6\uff0c-1\u4e3a\u81ea\u52a8\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0bbbac2cf6c56a741416cbd8b5667a5d");
        pSDEFGroupDetailModel.setName("COLMODEL");
        iPSDEFieldModel = this.getDEField("COLMODEL", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5e03\u5c40\u5bb9\u5668\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u8868\u683c\u5217\u5206\u5272\u6a21\u578b\uff0c\u591a\u5217\u4f7f\u7528\u5206\u53f7\u5206\u9694\uff0c\u5217\u5bbd\u5ea6\u53ef\u4ee5\u4f7f\u7528\u767e\u5206\u6570\uff08\u8868\u683c\u5bbd\u5ea6\u5360\u6bd4\uff09\u3001\u6570\u5b57\u3001\u661f\u53f7\uff08\u5269\u4f59\uff09\uff0c\u5982 100;50%;* \u8868\u73b0\u7b2c\u4e00\u5217100\u50cf\u7d20\u3001\u7b2c\u4e8c\u5217\u8868\u683c\u4e00\u534a\u5bbd\u5ea6\uff0c\u7b2c\u4e09\u5217\u4e3a\u5269\u4f59\u5bbd\u5ea6");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("c5cb15b1a665388808e9e73937769be6");
        pSDEFGroupDetailModel.setName("COLSPAN");
        iPSDEFieldModel = this.getDEField("COLSPAN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u7684\u5360\u4f4d\u5217\u6570\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u30101\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5d5d4c395d48fdd00af3f501d9afff5a");
        pSDEFGroupDetailModel.setName("COL_LG");
        iPSDEFieldModel = this.getDEField("COL_LG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u5927\u578b\u754c\u9762\u7684\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u7236\u5bb9\u5668\u7684\u9ed8\u8ba4\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("bddc608206ce843f6ae721cc077d9844");
        pSDEFGroupDetailModel.setName("COL_LG_OS");
        iPSDEFieldModel = this.getDEField("COL_LG_OS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u5927\u578b\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("ea238d3022a350e601da505be6407abe");
        pSDEFGroupDetailModel.setName("COL_MD");
        iPSDEFieldModel = this.getDEField("COL_MD", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u4e2d\u578b\u754c\u9762\u7684\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u7236\u5bb9\u5668\u7684\u9ed8\u8ba4\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("11c4370b105d9872a27a1e71f60b5595");
        pSDEFGroupDetailModel.setName("COL_MD_OS");
        iPSDEFieldModel = this.getDEField("COL_MD_OS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u4e2d\u578b\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("265df258da87aed7111eed7c82881b35");
        pSDEFGroupDetailModel.setName("COL_SM");
        iPSDEFieldModel = this.getDEField("COL_SM", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u5c0f\u578b\u754c\u9762\u7684\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u7236\u5bb9\u5668\u7684\u9ed8\u8ba4\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("efa55b9e4e91ad6b1b4efeb865e738ab");
        pSDEFGroupDetailModel.setName("COL_SM_OS");
        iPSDEFieldModel = this.getDEField("COL_SM_OS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u5c0f\u578b\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d5c543e3ae3d39ff52596e01cca8c695");
        pSDEFGroupDetailModel.setName("COL_WIDTH");
        iPSDEFieldModel = this.getDEField("COL_WIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u56fa\u5b9a\u5217\u5bbd\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d9016c633bee24ceeedd6f4ca06df392");
        pSDEFGroupDetailModel.setName("COL_XS");
        iPSDEFieldModel = this.getDEField("COL_XS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u8d85\u5c0f\u754c\u9762\u7684\u5360\u4f4d\u6570\u91cf\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u7236\u5bb9\u5668\u7684\u9ed8\u8ba4\u914d\u7f6e");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("268765e89784ad670c6094b689104c0b");
        pSDEFGroupDetailModel.setName("COL_XS_OS");
        iPSDEFieldModel = this.getDEField("COL_XS_OS", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010\u6805\u683c\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u7684\u8d85\u5c0f\u754c\u9762\u7684\u5217\u504f\u79fb\u6570\u91cf\uff0c\u9ed8\u8ba4\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("33cd492668d62198702d6aa658b564b1");
        pSDEFGroupDetailModel.setName("DETAILSTYLE");
        iPSDEFieldModel = this.getDEField("DETAILSTYLE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDetailStyleCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u5185\u7f6e\u5f0f\u6837\uff0c\u5185\u7f6e\u5f0f\u6837\u662f\u6a21\u677f\u63d0\u4f9b\u7684\u8868\u73b0\u5f0f\u6837\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010\u9ed8\u8ba4\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("076ab331669cb6814bb546b828cdced4");
        pSDEFGroupDetailModel.setName("DETAILTYPE");
        iPSDEFieldModel = this.getDEField("DETAILTYPE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDetailType2CodeListModel");
        pSDEFGroupDetailModel.setMemo("\u8868\u5355\u6210\u5458\u7c7b\u578b");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d0a8d0b9d77bb0bdc714c525c7de6a18");
        pSDEFGroupDetailModel.setName("FLEXALIGN");
        iPSDEFieldModel = this.getDEField("FLEXALIGN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FlexAlignCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010Flex\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u6307\u5b9a\u6a2a\u8f74\u5bf9\u9f50\u65b9\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("4068cb15de2a359be8646ac510ae9bb0");
        pSDEFGroupDetailModel.setName("FLEXDIR");
        iPSDEFieldModel = this.getDEField("FLEXDIR", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FlexLayoutDirCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010Flex\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u6307\u5b9a\u5e03\u5c40\u65b9\u5411");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b83dcb2ac8b81125b98a63f63685684d");
        pSDEFGroupDetailModel.setName("FLEXGROW");
        iPSDEFieldModel = this.getDEField("FLEXGROW", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6210\u5458\u5728\u3010Flex\u5e03\u5c40\u3011\u6a21\u5f0f\u4e0b\u5ef6\u5c55\u503c\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("7c69d3f3beda2bc9782a7c8866be895e");
        pSDEFGroupDetailModel.setName("FLEXVALIGN");
        iPSDEFieldModel = this.getDEField("FLEXVALIGN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FlexVAlignCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010Flex\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u7eb5\u8f74\u5bf9\u9f50\u65b9\u5f0f");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d394e6d4182e43133102ef7b40aeeb3d");
        pSDEFGroupDetailModel.setName("GRIDROWID");
        iPSDEFieldModel = this.getDEField("GRIDROWID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u5360\u4f4d\u884c\u6807\u8bc6\uff0c-1\u4e3a\u81ea\u52a8\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u3010-1\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e8ec912adf16fdd685ecf1c8cea399e1");
        pSDEFGroupDetailModel.setName("HEIGHT");
        iPSDEFieldModel = this.getDEField("HEIGHT", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u9ad8\u5ea6\uff0c\u9ed8\u8ba4\u4e3a0\uff08\u81ea\u52a8\u8ba1\u7b97\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("8880ab3bb3b133b8f178378aaaa9ca60");
        pSDEFGroupDetailModel.setName("LAYOUTMODE");
        iPSDEFieldModel = this.getDEField("LAYOUTMODE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.FormDetailLayoutModeCodeListModel");
        pSDEFGroupDetailModel.setMemo("\u5bb9\u5668\u6210\u5458\u7684\u5e03\u5c40\u6a21\u5f0f\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u7236\u5bb9\u5668\u5e03\u5c40\uff08\u9876\u7ea7\u5bb9\u5668\u662f\u8868\u5355\u90e8\u4ef6\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("529e14540a5f19ba839222d62725341d");
        pSDEFGroupDetailModel.setName("MARGIN");
        iPSDEFieldModel = this.getDEField("MARGIN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u5916\u8fb9\u8ddd\uff0c\u6ce8\u610f\uff1a\u6b64\u914d\u7f6e\u540e\u7eed\u5c06\u88ab\u53d6\u6d88\uff0c\u5efa\u8bae\u901a\u8fc7\u4f7f\u7528\u754c\u9762\u6837\u5f0f\u8868\u5b8c\u6210\u5bf9\u5e94\u7684\u529f\u80fd");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b0b54264fc0c52a104b2eaf77a3b7b2e");
        pSDEFGroupDetailModel.setName("MEMO");
        iPSDEFieldModel = this.getDEField("MEMO", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("0d311585ccedc04f0452f882b2648492");
        pSDEFGroupDetailModel.setName("MODELSTATE");
        iPSDEFieldModel = this.getDEField("MODELSTATE", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setCodeListId("net.ibizsys.pscore.srv.codelist.DEFormDetailState2CodeListModel");
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u5728\u8fd0\u884c\u65f6\u8bbe\u8ba1\u5de5\u5177\u7684\u6269\u5c55\u63a7\u5236\u72b6\u6001\uff0c\u8fd0\u884c\u65f6\u8bbe\u8ba1\u5de5\u5177\u662f\u6307\u5728\u8fd0\u884c\u65f6\u73af\u5883\u63d0\u4f9b\u7684\u8868\u5355\u8bbe\u8ba1\u5de5\u5177");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("08781c842108d268b9f2c14611a4d101");
        pSDEFGroupDetailModel.setName("PPSDEFORMDETAILID");
        iPSDEFieldModel = this.getDEField("PPSDEFORMDETAILID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("cf31c81e53d9f054f03ec6df4a49ecaa");
        pSDEFGroupDetailModel.setName("PSDEFORMDETAILNAME");
        iPSDEFieldModel = this.getDEField("PSDEFORMDETAILNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u6807\u8bc6\uff0c\u9700\u5728\u6240\u5728\u8868\u5355\u4e2d\u5177\u6709\u552f\u4e00\u6027");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("a201de529fe5fe1b29d038e27ffa66f8");
        pSDEFGroupDetailModel.setName("PSDEFORMID");
        iPSDEFieldModel = this.getDEField("PSDEFORMID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("d4590b6f16a1d2e7a63ac42e0fae0156");
        pSDEFGroupDetailModel.setName("PSSYSCSSID");
        iPSDEFieldModel = this.getDEField("PSSYSCSSID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u5bb9\u5668\u6837\u5f0f\u8868");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("40ef42b67c383ae69b686ab16856a463");
        pSDEFGroupDetailModel.setName("PSSYSCSSNAME");
        iPSDEFieldModel = this.getDEField("PSSYSCSSNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u5bb9\u5668\u6837\u5f0f\u8868");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("e3ba63acd3311e92bb749961fe28d0d9");
        pSDEFGroupDetailModel.setName("PSSYSDYNAMODELID");
        iPSDEFieldModel = this.getDEField("PSSYSDYNAMODELID", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("87845fc2b2a8bebb5a6107010c213e46");
        pSDEFGroupDetailModel.setName("PSSYSDYNAMODELNAME");
        iPSDEFieldModel = this.getDEField("PSSYSDYNAMODELNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("5d9108b672e83f765bd33a11d125d635");
        pSDEFGroupDetailModel.setName("PADDING");
        iPSDEFieldModel = this.getDEField("PADDING", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u6307\u5b9a\u8868\u5355\u6210\u5458\u7684\u5185\u8fb9\u8ddd\uff0c\u6ce8\u610f\uff1a\u6b64\u914d\u7f6e\u540e\u7eed\u5c06\u88ab\u53d6\u6d88\uff0c\u5efa\u8bae\u901a\u8fc7\u4f7f\u7528\u754c\u9762\u6837\u5f0f\u8868\u5b8c\u6210\u5bf9\u5e94\u7684\u529f\u80fd");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("b5bbb00b2c6670c519f8cc866c5924c3");
        pSDEFGroupDetailModel.setName("ROWSPAN");
        iPSDEFieldModel = this.getDEField("ROWSPAN", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u7236\u5bb9\u5668\u5e03\u5c40\u6a21\u5f0f\u4e3a\u3010\u8868\u683c\u5e03\u5c40\u3011\u65f6\u6307\u5b9a\u6210\u5458\u7684\u5360\u4f4d\u884c\u6570\uff0c\u672a\u5b9a\u4e49\u65f6\u4e3a\u30101\u3011");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("04d8faaba3964b63d09fb613096f91ec");
        pSDEFGroupDetailModel.setName("USERTAG");
        iPSDEFieldModel = this.getDEField("USERTAG", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2e78ddd1e06e7607f70c3de68c35bd9e");
        pSDEFGroupDetailModel.setName("USERTAG2");
        iPSDEFieldModel = this.getDEField("USERTAG2", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        pSDEFGroupDetailModel = new PSDEFGroupDetailModel();
        pSDEFGroupDetailModel.setId("2fcb5c5639d38872ab3a3bb2bf48f776");
        pSDEFGroupDetailModel.setName("WIDTH");
        iPSDEFieldModel = this.getDEField("WIDTH", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("\u5bbd\u5ea6\uff0c\u9ed8\u8ba4\u4e3a0\uff08\u81ea\u9002\u5e94\u5bb9\u5668\u5bbd\u5ea6\uff09");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

