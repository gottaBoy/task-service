/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwcreatede.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8972c85f9eb6c0f01fa629d3b63dd123", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUWCREATEDEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUWCREATEDENAME", format="")})})
public class PSUWCreateDEDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUWCreateDEDefaultACModel() {
        this.initAnnotation(PSUWCreateDEDefaultACModel.class);
    }
}

