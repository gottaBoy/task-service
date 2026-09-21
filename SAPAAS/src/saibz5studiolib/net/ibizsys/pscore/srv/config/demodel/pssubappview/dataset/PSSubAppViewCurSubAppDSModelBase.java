/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubappview.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="A105FFF5-548C-4F81-B7D1-D0BAFC43F2CB", name="CurSubApp", queries={@DEDataSetQuery(queryid="0F427D8B-C095-4869-A351-9D0515555F3E", queryname="CurSubApp")})
public abstract class PSSubAppViewCurSubAppDSModelBase
extends DEDataSetModelBase {
    public PSSubAppViewCurSubAppDSModelBase() {
        this.initAnnotation(PSSubAppViewCurSubAppDSModelBase.class);
    }
}

