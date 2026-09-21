/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import java.util.ArrayList;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatformNode;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFunc;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCMSPlatformNodeService
extends PSDCMSPlatformNodeServiceBase {
    private static final Log log = LogFactory.getLog(PSDCMSPlatformNodeService.class);

    public void calcRefInfo(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        final PSDCMSPlatformNode pSDCMSPlatformNode2 = pSDCMSPlatformNode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDCMSPlatformNodeService.this.onCalcRefInfo(pSDCMSPlatformNode2);
            }
        });
    }

    protected void onCalcRefInfo(PSDCMSPlatformNode pSDCMSPlatformNode) throws Exception {
        String string = pSDCMSPlatformNode.getPSDCMSPlatformNodeId();
        pSDCMSPlatformNode.reset();
        pSDCMSPlatformNode.setPSDCMSPlatformNodeId(string);
        PSDevSlnMSDepAPIService pSDevSlnMSDepAPIService = (PSDevSlnMSDepAPIService)ServiceGlobal.getService(PSDevSlnMSDepAPIService.class, (SessionFactory)this.getSessionFactory());
        PSDevSlnMSDepAppService pSDevSlnMSDepAppService = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, (SessionFactory)this.getSessionFactory());
        PSDevSlnMSDepFuncService pSDevSlnMSDepFuncService = (PSDevSlnMSDepFuncService)ServiceGlobal.getService(PSDevSlnMSDepFuncService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDevSlnMSDepAPI> arrayList = pSDevSlnMSDepAPIService.selectByPSDCMSPlatformNode(pSDCMSPlatformNode);
        ArrayList<PSDevSlnMSDepApp> arrayList2 = pSDevSlnMSDepAppService.selectByPSDCMSPlatformNode(pSDCMSPlatformNode);
        ArrayList<PSDevSlnMSDepFunc> arrayList3 = pSDevSlnMSDepFuncService.selectByPSDCMSPlatformNode(pSDCMSPlatformNode);
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        int n = 0;
        if (arrayList != null) {
            n += arrayList.size();
            for (PSDevSlnMSDepAPI entityBase : arrayList) {
                stringBuilderEx.append("[%1$s]%2$s\r\n", (Object)entityBase.getPSDevSlnMSDeployName(), (Object)entityBase.getPSDevSlnMSDepAPIName());
            }
        }
        if (arrayList2 != null) {
            n += arrayList2.size();
            for (PSDevSlnMSDepApp pSDevSlnMSDepApp : arrayList2) {
                stringBuilderEx.append("[%1$s]%2$s\r\n", (Object)pSDevSlnMSDepApp.getPSDevSlnMSDeployName(), (Object)pSDevSlnMSDepApp.getPSDevSlnMSDepAppName());
            }
        }
        if (arrayList3 != null) {
            n += arrayList3.size();
            for (PSDevSlnMSDepFunc pSDevSlnMSDepFunc : arrayList3) {
                stringBuilderEx.append("[%1$s]%2$s\r\n", (Object)pSDevSlnMSDepFunc.getPSDevSlnMSDeployName(), (Object)pSDevSlnMSDepFunc.getPSDevSlnMSDepFuncName());
            }
        }
        pSDCMSPlatformNode.setRefCount(n);
        Object object = stringBuilderEx.toString();
        if (!StringHelper.isNullOrEmpty(object) && ((String)object).length() > 2000) {
            object = ((String)object).substring(0, 1990) + "...";
        }
        pSDCMSPlatformNode.setRefInfo((String)object);
        this.sysUpdate(pSDCMSPlatformNode, false);
    }
}

