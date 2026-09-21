/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuawizard.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b801a9bf47a34a848ff405c8dcfc0bcf", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUAWIZARDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUAWIZARDNAME", format="")})})
public class PSDEUAWizardDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEUAWizardDefaultACModel() {
        this.initAnnotation(PSDEUAWizardDefaultACModel.class);
    }
}

