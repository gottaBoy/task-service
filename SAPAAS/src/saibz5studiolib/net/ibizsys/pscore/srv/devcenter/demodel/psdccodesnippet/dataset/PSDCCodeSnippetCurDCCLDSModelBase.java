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

@DEDataSet(id="79C05953-9F41-4177-BD72-F39E9F25DC38", name="CurDCCL", queries={@DEDataSetQuery(queryid="9DDF80C0-6CFD-4C61-B389-23164441D626", queryname="AllDCCL"), @DEDataSetQuery(queryid="BCBA0802-E9C6-4D31-BAD4-7FD663B3F11E", queryname="CurDCCL")})
public abstract class PSDCCodeSnippetCurDCCLDSModelBase
extends DEDataSetModelBase {
    public PSDCCodeSnippetCurDCCLDSModelBase() {
        this.initAnnotation(PSDCCodeSnippetCurDCCLDSModelBase.class);
    }
}

