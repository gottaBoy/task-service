/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psderepitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="27b2515d816c0d2798174560892c0b8d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEREPITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEREPITEMNAME", format="")})})
public class PSDERepItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDERepItemDefaultACModel() {
        this.initAnnotation(PSDERepItemDefaultACModel.class);
    }
}

