/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmidetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4fb8e4f9e4554b1eb2876b88337ddbd9", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMIDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMIDETAILNAME", format="")})})
public class PSMIDetailDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSMIDetailDefaultACModel() {
        this.initAnnotation(PSMIDetailDefaultACModel.class);
    }
}

