/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfstyle.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="3BDC1B7C-6B8B-4378-929D-CF0E48B8CC8A", name="CurSF", queries={@DEDataSetQuery(queryid="F3141827-6E3E-470E-A517-E5D172486C34", queryname="CurSF")})
public abstract class PSSFStyleCurSFDSModelBase
extends DEDataSetModelBase {
    public PSSFStyleCurSFDSModelBase() {
        this.initAnnotation(PSSFStyleCurSFDSModelBase.class);
    }
}

