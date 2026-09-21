/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodel.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c23f287c8d5c3f6f957c6f83508bb462", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELNAME", format="")})})
public class PSModelDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelDefaultACModel() {
        this.initAnnotation(PSModelDefaultACModel.class);
    }
}

