/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuserrole.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b80fbe23ae4241d4d8e0c2bf991b6cd7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEUSERROLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEUSERROLENAME", format="")})})
public class PSDEUserRoleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEUserRoleDefaultACModel() {
        this.initAnnotation(PSDEUserRoleDefaultACModel.class);
    }
}

