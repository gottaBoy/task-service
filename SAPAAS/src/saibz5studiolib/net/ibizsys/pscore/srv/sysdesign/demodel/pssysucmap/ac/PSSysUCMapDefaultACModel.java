/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysucmap.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4c192dba86be7a854917d7f19b71cf73", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSUCMAPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSUCMAPNAME", format="")})})
public class PSSysUCMapDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysUCMapDefaultACModel() {
        this.initAnnotation(PSSysUCMapDefaultACModel.class);
    }
}

