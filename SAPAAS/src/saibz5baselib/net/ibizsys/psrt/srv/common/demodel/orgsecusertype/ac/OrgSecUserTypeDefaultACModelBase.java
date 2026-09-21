/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.orgsecusertype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="576dd33b28a3ee34ba68561c68aa93b3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="ORGSECUSERTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="ORGSECUSERTYPENAME", format="")})})
public abstract class OrgSecUserTypeDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public OrgSecUserTypeDefaultACModelBase() {
        this.initAnnotation(OrgSecUserTypeDefaultACModelBase.class);
    }
}

