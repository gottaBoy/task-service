/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psopenplatformtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4bb56ddc84bf576daea48476b08c97f2", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSOPENPLATFORMTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSOPENPLATFORMTYPENAME", format="")})})
public class PSOpenPlatformTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSOpenPlatformTypeDefaultACModel() {
        this.initAnnotation(PSOpenPlatformTypeDefaultACModel.class);
    }
}

