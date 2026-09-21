/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappsbitemrs.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="406cdf0fc9cada072c4d8a61ab3dd430", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPSBITEMRSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPSBITEMRSNAME", format="")})})
public class PSAppSBItemRSDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppSBItemRSDefaultACModel() {
        this.initAnnotation(PSAppSBItemRSDefaultACModel.class);
    }
}

