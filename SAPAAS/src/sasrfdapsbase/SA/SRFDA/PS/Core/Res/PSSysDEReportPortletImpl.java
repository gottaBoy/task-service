/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDEReportPortlet;
import SA.SRFDA.PS.Core.Res.PSSysPortletImpl;

@PSModelPFIgnoreMeta
public class PSSysDEReportPortletImpl
extends PSSysPortletImpl
implements IPSSysDEReportPortlet {
    @Override
    public String getPSDEReportId() {
        return this.psSysPortlet.getPSDEREPORTID();
    }
}

