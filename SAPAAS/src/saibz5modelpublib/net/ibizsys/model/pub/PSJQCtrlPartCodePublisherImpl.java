/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.pub.PSPFCtrlPartCodePublisherImpl
 */
package net.ibizsys.model.pub;

import java.util.HashMap;
import net.ibizsys.model.pub.PSJQTemplHelper;
import net.ibizsys.model.pub.PSPFCtrlPartCodePublisherImpl;

public class PSJQCtrlPartCodePublisherImpl
extends PSPFCtrlPartCodePublisherImpl {
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSJQTemplHelper.fillParams(params);
    }
}

