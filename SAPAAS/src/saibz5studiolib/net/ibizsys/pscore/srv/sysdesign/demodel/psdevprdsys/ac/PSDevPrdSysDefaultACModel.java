/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdsys.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="91aa9c57322abc84315d1e95202f6d16", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVPRDSYSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVPRDSYSNAME", format="")})})
public class PSDevPrdSysDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevPrdSysDefaultACModel() {
        this.initAnnotation(PSDevPrdSysDefaultACModel.class);
    }
}

