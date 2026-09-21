/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynadeforminst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2ba3e8d9061a1fe707e29a4418952dae", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNADEFORMINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNADEFORMINSTNAME", format="")})})
public class PSDynaDEFormInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaDEFormInstDefaultACModel() {
        this.initAnnotation(PSDynaDEFormInstDefaultACModel.class);
    }
}

