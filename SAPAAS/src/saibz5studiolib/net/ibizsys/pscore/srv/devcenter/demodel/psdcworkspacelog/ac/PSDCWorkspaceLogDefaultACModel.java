/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspacelog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4a94fb6ee54cb4e21f0a8a82a5fca5cd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCWORKSPACELOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCWORKSPACELOGNAME", format="")})})
public class PSDCWorkspaceLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCWorkspaceLogDefaultACModel() {
        this.initAnnotation(PSDCWorkspaceLogDefaultACModel.class);
    }
}

