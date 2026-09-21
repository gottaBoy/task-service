/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDEEditFormPortlet;
import SA.SRFDA.PS.Core.Res.PSSysPortletImpl;

@PSModelIgnoreMeta
public class PSSysDEEditFormPortletImpl
extends PSSysPortletImpl
implements IPSSysDEEditFormPortlet {
    @Override
    public String getPSDEEditFormId() {
        return this.psSysPortlet.getPSDEFORMID();
    }
}

