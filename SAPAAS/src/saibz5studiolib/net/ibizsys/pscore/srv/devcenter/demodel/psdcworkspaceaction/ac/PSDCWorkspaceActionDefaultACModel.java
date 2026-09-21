/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspaceaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b92e7b268209bf52d80f1a37083b2526", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCWORKSPACEACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCWORKSPACEACTIONNAME", format="")})})
public class PSDCWorkspaceActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCWorkspaceActionDefaultACModel() {
        this.initAnnotation(PSDCWorkspaceActionDefaultACModel.class);
    }
}

