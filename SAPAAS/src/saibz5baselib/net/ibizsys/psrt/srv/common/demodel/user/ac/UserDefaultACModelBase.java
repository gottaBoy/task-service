/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.user.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f4552a6291c79e3934263b31b83aec33", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERNAME", format="")})})
public abstract class UserDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserDefaultACModelBase() {
        this.initAnnotation(UserDefaultACModelBase.class);
    }
}

