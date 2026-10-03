/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdeploy.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysDynaInst;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDynaInstServiceBase;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDepSlnSysDynaInstService
extends PSDepSlnSysDynaInstServiceBase {
    private static final Log log = LogFactory.getLog(PSDepSlnSysDynaInstService.class);

    @Override
    protected void onAfterCreate(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        this.initPSDynaInst(pSDepSlnSysDynaInst);
        super.onAfterCreate(pSDepSlnSysDynaInst);
    }

    @Override
    protected void onAfterUpdate(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        this.initPSDynaInst(pSDepSlnSysDynaInst);
        super.onAfterUpdate(pSDepSlnSysDynaInst);
    }

    @Override
    protected void onAfterRemove(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        super.onAfterRemove(pSDepSlnSysDynaInst);
    }

    protected void initPSDynaInst(PSDepSlnSysDynaInst pSDepSlnSysDynaInst) throws Exception {
        if (pSDepSlnSysDynaInst.getPSDepSlnSys() == null) {
            return;
        }
        if (DataObject.getIntegerValue((Object)pSDepSlnSysDynaInst.getPSDepSlnSys().getEnableDynaSys(), (Integer)0) == 0) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u7cfb\u7edf\u6ca1\u6709\u542f\u7528\u52a8\u6001\u7cfb\u7edf\u529f\u80fd\uff0c\u4e0d\u80fd\u5efa\u7acb\u52a8\u6001\u7cfb\u7edf\u5b9e\u4f8b"));
        }
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(pSDepSlnSysDynaInst.getPSDepSlnSys().getPSSysModelInst());
        PSDynaInstService pSDynaInstService = (PSDynaInstService)ServiceGlobal.getService(PSDynaInstService.class, (SessionFactory)sessionFactory);
        PSDynaInst pSDynaInst = new PSDynaInst();
        pSDynaInst.setPSDynaInstId(pSDepSlnSysDynaInst.getPSDepSlnSysDynaInstId());
        if (pSDepSlnSysDynaInst.isPSDepSlnSysDynaInstNameDirty()) {
            pSDynaInst.setPSDynaInstName(pSDepSlnSysDynaInst.getPSDepSlnSysDynaInstName());
        }
        if (pSDepSlnSysDynaInst.isValidFlagDirty()) {
            pSDynaInst.setValidFlag(pSDepSlnSysDynaInst.getValidFlag());
        }
        pSDynaInst.setPSDynaSysId(pSDepSlnSysDynaInst.getPSDepSlnSys().getPSSystemId());
        pSDynaInst.setPSDynaSysName(pSDepSlnSysDynaInst.getPSDepSlnSys().getPSDepSlnSysName());
        pSDynaInstService.save(pSDynaInst);
    }
}

