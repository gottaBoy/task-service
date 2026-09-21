/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynade.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="54bd30168802d46a85963acf5ddc7a17", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDYNADEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDYNADENAME", format="")})})
public class PSDynaDEDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDynaDEDefaultACModel() {
        this.initAnnotation(PSDynaDEDefaultACModel.class);
    }
}

