/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssubsys.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="45F536C8-2802-4FF3-8483-8315F127E7E2", name="SFFW", queries={@DEDataSetQuery(queryid="B7C28568-BEBD-4629-A561-C050E0243860", queryname="SFFW")})
public abstract class PSSubSysSFFWDSModelBase
extends DEDataSetModelBase {
    public PSSubSysSFFWDSModelBase() {
        this.initAnnotation(PSSubSysSFFWDSModelBase.class);
    }
}

