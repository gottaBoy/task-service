/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnsysapi.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="45426cb8863b757dfc23a2623b4dd750", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPSLNSYSAPIID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPSLNSYSAPINAME", format="")})})
public class PSDepSlnSysAPIDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDepSlnSysAPIDefaultACModel() {
        this.initAnnotation(PSDepSlnSysAPIDefaultACModel.class);
    }
}

