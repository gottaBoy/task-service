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

@DEDataSet(id="40C7D4E2-B299-43B1-8317-BF98108DDE1C", name="CurDCSys", queries={@DEDataSetQuery(queryid="1AFCCA25-DE00-4316-92EE-1543E3AEE5E1", queryname="AllDCSys"), @DEDataSetQuery(queryid="96829FFD-0CD8-4020-854C-AAA43F220FDA", queryname="CurDCSys")})
public abstract class PSDCCodeSnippetCurDCSysDSModelBase
extends DEDataSetModelBase {
    public PSDCCodeSnippetCurDCSysDSModelBase() {
        this.initAnnotation(PSDCCodeSnippetCurDCSysDSModelBase.class);
    }
}

