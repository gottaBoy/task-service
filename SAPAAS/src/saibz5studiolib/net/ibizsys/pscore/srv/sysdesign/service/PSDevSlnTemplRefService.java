/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.HashMap;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTemplRef;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplRefServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnTemplRefService
extends PSDevSlnTemplRefServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnTemplRefService.class);

    @Override
    protected void onBeforeCreate(PSDevSlnTemplRef pSDevSlnTemplRef) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            if (StringHelper.isNullOrEmpty((String)pSDevSlnTemplRef.getAccessToken())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6a21\u677f\u8bbf\u95ee\u4ee3\u7801");
            }
            PSDevSlnTempl pSDevSlnTempl = pSDevSlnTemplRef.getPSDevSlnTempl();
            if (pSDevSlnTempl == null) {
                throw new Exception("\u5f53\u524d\u5f00\u53d1\u6a21\u677f\u65e0\u6548");
            }
            PSDevSlnTemplService pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
            PSDevSlnTempl pSDevSlnTempl2 = new PSDevSlnTempl();
            pSDevSlnTempl2.setRefCode(pSDevSlnTemplRef.getAccessToken());
            if (!pSDevSlnTemplService.select(pSDevSlnTempl2, true)) {
                throw new Exception("\u6a21\u677f\u8bbf\u95ee\u4ee3\u7801\u65e0\u6548");
            }
            if (StringHelper.compare((String)pSDevSlnTempl.getTemplType(), (String)pSDevSlnTempl2.getTemplType(), (boolean)false) != 0) {
                throw new Exception("\u5f53\u524d\u5f00\u53d1\u6a21\u677f\u7c7b\u578b\u4e0e\u5f15\u7528\u6a21\u677f\u4e0d\u4e00\u81f4");
            }
            if (StringHelper.compare((String)pSDevSlnTempl.getTemplType(), (String)"PSPF", (boolean)false) == 0) {
                if (StringHelper.compare((String)pSDevSlnTempl.getPSPFId(), (String)pSDevSlnTempl2.getPSPFId(), (boolean)false) != 0) {
                    throw new Exception("\u5f53\u524d\u5f00\u53d1\u6a21\u677f\u524d\u7aef\u6a21\u677f\u7c7b\u578b\u4e0e\u5f15\u7528\u6a21\u677f\u4e0d\u4e00\u81f4");
                }
            } else if (StringHelper.compare((String)pSDevSlnTempl.getTemplType(), (String)"PSSF", (boolean)false) == 0 && StringHelper.compare((String)pSDevSlnTempl.getPSSFId(), (String)pSDevSlnTempl2.getPSSFId(), (boolean)false) != 0) {
                throw new Exception("\u5f53\u524d\u5f00\u53d1\u6a21\u677f\u540e\u53f0\u6a21\u677f\u7c7b\u578b\u4e0e\u5f15\u7528\u6a21\u677f\u4e0d\u4e00\u81f4");
            }
            pSDevSlnTemplRef.setRefState(10);
            pSDevSlnTemplRef.setRefPSDevSlnTemplId(pSDevSlnTempl2.getPSDevSlnTemplId());
            pSDevSlnTemplRef.setRefPSDevSlnTemplName(pSDevSlnTempl2.getPSDevSlnTemplName());
            if (StringHelper.isNullOrEmpty((String)pSDevSlnTemplRef.getPSDevSlnTemplRefName())) {
                String string = "ref";
                HashMap<String, String> hashMap = new HashMap<String, String>();
                HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
                hashMap.put("PSDEVSLNTEMPLREFNAME", string);
                hashMap2.put("PSDEVSLNTEMPLID", pSDevSlnTemplRef.getPSDevSlnTemplId());
                this.fillDefaultValue(pSDevSlnTemplRef, false, hashMap, hashMap2);
            }
        }
        super.onBeforeCreate(pSDevSlnTemplRef);
    }

    @Override
    protected void onAfterUpdate(PSDevSlnTemplRef pSDevSlnTemplRef) throws Exception {
        super.onAfterUpdate(pSDevSlnTemplRef);
        this.syncPSDevSlnTemplRef(pSDevSlnTemplRef);
    }

    @Override
    protected void onUpdateRefState(PSDevSlnTemplRef pSDevSlnTemplRef) throws Exception {
        this.sysUpdate(pSDevSlnTemplRef, true);
        this.syncPSDevSlnTemplRef(pSDevSlnTemplRef);
    }

    protected void syncPSDevSlnTemplRef(PSDevSlnTemplRef pSDevSlnTemplRef) throws Exception {
        this.get(pSDevSlnTemplRef);
    }
}

