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

@DEDataSet(id="FE05E029-479D-44EE-B3BD-2F1D7C79CC72", name="CurApp", queries={@DEDataSetQuery(queryid="FE05E029-479D-44EE-B3BD-2F1D7C79CC72", queryname="CurApp")})
public abstract class PSSysCounterCurAppDSModelBase
extends DEDataSetModelBase {
    public PSSysCounterCurAppDSModelBase() {
        this.initAnnotation(PSSysCounterCurAppDSModelBase.class);
    }
}

