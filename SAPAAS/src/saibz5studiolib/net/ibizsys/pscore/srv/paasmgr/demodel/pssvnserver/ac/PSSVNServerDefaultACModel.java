/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pssvnserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="992e4e984bc8308335f2a9d5d925ad13", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSVNSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSVNSERVERNAME", format="")})})
public class PSSVNServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSVNServerDefaultACModel() {
        this.initAnnotation(PSSVNServerDefaultACModel.class);
    }
}

