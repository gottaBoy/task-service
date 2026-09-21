/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.CloneSessionManager
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.CloneSessionManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUpdate;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUpdateServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDETEIUpdateService
extends PSDETEIUpdateServiceBase {
    private static final Log log = LogFactory.getLog(PSDETEIUpdateService.class);

    @Override
    protected void getRelatedDataTempMajor_PSDETEIUDetail(PSDETEIUpdate pSDETEIUpdate) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSDETREEVIEW", (boolean)true) == 0) {
            return;
        }
        super.getRelatedDataTempMajor_PSDETEIUDetail(pSDETEIUpdate);
    }

    @Override
    protected ArrayList<PSDETEIUDetail> updateRelatedDataTempMajor_removePSDETEIUDetail(PSDETEIUpdate pSDETEIUpdate, PSDETEIUpdate pSDETEIUpdate2) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSDETREEVIEW", (boolean)true) == 0) {
            return null;
        }
        return super.updateRelatedDataTempMajor_removePSDETEIUDetail(pSDETEIUpdate, pSDETEIUpdate2);
    }
}

