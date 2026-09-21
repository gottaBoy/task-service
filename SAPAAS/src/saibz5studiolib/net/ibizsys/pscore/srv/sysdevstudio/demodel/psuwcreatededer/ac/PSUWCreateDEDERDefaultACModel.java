/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwcreatededer.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d5a688097641b5f97d11f020d293f09e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUWCREATEDEDERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUWCREATEDEDERNAME", format="")})})
public class PSUWCreateDEDERDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUWCreateDEDERDefaultACModel() {
        this.initAnnotation(PSUWCreateDEDERDefaultACModel.class);
    }
}

