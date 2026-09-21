/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psapptype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="d8e4bd9bde2358c11daac4de590859de", name="DEFAULT", queries={@DEDataSetQuery(queryid="9C484C3B-E179-4349-A447-9CA00845ABD5", queryname="DEFAULT")})
public abstract class PSAppTypeDefaultDSModelBase
extends DEDataSetModelBase {
    public PSAppTypeDefaultDSModelBase() {
        this.initAnnotation(PSAppTypeDefaultDSModelBase.class);
    }
}

