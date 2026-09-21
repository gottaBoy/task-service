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
import net.ibizsys.pscore.srv.config.entity.PSPFCtrlTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFCtrlTemplServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSPFCtrlTemplService
extends PSPFCtrlTemplServiceBase {
    private static final Log log = LogFactory.getLog(PSPFCtrlTemplService.class);

    protected boolean onFillEntityKeyValue(PSPFCtrlTempl pSPFCtrlTempl, boolean bl) throws Exception {
        if (!bl) {
            PSPFStyle pSPFStyle = pSPFCtrlTempl.getPSPFStyle();
            pSPFCtrlTempl.setPSPFId(pSPFStyle.getPSPFId());
            pSPFCtrlTempl.setPSPFName(pSPFStyle.getPSPFName());
            pSPFCtrlTempl.setPSPFCtrlTemplId(KeyValueHelper.genUniqueId((String)pSPFCtrlTempl.getPSPFId(), (String)pSPFCtrlTempl.getPSPFStyleId(), (String)pSPFCtrlTempl.getPSCtrlTypeId(), (String)pSPFCtrlTempl.getPSPFPubCodeId()));
            return true;
        }
        return super.onFillEntityKeyValue((IEntity)pSPFCtrlTempl, bl);
    }

    @Override
    protected void onBeforeCreate(PSPFCtrlTempl pSPFCtrlTempl) throws Exception {
        String string = StringHelper.format((String)"%1$s/%2$s/%3$s/%4$s", (Object)pSPFCtrlTempl.getPSPFName(), (Object)pSPFCtrlTempl.getPSPFStyleName(), (Object)pSPFCtrlTempl.getPSCtrlTypeName(), (Object)pSPFCtrlTempl.getPSPFPubCodeName());
        pSPFCtrlTempl.setPSPFCtrlTemplName(string);
        super.onBeforeCreate(pSPFCtrlTempl);
    }
}

