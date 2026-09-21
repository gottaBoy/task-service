/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppIndexViewService
extends PSAppIndexViewServiceBase {
    private static final Log log = LogFactory.getLog(PSAppIndexViewService.class);

    @Override
    protected void onChangeAppMenu(PSAppIndexView pSAppIndexView) throws Exception {
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
            pSAppIndexView.setPSAppMenuId(string2);
            pSAppIndexView.setPSAppMenuName(jSONObject.optString("psappmenuname"));
        }
    }

    @Override
    public void getWithModel(PSAppIndexView pSAppIndexView) throws Exception {
        this.getTempMajor(pSAppIndexView);
        String string = pSAppIndexView.getPSAppMenuId();
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSAppMenu pSAppMenu = new PSAppMenu();
            pSAppMenu.setPSAppMenuId(string);
            PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
            pSAppMenuService.getWithModel(pSAppMenu);
            pSAppIndexView.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
            pSAppIndexView.setMenuModel(pSAppMenu.getMenuModel());
            try {
                PSAppIndexView pSAppIndexView2 = new PSAppIndexView();
                pSAppIndexView2.setPSAppIndexViewId(pSAppIndexView.getPSAppIndexViewId());
                pSAppIndexView2.setPSAppMenuId(pSAppIndexView.getPSAppMenuId());
                this.sysUpdateTemp((IEntity)pSAppIndexView2, false);
            }
            catch (Exception exception) {
                log.error((Object)exception);
            }
        }
    }

    @Override
    public void updateWithModel(PSAppIndexView pSAppIndexView) throws Exception {
        final PSAppIndexView pSAppIndexView2 = pSAppIndexView;
        pSAppIndexView2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenu pSAppMenu = null;
                if (!StringHelper.isNullOrEmpty((String)pSAppIndexView2.getPSAppMenuId())) {
                    pSAppMenu = new PSAppMenu();
                    pSAppMenu.setPSAppMenuId(pSAppIndexView2.getPSAppMenuId());
                    pSAppMenu.setMenuModel(pSAppIndexView2.getMenuModel());
                    PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)PSAppIndexViewService.this.getSessionFactory());
                    pSAppMenuService.updateWithModel(pSAppMenu);
                }
                pSAppIndexView2.setMenuModel(null);
                PSAppIndexViewService.this.updateTempMajor(pSAppIndexView2);
                if (pSAppMenu != null) {
                    pSAppIndexView2.setMenuModel(pSAppMenu.getMenuModel());
                }
            }
        });
    }

    @Override
    public void createWithModel(PSAppIndexView pSAppIndexView) throws Exception {
        final PSAppIndexView pSAppIndexView2 = pSAppIndexView;
        pSAppIndexView2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            /*
             * Unable to fully structure code
             */
            public void execute(ITransaction var1_1) throws Exception {
                block7: {
                    block6: {
                        var2_2 = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)PSAppIndexViewService.this.getSessionFactory());
                        var3_3 = new PSAppMenu();
                        if (pSAppIndexView2.getPSSysApp() == null) break block6;
                        var4_4 = "";
                        var5_6 = 0;
                        do lbl-1000:
                        // 3 sources

                        {
                            var4_4 = StringHelper.format((String)"Default%1$s", (Object)(++var5_6 == 1 ? "" : Integer.valueOf(var5_6)));
                            var3_3.setPSSysAppId(pSAppIndexView2.getPSSysApp().getPSSysAppId());
                            var3_3.setPSAppMenuName((String)var4_4);
                            if (var2_2.select(var3_3, true)) ** GOTO lbl-1000
                            var3_3.reset();
                            var3_3.setPSSysAppId(pSAppIndexView2.getPSSysApp().getPSSysAppId());
                            var3_3.setCodeName((String)var4_4);
                        } while (var2_2.select(var3_3, true));
                        break block7;
                    }
                    throw new Exception(StringHelper.format((String)"\u5f53\u524d\u5e94\u7528\u7a0b\u5e8f\u5bf9\u8c61\u65e0\u6548"));
                }
                var3_3.setPSSysAppId(pSAppIndexView2.getPSSysApp().getPSSysAppId());
                var3_3.setCodeName((String)var4_4);
                var3_3.setPSAppMenuName((String)var4_4);
                if (!StringHelper.isNullOrEmpty((String)pSAppIndexView2.getTitle())) {
                    var3_3.setLogicName(pSAppIndexView2.getTitle());
                } else {
                    var3_3.setLogicName("\u5e94\u7528\u9996\u9875\u89c6\u56fe\u9ed8\u8ba4\u83dc\u5355");
                }
                var3_3.setPSAppMenuId(pSAppIndexView2.getPSAppMenuId());
                var3_3.setMenuModel(pSAppIndexView2.getMenuModel());
                var2_2.createWithModel(var3_3);
                pSAppIndexView2.set("SRFENTITYKEY", var3_3.get("SRFORIKEY"));
                pSAppIndexView2.setPSAppMenuId(DataObject.getStringValue((Object)var3_3.get("SRFORIKEY")));
                pSAppIndexView2.setMenuModel(null);
                PSAppIndexViewService.this.createTempMajor((IEntity)pSAppIndexView2);
                pSAppIndexView2.setPSAppMenuId(var3_3.getPSAppMenuId());
                pSAppIndexView2.setMenuModel(var3_3.getMenuModel());
                if (!StringHelper.isNullOrEmpty((String)pSAppIndexView2.getPSAppMenuId())) {
                    try {
                        var4_4 = new PSAppIndexView();
                        var4_4.setPSAppIndexViewId(pSAppIndexView2.getPSAppIndexViewId());
                        var4_4.setPSAppMenuId(pSAppIndexView2.getPSAppMenuId());
                        PSAppIndexViewService.this.sysUpdateTemp((IEntity)var4_4, false);
                    }
                    catch (Exception var4_5) {
                        PSAppIndexViewService.access$000().error((Object)var4_5);
                    }
                }
            }
        });
    }

    @Override
    public void previewSave(PSAppIndexView pSAppIndexView) throws Exception {
        final PSAppIndexView pSAppIndexView2 = pSAppIndexView;
        log.debug((Object)"\u5f00\u59cb[previewSave]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)PSAppIndexViewService.this.getSessionFactory());
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(pSAppIndexView2.getPSAppMenuId());
                pSAppMenuService.previewSave(pSAppMenu);
            }
        });
    }

    @Override
    public void getDraftWithModel(PSAppIndexView pSAppIndexView) throws Exception {
        this.getDraftTempMajor((IEntity)pSAppIndexView);
        this.fillPSAppIndexViewDefaultName(pSAppIndexView);
        PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
        PSAppMenu pSAppMenu = new PSAppMenu();
        pSAppMenu.setPSSysAppId(pSAppIndexView.getPSSysAppId());
        pSAppMenu.setPSSysAppName(pSAppIndexView.getPSSysAppName());
        pSAppMenuService.getDraftWithModel(pSAppMenu);
        pSAppIndexView.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
        pSAppIndexView.setMenuModel(pSAppMenu.getMenuModel());
        PSAppIndexView pSAppIndexView2 = pSAppIndexView;
        if (!StringHelper.isNullOrEmpty((String)pSAppIndexView2.getPSAppMenuId())) {
            try {
                PSAppIndexView pSAppIndexView3 = new PSAppIndexView();
                pSAppIndexView3.setPSAppIndexViewId(pSAppIndexView2.getPSAppIndexViewId());
                pSAppIndexView3.setPSAppMenuId(pSAppIndexView2.getPSAppMenuId());
                this.sysUpdateTemp((IEntity)pSAppIndexView3, false);
            }
            catch (Exception exception) {
                log.error((Object)exception);
            }
        }
    }

    @Override
    public void getDraftFromWithModel(PSAppIndexView pSAppIndexView) throws Exception {
        super.getDraftTempMajorFrom(pSAppIndexView);
        pSAppIndexView.resetPSAppIndexViewName();
        this.fillPSAppIndexViewDefaultName(pSAppIndexView);
        String string = pSAppIndexView.getPSAppMenuId();
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
            PSAppMenu pSAppMenu = new PSAppMenu();
            pSAppMenu.setPSAppMenuId(string);
            pSAppMenuService.getDraftFromWithModel(pSAppMenu);
            pSAppIndexView.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
            pSAppIndexView.setMenuModel(pSAppMenu.getMenuModel());
            PSAppIndexView pSAppIndexView2 = pSAppIndexView;
            try {
                PSAppIndexView pSAppIndexView3 = new PSAppIndexView();
                pSAppIndexView3.setPSAppIndexViewId(pSAppIndexView2.getPSAppIndexViewId());
                pSAppIndexView3.setPSAppMenuId(pSAppIndexView2.getPSAppMenuId());
                this.sysUpdateTemp((IEntity)pSAppIndexView3, false);
            }
            catch (Exception exception) {
                log.error((Object)exception);
            }
        }
    }

    @Override
    protected void onAfterRemove(PSAppIndexView pSAppIndexView) throws Exception {
        PSAppIndexView pSAppIndexView2 = (PSAppIndexView)this.getLast((IEntity)pSAppIndexView);
        if (!StringHelper.isNullOrEmpty((String)pSAppIndexView2.getPSAppMenuId())) {
            PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
            PSAppMenu pSAppMenu = new PSAppMenu();
            pSAppMenu.setPSAppMenuId(pSAppIndexView2.getPSAppMenuId());
            pSAppMenuService.remove((IEntity)pSAppMenu);
        }
        super.onAfterRemove(pSAppIndexView);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    protected void fillPSAppIndexViewDefaultName(PSAppIndexView pSAppIndexView) throws Exception {
        PSAppIndexView pSAppIndexView2;
        if (StringHelper.isNullOrEmpty((String)pSAppIndexView.getPSSysAppId()) || !StringHelper.isNullOrEmpty((String)pSAppIndexView.getPSAppIndexViewName())) {
            return;
        }
        int n = 0;
        String string = "AppIndexView";
        while (true) {
            pSAppIndexView2 = new PSAppIndexView();
            pSAppIndexView2.setPSSysAppId(pSAppIndexView.getPSSysAppId());
            pSAppIndexView2.setPSAppIndexViewName(StringHelper.format((String)"%1$s%2$s", (Object)string, (Object)(n == 0 ? "" : Integer.valueOf(n + 1))));
            if (!this.selectOne((IEntity)pSAppIndexView2, true)) break;
            ++n;
        }
        pSAppIndexView.setPSAppIndexViewName(pSAppIndexView2.getPSAppIndexViewName());
    }

    @Override
    public ObjectNode exportModelV2(PSAppIndexView pSAppIndexView) throws Exception {
        Object object;
        ObjectNode objectNode = null;
        if (pSAppIndexView.getPSAppMenu() != null) {
            object = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
            objectNode = ((PSCoreSysServiceBase)object).exportModelV2(pSAppIndexView.getPSAppMenu());
        }
        if ((object = super.exportModelV2(pSAppIndexView)) != null && objectNode != null) {
            object.put("psappmenu", (JsonNode)objectNode);
        }
        return object;
    }

    @Override
    public void importModelV2(PSAppIndexView pSAppIndexView, ObjectNode objectNode) throws Exception {
        final PSAppIndexView pSAppIndexView2 = pSAppIndexView;
        final ObjectNode objectNode2 = objectNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSAppIndexView pSAppIndexView;
                String string;
                ObjectNode objectNode = null;
                if (objectNode2.has("psappmenu") && (string = objectNode2.get("psappmenu")) instanceof ObjectNode) {
                    objectNode = (ObjectNode)string;
                }
                string = pSAppIndexView2.getPSAppIndexViewId();
                String string2 = null;
                if (!StringHelper.isNullOrEmpty((String)string)) {
                    pSAppIndexView = new PSAppIndexView();
                    pSAppIndexView.setPSAppIndexViewId(string);
                    PSAppIndexViewService.this.get((IEntity)pSAppIndexView);
                    if (!StringHelper.isNullOrEmpty((String)pSAppIndexView.getPSAppMenuId())) {
                        PSAppMenu pSAppMenu = new PSAppMenu();
                        pSAppMenu.setPSAppMenuId(pSAppIndexView.getPSAppMenuId());
                        pSAppMenu.setPSSysAppId(pSAppIndexView.getPSSysAppId());
                        PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)PSAppIndexViewService.this.getSessionFactory());
                        if (objectNode != null) {
                            pSAppMenuService.importModelV2(pSAppMenu, objectNode);
                        }
                        string2 = pSAppIndexView.getPSAppMenuId();
                    }
                }
                PSAppIndexViewService.this.superImportModelV2(pSAppIndexView2, objectNode2);
                if (!StringHelper.isNullOrEmpty(string2)) {
                    pSAppIndexView = new PSAppIndexView();
                    pSAppIndexView.setPSAppIndexViewId(string);
                    pSAppIndexView.setPSAppMenuId(string2);
                    PSAppIndexViewService.this.internalSysUpdate((IEntity)pSAppIndexView);
                    pSAppIndexView2.setPSAppMenuId(pSAppIndexView.getPSAppMenuId());
                    pSAppIndexView2.setPSAppMenuName(pSAppIndexView.getPSAppMenuName());
                }
            }
        }, true);
    }

    protected void superImportModelV2(PSAppIndexView pSAppIndexView, ObjectNode objectNode) throws Exception {
        super.importModelV2(pSAppIndexView, objectNode);
    }

    static /* synthetic */ Log access$000() {
        return log;
    }
}

