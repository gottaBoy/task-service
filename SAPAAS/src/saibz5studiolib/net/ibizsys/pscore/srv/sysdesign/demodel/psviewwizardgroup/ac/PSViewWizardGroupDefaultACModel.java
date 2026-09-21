/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psviewwizardgroup.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a20999a2780c6ce44ac8f044848b89ec", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVIEWWIZARDGROUPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVIEWWIZARDGROUPNAME", format="")})})
public class PSViewWizardGroupDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSViewWizardGroupDefaultACModel() {
        this.initAnnotation(PSViewWizardGroupDefaultACModel.class);
    }
}

