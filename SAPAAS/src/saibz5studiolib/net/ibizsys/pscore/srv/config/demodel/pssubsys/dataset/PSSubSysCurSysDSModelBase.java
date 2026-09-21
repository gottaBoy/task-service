/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubsys.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="EF253952-E077-48F4-B391-1D351C47A956", name="CurSys", queries={@DEDataSetQuery(queryid="42872E64-09F0-4DFD-8DE1-447E38BA55BD", queryname="CurSys")})
public abstract class PSSubSysCurSysDSModelBase
extends DEDataSetModelBase {
    public PSSubSysCurSysDSModelBase() {
        this.initAnnotation(PSSubSysCurSysDSModelBase.class);
    }
}

