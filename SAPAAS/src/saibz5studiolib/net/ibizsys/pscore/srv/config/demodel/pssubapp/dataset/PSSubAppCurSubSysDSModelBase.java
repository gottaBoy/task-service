/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubapp.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="CE02F8A6-9F40-406F-ADD9-9F5969BC115D", name="CurSubSys", queries={@DEDataSetQuery(queryid="0C1572EC-23F8-4297-9B4A-B7BD268D7D6B", queryname="CurSubSys")})
public abstract class PSSubAppCurSubSysDSModelBase
extends DEDataSetModelBase {
    public PSSubAppCurSubSysDSModelBase() {
        this.initAnnotation(PSSubAppCurSubSysDSModelBase.class);
    }
}

