/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageItemServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSLanguageItemService
extends PSLanguageItemServiceBase {
    private static final Log log = LogFactory.getLog(PSLanguageItemService.class);

    @Override
    protected boolean onFillEntityKeyValue(PSLanguageItem pSLanguageItem, boolean bl) throws Exception {
        if (!bl && !PSLanguageItemService.isImpSysModelNowEx() && pSLanguageItem.isPSSystemIdDirty() && pSLanguageItem.isPSLanguageIdDirty() && pSLanguageItem.isPSLanguageResIdDirty()) {
            PSLanguageItem pSLanguageItem2 = new PSLanguageItem();
            pSLanguageItem2.setPSSystemId(pSLanguageItem.getPSSystemId());
            pSLanguageItem2.setPSLanguageId(pSLanguageItem.getPSLanguageId());
            pSLanguageItem2.setPSLanguageResId(pSLanguageItem.getPSLanguageResId());
            if (this.select(pSLanguageItem2, true)) {
                pSLanguageItem.setPSLanguageItemId(pSLanguageItem2.getPSLanguageItemId());
                return true;
            }
        }
        return super.onFillEntityKeyValue(pSLanguageItem, bl);
    }

    @Override
    protected void onBeforeCreate(PSLanguageItem pSLanguageItem) throws Exception {
        pSLanguageItem.setPSLanguageItemName(StringHelper.format((String)"%1$s.%2$s", (Object)pSLanguageItem.getPSLanguageId(), (Object)pSLanguageItem.getPSLanguageRes().getLanResTag()));
        if (StringHelper.length((String)pSLanguageItem.getContent()) > 2000) {
            pSLanguageItem.setContent2(pSLanguageItem.getContent());
            pSLanguageItem.setContent(null);
        } else {
            pSLanguageItem.setContent2(null);
        }
        super.onBeforeCreate(pSLanguageItem);
    }

    @Override
    protected void onBeforeUpdate(PSLanguageItem pSLanguageItem) throws Exception {
        if (StringHelper.length((String)pSLanguageItem.getContent()) > 2000) {
            pSLanguageItem.setContent2(pSLanguageItem.getContent());
            pSLanguageItem.setContent(null);
        } else {
            pSLanguageItem.setContent2(null);
        }
        super.onBeforeUpdate(pSLanguageItem);
    }

    @Override
    protected CallResult internalGetTemp(PSLanguageItem pSLanguageItem, boolean bl) throws Exception {
        CallResult callResult = super.internalGetTemp(pSLanguageItem, bl);
        if (callResult.isOk() && !StringHelper.isNullOrEmpty((String)pSLanguageItem.getContent2())) {
            pSLanguageItem.setContent(pSLanguageItem.getContent2());
        }
        return callResult;
    }

    @Override
    protected String getModelV2Key(String string, String string2, String string3, String string4) throws Exception {
        String string5 = super.getModelV2Key(string, string2, string3, string4);
        if (StringHelper.isNullOrEmpty((String)string5) && string.equalsIgnoreCase("PSLANGUAGERES")) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s](%2$s)", (Object)string, (Object)string2));
        }
        return string5;
    }
}

