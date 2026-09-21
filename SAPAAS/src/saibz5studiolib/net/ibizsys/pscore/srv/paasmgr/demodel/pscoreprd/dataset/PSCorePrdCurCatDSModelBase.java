/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pscoreprd.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="7BBFDE75-E7BF-4ED8-9B13-3369132A2E17", name="CurCat", queries={@DEDataSetQuery(queryid="D3B99760-A2B7-4AD6-8A77-7A197BE06BFF", queryname="CurCat")})
public abstract class PSCorePrdCurCatDSModelBase
extends DEDataSetModelBase {
    public PSCorePrdCurCatDSModelBase() {
        this.initAnnotation(PSCorePrdCurCatDSModelBase.class);
    }
}

