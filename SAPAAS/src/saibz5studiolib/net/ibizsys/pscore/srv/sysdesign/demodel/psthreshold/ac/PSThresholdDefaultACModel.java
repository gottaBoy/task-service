/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psthreshold.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="63972a4b40b75ed4f61695978929cce5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSTHRESHOLDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSTHRESHOLDNAME", format="")})})
public class PSThresholdDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSThresholdDefaultACModel() {
        this.initAnnotation(PSThresholdDefaultACModel.class);
    }
}

