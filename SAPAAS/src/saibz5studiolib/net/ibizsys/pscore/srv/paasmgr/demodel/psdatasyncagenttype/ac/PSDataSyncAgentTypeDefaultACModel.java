/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psdatasyncagenttype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4a4643382483ad791e4ea6d414fd8c37", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDATASYNCAGENTTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDATASYNCAGENTTYPENAME", format="")})})
public class PSDataSyncAgentTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDataSyncAgentTypeDefaultACModel() {
        this.initAnnotation(PSDataSyncAgentTypeDefaultACModel.class);
    }
}

