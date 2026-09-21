/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfversion.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f0abca40127ddf436270635ba0e3c135", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFWFVERSIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFWFVERSIONNAME", format="")})})
public abstract class WFVersionDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFVersionDefaultACModelBase() {
        this.initAnnotation(WFVersionDefaultACModelBase.class);
    }
}

