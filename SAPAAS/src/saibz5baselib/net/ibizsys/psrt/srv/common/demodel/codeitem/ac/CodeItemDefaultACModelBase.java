/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.codeitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="60a039b41c39edc7ff965f1c0958232d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="CODEITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="CODEITEMNAME", format="")})})
public abstract class CodeItemDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public CodeItemDefaultACModelBase() {
        this.initAnnotation(CodeItemDefaultACModelBase.class);
    }
}

