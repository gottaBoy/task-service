/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdesars.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c20d9c16cf20d7198696c7da27bfbe56", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDESARSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDESARSNAME", format="")})})
public class PSDESARSDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDESARSDefaultACModel() {
        this.initAnnotation(PSDESARSDefaultACModel.class);
    }
}

