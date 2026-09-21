/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pscodename.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ecf2bb472db2a5b83cfffaa3a813a839", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCODENAMEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCODENAMENAME", format="")})})
public class PSCodeNameDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCodeNameDefaultACModel() {
        this.initAnnotation(PSCodeNameDefaultACModel.class);
    }
}

