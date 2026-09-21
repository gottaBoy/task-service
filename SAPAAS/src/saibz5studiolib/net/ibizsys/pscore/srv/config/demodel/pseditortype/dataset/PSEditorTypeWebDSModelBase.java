/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pseditortype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="69DAEC03-5691-48C4-8B6D-10C0860CF543", name="Web", queries={@DEDataSetQuery(queryid="69DAEC03-5691-48C4-8B6D-10C0860CF543", queryname="Web")})
public abstract class PSEditorTypeWebDSModelBase
extends DEDataSetModelBase {
    public PSEditorTypeWebDSModelBase() {
        this.initAnnotation(PSEditorTypeWebDSModelBase.class);
    }
}

