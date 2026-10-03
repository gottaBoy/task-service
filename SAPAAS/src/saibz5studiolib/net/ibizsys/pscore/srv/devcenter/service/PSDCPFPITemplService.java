/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCodeBase;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCPFPITempl;
import net.ibizsys.pscore.srv.devcenter.service.PSDCPFPITemplServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCPFPITemplService
extends PSDCPFPITemplServiceBase {
    private static final Log log = LogFactory.getLog(PSDCPFPITemplService.class);

    @Override
    protected void onBeforeCreate(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        pSDCPFPITempl.setPSDCPFPITemplName(StringHelper.format((String)"%1$s/%2$s", (Object)pSDCPFPITempl.getPSDCPFPluginName(), (Object)pSDCPFPITempl.getPSPFName()));
        if (StringHelper.length((String)pSDCPFPITempl.getTemplCode2()) > 2000) {
            pSDCPFPITempl.setTemplCode2Ex(pSDCPFPITempl.getTemplCode2());
            pSDCPFPITempl.setTemplCode2(null);
        } else if (!StringHelper.isNullOrEmpty((String)pSDCPFPITempl.getTemplCode2())) {
            pSDCPFPITempl.setTemplCode2Ex(null);
        }
        super.onBeforeCreate(pSDCPFPITempl);
    }

    @Override
    protected void onBeforeUpdate(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        if (StringHelper.length((String)pSDCPFPITempl.getTemplCode2()) > 2000) {
            pSDCPFPITempl.setTemplCode2Ex(pSDCPFPITempl.getTemplCode2());
            pSDCPFPITempl.setTemplCode2(null);
        } else if (!StringHelper.isNullOrEmpty((String)pSDCPFPITempl.getTemplCode2())) {
            pSDCPFPITempl.setTemplCode2Ex(null);
        }
        super.onBeforeUpdate(pSDCPFPITempl);
    }

    protected CallResult internalGet(PSDCPFPITempl pSDCPFPITempl, boolean bl) throws Exception {
        CallResult callResult = super.internalGet(pSDCPFPITempl, bl);
        if (callResult.isOk() && !StringHelper.isNullOrEmpty((String)pSDCPFPITempl.getTemplCode2Ex())) {
            pSDCPFPITempl.setTemplCode2(pSDCPFPITempl.getTemplCode2Ex());
        }
        return callResult;
    }

    @Override
    protected void onGetDraftWithTips(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        this.getDraft(pSDCPFPITempl);
        this.calcTemplCodeInfo(pSDCPFPITempl);
    }

    @Override
    protected void onGetWithTips(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        this.get(pSDCPFPITempl);
        this.calcTemplCodeInfo(pSDCPFPITempl);
    }

    @Override
    protected void onCreateWithTips(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        pSDCPFPITempl.setTemplCode2Flag(0);
        pSDCPFPITempl.setTemplCodeFlag(0);
        pSDCPFPITempl.setTemplCode3Flag(0);
        pSDCPFPITempl.setTemplCode4Flag(0);
        pSDCPFPITempl.setTemplCodeInfo(null);
        pSDCPFPITempl.setTemplCode2Info(null);
        pSDCPFPITempl.setTemplCode3Info(null);
        pSDCPFPITempl.setTemplCode4Info(null);
        this.create(pSDCPFPITempl);
        this.calcTemplCodeInfo(pSDCPFPITempl);
    }

    @Override
    protected void onUpdateWithTips(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        pSDCPFPITempl.setTemplCode2Flag(0);
        pSDCPFPITempl.setTemplCodeFlag(0);
        pSDCPFPITempl.setTemplCode3Flag(0);
        pSDCPFPITempl.setTemplCode4Flag(0);
        pSDCPFPITempl.setTemplCodeInfo(null);
        pSDCPFPITempl.setTemplCode2Info(null);
        pSDCPFPITempl.setTemplCode3Info(null);
        pSDCPFPITempl.setTemplCode4Info(null);
        this.update(pSDCPFPITempl);
        this.calcTemplCodeInfo(pSDCPFPITempl);
    }

    @Override
    protected void onCalcTemplCodeInfo(PSDCPFPITempl pSDCPFPITempl) throws Exception {
        pSDCPFPITempl.setTemplCode2Flag(0);
        pSDCPFPITempl.setTemplCodeFlag(0);
        pSDCPFPITempl.setTemplCode3Flag(0);
        pSDCPFPITempl.setTemplCode4Flag(0);
        pSDCPFPITempl.setTemplCodeInfo(null);
        pSDCPFPITempl.setTemplCode2Info(null);
        pSDCPFPITempl.setTemplCode3Info(null);
        pSDCPFPITempl.setTemplCode4Info(null);
        if (!StringHelper.isNullOrEmpty((String)pSDCPFPITempl.getPSPFId())) {
            Object object;
            PSPFPubCodeService pSPFPubCodeService = (PSPFPubCodeService)ServiceGlobal.getService(PSPFPubCodeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            SelectCond selectCond = new SelectCond();
            selectCond.set("PSPFID", (Object)pSDCPFPITempl.getPSPFId());
            selectCond.set("PITEMPLCODE", SelectCond.ISNOTNULL);
            ArrayList<PSPFPubCode> arrayList = pSPFPubCodeService.select((ISelectCond)selectCond);
            HashMap<String, PSPFPubCode> hashMap = new HashMap<String, PSPFPubCode>();
            for (PSPFPubCode pSPFPubCode : arrayList) {
                hashMap.put(pSPFPubCode.getPITemplCode(), pSPFPubCode);
            }
            if (hashMap.containsKey("CODE")) {
                object = (PSPFPubCode)hashMap.get("CODE");
                pSDCPFPITempl.setTemplCodeFlag(1);
                if (StringHelper.isNullOrEmpty((String)((PSPFPubCodeBase)object).getPubCodeDesc())) {
                    pSDCPFPITempl.setTemplCodeInfo(((PSPFPubCodeBase)object).getPSPFPubCodeName());
                } else {
                    pSDCPFPITempl.setTemplCodeInfo(((PSPFPubCodeBase)object).getPubCodeDesc());
                }
            }
            if (hashMap.containsKey("CODE2")) {
                object = (PSPFPubCode)hashMap.get("CODE2");
                pSDCPFPITempl.setTemplCode2Flag(1);
                if (StringHelper.isNullOrEmpty((String)((PSPFPubCodeBase)object).getPubCodeDesc())) {
                    pSDCPFPITempl.setTemplCode2Info(((PSPFPubCodeBase)object).getPSPFPubCodeName());
                } else {
                    pSDCPFPITempl.setTemplCode2Info(((PSPFPubCodeBase)object).getPubCodeDesc());
                }
            }
            if (hashMap.containsKey("CODE3")) {
                object = (PSPFPubCode)hashMap.get("CODE3");
                pSDCPFPITempl.setTemplCode3Flag(1);
                if (StringHelper.isNullOrEmpty((String)((PSPFPubCodeBase)object).getPubCodeDesc())) {
                    pSDCPFPITempl.setTemplCode3Info(((PSPFPubCodeBase)object).getPSPFPubCodeName());
                } else {
                    pSDCPFPITempl.setTemplCode3Info(((PSPFPubCodeBase)object).getPubCodeDesc());
                }
            }
            if (hashMap.containsKey("CODE4")) {
                object = (PSPFPubCode)hashMap.get("CODE4");
                pSDCPFPITempl.setTemplCode4Flag(1);
                if (StringHelper.isNullOrEmpty((String)((PSPFPubCodeBase)object).getPubCodeDesc())) {
                    pSDCPFPITempl.setTemplCode4Info(((PSPFPubCodeBase)object).getPSPFPubCodeName());
                } else {
                    pSDCPFPITempl.setTemplCode4Info(((PSPFPubCodeBase)object).getPubCodeDesc());
                }
            }
        }
    }
}
