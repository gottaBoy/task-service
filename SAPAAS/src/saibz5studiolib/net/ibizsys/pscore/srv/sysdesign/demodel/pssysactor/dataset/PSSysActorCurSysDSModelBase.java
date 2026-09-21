/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysactor.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="B08F31F9-F1DC-46B6-B2B2-0338084401D7", name="CurSys", queries={@DEDataSetQuery(queryid="43ACEFE8-2FA2-468C-B751-CF14B3015666", queryname="CurSys")})
public abstract class PSSysActorCurSysDSModelBase
extends DEDataSetModelBase {
    public PSSysActorCurSysDSModelBase() {
        this.initAnnotation(PSSysActorCurSysDSModelBase.class);
    }
}

