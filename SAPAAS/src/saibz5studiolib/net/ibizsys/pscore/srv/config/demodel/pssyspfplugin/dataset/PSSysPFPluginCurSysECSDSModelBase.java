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

@DEDataSet(id="408A348D-0E99-4FEE-A2B9-9515CC2150F5", name="CurSysECS", queries={@DEDataSetQuery(queryid="5346A99F-46F4-4E6E-ABFC-48ADF1727F0D", queryname="CurSysECS")})
public abstract class PSSysPFPluginCurSysECSDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysECSDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysECSDSModelBase.class);
    }
}

