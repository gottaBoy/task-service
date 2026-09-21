/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdetable.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="69f5e17e56704980c78d29a707260f60", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDETABLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDETABLENAME", format="")})})
public class PSDETableDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDETableDefaultACModel() {
        this.initAnnotation(PSDETableDefaultACModel.class);
    }
}

