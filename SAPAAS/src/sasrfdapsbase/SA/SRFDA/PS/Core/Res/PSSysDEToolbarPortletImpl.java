/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.Res.IPSSysDEToolbarPortlet;
import SA.SRFDA.PS.Core.Res.PSSysPortletImpl;

public class PSSysDEToolbarPortletImpl
extends PSSysPortletImpl
implements IPSSysDEToolbarPortlet {
    @Override
    public String getPSDEToolbarId() {
        return this.psSysPortlet.getPSDETOOLBARID();
    }
}

