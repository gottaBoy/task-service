/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysissue.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8232aba22f9d2258b70a9d250b362e0a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSISSUEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSISSUENAME", format="")})})
public class PSSysIssueDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysIssueDefaultACModel() {
        this.initAnnotation(PSSysIssueDefaultACModel.class);
    }
}

