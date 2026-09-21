/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdewizardstep.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="de36ab2e71244cdb3d616ab72b11f029", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEWIZARDSTEPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEWIZARDSTEPNAME", format="")})})
public class PSDEWizardStepDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEWizardStepDefaultACModel() {
        this.initAnnotation(PSDEWizardStepDefaultACModel.class);
    }
}

