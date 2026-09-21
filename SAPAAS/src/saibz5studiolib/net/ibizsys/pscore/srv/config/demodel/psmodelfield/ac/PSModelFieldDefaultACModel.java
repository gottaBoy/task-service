/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelfield.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="40830b16d62c29e23d3930802ac2be02", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELFIELDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELFIELDNAME", format="")})})
public class PSModelFieldDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelFieldDefaultACModel() {
        this.initAnnotation(PSModelFieldDefaultACModel.class);
    }
}

