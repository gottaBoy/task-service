/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psuienginetype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d25b01f840bc31632672dbe987feb35f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSUIENGINETYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSUIENGINETYPENAME", format="")})})
public class PSUIEngineTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSUIEngineTypeDefaultACModel() {
        this.initAnnotation(PSUIEngineTypeDefaultACModel.class);
    }
}

