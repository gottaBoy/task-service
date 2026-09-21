/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.expbar.IPSExpBar
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub.vue2;

import java.util.HashMap;
import net.ibizsys.model.control.expbar.IPSExpBar;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.vue2.PSVue2CtrlCodePublisherImpl;

public class PSVue2ExpBarViewCodePublisherImpl
extends PSVue2CtrlCodePublisherImpl {
    protected IPSExpBar iPSExpBar = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSExpBar = (IPSExpBar)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
    }
}

