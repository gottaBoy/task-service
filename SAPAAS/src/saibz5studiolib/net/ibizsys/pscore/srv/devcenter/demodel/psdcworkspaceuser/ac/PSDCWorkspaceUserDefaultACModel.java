/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspaceuser.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="25cde3eccbe9344e99ad9d6fbb7d075b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCWORKSPACEUSERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCWORKSPACEUSERNAME", format="")})})
public class PSDCWorkspaceUserDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCWorkspaceUserDefaultACModel() {
        this.initAnnotation(PSDCWorkspaceUserDefaultACModel.class);
    }
}

