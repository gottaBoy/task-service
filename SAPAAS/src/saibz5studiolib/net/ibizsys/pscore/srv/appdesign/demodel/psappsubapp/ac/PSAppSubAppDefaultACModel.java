/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappsubapp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e7663fe97e0100a33a9aac74b48d9ede", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPSUBAPPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPSUBAPPNAME", format="")})})
public class PSAppSubAppDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppSubAppDefaultACModel() {
        this.initAnnotation(PSAppSubAppDefaultACModel.class);
    }
}

