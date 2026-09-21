/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuawizard3.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ab5a89ae39f8eebae8507f866ad7951c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUAWIZARD3ID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUAWIZARD3NAME", format="")})})
public class PSUAWizard3DefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUAWizard3DefaultACModel() {
        this.initAnnotation(PSUAWizard3DefaultACModel.class);
    }
}

