/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSSDAjaxControlParam;
import SA.SRFDA.PS.Core.Control.PSAjaxControlParamImpl;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelRTIgnoreMeta
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

