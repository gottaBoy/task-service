/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDynaDEView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDynaDEViewServiceBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEViewTempl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppDynaDEViewService
extends PSAppDynaDEViewServiceBase {
    private static final Log log = LogFactory.getLog(PSAppDynaDEViewService.class);

    @Override
    protected void onBeforeCreate(PSAppDynaDEView pSAppDynaDEView) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSAppDynaDEView.getPSAppDynaDEViewName())) {
            PSDynaDEViewTempl pSDynaDEViewTempl = pSAppDynaDEView.getPSDynaDEViewTempl();
            String string = pSDynaDEViewTempl.getPSDynaDETempl().getTemplPSDE().getCodeName() + pSDynaDEViewTempl.getCodeName();
            pSAppDynaDEView.setPSAppDynaDEViewName(string);
        }
        super.onBeforeCreate(pSAppDynaDEView);
    }

    @Override
    protected boolean onFillEntityKeyValue(PSAppDynaDEView pSAppDynaDEView, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSAppDynaDEView.get("PSSYSAPPID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSAppDynaDEView.get("PSDYNADEVIEWTEMPLID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSAppDynaDEView.set(this.getDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }
}

