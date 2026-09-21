/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pspfcdn.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="33fb500f531873b069b6b07b5197b327", name="DEFAULT", queries={@DEDataSetQuery(queryid="DB61F44E-AA9E-4477-B823-12E6DAF61CE5", queryname="DEFAULT")})
public abstract class PSPFCDNDefaultDSModelBase
extends DEDataSetModelBase {
    public PSPFCDNDefaultDSModelBase() {
        this.initAnnotation(PSPFCDNDefaultDSModelBase.class);
    }
}

