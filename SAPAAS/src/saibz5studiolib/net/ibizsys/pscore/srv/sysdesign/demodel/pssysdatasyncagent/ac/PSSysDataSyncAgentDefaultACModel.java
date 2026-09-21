/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdatasyncagent.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0e3c942968e534e38a18bd834bf9df04", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDATASYNCAGENTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDATASYNCAGENTNAME", format="")})})
public class PSSysDataSyncAgentDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDataSyncAgentDefaultACModel() {
        this.initAnnotation(PSSysDataSyncAgentDefaultACModel.class);
    }
}

