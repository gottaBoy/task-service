/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepsln.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="533AF137-D97C-41A2-A87F-4187D4B760DC", name="CurDC", queries={@DEDataSetQuery(queryid="04A04FF3-1A10-480B-B459-A6F2305543EB", queryname="CurDC")})
public abstract class PSDepSlnCurDCDSModelBase
extends DEDataSetModelBase {
    public PSDepSlnCurDCDSModelBase() {
        this.initAnnotation(PSDepSlnCurDCDSModelBase.class);
    }
}

