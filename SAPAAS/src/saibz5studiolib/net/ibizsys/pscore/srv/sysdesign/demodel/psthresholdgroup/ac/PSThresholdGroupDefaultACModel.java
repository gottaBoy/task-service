/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psthresholdgroup.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="75fab73ef6edf67a6af1bbea981140af", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSTHRESHOLDGROUPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSTHRESHOLDGROUPNAME", format="")})})
public class PSThresholdGroupDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSThresholdGroupDefaultACModel() {
        this.initAnnotation(PSThresholdGroupDefaultACModel.class);
    }
}

