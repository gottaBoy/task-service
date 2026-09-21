/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdertype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="551C888A-51C0-4F28-9ACD-9069498DE9FB", name="Valid", queries={@DEDataSetQuery(queryid="61A0C72D-4CD6-4FAC-97A3-704164004892", queryname="Valid")})
public abstract class PSDERTypeValidDSModelBase
extends DEDataSetModelBase {
    public PSDERTypeValidDSModelBase() {
        this.initAnnotation(PSDERTypeValidDSModelBase.class);
    }
}

