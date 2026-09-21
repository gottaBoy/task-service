/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psbookingrestype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9eeaaae919b691fef7c8f5ca4b174b15", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSBOOKINGRESTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSBOOKINGRESTYPENAME", format="")})})
public class PSBookingResTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSBookingResTypeDefaultACModel() {
        this.initAnnotation(PSBookingResTypeDefaultACModel.class);
    }
}

