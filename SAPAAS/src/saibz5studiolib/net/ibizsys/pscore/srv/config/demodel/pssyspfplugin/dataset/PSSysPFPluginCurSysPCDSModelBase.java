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

@DEDataSet(id="42E7ACE5-FC6A-4F08-A2CC-FAC47A030344", name="CurSysPC", queries={@DEDataSetQuery(queryid="10AA8ADD-0249-4CA7-BAE8-2D156C83B836", queryname="CurSysPC")})
public abstract class PSSysPFPluginCurSysPCDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysPCDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysPCDSModelBase.class);
    }
}

