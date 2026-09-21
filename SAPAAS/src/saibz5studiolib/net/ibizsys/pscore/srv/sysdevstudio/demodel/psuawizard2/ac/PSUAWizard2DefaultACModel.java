/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuawizard2.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ed0de838b0e5db60724327b913284d7e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUAWIZARD2ID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUAWIZARD2NAME", format="")})})
public class PSUAWizard2DefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUAWizard2DefaultACModel() {
        this.initAnnotation(PSUAWizard2DefaultACModel.class);
    }
}

