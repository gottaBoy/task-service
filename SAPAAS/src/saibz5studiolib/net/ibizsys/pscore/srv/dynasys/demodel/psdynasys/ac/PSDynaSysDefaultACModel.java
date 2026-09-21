/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynasys.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3f2c0afbec2243b9dea049851b8a5e94", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNASYSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNASYSNAME", format="")})})
public class PSDynaSysDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaSysDefaultACModel() {
        this.initAnnotation(PSDynaSysDefaultACModel.class);
    }
}

