/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psstudioserverlog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="8d1afdae78143dabaf72b16f2afa8f8f", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSTUDIOSERVERLOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSTUDIOSERVERLOGNAME", format="")})})
public class PSStudioServerLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSStudioServerLogDefaultACModel() {
        this.initAnnotation(PSStudioServerLogDefaultACModel.class);
    }
}

