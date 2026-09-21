/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnmsdepapp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f51499dbf4527d7304229b500bf1fde5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVSLNMSDEPAPPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVSLNMSDEPAPPNAME", format="")})})
public class PSDevSlnMSDepAppDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevSlnMSDepAppDefaultACModel() {
        this.initAnnotation(PSDevSlnMSDepAppDefaultACModel.class);
    }
}

