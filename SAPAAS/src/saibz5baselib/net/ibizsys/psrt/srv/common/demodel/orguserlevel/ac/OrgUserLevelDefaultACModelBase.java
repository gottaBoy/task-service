/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.orguserlevel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e6c870c62a861cfd5593212fa41d6f88", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="ORGUSERLEVELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="ORGUSERLEVELNAME", format="")})})
public abstract class OrgUserLevelDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public OrgUserLevelDefaultACModelBase() {
        this.initAnnotation(OrgUserLevelDefaultACModelBase.class);
    }
}

