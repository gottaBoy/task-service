/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeacmode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1472a28b90b557d82b46be7eff3ed0d7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEACMODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEACMODENAME", format="")})})
public class PSDEACModeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEACModeDefaultACModel() {
        this.initAnnotation(PSDEACModeDefaultACModel.class);
    }
}

