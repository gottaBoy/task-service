/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappmodule.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b47959ba78b971bd77d19b61634f1c08", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPMODULEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPMODULENAME", format="")})})
public class PSAppModuleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppModuleDefaultACModel() {
        this.initAnnotation(PSAppModuleDefaultACModel.class);
        this.setMinorSortField("ORDERVALUE");
        this.setMinorSortDir("ASC");
    }
}

