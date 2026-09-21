/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssysissuetype.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="89665144c9300cd77cb6bd4ec36fe346", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSISSUETYPEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSISSUETYPENAME", format="")})})
public class PSSysIssueTypeDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysIssueTypeDefaultACModel() {
        this.initAnnotation(PSSysIssueTypeDefaultACModel.class);
    }
}

