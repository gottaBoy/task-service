/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysdevbktask.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="35a6a2b1cdbf1b542661a6d52cbf64bb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSDEVBKTASKID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSDEVBKTASKNAME", format="")})})
public class PSSysDevBKTaskDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysDevBKTaskDefaultACModel() {
        this.initAnnotation(PSSysDevBKTaskDefaultACModel.class);
    }
}

