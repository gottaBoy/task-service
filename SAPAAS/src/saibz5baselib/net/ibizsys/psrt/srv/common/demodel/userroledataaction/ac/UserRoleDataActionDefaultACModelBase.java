/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userroledataaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0cc63f54de2a15b9a7db47ff805af49a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERROLEDATAACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERROLEDATAACTIONNAME", format="")})})
public abstract class UserRoleDataActionDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserRoleDataActionDefaultACModelBase() {
        this.initAnnotation(UserRoleDataActionDefaultACModelBase.class);
    }
}

