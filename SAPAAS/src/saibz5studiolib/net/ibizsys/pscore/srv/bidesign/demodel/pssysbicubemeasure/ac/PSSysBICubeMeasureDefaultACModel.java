/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bidesign.demodel.pssysbicubemeasure.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="59910416d7ad7621c57f0f27b2434940", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBICUBEMEASUREID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBICUBEMEASURENAME", format="")})})
public class PSSysBICubeMeasureDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBICubeMeasureDefaultACModel() {
        this.initAnnotation(PSSysBICubeMeasureDefaultACModel.class);
    }
}

