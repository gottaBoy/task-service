/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userdgtheme.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="dfe988181f007801f103fd18e8a5661b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERDGTHEMEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERDGTHEMENAME", format="")})})
public abstract class UserDGThemeDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserDGThemeDefaultACModelBase() {
        this.initAnnotation(UserDGThemeDefaultACModelBase.class);
    }
}

