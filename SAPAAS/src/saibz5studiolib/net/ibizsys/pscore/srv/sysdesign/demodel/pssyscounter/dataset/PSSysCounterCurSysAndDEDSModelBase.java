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

@DEDataSet(id="89538793-43C1-4B31-8B54-1A557BA726F4", name="CurSysAndDE", queries={@DEDataSetQuery(queryid="FEBD520B-A189-41EF-9C53-52ECD3E6637A", queryname="CurDE"), @DEDataSetQuery(queryid="79EFAD4E-263A-4538-8958-98277DEF7A45", queryname="CurSysNotDE")})
public abstract class PSSysCounterCurSysAndDEDSModelBase
extends DEDataSetModelBase {
    public PSSysCounterCurSysAndDEDSModelBase() {
        this.initAnnotation(PSSysCounterCurSysAndDEDSModelBase.class);
    }
}

