/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.PluginActionResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServicePluginBase
 *  net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin
 *  net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysPFPITempl
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscoreux.srv.plugin;

import java.util.ArrayList;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServicePluginBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPFPITempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysPFPluginServicePlugin
extends ServicePluginBase {
    private static final Log log = LogFactory.getLog(PSSysPFPluginServicePlugin.class);

    public PluginActionResult doCopyDetails(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        if (nActionPos == 0) {
            PSSysPFPITemplService psSysPFPITemplService = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)iService.getSessionFactory());
            PSSysPFPlugin psSysPFPlugin = new PSSysPFPlugin();
            psSysPFPlugin.setPSSysPFPluginId((String)objParam);
            PSSysPFPlugin psSysPFPluginNew = (PSSysPFPlugin)iEntity;
            ArrayList list = psSysPFPITemplService.selectByPSSysPFPlugin((PSSysPFPluginBase)psSysPFPlugin);
            for (PSSysPFPITempl psSysPFPITempl : list) {
                psSysPFPITempl.resetPSSysPFPITemplId();
                psSysPFPITempl.setPSSysPFPluginId(psSysPFPluginNew.getPSSysPFPluginId());
                psSysPFPITempl.setPSSysPFPluginName(psSysPFPluginNew.getPSSysPFPluginName());
                psSysPFPITemplService.create((IEntity)psSysPFPITempl);
            }
            return PluginActionResult.Continue;
        }
        return super.doCopyDetails(iService, nActionPos, iEntity, objParam);
    }
}

