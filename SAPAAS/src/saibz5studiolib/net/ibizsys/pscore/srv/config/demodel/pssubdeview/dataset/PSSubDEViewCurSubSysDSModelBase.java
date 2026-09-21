/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubdeview.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="C18B22F4-46FF-4D11-A7CB-C84E43A9EC55", name="CurSubSys", queries={@DEDataSetQuery(queryid="5134BA18-2C40-4910-ADBA-29FB53A70948", queryname="CurSubSys")})
public abstract class PSSubDEViewCurSubSysDSModelBase
extends DEDataSetModelBase {
    public PSSubDEViewCurSubSysDSModelBase() {
        this.initAnnotation(PSSubDEViewCurSubSysDSModelBase.class);
    }
}

