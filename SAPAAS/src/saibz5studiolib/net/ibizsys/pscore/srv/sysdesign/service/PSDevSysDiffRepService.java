/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.Date;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSysDiffRep;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffRepServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSysDiffRepService
extends PSDevSysDiffRepServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSysDiffRepService.class);

    @Override
    protected void onBeforeCreate(PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            if (StringHelper.compare((String)pSDevSysDiffRep.getPSDevSlnSysId(), (String)pSDevSysDiffRep.getDstPSDevSlnSysId(), (boolean)true) == 0) {
                throw new Exception("\u5bf9\u6bd4\u7cfb\u7edf\u4e0d\u80fd\u4e3a\u5f53\u524d\u7cfb\u7edf");
            }
            String string = StringHelper.format((String)"[%1$s~%2$s][%3$tY%3$tm%3$td%3$tH%3$tM%3$tS]\u5206\u6790\u62a5\u544a", (Object)pSDevSysDiffRep.getPSDevSlnSysName(), (Object)pSDevSysDiffRep.getDstPSDevSlnSysName(), (Object)new Date());
            pSDevSysDiffRep.setPSDevSysDiffRepName(string);
        }
        super.onBeforeCreate(pSDevSysDiffRep);
    }

    @Override
    protected void onAfterCreate(PSDevSysDiffRep pSDevSysDiffRep) throws Exception {
        super.onAfterCreate(pSDevSysDiffRep);
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            SessionFactoryManager.commit((SessionFactory)this.getSessionFactory());
            if (pSDevSysDiffRep.getRepState() != null && pSDevSysDiffRep.getRepState() == 10) {
                this.executeRemoteCall2("STARTDIFF", pSDevSysDiffRep);
            }
            return;
        }
    }
}

