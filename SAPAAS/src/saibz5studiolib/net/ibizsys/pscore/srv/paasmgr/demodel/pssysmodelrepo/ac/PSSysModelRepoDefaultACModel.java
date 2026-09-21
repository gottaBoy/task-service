/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pssysmodelrepo.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e2c30ddadbfe73b76e551bc99b0d03a5", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSMODELREPOID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSMODELREPONAME", format="")})})
public class PSSysModelRepoDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysModelRepoDefaultACModel() {
        this.initAnnotation(PSSysModelRepoDefaultACModel.class);
    }
}

