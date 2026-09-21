/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPortlet;

@PSModelPFIgnoreMeta
public interface IPSSysDEListPortlet
extends IPSSysPortlet {
    public String getPSDEListId();

    public String getPSDEDataSetId();

    public String getActiveDataPSDELogicId();

    public String getCustomCond();
}

