/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysermap.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="E000DF68-C7FF-4BCF-88D7-1097FBCC05AA", name="CurSys", queries={@DEDataSetQuery(queryid="94E96ACB-A846-43C2-A634-43DFF536C4B7", queryname="CurSys")})
public abstract class PSSysERMapCurSysDSModelBase
extends DEDataSetModelBase {
    public PSSysERMapCurSysDSModelBase() {
        this.initAnnotation(PSSysERMapCurSysDSModelBase.class);
    }
}

