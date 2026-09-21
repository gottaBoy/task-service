/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubsys.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c7bb0325f1509f5b5e0bf9c3dd13e994", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSUBSYSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSUBSYSNAME", format="")})})
public class PSSubSysDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSubSysDefaultACModel() {
        this.initAnnotation(PSSubSysDefaultACModel.class);
    }
}

