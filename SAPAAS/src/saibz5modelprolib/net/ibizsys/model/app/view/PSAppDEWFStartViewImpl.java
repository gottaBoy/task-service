/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.PSAppDEWFEditViewImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSAppDEWFStartViewImpl
extends PSAppDEWFEditViewImpl {
    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6253\u5f00\u6a21\u5f0f", codelist="DEViewOpenMode")
    public String getOpenMode() {
        String strOpenMode = super.getOpenMode();
        if (StringHelper.isNullOrEmpty((String)strOpenMode)) {
            return "POPUPMODAL";
        }
        return strOpenMode;
    }
}

