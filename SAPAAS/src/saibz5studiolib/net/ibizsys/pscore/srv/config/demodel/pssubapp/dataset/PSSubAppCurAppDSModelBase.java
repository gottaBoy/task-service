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

@DEDataSet(id="E9E5672E-3667-4E2C-B98C-E7823139256D", name="CurApp", queries={@DEDataSetQuery(queryid="0F2996F5-4F24-492B-8B48-D0303FA66998", queryname="CurApp")})
public abstract class PSSubAppCurAppDSModelBase
extends DEDataSetModelBase {
    public PSSubAppCurAppDSModelBase() {
        this.initAnnotation(PSSubAppCurAppDSModelBase.class);
    }
}

