/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.PSControlRenderProxy2;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelIgnoreMeta
public class PSControlRenderProxy5
extends PSControlRenderProxy2 {
    public PSControlRenderProxy5(IPSControl iPSControl, IPSControlRender iPSControlRender) {
        super(iPSControl, iPSControlRender);
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u540d\u79f0", dump=false)
    public String getItemName() {
        return null;
    }
}

