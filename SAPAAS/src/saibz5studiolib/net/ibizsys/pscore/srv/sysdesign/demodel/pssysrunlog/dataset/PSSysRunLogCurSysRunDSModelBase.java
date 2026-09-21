/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysrunlog.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="D0F4884E-5579-43FC-B410-183F56DE9DC1", name="CurSysRun", queries={@DEDataSetQuery(queryid="CD8F046A-64ED-4F47-9E55-114C34A20269", queryname="CurSysRun")})
public abstract class PSSysRunLogCurSysRunDSModelBase
extends DEDataSetModelBase {
    public PSSysRunLogCurSysRunDSModelBase() {
        this.initAnnotation(PSSysRunLogCurSysRunDSModelBase.class);
    }
}

