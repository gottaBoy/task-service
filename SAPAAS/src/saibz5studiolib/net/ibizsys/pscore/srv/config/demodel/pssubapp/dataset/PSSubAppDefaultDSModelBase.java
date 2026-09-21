/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubapp.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="6f7a0e8f92848460fb01df38a8c3a6f0", name="DEFAULT", queries={@DEDataSetQuery(queryid="7B873881-CE50-4EE8-8B45-D5080D1DB81C", queryname="DEFAULT")})
public abstract class PSSubAppDefaultDSModelBase
extends DEDataSetModelBase {
    public PSSubAppDefaultDSModelBase() {
        this.initAnnotation(PSSubAppDefaultDSModelBase.class);
    }
}

