/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysmsgqueue.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c311f9104725bbe236c9c40366521a09", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSMSGQUEUEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSMSGQUEUENAME", format="")})})
public class PSSysMsgQueueDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysMsgQueueDefaultACModel() {
        this.initAnnotation(PSSysMsgQueueDefaultACModel.class);
    }
}

