/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPanelView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPanelViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortalViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilViewService;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSVTCtrl;
import net.ibizsys.pscore.srv.config.entity.PSVTRV;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeStruct;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewRV;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewRVService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWAppView;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUWAppViewServiceBase;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSUWAppViewService
extends PSUWAppViewServiceBase {
    private static final Log log = LogFactory.getLog(PSUWAppViewService.class);

    @Override
    protected void onChangeSearchForm(PSUWAppView pSUWAppView) throws Exception {
        String string = this.getWebContext().getPostValue("srfactionparam");
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        JSONObject jSONObject = JSONObject.fromString((String)string);
        String string2 = jSONObject.optString("srforikey");
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = jSONObject.optString("srfkey");
        }
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            pSUWAppView.setPSDESearchFormId(string2);
            pSUWAppView.setPSDESearchFormName(jSONObject.optString("psdeformname"));
        }
    }

    @Override
    protected void onChangeEditForm(PSUWAppView pSUWAppView) throws Exception {
        String string = this.getWebContext().getPostValue("srfactionparam");
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        JSONObject jSONObject = JSONObject.fromString((String)string);
        String string2 = jSONObject.optString("srforikey");
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = jSONObject.optString("srfkey");
        }
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            pSUWAppView.setPSDEFormId(string2);
            pSUWAppView.setPSDEFormName(jSONObject.optString("psdeformname"));
        }
    }

    @Override
    protected void onChangeToolbar(PSUWAppView pSUWAppView) throws Exception {
        String string = this.getWebContext().getPostValue("srfactionparam");
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        JSONObject jSONObject = JSONObject.fromString((String)string);
        String string2 = jSONObject.optString("srforikey");
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = jSONObject.optString("srfkey");
        }
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            pSUWAppView.setPSDEToolbarId(string2);
            pSUWAppView.setPSDEToolbarName(jSONObject.optString("psdetoolbarname"));
        }
    }

    @Override
    protected void onChangeGrid(PSUWAppView pSUWAppView) throws Exception {
        String string = this.getWebContext().getPostValue("srfactionparam");
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        JSONObject jSONObject = JSONObject.fromString((String)string);
        String string2 = jSONObject.optString("srforikey");
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = jSONObject.optString("srfkey");
        }
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            pSUWAppView.setPSDEGridId(string2);
            pSUWAppView.setPSDEGridName(jSONObject.optString("psdegridname"));
        }
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected void onUpdateViewType(PSUWAppView var1_1) throws Exception {
        block10: {
            block12: {
                block14: {
                    block13: {
                        block11: {
                            block9: {
                                if (StringHelper.isNullOrEmpty((String)var1_1.getPSAppViewType())) {
                                    return;
                                }
                                if (var1_1.getPSAppViewType().indexOf("DE") != 0) break block9;
                                var1_1.setPSDEViewBaseType(var1_1.getPSAppViewType().replaceAll("\\d+", ""));
                                var1_1.setSRFNextForm("de");
                                break block10;
                            }
                            if (StringHelper.isNullOrEmpty((String)var1_1.getPSAppModuleId())) {
                                var2_2 = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
                                var3_3 = new PSAppModule();
                                var3_3.setPSSysAppId(var1_1.getPSSysAppId());
                                var3_3.setDefaultFlag(1);
                                if (!var2_2.select(var3_3, true)) {
                                    var3_3.reset();
                                    var3_3.setPSSysAppId(var1_1.getPSSysAppId());
                                    if (!var2_2.select(var3_3, true)) {
                                        var3_3 = null;
                                    }
                                }
                                if (var3_3 != null) {
                                    var1_1.setPSAppModuleId(var3_3.getPSAppModuleId());
                                    var1_1.setPSAppModuleName(var3_3.getPSAppModuleName());
                                }
                            }
                            var2_2 = PSModelGlobal.getPSViewType(var1_1.getPSAppViewType());
                            var1_1.setPSUWAppViewName(var2_2.getPSViewTypeName());
                            if (StringHelper.compare((String)var1_1.getPSAppViewType(), (String)"APPINDEXVIEW", (boolean)true) != 0) break block11;
                            var3_3 = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
                            var4_4 = var2_2.getTitle();
                            var5_8 = var2_2.getCodeName();
                            var6_12 = 0;
                            do lbl-1000:
                            // 3 sources

                            {
                                var7_16 = new PSAppIndexView();
                                var7_16.setPSSysAppId(var1_1.getPSSysAppId());
                                var7_16.setPSAppIndexViewName(StringHelper.format((String)"%1$s%2$s", (Object)var5_8, (Object)(++var6_12 == 1 ? "" : Integer.valueOf(var6_12))));
                                if (var3_3.select(var7_16, true)) ** GOTO lbl-1000
                                var1_1.setCodeName(var7_16.getPSAppIndexViewName());
                                var7_16.reset();
                                var7_16.setPSSysAppId(var1_1.getPSSysAppId());
                                var7_16.setTitle(StringHelper.format((String)"%1$s%2$s", (Object)var4_4, (Object)(var6_12 == 1 ? "" : Integer.valueOf(var6_12))));
                            } while (var3_3.select(var7_16, true));
                            var1_1.setTitle(var7_16.getTitle());
                            break block12;
                        }
                        if (StringHelper.compare((String)var1_1.getPSAppViewType(), (String)"APPPORTALVIEW", (boolean)true) != 0) break block13;
                        var3_3 = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
                        var4_5 = var2_2.getTitle();
                        var5_9 = var2_2.getCodeName();
                        var6_13 = 0;
                        do lbl-1000:
                        // 3 sources

                        {
                            var7_17 = new PSAppPortalView();
                            var7_17.setPSSysAppId(var1_1.getPSSysAppId());
                            var7_17.setPSAppPortalViewName(StringHelper.format((String)"%1$s%2$s", (Object)var5_9, (Object)(++var6_13 == 1 ? "" : Integer.valueOf(var6_13))));
                            if (var3_3.select(var7_17, true)) ** GOTO lbl-1000
                            var1_1.setCodeName(var7_17.getPSAppPortalViewName());
                            var7_17.reset();
                            var7_17.setPSSysAppId(var1_1.getPSSysAppId());
                            var7_17.setTitle(StringHelper.format((String)"%1$s%2$s", (Object)var4_5, (Object)(var6_13 == 1 ? "" : Integer.valueOf(var6_13))));
                        } while (var3_3.select(var7_17, true));
                        var1_1.setTitle(var7_17.getTitle());
                        break block12;
                    }
                    if (StringHelper.compare((String)var1_1.getPSAppViewType(), (String)"APPPANELVIEW", (boolean)true) != 0) break block14;
                    var3_3 = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
                    var4_6 = var2_2.getTitle();
                    var5_10 = var2_2.getCodeName();
                    var6_14 = 0;
                    do lbl-1000:
                    // 3 sources

                    {
                        var7_18 = new PSAppPanelView();
                        var7_18.setPSSysAppId(var1_1.getPSSysAppId());
                        var7_18.setPSAppPanelViewName(StringHelper.format((String)"%1$s%2$s", (Object)var5_10, (Object)(++var6_14 == 1 ? "" : Integer.valueOf(var6_14))));
                        if (var3_3.select(var7_18, true)) ** GOTO lbl-1000
                        var1_1.setCodeName(var7_18.getPSAppPanelViewName());
                        var7_18.reset();
                        var7_18.setPSSysAppId(var1_1.getPSSysAppId());
                        var7_18.setTitle(StringHelper.format((String)"%1$s%2$s", (Object)var4_6, (Object)(var6_14 == 1 ? "" : Integer.valueOf(var6_14))));
                    } while (var3_3.select(var7_18, true));
                    var1_1.setTitle(var7_18.getTitle());
                    break block12;
                }
                var3_3 = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
                var4_7 = var2_2.getTitle();
                var5_11 = var2_2.getCodeName();
                var6_15 = 0;
                do lbl-1000:
                // 3 sources

                {
                    var7_19 = new PSAppUtilView();
                    var7_19.setPSSysAppId(var1_1.getPSSysAppId());
                    var7_19.setPSAppUtilViewName(StringHelper.format((String)"%1$s%2$s", (Object)var5_11, (Object)(++var6_15 == 1 ? "" : Integer.valueOf(var6_15))));
                    if (var3_3.select(var7_19, true)) ** GOTO lbl-1000
                    var1_1.setCodeName(var7_19.getPSAppUtilViewName());
                    var7_19.reset();
                    var7_19.setPSSysAppId(var1_1.getPSSysAppId());
                    var7_19.setTitle(StringHelper.format((String)"%1$s%2$s", (Object)var4_7, (Object)(var6_15 == 1 ? "" : Integer.valueOf(var6_15))));
                } while (var3_3.select(var7_19, true));
                var1_1.setTitle(var7_19.getTitle());
            }
            var1_1.setSRFNextForm("finish");
        }
        this.update(var1_1);
    }

    @Override
    protected void onInitViewParam(PSUWAppView pSUWAppView) throws Exception {
        PSUWAppView pSUWAppView2 = new PSUWAppView();
        pSUWAppView2.setPSUWAppViewId(pSUWAppView.getPSUWAppViewId());
        this.get((IEntity)pSUWAppView2);
        pSUWAppView.setPSAppViewType(pSUWAppView2.getPSAppViewType());
        if (!StringHelper.isNullOrEmpty((String)pSUWAppView.getPSAppViewType())) {
            PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = new PSSysApp();
            pSSysApp.setPSSysAppId(pSUWAppView2.getPSSysAppId());
            pSSysAppService.initPSAppModules(pSSysApp);
            if (pSUWAppView.getPSAppViewType().indexOf("DE") == 0) {
                Object object;
                PSDataEntity pSDataEntity = null;
                if (!StringHelper.isNullOrEmpty((String)pSUWAppView.getPSDEId())) {
                    pSDataEntity = new PSDataEntity();
                    pSDataEntity.setSessionFactory(this.getSessionFactory());
                    pSDataEntity.setPSDataEntityId(pSUWAppView.getPSDEId());
                    try {
                        pSDataEntity.get(true);
                    }
                    catch (Exception exception) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61[%1$s]", (Object)pSUWAppView.getPSDEId()));
                    }
                    object = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
                    PSAppModule pSAppModule = new PSAppModule();
                    pSAppModule.setPSSysAppId(pSUWAppView2.getPSSysAppId());
                    pSAppModule.setPSModuleId(pSDataEntity.getPSModuleId());
                    if (!((PSCoreSysServiceBaseBase)((Object)object)).select(pSAppModule, true)) {
                        pSAppModule.reset();
                        pSAppModule.setPSSysAppId(pSUWAppView2.getPSSysAppId());
                        pSAppModule.setCodeName(pSDataEntity.getPSModule().getCodeName());
                        if (!((PSCoreSysServiceBaseBase)((Object)object)).select(pSAppModule, true)) {
                            pSAppModule.reset();
                            pSAppModule.setPSSysAppId(pSUWAppView2.getPSSysAppId());
                            pSAppModule.setDefaultFlag(1);
                            if (!((PSCoreSysServiceBaseBase)((Object)object)).select(pSAppModule, true)) {
                                pSAppModule = null;
                            }
                        }
                    }
                    if (pSAppModule != null) {
                        pSUWAppView.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                        pSUWAppView.setPSAppModuleName(pSAppModule.getPSAppModuleName());
                    }
                }
                object = PSModelGlobal.getPSViewType(pSUWAppView.getPSAppViewType());
                this.initPSUWAppView(pSUWAppView, pSDataEntity, (PSViewTypeStruct)object);
                pSUWAppView.setSRFNextForm("finish");
                if (!StringHelper.isNullOrEmpty((String)pSUWAppView.getPSDEGridId())) {
                    pSUWAppView.setSRFNextForm("grid");
                } else if (!StringHelper.isNullOrEmpty((String)pSUWAppView.getPSDEFormId())) {
                    pSUWAppView.setSRFNextForm("editform");
                }
            }
        }
        this.update(pSUWAppView);
    }

    protected void initPSUWAppView(PSUWAppView pSUWAppView, PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct) throws Exception {
        ArrayList<PSVTCtrl> arrayList;
        PSDEViewCtrl pSDEViewCtrl;
        Object object2;
        Object object3;
        if (pSDataEntity != null) {
            PSDEViewBase object4;
            if (!StringHelper.isNullOrEmpty((String)pSViewTypeStruct.getTitle())) {
                pSUWAppView.setTitle(StringHelper.format((String)"%1$s%2$s", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getTitle()));
            }
            object3 = StringHelper.format((String)"%1$s%2$s", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getPSViewTypeName());
            int n = 1;
            do {
                if (n > 1) {
                    object3 = StringHelper.format((String)"%1$s%2$s", (Object)StringHelper.format((String)"%1$s%2$s", (Object)pSDataEntity.getLogicName(), (Object)pSViewTypeStruct.getPSViewTypeName()), (Object)(n == 1 ? "" : StringHelper.format((String)"(%1$s)", (Object)n)));
                }
                ++n;
                object2 = new PSDEViewBase();
                object2.setSessionFactory(this.getSessionFactory());
                ((PSDEViewBaseBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEViewBaseBase)object2).setPSDEViewBaseName((String)object3);
            } while (object2.select(true));
            pSUWAppView.setPSUWAppViewName((String)object3);
            object2 = pSViewTypeStruct.getCodeName();
            n = 1;
            do {
                if (n > 1) {
                    object2 = StringHelper.format((String)"Usr%1$s%2$s", (Object)(n == 1 ? "" : Integer.valueOf(n)), (Object)pSViewTypeStruct.getCodeName());
                }
                ++n;
                object4 = new PSDEViewBase();
                object4.setSessionFactory(this.getSessionFactory());
                object4.setPSDEId(pSDataEntity.getPSDataEntityId());
                object4.setCodeName((String)object2);
            } while (object4.select(true));
            pSUWAppView.setCodeName((String)object2);
        }
        object3 = null;
        if (DataObject.getBoolValue((Integer)pSUWAppView.getEnableSrcPSDEView(), (boolean)false) && !StringHelper.isNullOrEmpty((String)pSUWAppView.getSrcPSDEViewId())) {
            PSDEViewBase pSDEViewBase = new PSDEViewBase();
            pSDEViewBase.setSessionFactory(this.getSessionFactory());
            pSDEViewBase.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEViewBase.setPSDEViewBaseId(pSUWAppView.getSrcPSDEViewId());
            if (pSDEViewBase.select(true)) {
                object3 = new HashMap();
                object2 = pSDEViewBase.getPSDEViewCtrls();
                Iterator<PSDEViewCtrl> iterator = ((ArrayList)object2).iterator();
                while (iterator.hasNext()) {
                    pSDEViewCtrl = iterator.next();
                    object3.put(pSDEViewCtrl.getPSDEViewCtrlName().toUpperCase(), pSDEViewCtrl);
                }
            }
        }
        if ((arrayList = pSViewTypeStruct.getPSVTCtrls()) != null) {
            for (PSVTCtrl pSVTCtrl : arrayList) {
                if (!DataObject.getBoolValue((Integer)pSVTCtrl.getValidFlag(), (boolean)true)) continue;
                try {
                    pSDEViewCtrl = null;
                    if (object3 != null) {
                        pSDEViewCtrl = (PSDEViewCtrl)object3.get(pSVTCtrl.getPSVTCtrlName().toUpperCase());
                    }
                    this.initDEViewCtrl(pSUWAppView, pSDataEntity, pSViewTypeStruct, pSVTCtrl, pSDEViewCtrl);
                }
                catch (Exception exception) {
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u89c6\u56fe\u7c7b\u578b[%1$s]\u90e8\u4ef6[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSViewTypeStruct.getPSViewTypeName(), (Object)pSVTCtrl.getPSVTCtrlName(), (Object)exception.getMessage()), exception);
                }
            }
        }
    }

    protected void initDEViewCtrl(PSUWAppView pSUWAppView, PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct, PSVTCtrl pSVTCtrl, PSDEViewCtrl pSDEViewCtrl) throws Exception {
        if (!DataObject.getBoolValue((Integer)pSVTCtrl.getValidFlag(), (boolean)true)) {
            return;
        }
        PSSystem pSSystem = null;
        if (pSDataEntity != null) {
            pSSystem = pSDataEntity.getPSSystem();
        }
        this.fillDEViewCtrl(pSUWAppView, pSSystem, pSDataEntity, pSViewTypeStruct, pSVTCtrl, pSDEViewCtrl, "", "");
    }

    protected void fillDEViewCtrl(PSUWAppView pSUWAppView, PSSystem pSSystem, PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct, PSVTCtrl pSVTCtrl, PSDEViewCtrl pSDEViewCtrl, String string, String string2) throws Exception {
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"FORM", (boolean)true) == 0) {
            if (pSDEViewCtrl != null) {
                pSUWAppView.setPSDEFormId(pSDEViewCtrl.getPSDEFormId());
                pSUWAppView.setPSDEFormName(pSDEViewCtrl.getPSDEFormName());
                pSUWAppView.setPSACHandlerId(pSDEViewCtrl.getPSACHandlerId());
                pSUWAppView.setPSACHandlerName(pSDEViewCtrl.getPSACHandlerName());
            } else {
                String string3;
                boolean bl = false;
                if (pSViewTypeStruct != null && pSViewTypeStruct.getPSViewTypeId().indexOf("DEMOB") != -1) {
                    bl = true;
                }
                if (!StringHelper.isNullOrEmpty((String)(string3 = this.getPSDEEditFormId(pSDataEntity, bl)))) {
                    pSUWAppView.setPSDEFormId(string3);
                    if (!StringHelper.isNullOrEmpty((String)pSVTCtrl.getPSSysACHandlerId())) {
                        pSUWAppView.setPSACHandlerId(this.getPSACHandlerId(pSVTCtrl.getPSSysACHandlerId(), pSSystem));
                    }
                }
            }
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"SEARCHFORM", (boolean)true) == 0) {
            if (pSDEViewCtrl != null) {
                pSUWAppView.setPSDESearchFormId(pSDEViewCtrl.getPSDEFormId());
                pSUWAppView.setPSDESearchFormName(pSDEViewCtrl.getPSDEFormName());
                pSUWAppView.setPSSFACHandlerId(pSDEViewCtrl.getPSACHandlerId());
                pSUWAppView.setPSSFACHandlerName(pSDEViewCtrl.getPSACHandlerName());
            } else {
                String string4;
                boolean bl = false;
                if (pSViewTypeStruct != null && pSViewTypeStruct.getPSViewTypeId().indexOf("DEMOB") != -1) {
                    bl = true;
                }
                if (!StringHelper.isNullOrEmpty((String)(string4 = this.getPSDESearchFormId(pSDataEntity, bl)))) {
                    pSUWAppView.setPSDESearchFormId(string4);
                    if (!StringHelper.isNullOrEmpty((String)pSVTCtrl.getPSSysACHandlerId())) {
                        pSUWAppView.setPSSFACHandlerId(this.getPSACHandlerId(pSVTCtrl.getPSSysACHandlerId(), pSSystem));
                    }
                }
            }
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"GRID", (boolean)true) == 0) {
            if (pSDEViewCtrl != null) {
                pSUWAppView.setPSDEGridId(pSDEViewCtrl.getPSDEGridId());
                pSUWAppView.setPSDEGridName(pSDEViewCtrl.getPSDEGridName());
                pSUWAppView.setPSACHandlerId(pSDEViewCtrl.getPSACHandlerId());
                pSUWAppView.setPSACHandlerName(pSDEViewCtrl.getPSACHandlerName());
                pSUWAppView.setPSDEDataSetId(pSDEViewCtrl.getPSDEDataSetId());
            } else {
                String string5;
                boolean bl = false;
                if (pSViewTypeStruct != null && pSViewTypeStruct.getPSViewTypeId().indexOf("DEMOB") != -1) {
                    bl = true;
                }
                if (!StringHelper.isNullOrEmpty((String)(string5 = this.getPSDEGridId(pSDataEntity, bl)))) {
                    pSUWAppView.setPSDEGridId(string5);
                }
                pSUWAppView.setPSDEDataSetId(this.getPSDEDataSetId(pSDataEntity));
                if (!StringHelper.isNullOrEmpty((String)pSVTCtrl.getPSSysACHandlerId())) {
                    pSUWAppView.setPSACHandlerId(this.getPSACHandlerId(pSVTCtrl.getPSSysACHandlerId(), pSSystem));
                }
            }
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"TOOLBAR", (boolean)true) == 0) {
            PSDEToolbar pSDEToolbar;
            if (pSDEViewCtrl != null) {
                pSUWAppView.setPSDEToolbarId(pSDEViewCtrl.getPSDEToolbarId());
                pSUWAppView.setPSDEToolbarName(pSDEViewCtrl.getPSDEToolbarName());
            } else if (!StringHelper.isNullOrEmpty((String)pSVTCtrl.getPSSysToolbarId()) && (pSDEToolbar = this.getPSDEToolbarId(pSVTCtrl.getPSSysToolbarId(), pSSystem)) != null) {
                pSUWAppView.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
                pSUWAppView.setPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
            }
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"PICKUPVIEWPANEL", (boolean)true) == 0) {
            if (pSDEViewCtrl != null) {
                pSUWAppView.setPSDEViewId(pSDEViewCtrl.getPSDEViewId());
                pSUWAppView.setPSDEViewName(pSDEViewCtrl.getPSDEViewName());
            } else {
                String string6 = this.getPSDEViewBaseId(pSDataEntity, pSViewTypeStruct, string, string2);
                if (!StringHelper.isNullOrEmpty((String)string6)) {
                    pSUWAppView.setPSDEViewId(string6);
                }
            }
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"DRBAR", (boolean)true) == 0 || StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"DRTAB", (boolean)true) == 0) {
            if (pSDEViewCtrl != null) {
                pSUWAppView.setPSDEDRId(pSDEViewCtrl.getPSDEDRId());
                pSUWAppView.setPSDEDRName(pSDEViewCtrl.getPSDEDRName());
            } else {
                boolean bl = false;
                if (pSViewTypeStruct != null && pSViewTypeStruct.getPSViewTypeId().indexOf("DEMOB") != -1) {
                    bl = true;
                }
                String string7 = this.getPSDEDataRelationId(pSDataEntity, bl);
                pSUWAppView.setPSDEDRId(string7);
            }
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"DATAVIEW", (boolean)true) == 0) {
            if (pSDEViewCtrl != null) {
                pSUWAppView.setPSDEDataViewId(pSDEViewCtrl.getPSDEDataViewId());
                pSUWAppView.setPSDEDataViewName(pSDEViewCtrl.getPSDEDataViewName());
                pSUWAppView.setPSACHandlerId(pSDEViewCtrl.getPSACHandlerId());
                pSUWAppView.setPSACHandlerName(pSDEViewCtrl.getPSACHandlerName());
                pSUWAppView.setPSDEDataSetId(pSDEViewCtrl.getPSDEDataSetId());
            } else {
                pSUWAppView.setPSDEDataViewId(this.getPSDEDataViewId(pSDataEntity, string, string2));
                pSUWAppView.setPSDEDataSetId(this.getPSDEDataSetId(pSDataEntity, string, string2));
                if (StringHelper.isNullOrEmpty((String)string)) {
                    if (!StringHelper.isNullOrEmpty((String)pSVTCtrl.getPSSysACHandlerId())) {
                        pSUWAppView.setPSACHandlerId(this.getPSACHandlerId(pSVTCtrl.getPSSysACHandlerId(), pSSystem));
                    }
                } else {
                    Object object;
                    Object object2;
                    String string8 = "";
                    if (StringHelper.isNullOrEmpty((String)string)) {
                        string8 = pSDataEntity.getPSDataEntityId();
                        object2 = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                        object = new PSDEDataSet();
                        ((PSDEDataSetBase)object).setPSDEDataSetId(pSDataEntity.getPSDataEntityId());
                        if (((PSCoreSysServiceBase)object2).checkKey(object) == 1) {
                            pSUWAppView.setPSDEDataSetId(pSDataEntity.getPSDataEntityId());
                        }
                        if (!StringHelper.isNullOrEmpty((String)pSVTCtrl.getPSSysACHandlerId())) {
                            pSUWAppView.setPSACHandlerId(this.getPSACHandlerId(pSVTCtrl.getPSSysACHandlerId(), pSSystem));
                        }
                    } else {
                        string8 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)string, (String)string2);
                        object2 = "";
                        object = "";
                        if (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0) {
                            object2 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"INDEXDETYPE", (String)string2);
                            object = "INDEXPICKUPDATAVIEWHANDLER";
                        } else if (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0) {
                            object2 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"FORMTYPE", (String)"");
                            object = "FORMPICKUPDATAVIEWHANDLER";
                        }
                        PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                        PSDEDataSet pSDEDataSet = new PSDEDataSet();
                        pSDEDataSet.setPSDEDataSetId((String)object2);
                        if (pSDEDataSetService.checkKey(pSDEDataSet) == 1) {
                            pSUWAppView.setPSDEDataSetId((String)object2);
                        }
                        pSUWAppView.setPSACHandlerId(this.getPSACHandlerId((String)object, pSSystem));
                    }
                    object2 = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
                    object = new PSDEDataView();
                    ((PSDEDataViewBase)object).setPSDEDataViewId(string8);
                    if (((PSCoreSysServiceBase)object2).checkKey(object) == 1) {
                        pSUWAppView.setPSDEDataViewId(string8);
                    }
                }
            }
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"MOBMDCTRL", (boolean)true) == 0) {
            if (pSDEViewCtrl != null) {
                pSUWAppView.setPSDEListId(pSDEViewCtrl.getPSDEListId());
                pSUWAppView.setPSDEListName(pSDEViewCtrl.getPSDEListName());
                pSUWAppView.setPSACHandlerId(pSDEViewCtrl.getPSACHandlerId());
                pSUWAppView.setPSACHandlerName(pSDEViewCtrl.getPSACHandlerName());
                pSUWAppView.setPSDEDataSetId(pSDEViewCtrl.getPSDEDataSetId());
                pSUWAppView.setMDCtrlParam(pSDEViewCtrl.getCtrlParam());
            } else {
                pSUWAppView.setPSDEListId(this.getPSDEListId(pSDataEntity, string, string2, true));
                pSUWAppView.setPSDEDataSetId(this.getPSDEDataSetId(pSDataEntity, string, string2));
                if (StringHelper.isNullOrEmpty((String)string)) {
                    if (!StringHelper.isNullOrEmpty((String)pSVTCtrl.getPSSysACHandlerId())) {
                        pSUWAppView.setPSACHandlerId(this.getPSACHandlerId(pSVTCtrl.getPSSysACHandlerId(), pSSystem));
                    }
                } else {
                    String string9 = pSVTCtrl.getPSSysACHandlerId();
                    pSUWAppView.setPSACHandlerId(this.getPSACHandlerId(string9, pSSystem));
                }
                pSUWAppView.setMDCtrlParam("LISTVIEW");
            }
            return;
        }
    }

    protected String getPSACHandlerId(String string, PSSystem pSSystem) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string2 = StringHelper.format((String)"%1$s#%2$s", (Object)"PSACHANDLER", (Object)string);
        if (actionSession != null && (object = actionSession.getActionParam(string2)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSACHandlerIdReal(string, pSSystem);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string2, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string2, object);
            }
        }
        return object;
    }

    protected String getPSACHandlerIdReal(String string, PSSystem pSSystem) throws Exception {
        String string2 = KeyValueHelper.genUniqueId((String)string, (String)pSSystem.getPSSFId());
        String string3 = KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)string2);
        PSACHandlerService pSACHandlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        PSACHandler pSACHandler = new PSACHandler();
        pSACHandler.setPSACHandlerId(string3);
        if (pSACHandlerService.checkKey(pSACHandler) == 1) {
            return string3;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.setFetchFirst(true);
        selectCond.setIsNull("PSDEID");
        selectCond.set("PSSYSTEMID", (Object)pSSystem.getPSSystemId());
        selectCond.set("PSSFACHANDLERID", (Object)string2);
        ArrayList arrayList = pSACHandlerService.select((ISelectCond)selectCond);
        if (arrayList.size() > 0) {
            return ((PSACHandler)arrayList.get(0)).getPSACHandlerId();
        }
        return null;
    }

    protected PSDEToolbar getPSDEToolbarId(String string, PSSystem pSSystem) throws Exception {
        String string2 = KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)string);
        PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        PSDEToolbar pSDEToolbar = new PSDEToolbar();
        pSDEToolbar.setPSDEToolbarId(string2);
        if (pSDEToolbarService.get((IEntity)pSDEToolbar, true)) {
            return pSDEToolbar;
        }
        return null;
    }

    protected String getPSDEEditFormId(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string = StringHelper.format((String)"%1$s#%2$s#%3$s", (Object)"PSEDITFORM", (Object)pSDataEntity.getPSDataEntityId(), (Object)bl);
        if (actionSession != null && (object = actionSession.getActionParam(string)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDEEditFormIdReal(pSDataEntity, bl);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string, object);
            }
        }
        return object;
    }

    protected String getPSDEEditFormIdReal(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        boolean bl2 = this.isEnableFolderKey((IEntity)pSDataEntity);
        String string = null;
        if (bl2) {
            string = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R1");
            if (bl) {
                string = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R3");
            }
        } else {
            string = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"EDITFORM");
            if (bl) {
                string = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"EDITFORM", (String)"MOB");
            }
        }
        PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        PSDEForm pSDEForm = new PSDEForm();
        pSDEForm.setPSDEFormId(string);
        if (pSDEFormService.checkKey(pSDEForm) == 1) {
            return string;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("FORMTYPE", (Object)"EDITFORM");
        selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
        ArrayList arrayList = pSDEFormService.select((ISelectCond)selectCond);
        for (PSDEForm pSDEForm2 : arrayList) {
            if (bl) {
                if (DataObject.getBoolValue((Integer)pSDEForm2.getMobFlag(), (boolean)false)) {
                    return pSDEForm2.getPSDEFormId();
                }
                if (pSDEForm2.getCodeName().indexOf("Mob") == -1) continue;
                return pSDEForm2.getPSDEFormId();
            }
            if (DataObject.getBoolValue((Integer)pSDEForm2.getMobFlag(), (boolean)false) || pSDEForm2.getCodeName().indexOf("Mob") != -1) continue;
            return pSDEForm2.getPSDEFormId();
        }
        return null;
    }

    protected String getPSDESearchFormId(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string = StringHelper.format((String)"%1$s#%2$s#%3$s", (Object)"PSSEARCHFORM", (Object)pSDataEntity.getPSDataEntityId(), (Object)bl);
        if (actionSession != null && (object = actionSession.getActionParam(string)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDESearchFormIdReal(pSDataEntity, bl);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string, object);
            }
        }
        return object;
    }

    protected String getPSDESearchFormIdReal(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        boolean bl2 = this.isEnableFolderKey((IEntity)pSDataEntity);
        String string = null;
        if (bl2) {
            string = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R2");
            if (bl) {
                string = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R4");
            }
        } else {
            string = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"SEARCHFORM");
            if (bl) {
                string = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"SEARCHFORM", (String)"MOB");
            }
        }
        PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        PSDEForm pSDEForm = new PSDEForm();
        pSDEForm.setPSDEFormId(string);
        if (pSDEFormService.checkKey(pSDEForm) == 1) {
            return string;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("FORMTYPE", (Object)"SEARCHFORM");
        selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
        ArrayList arrayList = pSDEFormService.select((ISelectCond)selectCond);
        for (PSDEForm pSDEForm2 : arrayList) {
            if (bl) {
                if (DataObject.getBoolValue((Integer)pSDEForm2.getMobFlag(), (boolean)false)) {
                    return pSDEForm2.getPSDEFormId();
                }
                if (pSDEForm2.getCodeName().indexOf("Mob") == -1) continue;
                return pSDEForm2.getPSDEFormId();
            }
            if (DataObject.getBoolValue((Integer)pSDEForm2.getMobFlag(), (boolean)false) || pSDEForm2.getCodeName().indexOf("Mob") != -1) continue;
            return pSDEForm2.getPSDEFormId();
        }
        return null;
    }

    protected String getPSDEGridId(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string = StringHelper.format((String)"%1$s#%2$s#%3$s", (Object)"PSDEGRID", (Object)pSDataEntity.getPSDataEntityId(), (Object)bl);
        if (actionSession != null && (object = actionSession.getActionParam(string)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDEGridIdReal(pSDataEntity, bl);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string, object);
            }
        }
        return object;
    }

    protected String getPSDEGridIdReal(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        boolean bl2 = this.isEnableFolderKey((IEntity)pSDataEntity);
        String string = null;
        string = bl2 ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R1") : pSDataEntity.getPSDataEntityId();
        PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        PSDEGrid pSDEGrid = new PSDEGrid();
        pSDEGrid.setPSDEGridId(string);
        if (pSDEGridService.checkKey(pSDEGrid) == 1) {
            return string;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
        ArrayList arrayList = pSDEGridService.select((ISelectCond)selectCond);
        for (PSDEGrid pSDEGrid2 : arrayList) {
            if (!(bl ? pSDEGrid2.getCodeName().indexOf("Mob") != -1 : pSDEGrid2.getCodeName().indexOf("Mob") == -1)) continue;
            return pSDEGrid2.getPSDEGridId();
        }
        return null;
    }

    protected String getPSDEDataSetId(PSDataEntity pSDataEntity) throws Exception {
        return this.getPSDEDataSetId(pSDataEntity, null, null);
    }

    protected String getPSDEDataSetId(PSDataEntity pSDataEntity, String string, String string2) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string3 = StringHelper.format((String)"%1$s#%2$s#%3$s#%4$s", (Object)"PSDEDATASET", (Object)pSDataEntity.getPSDataEntityId(), (Object)string, (Object)string2);
        if (actionSession != null && (object = actionSession.getActionParam(string3)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDEDataSetIdReal(pSDataEntity, string, string2);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string3, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string3, object);
            }
        }
        return object;
    }

    protected String getPSDEDataSetIdReal(PSDataEntity pSDataEntity, String string, String string2) throws Exception {
        boolean bl = this.isEnableFolderKey((IEntity)pSDataEntity);
        String string3 = null;
        if (bl) {
            string3 = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R1");
        } else {
            string3 = pSDataEntity.getPSDataEntityId();
            if (!StringHelper.isNullOrEmpty((String)string)) {
                if (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0) {
                    string3 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"INDEXDETYPE", (String)string2);
                } else if (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0) {
                    string3 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"FORMTYPE", (String)"");
                }
            }
        }
        PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        PSDEDataSet pSDEDataSet = new PSDEDataSet();
        pSDEDataSet.setPSDEDataSetId(string3);
        if (pSDEDataSetService.checkKey(pSDEDataSet) == 1) {
            return string3;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
        ArrayList arrayList = pSDEDataSetService.select((ISelectCond)selectCond);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            for (PSDEDataSet pSDEDataSet2 : arrayList) {
                if (!(StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0 ? "INDEXDE".equals(pSDEDataSet2.getPredefineType()) : StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0 && "MULTIFORM".equals(pSDEDataSet2.getPredefineType()))) continue;
                return pSDEDataSet2.getPSDEDataSetId();
            }
        } else {
            for (PSDEDataSet pSDEDataSet3 : arrayList) {
                if (!DataObject.getBoolValue((Integer)pSDEDataSet3.getDefaultMode(), (boolean)false)) continue;
                return pSDEDataSet3.getPSDEDataSetId();
            }
            Iterator iterator = arrayList.iterator();
            if (iterator.hasNext()) {
                PSDEDataSet pSDEDataSet3;
                pSDEDataSet3 = (PSDEDataSet)iterator.next();
                return pSDEDataSet3.getPSDEDataSetId();
            }
        }
        return null;
    }

    protected String getPSDEDataViewId(PSDataEntity pSDataEntity, String string, String string2) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string3 = StringHelper.format((String)"%1$s#%2$s#%3$s#%4$s", (Object)"PSDEDATAVIEW", (Object)pSDataEntity.getPSDataEntityId(), (Object)string, (Object)string2);
        if (actionSession != null && (object = actionSession.getActionParam(string3)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDEDataViewIdReal(pSDataEntity, string, string2);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string3, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string3, object);
            }
        }
        return object;
    }

    protected String getPSDEDataViewIdReal(PSDataEntity pSDataEntity, String string, String string2) throws Exception {
        String string3 = "";
        boolean bl = this.isEnableFolderKey((IEntity)pSDataEntity);
        if (bl) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                if (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0) {
                    string3 = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R2");
                } else if (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0) {
                    string3 = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R3");
                }
            }
        } else {
            string3 = StringHelper.isNullOrEmpty((String)string) ? pSDataEntity.getPSDataEntityId() : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)string, (String)string2);
        }
        PSDEDataViewService pSDEDataViewService = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        PSDEDataView pSDEDataView = new PSDEDataView();
        pSDEDataView.setPSDEDataViewId(string3);
        if (pSDEDataViewService.checkKey(pSDEDataView) == 1) {
            return string3;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
        ArrayList arrayList = pSDEDataViewService.select((ISelectCond)selectCond);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            for (PSDEDataView pSDEDataView2 : arrayList) {
                if (!(StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0 ? "IndexType".equals(pSDEDataView2.getCodeName()) : StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0 && "FormType".equals(pSDEDataView2.getCodeName()))) continue;
                return pSDEDataView2.getPSDEDataViewId();
            }
        } else {
            Iterator iterator = arrayList.iterator();
            if (iterator.hasNext()) {
                PSDEDataView pSDEDataView3 = (PSDEDataView)iterator.next();
                return pSDEDataView3.getPSDEDataViewId();
            }
        }
        return null;
    }

    protected String getPSDEListId(PSDataEntity pSDataEntity, String string, String string2, boolean bl) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string3 = StringHelper.format((String)"%1$s#%2$s#%3$s#%4$s#%5$s", (Object)"PSDELIST", (Object)pSDataEntity.getPSDataEntityId(), (Object)string, (Object)string2, (Object)bl);
        if (actionSession != null && (object = actionSession.getActionParam(string3)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDEListIdReal(pSDataEntity, string, string2, bl);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string3, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string3, object);
            }
        }
        return object;
    }

    protected String getPSDEListIdReal(PSDataEntity pSDataEntity, String string, String string2, boolean bl) throws Exception {
        boolean bl2 = this.isEnableFolderKey((IEntity)pSDataEntity);
        String string3 = "";
        if (bl2) {
            if (StringHelper.isNullOrEmpty((String)string)) {
                string3 = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R1");
            } else if (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0) {
                string3 = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R2");
            } else if (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0) {
                string3 = StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R3");
            }
        } else {
            string3 = bl ? (StringHelper.isNullOrEmpty((String)string) ? KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"MOB") : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)string, (String)string2, (String)"MOB")) : (StringHelper.isNullOrEmpty((String)string) ? pSDataEntity.getPSDataEntityId() : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)string, (String)string2));
        }
        PSDEListService pSDEListService = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        PSDEList pSDEList = new PSDEList();
        pSDEList.setPSDEListId(string3);
        if (pSDEListService.checkKey(pSDEList) == 1) {
            return string3;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
        ArrayList arrayList = pSDEListService.select((ISelectCond)selectCond);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            for (PSDEList pSDEList2 : arrayList) {
                if (!(StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0 ? (bl ? "MobIndexType".equals(pSDEList2.getCodeName()) : "IndexType".equals(pSDEList2.getCodeName())) : StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0 && (bl ? "MobFormType".equals(pSDEList2.getCodeName()) : "FormType".equals(pSDEList2.getCodeName())))) continue;
                return pSDEList2.getPSDEListId();
            }
        } else {
            for (PSDEList pSDEList3 : arrayList) {
                if (!bl || !"Mob".equals(pSDEList3.getCodeName())) continue;
                return pSDEList3.getPSDEListId();
            }
            Iterator iterator = arrayList.iterator();
            if (iterator.hasNext()) {
                PSDEList pSDEList3;
                pSDEList3 = (PSDEList)iterator.next();
                return pSDEList3.getPSDEListId();
            }
        }
        return null;
    }

    protected String getPSDEViewBaseId(PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct, String string, String string2) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string3 = StringHelper.format((String)"%1$s#%2$s#%3$s#%4$s#%5$s", (Object)"PSDEDATASET", (Object)pSDataEntity.getPSDataEntityId(), (Object)(pSViewTypeStruct == null ? "" : pSViewTypeStruct.getPSViewTypeId()), (Object)string, (Object)string2);
        if (actionSession != null && (object = actionSession.getActionParam(string3)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDEViewBaseIdReal(pSDataEntity, pSViewTypeStruct, string, string2);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string3, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string3, object);
            }
        }
        return object;
    }

    protected String getPSDEViewBaseIdReal(PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct, String string, String string2) throws Exception {
        boolean bl = this.isEnableFolderKey((IEntity)pSDataEntity);
        if (bl) {
            String string3 = "";
            string3 = pSViewTypeStruct != null && pSViewTypeStruct.getPSViewTypeId().indexOf("DEMOB") != -1 ? (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0 ? KeyValueHelper.genUniqueId((String)"DEMOBINDEXPICKUPMDVIEW", (String)string, (String)string2) : (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0 ? KeyValueHelper.genUniqueId((String)"DEMOBFORMPICKUPMDVIEW", (String)string, (String)string2) : KeyValueHelper.genUniqueId((String)"DEMOBPICKUPMDVIEW"))) : (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0 ? KeyValueHelper.genUniqueId((String)"DEINDEXPICKUPDATAVIEW", (String)string, (String)string2) : (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0 ? KeyValueHelper.genUniqueId((String)"DEFORMPICKUPDATAVIEW", (String)string, (String)string2) : KeyValueHelper.genUniqueId((String)"DEPICKUPGRIDVIEW")));
            PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = new PSDEViewBase();
            pSDEViewBase.setDEViewTag(string3);
            pSDEViewBase.setPSDEId(pSDataEntity.getPSDataEntityId());
            if (pSDEViewBaseService.selectOne((IEntity)pSDEViewBase, true)) {
                return pSDEViewBase.getPSDEViewBaseId();
            }
        } else {
            String string4 = "";
            String string5 = "";
            if (pSViewTypeStruct != null && pSViewTypeStruct.getPSViewTypeId().indexOf("DEMOB") != -1) {
                if (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0) {
                    string4 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEMOBINDEXPICKUPMDVIEW", (String)string, (String)string2);
                    string5 = "DEMOBINDEXPICKUPMDVIEW";
                } else if (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0) {
                    string4 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEMOBFORMPICKUPMDVIEW", (String)string, (String)string2);
                    string5 = "DEMOBFORMPICKUPMDVIEW";
                } else {
                    string4 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEMOBPICKUPMDVIEW");
                    string5 = "DEMOBPICKUPMDVIEW";
                }
            } else if (StringHelper.compare((String)string, (String)"INDEXDETYPE", (boolean)true) == 0) {
                string4 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEINDEXPICKUPDATAVIEW", (String)string, (String)string2);
                string5 = "DEINDEXPICKUPDATAVIEW";
            } else if (StringHelper.compare((String)string, (String)"FORMTYPE", (boolean)true) == 0) {
                string4 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEFORMPICKUPDATAVIEW", (String)string, (String)string2);
                string5 = "DEFORMPICKUPDATAVIEW";
            } else {
                string4 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEPICKUPGRIDVIEW");
                string5 = "DEPICKUPGRIDVIEW";
            }
            PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = new PSDEViewBase();
            pSDEViewBase.setPSDEViewBaseId(string4);
            if (pSDEViewBaseService.checkKey(pSDEViewBase) == 1) {
                return pSDEViewBase.getPSDEViewBaseId();
            }
            SelectCond selectCond = new SelectCond();
            selectCond.setFetchFirst(true);
            selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
            selectCond.set("PSDEVIEWBASETYPE", (Object)string5);
            if (StringHelper.isNullOrEmpty((String)string)) {
                selectCond.setIsNull("DEVIEWTAG3");
                selectCond.setIsNull("DEVIEWTAG4");
            } else {
                selectCond.set("DEVIEWTAG3", (Object)string);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    selectCond.set("DEVIEWTAG4", (Object)string2);
                } else {
                    selectCond.setIsNull("DEVIEWTAG4");
                }
            }
            ArrayList arrayList = pSDEViewBaseService.select((ISelectCond)selectCond);
            if (arrayList.size() == 0) {
                return null;
            }
            return ((PSDEViewBase)arrayList.get(0)).getPSDEViewBaseId();
        }
        return null;
    }

    protected String getPSDEDataRelationId(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        Object object;
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        String string = StringHelper.format((String)"%1$s#%2$s#%3$s", (Object)"PSDEDATARELATION", (Object)pSDataEntity.getPSDataEntityId(), (Object)bl);
        if (actionSession != null && (object = actionSession.getActionParam(string)) != null) {
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        object = this.getPSDEDataRelationIdReal(pSDataEntity, bl);
        if (actionSession != null) {
            if (object == null) {
                actionSession.setActionParam(string, EntityBase.EMPTY);
            } else {
                actionSession.setActionParam(string, object);
            }
        }
        return object;
    }

    protected String getPSDEDataRelationIdReal(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        boolean bl2 = this.isEnableFolderKey((IEntity)pSDataEntity);
        String string = null;
        string = bl2 ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)"R1") : pSDataEntity.getPSDataEntityId();
        PSDEDataRelation pSDEDataRelation = new PSDEDataRelation();
        pSDEDataRelation.setPSDEDataRelationId(string);
        PSDEDataRelationService pSDEDataRelationService = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, (SessionFactory)this.getSessionFactory());
        if (pSDEDataRelationService.checkKey(pSDEDataRelation) == 1) {
            return string;
        }
        SelectCond selectCond = new SelectCond();
        selectCond.setFetchFirst(true);
        selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
        selectCond.setIsNull("PSWFDEID");
        if (bl) {
            selectCond.set("DRTAG", (Object)"MOB");
        } else {
            selectCond.setIsNull("DRTAG");
        }
        ArrayList arrayList = pSDEDataRelationService.select((ISelectCond)selectCond);
        if (arrayList.size() > 0) {
            return ((PSDEDataRelation)arrayList.get(0)).getPSDEDataRelationId();
        }
        return null;
    }

    protected void initDEViewCtrl(PSUWAppView pSUWAppView, PSViewTypeStruct pSViewTypeStruct, PSDEViewBase pSDEViewBase, PSVTCtrl pSVTCtrl, String string, String string2) throws Exception {
        if (!DataObject.getBoolValue((Integer)pSVTCtrl.getValidFlag(), (boolean)true)) {
            return;
        }
        PSDEViewCtrl pSDEViewCtrl = new PSDEViewCtrl();
        pSDEViewCtrl.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDEViewCtrl.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
        pSDEViewCtrl.setPSDEViewCtrlName(pSVTCtrl.getPSVTCtrlName());
        pSDEViewCtrl.setPSDEViewCtrlType(pSVTCtrl.getCtrlType());
        pSDEViewCtrl.setPSDEId(pSDEViewBase.getPSDEId());
        pSDEViewCtrl.setPSDEName(pSDEViewBase.getPSDEName());
        if (pSVTCtrl.getDefaultFlag() != null) {
            pSDEViewCtrl.setDefaultFlag(pSVTCtrl.getDefaultFlag());
        } else {
            pSDEViewCtrl.setDefaultFlag(1);
        }
        this.fillDEViewCtrlParams(pSDEViewCtrl, pSVTCtrl);
        if (pSVTCtrl.getOrderValue() != null) {
            pSDEViewCtrl.setOrderValue(pSVTCtrl.getOrderValue());
        }
        if (pSVTCtrl.getEnableViewActions() != null) {
            pSDEViewCtrl.setEnableViewActions(pSVTCtrl.getEnableViewActions());
        }
        this.fillDEViewCtrl(pSDEViewCtrl, pSUWAppView, pSViewTypeStruct, pSDEViewBase, pSVTCtrl, string, string2);
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        pSDEViewCtrlService.create(pSDEViewCtrl);
        pSDEViewCtrlService.update(pSDEViewCtrl);
    }

    protected void fillDEViewCtrl(PSDEViewCtrl pSDEViewCtrl, PSUWAppView pSUWAppView, PSViewTypeStruct pSViewTypeStruct, PSDEViewBase pSDEViewBase, PSVTCtrl pSVTCtrl, String string, String string2) throws Exception {
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"FORM", (boolean)true) == 0) {
            pSDEViewCtrl.setPSDEFormId(pSUWAppView.getPSDEFormId());
            pSDEViewCtrl.setPSACHandlerId(pSUWAppView.getPSACHandlerId());
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"SEARCHFORM", (boolean)true) == 0) {
            pSDEViewCtrl.setPSDEFormId(pSUWAppView.getPSDESearchFormId());
            pSDEViewCtrl.setPSACHandlerId(pSUWAppView.getPSSFACHandlerId());
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"GRID", (boolean)true) == 0) {
            pSDEViewCtrl.setPSDEGridId(pSUWAppView.getPSDEGridId());
            pSDEViewCtrl.setPSDEDataSetId(pSUWAppView.getPSDEDataSetId());
            pSDEViewCtrl.setPSACHandlerId(pSUWAppView.getPSACHandlerId());
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"TOOLBAR", (boolean)true) == 0) {
            pSDEViewCtrl.setPSDEToolbarId(pSUWAppView.getPSDEToolbarId());
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"PICKUPVIEWPANEL", (boolean)true) == 0) {
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"DRBAR", (boolean)true) == 0 || StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"DRTAB", (boolean)true) == 0) {
            pSDEViewCtrl.setPSDEDRId(pSUWAppView.getPSDEDRId());
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"DATAVIEW", (boolean)true) == 0) {
            pSDEViewCtrl.setPSDEDataViewId(pSUWAppView.getPSDEDataViewId());
            pSDEViewCtrl.setPSDEDataSetId(pSUWAppView.getPSDEDataSetId());
            pSDEViewCtrl.setPSACHandlerId(pSUWAppView.getPSACHandlerId());
            return;
        }
        if (StringHelper.compare((String)pSVTCtrl.getCtrlType(), (String)"MOBMDCTRL", (boolean)true) == 0) {
            pSDEViewCtrl.setPSDEListId(pSUWAppView.getPSDEListId());
            pSDEViewCtrl.setPSDEDataSetId(pSUWAppView.getPSDEDataSetId());
            pSDEViewCtrl.setPSACHandlerId(pSUWAppView.getPSACHandlerId());
            pSDEViewCtrl.setCtrlParam("LISTVIEW");
            return;
        }
    }

    protected void fillDEViewCtrlParams(PSDEViewCtrl pSDEViewCtrl, PSVTCtrl pSVTCtrl) throws Exception {
        if (pSVTCtrl.getCtrlParam() != null) {
            pSDEViewCtrl.setCtrlParam(pSVTCtrl.getCtrlParam());
        }
        if (pSVTCtrl.getCtrlParam2() != null) {
            pSDEViewCtrl.setCtrlParam2(pSVTCtrl.getCtrlParam2());
        }
        if (pSVTCtrl.getCtrlParam3() != null) {
            pSDEViewCtrl.setCtrlParam3(pSVTCtrl.getCtrlParam3());
        }
        if (pSVTCtrl.getCtrlParam4() != null) {
            pSDEViewCtrl.setCtrlParam4(pSVTCtrl.getCtrlParam4());
        }
        if (pSVTCtrl.getCtrlParam5() != null) {
            pSDEViewCtrl.setCtrlParam5(pSVTCtrl.getCtrlParam5());
        }
        if (pSVTCtrl.getCtrlParam6() != null) {
            pSDEViewCtrl.setCtrlParam6(pSVTCtrl.getCtrlParam6());
        }
        if (pSVTCtrl.getCtrlParam7() != null) {
            pSDEViewCtrl.setCtrlParam7(pSVTCtrl.getCtrlParam7());
        }
        if (pSVTCtrl.getCtrlParam8() != null) {
            pSDEViewCtrl.setCtrlParam8(pSVTCtrl.getCtrlParam8());
        }
        if (pSVTCtrl.getCtrlParam9() != null) {
            pSDEViewCtrl.setCtrlParam9(pSVTCtrl.getCtrlParam9());
        }
        if (pSVTCtrl.getCtrlParam10() != null) {
            pSDEViewCtrl.setCtrlParam10(pSVTCtrl.getCtrlParam10());
        }
    }

    @Override
    protected void onUpdateEditForm(PSUWAppView pSUWAppView) throws Exception {
        PSUWAppView pSUWAppView2 = new PSUWAppView();
        pSUWAppView2.setPSUWAppViewId(pSUWAppView.getPSUWAppViewId());
        this.get((IEntity)pSUWAppView2);
        pSUWAppView.setSRFNextForm("finish");
        if (!StringHelper.isNullOrEmpty((String)pSUWAppView2.getPSDEToolbarId())) {
            pSUWAppView.setSRFNextForm("toolbar");
        }
        this.update(pSUWAppView);
    }

    @Override
    protected void onUpdateSearchForm(PSUWAppView pSUWAppView) throws Exception {
        PSUWAppView pSUWAppView2 = new PSUWAppView();
        pSUWAppView2.setPSUWAppViewId(pSUWAppView.getPSUWAppViewId());
        this.get((IEntity)pSUWAppView2);
        pSUWAppView.setSRFNextForm("finish");
        if (!StringHelper.isNullOrEmpty((String)pSUWAppView2.getPSDEToolbarId())) {
            pSUWAppView.setSRFNextForm("toolbar");
        }
        this.update(pSUWAppView);
    }

    @Override
    protected void onUpdateGrid(PSUWAppView pSUWAppView) throws Exception {
        PSUWAppView pSUWAppView2 = new PSUWAppView();
        pSUWAppView2.setPSUWAppViewId(pSUWAppView.getPSUWAppViewId());
        this.get((IEntity)pSUWAppView2);
        pSUWAppView.setSRFNextForm("finish");
        if (!StringHelper.isNullOrEmpty((String)pSUWAppView2.getPSDESearchFormId())) {
            pSUWAppView.setSRFNextForm("searchform");
        }
        this.update(pSUWAppView);
    }

    @Override
    protected void onUpdateToolbar(PSUWAppView pSUWAppView) throws Exception {
        pSUWAppView.setSRFNextForm("finish");
        this.update(pSUWAppView);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected void onFinishWizard(PSUWAppView var1_1) throws Exception {
        block23: {
            block24: {
                block22: {
                    this.get((IEntity)var1_1);
                    var2_2 = PSModelGlobal.getPSViewType(var1_1.getPSAppViewType());
                    if (var1_1.getPSAppViewType().indexOf("DE") != 0) break block22;
                    var3_3 = new PSDataEntity();
                    var3_3.setSessionFactory(this.getSessionFactory());
                    var3_3.setPSDataEntityId(var1_1.getPSDEId());
                    try {
                        var3_3.get(true);
                    }
                    catch (Exception var4_8) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61[%1$s]", (Object)var1_1.getPSDEId()));
                    }
                    var4_9 = new PSDEViewBase();
                    var5_14 = KeyValueHelper.genGuidEx();
                    var4_9.setPSDEViewBaseId(var5_14);
                    var4_9.setPSSystemId(var3_3.getPSSystemId());
                    var4_9.setPSDEId(var3_3.getPSDataEntityId());
                    var4_9.setPSDEName(var3_3.getPSDataEntityName());
                    var4_9.setPSDEViewBaseName(var1_1.getPSUWAppViewName());
                    var4_9.setTitle(var1_1.getTitle());
                    var4_9.setCaption(var1_1.getCaption());
                    var4_9.setPSDEViewBaseType(var2_2.getPSViewTypeId());
                    var4_9.setCodeName(var1_1.getCodeName());
                    var4_9.setSessionFactory(this.getSessionFactory());
                    try {
                        var4_9.create();
                    }
                    catch (Exception var6_17) {
                        throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5b9e\u4f53\u89c6\u56fe[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)var4_9.getPSDEViewBaseName(), (Object)var6_17.getMessage()), var6_17);
                    }
                    var6_18 = var3_3.getPSSystem();
                    var7_21 = var2_2.getPSVTCtrls();
                    if (var7_21 != null) {
                        var8_24 = var7_21.iterator();
                        while (var8_24.hasNext()) {
                            var9_26 = (PSVTCtrl)var8_24.next();
                            if (!DataObject.getBoolValue((Integer)var9_26.getValidFlag(), (boolean)true)) continue;
                            try {
                                this.initDEViewCtrl(var1_1, var2_2, var4_9, (PSVTCtrl)var9_26, null, null);
                            }
                            catch (Exception var10_28) {
                                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5b9e\u4f53\u89c6\u56fe[%1$s]\u90e8\u4ef6[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)var4_9.getPSDEViewBaseName(), (Object)var9_26.getPSVTCtrlName(), (Object)var10_28.getMessage()), var10_28);
                            }
                        }
                    }
                    if ((var8_24 = var2_2.getPSVTRVs()) != null) {
                        var9_26 = var8_24.iterator();
                        while (var9_26.hasNext()) {
                            var10_29 = (PSVTRV)var9_26.next();
                            if (!DataObject.getBoolValue((Integer)var10_29.getValidFlag(), (boolean)true) || !DataObject.getBoolValue((Integer)var10_29.getDefaultFlag(), (boolean)true)) continue;
                            try {
                                this.initDEViewRV(var6_18, var3_3, var2_2, var4_9, var10_29, null, null);
                            }
                            catch (Exception var11_32) {
                                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5b9e\u4f53\u89c6\u56fe[%1$s]\u89c6\u56fe\u5f15\u7528[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)var4_9.getPSDEViewBaseName(), (Object)var10_29.getPSVTRVName(), (Object)var11_32.getMessage()), var11_32);
                            }
                        }
                    }
                    var9_26 = new PSAppDEView();
                    var9_26.setPSDEViewBaseId(var4_9.getPSDEViewBaseId());
                    var9_26.setPSSysAppId(var1_1.getPSSysAppId());
                    var9_26.setPSAppModuleId(var1_1.getPSAppModuleId());
                    var9_26.setPSAppModuleName(var1_1.getPSAppModuleName());
                    var9_26.setSessionFactory(this.getSessionFactory());
                    try {
                        var9_26.create();
                    }
                    catch (Exception var10_30) {
                        throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)var4_9.getPSDEViewBaseName(), (Object)var10_30.getMessage()), var10_30);
                    }
                    var1_1.setPSAppViewId(var9_26.getPSAppViewId());
                    var1_1.setPSAppViewName(var9_26.getPSAppViewName());
                    this.update(var1_1);
                    break block23;
                }
                if (StringHelper.compare((String)var1_1.getPSAppViewType(), (String)"APPINDEXVIEW", (boolean)true) != 0) break block24;
                var3_4 = new PSAppMenu();
                var4_10 = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                var5_15 = 0;
                do lbl-1000:
                // 3 sources

                {
                    var6_19 = new PSAppMenu();
                    var6_19.setPSSysAppId(var1_1.getPSSysAppId());
                    var6_19.setPSAppMenuName(StringHelper.format((String)"%1$s%2$s", (Object)var1_1.getCodeName(), (Object)(++var5_15 == 1 ? "" : Integer.valueOf(var5_15))));
                    if (var4_10.select(var6_19, true)) ** GOTO lbl-1000
                    var3_4.setPSAppMenuName(var6_19.getPSAppMenuName());
                    var6_19.reset();
                    var6_19.setPSSysAppId(var1_1.getPSSysAppId());
                    var6_19.setCodeName(StringHelper.format((String)"%1$s%2$s", (Object)var1_1.getCodeName(), (Object)(var5_15 == 1 ? "" : Integer.valueOf(var5_15))));
                } while (var4_10.select(var6_19, true));
                var3_4.setCodeName(var6_19.getCodeName());
                var3_4.setPublicFlag(0);
                var3_4.setPSSysAppId(var1_1.getPSSysAppId());
                var3_4.setLogicName(StringHelper.format((String)"%1$s\u9ed8\u8ba4\u83dc\u5355", (Object)var1_1.getTitle()));
                var4_10.create(var3_4);
                var6_19 = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
                var7_22 = new PSAppIndexView();
                var7_22.setPSSysAppId(var1_1.getPSSysAppId());
                var7_22.setPSAppModuleId(var1_1.getPSAppModuleId());
                var7_22.setPSAppIndexViewName(var1_1.getCodeName());
                var7_22.setTitle(var1_1.getTitle());
                var7_22.setCaption(var1_1.getCaption());
                var7_22.setPSAppMenuId(var3_4.getPSAppMenuId());
                var7_22.setPSAppMenuName(var3_4.getPSAppMenuName());
                var6_19.create(var7_22);
                var3_4.reset();
                var3_4.setPSAppMenuId(var7_22.getPSAppMenuId());
                var3_4.setOwnerType("PSAPPINDEXVIEW");
                var3_4.setOwnerId(var7_22.getPSAppIndexViewId());
                var4_10.sysUpdate(var3_4, false);
                var1_1.setPSAppViewId(var7_22.getPSAppViewId());
                var1_1.setPSAppViewName(var7_22.getPSAppViewName());
                this.update(var1_1);
                break block23;
            }
            if (StringHelper.compare((String)var1_1.getPSAppViewType(), (String)"APPPORTALVIEW", (boolean)true) == 0) {
                var3_5 = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
                var4_11 = new PSAppPortalView();
                var4_11.setPSSysAppId(var1_1.getPSSysAppId());
                var4_11.setPSAppModuleId(var1_1.getPSAppModuleId());
                var4_11.setPSAppPortalViewName(var1_1.getCodeName());
                var4_11.setTitle(var1_1.getTitle());
                var4_11.setCaption(var1_1.getCaption());
                var4_11.setColModel("50%;50%");
                var4_11.setLayoutMode("TABLE_24COL");
                var3_5.create(var4_11);
                var1_1.setPSAppViewId(var4_11.getPSAppViewId());
                var1_1.setPSAppViewName(var4_11.getPSAppViewName());
                this.update(var1_1);
            } else if (StringHelper.compare((String)var1_1.getPSAppViewType(), (String)"APPPANELVIEW", (boolean)true) == 0) {
                var3_6 = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                var4_12 = new PSSysApp();
                var4_12.setPSSysAppId(var1_1.getPSSysAppId());
                var3_6.get((IEntity)var4_12);
                var5_16 = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                var6_20 = new PSAppType();
                var6_20.setPSAppTypeId(var4_12.getPSAppTypeId());
                var5_16.get((IEntity)var6_20);
                var7_23 = new PSSysViewPanel();
                var8_25 = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                var9_27 = 0;
                do {
                    var10_31 = new PSSysViewPanel();
                    var10_31.setPSSystemId(var4_12.getPSSystemId());
                    var10_31.setCodeName(StringHelper.format((String)"%1$s%2$s", (Object)var1_1.getCodeName(), (Object)(++var9_27 == 1 ? "" : Integer.valueOf(var9_27))));
                } while (var8_25.select(var10_31, true));
                var7_23.setCodeName(var10_31.getCodeName());
                var7_23.setViewLayoutFlag(0);
                var7_23.setPublicFlag(0);
                var7_23.setPSSysAppId(var4_12.getPSSysAppId());
                var7_23.setPSSysAppName(var4_12.getPSSysAppName());
                var7_23.setPSSystemId(var4_12.getPSSystemId());
                var7_23.setPSSystemName(var4_12.getPSSystemName());
                var7_23.setPSSysViewPanelName(StringHelper.format((String)"%1$s\u9ed8\u8ba4\u9762\u677f", (Object)var1_1.getTitle()));
                if (DataObject.getBoolValue((Integer)var6_20.getMobileMode(), (boolean)false)) {
                    var7_23.setMobFlag(1);
                } else {
                    var7_23.setMobFlag(0);
                }
                var7_23.setPublicFlag(0);
                var8_25.create(var7_23);
                var10_31 = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
                var11_33 = new PSAppPanelView();
                var11_33.setPSSysAppId(var1_1.getPSSysAppId());
                var11_33.setPSAppModuleId(var1_1.getPSAppModuleId());
                var11_33.setPSAppPanelViewName(var1_1.getCodeName());
                var11_33.setTitle(var1_1.getTitle());
                var11_33.setCaption(var1_1.getCaption());
                var11_33.setPSSysViewPanelId(var7_23.getPSSysViewPanelId());
                var11_33.setPSSysViewPanelName(var7_23.getPSSysViewPanelName());
                var10_31.create(var11_33);
                var7_23.reset();
                var7_23.setPSSysViewPanelId(var11_33.getPSSysViewPanelId());
                var7_23.setOwnerType("PSAPPPANELVIEW");
                var7_23.setOwnerId(var11_33.getPSAppPanelViewId());
                var8_25.sysUpdate(var7_23, false);
                var1_1.setPSAppViewId(var11_33.getPSAppViewId());
                var1_1.setPSAppViewName(var11_33.getPSAppViewName());
                this.update(var1_1);
            } else {
                var3_7 = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
                var4_13 = new PSAppUtilView();
                var4_13.setPSSysAppId(var1_1.getPSSysAppId());
                var4_13.setPSAppModuleId(var1_1.getPSAppModuleId());
                var4_13.setPSAppUtilViewName(var1_1.getCodeName());
                var4_13.setTitle(var1_1.getTitle());
                var4_13.setCaption(var1_1.getCaption());
                var4_13.setPSAppUtilViewType(var1_1.getPSAppViewType());
                var3_7.create(var4_13);
                var1_1.setPSAppViewId(var4_13.getPSAppViewId());
                var1_1.setPSAppViewName(var4_13.getPSAppViewName());
                this.update(var1_1);
            }
        }
    }

    protected void initDEViewRV(PSSystem pSSystem, PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct, PSDEViewBase pSDEViewBase, PSVTRV pSVTRV, String string, String string2) throws Exception {
        PSDEViewRV pSDEViewRV = new PSDEViewRV();
        pSDEViewRV.setMajorPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEViewRV.setMajorPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
        pSDEViewRV.setPSDEViewRVName(pSVTRV.getPSVTRVName());
        pSDEViewRV.setRefModeText(pSVTRV.getLogicName());
        pSDEViewRV.setMemo(pSVTRV.getMemo());
        pSDEViewRV.setDefViewType(pSVTRV.getDEFViewType());
        this.fillDEViewRV(pSDEViewRV, pSSystem, pSDataEntity, pSViewTypeStruct, pSDEViewBase, pSVTRV, string, string2);
        PSDEViewRVService pSDEViewRVService = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)this.getSessionFactory());
        pSDEViewRVService.create(pSDEViewRV);
    }

    protected void fillDEViewRV(PSDEViewRV pSDEViewRV, PSSystem pSSystem, PSDataEntity pSDataEntity, PSViewTypeStruct pSViewTypeStruct, PSDEViewBase pSDEViewBase, PSVTRV pSVTRV, String string, String string2) throws Exception {
        if (StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEGRIDVIEW", (boolean)true) == 0 || StringHelper.compare((String)pSViewTypeStruct.getPSViewTypeId(), (String)"DEMDCUSTOMVIEW", (boolean)true) == 0) {
            if (StringHelper.compare((String)pSVTRV.getPSVTRVName(), (String)"NEWDATA", (boolean)true) == 0) {
                String string3 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEEDITVIEW");
                pSDEViewRV.setMinorPSDEViewId(string3);
                return;
            }
            if (StringHelper.compare((String)pSVTRV.getPSVTRVName(), (String)"EDITDATA", (boolean)true) == 0) {
                String string4 = KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"DEEDITVIEW");
                pSDEViewRV.setMinorPSDEViewId(string4);
                return;
            }
        }
    }

    protected String getNextForm(PSUWAppView pSUWAppView) throws Exception {
        return "finish";
    }
}

