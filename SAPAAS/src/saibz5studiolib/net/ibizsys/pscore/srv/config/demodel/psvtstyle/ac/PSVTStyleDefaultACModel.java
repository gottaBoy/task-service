/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psvtstyle.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="790d92ec59b46bd6a0147dc2a53eddc2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVTSTYLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVTSTYLENAME", format="")})})
public class PSVTStyleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSVTStyleDefaultACModel() {
        this.initAnnotation(PSVTStyleDefaultACModel.class);
    }
}

