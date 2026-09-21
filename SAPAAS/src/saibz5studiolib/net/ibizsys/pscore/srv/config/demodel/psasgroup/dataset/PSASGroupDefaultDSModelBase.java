/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psasgroup.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="b7aef20055f8c4623fdb8f2c376c00df", name="DEFAULT", queries={@DEDataSetQuery(queryid="3F2BB04B-74EA-47E4-ABF6-9B206B4322AF", queryname="DEFAULT")})
public abstract class PSASGroupDefaultDSModelBase
extends DEDataSetModelBase {
    public PSASGroupDefaultDSModelBase() {
        this.initAnnotation(PSASGroupDefaultDSModelBase.class);
    }
}

