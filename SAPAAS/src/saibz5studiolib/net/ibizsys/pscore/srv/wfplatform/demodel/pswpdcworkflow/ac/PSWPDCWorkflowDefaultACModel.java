/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.wfplatform.demodel.pswpdcworkflow.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d3f5a6aba52c1f07ffcf79908d85ab0d", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSWPDCWORKFLOWID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSWPDCWORKFLOWNAME", format="")})})
public class PSWPDCWorkflowDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSWPDCWorkflowDefaultACModel() {
        this.initAnnotation(PSWPDCWorkflowDefaultACModel.class);
    }
}

