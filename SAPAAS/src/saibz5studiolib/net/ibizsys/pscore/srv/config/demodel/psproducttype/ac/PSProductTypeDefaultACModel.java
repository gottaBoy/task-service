/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psproducttype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="1af2ab55ccc1b8b10751cdc8cc957370", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPRODUCTTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPRODUCTTYPENAME", format="")})})
public class PSProductTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSProductTypeDefaultACModel() {
        this.initAnnotation(PSProductTypeDefaultACModel.class);
    }
}

