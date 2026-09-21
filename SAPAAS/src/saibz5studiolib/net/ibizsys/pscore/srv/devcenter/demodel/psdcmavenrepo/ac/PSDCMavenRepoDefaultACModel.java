/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmavenrepo.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="45d6e84728dc3a5a1e5907cf1dc199aa", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCMAVENREPOID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCMAVENREPONAME", format="")})})
public class PSDCMavenRepoDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCMavenRepoDefaultACModel() {
        this.initAnnotation(PSDCMavenRepoDefaultACModel.class);
    }
}

