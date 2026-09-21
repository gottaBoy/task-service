/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssysdevinfotype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="47c75f838041764f519b8d68b7178d8a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDEVINFOTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDEVINFOTYPENAME", format="")})})
public class PSSysDevInfoTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDevInfoTypeDefaultACModel() {
        this.initAnnotation(PSSysDevInfoTypeDefaultACModel.class);
    }
}

