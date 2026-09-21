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

@DEDataSet(id="FA952001-5802-4E0A-A19F-B73285D53B44", name="CurDCDB", queries={@DEDataSetQuery(queryid="1DA92CFE-54AD-48CB-98F9-A9D8E89A7DD0", queryname="AllDCDB"), @DEDataSetQuery(queryid="D046CEA5-534F-49F9-A518-F2BE5E9D5F6C", queryname="CurDCDB")})
public abstract class PSDCCodeSnippetCurDCDBDSModelBase
extends DEDataSetModelBase {
    public PSDCCodeSnippetCurDCDBDSModelBase() {
        this.initAnnotation(PSDCCodeSnippetCurDCDBDSModelBase.class);
    }
}

