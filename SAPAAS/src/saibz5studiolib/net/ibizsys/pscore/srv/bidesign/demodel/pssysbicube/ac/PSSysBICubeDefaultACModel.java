/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.bidesign.demodel.pssysbicube.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="3597c6c618f73cd211d39c64d064d696", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSBICUBEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSBICUBENAME", format="")})})
public class PSSysBICubeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysBICubeDefaultACModel() {
        this.initAnnotation(PSSysBICubeDefaultACModel.class);
    }
}

