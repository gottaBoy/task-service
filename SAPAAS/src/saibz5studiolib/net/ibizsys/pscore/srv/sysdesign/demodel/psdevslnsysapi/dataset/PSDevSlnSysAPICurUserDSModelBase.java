/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnsysapi.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="F6D140DB-85A8-4967-A183-A1F284C20AD3", name="CurUser", queries={@DEDataSetQuery(queryid="F6D140DB-85A8-4967-A183-A1F284C20AD3", queryname="CurUser"), @DEDataSetQuery(queryid="CA181015-98C3-4182-AB27-C704701A33A5", queryname="CurUser2"), @DEDataSetQuery(queryid="D8B4D61A-F306-4FE3-AFB7-A19EFBAF2B23", queryname="CurUser3"), @DEDataSetQuery(queryid="F5E23200-0DA8-4106-9311-86F774A73D28", queryname="CurUser4")})
public abstract class PSDevSlnSysAPICurUserDSModelBase
extends DEDataSetModelBase {
    public PSDevSlnSysAPICurUserDSModelBase() {
        this.initAnnotation(PSDevSlnSysAPICurUserDSModelBase.class);
    }
}

