/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psviewtypecat.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2e438f9e61fb57f71c48915bf9c5f03b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVIEWTYPECATID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVIEWTYPECATNAME", format="")})})
public class PSViewTypeCatDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSViewTypeCatDefaultACModel() {
        this.initAnnotation(PSViewTypeCatDefaultACModel.class);
    }
}

