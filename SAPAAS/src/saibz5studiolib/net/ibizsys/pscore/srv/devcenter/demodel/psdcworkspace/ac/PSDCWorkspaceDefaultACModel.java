/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9e13adb2a6339405a8ca039107c50f30", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCWORKSPACEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCWORKSPACENAME", format="")})})
public class PSDCWorkspaceDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCWorkspaceDefaultACModel() {
        this.initAnnotation(PSDCWorkspaceDefaultACModel.class);
    }
}

