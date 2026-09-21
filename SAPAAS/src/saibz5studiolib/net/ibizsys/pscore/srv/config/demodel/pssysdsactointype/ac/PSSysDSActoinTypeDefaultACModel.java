/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssysdsactointype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9ee96275511f9204ac90393fb6bc2b06", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDSACTIONTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDSACTIONTYPENAME", format="")})})
public class PSSysDSActoinTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDSActoinTypeDefaultACModel() {
        this.initAnnotation(PSSysDSActoinTypeDefaultACModel.class);
    }
}

