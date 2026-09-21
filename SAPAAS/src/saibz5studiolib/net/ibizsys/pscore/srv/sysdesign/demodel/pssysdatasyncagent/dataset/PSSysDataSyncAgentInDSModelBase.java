/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdatasyncagent.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="A5D7CCF4-4A79-4C6E-BA35-71B7375402AE", name="IN", queries={@DEDataSetQuery(queryid="FE82FFB1-4B7D-4CE6-A7DE-DD12CF7040F2", queryname="IN"), @DEDataSetQuery(queryid="C288ABFC-1955-4C0A-AED3-3E1E0BCADA21", queryname="INOUT")})
public abstract class PSSysDataSyncAgentInDSModelBase
extends DEDataSetModelBase {
    public PSSysDataSyncAgentInDSModelBase() {
        this.initAnnotation(PSSysDataSyncAgentInDSModelBase.class);
    }
}

