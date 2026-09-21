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

@DEDataSet(id="D736053F-8133-4713-BF6B-9F292286B45E", name="CurDCDE", queries={@DEDataSetQuery(queryid="22C90F56-5D48-4702-BB8A-22519B9A93BE", queryname="AllDCDE"), @DEDataSetQuery(queryid="B3E391E2-9F9C-4D03-9881-85CB2F1F1BDD", queryname="CurDCDE")})
public abstract class PSDCCodeSnippetCurDCDEDSModelBase
extends DEDataSetModelBase {
    public PSDCCodeSnippetCurDCDEDSModelBase() {
        this.initAnnotation(PSDCCodeSnippetCurDCDEDSModelBase.class);
    }
}

