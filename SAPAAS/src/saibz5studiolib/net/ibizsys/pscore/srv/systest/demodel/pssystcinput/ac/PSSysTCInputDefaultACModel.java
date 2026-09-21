/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.systest.demodel.pssystcinput.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="48e6347b9c3c52ca9b56a159959d38f6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTCINPUTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTCINPUTNAME", format="")})})
public class PSSysTCInputDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysTCInputDefaultACModel() {
        this.initAnnotation(PSSysTCInputDefaultACModel.class);
    }
}

