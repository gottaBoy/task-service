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

@DEDataSet(id="096BAC01-65BA-4D20-825F-7C584A11079B", name="CurSysDVI", queries={@DEDataSetQuery(queryid="67AE8192-EE2E-4308-8B1C-8F5F76A6F1D7", queryname="CurSysDVI")})
public abstract class PSSysPFPluginCurSysDVIDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysDVIDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysDVIDSModelBase.class);
    }
}

