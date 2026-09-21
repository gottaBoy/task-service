/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepsaassysapp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ea1fe27d5b61d8ca2180509d40a4634a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPSAASSYSAPPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPSAASSYSAPPNAME", format="")})})
public class PSDepSaaSSysAppDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDepSaaSSysAppDefaultACModel() {
        this.initAnnotation(PSDepSaaSSysAppDefaultACModel.class);
    }
}

