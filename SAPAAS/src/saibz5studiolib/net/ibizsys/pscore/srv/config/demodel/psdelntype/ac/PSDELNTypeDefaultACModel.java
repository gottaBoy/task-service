/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdelntype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e0a60fd663524566949089114bb157bd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDELNTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDELNTYPENAME", format="")})})
public class PSDELNTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDELNTypeDefaultACModel() {
        this.initAnnotation(PSDELNTypeDefaultACModel.class);
    }
}

