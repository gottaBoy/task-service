/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IInheritDEServiceProxy
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.appdesign.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IInheritDEServiceProxy;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDynaDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPanelView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDynaDEViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPanelViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortalViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppViewServiceProxyBase
extends PSAppViewService<PSAppView>
implements IInheritDEServiceProxy<PSAppView> {
    private static final Log log = LogFactory.getLog(PSAppViewServiceProxyBase.class);

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
        ServiceGlobal.registerService((String)(this.getServiceId() + "Proxy"), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSAppViewService";
    }

    public void remove(PSAppView pSAppView) throws Exception {
        if (pSAppView.getPSAppViewType() == null) {
            this.get(pSAppView);
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPDEVIEW", (boolean)true) == 0) {
            PSAppDEViewService pSAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppDEView pSAppDEView = new PSAppDEView();
            pSAppDEView.setPSAppDEViewId(pSAppView.getPSAppViewId());
            pSAppDEViewService.remove(pSAppDEView);
            return;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPDYNADEVIEW", (boolean)true) == 0) {
            PSAppDynaDEViewService pSAppDynaDEViewService = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppDynaDEView pSAppDynaDEView = new PSAppDynaDEView();
            pSAppDynaDEView.setPSAppDynaDEViewId(pSAppView.getPSAppViewId());
            pSAppDynaDEViewService.remove(pSAppDynaDEView);
            return;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPINDEXVIEW", (boolean)true) == 0) {
            PSAppIndexViewService pSAppIndexViewService = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppIndexView pSAppIndexView = new PSAppIndexView();
            pSAppIndexView.setPSAppIndexViewId(pSAppView.getPSAppViewId());
            pSAppIndexViewService.remove(pSAppIndexView);
            return;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPPANELVIEW", (boolean)true) == 0) {
            PSAppPanelViewService pSAppPanelViewService = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppPanelView pSAppPanelView = new PSAppPanelView();
            pSAppPanelView.setPSAppPanelViewId(pSAppView.getPSAppViewId());
            pSAppPanelViewService.remove(pSAppPanelView);
            return;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPPORTALVIEW", (boolean)true) == 0) {
            PSAppPortalViewService pSAppPortalViewService = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppPortalView pSAppPortalView = new PSAppPortalView();
            pSAppPortalView.setPSAppPortalViewId(pSAppView.getPSAppViewId());
            pSAppPortalViewService.remove(pSAppPortalView);
            return;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPUTILVIEW", (boolean)true) == 0) {
            PSAppUtilViewService pSAppUtilViewService = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppUtilView pSAppUtilView = new PSAppUtilView();
            pSAppUtilView.setPSAppUtilViewId(pSAppView.getPSAppViewId());
            pSAppUtilViewService.remove(pSAppUtilView);
            return;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSAppView.getPSAppViewType()));
    }

    public PSAppView getReal(PSAppView pSAppView, boolean bl) throws Exception {
        if (pSAppView.getPSAppViewType() == null && !this.get(pSAppView, bl)) {
            return null;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPDEVIEW", (boolean)true) == 0) {
            PSAppDEViewService pSAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppDEView pSAppDEView = new PSAppDEView();
            pSAppDEView.setPSAppDEViewId(pSAppView.getPSAppViewId());
            if (!pSAppDEViewService.get(pSAppDEView, bl)) {
                return null;
            }
            return pSAppDEView;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPDYNADEVIEW", (boolean)true) == 0) {
            PSAppDynaDEViewService pSAppDynaDEViewService = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppDynaDEView pSAppDynaDEView = new PSAppDynaDEView();
            pSAppDynaDEView.setPSAppDynaDEViewId(pSAppView.getPSAppViewId());
            if (!pSAppDynaDEViewService.get(pSAppDynaDEView, bl)) {
                return null;
            }
            return pSAppDynaDEView;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPINDEXVIEW", (boolean)true) == 0) {
            PSAppIndexViewService pSAppIndexViewService = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppIndexView pSAppIndexView = new PSAppIndexView();
            pSAppIndexView.setPSAppIndexViewId(pSAppView.getPSAppViewId());
            if (!pSAppIndexViewService.get(pSAppIndexView, bl)) {
                return null;
            }
            return pSAppIndexView;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPPANELVIEW", (boolean)true) == 0) {
            PSAppPanelViewService pSAppPanelViewService = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppPanelView pSAppPanelView = new PSAppPanelView();
            pSAppPanelView.setPSAppPanelViewId(pSAppView.getPSAppViewId());
            if (!pSAppPanelViewService.get(pSAppPanelView, bl)) {
                return null;
            }
            return pSAppPanelView;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPPORTALVIEW", (boolean)true) == 0) {
            PSAppPortalViewService pSAppPortalViewService = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppPortalView pSAppPortalView = new PSAppPortalView();
            pSAppPortalView.setPSAppPortalViewId(pSAppView.getPSAppViewId());
            if (!pSAppPortalViewService.get(pSAppPortalView, bl)) {
                return null;
            }
            return pSAppPortalView;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPUTILVIEW", (boolean)true) == 0) {
            PSAppUtilViewService pSAppUtilViewService = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppUtilView pSAppUtilView = new PSAppUtilView();
            pSAppUtilView.setPSAppUtilViewId(pSAppView.getPSAppViewId());
            if (!pSAppUtilViewService.get(pSAppUtilView, bl)) {
                return null;
            }
            return pSAppUtilView;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSAppView.getPSAppViewType()));
    }

    public IService getRealService(PSAppView pSAppView) throws Exception {
        if (pSAppView.getPSAppViewType() == null) {
            this.get(pSAppView);
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPDEVIEW", (boolean)true) == 0) {
            PSAppDEViewService pSAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
            return pSAppDEViewService;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPDYNADEVIEW", (boolean)true) == 0) {
            PSAppDynaDEViewService pSAppDynaDEViewService = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
            return pSAppDynaDEViewService;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPINDEXVIEW", (boolean)true) == 0) {
            PSAppIndexViewService pSAppIndexViewService = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
            return pSAppIndexViewService;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPPANELVIEW", (boolean)true) == 0) {
            PSAppPanelViewService pSAppPanelViewService = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
            return pSAppPanelViewService;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPPORTALVIEW", (boolean)true) == 0) {
            PSAppPortalViewService pSAppPortalViewService = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
            return pSAppPortalViewService;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPUTILVIEW", (boolean)true) == 0) {
            PSAppUtilViewService pSAppUtilViewService = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
            return pSAppUtilViewService;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSAppView.getPSAppViewType()));
    }

    protected void onExportCurModel(PSAppView pSAppView, ArrayList<JSONObject> arrayList) throws Exception {
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPDEVIEW", (boolean)true) == 0) {
            PSAppDEViewService pSAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppDEView pSAppDEView = new PSAppDEView();
            pSAppDEView.setPSAppDEViewId(pSAppView.getPSAppViewId());
            pSAppDEViewService.exportModel(pSAppDEView, arrayList);
            return;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPDYNADEVIEW", (boolean)true) == 0) {
            PSAppDynaDEViewService pSAppDynaDEViewService = (PSAppDynaDEViewService)ServiceGlobal.getService(PSAppDynaDEViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppDynaDEView pSAppDynaDEView = new PSAppDynaDEView();
            pSAppDynaDEView.setPSAppDynaDEViewId(pSAppView.getPSAppViewId());
            pSAppDynaDEViewService.exportModel(pSAppDynaDEView, arrayList);
            return;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPINDEXVIEW", (boolean)true) == 0) {
            PSAppIndexViewService pSAppIndexViewService = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppIndexView pSAppIndexView = new PSAppIndexView();
            pSAppIndexView.setPSAppIndexViewId(pSAppView.getPSAppViewId());
            pSAppIndexViewService.exportModel(pSAppIndexView, arrayList);
            return;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPPANELVIEW", (boolean)true) == 0) {
            PSAppPanelViewService pSAppPanelViewService = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppPanelView pSAppPanelView = new PSAppPanelView();
            pSAppPanelView.setPSAppPanelViewId(pSAppView.getPSAppViewId());
            pSAppPanelViewService.exportModel(pSAppPanelView, arrayList);
            return;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPPORTALVIEW", (boolean)true) == 0) {
            PSAppPortalViewService pSAppPortalViewService = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppPortalView pSAppPortalView = new PSAppPortalView();
            pSAppPortalView.setPSAppPortalViewId(pSAppView.getPSAppViewId());
            pSAppPortalViewService.exportModel(pSAppPortalView, arrayList);
            return;
        }
        if (StringHelper.compare((String)pSAppView.getPSAppViewType(), (String)"APPUTILVIEW", (boolean)true) == 0) {
            PSAppUtilViewService pSAppUtilViewService = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, (SessionFactory)this.getSessionFactory());
            PSAppUtilView pSAppUtilView = new PSAppUtilView();
            pSAppUtilView.setPSAppUtilViewId(pSAppView.getPSAppViewId());
            pSAppUtilViewService.exportModel(pSAppUtilView, arrayList);
            return;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSAppView.getPSAppViewType()));
    }
}

