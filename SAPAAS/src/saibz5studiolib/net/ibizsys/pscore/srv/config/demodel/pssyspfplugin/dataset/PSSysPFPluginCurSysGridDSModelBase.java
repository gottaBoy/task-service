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

@DEDataSet(id="A746A36D-ECFF-4D43-9B81-46A6ECAA34FA", name="CurSysGrid", queries={@DEDataSetQuery(queryid="A746A36D-ECFF-4D43-9B81-46A6ECAA34FA", queryname="CurSysGrid")})
public abstract class PSSysPFPluginCurSysGridDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysGridDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysGridDSModelBase.class);
    }
}

