/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userroleres.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ee84bfb6e336a62bdcd671895549aebe", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERROLERESID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERROLERESNAME", format="")})})
public abstract class UserRoleResDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserRoleResDefaultACModelBase() {
        this.initAnnotation(UserRoleResDefaultACModelBase.class);
    }
}

