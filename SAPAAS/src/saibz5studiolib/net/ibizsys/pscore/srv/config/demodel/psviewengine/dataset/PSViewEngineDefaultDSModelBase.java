/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psviewengine.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="bd426a00840360c993a6139549a8d6a4", name="DEFAULT", queries={@DEDataSetQuery(queryid="38530BE5-183B-4E2E-9FCD-EA378BF7E608", queryname="DEFAULT")})
public abstract class PSViewEngineDefaultDSModelBase
extends DEDataSetModelBase {
    public PSViewEngineDefaultDSModelBase() {
        this.initAnnotation(PSViewEngineDefaultDSModelBase.class);
    }
}

