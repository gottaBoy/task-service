/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEACMode
 *  net.ibizsys.paas.data.DataItem
 *  net.ibizsys.paas.data.DataItemParam
 *  net.ibizsys.paas.demodel.DEACModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyssqlcmdsql.ac;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.DataItemParam;
import net.ibizsys.paas.demodel.DEACModelBase;

@DEACMode(name="DEFAULT", id="e9a317c3c1eb96938e123185e2435168", defaultmode=true, dataitems={@DataItem(name="value", dataitemparams={@DataItemParam(name="PSSYSSQLCMDSQLID", format="")}), @DataItem(name="text", dataitemparams={@DataItemParam(name="PSSYSSQLCMDSQLNAME", format="")})})
public class PSSysSQLCmdSQLDefaultACModel
extends DEACModelBase {
    public static final String NAME = "DEFAULT";

    public PSSysSQLCmdSQLDefaultACModel() {
        this.initAnnotation(PSSysSQLCmdSQLDefaultACModel.class);
    }
}

