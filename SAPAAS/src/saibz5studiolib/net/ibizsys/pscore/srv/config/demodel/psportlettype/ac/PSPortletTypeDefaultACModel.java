/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psportlettype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="09e224fb1c3efd0816464313145ad1b2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPORTLETTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPORTLETTYPENAME", format="")})})
public class PSPortletTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPortletTypeDefaultACModel() {
        this.initAnnotation(PSPortletTypeDefaultACModel.class);
    }
}

