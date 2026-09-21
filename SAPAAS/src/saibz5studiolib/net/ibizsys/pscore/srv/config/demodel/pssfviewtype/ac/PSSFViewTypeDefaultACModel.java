/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfviewtype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f2d652a4ae55f184971e0db7ea4c3713", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFVIEWTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFVIEWTYPENAME", format="")})})
public class PSSFViewTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFViewTypeDefaultACModel() {
        this.initAnnotation(PSSFViewTypeDefaultACModel.class);
    }
}

