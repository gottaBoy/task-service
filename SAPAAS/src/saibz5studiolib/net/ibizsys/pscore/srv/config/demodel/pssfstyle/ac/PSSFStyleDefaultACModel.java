/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfstyle.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="47aedebaa35da0ac1777d997dc023bdd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSFSTYLEID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSFSTYLENAME", format="")})})
public class PSSFStyleDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSFStyleDefaultACModel() {
        this.initAnnotation(PSSFStyleDefaultACModel.class);
    }
}

