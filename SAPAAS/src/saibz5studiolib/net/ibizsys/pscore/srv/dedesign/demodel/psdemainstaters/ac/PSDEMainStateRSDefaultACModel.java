/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdemainstaters.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8eef6f0b3820d776dfab4f43be5c77f4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEMAINSTATERSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEMAINSTATERSNAME", format="")})})
public class PSDEMainStateRSDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEMainStateRSDefaultACModel() {
        this.initAnnotation(PSDEMainStateRSDefaultACModel.class);
    }
}

