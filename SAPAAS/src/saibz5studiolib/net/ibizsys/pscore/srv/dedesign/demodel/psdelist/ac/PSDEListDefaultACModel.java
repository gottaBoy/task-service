/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdelist.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f356992d260198428c961199272b22fe", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDELISTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDELISTNAME", format="")})})
public class PSDEListDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEListDefaultACModel() {
        this.initAnnotation(PSDEListDefaultACModel.class);
    }
}

