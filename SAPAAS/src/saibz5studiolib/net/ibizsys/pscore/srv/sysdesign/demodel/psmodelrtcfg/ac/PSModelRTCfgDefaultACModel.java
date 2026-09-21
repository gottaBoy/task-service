/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelrtcfg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a4638edfae619c9447a1c2eb9d33a99b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELRTCFGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELRTCFGNAME", format="")})})
public class PSModelRTCfgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelRTCfgDefaultACModel() {
        this.initAnnotation(PSModelRTCfgDefaultACModel.class);
    }
}

