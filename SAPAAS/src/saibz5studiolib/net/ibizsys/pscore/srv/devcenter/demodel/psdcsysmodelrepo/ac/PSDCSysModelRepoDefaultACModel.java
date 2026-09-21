/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcsysmodelrepo.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="487ad2d2dcfdee2c5454ff9195053c51", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCSYSMODELREPOID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCSYSMODELREPONAME", format="")})})
public class PSDCSysModelRepoDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCSysModelRepoDefaultACModel() {
        this.initAnnotation(PSDCSysModelRepoDefaultACModel.class);
    }
}

