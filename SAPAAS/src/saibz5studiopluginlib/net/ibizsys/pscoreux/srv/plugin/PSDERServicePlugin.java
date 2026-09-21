/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.PluginActionResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServicePluginBase
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDER
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscoreux.srv.plugin;

import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServicePluginBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDERServicePlugin
extends ServicePluginBase {
    private static final Log log = LogFactory.getLog(PSDERServicePlugin.class);

    public PluginActionResult doGetDraft(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        boolean isExtract;
        if (nActionPos == 61 && (isExtract = PSCoreSysServiceBase.isExtractDefault((SessionFactory)iService.getSessionFactory()))) {
            PSDEDataSetService psDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)iService.getSessionFactory());
            PSDEACModeService psDEACModeService = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)iService.getSessionFactory());
            PSDEViewBaseService psDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)iService.getSessionFactory());
            PSDER psDER = (PSDER)iEntity;
            String strMajorPSDEId = psDER.getMajorPSDEId();
            if (!StringHelper.isNullOrEmpty((String)strMajorPSDEId)) {
                PSDEViewBase psDEViewBase;
                if (StringHelper.isNullOrEmpty((String)psDER.getPSDEACModeId())) {
                    PSDEACMode psDEACMode = new PSDEACMode();
                    psDEACMode.setPSDEId(strMajorPSDEId);
                    psDEACMode.setDefaultMode(Integer.valueOf(1));
                    if (psDEACModeService.select((IEntity)psDEACMode, true)) {
                        psDER.setPSDEACModeId(psDEACMode.getPSDEACModeId());
                        psDER.setPSDEACModeName(psDEACMode.getPSDEACModeName());
                    }
                }
                if (StringHelper.isNullOrEmpty((String)psDER.getSDPSDEViewID())) {
                    psDEViewBase = new PSDEViewBase();
                    psDEViewBase.setPSDEId(strMajorPSDEId);
                    psDEViewBase.setPredefinedViewType("PICKUPVIEW");
                    if (psDEViewBaseService.select((IEntity)psDEViewBase, true)) {
                        psDER.setSDPSDEViewID(psDEViewBase.getPSDEViewBaseId());
                        psDER.setSDPSDEViewName(psDEViewBase.getPSDEViewBaseName());
                    }
                }
                if (StringHelper.isNullOrEmpty((String)psDER.getMDPSDEViewId())) {
                    psDEViewBase = new PSDEViewBase();
                    psDEViewBase.setPSDEId(strMajorPSDEId);
                    psDEViewBase.setPredefinedViewType("MPICKUPVIEW");
                    if (psDEViewBaseService.select((IEntity)psDEViewBase, true)) {
                        psDER.setMDPSDEViewId(psDEViewBase.getPSDEViewBaseId());
                        psDER.setMDPSDEViewName(psDEViewBase.getPSDEViewBaseName());
                    }
                }
                if (StringHelper.isNullOrEmpty((String)psDER.getPSDEDataSetId())) {
                    PSDEDataSet psDEDataSet = new PSDEDataSet();
                    psDEDataSet.setPSDEId(strMajorPSDEId);
                    psDEDataSet.setDefaultMode(Integer.valueOf(1));
                    if (psDEDataSetService.select((IEntity)psDEDataSet, true)) {
                        psDER.setPSDEDataSetId(psDEDataSet.getPSDEDataSetId());
                        psDER.setPSDEDataSetName(psDEDataSet.getPSDEDataSetName());
                    }
                }
            }
            return PluginActionResult.Continue;
        }
        return super.doGetDraft(iService, nActionPos, iEntity, objParam);
    }
}

