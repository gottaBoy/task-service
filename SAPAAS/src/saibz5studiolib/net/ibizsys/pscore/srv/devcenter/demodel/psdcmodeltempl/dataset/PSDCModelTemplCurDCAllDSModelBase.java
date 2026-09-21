/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmodeltempl.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="E18984D6-5574-4A33-A8E6-635725D12ABC", name="CurDCAll", queries={@DEDataSetQuery(queryid="076F55DE-DF7D-4FB6-A82F-5DD2D6CBB3FD", queryname="AllDC"), @DEDataSetQuery(queryid="9086CC6A-B625-430F-8F27-5DE67930556E", queryname="CurDC")})
public abstract class PSDCModelTemplCurDCAllDSModelBase
extends DEDataSetModelBase {
    public PSDCModelTemplCurDCAllDSModelBase() {
        this.initAnnotation(PSDCModelTemplCurDCAllDSModelBase.class);
    }
}

