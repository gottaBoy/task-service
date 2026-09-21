/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psmavenrepo.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="49a0f62a5c2990ccd0d34524e81c8c06", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSMAVENREPOID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSMAVENREPONAME", format="")})})
public class PSMavenRepoDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSMavenRepoDefaultACModel() {
        this.initAnnotation(PSMavenRepoDefaultACModel.class);
    }
}

