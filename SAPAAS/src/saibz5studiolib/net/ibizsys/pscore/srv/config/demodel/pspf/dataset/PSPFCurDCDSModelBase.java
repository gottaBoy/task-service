/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspf.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="14E13D38-FF0E-4145-B00A-520BE4C843DC", name="CurDC", queries={@DEDataSetQuery(queryid="14E13D38-FF0E-4145-B00A-520BE4C843DC", queryname="CurDC"), @DEDataSetQuery(queryid="570C7E2A-0B56-49DC-9C57-6FA5B6EA5797", queryname="CurDC2")})
public abstract class PSPFCurDCDSModelBase
extends DEDataSetModelBase {
    public PSPFCurDCDSModelBase() {
        this.initAnnotation(PSPFCurDCDSModelBase.class);
    }
}

