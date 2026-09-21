/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcbktask.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="333584e579deff0b96a2390c85949012", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCBKTASKID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCBKTASKNAME", format="")})})
public class PSDCBKTaskDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCBKTaskDefaultACModel() {
        this.initAnnotation(PSDCBKTaskDefaultACModel.class);
    }
}

