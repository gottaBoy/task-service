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
import net.ibizsys.pscore.srv.config.entity.PSPFVLTempl;
import net.ibizsys.pscore.srv.config.service.PSPFVLTemplServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSPFVLTemplService
extends PSPFVLTemplServiceBase {
    private static final Log log = LogFactory.getLog(PSPFVLTemplService.class);

    protected boolean onFillEntityKeyValue(PSPFVLTempl pSPFVLTempl, boolean bl) throws Exception {
        if (!bl) {
            PSPFStyle pSPFStyle = pSPFVLTempl.getPSPFStyle();
            pSPFVLTempl.setPSPFId(pSPFStyle.getPSPFId());
            pSPFVLTempl.setPSPFName(pSPFStyle.getPSPFName());
            pSPFVLTempl.setPSPFVLTemplId(KeyValueHelper.genUniqueId((String)pSPFVLTempl.getPSPFId(), (String)pSPFVLTempl.getPSPFStyleId(), (String)pSPFVLTempl.getPSViewLogicTypeId(), (String)pSPFVLTempl.getPSPFPubCodeId()));
            return true;
        }
        return super.onFillEntityKeyValue(pSPFVLTempl, bl);
    }

    @Override
    protected void onBeforeCreate(PSPFVLTempl pSPFVLTempl) throws Exception {
        String string = StringHelper.format((String)"%1$s/%2$s/%3$s/%4$s", (Object)pSPFVLTempl.getPSPFName(), (Object)pSPFVLTempl.getPSPFStyleName(), (Object)pSPFVLTempl.getPSViewLogicTypeName(), (Object)pSPFVLTempl.getPSPFPubCodeName());
        pSPFVLTempl.setPSPFVLTemplName(string);
        super.onBeforeCreate(pSPFVLTempl);
    }
}

