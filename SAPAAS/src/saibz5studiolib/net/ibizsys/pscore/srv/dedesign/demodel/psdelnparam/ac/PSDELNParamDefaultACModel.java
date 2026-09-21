/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdelnparam.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3c4aa0019094c4afb506564afbc94060", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDELNPARAMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDELNPARAMNAME", format="")})})
public class PSDELNParamDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDELNParamDefaultACModel() {
        this.initAnnotation(PSDELNParamDefaultACModel.class);
    }
}

