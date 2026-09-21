/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psviewmsggrpdetail.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="b87a61033009834b4684848b10e4cea8", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSVIEWMSGGRPDETAILID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSVIEWMSGGRPDETAILNAME", format="")})})
public class PSViewMsgGrpDetailDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSViewMsgGrpDetailDefaultACModel() {
        this.initAnnotation(PSViewMsgGrpDetailDefaultACModel.class);
    }
}

