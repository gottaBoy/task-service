/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysref.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="C4FE92E2-49FE-4288-A8EF-B498ECFAA22D", name="CurSys", queries={@DEDataSetQuery(queryid="901ADDB8-5734-460C-A888-BFF20F582C45", queryname="CurSys")})
public abstract class PSSysRefCurSysDSModelBase
extends DEDataSetModelBase {
    public PSSysRefCurSysDSModelBase() {
        this.initAnnotation(PSSysRefCurSysDSModelBase.class);
    }
}

