/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefinputtip.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2932687fbd8c3277910fbabe6d95099b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEFINPUTTIPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEFINPUTTIPNAME", format="")})})
public class PSDEFInputTipDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEFInputTipDefaultACModel() {
        this.initAnnotation(PSDEFInputTipDefaultACModel.class);
    }
}

