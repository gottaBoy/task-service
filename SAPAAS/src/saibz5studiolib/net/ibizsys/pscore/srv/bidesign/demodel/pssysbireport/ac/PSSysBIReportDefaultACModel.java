/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bidesign.demodel.pssysbireport.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7f60d0d3bcda0cb3827f8be915d56ce6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBIREPORTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBIREPORTNAME", format="")})})
public class PSSysBIReportDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBIReportDefaultACModel() {
        this.initAnnotation(PSSysBIReportDefaultACModel.class);
    }
}

