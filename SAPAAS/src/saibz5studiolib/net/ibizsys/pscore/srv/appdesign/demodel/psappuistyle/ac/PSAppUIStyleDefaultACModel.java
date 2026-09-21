/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappuistyle.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ce706b3bcfd6ccc5ca162e396d79d663", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPUISTYLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPUISTYLENAME", format="")})})
public class PSAppUIStyleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppUIStyleDefaultACModel() {
        this.initAnnotation(PSAppUIStyleDefaultACModel.class);
    }
}

