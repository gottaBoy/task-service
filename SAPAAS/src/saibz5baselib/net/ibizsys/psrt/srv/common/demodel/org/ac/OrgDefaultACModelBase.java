/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.org.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e3e158d75b7bc6f589686b6e1beb966c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="ORGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="ORGNAME", format="")})})
public abstract class OrgDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public OrgDefaultACModelBase() {
        this.initAnnotation(OrgDefaultACModelBase.class);
    }
}

