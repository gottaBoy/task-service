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

@DEDataSet(id="332A5946-410B-4C4F-987B-97014C2AF43E", name="CurDCDocAll", queries={@DEDataSetQuery(queryid="969C50EE-C958-47ED-AE19-3273622D9962", queryname="CurDCDoc"), @DEDataSetQuery(queryid="5E24C3CD-A926-4906-8FFB-7CB701485833", queryname="CurDCDoc2")})
public abstract class PSSFStyleCurDCDocAllDSModelBase
extends DEDataSetModelBase {
    public PSSFStyleCurDCDocAllDSModelBase() {
        this.initAnnotation(PSSFStyleCurDCDocAllDSModelBase.class);
    }
}

