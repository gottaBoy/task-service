/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.systest.demodel.pssystestmodule.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="74ed6946631db9730f7c7964b24e5a7d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTESTMODULEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTESTMODULENAME", format="")})})
public class PSSysTestModuleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysTestModuleDefaultACModel() {
        this.initAnnotation(PSSysTestModuleDefaultACModel.class);
    }
}

