/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psdcserverstate.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="19DE4CEC-F63C-4B2B-B50D-B621064C216E", name="CurDC", queries={@DEDataSetQuery(queryid="E35FD397-695F-4446-ACDA-6F47939DA07D", queryname="CurDC")})
public abstract class PSDCServerStateCurDCDSModelBase
extends DEDataSetModelBase {
    public PSDCServerStateCurDCDSModelBase() {
        this.initAnnotation(PSDCServerStateCurDCDSModelBase.class);
    }
}

