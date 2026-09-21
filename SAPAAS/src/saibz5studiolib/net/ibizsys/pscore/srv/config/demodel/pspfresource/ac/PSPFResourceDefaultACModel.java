/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfresource.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="48cb0c489b9d9ee3f92b3c53e92ee026", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSPFRESOURCEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSPFRESOURCENAME", format="")})})
public class PSPFResourceDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSPFResourceDefaultACModel() {
        this.initAnnotation(PSPFResourceDefaultACModel.class);
    }
}

