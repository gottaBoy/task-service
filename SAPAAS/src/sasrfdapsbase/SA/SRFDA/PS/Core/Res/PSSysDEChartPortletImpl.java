/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDEChartPortlet;
import SA.SRFDA.PS.Core.Res.PSSysPortletImpl;

@PSModelPFIgnoreMeta
public class PSSysDEChartPortletImpl
extends PSSysPortletImpl
implements IPSSysDEChartPortlet {
    @Override
    public String getPSDEChartId() {
        return this.psSysPortlet.getPSDECHARTID();
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

