/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.userroledefields.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c95a8972b0f72a140d65e057a002144a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="USERROLEDEFIELDSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="USERROLEDEFIELDSNAME", format="")})})
public abstract class UserRoleDEFieldsDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public UserRoleDEFieldsDefaultACModelBase() {
        this.initAnnotation(UserRoleDEFieldsDefaultACModelBase.class);
    }
}

