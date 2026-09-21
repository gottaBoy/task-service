/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psbdtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="18729613a3196daa43adf31aaef3bb46", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSBDTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSBDTYPENAME", format="")})})
public class PSBDTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSBDTypeDefaultACModel() {
        this.initAnnotation(PSBDTypeDefaultACModel.class);
    }
}

