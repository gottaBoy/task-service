/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappsbitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="05071a82a6841fad43da5336284efcdb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPSBITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPSBITEMNAME", format="")})})
public class PSAppSBItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppSBItemDefaultACModel() {
        this.initAnnotation(PSAppSBItemDefaultACModel.class);
    }
}

