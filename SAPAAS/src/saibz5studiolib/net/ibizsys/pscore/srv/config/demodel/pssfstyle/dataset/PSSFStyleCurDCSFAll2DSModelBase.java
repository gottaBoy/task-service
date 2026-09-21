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

@DEDataSet(id="0A44B300-4EB7-40C7-96C7-818210E407AC", name="CurDCSFAll2", queries={@DEDataSetQuery(queryid="27E3FAC0-536D-44C4-B7A9-9A2B87A5249E", queryname="CurDCSF"), @DEDataSetQuery(queryid="ABCB1B22-C06E-4A8D-96A8-4F0ED0C48DC6", queryname="CurDCSF3")})
public abstract class PSSFStyleCurDCSFAll2DSModelBase
extends DEDataSetModelBase {
    public PSSFStyleCurDCSFAll2DSModelBase() {
        this.initAnnotation(PSSFStyleCurDCSFAll2DSModelBase.class);
    }
}

