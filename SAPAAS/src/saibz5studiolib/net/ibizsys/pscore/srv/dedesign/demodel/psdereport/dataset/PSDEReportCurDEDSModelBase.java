/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdereport.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="97A05A83-4948-48E2-8A88-F564624B0F10", name="CurDE", queries={@DEDataSetQuery(queryid="6F81DFD4-3407-4019-A170-382274DF0B2E", queryname="CurDE")})
public abstract class PSDEReportCurDEDSModelBase
extends DEDataSetModelBase {
    public PSDEReportCurDEDSModelBase() {
        this.initAnnotation(PSDEReportCurDEDSModelBase.class);
    }
}

