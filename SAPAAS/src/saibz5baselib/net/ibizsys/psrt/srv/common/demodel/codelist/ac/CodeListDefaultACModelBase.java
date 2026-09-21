/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.codelist.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="85317205b415aa6af990684ca7704515", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="CODELISTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="CODELISTNAME", format="")})})
public abstract class CodeListDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public CodeListDefaultACModelBase() {
        this.initAnnotation(CodeListDefaultACModelBase.class);
    }
}

