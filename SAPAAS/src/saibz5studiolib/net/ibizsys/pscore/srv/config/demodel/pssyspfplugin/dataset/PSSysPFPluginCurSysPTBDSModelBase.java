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

@DEDataSet(id="CF77989E-DD2E-4C5E-A0F6-CEE6E35502AF", name="CurSysPTB", queries={@DEDataSetQuery(queryid="3DBF9D91-1A7C-46B1-B0C0-C9970A56F753", queryname="CurSysPTB")})
public abstract class PSSysPFPluginCurSysPTBDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysPTBDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysPTBDSModelBase.class);
    }
}

