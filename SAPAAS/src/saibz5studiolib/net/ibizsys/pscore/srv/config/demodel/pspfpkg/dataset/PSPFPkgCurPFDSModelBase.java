/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfpkg.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="C0F2A183-072E-4D4D-A1A6-9360B4354922", name="CurPF", queries={@DEDataSetQuery(queryid="C0F2A183-072E-4D4D-A1A6-9360B4354922", queryname="CurPF")})
public abstract class PSPFPkgCurPFDSModelBase
extends DEDataSetModelBase {
    public PSPFPkgCurPFDSModelBase() {
        this.initAnnotation(PSPFPkgCurPFDSModelBase.class);
    }
}

