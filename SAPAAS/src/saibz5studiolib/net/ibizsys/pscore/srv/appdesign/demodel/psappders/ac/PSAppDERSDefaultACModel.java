/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappders.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="59b1dcd886dbbfd87db3a3119bf5f53a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPDERSID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPDERSNAME", format="")})})
public class PSAppDERSDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppDERSDefaultACModel() {
        this.initAnnotation(PSAppDERSDefaultACModel.class);
    }
}

