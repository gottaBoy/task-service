/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfstylelog.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="545a8c458c0fc7c4577e9a75633657f3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFSTYLELOGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFSTYLELOGNAME", format="")})})
public class PSSFStyleLogDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFStyleLogDefaultACModel() {
        this.initAnnotation(PSSFStyleLogDefaultACModel.class);
    }
}

