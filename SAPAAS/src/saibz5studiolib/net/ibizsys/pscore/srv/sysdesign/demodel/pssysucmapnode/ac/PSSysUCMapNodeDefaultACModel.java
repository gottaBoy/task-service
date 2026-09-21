/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysucmapnode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a55daff1d9530a31c1080b457f721cdd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSUCMAPNODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSUCMAPNODENAME", format="")})})
public class PSSysUCMapNodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysUCMapNodeDefaultACModel() {
        this.initAnnotation(PSSysUCMapNodeDefaultACModel.class);
    }
}

