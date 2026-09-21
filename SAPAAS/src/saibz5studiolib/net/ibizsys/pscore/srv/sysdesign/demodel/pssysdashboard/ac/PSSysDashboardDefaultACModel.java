/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdashboard.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3d4077750a53279c6f8d0fb0315ed691", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDASHBOARDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDASHBOARDNAME", format="")})})
public class PSSysDashboardDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDashboardDefaultACModel() {
        this.initAnnotation(PSSysDashboardDefaultACModel.class);
    }
}

