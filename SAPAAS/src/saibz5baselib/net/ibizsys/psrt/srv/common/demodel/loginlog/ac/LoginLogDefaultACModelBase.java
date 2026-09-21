/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.loginlog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7628b30c66aaeab68c9aec1aed3f7e21", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="LOGINLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="LOGINLOGNAME", format="")})})
public abstract class LoginLogDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public LoginLogDefaultACModelBase() {
        this.initAnnotation(LoginLogDefaultACModelBase.class);
    }
}

