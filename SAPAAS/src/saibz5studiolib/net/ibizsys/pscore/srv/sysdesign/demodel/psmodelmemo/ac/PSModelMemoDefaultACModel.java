/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelmemo.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="124d1539b02133574726d5a923caeff9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELMEMOID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELMEMONAME", format="")})})
public class PSModelMemoDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelMemoDefaultACModel() {
        this.initAnnotation(PSModelMemoDefaultACModel.class);
    }
}

