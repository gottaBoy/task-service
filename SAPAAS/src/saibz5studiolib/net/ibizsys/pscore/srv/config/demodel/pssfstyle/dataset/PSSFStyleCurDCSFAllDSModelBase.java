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

@DEDataSet(id="CF24774F-0FC6-4303-8F77-810C8B609079", name="CurDCSFAll", queries={@DEDataSetQuery(queryid="27E3FAC0-536D-44C4-B7A9-9A2B87A5249E", queryname="CurDCSF"), @DEDataSetQuery(queryid="0E31F596-B322-4728-94B1-E1BBAEC2C245", queryname="CurDCSF2")})
public abstract class PSSFStyleCurDCSFAllDSModelBase
extends DEDataSetModelBase {
    public PSSFStyleCurDCSFAllDSModelBase() {
        this.initAnnotation(PSSFStyleCurDCSFAllDSModelBase.class);
    }
}

