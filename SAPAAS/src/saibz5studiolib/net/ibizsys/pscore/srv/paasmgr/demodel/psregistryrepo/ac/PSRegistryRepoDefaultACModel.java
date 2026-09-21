/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psregistryrepo.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="814620adf4077df3a95921c78b6efdbf", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSREGISTRYREPOID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSREGISTRYREPONAME", format="")})})
public class PSRegistryRepoDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSRegistryRepoDefaultACModel() {
        this.initAnnotation(PSRegistryRepoDefaultACModel.class);
    }
}

