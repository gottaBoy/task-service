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

@DEDataSet(id="52D10F90-8813-4F8C-B8E2-6F31AE6AAB80", name="OUT", queries={@DEDataSetQuery(queryid="C288ABFC-1955-4C0A-AED3-3E1E0BCADA21", queryname="INOUT"), @DEDataSetQuery(queryid="A6796394-7776-4FDF-A156-EA0EDC4B04A8", queryname="OUT")})
public abstract class PSSysDataSyncAgentOutDSModelBase
extends DEDataSetModelBase {
    public PSSysDataSyncAgentOutDSModelBase() {
        this.initAnnotation(PSSysDataSyncAgentOutDSModelBase.class);
    }
}

