/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmtdecat.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c85d4c525ed56df08fcc8e414b8b6ece", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCMTDECATID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCMTDECATNAME", format="")})})
public class PSDCMTDECatDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCMTDECatDefaultACModel() {
        this.initAnnotation(PSDCMTDECatDefaultACModel.class);
    }
}

