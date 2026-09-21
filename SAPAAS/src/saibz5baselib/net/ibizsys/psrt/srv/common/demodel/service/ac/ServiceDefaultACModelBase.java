/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.service.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="08903b770bfabc9dbb8e95f19a74ed65", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="SERVICEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="SERVICENAME", format="")})})
public abstract class ServiceDefaultACModelBase
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public ServiceDefaultACModelBase() {
        this.initAnnotation(ServiceDefaultACModelBase.class);
    }
}

