/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubappview.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b4ea4243b153b632bb04fd61bed5d601", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSUBAPPVIEWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSUBAPPVIEWNAME", format="")})})
public class PSSubAppViewDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSubAppViewDefaultACModel() {
        this.initAnnotation(PSSubAppViewDefaultACModel.class);
    }
}

