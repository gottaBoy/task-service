/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel.wfuserassist.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c0a02fe821e07837af3333a49fb08b30", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="WFUSERASSISTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="WFUSERASSISTNAME", format="")})})
public abstract class WFUserAssistDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public WFUserAssistDefaultACModelBase() {
        this.initAnnotation(WFUserAssistDefaultACModelBase.class);
    }
}

