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

@DEDataSet(id="30D0E13D-05D0-4A40-834F-C2A2688D6C69", name="CurSysDLR", queries={@DEDataSetQuery(queryid="94C5D981-9638-4034-93C2-8BC14D2777AD", queryname="CurSysDLR")})
public abstract class PSSysPFPluginCurSysDLRDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysDLRDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysDLRDSModelBase.class);
    }
}

