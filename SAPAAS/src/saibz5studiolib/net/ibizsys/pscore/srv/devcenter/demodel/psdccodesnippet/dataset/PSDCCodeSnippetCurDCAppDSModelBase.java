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

@DEDataSet(id="172CFC88-31F4-4992-AB8D-0ABF6A475BCB", name="CurDCApp", queries={@DEDataSetQuery(queryid="0A0004F6-CD34-4C96-8439-E3F22C918DCD", queryname="AllDCApp"), @DEDataSetQuery(queryid="A5C40F9C-B623-4114-96E9-D3F87B894C9E", queryname="CurDCApp")})
public abstract class PSDCCodeSnippetCurDCAppDSModelBase
extends DEDataSetModelBase {
    public PSDCCodeSnippetCurDCAppDSModelBase() {
        this.initAnnotation(PSDCCodeSnippetCurDCAppDSModelBase.class);
    }
}

