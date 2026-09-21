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

@DEDataSet(id="D799DD03-4DEA-45D8-81F2-D8E247D6084D", name="CurDC", queries={@DEDataSetQuery(queryid="D799DD03-4DEA-45D8-81F2-D8E247D6084D", queryname="CurDC")})
public abstract class PSSFStyleCurDCDSModelBase
extends DEDataSetModelBase {
    public PSSFStyleCurDCDSModelBase() {
        this.initAnnotation(PSSFStyleCurDCDSModelBase.class);
    }
}

