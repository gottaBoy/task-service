/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psgituser.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="bc82349da6cb62aa0889a6bdd5412ccd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSGITUSERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSGITUSERNAME", format="")})})
public class PSGitUserDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSGitUserDefaultACModel() {
        this.initAnnotation(PSGitUserDefaultACModel.class);
    }
}

