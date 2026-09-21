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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUpdate;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEGEIUpdateService
extends PSDEGEIUpdateServiceBase {
    private static final Log log = LogFactory.getLog(PSDEGEIUpdateService.class);

    @Override
    protected void getRelatedDataTempMajor_PSDEGEIUDetail(PSDEGEIUpdate pSDEGEIUpdate) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSDEGRID", (boolean)true) == 0) {
            return;
        }
        super.getRelatedDataTempMajor_PSDEGEIUDetail(pSDEGEIUpdate);
    }

    @Override
    protected ArrayList<PSDEGEIUDetail> updateRelatedDataTempMajor_removePSDEGEIUDetail(PSDEGEIUpdate pSDEGEIUpdate, PSDEGEIUpdate pSDEGEIUpdate2) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSDEGRID", (boolean)true) == 0) {
            return null;
        }
        return super.updateRelatedDataTempMajor_removePSDEGEIUDetail(pSDEGEIUpdate, pSDEGEIUpdate2);
    }
}

