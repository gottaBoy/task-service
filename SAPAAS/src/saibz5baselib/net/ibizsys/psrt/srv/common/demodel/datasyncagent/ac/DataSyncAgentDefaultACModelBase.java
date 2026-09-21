/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.datasyncagent.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="eca73ee23612ec7a94bc4d8f40f3c5dc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DATASYNCAGENTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DATASYNCAGENTNAME", format="")})})
public abstract class DataSyncAgentDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DataSyncAgentDefaultACModelBase() {
        this.initAnnotation(DataSyncAgentDefaultACModelBase.class);
    }
}

