/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdissueplan.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c3ec0c532d3053faeb4f8d8f769bd6d0", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEVPRDISSUEPLANID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEVPRDISSUEPLANNAME", format="")})})
public class PSDevPrdIssuePlanDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDevPrdIssuePlanDefaultACModel() {
        this.initAnnotation(PSDevPrdIssuePlanDefaultACModel.class);
    }
}

