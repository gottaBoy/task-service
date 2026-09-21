/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psuapolicytype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0ae666f6329ea3926babab8d476f5078", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUACPOLICYTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUACPOLICYTYPENAME", format="")})})
public class PSUAPolicyTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUAPolicyTypeDefaultACModel() {
        this.initAnnotation(PSUAPolicyTypeDefaultACModel.class);
    }
}

