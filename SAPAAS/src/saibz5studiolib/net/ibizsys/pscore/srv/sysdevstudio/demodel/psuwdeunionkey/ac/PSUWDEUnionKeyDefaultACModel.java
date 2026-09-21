/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwdeunionkey.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ff4142b4c7c73f3ec5a4a22187fda49d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUWDEUNIONKEYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUWDEUNIONKEYNAME", format="")})})
public class PSUWDEUnionKeyDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUWDEUnionKeyDefaultACModel() {
        this.initAnnotation(PSUWDEUnionKeyDefaultACModel.class);
    }
}

