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

@DEDataSet(id="B336DA91-1B86-4EA3-950E-44A4DCA1A023", name="CurSysTree", queries={@DEDataSetQuery(queryid="B336DA91-1B86-4EA3-950E-44A4DCA1A023", queryname="CurSysTree")})
public abstract class PSSysPFPluginCurSysTreeDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysTreeDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysTreeDSModelBase.class);
    }
}

