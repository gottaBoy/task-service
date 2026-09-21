/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfachandler.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="086b334ff0156ce3b0a23a41cd9f8ce4", name="DEFAULT", queries={@DEDataSetQuery(queryid="B45F8C39-208A-4CCD-A510-A576D4D8FC86", queryname="DEFAULT")})
public abstract class PSSFACHandlerDefaultDSModelBase
extends DEDataSetModelBase {
    public PSSFACHandlerDefaultDSModelBase() {
        this.initAnnotation(PSSFACHandlerDefaultDSModelBase.class);
    }
}

