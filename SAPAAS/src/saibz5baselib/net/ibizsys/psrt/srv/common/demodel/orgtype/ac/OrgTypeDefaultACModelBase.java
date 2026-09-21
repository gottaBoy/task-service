/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.orgtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3bb1f0b62e66ff93dc5929eb8794751a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="ORGTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="ORGTYPENAME", format="")})})
public abstract class OrgTypeDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public OrgTypeDefaultACModelBase() {
        this.initAnnotation(OrgTypeDefaultACModelBase.class);
    }
}

