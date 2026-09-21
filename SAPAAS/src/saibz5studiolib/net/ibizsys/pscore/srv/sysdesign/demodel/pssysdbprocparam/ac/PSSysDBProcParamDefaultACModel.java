/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdbprocparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="50ab06b49a72622f14113ddfd013d1fc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDBPROCPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDBPROCPARAMNAME", format="")})})
public class PSSysDBProcParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDBProcParamDefaultACModel() {
        this.initAnnotation(PSSysDBProcParamDefaultACModel.class);
    }
}

