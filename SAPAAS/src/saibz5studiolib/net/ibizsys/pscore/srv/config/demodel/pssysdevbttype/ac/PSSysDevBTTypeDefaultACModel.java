/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssysdevbttype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="5a65fbbca209e0e3d744c47802d82c3f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDEVBTTYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDEVBTTYPENAME", format="")})})
public class PSSysDevBTTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDevBTTypeDefaultACModel() {
        this.initAnnotation(PSSysDevBTTypeDefaultACModel.class);
    }
}

