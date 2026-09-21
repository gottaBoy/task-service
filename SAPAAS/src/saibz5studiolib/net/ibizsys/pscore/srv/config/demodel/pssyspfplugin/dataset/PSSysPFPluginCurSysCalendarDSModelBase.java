/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssyspfplugin.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="C0539E61-1989-4FA3-8E0D-385C8BCFEBE3", name="CurSysCalendar", queries={@DEDataSetQuery(queryid="C0539E61-1989-4FA3-8E0D-385C8BCFEBE3", queryname="CurSysCalendar")})
public abstract class PSSysPFPluginCurSysCalendarDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysCalendarDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysCalendarDSModelBase.class);
    }
}

