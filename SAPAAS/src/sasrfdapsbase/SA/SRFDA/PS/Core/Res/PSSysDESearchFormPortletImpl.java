/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDESearchFormPortlet;
import SA.SRFDA.PS.Core.Res.PSSysPortletImpl;

@PSModelIgnoreMeta
public class PSSysDESearchFormPortletImpl
extends PSSysPortletImpl
implements IPSSysDESearchFormPortlet {
    @Override
    public String getPSDESearchFormId() {
        return this.psSysPortlet.getPSDEFORMID();
    }
}

