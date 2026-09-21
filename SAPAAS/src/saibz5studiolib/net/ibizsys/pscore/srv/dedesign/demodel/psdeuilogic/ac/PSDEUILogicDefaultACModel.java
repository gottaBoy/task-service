/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuilogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f76f025e2e0de98541bab8da96ace50d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDELOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDELOGICNAME", format="")})})
public class PSDEUILogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEUILogicDefaultACModel() {
        this.initAnnotation(PSDEUILogicDefaultACModel.class);
    }
}

