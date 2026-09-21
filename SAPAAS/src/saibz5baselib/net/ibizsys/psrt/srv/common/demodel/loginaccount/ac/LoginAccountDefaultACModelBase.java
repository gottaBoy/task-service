/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.loginaccount.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5ae7d9610693e638cd1064cf7c9126f8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="LOGINACCOUNTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="LOGINACCOUNTNAME", format="")})})
public abstract class LoginAccountDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public LoginAccountDefaultACModelBase() {
        this.initAnnotation(LoginAccountDefaultACModelBase.class);
    }
}

