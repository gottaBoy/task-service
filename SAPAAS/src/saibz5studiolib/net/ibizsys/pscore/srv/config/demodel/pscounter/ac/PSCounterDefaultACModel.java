/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pscounter.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="89c8a9e0cb4d586736fbc2530c12d3ef", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCOUNTERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCOUNTERNAME", format="")})})
public class PSCounterDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCounterDefaultACModel() {
        this.initAnnotation(PSCounterDefaultACModel.class);
    }
}

