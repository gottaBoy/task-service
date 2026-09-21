/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psvtrv.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="abe00ee385144f0cfe07e32f4fac4f86", name="DEFAULT", queries={@DEDataSetQuery(queryid="E804D95E-7CE4-48D2-9606-FDB46FA0FE81", queryname="DEFAULT")})
public abstract class PSVTRVDefaultDSModelBase
extends DEDataSetModelBase {
    public PSVTRVDefaultDSModelBase() {
        this.initAnnotation(PSVTRVDefaultDSModelBase.class);
    }
}

