/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.orgsector.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="63061bfdafbbd213fc0ce66d3f26419e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="ORGSECTORID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="ORGSECTORNAME", format="")})})
public abstract class OrgSectorDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public OrgSectorDefaultACModelBase() {
        this.initAnnotation(OrgSectorDefaultACModelBase.class);
    }
}

