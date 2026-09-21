/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeagdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4db40bb05123557dee65b9a335b49892", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEAGDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEAGDETAILNAME", format="")})})
public class PSDEAGDetailDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEAGDetailDefaultACModel() {
        this.initAnnotation(PSDEAGDetailDefaultACModel.class);
    }
}

