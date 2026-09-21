/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.liteutil.demodel.psappviewlite.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="692d9ddb3f056aefb511453373932a21", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPVIEWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPVIEWNAME", format="")})})
public class PSAppViewLiteDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppViewLiteDefaultACModel() {
        this.initAnnotation(PSAppViewLiteDefaultACModel.class);
    }
}

