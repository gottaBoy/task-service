/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdeploy.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="9e38456067ed0aae895173143a958ebc", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDEPLOYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDEPLOYNAME", format="")})})
public class PSSysDeployDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDeployDefaultACModel() {
        this.initAnnotation(PSSysDeployDefaultACModel.class);
    }
}

