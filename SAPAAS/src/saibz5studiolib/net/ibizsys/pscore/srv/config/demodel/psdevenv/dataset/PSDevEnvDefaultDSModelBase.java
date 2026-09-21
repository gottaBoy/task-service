/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdevenv.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="6b4a151d86390043540f5ae385d2dde2", name="DEFAULT", queries={@DEDataSetQuery(queryid="5821E420-5A7D-4D2F-9911-7B23791A62A2", queryname="DEFAULT")})
public abstract class PSDevEnvDefaultDSModelBase
extends DEDataSetModelBase {
    public PSDevEnvDefaultDSModelBase() {
        this.initAnnotation(PSDevEnvDefaultDSModelBase.class);
    }
}

