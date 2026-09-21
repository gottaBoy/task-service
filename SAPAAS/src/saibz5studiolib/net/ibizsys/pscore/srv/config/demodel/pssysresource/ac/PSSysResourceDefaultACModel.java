/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssysresource.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="13ea1afcb880ab715951e5931c8ed6a1", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSRESOURCEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSRESOURCENAME", format="")})})
public class PSSysResourceDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysResourceDefaultACModel() {
        this.initAnnotation(PSSysResourceDefaultACModel.class);
    }
}

