/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfexception.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="977abc4a87cbe3d2846feb4155fc269c", name="DEFAULT", queries={@DEDataSetQuery(queryid="4C2E0140-A3E0-4893-8814-0B23F20837D8", queryname="DEFAULT")})
public abstract class PSSFExceptionDefaultDSModelBase
extends DEDataSetModelBase {
    public PSSFExceptionDefaultDSModelBase() {
        this.initAnnotation(PSSFExceptionDefaultDSModelBase.class);
    }
}

