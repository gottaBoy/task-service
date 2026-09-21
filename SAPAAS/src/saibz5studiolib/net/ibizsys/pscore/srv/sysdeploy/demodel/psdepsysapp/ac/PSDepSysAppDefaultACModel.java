/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepsysapp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8ac9cc08092f5dba85f47e213a7a6e4b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPSYSAPPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPSYSAPPNAME", format="")})})
public class PSDepSysAppDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDepSysAppDefaultACModel() {
        this.initAnnotation(PSDepSysAppDefaultACModel.class);
    }
}

