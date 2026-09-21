/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdsyssync.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="6c9193b3ee7a55f4699d2da483bcc6ab", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVPRDSYSSYNCID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVPRDSYSSYNCNAME", format="")})})
public class PSDevPrdSysSyncDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevPrdSysSyncDefaultACModel() {
        this.initAnnotation(PSDevPrdSysSyncDefaultACModel.class);
    }
}

