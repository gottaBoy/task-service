/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.pub.PSPFCtrlPartCodePublisherImpl
 */
package net.ibizsys.model.pub.angularga;

import java.util.HashMap;
import net.ibizsys.model.pub.PSPFCtrlPartCodePublisherImpl;
import net.ibizsys.model.pub.angularga.PSAngularTemplHelper;

public class PSAngularCtrlPartCodePublisherImpl
extends PSPFCtrlPartCodePublisherImpl {
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSAngularTemplHelper.fillParams(params);
    }
}

