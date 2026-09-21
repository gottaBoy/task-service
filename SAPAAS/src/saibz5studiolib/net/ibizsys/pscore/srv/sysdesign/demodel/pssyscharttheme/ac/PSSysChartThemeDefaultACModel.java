/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscharttheme.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6119a0291a00c323d6cad0a278a3f85c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSCHARTTHEMEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSCHARTTHEMENAME", format="")})})
public class PSSysChartThemeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysChartThemeDefaultACModel() {
        this.initAnnotation(PSSysChartThemeDefaultACModel.class);
    }
}

