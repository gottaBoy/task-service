/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psdbdevinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9526f3e227261e83ad60b0667c84bf27", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDBDEVINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDBDEVINSTNAME", format="")})})
public class PSDBDevInstDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDBDevInstDefaultACModel() {
        this.initAnnotation(PSDBDevInstDefaultACModel.class);
    }
}

