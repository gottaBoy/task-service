/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdegctype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="19909e2c0fbe1ccf0567ad8e01166c07", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEGCTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEGCTYPENAME", format="")})})
public class PSDEGCTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEGCTypeDefaultACModel() {
        this.initAnnotation(PSDEGCTypeDefaultACModel.class);
    }
}

