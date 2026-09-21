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

@DEDataSet(id="EA7D51AC-694C-4C20-9B1B-BA5637C844B2", name="CurSysDashboardPart", queries={@DEDataSetQuery(queryid="EA7D51AC-694C-4C20-9B1B-BA5637C844B2", queryname="CurSysDashboardPart")})
public abstract class PSSysPFPluginDashboardPartDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginDashboardPartDSModelBase() {
        this.initAnnotation(PSSysPFPluginDashboardPartDSModelBase.class);
    }
}

