/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdetoolbar.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="dbdeef536f557441f264db54377c4571", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDETOOLBARID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDETOOLBARNAME", format="")})})
public class PSDEToolbarDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEToolbarDefaultACModel() {
        this.initAnnotation(PSDEToolbarDefaultACModel.class);
    }
}

