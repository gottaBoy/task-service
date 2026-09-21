/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfvercode.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7b366e7e41d6ab9964fdcf57d1ece701", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFVERCODEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFVERCODENAME", format="")})})
public class PSSFVerCodeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFVerCodeDefaultACModel() {
        this.initAnnotation(PSSFVerCodeDefaultACModel.class);
    }
}

