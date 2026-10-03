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
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnMSDepAPIService
extends PSDevSlnMSDepAPIServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepAPIService.class);

    @Override
    protected void onBeforeCreate(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        String string;
        if (StringHelper.isNullOrEmpty((String)pSDevSlnMSDepAPI.getPSDevSlnSysId())) {
            pSDevSlnMSDepAPI.setPSDevSlnSysAPIId(null);
            pSDevSlnMSDepAPI.setPSDevSlnSysAPIName(null);
        }
        if (!StringHelper.isNullOrEmpty((String)(string = pSDevSlnMSDepAPI.getPSDCMSPlatformNodeId()))) {
            this.checkPSDCMSPlatformNode(string, pSDevSlnMSDepAPI, false);
        }
        super.onBeforeCreate(pSDevSlnMSDepAPI);
    }

    @Override
    protected void onBeforeUpdate(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        String string;
        PSDevSlnMSDepAPI pSDevSlnMSDepAPI2 = (PSDevSlnMSDepAPI)this.getLast(pSDevSlnMSDepAPI);
        if (!pSDevSlnMSDepAPI.isPSDCMSPlatformNodeIdDirty()) {
            pSDevSlnMSDepAPI.setPSDCMSPlatformNodeId(pSDevSlnMSDepAPI2.getPSDCMSPlatformNodeId());
            pSDevSlnMSDepAPI.setPSDCMSPlatformNodeName(pSDevSlnMSDepAPI2.getPSDCMSPlatformNodeName());
        }
        if (!pSDevSlnMSDepAPI.isPSDevSlnSysIdDirty()) {
            pSDevSlnMSDepAPI.setPSDevSlnSysId(pSDevSlnMSDepAPI2.getPSDevSlnSysId());
            pSDevSlnMSDepAPI.setPSDevSlnSysName(pSDevSlnMSDepAPI2.getPSDevSlnSysName());
        }
        if (!pSDevSlnMSDepAPI.isPSDevSlnSysAPIIdDirty()) {
            pSDevSlnMSDepAPI.setPSDevSlnSysAPIId(pSDevSlnMSDepAPI2.getPSDevSlnSysAPIId());
            pSDevSlnMSDepAPI.setPSDevSlnSysAPIName(pSDevSlnMSDepAPI2.getPSDevSlnSysAPIName());
        }
        if (StringHelper.isNullOrEmpty((String)pSDevSlnMSDepAPI.getPSDevSlnSysId())) {
            pSDevSlnMSDepAPI.setPSDevSlnSysAPIId(null);
            pSDevSlnMSDepAPI.setPSDevSlnSysAPIName(null);
        }
        if (!StringHelper.isNullOrEmpty((String)(string = pSDevSlnMSDepAPI.getPSDCMSPlatformNodeId()))) {
            this.checkPSDCMSPlatformNode(string, pSDevSlnMSDepAPI, true);
        }
        super.onBeforeUpdate(pSDevSlnMSDepAPI);
    }

    protected void checkPSDCMSPlatformNode(String string, PSDevSlnMSDepAPI pSDevSlnMSDepAPI, boolean bl) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDevSlnMSDepAPI.getPSDevSlnSysId()) || StringHelper.isNullOrEmpty((String)pSDevSlnMSDepAPI.getPSDevSlnSysAPIId())) {
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
        PSDevSlnMSDepAppService pSDevSlnMSDepAppService = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, (SessionFactory)this.getSessionFactory());
        ArrayList arrayList2 = pSDevSlnMSDepAppService.select((ISelectCond)selectCond);
        if (arrayList2 != null && arrayList2.size() > 0) {
            throw new Exception(String.format("Cloud\u670d\u52a1[%1$s]\u5df2\u7ecf\u88ab\u524d\u7aef\u5e94\u7528[%2$s@%3$s]\u4f7f\u7528", pSDCMSPlatformNode.getPSDCMSPlatformNodeName(), ((PSDevSlnMSDepApp)arrayList2.get(0)).getPSDevSlnSysAppName(), ((PSDevSlnMSDepApp)arrayList2.get(0)).getPSDevSlnSysName()));
        }
        PSDevSlnMSDepAPIService pSDevSlnMSDepAPIService = (PSDevSlnMSDepAPIService)ServiceGlobal.getService(PSDevSlnMSDepAPIService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnMSDepAPI> arrayList3 = pSDevSlnMSDepAPIService.select((ISelectCond)selectCond);
        if (arrayList3 != null) {
            for (PSDevSlnMSDepAPI pSDevSlnMSDepAPI2 : arrayList3) {
                if (StringHelper.compare((String)pSDevSlnMSDepAPI2.getPSDevSlnMSDepAPIId(), (String)pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIId(), (boolean)false) == 0) continue;
                if (StringHelper.compare((String)pSDevSlnMSDepAPI2.getPSDevSlnSysId(), (String)pSDevSlnMSDepAPI.getPSDevSlnSysId(), (boolean)false) != 0) {
                    throw new Exception(String.format("Cloud\u670d\u52a1[%1$s]\u5df2\u7ecf\u88ab\u670d\u52a1\u63a5\u53e3[%2$s@%3$s]\u4f7f\u7528", pSDCMSPlatformNode.getPSDCMSPlatformNodeName(), pSDevSlnMSDepAPI2.getPSDevSlnSysAPIName(), pSDevSlnMSDepAPI2.getPSDevSlnSysName()));
                }
                if (StringHelper.compare((String)pSDevSlnMSDepAPI2.getPSDevSlnSysAPIId(), (String)pSDevSlnMSDepAPI.getPSDevSlnSysAPIId(), (boolean)false) != 0 || StringHelper.compare((String)pSDevSlnMSDepAPI2.getPSDevSlnMSDepAPIId(), (String)pSDevSlnMSDepAPI.getPSDevSlnMSDepAPIId(), (boolean)false) == 0) continue;
                throw new Exception(String.format("Cloud\u670d\u52a1[%1$s]\u91cd\u590d\u7ed1\u5b9a\u670d\u52a1\u63a5\u53e3[%2$s@%3$s]", pSDCMSPlatformNode.getPSDCMSPlatformNodeName(), pSDevSlnMSDepAPI2.getPSDevSlnSysAPIName(), pSDevSlnMSDepAPI2.getPSDevSlnSysName()));
            }
        }
    }

    @Override
    protected void onAfterCreate(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        String string = pSDevSlnMSDepAPI.getPSDCMSPlatformNodeId();
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSDCMSPlatformNodeService pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
            PSDCMSPlatformNode pSDCMSPlatformNode = new PSDCMSPlatformNode();
            pSDCMSPlatformNode.setPSDCMSPlatformNodeId(string);
            pSDCMSPlatformNodeService.calcRefInfo(pSDCMSPlatformNode);
        }
        super.onAfterCreate(pSDevSlnMSDepAPI);
    }

    @Override
    protected void onAfterUpdate(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        PSDevSlnMSDepAPI pSDevSlnMSDepAPI2 = (PSDevSlnMSDepAPI)this.getLast(pSDevSlnMSDepAPI);
        String string = pSDevSlnMSDepAPI.getPSDCMSPlatformNodeId();
        String string2 = pSDevSlnMSDepAPI2.getPSDCMSPlatformNodeId();
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
        super.onAfterUpdate(pSDevSlnMSDepAPI);
    }

    @Override
    protected void onBeforeRemove(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        PSDevSlnMSDepAPI pSDevSlnMSDepAPI2 = (PSDevSlnMSDepAPI)this.getLast(pSDevSlnMSDepAPI);
        super.onBeforeRemove(pSDevSlnMSDepAPI);
    }

    @Override
    protected void onAfterRemove(PSDevSlnMSDepAPI pSDevSlnMSDepAPI) throws Exception {
        String string;
        PSDevSlnMSDepAPI pSDevSlnMSDepAPI2 = (PSDevSlnMSDepAPI)this.getLast(pSDevSlnMSDepAPI);
        if (pSDevSlnMSDepAPI2 != null && !StringHelper.isNullOrEmpty((String)(string = pSDevSlnMSDepAPI2.getPSDCMSPlatformNodeId()))) {
            PSDCMSPlatformNodeService pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
            PSDCMSPlatformNode pSDCMSPlatformNode = new PSDCMSPlatformNode();
            pSDCMSPlatformNode.setPSDCMSPlatformNodeId(string);
            pSDCMSPlatformNodeService.calcRefInfo(pSDCMSPlatformNode);
        }
        super.onAfterRemove(pSDevSlnMSDepAPI);
    }
}

