/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.dalog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4f42003f518ff9e8ba0c1d582a3b70d5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="DALOG_ID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="DALOG_NAME", format="")})})
public abstract class DALogDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public DALogDefaultACModelBase() {
        this.initAnnotation(DALogDefaultACModelBase.class);
    }
}

