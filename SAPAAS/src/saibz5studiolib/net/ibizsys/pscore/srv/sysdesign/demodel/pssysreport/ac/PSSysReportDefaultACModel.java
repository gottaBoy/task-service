/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysreport.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="cf3ad72ce24aab3b857b90e694439126", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSREPORTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSREPORTNAME", format="")})})
public class PSSysReportDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysReportDefaultACModel() {
        this.initAnnotation(PSSysReportDefaultACModel.class);
    }
}

