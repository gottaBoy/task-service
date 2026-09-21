/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysusermode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8c3f24e69cfac64c3bf2345241281b3d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSUSERMODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSUSERMODENAME", format="")})})
public class PSSysUserModeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysUserModeDefaultACModel() {
        this.initAnnotation(PSSysUserModeDefaultACModel.class);
    }
}

