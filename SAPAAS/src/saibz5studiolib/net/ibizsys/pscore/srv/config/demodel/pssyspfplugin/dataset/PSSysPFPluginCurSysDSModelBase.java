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

@DEDataSet(id="5C061002-18B9-425E-A4DA-393ED0C70D3C", name="CurSys", queries={@DEDataSetQuery(queryid="C1E769CA-C0CF-45B2-B9BC-11D477A9FEEE", queryname="CurSys")})
public abstract class PSSysPFPluginCurSysDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysDSModelBase.class);
    }
}

