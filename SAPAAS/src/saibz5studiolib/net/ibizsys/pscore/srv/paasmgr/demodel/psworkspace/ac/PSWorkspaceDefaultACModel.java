/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psworkspace.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b145c54d4e7c77bd81236e1c7e3d90f7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWORKSPACEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWORKSPACENAME", format="")})})
public class PSWorkspaceDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWorkspaceDefaultACModel() {
        this.initAnnotation(PSWorkspaceDefaultACModel.class);
    }
}

