/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedbcfg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="0e9c2b2901a14919ac24dae560c8efd3", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSDEDBCFGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSDEDBCFGNAME", format="")})})
public class PSDEDBCfgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSDEDBCfgDefaultACModel() {
        this.initAnnotation(PSDEDBCfgDefaultACModel.class);
    }
}

