/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.Res.IPSSysDEViewPortlet;
import SA.SRFDA.PS.Core.Res.PSSysPortletImpl;

public class PSSysDEViewPortletImpl
extends PSSysPortletImpl
implements IPSSysDEViewPortlet {
    @Override
    public String getPSDEViewId() {
        return this.psSysPortlet.getPSDEVIEWID();
    }
}

