/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pswfenginetype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fb6f13b03b7f609e49ae6bb602503116", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWFENGINETYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWFENGINETYPENAME", format="")})})
public class PSWFEngineTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWFEngineTypeDefaultACModel() {
        this.initAnnotation(PSWFEngineTypeDefaultACModel.class);
    }
}

