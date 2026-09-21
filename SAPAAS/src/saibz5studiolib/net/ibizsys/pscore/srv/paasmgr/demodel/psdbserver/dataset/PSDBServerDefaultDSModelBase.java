/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psdbserver.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="9ba47ad76b51f822ec35564d8475e09a", name="DEFAULT", queries={@DEDataSetQuery(queryid="BE8D53BC-4D95-48F6-97E9-C63B86EC608F", queryname="DEFAULT")})
public abstract class PSDBServerDefaultDSModelBase
extends DEDataSetModelBase {
    public PSDBServerDefaultDSModelBase() {
        this.initAnnotation(PSDBServerDefaultDSModelBase.class);
    }
}

