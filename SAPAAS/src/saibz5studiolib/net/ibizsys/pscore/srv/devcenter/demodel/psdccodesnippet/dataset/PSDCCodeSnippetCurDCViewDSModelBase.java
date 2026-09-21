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

@DEDataSet(id="26E55076-3D00-4329-8F80-6BDF493D06F9", name="CurDCView", queries={@DEDataSetQuery(queryid="1573B6D4-70D9-4E17-824D-48D4AE2A64E7", queryname="AllDCView"), @DEDataSetQuery(queryid="C17572BA-E721-4182-AF01-66B4693B028F", queryname="CurDCView")})
public abstract class PSDCCodeSnippetCurDCViewDSModelBase
extends DEDataSetModelBase {
    public PSDCCodeSnippetCurDCViewDSModelBase() {
        this.initAnnotation(PSDCCodeSnippetCurDCViewDSModelBase.class);
    }
}

