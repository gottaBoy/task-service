/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userdict.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="de0f12cf67b20fb12eb5454093998c74", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERDICTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERDICTNAME", format="")})})
public abstract class UserDictDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserDictDefaultACModelBase() {
        this.initAnnotation(UserDictDefaultACModelBase.class);
    }
}

