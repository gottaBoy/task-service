/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psctrltypecallback.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="f0d2338ea5b337884097f84a66dfb446", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCTRLTYPECALLBACKID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCTRLTYPECALLBACKNAME", format="")})})
public class PSCtrlTypeCallbackDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCtrlTypeCallbackDefaultACModel() {
        this.initAnnotation(PSCtrlTypeCallbackDefaultACModel.class);
    }
}

