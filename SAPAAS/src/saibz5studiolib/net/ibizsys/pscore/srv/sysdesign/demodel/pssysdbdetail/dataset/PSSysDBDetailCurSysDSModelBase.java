/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdbdetail.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="B5EAD16B-2DD4-4473-A66A-9E0035A58504", name="CurSys", queries={@DEDataSetQuery(queryid="ABA72458-8532-4EAC-B82A-5D8BA2011C7C", queryname="CurSys")})
public abstract class PSSysDBDetailCurSysDSModelBase
extends DEDataSetModelBase {
    public PSSysDBDetailCurSysDSModelBase() {
        this.initAnnotation(PSSysDBDetailCurSysDSModelBase.class);
    }
}

