/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdellcondtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="fb8087050ed931911aecc2e0182376b4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDELLCONDTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDELLCONDTYPENAME", format="")})})
public class PSDELLCondTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDELLCondTypeDefaultACModel() {
        this.initAnnotation(PSDELLCondTypeDefaultACModel.class);
    }
}

