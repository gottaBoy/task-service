/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfvercodeitem.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="818e41d2be03dcaee9cabf12ae607982", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFVERCODEITEMID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFVERCODEITEMNAME", format="")})})
public class PSSFVerCodeItemDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFVerCodeItemDefaultACModel() {
        this.initAnnotation(PSSFVerCodeItemDefaultACModel.class);
    }
}

