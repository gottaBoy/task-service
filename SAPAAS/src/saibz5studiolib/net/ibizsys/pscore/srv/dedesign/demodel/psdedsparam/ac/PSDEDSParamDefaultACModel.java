/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedsparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b8b5705d921898bf915a3123f570fb57", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDSPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDSPARAMNAME", format="")})})
public class PSDEDSParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDSParamDefaultACModel() {
        this.initAnnotation(PSDEDSParamDefaultACModel.class);
    }
}

