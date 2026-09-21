/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psappserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="858d46b3889378e3bedb7539ee009e7c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSAPPSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSAPPSERVERNAME", format="")})})
public class PSAppServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSAppServerDefaultACModel() {
        this.initAnnotation(PSAppServerDefaultACModel.class);
    }
}

