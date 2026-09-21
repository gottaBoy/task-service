/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdedqpdcond.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4ca5da37723f49f2a942c2eba71a9b2e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDQPDCONDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDQPDCONDNAME", format="")})})
public class PSDEDQPDCondDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDQPDCondDefaultACModel() {
        this.initAnnotation(PSDEDQPDCondDefaultACModel.class);
    }
}

