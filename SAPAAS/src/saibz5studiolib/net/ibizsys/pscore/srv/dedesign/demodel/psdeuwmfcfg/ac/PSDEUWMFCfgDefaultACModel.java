/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuwmfcfg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="36c2760ab30a8f7bf28633e0629ffddb", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDATAENTITYID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDATAENTITYNAME", format="")})})
public class PSDEUWMFCfgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEUWMFCfgDefaultACModel() {
        this.initAnnotation(PSDEUWMFCfgDefaultACModel.class);
    }
}

