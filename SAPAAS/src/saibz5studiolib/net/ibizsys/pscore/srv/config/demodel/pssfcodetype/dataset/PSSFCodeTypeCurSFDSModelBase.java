/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssfcodetype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="7D835D51-0F3F-41A7-A280-7F251D3C207C", name="CurSF", queries={@DEDataSetQuery(queryid="FED7AA58-6824-4715-91D1-C11EC424D53E", queryname="CurSF")})
public abstract class PSSFCodeTypeCurSFDSModelBase
extends DEDataSetModelBase {
    public PSSFCodeTypeCurSFDSModelBase() {
        this.initAnnotation(PSSFCodeTypeCurSFDSModelBase.class);
    }
}

