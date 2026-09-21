/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappmenu.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="93833d21e3c348c9c70e0a103097a1ef", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPMENUID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPMENUNAME", format="")})})
public class PSAppMenuDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppMenuDefaultACModel() {
        this.initAnnotation(PSAppMenuDefaultACModel.class);
    }
}

