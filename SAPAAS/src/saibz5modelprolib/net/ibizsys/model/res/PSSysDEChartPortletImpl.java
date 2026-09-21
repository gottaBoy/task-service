/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.res;

import net.ibizsys.model.res.IPSSysDEChartPortlet;
import net.ibizsys.model.res.PSSysPortletImpl;

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
}

