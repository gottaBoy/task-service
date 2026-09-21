/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscounter.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="90B84E5F-AFE9-4C1E-AC7E-495913E92EA7", name="CurSys", queries={@DEDataSetQuery(queryid="85932FB2-2491-41A9-BDE9-9D37FB17F400", queryname="CurSys")})
public abstract class PSSysCounterCurSysDSModelBase
extends DEDataSetModelBase {
    public PSSysCounterCurSysDSModelBase() {
        this.initAnnotation(PSSysCounterCurSysDSModelBase.class);
    }
}

