/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelviewuiaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="89f8edbf1ed57f9a7fa3b9289c5ed377", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELVIEWUIACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELVIEWUIACTIONNAME", format="")})})
public class PSModelViewUIActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelViewUIActionDefaultACModel() {
        this.initAnnotation(PSModelViewUIActionDefaultACModel.class);
    }
}

