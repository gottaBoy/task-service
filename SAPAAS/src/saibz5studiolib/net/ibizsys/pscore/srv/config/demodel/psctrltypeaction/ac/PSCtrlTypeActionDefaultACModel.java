/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psctrltypeaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="60a4cff3f8c1af35620cfba41a81d804", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCTRLTYPEACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCTRLTYPEACTIONNAME", format="")})})
public class PSCtrlTypeActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCtrlTypeActionDefaultACModel() {
        this.initAnnotation(PSCtrlTypeActionDefaultACModel.class);
    }
}

