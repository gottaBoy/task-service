/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysapp.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="0BD8FC94-4D8E-4F85-A164-102F58C9781D", name="CurSys", queries={@DEDataSetQuery(queryid="F812F599-ED79-4032-90A7-4EB34239528F", queryname="CurSys")})
public abstract class PSSysAppCurSysDSModelBase
extends DEDataSetModelBase {
    public PSSysAppCurSysDSModelBase() {
        this.initAnnotation(PSSysAppCurSysDSModelBase.class);
    }
}

