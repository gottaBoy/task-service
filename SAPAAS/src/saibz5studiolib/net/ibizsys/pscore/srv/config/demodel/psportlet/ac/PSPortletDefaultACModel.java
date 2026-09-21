/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psportlet.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a7be25f688207c4bbad50878e7a22453", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPORTLETID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPORTLETNAME", format="")})})
public class PSPortletDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPortletDefaultACModel() {
        this.initAnnotation(PSPortletDefaultACModel.class);
    }
}

