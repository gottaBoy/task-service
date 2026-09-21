/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psmodelexample.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="1ca2af5b90f2eeafd98815d947bbe5dc", name="DEFAULT", queries={@DEDataSetQuery(queryid="478BF383-25EF-4057-99B1-8B476EBE2B85", queryname="DEFAULT")})
public abstract class PSModelExampleDefaultDSModelBase
extends DEDataSetModelBase {
    public PSModelExampleDefaultDSModelBase() {
        this.initAnnotation(PSModelExampleDefaultDSModelBase.class);
    }
}

