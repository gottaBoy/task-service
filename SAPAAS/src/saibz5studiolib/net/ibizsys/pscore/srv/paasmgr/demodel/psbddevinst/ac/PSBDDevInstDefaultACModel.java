/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psbddevinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="eca3e83caaa7ea45f3070b7ba4ea058b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSBDDEVINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSBDDEVINSTNAME", format="")})})
public class PSBDDevInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSBDDevInstDefaultACModel() {
        this.initAnnotation(PSBDDevInstDefaultACModel.class);
    }
}

