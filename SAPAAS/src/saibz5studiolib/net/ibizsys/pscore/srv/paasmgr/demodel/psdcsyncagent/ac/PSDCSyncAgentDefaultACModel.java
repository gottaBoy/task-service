/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psdcsyncagent.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cdf5246889771140906e81a149e34dbd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCSYNCAGENTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCSYNCAGENTNAME", format="")})})
public class PSDCSyncAgentDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCSyncAgentDefaultACModel() {
        this.initAnnotation(PSDCSyncAgentDefaultACModel.class);
    }
}

