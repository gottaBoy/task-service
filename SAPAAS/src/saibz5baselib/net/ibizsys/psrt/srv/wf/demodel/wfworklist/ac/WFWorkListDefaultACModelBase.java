/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfworklist.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c93ef4408352303441d2f73e0e4990a2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFWORKLISTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFWORKLISTNAME", format="")})})
public abstract class WFWorkListDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFWorkListDefaultACModelBase() {
        this.initAnnotation(WFWorkListDefaultACModelBase.class);
    }
}

