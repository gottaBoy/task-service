/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNode;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFunc;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnMSDepAppService
extends PSDevSlnMSDepAppServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepAppService.class);

    @Override
    protected void onBeforeCreate(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        String string;
        if (StringHelper.isNullOrEmpty((String)pSDevSlnMSDepApp.getPSDevSlnSysId())) {
            pSDevSlnMSDepApp.setPSDevSlnSysAppId(null);
            pSDevSlnMSDepApp.setPSDevSlnSysAppName(null);
        }
        if (!StringHelper.isNullOrEmpty((String)(string = pSDevSlnMSDepApp.getPSDCMSPlatformNodeId()))) {
            this.checkPSDCMSPlatformNode(string, pSDevSlnMSDepApp, false);
        }
        super.onBeforeCreate(pSDevSlnMSDepApp);
    }

    @Override
    protected void onBeforeUpdate(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        String string;
        PSDevSlnMSDepApp pSDevSlnMSDepApp2 = (PSDevSlnMSDepApp)this.getLast(pSDevSlnMSDepApp);
        if (!pSDevSlnMSDepApp.isPSDCMSPlatformNodeIdDirty()) {
            pSDevSlnMSDepApp.setPSDCMSPlatformNodeId(pSDevSlnMSDepApp2.getPSDCMSPlatformNodeId());
            pSDevSlnMSDepApp.setPSDCMSPlatformNodeName(pSDevSlnMSDepApp2.getPSDCMSPlatformNodeName());
        }
        if (!pSDevSlnMSDepApp.isPSDevSlnSysIdDirty()) {
            pSDevSlnMSDepApp.setPSDevSlnSysId(pSDevSlnMSDepApp2.getPSDevSlnSysId());
            pSDevSlnMSDepApp.setPSDevSlnSysName(pSDevSlnMSDepApp2.getPSDevSlnSysName());
        }
        if (!pSDevSlnMSDepApp.isPSDevSlnSysAppIdDirty()) {
            pSDevSlnMSDepApp.setPSDevSlnSysAppId(pSDevSlnMSDepApp2.getPSDevSlnSysAppId());
            pSDevSlnMSDepApp.setPSDevSlnSysAppName(pSDevSlnMSDepApp2.getPSDevSlnSysAppName());
        }
        if (StringHelper.isNullOrEmpty((String)pSDevSlnMSDepApp.getPSDevSlnSysId())) {
            pSDevSlnMSDepApp.setPSDevSlnSysAppId(null);
            pSDevSlnMSDepApp.setPSDevSlnSysAppName(null);
        }
        if (!StringHelper.isNullOrEmpty((String)(string = pSDevSlnMSDepApp.getPSDCMSPlatformNodeId()))) {
            this.checkPSDCMSPlatformNode(string, pSDevSlnMSDepApp, true);
        }
        super.onBeforeUpdate(pSDevSlnMSDepApp);
    }

    protected void checkPSDCMSPlatformNode(String string, PSDevSlnMSDepApp pSDevSlnMSDepApp, boolean bl) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDevSlnMSDepApp.getPSDevSlnSysId()) || StringHelper.isNullOrEmpty((String)pSDevSlnMSDepApp.getPSDevSlnSysAppId())) {
            return;
        }
        PSDCMSPlatformNodeService pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
        PSDCMSPlatformNode pSDCMSPlatformNode = new PSDCMSPlatformNode();
        pSDCMSPlatformNode.setPSDCMSPlatformNodeId(string);
        if (!pSDCMSPlatformNodeService.get(pSDCMSPlatformNode, true)) {
            throw new Exception(String.format("\u4f20\u5165Cloud\u670d\u52a1\u65e0\u6548", new Object[0]));
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDCMSPLATFORMNODEID", (Object)string);
        PSDevSlnMSDepFuncService pSDevSlnMSDepFuncService = (PSDevSlnMSDepFuncService)ServiceGlobal.getService(PSDevSlnMSDepFuncService.class, (SessionFactory)this.getSessionFactory());
        ArrayList arrayList = pSDevSlnMSDepFuncService.select((ISelectCond)selectCond);
        if (arrayList != null && arrayList.size() > 0) {
            throw new Exception(String.format("Cloud\u670d\u52a1[%1$s]\u5df2\u7ecf\u88ab\u529f\u80fd[%2$s]\u4f7f\u7528", pSDCMSPlatformNode.getPSDCMSPlatformNodeName(), ((PSDevSlnMSDepFunc)arrayList.get(0)).getPSDevSlnMSDepFuncName()));
        }
        PSDevSlnMSDepAPIService pSDevSlnMSDepAPIService = (PSDevSlnMSDepAPIService)ServiceGlobal.getService(PSDevSlnMSDepAPIService.class, (SessionFactory)this.getSessionFactory());
        ArrayList arrayList2 = pSDevSlnMSDepAPIService.select((ISelectCond)selectCond);
        if (arrayList2 != null && arrayList2.size() > 0) {
            PSDevSlnMSDepAPI pSDevSlnMSDepAPI = (PSDevSlnMSDepAPI)arrayList2.get(0);
            throw new Exception(String.format("Cloud\u670d\u52a1[%1$s]\u5df2\u7ecf\u88ab\u670d\u52a1\u63a5\u53e3[%2$s@%3$s]\u4f7f\u7528", pSDCMSPlatformNode.getPSDCMSPlatformNodeName(), pSDevSlnMSDepAPI.getPSDevSlnSysAPIName(), pSDevSlnMSDepAPI.getPSDevSlnSysName()));
        }
        PSDevSlnMSDepAppService pSDevSlnMSDepAppService = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnMSDepApp> arrayList3 = pSDevSlnMSDepAppService.select((ISelectCond)selectCond);
        if (arrayList3 != null && arrayList3.size() > 0) {
            for (PSDevSlnMSDepApp pSDevSlnMSDepApp2 : arrayList3) {
                if (StringHelper.compare((String)pSDevSlnMSDepApp2.getPSDevSlnMSDepAppId(), (String)pSDevSlnMSDepApp.getPSDevSlnMSDepAppId(), (boolean)false) == 0) continue;
                if (StringHelper.compare((String)pSDevSlnMSDepApp2.getPSDevSlnSysId(), (String)pSDevSlnMSDepApp.getPSDevSlnSysId(), (boolean)false) != 0) {
                    throw new Exception(String.format("Cloud\u670d\u52a1[%1$s]\u5df2\u7ecf\u88ab\u524d\u7aef\u5e94\u7528[%2$s@%3$s]\u4f7f\u7528", pSDCMSPlatformNode.getPSDCMSPlatformNodeName(), pSDevSlnMSDepApp2.getPSDevSlnSysAppName(), pSDevSlnMSDepApp2.getPSDevSlnSysName()));
                }
                if (StringHelper.compare((String)pSDevSlnMSDepApp2.getPSDevSlnMSDepAppId(), (String)pSDevSlnMSDepApp.getPSDevSlnMSDepAppId(), (boolean)false) == 0) continue;
                throw new Exception(String.format("Cloud\u670d\u52a1[%1$s]\u91cd\u590d\u7ed1\u5b9a\u524d\u7aef\u5e94\u7528[%2$s@%3$s]", pSDCMSPlatformNode.getPSDCMSPlatformNodeName(), pSDevSlnMSDepApp2.getPSDevSlnSysAppName(), pSDevSlnMSDepApp2.getPSDevSlnSysName()));
            }
        }
    }

    @Override
    protected void onAfterCreate(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        String string = pSDevSlnMSDepApp.getPSDCMSPlatformNodeId();
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSDCMSPlatformNodeService pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
            PSDCMSPlatformNode pSDCMSPlatformNode = new PSDCMSPlatformNode();
            pSDCMSPlatformNode.setPSDCMSPlatformNodeId(string);
            pSDCMSPlatformNodeService.calcRefInfo(pSDCMSPlatformNode);
        }
        super.onAfterCreate(pSDevSlnMSDepApp);
    }

    @Override
    protected void onAfterUpdate(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        PSDevSlnMSDepApp pSDevSlnMSDepApp2 = (PSDevSlnMSDepApp)this.getLast(pSDevSlnMSDepApp);
        String string = pSDevSlnMSDepApp.getPSDCMSPlatformNodeId();
        String string2 = pSDevSlnMSDepApp2.getPSDCMSPlatformNodeId();
        if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) {
            PSDCMSPlatformNode pSDCMSPlatformNode;
            PSDCMSPlatformNodeService pSDCMSPlatformNodeService;
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
                pSDCMSPlatformNode = new PSDCMSPlatformNode();
                pSDCMSPlatformNode.setPSDCMSPlatformNodeId(string2);
                pSDCMSPlatformNodeService.calcRefInfo(pSDCMSPlatformNode);
            }
            if (!StringHelper.isNullOrEmpty((String)string)) {
                pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
                pSDCMSPlatformNode = new PSDCMSPlatformNode();
                pSDCMSPlatformNode.setPSDCMSPlatformNodeId(string);
                pSDCMSPlatformNodeService.calcRefInfo(pSDCMSPlatformNode);
            }
        }
        super.onAfterUpdate(pSDevSlnMSDepApp);
    }

    @Override
    protected void onBeforeRemove(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        PSDevSlnMSDepApp pSDevSlnMSDepApp2 = (PSDevSlnMSDepApp)this.getLast(pSDevSlnMSDepApp);
        super.onBeforeRemove(pSDevSlnMSDepApp);
    }

    @Override
    protected void onAfterRemove(PSDevSlnMSDepApp pSDevSlnMSDepApp) throws Exception {
        String string;
        PSDevSlnMSDepApp pSDevSlnMSDepApp2 = (PSDevSlnMSDepApp)this.getLast(pSDevSlnMSDepApp);
        if (pSDevSlnMSDepApp2 != null && !StringHelper.isNullOrEmpty((String)(string = pSDevSlnMSDepApp2.getPSDCMSPlatformNodeId()))) {
            PSDCMSPlatformNodeService pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
            PSDCMSPlatformNode pSDCMSPlatformNode = new PSDCMSPlatformNode();
            pSDCMSPlatformNode.setPSDCMSPlatformNodeId(string);
            pSDCMSPlatformNodeService.calcRefInfo(pSDCMSPlatformNode);
        }
        super.onAfterRemove(pSDevSlnMSDepApp);
    }
}

