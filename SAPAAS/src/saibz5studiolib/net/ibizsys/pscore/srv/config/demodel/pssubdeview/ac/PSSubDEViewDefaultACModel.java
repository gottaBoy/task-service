/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubdeview.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="11954f6963dd50954e88a931a7f837a6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSUBDEVIEWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSUBDEVIEWNAME", format="")})})
public class PSSubDEViewDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSubDEViewDefaultACModel() {
        this.initAnnotation(PSSubDEViewDefaultACModel.class);
    }
}

