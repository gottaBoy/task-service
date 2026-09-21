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
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.ac.PSDSPanelToolBoxDefaultACModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataquery.PSDSPanelToolBoxButtonDQModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataquery.PSDSPanelToolBoxContainerDQModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataquery.PSDSPanelToolBoxControlDQModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataquery.PSDSPanelToolBoxCtrlPosDQModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataquery.PSDSPanelToolBoxDefaultDQModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataquery.PSDSPanelToolBoxFieldDQModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataquery.PSDSPanelToolBoxRawItemDQModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataset.PSDSPanelToolBoxButtonDSModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataset.PSDSPanelToolBoxContainerDSModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataset.PSDSPanelToolBoxControlDSModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataset.PSDSPanelToolBoxCtrlPosDSModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataset.PSDSPanelToolBoxDefaultDSModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataset.PSDSPanelToolBoxFieldDSModel;
import net.ibizsys.pscore.srv.sysdevstudio.demodel.psdspaneltoolbox.dataset.PSDSPanelToolBoxRawItemDSModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDSPanelToolBox;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDSPanelToolBoxService;

public abstract class PSDSPanelToolBoxDEModelBase
extends PSDataEntityModelBase<PSDSPanelToolBox> {
    private PSCoreSysModel pSCoreSysModel;
    private PSDSPanelToolBoxService pSDSPanelToolBoxService;

    public PSDSPanelToolBoxDEModelBase() throws Exception {
        this.setId("b2460bd425224b50d5a2f43b07188383");
        this.setName("PSDSPANELTOOLBOX");
        this.setCodeName("PSDSPanelToolBox");
        this.setTableName("T_SRFPSDSPANELTOOLBOX");
        this.setViewName("v_PSDSPANELTOOLBOX");
        this.setLogicName("\u9762\u677f\u5de5\u5177\u7bb1");
        this.setDSLink("DEFAULT");
        this.setDataAccCtrlMode(1);
        this.setAuditMode(0);
        if (this.isRegisterToDEModelGlobal()) {
            DEModelGlobal.registerDEModel((String)"net.ibizsys.pscore.srv.sysdevstudio.demodel.PSDSPanelToolBoxDEModel", (IDataEntityModel)this);
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

    public PSDSPanelToolBoxService getRealService() {
        if (this.pSDSPanelToolBoxService == null) {
            try {
                this.pSDSPanelToolBoxService = (PSDSPanelToolBoxService)ServiceGlobal.getService((String)this.getServiceId());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDSPanelToolBoxService;
    }

    public IService getService() {
        return this.getRealService();
    }

    public String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdevstudio.service.PSDSPanelToolBoxService";
    }

    public PSDSPanelToolBox createEntity() {
        return new PSDSPanelToolBox();
    }

    protected void prepareDEFields() throws Exception {
        DEFSearchModeModel dEFSearchModeModel;
        PSDEFieldModel pSDEFieldModel;
        Object object = null;
        IDEFSearchMode iDEFSearchMode = null;
        object = this.createDEField("CAT");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7cd08ecd371b010ce0ee0a374e6645eb");
            pSDEFieldModel.setName("CAT");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5206\u7c7b");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("Cat");
            pSDEFieldModel.setLength(30);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("CREATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("078ef055362d8577c64f151d4df38f52");
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
            pSDEFieldModel.setId("8f1a32f4f2c06f0df59022a530eaf65f");
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
        object = this.createDEField("ICONCLS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7d742cdc9ec19806bde1ab8c245c54c1");
            pSDEFieldModel.setName("ICONCLS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u56fe\u6807\u6837\u5f0f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("IconCls");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("INITPARAMS");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("8b144f06f86eca383ad3365f69cf82b6");
            pSDEFieldModel.setName("INITPARAMS");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u521d\u59cb\u5316\u53c2\u6570");
            pSDEFieldModel.setDataType("LONGTEXT_1000");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("InitParams");
            pSDEFieldModel.setLength(4000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("ITEMTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7b818f17834e6621c6a51ff9a942a827");
            pSDEFieldModel.setName("ITEMTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5b9e\u9645\u9879\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PanelItemTypeCodeListModel");
            pSDEFieldModel.setCodeName("ItemType");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_ITEMTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_ITEMTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
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
            pSDEFieldModel.setId("65105185be5191f95e0b912d70fb390b");
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
        object = this.createDEField("PSDSPANELTOOLBOXID");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("84ee4415783641c4d1e5152a0262aa44");
            pSDEFieldModel.setName("PSDSPANELTOOLBOXID");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9762\u677f\u5de5\u5177\u7bb1\u6807\u8bc6");
            pSDEFieldModel.setDataType("GUID");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setKeyDEField(true);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setUserInputMode(0);
            pSDEFieldModel.setCodeName("PSDSPanelToolBoxId");
            pSDEFieldModel.setLength(100);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("PSDSPANELTOOLBOXNAME");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("7a45c80fd340e3152cba8614f71f3b6a");
            pSDEFieldModel.setName("PSDSPANELTOOLBOXNAME");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u9762\u677f\u5de5\u5177\u7bb1\u540d\u79f0");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setMajorDEField(true);
            pSDEFieldModel.setImportOrder(100);
            pSDEFieldModel.setCodeName("PSDSPanelToolBoxName");
            pSDEFieldModel.setLength(200);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_PSDSPANELTOOLBOXNAME_LIKE");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_PSDSPANELTOOLBOXNAME_LIKE");
                dEFSearchModeModel.setValueOp("LIKE");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TOOLBOXTYPE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("97d34f0a52544287149316e698e84d02");
            pSDEFieldModel.setName("TOOLBOXTYPE");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u5de5\u5177\u7bb1\u7c7b\u578b");
            pSDEFieldModel.setDataType("SSCODELIST");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeListId("net.ibizsys.pscore.srv.codelist.PanelItemTypeCodeListModel");
            pSDEFieldModel.setCodeName("ToolBoxType");
            pSDEFieldModel.setLength(30);
            iDEFSearchMode = this.createDEFSearchMode((IDEField)pSDEFieldModel, "N_TOOLBOXTYPE_EQ");
            if (iDEFSearchMode == null) {
                dEFSearchModeModel = new DEFSearchModeModel();
                dEFSearchModeModel.setDEField((IDEField)pSDEFieldModel);
                dEFSearchModeModel.setName("N_TOOLBOXTYPE_EQ");
                dEFSearchModeModel.setValueOp("EQ");
                dEFSearchModeModel.init();
                pSDEFieldModel.registerDEFSearchMode((IDEFSearchMode)dEFSearchModeModel);
            }
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("TOOLTIP");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("5c40d45f761ffd91b659db398f6cc533");
            pSDEFieldModel.setName("TOOLTIP");
            pSDEFieldModel.setDEFType(1);
            pSDEFieldModel.setLogicName("\u63d0\u793a\u4fe1\u606f");
            pSDEFieldModel.setDataType("TEXT");
            pSDEFieldModel.setStdDataType(25);
            pSDEFieldModel.setImportOrder(-1);
            pSDEFieldModel.setCodeName("ToolTip");
            pSDEFieldModel.setLength(2000);
            pSDEFieldModel.init();
            object = pSDEFieldModel;
        }
        this.registerDEField((IDEField)object);
        object = this.createDEField("UPDATEDATE");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("137b944bb94c0fba5fab25aae8ab6991");
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
            pSDEFieldModel.setId("b2aa264191557707f0fb2b7c53617551");
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
            pSDEFieldModel.setId("3f2cd857f7e8a41580ad9c60d6a0ce97");
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
            pSDEFieldModel.setId("cb442b2bfff350bffa0baaa690dbd7be");
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
        object = this.createDEField("VALIDFLAG");
        if (object == null) {
            pSDEFieldModel = new PSDEFieldModel();
            pSDEFieldModel.setDataEntity((IDataEntity)this);
            pSDEFieldModel.setId("61e911dc6cdbc53042086ea4991e550d");
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
        PSDSPanelToolBoxDefaultACModel pSDSPanelToolBoxDefaultACModel = new PSDSPanelToolBoxDefaultACModel();
        pSDSPanelToolBoxDefaultACModel.init((IDataEntity)this);
        this.registerDEACMode((IDEACMode)pSDSPanelToolBoxDefaultACModel);
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
        PSDSPanelToolBoxButtonDSModel pSDSPanelToolBoxButtonDSModel = new PSDSPanelToolBoxButtonDSModel();
        pSDSPanelToolBoxButtonDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDSPanelToolBoxButtonDSModel);
        PSDSPanelToolBoxContainerDSModel pSDSPanelToolBoxContainerDSModel = new PSDSPanelToolBoxContainerDSModel();
        pSDSPanelToolBoxContainerDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDSPanelToolBoxContainerDSModel);
        PSDSPanelToolBoxControlDSModel pSDSPanelToolBoxControlDSModel = new PSDSPanelToolBoxControlDSModel();
        pSDSPanelToolBoxControlDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDSPanelToolBoxControlDSModel);
        PSDSPanelToolBoxCtrlPosDSModel pSDSPanelToolBoxCtrlPosDSModel = new PSDSPanelToolBoxCtrlPosDSModel();
        pSDSPanelToolBoxCtrlPosDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDSPanelToolBoxCtrlPosDSModel);
        PSDSPanelToolBoxDefaultDSModel pSDSPanelToolBoxDefaultDSModel = new PSDSPanelToolBoxDefaultDSModel();
        pSDSPanelToolBoxDefaultDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDSPanelToolBoxDefaultDSModel);
        PSDSPanelToolBoxFieldDSModel pSDSPanelToolBoxFieldDSModel = new PSDSPanelToolBoxFieldDSModel();
        pSDSPanelToolBoxFieldDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDSPanelToolBoxFieldDSModel);
        PSDSPanelToolBoxRawItemDSModel pSDSPanelToolBoxRawItemDSModel = new PSDSPanelToolBoxRawItemDSModel();
        pSDSPanelToolBoxRawItemDSModel.init((IDataEntity)this);
        this.registerDEDataSet((IDEDataSet)pSDSPanelToolBoxRawItemDSModel);
    }

    protected void prepareDEDataQueries() throws Exception {
        PSDSPanelToolBoxButtonDQModel pSDSPanelToolBoxButtonDQModel = new PSDSPanelToolBoxButtonDQModel();
        pSDSPanelToolBoxButtonDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDSPanelToolBoxButtonDQModel);
        PSDSPanelToolBoxContainerDQModel pSDSPanelToolBoxContainerDQModel = new PSDSPanelToolBoxContainerDQModel();
        pSDSPanelToolBoxContainerDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDSPanelToolBoxContainerDQModel);
        PSDSPanelToolBoxControlDQModel pSDSPanelToolBoxControlDQModel = new PSDSPanelToolBoxControlDQModel();
        pSDSPanelToolBoxControlDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDSPanelToolBoxControlDQModel);
        PSDSPanelToolBoxCtrlPosDQModel pSDSPanelToolBoxCtrlPosDQModel = new PSDSPanelToolBoxCtrlPosDQModel();
        pSDSPanelToolBoxCtrlPosDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDSPanelToolBoxCtrlPosDQModel);
        PSDSPanelToolBoxDefaultDQModel pSDSPanelToolBoxDefaultDQModel = new PSDSPanelToolBoxDefaultDQModel();
        pSDSPanelToolBoxDefaultDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDSPanelToolBoxDefaultDQModel);
        PSDSPanelToolBoxFieldDQModel pSDSPanelToolBoxFieldDQModel = new PSDSPanelToolBoxFieldDQModel();
        pSDSPanelToolBoxFieldDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDSPanelToolBoxFieldDQModel);
        PSDSPanelToolBoxRawItemDQModel pSDSPanelToolBoxRawItemDQModel = new PSDSPanelToolBoxRawItemDQModel();
        pSDSPanelToolBoxRawItemDQModel.init((IDataEntity)this);
        this.registerDEDataQuery((IDEDataQuery)pSDSPanelToolBoxRawItemDQModel);
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
        this.registerPDTDEView("EDITVIEW", "200bf96eda57702b723cd819bf01e56c");
        this.registerPDTDEView("MDATAVIEW", "74a035f361d620c192beb5de1529c5e5");
        this.registerPDTDEView("MPICKUPVIEW", "561eb66c86a16e679cc1ded92647aea0");
        this.registerPDTDEView("PICKUPVIEW", "fdfacea85d45a6eb0b75541ca434a353");
        this.registerPDTDEView("REDIRECTVIEW", "437015aaa50902db0bc32f027c61d454");
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
        dEDataSetCond2.setDEFName("PSDSPANELTOOLBOXNAME");
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
        pSDEFGroupDetailModel.setId("7a45c80fd340e3152cba8614f71f3b6a");
        pSDEFGroupDetailModel.setName("PSDSPANELTOOLBOXNAME");
        IPSDEFieldModel iPSDEFieldModel = this.getDEField("PSDSPANELTOOLBOXNAME", true);
        if (iPSDEFieldModel instanceof IPSDEFieldModel) {
            pSDEFGroupDetailModel.setPSDEFieldModel(iPSDEFieldModel);
        }
        pSDEFGroupDetailModel.setMemo("");
        pSDEFGroupModel.registerPSDEFGroupDetailModel(pSDEFGroupDetailModel);
        return pSDEFGroupModel;
    }
}

