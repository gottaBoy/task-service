/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psbuttontype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8d85c8f5449e646bf227bde7f7834ff1", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSBUTTONTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSBUTTONTYPENAME", format="")})})
public class PSButtonTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSButtonTypeDefaultACModel() {
        this.initAnnotation(PSButtonTypeDefaultACModel.class);
    }
}

