/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdelogic.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="db93efe6c759b00b07823bd73ee253e6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDELOGICID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDELOGICNAME", format="")})})
public class PSDELogicDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDELogicDefaultACModel() {
        this.initAnnotation(PSDELogicDefaultACModel.class);
    }
}

