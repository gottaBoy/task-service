/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.config.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.config.entity.PSPFAppTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFAppTemplServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSPFAppTemplService
extends PSPFAppTemplServiceBase {
    private static final Log log = LogFactory.getLog(PSPFAppTemplService.class);

    protected boolean onFillEntityKeyValue(PSPFAppTempl pSPFAppTempl, boolean bl) throws Exception {
        if (!bl) {
            PSPFStyle pSPFStyle = pSPFAppTempl.getPSPFStyle();
            pSPFAppTempl.setPSPFId(pSPFStyle.getPSPFId());
            pSPFAppTempl.setPSPFName(pSPFStyle.getPSPFName());
            pSPFAppTempl.setPSPFAppTemplId(KeyValueHelper.genUniqueId((String)pSPFAppTempl.getPSPFId(), (String)pSPFAppTempl.getPSPFStyleId(), (String)pSPFAppTempl.getPSPFPubCodeId()));
            return true;
        }
        return super.onFillEntityKeyValue((IEntity)pSPFAppTempl, bl);
    }

    @Override
    protected void onBeforeCreate(PSPFAppTempl pSPFAppTempl) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSPFAppTempl.getPSPFAppTemplName())) {
            String string = StringHelper.format((String)"%1$s/%2$s/%3$s", (Object)pSPFAppTempl.getPSPFName(), (Object)pSPFAppTempl.getPSPFStyleName(), (Object)pSPFAppTempl.getPSPFPubCodeName());
            pSPFAppTempl.setPSPFAppTemplName(string);
        }
        super.onBeforeCreate(pSPFAppTempl);
    }
}

