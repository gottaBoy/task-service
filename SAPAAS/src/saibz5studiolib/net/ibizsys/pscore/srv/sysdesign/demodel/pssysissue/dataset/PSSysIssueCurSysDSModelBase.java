/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysissue.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="BC400FF8-6102-4B5E-A19A-FE935DDE763A", name="CurSys", queries={@DEDataSetQuery(queryid="6AA42029-F47A-4846-AA17-EFF58E8F09C4", queryname="CurSys")})
public abstract class PSSysIssueCurSysDSModelBase
extends DEDataSetModelBase {
    public PSSysIssueCurSysDSModelBase() {
        this.initAnnotation(PSSysIssueCurSysDSModelBase.class);
    }
}

