/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSPFStyle;

@PSModelIgnoreMeta
public interface IPSPF2
extends IPSPF {
    public IPSPFStyle createPSPFStyle(PSPFStyle var1) throws Exception;

    public String getViewPubObj2();

    public String getViewPubObj2MacroParams();
}

