/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPortlet;

@PSModelPFIgnoreMeta
public interface IPSSysDEChartPortlet
extends IPSSysPortlet {
    public String getPSDEChartId();

    public String getPSDEDataSetId();

    public String getActiveDataPSDELogicId();

    public String getCustomCond();
}

