/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pscountertype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9fed1fa4d86090aaa62e81ed4b51114f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCOUNTERTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCOUNTERTYPENAME", format="")})})
public class PSCounterTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCounterTypeDefaultACModel() {
        this.initAnnotation(PSCounterTypeDefaultACModel.class);
    }
}

