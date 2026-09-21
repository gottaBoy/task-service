/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.orgsecuser.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a29184750c477cf3910fc2179179dccc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="ORGSECUSERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="ORGSECUSERNAME", format="")})})
public abstract class OrgSecUserDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public OrgSecUserDefaultACModelBase() {
        this.initAnnotation(OrgSecUserDefaultACModelBase.class);
    }
}

