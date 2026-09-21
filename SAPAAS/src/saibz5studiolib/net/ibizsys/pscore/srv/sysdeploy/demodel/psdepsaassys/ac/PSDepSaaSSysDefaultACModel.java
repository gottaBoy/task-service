/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepsaassys.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e020b3ffd44224f7b6740ef2b4412ea3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPSAASSYSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPSAASSYSNAME", format="")})})
public class PSDepSaaSSysDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDepSaaSSysDefaultACModel() {
        this.initAnnotation(PSDepSaaSSysDefaultACModel.class);
    }
}

