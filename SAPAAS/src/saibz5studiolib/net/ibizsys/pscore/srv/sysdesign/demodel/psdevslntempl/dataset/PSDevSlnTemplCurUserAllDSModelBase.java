/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslntempl.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="EAB29085-A48C-4C8A-BA9F-E5C15E196D9D", name="CurUserAll", queries={@DEDataSetQuery(queryid="FBF660F5-BBD3-430E-8C0E-E5469CE8D17B", queryname="CurUser"), @DEDataSetQuery(queryid="68AB215A-9E6B-44C9-AB90-A35E3AE29399", queryname="CurUser3"), @DEDataSetQuery(queryid="388441F2-867C-4FB1-92BA-C5C35EDECC4E", queryname="CurUser4"), @DEDataSetQuery(queryid="8C220050-3778-405B-AA81-55AB4A7EE6DC", queryname="CurUser5"), @DEDataSetQuery(queryid="CBFACB3A-E47C-445B-907E-7B8884D0FC4D", queryname="CurUser6")})
public abstract class PSDevSlnTemplCurUserAllDSModelBase
extends DEDataSetModelBase {
    public PSDevSlnTemplCurUserAllDSModelBase() {
        this.initAnnotation(PSDevSlnTemplCurUserAllDSModelBase.class);
    }
}

