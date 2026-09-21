/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="318cc88cf5339d76e6c97a6b635d20f2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVPRDVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVPRDVERNAME", format="")})})
public class PSDevPrdVerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevPrdVerDefaultACModel() {
        this.initAnnotation(PSDevPrdVerDefaultACModel.class);
    }
}

