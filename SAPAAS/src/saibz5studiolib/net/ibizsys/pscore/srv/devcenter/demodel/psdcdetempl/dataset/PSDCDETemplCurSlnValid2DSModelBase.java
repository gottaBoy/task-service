/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSet
 *  net.ibizsys.paas.core.DEDataSetQuery
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdetempl.dataset;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.demodel.DEDataSetModelBase;

@DEDataSet(id="CD63BB60-31E5-467F-8AFF-3E66DBC87E2C", name="CurSlnValid2", queries={@DEDataSetQuery(queryid="003CAE8E-6186-41B2-9545-A64013D1DABE", queryname="AllDCValid"), @DEDataSetQuery(queryid="CC79020E-0DFD-4AE1-8E4C-6EB0216BB0F1", queryname="CurDCValid"), @DEDataSetQuery(queryid="909D05B6-BFD8-43D2-8454-3CAA4FAFC57A", queryname="CurSlnValid")})
public abstract class PSDCDETemplCurSlnValid2DSModelBase
extends DEDataSetModelBase {
    public PSDCDETemplCurSlnValid2DSModelBase() {
        this.initAnnotation(PSDCDETemplCurSlnValid2DSModelBase.class);
    }
}

