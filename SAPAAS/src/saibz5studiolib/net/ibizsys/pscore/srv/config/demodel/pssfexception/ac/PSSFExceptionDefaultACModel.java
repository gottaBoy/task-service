/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfexception.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="977abc4a87cbe3d2846feb4155fc269c", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFEXCEPTIONID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFEXCEPTIONNAME", format="")})})
public class PSSFExceptionDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFExceptionDefaultACModel() {
        this.initAnnotation(PSSFExceptionDefaultACModel.class);
    }
}

