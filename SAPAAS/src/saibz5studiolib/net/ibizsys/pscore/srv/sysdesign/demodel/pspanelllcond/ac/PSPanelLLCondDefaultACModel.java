/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pspanelllcond.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="601622e69f87bf0206e8cb15c3a5dab2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPANELLLCONDID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPANELLLCONDNAME", format="")})})
public class PSPanelLLCondDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPanelLLCondDefaultACModel() {
        this.initAnnotation(PSPanelLLCondDefaultACModel.class);
    }
}

