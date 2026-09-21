/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysmodelloadlog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="81457c25c25960122b4253d181336005", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSMODELLOADLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSMODELLOADLOGNAME", format="")})})
public class PSSysModelLoadLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysModelLoadLogDefaultACModel() {
        this.initAnnotation(PSSysModelLoadLogDefaultACModel.class);
    }
}

