/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdeploy.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="7FE72DDB-6999-4717-8AD0-3849AF07285D", name="CurSys", queries={@DEDataSetQuery(queryid="B725AD6D-7A21-47DD-B1CF-AA2F115B4CEA", queryname="CurSys")})
public abstract class PSSysDeployCurSysDSModelBase
extends DEDataSetModelBase {
    public PSSysDeployCurSysDSModelBase() {
        this.initAnnotation(PSSysDeployCurSysDSModelBase.class);
    }
}

