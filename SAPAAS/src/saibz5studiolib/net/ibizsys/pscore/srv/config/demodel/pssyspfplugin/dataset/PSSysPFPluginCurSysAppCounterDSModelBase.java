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

@DEDataSet(id="1A4C7730-FFF4-4576-958B-799028DF65BA", name="CurSysAppCounter", queries={@DEDataSetQuery(queryid="1A4C7730-FFF4-4576-958B-799028DF65BA", queryname="CurSysAppCounter")})
public abstract class PSSysPFPluginCurSysAppCounterDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysAppCounterDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysAppCounterDSModelBase.class);
    }
}

