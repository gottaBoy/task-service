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

@DEDataSet(id="850bff46135ea742014684051bf67889", name="DEFAULT", queries={@DEDataSetQuery(queryid="2D046E04-B90B-4D21-B9B4-71643BE9840B", queryname="DEFAULT")})
public abstract class PSSysPFPluginDefaultDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginDefaultDSModelBase() {
        this.initAnnotation(PSSysPFPluginDefaultDSModelBase.class);
    }
}

