/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.pscodeserveraction.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d2b5459ec089b7e6a639e2ebd793a00d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCODESERVERACTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCODESERVERACTIONNAME", format="")})})
public class PSCodeServerActionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCodeServerActionDefaultACModel() {
        this.initAnnotation(PSCodeServerActionDefaultACModel.class);
    }
}

