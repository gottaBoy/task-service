/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysdsaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0874c6f1fe4ffdb6cba439ae1fff1475", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDSACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDSACTIONNAME", format="")})})
public class PSSysDSActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDSActionDefaultACModel() {
        this.initAnnotation(PSSysDSActionDefaultACModel.class);
    }
}

