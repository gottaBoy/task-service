/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdemapaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f1fa228e3cfffa85a87d415ec5a694c7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEMAPACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEMAPACTIONNAME", format="")})})
public class PSDEMapActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEMapActionDefaultACModel() {
        this.initAnnotation(PSDEMapActionDefaultACModel.class);
    }
}

