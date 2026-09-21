/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psworkspacepolicy.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cfce9288b194765c993e9f7792629db9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWORKSPACEPOLICYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWORKSPACEPOLICYNAME", format="")})})
public class PSWorkspacePolicyDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWorkspacePolicyDefaultACModel() {
        this.initAnnotation(PSWorkspacePolicyDefaultACModel.class);
    }
}

