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

@DEDataSet(id="C6A59A2C-C7A9-409C-9111-6A3D2A7109BD", name="All", queries={@DEDataSetQuery(queryid="0F68FF9F-A034-4548-AC75-3D0A8A214E86", queryname="AllDC"), @DEDataSetQuery(queryid="801A4A23-95BA-4409-8B65-092256C796FB", queryname="CurDC")})
public abstract class PSDCCodeSnippetAllDSModelBase
extends DEDataSetModelBase {
    public PSDCCodeSnippetAllDSModelBase() {
        this.initAnnotation(PSDCCodeSnippetAllDSModelBase.class);
    }
}

