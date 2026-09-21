/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystemdbcfg.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="64687af1915eda73190e2801eca53fcd", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSTEMDBCFGID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSTEMDBCFGNAME", format="")})})
public class PSSystemDBCfgDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSystemDBCfgDefaultACModel() {
        this.initAnnotation(PSSystemDBCfgDefaultACModel.class);
    }
}

