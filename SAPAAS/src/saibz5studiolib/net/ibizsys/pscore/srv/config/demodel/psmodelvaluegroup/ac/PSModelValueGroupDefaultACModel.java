/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelvaluegroup.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6a7c6686ef8a7d79c574256fc77e864c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELVALUEGROUPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELVALUEGROUPNAME", format="")})})
public class PSModelValueGroupDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelValueGroupDefaultACModel() {
        this.initAnnotation(PSModelValueGroupDefaultACModel.class);
    }
}

