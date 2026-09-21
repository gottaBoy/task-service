/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdeployapp.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d63f3eb1bbd3de537b0f963a592ab3fa", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDEPLOYAPPID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDEPLOYAPPNAME", format="")})})
public class PSSysDeployAppDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDeployAppDefaultACModel() {
        this.initAnnotation(PSSysDeployAppDefaultACModel.class);
    }
}

