/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysreqmodule.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="58bd1a704450f879a1ff6da73907d933", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSREQMODULEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSREQMODULENAME", format="")})})
public class PSSysReqModuleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysReqModuleDefaultACModel() {
        this.initAnnotation(PSSysReqModuleDefaultACModel.class);
    }
}

