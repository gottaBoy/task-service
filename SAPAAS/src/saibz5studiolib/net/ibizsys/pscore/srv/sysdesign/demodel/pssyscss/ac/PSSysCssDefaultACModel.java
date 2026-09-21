/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscss.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f44a824b674e80684a89eed460c74563", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSCSSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSCSSNAME", format="")})})
public class PSSysCssDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysCssDefaultACModel() {
        this.initAnnotation(PSSysCssDefaultACModel.class);
    }
}

