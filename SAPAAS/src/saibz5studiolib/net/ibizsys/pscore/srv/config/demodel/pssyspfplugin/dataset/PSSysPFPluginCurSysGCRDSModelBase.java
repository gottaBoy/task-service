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

@DEDataSet(id="A911E677-C459-4D4E-9A6D-ECA9B94A15CB", name="CurSysGCR", queries={@DEDataSetQuery(queryid="A453236B-09EE-4505-9DBC-C662EF808B20", queryname="CurSysGCR")})
public abstract class PSSysPFPluginCurSysGCRDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysGCRDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysGCRDSModelBase.class);
    }
}

