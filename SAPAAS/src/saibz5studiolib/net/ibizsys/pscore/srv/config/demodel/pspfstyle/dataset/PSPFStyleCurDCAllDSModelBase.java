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

@DEDataSet(id="4983F937-1FD5-4AC5-B689-7B6BE4C33AB3", name="CurDCAll", queries={@DEDataSetQuery(queryid="D2D36BD6-640E-4E26-897E-9BCD6F6425B6", queryname="CurDC"), @DEDataSetQuery(queryid="98587B73-1C0E-4645-86F2-A785BEEF09A6", queryname="CurDC2")})
public abstract class PSPFStyleCurDCAllDSModelBase
extends DEDataSetModelBase {
    public PSPFStyleCurDCAllDSModelBase() {
        this.initAnnotation(PSPFStyleCurDCAllDSModelBase.class);
    }
}

