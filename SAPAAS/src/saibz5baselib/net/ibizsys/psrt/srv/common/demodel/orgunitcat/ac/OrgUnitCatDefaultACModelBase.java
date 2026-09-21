/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.orgunitcat.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="37c7b65732fb7013db7c970d1262e849", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="ORGUNITCATID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="ORGUNITCATNAME", format="")})})
public abstract class OrgUnitCatDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public OrgUnitCatDefaultACModelBase() {
        this.initAnnotation(OrgUnitCatDefaultACModelBase.class);
    }
}

