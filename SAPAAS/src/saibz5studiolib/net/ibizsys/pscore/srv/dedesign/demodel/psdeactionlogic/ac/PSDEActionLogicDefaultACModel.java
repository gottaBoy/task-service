/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeactionlogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="20fd7f726e7aeefc3c6d9773e92a0f67", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEACTIONLOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEACTIONLOGICNAME", format="")})})
public class PSDEActionLogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEActionLogicDefaultACModel() {
        this.initAnnotation(PSDEActionLogicDefaultACModel.class);
    }
}

