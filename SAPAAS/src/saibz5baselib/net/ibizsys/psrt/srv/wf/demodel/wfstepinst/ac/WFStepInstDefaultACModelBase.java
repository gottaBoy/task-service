/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfstepinst.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="707f76a538be385bf4bf65a2b1125003", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFSTEPINSTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFSTEPINSTNAME", format="")})})
public abstract class WFStepInstDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFStepInstDefaultACModelBase() {
        this.initAnnotation(WFStepInstDefaultACModelBase.class);
    }
}

