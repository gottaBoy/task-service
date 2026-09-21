/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psbktasklog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3c0fb9c60ead7f4afd79b28b7105185d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSBKTASKLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSBKTASKLOGNAME", format="")})})
public class PSBKTaskLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSBKTaskLogDefaultACModel() {
        this.initAnnotation(PSBKTaskLogDefaultACModel.class);
    }
}

