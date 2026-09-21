/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psdeinitcfg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="61ea81d5646aed69f0f8a7c5f967aa58", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEINITCFGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEINITCFGNAME", format="")})})
public class PSDEInitCfgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEInitCfgDefaultACModel() {
        this.initAnnotation(PSDEInitCfgDefaultACModel.class);
    }
}

