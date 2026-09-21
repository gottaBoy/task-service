/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubdeaction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="789d6f5a3622e78c89c13cc22a4f5dc1", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSUBDEACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSUBDEACTIONNAME", format="")})})
public class PSSubDEActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSubDEActionDefaultACModel() {
        this.initAnnotation(PSSubDEActionDefaultACModel.class);
    }
}

