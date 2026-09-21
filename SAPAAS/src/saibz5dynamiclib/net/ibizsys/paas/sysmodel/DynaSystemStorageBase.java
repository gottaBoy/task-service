/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.controller.ViewControllerGlobal
 *  net.ibizsys.paas.core.ModelBaseImpl
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.IDynaSystemSetting
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebConfig
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaCodeList
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaView
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer
 *  net.ibizsys.psrt.srv.dynasys.service.DSDynaCodeListService
 *  net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService
 *  net.ibizsys.psrt.srv.dynasys.service.DSDynaViewService
 *  net.ibizsys.psrt.srv.dynasys.service.DSDynaWFService
 *  net.ibizsys.psrt.srv.dynasys.service.DSDynaWFVerService
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.WFModelGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.controller.ViewControllerGlobal;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.IDynaCodeListModel;
import net.ibizsys.paas.sysmodel.IDynaCodeListModelContainer;
import net.ibizsys.paas.sysmodel.IDynaSystemSetting;
import net.ibizsys.paas.sysmodel.IDynaSystemStorage;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaCodeList;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaView;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaCodeListService;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaViewService;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaWFService;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaWFVerService;
import net.ibizsys.pswf.core.IDynaWFModel;
import net.ibizsys.pswf.core.IDynaWFVersionModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.WFModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class DynaSystemStorageBase
extends ModelBaseImpl
implements IDynaSystemStorage {
    private static Log log = LogFactory.getLog(DynaSystemStorageBase.class);
    private IDynaSystemSetting iDynaSystemSetting = null;

    @Override
    public void init(IDynaSystemSetting iDynaSystemSetting) throws Exception {
        this.iDynaSystemSetting = iDynaSystemSetting;
        this.onInit();
    }

    @Override
    public IDynaSystemSetting getDynaSystemSetting() {
        return this.iDynaSystemSetting;
    }

    @Override
    public void syncAll() throws Exception {
        this.syncAllCodeLists();
        this.syncAllViews();
        this.syncAllWorkflows();
    }

    @Override
    public void installAll() throws Exception {
        this.installAllCodeLists();
        this.installAllWorkflows();
    }

    @Override
    public void syncAllViews() throws Exception {
        ArrayList<DSDynaViewInst> dynaViewInstList = this.listDynaViewInsts();
        DSDynaViewInstService dsDynaViewInstService = (DSDynaViewInstService)ServiceGlobal.getService((String)DSDynaViewInstService.class.getName(), (SessionFactory)this.getDynaSystemSetting().getSessionFactory());
        DSDynaViewService dsDynaViewService = (DSDynaViewService)ServiceGlobal.getService((String)DSDynaViewService.class.getName(), (SessionFactory)this.getDynaSystemSetting().getSessionFactory());
        String strDynaSysInstId = WebConfig.getCurrent().getDynaSysInstId();
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DYNASYSINSTID", (Object)strDynaSysInstId);
        dsDynaViewInstService.remove((ISelectCond)selectCond, false);
        selectCond = new SelectCond();
        dsDynaViewService.remove((ISelectCond)new SelectCond(), false);
        for (DSDynaViewInst dsDynaViewInst : dynaViewInstList) {
            String strDSDynaViewId = DataObject.getStringValue((Object)dsDynaViewInst.getDSDynaViewId(), (String)"");
            String strDSDynaViewInstId = DataObject.getStringValue((Object)dsDynaViewInst.getDSDynaViewInstId(), (String)"");
            int nInstVer = DataObject.getIntegerValue((Object)dsDynaViewInst.get("instver"), (Integer)1);
            DSDynaView dsDynaView = new DSDynaView();
            dsDynaView.setDSDynaViewId(strDSDynaViewId);
            try {
                if (dsDynaViewService.checkKey((IEntity)dsDynaView) == 0) {
                    dsDynaView = this.getDynaView(strDSDynaViewId);
                    dsDynaViewService.create((IEntity)dsDynaView, false);
                } else {
                    dsDynaView = this.getDynaView(strDSDynaViewId);
                    dsDynaViewService.update((IEntity)dsDynaView, false);
                }
            }
            catch (Exception e) {
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u52a8\u6001\u89c6\u56fe\u53d1\u751f\u5f02\u5e38,%1$s", (Object)e.getMessage()), e);
            }
            dsDynaViewInst.setDSDynaViewInstId(strDSDynaViewInstId);
            dsDynaViewInstService.get((IEntity)dsDynaViewInst, true);
            dsDynaViewInst = this.getDynaViewInst(strDSDynaViewInstId);
            dsDynaViewInstService.save((IEntity)dsDynaViewInst, false);
        }
        ViewControllerGlobal.resetAllDynaViewControllerInsts();
    }

    protected abstract ArrayList<DSDynaViewInst> listDynaViewInsts() throws Exception;

    protected abstract DSDynaView getDynaView(String var1) throws Exception;

    protected abstract DSDynaViewInst getDynaViewInst(String var1) throws Exception;

    @Override
    public void syncAllWorkflows() throws Exception {
        ArrayList<DSDynaWFVer> dsDynaWFVerList = new ArrayList<DSDynaWFVer>();
        ArrayList<DSDynaWFVer> dynaWFVerList = this.listDynaWFVers();
        DSDynaWFVerService dsDynaWFVerService = (DSDynaWFVerService)ServiceGlobal.getService((String)DSDynaWFVerService.class.getName(), (SessionFactory)this.getDynaSystemSetting().getSessionFactory());
        DSDynaWFService dsDynaWFService = (DSDynaWFService)ServiceGlobal.getService((String)DSDynaWFService.class.getName(), (SessionFactory)this.getDynaSystemSetting().getSessionFactory());
        for (DSDynaWFVer dsDynaWFVer : dynaWFVerList) {
            String strDSDynaWFId = DataObject.getStringValue((Object)dsDynaWFVer.getDSDynaWFId(), (String)"");
            String strDSDynaWFVerId = DataObject.getStringValue((Object)dsDynaWFVer.getDSDynaWFVerId(), (String)"");
            int nWFVer = DataObject.getIntegerValue((Object)dsDynaWFVer.get("wfversion"), (Integer)1);
            DSDynaWF dsDynaWF = new DSDynaWF();
            dsDynaWF.setDSDynaWFId(strDSDynaWFId);
            if (dsDynaWFService.checkKey((IEntity)dsDynaWF) == 0) {
                dsDynaWF = this.getDynaWF(strDSDynaWFId);
                dsDynaWFService.create((IEntity)dsDynaWF, false);
            }
            dsDynaWFVer.setDSDynaWFVerId(strDSDynaWFVerId);
            dsDynaWFVerService.get((IEntity)dsDynaWFVer, true);
            dsDynaWFVer = this.getDynaWFVer(strDSDynaWFVerId);
            dsDynaWFVerService.save((IEntity)dsDynaWFVer, false);
            dsDynaWFVerList.add(dsDynaWFVer);
        }
        HashMap<String, IDynaWFModel> dynaWFModelMap = new HashMap<String, IDynaWFModel>();
        for (DSDynaWFVer dsDynaWFVer : dsDynaWFVerList) {
            IDynaWFModel iDynaWFModel = (IDynaWFModel)dynaWFModelMap.get(dsDynaWFVer.getDSDynaWF().getWFWorkflowId());
            if (iDynaWFModel == null) {
                IWFModel iWFModel = WFModelGlobal.getWFModel((String)dsDynaWFVer.getDSDynaWF().getWFWorkflowId(), (boolean)true);
                if (iWFModel == null) continue;
                if (!(iWFModel instanceof IDynaWFModel)) {
                    throw new Exception(StringHelper.format((String)"\u5de5\u4f5c\u6d41\u6a21\u578b[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)iWFModel.getId()));
                }
                iDynaWFModel = (IDynaWFModel)iWFModel;
                iDynaWFModel.resetCurrentDynaSysInst();
                dynaWFModelMap.put(dsDynaWFVer.getDSDynaWF().getWFWorkflowId(), iDynaWFModel);
            }
            IDynaWFVersionModel defaultDynaWFVersionModel = iDynaWFModel.createDynaWFVersionModel((IEntity)dsDynaWFVer);
            defaultDynaWFVersionModel.init(iDynaWFModel, (IEntity)dsDynaWFVer);
            iDynaWFModel.registerDynaWFVersionModel(defaultDynaWFVersionModel);
        }
    }

    @Override
    public void installAllWorkflows() throws Exception {
        DSDynaWFVerService dsDynaWFVerService = (DSDynaWFVerService)ServiceGlobal.getService((String)DSDynaWFVerService.class.getName(), (SessionFactory)this.getDynaSystemSetting().getSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DYNASYSINSTID", (Object)WebConfig.getCurrent().getDynaSysInstId());
        ArrayList dsDynaWFVerList = dsDynaWFVerService.select((ISelectCond)selectCond);
        HashMap<String, IDynaWFModel> dynaWFModelMap = new HashMap<String, IDynaWFModel>();
        for (DSDynaWFVer dsDynaWFVer : dsDynaWFVerList) {
            IDynaWFModel iDynaWFModel = (IDynaWFModel)dynaWFModelMap.get(dsDynaWFVer.getDSDynaWF().getWFWorkflowId());
            if (iDynaWFModel == null) {
                IWFModel iWFModel = WFModelGlobal.getWFModel((String)dsDynaWFVer.getDSDynaWF().getWFWorkflowId(), (boolean)true);
                if (iWFModel == null) {
                    log.warn((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6d41\u7a0b\u6a21\u578b[%1$s]", (Object)dsDynaWFVer.getDSDynaWF().getWFWorkflowId()));
                    continue;
                }
                if (!(iWFModel instanceof IDynaWFModel)) {
                    throw new Exception(StringHelper.format((String)"\u5de5\u4f5c\u6d41\u6a21\u578b[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)iWFModel.getId()));
                }
                iDynaWFModel = (IDynaWFModel)iWFModel;
                iDynaWFModel.resetAllDynaSysInst();
                dynaWFModelMap.put(dsDynaWFVer.getDSDynaWF().getWFWorkflowId(), iDynaWFModel);
            }
            try {
                IDynaWFVersionModel defaultDynaWFVersionModel = iDynaWFModel.createDynaWFVersionModel((IEntity)dsDynaWFVer);
                defaultDynaWFVersionModel.init(iDynaWFModel, (IEntity)dsDynaWFVer);
                iDynaWFModel.registerDynaWFVersionModel(defaultDynaWFVersionModel);
            }
            catch (Exception e) {
                log.warn((Object)StringHelper.format((String)"\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]\u5b89\u88c5\u5931\u8d25,\u9519\u8bef\u4fe1\u606f:%2$s", (Object)dsDynaWFVer.getDSDynaWFVerName(), (Object)e.getMessage()));
            }
        }
    }

    @Override
    public void syncView(String strViewId) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void syncCodeList(String strCodeListId) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void syncWorkflow(String strWorkflowId) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void syncAllCodeLists() throws Exception {
        ArrayList<DSDynaCodeList> dsDynaCodeListList = new ArrayList<DSDynaCodeList>();
        ArrayList<DSDynaCodeList> dynaCodeListList = this.listDynaCodeLists();
        DSDynaCodeListService dsDynaCodeListService = (DSDynaCodeListService)ServiceGlobal.getService((String)DSDynaCodeListService.class.getName(), (SessionFactory)this.getDynaSystemSetting().getSessionFactory());
        for (DSDynaCodeList dsDynaCodeList : dynaCodeListList) {
            String strCodeListId = DataObject.getStringValue((Object)dsDynaCodeList.getCodeListId(), (String)"");
            String strDSDynaCodeListId = DataObject.getStringValue((Object)dsDynaCodeList.getDSDynaCodeListId(), (String)"");
            int nInstVer = DataObject.getIntegerValue((Object)dsDynaCodeList.get("instver"), (Integer)1);
            dsDynaCodeList.setDSDynaCodeListId(strDSDynaCodeListId);
            dsDynaCodeListService.get((IEntity)dsDynaCodeList, true);
            dsDynaCodeList = this.getDynaCodeList(strDSDynaCodeListId);
            dsDynaCodeListService.save((IEntity)dsDynaCodeList, false);
            dsDynaCodeListList.add(dsDynaCodeList);
        }
        HashMap<String, IDynaCodeListModelContainer> dynaCodeListModelContainerMap = new HashMap<String, IDynaCodeListModelContainer>();
        for (DSDynaCodeList dsDynaCodeList : dsDynaCodeListList) {
            IDynaCodeListModelContainer iDynaCodeListModelContainer = (IDynaCodeListModelContainer)dynaCodeListModelContainerMap.get(dsDynaCodeList.getCodeListId());
            if (iDynaCodeListModelContainer == null) {
                ICodeList iCodeList = CodeListGlobal.getCodeList((String)dsDynaCodeList.getCodeListId(), (boolean)true);
                if (iCodeList == null) continue;
                if (!(iCodeList instanceof IDynaCodeListModelContainer)) {
                    throw new Exception(StringHelper.format((String)"\u4ee3\u7801\u8868\u6a21\u578b[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)iCodeList.getId()));
                }
                iDynaCodeListModelContainer = (IDynaCodeListModelContainer)iCodeList;
                iDynaCodeListModelContainer.resetCurrentDynaSysInst();
                dynaCodeListModelContainerMap.put(dsDynaCodeList.getCodeListId(), iDynaCodeListModelContainer);
            }
            IDynaCodeListModel defaultDynaStaticCodeListModel = iDynaCodeListModelContainer.createDynaCodeListModel((IEntity)dsDynaCodeList);
            defaultDynaStaticCodeListModel.init(iDynaCodeListModelContainer, (IEntity)dsDynaCodeList);
            iDynaCodeListModelContainer.registerDynaCodeListModel(defaultDynaStaticCodeListModel);
        }
    }

    @Override
    public void installAllCodeLists() throws Exception {
        DSDynaCodeListService dsDynaCodeListService = (DSDynaCodeListService)ServiceGlobal.getService((String)DSDynaCodeListService.class.getName(), (SessionFactory)this.getDynaSystemSetting().getSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DYNASYSINSTID", (Object)WebConfig.getCurrent().getDynaSysInstId());
        ArrayList dsDynaCodeListList = dsDynaCodeListService.select((ISelectCond)selectCond);
        HashMap<String, IDynaCodeListModelContainer> dynaCodeListModelContainerMap = new HashMap<String, IDynaCodeListModelContainer>();
        for (DSDynaCodeList dsDynaCodeList : dsDynaCodeListList) {
            IDynaCodeListModelContainer iDynaCodeListModelContainer = (IDynaCodeListModelContainer)dynaCodeListModelContainerMap.get(dsDynaCodeList.getCodeListId());
            if (iDynaCodeListModelContainer == null) {
                ICodeList iCodeList = CodeListGlobal.getCodeList((String)dsDynaCodeList.getCodeListId(), (boolean)true);
                if (iCodeList == null) {
                    log.warn((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]", (Object)dsDynaCodeList.getCodeListId()));
                    continue;
                }
                if (!(iCodeList instanceof IDynaCodeListModelContainer)) {
                    throw new Exception(StringHelper.format((String)"\u4ee3\u7801\u8868\u6a21\u578b[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)iCodeList.getId()));
                }
                iDynaCodeListModelContainer = (IDynaCodeListModelContainer)iCodeList;
                iDynaCodeListModelContainer.resetAllDynaSysInst();
                dynaCodeListModelContainerMap.put(dsDynaCodeList.getCodeListId(), iDynaCodeListModelContainer);
            }
            IDynaCodeListModel defaultDynaStaticCodeListModel = iDynaCodeListModelContainer.createDynaCodeListModel((IEntity)dsDynaCodeList);
            defaultDynaStaticCodeListModel.init(iDynaCodeListModelContainer, (IEntity)dsDynaCodeList);
            iDynaCodeListModelContainer.registerDynaCodeListModel(defaultDynaStaticCodeListModel);
        }
    }

    protected abstract ArrayList<DSDynaWFVer> listDynaWFVers() throws Exception;

    protected abstract DSDynaWF getDynaWF(String var1) throws Exception;

    protected abstract DSDynaWFVer getDynaWFVer(String var1) throws Exception;

    protected abstract ArrayList<DSDynaCodeList> listDynaCodeLists() throws Exception;

    protected abstract DSDynaCodeList getDynaCodeList(String var1) throws Exception;
}

