/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPITempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPITemplServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysSFPITemplService
extends PSSysSFPITemplServiceBase {
    private static final Log log = LogFactory.getLog(PSSysSFPITemplService.class);

    @Override
    protected void onBeforeCreate(PSSysSFPITempl pSSysSFPITempl) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSSysSFPITempl.getPSSysSFPITemplName())) {
            pSSysSFPITempl.setPSSysSFPITemplName(StringHelper.format((String)"%1$s/%2$s", (Object)pSSysSFPITempl.getPSSysSFPluginName(), (Object)pSSysSFPITempl.getPSSFName()));
        }
        if (StringHelper.length((String)pSSysSFPITempl.getTemplCode()) > 4000) {
            pSSysSFPITempl.setTemplCodeEx(pSSysSFPITempl.getTemplCode());
            pSSysSFPITempl.setTemplCode(null);
        } else if (!StringHelper.isNullOrEmpty((String)pSSysSFPITempl.getTemplCode())) {
            pSSysSFPITempl.setTemplCodeEx(null);
        }
        if (StringHelper.length((String)pSSysSFPITempl.getTemplCode2()) > 4000) {
            pSSysSFPITempl.setTemplCode2Ex(pSSysSFPITempl.getTemplCode2());
            pSSysSFPITempl.setTemplCode2(null);
        } else if (!StringHelper.isNullOrEmpty((String)pSSysSFPITempl.getTemplCode2())) {
            pSSysSFPITempl.setTemplCode2Ex(null);
        }
        super.onBeforeCreate(pSSysSFPITempl);
    }

    @Override
    protected void onBeforeUpdate(PSSysSFPITempl pSSysSFPITempl) throws Exception {
        if (StringHelper.length((String)pSSysSFPITempl.getTemplCode()) > 4000) {
            pSSysSFPITempl.setTemplCodeEx(pSSysSFPITempl.getTemplCode());
            pSSysSFPITempl.setTemplCode(null);
        } else if (pSSysSFPITempl.isTemplCodeDirty()) {
            pSSysSFPITempl.setTemplCodeEx(null);
        }
        if (StringHelper.length((String)pSSysSFPITempl.getTemplCode2()) > 4000) {
            pSSysSFPITempl.setTemplCode2Ex(pSSysSFPITempl.getTemplCode2());
            pSSysSFPITempl.setTemplCode2(null);
        } else if (pSSysSFPITempl.isTemplCode2Dirty()) {
            pSSysSFPITempl.setTemplCode2Ex(null);
        }
        super.onBeforeUpdate(pSSysSFPITempl);
    }

    protected CallResult internalGet(PSSysSFPITempl pSSysSFPITempl, boolean bl) throws Exception {
        CallResult callResult = super.internalGet((IEntity)pSSysSFPITempl, bl);
        if (callResult.isOk()) {
            if (!StringHelper.isNullOrEmpty((String)pSSysSFPITempl.getTemplCodeEx())) {
                pSSysSFPITempl.setTemplCode(pSSysSFPITempl.getTemplCodeEx());
            }
            if (!StringHelper.isNullOrEmpty((String)pSSysSFPITempl.getTemplCode2Ex())) {
                pSSysSFPITempl.setTemplCode2(pSSysSFPITempl.getTemplCode2Ex());
            }
        }
        return callResult;
    }

    @Override
    protected CallResult internalGetTemp(PSSysSFPITempl pSSysSFPITempl, boolean bl) throws Exception {
        CallResult callResult = super.internalGetTemp(pSSysSFPITempl, bl);
        if (callResult.isOk()) {
            if (!StringHelper.isNullOrEmpty((String)pSSysSFPITempl.getTemplCodeEx())) {
                pSSysSFPITempl.setTemplCode(pSSysSFPITempl.getTemplCodeEx());
            }
            if (!StringHelper.isNullOrEmpty((String)pSSysSFPITempl.getTemplCode2Ex())) {
                pSSysSFPITempl.setTemplCode2(pSSysSFPITempl.getTemplCode2Ex());
            }
        }
        return callResult;
    }
}

