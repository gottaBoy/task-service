/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdbdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="aefecf6f917c726955249e4438d1535d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDBDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDBDETAILNAME", format="")})})
public class PSSysDBDetailDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDBDetailDefaultACModel() {
        this.initAnnotation(PSSysDBDetailDefaultACModel.class);
    }
}

