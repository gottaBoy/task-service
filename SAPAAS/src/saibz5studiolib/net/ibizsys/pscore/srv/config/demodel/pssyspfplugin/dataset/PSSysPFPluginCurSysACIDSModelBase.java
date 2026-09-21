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

@DEDataSet(id="6E0CF49B-92B1-42FA-B216-4DB1148A6136", name="CurSysACI", queries={@DEDataSetQuery(queryid="5D2BF21C-AB76-4284-B39C-7185BC3A3A8A", queryname="CurSysACI")})
public abstract class PSSysPFPluginCurSysACIDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysACIDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysACIDSModelBase.class);
    }
}

