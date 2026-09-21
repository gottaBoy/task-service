/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.aidesign.demodel.pssysaiworkeragent.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0462176d5651710a0c1c9b966ae24117", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSAIWORKERAGENTID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSAIWORKERAGENTNAME", format="")})})
public class PSSysAIWorkerAgentDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysAIWorkerAgentDefaultACModel() {
        this.initAnnotation(PSSysAIWorkerAgentDefaultACModel.class);
    }
}

