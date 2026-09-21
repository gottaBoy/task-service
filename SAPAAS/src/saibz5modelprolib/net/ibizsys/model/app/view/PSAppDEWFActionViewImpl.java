/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEWFActionView
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppDEWFActionView;
import net.ibizsys.model.app.view.PSAppDEEditViewImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSAppDEWFActionViewImpl
extends PSAppDEEditViewImpl
implements IPSAppDEWFActionView {
    @Override
    protected void onInit() throws Exception {
        this.setWFIAMode(true);
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6d41\u7a0b")
    public boolean isEnableWF() {
        return this.getPSDEWF() != null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6253\u5f00\u6a21\u5f0f", codelist="DEViewOpenMode")
    public String getOpenMode() {
        String strOpenMode = super.getOpenMode();
        if (StringHelper.isNullOrEmpty((String)strOpenMode)) {
            return "POPUPMODAL";
        }
        return strOpenMode;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u4ea4\u4e92\u6a21\u5f0f")
    public boolean isWFIAMode() {
        return super.isWFIAMode();
    }

    @Override
    @PSModelRTMeta(description="\u7ed1\u5b9a\u6d41\u7a0b\u6b65\u9aa4\u503c", hideempty2=true)
    public String getWFStepValue() {
        return super.getWFStepValue();
    }
}

