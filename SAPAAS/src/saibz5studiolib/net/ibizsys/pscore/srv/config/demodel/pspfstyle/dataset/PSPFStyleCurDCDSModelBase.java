/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfstyle.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="F740D7D3-4CA2-4489-8F2D-C7CB4A975E9F", name="CurDC", queries={@DEDataSetQuery(queryid="D2D36BD6-640E-4E26-897E-9BCD6F6425B6", queryname="CurDC")})
public abstract class PSPFStyleCurDCDSModelBase
extends DEDataSetModelBase {
    public PSPFStyleCurDCDSModelBase() {
        this.initAnnotation(PSPFStyleCurDCDSModelBase.class);
    }
}

