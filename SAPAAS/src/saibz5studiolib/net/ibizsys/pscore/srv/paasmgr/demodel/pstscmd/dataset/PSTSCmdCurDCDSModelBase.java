/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pstscmd.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="58C1472F-331F-429B-9D38-D5878DC4875A", name="CurDC", queries={@DEDataSetQuery(queryid="9A21ECE3-3F55-47B1-8A97-4C1DDE848EE7", queryname="CurDC")})
public abstract class PSTSCmdCurDCDSModelBase
extends DEDataSetModelBase {
    public PSTSCmdCurDCDSModelBase() {
        this.initAnnotation(PSTSCmdCurDCDSModelBase.class);
    }
}

