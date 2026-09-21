/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="B06F52E8-CB65-48CF-98BB-3D2656D4BFEA", name="CurDCDEAction", queries={@DEDataSetQuery(queryid="40D961BB-5F3C-485A-A4DB-86F519AD7945", queryname="AllDCDEAction"), @DEDataSetQuery(queryid="DE208C7D-C84B-4E21-A512-D9E14A6D76CB", queryname="CurDCDEAction")})
public abstract class PSDCCodeSnippetCurDCDEActionDSModelBase
extends DEDataSetModelBase {
    public PSDCCodeSnippetCurDCDEActionDSModelBase() {
        this.initAnnotation(PSDCCodeSnippetCurDCDEActionDSModelBase.class);
    }
}

