/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfiaaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e1ba3122fd9af91ae76dd18bf015669a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFIAACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFIAACTIONNAME", format="")})})
public abstract class WFIAActionDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFIAActionDefaultACModelBase() {
        this.initAnnotation(WFIAActionDefaultACModelBase.class);
    }
}

