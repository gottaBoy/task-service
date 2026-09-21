/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psdbdevinstbk.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e4e35c1a9e9c6f6a97c066ca73092671", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDBDEVINSTBKID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDBDEVINSTBKNAME", format="")})})
public class PSDBDevInstBKDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDBDevInstBKDefaultACModel() {
        this.initAnnotation(PSDBDevInstBKDefaultACModel.class);
    }
}

