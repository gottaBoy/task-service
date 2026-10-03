/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdeploy.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSys;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVer;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysService;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysVer;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDepSysVerService
extends PSDepSysVerServiceBase {
    private static final Log log = LogFactory.getLog(PSDepSysVerService.class);

    @Override
    protected void onBeforeCreate(PSDepSysVer pSDepSysVer) throws Exception {
        if (StringHelper.compare((String)pSDepSysVer.getPSDepSysVerType(), (String)"SAASSYS", (boolean)false) == 0) {
            String string = pSDepSysVer.getPSDepSys().getPSSaaSSysId();
            PSSaaSSysService pSSaaSSysService = (PSSaaSSysService)ServiceGlobal.getService(PSSaaSSysService.class);
            PSSaaSSys pSSaaSSys = new PSSaaSSys();
            pSSaaSSys.setPSSaaSSysId(string);
            String string2 = pSDepSysVer.getPSDepSys().getCodeName();
            if (pSSaaSSysService.get(pSSaaSSys, true) && !StringHelper.isNullOrEmpty((String)pSSaaSSys.getCodeName())) {
                string2 = pSSaaSSys.getCodeName();
            }
            PSSaaSSysVerService pSSaaSSysVerService = (PSSaaSSysVerService)ServiceGlobal.getService(PSSaaSSysVerService.class);
            PSSaaSSysVer pSSaaSSysVer = new PSSaaSSysVer();
            pSSaaSSysVer.setPSSaaSSysVerId(pSDepSysVer.getPSSaaSSysVerId());
            if (!pSSaaSSysVerService.get(pSSaaSSysVer, true)) {
                throw new Exception("\u65e0\u6cd5\u83b7\u53d6SaaS\u7cfb\u7edf\u7248\u672c\u4fe1\u606f");
            }
            PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
            pSDevSlnSys.setPSDevSlnId(pSDepSysVer.getPSDepSys().getPSDepSysId());
            pSDevSlnSys.setPSDevSlnName(pSDepSysVer.getPSDepSys().getPSDepSysName());
            pSDevSlnSys.setDevSysState(10);
            String string3 = StringHelper.format((String)"%1$s_%2$s", (Object)string2, (Object)pSDepSysVer.getPSDepSysVerName().replace(".", "_"));
            pSDevSlnSys.setPSDevSlnSysName(string3);
            pSDevSlnSys.setCodeName(string2);
            pSDevSlnSys.setSysVer(pSDepSysVer.getPSDepSysVerName());
            pSDevSlnSys.setVCType("TRUNK");
            pSDevSlnSys.setPSSFId(pSSaaSSys.getPSSFId());
            pSDevSlnSys.setPSSFName(pSSaaSSys.getPSSFName());
            pSDevSlnSys.setSFPSSubSysId(pSSaaSSys.getSFPSSubSysId());
            pSDevSlnSys.setSFPSSubSysName(pSSaaSSys.getSFPSSubSysName());
            pSDevSlnSys.setValidFlag(1);
            pSDevSlnSys.setSysType("DEPSYS");
            PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class);
            pSDevSlnSys.set("srcpssysmodelinstid", pSSaaSSysVer.getPSSysModelInstId());
            pSDevSlnSysService.create(pSDevSlnSys);
            pSDepSysVer.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDepSysVer.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
        }
        super.onBeforeCreate(pSDepSysVer);
    }
}

