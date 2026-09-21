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
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEField
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService
 *  net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE
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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSWFDEServicePlugin
extends ServicePluginBase {
    private static final Log log = LogFactory.getLog(PSWFDEServicePlugin.class);

    public PluginActionResult doGetDraft(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        if (nActionPos == 61) {
            PSDEFieldService psDEFieldService;
            PSWFDE psWFDE = (PSWFDE)iEntity;
            if (!StringHelper.isNullOrEmpty((String)psWFDE.getPSDEId()) && (psDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)iService.getSessionFactory())) != null) {
                ArrayList psDEFieldList = psDEFieldService.selectByDataEntity(psWFDE.getPSDEId());
                for (PSDEField psDEField : psDEFieldList) {
                    if (StringHelper.compare((String)psDEField.getBizTag(), (String)"WFINSTANCEID", (boolean)true) == 0) {
                        psWFDE.setWFInstPSDEFId(psDEField.getPSDEFieldId());
                        psWFDE.setWFInstPSDEFName(psDEField.getPSDEFieldName());
                        continue;
                    }
                    if (StringHelper.compare((String)psDEField.getBizTag(), (String)"WFSTATE", (boolean)true) == 0) {
                        psWFDE.setWFStatePSDEFId(psDEField.getPSDEFieldId());
                        psWFDE.setWFStatePSDEFName(psDEField.getPSDEFieldName());
                        continue;
                    }
                    if (StringHelper.compare((String)psDEField.getBizTag(), (String)"WFSTEP", (boolean)true) == 0) {
                        psWFDE.setWFStepPSDEFId(psDEField.getPSDEFieldId());
                        psWFDE.setWFStepPSDEFName(psDEField.getPSDEFieldName());
                        continue;
                    }
                    if (StringHelper.compare((String)psDEField.getBizTag(), (String)"WFVERSION", (boolean)true) == 0) {
                        psWFDE.setWFVerPSDEFId(psDEField.getPSDEFieldId());
                        psWFDE.setWFVerPSDEFName(psDEField.getPSDEFieldName());
                        continue;
                    }
                    if (StringHelper.compare((String)psDEField.getBizTag(), (String)"WFUSERSTATE", (boolean)true) != 0) continue;
                    psWFDE.setStatePSDEFId(psDEField.getPSDEFieldId());
                    psWFDE.setStatePSDEFName(psDEField.getPSDEFieldName());
                }
            }
            return PluginActionResult.Continue;
        }
        return super.doGetDraft(iService, nActionPos, iEntity, objParam);
    }
}

