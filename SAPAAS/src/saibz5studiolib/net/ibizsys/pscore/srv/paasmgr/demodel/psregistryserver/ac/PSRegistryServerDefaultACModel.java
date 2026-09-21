/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psregistryserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="ead8b59adc04558f712e5f8ad3219bf7", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSREGISTRYSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSREGISTRYSERVERNAME", format="")})})
public class PSRegistryServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSRegistryServerDefaultACModel() {
        this.initAnnotation(PSRegistryServerDefaultACModel.class);
    }
}

