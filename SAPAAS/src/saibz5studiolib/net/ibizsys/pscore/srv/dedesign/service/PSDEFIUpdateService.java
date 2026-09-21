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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUpdate;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUpdateServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEFIUpdateService
extends PSDEFIUpdateServiceBase {
    private static final Log log = LogFactory.getLog(PSDEFIUpdateService.class);

    @Override
    protected void getRelatedDataTempMajor_PSDEFIUDetail(PSDEFIUpdate pSDEFIUpdate) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSDEFORM", (boolean)true) == 0) {
            return;
        }
        super.getRelatedDataTempMajor_PSDEFIUDetail(pSDEFIUpdate);
    }

    @Override
    protected ArrayList<PSDEFIUDetail> updateRelatedDataTempMajor_removePSDEFIUDetail(PSDEFIUpdate pSDEFIUpdate, PSDEFIUpdate pSDEFIUpdate2) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSDEFORM", (boolean)true) == 0) {
            return null;
        }
        return super.updateRelatedDataTempMajor_removePSDEFIUDetail(pSDEFIUpdate, pSDEFIUpdate2);
    }
}

