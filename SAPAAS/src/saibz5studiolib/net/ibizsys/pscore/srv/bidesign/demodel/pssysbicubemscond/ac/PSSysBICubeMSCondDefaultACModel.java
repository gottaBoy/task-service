/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bidesign.demodel.pssysbicubemscond.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0cec0c3c68e82f172a001df66975671e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBICUBEMSCONDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBICUBEMSCONDNAME", format="")})})
public class PSSysBICubeMSCondDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBICubeMSCondDefaultACModel() {
        this.initAnnotation(PSSysBICubeMSCondDefaultACModel.class);
    }
}

