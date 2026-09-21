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

@DEDataSet(id="3B7C469D-169E-4AD5-AF35-3BEC0EA629C2", name="CurSysCDV", queries={@DEDataSetQuery(queryid="914B7F45-E9FD-4C9D-B788-724686853D88", queryname="CurSysCDV")})
public abstract class PSSysPFPluginCurSysCDVDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysCDVDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysCDVDSModelBase.class);
    }
}

