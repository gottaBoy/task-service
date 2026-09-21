/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspanelllcondtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="21f0ae3da6e577282622424358b8b23b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPANELLLCONDTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPANELLLCONDTYPENAME", format="")})})
public class PSPanelLLCondTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPanelLLCondTypeDefaultACModel() {
        this.initAnnotation(PSPanelLLCondTypeDefaultACModel.class);
    }
}

