/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystask.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="0A1CB830-1093-4F45-B78E-4268DAF33642", name="CurSys", queries={@DEDataSetQuery(queryid="47448C6E-C433-4CC2-9EA4-202F8E50A715", queryname="CurSys")})
public abstract class PSSysTaskCurSysDSModelBase
extends DEDataSetModelBase {
    public PSSysTaskCurSysDSModelBase() {
        this.initAnnotation(PSSysTaskCurSysDSModelBase.class);
    }
}

