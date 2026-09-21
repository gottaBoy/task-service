/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedtsqueue.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="14a69019237bf8e5abf88295448c595c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDTSQUEUEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDTSQUEUENAME", format="")})})
public class PSDEDTSQueueDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDTSQueueDefaultACModel() {
        this.initAnnotation(PSDEDTSQueueDefaultACModel.class);
    }
}

