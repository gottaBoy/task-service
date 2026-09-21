/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.systest.demodel.pssystestcase.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c5641a1c0a19ce919fca5cc54965ddc9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTESTCASEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTESTCASENAME", format="")})})
public class PSSysTestCaseDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysTestCaseDefaultACModel() {
        this.initAnnotation(PSSysTestCaseDefaultACModel.class);
    }
}

