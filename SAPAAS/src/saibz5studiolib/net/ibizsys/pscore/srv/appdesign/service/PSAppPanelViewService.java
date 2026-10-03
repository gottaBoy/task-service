/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPanelView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPanelViewBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPanelViewServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppPanelViewService
extends PSAppPanelViewServiceBase {
    private static final Log log = LogFactory.getLog(PSAppPanelViewService.class);
    protected static final String ATTR_PANELMODEL = "panelmodel";

    @Override
    public void getWithModel(PSAppPanelView pSAppPanelView) throws Exception {
        this.getTempMajor(pSAppPanelView);
        String string = pSAppPanelView.getPSSysViewPanelId();
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
            pSSysViewPanel.setPSSysViewPanelId(string);
            PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
            pSSysViewPanelService.getWithModel(pSSysViewPanel);
            pSAppPanelView.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
            pSAppPanelView.set(ATTR_PANELMODEL, pSSysViewPanel.getPanelModel());
            PSAppPanelView pSAppPanelView2 = new PSAppPanelView();
            pSAppPanelView2.setPSAppPanelViewId(pSAppPanelView.getPSAppPanelViewId());
            pSAppPanelView2.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
            this.sysUpdateTemp(pSAppPanelView2, false);
        }
    }

    @Override
    public void updateWithModel(PSAppPanelView pSAppPanelView) throws Exception {
        final PSAppPanelView pSAppPanelView2 = pSAppPanelView;
        pSAppPanelView2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanel pSSysViewPanel = null;
                if (!StringHelper.isNullOrEmpty((String)pSAppPanelView2.getPSSysViewPanelId())) {
                    pSSysViewPanel = new PSSysViewPanel();
                    pSSysViewPanel.setPSSysViewPanelId(pSAppPanelView2.getPSSysViewPanelId());
                    pSSysViewPanel.setPanelModel(DataObject.getStringValue((Object)pSAppPanelView2.get(PSAppPanelViewService.ATTR_PANELMODEL)));
                    PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)PSAppPanelViewService.this.getSessionFactory());
                    pSSysViewPanelService.updateWithModel(pSSysViewPanel);
                }
                pSAppPanelView2.set(PSAppPanelViewService.ATTR_PANELMODEL, null);
                PSAppPanelViewService.this.updateTempMajor(pSAppPanelView2);
                if (pSSysViewPanel != null) {
                    pSAppPanelView2.set(PSAppPanelViewService.ATTR_PANELMODEL, pSSysViewPanel.getPanelModel());
                }
            }
        });
    }

    @Override
    public void createWithModel(PSAppPanelView pSAppPanelView) throws Exception {
        final PSAppPanelView pSAppPanelView2 = pSAppPanelView;
        pSAppPanelView2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)PSAppPanelViewService.this.getSessionFactory());
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                if (pSAppPanelView2.getPSSysApp() != null) {
                    pSSysViewPanel.setPSSysAppId(pSAppPanelView2.getPSSysApp().getPSSysAppId());
                    pSSysViewPanel.setPSSystemId(pSAppPanelView2.getPSSysApp().getPSSystemId());
                }
                if (!StringHelper.isNullOrEmpty((String)pSAppPanelView2.getTitle())) {
                    pSSysViewPanel.setPSSysViewPanelName(pSAppPanelView2.getTitle());
                } else {
                    pSSysViewPanel.setPSSysViewPanelName("\u5e94\u7528\u9762\u677f\u89c6\u56fe\u9ed8\u8ba4\u9762\u677f");
                }
                pSSysViewPanel.setViewLayoutFlag(0);
                pSSysViewPanel.setPublicFlag(0);
                pSSysViewPanel.setPSSysViewPanelId(pSAppPanelView2.getPSSysViewPanelId());
                pSSysViewPanel.setPanelModel(DataObject.getStringValue((Object)pSAppPanelView2.get(PSAppPanelViewService.ATTR_PANELMODEL)));
                pSSysViewPanelService.createWithModel(pSSysViewPanel);
                String string = DataObject.getStringValue((Object)pSSysViewPanel.get("SRFORIKEY"));
                String string2 = pSSysViewPanel.getPSSysViewPanelId();
                pSAppPanelView2.set("SRFENTITYKEY", string);
                pSAppPanelView2.setPSSysViewPanelId(string);
                pSAppPanelView2.set(PSAppPanelViewService.ATTR_PANELMODEL, null);
                PSAppPanelViewService.this.createTempMajor(pSAppPanelView2);
                pSAppPanelView2.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
                pSAppPanelView2.set(PSAppPanelViewService.ATTR_PANELMODEL, pSSysViewPanel.getPanelModel());
                PSAppPanelView pSAppPanelView = new PSAppPanelView();
                pSAppPanelView.setPSAppPanelViewId(pSAppPanelView2.getPSAppPanelViewId());
                pSAppPanelView.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
                PSAppPanelViewService.this.sysUpdateTemp(pSAppPanelView, false);
                String string3 = DataObject.getStringValue((Object)pSAppPanelView2.get("SRFORIKEY"));
                pSSysViewPanel.reset();
                pSSysViewPanel.setOwnerId(string3);
                pSSysViewPanel.setOwnerType("PSAPPPANELVIEW");
                pSSysViewPanel.setPSSysViewPanelId(string);
                pSSysViewPanelService.sysUpdate(pSSysViewPanel, false);
                pSSysViewPanel.reset();
                pSSysViewPanel.setOwnerId(string3);
                pSSysViewPanel.setOwnerType("PSAPPPANELVIEW");
                pSSysViewPanel.setPSSysViewPanelId(string2);
                pSSysViewPanelService.sysUpdateTemp(pSSysViewPanel, false);
            }
        });
    }

    @Override
    public void previewSave(PSAppPanelView pSAppPanelView) throws Exception {
        final PSAppPanelView pSAppPanelView2 = pSAppPanelView;
        log.debug((Object)"\u5f00\u59cb[previewSave]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)PSAppPanelViewService.this.getSessionFactory());
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(pSAppPanelView2.getPSSysViewPanelId());
                pSSysViewPanelService.previewSave(pSSysViewPanel);
            }
        });
    }

    @Override
    public void getDraftWithModel(PSAppPanelView pSAppPanelView) throws Exception {
        this.getDraftTempMajor(pSAppPanelView);
        this.fillPSAppPanelViewDefaultName(pSAppPanelView);
        PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
        if (pSAppPanelView.getPSSysApp() != null) {
            pSSysViewPanel.setPSSysAppId(pSAppPanelView.getPSSysApp().getPSSysAppId());
            pSSysViewPanel.setPSSysAppName(pSAppPanelView.getPSSysApp().getPSSysAppName());
            pSSysViewPanel.setPSSystemId(pSAppPanelView.getPSSysApp().getPSSystemId());
            pSSysViewPanel.setPSSystemName(pSAppPanelView.getPSSysApp().getPSSystemName());
            if (!StringHelper.isNullOrEmpty((String)pSAppPanelView.getPSSysApp().getPSAppTypeId())) {
                PSAppTypeService appTypeService = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                PSAppType pSAppType = new PSAppType();
                pSAppType.setPSAppTypeId(pSAppPanelView.getPSSysApp().getPSAppTypeId());
                appTypeService.get(pSAppType);
                if (DataObject.getBoolValue((Integer)pSAppType.getMobileMode(), (boolean)false)) {
                    pSSysViewPanel.setMobFlag(1);
                } else {
                    pSSysViewPanel.setMobFlag(0);
                }
            }
        }
        pSSysViewPanel.setViewLayoutFlag(0);
        pSSysViewPanel.setPublicFlag(0);
        pSSysViewPanelService.getDraftWithModel(pSSysViewPanel);
        pSAppPanelView.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSAppPanelView.set(ATTR_PANELMODEL, pSSysViewPanel.getPanelModel());
        PSAppPanelView updatedView = new PSAppPanelView();
        updatedView.setPSAppPanelViewId(pSAppPanelView.getPSAppPanelViewId());
        updatedView.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        this.sysUpdateTemp(updatedView, false);
    }

    @Override
    public void getDraftFromWithModel(PSAppPanelView pSAppPanelView) throws Exception {
        super.getDraftTempMajorFrom(pSAppPanelView);
        pSAppPanelView.resetPSAppPanelViewName();
        this.fillPSAppPanelViewDefaultName(pSAppPanelView);
        String string = pSAppPanelView.getPSSysViewPanelId();
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
            pSSysViewPanel.setPSSysViewPanelId(string);
            pSSysViewPanelService.getDraftFromWithModel(pSSysViewPanel);
            pSAppPanelView.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
            pSAppPanelView.set(ATTR_PANELMODEL, pSSysViewPanel.getPanelModel());
            PSAppPanelView pSAppPanelView2 = new PSAppPanelView();
            pSAppPanelView2.setPSAppPanelViewId(pSAppPanelView.getPSAppPanelViewId());
            pSAppPanelView2.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
            this.sysUpdateTemp(pSAppPanelView2, false);
        }
    }

    @Override
    protected void onAfterRemove(PSAppPanelView pSAppPanelView) throws Exception {
        PSAppPanelView pSAppPanelView2 = (PSAppPanelView)this.getLast(pSAppPanelView);
        if (!StringHelper.isNullOrEmpty((String)pSAppPanelView2.getPSSysViewPanelId())) {
            PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
            pSSysViewPanel.setPSSysViewPanelId(pSAppPanelView2.getPSSysViewPanelId());
            pSSysViewPanelService.remove(pSSysViewPanel);
        }
        super.onAfterRemove(pSAppPanelView);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    protected void fillPSAppPanelViewDefaultName(PSAppPanelView pSAppPanelView) throws Exception {
        PSAppPanelView pSAppPanelView2;
        if (StringHelper.isNullOrEmpty((String)pSAppPanelView.getPSSysAppId()) || !StringHelper.isNullOrEmpty((String)pSAppPanelView.getPSAppPanelViewName())) {
            return;
        }
        int n = 0;
        String string = "AppPanelView";
        while (true) {
            pSAppPanelView2 = new PSAppPanelView();
            pSAppPanelView2.setPSSysAppId(pSAppPanelView.getPSSysAppId());
            pSAppPanelView2.setPSAppPanelViewName(StringHelper.format((String)"%1$s%2$s", (Object)string, (Object)(n == 0 ? "" : Integer.valueOf(n + 1))));
            if (!this.selectOne(pSAppPanelView2, true)) break;
            ++n;
        }
        pSAppPanelView.setPSAppPanelViewName(pSAppPanelView2.getPSAppPanelViewName());
    }
}
