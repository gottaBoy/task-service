/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.Res.IPSSysDEListPortlet;
import SA.SRFDA.PS.Core.Res.PSSysPortletImpl;

public class PSSysDEListPortletImpl
extends PSSysPortletImpl
implements IPSSysDEListPortlet {
    @Override
    public String getPSDEListId() {
        return this.psSysPortlet.getPSDELISTID();
    }

    @Override
    public String getPSDEDataSetId() {
        return "";
    }

    @Override
    public String getActiveDataPSDELogicId() {
        return "";
    }

    @Override
    public String getCustomCond() {
        return "";
    }
}

