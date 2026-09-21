/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psdccoreprdissue.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="80bfe694cd88cf0943ae2a5cd0403867", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDCCOREPRDISSUEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDCCOREPRDISSUENAME", format="")})})
public class PSDCCorePrdIssueDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDCCorePrdIssueDefaultACModel() {
        this.initAnnotation(PSDCCorePrdIssueDefaultACModel.class);
    }
}

