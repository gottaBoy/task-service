/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userobject.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="318a3649ecafa3b934925a0231207d09", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USEROBJECTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USEROBJECTNAME", format="")})})
public abstract class UserObjectDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserObjectDefaultACModelBase() {
        this.initAnnotation(UserObjectDefaultACModelBase.class);
    }
}

