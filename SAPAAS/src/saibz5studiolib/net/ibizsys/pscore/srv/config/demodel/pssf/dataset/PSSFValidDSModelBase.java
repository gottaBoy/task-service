/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssf.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="4D1F5578-AFDD-468A-B4B1-AC223AADD6E8", name="Valid", queries={@DEDataSetQuery(queryid="4D1F5578-AFDD-468A-B4B1-AC223AADD6E8", queryname="Valid")})
public abstract class PSSFValidDSModelBase
extends DEDataSetModelBase {
    public PSSFValidDSModelBase() {
        this.initAnnotation(PSSFValidDSModelBase.class);
    }
}

