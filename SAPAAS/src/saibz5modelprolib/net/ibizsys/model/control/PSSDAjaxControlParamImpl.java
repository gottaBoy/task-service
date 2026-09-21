/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.IPSSDAjaxControlParam
 */
package net.ibizsys.model.control;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.IPSSDAjaxControlParam;
import net.ibizsys.model.control.PSAjaxControlParamImpl;

public class PSSDAjaxControlParamImpl
extends PSAjaxControlParamImpl
implements IPSSDAjaxControlParam {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSSDAjaxControlParam) {
            IPSSDAjaxControlParam iPSSDAjaxControlParam = (IPSSDAjaxControlParam)iPSControlParam;
        }
    }
}

