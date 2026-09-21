/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.pssaassysapp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c6c70cabc80cfd0675557ac6701ba365", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSAASSYSAPPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSAASSYSAPPNAME", format="")})})
public class PSSaaSSysAppDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSaaSSysAppDefaultACModel() {
        this.initAnnotation(PSSaaSSysAppDefaultACModel.class);
    }
}

