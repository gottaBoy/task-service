/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERMultiInherit;
import SA.SRFDA.PS.Core.DataEntity.DER.PSDERInheritImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelPFIgnoreMeta
public class PSDERMultiInheritImpl
extends PSDERInheritImpl
implements IPSDERMultiInherit {
    @Override
    @PSModelRTMeta(description="\u5355\u7ee7\u627f\u5173\u7cfb", ignoredumpvalues="false", doc="\u6052\u4e3afalse", staticcode="false")
    public boolean isSingleInherit() {
        return false;
    }
}

