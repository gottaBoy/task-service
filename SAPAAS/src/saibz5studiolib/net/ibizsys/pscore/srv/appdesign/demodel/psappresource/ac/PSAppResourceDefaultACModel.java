/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappresource.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f3bd56dabf64e720690350aa9f07dda5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPRESOURCEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPRESOURCENAME", format="")})})
public class PSAppResourceDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppResourceDefaultACModel() {
        this.initAnnotation(PSAppResourceDefaultACModel.class);
    }
}

