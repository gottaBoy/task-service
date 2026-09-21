/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psstudioserver.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="c123887155566e7b77ae0dbe950a7f5b", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSTUDIOSERVERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSTUDIOSERVERNAME", format="")})})
public class PSStudioServerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSStudioServerDefaultACModel() {
        this.initAnnotation(PSStudioServerDefaultACModel.class);
    }
}

