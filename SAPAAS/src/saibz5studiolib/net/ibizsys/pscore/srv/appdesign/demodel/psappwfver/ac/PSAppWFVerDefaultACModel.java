/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappwfver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c8b4cfcb87b9722c609309ec77cb64bf", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPWFVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPWFVERNAME", format="")})})
public class PSAppWFVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppWFVerDefaultACModel() {
        this.initAnnotation(PSAppWFVerDefaultACModel.class);
    }
}

