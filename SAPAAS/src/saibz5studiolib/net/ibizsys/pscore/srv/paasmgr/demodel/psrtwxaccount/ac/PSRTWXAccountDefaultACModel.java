/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psrtwxaccount.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="2fbe77dcb2ad87f8c21d2488a68a5a98", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSRTWXACCOUNTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSRTWXACCOUNTNAME", format="")})})
public class PSRTWXAccountDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSRTWXAccountDefaultACModel() {
        this.initAnnotation(PSRTWXAccountDefaultACModel.class);
    }
}

