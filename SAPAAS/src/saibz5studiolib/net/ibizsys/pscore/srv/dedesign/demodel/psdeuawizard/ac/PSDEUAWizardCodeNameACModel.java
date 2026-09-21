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

@DEACMode(name="CODENAME", id="055E3492-834D-44DC-82B4-70D0250FD4F5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUAWIZARDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUAWIZARDNAME", format="")})})
public class PSDEUAWizardCodeNameACModel
extends DEACModelBase {
    public static final String NAME = "CODENAME";

    public PSDEUAWizardCodeNameACModel() {
        this.initAnnotation(PSDEUAWizardCodeNameACModel.class);
    }
}

