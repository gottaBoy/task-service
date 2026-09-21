/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psuapolicytype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="0ae666f6329ea3926babab8d476f5078", name="DEFAULT", queries={@DEDataSetQuery(queryid="A167FDBF-A926-4951-83DE-D51B0B74FC5A", queryname="DEFAULT")})
public abstract class PSUAPolicyTypeDefaultDSModelBase
extends DEDataSetModelBase {
    public PSUAPolicyTypeDefaultDSModelBase() {
        this.initAnnotation(PSUAPolicyTypeDefaultDSModelBase.class);
    }
}

