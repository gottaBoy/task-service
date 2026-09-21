/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pssvrserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3d6333aaadcec6d091998807062e104a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSVRSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSVRSERVERNAME", format="")})})
public class PSSvrServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSvrServerDefaultACModel() {
        this.initAnnotation(PSSvrServerDefaultACModel.class);
    }
}

