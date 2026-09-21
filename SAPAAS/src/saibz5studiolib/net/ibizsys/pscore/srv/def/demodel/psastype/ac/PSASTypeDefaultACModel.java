/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.def.demodel.psastype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="343f69645820bfb02e34a8ddaa08750e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSASTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSASTYPENAME", format="")})})
public class PSASTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSASTypeDefaultACModel() {
        this.initAnnotation(PSASTypeDefaultACModel.class);
    }
}

