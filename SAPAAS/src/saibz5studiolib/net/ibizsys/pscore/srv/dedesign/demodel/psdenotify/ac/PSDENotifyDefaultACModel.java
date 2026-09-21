/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdenotify.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="d6fb1f08e9fdf1efb6c9097da0ca95d3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDENOTIFYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDENOTIFYNAME", format="")})})
public class PSDENotifyDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDENotifyDefaultACModel() {
        this.initAnnotation(PSDENotifyDefaultACModel.class);
    }
}

