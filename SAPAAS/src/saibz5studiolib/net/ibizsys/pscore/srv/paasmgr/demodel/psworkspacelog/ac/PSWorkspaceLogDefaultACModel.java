/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psworkspacelog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="dce463a369381edfd6b7bef30a14b851", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWORKSPACELOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWORKSPACELOGNAME", format="")})})
public class PSWorkspaceLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWorkspaceLogDefaultACModel() {
        this.initAnnotation(PSWorkspaceLogDefaultACModel.class);
    }
}

