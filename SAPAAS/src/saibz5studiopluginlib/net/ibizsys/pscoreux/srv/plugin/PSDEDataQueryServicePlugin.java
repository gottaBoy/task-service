/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.PluginActionResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServicePluginBase
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCode
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeCond
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeExp
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeCondService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeExpService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscoreux.srv.plugin;

import java.util.ArrayList;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServicePluginBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCodeExp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQueryBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeExpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDEDataQueryServicePlugin
extends ServicePluginBase {
    private static final Log log = LogFactory.getLog(PSDEDataQueryServicePlugin.class);

    public PluginActionResult doCopyDetails(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        if (nActionPos == 0) {
            if (StringHelper.isNullOrEmpty((Object)objParam)) {
                return PluginActionResult.Continue;
            }
            PSDEDataQueryService psDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)iService.getSessionFactory());
            PSDEDataQuery psdeDataQueryNew = (PSDEDataQuery)iEntity;
            PSDEDataQuery psDEDataQuery = new PSDEDataQuery();
            psDEDataQuery.setPSDEDataQueryId((String)objParam);
            if (psDEDataQueryService.select((IEntity)psDEDataQuery, true)) {
                if (DataObject.getBoolValue((Integer)psDEDataQuery.getCustomMode(), (boolean)false)) {
                    PSDEDQCodeService psDEDQCodeService = (PSDEDQCodeService)ServiceGlobal.getService(PSDEDQCodeService.class, (SessionFactory)iService.getSessionFactory());
                    PSDEDQCodeExpService psDEDQCodeExpService = (PSDEDQCodeExpService)ServiceGlobal.getService(PSDEDQCodeExpService.class, (SessionFactory)iService.getSessionFactory());
                    PSDEDQCodeCondService psDEDQCodeCondService = (PSDEDQCodeCondService)ServiceGlobal.getService(PSDEDQCodeCondService.class, (SessionFactory)iService.getSessionFactory());
                    ArrayList psDEDQCodeList = psDEDQCodeService.selectByPSDEDQ((PSDEDataQueryBase)psDEDataQuery);
                    for (PSDEDQCode psDEDQCode : psDEDQCodeList) {
                        ArrayList psDEDQCodeExpList = psDEDQCodeExpService.selectByPSDEDQCode((PSDEDQCodeBase)psDEDQCode);
                        ArrayList psDEDQCodeCondList = psDEDQCodeCondService.selectByPSDEDQCode((PSDEDQCodeBase)psDEDQCode);
                        psDEDQCode.resetPSDEDQCodeId();
                        psDEDQCode.setPSDEDQId(psdeDataQueryNew.getPSDEDataQueryId());
                        psDEDQCode.setPSDEDQName(psdeDataQueryNew.getPSDEDataQueryName());
                        psDEDQCodeService.create((IEntity)psDEDQCode);
                        for (PSDEDQCodeExp psDEDQCodeExp : psDEDQCodeExpList) {
                            psDEDQCodeExp.resetPSDEDQCodeExpId();
                            psDEDQCodeExp.setPSDEDQCodeId(psDEDQCode.getPSDEDQCodeId());
                            psDEDQCodeExp.setPSDEDQCodeName(psDEDQCode.getPSDEDQCodeName());
                            psDEDQCodeExpService.create((IEntity)psDEDQCodeExp);
                        }
                        for (PSDEDQCodeCond psDEDQCodeCond : psDEDQCodeCondList) {
                            psDEDQCodeCond.resetPSDEDQCodeCondId();
                            psDEDQCodeCond.setPSDEDQCodeId(psDEDQCode.getPSDEDQCodeId());
                            psDEDQCodeCond.setPSDEDQCodeName(psDEDQCode.getPSDEDQCodeName());
                            psDEDQCodeCondService.create((IEntity)psDEDQCodeCond);
                        }
                    }
                }
            } else {
                log.error((Object)StringHelper.format((String)"\u6570\u636e\u67e5\u9009\u62f7\u8d1d\u6e90[%1$s]\u4e0d\u5b58\u5728!", (Object)objParam));
                return PluginActionResult.Continue;
            }
            return PluginActionResult.Replace;
        }
        return super.doCopyDetails(iService, nActionPos, iEntity, objParam);
    }
}

