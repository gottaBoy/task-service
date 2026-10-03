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
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnMSDepFuncService
extends PSDevSlnMSDepFuncServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepFuncService.class);

    @Override
    protected void onBeforeCreate(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        String string = pSDevSlnMSDepFunc.getPSDCMSPlatformNodeId();
        if (!StringHelper.isNullOrEmpty((String)string)) {
            this.checkPSDCMSPlatformNode(string, pSDevSlnMSDepFunc, false);
        }
        super.onBeforeCreate(pSDevSlnMSDepFunc);
    }

    @Override
    protected void onBeforeUpdate(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        String string;
        PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = (PSDevSlnMSDepFunc)this.getLast(pSDevSlnMSDepFunc);
        if (!pSDevSlnMSDepFunc.isPSDCMSPlatformNodeIdDirty()) {
            pSDevSlnMSDepFunc.setPSDCMSPlatformNodeId(pSDevSlnMSDepFunc2.getPSDCMSPlatformNodeId());
            pSDevSlnMSDepFunc.setPSDCMSPlatformNodeName(pSDevSlnMSDepFunc2.getPSDCMSPlatformNodeName());
        }
        if (!pSDevSlnMSDepFunc.isPSDevSlnSysIdDirty()) {
            pSDevSlnMSDepFunc.setPSDevSlnSysId(pSDevSlnMSDepFunc2.getPSDevSlnSysId());
            pSDevSlnMSDepFunc.setPSDevSlnSysName(pSDevSlnMSDepFunc2.getPSDevSlnSysName());
        }
        if (!StringHelper.isNullOrEmpty((String)(string = pSDevSlnMSDepFunc.getPSDCMSPlatformNodeId()))) {
            this.checkPSDCMSPlatformNode(string, pSDevSlnMSDepFunc, true);
        }
        super.onBeforeUpdate(pSDevSlnMSDepFunc);
    }

    protected void checkPSDCMSPlatformNode(String string, PSDevSlnMSDepFunc pSDevSlnMSDepFunc, boolean bl) throws Exception {
        PSDCMSPlatformNodeService pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
        PSDCMSPlatformNode pSDCMSPlatformNode = new PSDCMSPlatformNode();
        pSDCMSPlatformNode.setPSDCMSPlatformNodeId(string);
        if (!pSDCMSPlatformNodeService.get(pSDCMSPlatformNode, true)) {
            throw new Exception(String.format("\u4f20\u5165Cloud\u670d\u52a1\u65e0\u6548", new Object[0]));
        }
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDCMSPLATFORMNODEID", (Object)string);
        PSDevSlnMSDepAppService pSDevSlnMSDepAppService = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, (SessionFactory)this.getSessionFactory());
        ArrayList arrayList = pSDevSlnMSDepAppService.select((ISelectCond)selectCond);
        if (arrayList != null && arrayList.size() > 0) {
            throw new Exception(String.format("Cloud\u670d\u52a1[%1$s]\u5df2\u7ecf\u88ab\u524d\u7aef\u5e94\u7528[%2$s@%3$s]\u4f7f\u7528", pSDCMSPlatformNode.getPSDCMSPlatformNodeName(), ((PSDevSlnMSDepApp)arrayList.get(0)).getPSDevSlnSysAppName(), ((PSDevSlnMSDepApp)arrayList.get(0)).getPSDevSlnSysName()));
        }
        PSDevSlnMSDepAPIService pSDevSlnMSDepAPIService = (PSDevSlnMSDepAPIService)ServiceGlobal.getService(PSDevSlnMSDepAPIService.class, (SessionFactory)this.getSessionFactory());
        ArrayList arrayList2 = pSDevSlnMSDepAPIService.select((ISelectCond)selectCond);
        if (arrayList2 != null && arrayList2.size() > 0) {
            PSDevSlnMSDepAPI pSDevSlnMSDepAPI = (PSDevSlnMSDepAPI)arrayList2.get(0);
            throw new Exception(String.format("Cloud\u670d\u52a1[%1$s]\u5df2\u7ecf\u88ab\u670d\u52a1\u63a5\u53e3[%2$s@%3$s]\u4f7f\u7528", pSDCMSPlatformNode.getPSDCMSPlatformNodeName(), pSDevSlnMSDepAPI.getPSDevSlnSysAPIName(), pSDevSlnMSDepAPI.getPSDevSlnSysName()));
        }
        PSDevSlnMSDepFuncService pSDevSlnMSDepFuncService = (PSDevSlnMSDepFuncService)ServiceGlobal.getService(PSDevSlnMSDepFuncService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnMSDepFunc> arrayList3 = pSDevSlnMSDepFuncService.select((ISelectCond)selectCond);
        if (arrayList3 != null) {
            for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 : arrayList3) {
                if (StringHelper.compare((String)pSDevSlnMSDepFunc2.getPSDevSlnMSDepFuncId(), (String)pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncId(), (boolean)false) == 0) continue;
                throw new Exception(String.format("Cloud\u670d\u52a1[%1$s]\u5df2\u7ecf\u88ab\u529f\u80fd[%2$s]\u4f7f\u7528", pSDCMSPlatformNode.getPSDCMSPlatformNodeName(), ((PSDevSlnMSDepFunc)arrayList3.get(0)).getPSDevSlnMSDepFuncName()));
            }
        }
    }

    @Override
    protected void onAfterCreate(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        String string = pSDevSlnMSDepFunc.getPSDCMSPlatformNodeId();
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSDCMSPlatformNodeService pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
            PSDCMSPlatformNode pSDCMSPlatformNode = new PSDCMSPlatformNode();
            pSDCMSPlatformNode.setPSDCMSPlatformNodeId(string);
            pSDCMSPlatformNodeService.calcRefInfo(pSDCMSPlatformNode);
        }
        super.onAfterCreate(pSDevSlnMSDepFunc);
    }

    @Override
    protected void onAfterUpdate(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = (PSDevSlnMSDepFunc)this.getLast(pSDevSlnMSDepFunc);
        String string = pSDevSlnMSDepFunc.getPSDCMSPlatformNodeId();
        String string2 = pSDevSlnMSDepFunc2.getPSDCMSPlatformNodeId();
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
        super.onAfterUpdate(pSDevSlnMSDepFunc);
    }

    @Override
    protected void onBeforeRemove(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = (PSDevSlnMSDepFunc)this.getLast(pSDevSlnMSDepFunc);
        super.onBeforeRemove(pSDevSlnMSDepFunc);
    }

    @Override
    protected void onAfterRemove(PSDevSlnMSDepFunc pSDevSlnMSDepFunc) throws Exception {
        String string;
        PSDevSlnMSDepFunc pSDevSlnMSDepFunc2 = (PSDevSlnMSDepFunc)this.getLast(pSDevSlnMSDepFunc);
        if (pSDevSlnMSDepFunc2 != null && !StringHelper.isNullOrEmpty((String)(string = pSDevSlnMSDepFunc2.getPSDCMSPlatformNodeId()))) {
            PSDCMSPlatformNodeService pSDCMSPlatformNodeService = (PSDCMSPlatformNodeService)ServiceGlobal.getService(PSDCMSPlatformNodeService.class, (SessionFactory)this.getSessionFactory());
            PSDCMSPlatformNode pSDCMSPlatformNode = new PSDCMSPlatformNode();
            pSDCMSPlatformNode.setPSDCMSPlatformNodeId(string);
            pSDCMSPlatformNodeService.calcRefInfo(pSDCMSPlatformNode);
        }
        super.onAfterRemove(pSDevSlnMSDepFunc);
    }
}

