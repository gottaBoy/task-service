/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfpkg.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="CF280BBD-CC58-453E-AD01-4D2B8796116A", name="CurSF", queries={@DEDataSetQuery(queryid="CF280BBD-CC58-453E-AD01-4D2B8796116A", queryname="CurSF")})
public abstract class PSSFPkgCurSFDSModelBase
extends DEDataSetModelBase {
    public PSSFPkgCurSFDSModelBase() {
        this.initAnnotation(PSSFPkgCurSFDSModelBase.class);
    }
}

