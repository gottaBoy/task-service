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

@DEDataSet(id="984C6DE2-1881-4AD5-8F21-299570624D78", name="CurDCDocAll2", queries={@DEDataSetQuery(queryid="969C50EE-C958-47ED-AE19-3273622D9962", queryname="CurDCDoc"), @DEDataSetQuery(queryid="B90DF554-2786-40C6-9507-86848E8A88E2", queryname="CurDCDoc3")})
public abstract class PSSFStyleCurDCDocAll2DSModelBase
extends DEDataSetModelBase {
    public PSSFStyleCurDCDocAll2DSModelBase() {
        this.initAnnotation(PSSFStyleCurDCDocAll2DSModelBase.class);
    }
}

