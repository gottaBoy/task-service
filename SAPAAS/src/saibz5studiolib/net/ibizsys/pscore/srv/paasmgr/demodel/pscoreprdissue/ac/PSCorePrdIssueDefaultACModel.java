/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pscoreprdissue.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e453b5d23347f7fefed5973fbf72102a", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSCOREPRDISSUEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSCOREPRDISSUENAME", format="")})})
public class PSCorePrdIssueDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSCorePrdIssueDefaultACModel() {
        this.initAnnotation(PSCorePrdIssueDefaultACModel.class);
    }
}

