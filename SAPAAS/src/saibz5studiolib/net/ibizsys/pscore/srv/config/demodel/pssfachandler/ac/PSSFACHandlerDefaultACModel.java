/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfachandler.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="086b334ff0156ce3b0a23a41cd9f8ce4", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFACHANDLERID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFACHANDLERNAME", format="")})})
public class PSSFACHandlerDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFACHandlerDefaultACModel() {
        this.initAnnotation(PSSFACHandlerDefaultACModel.class);
    }
}

