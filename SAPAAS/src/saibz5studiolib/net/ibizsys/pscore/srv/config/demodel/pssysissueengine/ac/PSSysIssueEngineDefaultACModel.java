/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssysissueengine.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="4cb271761c8fc88ab41810dc8464ee1d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSISSUEENGINEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSISSUEENGINENAME", format="")})})
public class PSSysIssueEngineDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysIssueEngineDefaultACModel() {
        this.initAnnotation(PSSysIssueEngineDefaultACModel.class);
    }
}

