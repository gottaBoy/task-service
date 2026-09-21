/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeGridEx;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSControl", typevalues={"TREEGRIDEX"})
public class PSDETreeGridExImpl
extends PSDETreeImpl
implements IPSDETreeGridEx {
    @Override
    protected String onGetControlType() {
        return "TREEGRIDEX";
    }

    @Override
    public String getModelType() {
        return "PSDETREEGRIDEX";
    }
}

