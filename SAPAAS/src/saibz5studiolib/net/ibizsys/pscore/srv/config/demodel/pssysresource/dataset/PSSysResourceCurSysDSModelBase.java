/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssysresource.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="4E82C564-2A23-4C20-8C40-8A5810046065", name="CurSys", queries={@DEDataSetQuery(queryid="4E82C564-2A23-4C20-8C40-8A5810046065", queryname="CurSys")})
public abstract class PSSysResourceCurSysDSModelBase
extends DEDataSetModelBase {
    public PSSysResourceCurSysDSModelBase() {
        this.initAnnotation(PSSysResourceCurSysDSModelBase.class);
    }
}

