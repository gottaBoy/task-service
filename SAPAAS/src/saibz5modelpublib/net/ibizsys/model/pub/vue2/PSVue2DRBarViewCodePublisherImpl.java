/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.drctrl.IPSDRBar
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub.vue2;

import java.util.HashMap;
import net.ibizsys.model.control.drctrl.IPSDRBar;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.vue2.PSVue2CtrlCodePublisherImpl;

public class PSVue2DRBarViewCodePublisherImpl
extends PSVue2CtrlCodePublisherImpl {
    protected IPSDRBar iPSDRBar = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDRBar = (IPSDRBar)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
    }
}

