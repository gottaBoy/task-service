/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdeploy.service;

import java.util.ArrayList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSys;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVer;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSysVer;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDepSysService
extends PSDepSysServiceBase {
    private static final Log log = LogFactory.getLog(PSDepSysService.class);

    /*
     * Unable to fully structure code
     */
    @Override
    protected void onBeforeCreate(PSDepSys var1_1) throws Exception {
        var2_2 = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class);
        var3_3 = "DepSysSln";
        var4_4 = new PSDevSln();
        var4_4.setPSDevCenterId(var1_1.getPSDevCenterId());
        var4_4.setPSDevCenterName(var1_1.getPSDevCenterName());
        var5_5 = 0;
        do lbl-1000:
        // 3 sources

        {
            var6_6 = StringHelper.format((String)"%1$s%2$s", (Object)var3_3, (Object)(++var5_5));
            var4_4.resetCodeName();
            var4_4.setPSDevSlnName(var6_6);
            if (var2_2.select(var4_4, true)) ** GOTO lbl-1000
            var4_4.resetPSDevSlnName();
            var4_4.setCodeName(var6_6);
        } while (var2_2.select(var4_4, true));
        var4_4.setPSDevSlnId(var1_1.getPSDepSysId());
        var4_4.setSLNType("DEPSYS");
        var4_4.setPSDevSlnName(var6_6);
        var4_4.setCodeName(var6_6);
        var4_4.setLogicName(StringHelper.format((String)"\u53ef\u90e8\u7f72\u7cfb\u7edf[%1$s]\u6269\u5c55\u5f00\u53d1\u65b9\u6848", (Object)var1_1.getPSDepSysName()));
        var2_2.create(var4_4);
        super.onBeforeCreate(var1_1);
    }

    @Override
    protected void onSyncSysVer(PSDepSys pSDepSys) throws Exception {
        this.get((IEntity)pSDepSys);
        PSDepSysVerService pSDepSysVerService = (PSDepSysVerService)ServiceGlobal.getService(PSDepSysVerService.class);
        if (StringHelper.compare((String)pSDepSys.getPSDepSysType(), (String)"SAASSYS", (boolean)true) == 0) {
            PSSaaSSys pSSaaSSys = new PSSaaSSys();
            pSSaaSSys.setPSSaaSSysId(pSDepSys.getPSSaaSSysId());
            PSSaaSSysVerService pSSaaSSysVerService = (PSSaaSSysVerService)ServiceGlobal.getService(PSSaaSSysVerService.class);
            ArrayList<PSSaaSSysVer> arrayList = pSSaaSSysVerService.selectByPSSaaSSys(pSSaaSSys);
            for (PSSaaSSysVer pSSaaSSysVer : arrayList) {
                PSDepSysVer pSDepSysVer = new PSDepSysVer();
                pSDepSysVer.setPSDepSysVerId(KeyValueHelper.genUniqueId((String)pSDepSys.getPSDepSysId(), (String)pSDepSys.getPSDepSysType(), (String)pSSaaSSysVer.getPSSaaSSysVerId()));
                if (pSDepSysVerService.checkKey(pSDepSysVer) != 0) continue;
                pSDepSysVer.setPSDepSysId(pSDepSys.getPSDepSysId());
                pSDepSysVer.setPSDepSysName(pSDepSys.getPSDepSysName());
                pSDepSysVer.setPSDepSysVerType(pSDepSys.getPSDepSysType());
                pSDepSysVer.setPSSaaSSysVerId(pSSaaSSysVer.getPSSaaSSysVerId());
                pSDepSysVer.setPSSaaSSysVerName(pSSaaSSysVer.getPSSaaSSysVerName());
                pSDepSysVer.setPSDepSysVerName(pSSaaSSysVer.getPSSaaSSysVerName());
                pSDepSysVerService.create(pSDepSysVer);
            }
        }
    }
}

