/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryrepo.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="00d87087e2c1ef175734efc3a2216b23", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCREGISTRYREPOID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCREGISTRYREPONAME", format="")})})
public class PSDCRegistryRepoDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCRegistryRepoDefaultACModel() {
        this.initAnnotation(PSDCRegistryRepoDefaultACModel.class);
    }
}

