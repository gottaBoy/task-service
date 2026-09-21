/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcregistryitem.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="A7F282BE-164D-4835-8BD4-9951636EF359", name="CurRepo", queries={@DEDataSetQuery(queryid="A7F282BE-164D-4835-8BD4-9951636EF359", queryname="CurRepo")})
public abstract class PSDCRegistryItemCurRepoDSModelBase
extends DEDataSetModelBase {
    public PSDCRegistryItemCurRepoDSModelBase() {
        this.initAnnotation(PSDCRegistryItemCurRepoDSModelBase.class);
    }
}

