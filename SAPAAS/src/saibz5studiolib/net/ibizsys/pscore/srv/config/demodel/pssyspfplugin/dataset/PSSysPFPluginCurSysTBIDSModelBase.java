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

@DEDataSet(id="1FD5803D-D94C-44B7-923D-90090177CB1C", name="CurSysTBI", queries={@DEDataSetQuery(queryid="DC1190A7-2B7C-49D3-9411-D6C6C880CA70", queryname="CurSysTBI")})
public abstract class PSSysPFPluginCurSysTBIDSModelBase
extends DEDataSetModelBase {
    public PSSysPFPluginCurSysTBIDSModelBase() {
        this.initAnnotation(PSSysPFPluginCurSysTBIDSModelBase.class);
    }
}

