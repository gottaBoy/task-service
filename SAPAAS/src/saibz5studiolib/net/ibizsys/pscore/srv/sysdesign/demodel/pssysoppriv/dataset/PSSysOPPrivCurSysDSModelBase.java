/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysoppriv.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="76DFC712-F078-4156-AC5B-07B02DD3B693", name="CurSys", queries={@DEDataSetQuery(queryid="7B137B02-7327-4FDF-9EBE-5733477C3AD6", queryname="CurSys")})
public abstract class PSSysOPPrivCurSysDSModelBase
extends DEDataSetModelBase {
    public PSSysOPPrivCurSysDSModelBase() {
        this.initAnnotation(PSSysOPPrivCurSysDSModelBase.class);
    }
}

