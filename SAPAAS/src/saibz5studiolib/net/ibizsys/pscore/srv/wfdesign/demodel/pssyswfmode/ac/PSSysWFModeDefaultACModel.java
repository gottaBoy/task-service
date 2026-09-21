/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pssyswfmode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1b6516b4f65ade5145319fae5a0fe126", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSWFMODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSWFMODENAME", format="")})})
public class PSSysWFModeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysWFModeDefaultACModel() {
        this.initAnnotation(PSSysWFModeDefaultACModel.class);
    }
}

