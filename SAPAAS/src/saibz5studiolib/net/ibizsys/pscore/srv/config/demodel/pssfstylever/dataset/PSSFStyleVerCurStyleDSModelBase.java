/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfstylever.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="F0FF302E-7BB0-4092-A1EC-CB93A474D2DB", name="CURSTYLE", queries={@DEDataSetQuery(queryid="8E86EE19-97F9-4190-B206-05F082F03B2A", queryname="CURSTYLE")})
public abstract class PSSFStyleVerCurStyleDSModelBase
extends DEDataSetModelBase {
    public PSSFStyleVerCurStyleDSModelBase() {
        this.initAnnotation(PSSFStyleVerCurStyleDSModelBase.class);
    }
}

