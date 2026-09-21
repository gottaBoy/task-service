/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psdeployserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0e412086c3c8452992a9b3ba95748725", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEPLOYSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEPLOYSERVERNAME", format="")})})
public class PSDeployServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDeployServerDefaultACModel() {
        this.initAnnotation(PSDeployServerDefaultACModel.class);
    }
}

