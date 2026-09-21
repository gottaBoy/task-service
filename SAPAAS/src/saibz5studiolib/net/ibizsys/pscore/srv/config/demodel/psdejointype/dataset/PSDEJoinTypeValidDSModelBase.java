/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdejointype.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="2DFF58F6-54F3-44C7-950B-F2EABA45C0E7", name="Valid", queries={@DEDataSetQuery(queryid="E93904CB-1FFE-470B-95A0-FDB10AA9DB1D", queryname="Valid")})
public abstract class PSDEJoinTypeValidDSModelBase
extends DEDataSetModelBase {
    public PSDEJoinTypeValidDSModelBase() {
        this.initAnnotation(PSDEJoinTypeValidDSModelBase.class);
    }
}

