/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.model.IPSDepSlnSys
 *  net.ibizsys.model.IPSModelStorage
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.control.IPSControlType
 *  net.ibizsys.model.control.IPSEditorType
 *  net.ibizsys.model.control.counter.IPSCounter
 *  net.ibizsys.model.control.counter.IPSCounterType
 *  net.ibizsys.model.control.form.IPSDEFDLogic
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.control.grid.IPSDEGrid
 *  net.ibizsys.model.control.grid.IPSDEGridColumn
 *  net.ibizsys.model.control.toolbar.IPSDEToolbar
 *  net.ibizsys.model.control.toolbar.IPSDEToolbarItem
 *  net.ibizsys.model.data.IPSDBValueOP
 *  net.ibizsys.model.res.IPSPortletType
 *  net.ibizsys.model.view.IPSViewType
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.db.IDBDialect
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.beans.factory.annotation.Qualifier
 */
package net.ibizsys.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import net.ibizsys.model.IPSDepSlnSys;
import net.ibizsys.model.IPSModelStorage;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSDepSlnSysGlobalModel;
import net.ibizsys.model.PSModelQueryHelperFactory;
import net.ibizsys.model.control.IPSControlType;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.PSControlTypeGlobalModel;
import net.ibizsys.model.control.PSEditorTypeGlobalModel;
import net.ibizsys.model.control.counter.IPSCounter;
import net.ibizsys.model.control.counter.IPSCounterType;
import net.ibizsys.model.control.counter.PSCounterGlobalModel;
import net.ibizsys.model.control.counter.PSCounterTypeGlobalModel;
import net.ibizsys.model.control.form.IPSDEFDLogic;
import net.ibizsys.model.control.form.IPSDEFDLogicRuntime;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormDetailRuntime;
import net.ibizsys.model.control.form.IPSFDLogicType;
import net.ibizsys.model.control.form.IPSFormDetailType;
import net.ibizsys.model.control.form.PSFDLogicTypeGlobalModel;
import net.ibizsys.model.control.form.PSFormDetailTypeGlobalModel;
import net.ibizsys.model.control.form.PSFormTypeGlobalModel;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridColumnRuntime;
import net.ibizsys.model.control.grid.IPSDEGridColumnType;
import net.ibizsys.model.control.grid.PSDEGridColumnTypeGlobalModel;
import net.ibizsys.model.control.menu.IPSAppMenuItemType;
import net.ibizsys.model.control.menu.PSAppMenuItemTypeGlobalModel;
import net.ibizsys.model.control.toolbar.IPSDEToolbar;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItemRuntime;
import net.ibizsys.model.control.toolbar.IPSToolbarItemType;
import net.ibizsys.model.control.toolbar.PSToolbarItemTypeGlobalModel;
import net.ibizsys.model.data.IPSDBValueOP;
import net.ibizsys.model.database.PSDBValueOPGlobalModel;
import net.ibizsys.model.dataentity.action.IPSDEActionType;
import net.ibizsys.model.dataentity.action.PSDEActionTypeGlobalModel;
import net.ibizsys.model.dataentity.dr.IPSDRItemType;
import net.ibizsys.model.dataentity.dr.PSDRItemTypeGlobalModel;
import net.ibizsys.model.dataentity.field.IPSDEFieldType;
import net.ibizsys.model.dataentity.field.PSDEFieldTypeGlobalModel;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRuleType;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFValueRuleTypeGlobalModel;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCondType;
import net.ibizsys.model.dataentity.logic.IPSDELogicNodeType;
import net.ibizsys.model.dataentity.logic.PSDELogicLinkCondTypeGlobalModel;
import net.ibizsys.model.dataentity.logic.PSDELogicNodeTypeGlobalModel;
import net.ibizsys.model.der.IPSDERType;
import net.ibizsys.model.der.PSDERTypeGlobalModel;
import net.ibizsys.model.entity.PSDEFDLogic;
import net.ibizsys.model.entity.PSDEFormDetail;
import net.ibizsys.model.entity.PSDEGridColumn;
import net.ibizsys.model.entity.PSDEToolbarItem;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFPluginTempl;
import net.ibizsys.model.pf.PSPFGlobalModel;
import net.ibizsys.model.pf.PSPFPluginTemplGlobalModel;
import net.ibizsys.model.res.IPSPortletType;
import net.ibizsys.model.res.PSPortletTypeGlobalModel;
import net.ibizsys.model.util.ThreadLockChecker;
import net.ibizsys.model.view.IPSViewType;
import net.ibizsys.model.view.PSViewTypeGlobalModel;
import net.ibizsys.model.wf.IPSWFLinkCondType;
import net.ibizsys.model.wf.IPSWFLinkType;
import net.ibizsys.model.wf.IPSWFProcessType;
import net.ibizsys.model.wf.PSWFLinkCondTypeGlobalModel;
import net.ibizsys.model.wf.PSWFLinkTypeGlobalModel;
import net.ibizsys.model.wf.PSWFProcessTypeGlobalModel;
import net.ibizsys.model.zookeeper.PSModelEntityKeeperGlobal;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PSModelStorageImpl
implements IPSModelStorage,
IPSModelStorageContext {
    private static final Log log = LogFactory.getLog(PSModelStorageImpl.class);
    private final PSEditorTypeGlobalModel psEditorTypeGlobalModel = new PSEditorTypeGlobalModel();
    private final PSDBValueOPGlobalModel psDBValueOPGlobalModel = new PSDBValueOPGlobalModel();
    private final PSCounterTypeGlobalModel psCounterTypeGlobalModel = new PSCounterTypeGlobalModel();
    private final PSCounterGlobalModel psCounterGlobalModel = new PSCounterGlobalModel();
    private final PSWFLinkTypeGlobalModel psWFLinkTypeGlobalModel = new PSWFLinkTypeGlobalModel();
    private final PSWFProcessTypeGlobalModel psWFProcessTypeGlobalModel = new PSWFProcessTypeGlobalModel();
    private final PSWFLinkCondTypeGlobalModel psWFLinkCondTypeGlobalModel = new PSWFLinkCondTypeGlobalModel();
    private final PSViewTypeGlobalModel psViewTypeGlobalModel = new PSViewTypeGlobalModel();
    private final PSDERTypeGlobalModel psDERTypeGlobalModel = new PSDERTypeGlobalModel();
    private final PSDEFValueRuleTypeGlobalModel psDEFValueRuleTypeGlobalModel = new PSDEFValueRuleTypeGlobalModel();
    private final PSDEFieldTypeGlobalModel psDEFieldTypeGlobalModel = new PSDEFieldTypeGlobalModel();
    private final PSDRItemTypeGlobalModel psDRItemTypeGlobalModel = new PSDRItemTypeGlobalModel();
    private final PSDELogicLinkCondTypeGlobalModel psDELogicLinkCondTypeGlobalModel = new PSDELogicLinkCondTypeGlobalModel();
    private final PSDELogicNodeTypeGlobalModel psDELogicNodeTypeGlobalModel = new PSDELogicNodeTypeGlobalModel();
    private final PSDEActionTypeGlobalModel psDEActionTypeGlobalModel = new PSDEActionTypeGlobalModel();
    private final PSPortletTypeGlobalModel psPortletTypeGlobalModel = new PSPortletTypeGlobalModel();
    private final PSFormTypeGlobalModel psFormTypeGlobalModel = new PSFormTypeGlobalModel();
    private final PSFormDetailTypeGlobalModel psFormDetailTypeGlobalModel = new PSFormDetailTypeGlobalModel();
    private final PSFDLogicTypeGlobalModel psFDLogicTypeGlobalModel = new PSFDLogicTypeGlobalModel();
    private final PSToolbarItemTypeGlobalModel psToolbarItemTypeGlobalModel = new PSToolbarItemTypeGlobalModel();
    private final PSControlTypeGlobalModel psControlTypeGlobalModel = new PSControlTypeGlobalModel();
    private final PSDEGridColumnTypeGlobalModel psDEGridColumnTypeGlobalModel = new PSDEGridColumnTypeGlobalModel();
    private final PSAppMenuItemTypeGlobalModel psAppMenuItemTypeGlobalModel = new PSAppMenuItemTypeGlobalModel();
    private final PSPFPluginTemplGlobalModel psPFPluginTemplGlobalModel = new PSPFPluginTemplGlobalModel();
    private final PSPFGlobalModel psPFGlobalModel = new PSPFGlobalModel();
    private boolean bLoaded = false;
    private final HashMap<String, PSDepSlnSysGlobalModel> psDepSlnSysGlobalModelMap = new HashMap();
    private String lock_psDepSlnSysGlobalModelMap = null;
    private static HashMap<String, String> objectMap = new HashMap();
    private static ArrayList<String> objList = new ArrayList();
    private ScheduledExecutorService scheduledThreadPool = null;
    @Autowired(required=false)
    @Qualifier(value="modelDBDialect")
    private IDBDialect modelDBDialect;
    @Autowired(required=false)
    @Qualifier(value="modelSessionFactory")
    private SessionFactory modelSessionFactory;
    @Autowired(required=false)
    @Qualifier(value="depSlnSysId")
    private String depSlnSysId;
    @Autowired(required=false)
    @Qualifier(value="restServiceUrl")
    private String restServiceUrl;

    static {
        objList.add("SA.SRFDA.PS.Core.Control.Form");
        objList.add("SA.SRFDA.PS.Core.Control.Toolbar");
        objList.add("SA.SRFDA.PS.Core.Control.Grid");
        objList.add("SA.SRFDA.PS.Core.Control.Menu");
        objList.add("SA.SRFDA.PS.Core.Control.List");
        objList.add("SA.SRFDA.PS.Core.Control.Chart");
        objList.add("SA.SRFDA.PS.Core.Control.Counter");
        objList.add("SA.SRFDA.PS.Core.Control.Dashboard");
        objList.add("SA.SRFDA.PS.Core.Control.DataView");
        objList.add("SA.SRFDA.PS.Core.Control.DRCtrl");
        objList.add("SA.SRFDA.PS.Core.Control.ExpBar");
        objList.add("SA.SRFDA.PS.Core.Control.List");
        objList.add("SA.SRFDA.PS.Core.Control.Tree");
        objList.add("SA.SRFDA.PS.Core.Control.Ajax");
        objList.add("SA.SRFDA.PS.Core.Control.ViewPanel");
        objList.add("SA.SRFDA.PS.Core.Control");
        objList.add("SA.SRFDA.PS.Core.DEField.ValueRule");
        objList.add("SA.SRFDA.PS.Core.DEField");
        objList.add("SA.SRFDA.PS.Core.DataEntity.UIAction");
        objList.add("SA.SRFDA.PS.Core.DataEntity.Action");
        objList.add("SA.SRFDA.PS.Core.DataEntity.DR");
        objList.add("SA.SRFDA.PS.Core.App.View");
        objList.add("SA.SRFDA.PS.Core.Res");
        objList.add("SA.SRFDA.PS.Core.WF.UIAction");
        objList.add("SA.SRFDA.PS.Core.WF");
        objList.add("SA.SRFDA.PS.Core.PF");
        objList.add("SA.SRFDA.PS.Core.Pub.Vue2");
        objList.add("SA.SRFDA.PS.Core.Pub.Vue3");
        objList.add("SA.SRFDA.PS.Core.Pub");
        objectMap.put("SA.SRFDA.PS.Core.App.View", "net.ibizsys.model.app.view");
        objectMap.put("SA.SRFDA.PS.Core.Control.Form", "net.ibizsys.model.control.form");
        objectMap.put("SA.SRFDA.PS.Core.Control.Toolbar", "net.ibizsys.model.control.toolbar");
        objectMap.put("SA.SRFDA.PS.Core.Control.Grid", "net.ibizsys.model.control.grid");
        objectMap.put("SA.SRFDA.PS.Core.Control.Menu", "net.ibizsys.model.control.menu");
        objectMap.put("SA.SRFDA.PS.Core.Control.List", "net.ibizsys.model.control.list");
        objectMap.put("SA.SRFDA.PS.Core.Control.Chart", "net.ibizsys.model.control.chart");
        objectMap.put("SA.SRFDA.PS.Core.Control.Counter", "net.ibizsys.model.control.counter");
        objectMap.put("SA.SRFDA.PS.Core.Control.Dashboard", "net.ibizsys.model.control.dashboard");
        objectMap.put("SA.SRFDA.PS.Core.Control.DataView", "net.ibizsys.model.control.dataview");
        objectMap.put("SA.SRFDA.PS.Core.Control.DRCtrl", "net.ibizsys.model.control.drctrl");
        objectMap.put("SA.SRFDA.PS.Core.Control.ExpBar", "net.ibizsys.model.control.expbar");
        objectMap.put("SA.SRFDA.PS.Core.Control.List", "net.ibizsys.model.control.list");
        objectMap.put("SA.SRFDA.PS.Core.Control.Tree", "net.ibizsys.model.control.tree");
        objectMap.put("SA.SRFDA.PS.Core.Control.ViewPanel", "net.ibizsys.model.control.viewpanel");
        objectMap.put("SA.SRFDA.PS.Core.Control", "net.ibizsys.model.control");
        objectMap.put("SA.SRFDA.PS.Core.Control.Ajax", "net.ibizsys.model.control.ajax");
        objectMap.put("SA.SRFDA.PS.Core.DEField.ValueRule", "net.ibizsys.model.dataentity.field.valuerule");
        objectMap.put("SA.SRFDA.PS.Core.DEField", "net.ibizsys.model.dataentity.field");
        objectMap.put("SA.SRFDA.PS.Core.DataEntity.Action", "net.ibizsys.model.dataentity.action");
        objectMap.put("SA.SRFDA.PS.Core.DataEntity.UIAction", "net.ibizsys.model.dataentity.uiaction");
        objectMap.put("SA.SRFDA.PS.Core.DataEntity.DR", "net.ibizsys.model.dataentity.dr");
        objectMap.put("SA.SRFDA.PS.Core.Res", "net.ibizsys.model.res");
        objectMap.put("SA.SRFDA.PS.Core.WF", "net.ibizsys.model.wf");
        objectMap.put("SA.SRFDA.PS.Core.WF.UIAction", "net.ibizsys.model.wf.uiaction");
        objectMap.put("SA.SRFDA.PS.Core.PF", "net.ibizsys.model.pf");
        objectMap.put("SA.SRFDA.PS.Core.Pub", "net.ibizsys.model.pub");
        objectMap.put("SA.SRFDA.PS.Core.Pub.Vue2", "net.ibizsys.model.pub.vue2");
        objectMap.put("SA.SRFDA.PS.Core.Pub.Vue3", "net.ibizsys.model.pub.vue3");
    }

    @PostConstruct
    public void init() throws Exception {
        PSModelEntityKeeperGlobal.initAll();
        this.lock_psDepSlnSysGlobalModelMap = StringHelper.format((String)"psDepSlnSysGlobalModelMap@%1$s", (Object)this);
        if (!StringHelper.isNullOrEmpty((String)this.getRestServiceUrl())) {
            PSModelQueryHelperFactory.setRestServiceUrl(this.getRestServiceUrl());
            PSModelQueryHelperFactory.setPSDepSlnSysId(this.getDepSlnSysId());
        } else if (this.modelDBDialect != null && this.modelSessionFactory != null) {
            DAOGlobal.registerDBDialect((SessionFactory)this.modelSessionFactory, (IDBDialect)this.modelDBDialect);
            PSModelQueryHelperFactory.setMajorSessionFactory(this.modelSessionFactory);
        }
        this.onInit();
        this.scheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.scheduledThreadPool.scheduleAtFixedRate(new Runnable(){

            @Override
            public void run() {
                PSModelStorageImpl.this.refreshModelStorageVer();
            }
        }, 15L, 15L, TimeUnit.SECONDS);
        this.bLoaded = true;
    }

    protected void onInit() throws Exception {
        this.psPFGlobalModel.init(this);
        this.psDEFieldTypeGlobalModel.init(this);
        this.psEditorTypeGlobalModel.init(this);
        this.psDBValueOPGlobalModel.init(this);
        this.psCounterTypeGlobalModel.init(this);
        this.psCounterGlobalModel.init(this);
        this.psWFLinkTypeGlobalModel.init(this);
        this.psWFProcessTypeGlobalModel.init(this);
        this.psWFLinkTypeGlobalModel.init(this);
        this.psWFLinkCondTypeGlobalModel.init(this);
        this.psViewTypeGlobalModel.init(this);
        this.psDERTypeGlobalModel.init(this);
        this.psDEFValueRuleTypeGlobalModel.init(this);
        this.psDRItemTypeGlobalModel.init(this);
        this.psDELogicLinkCondTypeGlobalModel.init(this);
        this.psDELogicNodeTypeGlobalModel.init(this);
        this.psDEActionTypeGlobalModel.init(this);
        this.psPortletTypeGlobalModel.init(this);
        this.psFormTypeGlobalModel.init(this);
        this.psFormDetailTypeGlobalModel.init(this);
        this.psFDLogicTypeGlobalModel.init(this);
        this.psToolbarItemTypeGlobalModel.init(this);
        this.psControlTypeGlobalModel.init(this);
        this.psDEGridColumnTypeGlobalModel.init(this);
        this.psAppMenuItemTypeGlobalModel.init(this);
        this.psPFPluginTemplGlobalModel.init(this);
    }

    protected void refreshModelStorageVer() {
        ArrayList<PSDepSlnSysGlobalModel> list = new ArrayList<PSDepSlnSysGlobalModel>();
        list.addAll(this.psDepSlnSysGlobalModelMap.values());
        for (PSDepSlnSysGlobalModel psDepSlnSysGlobalModel : list) {
            psDepSlnSysGlobalModel.refreshModelVer();
        }
    }

    public void setModelDBDialect(IDBDialect modelDBDialect) {
        this.modelDBDialect = modelDBDialect;
    }

    public IDBDialect getModelDBDialect() {
        return this.modelDBDialect;
    }

    public void setModelSessionFactory(SessionFactory modelSessionFactory) {
        this.modelSessionFactory = modelSessionFactory;
    }

    public SessionFactory getModelSessionFactory() {
        return this.modelSessionFactory;
    }

    public String getDepSlnSysId() {
        return this.depSlnSysId;
    }

    public void setDepSlnSysId(String depSlnSysId) {
        this.depSlnSysId = depSlnSysId;
    }

    public String getRestServiceUrl() {
        return this.restServiceUrl;
    }

    public void setRestServiceUrl(String restServiceUrl) {
        this.restServiceUrl = restServiceUrl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IPSDepSlnSys getPSDepSlnSys(String strPSDepSlnSysId) throws Exception {
        if (!this.isLoaded()) {
            throw new Exception(StringHelper.format((String)"\u4efb\u52a1\u7cfb\u7edf\u8fd8\u672a\u52a0\u8f7d\u5b8c\u6210\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5!"));
        }
        PSDepSlnSysGlobalModel psDepSlnSysGlobalModel = this.psDepSlnSysGlobalModelMap.get(strPSDepSlnSysId);
        if (psDepSlnSysGlobalModel == null) {
            psDepSlnSysGlobalModel = new PSDepSlnSysGlobalModel();
            psDepSlnSysGlobalModel.init(this);
            this.waitLock(this.lock_psDepSlnSysGlobalModelMap, ThreadLockChecker.getCodeInfo());
            HashMap<String, PSDepSlnSysGlobalModel> hashMap = this.psDepSlnSysGlobalModelMap;
            synchronized (hashMap) {
                this.enterLock(this.lock_psDepSlnSysGlobalModelMap, ThreadLockChecker.getCodeInfo());
                PSDepSlnSysGlobalModel psDepSlnSysGlobalModel2 = this.psDepSlnSysGlobalModelMap.get(strPSDepSlnSysId);
                if (psDepSlnSysGlobalModel2 == null) {
                    this.psDepSlnSysGlobalModelMap.put(strPSDepSlnSysId, psDepSlnSysGlobalModel);
                } else {
                    psDepSlnSysGlobalModel = psDepSlnSysGlobalModel2;
                }
                this.leaveLock(this.lock_psDepSlnSysGlobalModelMap, ThreadLockChecker.getCodeInfo());
            }
        }
        boolean bExists = psDepSlnSysGlobalModel.containsModel(strPSDepSlnSysId);
        IPSDepSlnSys iPSDepSlnSys = (IPSDepSlnSys)psDepSlnSysGlobalModel.findModelHelper(strPSDepSlnSysId);
        if (!bExists) {
            // empty if block
        }
        return iPSDepSlnSys;
    }

    @Override
    public IPSEditorType getPSEditorType(String strPSEditorTypeId) throws Exception {
        return (IPSEditorType)this.psEditorTypeGlobalModel.findModelHelper(strPSEditorTypeId);
    }

    @Override
    public IPSDEFDLogic createPSDEFDLogic(IPSDEFormDetail iPSDEFormDetail, IPSDEFDLogic parentPSDEFDLogic, PSDEFDLogic psDEFDLogic) throws Exception {
        IPSFDLogicType iPSFDLogicType = this.getPSFDLogicType(psDEFDLogic.getLOGICTYPE());
        IPSDEFDLogic iPSDEFDLogic = iPSFDLogicType.createPSDEFDLogic(psDEFDLogic);
        ((IPSDEFDLogicRuntime)iPSDEFDLogic).init(this, iPSDEFormDetail, parentPSDEFDLogic, psDEFDLogic);
        return iPSDEFDLogic;
    }

    @Override
    public IPSDEFormDetail createPSDEFormDetail(IPSDEForm iPSDEForm, IPSDEFormDetail parentPSDEFormDetail, PSDEFormDetail psDEFormDetail) throws Exception {
        IPSFormDetailType iPSFormDetailType = this.getPSFormDetailType(psDEFormDetail.getDETAILTYPE());
        IPSDEFormDetail iPSDEFormDetail = iPSFormDetailType.createPSDEFormDetail(psDEFormDetail);
        ((IPSDEFormDetailRuntime)iPSDEFormDetail).init(this, iPSDEForm, parentPSDEFormDetail, psDEFormDetail);
        return iPSDEFormDetail;
    }

    @Override
    public IPSDEGridColumn createPSDEGridColumn(IPSDEGrid iPSDEGrid, IPSDEGridColumn parentPSDEGridColumn, PSDEGridColumn psDEGridColumn) throws Exception {
        IPSDEGridColumnType iPSDEGridColumnType = this.getPSDEGridColumnType(psDEGridColumn.getGRIDCOLTYPE());
        IPSDEGridColumn iPSDEGridColumn = iPSDEGridColumnType.createPSDEGridColumn(psDEGridColumn);
        ((IPSDEGridColumnRuntime)iPSDEGridColumn).init(this, iPSDEGrid, parentPSDEGridColumn, psDEGridColumn);
        return iPSDEGridColumn;
    }

    @Override
    public IPSDEToolbarItem createPSDEToolbarItem(IPSDEToolbar iPSDEToolbar, IPSDEToolbarItem parentPSDEToolbarItem, PSDEToolbarItem psDEToolbarItem) throws Exception {
        IPSToolbarItemType iPSToolbarItemType = this.getPSToolbarItemType(psDEToolbarItem.getTBITEMTYPE());
        IPSDEToolbarItem iPSDEToolbarItem = iPSToolbarItemType.createPSDEToolbarItem(psDEToolbarItem);
        ((IPSDEToolbarItemRuntime)iPSDEToolbarItem).init(this, iPSDEToolbar, parentPSDEToolbarItem, psDEToolbarItem);
        return iPSDEToolbarItem;
    }

    @Override
    public IPSDBValueOP getPSDBValueOP(String strPSDBValueOPId) throws Exception {
        return (IPSDBValueOP)this.psDBValueOPGlobalModel.findModelHelper(strPSDBValueOPId);
    }

    @Override
    public IPSPortletType getPSPortletType(String strPSPortletTypeId) throws Exception {
        return (IPSPortletType)this.psPortletTypeGlobalModel.findModelHelper(strPSPortletTypeId);
    }

    @Override
    public IPSDEActionType getPSDEActionType(String strPSDEActionTypeId) throws Exception {
        return (IPSDEActionType)this.psDEActionTypeGlobalModel.findModelHelper(strPSDEActionTypeId);
    }

    @Override
    public IPSDELogicNodeType getPSDELogicNodeType(String strPSDELogicNodeTypeId) throws Exception {
        return (IPSDELogicNodeType)this.psDELogicNodeTypeGlobalModel.findModelHelper(strPSDELogicNodeTypeId);
    }

    @Override
    public IPSDELogicLinkCondType getPSDELogicLinkCondType(String strPSDELogicLinkCondTypeId) throws Exception {
        return (IPSDELogicLinkCondType)this.psDELogicLinkCondTypeGlobalModel.findModelHelper(strPSDELogicLinkCondTypeId);
    }

    @Override
    public IPSDRItemType getPSDRItemType(String strPSDRItemTypeId) throws Exception {
        return (IPSDRItemType)this.psDRItemTypeGlobalModel.findModelHelper(strPSDRItemTypeId);
    }

    @Override
    public IPSDEFieldType getPSDEFieldType(String strPSDEFieldTypeId) throws Exception {
        return (IPSDEFieldType)this.psDEFieldTypeGlobalModel.findModelHelper(strPSDEFieldTypeId);
    }

    @Override
    public IPSDEFieldType getPSDEFieldTypeByTag(String strDEFieldTag) throws Exception {
        return this.psDEFieldTypeGlobalModel.getPSDEFieldTypeByTag(strDEFieldTag);
    }

    @Override
    public IPSDEFValueRuleType getPSDEFValueRuleType(String strPSDEFValueRuleTypeId) throws Exception {
        return (IPSDEFValueRuleType)this.psDEFValueRuleTypeGlobalModel.findModelHelper(strPSDEFValueRuleTypeId);
    }

    @Override
    public IPSDERType getPSDERType(String strPSDERTypeId) throws Exception {
        return (IPSDERType)this.psDERTypeGlobalModel.findModelHelper(strPSDERTypeId);
    }

    @Override
    public IPSViewType getPSViewType(String strPSViewTypeId) throws Exception {
        return (IPSViewType)this.psViewTypeGlobalModel.findModelHelper(strPSViewTypeId);
    }

    @Override
    public IPSWFLinkType getPSWFLinkType(String strPSWFLinkTypeId) throws Exception {
        return (IPSWFLinkType)this.psWFLinkTypeGlobalModel.findModelHelper(strPSWFLinkTypeId);
    }

    @Override
    public IPSWFLinkCondType getPSWFLinkCondType(String strPSWFLinkCondTypeId) throws Exception {
        return (IPSWFLinkCondType)this.psWFLinkCondTypeGlobalModel.findModelHelper(strPSWFLinkCondTypeId);
    }

    @Override
    public IPSWFProcessType getPSWFProcessType(String strPSWFProcessTypeId) throws Exception {
        return (IPSWFProcessType)this.psWFProcessTypeGlobalModel.findModelHelper(strPSWFProcessTypeId);
    }

    @Override
    public IPSCounterType getPSCounterType(String strPSCounterTypeId) throws Exception {
        return (IPSCounterType)this.psCounterTypeGlobalModel.findModelHelper(strPSCounterTypeId);
    }

    @Override
    public IPSCounter getPSCounter(String strPSCounterId) throws Exception {
        return (IPSCounter)this.psCounterGlobalModel.findModelHelper(strPSCounterId);
    }

    @Override
    public IPSControlType getPSControlType(String strPSControlType) throws Exception {
        return (IPSControlType)this.psControlTypeGlobalModel.findModelHelper(strPSControlType);
    }

    @Override
    public IPSAppMenuItemType getPSAppMenuItemType(String strPSAppMenuItemTypeId) throws Exception {
        return (IPSAppMenuItemType)this.psAppMenuItemTypeGlobalModel.findModelHelper(strPSAppMenuItemTypeId);
    }

    @Override
    public IPSToolbarItemType getPSToolbarItemType(String strPSToolbarItemTypeId) throws Exception {
        return (IPSToolbarItemType)this.psToolbarItemTypeGlobalModel.findModelHelper(strPSToolbarItemTypeId);
    }

    @Override
    public IPSFormDetailType getPSFormDetailType(String strPSFormDetailTypeId) throws Exception {
        return (IPSFormDetailType)this.psFormDetailTypeGlobalModel.findModelHelper(strPSFormDetailTypeId);
    }

    @Override
    public IPSFDLogicType getPSFDLogicType(String strPSFDLogicTypeId) throws Exception {
        return (IPSFDLogicType)this.psFDLogicTypeGlobalModel.findModelHelper(strPSFDLogicTypeId);
    }

    @Override
    public IPSDEGridColumnType getPSDEGridColumnType(String strPSDEGridColumnTypeId) throws Exception {
        return (IPSDEGridColumnType)this.psDEGridColumnTypeGlobalModel.findModelHelper(strPSDEGridColumnTypeId);
    }

    @Override
    public IPSPF getPSPF(String strPSPFId) throws Exception {
        return (IPSPF)this.psPFGlobalModel.findModelHelper(strPSPFId);
    }

    @Override
    public IPSPFPluginTempl getPSPFPluginTempl(String strPSPFPluginTemplId) throws Exception {
        return (IPSPFPluginTempl)this.psPFPluginTemplGlobalModel.findModelHelper(strPSPFPluginTemplId);
    }

    @Override
    public IPSPFPluginTempl getPSPFPluginTempl(String strPSPFPluginTemplId, boolean bTryMode) throws Exception {
        return (IPSPFPluginTempl)this.psPFPluginTemplGlobalModel.findModelHelper(strPSPFPluginTemplId, bTryMode);
    }

    public boolean isLoaded() {
        return this.bLoaded;
    }

    public IPSSystem getPSSystem() throws Exception {
        return this.getPSDepSlnSys(this.getDepSlnSysId()).getPSSystem();
    }

    public IPSSystem getPSSystem(boolean bCache) throws Exception {
        return this.getPSDepSlnSys(this.getDepSlnSysId()).getPSSystem(bCache);
    }

    @Override
    public Object createObject(String strObjectType) throws Exception {
        for (String strKey : objList) {
            String strValue = objectMap.get(strKey);
            if (StringHelper.isNullOrEmpty((String)strValue)) continue;
            strObjectType = strObjectType.replace(strKey, strValue);
        }
        return ObjectHelper.create((String)strObjectType);
    }

    protected final void waitLock(String objLock, String strLockInfo) {
        ThreadLockChecker.getInstance().wait(objLock, strLockInfo);
    }

    protected final void enterLock(String objLock, String strLockInfo) {
        ThreadLockChecker.getInstance().enter(objLock, strLockInfo);
    }

    protected final void leaveLock(String objLock, String strLockInfo) {
        ThreadLockChecker.getInstance().leave(objLock, strLockInfo);
    }

    protected final void enterAndLeaveLock(String objLock, String strLockInfo) {
        ThreadLockChecker.getInstance().enterAndLeave(objLock, strLockInfo);
    }
}

