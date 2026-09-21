/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysdevstudio.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c5d8f0cc3393615486b823b3b206669d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDEVSTUDIOID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDEVSTUDIONAME", format="")})})
public class PSSysDevStudioDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDevStudioDefaultACModel() {
        this.initAnnotation(PSSysDevStudioDefaultACModel.class);
    }
}

