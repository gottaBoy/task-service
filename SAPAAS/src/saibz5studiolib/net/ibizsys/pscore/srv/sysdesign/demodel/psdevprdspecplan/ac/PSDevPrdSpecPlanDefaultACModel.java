/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdspecplan.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5f4e367cc6665502ce8e7a0027f242d6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVPRDSPECPLANID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVPRDSPECPLANNAME", format="")})})
public class PSDevPrdSpecPlanDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevPrdSpecPlanDefaultACModel() {
        this.initAnnotation(PSDevPrdSpecPlanDefaultACModel.class);
    }
}

