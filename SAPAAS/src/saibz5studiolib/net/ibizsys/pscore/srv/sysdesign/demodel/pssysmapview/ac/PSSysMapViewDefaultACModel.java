/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysmapview.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ff09c607e3c8a4bbf64e462d6f0ddcef", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSMAPVIEWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSMAPVIEWNAME", format="")})})
public class PSSysMapViewDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysMapViewDefaultACModel() {
        this.initAnnotation(PSSysMapViewDefaultACModel.class);
    }
}

