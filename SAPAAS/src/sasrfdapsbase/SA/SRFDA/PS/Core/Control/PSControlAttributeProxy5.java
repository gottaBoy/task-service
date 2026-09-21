/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.PSControlAttributeProxy2;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelIgnoreMeta
public class PSControlAttributeProxy5
extends PSControlAttributeProxy2 {
    public PSControlAttributeProxy5(IPSControl iPSControl, IPSControlAttribute iPSControlAttribute) {
        super(iPSControl, iPSControlAttribute);
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u540d\u79f0", dump=false)
    public String getItemName() {
        return null;
    }
}

