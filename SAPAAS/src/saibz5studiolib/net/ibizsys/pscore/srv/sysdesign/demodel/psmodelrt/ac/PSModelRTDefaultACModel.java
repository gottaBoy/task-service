/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelrt.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="a5c790d0b68757be9b4b6daad79db4c3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELRTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELRTNAME", format="")})})
public class PSModelRTDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelRTDefaultACModel() {
        this.initAnnotation(PSModelRTDefaultACModel.class);
    }
}

