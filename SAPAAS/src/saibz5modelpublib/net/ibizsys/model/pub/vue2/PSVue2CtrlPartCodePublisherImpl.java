/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.pub.PSPFCtrlPartCodePublisherImpl
 */
package net.ibizsys.model.pub.vue2;

import java.util.HashMap;
import net.ibizsys.model.pub.PSPFCtrlPartCodePublisherImpl;
import net.ibizsys.model.pub.vue2.PSVue2TemplHelper;

public class PSVue2CtrlPartCodePublisherImpl
extends PSPFCtrlPartCodePublisherImpl {
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSVue2TemplHelper.fillParams(params);
    }
}

