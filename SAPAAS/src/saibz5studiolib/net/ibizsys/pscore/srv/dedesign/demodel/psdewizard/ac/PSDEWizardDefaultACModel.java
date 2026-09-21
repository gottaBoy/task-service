/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdewizard.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="acf3fc5754ae49f6b298144c916a24ee", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEWIZARDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEWIZARDNAME", format="")})})
public class PSDEWizardDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEWizardDefaultACModel() {
        this.initAnnotation(PSDEWizardDefaultACModel.class);
    }
}

