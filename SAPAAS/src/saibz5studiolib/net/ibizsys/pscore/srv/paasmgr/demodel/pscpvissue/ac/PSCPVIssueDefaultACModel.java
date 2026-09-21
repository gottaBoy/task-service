/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pscpvissue.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="002f3380c19e6fad9073fc1facfcb042", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCPVISSUEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCPVISSUENAME", format="")})})
public class PSCPVIssueDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCPVIssueDefaultACModel() {
        this.initAnnotation(PSCPVIssueDefaultACModel.class);
    }
}

