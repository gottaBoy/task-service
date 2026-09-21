/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelref.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5600b0842a63e9a45d1e00f54c67b0d6", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMODELREFID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMODELREFNAME", format="")})})
public class PSModelRefDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSModelRefDefaultACModel() {
        this.initAnnotation(PSModelRefDefaultACModel.class);
    }
}

