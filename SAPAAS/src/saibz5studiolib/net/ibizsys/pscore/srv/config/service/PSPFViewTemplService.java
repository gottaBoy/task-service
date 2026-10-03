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
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFViewTempl;
import net.ibizsys.pscore.srv.config.service.PSPFViewTemplServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSPFViewTemplService
extends PSPFViewTemplServiceBase {
    private static final Log log = LogFactory.getLog(PSPFViewTemplService.class);

    protected boolean onFillEntityKeyValue(PSPFViewTempl pSPFViewTempl, boolean bl) throws Exception {
        if (!bl) {
            PSPFStyle pSPFStyle = pSPFViewTempl.getPSPFStyle();
            pSPFViewTempl.setPSPFId(pSPFStyle.getPSPFId());
            pSPFViewTempl.setPSPFName(pSPFStyle.getPSPFName());
            pSPFViewTempl.setPSPFViewTemplId(KeyValueHelper.genUniqueId((String)pSPFViewTempl.getPSPFId(), (String)pSPFViewTempl.getPSPFStyleId(), (String)pSPFViewTempl.getPSViewTypeId(), (String)pSPFViewTempl.getPSPFPubCodeId()));
            return true;
        }
        return super.onFillEntityKeyValue(pSPFViewTempl, bl);
    }

    @Override
    protected void onBeforeCreate(PSPFViewTempl pSPFViewTempl) throws Exception {
        String string = StringHelper.format((String)"%1$s/%2$s/%3$s/%4$s", (Object)pSPFViewTempl.getPSPFName(), (Object)pSPFViewTempl.getPSPFStyleName(), (Object)pSPFViewTempl.getPSViewTypeName(), (Object)pSPFViewTempl.getPSPFPubCodeName());
        pSPFViewTempl.setPSPFViewTemplName(string);
        super.onBeforeCreate(pSPFViewTempl);
    }
}

