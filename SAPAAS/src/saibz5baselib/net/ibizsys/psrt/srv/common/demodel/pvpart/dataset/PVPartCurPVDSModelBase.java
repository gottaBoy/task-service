/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.demodel.pvpart.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="689C1D69-8EF0-41B1-B64B-EF6DBE6E6851", name="CurPV", queries={@DEDataSetQuery(queryid="DEA9923C-7E2A-45D0-936D-656E1473764B", queryname="CurPV")})
public abstract class PVPartCurPVDSModelBase
extends DEDataSetModelBase {
    public PVPartCurPVDSModelBase() {
        this.initAnnotation(PVPartCurPVDSModelBase.class);
    }
}

