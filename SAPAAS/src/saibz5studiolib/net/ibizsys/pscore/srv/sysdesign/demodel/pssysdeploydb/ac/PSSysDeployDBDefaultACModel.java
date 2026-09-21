/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdeploydb.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="7cb36e6ea1a6efc425cdd4744fc3bd3e", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDEPLOYDBID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDEPLOYDBNAME", format="")})})
public class PSSysDeployDBDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDeployDBDefaultACModel() {
        this.initAnnotation(PSSysDeployDBDefaultACModel.class);
    }
}

