/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.appdesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.dao.PSAppTitleBarDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSAppTitleBarDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppTitleBar;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroupBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppTitleBarServiceBase
extends PSCoreSysServiceBase<PSAppTitleBar> {
    private static final Log log = LogFactory.getLog(PSAppTitleBarServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSAppTitleBarDEModel pSAppTitleBarDEModel;
    private PSAppTitleBarDAO pSAppTitleBarDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarService";
    }

    public PSAppTitleBarDEModel getPSAppTitleBarDEModel() {
        if (this.pSAppTitleBarDEModel == null) {
            try {
                this.pSAppTitleBarDEModel = (PSAppTitleBarDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSAppTitleBarDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppTitleBarDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSAppTitleBarDEModel();
    }

    public PSAppTitleBarDAO getPSAppTitleBarDAO() {
        if (this.pSAppTitleBarDAO == null) {
            try {
                this.pSAppTitleBarDAO = (PSAppTitleBarDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSAppTitleBarDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAppTitleBarDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSAppTitleBarDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSAppTitleBar pSAppTitleBar, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPTITLEBAR_PSAPPMENU_LEFTPSAPPMENUID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService", (SessionFactory)this.getSessionFactory());
            PSAppMenu pSAppMenu = (PSAppMenu)iService.getDEModel().createEntity();
            pSAppMenu.set("PSAPPMENUID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppMenu);
            } else {
                iService.get(pSAppMenu);
            }
            this.onFillParentInfo_LeftPSAppMenu(pSAppTitleBar, pSAppMenu);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPTITLEBAR_PSAPPMENU_RIGHTPSAPPMENUID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService", (SessionFactory)this.getSessionFactory());
            PSAppMenu pSAppMenu = (PSAppMenu)iService.getDEModel().createEntity();
            pSAppMenu.set("PSAPPMENUID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSAppMenu);
            } else {
                iService.get(pSAppMenu);
            }
            this.onFillParentInfo_RightPSAppMenu(pSAppTitleBar, pSAppMenu);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPTITLEBAR_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlLogicGroup);
            } else {
                iService.get(pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSAppTitleBar, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPTITLEBAR_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSAppTitleBar, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPTITLEBAR_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSAppTitleBar, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPTITLEBAR_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSAppTitleBar, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPTITLEBAR_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysImage);
            } else {
                iService.get(pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSAppTitleBar, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPTITLEBAR_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSAppTitleBar, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSAPPTITLEBAR_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewMsgGroup);
            } else {
                iService.get(pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSAppTitleBar, pSViewMsgGroup);
            return;
        }
        super.onFillParentInfo(pSAppTitleBar, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_LeftPSAppMenu(PSAppTitleBar pSAppTitleBar, PSAppMenu pSAppMenu) throws Exception {
        pSAppTitleBar.setLeftPSAppMenuId(pSAppMenu.getPSAppMenuId());
        pSAppTitleBar.setLeftPSAppMenuName(pSAppMenu.getPSAppMenuName());
    }

    protected void onFillParentInfo_RightPSAppMenu(PSAppTitleBar pSAppTitleBar, PSAppMenu pSAppMenu) throws Exception {
        pSAppTitleBar.setRightPSAppMenuId(pSAppMenu.getPSAppMenuId());
        pSAppTitleBar.setRightPSAppMenuName(pSAppMenu.getPSAppMenuName());
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSAppTitleBar pSAppTitleBar, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSAppTitleBar.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSAppTitleBar.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSAppTitleBar pSAppTitleBar, PSLanguageRes pSLanguageRes) throws Exception {
        pSAppTitleBar.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSAppTitleBar.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysApp(PSAppTitleBar pSAppTitleBar, PSSysApp pSSysApp) throws Exception {
        pSAppTitleBar.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSAppTitleBar.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysCss(PSAppTitleBar pSAppTitleBar, PSSysCss pSSysCss) throws Exception {
        pSAppTitleBar.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSAppTitleBar.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysImage(PSAppTitleBar pSAppTitleBar, PSSysImage pSSysImage) throws Exception {
        pSAppTitleBar.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSAppTitleBar.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSAppTitleBar pSAppTitleBar, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSAppTitleBar.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSAppTitleBar.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSAppTitleBar pSAppTitleBar, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSAppTitleBar.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSAppTitleBar.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillEntityFullInfo(PSAppTitleBar pSAppTitleBar, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSAppTitleBar, bl);
        this.onFillEntityFullInfo_LeftPSAppMenu(pSAppTitleBar, bl);
        this.onFillEntityFullInfo_RightPSAppMenu(pSAppTitleBar, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSAppTitleBar, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSAppTitleBar, bl);
        this.onFillEntityFullInfo_PSSysApp(pSAppTitleBar, bl);
        this.onFillEntityFullInfo_PSSysCss(pSAppTitleBar, bl);
        this.onFillEntityFullInfo_PSSysImage(pSAppTitleBar, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSAppTitleBar, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSAppTitleBar, bl);
    }

    protected void onFillEntityFullInfo_LeftPSAppMenu(PSAppTitleBar pSAppTitleBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RightPSAppMenu(PSAppTitleBar pSAppTitleBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSAppTitleBar pSAppTitleBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSAppTitleBar pSAppTitleBar, boolean bl) throws Exception {
        if (pSAppTitleBar.isCapPSLanResIdDirty()) {
            if (pSAppTitleBar.getCapPSLanResId() != null) {
                if (pSAppTitleBar.getCapPSLanResId() == null || pSAppTitleBar.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSAppTitleBar.getCapPSLanRes();
                    pSAppTitleBar.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSAppTitleBar.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysApp(PSAppTitleBar pSAppTitleBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSAppTitleBar pSAppTitleBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSAppTitleBar pSAppTitleBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSAppTitleBar pSAppTitleBar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSAppTitleBar pSAppTitleBar, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSAppTitleBar pSAppTitleBar, boolean bl) throws Exception {
        super.onWriteBackParent(pSAppTitleBar, bl);
    }

    public ArrayList<PSAppTitleBar> selectByLeftPSAppMenu(PSAppMenuBase pSAppMenuBase) throws Exception {
        return this.selectByLeftPSAppMenu(pSAppMenuBase, "", -1);
    }

    public ArrayList<PSAppTitleBar> selectByLeftPSAppMenu(PSAppMenuBase pSAppMenuBase, String string) throws Exception {
        return this.selectByLeftPSAppMenu(pSAppMenuBase, string, -1);
    }

    public ArrayList<PSAppTitleBar> selectByLeftPSAppMenu(PSAppMenuBase pSAppMenuBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LEFTPSAPPMENUID", (Object)pSAppMenuBase.getPSAppMenuId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLeftPSAppMenuCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLeftPSAppMenuCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppTitleBar> selectByRightPSAppMenu(PSAppMenuBase pSAppMenuBase) throws Exception {
        return this.selectByRightPSAppMenu(pSAppMenuBase, "", -1);
    }

    public ArrayList<PSAppTitleBar> selectByRightPSAppMenu(PSAppMenuBase pSAppMenuBase, String string) throws Exception {
        return this.selectByRightPSAppMenu(pSAppMenuBase, string, -1);
    }

    public ArrayList<PSAppTitleBar> selectByRightPSAppMenu(PSAppMenuBase pSAppMenuBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("RIGHTPSAPPMENUID", (Object)pSAppMenuBase.getPSAppMenuId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRightPSAppMenuCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRightPSAppMenuCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppTitleBar> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSAppTitleBar> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSAppTitleBar> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLLOGICGROUPID", (Object)pSCtrlLogicGroupBase.getPSCtrlLogicGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlLogicGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlLogicGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppTitleBar> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSAppTitleBar> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSAppTitleBar> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CAPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCapPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCapPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppTitleBar> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSAppTitleBar> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSAppTitleBar> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppTitleBar> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSAppTitleBar> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSAppTitleBar> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppTitleBar> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSAppTitleBar> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSAppTitleBar> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSIMAGEID", (Object)pSSysImageBase.getPSSysImageId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysImageCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysImageCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppTitleBar> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSAppTitleBar> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSAppTitleBar> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSAppTitleBar> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSAppTitleBar> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSAppTitleBar> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWMSGGROUPID", (Object)pSViewMsgGroupBase.getPSViewMsgGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewMsgGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewMsgGroupCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByLeftPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByLeftPSAppMenu(pSAppMenu, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPMENU");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppMenu);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPTITLEBAR_PSAPPMENU_LEFTPSAPPMENUID", "", iDataEntityModel.getName(), "PSAPPTITLEBAR", iDataEntityModel.getDataInfo(pSAppMenu), arrayList.get(0)));
        }
    }

    public void resetLeftPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByLeftPSAppMenu(pSAppMenu);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            PSAppTitleBar pSAppTitleBar2 = (PSAppTitleBar)this.getDEModel().createEntity();
            pSAppTitleBar2.setPSAppTitleBarId(pSAppTitleBar.getPSAppTitleBarId());
            pSAppTitleBar2.setLeftPSAppMenuId(null);
            this.update(pSAppTitleBar2);
        }
    }

    public void removeByLeftPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppTitleBarServiceBase.this.onBeforeRemoveByLeftPSAppMenu(pSAppMenu2);
                PSAppTitleBarServiceBase.this.internalRemoveByLeftPSAppMenu(pSAppMenu2);
                PSAppTitleBarServiceBase.this.onAfterRemoveByLeftPSAppMenu(pSAppMenu2);
            }
        });
    }

    protected void onBeforeRemoveByLeftPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void internalRemoveByLeftPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByLeftPSAppMenu(pSAppMenu);
        this.onBeforeRemoveByLeftPSAppMenu(pSAppMenu, arrayList);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            this.remove(pSAppTitleBar);
        }
        this.onAfterRemoveByLeftPSAppMenu(pSAppMenu, arrayList);
    }

    protected void onAfterRemoveByLeftPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void onBeforeRemoveByLeftPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLeftPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    public void testRemoveByRightPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByRightPSAppMenu(pSAppMenu, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPMENU");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSAppMenu);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPTITLEBAR_PSAPPMENU_RIGHTPSAPPMENUID", "", iDataEntityModel.getName(), "PSAPPTITLEBAR", iDataEntityModel.getDataInfo(pSAppMenu), arrayList.get(0)));
        }
    }

    public void resetRightPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByRightPSAppMenu(pSAppMenu);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            PSAppTitleBar pSAppTitleBar2 = (PSAppTitleBar)this.getDEModel().createEntity();
            pSAppTitleBar2.setPSAppTitleBarId(pSAppTitleBar.getPSAppTitleBarId());
            pSAppTitleBar2.setRightPSAppMenuId(null);
            this.update(pSAppTitleBar2);
        }
    }

    public void removeByRightPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppTitleBarServiceBase.this.onBeforeRemoveByRightPSAppMenu(pSAppMenu2);
                PSAppTitleBarServiceBase.this.internalRemoveByRightPSAppMenu(pSAppMenu2);
                PSAppTitleBarServiceBase.this.onAfterRemoveByRightPSAppMenu(pSAppMenu2);
            }
        });
    }

    protected void onBeforeRemoveByRightPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void internalRemoveByRightPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByRightPSAppMenu(pSAppMenu);
        this.onBeforeRemoveByRightPSAppMenu(pSAppMenu, arrayList);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            this.remove(pSAppTitleBar);
        }
        this.onAfterRemoveByRightPSAppMenu(pSAppMenu, arrayList);
    }

    protected void onAfterRemoveByRightPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void onBeforeRemoveByRightPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRightPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPTITLEBAR_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSAPPTITLEBAR", iDataEntityModel.getDataInfo(pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            PSAppTitleBar pSAppTitleBar2 = (PSAppTitleBar)this.getDEModel().createEntity();
            pSAppTitleBar2.setPSAppTitleBarId(pSAppTitleBar.getPSAppTitleBarId());
            pSAppTitleBar2.setPSCtrlLogicGroupId(null);
            this.update(pSAppTitleBar2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppTitleBarServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSAppTitleBarServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSAppTitleBarServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            this.remove(pSAppTitleBar);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPTITLEBAR_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSAPPTITLEBAR", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            PSAppTitleBar pSAppTitleBar2 = (PSAppTitleBar)this.getDEModel().createEntity();
            pSAppTitleBar2.setPSAppTitleBarId(pSAppTitleBar.getPSAppTitleBarId());
            pSAppTitleBar2.setCapPSLanResId(null);
            this.update(pSAppTitleBar2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppTitleBarServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSAppTitleBarServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSAppTitleBarServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            this.remove(pSAppTitleBar);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            PSAppTitleBar pSAppTitleBar2 = (PSAppTitleBar)this.getDEModel().createEntity();
            pSAppTitleBar2.setPSAppTitleBarId(pSAppTitleBar.getPSAppTitleBarId());
            pSAppTitleBar2.setPSSysAppId(null);
            this.update(pSAppTitleBar2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppTitleBarServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSAppTitleBarServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSAppTitleBarServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            this.remove(pSAppTitleBar);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPTITLEBAR_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSAPPTITLEBAR", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            PSAppTitleBar pSAppTitleBar2 = (PSAppTitleBar)this.getDEModel().createEntity();
            pSAppTitleBar2.setPSAppTitleBarId(pSAppTitleBar.getPSAppTitleBarId());
            pSAppTitleBar2.setPSSysCssId(null);
            this.update(pSAppTitleBar2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppTitleBarServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSAppTitleBarServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSAppTitleBarServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            this.remove(pSAppTitleBar);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPTITLEBAR_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSAPPTITLEBAR", iDataEntityModel.getDataInfo(pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            PSAppTitleBar pSAppTitleBar2 = (PSAppTitleBar)this.getDEModel().createEntity();
            pSAppTitleBar2.setPSAppTitleBarId(pSAppTitleBar.getPSAppTitleBarId());
            pSAppTitleBar2.setPSSysImageId(null);
            this.update(pSAppTitleBar2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppTitleBarServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSAppTitleBarServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSAppTitleBarServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            this.remove(pSAppTitleBar);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPTITLEBAR_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSAPPTITLEBAR", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            PSAppTitleBar pSAppTitleBar2 = (PSAppTitleBar)this.getDEModel().createEntity();
            pSAppTitleBar2.setPSAppTitleBarId(pSAppTitleBar.getPSAppTitleBarId());
            pSAppTitleBar2.setPSSysPFPluginId(null);
            this.update(pSAppTitleBar2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppTitleBarServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSAppTitleBarServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSAppTitleBarServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            this.remove(pSAppTitleBar);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSAPPTITLEBAR_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSAPPTITLEBAR", iDataEntityModel.getDataInfo(pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            PSAppTitleBar pSAppTitleBar2 = (PSAppTitleBar)this.getDEModel().createEntity();
            pSAppTitleBar2.setPSAppTitleBarId(pSAppTitleBar.getPSAppTitleBarId());
            pSAppTitleBar2.setPSViewMsgGroupId(null);
            this.update(pSAppTitleBar2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppTitleBarServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSAppTitleBarServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSAppTitleBarServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSAppTitleBar> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSAppTitleBar pSAppTitleBar : arrayList) {
            this.remove(pSAppTitleBar);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSAppTitleBar> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSAppTitleBar pSAppTitleBar) throws Exception {
        PSAppViewService pSAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        pSAppViewService.testRemoveByPSAppTitleBar(pSAppTitleBar);
        super.onBeforeRemove(pSAppTitleBar);
    }

    protected void replaceParentInfo(PSAppTitleBar pSAppTitleBar, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSAppTitleBar, cloneSession);
        if (pSAppTitleBar.getLeftPSAppMenuId() != null && (iEntity = cloneSession.getEntity("PSAPPMENU", (Object)pSAppTitleBar.getLeftPSAppMenuId())) != null) {
            this.onFillParentInfo_LeftPSAppMenu(pSAppTitleBar, (PSAppMenu)iEntity);
        }
        if (pSAppTitleBar.getRightPSAppMenuId() != null && (iEntity = cloneSession.getEntity("PSAPPMENU", (Object)pSAppTitleBar.getRightPSAppMenuId())) != null) {
            this.onFillParentInfo_RightPSAppMenu(pSAppTitleBar, (PSAppMenu)iEntity);
        }
        if (pSAppTitleBar.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSAppTitleBar.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSAppTitleBar, (PSCtrlLogicGroup)iEntity);
        }
        if (pSAppTitleBar.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSAppTitleBar.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSAppTitleBar, (PSLanguageRes)iEntity);
        }
        if (pSAppTitleBar.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSAppTitleBar.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSAppTitleBar, (PSSysApp)iEntity);
        }
        if (pSAppTitleBar.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSAppTitleBar.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSAppTitleBar, (PSSysCss)iEntity);
        }
        if (pSAppTitleBar.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSAppTitleBar.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSAppTitleBar, (PSSysImage)iEntity);
        }
        if (pSAppTitleBar.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSAppTitleBar.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSAppTitleBar, (PSSysPFPlugin)iEntity);
        }
        if (pSAppTitleBar.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSAppTitleBar.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSAppTitleBar, (PSViewMsgGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSAppTitleBar pSAppTitleBar, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSAppTitleBar, bl);
    }

    protected void onCheckEntity(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CapPSLanResId(bl, pSAppTitleBar, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LeftPSAppMenuId(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppTitleBarId(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppTitleBarName(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RightPSAppMenuId(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitleBarStyle(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSAppTitleBar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSAppTitleBar, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isCapPSLanResIdDirty() : !pSAppTitleBar.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isCapPSLanResNameDirty() : !pSAppTitleBar.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Caption(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isCaptionDirty() : !pSAppTitleBar.isCaptionDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isCodeNameDirty() : !pSAppTitleBar.isCodeNameDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSAPPID";
                String string4 = this.checkFieldDupRule(this.getPSAppTitleBarDEModel(), "CODENAME", string3, pSAppTitleBar, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LeftPSAppMenuId(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isLeftPSAppMenuIdDirty() : !pSAppTitleBar.isLeftPSAppMenuIdDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getLeftPSAppMenuId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LeftPSAppMenuId_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEFTPSAPPMENUID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isMemoDirty() : !pSAppTitleBar.isMemoDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppTitleBarId(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isPSAppTitleBarIdDirty() && !bl2 : !pSAppTitleBar.isPSAppTitleBarIdDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getPSAppTitleBarId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTITLEBARID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppTitleBarId_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTITLEBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSAppTitleBarName(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isPSAppTitleBarNameDirty() && !bl2 : !pSAppTitleBar.isPSAppTitleBarNameDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getPSAppTitleBarName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTITLEBARNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppTitleBarName_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPTITLEBARNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isPSCtrlLogicGroupIdDirty() : !pSAppTitleBar.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLLOGICGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isPSSysAppIdDirty() && !bl2 : !pSAppTitleBar.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getPSSysAppId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isPSSysCssIdDirty() : !pSAppTitleBar.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isPSSysImageIdDirty() : !pSAppTitleBar.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSIMAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isPSSysPFPluginIdDirty() : !pSAppTitleBar.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isPSViewMsgGroupIdDirty() : !pSAppTitleBar.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RightPSAppMenuId(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isRightPSAppMenuIdDirty() : !pSAppTitleBar.isRightPSAppMenuIdDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getRightPSAppMenuId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RightPSAppMenuId_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RIGHTPSAPPMENUID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TitleBarStyle(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isTitleBarStyleDirty() : !pSAppTitleBar.isTitleBarStyleDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getTitleBarStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TitleBarStyle_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEBARSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isUserTagDirty() : !pSAppTitleBar.isUserTagDirty()) {
            return null;
        }
        String string = pSAppTitleBar.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSAppTitleBar pSAppTitleBar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSAppTitleBar.isUserTag2Dirty() : !pSAppTitleBar.isUserTag2Dirty()) {
            return null;
        }
        String string = pSAppTitleBar.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSAppTitleBar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSAppTitleBar pSAppTitleBar, boolean bl) throws Exception {
        super.onSyncEntity(pSAppTitleBar, bl);
    }

    protected void onSyncIndexEntities(PSAppTitleBar pSAppTitleBar, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSAppTitleBar, bl);
    }

    public Object getDataContextValue(PSAppTitleBar pSAppTitleBar, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSAppTitleBar, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysApp pSSysApp = pSAppTitleBar.getPSSysApp();
        if (pSSysApp != null && pSSysApp.contains(string)) {
            return pSSysApp.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSAppTitleBar pSAppTitleBar, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSAppTitleBar, arrayList, n);
        super.onExportMajorModel(pSAppTitleBar, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSAppTitleBar pSAppTitleBar, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSAppTitleBar.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSAppTitleBar.getCapPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Caption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEFTPSAPPMENUID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LeftPSAppMenuId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEFTPSAPPMENUNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LeftPSAppMenuName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTITLEBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTitleBarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPTITLEBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppTitleBarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RIGHTPSAPPMENUID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RightPSAppMenuId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RIGHTPSAPPMENUNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RightPSAppMenuName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEBARSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitleBarStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CapPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CapPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Caption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LeftPSAppMenuId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LEFTPSAPPMENUID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LeftPSAppMenuName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LEFTPSAPPMENUNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppTitleBarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPTITLEBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppTitleBarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPTITLEBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlLogicGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLLOGICGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlLogicGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLLOGICGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RightPSAppMenuId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RIGHTPSAPPMENUID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RightPSAppMenuName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RIGHTPSAPPMENUNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TitleBarStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TITLEBARSTYLE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSAppTitleBar pSAppTitleBar) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSAppTitleBar)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSAppTitleBar pSAppTitleBar) throws Exception {
        Object object = pSAppTitleBar.get("PSSYSAPPID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSAPPTITLEBAR_PSSYSAPP_PSSYSAPPID", object);
        }
        super.onUpdateParent(pSAppTitleBar);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSAppTitleBar pSAppTitleBar, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSAPPTITLEBAR");
        if (!bl) {
            pSAppTitleBar.setCreateDate(null);
            pSAppTitleBar.setCreateMan(null);
            pSAppTitleBar.setPSAppTitleBarId(null);
            pSAppTitleBar.setUpdateDate(null);
            pSAppTitleBar.setUpdateMan(null);
            super.exportCurXmlModel(pSAppTitleBar, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSAppTitleBar pSAppTitleBar, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSAppTitleBar, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSAPP#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSAPPTITLEBAR_PSSYSAPP_PSSYSAPPID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSAPPNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSAPP", (boolean)true) == 0) {
            iEntity.set("PSSYSAPPID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSAPPID"};
    }

    @Override
    public String getModelV2Tag(PSAppTitleBar pSAppTitleBar) {
        if (!StringHelper.isNullOrEmpty((String)pSAppTitleBar.getCodeName())) {
            return pSAppTitleBar.getCodeName();
        }
        return super.getModelV2Tag(pSAppTitleBar);
    }

    @Override
    public boolean setModelV2Tag(PSAppTitleBar pSAppTitleBar, String string) {
        pSAppTitleBar.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSSYSAPPID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSAppTitleBar pSAppTitleBar, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSAppTitleBar.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSAppTitleBar, true);
        pSAppTitleBar.set("CODENAME", string);
        if (this.select(pSAppTitleBar, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSAppTitleBar, true);
        return super.getModelV2Entity(pSAppTitleBar, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSAppTitleBar pSAppTitleBar, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSAppTitleBar, objectNode, string, string2, n);
    }
}

