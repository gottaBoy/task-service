/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappwf.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="73c322f1153f75ff15d0ef9494acaa60", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPWFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPWFNAME", format="")})})
public class PSAppWFDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppWFDefaultACModel() {
        this.initAnnotation(PSAppWFDefaultACModel.class);
    }
}

